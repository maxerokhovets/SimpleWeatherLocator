package com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo;


import com.google.gson.annotations.SerializedName;


public class Sys{

	@SerializedName("country")
	private String country;

	@SerializedName("sunrise")
	private long sunrise;

	@SerializedName("sunset")
	private long sunset;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}

	public long getSunrise(){
		return sunrise;
	}

	public void setSunset(int sunset){
		this.sunset = sunset;
	}

	public long getSunset(){
		return sunset;
	}

	@Override
 	public String toString(){
		return 
			"Sys{" + 
			"country = '" + country + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",sunset = '" + sunset + '\'' + 
			"}";
		}
}