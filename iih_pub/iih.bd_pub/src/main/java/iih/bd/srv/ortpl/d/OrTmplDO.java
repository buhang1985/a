package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.OrTmplDODesc;
import java.math.BigDecimal;

/**
 * 医嘱模板 DO数据 
 * 
 */
public class OrTmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱模板主键标识
	public static final String ID_ORTMPL= "Id_ortmpl";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医嘱模板类型
	public static final String ID_ORTMPLTP= "Id_ortmpltp";
	//医嘱模板类型编码
	public static final String SD_ORTMPLTP= "Sd_ortmpltp";
	//模板编码
	public static final String CODE= "Code";
	//编码名称
	public static final String NAME= "Name";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//模板描述
	public static final String DES= "Des";
	//协定标识
	public static final String FG_CIPHER= "Fg_cipher";
	//模板适用范围
	public static final String ID_SRVORRT= "Id_srvorrt";
	//模板适用范围编码
	public static final String SD_SRVORRT= "Sd_srvorrt";
	//科室
	public static final String ID_DEP= "Id_dep";
	//个人
	public static final String ID_EMP= "Id_emp";
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
	//可使用标识-预住院标识
	public static final String FG_USE_PIP= "Fg_use_pip";
	//是否派生
	public static final String FG_SYNC= "Fg_sync";
	//来源模板
	public static final String ID_ORTMPL_SRC= "Id_ortmpl_src";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//模板内容
	public static final String CONTENT_OR= "Content_or";
	//用法
	public static final String ID_ROUTE= "Id_route";
	//要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//煎法
	public static final String ID_BOIL= "Id_boil";
	//煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//模板服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//模板服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//频次
	public static final String ID_FREQ= "Id_freq";
	//医嘱付数
	public static final String ORDERS= "Orders";
	//医嘱天数
	public static final String DAYS_OR= "Days_or";
	//频次周期类型
	public static final String ID_FREQUNIT= "Id_frequnit";
	//频次周期类型编码
	public static final String SD_FREQUNIT= "Sd_frequnit";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//模板序号
	public static final String SEQNO= "Seqno";
	//嘱托
	public static final String DES_OR= "Des_or";
	//关联的诊断
	public static final String ID_DIDEF_REF= "Id_didef_ref";
	//名称
	public static final String ORTMPL_TP_NAME= "Ortmpl_tp_name";
	//名称
	public static final String ORTMPL_SRVORRT_NAME= "Ortmpl_srvorrt_name";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//部门编码
	public static final String DEP_CODE= "Dep_code";
	//人员编码
	public static final String EMP_CODE= "Emp_code";
	//人员姓名
	public static final String EMP_NAME= "Emp_name";
	//用法编码
	public static final String ORTMPL_ROUTE_CODE= "Ortmpl_route_code";
	//用法名称
	public static final String ORTMPL_ROUTE_NAME= "Ortmpl_route_name";
	//医疗要求
	public static final String ORTMPL_ROUTEDES_NAME= "Ortmpl_routedes_name";
	//医疗要求编码
	public static final String ORTMPL_ROUTEDES_CODE= "Ortmpl_routedes_code";
	//煎法编码
	public static final String ORTMPL_BOIL_CODE= "Ortmpl_boil_code";
	//煎法名称
	public static final String ORTMPL_BOIL_NAME= "Ortmpl_boil_name";
	//煎法要求编码
	public static final String ORTMPL_BOILDES_CODE= "Ortmpl_boildes_code";
	//煎法要求
	public static final String ORTMPL_BOILDES_NAME= "Ortmpl_boildes_name";
	//名称
	public static final String ORTMPL_SRVTP_NAME= "Ortmpl_srvtp_name";
	//频次名称
	public static final String ORTMPL_FREQ_NAME= "Ortmpl_freq_name";
	//频次编码
	public static final String ORTMPL_FREQ_CODE= "Ortmpl_freq_code";
	//名称
	public static final String ORTMPL_FREQUNIT_NAME= "Ortmpl_frequnit_name";
	//关联诊断名称
	public static final String NAME_DIDEF_REF= "Name_didef_ref";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱模板主键标识
	 * @return String
	 */
	public String getId_ortmpl() {
		return ((String) getAttrVal("Id_ortmpl"));
	}	
	/**
	 * 医嘱模板主键标识
	 * @param Id_ortmpl
	 */
	public void setId_ortmpl(String Id_ortmpl) {
		setAttrVal("Id_ortmpl", Id_ortmpl);
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
	 * 医嘱模板类型
	 * @return String
	 */
	public String getId_ortmpltp() {
		return ((String) getAttrVal("Id_ortmpltp"));
	}	
	/**
	 * 医嘱模板类型
	 * @param Id_ortmpltp
	 */
	public void setId_ortmpltp(String Id_ortmpltp) {
		setAttrVal("Id_ortmpltp", Id_ortmpltp);
	}
	/**
	 * 医嘱模板类型编码
	 * @return String
	 */
	public String getSd_ortmpltp() {
		return ((String) getAttrVal("Sd_ortmpltp"));
	}	
	/**
	 * 医嘱模板类型编码
	 * @param Sd_ortmpltp
	 */
	public void setSd_ortmpltp(String Sd_ortmpltp) {
		setAttrVal("Sd_ortmpltp", Sd_ortmpltp);
	}
	/**
	 * 模板编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 模板编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 编码名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 编码名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
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
	 * 模板描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 模板描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 协定标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cipher() {
		return ((FBoolean) getAttrVal("Fg_cipher"));
	}	
	/**
	 * 协定标识
	 * @param Fg_cipher
	 */
	public void setFg_cipher(FBoolean Fg_cipher) {
		setAttrVal("Fg_cipher", Fg_cipher);
	}
	/**
	 * 模板适用范围
	 * @return String
	 */
	public String getId_srvorrt() {
		return ((String) getAttrVal("Id_srvorrt"));
	}	
	/**
	 * 模板适用范围
	 * @param Id_srvorrt
	 */
	public void setId_srvorrt(String Id_srvorrt) {
		setAttrVal("Id_srvorrt", Id_srvorrt);
	}
	/**
	 * 模板适用范围编码
	 * @return String
	 */
	public String getSd_srvorrt() {
		return ((String) getAttrVal("Sd_srvorrt"));
	}	
	/**
	 * 模板适用范围编码
	 * @param Sd_srvorrt
	 */
	public void setSd_srvorrt(String Sd_srvorrt) {
		setAttrVal("Sd_srvorrt", Sd_srvorrt);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 个人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 个人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
	 * 可使用标识-预住院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 可使用标识-预住院标识
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 是否派生
	 * @return FBoolean
	 */
	public FBoolean getFg_sync() {
		return ((FBoolean) getAttrVal("Fg_sync"));
	}	
	/**
	 * 是否派生
	 * @param Fg_sync
	 */
	public void setFg_sync(FBoolean Fg_sync) {
		setAttrVal("Fg_sync", Fg_sync);
	}
	/**
	 * 来源模板
	 * @return String
	 */
	public String getId_ortmpl_src() {
		return ((String) getAttrVal("Id_ortmpl_src"));
	}	
	/**
	 * 来源模板
	 * @param Id_ortmpl_src
	 */
	public void setId_ortmpl_src(String Id_ortmpl_src) {
		setAttrVal("Id_ortmpl_src", Id_ortmpl_src);
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
	 * 模板内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 模板内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 模板服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 模板服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 模板服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 模板服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 频次周期类型
	 * @return String
	 */
	public String getId_frequnit() {
		return ((String) getAttrVal("Id_frequnit"));
	}	
	/**
	 * 频次周期类型
	 * @param Id_frequnit
	 */
	public void setId_frequnit(String Id_frequnit) {
		setAttrVal("Id_frequnit", Id_frequnit);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnit() {
		return ((String) getAttrVal("Sd_frequnit"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnit
	 */
	public void setSd_frequnit(String Sd_frequnit) {
		setAttrVal("Sd_frequnit", Sd_frequnit);
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
	 * 模板序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}	
	/**
	 * 模板序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 关联的诊断
	 * @return String
	 */
	public String getId_didef_ref() {
		return ((String) getAttrVal("Id_didef_ref"));
	}	
	/**
	 * 关联的诊断
	 * @param Id_didef_ref
	 */
	public void setId_didef_ref(String Id_didef_ref) {
		setAttrVal("Id_didef_ref", Id_didef_ref);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOrtmpl_tp_name() {
		return ((String) getAttrVal("Ortmpl_tp_name"));
	}	
	/**
	 * 名称
	 * @param Ortmpl_tp_name
	 */
	public void setOrtmpl_tp_name(String Ortmpl_tp_name) {
		setAttrVal("Ortmpl_tp_name", Ortmpl_tp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOrtmpl_srvorrt_name() {
		return ((String) getAttrVal("Ortmpl_srvorrt_name"));
	}	
	/**
	 * 名称
	 * @param Ortmpl_srvorrt_name
	 */
	public void setOrtmpl_srvorrt_name(String Ortmpl_srvorrt_name) {
		setAttrVal("Ortmpl_srvorrt_name", Ortmpl_srvorrt_name);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 部门名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 部门编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 部门编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_code
	 */
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 人员姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getOrtmpl_route_code() {
		return ((String) getAttrVal("Ortmpl_route_code"));
	}	
	/**
	 * 用法编码
	 * @param Ortmpl_route_code
	 */
	public void setOrtmpl_route_code(String Ortmpl_route_code) {
		setAttrVal("Ortmpl_route_code", Ortmpl_route_code);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getOrtmpl_route_name() {
		return ((String) getAttrVal("Ortmpl_route_name"));
	}	
	/**
	 * 用法名称
	 * @param Ortmpl_route_name
	 */
	public void setOrtmpl_route_name(String Ortmpl_route_name) {
		setAttrVal("Ortmpl_route_name", Ortmpl_route_name);
	}
	/**
	 * 医疗要求
	 * @return String
	 */
	public String getOrtmpl_routedes_name() {
		return ((String) getAttrVal("Ortmpl_routedes_name"));
	}	
	/**
	 * 医疗要求
	 * @param Ortmpl_routedes_name
	 */
	public void setOrtmpl_routedes_name(String Ortmpl_routedes_name) {
		setAttrVal("Ortmpl_routedes_name", Ortmpl_routedes_name);
	}
	/**
	 * 医疗要求编码
	 * @return String
	 */
	public String getOrtmpl_routedes_code() {
		return ((String) getAttrVal("Ortmpl_routedes_code"));
	}	
	/**
	 * 医疗要求编码
	 * @param Ortmpl_routedes_code
	 */
	public void setOrtmpl_routedes_code(String Ortmpl_routedes_code) {
		setAttrVal("Ortmpl_routedes_code", Ortmpl_routedes_code);
	}
	/**
	 * 煎法编码
	 * @return String
	 */
	public String getOrtmpl_boil_code() {
		return ((String) getAttrVal("Ortmpl_boil_code"));
	}	
	/**
	 * 煎法编码
	 * @param Ortmpl_boil_code
	 */
	public void setOrtmpl_boil_code(String Ortmpl_boil_code) {
		setAttrVal("Ortmpl_boil_code", Ortmpl_boil_code);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getOrtmpl_boil_name() {
		return ((String) getAttrVal("Ortmpl_boil_name"));
	}	
	/**
	 * 煎法名称
	 * @param Ortmpl_boil_name
	 */
	public void setOrtmpl_boil_name(String Ortmpl_boil_name) {
		setAttrVal("Ortmpl_boil_name", Ortmpl_boil_name);
	}
	/**
	 * 煎法要求编码
	 * @return String
	 */
	public String getOrtmpl_boildes_code() {
		return ((String) getAttrVal("Ortmpl_boildes_code"));
	}	
	/**
	 * 煎法要求编码
	 * @param Ortmpl_boildes_code
	 */
	public void setOrtmpl_boildes_code(String Ortmpl_boildes_code) {
		setAttrVal("Ortmpl_boildes_code", Ortmpl_boildes_code);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getOrtmpl_boildes_name() {
		return ((String) getAttrVal("Ortmpl_boildes_name"));
	}	
	/**
	 * 煎法要求
	 * @param Ortmpl_boildes_name
	 */
	public void setOrtmpl_boildes_name(String Ortmpl_boildes_name) {
		setAttrVal("Ortmpl_boildes_name", Ortmpl_boildes_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOrtmpl_srvtp_name() {
		return ((String) getAttrVal("Ortmpl_srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Ortmpl_srvtp_name
	 */
	public void setOrtmpl_srvtp_name(String Ortmpl_srvtp_name) {
		setAttrVal("Ortmpl_srvtp_name", Ortmpl_srvtp_name);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getOrtmpl_freq_name() {
		return ((String) getAttrVal("Ortmpl_freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Ortmpl_freq_name
	 */
	public void setOrtmpl_freq_name(String Ortmpl_freq_name) {
		setAttrVal("Ortmpl_freq_name", Ortmpl_freq_name);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getOrtmpl_freq_code() {
		return ((String) getAttrVal("Ortmpl_freq_code"));
	}	
	/**
	 * 频次编码
	 * @param Ortmpl_freq_code
	 */
	public void setOrtmpl_freq_code(String Ortmpl_freq_code) {
		setAttrVal("Ortmpl_freq_code", Ortmpl_freq_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOrtmpl_frequnit_name() {
		return ((String) getAttrVal("Ortmpl_frequnit_name"));
	}	
	/**
	 * 名称
	 * @param Ortmpl_frequnit_name
	 */
	public void setOrtmpl_frequnit_name(String Ortmpl_frequnit_name) {
		setAttrVal("Ortmpl_frequnit_name", Ortmpl_frequnit_name);
	}
	/**
	 * 关联诊断名称
	 * @return String
	 */
	public String getName_didef_ref() {
		return ((String) getAttrVal("Name_didef_ref"));
	}	
	/**
	 * 关联诊断名称
	 * @param Name_didef_ref
	 */
	public void setName_didef_ref(String Name_didef_ref) {
		setAttrVal("Name_didef_ref", Name_didef_ref);
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
		return "Id_ortmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_ortmpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrTmplDODesc.class);
	}
	
}