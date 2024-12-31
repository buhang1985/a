
package iih.bd.srv.medusage.d.desc;

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
 * 用法要求 DO 元数据信息
 */
public class MedUsageDesDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medusage.d.MedUsageDesDO";
	public static final String CLASS_DISPALYNAME = "用法要求";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_route_des";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_routedes";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MedUsageDesDODesc(){
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
		this.setKeyDesc(getId_routedesADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_routedesADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getFg_entp_opADesc(tblDesc));
		this.add(getFg_entp_ipADesc(tblDesc));
		this.add(getFg_entp_erADesc(tblDesc));
		this.add(getFg_use_er1ADesc(tblDesc));
		this.add(getFg_use_er2ADesc(tblDesc));
		this.add(getFg_entp_peADesc(tblDesc));
		this.add(getFg_entp_fmADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getFg_entp_opCDesc(tblDesc));
		tblDesc.add(getFg_entp_ipCDesc(tblDesc));
		tblDesc.add(getFg_entp_erCDesc(tblDesc));
		tblDesc.add(getFg_use_er1CDesc(tblDesc));
		tblDesc.add(getFg_use_er2CDesc(tblDesc));
		tblDesc.add(getFg_entp_peCDesc(tblDesc));
		tblDesc.add(getFg_entp_fmCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 用法要求主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求主键标识");
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
	 * 医疗要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnecode",  getMnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 *  可使用标志_门诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_op",  getFg_entp_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel(" 可使用标志_门诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 *  可使用标志_住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_ip",  getFg_entp_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel(" 可使用标志_住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊流水标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_er",  getFg_entp_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊流水标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊抢救标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_er1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er1",  getFg_use_er1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊抢救标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊留观标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_er2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er2",  getFg_use_er2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊留观标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 *  可使用标志_体检属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_pe",  getFg_entp_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel(" 可使用标志_体检");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_家庭属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_fm",  getFg_entp_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_家庭");
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
	 * 获取用法要求主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用法要求主键标识"); 
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
	 * 获取医疗要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗要求编码"); 
		return column;
	}
	/**
	 * 获取医疗要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗要求"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取 可使用标志_门诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel(" 可使用标志_门诊"); 
		return column;
	}
	/**
	 * 获取 可使用标志_住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_ip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel(" 可使用标志_住院"); 
		return column;
	}
	/**
	 * 获取急诊流水标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_er");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊流水标志"); 
		return column;
	}
	/**
	 * 获取急诊抢救标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_er1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er1");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊抢救标志"); 
		return column;
	}
	/**
	 * 获取急诊留观标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_er2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er2");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊留观标志"); 
		return column;
	}
	/**
	 * 获取 可使用标志_体检表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_pe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel(" 可使用标志_体检"); 
		return column;
	}
	/**
	 * 获取可使用标志_家庭表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_fm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_家庭"); 
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
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_routedes");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Mnecode");
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