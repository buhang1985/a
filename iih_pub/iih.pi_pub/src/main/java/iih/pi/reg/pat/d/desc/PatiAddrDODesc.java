
package iih.pi.reg.pat.d.desc;

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
 * 患者地址 DO 元数据信息
 */
public class PatiAddrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.reg.pat.d.PatiAddrDO";
	public static final String CLASS_DISPALYNAME = "患者地址";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_addr";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pataddr";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PatiAddrDODesc(){
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
		this.setKeyDesc(getId_pataddrADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_pataddrADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSd_addrtpADesc(tblDesc));
		this.add(getId_addrtpADesc(tblDesc));
		this.add(getSd_admdivADesc(tblDesc));
		this.add(getId_admdivADesc(tblDesc));
		this.add(getStreetADesc(tblDesc));
		this.add(getZipADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getAddrtp_codeADesc(tblDesc));
		this.add(getAddrtp_nameADesc(tblDesc));
		this.add(getAdmdiv_codeADesc(tblDesc));
		this.add(getAdmdiv_fullnameADesc(tblDesc));
		this.add(getAdmdiv_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pataddrCDesc(tblDesc));
		tblDesc.add(getId_pataddrCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSd_addrtpCDesc(tblDesc));
		tblDesc.add(getId_addrtpCDesc(tblDesc));
		tblDesc.add(getSd_admdivCDesc(tblDesc));
		tblDesc.add(getId_admdivCDesc(tblDesc));
		tblDesc.add(getStreetCDesc(tblDesc));
		tblDesc.add(getZipCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者地址主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pataddrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pataddr",  getId_pataddrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者地址主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 地址类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addrtp",  getSd_addrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地址类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地址类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addrtp",  getId_addrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地址类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 区县码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_admdivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_admdiv",  getSd_admdivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("区县码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 区县属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_admdivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_admdiv",  getId_admdivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("区县");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 乡镇街道地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStreetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Street",  getStreetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乡镇街道地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 邮政编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zip",  getZipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮政编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地址电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel",  getTelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地址电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddrtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addrtp_code",  getAddrtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b1","id_addrtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddrtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addrtp_name",  getAddrtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b1","id_addrtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdmdiv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Admdiv_code",  getAdmdiv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a1b2","id_admdiv=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划全称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdmdiv_fullnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Admdiv_fullname",  getAdmdiv_fullnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划全称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a1b2","id_admdiv=id_adminarea","fullname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdmdiv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Admdiv_name",  getAdmdiv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a1b2","id_admdiv=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者地址主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pataddrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pataddr");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者地址主键"); 
		return column;
	}
	/**
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取地址类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址类型编码"); 
		return column;
	}
	/**
	 * 获取地址类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addrtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址类型"); 
		return column;
	}
	/**
	 * 获取区县码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_admdivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_admdiv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("区县码"); 
		return column;
	}
	/**
	 * 获取区县表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_admdivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_admdiv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("区县"); 
		return column;
	}
	/**
	 * 获取乡镇街道地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStreetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Street");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乡镇街道地址"); 
		return column;
	}
	/**
	 * 获取邮政编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮政编码"); 
		return column;
	}
	/**
	 * 获取地址电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址电话"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddrtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addrtp_code");
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
	private IColumnDesc getAddrtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addrtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdmdiv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Admdiv_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划全称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdmdiv_fullnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Admdiv_fullname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划全称"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdmdiv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Admdiv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
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
