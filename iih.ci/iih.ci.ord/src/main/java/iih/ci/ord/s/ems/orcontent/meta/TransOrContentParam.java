package iih.ci.ord.s.ems.orcontent.meta;

public class TransOrContentParam extends BaseOrContentParam {
	/**
	 * 目标科室
	 * @return String
	 */
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}
	/**
	 * 目标科室
	 * @param Name_dep_to
	 */
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	/**
	 * 目标病区
	 * @return String
	 */
	public String getName_dep_nur_to() {
		return ((String) getAttrVal("Name_dep_nur_to"));
	}
	/**
	 * 目标病区
	 * @param Id_dep_nur_to
	 */
	public void setName_dep_nur_to(String Name_dep_nur_to) {
		setAttrVal("Name_dep_nur_to", Name_dep_nur_to);
	}

}
