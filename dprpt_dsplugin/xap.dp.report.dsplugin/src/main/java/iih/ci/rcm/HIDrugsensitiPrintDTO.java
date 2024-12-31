package iih.ci.rcm;

public class HIDrugsensitiPrintDTO {
	private String name_samplename;// 样本名称
	private String submission_date;// 送检日期
	private String name_test_method;// 检验方法
	private String name_pathogen_species;// 病原体种类
	private String name_spe_test_result;// 标本检验结果
	private String drug_sen_test;// 病原菌抗生素药敏实验
	private String drug_sen_result;// 病原菌抗生素药敏结果
	private String name_infe_site;// 感染部位
	private String qtname;

	public String getName_samplename() {
		return name_samplename;
	}

	public void setName_samplename(String name_samplename) {
		this.name_samplename = name_samplename;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public String getName_test_method() {
		return name_test_method;
	}

	public void setName_test_method(String name_test_method) {
		this.name_test_method = name_test_method;
	}

	public String getName_pathogen_species() {
		return name_pathogen_species;
	}

	public void setName_pathogen_species(String name_pathogen_species) {
		this.name_pathogen_species = name_pathogen_species;
	}

	public String getName_spe_test_result() {
		return name_spe_test_result;
	}

	public void setName_spe_test_result(String name_spe_test_result) {
		this.name_spe_test_result = name_spe_test_result;
	}

	public String getDrug_sen_test() {
		return drug_sen_test;
	}

	public void setDrug_sen_test(String drug_sen_test) {
		this.drug_sen_test = drug_sen_test;
	}

	public String getDrug_sen_result() {
		return drug_sen_result;
	}

	public void setDrug_sen_result(String drug_sen_result) {
		this.drug_sen_result = drug_sen_result;
	}

	public String getName_infe_site() {
		return name_infe_site;
	}

	public void setName_infe_site(String name_infe_site) {
		this.name_infe_site = name_infe_site;
	}

	public String getQtname() {
		return qtname;
	}

	public void setQtname(String qtname) {
		this.qtname = qtname;
	}

}
