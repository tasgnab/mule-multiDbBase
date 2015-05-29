package com.bankmega.multidb.model;

public class ServiceProp {
  private String verb;
  private String serviceName;
  private String clientID;
  private String signature;
  
  public ServiceProp(){
  };
  public ServiceProp(String verb, String serviceName, String clientID, String signature) {
    super();
    this.verb = verb;
    this.serviceName = serviceName;
    this.clientID = clientID;
    this.signature = signature;
  }
  public ServiceProp(String service) {
    super();
    String[] tmp = service.split(",");
    this.verb = tmp[0];
    this.serviceName = tmp[1];
    this.clientID = tmp[2];
    this.signature = tmp[3];
  }
  public String getServiceName() {
    return serviceName;
  }
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }
  public String getClientID() {
    return clientID;
  }
  public void setClientID(String clientID) {
    this.clientID = clientID;
  }
  public String getSignature() {
    return signature;
  }
  public void setSignature(String signature) {
    this.signature = signature;
  }
  public String getVerb() {
    return verb;
  }
  public void setVerb(String verb) {
    this.verb = verb;
  }
}
