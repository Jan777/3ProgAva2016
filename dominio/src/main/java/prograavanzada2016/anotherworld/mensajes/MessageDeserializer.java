package prograavanzada2016.anotherworld.mensajes;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class MessageDeserializer implements JsonDeserializer<RawMessage> {
	String messageTypeName;
	  Gson gson;
	  Map<String, Class<? extends MessageBase>> messageTypeRegistry;

	  public MessageDeserializer(String messageTypeName)
	  {
	    this.messageTypeName = messageTypeName;
	    gson = new Gson();
	    messageTypeRegistry = new HashMap<>(); // Java 7 required for this syntax.
	  }
	
	
	  public void registerMessageType(String messageTypeName, Class<? extends MessageBase> messageType)
	  {
		  messageTypeRegistry.put(messageTypeName, messageType);
	  }

	  @Override
	  public RawMessage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
	      throws JsonParseException
	  {
	    JsonObject messageObject = json.getAsJsonObject();
	    JsonElement messageTypeElement = messageObject.get(messageTypeName);
	    RawMessage message = new RawMessage();
	    message.type = messageTypeElement.getAsString(); 
	    Class<? extends MessageBase> messageType = messageTypeRegistry.get(message.type);
	    message.message = gson.fromJson(messageObject.get("message"), messageType);
	    return message;
	  }

}
