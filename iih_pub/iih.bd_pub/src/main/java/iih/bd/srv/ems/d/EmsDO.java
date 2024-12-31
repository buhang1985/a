package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ems.d.desc.EmsDODesc;
import java.math.BigDecimal;

/**
 * 医疗单注册 DO数据 
 * 
 */
public class EmsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗单主键标识
	public static final String ID_SRVOF= "Id_srvof";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医疗单编码
	public static final String CODE= "Code";
	//医疗单名称
	public static final String NAME= "Name";
	//功能类名字串
	public static final String FUNCLASSSTR= "Funclassstr";
	//适用范围
	public static final String ID_SRVORRT= "Id_srvorrt";
	//适用范围编码
	public static final String SD_SRVORRT= "Sd_srvorrt";
	//适用科室
	public static final String ID_DEPT= "Id_dept";
	//可使用标识_门诊
	public static final String FG_ENTP_OP= "Fg_entp_op";
	//可使用标识_住院
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	//可使用标识_预住院
	public static final String FG_ENTP_PIP= "Fg_entp_pip";
	//可使用标识_急诊流水
	public static final String FG_ENTP_ER= "Fg_entp_er";
	//可使用标识_急诊抢救
	public static final String FG_ENTP_ER1= "Fg_entp_er1";
	//可使用标识_急诊留观
	public static final String FG_ENTP_ER2= "Fg_entp_er2";
	//可使用标识_体检
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	//可使用标识_家床
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	//指标跨就诊标识
	public static final String FG_DYNCITM_CROSSENTP= "Fg_dyncitm_crossentp";
	//指标周期下数值
	public static final String CNT_DYNCITMUNIT= "Cnt_dyncitmunit";
	//指标周期类型
	public static final String EU_DYNCITMUNIT= "Eu_dyncitmunit";
	//指标取值方式
	public static final String EU_DYNCITM_MODE= "Eu_dyncitm_mode";
	//系统标识
	public static final String FG_SYS= "Fg_sys";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//有效时间
	public static final String DT_EFFE= "Dt_effe";
	//失效时间
	public static final String DT_END= "Dt_end";
	//版本
	public static final String DES_VER= "Des_ver";
	//显示名称
	public static final String NAME_SHOW= "Name_show";
	//应用模式
	public static final String EU_EMSAPPMODE= "Eu_emsappmode";
	//动态指标标识
	public static final String FG_OFDYNCITM= "Fg_ofdyncitm";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医疗单分类
	public static final String ID_SRVOFCA= "Id_srvofca";
	//含客户自定义项字段
	public static final String FG_CLIEXTFLDS= "Fg_cliextflds";
	//简化的流程标识
	public static final String FG_QUICKWFLOW= "Fg_quickwflow";
	//名称
	public static final String SRVOR_NAME= "Srvor_name";
	//名称
	public static final String DEPNAME= "Depname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗单主键标识
	 * @return String
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	/**
	 * 医疗单主键标识
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医疗单编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 医疗单编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医疗单名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医疗单名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 功能类名字串
	 * @return String
	 */
	public String getFunclassstr() {
		return ((String) getAttrVal("Funclassstr"));
	}	
	/**
	 * 功能类名字串
	 * @param Funclassstr
	 */
	public void setFunclassstr(String Funclassstr) {
		setAttrVal("Funclassstr", Funclassstr);
	}
	/**
	 * 适用范围
	 * @return String
	 */
	public String getId_srvorrt() {
		return ((String) getAttrVal("Id_srvorrt"));
	}	
	/**
	 * 适用范围
	 * @param Id_srvorrt
	 */
	public void setId_srvorrt(String Id_srvorrt) {
		setAttrVal("Id_srvorrt", Id_srvorrt);
	}
	/**
	 * 适用范围编码
	 * @return String
	 */
	public String getSd_srvorrt() {
		return ((String) getAttrVal("Sd_srvorrt"));
	}	
	/**
	 * 适用范围编码
	 * @param Sd_srvorrt
	 */
	public void setSd_srvorrt(String Sd_srvorrt) {
		setAttrVal("Sd_srvorrt", Sd_srvorrt);
	}
	/**
	 * 适用科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 适用科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 可使用标识_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}	
	/**
	 * 可使用标识_门诊
	 * @param Fg_entp_op
	 */
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	/**
	 * 可使用标识_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	/**
	 * 可使用标识_住院
	 * @param Fg_entp_ip
	 */
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	/**
	 * 可使用标识_预住院
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_pip() {
		return ((FBoolean) getAttrVal("Fg_entp_pip"));
	}	
	/**
	 * 可使用标识_预住院
	 * @param Fg_entp_pip
	 */
	public void setFg_entp_pip(FBoolean Fg_entp_pip) {
		setAttrVal("Fg_entp_pip", Fg_entp_pip);
	}
	/**
	 * 可使用标识_急诊流水
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}	
	/**
	 * 可使用标识_急诊流水
	 * @param Fg_entp_er
	 */
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	/**
	 * 可使用标识_急诊抢救
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er1() {
		return ((FBoolean) getAttrVal("Fg_entp_er1"));
	}	
	/**
	 * 可使用标识_急诊抢救
	 * @param Fg_entp_er1
	 */
	public void setFg_entp_er1(FBoolean Fg_entp_er1) {
		setAttrVal("Fg_entp_er1", Fg_entp_er1);
	}
	/**
	 * 可使用标识_急诊留观
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er2() {
		return ((FBoolean) getAttrVal("Fg_entp_er2"));
	}	
	/**
	 * 可使用标识_急诊留观
	 * @param Fg_entp_er2
	 */
	public void setFg_entp_er2(FBoolean Fg_entp_er2) {
		setAttrVal("Fg_entp_er2", Fg_entp_er2);
	}
	/**
	 * 可使用标识_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	/**
	 * 可使用标识_体检
	 * @param Fg_entp_pe
	 */
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	/**
	 * 可使用标识_家床
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	/**
	 * 可使用标识_家床
	 * @param Fg_entp_fm
	 */
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	/**
	 * 指标跨就诊标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dyncitm_crossentp() {
		return ((FBoolean) getAttrVal("Fg_dyncitm_crossentp"));
	}	
	/**
	 * 指标跨就诊标识
	 * @param Fg_dyncitm_crossentp
	 */
	public void setFg_dyncitm_crossentp(FBoolean Fg_dyncitm_crossentp) {
		setAttrVal("Fg_dyncitm_crossentp", Fg_dyncitm_crossentp);
	}
	/**
	 * 指标周期下数值
	 * @return Integer
	 */
	public Integer getCnt_dyncitmunit() {
		return ((Integer) getAttrVal("Cnt_dyncitmunit"));
	}	
	/**
	 * 指标周期下数值
	 * @param Cnt_dyncitmunit
	 */
	public void setCnt_dyncitmunit(Integer Cnt_dyncitmunit) {
		setAttrVal("Cnt_dyncitmunit", Cnt_dyncitmunit);
	}
	/**
	 * 指标周期类型
	 * @return Integer
	 */
	public Integer getEu_dyncitmunit() {
		return ((Integer) getAttrVal("Eu_dyncitmunit"));
	}	
	/**
	 * 指标周期类型
	 * @param Eu_dyncitmunit
	 */
	public void setEu_dyncitmunit(Integer Eu_dyncitmunit) {
		setAttrVal("Eu_dyncitmunit", Eu_dyncitmunit);
	}
	/**
	 * 指标取值方式
	 * @return Integer
	 */
	public Integer getEu_dyncitm_mode() {
		return ((Integer) getAttrVal("Eu_dyncitm_mode"));
	}	
	/**
	 * 指标取值方式
	 * @param Eu_dyncitm_mode
	 */
	public void setEu_dyncitm_mode(Integer Eu_dyncitm_mode) {
		setAttrVal("Eu_dyncitm_mode", Eu_dyncitm_mode);
	}
	/**
	 * 系统标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标识
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 有效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 有效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 失效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 失效时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 版本
	 * @return String
	 */
	public String getDes_ver() {
		return ((String) getAttrVal("Des_ver"));
	}	
	/**
	 * 版本
	 * @param Des_ver
	 */
	public void setDes_ver(String Des_ver) {
		setAttrVal("Des_ver", Des_ver);
	}
	/**
	 * 显示名称
	 * @return String
	 */
	public String getName_show() {
		return ((String) getAttrVal("Name_show"));
	}	
	/**
	 * 显示名称
	 * @param Name_show
	 */
	public void setName_show(String Name_show) {
		setAttrVal("Name_show", Name_show);
	}
	/**
	 * 应用模式
	 * @return Integer
	 */
	public Integer getEu_emsappmode() {
		return ((Integer) getAttrVal("Eu_emsappmode"));
	}	
	/**
	 * 应用模式
	 * @param Eu_emsappmode
	 */
	public void setEu_emsappmode(Integer Eu_emsappmode) {
		setAttrVal("Eu_emsappmode", Eu_emsappmode);
	}
	/**
	 * 动态指标标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ofdyncitm() {
		return ((FBoolean) getAttrVal("Fg_ofdyncitm"));
	}	
	/**
	 * 动态指标标识
	 * @param Fg_ofdyncitm
	 */
	public void setFg_ofdyncitm(FBoolean Fg_ofdyncitm) {
		setAttrVal("Fg_ofdyncitm", Fg_ofdyncitm);
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
	 * 医疗单分类
	 * @return String
	 */
	public String getId_srvofca() {
		return ((String) getAttrVal("Id_srvofca"));
	}	
	/**
	 * 医疗单分类
	 * @param Id_srvofca
	 */
	public void setId_srvofca(String Id_srvofca) {
		setAttrVal("Id_srvofca", Id_srvofca);
	}
	/**
	 * 含客户自定义项字段
	 * @return FBoolean
	 */
	public FBoolean getFg_cliextflds() {
		return ((FBoolean) getAttrVal("Fg_cliextflds"));
	}	
	/**
	 * 含客户自定义项字段
	 * @param Fg_cliextflds
	 */
	public void setFg_cliextflds(FBoolean Fg_cliextflds) {
		setAttrVal("Fg_cliextflds", Fg_cliextflds);
	}
	/**
	 * 简化的流程标识
	 * @return FBoolean
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}	
	/**
	 * 简化的流程标识
	 * @param Fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvor_name() {
		return ((String) getAttrVal("Srvor_name"));
	}	
	/**
	 * 名称
	 * @param Srvor_name
	 */
	public void setSrvor_name(String Srvor_name) {
		setAttrVal("Srvor_name", Srvor_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDepname() {
		return ((String) getAttrVal("Depname"));
	}	
	/**
	 * 名称
	 * @param Depname
	 */
	public void setDepname(String Depname) {
		setAttrVal("Depname", Depname);
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
		return "Id_srvof";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_of";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsDODesc.class);
	}
	
}