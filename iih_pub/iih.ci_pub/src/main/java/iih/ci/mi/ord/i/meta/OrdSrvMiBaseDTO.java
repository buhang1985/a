package iih.ci.mi.ord.i.meta;

import iih.ci.mi.basic.MiBaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

public class OrdSrvMiBaseDTO extends MiBaseDTO{

	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}

	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}

	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}

	/**
	 * 病种id
	 * @return String
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}
	/**
	 * 病种id
	 * @param Id_dsdef
	 */
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	
	/**
	 * 病种编码
	 * @return String
	 */
	public String getCode_dsdef() {
		return ((String) getAttrVal("Code_dsdef"));
	}
	/**
	 * 病种编码
	 * @param Code_dsdef
	 */
	public void setCode_dsdef(String Code_dsdef) {
		setAttrVal("Code_dsdef", Code_dsdef);
	}

	/**
	 * 病种名称
	 * @return String
	 */
	public String getName_dsdef() {
		return ((String) getAttrVal("Name_dsdef"));
	}
	/**
	 * 病种名称
	 * @param Name_dsdef
	 */
	public void setName_dsdef(String Name_dsdef) {
		setAttrVal("Name_dsdef", Name_dsdef);
	}
	
	/**
	 * 诊断列表
	 * @return String
	 */
	public FArrayList getCi_di_itms() {
		return ((FArrayList) getAttrVal("Ci_di_itms"));
	}
	/**
	 * 诊断列表
	 * @param Ci_di_itms
	 */
	public void setCi_di_itms(FArrayList Ci_di_itms) {
		setAttrVal("Ci_di_itms", Ci_di_itms);
	}

	/**
	 * 医嘱医保判断结果
	 * @return String
	 */
	public String getEu_orhp() {
		return ((String) getAttrVal("Eu_orhp"));
	}
	/**
	 * 医嘱医保判断结果
	 * @param Eu_orhp
	 */
	public void setEu_orhp(String Eu_orhp) {
		setAttrVal("Eu_orhp", Eu_orhp);
	}

	/**
	 * 服务项目临床医保适应症判定方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}
	/**
	 * 服务项目临床医保适应症判定方式
	 * @param Eu_hpjudge
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}

	/**
	 * 服务项目医保判断结果
	 * @return String
	 */
	public String getEu_orsrvhp() {
		return ((String) getAttrVal("Eu_orsrvhp"));
	}
	/**
	 * 服务项目医保判断结果
	 * @param Eu_orsrvhp
	 */
	public void setEu_orsrvhp(String Eu_orsrvhp) {
		setAttrVal("Eu_orsrvhp", Eu_orsrvhp);
	}
	
	/**
	 * 服务价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 服务价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
}
