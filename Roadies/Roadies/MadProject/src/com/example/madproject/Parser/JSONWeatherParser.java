 package com.example.madproject.Parser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.madproject.weather.model.DayForecast;
import com.example.madproject.weather.model.Location;
import com.example.madproject.weather.model.Weather;
import com.example.madproject.weather.model.WeatherForecast;


public class JSONWeatherParser {

	public static Weather getWeather(String data) throws JSONException  {
		 Weather weather = new Weather();
		System.out.println("Data ["+data+"]");
		// We create out JSONObject from the data
		JSONObject jObj = new JSONObject(data);
		
		// We start extracting the info
		Location loc = new Location();
		
		JSONObject coordObj = getObject("coord", jObj);
		loc.setLatitude(getFloat("lat", coordObj));
		loc.setLongitude(getFloat("lon", coordObj));
		
		JSONObject sysObj = getObject("sys", jObj);
		loc.setCountry(getString("country", sysObj));
		loc.setSunrise(getInt("sunrise", sysObj));
		loc.setSunset(getInt("sunset", sysObj));
		loc.setCity(getString("name", jObj));
		weather.location = loc;
		
		// We get weather info (This is an array)
		JSONArray jArr = jObj.getJSONArray("weather");
		
		// We use only the first value
		JSONObject JSONWeather = jArr.getJSONObject(0);
		weather.currentCondition.setWeatherId(getInt("id", JSONWeather));
		weather.currentCondition.setDescr(getString("description", JSONWeather));
		weather.currentCondition.setCondition(getString("main", JSONWeather));
		weather.currentCondition.setIcon(getString("icon", JSONWeather));
		
		JSONObject mainObj = getObject("main", jObj);
		weather.currentCondition.setHumidity(getInt("humidity", mainObj));
		weather.currentCondition.setPressure(getInt("pressure", mainObj));
		weather.temperature.setMaxTemp(getFloat("temp_max", mainObj));
		weather.temperature.setMinTemp(getFloat("temp_min", mainObj));
		weather.temperature.setTemp(getFloat("temp", mainObj));
		
		// Wind
		JSONObject wObj = getObject("wind", jObj);
		weather.wind.setSpeed(getFloat("speed", wObj));
		weather.wind.setDeg(getFloat("deg", wObj));
		
		// Clouds
		JSONObject cObj = getObject("clouds", jObj);
		weather.clouds.setPerc(getInt("all", cObj));
		
		// We download the icon to show
		
		
		return weather;
	}
	
	public static WeatherForecast getForecastWeather(String data) throws JSONException  {
		
		WeatherForecast forecast = new WeatherForecast();
		
		// We create out JSONObject from the data
		JSONObject jObj = new JSONObject(data);

		JSONArray jArr = jObj.getJSONArray("list"); // Here we have the forecast for every day
		
		// We traverse all the array and parse the data
		for (int i=0; i < jArr.length(); i++) {
			JSONObject jDayForecast = jArr.getJSONObject(i);
			
			// Now we have the json object so we can extract the data
			DayForecast df = new DayForecast();
			
			// We retrieve the timestamp (dt)
			df.timestamp = jDayForecast.getLong("dt");
			
			// Temp is an object
			JSONObject jTempObj = jDayForecast.getJSONObject("temp");
			
			df.forecastTemp.day = (float) jTempObj.getDouble("day");
			df.forecastTemp.min = (float) jTempObj.getDouble("min");
			df.forecastTemp.max = (float) jTempObj.getDouble("max");
			df.forecastTemp.night = (float) jTempObj.getDouble("night");
			df.forecastTemp.eve = (float) jTempObj.getDouble("eve");
			df.forecastTemp.morning = (float) jTempObj.getDouble("morn");
			
			// Pressure & Humidity
			df.weather.currentCondition.setPressure((float) jDayForecast.getDouble("pressure"));
			df.weather.currentCondition.setHumidity((float) jDayForecast.getDouble("humidity"));
			
			// ...and now the weather
			JSONArray jWeatherArr = jDayForecast.getJSONArray("weather");
			JSONObject jWeatherObj = jWeatherArr.getJSONObject(0);
			df.weather.currentCondition.setWeatherId(getInt("id", jWeatherObj));
			df.weather.currentCondition.setDescr(getString("description", jWeatherObj));
			df.weather.currentCondition.setCondition(getString("main", jWeatherObj));
			df.weather.currentCondition.setIcon(getString("icon", jWeatherObj));

			forecast.addForecast(df);
		}
		

		
		return forecast;
	}	
	
	
	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
		JSONObject subObj = jObj.getJSONObject(tagName);
		return subObj;
	}
	
	private static String getString(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getString(tagName);
	}

	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
		return (float) jObj.getDouble(tagName);
	}
	
	private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getInt(tagName);
	}
	
}
