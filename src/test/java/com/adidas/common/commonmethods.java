package com.adidas.common;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class commonmethods {
	
	//this method return all weather data by cityname as a parameter
	public static Response getWeatherByCityName(String baseurl,String path) 
	{
		RestAssured.baseURI = baseurl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,path);
		return response;
	}
	//this method return all weather data by cityid as a parameter
	public static Response getWeatherByCityId(String baseurl,String path) 
	{
		RestAssured.baseURI = baseurl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,path);
		return response;
	}
	//this method return all weather data by cityzipcode as a parameter
	public static Response getWeatherByCityZipcode(String baseurl,String path) 
	{
		RestAssured.baseURI = baseurl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,path);
		return response;
	}
	//this method return all weather data by multiplecityIDs as a parameter
	public static Response getWeatherByMultiplecityIDs(String baseurl,String path) 
	{
		RestAssured.baseURI = baseurl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,path);
		return response;
	}
}
