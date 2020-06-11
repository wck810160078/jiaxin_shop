package com.jiaxin.shop.security;

import com.alibaba.druid.util.StringUtils;
import com.jiaxin.shop.pojo.JxUser;
import com.jiaxin.shop.pojo.common.PublicConstants;
import com.jiaxin.shop.utils.SpringUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @author hejiazhou
 */

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private UserDetailsService userDetailsService;
    @Resource
    private RedisTemplate redisTemplate;

    private AuthenticationManager authenticationManager;
    public JWTLoginFilter(AuthenticationManager authenticationManager,UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService =  userDetailsService;
        this.redisTemplate = (RedisTemplate) SpringUtil.getBean("redisTemplate");
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
            //表单提交暂时废弃
            String username = req.getParameter("username");
            String password = req.getParameter("password");



            if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
                return null;
            }

        try {


                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                /**
                 * 数据库中没有此token的用户就返回此信息
                 */
                if(userDetails==null){
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter out = null;
                    try {
                        out = res.getWriter();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String s = "{\"code\":\"40000\",\"msg\": \"没有此用户\"}";
                    out.write(s);
                    out.flush();
                    out.close();

                }else {
                    return authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    password,userDetails.getAuthorities())
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
                res.setContentType("application/json;charset=utf-8");
                PrintWriter out = null;
                try {
                    out = res.getWriter();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String s = "{\"code\":\"40000\",\"msg\": \"用户名或密码不正确\"}";
                out.write(s);
                out.flush();
                out.close();
            }
        return null;
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String username = ((JxUser) auth.getPrincipal()).getUsername();
        //从redis获取 有则不生成直接使用 并且刷新有效时间
        Object o = redisTemplate.opsForValue().get(PublicConstants.USERTOKEN + username);
        if(o!=null){
            redisTemplate.expire(PublicConstants.USERTOKEN+username,120,TimeUnit.MINUTES);
            returnResult(res, username,o.toString());
        }else{
            String token = Jwts.builder()
                    .setSubject(username)
                    .signWith(SignatureAlgorithm.HS512, "jiaxin".getBytes())
                    .compact();

            returnResult(res, username,token);
        }
    }

    /**
     * 返回结果
     * @param res
     * @param username 用户名
     * @param token token
     */
    private void returnResult(HttpServletResponse res, String username, String token) throws IOException {
        //存入redis
        setRedis(username, token);
        res.addHeader("Authorization",token);
        res.setContentType("application/json;charset=utf-8");
        PrintWriter out = res.getWriter();
        String s = "{\"code\":\"10000\",\"msg\": \"登录成功\",\"Authorization\":\""+token+"\"}";
        out.write(s);
        out.flush();
        out.close();
    }

    /**
     * 将结果存入redis 设置过期时间
     * @param username
     * @param token
     */
    private void setRedis(String username, String token) {
        redisTemplate.opsForValue().set(PublicConstants.USERTOKEN+username,token);
        redisTemplate.expire(PublicConstants.USERTOKEN+username,120,TimeUnit.MINUTES);
    }


    /**
     * 处理登录失败
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String s = "{\"code\":\"40000\",\"msg\": \"用户名或密码不正确}\"";
        out.write(s);
        out.flush();
        out.close();
    }


}