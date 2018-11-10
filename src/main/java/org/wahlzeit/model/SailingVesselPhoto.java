/*
 * Class SailingVesselPhoto
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
 * A sailing vessel photo represents a user-provided (uploaded) photo of a sailing vessel.
 */
public class SailingVesselPhoto extends Photo
{

	/**
	 * Reference to an object representing the sailing vessel shown in a sailing vessel photo.
	 */
	private SailingVessel depictedSailingVessel = null;
	
	/**
     * @methodtype constructor
     */
    public SailingVesselPhoto()
    {
        super();
    }
    
    /**
     * @methodtype constructor
     * 
     * @param myId
     */
    public SailingVesselPhoto(PhotoId myId)
    {
        super(myId);
    }

    /**
     * @methodtype constructor
     * 
     * @param sailingVessel
     */
    public SailingVesselPhoto(SailingVessel sailingVessel)
    {
        super();
        depictedSailingVessel = sailingVessel;
    }
    
    /**
     * @methodtype constructor
     *  
     * @param myId
     * @param sailingVessel
     */
    public SailingVesselPhoto(PhotoId myId, SailingVessel sailingVessel)
    {
        super(myId);
        depictedSailingVessel = sailingVessel;
    }
    
    /**
     * @methodtype constructor
     * 
     * @param sailingVesselType  the type of sailing vessel
     * @param len                the length of the ship
     * @param portOfReg          the port of reqistry
     * @param constYear          the year of construction
     */
    public SailingVesselPhoto(String sailingVesselType, double length, String portOfRegistry, int constructionYear)
    {
        super();
        depictedSailingVessel = new SailingVessel(sailingVesselType, length, portOfRegistry, constructionYear);    
    }
    
    /**
     * @methodtype constructor
     * 
     * @param myId
     * @param sailingVesselType  the type of sailing vessel
     * @param len                the length of the ship
     * @param portOfReg          the port of reqistry
     * @param constYear          the year of construction
     */
    public SailingVesselPhoto(PhotoId myId, String sailingVesselType, double length, String portOfRegistry, int constructionYear)
    {
        super(myId);
        depictedSailingVessel = new SailingVessel(sailingVesselType, length, portOfRegistry, constructionYear);    
    }
    
    /**
     * 
     * @param sailingVessel
     */
    public void setDepictedSailingVessel(SailingVessel sailingVessel)
    {
    	depictedSailingVessel = sailingVessel;
    }
    
    /**
     * 
     * @param sailingVesselType  the type of sailing vessel
     * @param len                the length of the ship
     * @param portOfReg          the port of reqistry
     * @param constYear          the year of construction
     */
    public void setDepictedSailingVesselInformation(String sailingVesselType, double length, String portOfRegistry, int constructionYear)
    {
    	depictedSailingVessel = new SailingVessel(sailingVesselType, length, portOfRegistry, constructionYear); 
    }
    
    /**
     * Get the type of the depicted sailing vessel if available.
     */
    public String getSailingVesselType()
    {
    	if(depictedSailingVessel == null)
    	{
    		return "n.A.";
    	}
    	return depictedSailingVessel.getType();
    }
    
    /**
     * Get the length of the depicted sailing vessel as String if available.
     */
    public String getSailingVesselLength()
    {
    	if(depictedSailingVessel == null)
    	{
    		return "n.A.";
    	}
    	return String.valueOf(depictedSailingVessel.getLength());
    }
    
    /**
     * Get the port of reqistry of the depicted sailing vessel if available.
     */
    public String getSailingVesselPortOfReqistry()
    {
    	if(depictedSailingVessel == null)
    	{
    		return "n.A.";
    	}
    	return depictedSailingVessel.getPortOfReqistry();
    }
    
    /**
     * Get the construction year of the depicted sailing vessel as String if available.
     */
    public String getSailingVesselConstructionYear()
    {
    	if(depictedSailingVessel == null)
    	{
    		return "n.A.";
    	}
    	return String.valueOf(depictedSailingVessel.getConstructionYear());
    }
}
