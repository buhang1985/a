package iih.ci.ord.s.ems.orcontent.meta;

public class LisOrContentParam extends BaseOrContentParam {

	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}	
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
}
