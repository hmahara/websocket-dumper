package eu.iamhelmi.websocket.client;

import java.util.Date;

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
        logger.debug("Scheduler to check websocket connection " + new Date());
        
        if (!wsClientBean.isWebsocketConnected()) {
        	wsClientBean.reconnect();
        }
        //Thread.sleep(2000);
    }
}
