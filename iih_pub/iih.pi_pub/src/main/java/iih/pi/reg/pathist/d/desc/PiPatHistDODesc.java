
package iih.pi.reg.pathist.d.desc;

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
 * 患者关键信息变动记录 DO 元数据信息
 */
public class PiPatHistDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.reg.pathist.d.PiPatHistDO";
	public static final String CLASS_DISPALYNAME = "患者关键信息变动记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_hist";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pathist";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatHistDODesc(){
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
		this.setKeyDesc(getId_pathistADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pathistADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getDt_modifyADesc(tblDesc));
		this.add(getEmp_modifyADesc(tblDesc));
		this.add(getDes_modifyADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pathistCDesc(tblDesc));
		tblDesc.add(getId_pathistCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getDt_modifyCDesc(tblDesc));
		tblDesc.add(getEmp_modifyCDesc(tblDesc));
		tblDesc.add(getDes_modifyCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者关键信息修改ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pathistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pathist",  getId_pathistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者关键信息修改ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_modifyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_modify",  getDt_modifyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_modifyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_modify",  getEmp_modifyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 修改内容描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_modifyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_modify",  getDes_modifyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修改内容描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构");
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
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_code",  getPat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b2","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b2","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","emp_modify=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者关键信息修改ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pathistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pathist");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者关键信息修改ID"); 
		return column;
	}
	/**
	 * 获取患者主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者主键"); 
		return column;
	}
	/**
	 * 获取修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_modifyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_modify");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("修改时间"); 
		return column;
	}
	/**
	 * 获取修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_modifyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_modify");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修改人"); 
		return column;
	}
	/**
	 * 获取修改内容描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_modifyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_modify");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修改内容描述"); 
		return column;
	}
	/**
	 * 获取机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构"); 
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
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pathist");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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