package de.codecentric;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class ServiceLookupTest  extends FunctionalTestCase {

	@Override
	protected String getConfigResources() {
		return "src/main/app/service-registry-mule-example.xml";
	}

	@Override
	protected int getTimeoutSystemProperty() {
		return 60 * 60; // 1 hour
	}
	
	@Test
	public void testClient() throws Exception {

		// Given
		String request = "helloWorld";
		MuleClient client = new MuleClient(muleContext);
		
		// When
		MuleMessage response = (MuleMessage)client.send("vm://inbound", request, null, 1000000);
		
		// Then
		assertEquals(request,response.getPayloadAsString());
	}
}
