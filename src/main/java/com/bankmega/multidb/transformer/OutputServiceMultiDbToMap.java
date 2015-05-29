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
import com.bankmega.multidb.OutputServiceMultiDb;
import com.bankmega.multidb.RequestServiceMultiDb;
import com.bankmega.multidb.beans.MapHolder;
import com.bankmega.multidb.model.ServiceProp;


public class OutputServiceMultiDbToMap extends AbstractMessageTransformer {

  @Override
  public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
    // TODO Auto-generated method stub
//	  System.out.println(">>>>>"+message.toString());
	  HashMap<String,Object> response = new HashMap<String,Object>();
	  HashMap<String,Object> respHeader = new HashMap<String,Object>();
	  OutputServiceMultiDb out = (OutputServiceMultiDb) message.getPayload();
	  String respCode = out.getResponseCode();
	  String respDesc = out.getResponseDescription();
	  int totalRow = Integer.parseInt(out.getTotalRow());
	  if (respCode.equals("00")){
		  if (totalRow>0){
			  respHeader.put("respCode", "200");
			  respHeader.put("respText", "OK");
			  respHeader.put("respDesc", "Success.");
		  } else {
			  respHeader.put("respCode", "404");
			  respHeader.put("respText", "Not Found");
			  respHeader.put("respDesc", "No transaction data found.");
		  }
	  }if (respCode.equals("500")){
		  if (respDesc.contains("Security Exception")){
			  respHeader.put("respCode", "401");
			  respHeader.put("respText", "Unauthorized");
			  respHeader.put("respDesc", "Incorrect authentication.");
		  } else {
			  respHeader.put("respCode", "500");
			  respHeader.put("respText", "Internal Server Error");
			  respHeader.put("respDesc", "Please contact Bank Mega Support.");
		  }
	  }
	  OutputServiceMultiDb a = new OutputServiceMultiDb();
	  a.setResponseCode(out.getResponseCode());
	  a.setResponseDescription(out.getResponseDescription());
	  a.setTotalRow(out.getTotalRow());
	  response.put("respHeader", respHeader);
	  response.put("respBody", respHeader);
    return a;
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
