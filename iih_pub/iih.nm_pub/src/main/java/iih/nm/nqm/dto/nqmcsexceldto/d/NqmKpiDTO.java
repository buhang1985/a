package iih.nm.nqm.dto.nqmcsexceldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查指标DTO DTO数据 
 * 
 */
public class NqmKpiDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检查指标id
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}
	/**
	 * 检查指标id
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 检查标准id
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}
	/**
	 * 检查标准id
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 上级指标
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 上级指标
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 指标名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 指标编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 指标编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 指标分值
	 * @return FDouble
	 */
	public FDouble getValue() {
		return ((FDouble) getAttrVal("Value"));
	}
	/**
	 * 指标分值
	 * @param Value
	 */
	public void setValue(FDouble Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 指标权重
	 * @return String
	 */
	public String getWi() {
		return ((String) getAttrVal("Wi"));
	}
	/**
	 * 指标权重
	 * @param Wi
	 */
	public void setWi(String Wi) {
		setAttrVal("Wi", Wi);
	}
	/**
	 * 问题系数
	 * @return FDouble
	 */
	public FDouble getIssuefactor() {
		return ((FDouble) getAttrVal("Issuefactor"));
	}
	/**
	 * 问题系数
	 * @param Issuefactor
	 */
	public void setIssuefactor(FDouble Issuefactor) {
		setAttrVal("Issuefactor", Issuefactor);
	}
	/**
	 * 检查对象编码
	 * @return String
	 */
	public String getSd_chk_obj() {
		return ((String) getAttrVal("Sd_chk_obj"));
	}
	/**
	 * 检查对象编码
	 * @param Sd_chk_obj
	 */
	public void setSd_chk_obj(String Sd_chk_obj) {
		setAttrVal("Sd_chk_obj", Sd_chk_obj);
	}
	/**
	 * 评分规则
	 * @return String
	 */
	public String getScor_rule() {
		return ((String) getAttrVal("Scor_rule"));
	}
	/**
	 * 评分规则
	 * @param Scor_rule
	 */
	public void setScor_rule(String Scor_rule) {
		setAttrVal("Scor_rule", Scor_rule);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 指标评分项目集合
	 * @return FArrayList
	 */
	public FArrayList getList() {
		return ((FArrayList) getAttrVal("List"));
	}
	/**
	 * 指标评分项目集合
	 * @param List
	 */
	public void setList(FArrayList List) {
		setAttrVal("List", List);
	}
}