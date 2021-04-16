import java.util.UUID;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;

public class ComputeComplaintIDAndDepartment extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		// MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();

		// create new message
		MbMessage outMessage = new MbMessage(inMessage);
		MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly,
				outMessage);

		try {
			// ----------------------------------------------------------
			// Add user code below
			String ref = "COM" + UUID.randomUUID().toString();

			outMessage
					.evaluateXPath("?CUSTOMERCOMPLAINT/?ADMIN/?REFERENCE[set-value('"
							+ ref + "')]");

			String ctype = (String) outMessage
					.evaluateXPath("string(CUSTOMERCOMPLAINT/COMPLAINT/C_TYPE)");
			if (ctype.equalsIgnoreCase("Order"))
				outMessage
						.evaluateXPath("?CUSTOMERCOMPLAINT/?ADMIN/?DEPT[set-value('B01')]");
			else if (ctype.equalsIgnoreCase("Delivery"))
				outMessage
						.evaluateXPath("?CUSTOMERCOMPLAINT/?ADMIN/?DEPT[set-value('C01')]");
			else
				outMessage
						.evaluateXPath("?CUSTOMERCOMPLAINT/?ADMIN/?DEPT[set-value('E01')]");

			// End of user code
			// ----------------------------------------------------------

			// The following should only be changed
			// if not propagating message to the 'out' terminal
			out.propagate(outAssembly);

		} finally {
			// clear the outMessage
			outMessage.clearMessage();
		}
	}

}
