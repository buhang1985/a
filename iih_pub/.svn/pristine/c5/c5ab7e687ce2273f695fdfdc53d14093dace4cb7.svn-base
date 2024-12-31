package iih.bd.srv.srvrtctl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvrtctl.d.desc.SrvRtCtlDODesc;
import java.math.BigDecimal;

/**
 * 服务开立权限 DO数据 
 * 
 */
public class SrvRtCtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务开立权限主键标识
	public static final String ID_SRVRT= "Id_srvrt";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//服务开立权限分类
	public static final String ID_SRVRTCA= "Id_srvrtca";
	//服务开立权限编码
	public static final String CODE= "Code";
	//服务开立权限名称
	public static final String NAME= "Name";
	//服务开立权限分类描述
	public static final String DES= "Des";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//可使用标识_门诊
	public static final String FG_USE_OP= "Fg_use_op";
	//可使用标识_预住院
	public static final String FG_USE_PIP= "Fg_use_pip";
	//可使用标识_住院
	public static final String FG_USE_IP= "Fg_use_ip";
	//急诊流水标志
	public static final String FG_USE_ER= "Fg_use_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//可使用标识_体检
	public static final String FG_USE_PE= "Fg_use_pe";
	//可使用标识_家庭
	public static final String FG_USE_FM= "Fg_use_fm";
	//临时医嘱是否受限制
	public static final String FG_CTL_LONG= "Fg_ctl_long";
	//规则串
	public static final String RULES= "Rules";
	//规则串对应的xml
	public static final String XML_RULES= "Xml_rules";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//开立权限分类编码
	public static final String IDSRVRTCACODE= "Idsrvrtcacode";
	//开立权限分类名称
	public static final String IDSRVRTCANAME= "Idsrvrtcaname";
	//服务开立权限分类规则控制标识
	public static final String SRVRTCA_FG_RUCTR= "Srvrtca_fg_ructr";
	//开立权限类型编码
	public static final String SRVRTCA_SD_SRVRTTP= "Srvrtca_sd_srvrttp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务开立权限主键标识
	 * @return String
	 */
	public String getId_srvrt() {
		return ((String) getAttrVal("Id_srvrt"));
	}	
	/**
	 * 服务开立权限主键标识
	 * @param Id_srvrt
	 */
	public void setId_srvrt(String Id_srvrt) {
		setAttrVal("Id_srvrt", Id_srvrt);
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
	 * 服务开立权限分类
	 * @return String
	 */
	public String getId_srvrtca() {
		return ((String) getAttrVal("Id_srvrtca"));
	}	
	/**
	 * 服务开立权限分类
	 * @param Id_srvrtca
	 */
	public void setId_srvrtca(String Id_srvrtca) {
		setAttrVal("Id_srvrtca", Id_srvrtca);
	}
	/**
	 * 服务开立权限编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 服务开立权限编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 服务开立权限名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务开立权限名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务开立权限分类描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 服务开立权限分类描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 可使用标识_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	/**
	 * 可使用标识_门诊
	 * @param Fg_use_op
	 */
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	/**
	 * 可使用标识_预住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 可使用标识_预住院
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 可使用标识_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	/**
	 * 可使用标识_住院
	 * @param Fg_use_ip
	 */
	public void setFg_use_ip(FBoolean Fg_use_ip) {
		setAttrVal("Fg_use_ip", Fg_use_ip);
	}
	/**
	 * 急诊流水标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er() {
		return ((FBoolean) getAttrVal("Fg_use_er"));
	}	
	/**
	 * 急诊流水标志
	 * @param Fg_use_er
	 */
	public void setFg_use_er(FBoolean Fg_use_er) {
		setAttrVal("Fg_use_er", Fg_use_er);
	}
	/**
	 * 急诊抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 急诊抢救标志
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 可使用标识_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	/**
	 * 可使用标识_体检
	 * @param Fg_use_pe
	 */
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	/**
	 * 可使用标识_家庭
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 可使用标识_家庭
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 临时医嘱是否受限制
	 * @return FBoolean
	 */
	public FBoolean getFg_ctl_long() {
		return ((FBoolean) getAttrVal("Fg_ctl_long"));
	}	
	/**
	 * 临时医嘱是否受限制
	 * @param Fg_ctl_long
	 */
	public void setFg_ctl_long(FBoolean Fg_ctl_long) {
		setAttrVal("Fg_ctl_long", Fg_ctl_long);
	}
	/**
	 * 规则串
	 * @return String
	 */
	public String getRules() {
		return ((String) getAttrVal("Rules"));
	}	
	/**
	 * 规则串
	 * @param Rules
	 */
	public void setRules(String Rules) {
		setAttrVal("Rules", Rules);
	}
	/**
	 * 规则串对应的xml
	 * @return String
	 */
	public String getXml_rules() {
		return ((String) getAttrVal("Xml_rules"));
	}	
	/**
	 * 规则串对应的xml
	 * @param Xml_rules
	 */
	public void setXml_rules(String Xml_rules) {
		setAttrVal("Xml_rules", Xml_rules);
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
	 * 开立权限分类编码
	 * @return String
	 */
	public String getIdsrvrtcacode() {
		return ((String) getAttrVal("Idsrvrtcacode"));
	}	
	/**
	 * 开立权限分类编码
	 * @param Idsrvrtcacode
	 */
	public void setIdsrvrtcacode(String Idsrvrtcacode) {
		setAttrVal("Idsrvrtcacode", Idsrvrtcacode);
	}
	/**
	 * 开立权限分类名称
	 * @return String
	 */
	public String getIdsrvrtcaname() {
		return ((String) getAttrVal("Idsrvrtcaname"));
	}	
	/**
	 * 开立权限分类名称
	 * @param Idsrvrtcaname
	 */
	public void setIdsrvrtcaname(String Idsrvrtcaname) {
		setAttrVal("Idsrvrtcaname", Idsrvrtcaname);
	}
	/**
	 * 服务开立权限分类规则控制标识
	 * @return FBoolean
	 */
	public FBoolean getSrvrtca_fg_ructr() {
		return ((FBoolean) getAttrVal("Srvrtca_fg_ructr"));
	}	
	/**
	 * 服务开立权限分类规则控制标识
	 * @param Srvrtca_fg_ructr
	 */
	public void setSrvrtca_fg_ructr(FBoolean Srvrtca_fg_ructr) {
		setAttrVal("Srvrtca_fg_ructr", Srvrtca_fg_ructr);
	}
	/**
	 * 开立权限类型编码
	 * @return String
	 */
	public String getSrvrtca_sd_srvrttp() {
		return ((String) getAttrVal("Srvrtca_sd_srvrttp"));
	}	
	/**
	 * 开立权限类型编码
	 * @param Srvrtca_sd_srvrttp
	 */
	public void setSrvrtca_sd_srvrttp(String Srvrtca_sd_srvrttp) {
		setAttrVal("Srvrtca_sd_srvrttp", Srvrtca_sd_srvrttp);
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
		return "Id_srvrt";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvRtCtlDODesc.class);
	}
	
}