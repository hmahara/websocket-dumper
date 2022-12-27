package eu.iamhelmi.websocket.client;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WsClientBean {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private URI uri;
	private WsClient wsClient;
	@Value("${websocket.url}")
	private String urlString;

	private WsClient client;

	@PostConstruct
	public void init() {
		logger.info("Post constructor. Websocket end point: " + urlString);
		try {
			client = new WsClient(new URI(urlString));
			client.setConnectionLostTimeout(525600);
			client.connect();
		} catch (URISyntaxException e) {
			logger.error("Failed to connect to websocket server: "+e.getMessage());
		}
	}
	
	public boolean isWebsocketConnected() {
		return client.isConnected();
	}
	
	public void reconnect(){
		try {
			client = new WsClient(new URI(urlString));
			client.setConnectionLostTimeout(525600);
			client.connect();
		} catch (URISyntaxException e) {
			logger.error("Failed to connect to websocket server: "+e.getMessage());
		}
	}
}
