
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
 * 医疗服务会诊属性 DO 元数据信息
 */
public class MedSrvConsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medsrv.d.MedSrvConsDO";
	public static final String CLASS_DISPALYNAME = "医疗服务会诊属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_cons";
	public static final String TABLE_ALIAS_NAME = "a12";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvcons";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MedSrvConsDODesc(){
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
		this.setKeyDesc(getId_srvconsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_srvADesc(tblDesc));
		this.add(getId_srvconsADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_constpADesc(tblDesc));
		this.add(getSd_constpADesc(tblDesc));
		this.add(getFg_inorgADesc(tblDesc));
		this.add(getFg_depsADesc(tblDesc));
		this.add(getFg_emptitlelimitADesc(tblDesc));
		this.add(getId_emptitleADesc(tblDesc));
		this.add(getSd_emptitleADesc(tblDesc));
		this.add(getFg_audit_clidepADesc(tblDesc));
		this.add(getFg_audit_admdepADesc(tblDesc));
		this.add(getQuan_constimelimitADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getQuan_urg_constimelimitADesc(tblDesc));
		this.add(getId_unit_urgADesc(tblDesc));
		this.add(getName_constpADesc(tblDesc));
		this.add(getName_emptitleADesc(tblDesc));
		this.add(getName_unitADesc(tblDesc));
		this.add(getName_unit_urgADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvconsCDesc(tblDesc));
		tblDesc.add(getId_srvconsCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_constpCDesc(tblDesc));
		tblDesc.add(getSd_constpCDesc(tblDesc));
		tblDesc.add(getFg_inorgCDesc(tblDesc));
		tblDesc.add(getFg_depsCDesc(tblDesc));
		tblDesc.add(getFg_emptitlelimitCDesc(tblDesc));
		tblDesc.add(getId_emptitleCDesc(tblDesc));
		tblDesc.add(getSd_emptitleCDesc(tblDesc));
		tblDesc.add(getFg_audit_clidepCDesc(tblDesc));
		tblDesc.add(getFg_audit_admdepCDesc(tblDesc));
		tblDesc.add(getQuan_constimelimitCDesc(tblDesc));
		tblDesc.add(getId_unitCDesc(tblDesc));
		tblDesc.add(getQuan_urg_constimelimitCDesc(tblDesc));
		tblDesc.add(getId_unit_urgCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗服务会诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvcons",  getId_srvconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务会诊主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊类型（废弃不用了）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_constpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_constp",  getId_constpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊类型（废弃不用了）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊类型编码（废弃不用了）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_constpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_constp",  getSd_constpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊类型编码（废弃不用了）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否院内会诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_inorgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_inorg",  getFg_inorgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否院内会诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否多科室会诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_depsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_deps",  getFg_depsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否多科室会诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀医生是否职称限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_emptitlelimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_emptitlelimit",  getFg_emptitlelimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受邀医生是否职称限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀医生最低职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emptitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emptitle",  getId_emptitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀医生最低职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀医生最低职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle",  getSd_emptitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀医生最低职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需科室审批属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_audit_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_audit_clidep",  getFg_audit_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需科室审批");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需医务部审批属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_audit_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_audit_admdep",  getFg_audit_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需医务部审批");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊时效属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_constimelimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_constimelimit",  getQuan_constimelimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("会诊时效");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时效单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时效单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 加急时效属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_urg_constimelimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_urg_constimelimit",  getQuan_urg_constimelimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("加急时效");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加急时效单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_urgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_urg",  getId_unit_urgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加急时效单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_constpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_constp",  getName_constpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a12b2","id_constp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emptitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emptitle",  getName_emptitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a12b4","id_emptitle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit",  getName_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a12b5","id_unit=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_urgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_urg",  getName_unit_urgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a12b6","id_unit_urg=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗服务会诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvcons");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗服务会诊主键"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取会诊类型（废弃不用了）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_constpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_constp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊类型（废弃不用了）"); 
		return column;
	}
	/**
	 * 获取会诊类型编码（废弃不用了）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_constpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_constp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊类型编码（废弃不用了）"); 
		return column;
	}
	/**
	 * 获取是否院内会诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_inorgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_inorg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否院内会诊"); 
		return column;
	}
	/**
	 * 获取是否多科室会诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_depsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_deps");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否多科室会诊"); 
		return column;
	}
	/**
	 * 获取受邀医生是否职称限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_emptitlelimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_emptitlelimit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受邀医生是否职称限制"); 
		return column;
	}
	/**
	 * 获取受邀医生最低职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emptitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emptitle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀医生最低职称"); 
		return column;
	}
	/**
	 * 获取受邀医生最低职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀医生最低职称编码"); 
		return column;
	}
	/**
	 * 获取是否需科室审批表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_audit_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_audit_clidep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需科室审批"); 
		return column;
	}
	/**
	 * 获取是否需医务部审批表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_audit_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_audit_admdep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需医务部审批"); 
		return column;
	}
	/**
	 * 获取会诊时效表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_constimelimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_constimelimit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("会诊时效"); 
		return column;
	}
	/**
	 * 获取时效单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时效单位"); 
		return column;
	}
	/**
	 * 获取加急时效表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_urg_constimelimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_urg_constimelimit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("加急时效"); 
		return column;
	}
	/**
	 * 获取加急时效单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_urgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_urg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加急时效单位"); 
		return column;
	}
	/**
	 * 获取会诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_constpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_constp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊类型名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emptitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emptitle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_urgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_urg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
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
