/*
 * Class SailingVesselPhotoFactory
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
 

/**
 * An Abstract Factory for creating sailint vessel photos and related objects.
 */
public class SailingVesselPhotoFactory extends PhotoFactory
{
    /**
     * Public singleton access method
     */
    public static synchronized SailingVesselPhotoFactory getInstance()
    {
		      if (instance == null)
        {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
		          super.setInstance(new SailingVesselPhotoFactory());
        }
        return super.instance;
    }
      
    /**
     * @methodtype factory
     */
     @Override
     public Photo createPhoto()
     {
         return new SailingVesselPhoto();
	    }

     /**
      * Creates a new sailing vessel photo with the specified id
      */
     @Override
	    public Photo createPhoto(PhotoId id)
     {
		        return new SailingVesselPhoto(id);
     }
}
