package com.nucldev.simpleweatherlocator.netinteraction.forecastpojo;


import com.google.gson.annotations.SerializedName;


public class Main{

	@SerializedName("temp")
	private double temp;

	@SerializedName("temp_min")
	private double tempMin;

	@SerializedName("grnd_level")
	private double grndLevel;

	@SerializedName("temp_kf")
	private double tempKf;

	@SerializedName("humidity")
	private double humidity;

	@SerializedName("pressure")
	private double pressure;

	@SerializedName("sea_level")
	private double seaLevel;

	@SerializedName("feels_like")
	private double feelsLike;

	@SerializedName("temp_max")
	private double tempMax;

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	public void setTempMin(double tempMin){
		this.tempMin = tempMin;
	}

	public double getTempMin(){
		return tempMin;
	}

	public void setGrndLevel(int grndLevel){
		this.grndLevel = grndLevel;
	}

	public double getGrndLevel(){
		return grndLevel;
	}

	public void setTempKf(int tempKf){
		this.tempKf = tempKf;
	}

	public double getTempKf(){
		return tempKf;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public double getHumidity(){
		return humidity;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public double getPressure(){
		return pressure;
	}

	public void setSeaLevel(int seaLevel){
		this.seaLevel = seaLevel;
	}

	public double getSeaLevel(){
		return seaLevel;
	}

	public void setFeelsLike(double feelsLike){
		this.feelsLike = feelsLike;
	}

	public double getFeelsLike(){
		return feelsLike;
	}

	public void setTempMax(double tempMax){
		this.tempMax = tempMax;
	}

	public double getTempMax(){
		return tempMax;
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",grnd_level = '" + grndLevel + '\'' + 
			",temp_kf = '" + tempKf + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",sea_level = '" + seaLevel + '\'' + 
			",feels_like = '" + feelsLike + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}
}