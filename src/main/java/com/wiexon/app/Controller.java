package com.wiexon.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class Controller {


    @FXML
    void getRequest(ActionEvent event) {
        System.out.println("working get request!");

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:505/mrmate/read/em1/1/3/2/4");

        String res = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {

            JsonNode node = mapper.readTree(res);
            System.out.println(node.get(0).get("value"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
