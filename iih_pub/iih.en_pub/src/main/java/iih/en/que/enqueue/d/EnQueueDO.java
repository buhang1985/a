package iih.en.que.enqueue.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_队列 DO数据 
 * 
 */
public class EnQueueDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//队列主键
	public static final String ID_ENT_QUE= "Id_ent_que";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属机构
	public static final String ID_ORG= "Id_org";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//就诊患者
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//号位
	public static final String ID_TICK= "Id_tick";
	//票号
	public static final String TICKETNO= "Ticketno";
	//医嘱
	public static final String ID_ORD= "Id_ord";
	//队列
	public static final String ID_QUE= "Id_que";
	//就诊日期
	public static final String DT_REGIST= "Dt_regist";
	//日期分组
	public static final String ID_DATESLOT= "Id_dateslot";
	//排序号
	public static final String SORTNO= "Sortno";
	//实际叫号顺序号
	public static final String SORTNO_CALLED= "Sortno_called";
	//排队类型
	public static final String ID_ENTQUE_TP= "Id_entque_tp";
	//排队类型编码
	public static final String SD_ENTQUE_TP= "Sd_entque_tp";
	//有效标志
	public static final String FG_ACTIVE= "Fg_active";
	//入队日期
	public static final String DT_IN= "Dt_in";
	//接受状态
	public static final String ID_STATUS_ACPT= "Id_status_acpt";
	//接受状态编码
	public static final String SD_STATUS_ACPT= "Sd_status_acpt";
	//接受日期
	public static final String DT_ACPT= "Dt_acpt";
	//接受医护人员
	public static final String ID_EMP_ACPT= "Id_emp_acpt";
	//接受医护人员名称
	public static final String NAME_EMP_ACPT= "Name_emp_acpt";
	//分诊台id
	public static final String ID_QUEBEN= "Id_queben";
	//接受队列工作点
	public static final String ID_QUE_SITE= "Id_que_site";
	//患者分类
	public static final String ID_PATCA= "Id_patca";
	//病情等级id
	public static final String ID_LEVEL_DISE= "Id_level_dise";
	//就诊病情评估等级
	public static final String SD_LEVEL_DISE= "Sd_level_dise";
	//指定挂号医生id
	public static final String ID_EMP_OPREG= "Id_emp_opreg";
	//优先级别
	public static final String LEVEL_PRI= "Level_pri";
	//优先级别原因
	public static final String LEVEL_PRI_RSN= "Level_pri_rsn";
	//处方id
	public static final String ID_PRES= "Id_pres";
	//预约标志
	public static final String FG_APT= "Fg_apt";
	//需手工分诊标志
	public static final String FG_MANUAL= "Fg_manual";
	//回诊标识
	public static final String FG_RTN= "Fg_rtn";
	//客开扩展字段1
	public static final String DEF1= "Def1";
	//客开扩展字段2
	public static final String DEF2= "Def2";
	//客开扩展字段3
	public static final String DEF3= "Def3";
	//客开扩展字段4
	public static final String DEF4= "Def4";
	//客开扩展字段5
	public static final String DEF5= "Def5";
	//需回诊标志
	public static final String FG_NEEDRTN= "Fg_needrtn";
	//CHIS条码号
	public static final String BARCODE_CHIS= "Barcode_chis";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 队列主键
	 * @return String
	 */
	public String getId_ent_que() {
		return ((String) getAttrVal("Id_ent_que"));
	}	
	/**
	 * 队列主键
	 * @param Id_ent_que
	 */
	public void setId_ent_que(String Id_ent_que) {
		setAttrVal("Id_ent_que", Id_ent_que);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 就诊患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 号位
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}	
	/**
	 * 号位
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getTicketno() {
		return ((Integer) getAttrVal("Ticketno"));
	}	
	/**
	 * 票号
	 * @param Ticketno
	 */
	public void setTicketno(Integer Ticketno) {
		setAttrVal("Ticketno", Ticketno);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}	
	/**
	 * 医嘱
	 * @param Id_ord
	 */
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	/**
	 * 队列
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}	
	/**
	 * 队列
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 就诊日期
	 * @return FDate
	 */
	public FDate getDt_regist() {
		return ((FDate) getAttrVal("Dt_regist"));
	}	
	/**
	 * 就诊日期
	 * @param Dt_regist
	 */
	public void setDt_regist(FDate Dt_regist) {
		setAttrVal("Dt_regist", Dt_regist);
	}
	/**
	 * 日期分组
	 * @return String
	 */
	public String getId_dateslot() {
		return ((String) getAttrVal("Id_dateslot"));
	}	
	/**
	 * 日期分组
	 * @param Id_dateslot
	 */
	public void setId_dateslot(String Id_dateslot) {
		setAttrVal("Id_dateslot", Id_dateslot);
	}
	/**
	 * 排序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 排序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 实际叫号顺序号
	 * @return Integer
	 */
	public Integer getSortno_called() {
		return ((Integer) getAttrVal("Sortno_called"));
	}	
	/**
	 * 实际叫号顺序号
	 * @param Sortno_called
	 */
	public void setSortno_called(Integer Sortno_called) {
		setAttrVal("Sortno_called", Sortno_called);
	}
	/**
	 * 排队类型
	 * @return String
	 */
	public String getId_entque_tp() {
		return ((String) getAttrVal("Id_entque_tp"));
	}	
	/**
	 * 排队类型
	 * @param Id_entque_tp
	 */
	public void setId_entque_tp(String Id_entque_tp) {
		setAttrVal("Id_entque_tp", Id_entque_tp);
	}
	/**
	 * 排队类型编码
	 * @return String
	 */
	public String getSd_entque_tp() {
		return ((String) getAttrVal("Sd_entque_tp"));
	}	
	/**
	 * 排队类型编码
	 * @param Sd_entque_tp
	 */
	public void setSd_entque_tp(String Sd_entque_tp) {
		setAttrVal("Sd_entque_tp", Sd_entque_tp);
	}
	/**
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 入队日期
	 * @return FDateTime
	 */
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}	
	/**
	 * 入队日期
	 * @param Dt_in
	 */
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 接受状态
	 * @return String
	 */
	public String getId_status_acpt() {
		return ((String) getAttrVal("Id_status_acpt"));
	}	
	/**
	 * 接受状态
	 * @param Id_status_acpt
	 */
	public void setId_status_acpt(String Id_status_acpt) {
		setAttrVal("Id_status_acpt", Id_status_acpt);
	}
	/**
	 * 接受状态编码
	 * @return String
	 */
	public String getSd_status_acpt() {
		return ((String) getAttrVal("Sd_status_acpt"));
	}	
	/**
	 * 接受状态编码
	 * @param Sd_status_acpt
	 */
	public void setSd_status_acpt(String Sd_status_acpt) {
		setAttrVal("Sd_status_acpt", Sd_status_acpt);
	}
	/**
	 * 接受日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 接受日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 接受医护人员
	 * @return String
	 */
	public String getId_emp_acpt() {
		return ((String) getAttrVal("Id_emp_acpt"));
	}	
	/**
	 * 接受医护人员
	 * @param Id_emp_acpt
	 */
	public void setId_emp_acpt(String Id_emp_acpt) {
		setAttrVal("Id_emp_acpt", Id_emp_acpt);
	}
	/**
	 * 接受医护人员名称
	 * @return String
	 */
	public String getName_emp_acpt() {
		return ((String) getAttrVal("Name_emp_acpt"));
	}	
	/**
	 * 接受医护人员名称
	 * @param Name_emp_acpt
	 */
	public void setName_emp_acpt(String Name_emp_acpt) {
		setAttrVal("Name_emp_acpt", Name_emp_acpt);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}	
	/**
	 * 分诊台id
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 接受队列工作点
	 * @return String
	 */
	public String getId_que_site() {
		return ((String) getAttrVal("Id_que_site"));
	}	
	/**
	 * 接受队列工作点
	 * @param Id_que_site
	 */
	public void setId_que_site(String Id_que_site) {
		setAttrVal("Id_que_site", Id_que_site);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 病情等级id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}	
	/**
	 * 病情等级id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 就诊病情评估等级
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}	
	/**
	 * 就诊病情评估等级
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 指定挂号医生id
	 * @return String
	 */
	public String getId_emp_opreg() {
		return ((String) getAttrVal("Id_emp_opreg"));
	}	
	/**
	 * 指定挂号医生id
	 * @param Id_emp_opreg
	 */
	public void setId_emp_opreg(String Id_emp_opreg) {
		setAttrVal("Id_emp_opreg", Id_emp_opreg);
	}
	/**
	 * 优先级别
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}	
	/**
	 * 优先级别
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 优先级别原因
	 * @return String
	 */
	public String getLevel_pri_rsn() {
		return ((String) getAttrVal("Level_pri_rsn"));
	}	
	/**
	 * 优先级别原因
	 * @param Level_pri_rsn
	 */
	public void setLevel_pri_rsn(String Level_pri_rsn) {
		setAttrVal("Level_pri_rsn", Level_pri_rsn);
	}
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 预约标志
	 * @return FBoolean
	 */
	public FBoolean getFg_apt() {
		return ((FBoolean) getAttrVal("Fg_apt"));
	}	
	/**
	 * 预约标志
	 * @param Fg_apt
	 */
	public void setFg_apt(FBoolean Fg_apt) {
		setAttrVal("Fg_apt", Fg_apt);
	}
	/**
	 * 需手工分诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}	
	/**
	 * 需手工分诊标志
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
	}
	/**
	 * 回诊标识
	 * @return FBoolean
	 */
	public FBoolean getFg_rtn() {
		return ((FBoolean) getAttrVal("Fg_rtn"));
	}	
	/**
	 * 回诊标识
	 * @param Fg_rtn
	 */
	public void setFg_rtn(FBoolean Fg_rtn) {
		setAttrVal("Fg_rtn", Fg_rtn);
	}
	/**
	 * 客开扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客开扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客开扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客开扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客开扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客开扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客开扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客开扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客开扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客开扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 需回诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needrtn() {
		return ((FBoolean) getAttrVal("Fg_needrtn"));
	}	
	/**
	 * 需回诊标志
	 * @param Fg_needrtn
	 */
	public void setFg_needrtn(FBoolean Fg_needrtn) {
		setAttrVal("Fg_needrtn", Fg_needrtn);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
		return "Id_ent_que";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_que";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnQueueDODesc.class);
	}
	
}