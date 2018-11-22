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
public class SphericCoordinate extends AbstractCoordinate
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
	public SphericCoordinate(double p, double t, double r)
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
		double sinPhi   = Math.sin(Math.toRadians(phi));
		double sinTheta = Math.sin(Math.toRadians(theta));
		double cosTheta = Math.cos(Math.toRadians(theta));
		double cosPhi   = Math.cos(Math.toRadians(phi));
        // transformation spherical to cartesian
		double x = radius * cosTheta * sinPhi;
		double y = radius * sinTheta * sinPhi;
		double z = radius * cosPhi;
		
		return new CartesianCoordinate(x, y, z);
	}

	/**
	 * Compute cartesian distance to a given Coordinate.
	 * @param otherCoord
	 */
	public double getCartesianDistance(Coordinate other)
	{
		CartesianCoordinate coord      =  this.asCartesianCoordinate();
		CartesianCoordinate otherCoord = other.asCartesianCoordinate();
		return Math.sqrt( Math.pow(coord.getX() - otherCoord.getX(), 2)
                                + Math.pow(coord.getY() - otherCoord.getY(), 2)
                                + Math.pow(coord.getZ() - otherCoord.getZ(), 2));
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
	public double getCentralAngle(Coordinate otherCoord)
	{
		SphericCoordinate coord2 = otherCoord.asSphericCoordinate();
		double theta2 = coord2.getTheta();
		double deltaPhi = Math.abs(coord2.getPhi()-phi);
		
		return Math.toDegrees(Math.atan2(Math.sqrt(Math.pow(Math.cos(Math.toRadians(theta2))*Math.sin(Math.toRadians(deltaPhi)), 2) + Math.pow(Math.cos(Math.toRadians(theta))*Math.sin(Math.toRadians(theta2)) - Math.sin(theta)*Math.cos(Math.toRadians(theta2))*Math.cos(Math.toRadians(deltaPhi)), 2)), (Math.sin(Math.toRadians(theta))*Math.sin(Math.toRadians(theta2))+Math.cos(Math.toRadians(theta))*Math.cos(Math.toRadians(theta2))*Math.cos(Math.toRadians(deltaPhi)))));
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
		if( coordinateEqual(phi, otherCoordAsSpheric.getPhi()) && 
			coordinateEqual(theta, otherCoordAsSpheric.getTheta()) &&
			coordinateEqual(radius, otherCoordAsSpheric.getRadius()) )
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
