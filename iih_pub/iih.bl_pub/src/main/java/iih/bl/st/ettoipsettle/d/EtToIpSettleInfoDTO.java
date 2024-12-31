package iih.bl.st.ettoipsettle.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊转住院结算信息 DTO数据 
 * 
 */
public class EtToIpSettleInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院就诊Id
	 * @return String
	 */
	public String getEntid() {
		return ((String) getAttrVal("Entid"));
	}
	/**
	 * 住院就诊Id
	 * @param Entid
	 */
	public void setEntid(String Entid) {
		setAttrVal("Entid", Entid);
	}
	/**
	 * 结算患者分类
	 * @return String
	 */
	public String getPatcaid() {
		return ((String) getAttrVal("Patcaid"));
	}
	/**
	 * 结算患者分类
	 * @param Patcaid
	 */
	public void setPatcaid(String Patcaid) {
		setAttrVal("Patcaid", Patcaid);
	}
	/**
	 * 患者医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 患者医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
}