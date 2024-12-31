package iih.bl.hp.cihpcheckdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;

import java.math.BigDecimal;
import java.util.List;


/**
 * 医保开单整体校验 DTO数据 
 * 
 */
public class CiHpCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者基本信息
	 * @return String
	 */
	public PatDO getPatdo() {
		return ((PatDO) getAttrVal("Patdo"));
	}
	/**
	 * 患者基本信息
	 * @param Patdo
	 */
	public void setPatdo(PatDO Patdo) {
		setAttrVal("Patdo", Patdo);
	}
	/**
	 * 就诊信息
	 * @return PatiVisitDO
	 */
	public PatiVisitDO getEntdo() {
		return ((PatiVisitDO) getAttrVal("Entdo"));
	}
	/**
	 * 就诊信息
	 * @param PatiVisitDO
	 */
	public void setEntdo(PatiVisitDO Entdo) {
		setAttrVal("Entdo", Entdo);
	}
	/**
	 * 医保计划
	 * @return EntHpDO
	 */
	public FArrayList2 getEnthpdo() {
		return ((FArrayList2) getAttrVal("Enthpdo"));
	}
	/**
	 * 医保计划
	 * @param Enthpdo
	 */
	public void setEnthpdo(FArrayList2 Enthpdo) {
		setAttrVal("Enthpdo", Enthpdo);
	}
	/**
	 * 诊断信息
	 * @return FArrayList
	 */
	public FArrayList2 getCi_di_itms() {
		return ((FArrayList2) getAttrVal("Ci_di_itms"));
	}
	/**
	 * 诊断信息
	 * @param Ci_di_itms
	 */
	public void setCi_di_itms(FArrayList2 Ci_di_itms) {
		setAttrVal("Ci_di_itms", Ci_di_itms);
	}
	/**
	 * 待提交医嘱集合
	 * @return FArrayList
	 */
	public FArrayList2 getSavecidto() {
		return ((FArrayList2) getAttrVal("Savecidto"));
	}
	/**
	 * 待提交医嘱集合
	 * @param Savecidto
	 */
	public void setSavecidto(FArrayList2 Savecidto) {
		setAttrVal("Savecidto", Savecidto);
	}
	/**
	 * N日医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getHistorycidto() {
		return ((FArrayList2) getAttrVal("Historycidto"));
	}
	/**
	 * N日医嘱集合
	 * @param Historycidto
	 */
	public void setHistorycidto(FArrayList2 Historycidto) {
		setAttrVal("Historycidto", Historycidto);
	}
	/**
	 * 提取天数
	 * @return Integer
	 */
	public Integer getQuerydays() {
		return ((Integer) getAttrVal("Querydays"));
	}
	/**
	 * 提取天数
	 * @param Querydays
	 */
	public void setQuerydays(Integer Querydays) {
		setAttrVal("Querydays", Querydays);
	}
	
	/**
	 * 医保计划无限制用量的药品名单ID_MM
	 * @param Id_mmLst
	 */
	public void setId_mmLst(List<String> Id_mmLst) {
		setAttrVal("Id_mmLst", Id_mmLst);
	}
	/**
	 * 医保计划无限制用量的药品名单ID_MM
	 * @return List<String>
	 */
	public List<String> getId_mmLst() {
		return ((List<String>) getAttrVal("Id_mmLst"));
	}
	
}