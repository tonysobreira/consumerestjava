package project.bean;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import project.model.Cliente;
import project.model.User;

@Service
public class JsonApi {
	
	public static String getJson() {
		String apiUrl = "https://cliente-rest-api.herokuapp.com/cliente";
		
		String json = "";

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			conn.connect();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode());
			} else {
				Scanner sc = new Scanner(url.openStream(), "utf-8");
				
				while (sc.hasNext()) {
					json += sc.nextLine();
				}
				
				sc.close();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
    	List<Cliente> list = gson.fromJson(json, listType);

		return json;
	}
	
	public static List<Cliente> getClienteList(String json) {
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
    	List<Cliente> list = gson.fromJson(json, listType);

		return list;
	}

}
