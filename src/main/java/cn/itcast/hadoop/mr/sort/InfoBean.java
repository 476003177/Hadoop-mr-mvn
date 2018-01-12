package cn.itcast.hadoop.mr.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class InfoBean implements WritableComparable<InfoBean>{//继承接口是为了排序和序列化
	private String account;
	private double income;
	private double expenses;
	private double surplus;  //结余
	
	public void set(String account,double income,double expenses){
		this.account=account;
		this.income=income;
		this.expenses=expenses;
		this.surplus=income-expenses;
	}
	
	//反序列化
	public void readFields(DataInput in) throws IOException {
		this.account=in.readUTF();
		this.income=in.readDouble();
		this.expenses=in.readDouble();
		this.surplus=in.readDouble();
	}
	//序列化
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(account);
		out.writeDouble(income);
		out.writeDouble(expenses);
		out.writeDouble(surplus);
	}

	public int compareTo(InfoBean o) {
		// TODO Auto-generated method stub
		if(this.income==o.getIncome()){
			return this.expenses>o.getExpenses()? 1:-1;
		}else{
			return this.income>o.getIncome()? -1:1;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.income+"\t"+this.expenses+"\t"+this.surplus;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	public double getSurplus() {
		return surplus;
	}
	public void setSurplus(double surplus) {
		this.surplus = surplus;
	}
	
	
}
