/*
 * Class SailingVessel
 *
 * Version 1.0
 *
 * 11-09-2018
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
 * Representation of a sailing vessel.
 */
 public class SailingVessel
 {
	 /**
	  * private variables: attributes of the represented sailing vessel
	  */
     private String type;
     private double length;
     private String portOfRegistry;
     private int constructionYear;
     
     /**
      * @methodtype constructor
      * 
      * @param sailingVesselType  the type of sailing vessel
      * @param len                the length of the ship
      * @param portOfReg          the port of reqistry
      * @param constYear          the year of construction
      */
     public SailingVessel(String sailingVesselType, double len, String portOfReg, int constYear)
     {
         type             = sailingVesselType;
         length           = len;
         portOfRegistry   = portOfReg;
         constructionYear = constYear;
     }
     
     /**
      * Get the type of the represented sailing vessel if available.
      */
     public String getType()
     {
     	return type;
     }
     
     /**
      * Get the length of the represented sailing vessel if available.
      */
     public double getLength()
     {
     	return length;
     }
     
     /**
      * Get the port of reqistry of the represented sailing vessel if available.
      */
     public String getPortOfReqistry()
     {
     	return portOfRegistry;
     }
     
     /**
      * Get the construction year of the represented sailing vessel if available.
      */
     public int getConstructionYear()
     {
     	return constructionYear;
     }
 }
