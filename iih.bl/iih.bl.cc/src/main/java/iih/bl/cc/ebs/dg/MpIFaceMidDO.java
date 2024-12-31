package iih.bl.cc.ebs.dg;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.mpifacemid.d.desc.MpIFaceMidDODesc;
import java.math.BigDecimal;

/**
 * IIH(EBS)对接中间表   DO数据 
 * 
 */
public class MpIFaceMidDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String IFACE_ID= "Iface_id";
	public static final String IFACE_BATCH_ID= "Iface_batch_id";
	public static final String LINE_NUM= "Line_num";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String OP_IP_FLAG= "Op_ip_flag";
	public static final String CHARGE_DATE= "Charge_date";
	public static final String ITEM_NUMBER= "Item_number";
	public static final String ITEM_DESC= "Item_desc";
	public static final String CHARGE_DEPT_NAME= "Charge_dept_name";
	public static final String CHARGE_DEPT= "Charge_dept";
	public static final String EXECUTE_DEPT_NAME= "Execute_dept_name";
	public static final String WARD_SN= "Ward_sn";
	public static final String WARD_SN_NAME= "Ward_sn_name";
	public static final String GROUP_NO= "Group_no";
	public static final String GROUP_NAME= "Group_name";
	public static final String DELIVER_QTY= "Deliver_qty";
	public static final String DELIVER_UOM_CODE= "Deliver_uom_code";
	public static final String RETAIL_PRICE= "Retail_price";
	public static final String SYNC_DATE= "Sync_date";
	public static final String PROCESS_FLAG= "Process_flag";
	public static final String PROCESS_DATE= "Process_date";
	public static final String WINDOW_NO= "Window_no";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getIface_id() {
		return ((String) getAttrVal("Iface_id"));
	}	
	public void setIface_id(String Iface_id) {
		setAttrVal("Iface_id", Iface_id);
	}
	public Integer getIface_batch_id() {
		return ((Integer) getAttrVal("Iface_batch_id"));
	}	
	public void setIface_batch_id(Integer Iface_batch_id) {
		setAttrVal("Iface_batch_id", Iface_batch_id);
	}
	public String getLine_num() {
		return ((String) getAttrVal("Line_num"));
	}	
	public void setLine_num(String Line_num) {
		setAttrVal("Line_num", Line_num);
	}
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	public String getOp_ip_flag() {
		return ((String) getAttrVal("Op_ip_flag"));
	}	
	public void setOp_ip_flag(String Op_ip_flag) {
		setAttrVal("Op_ip_flag", Op_ip_flag);
	}
	public FDateTime getCharge_date() {
		return ((FDateTime) getAttrVal("Charge_date"));
	}	
	public void setCharge_date(FDateTime Charge_date) {
		setAttrVal("Charge_date", Charge_date);
	}
	public String getItem_number() {
		return ((String) getAttrVal("Item_number"));
	}	
	public void setItem_number(String Item_number) {
		setAttrVal("Item_number", Item_number);
	}
	public String getItem_desc() {
		return ((String) getAttrVal("Item_desc"));
	}	
	public void setItem_desc(String Item_desc) {
		setAttrVal("Item_desc", Item_desc);
	}
	public String getCharge_dept_name() {
		return ((String) getAttrVal("Charge_dept_name"));
	}	
	public void setCharge_dept_name(String Charge_dept_name) {
		setAttrVal("Charge_dept_name", Charge_dept_name);
	}
	public String getCharge_dept() {
		return ((String) getAttrVal("Charge_dept"));
	}	
	public void setCharge_dept(String Charge_dept) {
		setAttrVal("Charge_dept", Charge_dept);
	}
	public String getExecute_dept_name() {
		return ((String) getAttrVal("Execute_dept_name"));
	}	
	public void setExecute_dept_name(String Execute_dept_name) {
		setAttrVal("Execute_dept_name", Execute_dept_name);
	}
	public String getWard_sn() {
		return ((String) getAttrVal("Ward_sn"));
	}	
	public void setWard_sn(String Ward_sn) {
		setAttrVal("Ward_sn", Ward_sn);
	}
	public String getWard_sn_name() {
		return ((String) getAttrVal("Ward_sn_name"));
	}	
	public void setWard_sn_name(String Ward_sn_name) {
		setAttrVal("Ward_sn_name", Ward_sn_name);
	}
	public String getGroup_no() {
		return ((String) getAttrVal("Group_no"));
	}	
	public void setGroup_no(String Group_no) {
		setAttrVal("Group_no", Group_no);
	}
	public String getGroup_name() {
		return ((String) getAttrVal("Group_name"));
	}	
	public void setGroup_name(String Group_name) {
		setAttrVal("Group_name", Group_name);
	}
	public FDouble getDeliver_qty() {
		return ((FDouble) getAttrVal("Deliver_qty"));
	}	
	public void setDeliver_qty(FDouble Deliver_qty) {
		setAttrVal("Deliver_qty", Deliver_qty);
	}
	public String getDeliver_uom_code() {
		return ((String) getAttrVal("Deliver_uom_code"));
	}	
	public void setDeliver_uom_code(String Deliver_uom_code) {
		setAttrVal("Deliver_uom_code", Deliver_uom_code);
	}
	public FDouble getRetail_price() {
		return ((FDouble) getAttrVal("Retail_price"));
	}	
	public void setRetail_price(FDouble Retail_price) {
		setAttrVal("Retail_price", Retail_price);
	}
	public FDateTime getSync_date() {
		return ((FDateTime) getAttrVal("Sync_date"));
	}	
	public void setSync_date(FDateTime Sync_date) {
		setAttrVal("Sync_date", Sync_date);
	}
	public String getProcess_flag() {
		return ((String) getAttrVal("Process_flag"));
	}	
	public void setProcess_flag(String Process_flag) {
		setAttrVal("Process_flag", Process_flag);
	}
	public FDateTime getProcess_date() {
		return ((FDateTime) getAttrVal("Process_date"));
	}	
	public void setProcess_date(FDateTime Process_date) {
		setAttrVal("Process_date", Process_date);
	}
	public String getWindow_no() {
		return ((String) getAttrVal("Window_no"));
	}	
	public void setWindow_no(String Window_no) {
		setAttrVal("Window_no", Window_no);
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
		return "Iface_id";
	}
	
	@Override
	public String getTableName() {	  
		return "IIH_INV_EBS_MEDIC_IFACE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpIFaceMidDODesc.class);
	}
	
}