package com.hack.snippets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by rafthab on 3/30/17.
 */
public class Makealoginrequest {

    protected HttpEntity<MultiValueMap<String, Object>> generateMAMLoginRequest(String uname, String password) {
        final MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("username",uname);
        map.add("password",password);
        final HttpHeaders headers = getHttpHeadersWithAuth(uname, password);
        List<MediaType> ml = new ArrayList<>();
        ml.add(MediaType.ALL);
        headers.setAccept(ml);
        headers.setContentType((MediaType.MULTIPART_FORM_DATA));
        final HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        return request;

    }

    protected HttpHeaders getHttpHeadersWithAuth(final String userName, final String password) {

        final String plainCreds = userName + ":" + password;
        final byte[] plainCredsBytes = plainCreds.getBytes();
        final byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
        final String base64Creds = new String(base64CredsBytes);

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        return headers;
    }

    protected Map<String, String> parseURL(String uri) throws MalformedURLException, UnsupportedEncodingException {

        URL url;
        url = new URL(uri);

        Map<String, String> query_pairs = new LinkedHashMap<>();
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }

    @Test
    public void testLogin() throws MalformedURLException, UnsupportedEncodingException {
        String url = "http://test.com/solarSystem/planet/{planet}/moon/{moon}";
        url = new String("http://localhost:8080/polaris/mamonlylogin.html");
        String serverurl = "http://localhost:8080";
        Makealoginrequest makealoginrequest = new Makealoginrequest();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String, Object>> loginRequest = makealoginrequest.generateMAMLoginRequest("kishore.K34604177040618713099@mobileiron.com", "Mi4man11");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, loginRequest, String.class);
        Assert.assertEquals(response.getStatusCode().value(), 302);
        Assert.assertNotNull(response.getHeaders().get("Location"), "Theres is not access code as part of MAM Login Response");
        String location = response.getHeaders().get("Location").get(0);
        parseURL(serverurl + location);
    }


}
