package senef.test.transfer_riddle.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import senef.test.transfer_riddle.service.IRiddleService;
import senef.test.transfer_riddle.service.RiddleServiceImpl;

public class AppBinder extends AbstractBinder {
		@Override
		protected void configure() {
		     bind(RiddleServiceImpl.class).to(IRiddleService.class);
		}
}
