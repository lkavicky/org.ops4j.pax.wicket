/*  Copyright 2008 Edward Yakop.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.wicket.it.lifecycle.tracker;

import static java.lang.Thread.sleep;
import org.ops4j.pax.drone.connector.paxrunner.PaxRunnerConnectorConfiguration;
import org.ops4j.pax.wicket.it.PaxWicketIntegrationTest;
import static org.ops4j.pax.wicket.it.bundles.simpleApp.SimpleAppConstants.SYMBOLIC_NAME_SIMPLE_APP;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;

/**
 * @author edward.yakop@gmail.com
 * @since 0.5.4
 */
public final class WicketApplicationTrackTest extends PaxWicketIntegrationTest
{

    @Override
    protected void onTestBundleConfigure( PaxRunnerConnectorConfiguration configuration )
    {
        configuration.addBundle( "mvn:org.ops4j.pax.wicket.integrationTest.bundles/simpleApp" );
    }

    public final void testApplicationTracker()
        throws Exception
    {
        sleep( 1000 );
        Bundle simpleAppBundle = getBundleBySymbolicName( SYMBOLIC_NAME_SIMPLE_APP );
        assertNotNull( simpleAppBundle );
        ServiceReference[] beforeStopServices = simpleAppBundle.getRegisteredServices();
        assertEquals( 12, beforeStopServices.length );

        Bundle bundle = getPaxWicketServiceBundle();
        bundle.stop();

        ServiceReference[] services = simpleAppBundle.getRegisteredServices();
        assertNotNull( services );
        assertEquals( 1, services.length );
    }
}