package iih.pe.por.pecorpbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecorpbinfo.d.desc.PeCorpbInfoDODesc;
import java.math.BigDecimal;

/**
 * 体检团体信息 DO数据 
 * 
 */
public class PeCorpbInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体主键标识
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	//体检团体父ID
	public static final String ID_PECORPBINFO_PAR= "Id_pecorpbinfo_par";
	//单位编码
	public static final String CODE= "Code";
	//单位名称
	public static final String NAME= "Name";
	//邮箱
	public static final String EMAIL= "Email";
	//电话
	public static final String TEL= "Tel";
	//开户账号
	public static final String BANK_CODE= "Bank_code";
	//联系人
	public static final String LINKMAN= "Linkman";
	//联系人2
	public static final String LINKMAN2= "Linkman2";
	//联系人3
	public static final String LINKMAN3= "Linkman3";
	//联系人电话
	public static final String LINKMAN_TEL= "Linkman_tel";
	//联系人电话2
	public static final String LINKMAN_TEL2= "Linkman_tel2";
	//联系人电话3
	public static final String LINKMAN_TEL3= "Linkman_tel3";
	//邮编
	public static final String ZIP= "Zip";
	//地址
	public static final String ADDR= "Addr";
	//备注
	public static final String NOTE= "Note";
	//序号
	public static final String SORTNO= "Sortno";
	//机构代码
	public static final String ORG_CODE= "Org_code";
	//经济类型编码
	public static final String SD_ECON= "Sd_econ";
	//经济类型
	public static final String ID_ECON= "Id_econ";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//门诊就诊ID
	public static final String ID_PAT= "Id_pat";
	//团体识别号
	public static final String IDCODE= "Idcode";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//门诊ID
	public static final String ID_CUST= "Id_cust";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//会员卡类别
	public static final String MEMCARD= "Memcard";
	//网页密码
	public static final String PWWEB= "Pwweb";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	//名称
	public static final String NAME_ECON= "Name_econ";
	//编码
	public static final String CODE_ECON= "Code_econ";
	//会员卡编码
	public static final String CODE_CARD= "Code_card";
	//会员卡名称
	public static final String NAME_CARD= "Name_card";
	//折扣率
	public static final String RATIO_DISCOUNT= "Ratio_discount";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体主键标识
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	/**
	 * 体检团体主键标识
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * 体检团体父ID
	 * @return String
	 */
	public String getId_pecorpbinfo_par() {
		return ((String) getAttrVal("Id_pecorpbinfo_par"));
	}	
	/**
	 * 体检团体父ID
	 * @param Id_pecorpbinfo_par
	 */
	public void setId_pecorpbinfo_par(String Id_pecorpbinfo_par) {
		setAttrVal("Id_pecorpbinfo_par", Id_pecorpbinfo_par);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 单位编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 单位名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 邮箱
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}	
	/**
	 * 邮箱
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 开户账号
	 * @return String
	 */
	public String getBank_code() {
		return ((String) getAttrVal("Bank_code"));
	}	
	/**
	 * 开户账号
	 * @param Bank_code
	 */
	public void setBank_code(String Bank_code) {
		setAttrVal("Bank_code", Bank_code);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getLinkman() {
		return ((String) getAttrVal("Linkman"));
	}	
	/**
	 * 联系人
	 * @param Linkman
	 */
	public void setLinkman(String Linkman) {
		setAttrVal("Linkman", Linkman);
	}
	/**
	 * 联系人2
	 * @return String
	 */
	public String getLinkman2() {
		return ((String) getAttrVal("Linkman2"));
	}	
	/**
	 * 联系人2
	 * @param Linkman2
	 */
	public void setLinkman2(String Linkman2) {
		setAttrVal("Linkman2", Linkman2);
	}
	/**
	 * 联系人3
	 * @return String
	 */
	public String getLinkman3() {
		return ((String) getAttrVal("Linkman3"));
	}	
	/**
	 * 联系人3
	 * @param Linkman3
	 */
	public void setLinkman3(String Linkman3) {
		setAttrVal("Linkman3", Linkman3);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getLinkman_tel() {
		return ((String) getAttrVal("Linkman_tel"));
	}	
	/**
	 * 联系人电话
	 * @param Linkman_tel
	 */
	public void setLinkman_tel(String Linkman_tel) {
		setAttrVal("Linkman_tel", Linkman_tel);
	}
	/**
	 * 联系人电话2
	 * @return String
	 */
	public String getLinkman_tel2() {
		return ((String) getAttrVal("Linkman_tel2"));
	}	
	/**
	 * 联系人电话2
	 * @param Linkman_tel2
	 */
	public void setLinkman_tel2(String Linkman_tel2) {
		setAttrVal("Linkman_tel2", Linkman_tel2);
	}
	/**
	 * 联系人电话3
	 * @return String
	 */
	public String getLinkman_tel3() {
		return ((String) getAttrVal("Linkman_tel3"));
	}	
	/**
	 * 联系人电话3
	 * @param Linkman_tel3
	 */
	public void setLinkman_tel3(String Linkman_tel3) {
		setAttrVal("Linkman_tel3", Linkman_tel3);
	}
	/**
	 * 邮编
	 * @return String
	 */
	public String getZip() {
		return ((String) getAttrVal("Zip"));
	}	
	/**
	 * 邮编
	 * @param Zip
	 */
	public void setZip(String Zip) {
		setAttrVal("Zip", Zip);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}	
	/**
	 * 地址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 机构代码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 机构代码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 经济类型编码
	 * @return String
	 */
	public String getSd_econ() {
		return ((String) getAttrVal("Sd_econ"));
	}	
	/**
	 * 经济类型编码
	 * @param Sd_econ
	 */
	public void setSd_econ(String Sd_econ) {
		setAttrVal("Sd_econ", Sd_econ);
	}
	/**
	 * 经济类型
	 * @return String
	 */
	public String getId_econ() {
		return ((String) getAttrVal("Id_econ"));
	}	
	/**
	 * 经济类型
	 * @param Id_econ
	 */
	public void setId_econ(String Id_econ) {
		setAttrVal("Id_econ", Id_econ);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 门诊就诊ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 门诊就诊ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 团体识别号
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	/**
	 * 团体识别号
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
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
	 * 门诊ID
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}	
	/**
	 * 门诊ID
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	 * 会员卡类别
	 * @return String
	 */
	public String getMemcard() {
		return ((String) getAttrVal("Memcard"));
	}	
	/**
	 * 会员卡类别
	 * @param Memcard
	 */
	public void setMemcard(String Memcard) {
		setAttrVal("Memcard", Memcard);
	}
	/**
	 * 网页密码
	 * @return String
	 */
	public String getPwweb() {
		return ((String) getAttrVal("Pwweb"));
	}	
	/**
	 * 网页密码
	 * @param Pwweb
	 */
	public void setPwweb(String Pwweb) {
		setAttrVal("Pwweb", Pwweb);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_corp() {
		return ((String) getAttrVal("Code_corp"));
	}	
	/**
	 * 单位编码
	 * @param Code_corp
	 */
	public void setCode_corp(String Code_corp) {
		setAttrVal("Code_corp", Code_corp);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}	
	/**
	 * 单位名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_econ() {
		return ((String) getAttrVal("Name_econ"));
	}	
	/**
	 * 名称
	 * @param Name_econ
	 */
	public void setName_econ(String Name_econ) {
		setAttrVal("Name_econ", Name_econ);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_econ() {
		return ((String) getAttrVal("Code_econ"));
	}	
	/**
	 * 编码
	 * @param Code_econ
	 */
	public void setCode_econ(String Code_econ) {
		setAttrVal("Code_econ", Code_econ);
	}
	/**
	 * 会员卡编码
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}	
	/**
	 * 会员卡编码
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 会员卡名称
	 * @return String
	 */
	public String getName_card() {
		return ((String) getAttrVal("Name_card"));
	}	
	/**
	 * 会员卡名称
	 * @param Name_card
	 */
	public void setName_card(String Name_card) {
		setAttrVal("Name_card", Name_card);
	}
	/**
	 * 折扣率
	 * @return FDouble
	 */
	public FDouble getRatio_discount() {
		return ((FDouble) getAttrVal("Ratio_discount"));
	}	
	/**
	 * 折扣率
	 * @param Ratio_discount
	 */
	public void setRatio_discount(FDouble Ratio_discount) {
		setAttrVal("Ratio_discount", Ratio_discount);
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
		return "Id_pecorpbinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecorpbinfo";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpbInfoDODesc.class);
	}
	
}