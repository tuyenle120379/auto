package Enum;

public enum ColumnsInWebTable {
	REQUEST_STATUS(1),DATE_SUBMITTED(2);

	private int value;

	private ColumnsInWebTable(int value) {
		this.value = value;
	}
	public int getValue() {
        return this.value;
    }
}
