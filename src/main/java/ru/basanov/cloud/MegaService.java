package ru.basanov.cloud;

import javax.enterprise.context.ApplicationScoped;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Date;

@WebService
@ApplicationScoped
public class MegaService {

    @WebMethod
    public Date getDate() {
        return new Date();
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/MegaService", new MegaService());
    }
}
