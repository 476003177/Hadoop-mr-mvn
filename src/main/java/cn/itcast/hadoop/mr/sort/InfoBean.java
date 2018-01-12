package cn.itcast.hadoop.mr.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class InfoBean implements WritableComparable<InfoBean>{//�̳нӿ���Ϊ����������л�
	private String account;
	private double income;
	private double expenses;
	private double surplus;  //����
	
	public void set(String account,double income,double expenses){
		this.account=account;
		this.income=income;
		this.expenses=expenses;
		this.surplus=income-expenses;
	}
	
	//�����л�
	public void readFields(DataInput in) throws IOException {
		this.account=in.readUTF();
		this.income=in.readDouble();
		this.expenses=in.readDouble();
		this.surplus=in.readDouble();
	}
	//���л�
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