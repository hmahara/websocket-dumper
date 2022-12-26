package eu.iamhelmi.websocket.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class WebsocketClientBean {
	@Autowired
	private Environment environment;
	


	
	Logger LOG = Logger.getLogger(this.getClass().getName());

	//@PostConstruct
	public void init() {
//		List<String> profiles = Arrays.asList(environment.getDefaultProfiles());
//		LOG.info("XXXXXXXXXxx" + profiles.toString());
//		
//		try {
//			c = new WsClient(new URI("ws://192.168.2.10:9090/event"));
//			c.connect();
//			LOG.info("SSSSS " + c.isConnected());
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		} // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
//		    

	}
	
	

}
