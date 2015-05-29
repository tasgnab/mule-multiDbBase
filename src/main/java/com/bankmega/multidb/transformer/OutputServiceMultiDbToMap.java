package com.bankmega.multidb.transformer;

import java.util.HashMap;
import java.util.List;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.bankmega.multidb.Map;
import com.bankmega.multidb.MapItem;
import com.bankmega.multidb.OutputServiceMultiDb;


public class OutputServiceMultiDbToMap extends AbstractMessageTransformer {

  @Override
  public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
    // TODO Auto-generated method stub
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
	  } else if (respCode.equals("500")){
		  if (respDesc.contains("Security Exception")){
			  respHeader.put("respCode", "401");
			  respHeader.put("respText", "Unauthorized");
			  respHeader.put("respDesc", "Incorrect authentication.");
		  } else {
			  respHeader.put("respCode", "500");
			  respHeader.put("respText", "Internal Server Error");
			  respHeader.put("respDesc", "Please contact Bank Mega Support.");
		  }
	  } else if (respCode.equals("201")){
		  respHeader.put("respCode", "400");
		  respHeader.put("respText", "Bad Request");
		  respHeader.put("respDesc", "Invalid request.");

	  }
//	  OutputServiceMultiDb a = new OutputServiceMultiDb();
//	  a.setResponseCode(out.getResponseCode());
//	  a.setResponseDescription(out.getResponseDescription());
//	  a.setTotalRow("0");
	  
	  HashMap<Integer,Object> respBody = new HashMap<Integer,Object>();
	  if(totalRow>0){
		  Map[] recordMap = out.getRecord();
		  int count = 0;
		  for (Map map : recordMap) {
				List<MapItem> itemList = map.getItem();
				HashMap<String, Object>singleRecord = new HashMap<String, Object>();
				for (MapItem mapItem : itemList) {
					Map resultMap = (Map)mapItem.getValue();
					List<MapItem> resuList = resultMap.getItem();

					for (MapItem mapItem2 : resuList) {
						singleRecord.put((String)mapItem2.getKey(),mapItem2.getValue());
					}
				}
				respBody.put(count++, singleRecord);
		  }
	  }
	  
	  response.put("respHeader", respHeader);
	  response.put("respBody", respBody);
	  
    return response;
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
