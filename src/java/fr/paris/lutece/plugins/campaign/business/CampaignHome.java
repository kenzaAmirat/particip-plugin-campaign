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
package fr.paris.lutece.plugins.campaign.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceList;

import java.util.List;

/**
 * This class provides instances management methods (create, find, ...) for Campaign objects
 */
public final class CampaignHome
{
    // Static variable pointed at the DAO instance
    private static ICampaignDAO _dao = SpringContextService.getBean( "campaign.campaignDAO" );
    private static Plugin _plugin = PluginService.getPlugin( "campaign" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private CampaignHome( )
    {
    }

    /**
     * Create an instance of the campaign class
     * 
     * @param campaign
     *            The instance of the Campaign which contains the informations to store
     * @return The instance of campaign which has been created with its primary key.
     */
    public static Campaign create( Campaign campaign )
    {
        _dao.insert( campaign, _plugin );

        return campaign;
    }

    /**
     * Update of the campaign which is specified in parameter
     * 
     * @param campaign
     *            The instance of the Campaign which contains the data to store
     * @return The instance of the campaign which has been updated
     */
    public static Campaign update( Campaign campaign )
    {
        _dao.store( campaign, _plugin );

        return campaign;
    }

    /**
     * Remove the campaign whose identifier is specified in parameter
     * 
     * @param nKey
     *            The campaign Id
     */
    public static void remove( int nKey )
    {
        _dao.delete( nKey, _plugin );
    }

    /**
     * Returns an instance of a campaign whose identifier is specified in parameter
     * 
     * @param nKey
     *            The campaign primary key
     * @return an instance of Campaign
     */
    public static Campaign findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin );
    }

    /**
     * Returns an instance of a campaign whose code is specified in parameter
     * 
     * @param strCampaignCode
     *            The campaign code
     * @return an instance of Campaign
     */
    public static Campaign findByCampaignCode( String strCampaignCode )
    {
        return _dao.loadByCampaignCode( strCampaignCode, _plugin );
    }

    /**
     * Load the data of all the campaign objects and returns them as a list
     * 
     * @return the list which contains the data of all the campaign objects
     */
    public static List<Campaign> getCampaignsList( )
    {
        return _dao.selectCampaignsList( _plugin );
    }

    /**
     * Load the id of all the campaign objects and returns them as a list
     * 
     * @return the list which contains the id of all the campaign objects
     */
    public static List<Integer> getIdCampaignsList( )
    {
        return _dao.selectIdCampaignsList( _plugin );
    }

    /**
     * Load the data of all the campaign objects and returns them as a referenceList
     * 
     * @return the referenceList which contains the data of all the campaign objects
     */
    public static ReferenceList getCampaignsReferenceList( )
    {
        return _dao.selectCampaignsReferenceList( _plugin );
    }

}
