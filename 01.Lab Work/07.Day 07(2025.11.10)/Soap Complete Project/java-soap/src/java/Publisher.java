package com.example.soap;

import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws/users", new UserService());
        System.out.println("SOAP Service running at http://localhost:8080/ws/users?wsdl");
    }
}
