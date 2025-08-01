package dev.java10x.MagicFridgeAI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


    // Variável para guardar a url da api da openai
    @Value("${chatgpt.api.url:https://api.openai.com/v1/chat/completions}")
    private String chatGptApiUrl;

    // WebClient vai ajudar a conectar com a Web usando a url do chat gpt e integrando (build) com a chave da API
    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl(chatGptApiUrl);
    }


}
