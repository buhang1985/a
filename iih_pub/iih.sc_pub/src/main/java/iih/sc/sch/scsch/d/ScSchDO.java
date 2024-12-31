package iih.sc.sch.scsch.d;

import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 计划排班_排班 DO数据 
 * 
 */
public class ScSchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排班ID
	public static final String ID_SCH= "Id_sch";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//计划
	public static final String ID_SCPL= "Id_scpl";
	//排班类型
	public static final String ID_SCTP= "Id_sctp";
	//排班类型编码
	public static final String SD_SCTP= "Sd_sctp";
	//排班分类
	public static final String ID_SCCA= "Id_scca";
	//日期
	public static final String D_SCH= "D_sch";
	//日期分组
	public static final String ID_DAYSLOT= "Id_dayslot";
	//号源池总数
	public static final String SCPOLCN= "Scpolcn";
	//票号模式id
	public static final String ID_TICKMD= "Id_tickmd";
	//票号模式
	public static final String SD_TICKMD= "Sd_tickmd";
	//预约规则
	public static final String ID_APPTRU= "Id_apptru";
	//数量_总数
	public static final String QUAN_TOTAL= "Quan_total";
	//数量_总数_可预约
	public static final String QUAN_TOTAL_APPT= "Quan_total_appt";
	//数量_总使用
	public static final String QUAN_TOTAL_USED= "Quan_total_used";
	//数量_号源池0_可预约
	public static final String QUAN0_APPT= "Quan0_appt";
	//数量_号源池0_已用
	public static final String QUAN0_USED= "Quan0_used";
	//数量_号源池1_可预约
	public static final String QUAN1_APPT= "Quan1_appt";
	//数量_号源池1_已用
	public static final String QUAN1_USED= "Quan1_used";
	//数量_号源池2_可预约
	public static final String QUAN2_APPT= "Quan2_appt";
	//数量_号源池2_已用
	public static final String QUAN2_USED= "Quan2_used";
	//数量_号源池3_可预约
	public static final String QUAN3_APPT= "Quan3_appt";
	//数量_号源池3_已用
	public static final String QUAN3_USED= "Quan3_used";
	//数量_号源池4_可预约
	public static final String QUAN4_APPT= "Quan4_appt";
	//数量_号源池4_已用
	public static final String QUAN4_USED= "Quan4_used";
	//数量_号源池5_可预约
	public static final String QUAN5_APPT= "Quan5_appt";
	//数量_号源池5_已用
	public static final String QUAN5_USED= "Quan5_used";
	//数量_号源池6_可预约
	public static final String QUAN6_APPT= "Quan6_appt";
	//数量_号源池6_已用
	public static final String QUAN6_USED= "Quan6_used";
	//数量_号源池7_可预约
	public static final String QUAN7_APPT= "Quan7_appt";
	//数量_号源池7_已用
	public static final String QUAN7_USED= "Quan7_used";
	//数量_号源池8_可预约
	public static final String QUAN8_APPT= "Quan8_appt";
	//数量_号源池8_已用
	public static final String QUAN8_USED= "Quan8_used";
	//数量_号源池9_可预约
	public static final String QUAN9_APPT= "Quan9_appt";
	//数量_号源池9_已用
	public static final String QUAN9_USED= "Quan9_used";
	//已加号数量
	public static final String ADDQUECN= "Addquecn";
	//开始就诊时间
	public static final String T_B_ACPT= "T_b_acpt";
	//结束就诊时间
	public static final String T_E_ACPT= "T_e_acpt";
	//是否标准就诊时间
	public static final String FG_STD_ACPT= "Fg_std_acpt";
	//单服务时长(分钟)
	public static final String SRVSLOT= "Srvslot";
	//推荐提前报到时间
	public static final String SUGEST_EXMINT= "Sugest_exmint";
	//号数
	public static final String SUGEST_NUM_TICK= "Sugest_num_tick";
	//分钟数
	public static final String SUGEST_NUM_MINT= "Sugest_num_mint";
	//停诊挂号时间
	public static final String T_E_REG= "T_e_reg";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
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
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//诊椅
	public static final String ID_QUESITE= "Id_quesite";
	//排班护士
	public static final String ID_EMP_NURSE= "Id_emp_nurse";
	//科室参数
	public static final String ID_DEPPARAM= "Id_depparam";
	//最大加号数量
	public static final String MAX_NUM_ADD= "Max_num_add";
	//替诊排班
	public static final String ID_SCSCH_CANCTO= "Id_scsch_cancto";
	//自动释放号源
	public static final String FG_AUTO_RELEASE= "Fg_auto_release";
	//是否设置就诊类型
	public static final String FG_SETENTP= "Fg_setentp";
	//是否自动预约
	public static final String FG_AUTO_APT= "Fg_auto_apt";
	//数据转移标志
	public static final String FG_TRANSED= "Fg_transed";
	//日期分组名称
	public static final String NAME_DAYSLOT= "Name_dayslot";
	//预约规则类型编码
	public static final String SD_SCHRULE= "Sd_schrule";
	//版本号
	public static final String VER= "Ver";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排班ID
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班ID
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 计划
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}	
	/**
	 * 计划
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 排班类型
	 * @return String
	 */
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	/**
	 * 排班类型
	 * @param Id_sctp
	 */
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	/**
	 * 排班类型编码
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	/**
	 * 排班类型编码
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}	
	/**
	 * 日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 日期分组
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	/**
	 * 日期分组
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 号源池总数
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 号源池总数
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 票号模式id
	 * @return String
	 */
	public String getId_tickmd() {
		return ((String) getAttrVal("Id_tickmd"));
	}	
	/**
	 * 票号模式id
	 * @param Id_tickmd
	 */
	public void setId_tickmd(String Id_tickmd) {
		setAttrVal("Id_tickmd", Id_tickmd);
	}
	/**
	 * 票号模式
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}	
	/**
	 * 票号模式
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 预约规则
	 * @return String
	 */
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}	
	/**
	 * 预约规则
	 * @param Id_apptru
	 */
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
	}
	/**
	 * 数量_总数
	 * @return Integer
	 */
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}	
	/**
	 * 数量_总数
	 * @param Quan_total
	 */
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 数量_总数_可预约
	 * @return Integer
	 */
	public Integer getQuan_total_appt() {
		return ((Integer) getAttrVal("Quan_total_appt"));
	}	
	/**
	 * 数量_总数_可预约
	 * @param Quan_total_appt
	 */
	public void setQuan_total_appt(Integer Quan_total_appt) {
		setAttrVal("Quan_total_appt", Quan_total_appt);
	}
	/**
	 * 数量_总使用
	 * @return Integer
	 */
	public Integer getQuan_total_used() {
		return ((Integer) getAttrVal("Quan_total_used"));
	}	
	/**
	 * 数量_总使用
	 * @param Quan_total_used
	 */
	public void setQuan_total_used(Integer Quan_total_used) {
		setAttrVal("Quan_total_used", Quan_total_used);
	}
	/**
	 * 数量_号源池0_可预约
	 * @return Integer
	 */
	public Integer getQuan0_appt() {
		return ((Integer) getAttrVal("Quan0_appt"));
	}	
	/**
	 * 数量_号源池0_可预约
	 * @param Quan0_appt
	 */
	public void setQuan0_appt(Integer Quan0_appt) {
		setAttrVal("Quan0_appt", Quan0_appt);
	}
	/**
	 * 数量_号源池0_已用
	 * @return Integer
	 */
	public Integer getQuan0_used() {
		return ((Integer) getAttrVal("Quan0_used"));
	}	
	/**
	 * 数量_号源池0_已用
	 * @param Quan0_used
	 */
	public void setQuan0_used(Integer Quan0_used) {
		setAttrVal("Quan0_used", Quan0_used);
	}
	/**
	 * 数量_号源池1_可预约
	 * @return Integer
	 */
	public Integer getQuan1_appt() {
		return ((Integer) getAttrVal("Quan1_appt"));
	}	
	/**
	 * 数量_号源池1_可预约
	 * @param Quan1_appt
	 */
	public void setQuan1_appt(Integer Quan1_appt) {
		setAttrVal("Quan1_appt", Quan1_appt);
	}
	/**
	 * 数量_号源池1_已用
	 * @return Integer
	 */
	public Integer getQuan1_used() {
		return ((Integer) getAttrVal("Quan1_used"));
	}	
	/**
	 * 数量_号源池1_已用
	 * @param Quan1_used
	 */
	public void setQuan1_used(Integer Quan1_used) {
		setAttrVal("Quan1_used", Quan1_used);
	}
	/**
	 * 数量_号源池2_可预约
	 * @return Integer
	 */
	public Integer getQuan2_appt() {
		return ((Integer) getAttrVal("Quan2_appt"));
	}	
	/**
	 * 数量_号源池2_可预约
	 * @param Quan2_appt
	 */
	public void setQuan2_appt(Integer Quan2_appt) {
		setAttrVal("Quan2_appt", Quan2_appt);
	}
	/**
	 * 数量_号源池2_已用
	 * @return Integer
	 */
	public Integer getQuan2_used() {
		return ((Integer) getAttrVal("Quan2_used"));
	}	
	/**
	 * 数量_号源池2_已用
	 * @param Quan2_used
	 */
	public void setQuan2_used(Integer Quan2_used) {
		setAttrVal("Quan2_used", Quan2_used);
	}
	/**
	 * 数量_号源池3_可预约
	 * @return Integer
	 */
	public Integer getQuan3_appt() {
		return ((Integer) getAttrVal("Quan3_appt"));
	}	
	/**
	 * 数量_号源池3_可预约
	 * @param Quan3_appt
	 */
	public void setQuan3_appt(Integer Quan3_appt) {
		setAttrVal("Quan3_appt", Quan3_appt);
	}
	/**
	 * 数量_号源池3_已用
	 * @return Integer
	 */
	public Integer getQuan3_used() {
		return ((Integer) getAttrVal("Quan3_used"));
	}	
	/**
	 * 数量_号源池3_已用
	 * @param Quan3_used
	 */
	public void setQuan3_used(Integer Quan3_used) {
		setAttrVal("Quan3_used", Quan3_used);
	}
	/**
	 * 数量_号源池4_可预约
	 * @return Integer
	 */
	public Integer getQuan4_appt() {
		return ((Integer) getAttrVal("Quan4_appt"));
	}	
	/**
	 * 数量_号源池4_可预约
	 * @param Quan4_appt
	 */
	public void setQuan4_appt(Integer Quan4_appt) {
		setAttrVal("Quan4_appt", Quan4_appt);
	}
	/**
	 * 数量_号源池4_已用
	 * @return Integer
	 */
	public Integer getQuan4_used() {
		return ((Integer) getAttrVal("Quan4_used"));
	}	
	/**
	 * 数量_号源池4_已用
	 * @param Quan4_used
	 */
	public void setQuan4_used(Integer Quan4_used) {
		setAttrVal("Quan4_used", Quan4_used);
	}
	/**
	 * 数量_号源池5_可预约
	 * @return Integer
	 */
	public Integer getQuan5_appt() {
		return ((Integer) getAttrVal("Quan5_appt"));
	}	
	/**
	 * 数量_号源池5_可预约
	 * @param Quan5_appt
	 */
	public void setQuan5_appt(Integer Quan5_appt) {
		setAttrVal("Quan5_appt", Quan5_appt);
	}
	/**
	 * 数量_号源池5_已用
	 * @return Integer
	 */
	public Integer getQuan5_used() {
		return ((Integer) getAttrVal("Quan5_used"));
	}	
	/**
	 * 数量_号源池5_已用
	 * @param Quan5_used
	 */
	public void setQuan5_used(Integer Quan5_used) {
		setAttrVal("Quan5_used", Quan5_used);
	}
	/**
	 * 数量_号源池6_可预约
	 * @return Integer
	 */
	public Integer getQuan6_appt() {
		return ((Integer) getAttrVal("Quan6_appt"));
	}	
	/**
	 * 数量_号源池6_可预约
	 * @param Quan6_appt
	 */
	public void setQuan6_appt(Integer Quan6_appt) {
		setAttrVal("Quan6_appt", Quan6_appt);
	}
	/**
	 * 数量_号源池6_已用
	 * @return Integer
	 */
	public Integer getQuan6_used() {
		return ((Integer) getAttrVal("Quan6_used"));
	}	
	/**
	 * 数量_号源池6_已用
	 * @param Quan6_used
	 */
	public void setQuan6_used(Integer Quan6_used) {
		setAttrVal("Quan6_used", Quan6_used);
	}
	/**
	 * 数量_号源池7_可预约
	 * @return Integer
	 */
	public Integer getQuan7_appt() {
		return ((Integer) getAttrVal("Quan7_appt"));
	}	
	/**
	 * 数量_号源池7_可预约
	 * @param Quan7_appt
	 */
	public void setQuan7_appt(Integer Quan7_appt) {
		setAttrVal("Quan7_appt", Quan7_appt);
	}
	/**
	 * 数量_号源池7_已用
	 * @return Integer
	 */
	public Integer getQuan7_used() {
		return ((Integer) getAttrVal("Quan7_used"));
	}	
	/**
	 * 数量_号源池7_已用
	 * @param Quan7_used
	 */
	public void setQuan7_used(Integer Quan7_used) {
		setAttrVal("Quan7_used", Quan7_used);
	}
	/**
	 * 数量_号源池8_可预约
	 * @return Integer
	 */
	public Integer getQuan8_appt() {
		return ((Integer) getAttrVal("Quan8_appt"));
	}	
	/**
	 * 数量_号源池8_可预约
	 * @param Quan8_appt
	 */
	public void setQuan8_appt(Integer Quan8_appt) {
		setAttrVal("Quan8_appt", Quan8_appt);
	}
	/**
	 * 数量_号源池8_已用
	 * @return Integer
	 */
	public Integer getQuan8_used() {
		return ((Integer) getAttrVal("Quan8_used"));
	}	
	/**
	 * 数量_号源池8_已用
	 * @param Quan8_used
	 */
	public void setQuan8_used(Integer Quan8_used) {
		setAttrVal("Quan8_used", Quan8_used);
	}
	/**
	 * 数量_号源池9_可预约
	 * @return Integer
	 */
	public Integer getQuan9_appt() {
		return ((Integer) getAttrVal("Quan9_appt"));
	}	
	/**
	 * 数量_号源池9_可预约
	 * @param Quan9_appt
	 */
	public void setQuan9_appt(Integer Quan9_appt) {
		setAttrVal("Quan9_appt", Quan9_appt);
	}
	/**
	 * 数量_号源池9_已用
	 * @return Integer
	 */
	public Integer getQuan9_used() {
		return ((Integer) getAttrVal("Quan9_used"));
	}	
	/**
	 * 数量_号源池9_已用
	 * @param Quan9_used
	 */
	public void setQuan9_used(Integer Quan9_used) {
		setAttrVal("Quan9_used", Quan9_used);
	}
	/**
	 * 已加号数量
	 * @return Integer
	 */
	public Integer getAddquecn() {
		return ((Integer) getAttrVal("Addquecn"));
	}	
	/**
	 * 已加号数量
	 * @param Addquecn
	 */
	public void setAddquecn(Integer Addquecn) {
		setAttrVal("Addquecn", Addquecn);
	}
	/**
	 * 开始就诊时间
	 * @return FTime
	 */
	public FTime getT_b_acpt() {
		return ((FTime) getAttrVal("T_b_acpt"));
	}	
	/**
	 * 开始就诊时间
	 * @param T_b_acpt
	 */
	public void setT_b_acpt(FTime T_b_acpt) {
		setAttrVal("T_b_acpt", T_b_acpt);
	}
	/**
	 * 结束就诊时间
	 * @return FTime
	 */
	public FTime getT_e_acpt() {
		return ((FTime) getAttrVal("T_e_acpt"));
	}	
	/**
	 * 结束就诊时间
	 * @param T_e_acpt
	 */
	public void setT_e_acpt(FTime T_e_acpt) {
		setAttrVal("T_e_acpt", T_e_acpt);
	}
	/**
	 * 是否标准就诊时间
	 * @return FBoolean
	 */
	public FBoolean getFg_std_acpt() {
		return ((FBoolean) getAttrVal("Fg_std_acpt"));
	}	
	/**
	 * 是否标准就诊时间
	 * @param Fg_std_acpt
	 */
	public void setFg_std_acpt(FBoolean Fg_std_acpt) {
		setAttrVal("Fg_std_acpt", Fg_std_acpt);
	}
	/**
	 * 单服务时长(分钟)
	 * @return Integer
	 */
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}	
	/**
	 * 单服务时长(分钟)
	 * @param Srvslot
	 */
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
	}
	/**
	 * 推荐提前报到时间
	 * @return Integer
	 */
	public Integer getSugest_exmint() {
		return ((Integer) getAttrVal("Sugest_exmint"));
	}	
	/**
	 * 推荐提前报到时间
	 * @param Sugest_exmint
	 */
	public void setSugest_exmint(Integer Sugest_exmint) {
		setAttrVal("Sugest_exmint", Sugest_exmint);
	}
	/**
	 * 号数
	 * @return Integer
	 */
	public Integer getSugest_num_tick() {
		return ((Integer) getAttrVal("Sugest_num_tick"));
	}	
	/**
	 * 号数
	 * @param Sugest_num_tick
	 */
	public void setSugest_num_tick(Integer Sugest_num_tick) {
		setAttrVal("Sugest_num_tick", Sugest_num_tick);
	}
	/**
	 * 分钟数
	 * @return Integer
	 */
	public Integer getSugest_num_mint() {
		return ((Integer) getAttrVal("Sugest_num_mint"));
	}	
	/**
	 * 分钟数
	 * @param Sugest_num_mint
	 */
	public void setSugest_num_mint(Integer Sugest_num_mint) {
		setAttrVal("Sugest_num_mint", Sugest_num_mint);
	}
	/**
	 * 停诊挂号时间
	 * @return FTime
	 */
	public FTime getT_e_reg() {
		return ((FTime) getAttrVal("T_e_reg"));
	}	
	/**
	 * 停诊挂号时间
	 * @param T_e_reg
	 */
	public void setT_e_reg(FTime T_e_reg) {
		setAttrVal("T_e_reg", T_e_reg);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 诊椅
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}	
	/**
	 * 诊椅
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 排班护士
	 * @return String
	 */
	public String getId_emp_nurse() {
		return ((String) getAttrVal("Id_emp_nurse"));
	}	
	/**
	 * 排班护士
	 * @param Id_emp_nurse
	 */
	public void setId_emp_nurse(String Id_emp_nurse) {
		setAttrVal("Id_emp_nurse", Id_emp_nurse);
	}
	/**
	 * 科室参数
	 * @return String
	 */
	public String getId_depparam() {
		return ((String) getAttrVal("Id_depparam"));
	}	
	/**
	 * 科室参数
	 * @param Id_depparam
	 */
	public void setId_depparam(String Id_depparam) {
		setAttrVal("Id_depparam", Id_depparam);
	}
	/**
	 * 最大加号数量
	 * @return Integer
	 */
	public Integer getMax_num_add() {
		return ((Integer) getAttrVal("Max_num_add"));
	}	
	/**
	 * 最大加号数量
	 * @param Max_num_add
	 */
	public void setMax_num_add(Integer Max_num_add) {
		setAttrVal("Max_num_add", Max_num_add);
	}
	/**
	 * 替诊排班
	 * @return String
	 */
	public String getId_scsch_cancto() {
		return ((String) getAttrVal("Id_scsch_cancto"));
	}	
	/**
	 * 替诊排班
	 * @param Id_scsch_cancto
	 */
	public void setId_scsch_cancto(String Id_scsch_cancto) {
		setAttrVal("Id_scsch_cancto", Id_scsch_cancto);
	}
	/**
	 * 自动释放号源
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_release() {
		return ((FBoolean) getAttrVal("Fg_auto_release"));
	}	
	/**
	 * 自动释放号源
	 * @param Fg_auto_release
	 */
	public void setFg_auto_release(FBoolean Fg_auto_release) {
		setAttrVal("Fg_auto_release", Fg_auto_release);
	}
	/**
	 * 是否设置就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_setentp() {
		return ((FBoolean) getAttrVal("Fg_setentp"));
	}	
	/**
	 * 是否设置就诊类型
	 * @param Fg_setentp
	 */
	public void setFg_setentp(FBoolean Fg_setentp) {
		setAttrVal("Fg_setentp", Fg_setentp);
	}
	/**
	 * 是否自动预约
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_apt() {
		return ((FBoolean) getAttrVal("Fg_auto_apt"));
	}	
	/**
	 * 是否自动预约
	 * @param Fg_auto_apt
	 */
	public void setFg_auto_apt(FBoolean Fg_auto_apt) {
		setAttrVal("Fg_auto_apt", Fg_auto_apt);
	}
	/**
	 * 数据转移标志
	 * @return FBoolean
	 */
	public FBoolean getFg_transed() {
		return ((FBoolean) getAttrVal("Fg_transed"));
	}	
	/**
	 * 数据转移标志
	 * @param Fg_transed
	 */
	public void setFg_transed(FBoolean Fg_transed) {
		setAttrVal("Fg_transed", Fg_transed);
	}
	/**
	 * 日期分组名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}	
	/**
	 * 日期分组名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 预约规则类型编码
	 * @return String
	 */
	public String getSd_schrule() {
		return ((String) getAttrVal("Sd_schrule"));
	}	
	/**
	 * 预约规则类型编码
	 * @param Sd_schrule
	 */
	public void setSd_schrule(String Sd_schrule) {
		setAttrVal("Sd_schrule", Sd_schrule);
	}
	/**
	 * 版本号
	 * @return Integer
	 */
	public Integer getVer() {
		return ((Integer) getAttrVal("Ver"));
	}	
	/**
	 * 版本号
	 * @param Ver
	 */
	public void setVer(Integer Ver) {
		setAttrVal("Ver", Ver);
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
		return "Id_sch";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_sch";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchDODesc.class);
	}
	
}