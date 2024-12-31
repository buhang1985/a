
package iih.sfda.aer.sfdaaerevmnoexpihosptm.d.desc;

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
 * 非预期延长住院时间 DO 元数据信息
 */
public class SfdaAerEvMNoexpIhospTmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevmnoexpihosptm.d.SfdaAerEvMNoexpIhospTmDO";
	public static final String CLASS_DISPALYNAME = "非预期延长住院时间";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_MNOEXPIHOSPTM";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_mnoexpihosptm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvMNoexpIhospTmDODesc(){
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
		this.setKeyDesc(getId_aer_ev_mnoexpihosptmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_mnoexpihosptmADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getPat_ihosp_tmADesc(tblDesc));
		this.add(getPat_med_numADesc(tblDesc));
		this.add(getIn_hosp_dayADesc(tblDesc));
		this.add(getDiagn_depADesc(tblDesc));
		this.add(getIn_hosp_diagnADesc(tblDesc));
		this.add(getDiagn_passADesc(tblDesc));
		this.add(getCurr_diagnADesc(tblDesc));
		this.add(getId_lihosp_reasADesc(tblDesc));
		this.add(getSd_lihosp_reasADesc(tblDesc));
		this.add(getOth_lihosp_reasADesc(tblDesc));
		this.add(getExis_probmADesc(tblDesc));
		this.add(getNo_expt_handmADesc(tblDesc));
		this.add(getExt1ADesc(tblDesc));
		this.add(getExt2ADesc(tblDesc));
		this.add(getExt3ADesc(tblDesc));
		this.add(getExt4ADesc(tblDesc));
		this.add(getExt5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_lihosp_reasADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_mnoexpihosptmCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_mnoexpihosptmCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getPat_ihosp_tmCDesc(tblDesc));
		tblDesc.add(getPat_med_numCDesc(tblDesc));
		tblDesc.add(getIn_hosp_dayCDesc(tblDesc));
		tblDesc.add(getDiagn_depCDesc(tblDesc));
		tblDesc.add(getIn_hosp_diagnCDesc(tblDesc));
		tblDesc.add(getDiagn_passCDesc(tblDesc));
		tblDesc.add(getCurr_diagnCDesc(tblDesc));
		tblDesc.add(getId_lihosp_reasCDesc(tblDesc));
		tblDesc.add(getSd_lihosp_reasCDesc(tblDesc));
		tblDesc.add(getOth_lihosp_reasCDesc(tblDesc));
		tblDesc.add(getExis_probmCDesc(tblDesc));
		tblDesc.add(getNo_expt_handmCDesc(tblDesc));
		tblDesc.add(getExt1CDesc(tblDesc));
		tblDesc.add(getExt2CDesc(tblDesc));
		tblDesc.add(getExt3CDesc(tblDesc));
		tblDesc.add(getExt4CDesc(tblDesc));
		tblDesc.add(getExt5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 非预期延长住院时间主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_mnoexpihosptmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_mnoexpihosptm",  getId_aer_ev_mnoexpihosptmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("非预期延长住院时间主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理安全事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理安全事件外键");
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
	 * 患者入院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_ihosp_tmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_ihosp_tm",  getPat_ihosp_tmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("患者入院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_med_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_med_num",  getPat_med_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者病案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_hosp_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_hosp_day",  getIn_hosp_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagn_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagn_dep",  getDiagn_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_hosp_diagnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_hosp_diagn",  getIn_hosp_diagnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗经过属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagn_passADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagn_pass",  getDiagn_passCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗经过");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurr_diagnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Curr_diagn",  getCurr_diagnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长期住院原因id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lihosp_reasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lihosp_reas",  getId_lihosp_reasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("长期住院原因id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 长期住院原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lihosp_reasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lihosp_reas",  getSd_lihosp_reasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("长期住院原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长期住院其他原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_lihosp_reasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_lihosp_reas",  getOth_lihosp_reasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("长期住院其他原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 存在问题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExis_probmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exis_probm",  getExis_probmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("存在问题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 非预期事件处理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_expt_handmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_expt_handm",  getNo_expt_handmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("非预期事件处理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext1",  getExt1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext2",  getExt2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext3",  getExt3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext4",  getExt4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext5",  getExt5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段5");
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
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lihosp_reasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lihosp_reas",  getName_lihosp_reasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_lihosp_reas=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取非预期延长住院时间主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_mnoexpihosptmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_mnoexpihosptm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("非预期延长住院时间主键"); 
		return column;
	}
	/**
	 * 获取护理安全事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理安全事件外键"); 
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
	 * 获取患者入院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_ihosp_tmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_ihosp_tm");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者入院日期"); 
		return column;
	}
	/**
	 * 获取患者病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_med_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_med_num");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者病案号"); 
		return column;
	}
	/**
	 * 获取住院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_hosp_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_hosp_day");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院天数"); 
		return column;
	}
	/**
	 * 获取诊疗科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagn_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagn_dep");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗科室"); 
		return column;
	}
	/**
	 * 获取入院诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_hosp_diagnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_hosp_diagn");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断"); 
		return column;
	}
	/**
	 * 获取诊疗经过表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagn_passCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagn_pass");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗经过"); 
		return column;
	}
	/**
	 * 获取当前诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCurr_diagnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Curr_diagn");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前诊断"); 
		return column;
	}
	/**
	 * 获取长期住院原因id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lihosp_reasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lihosp_reas");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("长期住院原因id"); 
		return column;
	}
	/**
	 * 获取长期住院原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lihosp_reasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lihosp_reas");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("长期住院原因编码"); 
		return column;
	}
	/**
	 * 获取长期住院其他原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_lihosp_reasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_lihosp_reas");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("长期住院其他原因"); 
		return column;
	}
	/**
	 * 获取存在问题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExis_probmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exis_probm");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("存在问题"); 
		return column;
	}
	/**
	 * 获取非预期事件处理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_expt_handmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_expt_handm");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("非预期事件处理措施"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext1");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext2");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext3");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext4");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段4"); 
		return column;
	}
	/**
	 * 获取扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext5");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
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
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lihosp_reasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lihosp_reas");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_aer_ev_mnoexpihosptm");
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
