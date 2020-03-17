package configuration;

public class SetUp {
	private static String sBrowser = "";
	private static String sRemoteSlaveNode = "";

	private static SetUp sSetup = new SetUp();

	public static SetUp getSetup() {
		return sSetup;
	}

	public void setBrowser(final String sValue) {
		sBrowser = sValue;
	}

	public String getBrowser() {
		return sBrowser;
	}

	public void setRemoteSlaveNode(final String sValue) {
		sRemoteSlaveNode = sValue;
	}

	public String getRemoteSlaveNode() {
		return sRemoteSlaveNode;
	}

}