package com.bootdemo.lmy.demo.provider;

import com.alibaba.fastjson.JSON;
import com.bootdemo.lmy.demo.dto.AccessTokenDTO;
import com.bootdemo.lmy.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * @author 李
 * 用于实现GitHub登录,使用OkHttp和fastJson来完成与github的交互
 * * @create 2019/9/25 23:27
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string=response.body().string();
                string=string.split("=")[1].split("&")[0];
                return string;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
    public GithubUser getGithubUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string =response.body().string();
                GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
                return githubUser;
            }catch(Exception e){

            }
        return null;
    }
}
