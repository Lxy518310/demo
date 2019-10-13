package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.AccessTokenDTO;
import com.bootdemo.lmy.demo.dto.GithubUser;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.provider.GitHubProvider;
import com.bootdemo.lmy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 李
 * @create 2019/9/25 23:18
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String id;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String uri;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request, HttpServletResponse response){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id(id);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(uri);
        String accessToken= gitHubProvider.getAccessToken(accessTokenDTO);
        User user =new User();
        GithubUser githubUser=gitHubProvider.getGithubUser(accessToken);
        if(githubUser!=null){
            user.setToken(UUID.randomUUID().toString());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setAvatarUrl(githubUser.getAvatar_url());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token",user.getToken()));
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
