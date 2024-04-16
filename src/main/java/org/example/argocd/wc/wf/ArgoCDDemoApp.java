package org.example.argocd.wc.wf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ArgoCDDemoApp
{

    public static void main(String[] args)
    {
        SpringApplication.run(ArgoCDDemoApp.class, args);
    }


    @Controller
    public static class HomeController
    {

        @Value("${env:Default}")
        protected String environment;

        @GetMapping("/")
        public ResponseEntity<String> homepage()
        {
            return ResponseEntity.ok("<html><body>Hello from " + environment + "</br>Served from: " + getHostName() + "</body></html>");
        }

        public String getHostName() {
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                return localHost.getHostName();
            } catch (UnknownHostException e) {
                // Handle exception (e.g., log error)
                e.printStackTrace();
                return null;
            }
        }
    }


}
