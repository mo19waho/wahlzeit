/*
 * Class LocationTest
 *
 * Version 1.0
 *
 * 11-10-2018
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

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test cases for the Location and Coordinate class.
 */
public class LocationTest
{
	/**
	 * Difference allowed because of double precision.  
	 */
	private double delta = 0.000001;

	/**
	 * Test getter methods of CartesianCoordinate class for access of single coordinate values. 
	 */
	@Test
	public void testCartesianCoordinateGet()
	{
		double x = 1.3;
		double y = 6.0;
		double z = 0.13;
		CartesianCoordinate coord = new CartesianCoordinate(x, y, z);
		
		assertEquals(coord.getX(), x,  delta);
		assertEquals(coord.getY(), y,  delta);
		assertEquals(coord.getZ(), z, delta);
	}
	
	/**
	 * Test getter methods of SphericCoordinate class for access of single coordinate values. 
	 */
	@Test
	public void testSphericCoordinateGet()
	{
		double p = 1.3;
		double t = 6.0;
		double r = 0.13;
		SphericCoordinate coord = new SphericCoordinate(p, t, r);
		
		assertEquals(coord.getPhi(), p,  delta);
		assertEquals(coord.getTheta(), t,  delta);
		assertEquals(coord.getRadius(), r, delta);
	}
	
	/**
	 *  Test the asCartesianCoordinate Method of CartesianCoordinate class.
	 */
	@Test
	public void testCartesianCoordinateasAsCartesianCoordinate()
	{
		CartesianCoordinate coord  = new CartesianCoordinate(1.0, 7.0, 28.0);
		CartesianCoordinate test   = coord.asCartesianCoordinate();
		
		assertEquals(coord.getX(), test.getX(), delta);
		assertEquals(coord.getY(), test.getY(), delta);
		assertEquals(coord.getZ(), test.getZ(), delta);
	}
	
	/**
	 *  Test the asCartesianCoordinate Method of SphericCoordinate class.
	 */
	@Test
	public void testSphericCoordinateasAsCartesianCoordinate()
	{
		
		SphericCoordinate coord  = new SphericCoordinate(8.1, 11.1, 7.3);
		CartesianCoordinate cart = coord.asCartesianCoordinate();
		assertEquals(cart.getX(), 1.00933702, delta);
		assertEquals(cart.getY(), 0.1980240505, delta);
		assertEquals(cart.getZ(), 7.227172701, delta);
		
		SphericCoordinate coord2  = new SphericCoordinate(60.0, 45.0, 30.0);
		CartesianCoordinate cart2 = coord2.asCartesianCoordinate();
		
		assertEquals(cart2.getX(), 18.37117307, 0.1);
		assertEquals(cart2.getY(), 18.37117307, 0.1);
		assertEquals(cart2.getZ(), 15.0, 0.1);
		
		SphericCoordinate test = cart2.asSphericCoordinate();
		
		assertEquals(test.getRadius(), 30.0, delta);
		assertEquals(test.getTheta(), 45.0, delta);
		assertEquals(test.getPhi(), 60.0, delta);
		
	}
	
		/**
	 *  Test the asSphericCoordinate Method of CartesianCoordinate class.
	 */
	@Test
	public void testCartesianCoordinateasAsSphericCoordinate()
	{
		CartesianCoordinate coord = new CartesianCoordinate(1.3, 6.0, 10);
	    SphericCoordinate spheric = coord.asSphericCoordinate();
        assertEquals(spheric.getRadius(), 11.734138229968, delta);
        assertEquals(spheric.getTheta(), 77.774877324264, delta);
        assertEquals(spheric.getPhi(), 31.546671835855, delta);
        
		CartesianCoordinate coord2 = new CartesianCoordinate(10, 3, 8);
	    SphericCoordinate spheric2 = coord2.asSphericCoordinate();
        assertEquals(spheric2.getRadius(), 13.152946437966, delta);
        assertEquals(spheric2.getTheta(), 16.699244233994, delta);
        assertEquals(spheric2.getPhi(), 52.538460979869, delta);
        
	    
		CartesianCoordinate cartesian = spheric.asCartesianCoordinate();
		assertEquals(coord.getX(), cartesian.getX(),  delta);
		assertEquals(coord.getY(), cartesian.getY(),  delta);
		assertEquals(coord.getZ(), cartesian.getZ(), delta);
	}
	
