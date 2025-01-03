package iih.en.pv.outpatient.d.desc;

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
 * 门诊属性 DO 元数据信息
 */
public class OutpatientDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.outpatient.d.OutpatientDO";
	public static final String CLASS_DISPALYNAME = "门诊属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_ent_op";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_outpatient";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OutpatientDODesc(){
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
		this.setKeyDesc(getId_outpatientADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_outpatientADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getCode_amr_oepADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getId_svrtpADesc(tblDesc));
		this.add(getSd_svrtpADesc(tblDesc));
		this.add(getId_emp_operatorADesc(tblDesc));
		this.add(getDt_valid_bADesc(tblDesc));
		this.add(getDt_valid_eADesc(tblDesc));
		this.add(getId_schaptADesc(tblDesc));
		this.add(getId_schADesc(tblDesc));
		this.add(getId_dateslotADesc(tblDesc));
		this.add(getId_ticksADesc(tblDesc));
		this.add(getId_tickADesc(tblDesc));
		this.add(getTicketnoADesc(tblDesc));
		this.add(getId_scresADesc(tblDesc));
		this.add(getId_scsrvADesc(tblDesc));
		this.add(getId_dep_regADesc(tblDesc));
		this.add(getId_emp_regADesc(tblDesc));
		this.add(getId_cg_regADesc(tblDesc));
		this.add(getFg_firstADesc(tblDesc));
		this.add(getFg_cgADesc(tblDesc));
		this.add(getId_cgADesc(tblDesc));
		this.add(getId_gowhereADesc(tblDesc));
		this.add(getSd_gowhereADesc(tblDesc));
		this.add(getId_level_diseADesc(tblDesc));
		this.add(getSd_level_diseADesc(tblDesc));
		this.add(getFg_needrtnADesc(tblDesc));
		this.add(getEu_regtpADesc(tblDesc));
		this.add(getTimes_opADesc(tblDesc));
		this.add(getFg_rescueADesc(tblDesc));
		this.add(getTimes_rescueADesc(tblDesc));
		this.add(getSucc_rescueADesc(tblDesc));
		this.add(getEu_preobsADesc(tblDesc));
		this.add(getDt_di_morADesc(tblDesc));
		this.add(getTimes_printADesc(tblDesc));
		this.add(getDayslot_codeADesc(tblDesc));
		this.add(getDayslot_nameADesc(tblDesc));
		this.add(getId_dayslottpADesc(tblDesc));
		this.add(getSd_dayslottpADesc(tblDesc));
		this.add(getScres_codeADesc(tblDesc));
		this.add(getScres_nameADesc(tblDesc));
		this.add(getScsrv_codeADesc(tblDesc));
		this.add(getScsrv_nameADesc(tblDesc));
		this.add(getDep_reg_codeADesc(tblDesc));
		this.add(getDep_reg_nameADesc(tblDesc));
		this.add(getEmp_reg_codeADesc(tblDesc));
		this.add(getEmp_reg_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_outpatientCDesc(tblDesc));
		tblDesc.add(getId_outpatientCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getCode_amr_oepCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getId_svrtpCDesc(tblDesc));
		tblDesc.add(getSd_svrtpCDesc(tblDesc));
		tblDesc.add(getId_emp_operatorCDesc(tblDesc));
		tblDesc.add(getDt_valid_bCDesc(tblDesc));
		tblDesc.add(getDt_valid_eCDesc(tblDesc));
		tblDesc.add(getId_schaptCDesc(tblDesc));
		tblDesc.add(getId_schCDesc(tblDesc));
		tblDesc.add(getId_dateslotCDesc(tblDesc));
		tblDesc.add(getId_ticksCDesc(tblDesc));
		tblDesc.add(getId_tickCDesc(tblDesc));
		tblDesc.add(getTicketnoCDesc(tblDesc));
		tblDesc.add(getId_scresCDesc(tblDesc));
		tblDesc.add(getId_scsrvCDesc(tblDesc));
		tblDesc.add(getId_dep_regCDesc(tblDesc));
		tblDesc.add(getId_emp_regCDesc(tblDesc));
		tblDesc.add(getId_cg_regCDesc(tblDesc));
		tblDesc.add(getFg_firstCDesc(tblDesc));
		tblDesc.add(getFg_cgCDesc(tblDesc));
		tblDesc.add(getId_cgCDesc(tblDesc));
		tblDesc.add(getId_gowhereCDesc(tblDesc));
		tblDesc.add(getSd_gowhereCDesc(tblDesc));
		tblDesc.add(getId_level_diseCDesc(tblDesc));
		tblDesc.add(getSd_level_diseCDesc(tblDesc));
		tblDesc.add(getFg_needrtnCDesc(tblDesc));
		tblDesc.add(getEu_regtpCDesc(tblDesc));
		tblDesc.add(getTimes_opCDesc(tblDesc));
		tblDesc.add(getFg_rescueCDesc(tblDesc));
		tblDesc.add(getTimes_rescueCDesc(tblDesc));
		tblDesc.add(getSucc_rescueCDesc(tblDesc));
		tblDesc.add(getEu_preobsCDesc(tblDesc));
		tblDesc.add(getDt_di_morCDesc(tblDesc));
		tblDesc.add(getTimes_printCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 门诊属性主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outpatientADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_outpatient",  getId_outpatientCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊属性主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊档案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_oep",  getCode_amr_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊档案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_svrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_svrtp",  getId_svrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_svrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_svrtp",  getSd_svrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应挂号员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_operator",  getId_emp_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应挂号员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有效期限_开始属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_valid_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_valid_b",  getDt_valid_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效期限_开始");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效期限_结束属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_valid_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_valid_e",  getDt_valid_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效期限_结束");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_schaptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_schapt",  getId_schaptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应排班属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_schADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sch",  getId_schCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应排班");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期分组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dateslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dateslot",  getId_dateslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 号段id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ticksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ticks",  getId_ticksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号段id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 号位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tick",  getId_tickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊排队号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTicketnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ticketno",  getTicketnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("就诊排队号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班资源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scres",  getId_scresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班资源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsrv",  getId_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 挂号科室id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_reg",  getId_dep_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号科室id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 挂号医生id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_reg",  getId_emp_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号医生id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应计费_挂号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cg_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cg_reg",  getId_cg_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应计费_挂号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 初诊标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_firstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_first",  getFg_firstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("初诊标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已结算标志_挂号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cg",  getFg_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("已结算标志_挂号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应结算_挂号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cg",  getId_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应结算_挂号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gowhereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_gowhere",  getId_gowhereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_gowhereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_gowhere",  getSd_gowhereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_diseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_dise",  getId_level_diseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病情等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_diseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_dise",  getSd_level_diseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需回诊标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needrtnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needrtn",  getFg_needrtnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("需回诊标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 挂号类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_regtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_regtp",  getEu_regtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_op",  getTimes_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("门诊次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_rescueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_rescue",  getFg_rescueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("抢救标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_rescueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_rescue",  getTimes_rescueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抢救次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救成功次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSucc_rescueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Succ_rescue",  getSucc_rescueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抢救成功次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_preobsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_preobs",  getEu_preobsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断记录发病日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_di_morADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_di_mor",  getDt_di_morCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("诊断记录发病日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救打印次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_printADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_print",  getTimes_printCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抢救打印次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDayslot_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dayslot_code",  getDayslot_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b9","id_dateslot=id_dayslot","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDayslot_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dayslot_name",  getDayslot_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b9","id_dateslot=id_dayslot","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dayslottpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dayslottp",  getId_dayslottpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b9","id_dateslot=id_dayslot","id_dayslottp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期分组类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dayslottpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dayslottp",  getSd_dayslottpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b9","id_dateslot=id_dayslot","sd_dayslottp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScres_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scres_code",  getScres_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_res a0b11","id_scres=id_scres","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScres_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scres_name",  getScres_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_res a0b11","id_scres=id_scres","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScsrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scsrv_code",  getScsrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b12","id_scsrv=id_scsrv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScsrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scsrv_name",  getScsrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b12","id_scsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 挂号科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_reg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_reg_code",  getDep_reg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","id_dep_reg=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 挂号科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_reg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_reg_name",  getDep_reg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","id_dep_reg=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 挂号医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_reg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_reg_code",  getEmp_reg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_emp_reg=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 挂号医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_reg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_reg_name",  getEmp_reg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("挂号医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_emp_reg=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取门诊属性主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outpatientCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_outpatient");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊属性主键"); 
		return column;
	}
	/**
	 * 获取患者就诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊主键"); 
		return column;
	}
	/**
	 * 获取门诊档案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_oep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊档案号"); 
		return column;
	}
	/**
	 * 获取就诊状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状态"); 
		return column;
	}
	/**
	 * 获取诊疗类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_svrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_svrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗类型"); 
		return column;
	}
	/**
	 * 获取诊疗类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_svrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_svrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗类型编码"); 
		return column;
	}
	/**
	 * 获取对应挂号员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_operator");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应挂号员"); 
		return column;
	}
	/**
	 * 获取有效期限_开始表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_valid_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_valid_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效期限_开始"); 
		return column;
	}
	/**
	 * 获取有效期限_结束表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_valid_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_valid_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效期限_结束"); 
		return column;
	}
	/**
	 * 获取对应预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_schaptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_schapt");
		column.setLength(22);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应预约"); 
		return column;
	}
	/**
	 * 获取对应排班表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_schCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sch");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应排班"); 
		return column;
	}
	/**
	 * 获取日期分组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dateslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dateslot");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组"); 
		return column;
	}
	/**
	 * 获取号段id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ticksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ticks");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号段id"); 
		return column;
	}
	/**
	 * 获取号位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tick");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号位id"); 
		return column;
	}
	/**
	 * 获取就诊排队号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTicketnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ticketno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("就诊排队号"); 
		return column;
	}
	/**
	 * 获取排班资源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scres");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班资源"); 
		return column;
	}
	/**
	 * 获取排班服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务"); 
		return column;
	}
	/**
	 * 获取挂号科室id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_reg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号科室id"); 
		return column;
	}
	/**
	 * 获取挂号医生id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_reg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号医生id"); 
		return column;
	}
	/**
	 * 获取对应计费_挂号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cg_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cg_reg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应计费_挂号"); 
		return column;
	}
	/**
	 * 获取初诊标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_firstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_first");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("初诊标志"); 
		return column;
	}
	/**
	 * 获取已结算标志_挂号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("已结算标志_挂号"); 
		return column;
	}
	/**
	 * 获取对应结算_挂号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应结算_挂号"); 
		return column;
	}
	/**
	 * 获取转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gowhereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_gowhere");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转归"); 
		return column;
	}
	/**
	 * 获取转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_gowhereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_gowhere");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转归编码"); 
		return column;
	}
	/**
	 * 获取病情等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_diseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_dise");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情等级"); 
		return column;
	}
	/**
	 * 获取病情等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_diseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_dise");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情等级编码"); 
		return column;
	}
	/**
	 * 获取需回诊标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needrtnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needrtn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("需回诊标志"); 
		return column;
	}
	/**
	 * 获取挂号类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_regtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_regtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号类型"); 
		return column;
	}
	/**
	 * 获取门诊次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_op");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("门诊次数"); 
		return column;
	}
	/**
	 * 获取抢救标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_rescueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_rescue");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("抢救标志"); 
		return column;
	}
	/**
	 * 获取抢救次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_rescueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_rescue");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抢救次数"); 
		return column;
	}
	/**
	 * 获取抢救成功次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSucc_rescueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Succ_rescue");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抢救成功次数"); 
		return column;
	}
	/**
	 * 获取预检状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_preobsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_preobs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检状态"); 
		return column;
	}
	/**
	 * 获取诊断记录发病日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_di_morCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_di_mor");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊断记录发病日期"); 
		return column;
	}
	/**
	 * 获取抢救打印次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_printCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_print");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抢救打印次数"); 
		return column;
	}
	/**
	 * 获取日期分组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDayslot_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dayslot_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组编码"); 
		return column;
	}
	/**
	 * 获取日期分组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDayslot_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dayslot_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组名称"); 
		return column;
	}
	/**
	 * 获取日期分组类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dayslottpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dayslottp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组类型"); 
		return column;
	}
	/**
	 * 获取日期分组类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dayslottpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dayslottp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组类型编码"); 
		return column;
	}
	/**
	 * 获取资源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScres_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scres_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资源编码"); 
		return column;
	}
	/**
	 * 获取资源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScres_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scres_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资源名称"); 
		return column;
	}
	/**
	 * 获取排班服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScsrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scsrv_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务编码"); 
		return column;
	}
	/**
	 * 获取排班服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScsrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scsrv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务名称"); 
		return column;
	}
	/**
	 * 获取挂号科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_reg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_reg_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号科室编码"); 
		return column;
	}
	/**
	 * 获取挂号科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_reg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_reg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号科室名称"); 
		return column;
	}
	/**
	 * 获取挂号医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_reg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_reg_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号医生编码"); 
		return column;
	}
	/**
	 * 获取挂号医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_reg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_reg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("挂号医生姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
		defaultValueMap.put("Eu_preobs","0");
		defaultValueMap.put("Times_print",0);
	}
	
}

    
