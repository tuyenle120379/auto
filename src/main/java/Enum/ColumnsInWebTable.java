package Enum;

public enum ColumnsInWebTable {
	DATE_SUBMITTED(3);

	private int value;

	private ColumnsInWebTable(int value) {
		this.value = value;
	}
	public int getValue() {
        return this.value;
    }
}
