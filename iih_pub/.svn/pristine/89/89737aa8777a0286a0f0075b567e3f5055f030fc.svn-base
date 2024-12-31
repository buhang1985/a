package iih.pe.por.pepsnbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsnbinfo.d.desc.PePsnBInfoDODesc;
import java.math.BigDecimal;

/**
 * 体检客户基本资料 DO数据 
 * 
 */
public class PePsnBInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检客户主键标识
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//客户编码
	public static final String CODE= "Code";
	//姓名
	public static final String NAME= "Name";
	//英文名
	public static final String ENAME= "Ename";
	//证件类型编码
	public static final String SD_IDTP= "Sd_idtp";
	//证件类型ID
	public static final String ID_IDTP= "Id_idtp";
	//证件号码
	public static final String IDCODE= "Idcode";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//性别ID
	public static final String ID_SEX= "Id_sex";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//年龄
	public static final String AGE= "Age";
	//婚姻状况编码
	public static final String SD_MARRY= "Sd_marry";
	//婚姻状况ID
	public static final String ID_MARRY= "Id_marry";
	//移动电话
	public static final String MOB= "Mob";
	//家庭电话
	public static final String TEL= "Tel";
	//电子邮件
	public static final String EMAIL= "Email";
	//地址
	public static final String ADDR_STR= "Addr_str";
	//邮编
	public static final String ZIP= "Zip";
	//微信号
	public static final String WX= "Wx";
	//医保号
	public static final String NO_HP= "No_hp";
	//健康管理师
	public static final String HEALTH_RESP= "Health_resp";
	//民族编码
	public static final String SD_NATION= "Sd_nation";
	//民族ID
	public static final String ID_NATION= "Id_nation";
	//国籍编码
	public static final String SD_COUTRY= "Sd_coutry";
	//国籍ID
	public static final String ID_COUTRY= "Id_coutry";
	//信仰编码
	public static final String SD_BELIEF= "Sd_belief";
	//信仰ID
	public static final String ID_BELIEF= "Id_belief";
	//籍贯
	public static final String NATIVE_PLACE= "Native_place";
	//身份
	public static final String IDENTITY= "Identity";
	//职业编码
	public static final String SD_OCCU= "Sd_occu";
	//职业ID
	public static final String ID_OCCU= "Id_occu";
	//文化程度编码
	public static final String SD_EDUC= "Sd_educ";
	//文化程度ID
	public static final String ID_EDUC= "Id_educ";
	//隐私
	public static final String PRIVACY= "Privacy";
	//工作单位
	public static final String WORKUNIT= "Workunit";
	//密码
	public static final String PASSWORD= "Password";
	//门诊就诊ID
	public static final String ID_PAT= "Id_pat";
	//CHIS条码号
	public static final String BARCODE_CHIS= "Barcode_chis";
	//照片
	public static final String PHO= "Pho";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
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
	//发票名称
	public static final String NAME_INVOICE= "Name_invoice";
	//编码
	public static final String CODE_ID= "Code_id";
	//名称
	public static final String NAME_ID= "Name_id";
	//编码
	public static final String CODE_SEX= "Code_sex";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//编码
	public static final String CODE_MARRY= "Code_marry";
	//名称
	public static final String NAME_MARRY= "Name_marry";
	//编码
	public static final String CODE_NATION= "Code_nation";
	//名称
	public static final String NAME_NATION= "Name_nation";
	//名称
	public static final String NAME_CONTRY= "Name_contry";
	//三位代码
	public static final String CODETH_CONTRY= "Codeth_contry";
	//编码
	public static final String CODE_BELIEF= "Code_belief";
	//名称
	public static final String NAME_BELIEF= "Name_belief";
	//编码
	public static final String CODE_OCCU= "Code_occu";
	//名称
	public static final String NAME_OCCU= "Name_occu";
	//编码
	public static final String CODE_EDUC= "Code_educ";
	//名称
	public static final String NAME_EDUC= "Name_educ";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检客户主键标识
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户主键标识
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
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
	 * 客户编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 客户编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 英文名
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文名
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件类型ID
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	/**
	 * 证件类型ID
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别ID
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 婚姻状况ID
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	/**
	 * 婚姻状况ID
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 家庭电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 电子邮件
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}	
	/**
	 * 电子邮件
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getAddr_str() {
		return ((String) getAttrVal("Addr_str"));
	}	
	/**
	 * 地址
	 * @param Addr_str
	 */
	public void setAddr_str(String Addr_str) {
		setAttrVal("Addr_str", Addr_str);
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
	 * 微信号
	 * @return String
	 */
	public String getWx() {
		return ((String) getAttrVal("Wx"));
	}	
	/**
	 * 微信号
	 * @param Wx
	 */
	public void setWx(String Wx) {
		setAttrVal("Wx", Wx);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 健康管理师
	 * @return String
	 */
	public String getHealth_resp() {
		return ((String) getAttrVal("Health_resp"));
	}	
	/**
	 * 健康管理师
	 * @param Health_resp
	 */
	public void setHealth_resp(String Health_resp) {
		setAttrVal("Health_resp", Health_resp);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 民族ID
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	/**
	 * 民族ID
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getSd_coutry() {
		return ((String) getAttrVal("Sd_coutry"));
	}	
	/**
	 * 国籍编码
	 * @param Sd_coutry
	 */
	public void setSd_coutry(String Sd_coutry) {
		setAttrVal("Sd_coutry", Sd_coutry);
	}
	/**
	 * 国籍ID
	 * @return String
	 */
	public String getId_coutry() {
		return ((String) getAttrVal("Id_coutry"));
	}	
	/**
	 * 国籍ID
	 * @param Id_coutry
	 */
	public void setId_coutry(String Id_coutry) {
		setAttrVal("Id_coutry", Id_coutry);
	}
	/**
	 * 信仰编码
	 * @return String
	 */
	public String getSd_belief() {
		return ((String) getAttrVal("Sd_belief"));
	}	
	/**
	 * 信仰编码
	 * @param Sd_belief
	 */
	public void setSd_belief(String Sd_belief) {
		setAttrVal("Sd_belief", Sd_belief);
	}
	/**
	 * 信仰ID
	 * @return String
	 */
	public String getId_belief() {
		return ((String) getAttrVal("Id_belief"));
	}	
	/**
	 * 信仰ID
	 * @param Id_belief
	 */
	public void setId_belief(String Id_belief) {
		setAttrVal("Id_belief", Id_belief);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getNative_place() {
		return ((String) getAttrVal("Native_place"));
	}	
	/**
	 * 籍贯
	 * @param Native_place
	 */
	public void setNative_place(String Native_place) {
		setAttrVal("Native_place", Native_place);
	}
	/**
	 * 身份
	 * @return String
	 */
	public String getIdentity() {
		return ((String) getAttrVal("Identity"));
	}	
	/**
	 * 身份
	 * @param Identity
	 */
	public void setIdentity(String Identity) {
		setAttrVal("Identity", Identity);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}	
	/**
	 * 职业编码
	 * @param Sd_occu
	 */
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	/**
	 * 职业ID
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}	
	/**
	 * 职业ID
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getSd_educ() {
		return ((String) getAttrVal("Sd_educ"));
	}	
	/**
	 * 文化程度编码
	 * @param Sd_educ
	 */
	public void setSd_educ(String Sd_educ) {
		setAttrVal("Sd_educ", Sd_educ);
	}
	/**
	 * 文化程度ID
	 * @return String
	 */
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}	
	/**
	 * 文化程度ID
	 * @param Id_educ
	 */
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	/**
	 * 隐私
	 * @return String
	 */
	public String getPrivacy() {
		return ((String) getAttrVal("Privacy"));
	}	
	/**
	 * 隐私
	 * @param Privacy
	 */
	public void setPrivacy(String Privacy) {
		setAttrVal("Privacy", Privacy);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 密码
	 * @return String
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}	
	/**
	 * 密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
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
	 * CHIS条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}	
	/**
	 * CHIS条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 照片
	 * @return byte[]
	 */
	public byte[] getPho() {
		return ((byte[]) getAttrVal("Pho"));
	}	
	/**
	 * 照片
	 * @param Pho
	 */
	public void setPho(byte[] Pho) {
		setAttrVal("Pho", Pho);
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
	 * 发票名称
	 * @return String
	 */
	public String getName_invoice() {
		return ((String) getAttrVal("Name_invoice"));
	}	
	/**
	 * 发票名称
	 * @param Name_invoice
	 */
	public void setName_invoice(String Name_invoice) {
		setAttrVal("Name_invoice", Name_invoice);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}	
	/**
	 * 编码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_id() {
		return ((String) getAttrVal("Name_id"));
	}	
	/**
	 * 名称
	 * @param Name_id
	 */
	public void setName_id(String Name_id) {
		setAttrVal("Name_id", Name_id);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	/**
	 * 编码
	 * @param Code_marry
	 */
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	/**
	 * 名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	/**
	 * 编码
	 * @param Code_nation
	 */
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_contry() {
		return ((String) getAttrVal("Name_contry"));
	}	
	/**
	 * 名称
	 * @param Name_contry
	 */
	public void setName_contry(String Name_contry) {
		setAttrVal("Name_contry", Name_contry);
	}
	/**
	 * 三位代码
	 * @return String
	 */
	public String getCodeth_contry() {
		return ((String) getAttrVal("Codeth_contry"));
	}	
	/**
	 * 三位代码
	 * @param Codeth_contry
	 */
	public void setCodeth_contry(String Codeth_contry) {
		setAttrVal("Codeth_contry", Codeth_contry);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_belief() {
		return ((String) getAttrVal("Code_belief"));
	}	
	/**
	 * 编码
	 * @param Code_belief
	 */
	public void setCode_belief(String Code_belief) {
		setAttrVal("Code_belief", Code_belief);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_belief() {
		return ((String) getAttrVal("Name_belief"));
	}	
	/**
	 * 名称
	 * @param Name_belief
	 */
	public void setName_belief(String Name_belief) {
		setAttrVal("Name_belief", Name_belief);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_occu() {
		return ((String) getAttrVal("Code_occu"));
	}	
	/**
	 * 编码
	 * @param Code_occu
	 */
	public void setCode_occu(String Code_occu) {
		setAttrVal("Code_occu", Code_occu);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}	
	/**
	 * 名称
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_educ() {
		return ((String) getAttrVal("Code_educ"));
	}	
	/**
	 * 编码
	 * @param Code_educ
	 */
	public void setCode_educ(String Code_educ) {
		setAttrVal("Code_educ", Code_educ);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}	
	/**
	 * 名称
	 * @param Name_educ
	 */
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
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
		return "Id_pepsnbinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pepsnbinfo";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnBInfoDODesc.class);
	}
	
}