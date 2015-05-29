package com.bankmega.multidb.transformer;

import java.util.HashMap;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.bankmega.multidb.ArrayOfRequest;
import com.bankmega.multidb.InputServiceMultiDb;
import com.bankmega.multidb.RequestServiceMultiDb;
import com.bankmega.multidb.beans.MapHolder;
import com.bankmega.multidb.model.ServiceProp;


public class RequestToInputServiceMultiDb extends AbstractMessageTransformer {

  @Override
  public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
    // TODO Auto-generated method stub
//	  System.out.println(">>>>>"+message.toString());
	  
	  String reqPath = message.getInboundProperty("http.request.path").toString().replace(".json", "");
	  String method = message.getInboundProperty("http.method");
	  HashMap<String, Object> qParam = message.getInboundProperty("http.query.params");
	  
	  MapHolder holder = (MapHolder) muleContext.getRegistry().lookupObject("props"); 
	  String tmp  = (String) holder.getMap().get(reqPath);
	  //System.out.println(">>>>>"+tmp);
	  if (null==tmp){
		  return null;
	  }
	  //System.out.println(">>>>>"+svc.getServiceName());
      ServiceProp svc = new ServiceProp(tmp);
	  
      InputServiceMultiDb service = new InputServiceMultiDb();
	  service.setServiceName(svc.getServiceName());
	  
	  service.setClientId(svc.getClientID());
	  service.setSignature(svc.getSignature());
	  
	  ArrayOfRequest request = new ArrayOfRequest();
	  for (String key: qParam.keySet()){
		  RequestServiceMultiDb req = new RequestServiceMultiDb();
	      req.setRequest(qParam.get(key).toString());
	      request.getItem().add(req);
	  }
	  service.setArrRequest(request);
    return service;
  }
  
	public String sendNotifyProcessSync(String processName,MuleContext context,
			HashMap<String, Object> parameters) {
		DefaultMuleMessage message = new DefaultMuleMessage(parameters, context);
		try {
			context.getClient().send("vm://" + processName,
					message);
		} catch (MuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
