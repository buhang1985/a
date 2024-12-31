package iih.mi.biz.common.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保金额分摊信息查询入参 DTO数据 
 * 
 */
public class MiPropInfoInDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 分摊id
	 * @return String
	 */
	public String getId_prop() {
		return ((String) getAttrVal("Id_prop"));
	}
	/**
	 * 分摊id
	 * @param Id_prop
	 */
	public void setId_prop(String Id_prop) {
		setAttrVal("Id_prop", Id_prop);
	}
	/**
	 * 应收id
	 * @return String
	 */
	public String getId_propar() {
		return ((String) getAttrVal("Id_propar"));
	}
	/**
	 * 应收id
	 * @param Id_propar
	 */
	public void setId_propar(String Id_propar) {
		setAttrVal("Id_propar", Id_propar);
	}
}