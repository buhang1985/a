package test.qysh.demo;

/**
 * 报表简化信息JavaBean
 * 
 * @author qi_yongsheng
 */
public class ReportInfoDTO {
	private String name;
	private String reportPath;
	private String sv;
	
	public ReportInfoDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}
}
