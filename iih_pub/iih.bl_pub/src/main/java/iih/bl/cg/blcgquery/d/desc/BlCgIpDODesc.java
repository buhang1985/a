
package iih.bl.cg.blcgquery.d.desc;

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
 * 住院记账 DO 元数据信息
 */
public class BlCgIpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.cg.blcgquery.d.BlCgIpDO";
	public static final String CLASS_DISPALYNAME = "住院记账";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_cg_ip";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cgip";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlCgIpDODesc(){
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
		this.setKeyDesc(getId_cgipADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cgipADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_enttpADesc(tblDesc));
		this.add(getCode_enttpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_srvcaADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getSrvuADesc(tblDesc));
		this.add(getCode_inccaitmADesc(tblDesc));
		this.add(getName_inccaitmADesc(tblDesc));
		this.add(getCode_accountADesc(tblDesc));
		this.add(getName_accountADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getPrice_ratioADesc(tblDesc));
		this.add(getQuanADesc(tblDesc));
		this.add(getQuan_retADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getAmt_stdADesc(tblDesc));
		this.add(getDt_orADesc(tblDesc));
		this.add(getId_org_orADesc(tblDesc));
		this.add(getId_dep_orADesc(tblDesc));
		this.add(getId_emp_orADesc(tblDesc));
		this.add(getId_wg_orADesc(tblDesc));
		this.add(getId_dep_phyADesc(tblDesc));
		this.add(getId_emp_phyADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_org_mpADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getDt_srvADesc(tblDesc));
		this.add(getId_pripatADesc(tblDesc));
		this.add(getRatio_pripatADesc(tblDesc));
		this.add(getAmt_patADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getRatio_hpADesc(tblDesc));
		this.add(getAmt_hpADesc(tblDesc));
		this.add(getFg_mmADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_mmtpADesc(tblDesc));
		this.add(getSd_mmtpADesc(tblDesc));
		this.add(getCode_mmADesc(tblDesc));
		this.add(getOnlycodeADesc(tblDesc));
		this.add(getName_mmADesc(tblDesc));
		this.add(getCd_batchADesc(tblDesc));
		this.add(getSpecADesc(tblDesc));
		this.add(getPgku_baseADesc(tblDesc));
		this.add(getPgku_curADesc(tblDesc));
		this.add(getFactorADesc(tblDesc));
		this.add(getQuan_baseADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_orsrvADesc(tblDesc));
		this.add(getId_or_prADesc(tblDesc));
		this.add(getId_or_pr_srvADesc(tblDesc));
		this.add(getId_presADesc(tblDesc));
		this.add(getFg_pddiscADesc(tblDesc));
		this.add(getFg_stADesc(tblDesc));
		this.add(getId_stipADesc(tblDesc));
		this.add(getDt_stADesc(tblDesc));
		this.add(getFg_hpADesc(tblDesc));
		this.add(getFg_suspADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getCode_cgADesc(tblDesc));
		this.add(getId_org_cgADesc(tblDesc));
		this.add(getId_dep_cgADesc(tblDesc));
		this.add(getId_emp_cgADesc(tblDesc));
		this.add(getDt_cgADesc(tblDesc));
		this.add(getDt_oper_cgADesc(tblDesc));
		this.add(getEu_srctpADesc(tblDesc));
		this.add(getId_ent_momADesc(tblDesc));
		this.add(getFg_bbADesc(tblDesc));
		this.add(getNo_bbADesc(tblDesc));
		this.add(getFg_refundADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getFg_additmADesc(tblDesc));
		this.add(getApprnoADesc(tblDesc));
		this.add(getAmt_ratioADesc(tblDesc));
		this.add(getFg_recgADesc(tblDesc));
		this.add(getId_recg_ipADesc(tblDesc));
		this.add(getId_dep_whADesc(tblDesc));
		this.add(getSrcfunc_desADesc(tblDesc));
		this.add(getFg_freeADesc(tblDesc));
		this.add(getCode_applyADesc(tblDesc));
		this.add(getFg_selfpayADesc(tblDesc));
		this.add(getFg_researchADesc(tblDesc));
		this.add(getId_researchprojectADesc(tblDesc));
		this.add(getId_entbedADesc(tblDesc));
		this.add(getId_entdcgADesc(tblDesc));
		this.add(getFg_pay_unitADesc(tblDesc));
		this.add(getFg_realADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getAmt_hp_freeADesc(tblDesc));
		this.add(getAmt_pat_freeADesc(tblDesc));
		this.add(getSd_std_hpsrvtpADesc(tblDesc));
		this.add(getBlcgpatcodeADesc(tblDesc));
		this.add(getBlcgpatnameADesc(tblDesc));
		this.add(getBlcgenttpnameADesc(tblDesc));
		this.add(getIdentcodeADesc(tblDesc));
		this.add(getSrvtpcodeADesc(tblDesc));
		this.add(getSrvtpnameADesc(tblDesc));
		this.add(getSrvcacodeADesc(tblDesc));
		this.add(getSrvcanameADesc(tblDesc));
		this.add(getSrvcodeADesc(tblDesc));
		this.add(getSrvnameADesc(tblDesc));
		this.add(getSrvu_codeADesc(tblDesc));
		this.add(getSrvu_nameADesc(tblDesc));
		this.add(getBlcgdepcodeADesc(tblDesc));
		this.add(getBlcgdepnameADesc(tblDesc));
		this.add(getDepmpcodeADesc(tblDesc));
		this.add(getDepmpnameADesc(tblDesc));
		this.add(getIdpripatcodeADesc(tblDesc));
		this.add(getIdpripatnameADesc(tblDesc));
		this.add(getIdmmcodeADesc(tblDesc));
		this.add(getIdmmnameADesc(tblDesc));
		this.add(getIdmmtpcodeADesc(tblDesc));
		this.add(getIdmmtpnameADesc(tblDesc));
		this.add(getCode_stADesc(tblDesc));
		this.add(getInccaitm_codeADesc(tblDesc));
		this.add(getInccaitm_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cgipCDesc(tblDesc));
		tblDesc.add(getId_cgipCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_enttpCDesc(tblDesc));
		tblDesc.add(getCode_enttpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_srvcaCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getCode_srvCDesc(tblDesc));
		tblDesc.add(getName_srvCDesc(tblDesc));
		tblDesc.add(getSrvuCDesc(tblDesc));
		tblDesc.add(getCode_inccaitmCDesc(tblDesc));
		tblDesc.add(getName_inccaitmCDesc(tblDesc));
		tblDesc.add(getCode_accountCDesc(tblDesc));
		tblDesc.add(getName_accountCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getPrice_ratioCDesc(tblDesc));
		tblDesc.add(getQuanCDesc(tblDesc));
		tblDesc.add(getQuan_retCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getAmt_stdCDesc(tblDesc));
		tblDesc.add(getDt_orCDesc(tblDesc));
		tblDesc.add(getId_org_orCDesc(tblDesc));
		tblDesc.add(getId_dep_orCDesc(tblDesc));
		tblDesc.add(getId_emp_orCDesc(tblDesc));
		tblDesc.add(getId_wg_orCDesc(tblDesc));
		tblDesc.add(getId_dep_phyCDesc(tblDesc));
		tblDesc.add(getId_emp_phyCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_org_mpCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getDt_srvCDesc(tblDesc));
		tblDesc.add(getId_pripatCDesc(tblDesc));
		tblDesc.add(getRatio_pripatCDesc(tblDesc));
		tblDesc.add(getAmt_patCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getRatio_hpCDesc(tblDesc));
		tblDesc.add(getAmt_hpCDesc(tblDesc));
		tblDesc.add(getFg_mmCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_mmtpCDesc(tblDesc));
		tblDesc.add(getSd_mmtpCDesc(tblDesc));
		tblDesc.add(getCode_mmCDesc(tblDesc));
		tblDesc.add(getOnlycodeCDesc(tblDesc));
		tblDesc.add(getName_mmCDesc(tblDesc));
		tblDesc.add(getCd_batchCDesc(tblDesc));
		tblDesc.add(getSpecCDesc(tblDesc));
		tblDesc.add(getPgku_baseCDesc(tblDesc));
		tblDesc.add(getPgku_curCDesc(tblDesc));
		tblDesc.add(getFactorCDesc(tblDesc));
		tblDesc.add(getQuan_baseCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_orsrvCDesc(tblDesc));
		tblDesc.add(getId_or_prCDesc(tblDesc));
		tblDesc.add(getId_or_pr_srvCDesc(tblDesc));
		tblDesc.add(getId_presCDesc(tblDesc));
		tblDesc.add(getFg_pddiscCDesc(tblDesc));
		tblDesc.add(getFg_stCDesc(tblDesc));
		tblDesc.add(getId_stipCDesc(tblDesc));
		tblDesc.add(getDt_stCDesc(tblDesc));
		tblDesc.add(getFg_hpCDesc(tblDesc));
		tblDesc.add(getFg_suspCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getCode_cgCDesc(tblDesc));
		tblDesc.add(getId_org_cgCDesc(tblDesc));
		tblDesc.add(getId_dep_cgCDesc(tblDesc));
		tblDesc.add(getId_emp_cgCDesc(tblDesc));
		tblDesc.add(getDt_cgCDesc(tblDesc));
		tblDesc.add(getDt_oper_cgCDesc(tblDesc));
		tblDesc.add(getEu_srctpCDesc(tblDesc));
		tblDesc.add(getId_ent_momCDesc(tblDesc));
		tblDesc.add(getFg_bbCDesc(tblDesc));
		tblDesc.add(getNo_bbCDesc(tblDesc));
		tblDesc.add(getFg_refundCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getFg_additmCDesc(tblDesc));
		tblDesc.add(getApprnoCDesc(tblDesc));
		tblDesc.add(getAmt_ratioCDesc(tblDesc));
		tblDesc.add(getFg_recgCDesc(tblDesc));
		tblDesc.add(getId_recg_ipCDesc(tblDesc));
		tblDesc.add(getId_dep_whCDesc(tblDesc));
		tblDesc.add(getSrcfunc_desCDesc(tblDesc));
		tblDesc.add(getFg_freeCDesc(tblDesc));
		tblDesc.add(getCode_applyCDesc(tblDesc));
		tblDesc.add(getFg_selfpayCDesc(tblDesc));
		tblDesc.add(getFg_researchCDesc(tblDesc));
		tblDesc.add(getId_researchprojectCDesc(tblDesc));
		tblDesc.add(getId_entbedCDesc(tblDesc));
		tblDesc.add(getId_entdcgCDesc(tblDesc));
		tblDesc.add(getFg_pay_unitCDesc(tblDesc));
		tblDesc.add(getFg_realCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getAmt_hp_freeCDesc(tblDesc));
		tblDesc.add(getAmt_pat_freeCDesc(tblDesc));
		tblDesc.add(getSd_std_hpsrvtpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 记账主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cgipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cgip",  getId_cgipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账主键");
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
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enttp",  getId_enttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_enttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_enttp",  getCode_enttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记退费方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_directADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_direct",  getEu_directCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("记退费方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvtp",  getId_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvca",  getId_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvu",  getSrvuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 账单项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_inccaitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_inccaitm",  getCode_inccaitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账单项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账单项名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inccaitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inccaitm",  getName_inccaitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账单项名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算项目分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_accountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_account",  getCode_accountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算项目分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算项目分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_accountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_account",  getName_accountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算项目分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格_折扣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrice_ratioADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price_ratio",  getPrice_ratioCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格_折扣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan",  getQuanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_retADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_ret",  getQuan_retCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退费数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_stdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_std",  getAmt_stdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标准金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_or",  getDt_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开立日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_or",  getId_org_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_or",  getId_dep_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_or",  getId_emp_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wg_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wg_or",  getId_wg_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy",  getId_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 责任医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_phy",  getId_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_mp",  getId_org_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目发生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_srv",  getDt_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("服务项目发生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者价格类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pripatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pripat",  getId_pripatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 价格比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRatio_pripatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ratio_pripat",  getRatio_pripatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额_患者自付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_pat",  getAmt_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额_患者自付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保产品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保产品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRatio_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ratio_hp",  getRatio_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医保自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额_医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp",  getAmt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额_医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mm",  getFg_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("物品标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmtp",  getId_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmtp",  getSd_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mm",  getCode_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOnlycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Onlycode",  getOnlycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品唯一码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mm",  getName_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品批次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCd_batchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cd_batch",  getCd_batchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品批次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spec",  getSpecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品包装单位_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPgku_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pgku_base",  getPgku_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品包装单位_基本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品包装单位_当前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPgku_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pgku_cur",  getPgku_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品包装单位_当前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 换算系数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor",  getFactorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_基本包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_base",  getQuan_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量_基本包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orsrv",  getId_orsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱执行记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_prADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr",  getId_or_prCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱执行记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行记录子表属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_pr_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr_srv",  getId_or_pr_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行记录子表");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_presADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pres",  getId_presCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院带药标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pddiscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pddisc",  getFg_pddiscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("出院带药标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_st",  getFg_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("结算标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stip",  getId_stipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结算日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_st",  getDt_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结算日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账上传医保标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hp",  getFg_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("记账上传医保标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账挂起标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_suspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_susp",  getFg_suspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("记账挂起标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费关联记账主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费关联记账主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记账单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cg",  getCode_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_cg",  getId_org_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记账科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_cg",  getId_dep_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记账人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_cg",  getId_emp_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记账日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cg",  getDt_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记账日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账操作时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_oper_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper_cg",  getDt_oper_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记账操作时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_srctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_srctp",  getEu_srctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("费用来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 母亲就诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_momADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_mom",  getId_ent_momCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("母亲就诊主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否新生儿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bb",  getFg_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否新生儿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_bb",  getNo_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("婴儿编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已退款标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_refundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_refund",  getFg_refundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("已退款标志");
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
	 * 补录费用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_additmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_additm",  getFg_additmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("补录费用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 批准文号/注册号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApprnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apprno",  getApprnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("批准文号/注册号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额_价格比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_ratioADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_ratio",  getAmt_ratioCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额_价格比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重划价标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_recgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_recg",  getFg_recgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("重划价标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重划价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_recg_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_recg_ip",  getId_recg_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重划价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_wh",  getId_dep_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 费用产生功能点描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrcfunc_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srcfunc_des",  getSrcfunc_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费用产生功能点描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 减免标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_free",  getFg_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("减免标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_applyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_apply",  getCode_applyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自费标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_selfpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_selfpay",  getFg_selfpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自费标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科研标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_researchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_research",  getFg_researchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("科研标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科研项目id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_researchprojectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_researchproject",  getId_researchprojectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科研项目id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊床位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entbedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entbed",  getId_entbedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊床位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊固定费用id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entdcgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entdcg",  getId_entdcgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊固定费用id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否单位支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pay_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pay_unit",  getFg_pay_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否单位支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 真实记账标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_realADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_real",  getFg_realCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("真实记账标识");
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
	 * 实际金额_医保自付_减免额度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hp_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp_free",  getAmt_hp_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实际金额_医保自付_减免额度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际金额_项目减免_减免比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_pat_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_pat_free",  getAmt_pat_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实际金额_项目减免_减免比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通用报销等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_std_hpsrvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_std_hpsrvtp",  getSd_std_hpsrvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通用报销等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcgpatcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcgpatcode",  getBlcgpatcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b3","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcgpatnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcgpatname",  getBlcgpatnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b3","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcgenttpnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcgenttpname",  getBlcgenttpnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a0b4","id_enttp=id_entp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdentcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Identcode",  getIdentcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b5","id_ent=id_ent","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvtpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvtpcode",  getSrvtpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_srvtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvtpnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvtpname",  getSrvtpnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_srvtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvcacodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvcacode",  getSrvcacodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b7","id_srvca=id_srvca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvcanameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvcaname",  getSrvcanameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b7","id_srvca=id_srvca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvcode",  getSrvcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b8","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvname",  getSrvnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b8","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvu_code",  getSrvu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b29","srvu=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvu_name",  getSrvu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b29","srvu=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcgdepcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcgdepcode",  getBlcgdepcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_or=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcgdepnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcgdepname",  getBlcgdepnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_or=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDepmpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Depmpcode",  getDepmpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dep_mp=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDepmpnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Depmpname",  getDepmpnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dep_mp=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者价格分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdpripatcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idpripatcode",  getIdpripatcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pat a0b16","id_pripat=id_pripat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者价格分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdpripatnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idpripatname",  getIdpripatnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者价格分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pat a0b16","id_pripat=id_pripat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdmmcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idmmcode",  getIdmmcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b19","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdmmnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idmmname",  getIdmmnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b19","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdmmtpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idmmtpcode",  getIdmmtpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_mmtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdmmtpnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idmmtpname",  getIdmmtpnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_mmtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_st",  getCode_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bl_st_ip a0b28","id_stip=id_stip","code_st"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInccaitm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inccaitm_code",  getInccaitm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca_itm a0b31","id_inccaitm=id_inccaitm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInccaitm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inccaitm_name",  getInccaitm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca_itm a0b31","id_inccaitm=id_inccaitm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取记账主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cgipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cgip");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记账主键"); 
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
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_enttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_enttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
		return column;
	}
	/**
	 * 获取记退费方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_directCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_direct");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("记退费方向"); 
		return column;
	}
	/**
	 * 获取服务项目类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目类型"); 
		return column;
	}
	/**
	 * 获取服务项目分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目分类编码"); 
		return column;
	}
	/**
	 * 获取服务项目分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目分类"); 
		return column;
	}
	/**
	 * 获取服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目"); 
		return column;
	}
	/**
	 * 获取服务项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目编码"); 
		return column;
	}
	/**
	 * 获取服务项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目名称"); 
		return column;
	}
	/**
	 * 获取服务项目单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目单位"); 
		return column;
	}
	/**
	 * 获取账单项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_inccaitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_inccaitm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账单项编码"); 
		return column;
	}
	/**
	 * 获取账单项名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inccaitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inccaitm");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账单项名称"); 
		return column;
	}
	/**
	 * 获取核算项目分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_accountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_account");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算项目分类编码"); 
		return column;
	}
	/**
	 * 获取核算项目分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_accountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_account");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算项目分类名称"); 
		return column;
	}
	/**
	 * 获取价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(14);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格"); 
		return column;
	}
	/**
	 * 获取价格_折扣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrice_ratioCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price_ratio");
		column.setLength(14);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格_折扣"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取退费数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_retCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_ret");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退费数量"); 
		return column;
	}
	/**
	 * 获取金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额"); 
		return column;
	}
	/**
	 * 获取标准金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_stdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_std");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标准金额"); 
		return column;
	}
	/**
	 * 获取开立日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_or");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开立日期时间"); 
		return column;
	}
	/**
	 * 获取开立机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立机构"); 
		return column;
	}
	/**
	 * 获取开立科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立科室"); 
		return column;
	}
	/**
	 * 获取开立医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立医生"); 
		return column;
	}
	/**
	 * 获取医疗组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wg_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wg_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗组"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取责任医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任医生"); 
		return column;
	}
	/**
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
		return column;
	}
	/**
	 * 获取执行机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行机构"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取服务项目发生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_srv");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务项目发生日期"); 
		return column;
	}
	/**
	 * 获取患者价格类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pripatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pripat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格类型"); 
		return column;
	}
	/**
	 * 获取价格比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRatio_pripatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ratio_pripat");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格比例"); 
		return column;
	}
	/**
	 * 获取金额_患者自付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_pat");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额_患者自付"); 
		return column;
	}
	/**
	 * 获取医保产品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保产品"); 
		return column;
	}
	/**
	 * 获取医保自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRatio_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ratio_hp");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医保自付比例"); 
		return column;
	}
	/**
	 * 获取金额_医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额_医保计划"); 
		return column;
	}
	/**
	 * 获取物品标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("物品标志"); 
		return column;
	}
	/**
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取物品类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品类型"); 
		return column;
	}
	/**
	 * 获取物品类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品类型编码"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品编码"); 
		return column;
	}
	/**
	 * 获取物品唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOnlycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Onlycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品唯一码"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mm");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取物品批次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCd_batchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cd_batch");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品批次"); 
		return column;
	}
	/**
	 * 获取物品规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品规格"); 
		return column;
	}
	/**
	 * 获取物品包装单位_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPgku_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pgku_base");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品包装单位_基本"); 
		return column;
	}
	/**
	 * 获取物品包装单位_当前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPgku_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pgku_cur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品包装单位_当前"); 
		return column;
	}
	/**
	 * 获取换算系数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor");
		column.setLength(12);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数"); 
		return column;
	}
	/**
	 * 获取数量_基本包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_base");
		column.setLength(12);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量_基本包装"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取医嘱服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱服务"); 
		return column;
	}
	/**
	 * 获取医嘱执行记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_prCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱执行记录"); 
		return column;
	}
	/**
	 * 获取执行记录子表表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_pr_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行记录子表"); 
		return column;
	}
	/**
	 * 获取处方表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_presCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pres");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方"); 
		return column;
	}
	/**
	 * 获取出院带药标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pddiscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pddisc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院带药标志"); 
		return column;
	}
	/**
	 * 获取结算标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_st");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结算标志"); 
		return column;
	}
	/**
	 * 获取结算表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算"); 
		return column;
	}
	/**
	 * 获取结算日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_st");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结算日期"); 
		return column;
	}
	/**
	 * 获取记账上传医保标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记账上传医保标志"); 
		return column;
	}
	/**
	 * 获取记账挂起标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_suspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_susp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记账挂起标志"); 
		return column;
	}
	/**
	 * 获取退费关联记账主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费关联记账主键"); 
		return column;
	}
	/**
	 * 获取记账单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账单号"); 
		return column;
	}
	/**
	 * 获取记账机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_cg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账机构"); 
		return column;
	}
	/**
	 * 获取记账科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_cg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账科室"); 
		return column;
	}
	/**
	 * 获取记账人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_cg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账人员"); 
		return column;
	}
	/**
	 * 获取记账日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记账日期时间"); 
		return column;
	}
	/**
	 * 获取记账操作时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_oper_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper_cg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记账操作时间"); 
		return column;
	}
	/**
	 * 获取费用来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_srctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_srctp");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("费用来源"); 
		return column;
	}
	/**
	 * 获取母亲就诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_momCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_mom");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("母亲就诊主键"); 
		return column;
	}
	/**
	 * 获取是否新生儿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bb");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否新生儿"); 
		return column;
	}
	/**
	 * 获取婴儿编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_bb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("婴儿编号"); 
		return column;
	}
	/**
	 * 获取已退款标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_refundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_refund");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("已退款标志"); 
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
	 * 获取补录费用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_additmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_additm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("补录费用标志"); 
		return column;
	}
	/**
	 * 获取批准文号/注册号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApprnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apprno");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("批准文号/注册号"); 
		return column;
	}
	/**
	 * 获取金额_价格比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_ratioCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_ratio");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额_价格比例"); 
		return column;
	}
	/**
	 * 获取重划价标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_recgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_recg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("重划价标志"); 
		return column;
	}
	/**
	 * 获取重划价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_recg_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_recg_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重划价"); 
		return column;
	}
	/**
	 * 获取仓库表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库"); 
		return column;
	}
	/**
	 * 获取费用产生功能点描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrcfunc_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srcfunc_des");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费用产生功能点描述"); 
		return column;
	}
	/**
	 * 获取减免标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_free");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("减免标志"); 
		return column;
	}
	/**
	 * 获取医疗单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_applyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_apply");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗单号"); 
		return column;
	}
	/**
	 * 获取自费标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_selfpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_selfpay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自费标识"); 
		return column;
	}
	/**
	 * 获取科研标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_researchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_research");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("科研标志"); 
		return column;
	}
	/**
	 * 获取科研项目id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_researchprojectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_researchproject");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科研项目id"); 
		return column;
	}
	/**
	 * 获取就诊床位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entbedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entbed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊床位id"); 
		return column;
	}
	/**
	 * 获取就诊固定费用id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entdcgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entdcg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊固定费用id"); 
		return column;
	}
	/**
	 * 获取是否单位支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pay_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pay_unit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否单位支付"); 
		return column;
	}
	/**
	 * 获取真实记账标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_realCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_real");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("真实记账标识"); 
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
	 * 获取实际金额_医保自付_减免额度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hp_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp_free");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实际金额_医保自付_减免额度"); 
		return column;
	}
	/**
	 * 获取实际金额_项目减免_减免比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_pat_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_pat_free");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实际金额_项目减免_减免比例"); 
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
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通用报销等级"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlcgpatcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcgpatcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlcgpatnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcgpatname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取就诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlcgenttpnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcgenttpname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型名称"); 
		return column;
	}
	/**
	 * 获取就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdentcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Identcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvtpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvtpcode");
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
	private IColumnDesc getSrvtpnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvtpname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取服务分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvcacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvcacode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类编码"); 
		return column;
	}
	/**
	 * 获取服务分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvcanameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvcaname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取计量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvu_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位编码"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlcgdepcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcgdepcode");
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
	private IColumnDesc getBlcgdepnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcgdepname");
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
	private IColumnDesc getDepmpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Depmpcode");
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
	private IColumnDesc getDepmpnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Depmpname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取患者价格分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdpripatcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idpripatcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格分类编码"); 
		return column;
	}
	/**
	 * 获取患者价格分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdpripatnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idpripatname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者价格分类名称"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdmmcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idmmcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品编码"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdmmnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idmmname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdmmtpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idmmtpcode");
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
	private IColumnDesc getIdmmtpnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idmmtpname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取结算号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_st");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算号"); 
		return column;
	}
	/**
	 * 获取票据项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInccaitm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inccaitm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据项目编码"); 
		return column;
	}
	/**
	 * 获取票据项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInccaitm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inccaitm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据项目名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_cgip");
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
		defaultValueMap.put("Quan_mend",new xap.mw.coreitf.d.FDouble(0.00));
	}
	
}
