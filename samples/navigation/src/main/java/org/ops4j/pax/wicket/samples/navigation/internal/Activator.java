/**
 * Copyright OPS4J
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.wicket.samples.navigation.internal;

import org.ops4j.pax.wicket.api.PaxWicketApplicationFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private PaxWicketApplicationFactory paxWicketApplicationFactory;

    public void start(BundleContext context) throws Exception {
        paxWicketApplicationFactory =
            new PaxWicketApplicationFactory(context, NavigationPage.class, "navigation", "navigation",
                new NavigationApplicationFactory());
        paxWicketApplicationFactory.register();
    }

    public void stop(BundleContext context) throws Exception {
        paxWicketApplicationFactory.dispose();
    }

}
