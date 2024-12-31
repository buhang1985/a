
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
 * 患者联系人 DO 元数据信息
 */
public class PiPatContDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.reg.pat.d.PiPatContDO";
	public static final String CLASS_DISPALYNAME = "患者联系人";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_cont";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_patcont";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatContDODesc(){
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
		this.setKeyDesc(getId_patcontADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patcontADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_conttpADesc(tblDesc));
		this.add(getSd_conttpADesc(tblDesc));
		this.add(getId_fmroleADesc(tblDesc));
		this.add(getSd_fmroleADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getConttelADesc(tblDesc));
		this.add(getContaddrADesc(tblDesc));
		this.add(getZipADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_contADesc(tblDesc));
		this.add(getSd_contADesc(tblDesc));
		this.add(getContidADesc(tblDesc));
		this.add(getFg_guardianADesc(tblDesc));
		this.add(getConttp_codeADesc(tblDesc));
		this.add(getConttp_nameADesc(tblDesc));
		this.add(getName_fmroleADesc(tblDesc));
		this.add(getContnameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patcontCDesc(tblDesc));
		tblDesc.add(getId_patcontCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_conttpCDesc(tblDesc));
		tblDesc.add(getSd_conttpCDesc(tblDesc));
		tblDesc.add(getId_fmroleCDesc(tblDesc));
		tblDesc.add(getSd_fmroleCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getConttelCDesc(tblDesc));
		tblDesc.add(getContaddrCDesc(tblDesc));
		tblDesc.add(getZipCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_contCDesc(tblDesc));
		tblDesc.add(getSd_contCDesc(tblDesc));
		tblDesc.add(getContidCDesc(tblDesc));
		tblDesc.add(getFg_guardianCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者联系人主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcont",  getId_patcontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者联系人主键");
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
	 * 联系人类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_conttp",  getId_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人类型");
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
	 * 亲属身份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fmroleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fmrole",  getId_fmroleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("亲属身份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 亲属身份编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fmroleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fmrole",  getSd_fmroleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("亲属身份编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人名称");
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
	private IAttrDesc getConttelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conttel",  getConttelCDesc(tblDesc), this);
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
	private IAttrDesc getContaddrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contaddr",  getContaddrCDesc(tblDesc), this);
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
	 * 联系人证件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cont",  getId_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人证件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联系人证件类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cont",  getSd_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人证件类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人证件号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contid",  getContidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人证件号码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 监护人标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_guardianADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_guardian",  getFg_guardianCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("监护人标记");
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
	private IAttrDesc getConttp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conttp_code",  getConttp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b1","id_conttp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConttp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conttp_name",  getConttp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b1","id_conttp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 亲属身份名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fmroleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fmrole",  getName_fmroleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("亲属身份名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b2","id_fmrole=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contname",  getContnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b4","id_cont=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者联系人主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcont");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者联系人主键"); 
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
	 * 获取联系人类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_conttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人类型"); 
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
	 * 获取亲属身份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fmroleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fmrole");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("亲属身份"); 
		return column;
	}
	/**
	 * 获取亲属身份编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fmroleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fmrole");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("亲属身份编码"); 
		return column;
	}
	/**
	 * 获取联系人名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人名称"); 
		return column;
	}
	/**
	 * 获取联系人电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConttelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conttel");
		column.setLength(20);
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
	private IColumnDesc getContaddrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contaddr");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人地址"); 
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
	 * 获取联系人证件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人证件类型"); 
		return column;
	}
	/**
	 * 获取联系人证件类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人证件类型编码"); 
		return column;
	}
	/**
	 * 获取联系人证件号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人证件号码"); 
		return column;
	}
	/**
	 * 获取监护人标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_guardianCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_guardian");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("监护人标记"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConttp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conttp_code");
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
	private IColumnDesc getConttp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conttp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取亲属身份名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fmroleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fmrole");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("亲属身份名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
