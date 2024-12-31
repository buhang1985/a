
package iih.pe.pps.perstslicemng.d.desc;

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
 * 体检重要结果分层管理名单 DO 元数据信息
 */
public class PeRstSliceMngPsnDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pps.perstslicemng.d.PeRstSliceMngPsnDO";
	public static final String CLASS_DISPALYNAME = "体检重要结果分层管理名单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_ps_rstslicemngpsn";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_rstslicemngpsn";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstSliceMngPsnDODesc(){
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
		this.setKeyDesc(getId_rstslicemngpsnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_rstslicemngADesc(tblDesc));
		this.add(getId_rstslicemngpsnADesc(tblDesc));
		this.add(getId_rstslicemngADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getPe_codeADesc(tblDesc));
		this.add(getDt_peADesc(tblDesc));
		this.add(getPestatusADesc(tblDesc));
		this.add(getCode_custADesc(tblDesc));
		this.add(getName_custADesc(tblDesc));
		this.add(getMob_custADesc(tblDesc));
		this.add(getAge_custADesc(tblDesc));
		this.add(getSd_sex_custADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_rstslicemngpsnCDesc(tblDesc));
		tblDesc.add(getId_rstslicemngpsnCDesc(tblDesc));
		tblDesc.add(getId_rstslicemngCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检重要结果分层管理名单主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rstslicemngpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rstslicemngpsn",  getId_rstslicemngpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检重要结果分层管理名单主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检重要结果分层管理ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rstslicemngADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rstslicemng",  getId_rstslicemngCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检重要结果分层管理ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检个人预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检个人预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_code",  getPe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检唯一码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a1b3","id_pepsnappt=id_pepsnappt","pe_code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pe",  getDt_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("体检时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a1b3","id_pepsnappt=id_pepsnappt","dt_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pestatus",  getPestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a1b3","id_pepsnappt=id_pepsnappt","pestatus"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cust",  getCode_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a1b4","id_pepsnbinfo=id_pepsnbinfo","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cust",  getName_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a1b4","id_pepsnbinfo=id_pepsnbinfo","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMob_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob_cust",  getMob_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a1b4","id_pepsnbinfo=id_pepsnbinfo","mob"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_cust",  getAge_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a1b4","id_pepsnbinfo=id_pepsnbinfo","age"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_cust",  getSd_sex_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a1b4","id_pepsnbinfo=id_pepsnbinfo","sd_sex"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检重要结果分层管理名单主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rstslicemngpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rstslicemngpsn");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检重要结果分层管理名单主键标识"); 
		return column;
	}
	/**
	 * 获取体检重要结果分层管理ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rstslicemngCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rstslicemng");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检重要结果分层管理ID"); 
		return column;
	}
	/**
	 * 获取体检个人预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检个人预约单ID"); 
		return column;
	}
	/**
	 * 获取体检客户ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检客户ID"); 
		return column;
	}
	/**
	 * 获取体检唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检唯一码"); 
		return column;
	}
	/**
	 * 获取体检时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pe");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检时间"); 
		return column;
	}
	/**
	 * 获取体检状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pestatus");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检状态"); 
		return column;
	}
	/**
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取移动电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMob_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动电话"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_cust");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_rstslicemngpsn");
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
