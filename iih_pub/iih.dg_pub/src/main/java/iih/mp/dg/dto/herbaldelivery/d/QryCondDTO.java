package iih.mp.dg.dto.herbaldelivery.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 草药配送查询条件 DTO数据 
 * 
 */
public class QryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCard_ent() {
		return ((String) getAttrVal("Card_ent"));
	}
	/**
	 * 就诊卡号
	 * @param Card_ent
	 */
	public void setCard_ent(String Card_ent) {
		setAttrVal("Card_ent", Card_ent);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 窗口
	 * @return String
	 */
	public String getName_pharm() {
		return ((String) getAttrVal("Name_pharm"));
	}
	/**
	 * 窗口
	 * @param Name_pharm
	 */
	public void setName_pharm(String Name_pharm) {
		setAttrVal("Name_pharm", Name_pharm);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立日期
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方号
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
}