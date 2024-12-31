package iih.sc.apt.scaptappl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scaptappl.d.desc.ScAptApplOptDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_申请_手术 DO数据 
 * 
 */
public class ScAptApplOptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//手术预约申请ID
	public static final String ID_APTAPPLOPT= "Id_aptapplopt";
	//预约申请ID
	public static final String ID_APTAPPL= "Id_aptappl";
	//麻醉方式id
	public static final String ID_ANESTP= "Id_anestp";
	//麻醉方式编码
	public static final String SD_ANESTP= "Sd_anestp";
	//特殊用物
	public static final String SPECIALREQ= "Specialreq";
	//特殊仪器
	public static final String SPECIALINSTRUMENT= "Specialinstrument";
	//特殊准备
	public static final String SPECIALDES= "Specialdes";
	//诊断id
	public static final String ID_DI= "Id_di";
	//诊断名称
	public static final String NAME_DI= "Name_di";
	//诊断编码
	public static final String CODE_DI= "Code_di";
	//注意事项
	public static final String ANNOUNCEMENTS= "Announcements";
	//手术要求
	public static final String SUG_REQUIRE= "Sug_require";
	//是否感染手术
	public static final String FG_INFECTION= "Fg_infection";
	//科室手术台次
	public static final String SORTNO_DEPPHY= "Sortno_depphy";
	//是否科室确认
	public static final String FG_CONFIRM_PHY= "Fg_confirm_phy";
	//科室确认时间
	public static final String DT_CONFIRM_PHY= "Dt_confirm_phy";
	//科室确认人
	public static final String ID_EMP_CONFIRM_PHY= "Id_emp_confirm_phy";
	//是否需要确认
	public static final String FG_NEED_CONFIRM= "Fg_need_confirm";
	//编码
	public static final String CODE_ANESTP= "Code_anestp";
	//名称
	public static final String NAME_ANESTP= "Name_anestp";
	//诊断编码
	public static final String ID_DIDEF_CODE= "Id_didef_code";
	//诊断名称
	public static final String ID_DIDEF_NAME= "Id_didef_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 手术预约申请ID
	 * @return String
	 */
	public String getId_aptapplopt() {
		return ((String) getAttrVal("Id_aptapplopt"));
	}	
	/**
	 * 手术预约申请ID
	 * @param Id_aptapplopt
	 */
	public void setId_aptapplopt(String Id_aptapplopt) {
		setAttrVal("Id_aptapplopt", Id_aptapplopt);
	}
	/**
	 * 预约申请ID
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	/**
	 * 预约申请ID
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	/**
	 * 麻醉方式id
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	/**
	 * 麻醉方式id
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	/**
	 * 麻醉方式编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 特殊用物
	 * @return String
	 */
	public String getSpecialreq() {
		return ((String) getAttrVal("Specialreq"));
	}	
	/**
	 * 特殊用物
	 * @param Specialreq
	 */
	public void setSpecialreq(String Specialreq) {
		setAttrVal("Specialreq", Specialreq);
	}
	/**
	 * 特殊仪器
	 * @return String
	 */
	public String getSpecialinstrument() {
		return ((String) getAttrVal("Specialinstrument"));
	}	
	/**
	 * 特殊仪器
	 * @param Specialinstrument
	 */
	public void setSpecialinstrument(String Specialinstrument) {
		setAttrVal("Specialinstrument", Specialinstrument);
	}
	/**
	 * 特殊准备
	 * @return String
	 */
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	/**
	 * 特殊准备
	 * @param Specialdes
	 */
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 手术要求
	 * @return String
	 */
	public String getSug_require() {
		return ((String) getAttrVal("Sug_require"));
	}	
	/**
	 * 手术要求
	 * @param Sug_require
	 */
	public void setSug_require(String Sug_require) {
		setAttrVal("Sug_require", Sug_require);
	}
	/**
	 * 是否感染手术
	 * @return FBoolean
	 */
	public FBoolean getFg_infection() {
		return ((FBoolean) getAttrVal("Fg_infection"));
	}	
	/**
	 * 是否感染手术
	 * @param Fg_infection
	 */
	public void setFg_infection(FBoolean Fg_infection) {
		setAttrVal("Fg_infection", Fg_infection);
	}
	/**
	 * 科室手术台次
	 * @return Integer
	 */
	public Integer getSortno_depphy() {
		return ((Integer) getAttrVal("Sortno_depphy"));
	}	
	/**
	 * 科室手术台次
	 * @param Sortno_depphy
	 */
	public void setSortno_depphy(Integer Sortno_depphy) {
		setAttrVal("Sortno_depphy", Sortno_depphy);
	}
	/**
	 * 是否科室确认
	 * @return FBoolean
	 */
	public FBoolean getFg_confirm_phy() {
		return ((FBoolean) getAttrVal("Fg_confirm_phy"));
	}	
	/**
	 * 是否科室确认
	 * @param Fg_confirm_phy
	 */
	public void setFg_confirm_phy(FBoolean Fg_confirm_phy) {
		setAttrVal("Fg_confirm_phy", Fg_confirm_phy);
	}
	/**
	 * 科室确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_confirm_phy() {
		return ((FDateTime) getAttrVal("Dt_confirm_phy"));
	}	
	/**
	 * 科室确认时间
	 * @param Dt_confirm_phy
	 */
	public void setDt_confirm_phy(FDateTime Dt_confirm_phy) {
		setAttrVal("Dt_confirm_phy", Dt_confirm_phy);
	}
	/**
	 * 科室确认人
	 * @return String
	 */
	public String getId_emp_confirm_phy() {
		return ((String) getAttrVal("Id_emp_confirm_phy"));
	}	
	/**
	 * 科室确认人
	 * @param Id_emp_confirm_phy
	 */
	public void setId_emp_confirm_phy(String Id_emp_confirm_phy) {
		setAttrVal("Id_emp_confirm_phy", Id_emp_confirm_phy);
	}
	/**
	 * 是否需要确认
	 * @return FBoolean
	 */
	public FBoolean getFg_need_confirm() {
		return ((FBoolean) getAttrVal("Fg_need_confirm"));
	}	
	/**
	 * 是否需要确认
	 * @param Fg_need_confirm
	 */
	public void setFg_need_confirm(FBoolean Fg_need_confirm) {
		setAttrVal("Fg_need_confirm", Fg_need_confirm);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_anestp() {
		return ((String) getAttrVal("Code_anestp"));
	}	
	/**
	 * 编码
	 * @param Code_anestp
	 */
	public void setCode_anestp(String Code_anestp) {
		setAttrVal("Code_anestp", Code_anestp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	/**
	 * 名称
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getId_didef_code() {
		return ((String) getAttrVal("Id_didef_code"));
	}	
	/**
	 * 诊断编码
	 * @param Id_didef_code
	 */
	public void setId_didef_code(String Id_didef_code) {
		setAttrVal("Id_didef_code", Id_didef_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getId_didef_name() {
		return ((String) getAttrVal("Id_didef_name"));
	}	
	/**
	 * 诊断名称
	 * @param Id_didef_name
	 */
	public void setId_didef_name(String Id_didef_name) {
		setAttrVal("Id_didef_name", Id_didef_name);
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
		return "Id_aptapplopt";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_appl_opt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptApplOptDODesc.class);
	}
	
}