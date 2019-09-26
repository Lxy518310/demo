package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.AccessTokenDTO;
import com.bootdemo.lmy.demo.dto.GithubUser;
import com.bootdemo.lmy.demo.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id(id);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(uri);
        String accessToken= gitHubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=gitHubProvider.getGithubUser(accessToken);
        System.out.println(githubUser.toString());
        return "index";
    }
}
