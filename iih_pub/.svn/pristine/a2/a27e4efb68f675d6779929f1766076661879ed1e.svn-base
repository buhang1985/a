
package iih.ems.emcm.emrep.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 设备维修 DO 元数据信息
 */
public class EmsRepairDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.emcm.emrep.d.EmsRepairDO";
	public static final String CLASS_DISPALYNAME = "设备维修";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ems_rep";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_repair";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsRepairDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_repairADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_repairADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_cardADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getCard_nameADesc(tblDesc));
		this.add(getId_deptADesc(tblDesc));
		this.add(getId_emADesc(tblDesc));
		this.add(getEmca_inrcodeADesc(tblDesc));
		this.add(getRepair_deptADesc(tblDesc));
		this.add(getRepair_numADesc(tblDesc));
		this.add(getRepair_costADesc(tblDesc));
		this.add(getRepair_contactADesc(tblDesc));
		this.add(getRepair_causeADesc(tblDesc));
		this.add(getDt_repair_stADesc(tblDesc));
		this.add(getDt_repair_endADesc(tblDesc));
		this.add(getId_rep_tpADesc(tblDesc));
		this.add(getSd_rep_tpADesc(tblDesc));
		this.add(getInvoice_noADesc(tblDesc));
		this.add(getDt_invoiceADesc(tblDesc));
		this.add(getRepair_stuffADesc(tblDesc));
		this.add(getStuff_numADesc(tblDesc));
		this.add(getId_stor_levelADesc(tblDesc));
		this.add(getSd_stor_levelADesc(tblDesc));
		this.add(getId_stor_deptADesc(tblDesc));
		this.add(getId_stor_operADesc(tblDesc));
		this.add(getId_stADesc(tblDesc));
		this.add(getSd_stADesc(tblDesc));
		this.add(getId_operADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getDt_appADesc(tblDesc));
		this.add(getId_reg_operADesc(tblDesc));
		this.add(getDt_regADesc(tblDesc));
		this.add(getId_acc_operADesc(tblDesc));
		this.add(getDt_accADesc(tblDesc));
		this.add(getId_compl_operADesc(tblDesc));
		this.add(getDt_complADesc(tblDesc));
		this.add(getId_insp_operADesc(tblDesc));
		this.add(getId_insp_deptADesc(tblDesc));
		this.add(getDt_approveADesc(tblDesc));
		this.add(getId_approve_operADesc(tblDesc));
		this.add(getId_waste_operADesc(tblDesc));
		this.add(getId_waste_deptADesc(tblDesc));
		this.add(getDt_wasteADesc(tblDesc));
		this.add(getWaste_causeADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
		this.add(getRepair_personADesc(tblDesc));
		this.add(getRepair_man_hourADesc(tblDesc));
		this.add(getUpkeep_costADesc(tblDesc));
		this.add(getStuff_costADesc(tblDesc));
		this.add(getOther_costADesc(tblDesc));
		this.add(getWork_natureADesc(tblDesc));
		this.add(getFault_situationADesc(tblDesc));
		this.add(getFault_reasonADesc(tblDesc));
		this.add(getEm_situationADesc(tblDesc));
		this.add(getRepair_contentsADesc(tblDesc));
		this.add(getWait_timeADesc(tblDesc));
		this.add(getDept_ideaADesc(tblDesc));
		this.add(getDt_faultADesc(tblDesc));
		this.add(getCharge_person_iedaADesc(tblDesc));
		this.add(getLeader_ideaADesc(tblDesc));
		this.add(getRepair_feedbackADesc(tblDesc));
		this.add(getInvoice_infoADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getYear_monthADesc(tblDesc));
		this.add(getName_deptADesc(tblDesc));
		this.add(getName_emADesc(tblDesc));
		this.add(getName_repairADesc(tblDesc));
		this.add(getName_rep_tpADesc(tblDesc));
		this.add(getName_stor_levelADesc(tblDesc));
		this.add(getName_stor_deptADesc(tblDesc));
		this.add(getName_stor_operADesc(tblDesc));
		this.add(getName_stADesc(tblDesc));
		this.add(getName_operADesc(tblDesc));
		this.add(getName_whADesc(tblDesc));
		this.add(getName_reg_operADesc(tblDesc));
		this.add(getName_acc_operADesc(tblDesc));
		this.add(getName_compl_operADesc(tblDesc));
		this.add(getName_insp_operADesc(tblDesc));
		this.add(getName_insp_deptADesc(tblDesc));
		this.add(getName_approve_operADesc(tblDesc));
		this.add(getName_waste_operADesc(tblDesc));
		this.add(getName_waste_deptADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_repairCDesc(tblDesc));
		tblDesc.add(getId_repairCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getCard_nameCDesc(tblDesc));
		tblDesc.add(getId_deptCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getEmca_inrcodeCDesc(tblDesc));
		tblDesc.add(getRepair_deptCDesc(tblDesc));
		tblDesc.add(getRepair_numCDesc(tblDesc));
		tblDesc.add(getRepair_costCDesc(tblDesc));
		tblDesc.add(getRepair_contactCDesc(tblDesc));
		tblDesc.add(getRepair_causeCDesc(tblDesc));
		tblDesc.add(getDt_repair_stCDesc(tblDesc));
		tblDesc.add(getDt_repair_endCDesc(tblDesc));
		tblDesc.add(getId_rep_tpCDesc(tblDesc));
		tblDesc.add(getSd_rep_tpCDesc(tblDesc));
		tblDesc.add(getInvoice_noCDesc(tblDesc));
		tblDesc.add(getDt_invoiceCDesc(tblDesc));
		tblDesc.add(getRepair_stuffCDesc(tblDesc));
		tblDesc.add(getStuff_numCDesc(tblDesc));
		tblDesc.add(getId_stor_levelCDesc(tblDesc));
		tblDesc.add(getSd_stor_levelCDesc(tblDesc));
		tblDesc.add(getId_stor_deptCDesc(tblDesc));
		tblDesc.add(getId_stor_operCDesc(tblDesc));
		tblDesc.add(getId_stCDesc(tblDesc));
		tblDesc.add(getSd_stCDesc(tblDesc));
		tblDesc.add(getId_operCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getDt_appCDesc(tblDesc));
		tblDesc.add(getId_reg_operCDesc(tblDesc));
		tblDesc.add(getDt_regCDesc(tblDesc));
		tblDesc.add(getId_acc_operCDesc(tblDesc));
		tblDesc.add(getDt_accCDesc(tblDesc));
		tblDesc.add(getId_compl_operCDesc(tblDesc));
		tblDesc.add(getDt_complCDesc(tblDesc));
		tblDesc.add(getId_insp_operCDesc(tblDesc));
		tblDesc.add(getId_insp_deptCDesc(tblDesc));
		tblDesc.add(getDt_approveCDesc(tblDesc));
		tblDesc.add(getId_approve_operCDesc(tblDesc));
		tblDesc.add(getId_waste_operCDesc(tblDesc));
		tblDesc.add(getId_waste_deptCDesc(tblDesc));
		tblDesc.add(getDt_wasteCDesc(tblDesc));
		tblDesc.add(getWaste_causeCDesc(tblDesc));
		tblDesc.add(getRemarkCDesc(tblDesc));
		tblDesc.add(getRepair_personCDesc(tblDesc));
		tblDesc.add(getRepair_man_hourCDesc(tblDesc));
		tblDesc.add(getUpkeep_costCDesc(tblDesc));
		tblDesc.add(getStuff_costCDesc(tblDesc));
		tblDesc.add(getOther_costCDesc(tblDesc));
		tblDesc.add(getWork_natureCDesc(tblDesc));
		tblDesc.add(getFault_situationCDesc(tblDesc));
		tblDesc.add(getFault_reasonCDesc(tblDesc));
		tblDesc.add(getEm_situationCDesc(tblDesc));
		tblDesc.add(getRepair_contentsCDesc(tblDesc));
		tblDesc.add(getWait_timeCDesc(tblDesc));
		tblDesc.add(getDept_ideaCDesc(tblDesc));
		tblDesc.add(getDt_faultCDesc(tblDesc));
		tblDesc.add(getCharge_person_iedaCDesc(tblDesc));
		tblDesc.add(getLeader_ideaCDesc(tblDesc));
		tblDesc.add(getRepair_feedbackCDesc(tblDesc));
		tblDesc.add(getInvoice_infoCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getYear_monthCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 维修表流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_repairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_repair",  getId_repairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修表流水号");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 资产卡编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产卡编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_name",  getCard_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept",  getId_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_em",  getId_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备分类树内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmca_inrcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emca_inrcode",  getEmca_inrcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备分类树内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修单位(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_dept",  getRepair_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修单位(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 维修次数(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_num",  getRepair_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("维修次数(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修费用合计(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_cost",  getRepair_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维修费用合计(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修联系方式(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_contactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_contact",  getRepair_contactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修联系方式(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_causeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_cause",  getRepair_causeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修/保养开始时间(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_repair_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_repair_st",  getDt_repair_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("维修/保养开始时间(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修/保养结束时间(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_repair_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_repair_end",  getDt_repair_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("维修/保养结束时间(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修类别(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rep_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rep_tp",  getId_rep_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修类别(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 维修类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rep_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rep_tp",  getSd_rep_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发票号码(外修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvoice_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Invoice_no",  getInvoice_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发票号码(外修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发票日期(外修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_invoiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_invoice",  getDt_invoiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("发票日期(外修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修材料(内修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_stuffADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_stuff",  getRepair_stuffCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修材料(内修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 材料消耗数量(内修填写) 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStuff_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stuff_num",  getStuff_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("材料消耗数量(内修填写) ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保管等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_level",  getId_stor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保管等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stor_level",  getSd_stor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保管科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_dept",  getId_stor_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保管人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_oper",  getId_stor_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 维修状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_st",  getId_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 维修状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_st",  getSd_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper",  getId_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请仓库属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wh",  getId_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请仓库");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_app",  getDt_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提交人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reg_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reg_oper",  getId_reg_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提交人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 提交时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_reg",  getDt_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("提交时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接单人(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_acc_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_acc_oper",  getId_acc_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接单人(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接单时间(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_accADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_acc",  getDt_accCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("接单时间(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修完成人(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_compl_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_compl_oper",  getId_compl_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修完成人(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 维修完成时间(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_complADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_compl",  getDt_complCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("维修完成时间(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 验收人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_insp_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_insp_oper",  getId_insp_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("验收人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 验收科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_insp_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_insp_dept",  getId_insp_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("验收科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 核准时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_approveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_approve",  getDt_approveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("核准时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核准人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_approve_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_approve_oper",  getId_approve_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核准人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 作废人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_waste_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_waste_oper",  getId_waste_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("作废人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 作废科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_waste_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_waste_dept",  getId_waste_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("作废科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 作废时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_wasteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_waste",  getDt_wasteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("作废时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 作废原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWaste_causeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Waste_cause",  getWaste_causeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("作废原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark",  getRemarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修人员名称(可多人) (维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_personADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_person",  getRepair_personCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修人员名称(可多人) (维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修工时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_man_hourADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_man_hour",  getRepair_man_hourCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修工时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修费(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUpkeep_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Upkeep_cost",  getUpkeep_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维修费(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修材料费(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStuff_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stuff_cost",  getStuff_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维修材料费(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修其它费用(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_cost",  getOther_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维修其它费用(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作性质(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWork_natureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Work_nature",  getWork_natureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作性质(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 故障现象(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFault_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fault_situation",  getFault_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("故障现象(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 故障原因(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFault_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fault_reason",  getFault_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("故障原因(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备现状(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEm_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Em_situation",  getEm_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备现状(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修工作内容(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_contentsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_contents",  getRepair_contentsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修工作内容(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配件等待时间(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait_time",  getWait_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配件等待时间(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_ideaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_idea",  getDept_ideaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 故障时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_faultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_fault",  getDt_faultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("故障时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用科室负责人意见(审核填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_person_iedaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_person_ieda",  getCharge_person_iedaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用科室负责人意见(审核填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 领导意见(审核填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLeader_ideaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Leader_idea",  getLeader_ideaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("领导意见(审核填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修反馈（验收）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_feedbackADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_feedback",  getRepair_feedbackCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修反馈（验收）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发票信息(维修填写)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvoice_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Invoice_info",  getInvoice_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发票信息(维修填写)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 财务年月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYear_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year_month",  getYear_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("财务年月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept",  getName_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_em",  getName_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a0b6","id_em=id_em","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_repairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_repair",  getName_repairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","repair_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rep_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rep_tp",  getName_rep_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_rep_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_level",  getName_stor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_stor_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_dept",  getName_stor_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_stor_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_oper",  getName_stor_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b11","id_stor_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_st",  getName_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_st=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper",  getName_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b13","id_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wh",  getName_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b14","id_wh=id_wh","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reg_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_reg_oper",  getName_reg_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_reg_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_acc_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_acc_oper",  getName_acc_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_acc_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_compl_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_compl_oper",  getName_compl_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_compl_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_insp_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_insp_oper",  getName_insp_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b18","id_insp_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_insp_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_insp_dept",  getName_insp_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b19","id_insp_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_approve_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_approve_oper",  getName_approve_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_approve_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_waste_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_waste_oper",  getName_waste_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_waste_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_waste_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_waste_dept",  getName_waste_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b22","id_waste_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取维修表流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_repairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_repair");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("维修表流水号"); 
		return column;
	}
	/**
	 * 获取维修单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修单号"); 
		return column;
	}
	/**
	 * 获取维修名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修名称"); 
		return column;
	}
	/**
	 * 获取资产卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产卡号"); 
		return column;
	}
	/**
	 * 获取资产卡编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产卡编号"); 
		return column;
	}
	/**
	 * 获取卡片名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片名称"); 
		return column;
	}
	/**
	 * 获取设备科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备科室编码"); 
		return column;
	}
	/**
	 * 获取设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_em");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备编码"); 
		return column;
	}
	/**
	 * 获取设备分类树内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmca_inrcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emca_inrcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类树内码"); 
		return column;
	}
	/**
	 * 获取维修单位(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修单位(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修次数(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("维修次数(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修费用合计(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_cost");
		column.setLength(12);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维修费用合计(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修联系方式(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_contactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_contact");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修联系方式(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_causeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_cause");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修原因"); 
		return column;
	}
	/**
	 * 获取维修/保养开始时间(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_repair_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_repair_st");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("维修/保养开始时间(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修/保养结束时间(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_repair_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_repair_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("维修/保养结束时间(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修类别(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rep_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rep_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修类别(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rep_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rep_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修类别编码"); 
		return column;
	}
	/**
	 * 获取发票号码(外修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvoice_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Invoice_no");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发票号码(外修填写)"); 
		return column;
	}
	/**
	 * 获取发票日期(外修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_invoiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_invoice");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发票日期(外修填写)"); 
		return column;
	}
	/**
	 * 获取维修材料(内修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_stuffCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_stuff");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修材料(内修填写)"); 
		return column;
	}
	/**
	 * 获取材料消耗数量(内修填写) 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStuff_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stuff_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("材料消耗数量(内修填写) "); 
		return column;
	}
	/**
	 * 获取保管等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管等级"); 
		return column;
	}
	/**
	 * 获取保管等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stor_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管等级编码"); 
		return column;
	}
	/**
	 * 获取保管科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管科室"); 
		return column;
	}
	/**
	 * 获取保管人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管人"); 
		return column;
	}
	/**
	 * 获取维修状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_st");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修状态"); 
		return column;
	}
	/**
	 * 获取维修状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_st");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修状态编码"); 
		return column;
	}
	/**
	 * 获取申请人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人"); 
		return column;
	}
	/**
	 * 获取申请仓库表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请仓库"); 
		return column;
	}
	/**
	 * 获取申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_app");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请时间"); 
		return column;
	}
	/**
	 * 获取提交人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reg_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reg_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提交人"); 
		return column;
	}
	/**
	 * 获取提交时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_reg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("提交时间"); 
		return column;
	}
	/**
	 * 获取接单人(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_acc_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_acc_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接单人(维修填写)"); 
		return column;
	}
	/**
	 * 获取接单时间(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_accCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_acc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("接单时间(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修完成人(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_compl_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_compl_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修完成人(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修完成时间(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_complCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_compl");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("维修完成时间(维修填写)"); 
		return column;
	}
	/**
	 * 获取验收人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_insp_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_insp_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("验收人"); 
		return column;
	}
	/**
	 * 获取验收科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_insp_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_insp_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("验收科室"); 
		return column;
	}
	/**
	 * 获取核准时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_approveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_approve");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("核准时间"); 
		return column;
	}
	/**
	 * 获取核准人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_approve_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_approve_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核准人"); 
		return column;
	}
	/**
	 * 获取作废人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_waste_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_waste_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("作废人"); 
		return column;
	}
	/**
	 * 获取作废科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_waste_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_waste_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("作废科室"); 
		return column;
	}
	/**
	 * 获取作废时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_wasteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_waste");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("作废时间"); 
		return column;
	}
	/**
	 * 获取作废原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWaste_causeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Waste_cause");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("作废原因"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取维修人员名称(可多人) (维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_personCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_person");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修人员名称(可多人) (维修填写)"); 
		return column;
	}
	/**
	 * 获取维修工时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_man_hourCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_man_hour");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修工时"); 
		return column;
	}
	/**
	 * 获取维修费(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUpkeep_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Upkeep_cost");
		column.setLength(12);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维修费(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修材料费(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStuff_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stuff_cost");
		column.setLength(12);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维修材料费(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修其它费用(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_cost");
		column.setLength(12);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维修其它费用(维修填写)"); 
		return column;
	}
	/**
	 * 获取工作性质(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWork_natureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Work_nature");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作性质(维修填写)"); 
		return column;
	}
	/**
	 * 获取故障现象(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFault_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fault_situation");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("故障现象(维修填写)"); 
		return column;
	}
	/**
	 * 获取故障原因(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFault_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fault_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("故障原因(维修填写)"); 
		return column;
	}
	/**
	 * 获取设备现状(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEm_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Em_situation");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备现状(维修填写)"); 
		return column;
	}
	/**
	 * 获取维修工作内容(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_contentsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_contents");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修工作内容(维修填写)"); 
		return column;
	}
	/**
	 * 获取配件等待时间(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配件等待时间(维修填写)"); 
		return column;
	}
	/**
	 * 获取部门意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_ideaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_idea");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门意见"); 
		return column;
	}
	/**
	 * 获取故障时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_faultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_fault");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("故障时间"); 
		return column;
	}
	/**
	 * 获取使用科室负责人意见(审核填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_person_iedaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_person_ieda");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用科室负责人意见(审核填写)"); 
		return column;
	}
	/**
	 * 获取领导意见(审核填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLeader_ideaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Leader_idea");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("领导意见(审核填写)"); 
		return column;
	}
	/**
	 * 获取维修反馈（验收）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_feedbackCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_feedback");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修反馈（验收）"); 
		return column;
	}
	/**
	 * 获取发票信息(维修填写)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvoice_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Invoice_info");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发票信息(维修填写)"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取财务年月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYear_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year_month");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("财务年月"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取设备名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_em");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_repairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_repair");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rep_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rep_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stor_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stor_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_st");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取仓库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wh");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_reg_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_reg_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_acc_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_acc_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_compl_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_compl_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_insp_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_insp_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_insp_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_insp_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_approve_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_approve_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_waste_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_waste_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_waste_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_waste_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_repair");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
