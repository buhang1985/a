
package iih.bd.mm.custcategoryitem.d.desc;

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
 * 医疗物品_自定义分类项目关系 DO 元数据信息
 */
public class CustCategoryItemRelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO";
	public static final String CLASS_DISPALYNAME = "医疗物品_自定义分类项目关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_MMCA_US_ITM_REL";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mmcausitmrel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CustCategoryItemRelDODesc(){
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
		this.setKeyDesc(getId_mmcausitmrelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mmcausitmADesc(tblDesc));
		this.add(getId_mmcausitmrelADesc(tblDesc));
		this.add(getId_mmcausitmADesc(tblDesc));
		this.add(getId_mmuscammADesc(tblDesc));
		this.add(getSd_mmuscammADesc(tblDesc));
		this.add(getId_mmorcaADesc(tblDesc));
		this.add(getName_mmorcaADesc(tblDesc));
		this.add(getId_factorADesc(tblDesc));
		this.add(getSd_factorADesc(tblDesc));
		this.add(getMmuscamm_nameADesc(tblDesc));
		this.add(getFactor_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mmcausitmrelCDesc(tblDesc));
		tblDesc.add(getId_mmcausitmrelCDesc(tblDesc));
		tblDesc.add(getId_mmcausitmCDesc(tblDesc));
		tblDesc.add(getId_mmuscammCDesc(tblDesc));
		tblDesc.add(getSd_mmuscammCDesc(tblDesc));
		tblDesc.add(getId_mmorcaCDesc(tblDesc));
		tblDesc.add(getName_mmorcaCDesc(tblDesc));
		tblDesc.add(getId_factorCDesc(tblDesc));
		tblDesc.add(getSd_factorCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 自定义分类项目对照主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmcausitmrelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmcausitmrel",  getId_mmcausitmrelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义分类项目对照主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自定义分类项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmcausitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmcausitm",  getId_mmcausitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义分类项目主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分类或物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmuscammADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmuscamm",  getId_mmuscammCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分类或物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分类或物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmuscammADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmuscamm",  getSd_mmuscammCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分类或物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品或基本分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmorcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmorca",  getId_mmorcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品或基本分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品或基本分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mmorcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mmorca",  getName_mmorcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品或基本分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自定义分类系数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_factor",  getId_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义分类系数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自定义分类系数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_factor",  getSd_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义分类系数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分类或物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmuscamm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmuscamm_name",  getMmuscamm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分类或物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b2","id_mmuscamm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 系数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_name",  getFactor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("系数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_factor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取自定义分类项目对照主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmcausitmrelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmcausitmrel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自定义分类项目对照主键"); 
		return column;
	}
	/**
	 * 获取自定义分类项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmcausitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmcausitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自定义分类项目主键"); 
		return column;
	}
	/**
	 * 获取分类或物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmuscammCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmuscamm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分类或物品"); 
		return column;
	}
	/**
	 * 获取分类或物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmuscammCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmuscamm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分类或物品编码"); 
		return column;
	}
	/**
	 * 获取物品或基本分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmorcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmorca");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("物品或基本分类ID"); 
		return column;
	}
	/**
	 * 获取物品或基本分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mmorcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mmorca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品或基本分类名称"); 
		return column;
	}
	/**
	 * 获取自定义分类系数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_factor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义分类系数"); 
		return column;
	}
	/**
	 * 获取自定义分类系数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_factor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义分类系数编码"); 
		return column;
	}
	/**
	 * 获取分类或物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmuscamm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmuscamm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分类或物品"); 
		return column;
	}
	/**
	 * 获取系数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("系数"); 
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
	}
	
}
