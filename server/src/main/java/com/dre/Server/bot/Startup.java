package com.dre.Server.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Startup {
    private static Startup instance;

    public static Startup getInstance(){
        if (instance == null){
            instance = new Startup();
        }
        return instance;
    }

    public void intialize(){
        JDA jda = JDABuilder.createDefault("").build();
    }
    public void test(){
        System.out.println("Testing worked");
    }
}
