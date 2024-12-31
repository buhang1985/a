
package iih.sfda.aer.sfdaaerevinstrument.d.desc;

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
 * 医疗器械事件 DO 元数据信息
 */
public class SfdaAerEvInstrumentDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevinstrument.d.SfdaAerEvInstrumentDO";
	public static final String CLASS_DISPALYNAME = "医疗器械事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_INSTRUMENT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_instrument";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvInstrumentDODesc(){
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
		this.setKeyDesc(getId_aer_ev_instrumentADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_instrumentADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getEvent_desADesc(tblDesc));
		this.add(getDis_known_timeADesc(tblDesc));
		this.add(getId_instr_siteADesc(tblDesc));
		this.add(getSd_instr_siteADesc(tblDesc));
		this.add(getOth_instr_siteADesc(tblDesc));
		this.add(getId_event_consequenceADesc(tblDesc));
		this.add(getSd_event_consequenceADesc(tblDesc));
		this.add(getDeath_timeADesc(tblDesc));
		this.add(getEvent_stateADesc(tblDesc));
		this.add(getProduct_nameADesc(tblDesc));
		this.add(getProd_nameADesc(tblDesc));
		this.add(getReg_numberADesc(tblDesc));
		this.add(getManu_nameADesc(tblDesc));
		this.add(getManu_siteADesc(tblDesc));
		this.add(getManu_phoneADesc(tblDesc));
		this.add(getSpec_typeADesc(tblDesc));
		this.add(getProduct_numberADesc(tblDesc));
		this.add(getProduct_bat_numberADesc(tblDesc));
		this.add(getId_operatorADesc(tblDesc));
		this.add(getSd_operatorADesc(tblDesc));
		this.add(getOth_operatorADesc(tblDesc));
		this.add(getEffect_dateADesc(tblDesc));
		this.add(getProd_dateADesc(tblDesc));
		this.add(getStop_dateADesc(tblDesc));
		this.add(getImpla_dateADesc(tblDesc));
		this.add(getEvent_init_analyzeADesc(tblDesc));
		this.add(getEvent_init_disposeADesc(tblDesc));
		this.add(getId_event_stateADesc(tblDesc));
		this.add(getSd_event_stateADesc(tblDesc));
		this.add(getProv_opinionADesc(tblDesc));
		this.add(getState_opinionADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_instr_siteADesc(tblDesc));
		this.add(getName_event_consequenceADesc(tblDesc));
		this.add(getName_operatorADesc(tblDesc));
		this.add(getName_event_stateADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_instrumentCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_instrumentCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getEvent_desCDesc(tblDesc));
		tblDesc.add(getDis_known_timeCDesc(tblDesc));
		tblDesc.add(getId_instr_siteCDesc(tblDesc));
		tblDesc.add(getSd_instr_siteCDesc(tblDesc));
		tblDesc.add(getOth_instr_siteCDesc(tblDesc));
		tblDesc.add(getId_event_consequenceCDesc(tblDesc));
		tblDesc.add(getSd_event_consequenceCDesc(tblDesc));
		tblDesc.add(getDeath_timeCDesc(tblDesc));
		tblDesc.add(getEvent_stateCDesc(tblDesc));
		tblDesc.add(getProduct_nameCDesc(tblDesc));
		tblDesc.add(getProd_nameCDesc(tblDesc));
		tblDesc.add(getReg_numberCDesc(tblDesc));
		tblDesc.add(getManu_nameCDesc(tblDesc));
		tblDesc.add(getManu_siteCDesc(tblDesc));
		tblDesc.add(getManu_phoneCDesc(tblDesc));
		tblDesc.add(getSpec_typeCDesc(tblDesc));
		tblDesc.add(getProduct_numberCDesc(tblDesc));
		tblDesc.add(getProduct_bat_numberCDesc(tblDesc));
		tblDesc.add(getId_operatorCDesc(tblDesc));
		tblDesc.add(getSd_operatorCDesc(tblDesc));
		tblDesc.add(getOth_operatorCDesc(tblDesc));
		tblDesc.add(getEffect_dateCDesc(tblDesc));
		tblDesc.add(getProd_dateCDesc(tblDesc));
		tblDesc.add(getStop_dateCDesc(tblDesc));
		tblDesc.add(getImpla_dateCDesc(tblDesc));
		tblDesc.add(getEvent_init_analyzeCDesc(tblDesc));
		tblDesc.add(getEvent_init_disposeCDesc(tblDesc));
		tblDesc.add(getId_event_stateCDesc(tblDesc));
		tblDesc.add(getSd_event_stateCDesc(tblDesc));
		tblDesc.add(getProv_opinionCDesc(tblDesc));
		tblDesc.add(getState_opinionCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗器械事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_instrumentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_instrument",  getId_aer_ev_instrumentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗器械事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 事件主要表现属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvent_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Event_des",  getEvent_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件主要表现");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发现或者知悉时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDis_known_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dis_known_time",  getDis_known_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("发现或者知悉时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗器械实际使用场所id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_instr_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_instr_site",  getId_instr_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗器械实际使用场所id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗器械实际使用场所编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_instr_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_instr_site",  getSd_instr_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗器械实际使用场所编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他医疗器械实际使用场所属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_instr_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_instr_site",  getOth_instr_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他医疗器械实际使用场所");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件后果id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_event_consequenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_event_consequence",  getId_event_consequenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件后果id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件后果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_event_consequenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_event_consequence",  getSd_event_consequenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件后果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_time",  getDeath_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("死亡时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件陈诉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvent_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Event_state",  getEvent_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件陈诉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProduct_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Product_name",  getProduct_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProd_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prod_name",  getProd_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注册证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReg_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reg_number",  getReg_numberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注册证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产企业名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getManu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Manu_name",  getManu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产企业名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产企业地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getManu_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Manu_site",  getManu_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产企业地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 企业联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getManu_phoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Manu_phone",  getManu_phoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("企业联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 型号规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpec_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spec_type",  getSpec_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("型号规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产品编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProduct_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Product_number",  getProduct_numberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产品编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产品批号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProduct_bat_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Product_bat_number",  getProduct_bat_numberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产品批号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作人id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operator",  getId_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 操作人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_operator",  getSd_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他操作人说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_operator",  getOth_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他操作人说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEffect_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Effect_date",  getEffect_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProd_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prod_date",  getProd_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("生产日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停用日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStop_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stop_date",  getStop_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("停用日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 植入日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImpla_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Impla_date",  getImpla_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("植入日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生初步原因分析属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvent_init_analyzeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Event_init_analyze",  getEvent_init_analyzeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生初步原因分析");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件初步处理情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvent_init_disposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Event_init_dispose",  getEvent_init_disposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件初步处理情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件报告状态id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_event_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_event_state",  getId_event_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件报告状态id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件报告状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_event_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_event_state",  getSd_event_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件报告状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 省级监测技术机构评价意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProv_opinionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prov_opinion",  getProv_opinionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("省级监测技术机构评价意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家监测技术机构评价意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getState_opinionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("State_opinion",  getState_opinionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家监测技术机构评价意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_instr_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_instr_site",  getName_instr_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_instr_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_event_consequenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_event_consequence",  getName_event_consequenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_event_consequence=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operator",  getName_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_operator=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_event_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_event_state",  getName_event_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_event_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗器械事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_instrumentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_instrument");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗器械事件主键"); 
		return column;
	}
	/**
	 * 获取不良事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件外键"); 
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
	 * 获取事件主要表现表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvent_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Event_des");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件主要表现"); 
		return column;
	}
	/**
	 * 获取发现或者知悉时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDis_known_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dis_known_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发现或者知悉时间"); 
		return column;
	}
	/**
	 * 获取医疗器械实际使用场所id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_instr_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_instr_site");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗器械实际使用场所id"); 
		return column;
	}
	/**
	 * 获取医疗器械实际使用场所编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_instr_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_instr_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗器械实际使用场所编码"); 
		return column;
	}
	/**
	 * 获取其他医疗器械实际使用场所表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_instr_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_instr_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他医疗器械实际使用场所"); 
		return column;
	}
	/**
	 * 获取事件后果id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_event_consequenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_event_consequence");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件后果id"); 
		return column;
	}
	/**
	 * 获取事件后果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_event_consequenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_event_consequence");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件后果编码"); 
		return column;
	}
	/**
	 * 获取死亡时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("死亡时间"); 
		return column;
	}
	/**
	 * 获取事件陈诉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvent_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Event_state");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件陈诉"); 
		return column;
	}
	/**
	 * 获取产品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProduct_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Product_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产品名称"); 
		return column;
	}
	/**
	 * 获取商品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProd_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prod_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商品名称"); 
		return column;
	}
	/**
	 * 获取注册证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReg_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reg_number");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注册证号"); 
		return column;
	}
	/**
	 * 获取生产企业名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getManu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Manu_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产企业名称"); 
		return column;
	}
	/**
	 * 获取生产企业地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getManu_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Manu_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产企业地址"); 
		return column;
	}
	/**
	 * 获取企业联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getManu_phoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Manu_phone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("企业联系电话"); 
		return column;
	}
	/**
	 * 获取型号规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpec_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("型号规格"); 
		return column;
	}
	/**
	 * 获取产品编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProduct_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Product_number");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产品编号"); 
		return column;
	}
	/**
	 * 获取产品批号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProduct_bat_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Product_bat_number");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产品批号"); 
		return column;
	}
	/**
	 * 获取操作人id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operator");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人id"); 
		return column;
	}
	/**
	 * 获取操作人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_operator");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人编码"); 
		return column;
	}
	/**
	 * 获取其他操作人说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_operator");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他操作人说明"); 
		return column;
	}
	/**
	 * 获取有效日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEffect_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Effect_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效日期"); 
		return column;
	}
	/**
	 * 获取生产日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProd_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prod_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生产日期"); 
		return column;
	}
	/**
	 * 获取停用日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStop_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stop_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停用日期"); 
		return column;
	}
	/**
	 * 获取植入日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImpla_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Impla_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("植入日期"); 
		return column;
	}
	/**
	 * 获取事件发生初步原因分析表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvent_init_analyzeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Event_init_analyze");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生初步原因分析"); 
		return column;
	}
	/**
	 * 获取事件初步处理情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvent_init_disposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Event_init_dispose");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件初步处理情况"); 
		return column;
	}
	/**
	 * 获取事件报告状态id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_event_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_event_state");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件报告状态id"); 
		return column;
	}
	/**
	 * 获取事件报告状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_event_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_event_state");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件报告状态编码"); 
		return column;
	}
	/**
	 * 获取省级监测技术机构评价意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProv_opinionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prov_opinion");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("省级监测技术机构评价意见"); 
		return column;
	}
	/**
	 * 获取国家监测技术机构评价意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getState_opinionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"State_opinion");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家监测技术机构评价意见"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_instr_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_instr_site");
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
	private IColumnDesc getName_event_consequenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_event_consequence");
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
	private IColumnDesc getName_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operator");
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
	private IColumnDesc getName_event_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_event_state");
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
