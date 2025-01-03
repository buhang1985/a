
package iih.pe.por.pepsnpot.d.desc;

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
 * 体检潜在客户 DO 元数据信息
 */
public class PePsnPotDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.por.pepsnpot.d.PePsnPotDO";
	public static final String CLASS_DISPALYNAME = "体检潜在客户";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_or_pepsnpot";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pepsnpot";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PePsnPotDODesc(){
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
		this.setKeyDesc(getId_pepsnpotADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pepsnpotADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getSexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getMobADesc(tblDesc));
		this.add(getAddrADesc(tblDesc));
		this.add(getId_pemarketingADesc(tblDesc));
		this.add(getPsn_sourceADesc(tblDesc));
		this.add(getFg_memberADesc(tblDesc));
		this.add(getId_salesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getPottpADesc(tblDesc));
		this.add(getFg_highseasADesc(tblDesc));
		this.add(getName21ADesc(tblDesc));
		this.add(getCode_sexADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getCode_sourceADesc(tblDesc));
		this.add(getName_sourceADesc(tblDesc));
		this.add(getName_salesADesc(tblDesc));
		this.add(getCode_salesADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pepsnpotCDesc(tblDesc));
		tblDesc.add(getId_pepsnpotCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getSexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getMobCDesc(tblDesc));
		tblDesc.add(getAddrCDesc(tblDesc));
		tblDesc.add(getId_pemarketingCDesc(tblDesc));
		tblDesc.add(getPsn_sourceCDesc(tblDesc));
		tblDesc.add(getFg_memberCDesc(tblDesc));
		tblDesc.add(getId_salesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getPottpCDesc(tblDesc));
		tblDesc.add(getFg_highseasCDesc(tblDesc));
		tblDesc.add(getName21CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检潜在客户主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnpotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnpot",  getId_pepsnpotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检潜在客户主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检客户ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnbinfo",  getId_pepsnbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检客户ID");
		attrDesc.setNullable(true);
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex",  getSexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob",  getMobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr",  getAddrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来源市场活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pemarketingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pemarketing",  getId_pemarketingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来源市场活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_source",  getPsn_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际客户标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_memberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_member",  getFg_memberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("实际客户标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 销售员ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_salesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sales",  getId_salesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("销售员ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 体检客户类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPottpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pottp",  getPottpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检客户类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公海客户标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_highseasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_highseas",  getFg_highseasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("公海客户标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam21属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name21",  getName21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam21");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sex",  getCode_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_source",  getCode_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","psn_source=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_source",  getName_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","psn_source=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_salesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sales",  getName_salesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_sales=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_salesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sales",  getCode_salesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_sales=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检潜在客户主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnpotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnpot");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检潜在客户主键标识"); 
		return column;
	}
	/**
	 * 获取体检客户ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检客户ID"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电话"); 
		return column;
	}
	/**
	 * 获取地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址"); 
		return column;
	}
	/**
	 * 获取来源市场活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pemarketingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pemarketing");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来源市场活动"); 
		return column;
	}
	/**
	 * 获取来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPsn_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_source");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来源"); 
		return column;
	}
	/**
	 * 获取实际客户标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_memberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_member");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际客户标识"); 
		return column;
	}
	/**
	 * 获取销售员ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_salesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sales");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("销售员ID"); 
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
	 * 获取体检客户类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPottpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pottp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检客户类型"); 
		return column;
	}
	/**
	 * 获取公海客户标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_highseasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_highseas");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("公海客户标识"); 
		return column;
	}
	/**
	 * 获取displaynam21表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name21");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam21"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_source");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_source");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_salesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sales");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_salesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sales");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pepsnpot");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
