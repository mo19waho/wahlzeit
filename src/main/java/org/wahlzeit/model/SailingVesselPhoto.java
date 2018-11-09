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

/**
 * A sailing vessel photo represents a user-provided (uploaded) photo of a sailing vessel.
 */
@Entity
public class SailingVesselPhoto extends Photo
{

    /* Brainstorming:
       - type
       - length
       - year of build
       - home haven
       ...
     */

    /**
     * @methodtype constructor
     */
    public SailingVesselPhoto()
    {
        super.Photo();
    }
    
    /**
     * @methodtype constructor
     */
    public SailingVesselPhoto(PhotoId myId)
    {
        super.Photo(myId);
    }
    
}
