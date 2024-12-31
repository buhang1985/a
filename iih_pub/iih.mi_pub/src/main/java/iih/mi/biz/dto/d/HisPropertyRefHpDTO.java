package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分摊数据保存 DTO数据 
 * 
 */
public class HisPropertyRefHpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * his业务主键关联医保应收
	 * @return String
	 */
	public String getId_ref() {
		return ((String) getAttrVal("Id_ref"));
	}
	/**
	 * his业务主键关联医保应收
	 * @param Id_ref
	 */
	public void setId_ref(String Id_ref) {
		setAttrVal("Id_ref", Id_ref);
	}
	/**
	 * his业务主键关联医保分摊
	 * @return String
	 */
	public String getId_ref_prop() {
		return ((String) getAttrVal("Id_ref_prop"));
	}
	/**
	 * his业务主键关联医保分摊
	 * @param Id_ref_prop
	 */
	public void setId_ref_prop(String Id_ref_prop) {
		setAttrVal("Id_ref_prop", Id_ref_prop);
	}
	/**
	 * his业务主键关联医保分应收记录
	 * @return String
	 */
	public String getId_refold() {
		return ((String) getAttrVal("Id_refold"));
	}
	/**
	 * his业务主键关联医保分应收记录
	 * @param Id_refold
	 */
	public void setId_refold(String Id_refold) {
		setAttrVal("Id_refold", Id_refold);
	}
	/**
	 * his业务主键关联医保分分摊记录
	 * @return String
	 */
	public String getId_refold_prop() {
		return ((String) getAttrVal("Id_refold_prop"));
	}
	/**
	 * his业务主键关联医保分分摊记录
	 * @param Id_refold_prop
	 */
	public void setId_refold_prop(String Id_refold_prop) {
		setAttrVal("Id_refold_prop", Id_refold_prop);
	}
	/**
	 * 前置流程下的医保分摊结果主键
	 * @return String
	 */
	public String getId_ref_preflow() {
		return ((String) getAttrVal("Id_ref_preflow"));
	}
	/**
	 * 前置流程下的医保分摊结果主键
	 * @param Id_ref_preflow
	 */
	public void setId_ref_preflow(String Id_ref_preflow) {
		setAttrVal("Id_ref_preflow", Id_ref_preflow);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
}