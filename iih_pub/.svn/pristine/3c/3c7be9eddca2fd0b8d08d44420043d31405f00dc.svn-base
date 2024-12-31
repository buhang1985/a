
package iih.en.er.op.d.desc;

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
 * 急诊就诊_门诊急诊 DO 元数据信息
 */
public class EnEntOpErDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.er.op.d.EnEntOpErDO";
	public static final String CLASS_DISPALYNAME = "急诊就诊_门诊急诊";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "EN_ENT_OP_ER";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_enoper";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnEntOpErDODesc(){
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
		this.setKeyDesc(getId_enoperADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_enoperADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_erpreADesc(tblDesc));
		this.add(getId_bedADesc(tblDesc));
		this.add(getId_ent_fstADesc(tblDesc));
		this.add(getId_scale_triageADesc(tblDesc));
		this.add(getSd_scale_triageADesc(tblDesc));
		this.add(getFg_nonpersonADesc(tblDesc));
		this.add(getId_level_nurADesc(tblDesc));
		this.add(getSd_level_nurADesc(tblDesc));
		this.add(getId_gowhere_erADesc(tblDesc));
		this.add(getSd_gowhere_erADesc(tblDesc));
		this.add(getFg_transADesc(tblDesc));
		this.add(getCode_bedADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_scale_triageADesc(tblDesc));
		this.add(getName_level_nurADesc(tblDesc));
		this.add(getName_gowhere_erADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_enoperCDesc(tblDesc));
		tblDesc.add(getId_enoperCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_erpreCDesc(tblDesc));
		tblDesc.add(getId_bedCDesc(tblDesc));
		tblDesc.add(getId_ent_fstCDesc(tblDesc));
		tblDesc.add(getId_scale_triageCDesc(tblDesc));
		tblDesc.add(getSd_scale_triageCDesc(tblDesc));
		tblDesc.add(getFg_nonpersonCDesc(tblDesc));
		tblDesc.add(getId_level_nurCDesc(tblDesc));
		tblDesc.add(getSd_level_nurCDesc(tblDesc));
		tblDesc.add(getId_gowhere_erCDesc(tblDesc));
		tblDesc.add(getSd_gowhere_erCDesc(tblDesc));
		tblDesc.add(getFg_transCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 门诊急诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enoperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enoper",  getId_enoperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊急诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erpreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erpre",  getId_erpreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bed",  getId_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 首次就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_fstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_fst",  getId_ent_fstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("首次就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检伤分级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scale_triageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scale_triage",  getId_scale_triageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤分级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检伤分级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_scale_triageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scale_triage",  getSd_scale_triageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤分级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 三无人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nonpersonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nonperson",  getFg_nonpersonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("三无人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_nur",  getId_level_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_nur",  getSd_level_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊转归id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gowhere_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_gowhere_er",  getId_gowhere_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊转归id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 急诊转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_gowhere_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_gowhere_er",  getSd_gowhere_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流水转抢救标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_trans",  getFg_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("流水转抢救标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_bed",  getCode_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_bed a0b2","id_bed=id_bed","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_bed a0b2","id_bed=id_bed","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scale_triageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scale_triage",  getName_scale_triageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分级名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_scale_triage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理等级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_level_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_level_nur",  getName_level_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理等级名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_level_nur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_gowhere_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_gowhere_er",  getName_gowhere_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_gowhere_er=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取门诊急诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enoperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enoper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊急诊id"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取预检id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erpreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erpre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检id"); 
		return column;
	}
	/**
	 * 获取床位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位id"); 
		return column;
	}
	/**
	 * 获取首次就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_fstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_fst");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("首次就诊id"); 
		return column;
	}
	/**
	 * 获取检伤分级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scale_triageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scale_triage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤分级id"); 
		return column;
	}
	/**
	 * 获取检伤分级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_scale_triageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scale_triage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤分级编码"); 
		return column;
	}
	/**
	 * 获取三无人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nonpersonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nonperson");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("三无人员"); 
		return column;
	}
	/**
	 * 获取护理等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理等级id"); 
		return column;
	}
	/**
	 * 获取护理等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理等级编码"); 
		return column;
	}
	/**
	 * 获取急诊转归id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gowhere_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_gowhere_er");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊转归id"); 
		return column;
	}
	/**
	 * 获取急诊转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_gowhere_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_gowhere_er");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊转归编码"); 
		return column;
	}
	/**
	 * 获取流水转抢救标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_trans");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("流水转抢救标志"); 
		return column;
	}
	/**
	 * 获取床位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_bed");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位编码"); 
		return column;
	}
	/**
	 * 获取床位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位名称"); 
		return column;
	}
	/**
	 * 获取分级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scale_triageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scale_triage");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分级名称"); 
		return column;
	}
	/**
	 * 获取护理等级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_level_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_level_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理等级名称"); 
		return column;
	}
	/**
	 * 获取急诊转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_gowhere_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_gowhere_er");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊转归"); 
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
		defaultValueMap.put("Fg_nonperson",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_trans",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
