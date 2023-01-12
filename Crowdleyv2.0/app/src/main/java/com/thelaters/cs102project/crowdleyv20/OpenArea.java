package com.thelaters.cs102project.crowdleyv20;

/*
  This class creates open areas which are places with some specialities
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 12.05.17
 */

public class OpenArea extends MyPlace
{
  private String areaName;
  
  public OpenArea(String name)
  {

    areaName = name;
  }
  
  public String getAreaName()
  {
    return areaName;
  }

   
  
  
}