package senef.test.transfer_riddle.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
	    register(new AppBinder());
	    register(new CORSFilter());
	    packages(true, "senef.test.transfer_riddle.resource");//jersey resources package
	}
}
