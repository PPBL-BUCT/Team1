package demo.springboot.domain;

public enum CardType {
	CREDIT_CARD('0', "信用卡"), DEPOSIT_CARD('1', "储蓄卡");
	
	private int index;
	private String name;
	
	
	/**
	 * @param index
	 * @param name
	 */
	private CardType(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}

