
package iih.en.er.pre.d.desc;

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
 * 急诊预检_患者信息 DO 元数据信息
 */
public class EnErPrePatDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.er.pre.d.EnErPrePatDO";
	public static final String CLASS_DISPALYNAME = "急诊预检_患者信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "EN_ERPRE_PAT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_erprepat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnErPrePatDODesc(){
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
		this.setKeyDesc(getId_erprepatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_erprepatADesc(tblDesc));
		this.add(getId_erpreADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getTelnoADesc(tblDesc));
		this.add(getId_admdiv_addrADesc(tblDesc));
		this.add(getSd_admdiv_addrADesc(tblDesc));
		this.add(getName_contADesc(tblDesc));
		this.add(getId_patcontADesc(tblDesc));
		this.add(getId_conttpADesc(tblDesc));
		this.add(getSd_conttpADesc(tblDesc));
		this.add(getTelno_contADesc(tblDesc));
		this.add(getAddr_contADesc(tblDesc));
		this.add(getAddrADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_admdiv_addrADesc(tblDesc));
		this.add(getFullname_admdiv_addrADesc(tblDesc));
		this.add(getName_conttpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_erprepatCDesc(tblDesc));
		tblDesc.add(getId_erprepatCDesc(tblDesc));
		tblDesc.add(getId_erpreCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getTelnoCDesc(tblDesc));
		tblDesc.add(getId_admdiv_addrCDesc(tblDesc));
		tblDesc.add(getSd_admdiv_addrCDesc(tblDesc));
		tblDesc.add(getName_contCDesc(tblDesc));
		tblDesc.add(getId_patcontCDesc(tblDesc));
		tblDesc.add(getId_conttpCDesc(tblDesc));
		tblDesc.add(getSd_conttpCDesc(tblDesc));
		tblDesc.add(getTelno_contCDesc(tblDesc));
		tblDesc.add(getAddr_contCDesc(tblDesc));
		tblDesc.add(getAddrCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 预检患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erprepatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erprepat",  getId_erprepatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检患者id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erpreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erpre",  getId_erpreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 性别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Telno",  getTelnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 区县地址id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_admdiv_addrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_admdiv_addr",  getId_admdiv_addrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("区县地址id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 区县地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_admdiv_addrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_admdiv_addr",  getSd_admdiv_addrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("区县地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cont",  getName_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者联系人id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcont",  getId_patcontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者联系人id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联系人类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_conttp",  getId_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联系人类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_conttp",  getSd_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelno_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Telno_cont",  getTelno_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_cont",  getAddr_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人地址");
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
	 * 性别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_admdiv_addrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_admdiv_addr",  getName_admdiv_addrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b3","id_admdiv_addr=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划全称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFullname_admdiv_addrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fullname_admdiv_addr",  getFullname_admdiv_addrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划全称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b3","id_admdiv_addr=id_adminarea","fullname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_conttp",  getName_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_conttp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取预检患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erprepatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erprepat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检患者id"); 
		return column;
	}
	/**
	 * 获取预检id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erpreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erpre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检id"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取性别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别id"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Telno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取区县地址id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_admdiv_addrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_admdiv_addr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("区县地址id"); 
		return column;
	}
	/**
	 * 获取区县地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_admdiv_addrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_admdiv_addr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("区县地址编码"); 
		return column;
	}
	/**
	 * 获取联系人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cont");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人姓名"); 
		return column;
	}
	/**
	 * 获取患者联系人id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者联系人id"); 
		return column;
	}
	/**
	 * 获取联系人类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_conttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人类型id"); 
		return column;
	}
	/**
	 * 获取联系人类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_conttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人类型编码"); 
		return column;
	}
	/**
	 * 获取联系人电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelno_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Telno_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人电话"); 
		return column;
	}
	/**
	 * 获取联系人地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_cont");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人地址"); 
		return column;
	}
	/**
	 * 获取地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址"); 
		return column;
	}
	/**
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_admdiv_addrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_admdiv_addr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划全称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFullname_admdiv_addrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fullname_admdiv_addr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划全称"); 
		return column;
	}
	/**
	 * 获取联系人类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_conttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人类型名称"); 
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
