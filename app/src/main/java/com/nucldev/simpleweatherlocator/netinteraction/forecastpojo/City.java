package com.nucldev.simpleweatherlocator.netinteraction.forecastpojo;

import com.google.gson.annotations.SerializedName;


public class City{

	@SerializedName("country")
	private String country;

	@SerializedName("coord")
	private Coord coord;

	@SerializedName("sunrise")
	private long sunrise;

	@SerializedName("timezone")
	private long timezone;

	@SerializedName("sunset")
	private long sunset;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private long id;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}

	public long getSunrise(){
		return sunrise;
	}

	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	public long getTimezone(){
		return timezone;
	}

	public void setSunset(int sunset){
		this.sunset = sunset;
	}

	public long getSunset(){
		return sunset;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"City{" + 
			"country = '" + country + '\'' + 
			",coord = '" + coord + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",sunset = '" + sunset + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}