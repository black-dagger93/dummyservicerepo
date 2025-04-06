package com.example.alpha.config;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class CustomFeignConfig {

    @Bean
    public Client feignClient() throws NoSuchAlgorithmException, KeyManagementException {
        // Create a TrustManager that accepts all certificates
        TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
        };

        // Set up SSL context with the "trust-all" TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

        // Set the default SSLSocketFactory to use the custom SSL context
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

        // Optionally, you can set a hostname verifier that accepts all hostnames
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

        return new Client.Default(null, null);  // Use the default Feign client
    }
}

