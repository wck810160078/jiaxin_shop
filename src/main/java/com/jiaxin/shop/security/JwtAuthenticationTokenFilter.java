package com.jiaxin.shop.security;

import com.jiaxin.shop.exception.LoginHasExpired;
import com.jiaxin.shop.pojo.common.PublicConstants;
import com.jiaxin.shop.utils.SpringUtil;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {
    private RedisTemplate redisTemplate;
    private UserDetailsService userDetailsService;


    public JwtAuthenticationTokenFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
        this.redisTemplate = (RedisTemplate) SpringUtil.getBean("redisTemplate");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("AuthToken");

        try {
            if(token==null){
                chain.doFilter(request,response);
                return;
            }

            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            chain.doFilter(request,response);

        }catch (LoginHasExpired e){
            loginHasExpired(response);
        }catch (JwtException n){
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e1) {

            }
            String s = "{\"code\":\"40000\",\"msg\": \"授权信息有误!\"}";
            out.write(s);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            //系统全局拦截
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String s = "{\"code\":\"45000\",\"msg\": \"系统错误,建议稍后再试!\"}";
            out.write(s);
            out.flush();
            out.close();
        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) throws LoginHasExpired {
        if(token!=null){
            String user = Jwts.parser()
                    .setSigningKey("jiaxin".getBytes())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            Object o = redisTemplate.opsForValue().get(PublicConstants.USERTOKEN+user);
            if(o==null){
                throw new LoginHasExpired();
            }else{
                redisTemplate.expire(PublicConstants.USERTOKEN,120, TimeUnit.MINUTES);
            }

            if(user!=null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(user);
                return new UsernamePasswordAuthenticationToken(user,null,userDetails.getAuthorities());
            }
            return null;
        }
        return null;
    }

    private void loginHasExpired(HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e1) {

        }
        String s = "{\"code\":\"44001\",\"msg\": \"登录已失效,请重新登录!\"}";
        out.write(s);
        out.flush();
        out.close();
    }
}
