/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author mluukkai
 * @ohtustudent jani-e
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url)
                .execute()
                .returnContent()
                .asString();
        
        //System.out.println("json-muotoinen data:");
        //System.out.println(bodyText);
        
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        List<Player> playersList = Arrays.asList(players);
        
        List<Player> filteredList = playersList.stream()
                .filter(nat -> nat.getNationality().equals("FIN"))
                .collect(Collectors.toList());
        
        //System.out.println("Oliot:");
        
        Date date = new Date();
        System.out.println("Players from FIN " + date.toString() + "\n");
        
        for (Player player : filteredList) {
            System.out.println(player);
        }
    }
    
}
