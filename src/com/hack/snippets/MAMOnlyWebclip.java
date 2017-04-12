package com.hack.snippets;



        import java.io.UnsupportedEncodingException;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLDecoder;
        import java.util.Base64;
        import java.util.LinkedHashMap;
        import java.util.Map;

        import org.springframework.http.HttpEntity;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpMethod;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.client.RestTemplate;
        import org.testng.annotations.Test;


public class MAMOnlyWebclip {

    String mamToken;
    String whiteLabel;
    final String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";
    final String url = "http://localhost:8080";


    public MAMOnlyWebclip() {

    }
    public MAMOnlyWebclip(final Map<String, String> queryPairs) throws MalformedURLException, UnsupportedEncodingException {
        this.mamToken = queryPairs.get("mamtoken");
        this.whiteLabel = queryPairs.get("whiteLabelKey");
    }


    public  Map<String, String> parseURL(final String uri) throws MalformedURLException, UnsupportedEncodingException {

        final URL url1 = new URL(uri);
        final Map<String, String> queryPairs = new LinkedHashMap<>();
        final String query = url1.getQuery();
        final String[] pairs = query.split("&");
        for (String pair : pairs) {
            final int idx = pair.indexOf("=");
            queryPairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return queryPairs;
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

    // Get categories

    public ResponseEntity<String> getCategoriesList() {
        String uri = "http://localhost:8080/polaris/c/api/v1/appstore/categories/15000?mamtoken=7F7F00009C4AAFBE0001000600108967FDFA489E6602F346F46C09049D5FBEAFD1F43561251704FCAF2333975FF8B7993296D75F3144991ACC42455B74DF9B21940614E296CED6789B7FF76A1E2E9E6E210B295A725FE81291611625D7B35E3BE168192A7944FC90AF4E17521550E13BA9992312551B66DF46A6E5EA1588F5053A28BD2A126AD89616C1ECF72EDA14CFC43C66350F3E67F8469C85999C8BAA918CA246307655A36746D055353F29B5BAF72811AD9B2F23C7&whiteLabelKey=mobileiron&dataUri=false&rows=15&containsQuery=true&page=1&start=0&rows=15";
        final HttpHeaders headers = getHttpHeadersWithAuth("kishore.K34604177040618713099@mobileiron.com", "Mi4man11");
        headers.add("user-agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<String> request = new HttpEntity<>(headers);
        final ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        return response;
    }
    //Get apps by categories
    // Get app details
    // Get featured apps

    @Test
    public void getCategoriesListTest() throws MalformedURLException, UnsupportedEncodingException {
        String loginHeader = "/polaris/appstore/webappstore.html?mamtoken=7F7F00009C4AAFBE000100060010AF8D9C233621EA9C7A7D580251C7CB6EBEAF19303E96E8E6B24A4CA7A568E73886E0A56C33EE804B833ADFD79ACA7B9DBB9E619F627768C1AEAE55C5A1CFFE52C2487FEC80C59A6BAB300A04351229311DCC8C3DAFC841CFF969EAF580ADAE47031FC460EFEABAC26121FE6A3FF8DDCC07CC07D01C5C78196577E8A2E2BD390F7A9FF5A3C2516DD95DA26C9817E8BCA085B4F18ECBBA3C2AAFA4AD41D88A8E9247563BC641703855FDE0&whiteLabelKey=mobileiron";
        final Map<String, String> queryPairs = parseURL(this.url + loginHeader);
        MAMOnlyWebclip webclip = new MAMOnlyWebclip(queryPairs);
        webclip.getCategoriesList();
    }

}
