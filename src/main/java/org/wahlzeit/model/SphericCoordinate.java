/*
 * Class SphericCoordinate
 *
 * Version 1.0
 *
 * 11-16-2018
 *
 * Copyright (c) 2018 Lukas Batz
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.model;

/**
 * A SphericCoordinate describes a position in space as spherical coordinate.
 */
public class SphericCoordinate implements Coordinate
{
	/**
	 * Private variables: coordinates.
	 */
	private double phi = 0;
	private double theta = 0;
	private double radius = 0;
	
	/**
	 * Public constructor to create a new SphericCoordinate.
	 * @param a, b, c with a = x, b = y, and c = z coordinate.
	 */
	public SphericCoordinateCoordinate(double p, double t, double r)
	{
		phi = p;
		theta = t;
		radius = r;
	}

	/**
	 * Receive value of phi coordinate.
	 */
	public double getPhi()
	{
		return phi;
	}
  
	/**
	 * Receive value of theta coordinate.
	 */
	public double getTheta()
	{
		return theta;
	}
  
	/**
	 * Receive value of radius coordinate.
	 */
	public double getRadius()
	{
		return radius;
	}
	
  /**
	 * Receive this Coordinate represented as CartesianCoordinate.
	 */
        public CartesianCoordinate asCartesianCoordinate()
	{
	    TODO
	}

	/**
	 * Compute distance to a given CartesianCoordinate.
	 * @param otherCoord
	 */
	public double getDistance(CartesianCoordinate otherCoord)
	{
	    return Math.sqrt( Math.pow(x - otherCoord.getX(), 2) + Math.pow(y - otherCoord.getY(), 2) + Math.pow(z - otherCoord.getZ(), 2));
	}
	
	/**
	 * Compute cartesian distance to a given Coordinate.
	 * @param otherCoord
	 */
  private double getCartesianDistance(Coordinate otherCoord)
	{
	    return getDistance(otherCoord.asCartesianCoordinate());
	}
	
	/**
	 * Receive this Coordinate represented as SpericCoordinate.
	 */
	public SphericCoordinate asSphericCoordinate()
	{
    return this;
	}
	
  /**
	 * Receive the central angle this Coordinate represented as SpericCoordinate.
	 */
	public double getCentralAngel(Coordinate otherCoord)
	{
      SphericCoordinate coord2 = otherCoord.asSphericCoordinate();
      double theta2 = coord2.getTheta();
	    double deltaPhi = coord2.getPhi()-phi;

	    return Math.atan(Math.sqrt(Math.pow(Math.cos(theta2)*Math.sin(deltaPhi), 2) + Math.pow(Math.cos(theta)*Math.sin(theta2) - Math.sin(theta)*Math.cos(theta2)*Math.cos(deltaPhi), 2))/(Math.sin(theta)*Math.sin(theta2)+Math.cos(theta)*Math.cos(theta2)*Math.cos(deltaPhi)));
	}
	
	/**
	 * Determine whether this and a given coordinate equal.
	 * @param otherCoord
	 */
	public boolean isEqual(Coordinate otherCoord)
	{
		if(otherCoord == null)
		{
			return false;
		}
		SphericCoordinate otherCoordAsSpheric = otherCoord.asSphericCoordinate();
		// check for equality in phi, theta and radius coordinate
		if( (phi == otherCoordAsSpheric.getPhi()) && 
		    (theta == otherCoordAsSpheric.getTheta()) &&
		    (radius == otherCoordAsSpheric.getRadius()) )
		{
		    return true;
		}
		return false;
	}
	
	/**
	 * Forward equals to isEqual.
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj)
	{
		// check for null
		if( obj == null )
		{
			return false;
		}
		// check for same object
		if( obj == this )
		{
			return true;
		}
		// cast object to Coordinate
		Coordinate otherCoord = (Coordinate) obj;
		// forward to isEqual
		return isEqual(otherCoord);
	}
}
