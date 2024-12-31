
package iih.hp.cp.eletpl.d.desc;

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
 * 诊疗计划元素模板 DO 元数据信息
 */
public class HpCpElemTplDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletpl.d.HpCpElemTplDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素模板";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELE_TPL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ele_tpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemTplDODesc(){
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
		this.setKeyDesc(getId_ele_tplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_ele_tplADesc(tblDesc));
		this.add(getId_cpADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getSerialnoADesc(tblDesc));
		this.add(getId_eletpADesc(tblDesc));
		this.add(getFg_pkgADesc(tblDesc));
		this.add(getEu_pkgitmseltpADesc(tblDesc));
		this.add(getEu_expand_dirADesc(tblDesc));
		this.add(getFg_needmappingADesc(tblDesc));
		this.add(getFg_necessaryADesc(tblDesc));
		this.add(getPrealarmhoursADesc(tblDesc));
		this.add(getFg_delADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_ele_tplCDesc(tblDesc));
		tblDesc.add(getId_ele_tplCDesc(tblDesc));
		tblDesc.add(getId_cpCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getSerialnoCDesc(tblDesc));
		tblDesc.add(getId_eletpCDesc(tblDesc));
		tblDesc.add(getFg_pkgCDesc(tblDesc));
		tblDesc.add(getEu_pkgitmseltpCDesc(tblDesc));
		tblDesc.add(getEu_expand_dirCDesc(tblDesc));
		tblDesc.add(getFg_needmappingCDesc(tblDesc));
		tblDesc.add(getFg_necessaryCDesc(tblDesc));
		tblDesc.add(getPrealarmhoursCDesc(tblDesc));
		tblDesc.add(getFg_delCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 诊疗计划元素模板ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_tpl",  getId_ele_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划元素模板ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cp",  getId_cpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 元素名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 父元素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父元素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前层次下序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerialnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serialno",  getSerialnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("当前层次下序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletp",  getId_eletpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pkg",  getFg_pkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("包标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包内项目选择类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pkgitmseltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pkgitmseltp",  getEu_pkgitmseltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("包内项目选择类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包展开方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_expand_dirADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_expand_dir",  getEu_expand_dirCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("包展开方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要对照属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needmappingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needmapping",  getFg_needmappingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要对照");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 必选标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_necessaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_necessary",  getFg_necessaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("必选标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提醒时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrealarmhoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prealarmhours",  getPrealarmhoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("提醒时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_delADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_del",  getFg_delCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("删除标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取诊疗计划元素模板ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_tpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划元素模板ID"); 
		return column;
	}
	/**
	 * 获取诊疗计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划ID"); 
		return column;
	}
	/**
	 * 获取元素名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素名称"); 
		return column;
	}
	/**
	 * 获取元素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素编码"); 
		return column;
	}
	/**
	 * 获取父元素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("父元素ID"); 
		return column;
	}
	/**
	 * 获取当前层次下序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerialnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serialno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("当前层次下序号"); 
		return column;
	}
	/**
	 * 获取元素类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型"); 
		return column;
	}
	/**
	 * 获取包标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pkg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("包标志"); 
		return column;
	}
	/**
	 * 获取包内项目选择类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pkgitmseltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pkgitmseltp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("包内项目选择类型"); 
		return column;
	}
	/**
	 * 获取包展开方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_expand_dirCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_expand_dir");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("包展开方向"); 
		return column;
	}
	/**
	 * 获取是否需要对照表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needmappingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needmapping");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要对照"); 
		return column;
	}
	/**
	 * 获取必选标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_necessaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_necessary");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("必选标志"); 
		return column;
	}
	/**
	 * 获取提醒时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrealarmhoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prealarmhours");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("提醒时间"); 
		return column;
	}
	/**
	 * 获取删除标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_delCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_del");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("删除标志"); 
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
	
}
