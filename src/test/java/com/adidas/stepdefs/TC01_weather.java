package com.adidas.stepdefs;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import com.adidas.common.commonmethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC01_weather {
	private Logger logger = Logger.getLogger(TC01_weather.class);
	Response response;
	JSONObject weather_data;
	@Given("^Get Weather data$")
    public void get_weather_data() throws IOException 
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\adidas\\data\\weatherdata.json");
	    String content = FileUtils.readFileToString(file, "utf-8");
	    
	    //convert JSON string to JSONObject
	    JSONObject Obj = new JSONObject(content);
	    weather_data = (JSONObject) Obj.get("weather_data");
	    logger.info("weather data = "+weather_data);
    }
	@When("^Get Weather by city name$")
    public void get_weather_by_cityname() throws IOException 
	{
		response =commonmethods.getWeatherByCityName(weather_data.get("baseurl").toString(),weather_data.get("path").toString()+"?q="+weather_data.get("city").toString()+"&appid="+weather_data.get("apikey").toString());
		logger.info("city pass to api = "+weather_data.get("city").toString());
	}
	@Then("^Verify Weather by city name response$")
    public void verify_weather_by_cityname() throws IOException 
	{
		//verify response status code
		logger.info("status code = "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		//print response body
		logger.info(response.getBody().asString());
		logger.info("tempreture = "+response.path("main.temp"));
	}
	@When("^Get Weather by city ID$")
    public void get_weather_by_cityID() throws IOException 
	{
		response =commonmethods.getWeatherByCityId(weather_data.get("baseurl").toString(),weather_data.get("path").toString()+"?id="+weather_data.get("cityid").toString()+"&appid="+weather_data.get("apikey").toString());
		logger.info("cityid pass to api = "+weather_data.get("cityid").toString());
	}
	@Then("^Verify Weather by city ID response$")
    public void verify_weather_by_cityID() throws IOException 
	{
		//verify response status code
		logger.info("status code = "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		//print response body
		logger.info(response.getBody().asString());
		logger.info("tempreture = "+response.path("main.temp"));
	}
	@When("^Get Weather by city ZipCode$")
    public void get_weather_by_cityZipCode() throws IOException 
	{
		response =commonmethods.getWeatherByCityZipcode(weather_data.get("baseurl").toString(),weather_data.get("path").toString()+"?zip="+weather_data.get("cityzip").toString()+"&appid="+weather_data.get("apikey").toString());
		logger.info("cityzip pass to api = "+weather_data.get("cityzip").toString());
	}
	@Then("^Verify Weather by city ZipCode response$")
    public void verify_weather_by_cityZipCode() throws IOException 
	{
		//verify response status code
		logger.info("status code = "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		//print response body
		logger.info(response.getBody().asString());
		logger.info("tempreture = "+response.path("main.temp"));
	}
	@When("^Get Weather by multiplecityIDs$")
    public void get_weather_by_multiplecityids() throws IOException 
	{
		response =commonmethods.getWeatherByMultiplecityIDs(weather_data.get("baseurl").toString(),weather_data.get("grouppath").toString()+"?id="+weather_data.get("multiplecityIDs").toString()+"&appid="+weather_data.get("apikey").toString());
		logger.info("MultiplecityIDs pass to api = "+weather_data.get("multiplecityIDs").toString());
	}
	@Then("^Verify Weather by multiplecityIDs response$")
    public void verify_weather_by_multiplecityIDs() throws IOException 
	{
		//verify response status code
		logger.info("status code = "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		//print response body
		logger.info(response.getBody().asString());
		logger.info("tempreture = "+response.path("main.temp"));
	}
}