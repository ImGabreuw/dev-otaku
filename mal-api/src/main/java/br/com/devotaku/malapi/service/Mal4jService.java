package br.com.devotaku.malapi.service;

import com.kttdevelopment.mal4j.MyAnimeList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Mal4jService {

    @Value("${MAL_CLIENT_ID}")
    private String clientId;

    public MyAnimeList getApiInstance() {
        return MyAnimeList.withClientID(clientId);
    }

}
