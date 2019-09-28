package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.AccessTokenDTO;
import com.bootdemo.lmy.demo.dto.GithubUser;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.provider.GitHubProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id(id);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(uri);
        String accessToken= gitHubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=gitHubProvider.getGithubUser(accessToken);
        if(githubUser!=null){
//            User user = new User();
//            user.setToken(UUID.randomUUID().toString());
//            user.setAccountId(String.valueOf(githubUser.getId()));
//            user.setName(githubUser.getName());
//            user.setGmtCreate(System.currentTimeMillis());
//            user.setGmtModified(user.getGmtCreate());
            String id=String.valueOf(githubUser.getId());
//            userMapper.addUser(user);
            User user =userMapper.getUser(id);
            System.out.println(user.toString());
            request.getSession().setAttribute("User",githubUser);
            return "redirect:index";
        }else{
            return "redirect:index";
        }
    }
}
