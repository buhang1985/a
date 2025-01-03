package iih.ci.ord.i.meta;

import iih.ci.ord.i.common.b.BaseCiDTO;

public class OrderQryDTO extends BaseCiDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单主服务id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医疗单主服务id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

}
