package com.nucldev.simpleweatherlocator.ui.main.utils;

public class AzimuthToSideOfTheWorldConverter {
    private int mAzimuth;

    public AzimuthToSideOfTheWorldConverter(int mAzimuth) {
        this.mAzimuth = mAzimuth;
    }

    public String getSideOfTheWorld(){
        SidesOfTheWorld sidesOfTheWorld = null;
        if(this.mAzimuth>0 & this.mAzimuth<11.25)
            sidesOfTheWorld = SidesOfTheWorld.N;
        if(this.mAzimuth>348.75&this.mAzimuth<360)
            sidesOfTheWorld = SidesOfTheWorld.N;
        if(this.mAzimuth>11.25&this.mAzimuth<33.75)
            sidesOfTheWorld = SidesOfTheWorld.NNE;
        if(this.mAzimuth>33.75&this.mAzimuth<56.25)
            sidesOfTheWorld = SidesOfTheWorld.NE;
        if(this.mAzimuth>56.25&this.mAzimuth<78.75)
            sidesOfTheWorld = SidesOfTheWorld.ENE;
        if (this.mAzimuth>78.75&this.mAzimuth<101.25)
            sidesOfTheWorld = SidesOfTheWorld.E;
        if (this.mAzimuth>101.25&this.mAzimuth<123.75)
            sidesOfTheWorld = SidesOfTheWorld.ESE;
        if (this.mAzimuth>123.75&this.mAzimuth<146.25)
            sidesOfTheWorld = SidesOfTheWorld.SE;
        if (this.mAzimuth>146.25&this.mAzimuth<168.75)
            sidesOfTheWorld = SidesOfTheWorld.SSE;
        if (this.mAzimuth>168.75&this.mAzimuth<191.25)
            sidesOfTheWorld = SidesOfTheWorld.S;
        if (this.mAzimuth>191.25&this.mAzimuth<213.75)
            sidesOfTheWorld = SidesOfTheWorld.SSW;
        if (this.mAzimuth>213.75&this.mAzimuth<236.25)
            sidesOfTheWorld = SidesOfTheWorld.SW;
        if (this.mAzimuth>236.25&this.mAzimuth<258.75)
            sidesOfTheWorld = SidesOfTheWorld.WSW;
        if (this.mAzimuth>258.75&this.mAzimuth<281.25)
            sidesOfTheWorld = SidesOfTheWorld.W;
        if (this.mAzimuth>281.5&this.mAzimuth<303.75)
            sidesOfTheWorld = SidesOfTheWorld.WNW;
        if (this.mAzimuth>303.75&this.mAzimuth<326.25)
            sidesOfTheWorld = SidesOfTheWorld.NW;
        if (this.mAzimuth>326.25&this.mAzimuth<348.75)
            sidesOfTheWorld = SidesOfTheWorld.NNW;
        return    sidesOfTheWorld.toString();
    }
}


