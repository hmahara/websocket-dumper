package eu.iamhelmi.websocket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ScheduledCheckConnection {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WsClientBean wsClientBean;
	
	@Async
    @Scheduled(fixedRate = 5000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        logger.info("Fixed rate task async - " + System.currentTimeMillis() / 1000);
        logger.info("************** " + wsClientBean.isWebsocketConnected());
        if (!wsClientBean.isWebsocketConnected()) {
        	wsClientBean.reconnect();
        }
        //Thread.sleep(2000);
    }
}
