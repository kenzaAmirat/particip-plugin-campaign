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

/**
 *
 */
public class NoSuchPhaseException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public NoSuchPhaseException( )
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     *            Arg
     */
    public NoSuchPhaseException( String arg0 )
    {
        super( arg0 );
    }

    /**
     * @param arg0
     *            Arg
     */
    public NoSuchPhaseException( Throwable arg0 )
    {
        super( arg0 );
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     *            Arg
     * @param arg1
     *            Arg
     */
    public NoSuchPhaseException( String arg0, Throwable arg1 )
    {
        super( arg0, arg1 );
    }

    /**
     * @param arg0
     *            Arg
     * @param arg1
     *            Arg
     * @param arg2
     *            Arg
     * @param arg3
     *            Arg
     */
    public NoSuchPhaseException( String arg0, Throwable arg1, boolean arg2, boolean arg3 )
    {
        super( arg0, arg1, arg2, arg3 );
    }

}
