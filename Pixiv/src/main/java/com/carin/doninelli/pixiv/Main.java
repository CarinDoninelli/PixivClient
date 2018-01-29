package com.carin.doninelli.pixiv;

import com.carin.doninelli.pixiv.client.PixivClient;
import com.carin.doninelli.pixiv.client.PixivClientFactory;
import com.carin.doninelli.pixiv.client.entities.Credentials;
import com.carin.doninelli.pixiv.client.entities.PasswordCredentials;
import com.carin.doninelli.pixiv.client.entities.UserProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

public final class Main {
    public static void main(String[] args) throws JsonProcessingException {
        PixivClientFactory pixivClientFactory = new PixivClientFactory();
        Credentials credentials = new PasswordCredentials("email", "password");
        PixivClient pixivClient = pixivClientFactory.createPixivClient(credentials);

        UserProfile user = pixivClient.getUserInfo(4570006).join();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new KotlinModule());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }
}
