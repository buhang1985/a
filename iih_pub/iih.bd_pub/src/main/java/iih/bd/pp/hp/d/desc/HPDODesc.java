
package iih.bd.pp.hp.d.desc;

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
 * 医保产品 DO 元数据信息
 */
public class HPDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.hp.d.HPDO";
	public static final String CLASS_DISPALYNAME = "医保产品";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_hp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HPDODesc(){
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
		this.setKeyDesc(getId_hpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hpADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_custADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getSd_hptpADesc(tblDesc));
		this.add(getId_hptpADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getEu_hpcalcpropADesc(tblDesc));
		this.add(getId_funcpropADesc(tblDesc));
		this.add(getEu_hpcalcrateADesc(tblDesc));
		this.add(getId_funcrateADesc(tblDesc));
		this.add(getEu_scopeADesc(tblDesc));
		this.add(getEu_srvorca_mdADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getEu_hpmmreltpADesc(tblDesc));
		this.add(getFg_cardstADesc(tblDesc));
		this.add(getFg_sabincADesc(tblDesc));
		this.add(getFg_sabinc_entADesc(tblDesc));
		this.add(getEu_sabincprnADesc(tblDesc));
		this.add(getFg_black_diADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_hpcgADesc(tblDesc));
		this.add(getFg_defaultADesc(tblDesc));
		this.add(getFg_reqhpcodeADesc(tblDesc));
		this.add(getFg_prepayADesc(tblDesc));
		this.add(getHp_hospital_codeADesc(tblDesc));
		this.add(getId_refhpADesc(tblDesc));
		this.add(getCust_codeADesc(tblDesc));
		this.add(getCust_nameADesc(tblDesc));
		this.add(getName_hptpADesc(tblDesc));
		this.add(getHp_codeADesc(tblDesc));
		this.add(getHp_nameADesc(tblDesc));
		this.add(getRefhp_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hpCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_custCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getSd_hptpCDesc(tblDesc));
		tblDesc.add(getId_hptpCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getEu_hpcalcpropCDesc(tblDesc));
		tblDesc.add(getId_funcpropCDesc(tblDesc));
		tblDesc.add(getEu_hpcalcrateCDesc(tblDesc));
		tblDesc.add(getId_funcrateCDesc(tblDesc));
		tblDesc.add(getEu_scopeCDesc(tblDesc));
		tblDesc.add(getEu_srvorca_mdCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getEu_hpmmreltpCDesc(tblDesc));
		tblDesc.add(getFg_cardstCDesc(tblDesc));
		tblDesc.add(getFg_sabincCDesc(tblDesc));
		tblDesc.add(getFg_sabinc_entCDesc(tblDesc));
		tblDesc.add(getEu_sabincprnCDesc(tblDesc));
		tblDesc.add(getFg_black_diCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_hpcgCDesc(tblDesc));
		tblDesc.add(getFg_defaultCDesc(tblDesc));
		tblDesc.add(getFg_reqhpcodeCDesc(tblDesc));
		tblDesc.add(getFg_prepayCDesc(tblDesc));
		tblDesc.add(getHp_hospital_codeCDesc(tblDesc));
		tblDesc.add(getId_refhpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保计划主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划主键");
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
	 * 付款机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cust",  getId_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hptp",  getSd_hptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptp",  getId_hptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复用医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("复用医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结算分摊接口模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hpcalcpropADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hpcalcprop",  getEu_hpcalcpropCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("结算分摊接口模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算分摊接口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_funcpropADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_funcprop",  getId_funcpropCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算分摊接口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账分摊接口模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hpcalcrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hpcalcrate",  getEu_hpcalcrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("记账分摊接口模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账分摊接口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_funcrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_funcrate",  getId_funcrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账分摊接口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊时可使用范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_scopeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_scope",  getEu_scopeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("就诊时可使用范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务或分类模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_srvorca_mdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_srvorca_md",  getEu_srvorca_mdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("服务或分类模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保物品对照类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hpmmreltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hpmmreltp",  getEu_hpmmreltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医保物品对照类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否持卡结算属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cardstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cardst",  getFg_cardstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否持卡结算");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 红冲发票标志(非门诊挂号发票)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sabincADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sabinc",  getFg_sabincCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("红冲发票标志(非门诊挂号发票)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 红冲发票标志(门诊挂号发票)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sabinc_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sabinc_ent",  getFg_sabinc_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("红冲发票标志(门诊挂号发票)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 红冲票打印方属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sabincprnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sabincprn",  getEu_sabincprnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("红冲票打印方");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断黑名单标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_black_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_black_di",  getFg_black_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("诊断黑名单标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
	 * 是否允许医保记账属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hpcgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hpcg",  getFg_hpcgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许医保记账");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缺省医保计划标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_default",  getFg_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("缺省医保计划标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保号码必填标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_reqhpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_reqhpcode",  getFg_reqhpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保号码必填标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可用预交金标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prepayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prepay",  getFg_prepayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可用预交金标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗机构编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_hospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_hospital_code",  getHp_hospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗机构编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引用目录对照属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_refhpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_refhp",  getId_refhpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引用目录对照");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCust_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cust_code",  getCust_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cust a0b4","id_cust=id_cust","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCust_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cust_name",  getCust_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cust a0b4","id_cust=id_cust","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hptp",  getName_hptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_hptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_code",  getHp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b6","id_par=id_hp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_name",  getHp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b6","id_par=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefhp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refhp_name",  getRefhp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b9","id_refhp=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保计划主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保计划主键"); 
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
	 * 获取付款机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cust");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款机构"); 
		return column;
	}
	/**
	 * 获取医保计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划编码"); 
		return column;
	}
	/**
	 * 获取医保计划类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划类型编码"); 
		return column;
	}
	/**
	 * 获取医保计划类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划类型"); 
		return column;
	}
	/**
	 * 获取医保计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划名称"); 
		return column;
	}
	/**
	 * 获取医保计划描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划描述"); 
		return column;
	}
	/**
	 * 获取复用医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("复用医保计划"); 
		return column;
	}
	/**
	 * 获取结算分摊接口模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hpcalcpropCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hpcalcprop");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("结算分摊接口模式"); 
		return column;
	}
	/**
	 * 获取结算分摊接口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_funcpropCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_funcprop");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算分摊接口"); 
		return column;
	}
	/**
	 * 获取记账分摊接口模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hpcalcrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hpcalcrate");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("记账分摊接口模式"); 
		return column;
	}
	/**
	 * 获取记账分摊接口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_funcrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_funcrate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账分摊接口"); 
		return column;
	}
	/**
	 * 获取就诊时可使用范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_scopeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_scope");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("就诊时可使用范围"); 
		return column;
	}
	/**
	 * 获取服务或分类模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_srvorca_mdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_srvorca_md");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("服务或分类模式"); 
		return column;
	}
	/**
	 * 获取启用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标识"); 
		return column;
	}
	/**
	 * 获取医保物品对照类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hpmmreltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hpmmreltp");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医保物品对照类型"); 
		return column;
	}
	/**
	 * 获取是否持卡结算表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cardstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cardst");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否持卡结算"); 
		return column;
	}
	/**
	 * 获取红冲发票标志(非门诊挂号发票)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sabincCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sabinc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("红冲发票标志(非门诊挂号发票)"); 
		return column;
	}
	/**
	 * 获取红冲发票标志(门诊挂号发票)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sabinc_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sabinc_ent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("红冲发票标志(门诊挂号发票)"); 
		return column;
	}
	/**
	 * 获取红冲票打印方表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sabincprnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sabincprn");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("红冲票打印方"); 
		return column;
	}
	/**
	 * 获取诊断黑名单标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_black_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_black_di");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊断黑名单标志"); 
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
	 * 获取是否允许医保记账表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hpcgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hpcg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许医保记账"); 
		return column;
	}
	/**
	 * 获取缺省医保计划标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_default");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("缺省医保计划标志"); 
		return column;
	}
	/**
	 * 获取医保号码必填标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_reqhpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_reqhpcode");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保号码必填标志"); 
		return column;
	}
	/**
	 * 获取可用预交金标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prepayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prepay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可用预交金标志"); 
		return column;
	}
	/**
	 * 获取医疗机构编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_hospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_hospital_code");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗机构编码"); 
		return column;
	}
	/**
	 * 获取引用目录对照表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_refhpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_refhp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引用目录对照"); 
		return column;
	}
	/**
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCust_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cust_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
		return column;
	}
	/**
	 * 获取客户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCust_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cust_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户名称"); 
		return column;
	}
	/**
	 * 获取医保计划类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hptp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划类型名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_code");
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
	private IColumnDesc getHp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取医保计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefhp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refhp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_hp");
		iBDDataInfoFldMap.put("pid","Id_par");
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
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
		iAuditInfoFldMap.put("createdtime","Createdtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
