
package iih.ems.emcm.upkeep.d.desc;

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
 * 设备保养记录 DO 元数据信息
 */
public class EmsUpkeepDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.emcm.upkeep.d.EmsUpkeepDO";
	public static final String CLASS_DISPALYNAME = "设备保养记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ems_uk";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_uk";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsUpkeepDODesc(){
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
		this.setKeyDesc(getId_ukADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ukADesc(tblDesc));
		this.add(getId_cardADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getCard_nameADesc(tblDesc));
		this.add(getId_emcaADesc(tblDesc));
		this.add(getId_emADesc(tblDesc));
		this.add(getEmca_inrcodeADesc(tblDesc));
		this.add(getDt_plan_upkeepADesc(tblDesc));
		this.add(getDt_upkeepADesc(tblDesc));
		this.add(getId_upkeep_typeADesc(tblDesc));
		this.add(getSd_upkeep_typeADesc(tblDesc));
		this.add(getUpkeep_contentADesc(tblDesc));
		this.add(getUpkeep_partADesc(tblDesc));
		this.add(getId_stADesc(tblDesc));
		this.add(getSd_stADesc(tblDesc));
		this.add(getId_emp_ukADesc(tblDesc));
		this.add(getUk_suggADesc(tblDesc));
		this.add(getId_uk_rltADesc(tblDesc));
		this.add(getSd_uk_rltADesc(tblDesc));
		this.add(getId_repairADesc(tblDesc));
		this.add(getDt_operADesc(tblDesc));
		this.add(getId_operADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getName_emcaADesc(tblDesc));
		this.add(getName_emADesc(tblDesc));
		this.add(getName_uktpADesc(tblDesc));
		this.add(getName_stADesc(tblDesc));
		this.add(getName_emp_ukADesc(tblDesc));
		this.add(getName_uk_rltADesc(tblDesc));
		this.add(getName_operADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ukCDesc(tblDesc));
		tblDesc.add(getId_ukCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getCard_nameCDesc(tblDesc));
		tblDesc.add(getId_emcaCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getEmca_inrcodeCDesc(tblDesc));
		tblDesc.add(getDt_plan_upkeepCDesc(tblDesc));
		tblDesc.add(getDt_upkeepCDesc(tblDesc));
		tblDesc.add(getId_upkeep_typeCDesc(tblDesc));
		tblDesc.add(getSd_upkeep_typeCDesc(tblDesc));
		tblDesc.add(getUpkeep_contentCDesc(tblDesc));
		tblDesc.add(getUpkeep_partCDesc(tblDesc));
		tblDesc.add(getId_stCDesc(tblDesc));
		tblDesc.add(getSd_stCDesc(tblDesc));
		tblDesc.add(getId_emp_ukCDesc(tblDesc));
		tblDesc.add(getUk_suggCDesc(tblDesc));
		tblDesc.add(getId_uk_rltCDesc(tblDesc));
		tblDesc.add(getSd_uk_rltCDesc(tblDesc));
		tblDesc.add(getId_repairCDesc(tblDesc));
		tblDesc.add(getDt_operCDesc(tblDesc));
		tblDesc.add(getId_operCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 保养记录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ukADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_uk",  getId_ukCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养记录主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产卡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产卡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 资产卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_name",  getCard_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emca",  getId_emcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备基本信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_em",  getId_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备基本信息");
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
	 * 计划保养时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_plan_upkeepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_plan_upkeep",  getDt_plan_upkeepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("计划保养时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际保养时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_upkeepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_upkeep",  getDt_upkeepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("实际保养时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保养类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_upkeep_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_upkeep_type",  getId_upkeep_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保养类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_upkeep_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_upkeep_type",  getSd_upkeep_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保养内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUpkeep_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Upkeep_content",  getUpkeep_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保养部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUpkeep_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Upkeep_part",  getUpkeep_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保养单状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_st",  getId_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养单状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保养单状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_st",  getSd_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养单状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指派保养人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_ukADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_uk",  getId_emp_ukCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指派保养人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保养建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUk_suggADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Uk_sugg",  getUk_suggCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保养结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_uk_rltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_uk_rlt",  getId_uk_rltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保养结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_uk_rltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_uk_rlt",  getSd_uk_rltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保养结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应维修记录流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_repairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_repair",  getId_repairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应维修记录流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper",  getDt_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("操作时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper",  getId_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emca",  getName_emcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_ca a0b7","id_emca=id_emca","name"});
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
		attrDesc.setRefTblInfos(new String[]{"ems_info a0b8","id_em=id_em","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_uktpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_uktp",  getName_uktpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_upkeep_type=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_st=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_ukADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_uk",  getName_emp_ukCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b11","id_emp_uk=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_uk_rltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_uk_rlt",  getName_uk_rltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_uk_rlt=id_udidoc","name"});
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
	 * 获取保养记录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ukCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_uk");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("保养记录主键"); 
		return column;
	}
	/**
	 * 获取资产卡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产卡"); 
		return column;
	}
	/**
	 * 获取资产卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产卡号"); 
		return column;
	}
	/**
	 * 获取资产名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产名称"); 
		return column;
	}
	/**
	 * 获取设备分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类"); 
		return column;
	}
	/**
	 * 获取设备基本信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_em");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备基本信息"); 
		return column;
	}
	/**
	 * 获取设备分类树内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmca_inrcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emca_inrcode");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类树内码"); 
		return column;
	}
	/**
	 * 获取计划保养时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_plan_upkeepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_plan_upkeep");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划保养时间"); 
		return column;
	}
	/**
	 * 获取实际保养时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_upkeepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_upkeep");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际保养时间"); 
		return column;
	}
	/**
	 * 获取保养类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_upkeep_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_upkeep_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养类别"); 
		return column;
	}
	/**
	 * 获取保养类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_upkeep_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_upkeep_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养类别编码"); 
		return column;
	}
	/**
	 * 获取保养内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUpkeep_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Upkeep_content");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养内容"); 
		return column;
	}
	/**
	 * 获取保养部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUpkeep_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Upkeep_part");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养部位"); 
		return column;
	}
	/**
	 * 获取保养单状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_st");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养单状态"); 
		return column;
	}
	/**
	 * 获取保养单状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_st");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养单状态编码"); 
		return column;
	}
	/**
	 * 获取指派保养人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_ukCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_uk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指派保养人员"); 
		return column;
	}
	/**
	 * 获取保养建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUk_suggCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Uk_sugg");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养建议"); 
		return column;
	}
	/**
	 * 获取保养结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_uk_rltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_uk_rlt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养结果"); 
		return column;
	}
	/**
	 * 获取保养结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_uk_rltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_uk_rlt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保养结果编码"); 
		return column;
	}
	/**
	 * 获取对应维修记录流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_repairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_repair");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应维修记录流水号"); 
		return column;
	}
	/**
	 * 获取操作时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("操作时间"); 
		return column;
	}
	/**
	 * 获取操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作员"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emca");
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
	private IColumnDesc getName_uktpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_uktp");
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
	private IColumnDesc getName_emp_ukCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_uk");
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
	private IColumnDesc getName_uk_rltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_uk_rlt");
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
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
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
