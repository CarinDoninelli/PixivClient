package com.carin.doninelli.pixiv;

import com.carin.doninelli.pixiv.client.PixivClient;
import com.carin.doninelli.pixiv.client.PixivClientFactory;
import com.carin.doninelli.pixiv.client.entities.Credentials;

public final class Main {
    public static void main(String[] args) {
        PixivClientFactory pixivClientFactory = new PixivClientFactory();
        Credentials credentials = new Credentials("efherrera.175@gmail.com", "chicho123");
        PixivClient pixivClient = pixivClientFactory.createPixivClient(credentials);

    }
}
