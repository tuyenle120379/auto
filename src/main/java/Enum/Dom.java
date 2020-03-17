package Enum;

public enum Dom {
	TABLE_TR {
		public String toString() {
			return "/tbody/tr";
		}
	},
	TD {
		public String toString() {
			return "td";
		}
	}
}
