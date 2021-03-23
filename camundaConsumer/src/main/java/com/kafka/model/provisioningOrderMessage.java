
package com.kafka.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class provisioningOrderMessage { 
	public accounts accounts;
	public String billingSystem;
	public currentServices currentServices;
	public int dbInstanceId;
	public String dbRoot;
	public String legacyCorp;
	public String messageSource;
	public productOrder productOrder;
	public serviceAddressDetails serviceAddressDetails;
	public String spcDivisionId;
	public String TxRoot;
	public String version;
	public workOrders workOrders;
}
