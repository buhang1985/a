package iih.cssd.dpus.dfpapp.dto;

import java.util.List;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

/**
 * 消毒包请领单DTO DTO数据
 * 
 */
public class DfpusAppListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 请领主键
	 * 
	 * @return String
	 */
	public String getId_dfp_app() {
		return ((String) getAttrVal("Id_dfp_app"));
	}

	/**
	 * 请领主键
	 * 
	 * @param Id_dfp_app
	 */
	public void setId_dfp_app(String Id_dfp_app) {
		setAttrVal("Id_dfp_app", Id_dfp_app);
	}

	/**
	 * 请领单号
	 * 
	 * @return String
	 */
	public String getDraw_no() {
		return ((String) getAttrVal("Draw_no"));
	}

	/**
	 * 请领单号
	 * 
	 * @param Draw_no
	 */
	public void setDraw_no(String Draw_no) {
		setAttrVal("Draw_no", Draw_no);
	}

	/**
	 * 请领科室
	 * 
	 * @return String
	 */
	public String getName_acc_dep() {
		return ((String) getAttrVal("Name_acc_dep"));
	}

	/**
	 * 请领科室
	 * 
	 * @param Name_acc_dep
	 */
	public void setName_acc_dep(String Name_acc_dep) {
		setAttrVal("Name_acc_dep", Name_acc_dep);
	}

	/**
	 * 请领人
	 * 
	 * @return String
	 */
	public String getName_acc_emp() {
		return ((String) getAttrVal("Name_acc_emp"));
	}

	/**
	 * 请领人
	 * 
	 * @param Name_acc_emp
	 */
	public void setName_acc_emp(String Name_acc_emp) {
		setAttrVal("Name_acc_emp", Name_acc_emp);
	}

	/**
	 * 请领时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_acc() {
		return ((FDateTime) getAttrVal("Dt_acc"));
	}

	/**
	 * 请领时间
	 * 
	 * @param Dt_acc
	 */
	public void setDt_acc(FDateTime Dt_acc) {
		setAttrVal("Dt_acc", Dt_acc);
	}

	/**
	 * 审核人
	 * 
	 * @return String
	 */
	public String getName_chk_emp() {
		return ((String) getAttrVal("Name_chk_emp"));
	}

	/**
	 * 审核人
	 * 
	 * @param Name_chk_emp
	 */
	public void setName_chk_emp(String Name_chk_emp) {
		setAttrVal("Name_chk_emp", Name_chk_emp);
	}

	/**
	 * 审核时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}

	/**
	 * 审核时间
	 * 
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}

	/**
	 * 申请定义包
	 * 
	 * @return String
	 */
	public String getName_app_pkg() {
		return ((String) getAttrVal("Name_app_pkg"));
	}

	/**
	 * 申请定义包
	 * 
	 * @param Name_app_pkg
	 */
	public void setName_app_pkg(String Name_app_pkg) {
		setAttrVal("Name_app_pkg", Name_app_pkg);
	}

	/**
	 * 申请数量
	 * 
	 * @return Integer
	 */
	public Integer getApp_num() {
		return ((Integer) getAttrVal("App_num"));
	}

	/**
	 * 申请数量
	 * 
	 * @param App_num
	 */
	public void setApp_num(Integer App_num) {
		setAttrVal("App_num", App_num);
	}

	/**
	 * 包类型
	 * 
	 * @return String
	 */
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}

	/**
	 * 包类型
	 * 
	 * @param Name_pkgtp
	 */
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
	}

	/**
	 * 清洗类型
	 * 
	 * @return String
	 */
	public String getName_pkgclean() {
		return ((String) getAttrVal("Name_pkgclean"));
	}

	/**
	 * 清洗类型
	 * 
	 * @param Name_pkgclean
	 */
	public void setName_pkgclean(String Name_pkgclean) {
		setAttrVal("Name_pkgclean", Name_pkgclean);
	}

	/**
	 * 灭菌方式
	 * 
	 * @return String
	 */
	public String getName_pkgstz() {
		return ((String) getAttrVal("Name_pkgstz"));
	}

	/**
	 * 灭菌方式
	 * 
	 * @param Name_pkgstz
	 */
	public void setName_pkgstz(String Name_pkgstz) {
		setAttrVal("Name_pkgstz", Name_pkgstz);
	}

	/**
	 * 包装材料
	 * 
	 * @return String
	 */
	public String getName_pkgmtr() {
		return ((String) getAttrVal("Name_pkgmtr"));
	}

	/**
	 * 包装材料
	 * 
	 * @param Name_pkgmtr
	 */
	public void setName_pkgmtr(String Name_pkgmtr) {
		setAttrVal("Name_pkgmtr", Name_pkgmtr);
	}

	/**
	 * 包规格
	 * 
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}

	/**
	 * 包规格
	 * 
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}

	/**
	 * 有效天数
	 * 
	 * @return Integer
	 */
	public Integer getDays_effec() {
		return ((Integer) getAttrVal("Days_effec"));
	}

	/**
	 * 有效天数
	 * 
	 * @param Days_effec
	 */
	public void setDays_effec(Integer Days_effec) {
		setAttrVal("Days_effec", Days_effec);
	}

	/**
	 * 请领消毒包子项集合
	 * 
	 * @return String
	 */
	public List<DfpusAppListDTO> getDfp_app_itms() {
		return ((List<DfpusAppListDTO>) getAttrVal("Dfp_app_itms"));
	}

	/**
	 * 请领消毒包子项集合
	 * 
	 * @param Dfp_app_itms
	 */
	public void setDfp_app_itms(List<DfpusAppListDTO> Dfp_app_itms) {
		setAttrVal("Dfp_app_itms", Dfp_app_itms);
	}
}