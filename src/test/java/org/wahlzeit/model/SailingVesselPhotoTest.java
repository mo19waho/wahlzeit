/*
 * Class SailingVesselPhotoTest
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
import java.io.IOException;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;

/**
 * Test cases for SailingVesselPhoto class and related.
 */
public class SailingVesselPhotoTest
{
	@Test
	public void testSailingVesselPhotoFactory()
	{
		//
		String type = "Korvette";
		double length = 12.50;
		String portOfReqistry = "Kiel";
		int constructionYear = 1994;
		
		//
		SailingVesselPhotoFactory.initialize();
		SailingVesselPhoto sailingVesselPhoto = SailingVesselPhotoFactory.getInstance().createPhoto();
		
		//
		sailingVesselPhoto.setDepictedSailingVesselInformation(type, length, portOfReqistry, constructionYear);
		
		assertTrue(sailingVesselPhoto.getSailingVesselType().equals(type));
		assertTrue(sailingVesselPhoto.getSailingVesselLength().equals(String.valueOf(length)));
		assertTrue(sailingVesselPhoto.getSailingVesselPortOfReqistry().equals(portOfReqistry));
		assertTrue(sailingVesselPhoto.getSailingVesselConstructionYear().equals(String.valueOf(constructionYear)));
	}
}
