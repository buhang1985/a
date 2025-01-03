package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ems.d.desc.EmsPrnTmplDODesc;
import java.math.BigDecimal;

/**
 * 医疗单打印模板 DO数据 
 * 
 */
public class EmsPrnTmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗单打印模板主键标识
	public static final String ID_EMSPRNTMPL= "Id_emsprntmpl";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//打印模板编码
	public static final String CODE= "Code";
	//打印模板名称
	public static final String NAME= "Name";
	//打印模板路径
	public static final String TMPLURL= "Tmplurl";
	//医疗单打印模板分类
	public static final String ID_EMSPRNCA= "Id_emsprnca";
	//适用范围
	public static final String ID_SRVORRT= "Id_srvorrt";
	//适用范围编码
	public static final String SD_SRVORRT= "Sd_srvorrt";
	//适用科室/组织
	public static final String ID_DEPT= "Id_dept";
	//临床医生打印单据类型
	public static final String ID_CIPRINTSHEETTP= "Id_ciprintsheettp";
	//临床医生打印单据类型编码
	public static final String SD_CIPRINTSHEETTP= "Sd_ciprintsheettp";
	//可使用标识_门诊
	public static final String FG_ENTP_OP= "Fg_entp_op";
	//可使用标识_住院
	public static final String FG_ENTP_IP= "Fg_entp_ip";
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
	//可使用标识_预住院
	public static final String FG_USE_PIP="Fg_use_pip";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//生效时间
	public static final String DT_EFFE= "Dt_effe";
	//失效时间
	public static final String DT_DISABLE= "Dt_disable";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//药品模板标识
	public static final String FG_DRUG= "Fg_drug";
	//是否热敏纸
	public static final String FG_THERMAL= "Fg_thermal";
	//医疗单打印模板分类
	public static final String EMSPRNCA_NAME= "Emsprnca_name";
	//名称
	public static final String SRVOR_NAME= "Srvor_name";
	//适用科室
	public static final String DEPNAME= "Depname";
	//名称
	public static final String NAME_CIPRNSHEETTP= "Name_ciprnsheettp";
	//是否是药品
	public static final String FG_MM_CIPRNSHEETTP= "Fg_mm_ciprnsheettp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗单打印模板主键标识
	 * @return String
	 */
	public String getId_emsprntmpl() {
		return ((String) getAttrVal("Id_emsprntmpl"));
	}	
	/**
	 * 医疗单打印模板主键标识
	 * @param Id_emsprntmpl
	 */
	public void setId_emsprntmpl(String Id_emsprntmpl) {
		setAttrVal("Id_emsprntmpl", Id_emsprntmpl);
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
	 * 打印模板编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 打印模板编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 打印模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 打印模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 打印模板路径
	 * @return String
	 */
	public String getTmplurl() {
		return ((String) getAttrVal("Tmplurl"));
	}	
	/**
	 * 打印模板路径
	 * @param Tmplurl
	 */
	public void setTmplurl(String Tmplurl) {
		setAttrVal("Tmplurl", Tmplurl);
	}
	/**
	 * 医疗单打印模板分类
	 * @return String
	 */
	public String getId_emsprnca() {
		return ((String) getAttrVal("Id_emsprnca"));
	}	
	/**
	 * 医疗单打印模板分类
	 * @param Id_emsprnca
	 */
	public void setId_emsprnca(String Id_emsprnca) {
		setAttrVal("Id_emsprnca", Id_emsprnca);
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
	 * 适用科室/组织
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 适用科室/组织
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 临床医生打印单据类型
	 * @return String
	 */
	public String getId_ciprintsheettp() {
		return ((String) getAttrVal("Id_ciprintsheettp"));
	}	
	/**
	 * 临床医生打印单据类型
	 * @param Id_ciprintsheettp
	 */
	public void setId_ciprintsheettp(String Id_ciprintsheettp) {
		setAttrVal("Id_ciprintsheettp", Id_ciprintsheettp);
	}
	/**
	 * 临床医生打印单据类型编码
	 * @return String
	 */
	public String getSd_ciprintsheettp() {
		return ((String) getAttrVal("Sd_ciprintsheettp"));
	}	
	/**
	 * 临床医生打印单据类型编码
	 * @param Sd_ciprintsheettp
	 */
	public void setSd_ciprintsheettp(String Sd_ciprintsheettp) {
		setAttrVal("Sd_ciprintsheettp", Sd_ciprintsheettp);
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
	 * 可使用标识_预住院
	 * @return
	 */
	public FBoolean getFg_use_pip(){
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}
	/**
	 * 可使用标识_预住院
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip){
		setAttrVal("Fg_use_pip",Fg_use_pip);
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
	public FDateTime getDt_disable() {
		return ((FDateTime) getAttrVal("Dt_disable"));
	}	
	/**
	 * 失效时间
	 * @param Dt_disable
	 */
	public void setDt_disable(FDateTime Dt_disable) {
		setAttrVal("Dt_disable", Dt_disable);
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
	 * 药品模板标识
	 * @return FBoolean
	 */
	public FBoolean getFg_drug() {
		return ((FBoolean) getAttrVal("Fg_drug"));
	}	
	/**
	 * 药品模板标识
	 * @param Fg_drug
	 */
	public void setFg_drug(FBoolean Fg_drug) {
		setAttrVal("Fg_drug", Fg_drug);
	}
	/**
	 * 是否热敏纸
	 * @return FBoolean
	 */
	public FBoolean getFg_thermal() {
		return ((FBoolean) getAttrVal("Fg_thermal"));
	}	
	/**
	 * 是否热敏纸
	 * @param Fg_thermal
	 */
	public void setFg_thermal(FBoolean Fg_thermal) {
		setAttrVal("Fg_thermal", Fg_thermal);
	}
	/**
	 * 医疗单打印模板分类
	 * @return String
	 */
	public String getEmsprnca_name() {
		return ((String) getAttrVal("Emsprnca_name"));
	}	
	/**
	 * 医疗单打印模板分类
	 * @param Emsprnca_name
	 */
	public void setEmsprnca_name(String Emsprnca_name) {
		setAttrVal("Emsprnca_name", Emsprnca_name);
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
	 * 适用科室
	 * @return String
	 */
	public String getDepname() {
		return ((String) getAttrVal("Depname"));
	}	
	/**
	 * 适用科室
	 * @param Depname
	 */
	public void setDepname(String Depname) {
		setAttrVal("Depname", Depname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ciprnsheettp() {
		return ((String) getAttrVal("Name_ciprnsheettp"));
	}	
	/**
	 * 名称
	 * @param Name_ciprnsheettp
	 */
	public void setName_ciprnsheettp(String Name_ciprnsheettp) {
		setAttrVal("Name_ciprnsheettp", Name_ciprnsheettp);
	}
	/**
	 * 是否是药品
	 * @return String
	 */
	public String getFg_mm_ciprnsheettp() {
		return ((String) getAttrVal("Fg_mm_ciprnsheettp"));
	}	
	/**
	 * 是否是药品
	 * @param Fg_mm_ciprnsheettp
	 */
	public void setFg_mm_ciprnsheettp(String Fg_mm_ciprnsheettp) {
		setAttrVal("Fg_mm_ciprnsheettp", Fg_mm_ciprnsheettp);
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
		return "Id_emsprntmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_ems_prntmpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsPrnTmplDODesc.class);
	}
	
}