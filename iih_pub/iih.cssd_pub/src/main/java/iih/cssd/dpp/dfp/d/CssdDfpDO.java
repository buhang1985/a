package iih.cssd.dpp.dfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfp.d.desc.CssdDfpDODesc;
import java.math.BigDecimal;

/**
 * 消毒包生产 DO数据 
 * 
 */
public class CssdDfpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包主键
	public static final String ID_DFP= "Id_dfp";
	//包主键
	public static final String ID_PKG= "Id_pkg";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//消毒包分类
	public static final String ID_PKG_CA= "Id_pkg_ca";
	//名称
	public static final String NAME= "Name";
	//识别码
	public static final String NO_BAR= "No_bar";
	//包类型id
	public static final String ID_PKGTP= "Id_pkgtp";
	//包类型sd
	public static final String SD_PKGTP= "Sd_pkgtp";
	//清洗类型id
	public static final String ID_PKGCLEAN= "Id_pkgclean";
	//清洗类型sd
	public static final String SD_PKGCLEAN= "Sd_pkgclean";
	//灭菌方式id
	public static final String ID_PKGSTZ= "Id_pkgstz";
	//灭菌方式sd
	public static final String SD_PKGSTZ= "Sd_pkgstz";
	//包装材料id
	public static final String ID_PKGMTR= "Id_pkgmtr";
	//包装材料sd
	public static final String SD_PKGMTR= "Sd_pkgmtr";
	//包规格
	public static final String SPEC= "Spec";
	//消毒包状态id
	public static final String ID_STATUS= "Id_status";
	//消毒包状态sd
	public static final String SD_STATUS= "Sd_status";
	//生效时间
	public static final String DT_EFFE= "Dt_effe";
	//失效时间
	public static final String DT_INVAL= "Dt_inval";
	//有效天数
	public static final String DAYS_EFFEC= "Days_effec";
	//数量
	public static final String NUM_DFP= "Num_dfp";
	//生产科室
	public static final String ID_DEP_PRD= "Id_dep_prd";
	//生产人
	public static final String ID_EMP_PRD= "Id_emp_prd";
	//生产时间
	public static final String DT_PRD= "Dt_prd";
	//包描述
	public static final String NOTE= "Note";
	//价格
	public static final String PRICE= "Price";
	//灭菌标记
	public static final String FG_SRLZ= "Fg_srlz";
	//灭菌科室
	public static final String ID_DEP_SRLZ= "Id_dep_srlz";
	//灭菌人
	public static final String ID_EMP_SRLZ= "Id_emp_srlz";
	//灭菌时间
	public static final String DT_SRLZ= "Dt_srlz";
	//科室接收标记
	public static final String FG_RCV= "Fg_rcv";
	//接收科室
	public static final String ID_DEP_RCV= "Id_dep_rcv";
	//接收人
	public static final String ID_EMP_RCV= "Id_emp_rcv";
	//接收时间
	public static final String DT_RCV= "Dt_rcv";
	//使用标记
	public static final String FG_USE= "Fg_use";
	//使用科室
	public static final String ID_DEP_USE= "Id_dep_use";
	//使用人
	public static final String ID_EMP_USE= "Id_emp_use";
	//使用时间
	public static final String DT_USE= "Dt_use";
	//使用患者
	public static final String ID_PAT= "Id_pat";
	//清洗标识
	public static final String FG_CLN= "Fg_cln";
	//清洗科室
	public static final String ID_DEP_CLN= "Id_dep_cln";
	//清洗人
	public static final String ID_EMP_CLN= "Id_emp_cln";
	//清洗时间
	public static final String DT_CLN= "Dt_cln";
	//储藏标记
	public static final String FG_STORE= "Fg_store";
	//储藏位置
	public static final String ID_INSTR= "Id_instr";
	//请领标记
	public static final String FG_APP= "Fg_app";
	//请领科室
	public static final String ID_DEP_APP= "Id_dep_app";
	//包重量
	public static final String EU_WEIGHT= "Eu_weight";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String PKG_NAME= "Pkg_name";
	//名称
	public static final String NAME_PKG_CA= "Name_pkg_ca";
	//消毒包类型
	public static final String NAME_PKGTP= "Name_pkgtp";
	//名称
	public static final String NAME_PKGCLEAN= "Name_pkgclean";
	//名称
	public static final String NAME_PKGSTZ= "Name_pkgstz";
	//名称
	public static final String NAME_PKGMTR= "Name_pkgmtr";
	//名称
	public static final String NAME_STATUS= "Name_status";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//姓名
	public static final String NAME_EMP_PRD= "Name_emp_prd";
	//灭菌科室名称
	public static final String NAME_DEP_SRLZ= "Name_dep_srlz";
	//灭菌人姓名
	public static final String NAME_EMP_SRLZ= "Name_emp_srlz";
	//接收科室名称
	public static final String NAME_DEP_RCV= "Name_dep_rcv";
	//接收人姓名
	public static final String NAME_EMP_RCV= "Name_emp_rcv";
	//使用科室名称
	public static final String NAME_DEP_USE= "Name_dep_use";
	//使用人姓名
	public static final String NAME_EMP_USE= "Name_emp_use";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//清洗科室名称
	public static final String NAME_DEP_CLN= "Name_dep_cln";
	//清洗人姓名
	public static final String NAME_EMP_CLN= "Name_emp_cln";
	//器械名称
	public static final String NAME_INSTR= "Name_instr";
	//器械编码
	public static final String CODE_INSTR= "Code_instr";
	//器械所属部门
	public static final String ID_DEP_INSTR= "Id_dep_instr";
	//请领科室名称
	public static final String NAME_DEP_APP= "Name_dep_app";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 包主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 包主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 消毒包分类
	 * @return String
	 */
	public String getId_pkg_ca() {
		return ((String) getAttrVal("Id_pkg_ca"));
	}	
	/**
	 * 消毒包分类
	 * @param Id_pkg_ca
	 */
	public void setId_pkg_ca(String Id_pkg_ca) {
		setAttrVal("Id_pkg_ca", Id_pkg_ca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 包类型id
	 * @return String
	 */
	public String getId_pkgtp() {
		return ((String) getAttrVal("Id_pkgtp"));
	}	
	/**
	 * 包类型id
	 * @param Id_pkgtp
	 */
	public void setId_pkgtp(String Id_pkgtp) {
		setAttrVal("Id_pkgtp", Id_pkgtp);
	}
	/**
	 * 包类型sd
	 * @return String
	 */
	public String getSd_pkgtp() {
		return ((String) getAttrVal("Sd_pkgtp"));
	}	
	/**
	 * 包类型sd
	 * @param Sd_pkgtp
	 */
	public void setSd_pkgtp(String Sd_pkgtp) {
		setAttrVal("Sd_pkgtp", Sd_pkgtp);
	}
	/**
	 * 清洗类型id
	 * @return String
	 */
	public String getId_pkgclean() {
		return ((String) getAttrVal("Id_pkgclean"));
	}	
	/**
	 * 清洗类型id
	 * @param Id_pkgclean
	 */
	public void setId_pkgclean(String Id_pkgclean) {
		setAttrVal("Id_pkgclean", Id_pkgclean);
	}
	/**
	 * 清洗类型sd
	 * @return String
	 */
	public String getSd_pkgclean() {
		return ((String) getAttrVal("Sd_pkgclean"));
	}	
	/**
	 * 清洗类型sd
	 * @param Sd_pkgclean
	 */
	public void setSd_pkgclean(String Sd_pkgclean) {
		setAttrVal("Sd_pkgclean", Sd_pkgclean);
	}
	/**
	 * 灭菌方式id
	 * @return String
	 */
	public String getId_pkgstz() {
		return ((String) getAttrVal("Id_pkgstz"));
	}	
	/**
	 * 灭菌方式id
	 * @param Id_pkgstz
	 */
	public void setId_pkgstz(String Id_pkgstz) {
		setAttrVal("Id_pkgstz", Id_pkgstz);
	}
	/**
	 * 灭菌方式sd
	 * @return String
	 */
	public String getSd_pkgstz() {
		return ((String) getAttrVal("Sd_pkgstz"));
	}	
	/**
	 * 灭菌方式sd
	 * @param Sd_pkgstz
	 */
	public void setSd_pkgstz(String Sd_pkgstz) {
		setAttrVal("Sd_pkgstz", Sd_pkgstz);
	}
	/**
	 * 包装材料id
	 * @return String
	 */
	public String getId_pkgmtr() {
		return ((String) getAttrVal("Id_pkgmtr"));
	}	
	/**
	 * 包装材料id
	 * @param Id_pkgmtr
	 */
	public void setId_pkgmtr(String Id_pkgmtr) {
		setAttrVal("Id_pkgmtr", Id_pkgmtr);
	}
	/**
	 * 包装材料sd
	 * @return String
	 */
	public String getSd_pkgmtr() {
		return ((String) getAttrVal("Sd_pkgmtr"));
	}	
	/**
	 * 包装材料sd
	 * @param Sd_pkgmtr
	 */
	public void setSd_pkgmtr(String Sd_pkgmtr) {
		setAttrVal("Sd_pkgmtr", Sd_pkgmtr);
	}
	/**
	 * 包规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 包规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 消毒包状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 消毒包状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 消毒包状态sd
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 消毒包状态sd
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 失效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_inval() {
		return ((FDateTime) getAttrVal("Dt_inval"));
	}	
	/**
	 * 失效时间
	 * @param Dt_inval
	 */
	public void setDt_inval(FDateTime Dt_inval) {
		setAttrVal("Dt_inval", Dt_inval);
	}
	/**
	 * 有效天数
	 * @return Integer
	 */
	public Integer getDays_effec() {
		return ((Integer) getAttrVal("Days_effec"));
	}	
	/**
	 * 有效天数
	 * @param Days_effec
	 */
	public void setDays_effec(Integer Days_effec) {
		setAttrVal("Days_effec", Days_effec);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getNum_dfp() {
		return ((Integer) getAttrVal("Num_dfp"));
	}	
	/**
	 * 数量
	 * @param Num_dfp
	 */
	public void setNum_dfp(Integer Num_dfp) {
		setAttrVal("Num_dfp", Num_dfp);
	}
	/**
	 * 生产科室
	 * @return String
	 */
	public String getId_dep_prd() {
		return ((String) getAttrVal("Id_dep_prd"));
	}	
	/**
	 * 生产科室
	 * @param Id_dep_prd
	 */
	public void setId_dep_prd(String Id_dep_prd) {
		setAttrVal("Id_dep_prd", Id_dep_prd);
	}
	/**
	 * 生产人
	 * @return String
	 */
	public String getId_emp_prd() {
		return ((String) getAttrVal("Id_emp_prd"));
	}	
	/**
	 * 生产人
	 * @param Id_emp_prd
	 */
	public void setId_emp_prd(String Id_emp_prd) {
		setAttrVal("Id_emp_prd", Id_emp_prd);
	}
	/**
	 * 生产时间
	 * @return FDateTime
	 */
	public FDateTime getDt_prd() {
		return ((FDateTime) getAttrVal("Dt_prd"));
	}	
	/**
	 * 生产时间
	 * @param Dt_prd
	 */
	public void setDt_prd(FDateTime Dt_prd) {
		setAttrVal("Dt_prd", Dt_prd);
	}
	/**
	 * 包描述
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 包描述
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 灭菌标记
	 * @return FBoolean
	 */
	public FBoolean getFg_srlz() {
		return ((FBoolean) getAttrVal("Fg_srlz"));
	}	
	/**
	 * 灭菌标记
	 * @param Fg_srlz
	 */
	public void setFg_srlz(FBoolean Fg_srlz) {
		setAttrVal("Fg_srlz", Fg_srlz);
	}
	/**
	 * 灭菌科室
	 * @return String
	 */
	public String getId_dep_srlz() {
		return ((String) getAttrVal("Id_dep_srlz"));
	}	
	/**
	 * 灭菌科室
	 * @param Id_dep_srlz
	 */
	public void setId_dep_srlz(String Id_dep_srlz) {
		setAttrVal("Id_dep_srlz", Id_dep_srlz);
	}
	/**
	 * 灭菌人
	 * @return String
	 */
	public String getId_emp_srlz() {
		return ((String) getAttrVal("Id_emp_srlz"));
	}	
	/**
	 * 灭菌人
	 * @param Id_emp_srlz
	 */
	public void setId_emp_srlz(String Id_emp_srlz) {
		setAttrVal("Id_emp_srlz", Id_emp_srlz);
	}
	/**
	 * 灭菌时间
	 * @return FDateTime
	 */
	public FDateTime getDt_srlz() {
		return ((FDateTime) getAttrVal("Dt_srlz"));
	}	
	/**
	 * 灭菌时间
	 * @param Dt_srlz
	 */
	public void setDt_srlz(FDateTime Dt_srlz) {
		setAttrVal("Dt_srlz", Dt_srlz);
	}
	/**
	 * 科室接收标记
	 * @return FBoolean
	 */
	public FBoolean getFg_rcv() {
		return ((FBoolean) getAttrVal("Fg_rcv"));
	}	
	/**
	 * 科室接收标记
	 * @param Fg_rcv
	 */
	public void setFg_rcv(FBoolean Fg_rcv) {
		setAttrVal("Fg_rcv", Fg_rcv);
	}
	/**
	 * 接收科室
	 * @return String
	 */
	public String getId_dep_rcv() {
		return ((String) getAttrVal("Id_dep_rcv"));
	}	
	/**
	 * 接收科室
	 * @param Id_dep_rcv
	 */
	public void setId_dep_rcv(String Id_dep_rcv) {
		setAttrVal("Id_dep_rcv", Id_dep_rcv);
	}
	/**
	 * 接收人
	 * @return String
	 */
	public String getId_emp_rcv() {
		return ((String) getAttrVal("Id_emp_rcv"));
	}	
	/**
	 * 接收人
	 * @param Id_emp_rcv
	 */
	public void setId_emp_rcv(String Id_emp_rcv) {
		setAttrVal("Id_emp_rcv", Id_emp_rcv);
	}
	/**
	 * 接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rcv() {
		return ((FDateTime) getAttrVal("Dt_rcv"));
	}	
	/**
	 * 接收时间
	 * @param Dt_rcv
	 */
	public void setDt_rcv(FDateTime Dt_rcv) {
		setAttrVal("Dt_rcv", Dt_rcv);
	}
	/**
	 * 使用标记
	 * @return FBoolean
	 */
	public FBoolean getFg_use() {
		return ((FBoolean) getAttrVal("Fg_use"));
	}	
	/**
	 * 使用标记
	 * @param Fg_use
	 */
	public void setFg_use(FBoolean Fg_use) {
		setAttrVal("Fg_use", Fg_use);
	}
	/**
	 * 使用科室
	 * @return String
	 */
	public String getId_dep_use() {
		return ((String) getAttrVal("Id_dep_use"));
	}	
	/**
	 * 使用科室
	 * @param Id_dep_use
	 */
	public void setId_dep_use(String Id_dep_use) {
		setAttrVal("Id_dep_use", Id_dep_use);
	}
	/**
	 * 使用人
	 * @return String
	 */
	public String getId_emp_use() {
		return ((String) getAttrVal("Id_emp_use"));
	}	
	/**
	 * 使用人
	 * @param Id_emp_use
	 */
	public void setId_emp_use(String Id_emp_use) {
		setAttrVal("Id_emp_use", Id_emp_use);
	}
	/**
	 * 使用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_use() {
		return ((FDateTime) getAttrVal("Dt_use"));
	}	
	/**
	 * 使用时间
	 * @param Dt_use
	 */
	public void setDt_use(FDateTime Dt_use) {
		setAttrVal("Dt_use", Dt_use);
	}
	/**
	 * 使用患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 使用患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 清洗标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cln() {
		return ((FBoolean) getAttrVal("Fg_cln"));
	}	
	/**
	 * 清洗标识
	 * @param Fg_cln
	 */
	public void setFg_cln(FBoolean Fg_cln) {
		setAttrVal("Fg_cln", Fg_cln);
	}
	/**
	 * 清洗科室
	 * @return String
	 */
	public String getId_dep_cln() {
		return ((String) getAttrVal("Id_dep_cln"));
	}	
	/**
	 * 清洗科室
	 * @param Id_dep_cln
	 */
	public void setId_dep_cln(String Id_dep_cln) {
		setAttrVal("Id_dep_cln", Id_dep_cln);
	}
	/**
	 * 清洗人
	 * @return String
	 */
	public String getId_emp_cln() {
		return ((String) getAttrVal("Id_emp_cln"));
	}	
	/**
	 * 清洗人
	 * @param Id_emp_cln
	 */
	public void setId_emp_cln(String Id_emp_cln) {
		setAttrVal("Id_emp_cln", Id_emp_cln);
	}
	/**
	 * 清洗时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cln() {
		return ((FDateTime) getAttrVal("Dt_cln"));
	}	
	/**
	 * 清洗时间
	 * @param Dt_cln
	 */
	public void setDt_cln(FDateTime Dt_cln) {
		setAttrVal("Dt_cln", Dt_cln);
	}
	/**
	 * 储藏标记
	 * @return FBoolean
	 */
	public FBoolean getFg_store() {
		return ((FBoolean) getAttrVal("Fg_store"));
	}	
	/**
	 * 储藏标记
	 * @param Fg_store
	 */
	public void setFg_store(FBoolean Fg_store) {
		setAttrVal("Fg_store", Fg_store);
	}
	/**
	 * 储藏位置
	 * @return String
	 */
	public String getId_instr() {
		return ((String) getAttrVal("Id_instr"));
	}	
	/**
	 * 储藏位置
	 * @param Id_instr
	 */
	public void setId_instr(String Id_instr) {
		setAttrVal("Id_instr", Id_instr);
	}
	/**
	 * 请领标记
	 * @return FBoolean
	 */
	public FBoolean getFg_app() {
		return ((FBoolean) getAttrVal("Fg_app"));
	}	
	/**
	 * 请领标记
	 * @param Fg_app
	 */
	public void setFg_app(FBoolean Fg_app) {
		setAttrVal("Fg_app", Fg_app);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}	
	/**
	 * 请领科室
	 * @param Id_dep_app
	 */
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
	/**
	 * 包重量
	 * @return Integer
	 */
	public Integer getEu_weight() {
		return ((Integer) getAttrVal("Eu_weight"));
	}	
	/**
	 * 包重量
	 * @param Eu_weight
	 */
	public void setEu_weight(Integer Eu_weight) {
		setAttrVal("Eu_weight", Eu_weight);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPkg_name() {
		return ((String) getAttrVal("Pkg_name"));
	}	
	/**
	 * 名称
	 * @param Pkg_name
	 */
	public void setPkg_name(String Pkg_name) {
		setAttrVal("Pkg_name", Pkg_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkg_ca() {
		return ((String) getAttrVal("Name_pkg_ca"));
	}	
	/**
	 * 名称
	 * @param Name_pkg_ca
	 */
	public void setName_pkg_ca(String Name_pkg_ca) {
		setAttrVal("Name_pkg_ca", Name_pkg_ca);
	}
	/**
	 * 消毒包类型
	 * @return String
	 */
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}	
	/**
	 * 消毒包类型
	 * @param Name_pkgtp
	 */
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkgclean() {
		return ((String) getAttrVal("Name_pkgclean"));
	}	
	/**
	 * 名称
	 * @param Name_pkgclean
	 */
	public void setName_pkgclean(String Name_pkgclean) {
		setAttrVal("Name_pkgclean", Name_pkgclean);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkgstz() {
		return ((String) getAttrVal("Name_pkgstz"));
	}	
	/**
	 * 名称
	 * @param Name_pkgstz
	 */
	public void setName_pkgstz(String Name_pkgstz) {
		setAttrVal("Name_pkgstz", Name_pkgstz);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkgmtr() {
		return ((String) getAttrVal("Name_pkgmtr"));
	}	
	/**
	 * 名称
	 * @param Name_pkgmtr
	 */
	public void setName_pkgmtr(String Name_pkgmtr) {
		setAttrVal("Name_pkgmtr", Name_pkgmtr);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	/**
	 * 名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_prd() {
		return ((String) getAttrVal("Name_emp_prd"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_prd
	 */
	public void setName_emp_prd(String Name_emp_prd) {
		setAttrVal("Name_emp_prd", Name_emp_prd);
	}
	/**
	 * 灭菌科室名称
	 * @return String
	 */
	public String getName_dep_srlz() {
		return ((String) getAttrVal("Name_dep_srlz"));
	}	
	/**
	 * 灭菌科室名称
	 * @param Name_dep_srlz
	 */
	public void setName_dep_srlz(String Name_dep_srlz) {
		setAttrVal("Name_dep_srlz", Name_dep_srlz);
	}
	/**
	 * 灭菌人姓名
	 * @return String
	 */
	public String getName_emp_srlz() {
		return ((String) getAttrVal("Name_emp_srlz"));
	}	
	/**
	 * 灭菌人姓名
	 * @param Name_emp_srlz
	 */
	public void setName_emp_srlz(String Name_emp_srlz) {
		setAttrVal("Name_emp_srlz", Name_emp_srlz);
	}
	/**
	 * 接收科室名称
	 * @return String
	 */
	public String getName_dep_rcv() {
		return ((String) getAttrVal("Name_dep_rcv"));
	}	
	/**
	 * 接收科室名称
	 * @param Name_dep_rcv
	 */
	public void setName_dep_rcv(String Name_dep_rcv) {
		setAttrVal("Name_dep_rcv", Name_dep_rcv);
	}
	/**
	 * 接收人姓名
	 * @return String
	 */
	public String getName_emp_rcv() {
		return ((String) getAttrVal("Name_emp_rcv"));
	}	
	/**
	 * 接收人姓名
	 * @param Name_emp_rcv
	 */
	public void setName_emp_rcv(String Name_emp_rcv) {
		setAttrVal("Name_emp_rcv", Name_emp_rcv);
	}
	/**
	 * 使用科室名称
	 * @return String
	 */
	public String getName_dep_use() {
		return ((String) getAttrVal("Name_dep_use"));
	}	
	/**
	 * 使用科室名称
	 * @param Name_dep_use
	 */
	public void setName_dep_use(String Name_dep_use) {
		setAttrVal("Name_dep_use", Name_dep_use);
	}
	/**
	 * 使用人姓名
	 * @return String
	 */
	public String getName_emp_use() {
		return ((String) getAttrVal("Name_emp_use"));
	}	
	/**
	 * 使用人姓名
	 * @param Name_emp_use
	 */
	public void setName_emp_use(String Name_emp_use) {
		setAttrVal("Name_emp_use", Name_emp_use);
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
	 * 清洗科室名称
	 * @return String
	 */
	public String getName_dep_cln() {
		return ((String) getAttrVal("Name_dep_cln"));
	}	
	/**
	 * 清洗科室名称
	 * @param Name_dep_cln
	 */
	public void setName_dep_cln(String Name_dep_cln) {
		setAttrVal("Name_dep_cln", Name_dep_cln);
	}
	/**
	 * 清洗人姓名
	 * @return String
	 */
	public String getName_emp_cln() {
		return ((String) getAttrVal("Name_emp_cln"));
	}	
	/**
	 * 清洗人姓名
	 * @param Name_emp_cln
	 */
	public void setName_emp_cln(String Name_emp_cln) {
		setAttrVal("Name_emp_cln", Name_emp_cln);
	}
	/**
	 * 器械名称
	 * @return String
	 */
	public String getName_instr() {
		return ((String) getAttrVal("Name_instr"));
	}	
	/**
	 * 器械名称
	 * @param Name_instr
	 */
	public void setName_instr(String Name_instr) {
		setAttrVal("Name_instr", Name_instr);
	}
	/**
	 * 器械编码
	 * @return String
	 */
	public String getCode_instr() {
		return ((String) getAttrVal("Code_instr"));
	}	
	/**
	 * 器械编码
	 * @param Code_instr
	 */
	public void setCode_instr(String Code_instr) {
		setAttrVal("Code_instr", Code_instr);
	}
	/**
	 * 器械所属部门
	 * @return String
	 */
	public String getId_dep_instr() {
		return ((String) getAttrVal("Id_dep_instr"));
	}	
	/**
	 * 器械所属部门
	 * @param Id_dep_instr
	 */
	public void setId_dep_instr(String Id_dep_instr) {
		setAttrVal("Id_dep_instr", Id_dep_instr);
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

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_dfp";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdDfpDODesc.class);
	}
	
}