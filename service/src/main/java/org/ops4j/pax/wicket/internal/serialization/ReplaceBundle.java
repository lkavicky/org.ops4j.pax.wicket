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
package org.ops4j.pax.wicket.internal.serialization;

import java.io.Serializable;
import static org.ops4j.lang.NullArgumentException.validateNotNull;
import static org.ops4j.pax.wicket.internal.serialization.SerializationActivator.bundleContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * @author edward.yakop@gmail.com
 * @since 0.5.4
 */
final class ReplaceBundle
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long m_bundleId;

    ReplaceBundle( Bundle bundle )
    {
        validateNotNull( bundle, "bundle" );
        m_bundleId = bundle.getBundleId();
    }

    final Bundle getBundle()
    {
        BundleContext context = bundleContext();
        return context.getBundle( m_bundleId );
    }
}