package RestAssurePojoClasses;

public class createProject {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
public createProject(String createdBy,String projectName,String status,int teamSize) {
	this.createdBy=createdBy;
	this.projectName=projectName;
	this.status=status;
	this.teamSize=teamSize;	
}
//EmptyConstructor
createProject(){
}

public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy=createdBy;
}

}
