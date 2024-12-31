package iih.ems.emcm.emrep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.emcm.emrep.d.desc.EmsRepairDODesc;
import java.math.BigDecimal;

/**
 * 设备维修 DO数据 
 * 
 */
public class EmsRepairDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//维修表流水号
	public static final String ID_REPAIR= "Id_repair";
	//维修单号
	public static final String CODE= "Code";
	//维修名称
	public static final String NAME= "Name";
	//资产卡号
	public static final String ID_CARD= "Id_card";
	//资产卡编号
	public static final String CARD_NO= "Card_no";
	//卡片名称
	public static final String CARD_NAME= "Card_name";
	//设备科室编码
	public static final String ID_DEPT= "Id_dept";
	//设备编码
	public static final String ID_EM= "Id_em";
	//设备分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//维修单位(维修填写)
	public static final String REPAIR_DEPT= "Repair_dept";
	//维修次数(维修填写)
	public static final String REPAIR_NUM= "Repair_num";
	//维修费用合计(维修填写)
	public static final String REPAIR_COST= "Repair_cost";
	//维修联系方式(维修填写)
	public static final String REPAIR_CONTACT= "Repair_contact";
	//维修原因
	public static final String REPAIR_CAUSE= "Repair_cause";
	//维修/保养开始时间(维修填写)
	public static final String DT_REPAIR_ST= "Dt_repair_st";
	//维修/保养结束时间(维修填写)
	public static final String DT_REPAIR_END= "Dt_repair_end";
	//维修类别(维修填写)
	public static final String ID_REP_TP= "Id_rep_tp";
	//维修类别编码
	public static final String SD_REP_TP= "Sd_rep_tp";
	//发票号码(外修填写)
	public static final String INVOICE_NO= "Invoice_no";
	//发票日期(外修填写)
	public static final String DT_INVOICE= "Dt_invoice";
	//维修材料(内修填写)
	public static final String REPAIR_STUFF= "Repair_stuff";
	//材料消耗数量(内修填写) 
	public static final String STUFF_NUM= "Stuff_num";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管等级编码
	public static final String SD_STOR_LEVEL= "Sd_stor_level";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//保管人
	public static final String ID_STOR_OPER= "Id_stor_oper";
	//维修状态
	public static final String ID_ST= "Id_st";
	//维修状态编码
	public static final String SD_ST= "Sd_st";
	//申请人
	public static final String ID_OPER= "Id_oper";
	//申请仓库
	public static final String ID_WH= "Id_wh";
	//申请时间
	public static final String DT_APP= "Dt_app";
	//提交人
	public static final String ID_REG_OPER= "Id_reg_oper";
	//提交时间
	public static final String DT_REG= "Dt_reg";
	//接单人(维修填写)
	public static final String ID_ACC_OPER= "Id_acc_oper";
	//接单时间(维修填写)
	public static final String DT_ACC= "Dt_acc";
	//维修完成人(维修填写)
	public static final String ID_COMPL_OPER= "Id_compl_oper";
	//维修完成时间(维修填写)
	public static final String DT_COMPL= "Dt_compl";
	//验收人
	public static final String ID_INSP_OPER= "Id_insp_oper";
	//验收科室
	public static final String ID_INSP_DEPT= "Id_insp_dept";
	//核准时间
	public static final String DT_APPROVE= "Dt_approve";
	//核准人
	public static final String ID_APPROVE_OPER= "Id_approve_oper";
	//作废人
	public static final String ID_WASTE_OPER= "Id_waste_oper";
	//作废科室
	public static final String ID_WASTE_DEPT= "Id_waste_dept";
	//作废时间
	public static final String DT_WASTE= "Dt_waste";
	//作废原因
	public static final String WASTE_CAUSE= "Waste_cause";
	//备注
	public static final String REMARK= "Remark";
	//维修人员名称(可多人) (维修填写)
	public static final String REPAIR_PERSON= "Repair_person";
	//维修工时
	public static final String REPAIR_MAN_HOUR= "Repair_man_hour";
	//维修费(维修填写)
	public static final String UPKEEP_COST= "Upkeep_cost";
	//维修材料费(维修填写)
	public static final String STUFF_COST= "Stuff_cost";
	//维修其它费用(维修填写)
	public static final String OTHER_COST= "Other_cost";
	//工作性质(维修填写)
	public static final String WORK_NATURE= "Work_nature";
	//故障现象(维修填写)
	public static final String FAULT_SITUATION= "Fault_situation";
	//故障原因(维修填写)
	public static final String FAULT_REASON= "Fault_reason";
	//设备现状(维修填写)
	public static final String EM_SITUATION= "Em_situation";
	//维修工作内容(维修填写)
	public static final String REPAIR_CONTENTS= "Repair_contents";
	//配件等待时间(维修填写)
	public static final String WAIT_TIME= "Wait_time";
	//部门意见
	public static final String DEPT_IDEA= "Dept_idea";
	//故障时间
	public static final String DT_FAULT= "Dt_fault";
	//使用科室负责人意见(审核填写)
	public static final String CHARGE_PERSON_IEDA= "Charge_person_ieda";
	//领导意见(审核填写)
	public static final String LEADER_IDEA= "Leader_idea";
	//维修反馈（验收）
	public static final String REPAIR_FEEDBACK= "Repair_feedback";
	//发票信息(维修填写)
	public static final String INVOICE_INFO= "Invoice_info";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//名称
	public static final String NAME_REPAIR= "Name_repair";
	//名称
	public static final String NAME_REP_TP= "Name_rep_tp";
	//名称
	public static final String NAME_STOR_LEVEL= "Name_stor_level";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//姓名
	public static final String NAME_STOR_OPER= "Name_stor_oper";
	//名称
	public static final String NAME_ST= "Name_st";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//姓名
	public static final String NAME_REG_OPER= "Name_reg_oper";
	//姓名
	public static final String NAME_ACC_OPER= "Name_acc_oper";
	//姓名
	public static final String NAME_COMPL_OPER= "Name_compl_oper";
	//姓名
	public static final String NAME_INSP_OPER= "Name_insp_oper";
	//名称
	public static final String NAME_INSP_DEPT= "Name_insp_dept";
	//姓名
	public static final String NAME_APPROVE_OPER= "Name_approve_oper";
	//姓名
	public static final String NAME_WASTE_OPER= "Name_waste_oper";
	//名称
	public static final String NAME_WASTE_DEPT= "Name_waste_dept";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 维修表流水号
	 * @return String
	 */
	public String getId_repair() {
		return ((String) getAttrVal("Id_repair"));
	}	
	/**
	 * 维修表流水号
	 * @param Id_repair
	 */
	public void setId_repair(String Id_repair) {
		setAttrVal("Id_repair", Id_repair);
	}
	/**
	 * 维修单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 维修单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 维修名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 维修名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 资产卡号
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 资产卡号
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产卡编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产卡编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 卡片名称
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}	
	/**
	 * 卡片名称
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}
	/**
	 * 设备科室编码
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 设备科室编码
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备编码
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 设备分类树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 设备分类树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 维修单位(维修填写)
	 * @return String
	 */
	public String getRepair_dept() {
		return ((String) getAttrVal("Repair_dept"));
	}	
	/**
	 * 维修单位(维修填写)
	 * @param Repair_dept
	 */
	public void setRepair_dept(String Repair_dept) {
		setAttrVal("Repair_dept", Repair_dept);
	}
	/**
	 * 维修次数(维修填写)
	 * @return Integer
	 */
	public Integer getRepair_num() {
		return ((Integer) getAttrVal("Repair_num"));
	}	
	/**
	 * 维修次数(维修填写)
	 * @param Repair_num
	 */
	public void setRepair_num(Integer Repair_num) {
		setAttrVal("Repair_num", Repair_num);
	}
	/**
	 * 维修费用合计(维修填写)
	 * @return FDouble
	 */
	public FDouble getRepair_cost() {
		return ((FDouble) getAttrVal("Repair_cost"));
	}	
	/**
	 * 维修费用合计(维修填写)
	 * @param Repair_cost
	 */
	public void setRepair_cost(FDouble Repair_cost) {
		setAttrVal("Repair_cost", Repair_cost);
	}
	/**
	 * 维修联系方式(维修填写)
	 * @return String
	 */
	public String getRepair_contact() {
		return ((String) getAttrVal("Repair_contact"));
	}	
	/**
	 * 维修联系方式(维修填写)
	 * @param Repair_contact
	 */
	public void setRepair_contact(String Repair_contact) {
		setAttrVal("Repair_contact", Repair_contact);
	}
	/**
	 * 维修原因
	 * @return String
	 */
	public String getRepair_cause() {
		return ((String) getAttrVal("Repair_cause"));
	}	
	/**
	 * 维修原因
	 * @param Repair_cause
	 */
	public void setRepair_cause(String Repair_cause) {
		setAttrVal("Repair_cause", Repair_cause);
	}
	/**
	 * 维修/保养开始时间(维修填写)
	 * @return FDateTime
	 */
	public FDateTime getDt_repair_st() {
		return ((FDateTime) getAttrVal("Dt_repair_st"));
	}	
	/**
	 * 维修/保养开始时间(维修填写)
	 * @param Dt_repair_st
	 */
	public void setDt_repair_st(FDateTime Dt_repair_st) {
		setAttrVal("Dt_repair_st", Dt_repair_st);
	}
	/**
	 * 维修/保养结束时间(维修填写)
	 * @return FDateTime
	 */
	public FDateTime getDt_repair_end() {
		return ((FDateTime) getAttrVal("Dt_repair_end"));
	}	
	/**
	 * 维修/保养结束时间(维修填写)
	 * @param Dt_repair_end
	 */
	public void setDt_repair_end(FDateTime Dt_repair_end) {
		setAttrVal("Dt_repair_end", Dt_repair_end);
	}
	/**
	 * 维修类别(维修填写)
	 * @return String
	 */
	public String getId_rep_tp() {
		return ((String) getAttrVal("Id_rep_tp"));
	}	
	/**
	 * 维修类别(维修填写)
	 * @param Id_rep_tp
	 */
	public void setId_rep_tp(String Id_rep_tp) {
		setAttrVal("Id_rep_tp", Id_rep_tp);
	}
	/**
	 * 维修类别编码
	 * @return String
	 */
	public String getSd_rep_tp() {
		return ((String) getAttrVal("Sd_rep_tp"));
	}	
	/**
	 * 维修类别编码
	 * @param Sd_rep_tp
	 */
	public void setSd_rep_tp(String Sd_rep_tp) {
		setAttrVal("Sd_rep_tp", Sd_rep_tp);
	}
	/**
	 * 发票号码(外修填写)
	 * @return String
	 */
	public String getInvoice_no() {
		return ((String) getAttrVal("Invoice_no"));
	}	
	/**
	 * 发票号码(外修填写)
	 * @param Invoice_no
	 */
	public void setInvoice_no(String Invoice_no) {
		setAttrVal("Invoice_no", Invoice_no);
	}
	/**
	 * 发票日期(外修填写)
	 * @return FDate
	 */
	public FDate getDt_invoice() {
		return ((FDate) getAttrVal("Dt_invoice"));
	}	
	/**
	 * 发票日期(外修填写)
	 * @param Dt_invoice
	 */
	public void setDt_invoice(FDate Dt_invoice) {
		setAttrVal("Dt_invoice", Dt_invoice);
	}
	/**
	 * 维修材料(内修填写)
	 * @return String
	 */
	public String getRepair_stuff() {
		return ((String) getAttrVal("Repair_stuff"));
	}	
	/**
	 * 维修材料(内修填写)
	 * @param Repair_stuff
	 */
	public void setRepair_stuff(String Repair_stuff) {
		setAttrVal("Repair_stuff", Repair_stuff);
	}
	/**
	 * 材料消耗数量(内修填写) 
	 * @return Integer
	 */
	public Integer getStuff_num() {
		return ((Integer) getAttrVal("Stuff_num"));
	}	
	/**
	 * 材料消耗数量(内修填写) 
	 * @param Stuff_num
	 */
	public void setStuff_num(Integer Stuff_num) {
		setAttrVal("Stuff_num", Stuff_num);
	}
	/**
	 * 保管等级
	 * @return String
	 */
	public String getId_stor_level() {
		return ((String) getAttrVal("Id_stor_level"));
	}	
	/**
	 * 保管等级
	 * @param Id_stor_level
	 */
	public void setId_stor_level(String Id_stor_level) {
		setAttrVal("Id_stor_level", Id_stor_level);
	}
	/**
	 * 保管等级编码
	 * @return String
	 */
	public String getSd_stor_level() {
		return ((String) getAttrVal("Sd_stor_level"));
	}	
	/**
	 * 保管等级编码
	 * @param Sd_stor_level
	 */
	public void setSd_stor_level(String Sd_stor_level) {
		setAttrVal("Sd_stor_level", Sd_stor_level);
	}
	/**
	 * 保管科室
	 * @return String
	 */
	public String getId_stor_dept() {
		return ((String) getAttrVal("Id_stor_dept"));
	}	
	/**
	 * 保管科室
	 * @param Id_stor_dept
	 */
	public void setId_stor_dept(String Id_stor_dept) {
		setAttrVal("Id_stor_dept", Id_stor_dept);
	}
	/**
	 * 保管人
	 * @return String
	 */
	public String getId_stor_oper() {
		return ((String) getAttrVal("Id_stor_oper"));
	}	
	/**
	 * 保管人
	 * @param Id_stor_oper
	 */
	public void setId_stor_oper(String Id_stor_oper) {
		setAttrVal("Id_stor_oper", Id_stor_oper);
	}
	/**
	 * 维修状态
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	/**
	 * 维修状态
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 维修状态编码
	 * @return String
	 */
	public String getSd_st() {
		return ((String) getAttrVal("Sd_st"));
	}	
	/**
	 * 维修状态编码
	 * @param Sd_st
	 */
	public void setSd_st(String Sd_st) {
		setAttrVal("Sd_st", Sd_st);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 申请人
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	/**
	 * 申请仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 申请仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}	
	/**
	 * 申请时间
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	/**
	 * 提交人
	 * @return String
	 */
	public String getId_reg_oper() {
		return ((String) getAttrVal("Id_reg_oper"));
	}	
	/**
	 * 提交人
	 * @param Id_reg_oper
	 */
	public void setId_reg_oper(String Id_reg_oper) {
		setAttrVal("Id_reg_oper", Id_reg_oper);
	}
	/**
	 * 提交时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 提交时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 接单人(维修填写)
	 * @return String
	 */
	public String getId_acc_oper() {
		return ((String) getAttrVal("Id_acc_oper"));
	}	
	/**
	 * 接单人(维修填写)
	 * @param Id_acc_oper
	 */
	public void setId_acc_oper(String Id_acc_oper) {
		setAttrVal("Id_acc_oper", Id_acc_oper);
	}
	/**
	 * 接单时间(维修填写)
	 * @return FDateTime
	 */
	public FDateTime getDt_acc() {
		return ((FDateTime) getAttrVal("Dt_acc"));
	}	
	/**
	 * 接单时间(维修填写)
	 * @param Dt_acc
	 */
	public void setDt_acc(FDateTime Dt_acc) {
		setAttrVal("Dt_acc", Dt_acc);
	}
	/**
	 * 维修完成人(维修填写)
	 * @return String
	 */
	public String getId_compl_oper() {
		return ((String) getAttrVal("Id_compl_oper"));
	}	
	/**
	 * 维修完成人(维修填写)
	 * @param Id_compl_oper
	 */
	public void setId_compl_oper(String Id_compl_oper) {
		setAttrVal("Id_compl_oper", Id_compl_oper);
	}
	/**
	 * 维修完成时间(维修填写)
	 * @return FDateTime
	 */
	public FDateTime getDt_compl() {
		return ((FDateTime) getAttrVal("Dt_compl"));
	}	
	/**
	 * 维修完成时间(维修填写)
	 * @param Dt_compl
	 */
	public void setDt_compl(FDateTime Dt_compl) {
		setAttrVal("Dt_compl", Dt_compl);
	}
	/**
	 * 验收人
	 * @return String
	 */
	public String getId_insp_oper() {
		return ((String) getAttrVal("Id_insp_oper"));
	}	
	/**
	 * 验收人
	 * @param Id_insp_oper
	 */
	public void setId_insp_oper(String Id_insp_oper) {
		setAttrVal("Id_insp_oper", Id_insp_oper);
	}
	/**
	 * 验收科室
	 * @return String
	 */
	public String getId_insp_dept() {
		return ((String) getAttrVal("Id_insp_dept"));
	}	
	/**
	 * 验收科室
	 * @param Id_insp_dept
	 */
	public void setId_insp_dept(String Id_insp_dept) {
		setAttrVal("Id_insp_dept", Id_insp_dept);
	}
	/**
	 * 核准时间
	 * @return FDateTime
	 */
	public FDateTime getDt_approve() {
		return ((FDateTime) getAttrVal("Dt_approve"));
	}	
	/**
	 * 核准时间
	 * @param Dt_approve
	 */
	public void setDt_approve(FDateTime Dt_approve) {
		setAttrVal("Dt_approve", Dt_approve);
	}
	/**
	 * 核准人
	 * @return String
	 */
	public String getId_approve_oper() {
		return ((String) getAttrVal("Id_approve_oper"));
	}	
	/**
	 * 核准人
	 * @param Id_approve_oper
	 */
	public void setId_approve_oper(String Id_approve_oper) {
		setAttrVal("Id_approve_oper", Id_approve_oper);
	}
	/**
	 * 作废人
	 * @return String
	 */
	public String getId_waste_oper() {
		return ((String) getAttrVal("Id_waste_oper"));
	}	
	/**
	 * 作废人
	 * @param Id_waste_oper
	 */
	public void setId_waste_oper(String Id_waste_oper) {
		setAttrVal("Id_waste_oper", Id_waste_oper);
	}
	/**
	 * 作废科室
	 * @return String
	 */
	public String getId_waste_dept() {
		return ((String) getAttrVal("Id_waste_dept"));
	}	
	/**
	 * 作废科室
	 * @param Id_waste_dept
	 */
	public void setId_waste_dept(String Id_waste_dept) {
		setAttrVal("Id_waste_dept", Id_waste_dept);
	}
	/**
	 * 作废时间
	 * @return FDateTime
	 */
	public FDateTime getDt_waste() {
		return ((FDateTime) getAttrVal("Dt_waste"));
	}	
	/**
	 * 作废时间
	 * @param Dt_waste
	 */
	public void setDt_waste(FDateTime Dt_waste) {
		setAttrVal("Dt_waste", Dt_waste);
	}
	/**
	 * 作废原因
	 * @return String
	 */
	public String getWaste_cause() {
		return ((String) getAttrVal("Waste_cause"));
	}	
	/**
	 * 作废原因
	 * @param Waste_cause
	 */
	public void setWaste_cause(String Waste_cause) {
		setAttrVal("Waste_cause", Waste_cause);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 维修人员名称(可多人) (维修填写)
	 * @return String
	 */
	public String getRepair_person() {
		return ((String) getAttrVal("Repair_person"));
	}	
	/**
	 * 维修人员名称(可多人) (维修填写)
	 * @param Repair_person
	 */
	public void setRepair_person(String Repair_person) {
		setAttrVal("Repair_person", Repair_person);
	}
	/**
	 * 维修工时
	 * @return String
	 */
	public String getRepair_man_hour() {
		return ((String) getAttrVal("Repair_man_hour"));
	}	
	/**
	 * 维修工时
	 * @param Repair_man_hour
	 */
	public void setRepair_man_hour(String Repair_man_hour) {
		setAttrVal("Repair_man_hour", Repair_man_hour);
	}
	/**
	 * 维修费(维修填写)
	 * @return FDouble
	 */
	public FDouble getUpkeep_cost() {
		return ((FDouble) getAttrVal("Upkeep_cost"));
	}	
	/**
	 * 维修费(维修填写)
	 * @param Upkeep_cost
	 */
	public void setUpkeep_cost(FDouble Upkeep_cost) {
		setAttrVal("Upkeep_cost", Upkeep_cost);
	}
	/**
	 * 维修材料费(维修填写)
	 * @return FDouble
	 */
	public FDouble getStuff_cost() {
		return ((FDouble) getAttrVal("Stuff_cost"));
	}	
	/**
	 * 维修材料费(维修填写)
	 * @param Stuff_cost
	 */
	public void setStuff_cost(FDouble Stuff_cost) {
		setAttrVal("Stuff_cost", Stuff_cost);
	}
	/**
	 * 维修其它费用(维修填写)
	 * @return FDouble
	 */
	public FDouble getOther_cost() {
		return ((FDouble) getAttrVal("Other_cost"));
	}	
	/**
	 * 维修其它费用(维修填写)
	 * @param Other_cost
	 */
	public void setOther_cost(FDouble Other_cost) {
		setAttrVal("Other_cost", Other_cost);
	}
	/**
	 * 工作性质(维修填写)
	 * @return String
	 */
	public String getWork_nature() {
		return ((String) getAttrVal("Work_nature"));
	}	
	/**
	 * 工作性质(维修填写)
	 * @param Work_nature
	 */
	public void setWork_nature(String Work_nature) {
		setAttrVal("Work_nature", Work_nature);
	}
	/**
	 * 故障现象(维修填写)
	 * @return String
	 */
	public String getFault_situation() {
		return ((String) getAttrVal("Fault_situation"));
	}	
	/**
	 * 故障现象(维修填写)
	 * @param Fault_situation
	 */
	public void setFault_situation(String Fault_situation) {
		setAttrVal("Fault_situation", Fault_situation);
	}
	/**
	 * 故障原因(维修填写)
	 * @return String
	 */
	public String getFault_reason() {
		return ((String) getAttrVal("Fault_reason"));
	}	
	/**
	 * 故障原因(维修填写)
	 * @param Fault_reason
	 */
	public void setFault_reason(String Fault_reason) {
		setAttrVal("Fault_reason", Fault_reason);
	}
	/**
	 * 设备现状(维修填写)
	 * @return String
	 */
	public String getEm_situation() {
		return ((String) getAttrVal("Em_situation"));
	}	
	/**
	 * 设备现状(维修填写)
	 * @param Em_situation
	 */
	public void setEm_situation(String Em_situation) {
		setAttrVal("Em_situation", Em_situation);
	}
	/**
	 * 维修工作内容(维修填写)
	 * @return String
	 */
	public String getRepair_contents() {
		return ((String) getAttrVal("Repair_contents"));
	}	
	/**
	 * 维修工作内容(维修填写)
	 * @param Repair_contents
	 */
	public void setRepair_contents(String Repair_contents) {
		setAttrVal("Repair_contents", Repair_contents);
	}
	/**
	 * 配件等待时间(维修填写)
	 * @return String
	 */
	public String getWait_time() {
		return ((String) getAttrVal("Wait_time"));
	}	
	/**
	 * 配件等待时间(维修填写)
	 * @param Wait_time
	 */
	public void setWait_time(String Wait_time) {
		setAttrVal("Wait_time", Wait_time);
	}
	/**
	 * 部门意见
	 * @return String
	 */
	public String getDept_idea() {
		return ((String) getAttrVal("Dept_idea"));
	}	
	/**
	 * 部门意见
	 * @param Dept_idea
	 */
	public void setDept_idea(String Dept_idea) {
		setAttrVal("Dept_idea", Dept_idea);
	}
	/**
	 * 故障时间
	 * @return String
	 */
	public String getDt_fault() {
		return ((String) getAttrVal("Dt_fault"));
	}	
	/**
	 * 故障时间
	 * @param Dt_fault
	 */
	public void setDt_fault(String Dt_fault) {
		setAttrVal("Dt_fault", Dt_fault);
	}
	/**
	 * 使用科室负责人意见(审核填写)
	 * @return String
	 */
	public String getCharge_person_ieda() {
		return ((String) getAttrVal("Charge_person_ieda"));
	}	
	/**
	 * 使用科室负责人意见(审核填写)
	 * @param Charge_person_ieda
	 */
	public void setCharge_person_ieda(String Charge_person_ieda) {
		setAttrVal("Charge_person_ieda", Charge_person_ieda);
	}
	/**
	 * 领导意见(审核填写)
	 * @return String
	 */
	public String getLeader_idea() {
		return ((String) getAttrVal("Leader_idea"));
	}	
	/**
	 * 领导意见(审核填写)
	 * @param Leader_idea
	 */
	public void setLeader_idea(String Leader_idea) {
		setAttrVal("Leader_idea", Leader_idea);
	}
	/**
	 * 维修反馈（验收）
	 * @return String
	 */
	public String getRepair_feedback() {
		return ((String) getAttrVal("Repair_feedback"));
	}	
	/**
	 * 维修反馈（验收）
	 * @param Repair_feedback
	 */
	public void setRepair_feedback(String Repair_feedback) {
		setAttrVal("Repair_feedback", Repair_feedback);
	}
	/**
	 * 发票信息(维修填写)
	 * @return String
	 */
	public String getInvoice_info() {
		return ((String) getAttrVal("Invoice_info"));
	}	
	/**
	 * 发票信息(维修填写)
	 * @param Invoice_info
	 */
	public void setInvoice_info(String Invoice_info) {
		setAttrVal("Invoice_info", Invoice_info);
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
	 * 财务年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 财务年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName_em() {
		return ((String) getAttrVal("Name_em"));
	}	
	/**
	 * 设备名称
	 * @param Name_em
	 */
	public void setName_em(String Name_em) {
		setAttrVal("Name_em", Name_em);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_repair() {
		return ((String) getAttrVal("Name_repair"));
	}	
	/**
	 * 名称
	 * @param Name_repair
	 */
	public void setName_repair(String Name_repair) {
		setAttrVal("Name_repair", Name_repair);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rep_tp() {
		return ((String) getAttrVal("Name_rep_tp"));
	}	
	/**
	 * 名称
	 * @param Name_rep_tp
	 */
	public void setName_rep_tp(String Name_rep_tp) {
		setAttrVal("Name_rep_tp", Name_rep_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_level() {
		return ((String) getAttrVal("Name_stor_level"));
	}	
	/**
	 * 名称
	 * @param Name_stor_level
	 */
	public void setName_stor_level(String Name_stor_level) {
		setAttrVal("Name_stor_level", Name_stor_level);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_dept() {
		return ((String) getAttrVal("Name_stor_dept"));
	}	
	/**
	 * 名称
	 * @param Name_stor_dept
	 */
	public void setName_stor_dept(String Name_stor_dept) {
		setAttrVal("Name_stor_dept", Name_stor_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_stor_oper() {
		return ((String) getAttrVal("Name_stor_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_stor_oper
	 */
	public void setName_stor_oper(String Name_stor_oper) {
		setAttrVal("Name_stor_oper", Name_stor_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_st() {
		return ((String) getAttrVal("Name_st"));
	}	
	/**
	 * 名称
	 * @param Name_st
	 */
	public void setName_st(String Name_st) {
		setAttrVal("Name_st", Name_st);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_reg_oper() {
		return ((String) getAttrVal("Name_reg_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_reg_oper
	 */
	public void setName_reg_oper(String Name_reg_oper) {
		setAttrVal("Name_reg_oper", Name_reg_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_acc_oper() {
		return ((String) getAttrVal("Name_acc_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_acc_oper
	 */
	public void setName_acc_oper(String Name_acc_oper) {
		setAttrVal("Name_acc_oper", Name_acc_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_compl_oper() {
		return ((String) getAttrVal("Name_compl_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_compl_oper
	 */
	public void setName_compl_oper(String Name_compl_oper) {
		setAttrVal("Name_compl_oper", Name_compl_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_insp_oper() {
		return ((String) getAttrVal("Name_insp_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_insp_oper
	 */
	public void setName_insp_oper(String Name_insp_oper) {
		setAttrVal("Name_insp_oper", Name_insp_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_insp_dept() {
		return ((String) getAttrVal("Name_insp_dept"));
	}	
	/**
	 * 名称
	 * @param Name_insp_dept
	 */
	public void setName_insp_dept(String Name_insp_dept) {
		setAttrVal("Name_insp_dept", Name_insp_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_approve_oper() {
		return ((String) getAttrVal("Name_approve_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_approve_oper
	 */
	public void setName_approve_oper(String Name_approve_oper) {
		setAttrVal("Name_approve_oper", Name_approve_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_waste_oper() {
		return ((String) getAttrVal("Name_waste_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_waste_oper
	 */
	public void setName_waste_oper(String Name_waste_oper) {
		setAttrVal("Name_waste_oper", Name_waste_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_waste_dept() {
		return ((String) getAttrVal("Name_waste_dept"));
	}	
	/**
	 * 名称
	 * @param Name_waste_dept
	 */
	public void setName_waste_dept(String Name_waste_dept) {
		setAttrVal("Name_waste_dept", Name_waste_dept);
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
		return "Id_repair";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_rep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsRepairDODesc.class);
	}
	
}