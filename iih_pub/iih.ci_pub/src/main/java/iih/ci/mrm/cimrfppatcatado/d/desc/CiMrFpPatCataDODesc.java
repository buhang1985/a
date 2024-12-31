
package iih.ci.mrm.cimrfppatcatado.d.desc;

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
 * 病案编目患者信息 DO 元数据信息
 */
public class CiMrFpPatCataDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.cimrfppatcatado.d.CiMrFpPatCataDO";
	public static final String CLASS_DISPALYNAME = "病案编目患者信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_PAT_CATA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cimrfppat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpPatCataDODesc(){
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
		this.setKeyDesc(getId_cimrfppatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cimrfppatADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getDt_birth_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getId_emp_phyADesc(tblDesc));
		this.add(getName_emp_phyADesc(tblDesc));
		this.add(getId_emp_nurADesc(tblDesc));
		this.add(getName_emp_nurADesc(tblDesc));
		this.add(getId_zr_docADesc(tblDesc));
		this.add(getName_zr_docADesc(tblDesc));
		this.add(getId_zz_docADesc(tblDesc));
		this.add(getName_zz_docADesc(tblDesc));
		this.add(getId_zy_docADesc(tblDesc));
		this.add(getName_zy_docADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getAddr_bornADesc(tblDesc));
		this.add(getAddr_originADesc(tblDesc));
		this.add(getAddr_nowADesc(tblDesc));
		this.add(getTel_addr_nowADesc(tblDesc));
		this.add(getZip_addr_nowADesc(tblDesc));
		this.add(getAddr_cencusADesc(tblDesc));
		this.add(getZip_addr_cencusADesc(tblDesc));
		this.add(getWorkunitADesc(tblDesc));
		this.add(getAddr_workADesc(tblDesc));
		this.add(getDel_addr_workADesc(tblDesc));
		this.add(getZip_addr_workADesc(tblDesc));
		this.add(getName_contADesc(tblDesc));
		this.add(getId_conttpADesc(tblDesc));
		this.add(getAddr_contADesc(tblDesc));
		this.add(getTel_contADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_pay_methodADesc(tblDesc));
		this.add(getSd_pay_methodADesc(tblDesc));
		this.add(getN_times_inhospitalADesc(tblDesc));
		this.add(getId_countryADesc(tblDesc));
		this.add(getSd_countryADesc(tblDesc));
		this.add(getId_nationADesc(tblDesc));
		this.add(getSd_nationADesc(tblDesc));
		this.add(getId_marryADesc(tblDesc));
		this.add(getSd_marryADesc(tblDesc));
		this.add(getId_idtpADesc(tblDesc));
		this.add(getSd_idtpADesc(tblDesc));
		this.add(getName_idtpADesc(tblDesc));
		this.add(getId_codeADesc(tblDesc));
		this.add(getId_occuADesc(tblDesc));
		this.add(getSd_occuADesc(tblDesc));
		this.add(getSd_conttpADesc(tblDesc));
		this.add(getAge_monthADesc(tblDesc));
		this.add(getBirth_weightADesc(tblDesc));
		this.add(getAddmission_weightADesc(tblDesc));
		this.add(getId_referalsrcADesc(tblDesc));
		this.add(getDt_acptADesc(tblDesc));
		this.add(getSd_referalsrcADesc(tblDesc));
		this.add(getId_dep_phyadmADesc(tblDesc));
		this.add(getSd_dep_phyadmADesc(tblDesc));
		this.add(getId_dep_transADesc(tblDesc));
		this.add(getSd_dep_transADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getId_dep_phydiscADesc(tblDesc));
		this.add(getSd_dep_phydiscADesc(tblDesc));
		this.add(getHosdaysADesc(tblDesc));
		this.add(getIn_id_bedADesc(tblDesc));
		this.add(getOut_id_bedADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_countryADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getName_occuADesc(tblDesc));
		this.add(getName_marryADesc(tblDesc));
		this.add(getName_conttpADesc(tblDesc));
		this.add(getName_referalsrcADesc(tblDesc));
		this.add(getName_dep_phyadmADesc(tblDesc));
		this.add(getName_dep_transADesc(tblDesc));
		this.add(getName_dep_phydiscADesc(tblDesc));
		this.add(getName_pay_methodADesc(tblDesc));
		this.add(getName_outp_emer_diADesc(tblDesc));
		this.add(getSd_outp_emer_diADesc(tblDesc));
		this.add(getId_outp_emer_diADesc(tblDesc));
		this.add(getId_curecategoryADesc(tblDesc));
		this.add(getName_curecategoryADesc(tblDesc));
		this.add(getSd_curecategoryADesc(tblDesc));
		this.add(getId_outp_cm_diADesc(tblDesc));
		this.add(getName_outp_cm_diADesc(tblDesc));
		this.add(getSd_outp_cm_diADesc(tblDesc));
		this.add(getDef0ADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getHealth_card_idADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getName_in_bedADesc(tblDesc));
		this.add(getSd_in_bedADesc(tblDesc));
		this.add(getSd_out_bedADesc(tblDesc));
		this.add(getName_out_bedADesc(tblDesc));
		this.add(getCode_pat_ieADesc(tblDesc));
		this.add(getCode_ent_ieADesc(tblDesc));
		this.add(getId_mrfpADesc(tblDesc));
		this.add(getName_otherinstADesc(tblDesc));
		this.add(getBirth_weight_oneADesc(tblDesc));
		this.add(getBirth_weight_twoADesc(tblDesc));
		this.add(getId_certificates_reasonADesc(tblDesc));
		this.add(getName_certificates_reasonADesc(tblDesc));
		this.add(getSd_certificates_reasonADesc(tblDesc));
		this.add(getId_addr_nowADesc(tblDesc));
		this.add(getSd_addr_nowADesc(tblDesc));
		this.add(getId_addr_cencusADesc(tblDesc));
		this.add(getSd_addr_cencusADesc(tblDesc));
		this.add(getId_workunitADesc(tblDesc));
		this.add(getSd_workunitADesc(tblDesc));
		this.add(getId_addr_workADesc(tblDesc));
		this.add(getSd_addr_workADesc(tblDesc));
		this.add(getId_addr_contADesc(tblDesc));
		this.add(getDlb_socre_inADesc(tblDesc));
		this.add(getDlb_socre_outADesc(tblDesc));
		this.add(getSd_addr_contADesc(tblDesc));
		this.add(getId_addr_bornADesc(tblDesc));
		this.add(getSd_addr_bornADesc(tblDesc));
		this.add(getId_addr_originADesc(tblDesc));
		this.add(getSd_addr_originADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getSex_nameADesc(tblDesc));
		this.add(getConttp_codeADesc(tblDesc));
		this.add(getConttp_nameADesc(tblDesc));
		this.add(getPay_method_codeADesc(tblDesc));
		this.add(getPay_method_nameADesc(tblDesc));
		this.add(getCountry_codeADesc(tblDesc));
		this.add(getCountry_nameADesc(tblDesc));
		this.add(getNation_codeADesc(tblDesc));
		this.add(getNation_nameADesc(tblDesc));
		this.add(getMarry_codeADesc(tblDesc));
		this.add(getMarry_nameADesc(tblDesc));
		this.add(getIdtp_codeADesc(tblDesc));
		this.add(getIdtp_nameADesc(tblDesc));
		this.add(getOccu_codeADesc(tblDesc));
		this.add(getOccu_nameADesc(tblDesc));
		this.add(getReferalsrc_codeADesc(tblDesc));
		this.add(getReferalsrc_nameADesc(tblDesc));
		this.add(getDep_phyadm_codeADesc(tblDesc));
		this.add(getDep_phyadm_nameADesc(tblDesc));
		this.add(getDep_trans_codeADesc(tblDesc));
		this.add(getDep_trans_nameADesc(tblDesc));
		this.add(getDep_phydisc_codeADesc(tblDesc));
		this.add(getDep_phydisc_nameADesc(tblDesc));
		this.add(getCode_outp_diADesc(tblDesc));
		this.add(getName_outp_diADesc(tblDesc));
		this.add(getCurecategory_codeADesc(tblDesc));
		this.add(getCurecategory_nameADesc(tblDesc));
		this.add(getOutp_cm_di_codeADesc(tblDesc));
		this.add(getOutp_cm_di_nameADesc(tblDesc));
		this.add(getModifiedby_nameADesc(tblDesc));
		this.add(getModifiedby_codeADesc(tblDesc));
		this.add(getCreateby_nameADesc(tblDesc));
		this.add(getCreateby_codeADesc(tblDesc));
		this.add(getCertificates_reason_codeADesc(tblDesc));
		this.add(getCertificates_reason_nameADesc(tblDesc));
		this.add(getAddr_now_codeADesc(tblDesc));
		this.add(getAddr_now_nameADesc(tblDesc));
		this.add(getAddr_cencus_nameADesc(tblDesc));
		this.add(getWorkunit_codeADesc(tblDesc));
		this.add(getWorkunit_nameADesc(tblDesc));
		this.add(getAddr_work_codeADesc(tblDesc));
		this.add(getAddr_work_nameADesc(tblDesc));
		this.add(getAddr_cont_codeADesc(tblDesc));
		this.add(getAddr_cont_nameADesc(tblDesc));
		this.add(getAddr_born_codeADesc(tblDesc));
		this.add(getAddr_born_nameADesc(tblDesc));
		this.add(getAddr_origin_codeADesc(tblDesc));
		this.add(getAddr_origin_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cimrfppatCDesc(tblDesc));
		tblDesc.add(getId_cimrfppatCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_entpCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getDt_birth_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getId_emp_phyCDesc(tblDesc));
		tblDesc.add(getName_emp_phyCDesc(tblDesc));
		tblDesc.add(getId_emp_nurCDesc(tblDesc));
		tblDesc.add(getName_emp_nurCDesc(tblDesc));
		tblDesc.add(getId_zr_docCDesc(tblDesc));
		tblDesc.add(getName_zr_docCDesc(tblDesc));
		tblDesc.add(getId_zz_docCDesc(tblDesc));
		tblDesc.add(getName_zz_docCDesc(tblDesc));
		tblDesc.add(getId_zy_docCDesc(tblDesc));
		tblDesc.add(getName_zy_docCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getAddr_bornCDesc(tblDesc));
		tblDesc.add(getAddr_originCDesc(tblDesc));
		tblDesc.add(getAddr_nowCDesc(tblDesc));
		tblDesc.add(getTel_addr_nowCDesc(tblDesc));
		tblDesc.add(getZip_addr_nowCDesc(tblDesc));
		tblDesc.add(getAddr_cencusCDesc(tblDesc));
		tblDesc.add(getZip_addr_cencusCDesc(tblDesc));
		tblDesc.add(getWorkunitCDesc(tblDesc));
		tblDesc.add(getAddr_workCDesc(tblDesc));
		tblDesc.add(getDel_addr_workCDesc(tblDesc));
		tblDesc.add(getZip_addr_workCDesc(tblDesc));
		tblDesc.add(getName_contCDesc(tblDesc));
		tblDesc.add(getId_conttpCDesc(tblDesc));
		tblDesc.add(getAddr_contCDesc(tblDesc));
		tblDesc.add(getTel_contCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_pay_methodCDesc(tblDesc));
		tblDesc.add(getSd_pay_methodCDesc(tblDesc));
		tblDesc.add(getN_times_inhospitalCDesc(tblDesc));
		tblDesc.add(getId_countryCDesc(tblDesc));
		tblDesc.add(getSd_countryCDesc(tblDesc));
		tblDesc.add(getId_nationCDesc(tblDesc));
		tblDesc.add(getSd_nationCDesc(tblDesc));
		tblDesc.add(getId_marryCDesc(tblDesc));
		tblDesc.add(getSd_marryCDesc(tblDesc));
		tblDesc.add(getId_idtpCDesc(tblDesc));
		tblDesc.add(getSd_idtpCDesc(tblDesc));
		tblDesc.add(getName_idtpCDesc(tblDesc));
		tblDesc.add(getId_codeCDesc(tblDesc));
		tblDesc.add(getId_occuCDesc(tblDesc));
		tblDesc.add(getSd_occuCDesc(tblDesc));
		tblDesc.add(getSd_conttpCDesc(tblDesc));
		tblDesc.add(getAge_monthCDesc(tblDesc));
		tblDesc.add(getBirth_weightCDesc(tblDesc));
		tblDesc.add(getAddmission_weightCDesc(tblDesc));
		tblDesc.add(getId_referalsrcCDesc(tblDesc));
		tblDesc.add(getDt_acptCDesc(tblDesc));
		tblDesc.add(getSd_referalsrcCDesc(tblDesc));
		tblDesc.add(getId_dep_phyadmCDesc(tblDesc));
		tblDesc.add(getSd_dep_phyadmCDesc(tblDesc));
		tblDesc.add(getId_dep_transCDesc(tblDesc));
		tblDesc.add(getSd_dep_transCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getId_dep_phydiscCDesc(tblDesc));
		tblDesc.add(getSd_dep_phydiscCDesc(tblDesc));
		tblDesc.add(getHosdaysCDesc(tblDesc));
		tblDesc.add(getIn_id_bedCDesc(tblDesc));
		tblDesc.add(getOut_id_bedCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getName_countryCDesc(tblDesc));
		tblDesc.add(getName_nationCDesc(tblDesc));
		tblDesc.add(getName_occuCDesc(tblDesc));
		tblDesc.add(getName_marryCDesc(tblDesc));
		tblDesc.add(getName_conttpCDesc(tblDesc));
		tblDesc.add(getName_referalsrcCDesc(tblDesc));
		tblDesc.add(getName_dep_phyadmCDesc(tblDesc));
		tblDesc.add(getName_dep_transCDesc(tblDesc));
		tblDesc.add(getName_dep_phydiscCDesc(tblDesc));
		tblDesc.add(getName_pay_methodCDesc(tblDesc));
		tblDesc.add(getName_outp_emer_diCDesc(tblDesc));
		tblDesc.add(getSd_outp_emer_diCDesc(tblDesc));
		tblDesc.add(getId_outp_emer_diCDesc(tblDesc));
		tblDesc.add(getId_curecategoryCDesc(tblDesc));
		tblDesc.add(getName_curecategoryCDesc(tblDesc));
		tblDesc.add(getSd_curecategoryCDesc(tblDesc));
		tblDesc.add(getId_outp_cm_diCDesc(tblDesc));
		tblDesc.add(getName_outp_cm_diCDesc(tblDesc));
		tblDesc.add(getSd_outp_cm_diCDesc(tblDesc));
		tblDesc.add(getDef0CDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getHealth_card_idCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getName_in_bedCDesc(tblDesc));
		tblDesc.add(getSd_in_bedCDesc(tblDesc));
		tblDesc.add(getSd_out_bedCDesc(tblDesc));
		tblDesc.add(getName_out_bedCDesc(tblDesc));
		tblDesc.add(getCode_pat_ieCDesc(tblDesc));
		tblDesc.add(getCode_ent_ieCDesc(tblDesc));
		tblDesc.add(getId_mrfpCDesc(tblDesc));
		tblDesc.add(getName_otherinstCDesc(tblDesc));
		tblDesc.add(getBirth_weight_oneCDesc(tblDesc));
		tblDesc.add(getBirth_weight_twoCDesc(tblDesc));
		tblDesc.add(getId_certificates_reasonCDesc(tblDesc));
		tblDesc.add(getName_certificates_reasonCDesc(tblDesc));
		tblDesc.add(getSd_certificates_reasonCDesc(tblDesc));
		tblDesc.add(getId_addr_nowCDesc(tblDesc));
		tblDesc.add(getSd_addr_nowCDesc(tblDesc));
		tblDesc.add(getId_addr_cencusCDesc(tblDesc));
		tblDesc.add(getSd_addr_cencusCDesc(tblDesc));
		tblDesc.add(getId_workunitCDesc(tblDesc));
		tblDesc.add(getSd_workunitCDesc(tblDesc));
		tblDesc.add(getId_addr_workCDesc(tblDesc));
		tblDesc.add(getSd_addr_workCDesc(tblDesc));
		tblDesc.add(getId_addr_contCDesc(tblDesc));
		tblDesc.add(getDlb_socre_inCDesc(tblDesc));
		tblDesc.add(getDlb_socre_outCDesc(tblDesc));
		tblDesc.add(getSd_addr_contCDesc(tblDesc));
		tblDesc.add(getId_addr_bornCDesc(tblDesc));
		tblDesc.add(getSd_addr_bornCDesc(tblDesc));
		tblDesc.add(getId_addr_originCDesc(tblDesc));
		tblDesc.add(getSd_addr_originCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病案编目患者信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cimrfppatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cimrfppat",  getId_cimrfppatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案编目患者信息ID");
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
	 * 患者就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊号");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者号");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp",  getId_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
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
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
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
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birth_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth_pat",  getDt_birth_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任医生ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_phy",  getId_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任医生ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_phy",  getName_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任护士ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nur",  getId_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_nur",  getName_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任医师ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_zr_doc",  getId_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任医师ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zr_doc",  getName_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治医生ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_zz_doc",  getId_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医生ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zz_doc",  getName_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院医生ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_zy_doc",  getId_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医生ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zy_doc",  getName_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 出生地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_born",  getAddr_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 籍贯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_originADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_origin",  getAddr_originCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("籍贯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_nowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_now",  getAddr_nowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTel_addr_nowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel_addr_now",  getTel_addr_nowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址邮编属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZip_addr_nowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zip_addr_now",  getZip_addr_nowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址邮编");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户口地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_cencusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_cencus",  getAddr_cencusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户口地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户口地址邮编属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZip_addr_cencusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zip_addr_cencus",  getZip_addr_cencusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户口地址邮编");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkunitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workunit",  getWorkunitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_work",  getAddr_workCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作地址电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDel_addr_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Del_addr_work",  getDel_addr_workCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作地址电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作地址邮编属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZip_addr_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zip_addr_work",  getZip_addr_workCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作地址邮编");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cont",  getName_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_conttp",  getId_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 联系人电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTel_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel_cont",  getTel_contCDesc(tblDesc), this);
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
	 * 住院病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗付费方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pay_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pay_method",  getId_pay_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗付费方式ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗付费方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pay_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pay_method",  getSd_pay_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗付费方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第几次住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN_times_inhospitalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N_times_inhospital",  getN_times_inhospitalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("第几次住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国籍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_country",  getId_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国籍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 国籍编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_country",  getSd_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国籍编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nation",  getId_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 民族编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nation",  getSd_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_marry",  getId_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婚姻编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_marry",  getSd_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主身份标志类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_idtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_idtp",  getId_idtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主身份标志类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主身份标志类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_idtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_idtp",  getSd_idtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主身份标志类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主身份标志类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_idtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_idtp",  getName_idtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主身份标志类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主身份标识号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_code",  getId_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主身份标识号码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_occuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_occu",  getId_occuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职业编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_occuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_occu",  getSd_occuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_conttp",  getSd_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄不足一周岁的月数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_month",  getAge_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄不足一周岁的月数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿出生体重（单位g）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirth_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_weight",  getBirth_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿出生体重（单位g）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿入院体重（单位g）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddmission_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addmission_weight",  getAddmission_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿入院体重（单位g）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_referalsrc",  getId_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_acptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_acpt",  getDt_acptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_referalsrc",  getSd_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phyadm",  getId_dep_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dep_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dep_phyadm",  getSd_dep_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转科科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_trans",  getId_dep_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转科科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dep_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dep_trans",  getSd_dep_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phydiscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phydisc",  getId_dep_phydiscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dep_phydiscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dep_phydisc",  getSd_dep_phydiscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际住院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosdaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosdays",  getHosdaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("实际住院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院病房属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_id_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_id_bed",  getIn_id_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病房");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院病房属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_id_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_id_bed",  getOut_id_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院病房");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国籍名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_country",  getName_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国籍名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_occuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_occu",  getName_occuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_marry",  getName_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关系名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_conttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_conttp",  getName_conttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关系名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院途径名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_referalsrc",  getName_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院途径名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phyadm",  getName_dep_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转科科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_trans",  getName_dep_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phydiscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phydisc",  getName_dep_phydiscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付费方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pay_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pay_method",  getName_pay_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付费方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门(急)诊诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_outp_emer_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_outp_emer_di",  getName_outp_emer_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门(急)诊诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门(急)诊诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_outp_emer_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_outp_emer_di",  getSd_outp_emer_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门(急)诊诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门(急)诊诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outp_emer_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_outp_emer_di",  getId_outp_emer_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门(急)诊诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 治疗类别（id）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_curecategoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_curecategory",  getId_curecategoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗类别（id）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 治疗类别（name）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_curecategoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_curecategory",  getName_curecategoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗类别（name）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗类别（sd）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_curecategoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_curecategory",  getSd_curecategoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗类别（sd）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门（急）诊诊断（中医诊断）id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outp_cm_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_outp_cm_di",  getId_outp_cm_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门（急）诊诊断（中医诊断）id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门（急）诊诊断（中医诊断）name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_outp_cm_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_outp_cm_di",  getName_outp_cm_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门（急）诊诊断（中医诊断）name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门（急）诊诊断（中医诊断）sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_outp_cm_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_outp_cm_di",  getSd_outp_cm_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门（急）诊诊断（中医诊断）sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam88属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef0ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def0",  getDef0CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam88");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam89属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam89");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam90属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam90");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam91属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam91");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam92属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam92");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam93属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam93");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam94属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam94");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam95属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam95");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam96属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam96");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam97属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam97");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_card_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_card_id",  getHealth_card_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 入院病房(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_in_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_in_bed",  getName_in_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病房(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院病房(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_in_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_in_bed",  getSd_in_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病房(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院病房(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_out_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_out_bed",  getSd_out_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院病房(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院病房(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_bed",  getName_out_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院病房(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集成平台患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_pat_ieADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat_ie",  getCode_pat_ieCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集成平台患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集成平台就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_ent_ieADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ent_ie",  getCode_ent_ieCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集成平台就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案首页id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfp",  getId_mrfpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊医疗机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_otherinstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_otherinst",  getName_otherinstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊医疗机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿出生体重一孩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirth_weight_oneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_weight_one",  getBirth_weight_oneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿出生体重一孩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿出生体重儿孩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirth_weight_twoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_weight_two",  getBirth_weight_twoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿出生体重儿孩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件不详原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_certificates_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_certificates_reason",  getId_certificates_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件不详原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 证件不详原因名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_certificates_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_certificates_reason",  getName_certificates_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件不详原因名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件不详原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_certificates_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_certificates_reason",  getSd_certificates_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件不详原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addr_nowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addr_now",  getId_addr_nowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 现住址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addr_nowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addr_now",  getSd_addr_nowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户口地址id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addr_cencusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addr_cencus",  getId_addr_cencusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户口地址id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 户口地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addr_cencusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addr_cencus",  getSd_addr_cencusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户口地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作单位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_workunitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_workunit",  getId_workunitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作单位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 工作单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_workunitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_workunit",  getSd_workunitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作地址id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addr_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addr_work",  getId_addr_workCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作地址id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 工作地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addr_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addr_work",  getSd_addr_workCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人地址id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addr_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addr_cont",  getId_addr_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人地址id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表（入院）得分入院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_socre_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_socre_in",  getDlb_socre_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表（入院）得分入院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表（出院）得出分院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_socre_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_socre_out",  getDlb_socre_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表（出院）得出分院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addr_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addr_cont",  getSd_addr_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生地址id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addr_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addr_born",  getId_addr_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生地址id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出生地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addr_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addr_born",  getSd_addr_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 籍贯id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addr_originADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addr_origin",  getId_addr_originCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("籍贯id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 籍贯编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_addr_originADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_addr_origin",  getSd_addr_originCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("籍贯编码");
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
	private IAttrDesc getGrp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_code",  getGrp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_code",  getSex_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_name",  getSex_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sex=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_conttp=id_udidoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_conttp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_method_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_method_code",  getPay_method_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_pay_method=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_method_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_method_name",  getPay_method_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_pay_method=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码 国籍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountry_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Country_code",  getCountry_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码 国籍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b7","id_country=id_countryzone","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称  国籍名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountry_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Country_name",  getCountry_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称  国籍名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b7","id_country=id_countryzone","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_code",  getNation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_nation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_name",  getNation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_nation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarry_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marry_code",  getMarry_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_marry=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarry_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marry_name",  getMarry_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_marry=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身份标识类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idtp_code",  getIdtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身份标识类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_idtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身份标识类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idtp_name",  getIdtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身份标识类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_idtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOccu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Occu_code",  getOccu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_occu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOccu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Occu_name",  getOccu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_occu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferalsrc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referalsrc_code",  getReferalsrc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_referalsrc=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferalsrc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referalsrc_name",  getReferalsrc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_referalsrc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_phyadm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_phyadm_code",  getDep_phyadm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b13","id_dep_phyadm=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_phyadm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_phyadm_name",  getDep_phyadm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b13","id_dep_phyadm=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转科科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_trans_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_trans_code",  getDep_trans_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b14","id_dep_trans=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转科科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_trans_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_trans_name",  getDep_trans_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b14","id_dep_trans=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_phydisc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_phydisc_code",  getDep_phydisc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dep_phydisc=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_phydisc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_phydisc_name",  getDep_phydisc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dep_phydisc=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_outp_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_outp_di",  getCode_outp_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b16","id_outp_emer_di=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_outp_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_outp_di",  getName_outp_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b16","id_outp_emer_di=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurecategory_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Curecategory_code",  getCurecategory_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_curecategory=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurecategory_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Curecategory_name",  getCurecategory_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_curecategory=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutp_cm_di_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outp_cm_di_code",  getOutp_cm_di_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b18","id_outp_cm_di=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutp_cm_di_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outp_cm_di_name",  getOutp_cm_di_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b18","id_outp_cm_di=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedby_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby_name",  getModifiedby_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b19","modifiedby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedby_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby_code",  getModifiedby_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b19","modifiedby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreateby_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createby_name",  getCreateby_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b20","createdby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreateby_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createby_code",  getCreateby_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b20","createdby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertificates_reason_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certificates_reason_code",  getCertificates_reason_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_certificates_reason=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertificates_reason_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certificates_reason_name",  getCertificates_reason_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_certificates_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_now_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_now_code",  getAddr_now_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b22","id_addr_now=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_now_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_now_name",  getAddr_now_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b22","id_addr_now=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_cencus_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_cencus_name",  getAddr_cencus_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b23","id_addr_cencus=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkunit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workunit_code",  getWorkunit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b24","id_workunit=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkunit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workunit_name",  getWorkunit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b24","id_workunit=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_work_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_work_code",  getAddr_work_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b25","id_addr_work=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_work_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_work_name",  getAddr_work_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b25","id_addr_work=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_cont_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_cont_code",  getAddr_cont_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b26","id_addr_cont=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_cont_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_cont_name",  getAddr_cont_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b26","id_addr_cont=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_born_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_born_code",  getAddr_born_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b27","id_addr_born=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_born_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_born_name",  getAddr_born_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b27","id_addr_born=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_origin_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_origin_code",  getAddr_origin_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b28","id_addr_origin=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_origin_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_origin_name",  getAddr_origin_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b28","id_addr_origin=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病案编目患者信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cimrfppatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cimrfppat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病案编目患者信息ID"); 
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
	 * 获取患者就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊号"); 
		return column;
	}
	/**
	 * 获取患者号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者号"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取就诊类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型ID"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birth_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth_pat");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取责任医生ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任医生ID"); 
		return column;
	}
	/**
	 * 获取责任医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任医生"); 
		return column;
	}
	/**
	 * 获取责任护士ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士ID"); 
		return column;
	}
	/**
	 * 获取责任护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士"); 
		return column;
	}
	/**
	 * 获取主任医师ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_zr_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任医师ID"); 
		return column;
	}
	/**
	 * 获取主任医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zr_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任医师"); 
		return column;
	}
	/**
	 * 获取主治医生ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_zz_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医生ID"); 
		return column;
	}
	/**
	 * 获取主治医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zz_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医生"); 
		return column;
	}
	/**
	 * 获取住院医生ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_zy_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医生ID"); 
		return column;
	}
	/**
	 * 获取住院医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zy_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医生"); 
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
	 * 获取出生地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_born");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生地址"); 
		return column;
	}
	/**
	 * 获取籍贯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_originCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_origin");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("籍贯"); 
		return column;
	}
	/**
	 * 获取现住址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_nowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_now");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址"); 
		return column;
	}
	/**
	 * 获取现住址电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTel_addr_nowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel_addr_now");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址电话"); 
		return column;
	}
	/**
	 * 获取现住址邮编表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZip_addr_nowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zip_addr_now");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址邮编"); 
		return column;
	}
	/**
	 * 获取户口地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_cencusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_cencus");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户口地址"); 
		return column;
	}
	/**
	 * 获取户口地址邮编表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZip_addr_cencusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zip_addr_cencus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户口地址邮编"); 
		return column;
	}
	/**
	 * 获取工作单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkunitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workunit");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作单位"); 
		return column;
	}
	/**
	 * 获取工作地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_work");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作地址"); 
		return column;
	}
	/**
	 * 获取工作地址电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDel_addr_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Del_addr_work");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作地址电话"); 
		return column;
	}
	/**
	 * 获取工作地址邮编表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZip_addr_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zip_addr_work");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作地址邮编"); 
		return column;
	}
	/**
	 * 获取联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人"); 
		return column;
	}
	/**
	 * 获取关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_conttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关系"); 
		return column;
	}
	/**
	 * 获取联系人地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_cont");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人地址"); 
		return column;
	}
	/**
	 * 获取联系人电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTel_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人电话"); 
		return column;
	}
	/**
	 * 获取住院病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案号"); 
		return column;
	}
	/**
	 * 获取医疗付费方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pay_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pay_method");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗付费方式ID"); 
		return column;
	}
	/**
	 * 获取医疗付费方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pay_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pay_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗付费方式编码"); 
		return column;
	}
	/**
	 * 获取第几次住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN_times_inhospitalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N_times_inhospital");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("第几次住院"); 
		return column;
	}
	/**
	 * 获取国籍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_country");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国籍"); 
		return column;
	}
	/**
	 * 获取国籍编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_country");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国籍编码"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取民族编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族编码"); 
		return column;
	}
	/**
	 * 获取婚姻表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_marry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻"); 
		return column;
	}
	/**
	 * 获取婚姻编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_marry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻编码"); 
		return column;
	}
	/**
	 * 获取主身份标志类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_idtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_idtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主身份标志类型"); 
		return column;
	}
	/**
	 * 获取主身份标志类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_idtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_idtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主身份标志类型编码"); 
		return column;
	}
	/**
	 * 获取主身份标志类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_idtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_idtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主身份标志类型名称"); 
		return column;
	}
	/**
	 * 获取主身份标识号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主身份标识号码"); 
		return column;
	}
	/**
	 * 获取职业表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_occuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_occu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业"); 
		return column;
	}
	/**
	 * 获取职业编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_occuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_occu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业编码"); 
		return column;
	}
	/**
	 * 获取关系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_conttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关系编码"); 
		return column;
	}
	/**
	 * 获取年龄不足一周岁的月数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_month");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄不足一周岁的月数"); 
		return column;
	}
	/**
	 * 获取新生儿出生体重（单位g）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_weight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿出生体重（单位g）"); 
		return column;
	}
	/**
	 * 获取新生儿入院体重（单位g）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddmission_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addmission_weight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿入院体重（单位g）"); 
		return column;
	}
	/**
	 * 获取入院途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_referalsrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院途径"); 
		return column;
	}
	/**
	 * 获取入院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_acptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_acpt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院日期"); 
		return column;
	}
	/**
	 * 获取入院途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院途径编码"); 
		return column;
	}
	/**
	 * 获取入院科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phyadm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科别"); 
		return column;
	}
	/**
	 * 获取入院科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dep_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dep_phyadm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科别编码"); 
		return column;
	}
	/**
	 * 获取转科科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_trans");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科科别"); 
		return column;
	}
	/**
	 * 获取转科科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dep_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dep_trans");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科科别编码"); 
		return column;
	}
	/**
	 * 获取出院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院日期"); 
		return column;
	}
	/**
	 * 获取出院科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phydiscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phydisc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院科别"); 
		return column;
	}
	/**
	 * 获取出院科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dep_phydiscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dep_phydisc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院科别编码"); 
		return column;
	}
	/**
	 * 获取实际住院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosdaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosdays");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("实际住院天数"); 
		return column;
	}
	/**
	 * 获取入院病房表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_id_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_id_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病房"); 
		return column;
	}
	/**
	 * 获取出院病房表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_id_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_id_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院病房"); 
		return column;
	}
	/**
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取国籍名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_country");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国籍名称"); 
		return column;
	}
	/**
	 * 获取民族名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族名称"); 
		return column;
	}
	/**
	 * 获取职业名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_occuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_occu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业名称"); 
		return column;
	}
	/**
	 * 获取婚姻名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_marry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻名称"); 
		return column;
	}
	/**
	 * 获取关系名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_conttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_conttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关系名称"); 
		return column;
	}
	/**
	 * 获取入院途径名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院途径名称"); 
		return column;
	}
	/**
	 * 获取入院科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phyadm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科别名称"); 
		return column;
	}
	/**
	 * 获取转科科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_trans");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科科别名称"); 
		return column;
	}
	/**
	 * 获取出院科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phydiscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phydisc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院科别名称"); 
		return column;
	}
	/**
	 * 获取付费方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pay_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pay_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付费方式名称"); 
		return column;
	}
	/**
	 * 获取门(急)诊诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_outp_emer_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_outp_emer_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门(急)诊诊断名称"); 
		return column;
	}
	/**
	 * 获取门(急)诊诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_outp_emer_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_outp_emer_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门(急)诊诊断编码"); 
		return column;
	}
	/**
	 * 获取门(急)诊诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outp_emer_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_outp_emer_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门(急)诊诊断"); 
		return column;
	}
	/**
	 * 获取治疗类别（id）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_curecategoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_curecategory");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗类别（id）"); 
		return column;
	}
	/**
	 * 获取治疗类别（name）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_curecategoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_curecategory");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗类别（name）"); 
		return column;
	}
	/**
	 * 获取治疗类别（sd）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_curecategoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_curecategory");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗类别（sd）"); 
		return column;
	}
	/**
	 * 获取门（急）诊诊断（中医诊断）id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outp_cm_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_outp_cm_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门（急）诊诊断（中医诊断）id"); 
		return column;
	}
	/**
	 * 获取门（急）诊诊断（中医诊断）name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_outp_cm_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_outp_cm_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门（急）诊诊断（中医诊断）name"); 
		return column;
	}
	/**
	 * 获取门（急）诊诊断（中医诊断）sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_outp_cm_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_outp_cm_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门（急）诊诊断（中医诊断）sd"); 
		return column;
	}
	/**
	 * 获取displaynam88表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef0CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def0");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam88"); 
		return column;
	}
	/**
	 * 获取displaynam89表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam89"); 
		return column;
	}
	/**
	 * 获取displaynam90表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam90"); 
		return column;
	}
	/**
	 * 获取displaynam91表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam91"); 
		return column;
	}
	/**
	 * 获取displaynam92表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam92"); 
		return column;
	}
	/**
	 * 获取displaynam93表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam93"); 
		return column;
	}
	/**
	 * 获取displaynam94表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam94"); 
		return column;
	}
	/**
	 * 获取displaynam95表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam95"); 
		return column;
	}
	/**
	 * 获取displaynam96表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam96"); 
		return column;
	}
	/**
	 * 获取displaynam97表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam97"); 
		return column;
	}
	/**
	 * 获取健康卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHealth_card_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_card_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康卡号"); 
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
	 * 获取入院病房(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_in_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_in_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病房(name)"); 
		return column;
	}
	/**
	 * 获取入院病房(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_in_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_in_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病房(sd)"); 
		return column;
	}
	/**
	 * 获取出院病房(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_out_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_out_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院病房(sd)"); 
		return column;
	}
	/**
	 * 获取出院病房(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_out_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院病房(name)"); 
		return column;
	}
	/**
	 * 获取集成平台患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_pat_ieCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat_ie");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集成平台患者编码"); 
		return column;
	}
	/**
	 * 获取集成平台就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_ent_ieCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ent_ie");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集成平台就诊编码"); 
		return column;
	}
	/**
	 * 获取病案首页id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案首页id"); 
		return column;
	}
	/**
	 * 获取转诊医疗机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_otherinstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_otherinst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转诊医疗机构名称"); 
		return column;
	}
	/**
	 * 获取新生儿出生体重一孩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_weight_oneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_weight_one");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿出生体重一孩"); 
		return column;
	}
	/**
	 * 获取新生儿出生体重儿孩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_weight_twoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_weight_two");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿出生体重儿孩"); 
		return column;
	}
	/**
	 * 获取证件不详原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_certificates_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_certificates_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件不详原因"); 
		return column;
	}
	/**
	 * 获取证件不详原因名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_certificates_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_certificates_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件不详原因名称"); 
		return column;
	}
	/**
	 * 获取证件不详原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_certificates_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_certificates_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件不详原因编码"); 
		return column;
	}
	/**
	 * 获取现住址id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addr_nowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addr_now");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址id"); 
		return column;
	}
	/**
	 * 获取现住址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addr_nowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addr_now");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址编码"); 
		return column;
	}
	/**
	 * 获取户口地址id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addr_cencusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addr_cencus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户口地址id"); 
		return column;
	}
	/**
	 * 获取户口地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addr_cencusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addr_cencus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户口地址编码"); 
		return column;
	}
	/**
	 * 获取工作单位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_workunitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_workunit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作单位id"); 
		return column;
	}
	/**
	 * 获取工作单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_workunitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_workunit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作单位编码"); 
		return column;
	}
	/**
	 * 获取工作地址id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addr_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addr_work");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作地址id"); 
		return column;
	}
	/**
	 * 获取工作地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addr_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addr_work");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作地址编码"); 
		return column;
	}
	/**
	 * 获取联系人地址id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addr_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addr_cont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人地址id"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表（入院）得分入院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_socre_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_socre_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表（入院）得分入院"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表（出院）得出分院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_socre_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_socre_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表（出院）得出分院"); 
		return column;
	}
	/**
	 * 获取联系人地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addr_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addr_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人地址编码"); 
		return column;
	}
	/**
	 * 获取出生地址id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addr_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addr_born");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生地址id"); 
		return column;
	}
	/**
	 * 获取出生地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addr_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addr_born");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生地址编码"); 
		return column;
	}
	/**
	 * 获取籍贯id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addr_originCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addr_origin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("籍贯id"); 
		return column;
	}
	/**
	 * 获取籍贯编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_addr_originCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_addr_origin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("籍贯编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_code");
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
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_code");
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
	private IColumnDesc getSex_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_name");
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_method_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_method_code");
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
	private IColumnDesc getPay_method_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_method_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码 国籍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCountry_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Country_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码 国籍"); 
		return column;
	}
	/**
	 * 获取名称  国籍名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCountry_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Country_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称  国籍名称"); 
		return column;
	}
	/**
	 * 获取民族编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族编码"); 
		return column;
	}
	/**
	 * 获取民族名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarry_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marry_code");
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
	private IColumnDesc getMarry_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marry_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取身份标识类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身份标识类型编码"); 
		return column;
	}
	/**
	 * 获取身份标识类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身份标识类型名称"); 
		return column;
	}
	/**
	 * 获取职业编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOccu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Occu_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业编码"); 
		return column;
	}
	/**
	 * 获取职业名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOccu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Occu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferalsrc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referalsrc_code");
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
	private IColumnDesc getReferalsrc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referalsrc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取入院科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_phyadm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_phyadm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科别编码"); 
		return column;
	}
	/**
	 * 获取入院科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_phyadm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_phyadm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科别名称"); 
		return column;
	}
	/**
	 * 获取转科科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_trans_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_trans_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科科别编码"); 
		return column;
	}
	/**
	 * 获取转科科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_trans_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_trans_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科科别名称"); 
		return column;
	}
	/**
	 * 获取出院科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_phydisc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_phydisc_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院科别编码"); 
		return column;
	}
	/**
	 * 获取出院科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_phydisc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_phydisc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院科别名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_outp_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_outp_di");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_outp_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_outp_di");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCurecategory_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Curecategory_code");
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
	private IColumnDesc getCurecategory_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Curecategory_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutp_cm_di_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outp_cm_di_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutp_cm_di_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outp_cm_di_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedby_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby_name");
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
	private IColumnDesc getModifiedby_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreateby_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createby_name");
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
	private IColumnDesc getCreateby_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createby_code");
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
	private IColumnDesc getCertificates_reason_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certificates_reason_code");
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
	private IColumnDesc getCertificates_reason_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certificates_reason_name");
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
	private IColumnDesc getAddr_now_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_now_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_now_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_now_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_cencus_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_cencus_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkunit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workunit_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkunit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workunit_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_work_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_work_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_work_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_work_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_cont_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_cont_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_cont_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_cont_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_born_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_born_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_born_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_born_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_origin_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_origin_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_origin_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_origin_name");
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
		defaultValueMap.put("Age","-");
	}
	
}
