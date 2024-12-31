
package iih.bd.srv.mrtplvs.d.desc;

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
 * 生命体征项属性 DO 元数据信息
 */
public class BdMrtplVsItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO";
	public static final String CLASS_DISPALYNAME = "生命体征项属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrtpl_vs_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrtpl_vs_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdMrtplVsItmDODesc(){
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
		this.setKeyDesc(getId_mrtpl_vs_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mrtpl_vsADesc(tblDesc));
		this.add(getId_mrtpl_vs_itmADesc(tblDesc));
		this.add(getId_mrtpl_vsADesc(tblDesc));
		this.add(getFg_defaultADesc(tblDesc));
		this.add(getId_srvvtADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_dedatatpADesc(tblDesc));
		this.add(getSd_dedatatpADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getId_dataoriginADesc(tblDesc));
		this.add(getSd_dataoriginADesc(tblDesc));
		this.add(getValmaxADesc(tblDesc));
		this.add(getValminADesc(tblDesc));
		this.add(getLenADesc(tblDesc));
		this.add(getId_defaultADesc(tblDesc));
		this.add(getVal_defaultADesc(tblDesc));
		this.add(getId_vs_relADesc(tblDesc));
		this.add(getSd_vs_relADesc(tblDesc));
		this.add(getFg_editADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getFg_idp_selADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_kbADesc(tblDesc));
		this.add(getPrecisionADesc(tblDesc));
		this.add(getFg_nullADesc(tblDesc));
		this.add(getCode_mrtpl_vsADesc(tblDesc));
		this.add(getName_mrtpl_vsADesc(tblDesc));
		this.add(getCode_srvvtADesc(tblDesc));
		this.add(getName_srvvtADesc(tblDesc));
		this.add(getName_dedatpADesc(tblDesc));
		this.add(getName_unitADesc(tblDesc));
		this.add(getCode_unitADesc(tblDesc));
		this.add(getName_dataoriginADesc(tblDesc));
		this.add(getCode_dataoriginADesc(tblDesc));
		this.add(getCode_defaultADesc(tblDesc));
		this.add(getName_vsrelADesc(tblDesc));
		this.add(getName_kbADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrtpl_vs_itmCDesc(tblDesc));
		tblDesc.add(getId_mrtpl_vs_itmCDesc(tblDesc));
		tblDesc.add(getId_mrtpl_vsCDesc(tblDesc));
		tblDesc.add(getFg_defaultCDesc(tblDesc));
		tblDesc.add(getId_srvvtCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_dedatatpCDesc(tblDesc));
		tblDesc.add(getSd_dedatatpCDesc(tblDesc));
		tblDesc.add(getId_unitCDesc(tblDesc));
		tblDesc.add(getId_dataoriginCDesc(tblDesc));
		tblDesc.add(getSd_dataoriginCDesc(tblDesc));
		tblDesc.add(getValmaxCDesc(tblDesc));
		tblDesc.add(getValminCDesc(tblDesc));
		tblDesc.add(getLenCDesc(tblDesc));
		tblDesc.add(getId_defaultCDesc(tblDesc));
		tblDesc.add(getVal_defaultCDesc(tblDesc));
		tblDesc.add(getId_vs_relCDesc(tblDesc));
		tblDesc.add(getSd_vs_relCDesc(tblDesc));
		tblDesc.add(getFg_editCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getFg_idp_selCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_kbCDesc(tblDesc));
		tblDesc.add(getPrecisionCDesc(tblDesc));
		tblDesc.add(getFg_nullCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体征项属性ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpl_vs_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl_vs_itm",  getId_mrtpl_vs_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征项属性ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征项ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpl_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl_vs",  getId_mrtpl_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征项ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_default",  getFg_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("默认项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗服务体征属性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvvtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvvt",  getId_srvvtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务体征属性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗服务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 显示名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("显示名称");
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
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dedatatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dedatatp",  getId_dedatatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dedatatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dedatatp",  getSd_dedatatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dataoriginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dataorigin",  getId_dataoriginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dataoriginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dataorigin",  getSd_dataoriginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源编码");
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
	 * 文本最大长度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Len",  getLenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("文本最大长度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认值ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_default",  getId_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_default",  getVal_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 项目关联类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vs_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vs_rel",  getId_vs_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目关联类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 项目关联类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vs_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vs_rel",  getSd_vs_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目关联类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 允许手动编辑属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_editADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_edit",  getFg_editCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("允许手动编辑");
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
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
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
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
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
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
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
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
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
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
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
	 * 是否允许独立选择属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_idp_selADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_idp_sel",  getFg_idp_selCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许独立选择");
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
	 * 键盘外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_kbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_kb",  getId_kbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("键盘外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 精度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrecisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Precision",  getPrecisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("精度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否允许为空属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nullADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_null",  getFg_nullCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许为空");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mrtpl_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mrtpl_vs",  getCode_mrtpl_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl_vs a1b2","id_mrtpl_vs=id_mrtpl_vs","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征项名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrtpl_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrtpl_vs",  getName_mrtpl_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征项名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl_vs a1b2","id_mrtpl_vs=id_mrtpl_vs","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvvtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srvvt",  getCode_srvvtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvvtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srvvt",  getName_srvvtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dedatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dedatp",  getName_dedatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_dedatatp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit",  getName_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b5","id_unit=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_unit",  getCode_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b5","id_unit=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dataoriginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dataorigin",  getName_dataoriginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_dataorigin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dataoriginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dataorigin",  getCode_dataoriginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_dataorigin=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认值编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_default",  getCode_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_default=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_vsrelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_vsrel",  getName_vsrelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_vs_rel=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"Mp_kb a1b12","id_kb=id_kb","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体征项属性ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpl_vs_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl_vs_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体征项属性ID"); 
		return column;
	}
	/**
	 * 获取体征项ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpl_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl_vs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征项ID"); 
		return column;
	}
	/**
	 * 获取默认项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_default");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认项"); 
		return column;
	}
	/**
	 * 获取医疗服务体征属性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvvtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvvt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务体征属性"); 
		return column;
	}
	/**
	 * 获取医疗服务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务id"); 
		return column;
	}
	/**
	 * 获取显示名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("显示名称"); 
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
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取数据类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dedatatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dedatatp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据类型id"); 
		return column;
	}
	/**
	 * 获取数据类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dedatatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dedatatp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据类型编码"); 
		return column;
	}
	/**
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取数据来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dataoriginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dataorigin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源"); 
		return column;
	}
	/**
	 * 获取数据来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dataoriginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dataorigin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源编码"); 
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
	 * 获取文本最大长度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Len");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("文本最大长度"); 
		return column;
	}
	/**
	 * 获取默认值ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_default");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值ID"); 
		return column;
	}
	/**
	 * 获取默认值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_default");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值"); 
		return column;
	}
	/**
	 * 获取项目关联类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vs_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vs_rel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目关联类型ID"); 
		return column;
	}
	/**
	 * 获取项目关联类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vs_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vs_rel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目关联类型编码"); 
		return column;
	}
	/**
	 * 获取允许手动编辑表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_editCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_edit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("允许手动编辑"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(100);
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
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(100);
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
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(100);
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
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(100);
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
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
		return column;
	}
	/**
	 * 获取是否允许独立选择表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_idp_selCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_idp_sel");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许独立选择"); 
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
	 * 获取键盘外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_kbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_kb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("键盘外键"); 
		return column;
	}
	/**
	 * 获取精度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrecisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Precision");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("精度"); 
		return column;
	}
	/**
	 * 获取是否允许为空表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nullCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_null");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许为空"); 
		return column;
	}
	/**
	 * 获取体征项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mrtpl_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mrtpl_vs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征项编码"); 
		return column;
	}
	/**
	 * 获取体征项名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrtpl_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrtpl_vs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征项名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvvtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srvvt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvvtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srvvt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目"); 
		return column;
	}
	/**
	 * 获取数据类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dedatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dedatp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据类型名称"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
		return column;
	}
	/**
	 * 获取计量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位编码"); 
		return column;
	}
	/**
	 * 获取数据来源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dataoriginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dataorigin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源名称"); 
		return column;
	}
	/**
	 * 获取数据来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dataoriginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dataorigin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源编码"); 
		return column;
	}
	/**
	 * 获取默认值编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_default");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值编码"); 
		return column;
	}
	/**
	 * 获取关联项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_vsrelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_vsrel");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联项目名称"); 
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
