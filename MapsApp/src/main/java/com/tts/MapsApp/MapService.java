package com.tts.MapsApp;

//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
	@Value("${api_key}")
	private String apiKey;
	
	public void addCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + "," + location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}
	
//	public List<String> randomCoordinates(){
//		 	double minLat = -90.00;
//		    double maxLat = 90.00;      
//		    double latitude = minLat + (double)(Math.random() * ((maxLat - minLat) + 1));
//		    double minLon = 0.00;
//		    double maxLon = 180.00;     
//		    double longitude = minLon + (double)(Math.random() * ((maxLon - minLon) + 1));
//		    DecimalFormat df = new DecimalFormat("#.#####");        
//		    //log.info("latitude:longitude --> " + df.format(latitude) + "," + df.format(longitude));
//		    String randlat = String.valueOf(latitude);
//		    String randlng = String.valueOf(longitude);
////		    List<String> coordinates = new ArrayList<String>();
////		    coordinates.add(randlat);
////		    coordinates.add(randlng);
//		    Location randomLocation = new Location();
//		    randomLocation.setLat(randlat);
//		    randomLocation.setLng(randlng);
//		    return randomLocation;
//		
//	}
	
	
}
