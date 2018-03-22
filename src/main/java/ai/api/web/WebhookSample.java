package ai.api.web;

import javax.servlet.annotation.WebServlet;

import ai.api.model.Fulfillment;
import ai.api.model.ResponseMessage;
import ai.api.model.ResponseMessage.ResponseImage;
import ai.api.model.ResponseMessage.ResponseQuickReply;
import ai.api.model.ResponseMessage.ResponseSpeech;
import ai.api.web.AIWebhookServlet;

@WebServlet("/webhook")
public class WebhookSample extends AIWebhookServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
	  output.setSpeech("You said: " + input.getResult().getFulfillment().getSpeech());
	    String action = input.getResult().getAction();

	    if(action.equals("search_property")){
	        
	    }
	    
	    ResponseSpeech speech = new ResponseMessage.ResponseSpeech();
	    speech.setSpeech("speech 1", "speech 2");
	        
	    ResponseImage image = new ResponseMessage.ResponseImage();
	    image.setImageUrl("url image");

	    ResponseQuickReply quickReply = new ResponseMessage.ResponseQuickReply();
	    quickReply.setTitle("Quick title");

	    output.setSpeech("test speech");
	    output.setMessages(image, quickReply, speech);
  }
}