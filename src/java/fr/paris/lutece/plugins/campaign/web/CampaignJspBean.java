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

package fr.paris.lutece.plugins.campaign.web;

import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.security.SecurityTokenService;
import fr.paris.lutece.portal.service.admin.AccessDeniedException;
import fr.paris.lutece.portal.util.mvc.admin.annotations.Controller;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.util.url.UrlItem;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import fr.paris.lutece.plugins.campaign.business.Campaign;
import fr.paris.lutece.plugins.campaign.business.CampaignHome;

/**
 * This class provides the user interface to manage Campaign features ( manage, create, modify, remove )
 */
@Controller( controllerJsp = "ManageCampaigns.jsp", controllerPath = "jsp/admin/plugins/campaign/", right = "CAMPAIGN_MANAGEMENT" )
public class CampaignJspBean extends AbstractManageCampaignsJspBean
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2485209123338980294L;
    // Templates
    private static final String TEMPLATE_MANAGE_CAMPAIGNS = "/admin/plugins/campaign/manage_campaigns.html";
    private static final String TEMPLATE_CREATE_CAMPAIGN = "/admin/plugins/campaign/create_campaign.html";
    private static final String TEMPLATE_MODIFY_CAMPAIGN = "/admin/plugins/campaign/modify_campaign.html";

    // Parameters
    private static final String PARAMETER_ID_CAMPAIGN = "id";

    // Properties for page titles
    private static final String PROPERTY_PAGE_TITLE_MANAGE_CAMPAIGNS = "campaign.manage_campaigns.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_CAMPAIGN = "campaign.modify_campaign.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_CAMPAIGN = "campaign.create_campaign.pageTitle";

    // Markers
    private static final String MARK_CAMPAIGN_LIST = "campaign_list";
    private static final String MARK_CAMPAIGN = "campaign";

    private static final String JSP_MANAGE_CAMPAIGNS = "jsp/admin/plugins/campaign/ManageCampaigns.jsp";

    // Properties
    private static final String MESSAGE_CONFIRM_REMOVE_CAMPAIGN = "campaign.message.confirmRemoveCampaign";

    // Validations
    private static final String VALIDATION_ATTRIBUTES_PREFIX = "campaign.model.entity.campaign.attribute.";

    // Views
    private static final String VIEW_MANAGE_CAMPAIGNS = "manageCampaigns";
    private static final String VIEW_CREATE_CAMPAIGN = "createCampaign";
    private static final String VIEW_MODIFY_CAMPAIGN = "modifyCampaign";

    // Actions
    private static final String ACTION_CREATE_CAMPAIGN = "createCampaign";
    private static final String ACTION_MODIFY_CAMPAIGN = "modifyCampaign";
    private static final String ACTION_REMOVE_CAMPAIGN = "removeCampaign";
    private static final String ACTION_CONFIRM_REMOVE_CAMPAIGN = "confirmRemoveCampaign";

    // Infos
    private static final String INFO_CAMPAIGN_CREATED = "campaign.info.campaign.created";
    private static final String INFO_CAMPAIGN_UPDATED = "campaign.info.campaign.updated";
    private static final String INFO_CAMPAIGN_REMOVED = "campaign.info.campaign.removed";

    private static final String ERROR_CAMPAIGN_CODE_ALREADY_USED = "campaign.error.campaign_code.already.used";

    // Session variable to store working values
    private Campaign _campaign;

    /**
     * Build the Manage View
     * 
     * @param request
     *            The HTTP request
     * @return The page
     */
    @View( value = VIEW_MANAGE_CAMPAIGNS, defaultView = true )
    public String getManageCampaigns( HttpServletRequest request )
    {
        _campaign = null;
        List<Campaign> listCampaigns = CampaignHome.getCampaignsList( );
        Map<String, Object> model = getPaginatedListModel( request, MARK_CAMPAIGN_LIST, listCampaigns, JSP_MANAGE_CAMPAIGNS );

        return getPage( PROPERTY_PAGE_TITLE_MANAGE_CAMPAIGNS, TEMPLATE_MANAGE_CAMPAIGNS, model );
    }

    /**
     * Returns the form to create a campaign
     *
     * @param request
     *            The Http request
     * @return the html code of the campaign form
     */
    @View( VIEW_CREATE_CAMPAIGN )
    public String getCreateCampaign( HttpServletRequest request )
    {
        _campaign = ( _campaign != null ) ? _campaign : new Campaign( );

        Map<String, Object> model = getModel( );
        model.put( MARK_CAMPAIGN, _campaign );
        model.put( SecurityTokenService.MARK_TOKEN, SecurityTokenService.getInstance( ).getToken( request, ACTION_CREATE_CAMPAIGN ) );

        return getPage( PROPERTY_PAGE_TITLE_CREATE_CAMPAIGN, TEMPLATE_CREATE_CAMPAIGN, model );
    }

    /**
     * Process the data capture form of a new campaign
     *
     * @param request
     *            The Http Request
     * @return The Jsp URL of the process result
     * @throws AccessDeniedException
     */
    @Action( ACTION_CREATE_CAMPAIGN )
    public String doCreateCampaign( HttpServletRequest request ) throws AccessDeniedException
    {
        populate( _campaign, request, getLocale( ) );

        if ( !SecurityTokenService.getInstance( ).validate( request, ACTION_CREATE_CAMPAIGN ) )
        {
            throw new AccessDeniedException( "Invalid security token" );
        }

        // Check constraints
        if ( !validateBean( _campaign, VALIDATION_ATTRIBUTES_PREFIX ) )
        {
            return redirectView( request, VIEW_CREATE_CAMPAIGN );
        }
        if ( CampaignHome.findByCampaignCode( _campaign.getCampaignCode( ) ) != null )
        {

            addError( ERROR_CAMPAIGN_CODE_ALREADY_USED, getLocale( ) );
            return redirectView( request, VIEW_CREATE_CAMPAIGN );
        }
        CampaignHome.create( _campaign );
        addInfo( INFO_CAMPAIGN_CREATED, getLocale( ) );

        return redirectView( request, VIEW_MANAGE_CAMPAIGNS );
    }

    /**
     * Manages the removal form of a campaign whose identifier is in the http request
     *
     * @param request
     *            The Http request
     * @return the html code to confirm
     */
    @Action( ACTION_CONFIRM_REMOVE_CAMPAIGN )
    public String getConfirmRemoveCampaign( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_CAMPAIGN ) );
        UrlItem url = new UrlItem( getActionUrl( ACTION_REMOVE_CAMPAIGN ) );
        url.addParameter( PARAMETER_ID_CAMPAIGN, nId );

        String strMessageUrl = AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_CAMPAIGN, url.getUrl( ), AdminMessage.TYPE_CONFIRMATION );

        return redirect( request, strMessageUrl );
    }

    /**
     * Handles the removal form of a campaign
     *
     * @param request
     *            The Http request
     * @return the jsp URL to display the form to manage campaigns
     */
    @Action( ACTION_REMOVE_CAMPAIGN )
    public String doRemoveCampaign( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_CAMPAIGN ) );
        CampaignHome.remove( nId );
        addInfo( INFO_CAMPAIGN_REMOVED, getLocale( ) );

        return redirectView( request, VIEW_MANAGE_CAMPAIGNS );
    }

    /**
     * Returns the form to update info about a campaign
     *
     * @param request
     *            The Http request
     * @return The HTML form to update info
     */
    @View( VIEW_MODIFY_CAMPAIGN )
    public String getModifyCampaign( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_CAMPAIGN ) );

        if ( _campaign == null || ( _campaign.getId( ) != nId ) )
        {
            _campaign = CampaignHome.findByPrimaryKey( nId );
        }

        Map<String, Object> model = getModel( );
        model.put( MARK_CAMPAIGN, _campaign );
        model.put( SecurityTokenService.MARK_TOKEN, SecurityTokenService.getInstance( ).getToken( request, ACTION_MODIFY_CAMPAIGN ) );

        return getPage( PROPERTY_PAGE_TITLE_MODIFY_CAMPAIGN, TEMPLATE_MODIFY_CAMPAIGN, model );
    }

    /**
     * Process the change form of a campaign
     *
     * @param request
     *            The Http request
     * @return The Jsp URL of the process result
     * @throws AccessDeniedException
     */
    @Action( ACTION_MODIFY_CAMPAIGN )
    public String doModifyCampaign( HttpServletRequest request ) throws AccessDeniedException
    {
        populate( _campaign, request, getLocale( ) );

        if ( !SecurityTokenService.getInstance( ).validate( request, ACTION_MODIFY_CAMPAIGN ) )
        {
            throw new AccessDeniedException( "Invalid security token" );
        }

        // Check constraints
        if ( !validateBean( _campaign, VALIDATION_ATTRIBUTES_PREFIX ) )
        {
            return redirect( request, VIEW_MODIFY_CAMPAIGN, PARAMETER_ID_CAMPAIGN, _campaign.getId( ) );
        }

        CampaignHome.update( _campaign );
        addInfo( INFO_CAMPAIGN_UPDATED, getLocale( ) );

        return redirectView( request, VIEW_MANAGE_CAMPAIGNS );
    }
}
