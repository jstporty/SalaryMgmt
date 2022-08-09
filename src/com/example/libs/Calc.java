package com.example.libs;

public class Calc {
	private Employee [] array;
	private int count;
	
	public Calc(Employee[] array, int count) {   //Constructor
		this.array = array;
		this.count = count;
	}
	
	public void calc() {
		for(int i = 0 ; i < count ; i++) {
			Employee emp = this.array[i];
			String empno = emp.getEmpno();  //A522
			String dname = this.getDname(empno.charAt(0)); 
			emp.setDname(dname);   //영업부 셋팅
			//String code = "" + empno.charAt(1);   // '5'  --> "5"
			char code = empno.charAt(1);   // '5'
			String codeStr = String.valueOf(code);   // "5"
			int codeInt = Integer.parseInt(codeStr);   // 5
			int hopay = this.getHopay(codeInt);  //호급수당
			emp.setHopay(hopay);     //호급수당 셋팅
			int nightpay = this.getNightpay(emp.getNight());   //야근수당
			emp.setNightpay(nightpay);    //야근수당 셋팅
			int base = emp.getBase();  //기본급
			int basePay = this.getBase(base);  //기본급수당
			int family = emp.getFamily();   //가족수
			int famPay = 7000 * family;
			emp.setFampay(famPay);   //가족수당 셋팅
			
			int total = hopay + basePay + nightpay + famPay;   //총금액
			emp.setTotal(total);     //총금액 셋팅
			
			int tax = (int)(hopay * 0.1);   //세금
			int salary = total - tax;  //실수령액
			emp.setSalary(salary);    //실수령액 셋팅
		}
	}

	private int getHopay(int code) {  //호급 수당 얻기 위한 메소드
		int [] hopays = {900000, 400000, 600000, 800000, 300000, 800000, 800000};
		return hopays[code-1];
	}
	
	private int getBase(int base) {  //기본급수당을 얻기 위한 메소드
		int [] bases = {15000, 25000, 35000, 45000};
		return bases[base-1];
	}
	
	private String getDname(char code) {  //부서코드로 부서명을 얻기 위한 메소드
		String [] dnames = {"영업부", "업무부", "홍보부", "인사부", "경리부", "판촉부", "총무부"};
		return dnames[code - 65];
	}
	
	private int getNightpay(int night) {
		return (night == 1) ? 1500 : 
						(night == 2) ? 2500 : 
							(night == 3) ? 3500 : 4500;
	}
}