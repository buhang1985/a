
package iih.mi.mc.mimctacticsrule.d.desc;

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
 * 医保规则 DO 元数据信息
 */
public class MiMcTacticsRuleDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.mc.mimctacticsrule.d.MiMcTacticsRuleDO";
	public static final String CLASS_DISPALYNAME = "医保规则";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_mc_tactics_rule";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hptacticsrule";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiMcTacticsRuleDODesc(){
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
		this.setKeyDesc(getId_hptacticsruleADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hptacticsruleADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getId_hptacticsADesc(tblDesc));
		this.add(getEu_ctrltpADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getId_emp_ruleADesc(tblDesc));
		this.add(getDt_ruleADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getFg_user_opADesc(tblDesc));
		this.add(getFg_user_erADesc(tblDesc));
		this.add(getFg_user_er1ADesc(tblDesc));
		this.add(getFg_user_er2ADesc(tblDesc));
		this.add(getFg_entp_ipADesc(tblDesc));
		this.add(getFg_entp_fmADesc(tblDesc));
		this.add(getFg_entp_peADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_use_pipADesc(tblDesc));
		this.add(getHp_codeADesc(tblDesc));
		this.add(getHp_nameADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getEmp_rule_codeADesc(tblDesc));
		this.add(getEmp_rule_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hptacticsruleCDesc(tblDesc));
		tblDesc.add(getId_hptacticsruleCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getId_hptacticsCDesc(tblDesc));
		tblDesc.add(getEu_ctrltpCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getId_emp_ruleCDesc(tblDesc));
		tblDesc.add(getDt_ruleCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getFg_user_opCDesc(tblDesc));
		tblDesc.add(getFg_user_erCDesc(tblDesc));
		tblDesc.add(getFg_user_er1CDesc(tblDesc));
		tblDesc.add(getFg_user_er2CDesc(tblDesc));
		tblDesc.add(getFg_entp_ipCDesc(tblDesc));
		tblDesc.add(getFg_entp_fmCDesc(tblDesc));
		tblDesc.add(getFg_entp_peCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_use_pipCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保规则主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptacticsruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptacticsrule",  getId_hptacticsruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保规则主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保策略库主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptacticsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptactics",  getId_hptacticsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保策略库主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 控制类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ctrltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ctrltp",  getEu_ctrltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否生效属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否生效");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生效时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b",  getDt_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("生效时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失效时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("失效时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则维护人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_rule",  getId_emp_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则维护人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 规则维护时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rule",  getDt_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("规则维护时间");
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
	 * 可使用标志_门诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_user_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_user_op",  getFg_user_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_门诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_急诊流水属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_user_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_user_er",  getFg_user_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_急诊流水");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_急诊抢救属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_user_er1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_user_er1",  getFg_user_er1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_急诊抢救");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_急诊留观属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_user_er2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_user_er2",  getFg_user_er2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_急诊留观");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_ip",  getFg_entp_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_家庭病床属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_fm",  getFg_entp_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_家庭病床");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标志_体检属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_pe",  getFg_entp_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标志_体检");
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
	 * 可使用标识_预住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_pip",  getFg_use_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标识_预住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_code",  getHp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b2","id_hp=id_hp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_name",  getHp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b2","id_hp=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 策略名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("策略名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mi_mc_tactics a0b8","id_hptactics=id_hptactics","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 策略编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("策略编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mi_mc_tactics a0b8","id_hptactics=id_hptactics","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_rule_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_rule_code",  getEmp_rule_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_rule=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_rule_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_rule_name",  getEmp_rule_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_rule=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保规则主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptacticsruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptacticsrule");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保规则主键"); 
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
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取医保策略库主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptacticsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptactics");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保策略库主键"); 
		return column;
	}
	/**
	 * 获取控制类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ctrltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ctrltp");
		column.setLength(10);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制类型"); 
		return column;
	}
	/**
	 * 获取是否生效表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否生效"); 
		return column;
	}
	/**
	 * 获取生效时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生效时间"); 
		return column;
	}
	/**
	 * 获取失效时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("失效时间"); 
		return column;
	}
	/**
	 * 获取规则维护人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_rule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则维护人"); 
		return column;
	}
	/**
	 * 获取规则维护时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rule");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("规则维护时间"); 
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
	 * 获取可使用标志_门诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_user_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_user_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_门诊"); 
		return column;
	}
	/**
	 * 获取可使用标志_急诊流水表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_user_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_user_er");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_急诊流水"); 
		return column;
	}
	/**
	 * 获取可使用标志_急诊抢救表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_user_er1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_user_er1");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_急诊抢救"); 
		return column;
	}
	/**
	 * 获取可使用标志_急诊留观表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_user_er2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_user_er2");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_急诊留观"); 
		return column;
	}
	/**
	 * 获取可使用标志_住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_ip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_住院"); 
		return column;
	}
	/**
	 * 获取可使用标志_家庭病床表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_fm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_家庭病床"); 
		return column;
	}
	/**
	 * 获取可使用标志_体检表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_pe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标志_体检"); 
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
	 * 获取可使用标识_预住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_pip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标识_预住院"); 
		return column;
	}
	/**
	 * 获取医保计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划编码"); 
		return column;
	}
	/**
	 * 获取医保计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划名称"); 
		return column;
	}
	/**
	 * 获取策略名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("策略名称"); 
		return column;
	}
	/**
	 * 获取策略编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("策略编码"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_rule_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_rule_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_rule_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_rule_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_hptacticsrule");
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
		defaultValueMap.put("Fg_use_pip",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
