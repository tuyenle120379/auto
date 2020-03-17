package automation.assignment;

import configuration.SetUp;


public class FillSetUpInfo {
	private final SetUp setUp = new SetUp();
		
	public boolean fillBrowser(final String sValue) {
		setUp.setBrowser(sValue);
		return true;
	}

	public boolean fillRemoteSlaveNode(final String sValue) {
		setUp.setRemoteSlaveNode(sValue);
		return true;
	}

}