	/**
	 *  Test the asSphericCoordinate Method of SphericCoordinate class.
	 */
	@Test
	public void testSphericCoordinateasAsSphericCoordinate()
	{
		SphericCoordinate coord  = new SphericCoordinate(1.0, 7.0, 28.0);
		SphericCoordinate test   = coord.asSphericCoordinate();
		
		assertEquals(coord.getPhi(), test.getPhi(), delta);
		assertEquals(coord.getTheta(), test.getTheta(), delta);
		assertEquals(coord.getRadius(), test.getRadius(), delta);
	}
		
	/**
	 * Test isEqual functionality of CartesianCoordinate class.
	 */
	@Test
	public void testCartesianCoordinateIsEqual()
	{
		Coordinate coord0 = new CartesianCoordinate(1.3, 6.0, 0.13);
		Coordinate coord1 = new CartesianCoordinate(0.13, 6.0, 1.3);
		Coordinate coord2 = new CartesianCoordinate(1.3, 6.0, 0.13);
	    
		// cases where equality is expected
		assertTrue(coord0.isEqual(coord0));
		assertTrue(coord0.isEqual(coord2));
		assertTrue(coord2.isEqual(coord0));
		assertTrue(coord0.isEqual(coord0.asSphericCoordinate()));
		assertTrue(coord0.isEqual(coord2.asSphericCoordinate()));
		assertTrue(coord2.isEqual(coord0.asSphericCoordinate()));
		
		// cases where no equality is expected
		assertFalse(coord0.isEqual(coord1));
		assertFalse(coord1.isEqual(coord0));
		assertFalse(coord1.isEqual(null));
	}
	
	/**
	 * Test isEqual functionality of SphericCoordinate class.
	 */
	@Test
	public void testSphericCoordinateIsEqual()
	{
		Coordinate coord0 = new SphericCoordinate(1.3, 6.0, 0.13);
		Coordinate coord1 = new SphericCoordinate(0.13, 6.0, 1.3);
		Coordinate coord2 = new SphericCoordinate(1.3, 6.0, 0.13);
		
		// cases where equality is expected
		assertTrue(coord0.isEqual(coord0));
		assertTrue(coord0.isEqual(coord2));
		assertTrue(coord2.isEqual(coord0));
		assertTrue(coord0.isEqual(coord0.asCartesianCoordinate()));
		assertTrue(coord0.isEqual(coord2.asCartesianCoordinate()));
		assertTrue(coord2.isEqual(coord0.asCartesianCoordinate()));
		// cases where no equality is expected
		assertFalse(coord0.isEqual(coord1.asCartesianCoordinate()));
		assertFalse(coord1.isEqual(coord0.asCartesianCoordinate()));
		assertFalse(coord0.isEqual(coord1));
		assertFalse(coord1.isEqual(coord0));
		assertFalse(coord1.isEqual(null));
	}
	
	/**
	 * Test desired forwarding of equals to isEqual of CartesianCoordinate.
	 */
	@Test
	public void testCartesianCoordinateEquals()
	{
		Coordinate coord0 = new CartesianCoordinate(1.3, 6.0, 0.13);
		Coordinate coord1 = new CartesianCoordinate(0.13, 6.0, 1.3);
		Coordinate coord2 = new CartesianCoordinate(1.3, 6.0, 0.13);
		
		// cases where equality is expected
		assertTrue(coord0.equals(coord0));
		assertTrue(coord0.equals(coord2));
		assertTrue(coord2.equals(coord0));
		assertTrue(coord0.equals(coord0.asSphericCoordinate()));
		assertTrue(coord0.equals(coord2.asSphericCoordinate()));
		assertTrue(coord2.equals(coord0.asSphericCoordinate()));
		
		// cases where no equality is expected
		assertFalse(coord0.equals(coord1));
		assertFalse(coord1.equals(coord0));
		assertFalse(coord0.equals(coord1.asSphericCoordinate()));
		assertFalse(coord1.equals(coord0.asSphericCoordinate()));
		assertFalse(coord1.equals(null));
	}
	
	/**
	 * Test desired forwarding of equals to isEqual of SphericCoordinate.
	 */
	@Test
	public void testSphericCoordinateEquals()
	{
		Coordinate coord0 = new SphericCoordinate(1.3, 6.0, 0.13);
		Coordinate coord1 = new SphericCoordinate(0.13, 6.0, 1.3);
		Coordinate coord2 = new SphericCoordinate(1.3, 6.0, 0.13);
		
		// cases where equality is expected
		assertTrue(coord0.equals(coord0));
		assertTrue(coord0.equals(coord2));
		assertTrue(coord2.equals(coord0));
		assertTrue(coord0.equals(coord0.asCartesianCoordinate()));
		assertTrue(coord0.equals(coord2.asCartesianCoordinate()));
		assertTrue(coord2.equals(coord0.asCartesianCoordinate()));
		
		// cases where no equality is expected
		assertFalse(coord0.equals(coord1));
		assertFalse(coord1.equals(coord0));
		assertFalse(coord0.equals(coord1.asCartesianCoordinate()));
		assertFalse(coord1.equals(coord0.asCartesianCoordinate()));
		assertFalse(coord1.equals(null));
	}
	
