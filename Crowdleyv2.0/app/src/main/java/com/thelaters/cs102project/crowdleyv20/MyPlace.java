package com.thelaters.cs102project.crowdleyv20;

/*
  This class creates locatable places
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 12.05.17
 */

public class MyPlace implements Locatable
    {
        //properties
        private double x1,y1;
        private double crowdedness;
        private int population;


        //methods
        public void setPopulation(int pop)
        {
            population = pop;
            crowdedness = getPopulation() / ((Building)this).getNormalLevel();
        }

        public int getPopulation()
        {
            return population;
        }

        public void decPopulation()
        {
            population--;
        }

        public double getCrowdedness()
        {
            return crowdedness;
        }


        public void setLocation(double x1 ,double y1 )
        {
            this.x1 = x1;
            this.y1 = y1;
        }

        public double getx1()
        {
            return x1;
        }


        public double gety1()
        {
            return y1;
        }


    }

