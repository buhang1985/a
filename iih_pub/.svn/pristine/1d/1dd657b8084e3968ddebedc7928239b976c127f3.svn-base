package iih.nm.nhr.nmpsndoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmpsndoc.d.desc.NmNurDODesc;
import java.math.BigDecimal;

/**
 * 护理人员属性 DO数据 
 * 
 */
public class NmNurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//护士标识主键
	public static final String ID_NUR= "Id_nur";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//人员id
	public static final String ID_PSNDOC= "Id_psndoc";
	//人员姓名
	public static final String NAME= "Name";
	//护理人员类别
	public static final String ID_NURTP= "Id_nurtp";
	//护理人员类别编码
	public static final String SD_NURTP= "Sd_nurtp";
	//身高
	public static final String HEIGHT= "Height";
	//服装号
	public static final String CODE_CLOTHES= "Code_clothes";
	//工号
	public static final String JOB_NO= "Job_no";
	//鞋号
	public static final String SIZE_SHOE= "Size_shoe";
	//到院前护龄
	public static final String YEARS_NR_BEFO= "Years_nr_befo";
	//护士层级id
	public static final String ID_NUR_LEVEL= "Id_nur_level";
	//护士层级编码
	public static final String SD_NUR_LEVEL= "Sd_nur_level";
	//学分卡
	public static final String NO_CREDIT= "No_credit";
	//到院日期
	public static final String DT_IN= "Dt_in";
	//注销日期
	public static final String DT_OUT= "Dt_out";
	//注销 原因id
	public static final String ID_OUT_RES= "Id_out_res";
	//注销原因编码
	public static final String SD_OUT_RES= "Sd_out_res";
	//所属支部编号
	public static final String NO_BRAN_PART= "No_bran_part";
	//考勤标识
	public static final String FG_ATTEND= "Fg_attend";
	//排班标识
	public static final String FG_SCHEDULE= "Fg_schedule";
	//轮转标识
	public static final String FG_TURN= "Fg_turn";
	//机动标识
	public static final String FG_MOVE= "Fg_move";
	//科护士长标识
	public static final String FG_UNITLEADER= "Fg_unitleader";
	//实习生标识
	public static final String FG_INTERN= "Fg_intern";
	//应急护士
	public static final String FG_URGENCY= "Fg_urgency";
	//院校ID
	public static final String ID_STU_ORG= "Id_stu_org";
	//实习生批次id
	public static final String ID_INTERN_BATCH= "Id_intern_batch";
	//传染病证书编号
	public static final String NO_INFEC_CFN= "No_infec_cfn";
	//备注
	public static final String DES= "Des";
	//学历id
	public static final String ID_EDUCATION= "Id_education";
	//学历编码
	public static final String SD_EDUCATION= "Sd_education";
	//英语级别id
	public static final String ID_ENG_LEVEL= "Id_eng_level";
	//英语级别编码
	public static final String SD_ENG_LEVEL= "Sd_eng_level";
	//英语能力描述
	public static final String ENG_ABILITY= "Eng_ability";
	//计算机等级id
	public static final String ID_COMPUTER_LEVEL= "Id_computer_level";
	//计算机等级
	public static final String SD_COMPUTER_LEVEL= "Sd_computer_level";
	//参加工作时间
	public static final String INWORKTIME= "Inworktime";
	//执业证号
	public static final String LICENSENUM= "Licensenum";
	//带教资格id1
	public static final String ID_TCH_QC1= "Id_tch_qc1";
	//带教资格编码1
	public static final String SD_TCH_QC1= "Sd_tch_qc1";
	//带教资格id2
	public static final String ID_TCH_QC2= "Id_tch_qc2";
	//带教资格编码2
	public static final String SD_TCH_QC2= "Sd_tch_qc2";
	//带教资格id3
	public static final String ID_TCH_QC3= "Id_tch_qc3";
	//带教资格编码3
	public static final String SD_TCH_QC3= "Sd_tch_qc3";
	//带教准入日期1
	public static final String DT_TCH1= "Dt_tch1";
	//带教准入日期2
	public static final String DT_TCH2= "Dt_tch2";
	//带教准入日期3
	public static final String DT_TCH3= "Dt_tch3";
	//国家级专科护士id
	public static final String ID_SPEC_NUR1= "Id_spec_nur1";
	//国家级专科护士编码
	public static final String SD_SPEC_NUR1= "Sd_spec_nur1";
	//省级专科护士id
	public static final String ID_SPEC_NUR2= "Id_spec_nur2";
	//省级专科护士编码
	public static final String SD_SPEC_NUR2= "Sd_spec_nur2";
	//地市级专科护士id
	public static final String ID_SPEC_NUR3= "Id_spec_nur3";
	//地市级专科护士编码
	public static final String SD_SPEC_NUR3= "Sd_spec_nur3";
	//专科小组id
	public static final String ID_SPEC_GRP= "Id_spec_grp";
	//专科小组编码
	public static final String SD_SPEC_GRP= "Sd_spec_grp";
	//社会任职
	public static final String SOCIAL_SERVICE= "Social_service";
	//个人特长
	public static final String PER_POINT= "Per_point";
	//在职状态
	public static final String INWORK_FLAG= "Inwork_flag";
	//作废标志 
	public static final String INVALID_FLAG= "Invalid_flag";
	//姓名简称
	public static final String SHROTNAME= "Shrotname";
	//人员编码
	public static final String CODE= "Code";
	//证件类型
	public static final String IDTYPE= "Idtype";
	//证件号码
	public static final String IDCARD= "Idcard";
	//性别
	public static final String SEX= "Sex";
	//出生日期
	public static final String BIRTHDAY= "Birthday";
	//籍贯
	public static final String VATIVEPLACE= "Vativeplace";
	//户籍地址
	public static final String CENSUSADDR= "Censusaddr";
	//户口性质
	public static final String CHARACTERRPR= "Characterrpr";
	//民族
	public static final String NATIONATILY= "Nationatily";
	//政治面貌
	public static final String POLITY= "Polity";
	//健康状况
	public static final String HEALTH= "Health";
	//婚姻状况
	public static final String MARITAL= "Marital";
	//手机
	public static final String MOBILE= "Mobile";
	//电子邮件
	public static final String EMAIL= "Email";
	//家庭电话
	public static final String HOMEPHONE= "Homephone";
	//家庭地址
	public static final String ADDR= "Addr";
	//邮政编码
	public static final String POSTALCODE= "Postalcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//曾用名
	public static final String USEDNAME= "Usedname";
	//血型
	public static final String BLOODTYPE= "Bloodtype";
	//私人邮箱
	public static final String SECRET_EMAIL= "Secret_email";
	//结离婚日期
	public static final String MARRIAGEDATE= "Marriagedate";
	//国家/地区
	public static final String COUNTRY= "Country";
	//户口所在地
	public static final String PERMANRESIDE= "Permanreside";
	//入党日期
	public static final String JOINPOLITYDATE= "Joinpolitydate";
	//个人身份
	public static final String PENELAUTH= "Penelauth";
	//档案所在地
	public static final String FILEADDRESS= "Fileaddress";
	//传真
	public static final String FAX= "Fax";
	//行政归属部门
	public static final String ID_DEP_ADMIN= "Id_dep_admin";
	//当前工作部门
	public static final String ID_DEP= "Id_dep";
	//归属部门职务
	public static final String ID_EMPDUTY= "Id_empduty";
	//人员工作类型
	public static final String ID_EMPWKTP= "Id_empwktp";
	//人员聘任职称
	public static final String ID_EMPTITLE= "Id_emptitle";
	//人员类别
	public static final String HUMANTYPE= "Humantype";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//人员属性表时间戳
	public static final String PSNSV= "Psnsv";
	//序号
	public static final String SORTNO= "Sortno";
	//年龄
	public static final String AGE= "Age";
	//推送目标
	public static final String TARGET= "Target";
	//手机品牌标识
	public static final String PHONEBRAND= "Phonebrand";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GROUP= "Name_group";
	//姓名
	public static final String PSNNAME= "Psnname";
	//人员编码
	public static final String PSNCODE= "Psncode";
	//名称
	public static final String NAME_NURTP= "Name_nurtp";
	//名称
	public static final String NAME_NUR_LEVEL= "Name_nur_level";
	//名称
	public static final String NAME_OUT_RES= "Name_out_res";
	//名称
	public static final String NAME_STU_ORG= "Name_stu_org";
	//批次名称
	public static final String NAME_BATCH= "Name_batch";
	//名称
	public static final String NAME_EDUCATION= "Name_education";
	//英语级别名称
	public static final String NAME_ENG_LEVEL= "Name_eng_level";
	//名称
	public static final String NAME_COMPUTER_LEVEL= "Name_computer_level";
	//带教资格1
	public static final String NAME_TCH_QC1= "Name_tch_qc1";
	//带教资格2
	public static final String NAME_TCH_QC2= "Name_tch_qc2";
	//带教资格3
	public static final String NAME_TCH_QC3= "Name_tch_qc3";
	//国家级专科护士
	public static final String NAME_SPEC_NUR1= "Name_spec_nur1";
	//省级专科护士
	public static final String NAME_SPEC_NUR2= "Name_spec_nur2";
	//地址级专科护士
	public static final String NAME_SPEC_NUR3= "Name_spec_nur3";
	//专科小组
	public static final String NAME_SPEC_GRP= "Name_spec_grp";
	//编码
	public static final String CODE_IDTP= "Code_idtp";
	//名称
	public static final String NAME_IDTP= "Name_idtp";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//行政区划名称
	public static final String NAME_VATIVEPLACE= "Name_vativeplace";
	//名称
	public static final String CHARACTER_NAME= "Character_name";
	//名称
	public static final String NAT_NAME= "Nat_name";
	//名称
	public static final String POLITY_NAME= "Polity_name";
	//名称
	public static final String HEALTH_NAME= "Health_name";
	//名称
	public static final String MAR_NAME= "Mar_name";
	//名称
	public static final String BLOODTP_NAME= "Bloodtp_name";
	//名称
	public static final String COUNTYNAME= "Countyname";
	//名称
	public static final String NAME_DEP_ADMIN= "Name_dep_admin";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//职务名称
	public static final String NAME_EMPDUTY= "Name_empduty";
	//职务编码
	public static final String CODE_EMPDUTY= "Code_empduty";
	//名称
	public static final String WKTP_NAME= "Wktp_name";
	//编码
	public static final String WKTP_CODE= "Wktp_code";
	//名称
	public static final String EMPTITLENAME= "Emptitlename";
	//名称
	public static final String NAME_HUMANTYPE= "Name_humantype";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 护士标识主键
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护士标识主键
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	 * 人员id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 人员姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 护理人员类别
	 * @return String
	 */
	public String getId_nurtp() {
		return ((String) getAttrVal("Id_nurtp"));
	}	
	/**
	 * 护理人员类别
	 * @param Id_nurtp
	 */
	public void setId_nurtp(String Id_nurtp) {
		setAttrVal("Id_nurtp", Id_nurtp);
	}
	/**
	 * 护理人员类别编码
	 * @return String
	 */
	public String getSd_nurtp() {
		return ((String) getAttrVal("Sd_nurtp"));
	}	
	/**
	 * 护理人员类别编码
	 * @param Sd_nurtp
	 */
	public void setSd_nurtp(String Sd_nurtp) {
		setAttrVal("Sd_nurtp", Sd_nurtp);
	}
	/**
	 * 身高
	 * @return Integer
	 */
	public Integer getHeight() {
		return ((Integer) getAttrVal("Height"));
	}	
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(Integer Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 服装号
	 * @return String
	 */
	public String getCode_clothes() {
		return ((String) getAttrVal("Code_clothes"));
	}	
	/**
	 * 服装号
	 * @param Code_clothes
	 */
	public void setCode_clothes(String Code_clothes) {
		setAttrVal("Code_clothes", Code_clothes);
	}
	/**
	 * 工号
	 * @return String
	 */
	public String getJob_no() {
		return ((String) getAttrVal("Job_no"));
	}	
	/**
	 * 工号
	 * @param Job_no
	 */
	public void setJob_no(String Job_no) {
		setAttrVal("Job_no", Job_no);
	}
	/**
	 * 鞋号
	 * @return Integer
	 */
	public Integer getSize_shoe() {
		return ((Integer) getAttrVal("Size_shoe"));
	}	
	/**
	 * 鞋号
	 * @param Size_shoe
	 */
	public void setSize_shoe(Integer Size_shoe) {
		setAttrVal("Size_shoe", Size_shoe);
	}
	/**
	 * 到院前护龄
	 * @return Integer
	 */
	public Integer getYears_nr_befo() {
		return ((Integer) getAttrVal("Years_nr_befo"));
	}	
	/**
	 * 到院前护龄
	 * @param Years_nr_befo
	 */
	public void setYears_nr_befo(Integer Years_nr_befo) {
		setAttrVal("Years_nr_befo", Years_nr_befo);
	}
	/**
	 * 护士层级id
	 * @return String
	 */
	public String getId_nur_level() {
		return ((String) getAttrVal("Id_nur_level"));
	}	
	/**
	 * 护士层级id
	 * @param Id_nur_level
	 */
	public void setId_nur_level(String Id_nur_level) {
		setAttrVal("Id_nur_level", Id_nur_level);
	}
	/**
	 * 护士层级编码
	 * @return String
	 */
	public String getSd_nur_level() {
		return ((String) getAttrVal("Sd_nur_level"));
	}	
	/**
	 * 护士层级编码
	 * @param Sd_nur_level
	 */
	public void setSd_nur_level(String Sd_nur_level) {
		setAttrVal("Sd_nur_level", Sd_nur_level);
	}
	/**
	 * 学分卡
	 * @return String
	 */
	public String getNo_credit() {
		return ((String) getAttrVal("No_credit"));
	}	
	/**
	 * 学分卡
	 * @param No_credit
	 */
	public void setNo_credit(String No_credit) {
		setAttrVal("No_credit", No_credit);
	}
	/**
	 * 到院日期
	 * @return FDate
	 */
	public FDate getDt_in() {
		return ((FDate) getAttrVal("Dt_in"));
	}	
	/**
	 * 到院日期
	 * @param Dt_in
	 */
	public void setDt_in(FDate Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 注销日期
	 * @return FDate
	 */
	public FDate getDt_out() {
		return ((FDate) getAttrVal("Dt_out"));
	}	
	/**
	 * 注销日期
	 * @param Dt_out
	 */
	public void setDt_out(FDate Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	/**
	 * 注销 原因id
	 * @return String
	 */
	public String getId_out_res() {
		return ((String) getAttrVal("Id_out_res"));
	}	
	/**
	 * 注销 原因id
	 * @param Id_out_res
	 */
	public void setId_out_res(String Id_out_res) {
		setAttrVal("Id_out_res", Id_out_res);
	}
	/**
	 * 注销原因编码
	 * @return String
	 */
	public String getSd_out_res() {
		return ((String) getAttrVal("Sd_out_res"));
	}	
	/**
	 * 注销原因编码
	 * @param Sd_out_res
	 */
	public void setSd_out_res(String Sd_out_res) {
		setAttrVal("Sd_out_res", Sd_out_res);
	}
	/**
	 * 所属支部编号
	 * @return String
	 */
	public String getNo_bran_part() {
		return ((String) getAttrVal("No_bran_part"));
	}	
	/**
	 * 所属支部编号
	 * @param No_bran_part
	 */
	public void setNo_bran_part(String No_bran_part) {
		setAttrVal("No_bran_part", No_bran_part);
	}
	/**
	 * 考勤标识
	 * @return FBoolean
	 */
	public FBoolean getFg_attend() {
		return ((FBoolean) getAttrVal("Fg_attend"));
	}	
	/**
	 * 考勤标识
	 * @param Fg_attend
	 */
	public void setFg_attend(FBoolean Fg_attend) {
		setAttrVal("Fg_attend", Fg_attend);
	}
	/**
	 * 排班标识
	 * @return FBoolean
	 */
	public FBoolean getFg_schedule() {
		return ((FBoolean) getAttrVal("Fg_schedule"));
	}	
	/**
	 * 排班标识
	 * @param Fg_schedule
	 */
	public void setFg_schedule(FBoolean Fg_schedule) {
		setAttrVal("Fg_schedule", Fg_schedule);
	}
	/**
	 * 轮转标识
	 * @return FBoolean
	 */
	public FBoolean getFg_turn() {
		return ((FBoolean) getAttrVal("Fg_turn"));
	}	
	/**
	 * 轮转标识
	 * @param Fg_turn
	 */
	public void setFg_turn(FBoolean Fg_turn) {
		setAttrVal("Fg_turn", Fg_turn);
	}
	/**
	 * 机动标识
	 * @return FBoolean
	 */
	public FBoolean getFg_move() {
		return ((FBoolean) getAttrVal("Fg_move"));
	}	
	/**
	 * 机动标识
	 * @param Fg_move
	 */
	public void setFg_move(FBoolean Fg_move) {
		setAttrVal("Fg_move", Fg_move);
	}
	/**
	 * 科护士长标识
	 * @return FBoolean
	 */
	public FBoolean getFg_unitleader() {
		return ((FBoolean) getAttrVal("Fg_unitleader"));
	}	
	/**
	 * 科护士长标识
	 * @param Fg_unitleader
	 */
	public void setFg_unitleader(FBoolean Fg_unitleader) {
		setAttrVal("Fg_unitleader", Fg_unitleader);
	}
	/**
	 * 实习生标识
	 * @return FBoolean
	 */
	public FBoolean getFg_intern() {
		return ((FBoolean) getAttrVal("Fg_intern"));
	}	
	/**
	 * 实习生标识
	 * @param Fg_intern
	 */
	public void setFg_intern(FBoolean Fg_intern) {
		setAttrVal("Fg_intern", Fg_intern);
	}
	/**
	 * 应急护士
	 * @return FBoolean
	 */
	public FBoolean getFg_urgency() {
		return ((FBoolean) getAttrVal("Fg_urgency"));
	}	
	/**
	 * 应急护士
	 * @param Fg_urgency
	 */
	public void setFg_urgency(FBoolean Fg_urgency) {
		setAttrVal("Fg_urgency", Fg_urgency);
	}
	/**
	 * 院校ID
	 * @return String
	 */
	public String getId_stu_org() {
		return ((String) getAttrVal("Id_stu_org"));
	}	
	/**
	 * 院校ID
	 * @param Id_stu_org
	 */
	public void setId_stu_org(String Id_stu_org) {
		setAttrVal("Id_stu_org", Id_stu_org);
	}
	/**
	 * 实习生批次id
	 * @return String
	 */
	public String getId_intern_batch() {
		return ((String) getAttrVal("Id_intern_batch"));
	}	
	/**
	 * 实习生批次id
	 * @param Id_intern_batch
	 */
	public void setId_intern_batch(String Id_intern_batch) {
		setAttrVal("Id_intern_batch", Id_intern_batch);
	}
	/**
	 * 传染病证书编号
	 * @return String
	 */
	public String getNo_infec_cfn() {
		return ((String) getAttrVal("No_infec_cfn"));
	}	
	/**
	 * 传染病证书编号
	 * @param No_infec_cfn
	 */
	public void setNo_infec_cfn(String No_infec_cfn) {
		setAttrVal("No_infec_cfn", No_infec_cfn);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 学历id
	 * @return String
	 */
	public String getId_education() {
		return ((String) getAttrVal("Id_education"));
	}	
	/**
	 * 学历id
	 * @param Id_education
	 */
	public void setId_education(String Id_education) {
		setAttrVal("Id_education", Id_education);
	}
	/**
	 * 学历编码
	 * @return String
	 */
	public String getSd_education() {
		return ((String) getAttrVal("Sd_education"));
	}	
	/**
	 * 学历编码
	 * @param Sd_education
	 */
	public void setSd_education(String Sd_education) {
		setAttrVal("Sd_education", Sd_education);
	}
	/**
	 * 英语级别id
	 * @return String
	 */
	public String getId_eng_level() {
		return ((String) getAttrVal("Id_eng_level"));
	}	
	/**
	 * 英语级别id
	 * @param Id_eng_level
	 */
	public void setId_eng_level(String Id_eng_level) {
		setAttrVal("Id_eng_level", Id_eng_level);
	}
	/**
	 * 英语级别编码
	 * @return String
	 */
	public String getSd_eng_level() {
		return ((String) getAttrVal("Sd_eng_level"));
	}	
	/**
	 * 英语级别编码
	 * @param Sd_eng_level
	 */
	public void setSd_eng_level(String Sd_eng_level) {
		setAttrVal("Sd_eng_level", Sd_eng_level);
	}
	/**
	 * 英语能力描述
	 * @return String
	 */
	public String getEng_ability() {
		return ((String) getAttrVal("Eng_ability"));
	}	
	/**
	 * 英语能力描述
	 * @param Eng_ability
	 */
	public void setEng_ability(String Eng_ability) {
		setAttrVal("Eng_ability", Eng_ability);
	}
	/**
	 * 计算机等级id
	 * @return String
	 */
	public String getId_computer_level() {
		return ((String) getAttrVal("Id_computer_level"));
	}	
	/**
	 * 计算机等级id
	 * @param Id_computer_level
	 */
	public void setId_computer_level(String Id_computer_level) {
		setAttrVal("Id_computer_level", Id_computer_level);
	}
	/**
	 * 计算机等级
	 * @return String
	 */
	public String getSd_computer_level() {
		return ((String) getAttrVal("Sd_computer_level"));
	}	
	/**
	 * 计算机等级
	 * @param Sd_computer_level
	 */
	public void setSd_computer_level(String Sd_computer_level) {
		setAttrVal("Sd_computer_level", Sd_computer_level);
	}
	/**
	 * 参加工作时间
	 * @return FDate
	 */
	public FDate getInworktime() {
		return ((FDate) getAttrVal("Inworktime"));
	}	
	/**
	 * 参加工作时间
	 * @param Inworktime
	 */
	public void setInworktime(FDate Inworktime) {
		setAttrVal("Inworktime", Inworktime);
	}
	/**
	 * 执业证号
	 * @return String
	 */
	public String getLicensenum() {
		return ((String) getAttrVal("Licensenum"));
	}	
	/**
	 * 执业证号
	 * @param Licensenum
	 */
	public void setLicensenum(String Licensenum) {
		setAttrVal("Licensenum", Licensenum);
	}
	/**
	 * 带教资格id1
	 * @return String
	 */
	public String getId_tch_qc1() {
		return ((String) getAttrVal("Id_tch_qc1"));
	}	
	/**
	 * 带教资格id1
	 * @param Id_tch_qc1
	 */
	public void setId_tch_qc1(String Id_tch_qc1) {
		setAttrVal("Id_tch_qc1", Id_tch_qc1);
	}
	/**
	 * 带教资格编码1
	 * @return String
	 */
	public String getSd_tch_qc1() {
		return ((String) getAttrVal("Sd_tch_qc1"));
	}	
	/**
	 * 带教资格编码1
	 * @param Sd_tch_qc1
	 */
	public void setSd_tch_qc1(String Sd_tch_qc1) {
		setAttrVal("Sd_tch_qc1", Sd_tch_qc1);
	}
	/**
	 * 带教资格id2
	 * @return String
	 */
	public String getId_tch_qc2() {
		return ((String) getAttrVal("Id_tch_qc2"));
	}	
	/**
	 * 带教资格id2
	 * @param Id_tch_qc2
	 */
	public void setId_tch_qc2(String Id_tch_qc2) {
		setAttrVal("Id_tch_qc2", Id_tch_qc2);
	}
	/**
	 * 带教资格编码2
	 * @return String
	 */
	public String getSd_tch_qc2() {
		return ((String) getAttrVal("Sd_tch_qc2"));
	}	
	/**
	 * 带教资格编码2
	 * @param Sd_tch_qc2
	 */
	public void setSd_tch_qc2(String Sd_tch_qc2) {
		setAttrVal("Sd_tch_qc2", Sd_tch_qc2);
	}
	/**
	 * 带教资格id3
	 * @return String
	 */
	public String getId_tch_qc3() {
		return ((String) getAttrVal("Id_tch_qc3"));
	}	
	/**
	 * 带教资格id3
	 * @param Id_tch_qc3
	 */
	public void setId_tch_qc3(String Id_tch_qc3) {
		setAttrVal("Id_tch_qc3", Id_tch_qc3);
	}
	/**
	 * 带教资格编码3
	 * @return String
	 */
	public String getSd_tch_qc3() {
		return ((String) getAttrVal("Sd_tch_qc3"));
	}	
	/**
	 * 带教资格编码3
	 * @param Sd_tch_qc3
	 */
	public void setSd_tch_qc3(String Sd_tch_qc3) {
		setAttrVal("Sd_tch_qc3", Sd_tch_qc3);
	}
	/**
	 * 带教准入日期1
	 * @return FDate
	 */
	public FDate getDt_tch1() {
		return ((FDate) getAttrVal("Dt_tch1"));
	}	
	/**
	 * 带教准入日期1
	 * @param Dt_tch1
	 */
	public void setDt_tch1(FDate Dt_tch1) {
		setAttrVal("Dt_tch1", Dt_tch1);
	}
	/**
	 * 带教准入日期2
	 * @return FDate
	 */
	public FDate getDt_tch2() {
		return ((FDate) getAttrVal("Dt_tch2"));
	}	
	/**
	 * 带教准入日期2
	 * @param Dt_tch2
	 */
	public void setDt_tch2(FDate Dt_tch2) {
		setAttrVal("Dt_tch2", Dt_tch2);
	}
	/**
	 * 带教准入日期3
	 * @return FDate
	 */
	public FDate getDt_tch3() {
		return ((FDate) getAttrVal("Dt_tch3"));
	}	
	/**
	 * 带教准入日期3
	 * @param Dt_tch3
	 */
	public void setDt_tch3(FDate Dt_tch3) {
		setAttrVal("Dt_tch3", Dt_tch3);
	}
	/**
	 * 国家级专科护士id
	 * @return String
	 */
	public String getId_spec_nur1() {
		return ((String) getAttrVal("Id_spec_nur1"));
	}	
	/**
	 * 国家级专科护士id
	 * @param Id_spec_nur1
	 */
	public void setId_spec_nur1(String Id_spec_nur1) {
		setAttrVal("Id_spec_nur1", Id_spec_nur1);
	}
	/**
	 * 国家级专科护士编码
	 * @return String
	 */
	public String getSd_spec_nur1() {
		return ((String) getAttrVal("Sd_spec_nur1"));
	}	
	/**
	 * 国家级专科护士编码
	 * @param Sd_spec_nur1
	 */
	public void setSd_spec_nur1(String Sd_spec_nur1) {
		setAttrVal("Sd_spec_nur1", Sd_spec_nur1);
	}
	/**
	 * 省级专科护士id
	 * @return String
	 */
	public String getId_spec_nur2() {
		return ((String) getAttrVal("Id_spec_nur2"));
	}	
	/**
	 * 省级专科护士id
	 * @param Id_spec_nur2
	 */
	public void setId_spec_nur2(String Id_spec_nur2) {
		setAttrVal("Id_spec_nur2", Id_spec_nur2);
	}
	/**
	 * 省级专科护士编码
	 * @return String
	 */
	public String getSd_spec_nur2() {
		return ((String) getAttrVal("Sd_spec_nur2"));
	}	
	/**
	 * 省级专科护士编码
	 * @param Sd_spec_nur2
	 */
	public void setSd_spec_nur2(String Sd_spec_nur2) {
		setAttrVal("Sd_spec_nur2", Sd_spec_nur2);
	}
	/**
	 * 地市级专科护士id
	 * @return String
	 */
	public String getId_spec_nur3() {
		return ((String) getAttrVal("Id_spec_nur3"));
	}	
	/**
	 * 地市级专科护士id
	 * @param Id_spec_nur3
	 */
	public void setId_spec_nur3(String Id_spec_nur3) {
		setAttrVal("Id_spec_nur3", Id_spec_nur3);
	}
	/**
	 * 地市级专科护士编码
	 * @return String
	 */
	public String getSd_spec_nur3() {
		return ((String) getAttrVal("Sd_spec_nur3"));
	}	
	/**
	 * 地市级专科护士编码
	 * @param Sd_spec_nur3
	 */
	public void setSd_spec_nur3(String Sd_spec_nur3) {
		setAttrVal("Sd_spec_nur3", Sd_spec_nur3);
	}
	/**
	 * 专科小组id
	 * @return String
	 */
	public String getId_spec_grp() {
		return ((String) getAttrVal("Id_spec_grp"));
	}	
	/**
	 * 专科小组id
	 * @param Id_spec_grp
	 */
	public void setId_spec_grp(String Id_spec_grp) {
		setAttrVal("Id_spec_grp", Id_spec_grp);
	}
	/**
	 * 专科小组编码
	 * @return String
	 */
	public String getSd_spec_grp() {
		return ((String) getAttrVal("Sd_spec_grp"));
	}	
	/**
	 * 专科小组编码
	 * @param Sd_spec_grp
	 */
	public void setSd_spec_grp(String Sd_spec_grp) {
		setAttrVal("Sd_spec_grp", Sd_spec_grp);
	}
	/**
	 * 社会任职
	 * @return String
	 */
	public String getSocial_service() {
		return ((String) getAttrVal("Social_service"));
	}	
	/**
	 * 社会任职
	 * @param Social_service
	 */
	public void setSocial_service(String Social_service) {
		setAttrVal("Social_service", Social_service);
	}
	/**
	 * 个人特长
	 * @return String
	 */
	public String getPer_point() {
		return ((String) getAttrVal("Per_point"));
	}	
	/**
	 * 个人特长
	 * @param Per_point
	 */
	public void setPer_point(String Per_point) {
		setAttrVal("Per_point", Per_point);
	}
	/**
	 * 在职状态
	 * @return FBoolean
	 */
	public FBoolean getInwork_flag() {
		return ((FBoolean) getAttrVal("Inwork_flag"));
	}	
	/**
	 * 在职状态
	 * @param Inwork_flag
	 */
	public void setInwork_flag(FBoolean Inwork_flag) {
		setAttrVal("Inwork_flag", Inwork_flag);
	}
	/**
	 * 作废标志 
	 * @return FBoolean
	 */
	public FBoolean getInvalid_flag() {
		return ((FBoolean) getAttrVal("Invalid_flag"));
	}	
	/**
	 * 作废标志 
	 * @param Invalid_flag
	 */
	public void setInvalid_flag(FBoolean Invalid_flag) {
		setAttrVal("Invalid_flag", Invalid_flag);
	}
	/**
	 * 姓名简称
	 * @return String
	 */
	public String getShrotname() {
		return ((String) getAttrVal("Shrotname"));
	}	
	/**
	 * 姓名简称
	 * @param Shrotname
	 */
	public void setShrotname(String Shrotname) {
		setAttrVal("Shrotname", Shrotname);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 人员编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getIdtype() {
		return ((String) getAttrVal("Idtype"));
	}	
	/**
	 * 证件类型
	 * @param Idtype
	 */
	public void setIdtype(String Idtype) {
		setAttrVal("Idtype", Idtype);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}	
	/**
	 * 证件号码
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}	
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getVativeplace() {
		return ((String) getAttrVal("Vativeplace"));
	}	
	/**
	 * 籍贯
	 * @param Vativeplace
	 */
	public void setVativeplace(String Vativeplace) {
		setAttrVal("Vativeplace", Vativeplace);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getCensusaddr() {
		return ((String) getAttrVal("Censusaddr"));
	}	
	/**
	 * 户籍地址
	 * @param Censusaddr
	 */
	public void setCensusaddr(String Censusaddr) {
		setAttrVal("Censusaddr", Censusaddr);
	}
	/**
	 * 户口性质
	 * @return String
	 */
	public String getCharacterrpr() {
		return ((String) getAttrVal("Characterrpr"));
	}	
	/**
	 * 户口性质
	 * @param Characterrpr
	 */
	public void setCharacterrpr(String Characterrpr) {
		setAttrVal("Characterrpr", Characterrpr);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getNationatily() {
		return ((String) getAttrVal("Nationatily"));
	}	
	/**
	 * 民族
	 * @param Nationatily
	 */
	public void setNationatily(String Nationatily) {
		setAttrVal("Nationatily", Nationatily);
	}
	/**
	 * 政治面貌
	 * @return String
	 */
	public String getPolity() {
		return ((String) getAttrVal("Polity"));
	}	
	/**
	 * 政治面貌
	 * @param Polity
	 */
	public void setPolity(String Polity) {
		setAttrVal("Polity", Polity);
	}
	/**
	 * 健康状况
	 * @return String
	 */
	public String getHealth() {
		return ((String) getAttrVal("Health"));
	}	
	/**
	 * 健康状况
	 * @param Health
	 */
	public void setHealth(String Health) {
		setAttrVal("Health", Health);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getMarital() {
		return ((String) getAttrVal("Marital"));
	}	
	/**
	 * 婚姻状况
	 * @param Marital
	 */
	public void setMarital(String Marital) {
		setAttrVal("Marital", Marital);
	}
	/**
	 * 手机
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}	
	/**
	 * 手机
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
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
	 * 家庭电话
	 * @return String
	 */
	public String getHomephone() {
		return ((String) getAttrVal("Homephone"));
	}	
	/**
	 * 家庭电话
	 * @param Homephone
	 */
	public void setHomephone(String Homephone) {
		setAttrVal("Homephone", Homephone);
	}
	/**
	 * 家庭地址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}	
	/**
	 * 家庭地址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getPostalcode() {
		return ((String) getAttrVal("Postalcode"));
	}	
	/**
	 * 邮政编码
	 * @param Postalcode
	 */
	public void setPostalcode(String Postalcode) {
		setAttrVal("Postalcode", Postalcode);
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
	 * 曾用名
	 * @return String
	 */
	public String getUsedname() {
		return ((String) getAttrVal("Usedname"));
	}	
	/**
	 * 曾用名
	 * @param Usedname
	 */
	public void setUsedname(String Usedname) {
		setAttrVal("Usedname", Usedname);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getBloodtype() {
		return ((String) getAttrVal("Bloodtype"));
	}	
	/**
	 * 血型
	 * @param Bloodtype
	 */
	public void setBloodtype(String Bloodtype) {
		setAttrVal("Bloodtype", Bloodtype);
	}
	/**
	 * 私人邮箱
	 * @return String
	 */
	public String getSecret_email() {
		return ((String) getAttrVal("Secret_email"));
	}	
	/**
	 * 私人邮箱
	 * @param Secret_email
	 */
	public void setSecret_email(String Secret_email) {
		setAttrVal("Secret_email", Secret_email);
	}
	/**
	 * 结离婚日期
	 * @return String
	 */
	public String getMarriagedate() {
		return ((String) getAttrVal("Marriagedate"));
	}	
	/**
	 * 结离婚日期
	 * @param Marriagedate
	 */
	public void setMarriagedate(String Marriagedate) {
		setAttrVal("Marriagedate", Marriagedate);
	}
	/**
	 * 国家/地区
	 * @return String
	 */
	public String getCountry() {
		return ((String) getAttrVal("Country"));
	}	
	/**
	 * 国家/地区
	 * @param Country
	 */
	public void setCountry(String Country) {
		setAttrVal("Country", Country);
	}
	/**
	 * 户口所在地
	 * @return String
	 */
	public String getPermanreside() {
		return ((String) getAttrVal("Permanreside"));
	}	
	/**
	 * 户口所在地
	 * @param Permanreside
	 */
	public void setPermanreside(String Permanreside) {
		setAttrVal("Permanreside", Permanreside);
	}
	/**
	 * 入党日期
	 * @return FDate
	 */
	public FDate getJoinpolitydate() {
		return ((FDate) getAttrVal("Joinpolitydate"));
	}	
	/**
	 * 入党日期
	 * @param Joinpolitydate
	 */
	public void setJoinpolitydate(FDate Joinpolitydate) {
		setAttrVal("Joinpolitydate", Joinpolitydate);
	}
	/**
	 * 个人身份
	 * @return String
	 */
	public String getPenelauth() {
		return ((String) getAttrVal("Penelauth"));
	}	
	/**
	 * 个人身份
	 * @param Penelauth
	 */
	public void setPenelauth(String Penelauth) {
		setAttrVal("Penelauth", Penelauth);
	}
	/**
	 * 档案所在地
	 * @return String
	 */
	public String getFileaddress() {
		return ((String) getAttrVal("Fileaddress"));
	}	
	/**
	 * 档案所在地
	 * @param Fileaddress
	 */
	public void setFileaddress(String Fileaddress) {
		setAttrVal("Fileaddress", Fileaddress);
	}
	/**
	 * 传真
	 * @return String
	 */
	public String getFax() {
		return ((String) getAttrVal("Fax"));
	}	
	/**
	 * 传真
	 * @param Fax
	 */
	public void setFax(String Fax) {
		setAttrVal("Fax", Fax);
	}
	/**
	 * 行政归属部门
	 * @return String
	 */
	public String getId_dep_admin() {
		return ((String) getAttrVal("Id_dep_admin"));
	}	
	/**
	 * 行政归属部门
	 * @param Id_dep_admin
	 */
	public void setId_dep_admin(String Id_dep_admin) {
		setAttrVal("Id_dep_admin", Id_dep_admin);
	}
	/**
	 * 当前工作部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 当前工作部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 归属部门职务
	 * @return String
	 */
	public String getId_empduty() {
		return ((String) getAttrVal("Id_empduty"));
	}	
	/**
	 * 归属部门职务
	 * @param Id_empduty
	 */
	public void setId_empduty(String Id_empduty) {
		setAttrVal("Id_empduty", Id_empduty);
	}
	/**
	 * 人员工作类型
	 * @return String
	 */
	public String getId_empwktp() {
		return ((String) getAttrVal("Id_empwktp"));
	}	
	/**
	 * 人员工作类型
	 * @param Id_empwktp
	 */
	public void setId_empwktp(String Id_empwktp) {
		setAttrVal("Id_empwktp", Id_empwktp);
	}
	/**
	 * 人员聘任职称
	 * @return String
	 */
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}	
	/**
	 * 人员聘任职称
	 * @param Id_emptitle
	 */
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	/**
	 * 人员类别
	 * @return String
	 */
	public String getHumantype() {
		return ((String) getAttrVal("Humantype"));
	}	
	/**
	 * 人员类别
	 * @param Humantype
	 */
	public void setHumantype(String Humantype) {
		setAttrVal("Humantype", Humantype);
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
	 * 人员属性表时间戳
	 * @return FDateTime
	 */
	public FDateTime getPsnsv() {
		return ((FDateTime) getAttrVal("Psnsv"));
	}	
	/**
	 * 人员属性表时间戳
	 * @param Psnsv
	 */
	public void setPsnsv(FDateTime Psnsv) {
		setAttrVal("Psnsv", Psnsv);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 推送目标
	 * @return String
	 */
	public String getTarget() {
		return ((String) getAttrVal("Target"));
	}	
	/**
	 * 推送目标
	 * @param Target
	 */
	public void setTarget(String Target) {
		setAttrVal("Target", Target);
	}
	/**
	 * 手机品牌标识
	 * @return String
	 */
	public String getPhonebrand() {
		return ((String) getAttrVal("Phonebrand"));
	}	
	/**
	 * 手机品牌标识
	 * @param Phonebrand
	 */
	public void setPhonebrand(String Phonebrand) {
		setAttrVal("Phonebrand", Phonebrand);
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
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_group() {
		return ((String) getAttrVal("Name_group"));
	}	
	/**
	 * 名称
	 * @param Name_group
	 */
	public void setName_group(String Name_group) {
		setAttrVal("Name_group", Name_group);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPsnname() {
		return ((String) getAttrVal("Psnname"));
	}	
	/**
	 * 姓名
	 * @param Psnname
	 */
	public void setPsnname(String Psnname) {
		setAttrVal("Psnname", Psnname);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getPsncode() {
		return ((String) getAttrVal("Psncode"));
	}	
	/**
	 * 人员编码
	 * @param Psncode
	 */
	public void setPsncode(String Psncode) {
		setAttrVal("Psncode", Psncode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nurtp() {
		return ((String) getAttrVal("Name_nurtp"));
	}	
	/**
	 * 名称
	 * @param Name_nurtp
	 */
	public void setName_nurtp(String Name_nurtp) {
		setAttrVal("Name_nurtp", Name_nurtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}	
	/**
	 * 名称
	 * @param Name_nur_level
	 */
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_out_res() {
		return ((String) getAttrVal("Name_out_res"));
	}	
	/**
	 * 名称
	 * @param Name_out_res
	 */
	public void setName_out_res(String Name_out_res) {
		setAttrVal("Name_out_res", Name_out_res);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stu_org() {
		return ((String) getAttrVal("Name_stu_org"));
	}	
	/**
	 * 名称
	 * @param Name_stu_org
	 */
	public void setName_stu_org(String Name_stu_org) {
		setAttrVal("Name_stu_org", Name_stu_org);
	}
	/**
	 * 批次名称
	 * @return String
	 */
	public String getName_batch() {
		return ((String) getAttrVal("Name_batch"));
	}	
	/**
	 * 批次名称
	 * @param Name_batch
	 */
	public void setName_batch(String Name_batch) {
		setAttrVal("Name_batch", Name_batch);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_education() {
		return ((String) getAttrVal("Name_education"));
	}	
	/**
	 * 名称
	 * @param Name_education
	 */
	public void setName_education(String Name_education) {
		setAttrVal("Name_education", Name_education);
	}
	/**
	 * 英语级别名称
	 * @return String
	 */
	public String getName_eng_level() {
		return ((String) getAttrVal("Name_eng_level"));
	}	
	/**
	 * 英语级别名称
	 * @param Name_eng_level
	 */
	public void setName_eng_level(String Name_eng_level) {
		setAttrVal("Name_eng_level", Name_eng_level);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_computer_level() {
		return ((String) getAttrVal("Name_computer_level"));
	}	
	/**
	 * 名称
	 * @param Name_computer_level
	 */
	public void setName_computer_level(String Name_computer_level) {
		setAttrVal("Name_computer_level", Name_computer_level);
	}
	/**
	 * 带教资格1
	 * @return String
	 */
	public String getName_tch_qc1() {
		return ((String) getAttrVal("Name_tch_qc1"));
	}	
	/**
	 * 带教资格1
	 * @param Name_tch_qc1
	 */
	public void setName_tch_qc1(String Name_tch_qc1) {
		setAttrVal("Name_tch_qc1", Name_tch_qc1);
	}
	/**
	 * 带教资格2
	 * @return String
	 */
	public String getName_tch_qc2() {
		return ((String) getAttrVal("Name_tch_qc2"));
	}	
	/**
	 * 带教资格2
	 * @param Name_tch_qc2
	 */
	public void setName_tch_qc2(String Name_tch_qc2) {
		setAttrVal("Name_tch_qc2", Name_tch_qc2);
	}
	/**
	 * 带教资格3
	 * @return String
	 */
	public String getName_tch_qc3() {
		return ((String) getAttrVal("Name_tch_qc3"));
	}	
	/**
	 * 带教资格3
	 * @param Name_tch_qc3
	 */
	public void setName_tch_qc3(String Name_tch_qc3) {
		setAttrVal("Name_tch_qc3", Name_tch_qc3);
	}
	/**
	 * 国家级专科护士
	 * @return String
	 */
	public String getName_spec_nur1() {
		return ((String) getAttrVal("Name_spec_nur1"));
	}	
	/**
	 * 国家级专科护士
	 * @param Name_spec_nur1
	 */
	public void setName_spec_nur1(String Name_spec_nur1) {
		setAttrVal("Name_spec_nur1", Name_spec_nur1);
	}
	/**
	 * 省级专科护士
	 * @return String
	 */
	public String getName_spec_nur2() {
		return ((String) getAttrVal("Name_spec_nur2"));
	}	
	/**
	 * 省级专科护士
	 * @param Name_spec_nur2
	 */
	public void setName_spec_nur2(String Name_spec_nur2) {
		setAttrVal("Name_spec_nur2", Name_spec_nur2);
	}
	/**
	 * 地址级专科护士
	 * @return String
	 */
	public String getName_spec_nur3() {
		return ((String) getAttrVal("Name_spec_nur3"));
	}	
	/**
	 * 地址级专科护士
	 * @param Name_spec_nur3
	 */
	public void setName_spec_nur3(String Name_spec_nur3) {
		setAttrVal("Name_spec_nur3", Name_spec_nur3);
	}
	/**
	 * 专科小组
	 * @return String
	 */
	public String getName_spec_grp() {
		return ((String) getAttrVal("Name_spec_grp"));
	}	
	/**
	 * 专科小组
	 * @param Name_spec_grp
	 */
	public void setName_spec_grp(String Name_spec_grp) {
		setAttrVal("Name_spec_grp", Name_spec_grp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_idtp() {
		return ((String) getAttrVal("Code_idtp"));
	}	
	/**
	 * 编码
	 * @param Code_idtp
	 */
	public void setCode_idtp(String Code_idtp) {
		setAttrVal("Code_idtp", Code_idtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}	
	/**
	 * 名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getName_vativeplace() {
		return ((String) getAttrVal("Name_vativeplace"));
	}	
	/**
	 * 行政区划名称
	 * @param Name_vativeplace
	 */
	public void setName_vativeplace(String Name_vativeplace) {
		setAttrVal("Name_vativeplace", Name_vativeplace);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCharacter_name() {
		return ((String) getAttrVal("Character_name"));
	}	
	/**
	 * 名称
	 * @param Character_name
	 */
	public void setCharacter_name(String Character_name) {
		setAttrVal("Character_name", Character_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNat_name() {
		return ((String) getAttrVal("Nat_name"));
	}	
	/**
	 * 名称
	 * @param Nat_name
	 */
	public void setNat_name(String Nat_name) {
		setAttrVal("Nat_name", Nat_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPolity_name() {
		return ((String) getAttrVal("Polity_name"));
	}	
	/**
	 * 名称
	 * @param Polity_name
	 */
	public void setPolity_name(String Polity_name) {
		setAttrVal("Polity_name", Polity_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHealth_name() {
		return ((String) getAttrVal("Health_name"));
	}	
	/**
	 * 名称
	 * @param Health_name
	 */
	public void setHealth_name(String Health_name) {
		setAttrVal("Health_name", Health_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMar_name() {
		return ((String) getAttrVal("Mar_name"));
	}	
	/**
	 * 名称
	 * @param Mar_name
	 */
	public void setMar_name(String Mar_name) {
		setAttrVal("Mar_name", Mar_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBloodtp_name() {
		return ((String) getAttrVal("Bloodtp_name"));
	}	
	/**
	 * 名称
	 * @param Bloodtp_name
	 */
	public void setBloodtp_name(String Bloodtp_name) {
		setAttrVal("Bloodtp_name", Bloodtp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCountyname() {
		return ((String) getAttrVal("Countyname"));
	}	
	/**
	 * 名称
	 * @param Countyname
	 */
	public void setCountyname(String Countyname) {
		setAttrVal("Countyname", Countyname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_admin() {
		return ((String) getAttrVal("Name_dep_admin"));
	}	
	/**
	 * 名称
	 * @param Name_dep_admin
	 */
	public void setName_dep_admin(String Name_dep_admin) {
		setAttrVal("Name_dep_admin", Name_dep_admin);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 职务名称
	 * @return String
	 */
	public String getName_empduty() {
		return ((String) getAttrVal("Name_empduty"));
	}	
	/**
	 * 职务名称
	 * @param Name_empduty
	 */
	public void setName_empduty(String Name_empduty) {
		setAttrVal("Name_empduty", Name_empduty);
	}
	/**
	 * 职务编码
	 * @return String
	 */
	public String getCode_empduty() {
		return ((String) getAttrVal("Code_empduty"));
	}	
	/**
	 * 职务编码
	 * @param Code_empduty
	 */
	public void setCode_empduty(String Code_empduty) {
		setAttrVal("Code_empduty", Code_empduty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getWktp_name() {
		return ((String) getAttrVal("Wktp_name"));
	}	
	/**
	 * 名称
	 * @param Wktp_name
	 */
	public void setWktp_name(String Wktp_name) {
		setAttrVal("Wktp_name", Wktp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getWktp_code() {
		return ((String) getAttrVal("Wktp_code"));
	}	
	/**
	 * 编码
	 * @param Wktp_code
	 */
	public void setWktp_code(String Wktp_code) {
		setAttrVal("Wktp_code", Wktp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEmptitlename() {
		return ((String) getAttrVal("Emptitlename"));
	}	
	/**
	 * 名称
	 * @param Emptitlename
	 */
	public void setEmptitlename(String Emptitlename) {
		setAttrVal("Emptitlename", Emptitlename);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_humantype() {
		return ((String) getAttrVal("Name_humantype"));
	}	
	/**
	 * 名称
	 * @param Name_humantype
	 */
	public void setName_humantype(String Name_humantype) {
		setAttrVal("Name_humantype", Name_humantype);
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
		return "Id_nur";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurDODesc.class);
	}
	
}