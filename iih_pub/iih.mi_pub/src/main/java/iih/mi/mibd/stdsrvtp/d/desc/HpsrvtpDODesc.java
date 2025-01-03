
package iih.mi.mibd.stdsrvtp.d.desc;

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
 * 医保计划下医保目录等级对照 DO 元数据信息
 */
public class HpsrvtpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.mibd.stdsrvtp.d.HpsrvtpDO";
	public static final String CLASS_DISPALYNAME = "医保计划下医保目录等级对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_hpsrvtp_vs_stdhpsrvtp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hpsrvtpvsiih";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpsrvtpDODesc(){
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
		this.setKeyDesc(getId_hpsrvtpvsiihADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hpsrvtpvsiihADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getSd_hpsrvtpADesc(tblDesc));
		this.add(getSd_std_hpsrvtpADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getActivestateADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hpsrvtpvsiihCDesc(tblDesc));
		tblDesc.add(getId_hpsrvtpvsiihCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getSd_hpsrvtpCDesc(tblDesc));
		tblDesc.add(getSd_std_hpsrvtpCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保计划医保目录等级对照主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpsrvtpvsiihADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpsrvtpvsiih",  getId_hpsrvtpvsiihCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划医保目录等级对照主键");
		attrDesc.setNullable(false);
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
	 * 医保计划下的医保目录等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hpsrvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hpsrvtp",  getSd_hpsrvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划下的医保目录等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 通用报销等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_std_hpsrvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_std_hpsrvtp",  getSd_std_hpsrvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("通用报销等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a389c051-7eb3-4646-a4b4-88de8ec2ba19,ctrl1,扩展字段1,ctrl1,扩展字段1,java.lang.String,varchar,bd_udidoc,id_udidoc,@@@@ZZ2000000000003P","sd_hpsrvtp=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a389c051-7eb3-4646-a4b4-88de8ec2ba19,ctrl1,扩展字段1,ctrl1,扩展字段1,java.lang.String,varchar,bd_udidoc,id_udidoc,@@@@ZZ2000000000003P","sd_hpsrvtp=id_udidoc","mnecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a389c051-7eb3-4646-a4b4-88de8ec2ba19,ctrl1,扩展字段1,ctrl1,扩展字段1,java.lang.String,varchar,bd_udidoc,id_udidoc,@@@@ZZ2000000000003P","sd_hpsrvtp=id_udidoc","pycode"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a389c051-7eb3-4646-a4b4-88de8ec2ba19,ctrl1,扩展字段1,ctrl1,扩展字段1,java.lang.String,varchar,bd_udidoc,id_udidoc,@@@@ZZ2000000000003P","sd_hpsrvtp=id_udidoc","wbcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getActivestateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Activestate",  getActivestateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a389c051-7eb3-4646-a4b4-88de8ec2ba19,ctrl1,扩展字段1,ctrl1,扩展字段1,java.lang.String,varchar,bd_udidoc,id_udidoc,@@@@ZZ2000000000003P","sd_hpsrvtp=id_udidoc","activestate"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a389c051-7eb3-4646-a4b4-88de8ec2ba19,ctrl1,扩展字段1,ctrl1,扩展字段1,java.lang.String,varchar,bd_udidoc,id_udidoc,@@@@ZZ2000000000003P","sd_hpsrvtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保计划医保目录等级对照主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpsrvtpvsiihCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpsrvtpvsiih");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保计划医保目录等级对照主键"); 
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
	 * 获取医保计划下的医保目录等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hpsrvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hpsrvtp");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划下的医保目录等级"); 
		return column;
	}
	/**
	 * 获取通用报销等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_std_hpsrvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_std_hpsrvtp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("通用报销等级"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取启用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getActivestateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Activestate");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用状态"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
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
