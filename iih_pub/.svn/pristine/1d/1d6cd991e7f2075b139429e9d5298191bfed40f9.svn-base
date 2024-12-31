package iih.bd.mm.drugcombctl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.drugcombctl.d.desc.DrugCombCtlDODesc;
import java.math.BigDecimal;

/**
 * 联合用药限制 DO数据 
 * 
 */
public class DrugCombCtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//联合用药限制分类主键
	public static final String ID_SRVDRUGCOMBCTLCA= "Id_srvdrugcombctlca";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//药品基本分类
	public static final String ID_MMCA= "Id_mmca";
	//药品自定义分类
	public static final String ID_MMCA_CTM= "Id_mmca_ctm";
	//通用名基本分类
	public static final String ID_SRVCA= "Id_srvca";
	//通用名自定义分类
	public static final String ID_SRVCA_CTM= "Id_srvca_ctm";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
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
	//可使用标识_急诊流水
	public static final String FG_USE_ER= "Fg_use_er";
	//可使用标识_急诊抢救
	public static final String FG_USE_ER1= "Fg_use_er1";
	//可使用标识_急诊留观
	public static final String FG_USE_ER2= "Fg_use_er2";
	//可使用标识_体检
	public static final String FG_USE_PE= "Fg_use_pe";
	//可使用标识_家庭
	public static final String FG_USE_FM= "Fg_use_fm";
	//限制分类类型
	public static final String EU_DRUGCOMBCTLTP= "Eu_drugcombctltp";
	//限制分类范围
	public static final String DRUGCOMBCTLTP= "Drugcombctltp";
	//临床医嘱是否受限制
	public static final String FG_CTL_LONG= "Fg_ctl_long";
	//限制等级
	public static final String EU_DRUGCOMBCTLMD= "Eu_drugcombctlmd";
	//提示信息内容
	public static final String MESSAGE= "Message";
	//限制药品数量
	public static final String MAXNUM= "Maxnum";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//药品基本分类名称
	public static final String NAME_MMCA= "Name_mmca";
	//药品基本分类编码
	public static final String CODE_MMCA= "Code_mmca";
	//药品自定义分类编码
	public static final String CODE_MMCA_CTM= "Code_mmca_ctm";
	//药品自定义分类名称
	public static final String NAME_MMCA_CTM= "Name_mmca_ctm";
	//通用名基本分类名称
	public static final String NAME_SRVCA= "Name_srvca";
	//通用名基本分类编码
	public static final String CODE_SRVCA= "Code_srvca";
	//通用名自定义分类编码
	public static final String CODE_SRVCA_CTM= "Code_srvca_ctm";
	//通用名自定义分类名称
	public static final String NAME_SRVCA_CTM= "Name_srvca_ctm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 联合用药限制分类主键
	 * @return String
	 */
	public String getId_srvdrugcombctlca() {
		return ((String) getAttrVal("Id_srvdrugcombctlca"));
	}	
	/**
	 * 联合用药限制分类主键
	 * @param Id_srvdrugcombctlca
	 */
	public void setId_srvdrugcombctlca(String Id_srvdrugcombctlca) {
		setAttrVal("Id_srvdrugcombctlca", Id_srvdrugcombctlca);
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
	 * 药品基本分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	/**
	 * 药品基本分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 药品自定义分类
	 * @return String
	 */
	public String getId_mmca_ctm() {
		return ((String) getAttrVal("Id_mmca_ctm"));
	}	
	/**
	 * 药品自定义分类
	 * @param Id_mmca_ctm
	 */
	public void setId_mmca_ctm(String Id_mmca_ctm) {
		setAttrVal("Id_mmca_ctm", Id_mmca_ctm);
	}
	/**
	 * 通用名基本分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 通用名基本分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 通用名自定义分类
	 * @return String
	 */
	public String getId_srvca_ctm() {
		return ((String) getAttrVal("Id_srvca_ctm"));
	}	
	/**
	 * 通用名自定义分类
	 * @param Id_srvca_ctm
	 */
	public void setId_srvca_ctm(String Id_srvca_ctm) {
		setAttrVal("Id_srvca_ctm", Id_srvca_ctm);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 可使用标识_急诊流水
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er() {
		return ((FBoolean) getAttrVal("Fg_use_er"));
	}	
	/**
	 * 可使用标识_急诊流水
	 * @param Fg_use_er
	 */
	public void setFg_use_er(FBoolean Fg_use_er) {
		setAttrVal("Fg_use_er", Fg_use_er);
	}
	/**
	 * 可使用标识_急诊抢救
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 可使用标识_急诊抢救
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 可使用标识_急诊留观
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 可使用标识_急诊留观
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
	 * 限制分类类型
	 * @return String
	 */
	public String getEu_drugcombctltp() {
		return ((String) getAttrVal("Eu_drugcombctltp"));
	}	
	/**
	 * 限制分类类型
	 * @param Eu_drugcombctltp
	 */
	public void setEu_drugcombctltp(String Eu_drugcombctltp) {
		setAttrVal("Eu_drugcombctltp", Eu_drugcombctltp);
	}
	/**
	 * 限制分类范围
	 * @return String
	 */
	public String getDrugcombctltp() {
		return ((String) getAttrVal("Drugcombctltp"));
	}	
	/**
	 * 限制分类范围
	 * @param Drugcombctltp
	 */
	public void setDrugcombctltp(String Drugcombctltp) {
		setAttrVal("Drugcombctltp", Drugcombctltp);
	}
	/**
	 * 临床医嘱是否受限制
	 * @return FBoolean
	 */
	public FBoolean getFg_ctl_long() {
		return ((FBoolean) getAttrVal("Fg_ctl_long"));
	}	
	/**
	 * 临床医嘱是否受限制
	 * @param Fg_ctl_long
	 */
	public void setFg_ctl_long(FBoolean Fg_ctl_long) {
		setAttrVal("Fg_ctl_long", Fg_ctl_long);
	}
	/**
	 * 限制等级
	 * @return String
	 */
	public String getEu_drugcombctlmd() {
		return ((String) getAttrVal("Eu_drugcombctlmd"));
	}	
	/**
	 * 限制等级
	 * @param Eu_drugcombctlmd
	 */
	public void setEu_drugcombctlmd(String Eu_drugcombctlmd) {
		setAttrVal("Eu_drugcombctlmd", Eu_drugcombctlmd);
	}
	/**
	 * 提示信息内容
	 * @return String
	 */
	public String getMessage() {
		return ((String) getAttrVal("Message"));
	}	
	/**
	 * 提示信息内容
	 * @param Message
	 */
	public void setMessage(String Message) {
		setAttrVal("Message", Message);
	}
	/**
	 * 限制药品数量
	 * @return Integer
	 */
	public Integer getMaxnum() {
		return ((Integer) getAttrVal("Maxnum"));
	}	
	/**
	 * 限制药品数量
	 * @param Maxnum
	 */
	public void setMaxnum(Integer Maxnum) {
		setAttrVal("Maxnum", Maxnum);
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
	 * 药品基本分类名称
	 * @return String
	 */
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}	
	/**
	 * 药品基本分类名称
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
	}
	/**
	 * 药品基本分类编码
	 * @return String
	 */
	public String getCode_mmca() {
		return ((String) getAttrVal("Code_mmca"));
	}	
	/**
	 * 药品基本分类编码
	 * @param Code_mmca
	 */
	public void setCode_mmca(String Code_mmca) {
		setAttrVal("Code_mmca", Code_mmca);
	}
	/**
	 * 药品自定义分类编码
	 * @return String
	 */
	public String getCode_mmca_ctm() {
		return ((String) getAttrVal("Code_mmca_ctm"));
	}	
	/**
	 * 药品自定义分类编码
	 * @param Code_mmca_ctm
	 */
	public void setCode_mmca_ctm(String Code_mmca_ctm) {
		setAttrVal("Code_mmca_ctm", Code_mmca_ctm);
	}
	/**
	 * 药品自定义分类名称
	 * @return String
	 */
	public String getName_mmca_ctm() {
		return ((String) getAttrVal("Name_mmca_ctm"));
	}	
	/**
	 * 药品自定义分类名称
	 * @param Name_mmca_ctm
	 */
	public void setName_mmca_ctm(String Name_mmca_ctm) {
		setAttrVal("Name_mmca_ctm", Name_mmca_ctm);
	}
	/**
	 * 通用名基本分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	/**
	 * 通用名基本分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 通用名基本分类编码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	/**
	 * 通用名基本分类编码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 通用名自定义分类编码
	 * @return String
	 */
	public String getCode_srvca_ctm() {
		return ((String) getAttrVal("Code_srvca_ctm"));
	}	
	/**
	 * 通用名自定义分类编码
	 * @param Code_srvca_ctm
	 */
	public void setCode_srvca_ctm(String Code_srvca_ctm) {
		setAttrVal("Code_srvca_ctm", Code_srvca_ctm);
	}
	/**
	 * 通用名自定义分类名称
	 * @return String
	 */
	public String getName_srvca_ctm() {
		return ((String) getAttrVal("Name_srvca_ctm"));
	}	
	/**
	 * 通用名自定义分类名称
	 * @param Name_srvca_ctm
	 */
	public void setName_srvca_ctm(String Name_srvca_ctm) {
		setAttrVal("Name_srvca_ctm", Name_srvca_ctm);
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
		return "Id_srvdrugcombctlca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_drugcombctlca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DrugCombCtlDODesc.class);
	}
	
}