package iih.cssd.dpp.dto.dfpbatch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 批量新增消毒包dto DTO数据 
 * 
 */
public class DfpBatchAddDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 包名称
	 * @return String
	 */
	public String getName_dfp() {
		return ((String) getAttrVal("Name_dfp"));
	}
	/**
	 * 包名称
	 * @param Name_dfp
	 */
	public void setName_dfp(String Name_dfp) {
		setAttrVal("Name_dfp", Name_dfp);
	}
	/**
	 * 包定义ID
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}
	/**
	 * 包定义ID
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 包定义
	 * @return String
	 */
	public String getName_pkg() {
		return ((String) getAttrVal("Name_pkg"));
	}
	/**
	 * 包定义
	 * @param Name_pkg
	 */
	public void setName_pkg(String Name_pkg) {
		setAttrVal("Name_pkg", Name_pkg);
	}
	/**
	 * 包类型
	 * @return String
	 */
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}
	/**
	 * 包类型
	 * @param Name_pkgtp
	 */
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
	}
	/**
	 * 包分类
	 * @return String
	 */
	public String getName_dfp_ca() {
		return ((String) getAttrVal("Name_dfp_ca"));
	}
	/**
	 * 包分类
	 * @param Name_dfp_ca
	 */
	public void setName_dfp_ca(String Name_dfp_ca) {
		setAttrVal("Name_dfp_ca", Name_dfp_ca);
	}
	/**
	 * 包数量
	 * @return Integer
	 */
	public Integer getNum() {
		return ((Integer) getAttrVal("Num"));
	}
	/**
	 * 包数量
	 * @param Num
	 */
	public void setNum(Integer Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 清洗类型
	 * @return String
	 */
	public String getName_cln_tp() {
		return ((String) getAttrVal("Name_cln_tp"));
	}
	/**
	 * 清洗类型
	 * @param Name_cln_tp
	 */
	public void setName_cln_tp(String Name_cln_tp) {
		setAttrVal("Name_cln_tp", Name_cln_tp);
	}
	/**
	 * 灭菌方式
	 * @return String
	 */
	public String getName_stz_tp() {
		return ((String) getAttrVal("Name_stz_tp"));
	}
	/**
	 * 灭菌方式
	 * @param Name_stz_tp
	 */
	public void setName_stz_tp(String Name_stz_tp) {
		setAttrVal("Name_stz_tp", Name_stz_tp);
	}
	/**
	 * 包装材料
	 * @return String
	 */
	public String getName_pkg_mtr() {
		return ((String) getAttrVal("Name_pkg_mtr"));
	}
	/**
	 * 包装材料
	 * @param Name_pkg_mtr
	 */
	public void setName_pkg_mtr(String Name_pkg_mtr) {
		setAttrVal("Name_pkg_mtr", Name_pkg_mtr);
	}
	/**
	 * 生产人
	 * @return String
	 */
	public String getName_emp_prd() {
		return ((String) getAttrVal("Name_emp_prd"));
	}
	/**
	 * 生产人
	 * @param Name_emp_prd
	 */
	public void setName_emp_prd(String Name_emp_prd) {
		setAttrVal("Name_emp_prd", Name_emp_prd);
	}
	/**
	 * 生产人ID
	 * @return String
	 */
	public String getId_emp_prd() {
		return ((String) getAttrVal("Id_emp_prd"));
	}
	/**
	 * 生产人ID
	 * @param Id_emp_prd
	 */
	public void setId_emp_prd(String Id_emp_prd) {
		setAttrVal("Id_emp_prd", Id_emp_prd);
	}
	/**
	 * 生产科室
	 * @return String
	 */
	public String getName_dep_pro() {
		return ((String) getAttrVal("Name_dep_pro"));
	}
	/**
	 * 生产科室
	 * @param Name_dep_pro
	 */
	public void setName_dep_pro(String Name_dep_pro) {
		setAttrVal("Name_dep_pro", Name_dep_pro);
	}
	/**
	 * 生产科室ID
	 * @return String
	 */
	public String getId_dep_pro() {
		return ((String) getAttrVal("Id_dep_pro"));
	}
	/**
	 * 生产科室ID
	 * @param Id_dep_pro
	 */
	public void setId_dep_pro(String Id_dep_pro) {
		setAttrVal("Id_dep_pro", Id_dep_pro);
	}
	/**
	 * 请领科室名称
	 * @return String
	 */
	public String getName_dep_app() {
		return ((String) getAttrVal("Name_dep_app"));
	}
	/**
	 * 请领科室名称
	 * @param Name_dep_app
	 */
	public void setName_dep_app(String Name_dep_app) {
		setAttrVal("Name_dep_app", Name_dep_app);
	}
	/**
	 * 请领单ID
	 * @return String
	 */
	public String getId_dfp_app() {
		return ((String) getAttrVal("Id_dfp_app"));
	}
	/**
	 * 请领单ID
	 * @param Id_dfp_app
	 */
	public void setId_dfp_app(String Id_dfp_app) {
		setAttrVal("Id_dfp_app", Id_dfp_app);
	}
	/**
	 * 清洗时间
	 * @return FDate
	 */
	public FDate getDt_cln() {
		return ((FDate) getAttrVal("Dt_cln"));
	}
	/**
	 * 清洗时间
	 * @param Dt_cln
	 */
	public void setDt_cln(FDate Dt_cln) {
		setAttrVal("Dt_cln", Dt_cln);
	}
	/**
	 * 午别
	 * @return Integer
	 */
	public Integer getEu_noon() {
		return ((Integer) getAttrVal("Eu_noon"));
	}
	/**
	 * 午别
	 * @param Eu_noon
	 */
	public void setEu_noon(Integer Eu_noon) {
		setAttrVal("Eu_noon", Eu_noon);
	}
	/**
	 * 消毒包清洗主键ID
	 * @return String
	 */
	public String getId_dfp_cln() {
		return ((String) getAttrVal("Id_dfp_cln"));
	}
	/**
	 * 消毒包清洗主键ID
	 * @param Id_dfp_cln
	 */
	public void setId_dfp_cln(String Id_dfp_cln) {
		setAttrVal("Id_dfp_cln", Id_dfp_cln);
	}
	/**
	 * 请领时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}
	/**
	 * 请领时间
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
}