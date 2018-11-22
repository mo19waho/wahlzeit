/*
 * Class CartesianCoordinate
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
 * A CartesianCoordinate describes a position in space as cartesian coordinate.
 */
public class CartesianCoordinate extends AbstractCoordinate
{
	/**
	 * Private variables: coordinates.
	 */
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	/**
	 * Public constructor to create a new Coordinate.
	 * @param a, b, c with a = x, b = y, and c = z coordinate.
	 */
	public CartesianCoordinate(double a, double b, double c)
	{
		x = a;
		y = b;
		z = c;
	}

	/**
	 * Receive value of x coordinate.
	 */
	public double getX()
	{
		return x;
	}
  
	/**
	 * Receive value of y coordinate.
	 */
	public double getY()
	{
		return y;
	}
  
	/**
	 * Receive value of z coordinate.
	 */
	public double getZ()
	{
		return z;
	}
	
	/**
	 * Receive this Coordinate represented as CartesianCoordinate.
	 */
	public CartesianCoordinate asCartesianCoordinate()
	{
		return this;
	}
	
	/**
	 * Compute cartesian distance to a given Coordinate.
     * @param otherCoord
     */
	public double getCartesianDistance(Coordinate other)
	{
		CartesianCoordinate otherCoord = other.asCartesianCoordinate();

		return Math.sqrt( Math.pow(x - otherCoord.getX(), 2) + Math.pow(y - otherCoord.getY(), 2) + Math.pow(z - otherCoord.getZ(), 2));
	}
	
	/**
	 * Receive this Coordinate represented as SpericCoordinate.
	 */
	public SphericCoordinate asSphericCoordinate()
	{
		// transformation cartesian to shperical
	    double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		double theta  = Math.toDegrees(Math.atan2(y, x));     
		double phi    = Math.toDegrees(Math.acos(z/radius));//removed toDegrees() ??

		return new SphericCoordinate(phi, theta, radius);
	}
	
    /**
	 * Receive the central angle this Coordinate represented as SpericCoordinate.
	 */
	public double getCentralAngle(Coordinate otherCoord)
	{	
		SphericCoordinate coord1 = this.asSphericCoordinate();
		double theta = Math.toRadians(coord1.getTheta());
		SphericCoordinate coord2 = otherCoord.asSphericCoordinate();
		double theta2 = Math.toRadians(coord2.getTheta());
		double deltaPhi = Math.toRadians(coord2.getPhi()-coord1.getPhi());
		
		
		double numerator   = Math.sqrt(Math.pow(Math.cos(theta2)*Math.sin(deltaPhi), 2) + Math.pow(Math.cos(theta)*Math.sin(theta2) - Math.sin(theta)*Math.cos(theta2)*Math.cos(deltaPhi), 2));
		double denominator = Math.sin(theta)*Math.sin(theta2)+Math.cos(theta)*Math.cos(theta2)*Math.cos(deltaPhi);
		return Math.atan2(denominator, numerator);
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
		CartesianCoordinate otherCoordAsCartesian = otherCoord.asCartesianCoordinate();
		// check for equality in x, y and z coordinate
		if( coordinateEqual(x, otherCoordAsCartesian.getX()) && 
			coordinateEqual(y, otherCoordAsCartesian.getY()) &&
			coordinateEqual(z, otherCoordAsCartesian.getZ()) )
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
	
	/**
	 * Helper method for comparison of double coordinate values.
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean coordinateEqual(double x, double y)
	{
		return Math.abs(x - y) <= 0.000001;
	}
}
