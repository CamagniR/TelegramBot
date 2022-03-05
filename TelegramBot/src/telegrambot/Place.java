/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

/**
 *
 * @author Riccardo
 */
public class Place {
    
    //attributi
    private String display_name;
    //elementi
    private String amenity;
    private String road;
    private String town;
    private String county;
    private String state;
    private String postcode;
    private String country;
    private String country_code;
    private String building;
    private String house_number;
    private String village;
    
    public Place() {
        
        display_name="";
        
        amenity = "";
        road = "";
        town = "";
        county = "";
        state = "";
        postcode = "";
        country = "";
        country_code = "";
        building = "";
        house_number = "";
        village="";
    }

    public Place(String display_name,String amenity, String road, String town, String county, String state, String postcode, String country, String country_code, String building, String house_number,String village) {
        this.display_name=display_name;
        this.amenity = amenity;
        this.road = road;
        this.town = town;
        this.county = county;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.country_code = country_code;
        this.building = building;
        this.house_number = house_number;
        this.village=village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getVillage() {
        return village;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }
    
    public String getAmenity() {
        return amenity;
    }

    public String getRoad() {
        return road;
    }

    public String getTown() {
        return town;
    }

    public String getCounty() {
        return county;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getBuilding() {
        return building;
    }

    public String getHouse_number() {
        return house_number;
    }
    
    
 
    
}

