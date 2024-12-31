
package iih.bd.srv.medsrv.d.desc;

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
 * 医疗服务卫材属性 DO 元数据信息
 */
public class MedSrvSaniDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medsrv.d.MedSrvSaniDO";
	public static final String CLASS_DISPALYNAME = "医疗服务卫材属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_sani";
	public static final String TABLE_ALIAS_NAME = "a6";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvsani";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MedSrvSaniDODesc(){
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
		this.setKeyDesc(getId_srvsaniADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_srvADesc(tblDesc));
		this.add(getId_srvsaniADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_sanitpADesc(tblDesc));
		this.add(getSd_sanitpADesc(tblDesc));
		this.add(getId_sanivaluetpADesc(tblDesc));
		this.add(getSd_sanivaluetpADesc(tblDesc));
		this.add(getIndicaADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getConstrADesc(tblDesc));
		this.add(getPrecautADesc(tblDesc));
		this.add(getApprnoADesc(tblDesc));
		this.add(getSup_nameADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getName_sanitpADesc(tblDesc));
		this.add(getName_valuetypeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvsaniCDesc(tblDesc));
		tblDesc.add(getId_srvsaniCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_sanitpCDesc(tblDesc));
		tblDesc.add(getSd_sanitpCDesc(tblDesc));
		tblDesc.add(getId_sanivaluetpCDesc(tblDesc));
		tblDesc.add(getSd_sanivaluetpCDesc(tblDesc));
		tblDesc.add(getIndicaCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getConstrCDesc(tblDesc));
		tblDesc.add(getPrecautCDesc(tblDesc));
		tblDesc.add(getApprnoCDesc(tblDesc));
		tblDesc.add(getSup_nameCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗服务卫材属性主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvsaniADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvsani",  getId_srvsaniCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务卫材属性主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 所属医疗服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属医疗服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 耗材分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sanitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sanitp",  getId_sanitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("耗材分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 耗材分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sanitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sanitp",  getSd_sanitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("耗材分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卫材价值分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sanivaluetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sanivaluetp",  getId_sanivaluetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卫材价值分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 卫材价值分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sanivaluetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sanivaluetp",  getSd_sanivaluetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卫材价值分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适应症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIndicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Indica",  getIndicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适应症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usage",  getUsageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 禁忌属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConstrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Constr",  getConstrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("禁忌");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrecautADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Precaut",  getPrecautCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前批准文号/注册号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApprnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apprno",  getApprnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前批准文号/注册号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_name",  getSup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a6b4","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 耗材分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sanitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sanitp",  getName_sanitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("耗材分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a6b5","id_sanitp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卫材价值分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_valuetypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_valuetype",  getName_valuetypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卫材价值分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a6b6","id_sanivaluetp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗服务卫材属性主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvsaniCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvsani");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗服务卫材属性主键标识"); 
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
	 * 获取所属医疗服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属医疗服务"); 
		return column;
	}
	/**
	 * 获取耗材分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sanitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sanitp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("耗材分类"); 
		return column;
	}
	/**
	 * 获取耗材分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sanitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sanitp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("耗材分类编码"); 
		return column;
	}
	/**
	 * 获取卫材价值分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sanivaluetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sanivaluetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卫材价值分类"); 
		return column;
	}
	/**
	 * 获取卫材价值分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sanivaluetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sanivaluetp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卫材价值分类编码"); 
		return column;
	}
	/**
	 * 获取适应症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIndicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Indica");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适应症"); 
		return column;
	}
	/**
	 * 获取使用用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usage");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用用法"); 
		return column;
	}
	/**
	 * 获取禁忌表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConstrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Constr");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("禁忌"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrecautCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Precaut");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取当前批准文号/注册号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApprnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apprno");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前批准文号/注册号"); 
		return column;
	}
	/**
	 * 获取生产厂家表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取耗材分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sanitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sanitp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("耗材分类"); 
		return column;
	}
	/**
	 * 获取卫材价值分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_valuetypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_valuetype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卫材价值分类"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_srvsani");
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
