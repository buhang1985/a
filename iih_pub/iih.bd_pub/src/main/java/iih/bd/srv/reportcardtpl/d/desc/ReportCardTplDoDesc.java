
package iih.bd.srv.reportcardtpl.d.desc;

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
 * 报卡模板 DO 元数据信息
 */
public class ReportCardTplDoDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.reportcardtpl.d.ReportCardTplDo";
	public static final String CLASS_DISPALYNAME = "报卡模板";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_rcm_tpl";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_bd_rcm_tpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ReportCardTplDoDesc(){
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
		this.setKeyDesc(getId_bd_rcm_tplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_bd_rcm_tplADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_mredADesc(tblDesc));
		this.add(getMred_codeADesc(tblDesc));
		this.add(getMred_nameADesc(tblDesc));
		this.add(getMred_funceditorADesc(tblDesc));
		this.add(getMred_nameclassADesc(tblDesc));
		this.add(getMred_dllpathADesc(tblDesc));
		this.add(getFg_signADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getIshidenameADesc(tblDesc));
		this.add(getSd_signADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getSavemodelADesc(tblDesc));
		this.add(getSd_savemodelADesc(tblDesc));
		this.add(getName_savemodelADesc(tblDesc));
		this.add(getId_bd_rcm_tpADesc(tblDesc));
		this.add(getName_bd_rcm_tpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_defADesc(tblDesc));
		this.add(getSign_user_nameADesc(tblDesc));
		this.add(getSign_user_codeADesc(tblDesc));
		this.add(getSavemodel_codeADesc(tblDesc));
		this.add(getSavemodel_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_bd_rcm_tplCDesc(tblDesc));
		tblDesc.add(getId_bd_rcm_tplCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getId_mredCDesc(tblDesc));
		tblDesc.add(getMred_codeCDesc(tblDesc));
		tblDesc.add(getMred_nameCDesc(tblDesc));
		tblDesc.add(getMred_funceditorCDesc(tblDesc));
		tblDesc.add(getMred_nameclassCDesc(tblDesc));
		tblDesc.add(getMred_dllpathCDesc(tblDesc));
		tblDesc.add(getFg_signCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getIshidenameCDesc(tblDesc));
		tblDesc.add(getSd_signCDesc(tblDesc));
		tblDesc.add(getName_signCDesc(tblDesc));
		tblDesc.add(getSavemodelCDesc(tblDesc));
		tblDesc.add(getSd_savemodelCDesc(tblDesc));
		tblDesc.add(getName_savemodelCDesc(tblDesc));
		tblDesc.add(getId_bd_rcm_tpCDesc(tblDesc));
		tblDesc.add(getName_bd_rcm_tpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_defCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_rcm_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_rcm_tpl",  getId_bd_rcm_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
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
	 * 是否启用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否启用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mredADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mred",  getId_mredCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMred_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mred_code",  getMred_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMred_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mred_name",  getMred_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器启动函数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMred_funceditorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mred_funceditor",  getMred_funceditorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器启动函数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器反射生成类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMred_nameclassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mred_nameclass",  getMred_nameclassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器反射生成类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器反射生成dll名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMred_dllpathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mred_dllpath",  getMred_dllpathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器反射生成dll名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要审签属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sign",  getFg_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要审签");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签的用户属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签的用户");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否匿名上报属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIshidenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ishidename",  getIshidenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否匿名上报");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sign",  getSd_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 存贮模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSavemodelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Savemodel",  getSavemodelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("存贮模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 存贮模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_savemodelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_savemodel",  getSd_savemodelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("存贮模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 存贮模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_savemodelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_savemodel",  getName_savemodelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("存贮模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡类型主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_rcm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_rcm_tp",  getId_bd_rcm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡类型主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bd_rcm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bd_rcm_tp",  getName_bd_rcm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡类型名称");
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
	 * 默认模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_def",  getFg_defCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("默认模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_user_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_user_name",  getSign_user_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","id_sign=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_user_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_user_code",  getSign_user_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","id_sign=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSavemodel_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Savemodel_code",  getSavemodel_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","savemodel=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSavemodel_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Savemodel_name",  getSavemodel_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","savemodel=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_rcm_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_rcm_tpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(75);
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
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取是否启用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否启用"); 
		return column;
	}
	/**
	 * 获取编辑器主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mredCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mred");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器主键"); 
		return column;
	}
	/**
	 * 获取编辑器编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMred_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mred_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器编码"); 
		return column;
	}
	/**
	 * 获取编辑器名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMred_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mred_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器名称"); 
		return column;
	}
	/**
	 * 获取编辑器启动函数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMred_funceditorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mred_funceditor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器启动函数"); 
		return column;
	}
	/**
	 * 获取编辑器反射生成类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMred_nameclassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mred_nameclass");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器反射生成类"); 
		return column;
	}
	/**
	 * 获取编辑器反射生成dll名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMred_dllpathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mred_dllpath");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器反射生成dll名称"); 
		return column;
	}
	/**
	 * 获取是否需要审签表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sign");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要审签"); 
		return column;
	}
	/**
	 * 获取审签的用户表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签的用户"); 
		return column;
	}
	/**
	 * 获取是否匿名上报表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIshidenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ishidename");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否匿名上报"); 
		return column;
	}
	/**
	 * 获取审签用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sign");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签用户编码"); 
		return column;
	}
	/**
	 * 获取审签用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签用户名称"); 
		return column;
	}
	/**
	 * 获取存贮模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSavemodelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Savemodel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("存贮模式"); 
		return column;
	}
	/**
	 * 获取存贮模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_savemodelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_savemodel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("存贮模式编码"); 
		return column;
	}
	/**
	 * 获取存贮模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_savemodelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_savemodel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("存贮模式名称"); 
		return column;
	}
	/**
	 * 获取报卡类型主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_rcm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_rcm_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡类型主键"); 
		return column;
	}
	/**
	 * 获取报卡类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bd_rcm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bd_rcm_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡类型名称"); 
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
	 * 获取默认模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_def");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认模板"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_user_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_user_name");
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
	private IColumnDesc getSign_user_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_user_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSavemodel_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Savemodel_code");
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
	private IColumnDesc getSavemodel_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Savemodel_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
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
