package com.hack.snippets;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rafthab on 3/23/17.
 */
public class pathVariables {
    public static void main(String[] args) {
        String url = "http://test.com/solarSystem/planet/{planet}/moon/{moon}";

// URI (URL) parameters
        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("planet", "Mars");
        uriParams.put("moon", "Phobos");

// Query parameters

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("firstName", "Mark")
                .queryParam("lastName", "Watney");

        UriComponentsBuilder builder1 = UriComponentsBuilder.fromUriString(url);

        System.out.println(builder.buildAndExpand(uriParams).toUri());
        System.out.println(builder1.buildAndExpand(uriParams).toUri());
    }
}
