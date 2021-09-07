/*
 * Copyright (c) 2002-2021, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.campaign.service;

import java.sql.Timestamp;

import fr.paris.lutece.plugins.campaign.business.Campaign;
import fr.paris.lutece.util.ReferenceList;

/**
 *
 */
public interface ICampaignService
{

    // Returns the campain the code of which is the SQL 'max'.
    // Ex : if 6 campagne with 'B0' - 'C' - 'D' - 'G0' - 'GA' - 'G', returns campagne 'GA'.

    /**
     * @param campagne
     *            Data
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isDuring( String campagne, String phase ); // PHASE_BEGINNING < current < PHASE_END

    /**
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isDuring( String phase );

    /**
     * @return Data
     */
    public Campaign getLastCampaign( );

    /**
     * @param campagne
     *            Data
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isBeforeEnd( String campagne, String phase ); // ..................................current < PHASE_END

    /**
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isBeforeEnd( String phase );

    /**
     * @param campagne
     *            Data
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isAfterBeginning( String campagne, String phase ); // PHASE_BEGINNING < current............................

    /**
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isAfterBeginning( String phase );

    /**
     * @param campagne
     *            Data
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isBeforeBeginning( String campagne, String phase ); // ......current < PHASE_BEGINNING

    /**
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isBeforeBeginning( String phase );

    /**
     * @param campagne
     *            Data
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isAfterEnd( String campagne, String phase ); // PHASE_END < current......

    /**
     * @param phase
     *            Data
     * @return Data
     */
    public boolean isAfterEnd( String phase );

    /**
     * 
     */
    // Resets the internal cache of phases
    public void reset( );

    /**
     * Load the data of all the campaign objects and returns them as a referenceList
     * 
     * @return the referenceList which contains the data of all the campaign objects
     */
    public ReferenceList getCampaignsReferenceList( );

}
