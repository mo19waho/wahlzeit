/*
 * Class Location
 *
 * Version 1.0
 *
 * 10-27-2018
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
 * A Location represents a position, place or locality.
 */
public class Location
{
	/**
	 * public variables: Reference to coordinate object.
	 */
    public Coordinate coordinate = null;
    
    /**
     * Creation of a new Location object and initialization with a Coordinate object.
     * @param coord
     */
    public Location(Coordinate coord)
    {
        coordinate = coord;
    }
    /**
     * Creation of a new Location object and initialization with double coordinate values.
     * @param x, y, z double coordinate values.
     */
    public Location(double x, double y, double z)
    {
    	coordinate = new Coordinate(x, y, z);
    }
}
