package finance;

public class Finance {
	private double tution;
	private double financialAid;
	private double roomAndBoard;
	private double totalCost;
	
	public void setTution(double tution) {
		this.tution = tution;
	}
	
	public double getTution() {
		return tution;
	}
	
	public void setFinancilaAid(double financialAid) {
		this.financialAid = financialAid;
	}
	
	public double getFinancialAid() {
		return financialAid;
	}
	
	public void setRoomAndBoard(double roomAndBoard) {
		this.roomAndBoard = roomAndBoard;
	}
	
	public double getRoomAndBoard() {
		return roomAndBoard;
	}
	
	public double calculateTotalCost() {
		if ((financialAid > 0) || (roomAndBoard > 0)) {
			totalCost = (tution + roomAndBoard) - financialAid;
		} else
			totalCost = tution;
	return totalCost;
	}
}



