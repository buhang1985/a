
package iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc;

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
 * 患者服务包项目 DO 元数据信息
 */
public class PiPatSrvPkgItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItmDO";
	public static final String CLASS_DISPALYNAME = "患者服务包项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_srv_pkg_itm";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_patsrvpkgitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatSrvPkgItmDODesc(){
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
		this.setKeyDesc(getId_patsrvpkgitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_patsrvpkgitmADesc(tblDesc));
		this.add(getId_patsrvpkgADesc(tblDesc));
		this.add(getId_patsrvpkggrADesc(tblDesc));
		this.add(getId_srvpkgitmADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_itmtpADesc(tblDesc));
		this.add(getSd_itmtpADesc(tblDesc));
		this.add(getId_optionalADesc(tblDesc));
		this.add(getSd_optionalADesc(tblDesc));
		this.add(getId_comptpADesc(tblDesc));
		this.add(getSd_comptpADesc(tblDesc));
		this.add(getId_reltpADesc(tblDesc));
		this.add(getSd_reltpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patsrvpkgitmCDesc(tblDesc));
		tblDesc.add(getId_patsrvpkgitmCDesc(tblDesc));
		tblDesc.add(getId_patsrvpkgCDesc(tblDesc));
		tblDesc.add(getId_patsrvpkggrCDesc(tblDesc));
		tblDesc.add(getId_srvpkgitmCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_itmtpCDesc(tblDesc));
		tblDesc.add(getSd_itmtpCDesc(tblDesc));
		tblDesc.add(getId_optionalCDesc(tblDesc));
		tblDesc.add(getSd_optionalCDesc(tblDesc));
		tblDesc.add(getId_comptpCDesc(tblDesc));
		tblDesc.add(getSd_comptpCDesc(tblDesc));
		tblDesc.add(getId_reltpCDesc(tblDesc));
		tblDesc.add(getSd_reltpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者服务包项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patsrvpkgitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patsrvpkgitm",  getId_patsrvpkgitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者服务包项目主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者服务包属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patsrvpkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patsrvpkg",  getId_patsrvpkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者服务包");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者服务包分组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patsrvpkggrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patsrvpkggr",  getId_patsrvpkggrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者服务包分组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务包项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvpkgitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvpkgitm",  getId_srvpkgitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_itmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_itmtp",  getId_itmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 项目类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_itmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_itmtp",  getSd_itmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可选性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_optionalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_optional",  getId_optionalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可选性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 可选性编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_optionalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_optional",  getSd_optionalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可选性编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照对象类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_comptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_comptp",  getId_comptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照对象类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对照对象类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_comptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_comptp",  getSd_comptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照对象类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目关系类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reltp",  getId_reltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目关系类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 项目关系类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reltp",  getSd_reltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目关系类型编码");
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
	 * 获取患者服务包项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patsrvpkgitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patsrvpkgitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者服务包项目主键"); 
		return column;
	}
	/**
	 * 获取患者服务包表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patsrvpkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patsrvpkg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者服务包"); 
		return column;
	}
	/**
	 * 获取患者服务包分组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patsrvpkggrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patsrvpkggr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者服务包分组"); 
		return column;
	}
	/**
	 * 获取服务包项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvpkgitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvpkgitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务包项目"); 
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
	 * 获取项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目名称"); 
		return column;
	}
	/**
	 * 获取项目类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_itmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_itmtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目类型"); 
		return column;
	}
	/**
	 * 获取项目类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_itmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_itmtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目类型编码"); 
		return column;
	}
	/**
	 * 获取可选性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_optionalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_optional");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可选性"); 
		return column;
	}
	/**
	 * 获取可选性编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_optionalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_optional");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可选性编码"); 
		return column;
	}
	/**
	 * 获取对照对象类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_comptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_comptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照对象类型"); 
		return column;
	}
	/**
	 * 获取对照对象类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_comptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_comptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照对象类型编码"); 
		return column;
	}
	/**
	 * 获取项目关系类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reltp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目关系类型"); 
		return column;
	}
	/**
	 * 获取项目关系类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reltp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目关系类型编码"); 
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
