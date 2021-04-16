package com.ibm.education.messagebroker;

import java.util.GregorianCalendar;
import java.util.ListResourceBundle;

import com.ibm.broker.config.proxy.*;
import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.*;

public class StartFlow extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly assembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage message = assembly.getMessage();

		// ----------------------------------------------------------
		// Add user code below
		//		 Which message flow is to be stopped?
		String b = "WBRK6_DEFAULT_BROKER";
		String e = "EXEGRP1";
		String m = "TEST";

		//Connect to ConfigManager
		MQConfigManagerConnectionParameters conParms = new MQConfigManagerConnectionParameters(
				"localhost", 2414, "WBRK6_DEFAULT_QUEUE_MANAGER");
		try {
			//Obtain handles to MessageFlowProxy object thru topology hierarchy
			ConfigManagerProxy cp = ConfigManagerProxy.getInstance(conParms);
			TopologyProxy tp = cp.getTopology();
			BrokerProxy bp = tp.getBrokerByName(b);
			ExecutionGroupProxy ep = bp.getExecutionGroupByName(e);
			MessageFlowProxy mp = ep.getMessageFlowByName(m);

			//stop Messageflow
			//As requests are processed asynchronously, ensure that the
			// completion code refers to the correct operation.
			GregorianCalendar oldCCTime = mp.getTimeOfLastCompletionCode();
			mp.start();
			GregorianCalendar newCCTime = oldCCTime;
			while (oldCCTime.equals(newCCTime)) {
				newCCTime = mp.getTimeOfLastCompletionCode();
			}
			//Write an information message to the MessageBroker system log. The
			// message has the following format: BIP4360I: Java user-defined
			// node information: [MessageSource:MessageKey]
			//For messages provided as part of a java class a class extending
			// ListResourceBundle must be supplied -> RestartFlowMessages.class
			if ((mp.getLastCompletionCode() == CompletionCodeType.success)) {
				MbService.logInformation(this, "evaluate",
						StartFlowMessages.MESSAGE_SOURCE,
						StartFlowMessages.FLOW_STARTED, "", null);
			} else {
				MbService.logWarning(this, "evaluate",
						StartFlowMessages.MESSAGE_SOURCE,
						StartFlowMessages.FLOW_NOT_STARTED, mp
								.getLastCompletionCode().toString(), null);
			}

			cp.disconnect();
		} catch (ConfigManagerProxyLoggedException e1) {
			e1.printStackTrace();
		} catch (ConfigManagerProxyPropertyNotInitializedException e1) {
			e1.printStackTrace();
		}

		//End of user code
		// ----------------------------------------------------------
		// The following should only be changed
		// if not propagating message to the 'out' terminal

		out.propagate(assembly);
	}

	/**
	 * The class is the ResourceBundle containg all the messages for this
	 * example.
	 */
	public static class StartFlowMessages extends ListResourceBundle {
		public static final String MESSAGE_SOURCE = StartFlowMessages.class
				.getName();

		public static final String FLOW_NOT_STARTED = "FLOW_NOT_STARTED";

		public static final String FLOW_STARTED = "FLOW_STARTED";

		private Object[][] messages = {
				{ FLOW_NOT_STARTED, "Flow should be started, but was not " },
				{ FLOW_STARTED, "Flow was successfully started " } };

		public Object[][] getContents() {
			return messages;
		}
	}
}
