/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Srb;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author sourabhsoni
 */
public class ApiReq {
    public static double price;
    public static double past_price;
   
 public static void currentPrice(String id){
        try{
    String token = id;
    URL url = new URL("https://api.coingecko.com/api/v3/simple/price?ids="+token+"&vs_currencies=inr");
   
    
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();
    //connection check
    int responsecode = conn.getResponseCode();
    //200 conection made
    if(responsecode != 200){
        throw new RuntimeException ("Response code : "+responsecode);
    }
    else{
        StringBuilder Info = new StringBuilder();
        Scanner scan = new Scanner(url.openStream());
        while(scan.hasNext()){
        Info.append(scan.nextLine());
        }
        scan.close();
        // parsing Json String "Info"
        JSONParser parser = new JSONParser();
         Object obj = parser.parse(String.valueOf(Info));
           // typecasting obj to JSONObject
        JSONObject jsonObject = (JSONObject) obj;
     JSONObject json1 = (JSONObject) jsonObject.get(token);
     price = (double)json1.get("inr");
     
    }
    
}catch(Exception ex){
    System.out.print("error :"+ ex);
}
        }
    
    public static void past_price(String id,String date)
    {
        try{
    URL url = new URL("https://api.coingecko.com/api/v3/coins/"+id+"/history?date="+date);
   
    
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();
    //connection check
    int responsecode = conn.getResponseCode();
    //200 conection made
    if(responsecode != 200){
        throw new RuntimeException ("Response code : "+responsecode);
    }
    else{
        StringBuilder Info = new StringBuilder();
        Scanner scan = new Scanner(url.openStream());
        while(scan.hasNext()){
        Info.append(scan.nextLine());
        }
        scan.close();
        
        // parsing Json String "Info"
        JSONParser parser = new JSONParser();
         Object obj = parser.parse(String.valueOf(Info));
         JSONObject jsonObbject = (JSONObject) obj;
           // typecasting obj to JSONObject
    
    JSONObject son = (JSONObject)jsonObbject.get("market_data");
     JSONObject so2n = (JSONObject)son.get("current_price");
    past_price = (double) so2n.get("inr");  
     
    }
    
}catch(Exception ex){
    System.out.print("error :"+ ex);
    }
    }
    
}



