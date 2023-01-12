package com.thelaters.cs102project.crowdleyv20;
/*
  This class represents cafes which are places with specific properties
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 10.04.17
 */
public class Cafe extends MyPlace
{
  
  //properties
  private String cafeName;
  private String openHours;
  private String priceList;

  /*
     This constructor builds a cafe object which is a place
      @param1 name is the name of the building
      @param2 hours is working hours of building
    */
  public Cafe(String name, String hours)
  {
    cafeName = name;
    openHours = hours; 
  }
 
  //get methods for each propertie and a set method to be able to change the price list
  public String getOpenHours()
  {
    return openHours;
  }
  
  public String getBuildingName()
  {
    return cafeName;
  }
  
  public void setPriceList(String list)
  {
    priceList = list;
  }
    
  public String getPriceList()
  {
    return priceList;
  }
  
}