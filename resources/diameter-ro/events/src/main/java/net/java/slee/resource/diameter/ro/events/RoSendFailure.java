/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.ro.events;

import net.java.slee.resource.diameter.base.events.ErrorAnswer;
import net.java.slee.resource.diameter.base.events.avp.ProxyInfoAvp;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;

/**
 * 
 * Implementation of {@link ErrorAnswer}.
 * 
 * @see DiameterMessageImpl
 */
public class RoSendFailure extends DiameterMessageImpl implements ErrorAnswer {
	
  private Exception cause;

  public RoSendFailure(Message message, Exception cause) {
    super(message);
    this.setCause(cause);
  }

  public ProxyInfoAvp getProxyInfo() {
    ProxyInfoAvp[] proxyInfos = super.getProxyInfos();

    return proxyInfos != null && proxyInfos.length > 0 ? proxyInfos[0] : null;
  }

  public boolean hasProxyInfo() {
    ProxyInfoAvp[] proxyInfos = super.getProxyInfos();

    return (proxyInfos != null && proxyInfos.length > 0);
  }

  /*
   * (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getLongName()
   */
  @Override
  public String getLongName() {
    return "undefined";
  }

  /*
   * (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  @Override
  public String getShortName() {
    return "undefined";
  }

  public Exception getCause() {
	return cause;
  }

  public void setCause(Exception cause) {
	this.cause = cause;
  }
}
