package pojoClass;

public class Employee {
	
	String empName;
	String empId;
	int empNumber;
	String empmail;
	
	//Constructor for Intilization
	public  Employee(String empName,String empId,int empNumber,String empmail)
	{
		this.empName=empName;
		this.empId=empId;
		this.empNumber=empNumber;
		this.empmail=empmail;
	}
	
	//Constructor Calling
	Employee()
	{
		
	}
	
	//Utilization
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpmail() {
		return empmail;
	}
	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}

}
