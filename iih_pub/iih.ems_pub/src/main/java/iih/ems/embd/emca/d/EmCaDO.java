package iih.ems.embd.emca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.embd.emca.d.desc.EmCaDODesc;
import java.math.BigDecimal;

/**
 * 医疗器械分类 DO数据 
 * 
 */
public class EmCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//设备分类主键
	public static final String ID_EMCA= "Id_emca";
	//上级主键
	public static final String ID_PARENT= "Id_parent";
	//编码
	public static final String CODE= "Code";
	//树内码
	public static final String INNERCODE= "Innercode";
	//名称
	public static final String NAME= "Name";
	//预期用途
	public static final String CA_USE= "Ca_use";
	//品名举例
	public static final String PDU_EXM= "Pdu_exm";
	//国标码
	public static final String NATION_CODE= "Nation_code";
	//是否需要登记
	public static final String FG_REG= "Fg_reg";
	//是否折旧
	public static final String FG_DE= "Fg_de";
	//是否末级
	public static final String FG_LEAF= "Fg_leaf";
	//是否有效
	public static final String FG_VALID= "Fg_valid";
	//财务科目编码
	public static final String ACCOUNT_CODE= "Account_code";
	//财务科目名称
	public static final String ACCOUNT_NAME= "Account_name";
	//对应成本核算项目类别
	public static final String STAT_CODE= "Stat_code";
	//产品描述
	public static final String DES= "Des";
	//是否保养
	public static final String FG_UPKEEP= "Fg_upkeep";
	//68码
	public static final String LB68_CODE= "Lb68_code";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//管理类别
	public static final String MATYPE= "Matype";
	//上级名称
	public static final String PRE_NAME= "Pre_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 设备分类主键
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 设备分类主键
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
	}
	/**
	 * 上级主键
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 上级主键
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
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
	 * 树内码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 树内码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
	 * 预期用途
	 * @return String
	 */
	public String getCa_use() {
		return ((String) getAttrVal("Ca_use"));
	}	
	/**
	 * 预期用途
	 * @param Ca_use
	 */
	public void setCa_use(String Ca_use) {
		setAttrVal("Ca_use", Ca_use);
	}
	/**
	 * 品名举例
	 * @return String
	 */
	public String getPdu_exm() {
		return ((String) getAttrVal("Pdu_exm"));
	}	
	/**
	 * 品名举例
	 * @param Pdu_exm
	 */
	public void setPdu_exm(String Pdu_exm) {
		setAttrVal("Pdu_exm", Pdu_exm);
	}
	/**
	 * 国标码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	/**
	 * 国标码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 是否需要登记
	 * @return FBoolean
	 */
	public FBoolean getFg_reg() {
		return ((FBoolean) getAttrVal("Fg_reg"));
	}	
	/**
	 * 是否需要登记
	 * @param Fg_reg
	 */
	public void setFg_reg(FBoolean Fg_reg) {
		setAttrVal("Fg_reg", Fg_reg);
	}
	/**
	 * 是否折旧
	 * @return FBoolean
	 */
	public FBoolean getFg_de() {
		return ((FBoolean) getAttrVal("Fg_de"));
	}	
	/**
	 * 是否折旧
	 * @param Fg_de
	 */
	public void setFg_de(FBoolean Fg_de) {
		setAttrVal("Fg_de", Fg_de);
	}
	/**
	 * 是否末级
	 * @return FBoolean
	 */
	public FBoolean getFg_leaf() {
		return ((FBoolean) getAttrVal("Fg_leaf"));
	}	
	/**
	 * 是否末级
	 * @param Fg_leaf
	 */
	public void setFg_leaf(FBoolean Fg_leaf) {
		setAttrVal("Fg_leaf", Fg_leaf);
	}
	/**
	 * 是否有效
	 * @return FBoolean
	 */
	public FBoolean getFg_valid() {
		return ((FBoolean) getAttrVal("Fg_valid"));
	}	
	/**
	 * 是否有效
	 * @param Fg_valid
	 */
	public void setFg_valid(FBoolean Fg_valid) {
		setAttrVal("Fg_valid", Fg_valid);
	}
	/**
	 * 财务科目编码
	 * @return String
	 */
	public String getAccount_code() {
		return ((String) getAttrVal("Account_code"));
	}	
	/**
	 * 财务科目编码
	 * @param Account_code
	 */
	public void setAccount_code(String Account_code) {
		setAttrVal("Account_code", Account_code);
	}
	/**
	 * 财务科目名称
	 * @return String
	 */
	public String getAccount_name() {
		return ((String) getAttrVal("Account_name"));
	}	
	/**
	 * 财务科目名称
	 * @param Account_name
	 */
	public void setAccount_name(String Account_name) {
		setAttrVal("Account_name", Account_name);
	}
	/**
	 * 对应成本核算项目类别
	 * @return String
	 */
	public String getStat_code() {
		return ((String) getAttrVal("Stat_code"));
	}	
	/**
	 * 对应成本核算项目类别
	 * @param Stat_code
	 */
	public void setStat_code(String Stat_code) {
		setAttrVal("Stat_code", Stat_code);
	}
	/**
	 * 产品描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 产品描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 是否保养
	 * @return FBoolean
	 */
	public FBoolean getFg_upkeep() {
		return ((FBoolean) getAttrVal("Fg_upkeep"));
	}	
	/**
	 * 是否保养
	 * @param Fg_upkeep
	 */
	public void setFg_upkeep(FBoolean Fg_upkeep) {
		setAttrVal("Fg_upkeep", Fg_upkeep);
	}
	/**
	 * 68码
	 * @return String
	 */
	public String getLb68_code() {
		return ((String) getAttrVal("Lb68_code"));
	}	
	/**
	 * 68码
	 * @param Lb68_code
	 */
	public void setLb68_code(String Lb68_code) {
		setAttrVal("Lb68_code", Lb68_code);
	}
	/**
	 * 折旧年限
	 * @return Integer
	 */
	public Integer getDe_year() {
		return ((Integer) getAttrVal("De_year"));
	}	
	/**
	 * 折旧年限
	 * @param De_year
	 */
	public void setDe_year(Integer De_year) {
		setAttrVal("De_year", De_year);
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
	 * 管理类别
	 * @return String
	 */
	public String getMatype() {
		return ((String) getAttrVal("Matype"));
	}	
	/**
	 * 管理类别
	 * @param Matype
	 */
	public void setMatype(String Matype) {
		setAttrVal("Matype", Matype);
	}
	/**
	 * 上级名称
	 * @return String
	 */
	public String getPre_name() {
		return ((String) getAttrVal("Pre_name"));
	}	
	/**
	 * 上级名称
	 * @param Pre_name
	 */
	public void setPre_name(String Pre_name) {
		setAttrVal("Pre_name", Pre_name);
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
		return "Id_emca";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_ca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmCaDODesc.class);
	}
	
}