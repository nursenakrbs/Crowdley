package com.thelaters.cs102project.crowdleyv20;
/*
  This class represents buildings which are places with specific properties
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 10.04.17
 */
public class Building extends MyPlace
{
  
  //properties
  private String buildingName;
  private String openHours;
  private int normalLevel;
  
  /*
    This constructor builds a building object which is a place
     @param1 name is the name of the building
     @param2 hours is working hours of building
     @param3 num is the usual crowdedness level of building
   */
  public Building(String name, String hours, int num )
  {
    buildingName = name;
    openHours = hours;
    normalLevel = num;
  }

  //get methods for each propertie
  public String getOpenHours()
  {
    return openHours;
  }
  
  public String getBuildingName()
  {
    return buildingName;
  }

  public int getNormalLevel()
  {
    return normalLevel;
  }

    

  
}