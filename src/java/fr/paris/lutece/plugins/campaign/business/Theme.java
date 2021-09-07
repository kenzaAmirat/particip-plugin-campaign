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

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;

/**
 * This is the business class for the object Theme
 */
public class Theme implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations
    private int _nId;
    private String _strCampaignCode;
    @NotEmpty( message = "#i18n{campaign.validation.theme.Title.notEmpty}" )
    @Size( max = 255, message = "#i18n{campaign.validation.theme.Title.size}" )
    private String _strTitle;

    @NotEmpty( message = "#i18n{campaign.validation.theme.Description.notEmpty}" )
    private String _strDescription;

    private boolean _bActive;

    @NotEmpty( message = "#i18n{campaign.validation.theme.FrontRgb.notEmpty}" )
    @Size( max = 255, message = "#i18n{campaign.validation.theme.FrontRgb.size}" )
    private String _strFrontRgb;

    private int _nImageFile;

    @NotEmpty( message = "#i18n{campaign.validation.theme.Code.notEmpty}" )
    @Size( max = 50, message = "#i18n{campaign.validation.theme.Code.size}" )
    private String _strCode;

    /**
     * Returns the Id
     * 
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * 
     * @param nId
     *            The Id
     */
    public void setId( int nId )
    {
        _nId = nId;
    }

    /**
     * Returns the CampaignCode
     * 
     * @return The CampaignCode
     */
    public String getCampaignCode( )
    {
        return _strCampaignCode;
    }

    /**
     * Sets the CampaignCode
     * 
     * @param CampaignCode
     *            The CampaignCode
     */
    public void setCampaignCode( String strCampaignCode )
    {
        _strCampaignCode = strCampaignCode;
    }

    /**
     * Returns the Title
     * 
     * @return The Title
     */
    public String getTitle( )
    {
        return _strTitle;
    }

    /**
     * Sets the Title
     * 
     * @param strTitle
     *            The Title
     */
    public void setTitle( String strTitle )
    {
        _strTitle = strTitle;
    }

    /**
     * Returns the Description
     * 
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     * 
     * @param strDescription
     *            The Description
     */
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }

    /**
     * Returns the Active
     * 
     * @return The Active
     */
    public boolean getActive( )
    {
        return _bActive;
    }

    /**
     * Sets the Active
     * 
     * @param bActive
     *            The Active
     */
    public void setActive( boolean bActive )
    {
        _bActive = bActive;
    }

    /**
     * Returns the FrontRgb
     * 
     * @return The FrontRgb
     */
    public String getFrontRgb( )
    {
        return _strFrontRgb;
    }

    /**
     * Sets the FrontRgb
     * 
     * @param strFrontRgb
     *            The FrontRgb
     */
    public void setFrontRgb( String strFrontRgb )
    {
        _strFrontRgb = strFrontRgb;
    }

    /**
     * Returns the ImageFile
     * 
     * @return The ImageFile
     */
    public int getImageFile( )
    {
        return _nImageFile;
    }

    /**
     * Sets the ImageFile
     * 
     * @param nImageFile
     *            The ImageFile
     */
    public void setImageFile( int nImageFile )
    {
        _nImageFile = nImageFile;
    }

    /**
     * @return the Code
     */
    public String getCode( )
    {
        return _strCode;
    }

    /**
     * @param strCode
     *            the Code to set
     */
    public void setCode( String strCodeTheme )
    {

        this._strCode = strCodeTheme;
    }
}
