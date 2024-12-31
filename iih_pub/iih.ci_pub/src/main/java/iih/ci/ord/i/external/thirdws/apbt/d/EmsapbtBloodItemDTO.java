package iih.ci.ord.i.external.thirdws.apbt.d;

import xap.mw.core.data.BaseDTO;

public class EmsapbtBloodItemDTO  extends BaseDTO {
	
	/**
	 * 备血项目编码
	 * @return String
	 */
	public String getCode_srv_or() {
		return ((String) getAttrVal("Code_srv_or"));
	}
	/**
	 * 备血项目编码
	 * @param Code_srv_or
	 */
	public void setCode_srv_or(String code_srv_or) {
		setAttrVal("Code_srv_or", code_srv_or);
	}
	
	/**
	 * 备血项目名称
	 * @return String
	 */
	public String getName_srv_or() {
		return ((String) getAttrVal("Name_srv_or"));
	}
	/**
	 * 备血项目名称
	 * @param Name_srv_or
	 */
	public void setName_srv_or(String Name_srv_or) {
		setAttrVal("Name_srv_or", Name_srv_or);
	}
	
	/**
	 * 申请血量
	 * @return String
	 */
	public String getQuan_medu_bt() {
		return ((String) getAttrVal("Quan_medu_bt"));
	}
	/**
	 * 申请血量
	 * @param Quan_medu_bt
	 */
	public void setQuan_medu_bt(String Quan_medu_bt) {
		setAttrVal("Quan_medu_bt", Quan_medu_bt);
	}
	
	/**
	 * 申请血量单位
	 * @return String
	 */
	public String getCode_medu_bt() {
		return ((String) getAttrVal("Code_medu_bt"));
	}
	/**
	 * 申请血量单位
	 * @param Code_medu_bt
	 */
	public void setCode_medu_bt(String Code_medu_bt) {
		setAttrVal("Code_medu_bt", Code_medu_bt);
	}

}
