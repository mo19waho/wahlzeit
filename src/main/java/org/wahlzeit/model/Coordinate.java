/*
* Class Coordinate
*
* Version 1.0
*
* 10-27-2018
*
* 
*/
package org.wahlzeit.model;

public class Coordinate
{
  private double x = 0;
  private double y = 0;
  private double z = 0;

  public Coordinate(double a, double b, double c)
  {
    x = a;
    y = b;
    z = c;
  }
  public double getX()
  {
    return x;
  }
  public double getY()
  {
    return y;
  }
  public double getZ()
  {
    return z;
  }
  
  double getDistance(Coordinate coord)
  {
    return 0;
  }
  boolean isEqual(Coordinate coord)
  {
    return false;
  }
}
