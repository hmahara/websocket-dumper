package eu.iamhelmi.websocket.client;

import java.net.URI;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class WsClient extends WebSocketClient{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private URI uri;
	public WsClient(URI serverUri, Draft draft) {
	    super(serverUri, draft);
	  }
	

	  public WsClient(URI serverURI) {
	    super(serverURI);
	  }

	  public WsClient(URI serverUri, Map<String, String> httpHeaders) {
	    super(serverUri, httpHeaders);
	  }

	  @Override
	  public void onOpen(ServerHandshake handshakedata) {
	    //send("Hello, it is me. Mario :)");
	    logger.info("opened connection");
	    // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	  }

	  @Override
	  public void onMessage(String message) {
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
		  JsonElement je = JsonParser.parseString(message);
		  String jsonOutput = gson.toJson(je);
	    logger.info(System.lineSeparator() +jsonOutput);
	  }

	  @Override
	  public void onClose(int code, String reason, boolean remote) {
	    // The close codes are documented in class org.java_websocket.framing.CloseFrame
	    System.out.println(
	        "Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
	            + reason);
	  }

	  @Override
	  public void onError(Exception ex) {
	    ex.printStackTrace();
	    // if the error is fatal then onClose will be called additionally
	  }
	  
	  public boolean isConnected () {
		  return this.isOpen();
	  }


	
}
