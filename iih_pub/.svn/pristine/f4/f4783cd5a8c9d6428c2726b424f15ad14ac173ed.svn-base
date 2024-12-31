
package iih.mp.nr.skinrcod.d.desc;

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
 * 皮试结果更新记录 DO 元数据信息
 */
public class SkinRcodDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.nr.skinrcod.d.SkinRcodDO";
	public static final String CLASS_DISPALYNAME = "皮试结果更新记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_skin_rcod";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_skin_rcod";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SkinRcodDODesc(){
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
		this.setKeyDesc(getId_skin_rcodADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_skin_rcodADesc(tblDesc));
		this.add(getId_skintestADesc(tblDesc));
		this.add(getEu_rcodADesc(tblDesc));
		this.add(getId_rst_skintest_orglADesc(tblDesc));
		this.add(getSd_rst_skintest_orglADesc(tblDesc));
		this.add(getId_emp_orglADesc(tblDesc));
		this.add(getDt_rst_orglADesc(tblDesc));
		this.add(getId_rst_skintest_newADesc(tblDesc));
		this.add(getSd_rst_skintest_newADesc(tblDesc));
		this.add(getId_emp_newADesc(tblDesc));
		this.add(getDt_rst_newADesc(tblDesc));
		this.add(getDt_operADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_rst_orglADesc(tblDesc));
		this.add(getName_emp_orglADesc(tblDesc));
		this.add(getName_rst_newADesc(tblDesc));
		this.add(getName_emp_newADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_skin_rcodCDesc(tblDesc));
		tblDesc.add(getId_skin_rcodCDesc(tblDesc));
		tblDesc.add(getId_skintestCDesc(tblDesc));
		tblDesc.add(getEu_rcodCDesc(tblDesc));
		tblDesc.add(getId_rst_skintest_orglCDesc(tblDesc));
		tblDesc.add(getSd_rst_skintest_orglCDesc(tblDesc));
		tblDesc.add(getId_emp_orglCDesc(tblDesc));
		tblDesc.add(getDt_rst_orglCDesc(tblDesc));
		tblDesc.add(getId_rst_skintest_newCDesc(tblDesc));
		tblDesc.add(getSd_rst_skintest_newCDesc(tblDesc));
		tblDesc.add(getId_emp_newCDesc(tblDesc));
		tblDesc.add(getDt_rst_newCDesc(tblDesc));
		tblDesc.add(getDt_operCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 皮试结果变更记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_rcodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_rcod",  getId_skin_rcodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试结果变更记录");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skintestADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skintest",  getId_skintestCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮试结果更新类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rcodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rcod",  getEu_rcodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮试结果更新类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rst_skintest_orglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rst_skintest_orgl",  getId_rst_skintest_orglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 原结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rst_skintest_orglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rst_skintest_orgl",  getSd_rst_skintest_orglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原结果更新人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_orglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_orgl",  getId_emp_orglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原结果更新人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 原结果更新时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rst_orglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rst_orgl",  getDt_rst_orglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("原结果更新时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rst_skintest_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rst_skintest_new",  getId_rst_skintest_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 新结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rst_skintest_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rst_skintest_new",  getSd_rst_skintest_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新结果更新人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_new",  getId_emp_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新结果更新人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 新结果更新时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rst_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rst_new",  getDt_rst_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("新结果更新时间");
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
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("操作时间");
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
	 * 原结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rst_orglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rst_orgl",  getName_rst_orglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_rst_skintest_orgl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原结果更新人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_orglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_orgl",  getName_emp_orglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原结果更新人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_orgl=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新皮试结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rst_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rst_new",  getName_rst_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新皮试结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_rst_skintest_new=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新结果更新人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_new",  getName_emp_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新结果更新人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_new=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取皮试结果变更记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_rcodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_rcod");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("皮试结果变更记录"); 
		return column;
	}
	/**
	 * 获取皮试结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skintestCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skintest");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试结果"); 
		return column;
	}
	/**
	 * 获取皮试结果更新类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rcodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rcod");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮试结果更新类型"); 
		return column;
	}
	/**
	 * 获取原结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rst_skintest_orglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rst_skintest_orgl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原结果ID"); 
		return column;
	}
	/**
	 * 获取原结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rst_skintest_orglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rst_skintest_orgl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原结果编码"); 
		return column;
	}
	/**
	 * 获取原结果更新人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_orglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_orgl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原结果更新人"); 
		return column;
	}
	/**
	 * 获取原结果更新时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rst_orglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rst_orgl");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("原结果更新时间"); 
		return column;
	}
	/**
	 * 获取新结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rst_skintest_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rst_skintest_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新结果ID"); 
		return column;
	}
	/**
	 * 获取新结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rst_skintest_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rst_skintest_new");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新结果编码"); 
		return column;
	}
	/**
	 * 获取新结果更新人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新结果更新人"); 
		return column;
	}
	/**
	 * 获取新结果更新时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rst_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rst_new");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("新结果更新时间"); 
		return column;
	}
	/**
	 * 获取操作时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("操作时间"); 
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
	 * 获取原结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rst_orglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rst_orgl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原结果名称"); 
		return column;
	}
	/**
	 * 获取原结果更新人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_orglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_orgl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原结果更新人姓名"); 
		return column;
	}
	/**
	 * 获取新皮试结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rst_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rst_new");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新皮试结果名称"); 
		return column;
	}
	/**
	 * 获取新结果更新人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_new");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新结果更新人"); 
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
