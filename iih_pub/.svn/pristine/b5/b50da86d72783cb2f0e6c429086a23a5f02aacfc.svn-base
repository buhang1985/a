
package iih.bl.cg.blrecgip.d.desc;

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
 * 住院重划价 DO 元数据信息
 */
public class BlRecgIpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.cg.blrecgip.d.BlRecgIpDO";
	public static final String CLASS_DISPALYNAME = "住院重划价";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_recg_ip";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_recg_ip";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlRecgIpDODesc(){
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
		this.setKeyDesc(getId_recg_ipADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_recg_ipADesc(tblDesc));
		this.add(getDt_recgADesc(tblDesc));
		this.add(getId_pripat_fromADesc(tblDesc));
		this.add(getId_pripat_toADesc(tblDesc));
		this.add(getId_emp_recgADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getPripat_from_nameADesc(tblDesc));
		this.add(getPripat_from_codeADesc(tblDesc));
		this.add(getPripat_to_codeADesc(tblDesc));
		this.add(getPripat_to_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_recg_ipCDesc(tblDesc));
		tblDesc.add(getId_recg_ipCDesc(tblDesc));
		tblDesc.add(getDt_recgCDesc(tblDesc));
		tblDesc.add(getId_pripat_fromCDesc(tblDesc));
		tblDesc.add(getId_pripat_toCDesc(tblDesc));
		tblDesc.add(getId_emp_recgCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 重划价记录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_recg_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_recg_ip",  getId_recg_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重划价记录主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重划价日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_recg",  getDt_recgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("重划价日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原价格分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pripat_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pripat_from",  getId_pripat_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原价格分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 新价格分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pripat_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pripat_to",  getId_pripat_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新价格分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_recgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_recg",  getId_emp_recgCDesc(tblDesc), this);
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
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者价格分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPripat_from_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pripat_from_name",  getPripat_from_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pat a0b5","id_pripat_from=id_pripat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者价格分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPripat_from_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pripat_from_code",  getPripat_from_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pat a0b5","id_pripat_from=id_pripat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者价格分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPripat_to_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pripat_to_code",  getPripat_to_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pat a0b6","id_pripat_to=id_pripat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者价格分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPripat_to_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pripat_to_name",  getPripat_to_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pat a0b6","id_pripat_to=id_pripat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取重划价记录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_recg_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_recg_ip");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("重划价记录主键"); 
		return column;
	}
	/**
	 * 获取重划价日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_recg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("重划价日期"); 
		return column;
	}
	/**
	 * 获取原价格分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pripat_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pripat_from");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原价格分类"); 
		return column;
	}
	/**
	 * 获取新价格分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pripat_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pripat_to");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新价格分类"); 
		return column;
	}
	/**
	 * 获取操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_recgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_recg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作员"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取患者价格分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPripat_from_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pripat_from_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格分类名称"); 
		return column;
	}
	/**
	 * 获取患者价格分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPripat_from_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pripat_from_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格分类编码"); 
		return column;
	}
	/**
	 * 获取患者价格分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPripat_to_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pripat_to_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格分类编码"); 
		return column;
	}
	/**
	 * 获取患者价格分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPripat_to_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pripat_to_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格分类名称"); 
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
