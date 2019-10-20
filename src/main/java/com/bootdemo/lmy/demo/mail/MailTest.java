package com.bootdemo.lmy.demo.mail;

import java.util.ArrayList;

/**
 * @author 李
 * @create 2019/10/20 22:04
 */
public class MailTest {
    public static void main(String[] args) throws Exception {
        new MailSender().title("Hi 男神 这是送给你的一首小情歌")
                .content("这是一首简单的小情歌，唱着人们心肠的曲折\n" +
                        "\n" +
                        "我想我很快乐，当有你的温热\n" +
                        "\n" +
                        "脚边的空气转了，这是一首简单的小情歌\n" +
                        "\n" +
                        "唱着我们心头的白鸽，我想我很适合\n" +
                        "\n" +
                        "当一个歌颂者，青春在风中飘着\n" +
                        "\n" +
                        "你知道，就算大雨让这座城市颠倒\n" +
                        "\n" +
                        "我会给你怀抱，受不了看见你背影来到\n" +
                        "\n" +
                        "写下我度秒如年难捱的离骚，就算整个世界被寂寞绑票\n" +
                        "\n" +
                        "我也不会奔跑，逃不了最后谁也都苍老\n" +
                        "\n" +
                        "写下我时间和琴声交错的城堡，这是一首简单的小情歌\n" +
                        "\n" +
                        "唱着我们心头的白鸽，我想我很适合\n" +
                        "\n" +
                        "当一个歌颂者，青春在风中飘着\n" +
                        "\n" +
                        "你知道，就算大雨让这座城市颠倒\n" +
                        "\n" +
                        "我会给你怀抱，受不了看见你背影来到\n" +
                        "\n" +
                        "写下我度秒如年难捱的离骚，就算整个世界被寂寞绑票\n" +
                        "\n" +
                        "我也不会奔跑，逃不了最后谁也都苍老\n" +
                        "\n" +
                        "写下我时间和琴声交错的城堡，你知道\n" +
                        "\n" +
                        "就算大雨让这座城市颠倒，我会给你怀抱\n" +
                        "\n" +
                        "受不了看见你背影来到，写下我度秒如年难捱的离骚\n" +
                        "\n" +
                        "就算整个世界被寂寞绑票，我也不会奔跑\n" +
                        "\n" +
                        "最后谁也都苍老，写下我时间和琴声交错的城堡")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{add("1012736164@qq.com");}})
                .send();
    }
}
