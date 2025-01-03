
package iih.pe.pitm.pesrvitem.d.desc;

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
 * 体检结果与诊断关联 DO 元数据信息
 */
public class PeSrvitmDiagDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pesrvitem.d.PeSrvitmDiagDO";
	public static final String CLASS_DISPALYNAME = "体检结果与诊断关联";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_peitmdiag";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesrvitmdiag";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSrvitmDiagDODesc(){
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
		this.setKeyDesc(getId_pesrvitmdiagADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pesrvitemADesc(tblDesc));
		this.add(getId_pesrvitmdiagADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getId_perstditpADesc(tblDesc));
		this.add(getSd_itemADesc(tblDesc));
		this.add(getSd_classADesc(tblDesc));
		this.add(getCode_ditpADesc(tblDesc));
		this.add(getName_ditpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pesrvitmdiagCDesc(tblDesc));
		tblDesc.add(getId_pesrvitmdiagCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getId_perstditpCDesc(tblDesc));
		tblDesc.add(getSd_itemCDesc(tblDesc));
		tblDesc.add(getSd_classCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检结果关联诊断主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitmdiagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitmdiag",  getId_pesrvitmdiagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果关联诊断主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem",  getId_pesrvitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检诊断目录ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstditpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstditp",  getId_perstditpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊断目录ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_item",  getSd_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_class",  getSd_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断目录编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_ditpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ditp",  getCode_ditpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断目录编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstditp a1b2","id_perstditp=id_perstditp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断目录名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ditpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ditp",  getName_ditpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断目录名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstditp a1b2","id_perstditp=id_perstditp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检结果关联诊断主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitmdiagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitmdiag");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检结果关联诊断主键标识"); 
		return column;
	}
	/**
	 * 获取体检结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果ID"); 
		return column;
	}
	/**
	 * 获取体检诊断目录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstditpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstditp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊断目录ID"); 
		return column;
	}
	/**
	 * 获取结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_item");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果编码"); 
		return column;
	}
	/**
	 * 获取结果分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_class");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果分类"); 
		return column;
	}
	/**
	 * 获取诊断目录编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_ditpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ditp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断目录编码"); 
		return column;
	}
	/**
	 * 获取诊断目录名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ditpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ditp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断目录名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pesrvitmdiag");
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
