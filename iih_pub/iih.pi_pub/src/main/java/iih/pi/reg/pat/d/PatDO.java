package iih.pi.reg.pat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.pat.d.desc.PatDODesc;
import java.math.BigDecimal;

/**
 * 患者基本信息 DO数据 
 * 
 */
public class PatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者信息主键标识
	public static final String ID_PAT= "Id_pat";
	//所属机构
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//患者编码
	public static final String CODE= "Code";
	//患者姓名
	public static final String NAME= "Name";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//主身份标志类型
	public static final String ID_IDTP= "Id_idtp";
	//主身份标志类型编码
	public static final String SD_IDTP= "Sd_idtp";
	//主身份标识号码
	public static final String ID_CODE= "Id_code";
	//患者分类
	public static final String ID_PATICATE= "Id_paticate";
	//价格分类
	public static final String ID_PATPRITP= "Id_patpritp";
	//信用分类
	public static final String ID_PATCRETTP= "Id_patcrettp";
	//性别
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//出生日期(时分秒)
	public static final String DT_BIRTH_HMS= "Dt_birth_hms";
	//固定电话
	public static final String TEL= "Tel";
	//移动电话
	public static final String MOB= "Mob";
	//民族
	public static final String ID_NATION= "Id_nation";
	//民族编码
	public static final String SD_NATION= "Sd_nation";
	//国家
	public static final String ID_COUNTRY= "Id_country";
	//国家编码
	public static final String SD_COUNTRY= "Sd_country";
	//患者来源地类型
	public static final String ID_SRCREGIONTP= "Id_srcregiontp";
	//患者来源地类型编码
	public static final String SD_SRCREGIONTP= "Sd_srcregiontp";
	//婚姻
	public static final String ID_MARRY= "Id_marry";
	//婚姻编码
	public static final String SD_MARRY= "Sd_marry";
	//职业
	public static final String ID_OCCU= "Id_occu";
	//职业编码
	public static final String SD_OCCU= "Sd_occu";
	//工作单位
	public static final String WORKUNIT= "Workunit";
	//门诊病案编号
	public static final String CODE_AMR_OEP= "Code_amr_oep";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//照片
	public static final String PHOTO= "Photo";
	//患者登录用户
	public static final String ID_LOG= "Id_log";
	//失效类型
	public static final String ID_PIINVDMD= "Id_piinvdmd";
	//失效类型编码
	public static final String SD_PIINVDMD= "Sd_piinvdmd";
	//失效描述
	public static final String PRIINVDDES= "Priinvddes";
	//失效标志
	public static final String FG_INVD= "Fg_invd";
	//实名认证
	public static final String FG_REALNAME= "Fg_realname";
	//年龄
	public static final String AGE= "Age";
	//文化程度
	public static final String ID_EDUC= "Id_educ";
	//文化程度编码
	public static final String SD_EDUC= "Sd_educ";
	//建档来源类型
	public static final String ID_PATSRCTP= "Id_patsrctp";
	//建档来源类型编码
	public static final String SD_PATSRCTP= "Sd_patsrctp";
	//CHIS条码号
	public static final String BARCODE_CHIS= "Barcode_chis";
	//密码
	public static final String PASSWORD= "Password";
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
	//建档人员
	public static final String ID_EMP_CREATE= "Id_emp_create";
	//第三方系统主键
	public static final String ID_THIRD= "Id_third";
	//门诊次数
	public static final String LAST_TIMES_OEP= "Last_times_oep";
	//住院次数
	public static final String LAST_TIMES_IP= "Last_times_ip";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否同步就诊数据
	public static final String FG_SYNC_EN= "Fg_sync_en";
	//患者标签
	public static final String ID_MARK= "Id_mark";
	//患者标签编码
	public static final String SD_MARK= "Sd_mark";
	//域
	public static final String DOMAIN= "Domain";
	//数据来源
	public static final String ORIGIN= "Origin";
	//创建来源
	public static final String CREATE_ORIGIN= "Create_origin";
	//empi主索引
	public static final String EMPI_ID= "Empi_id";
	//密码输入值
	public static final String INPUT_PSW= "Input_psw";
	//区县
	public static final String ID_ADMDIV= "Id_admdiv";
	//区县码
	public static final String SD_ADMDIV= "Sd_admdiv";
	//街道
	public static final String STREET= "Street";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//医保证件号码
	public static final String NO_HP= "No_hp";
	//chis存在
	public static final String FG_CHISEXIST= "Fg_chisexist";
	//患者分类医保计划
	public static final String CA_ID_HP= "Ca_id_hp";
	//患者分类医保计划名称
	public static final String CA_NAME_HP= "Ca_name_hp";
	//忽略chis
	public static final String FG_IGNORECHIS= "Fg_ignorechis";
	//病历本费收取标记
	public static final String FG_RECORDCOST= "Fg_recordcost";
	//就诊卡号
	public static final String CODE_ENCARD= "Code_encard";
	//是否处理标签
	public static final String FG_DEALTAG= "Fg_dealtag";
	//自然人标识
	public static final String ID_PERSON= "Id_person";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//电子邮件地址
	public static final String EMAIL= "Email";
	//证件不详原因
	public static final String ID_UNKWRSN= "Id_unkwrsn";
	//证件不详原因编码
	public static final String SD_UNKWRSN= "Sd_unkwrsn";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//集团编码
	public static final String GRPCODE= "Grpcode";
	//集团名称
	public static final String GRPNAME= "Grpname";
	//编码
	public static final String IDTP_CODE= "Idtp_code";
	//名称
	public static final String IDTP_NAME= "Idtp_name";
	//患者分类编码
	public static final String PATICATE_CODE= "Paticate_code";
	//患者分类名称
	public static final String PATICATE_NAME= "Paticate_name";
	//患者价格分类编码
	public static final String PATPRITP_CODE= "Patpritp_code";
	//患者价格分类名称
	public static final String PATPRITP_NAME= "Patpritp_name";
	//患者信用分类编码
	public static final String PATCRETTP_CODE= "Patcrettp_code";
	//者信用分类名称
	public static final String PATCRETTP_NAME= "Patcrettp_name";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//编码
	public static final String CODE_SEX= "Code_sex";
	//编码
	public static final String NATION_CODE= "Nation_code";
	//名称
	public static final String NATION_NAME= "Nation_name";
	//名称
	public static final String COUNTRY_NAME= "Country_name";
	//国家地区编码
	public static final String COUNTRY_CODE= "Country_code";
	//患者来源地类型名称
	public static final String NAME_SRCREGIONTP= "Name_srcregiontp";
	//编码
	public static final String MARRY_CODE= "Marry_code";
	//名称
	public static final String MARRY_NAME= "Marry_name";
	//编码
	public static final String OCCU_CODE= "Occu_code";
	//名称
	public static final String OCCU_NAME= "Occu_name";
	//名称
	public static final String NAME_EDUC= "Name_educ";
	//建档来源类型名称
	public static final String NAME_PATSRCTP= "Name_patsrctp";
	//姓名
	public static final String NAME_EMP_CREATE= "Name_emp_create";
	//用户名称
	public static final String CREATEBY_NAME= "Createby_name";
	//用户编码
	public static final String CREATEBY_CODE= "Createby_code";
	//用户名称
	public static final String MODIFY_NAME= "Modify_name";
	//用户编码
	public static final String MODIFY_CODE= "Modify_code";
	//名称
	public static final String MARKNAME= "Markname";
	//行政区划全称
	public static final String ADMDIV_FULLNAME= "Admdiv_fullname";
	//医保计划名称
	public static final String HP_NAME= "Hp_name";
	//医保号码必填标志
	public static final String FG_REQHPCODE= "Fg_reqhpcode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者信息主键标识
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者信息主键标识
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 所属机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 患者编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
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
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_paticate() {
		return ((String) getAttrVal("Id_paticate"));
	}	
	/**
	 * 患者分类
	 * @param Id_paticate
	 */
	public void setId_paticate(String Id_paticate) {
		setAttrVal("Id_paticate", Id_paticate);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}	
	/**
	 * 价格分类
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getId_patcrettp() {
		return ((String) getAttrVal("Id_patcrettp"));
	}	
	/**
	 * 信用分类
	 * @param Id_patcrettp
	 */
	public void setId_patcrettp(String Id_patcrettp) {
		setAttrVal("Id_patcrettp", Id_patcrettp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
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
	 * 出生日期(时分秒)
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_hms() {
		return ((FDateTime) getAttrVal("Dt_birth_hms"));
	}	
	/**
	 * 出生日期(时分秒)
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(FDateTime Dt_birth_hms) {
		setAttrVal("Dt_birth_hms", Dt_birth_hms);
	}
	/**
	 * 固定电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 固定电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
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
	 * 民族
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	/**
	 * 民族
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
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
	 * 国家
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}	
	/**
	 * 国家
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国家编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}	
	/**
	 * 国家编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 患者来源地类型
	 * @return String
	 */
	public String getId_srcregiontp() {
		return ((String) getAttrVal("Id_srcregiontp"));
	}	
	/**
	 * 患者来源地类型
	 * @param Id_srcregiontp
	 */
	public void setId_srcregiontp(String Id_srcregiontp) {
		setAttrVal("Id_srcregiontp", Id_srcregiontp);
	}
	/**
	 * 患者来源地类型编码
	 * @return String
	 */
	public String getSd_srcregiontp() {
		return ((String) getAttrVal("Sd_srcregiontp"));
	}	
	/**
	 * 患者来源地类型编码
	 * @param Sd_srcregiontp
	 */
	public void setSd_srcregiontp(String Sd_srcregiontp) {
		setAttrVal("Sd_srcregiontp", Sd_srcregiontp);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	/**
	 * 婚姻
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}	
	/**
	 * 职业
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
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
	 * 门诊病案编号
	 * @return String
	 */
	public String getCode_amr_oep() {
		return ((String) getAttrVal("Code_amr_oep"));
	}	
	/**
	 * 门诊病案编号
	 * @param Code_amr_oep
	 */
	public void setCode_amr_oep(String Code_amr_oep) {
		setAttrVal("Code_amr_oep", Code_amr_oep);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 照片
	 * @return byte[]
	 */
	public byte[] getPhoto() {
		return ((byte[]) getAttrVal("Photo"));
	}	
	/**
	 * 照片
	 * @param Photo
	 */
	public void setPhoto(byte[] Photo) {
		setAttrVal("Photo", Photo);
	}
	/**
	 * 患者登录用户
	 * @return String
	 */
	public String getId_log() {
		return ((String) getAttrVal("Id_log"));
	}	
	/**
	 * 患者登录用户
	 * @param Id_log
	 */
	public void setId_log(String Id_log) {
		setAttrVal("Id_log", Id_log);
	}
	/**
	 * 失效类型
	 * @return String
	 */
	public String getId_piinvdmd() {
		return ((String) getAttrVal("Id_piinvdmd"));
	}	
	/**
	 * 失效类型
	 * @param Id_piinvdmd
	 */
	public void setId_piinvdmd(String Id_piinvdmd) {
		setAttrVal("Id_piinvdmd", Id_piinvdmd);
	}
	/**
	 * 失效类型编码
	 * @return String
	 */
	public String getSd_piinvdmd() {
		return ((String) getAttrVal("Sd_piinvdmd"));
	}	
	/**
	 * 失效类型编码
	 * @param Sd_piinvdmd
	 */
	public void setSd_piinvdmd(String Sd_piinvdmd) {
		setAttrVal("Sd_piinvdmd", Sd_piinvdmd);
	}
	/**
	 * 失效描述
	 * @return String
	 */
	public String getPriinvddes() {
		return ((String) getAttrVal("Priinvddes"));
	}	
	/**
	 * 失效描述
	 * @param Priinvddes
	 */
	public void setPriinvddes(String Priinvddes) {
		setAttrVal("Priinvddes", Priinvddes);
	}
	/**
	 * 失效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_invd() {
		return ((FBoolean) getAttrVal("Fg_invd"));
	}	
	/**
	 * 失效标志
	 * @param Fg_invd
	 */
	public void setFg_invd(FBoolean Fg_invd) {
		setAttrVal("Fg_invd", Fg_invd);
	}
	/**
	 * 实名认证
	 * @return FBoolean
	 */
	public FBoolean getFg_realname() {
		return ((FBoolean) getAttrVal("Fg_realname"));
	}	
	/**
	 * 实名认证
	 * @param Fg_realname
	 */
	public void setFg_realname(FBoolean Fg_realname) {
		setAttrVal("Fg_realname", Fg_realname);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}	
	/**
	 * 文化程度
	 * @param Id_educ
	 */
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
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
	 * 建档来源类型
	 * @return String
	 */
	public String getId_patsrctp() {
		return ((String) getAttrVal("Id_patsrctp"));
	}	
	/**
	 * 建档来源类型
	 * @param Id_patsrctp
	 */
	public void setId_patsrctp(String Id_patsrctp) {
		setAttrVal("Id_patsrctp", Id_patsrctp);
	}
	/**
	 * 建档来源类型编码
	 * @return String
	 */
	public String getSd_patsrctp() {
		return ((String) getAttrVal("Sd_patsrctp"));
	}	
	/**
	 * 建档来源类型编码
	 * @param Sd_patsrctp
	 */
	public void setSd_patsrctp(String Sd_patsrctp) {
		setAttrVal("Sd_patsrctp", Sd_patsrctp);
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
	 * 建档人员
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	/**
	 * 建档人员
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 第三方系统主键
	 * @return String
	 */
	public String getId_third() {
		return ((String) getAttrVal("Id_third"));
	}	
	/**
	 * 第三方系统主键
	 * @param Id_third
	 */
	public void setId_third(String Id_third) {
		setAttrVal("Id_third", Id_third);
	}
	/**
	 * 门诊次数
	 * @return Integer
	 */
	public Integer getLast_times_oep() {
		return ((Integer) getAttrVal("Last_times_oep"));
	}	
	/**
	 * 门诊次数
	 * @param Last_times_oep
	 */
	public void setLast_times_oep(Integer Last_times_oep) {
		setAttrVal("Last_times_oep", Last_times_oep);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getLast_times_ip() {
		return ((Integer) getAttrVal("Last_times_ip"));
	}	
	/**
	 * 住院次数
	 * @param Last_times_ip
	 */
	public void setLast_times_ip(Integer Last_times_ip) {
		setAttrVal("Last_times_ip", Last_times_ip);
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
	 * 是否同步就诊数据
	 * @return FBoolean
	 */
	public FBoolean getFg_sync_en() {
		return ((FBoolean) getAttrVal("Fg_sync_en"));
	}	
	/**
	 * 是否同步就诊数据
	 * @param Fg_sync_en
	 */
	public void setFg_sync_en(FBoolean Fg_sync_en) {
		setAttrVal("Fg_sync_en", Fg_sync_en);
	}
	/**
	 * 患者标签
	 * @return String
	 */
	public String getId_mark() {
		return ((String) getAttrVal("Id_mark"));
	}	
	/**
	 * 患者标签
	 * @param Id_mark
	 */
	public void setId_mark(String Id_mark) {
		setAttrVal("Id_mark", Id_mark);
	}
	/**
	 * 患者标签编码
	 * @return String
	 */
	public String getSd_mark() {
		return ((String) getAttrVal("Sd_mark"));
	}	
	/**
	 * 患者标签编码
	 * @param Sd_mark
	 */
	public void setSd_mark(String Sd_mark) {
		setAttrVal("Sd_mark", Sd_mark);
	}
	/**
	 * 域
	 * @return String
	 */
	public String getDomain() {
		return ((String) getAttrVal("Domain"));
	}	
	/**
	 * 域
	 * @param Domain
	 */
	public void setDomain(String Domain) {
		setAttrVal("Domain", Domain);
	}
	/**
	 * 数据来源
	 * @return String
	 */
	public String getOrigin() {
		return ((String) getAttrVal("Origin"));
	}	
	/**
	 * 数据来源
	 * @param Origin
	 */
	public void setOrigin(String Origin) {
		setAttrVal("Origin", Origin);
	}
	/**
	 * 创建来源
	 * @return String
	 */
	public String getCreate_origin() {
		return ((String) getAttrVal("Create_origin"));
	}	
	/**
	 * 创建来源
	 * @param Create_origin
	 */
	public void setCreate_origin(String Create_origin) {
		setAttrVal("Create_origin", Create_origin);
	}
	/**
	 * empi主索引
	 * @return String
	 */
	public String getEmpi_id() {
		return ((String) getAttrVal("Empi_id"));
	}	
	/**
	 * empi主索引
	 * @param Empi_id
	 */
	public void setEmpi_id(String Empi_id) {
		setAttrVal("Empi_id", Empi_id);
	}
	/**
	 * 密码输入值
	 * @return String
	 */
	public String getInput_psw() {
		return ((String) getAttrVal("Input_psw"));
	}	
	/**
	 * 密码输入值
	 * @param Input_psw
	 */
	public void setInput_psw(String Input_psw) {
		setAttrVal("Input_psw", Input_psw);
	}
	/**
	 * 区县
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}	
	/**
	 * 区县
	 * @param Id_admdiv
	 */
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	/**
	 * 区县码
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}	
	/**
	 * 区县码
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	/**
	 * 街道
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}	
	/**
	 * 街道
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保证件号码
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保证件号码
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * chis存在
	 * @return FBoolean
	 */
	public FBoolean getFg_chisexist() {
		return ((FBoolean) getAttrVal("Fg_chisexist"));
	}	
	/**
	 * chis存在
	 * @param Fg_chisexist
	 */
	public void setFg_chisexist(FBoolean Fg_chisexist) {
		setAttrVal("Fg_chisexist", Fg_chisexist);
	}
	/**
	 * 患者分类医保计划
	 * @return String
	 */
	public String getCa_id_hp() {
		return ((String) getAttrVal("Ca_id_hp"));
	}	
	/**
	 * 患者分类医保计划
	 * @param Ca_id_hp
	 */
	public void setCa_id_hp(String Ca_id_hp) {
		setAttrVal("Ca_id_hp", Ca_id_hp);
	}
	/**
	 * 患者分类医保计划名称
	 * @return String
	 */
	public String getCa_name_hp() {
		return ((String) getAttrVal("Ca_name_hp"));
	}	
	/**
	 * 患者分类医保计划名称
	 * @param Ca_name_hp
	 */
	public void setCa_name_hp(String Ca_name_hp) {
		setAttrVal("Ca_name_hp", Ca_name_hp);
	}
	/**
	 * 忽略chis
	 * @return FBoolean
	 */
	public FBoolean getFg_ignorechis() {
		return ((FBoolean) getAttrVal("Fg_ignorechis"));
	}	
	/**
	 * 忽略chis
	 * @param Fg_ignorechis
	 */
	public void setFg_ignorechis(FBoolean Fg_ignorechis) {
		setAttrVal("Fg_ignorechis", Fg_ignorechis);
	}
	/**
	 * 病历本费收取标记
	 * @return FBoolean
	 */
	public FBoolean getFg_recordcost() {
		return ((FBoolean) getAttrVal("Fg_recordcost"));
	}	
	/**
	 * 病历本费收取标记
	 * @param Fg_recordcost
	 */
	public void setFg_recordcost(FBoolean Fg_recordcost) {
		setAttrVal("Fg_recordcost", Fg_recordcost);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_encard() {
		return ((String) getAttrVal("Code_encard"));
	}	
	/**
	 * 就诊卡号
	 * @param Code_encard
	 */
	public void setCode_encard(String Code_encard) {
		setAttrVal("Code_encard", Code_encard);
	}
	/**
	 * 是否处理标签
	 * @return FBoolean
	 */
	public FBoolean getFg_dealtag() {
		return ((FBoolean) getAttrVal("Fg_dealtag"));
	}	
	/**
	 * 是否处理标签
	 * @param Fg_dealtag
	 */
	public void setFg_dealtag(FBoolean Fg_dealtag) {
		setAttrVal("Fg_dealtag", Fg_dealtag);
	}
	/**
	 * 自然人标识
	 * @return String
	 */
	public String getId_person() {
		return ((String) getAttrVal("Id_person"));
	}	
	/**
	 * 自然人标识
	 * @param Id_person
	 */
	public void setId_person(String Id_person) {
		setAttrVal("Id_person", Id_person);
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
	 * 电子邮件地址
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}	
	/**
	 * 电子邮件地址
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 证件不详原因
	 * @return String
	 */
	public String getId_unkwrsn() {
		return ((String) getAttrVal("Id_unkwrsn"));
	}	
	/**
	 * 证件不详原因
	 * @param Id_unkwrsn
	 */
	public void setId_unkwrsn(String Id_unkwrsn) {
		setAttrVal("Id_unkwrsn", Id_unkwrsn);
	}
	/**
	 * 证件不详原因编码
	 * @return String
	 */
	public String getSd_unkwrsn() {
		return ((String) getAttrVal("Sd_unkwrsn"));
	}	
	/**
	 * 证件不详原因编码
	 * @param Sd_unkwrsn
	 */
	public void setSd_unkwrsn(String Sd_unkwrsn) {
		setAttrVal("Sd_unkwrsn", Sd_unkwrsn);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 集团编码
	 * @return String
	 */
	public String getGrpcode() {
		return ((String) getAttrVal("Grpcode"));
	}	
	/**
	 * 集团编码
	 * @param Grpcode
	 */
	public void setGrpcode(String Grpcode) {
		setAttrVal("Grpcode", Grpcode);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getGrpname() {
		return ((String) getAttrVal("Grpname"));
	}	
	/**
	 * 集团名称
	 * @param Grpname
	 */
	public void setGrpname(String Grpname) {
		setAttrVal("Grpname", Grpname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIdtp_code() {
		return ((String) getAttrVal("Idtp_code"));
	}	
	/**
	 * 编码
	 * @param Idtp_code
	 */
	public void setIdtp_code(String Idtp_code) {
		setAttrVal("Idtp_code", Idtp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIdtp_name() {
		return ((String) getAttrVal("Idtp_name"));
	}	
	/**
	 * 名称
	 * @param Idtp_name
	 */
	public void setIdtp_name(String Idtp_name) {
		setAttrVal("Idtp_name", Idtp_name);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getPaticate_code() {
		return ((String) getAttrVal("Paticate_code"));
	}	
	/**
	 * 患者分类编码
	 * @param Paticate_code
	 */
	public void setPaticate_code(String Paticate_code) {
		setAttrVal("Paticate_code", Paticate_code);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getPaticate_name() {
		return ((String) getAttrVal("Paticate_name"));
	}	
	/**
	 * 患者分类名称
	 * @param Paticate_name
	 */
	public void setPaticate_name(String Paticate_name) {
		setAttrVal("Paticate_name", Paticate_name);
	}
	/**
	 * 患者价格分类编码
	 * @return String
	 */
	public String getPatpritp_code() {
		return ((String) getAttrVal("Patpritp_code"));
	}	
	/**
	 * 患者价格分类编码
	 * @param Patpritp_code
	 */
	public void setPatpritp_code(String Patpritp_code) {
		setAttrVal("Patpritp_code", Patpritp_code);
	}
	/**
	 * 患者价格分类名称
	 * @return String
	 */
	public String getPatpritp_name() {
		return ((String) getAttrVal("Patpritp_name"));
	}	
	/**
	 * 患者价格分类名称
	 * @param Patpritp_name
	 */
	public void setPatpritp_name(String Patpritp_name) {
		setAttrVal("Patpritp_name", Patpritp_name);
	}
	/**
	 * 患者信用分类编码
	 * @return String
	 */
	public String getPatcrettp_code() {
		return ((String) getAttrVal("Patcrettp_code"));
	}	
	/**
	 * 患者信用分类编码
	 * @param Patcrettp_code
	 */
	public void setPatcrettp_code(String Patcrettp_code) {
		setAttrVal("Patcrettp_code", Patcrettp_code);
	}
	/**
	 * 者信用分类名称
	 * @return String
	 */
	public String getPatcrettp_name() {
		return ((String) getAttrVal("Patcrettp_name"));
	}	
	/**
	 * 者信用分类名称
	 * @param Patcrettp_name
	 */
	public void setPatcrettp_name(String Patcrettp_name) {
		setAttrVal("Patcrettp_name", Patcrettp_name);
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
	 * 编码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	/**
	 * 编码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}	
	/**
	 * 名称
	 * @param Nation_name
	 */
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCountry_name() {
		return ((String) getAttrVal("Country_name"));
	}	
	/**
	 * 名称
	 * @param Country_name
	 */
	public void setCountry_name(String Country_name) {
		setAttrVal("Country_name", Country_name);
	}
	/**
	 * 国家地区编码
	 * @return String
	 */
	public String getCountry_code() {
		return ((String) getAttrVal("Country_code"));
	}	
	/**
	 * 国家地区编码
	 * @param Country_code
	 */
	public void setCountry_code(String Country_code) {
		setAttrVal("Country_code", Country_code);
	}
	/**
	 * 患者来源地类型名称
	 * @return String
	 */
	public String getName_srcregiontp() {
		return ((String) getAttrVal("Name_srcregiontp"));
	}	
	/**
	 * 患者来源地类型名称
	 * @param Name_srcregiontp
	 */
	public void setName_srcregiontp(String Name_srcregiontp) {
		setAttrVal("Name_srcregiontp", Name_srcregiontp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	/**
	 * 编码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMarry_name() {
		return ((String) getAttrVal("Marry_name"));
	}	
	/**
	 * 名称
	 * @param Marry_name
	 */
	public void setMarry_name(String Marry_name) {
		setAttrVal("Marry_name", Marry_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOccu_code() {
		return ((String) getAttrVal("Occu_code"));
	}	
	/**
	 * 编码
	 * @param Occu_code
	 */
	public void setOccu_code(String Occu_code) {
		setAttrVal("Occu_code", Occu_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOccu_name() {
		return ((String) getAttrVal("Occu_name"));
	}	
	/**
	 * 名称
	 * @param Occu_name
	 */
	public void setOccu_name(String Occu_name) {
		setAttrVal("Occu_name", Occu_name);
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
	/**
	 * 建档来源类型名称
	 * @return String
	 */
	public String getName_patsrctp() {
		return ((String) getAttrVal("Name_patsrctp"));
	}	
	/**
	 * 建档来源类型名称
	 * @param Name_patsrctp
	 */
	public void setName_patsrctp(String Name_patsrctp) {
		setAttrVal("Name_patsrctp", Name_patsrctp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createby_name
	 */
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createby_code
	 */
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModify_name() {
		return ((String) getAttrVal("Modify_name"));
	}	
	/**
	 * 用户名称
	 * @param Modify_name
	 */
	public void setModify_name(String Modify_name) {
		setAttrVal("Modify_name", Modify_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModify_code() {
		return ((String) getAttrVal("Modify_code"));
	}	
	/**
	 * 用户编码
	 * @param Modify_code
	 */
	public void setModify_code(String Modify_code) {
		setAttrVal("Modify_code", Modify_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMarkname() {
		return ((String) getAttrVal("Markname"));
	}	
	/**
	 * 名称
	 * @param Markname
	 */
	public void setMarkname(String Markname) {
		setAttrVal("Markname", Markname);
	}
	/**
	 * 行政区划全称
	 * @return String
	 */
	public String getAdmdiv_fullname() {
		return ((String) getAttrVal("Admdiv_fullname"));
	}	
	/**
	 * 行政区划全称
	 * @param Admdiv_fullname
	 */
	public void setAdmdiv_fullname(String Admdiv_fullname) {
		setAttrVal("Admdiv_fullname", Admdiv_fullname);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保计划名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	/**
	 * 医保号码必填标志
	 * @return FBoolean
	 */
	public FBoolean getFg_reqhpcode() {
		return ((FBoolean) getAttrVal("Fg_reqhpcode"));
	}	
	/**
	 * 医保号码必填标志
	 * @param Fg_reqhpcode
	 */
	public void setFg_reqhpcode(FBoolean Fg_reqhpcode) {
		setAttrVal("Fg_reqhpcode", Fg_reqhpcode);
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
		return "Id_pat";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatDODesc.class);
	}
	
}