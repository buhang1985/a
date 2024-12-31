
package iih.nmr.pkuf.nmrdocmobdg.d.desc;

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
 * 移动数据元新版 DO 元数据信息
 */
public class NmrDocMobdeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.nmrdocmobdg.d.NmrDocMobdeDO";
	public static final String CLASS_DISPALYNAME = "移动数据元新版";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nmr_doc_mobde";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_nmr_doc_mobde";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmrDocMobdeDODesc(){
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
		this.setKeyDesc(getId_nmr_doc_mobdeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_nmr_doc_mobdgADesc(tblDesc));
		this.add(getId_nmr_doc_mobdeADesc(tblDesc));
		this.add(getId_nmr_doc_mobdgADesc(tblDesc));
		this.add(getId_propertyADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getName_attrADesc(tblDesc));
		this.add(getId_controltpADesc(tblDesc));
		this.add(getSd_controltpADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_mb_kbADesc(tblDesc));
		this.add(getFg_scoreADesc(tblDesc));
		this.add(getFg_showADesc(tblDesc));
		this.add(getFg_requiredADesc(tblDesc));
		this.add(getFg_editADesc(tblDesc));
		this.add(getFg_defaultADesc(tblDesc));
		this.add(getDef_valADesc(tblDesc));
		this.add(getFg_marcoADesc(tblDesc));
		this.add(getId_marcoADesc(tblDesc));
		this.add(getSd_marcoADesc(tblDesc));
		this.add(getValminADesc(tblDesc));
		this.add(getValmaxADesc(tblDesc));
		this.add(getId_sorcefieldADesc(tblDesc));
		this.add(getName_sorceADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_displayADesc(tblDesc));
		this.add(getName_propertyADesc(tblDesc));
		this.add(getName_controltpADesc(tblDesc));
		this.add(getName_kbADesc(tblDesc));
		this.add(getName_marcoADesc(tblDesc));
		this.add(getName_sorcefieldADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nmr_doc_mobdeCDesc(tblDesc));
		tblDesc.add(getId_nmr_doc_mobdeCDesc(tblDesc));
		tblDesc.add(getId_nmr_doc_mobdgCDesc(tblDesc));
		tblDesc.add(getId_propertyCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getName_attrCDesc(tblDesc));
		tblDesc.add(getId_controltpCDesc(tblDesc));
		tblDesc.add(getSd_controltpCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_mb_kbCDesc(tblDesc));
		tblDesc.add(getFg_scoreCDesc(tblDesc));
		tblDesc.add(getFg_showCDesc(tblDesc));
		tblDesc.add(getFg_requiredCDesc(tblDesc));
		tblDesc.add(getFg_editCDesc(tblDesc));
		tblDesc.add(getFg_defaultCDesc(tblDesc));
		tblDesc.add(getDef_valCDesc(tblDesc));
		tblDesc.add(getFg_marcoCDesc(tblDesc));
		tblDesc.add(getId_marcoCDesc(tblDesc));
		tblDesc.add(getSd_marcoCDesc(tblDesc));
		tblDesc.add(getValminCDesc(tblDesc));
		tblDesc.add(getValmaxCDesc(tblDesc));
		tblDesc.add(getId_sorcefieldCDesc(tblDesc));
		tblDesc.add(getName_sorceCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 移动数据集主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nmr_doc_mobdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nmr_doc_mobde",  getId_nmr_doc_mobdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动数据集主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动数据集合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nmr_doc_mobdgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nmr_doc_mobdg",  getId_nmr_doc_mobdgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动数据集合");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组件类属性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_propertyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_property",  getId_propertyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件类属性");
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
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_attrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_attr",  getName_attrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控件类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_controltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_controltp",  getId_controltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控件类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 控件类型sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_controltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_controltp",  getSd_controltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控件类型sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排序字段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("排序字段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 键盘属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mb_kbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mb_kb",  getId_mb_kbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("键盘");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 算分标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_score",  getFg_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("算分标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动端展示标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_showADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_show",  getFg_showCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("移动端展示标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 必填项标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_requiredADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_required",  getFg_requiredCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("必填项标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可编辑标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_editADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_edit",  getFg_editCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可编辑标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认值标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_default",  getFg_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("默认值标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_val",  getDef_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宏标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_marcoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_marco",  getFg_marcoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("宏标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宏值id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_marcoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_marco",  getId_marcoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宏值id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宏值sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_marcoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_marco",  getSd_marcoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宏值sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Valmin",  getValminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最小值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValmaxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Valmax",  getValmaxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最大值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分数存储的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sorcefieldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sorcefield",  getId_sorcefieldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分数存储的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分值存储属性字段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sorceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sorce",  getName_sorceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分值存储属性字段");
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
	 * 显示名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_displayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_display",  getName_displayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("显示名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"dm_property a1b2","id_property=id","displayname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_propertyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_property",  getName_propertyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"dm_property a1b2","id_property=id","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_controltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_controltp",  getName_controltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_controltp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_kbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_kb",  getName_kbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"Mp_kb a1b4","id_mb_kb=id_kb","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_marcoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_marco",  getName_marcoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_marco=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sorcefieldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sorcefield",  getName_sorcefieldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"dm_property a1b9","id_sorcefield=id","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取移动数据集主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nmr_doc_mobdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nmr_doc_mobde");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("移动数据集主键"); 
		return column;
	}
	/**
	 * 获取移动数据集合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nmr_doc_mobdgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nmr_doc_mobdg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动数据集合"); 
		return column;
	}
	/**
	 * 获取组件类属性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_propertyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_property");
		column.setLength(36);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件类属性"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取属性名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_attrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_attr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性名称"); 
		return column;
	}
	/**
	 * 获取控件类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_controltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_controltp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控件类型id"); 
		return column;
	}
	/**
	 * 获取控件类型sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_controltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_controltp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控件类型sd"); 
		return column;
	}
	/**
	 * 获取排序字段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("排序字段"); 
		return column;
	}
	/**
	 * 获取键盘表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mb_kbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mb_kb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("键盘"); 
		return column;
	}
	/**
	 * 获取算分标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_score");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("算分标记"); 
		return column;
	}
	/**
	 * 获取移动端展示标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_showCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_show");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("移动端展示标记"); 
		return column;
	}
	/**
	 * 获取必填项标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_requiredCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_required");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("必填项标记"); 
		return column;
	}
	/**
	 * 获取可编辑标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_editCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_edit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可编辑标记"); 
		return column;
	}
	/**
	 * 获取默认值标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_default");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认值标记"); 
		return column;
	}
	/**
	 * 获取默认值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值"); 
		return column;
	}
	/**
	 * 获取宏标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_marcoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_marco");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宏标志"); 
		return column;
	}
	/**
	 * 获取宏值id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_marcoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_marco");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宏值id"); 
		return column;
	}
	/**
	 * 获取宏值sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_marcoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_marco");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宏值sd"); 
		return column;
	}
	/**
	 * 获取最小值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Valmin");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最小值"); 
		return column;
	}
	/**
	 * 获取最大值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValmaxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Valmax");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最大值"); 
		return column;
	}
	/**
	 * 获取分数存储的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sorcefieldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sorcefield");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分数存储的"); 
		return column;
	}
	/**
	 * 获取分值存储属性字段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sorceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sorce");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分值存储属性字段"); 
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
	 * 获取显示名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_displayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_display");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("显示名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_propertyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_property");
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
	private IColumnDesc getName_controltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_controltp");
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
	private IColumnDesc getName_kbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_kb");
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
	private IColumnDesc getName_marcoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_marco");
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
	private IColumnDesc getName_sorcefieldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sorcefield");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
