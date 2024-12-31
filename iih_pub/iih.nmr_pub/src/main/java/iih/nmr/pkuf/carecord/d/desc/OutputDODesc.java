
package iih.nmr.pkuf.carecord.d.desc;

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
 * 排出量 DO 元数据信息
 */
public class OutputDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.carecord.d.OutputDO";
	public static final String CLASS_DISPALYNAME = "排出量";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_OUTPUT";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_output";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OutputDODesc(){
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
		this.setKeyDesc(getId_outputADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_carecordADesc(tblDesc));
		this.add(getId_outputADesc(tblDesc));
		this.add(getId_carecordADesc(tblDesc));
		this.add(getId_discharg_nameADesc(tblDesc));
		this.add(getName_discharg_nameADesc(tblDesc));
		this.add(getSd_discharg_nameADesc(tblDesc));
		this.add(getDischarg_areaADesc(tblDesc));
		this.add(getDischarg_amountADesc(tblDesc));
		this.add(getId_discharg_unitADesc(tblDesc));
		this.add(getSd_discharg_unitADesc(tblDesc));
		this.add(getId_colorADesc(tblDesc));
		this.add(getName_colorADesc(tblDesc));
		this.add(getSd_colorADesc(tblDesc));
		this.add(getId_characterADesc(tblDesc));
		this.add(getName_characterADesc(tblDesc));
		this.add(getSd_characterADesc(tblDesc));
		this.add(getConditionADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_discharg_unitADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_outputCDesc(tblDesc));
		tblDesc.add(getId_outputCDesc(tblDesc));
		tblDesc.add(getId_carecordCDesc(tblDesc));
		tblDesc.add(getId_discharg_nameCDesc(tblDesc));
		tblDesc.add(getName_discharg_nameCDesc(tblDesc));
		tblDesc.add(getSd_discharg_nameCDesc(tblDesc));
		tblDesc.add(getDischarg_areaCDesc(tblDesc));
		tblDesc.add(getDischarg_amountCDesc(tblDesc));
		tblDesc.add(getId_discharg_unitCDesc(tblDesc));
		tblDesc.add(getSd_discharg_unitCDesc(tblDesc));
		tblDesc.add(getId_colorCDesc(tblDesc));
		tblDesc.add(getName_colorCDesc(tblDesc));
		tblDesc.add(getSd_colorCDesc(tblDesc));
		tblDesc.add(getId_characterCDesc(tblDesc));
		tblDesc.add(getName_characterCDesc(tblDesc));
		tblDesc.add(getSd_characterCDesc(tblDesc));
		tblDesc.add(getConditionCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 排出量主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_output",  getId_outputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出量主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理记录单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_carecordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_carecord",  getId_carecordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理记录单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排出名称id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_discharg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_discharg_name",  getId_discharg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出名称id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排出名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_discharg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_discharg_name",  getName_discharg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排出名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_discharg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_discharg_name",  getSd_discharg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排出部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDischarg_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Discharg_area",  getDischarg_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排出量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDischarg_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Discharg_amount",  getDischarg_amountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排出单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_discharg_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_discharg_unit",  getId_discharg_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排出单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_discharg_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_discharg_unit",  getSd_discharg_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排出单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 颜色id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_color",  getId_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("颜色id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 颜色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_color",  getName_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("颜色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 颜色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_color",  getSd_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("颜色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性状id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_characterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_character",  getId_characterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性状id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_characterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_character",  getName_characterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性状编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_characterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_character",  getSd_characterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性状编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Condition",  getConditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状况");
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
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_discharg_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_discharg_unit",  getName_discharg_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_discharg_unit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取排出量主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_output");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排出量主键"); 
		return column;
	}
	/**
	 * 获取护理记录单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_carecordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_carecord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理记录单主键"); 
		return column;
	}
	/**
	 * 获取排出名称id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_discharg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_discharg_name");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出名称id"); 
		return column;
	}
	/**
	 * 获取排出名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_discharg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_discharg_name");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出名称"); 
		return column;
	}
	/**
	 * 获取排出名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_discharg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_discharg_name");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出名称编码"); 
		return column;
	}
	/**
	 * 获取排出部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDischarg_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Discharg_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出部位"); 
		return column;
	}
	/**
	 * 获取排出量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDischarg_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Discharg_amount");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出量"); 
		return column;
	}
	/**
	 * 获取排出单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_discharg_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_discharg_unit");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出单位"); 
		return column;
	}
	/**
	 * 获取排出单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_discharg_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_discharg_unit");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排出单位编码"); 
		return column;
	}
	/**
	 * 获取颜色id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_color");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("颜色id"); 
		return column;
	}
	/**
	 * 获取颜色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_color");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("颜色"); 
		return column;
	}
	/**
	 * 获取颜色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_color");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("颜色编码"); 
		return column;
	}
	/**
	 * 获取性状id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_characterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_character");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性状id"); 
		return column;
	}
	/**
	 * 获取性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_characterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_character");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性状"); 
		return column;
	}
	/**
	 * 获取性状编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_characterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_character");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性状编码"); 
		return column;
	}
	/**
	 * 获取状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状况"); 
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
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_discharg_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_discharg_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
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
