package main.java;

import java.util.ArrayList;
import java.util.List;

public class DataObject {

	private double tenure;
	private double is30dPayer;
	private double paymentAmount30d;
	private double engmtLastWk;
	private double engmtWk_1;
	private double engmtWk_2;
	private double engmtWk_3;
	private double engmt28d;
	private double deltaEngmt4wk;
	private double socialActionsReceivedLastWk;
	private double socialActorsReceivedLastWk;
	private double socialActionsSentLastWk;
	private double socialActorsSentLastWk;
	private double daysSinceLastSend;
	private double daysSinceLastReceive;

	private List<String> list ;

	public DataObject(double tenure, double is30dPayer, double paymentAmount30d, double engmtLastWk, double engmtWk_1, double engmtWk_2, double engmtWk_3, double engmt28d, double deltaEngmt4wk, double socialActionsReceivedLastWk, double socialActorsReceivedLastWk, double socialActionsSentLastWk, double socialActorsSentLastWk, double daysSinceLastSend, double daysSinceLastReceive) {

		this.tenure = tenure;
		this.is30dPayer = is30dPayer;
		this.paymentAmount30d = paymentAmount30d;
		this.engmtLastWk = engmtLastWk;
		this.engmtWk_1 = engmtWk_1;
		this.engmtWk_2 = engmtWk_2;
		this.engmtWk_3 = engmtWk_3;
		this.engmt28d = engmt28d;
		this.deltaEngmt4wk = deltaEngmt4wk;
		this.socialActionsReceivedLastWk = socialActionsReceivedLastWk;
		this.socialActorsReceivedLastWk = socialActorsReceivedLastWk;
		this.socialActionsSentLastWk = socialActionsSentLastWk;
		this.socialActorsSentLastWk = socialActorsSentLastWk;
		this.daysSinceLastSend = daysSinceLastSend;
		this.daysSinceLastReceive = daysSinceLastReceive;

		this.list = new ArrayList<String>();
		this.list.add("Int1");

	}

	public void settenure(double tenure) {
		this.tenure = tenure;
	}

	public double gettenure() {
		return this.tenure;
	}
	public double getis30dPayer() {
		return this.is30dPayer;
	}
	public double getpaymentAmount30d() {
		return this.paymentAmount30d;
	}
	public double getengmtLastWk() {
		return this.engmtLastWk;
	}
	public double getengmtWk_1() {
		return this.engmtWk_1;
	}
	public double getengmtWk_2() {
		return this.engmtWk_2;
	}
	public double getengmtWk_3() {
		return this.engmtWk_3;
	}
	public double getengmt28d() {
		return this.engmt28d;
	}
	public double getdeltaEngmt4wk() {
		return this.deltaEngmt4wk;
	}
	public double getsocialActionsReceivedLastWk() {
		return this.socialActionsReceivedLastWk;
	}
	public double getsocialActorsReceivedLastWk() {
		return this.socialActorsReceivedLastWk;
	}
	public double getsocialActionsSentLastWk() {
		return this.socialActionsSentLastWk;
	}
	public double getsocialActorsSentLastWk() {
		return this.socialActorsSentLastWk;
	}
	public double getdaysSinceLastSend() {
		return this.daysSinceLastSend;
	}
	public double getdaysSinceLastReceive() {
		return this.daysSinceLastReceive;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" mydata: ").append(" tenure : ").append(this.tenure)
				.append(" is30dPayer : ").append(this.is30dPayer)
				.append(" paymentAmount30d : ").append(this.paymentAmount30d)
				.append(" engmtLastWk : ").append(this.engmtLastWk)
				.append(" "+this.list).toString();
	}
}