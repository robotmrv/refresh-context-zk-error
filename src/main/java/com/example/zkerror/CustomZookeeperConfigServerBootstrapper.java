/*
 * Copyright 2015-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.zkerror;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.Bootstrapper;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.util.ClassUtils;

public class CustomZookeeperConfigServerBootstrapper implements Bootstrapper {

	@Override
	@SuppressWarnings("unchecked")
	public void intitialize(BootstrapRegistry registry) {
		boolean zkConfigPresent = ClassUtils.isPresent("org.springframework.cloud.zookeeper.config.ZookeeperConfigProperties", null);
		if (!zkConfigPresent) {
			return;
		}

		// create curator by our condition.
		WaCuratorFactory.registerCurator(registry, null, false,
				bootstrapContext ->
						isConfigEnabled(bootstrapContext.get(Binder.class))
								|| isConfigDiscoveryEnabled(bootstrapContext.get(Binder.class))
		);
	}

	private boolean isConfigDiscoveryEnabled(Binder binder) {
		return binder.bind(ConfigClientProperties.CONFIG_DISCOVERY_ENABLED, Boolean.class).orElse(false);
	}

	private boolean isConfigEnabled(Binder binder) {
		return
//				binder.bind("spring.cloud.zookeeper.enabled", Boolean.class).orElse(true)
//				&&
				binder.bind("spring.cloud.zookeeper.config.enabled", Boolean.class).orElse(true);
	}

}