	/**
	 * Test getCartesianDistance functionality of CartesianCoordinat class.
	 */
	@Test
	public void testCartesianCoordinateGetCartesianDistance()
	{

		Coordinate coord0 = new CartesianCoordinate(0.0, 0.0, 0.0);
		Coordinate coord1 = new CartesianCoordinate(-8.0, 11.0, 0.0);
		Coordinate coord2 = new CartesianCoordinate(0.1, 0.2, 0.3);
		Coordinate coord3 = new CartesianCoordinate(1.0, 5.0, 7.0);
		Coordinate coordSpheric = new SphericCoordinate(3.0, 4.0, 5.0);

		assertEquals(coord0.getCartesianDistance(coord0), 0.0, delta);
		assertEquals(coord0.getCartesianDistance(coord1),  13.601470508735444, delta);
		assertEquals(coord0.getCartesianDistance(coord2),  0.37416573867739417, delta);
		assertEquals(coord0.getCartesianDistance(coord3),   8.660254037844387, delta);
		assertEquals(coord3.getCartesianDistance(coord3), 0.0, delta);
		assertEquals(coord3.getCartesianDistance(coord2),   8.290958931269651, delta);
		// test with spheric class
		assertEquals(coord0.getCartesianDistance(coordSpheric), 5.0, delta);

	}
	
	/**
	 * Test getCartesianDistance functionality of SphericCoordinat class.
	 */
	@Test
	public void testSphericCoordinateGetCartesianDistance()
	{
		Coordinate coord0 = new SphericCoordinate(0.0, 0.0, 0.0);
		Coordinate coord1 = new SphericCoordinate(52.538460979869, 16.699244233994, 13.152946437966);
		Coordinate coord2 = new SphericCoordinate(3.0, 4.0, 5.0);
		Coordinate coordCart = new CartesianCoordinate(0.0, 0.0, 0.0);
		
		assertEquals(coord0.getCartesianDistance(coord0), 0.0, delta);
		assertEquals(coord0.getCartesianDistance(coord1), 13.152946, delta);
		assertEquals(coord2.getCartesianDistance(coord0), 5.0, delta);
		assertEquals(coord2.getCartesianDistance(coordCart), 5.0, delta);
	}
	
	/**
	 * Test getCentralAngle functionality of CartesianCoordinat class.
	 */
	@Test
	public void testCartesianCoordinateGetCentralAngle()
	{
		// theta1 = 3 phi1 = 7 | theta2 = 6 phi2 = 1
		Coordinate coord1 = new CartesianCoordinate(7.0, 3.0, 9.0);
		Coordinate coord2 = new CartesianCoordinate(1.0, 6.0, 8.0);
		assertEquals(coord1.getCentralAngle(coord2), 6.691, delta);
		assertEquals(coord2.getCentralAngle(coord1), 6.691, delta);
		// arctan(sqrt((cos(6 deg)*sin(abs(1-7) deg))^2 + (cos(3 deg)*sin(6 deg) - sin(3 deg)*cos(6 deg)*cos(abs(1-7) deg))^2)/(sin(3 deg)*sin(6 deg) + cos(3 deg)*cos(6 deg)*cos(abs(1-7) deg)))
	}
	
	/**
	 * Test getCentralAngle functionality of SphericCoordinat class.
	 */
	@Test
	public void testSphericCoordinateGetCentralAngle()
	{
		// TODO
	}
	
	/**
	 * Test creation of a Location by directly using CartesianCoordinate class.
	 */
	@Test
	public void testLocationUsingCoordinate()
	{
		Coordinate coord = new CartesianCoordinate(1.0, 1.0, 1.0);
		Location loc = new Location(coord);
		
		assertEquals(coord, loc.coordinate);
	}
	
	/**
	 * Test creation of Location using double coordinates.
	 */
	@Test
	public void testLocationUsingDoubleCoordinates()
	{	
		double x = 8.0;
		double y = 1.17;
		double z = 13.4;
		Location loc = new Location(x, y, z);
		CartesianCoordinate coord = loc.coordinate;
		
		assertEquals(coord.getX(), x, delta);
		assertEquals(coord.getY(), y, delta);
		assertEquals(coord.getZ(), z, delta);
	}
}
