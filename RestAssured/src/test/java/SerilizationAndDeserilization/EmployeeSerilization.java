package SerilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClass.Employee;

public class EmployeeSerilization {
	public static void main(String[] args) throws Throwable, Throwable, IOException {
		Employee emp = new Employee("Zabiulla", "TYSS1265", 991678543, "shaikzabiulla2305@gmail.com");
		ObjectMapper objectMap = new ObjectMapper();
		objectMap.writeValue(new File("./Employee.json"), emp);
	}

}
