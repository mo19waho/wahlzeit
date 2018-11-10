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
	 * Test getter methods of Coordinate class for access of single coordinate values. 
	 */
	@Test
	public void testCoordinateGet()
	{
		double x = 1.3;
		double y = 6.0;
		double z = 0.13;
		Coordinate coord = new Coordinate(x, y, z);
		
		assertEquals(coord.getX(), x,  delta);
		assertEquals(coord.getY(), y,  delta);
		assertEquals(coord.getZ(), z, delta);
	}
	/**
	 * Test isEqual functionality of Coordinate class.
	 */
	@Test
	public void testCoordinateIsEqual()
	{
		Coordinate coord0 = new Coordinate(1.3, 6.0, 0.13);
	    Coordinate coord1 = new Coordinate(0.13, 6.0, 1.3);
	    Coordinate coord2 = new Coordinate(1.3, 6.0, 0.13);
	    
	    assertTrue(coord0.isEqual(coord0));
	    assertTrue(coord0.isEqual(coord2));
	    assertTrue(coord2.isEqual(coord0));
	    
	    assertFalse(coord0.isEqual(coord1));
	    assertFalse(coord1.isEqual(coord0));
	    assertFalse(coord1.isEqual(null));
	}
	
	/**
	 * Test desired forwarding of equals to isEqual of Coordinate.
	 */
	@Test
	public void testCoordinateEquals()
	{
		Coordinate coord0 = new Coordinate(1.3, 6.0, 0.13);
	    Coordinate coord1 = new Coordinate(0.13, 6.0, 1.3);
	    Coordinate coord2 = new Coordinate(1.3, 6.0, 0.13);
	    
	    assertTrue(coord0.equals(coord0));
	    assertTrue(coord0.equals(coord2));
	    assertTrue(coord2.equals(coord0));
	    
	    assertFalse(coord0.equals(coord1));
	    assertFalse(coord1.equals(coord0));
	    assertFalse(coord1.equals(null));
	}
	
	/**
	 * Test getDistance functionality of Coordinat class.
	 */
	@Test
	public void testCoordinateGetDistance()
	{
		Coordinate coord0 = new Coordinate(0.0, 0.0, 0.0);
		Coordinate coord1 = new Coordinate(-8.0, 11.0, 0.0);
		Coordinate coord2 = new Coordinate(0.1, 0.2, 0.3);
		Coordinate coord3 = new Coordinate(1.0, 5.0, 7.0);
		

		assertEquals(coord0.getDistance(coord0), 0.0, delta);
		assertEquals(coord0.getDistance(coord1),  13.601470508735444, delta);
		assertEquals(coord0.getDistance(coord2),  0.37416573867739417, delta);
		assertEquals(coord0.getDistance(coord3),   8.660254037844387, 0.1);
	    assertEquals(coord3.getDistance(coord3), 0.0, delta);
		assertEquals(coord3.getDistance(coord2),   8.290958931269651, 0.1);
	}
	
	/**
	 * Test creation of a Location by directly using Coordinate class.
	 */
	@Test
	public void testLocationUsingCoordinate()
	{
		Coordinate coord = new Coordinate(1.0, 1.0, 1.0);
		Location loc = new Location(coord);
		
		assertEquals(coord, loc.coordinate);
	}
	
	/**
	 * Test creation of Location using doublce coordinates.
	 */
	@Test
	public void testLocationUsingDoubleCoordinates()
	{	
		double x = 8.0;
		double y = 1.17;
		double z = 13.4;
		Location loc = new Location(x, y, z);
		Coordinate coord = loc.coordinate;
		
		assertEquals(coord.getX(), x, delta);
		assertEquals(coord.getY(), y, delta);
		assertEquals(coord.getZ(), z, delta);
	}
}
