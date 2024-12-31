package test.rptbean;

public class MedicalExamProblem {
	// 体检项目名称
	private String itemName;
	// 问题描述
	private String problemDesc;
	
	public MedicalExamProblem() {
		
	}
	
	public MedicalExamProblem(String itemName, String problemDesc) {
		this.itemName = itemName;
		this.problemDesc = problemDesc;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	
	
}
