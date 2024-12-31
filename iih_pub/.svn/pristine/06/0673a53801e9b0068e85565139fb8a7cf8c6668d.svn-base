
package iih.ci.mrfp.other2mrfp.d.desc;

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
 * 病案首页其他信息 DO 元数据信息
 */
public class CiMrFpOtherDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO";
	public static final String CLASS_DISPALYNAME = "病案首页其他信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_OTHER";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cimrfpother";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpOtherDODesc(){
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
		this.setKeyDesc(getId_cimrfpotherADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cimrfpotherADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getId_drug_allergyADesc(tblDesc));
		this.add(getName_drug_allergyADesc(tblDesc));
		this.add(getAllergic_drugsADesc(tblDesc));
		this.add(getId_blood_typeADesc(tblDesc));
		this.add(getName_blood_typeADesc(tblDesc));
		this.add(getId_rh_typeADesc(tblDesc));
		this.add(getName_rh_typeADesc(tblDesc));
		this.add(getDirofdeptADesc(tblDesc));
		this.add(getId_dirofdeptADesc(tblDesc));
		this.add(getSd_dirofdeptADesc(tblDesc));
		this.add(getName_zr_docADesc(tblDesc));
		this.add(getSd_zr_docADesc(tblDesc));
		this.add(getId_zr_docADesc(tblDesc));
		this.add(getName_emp_phyADesc(tblDesc));
		this.add(getId_emp_phyADesc(tblDesc));
		this.add(getSd_emp_phyADesc(tblDesc));
		this.add(getName_emp_nurADesc(tblDesc));
		this.add(getId_emp_nurADesc(tblDesc));
		this.add(getSd_emp_nurADesc(tblDesc));
		this.add(getName_zz_docADesc(tblDesc));
		this.add(getId_zz_docADesc(tblDesc));
		this.add(getSd_zz_docADesc(tblDesc));
		this.add(getName_zy_docADesc(tblDesc));
		this.add(getId_zy_docADesc(tblDesc));
		this.add(getSd_zy_docADesc(tblDesc));
		this.add(getName_learn_docADesc(tblDesc));
		this.add(getId_learn_docADesc(tblDesc));
		this.add(getSd_learn_docADesc(tblDesc));
		this.add(getName_intern_docADesc(tblDesc));
		this.add(getId_intern_docADesc(tblDesc));
		this.add(getSd_intern_docADesc(tblDesc));
		this.add(getName_qcp_docADesc(tblDesc));
		this.add(getId_qcp_docADesc(tblDesc));
		this.add(getSd_qcp_docADesc(tblDesc));
		this.add(getName_qcp_nurADesc(tblDesc));
		this.add(getId_qcp_nurADesc(tblDesc));
		this.add(getSd_qcp_nurADesc(tblDesc));
		this.add(getName_coderADesc(tblDesc));
		this.add(getId_coderADesc(tblDesc));
		this.add(getSd_coderADesc(tblDesc));
		this.add(getId_qom_recordADesc(tblDesc));
		this.add(getName_qom_recordADesc(tblDesc));
		this.add(getQc_dateADesc(tblDesc));
		this.add(getNum_pathoADesc(tblDesc));
		this.add(getOut_hos_modeADesc(tblDesc));
		this.add(getCode_out_hos_modeADesc(tblDesc));
		this.add(getName_out_hos_modeADesc(tblDesc));
		this.add(getName_med_in_1ADesc(tblDesc));
		this.add(getName_med_in_2ADesc(tblDesc));
		this.add(getId_aut_dead_patADesc(tblDesc));
		this.add(getName_aut_dead_patADesc(tblDesc));
		this.add(getId_is_have_inhos_planADesc(tblDesc));
		this.add(getName_is_have_inhos_planADesc(tblDesc));
		this.add(getGoal_inhos_planADesc(tblDesc));
		this.add(getComa_time_bef_inhos_daysADesc(tblDesc));
		this.add(getComa_time_bef_inhos_hoursADesc(tblDesc));
		this.add(getComa_time_bef_inhos_minsADesc(tblDesc));
		this.add(getComa_time_inhos_daysADesc(tblDesc));
		this.add(getComa_time_inhos_hoursADesc(tblDesc));
		this.add(getComa_time_inhos_minsADesc(tblDesc));
		this.add(getVentilator_use_timeADesc(tblDesc));
		this.add(getTumor_grade_tADesc(tblDesc));
		this.add(getTumor_grade_nADesc(tblDesc));
		this.add(getTumor_grade_mADesc(tblDesc));
		this.add(getDlb_score_inADesc(tblDesc));
		this.add(getDlb_score_outADesc(tblDesc));
		this.add(getId_cipathtypeADesc(tblDesc));
		this.add(getId_usecmpADesc(tblDesc));
		this.add(getId_usecmeADesc(tblDesc));
		this.add(getId_usecmdtADesc(tblDesc));
		this.add(getId_dnurADesc(tblDesc));
		this.add(getId_iioutreasonADesc(tblDesc));
		this.add(getSd_iioutreasonADesc(tblDesc));
		this.add(getName_iioutreasonADesc(tblDesc));
		this.add(getId_dipathologyADesc(tblDesc));
		this.add(getSd_dipathologyADesc(tblDesc));
		this.add(getName_dipathologyADesc(tblDesc));
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
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_hightestdiADesc(tblDesc));
		this.add(getSd_hightestdiADesc(tblDesc));
		this.add(getName_hightestdiADesc(tblDesc));
		this.add(getId_nur_levADesc(tblDesc));
		this.add(getName_nur_levADesc(tblDesc));
		this.add(getId_inpathstatusADesc(tblDesc));
		this.add(getSd_inpathstatusADesc(tblDesc));
		this.add(getName_inpathstatusADesc(tblDesc));
		this.add(getId_completestatusADesc(tblDesc));
		this.add(getSd_completestatusADesc(tblDesc));
		this.add(getName_completestatusADesc(tblDesc));
		this.add(getId_variationstausADesc(tblDesc));
		this.add(getSd_variationstausADesc(tblDesc));
		this.add(getName_variationstausADesc(tblDesc));
		this.add(getId_team_docADesc(tblDesc));
		this.add(getSd_team_docADesc(tblDesc));
		this.add(getName_team_docADesc(tblDesc));
		this.add(getSuperlev_nur_daysADesc(tblDesc));
		this.add(getOnelev_nur_daysADesc(tblDesc));
		this.add(getTwolev_nur_daysADesc(tblDesc));
		this.add(getThreelev_nur_daysADesc(tblDesc));
		this.add(getCode_icdo3ADesc(tblDesc));
		this.add(getId_byediagADesc(tblDesc));
		this.add(getCode_byediagADesc(tblDesc));
		this.add(getName_byediagADesc(tblDesc));
		this.add(getId_cm_mainillADesc(tblDesc));
		this.add(getCode_cm_mainillADesc(tblDesc));
		this.add(getName_cm_mainillADesc(tblDesc));
		this.add(getId_cm_mainsymADesc(tblDesc));
		this.add(getCode_cm_mainsymADesc(tblDesc));
		this.add(getName_cm_mainsymADesc(tblDesc));
		this.add(getCertcode_dirofdeptADesc(tblDesc));
		this.add(getCertcode_zr_docADesc(tblDesc));
		this.add(getCertcode_zz_docADesc(tblDesc));
		this.add(getCertcode_zy_docADesc(tblDesc));
		this.add(getCertcode_emp_nurADesc(tblDesc));
		this.add(getOut_hos_situationADesc(tblDesc));
		this.add(getId_inhos_diADesc(tblDesc));
		this.add(getSd_inhos_diADesc(tblDesc));
		this.add(getName_inhos_diADesc(tblDesc));
		this.add(getDt_inhos_diADesc(tblDesc));
		this.add(getNum_patho_2ADesc(tblDesc));
		this.add(getId_dipathology_2ADesc(tblDesc));
		this.add(getSd_dipathology_2ADesc(tblDesc));
		this.add(getName_dipathology_2ADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getDirofdept_codeADesc(tblDesc));
		this.add(getDirofdept_nameADesc(tblDesc));
		this.add(getZr_doc_codeADesc(tblDesc));
		this.add(getZr_doc_nameADesc(tblDesc));
		this.add(getEmp_phy_codeADesc(tblDesc));
		this.add(getEmp_phy_nameADesc(tblDesc));
		this.add(getEmp_nur_codeADesc(tblDesc));
		this.add(getEmp_nur_nameADesc(tblDesc));
		this.add(getZz_doc_codeADesc(tblDesc));
		this.add(getZz_doc_nameADesc(tblDesc));
		this.add(getZy_doc_codeADesc(tblDesc));
		this.add(getZy_doc_nameADesc(tblDesc));
		this.add(getLearn_doc_codeADesc(tblDesc));
		this.add(getLearn_doc_nameADesc(tblDesc));
		this.add(getIntern_doc_codeADesc(tblDesc));
		this.add(getIntern_doc_nameADesc(tblDesc));
		this.add(getQcp_doc_codeADesc(tblDesc));
		this.add(getQcp_doc_nameADesc(tblDesc));
		this.add(getQcp_nur_codeADesc(tblDesc));
		this.add(getQcp_nur_nameADesc(tblDesc));
		this.add(getCoder_codeADesc(tblDesc));
		this.add(getCoder_nameADesc(tblDesc));
		this.add(getCode_cipathtypeADesc(tblDesc));
		this.add(getName_cipathtypeADesc(tblDesc));
		this.add(getSelectedtextADesc(tblDesc));
		this.add(getSelectedvalueADesc(tblDesc));
		this.add(getUsecme_codeADesc(tblDesc));
		this.add(getUsecme_nameADesc(tblDesc));
		this.add(getUsecmdt_codeADesc(tblDesc));
		this.add(getUsecmdt_nameADesc(tblDesc));
		this.add(getDnur_codeADesc(tblDesc));
		this.add(getDnur_nameADesc(tblDesc));
		this.add(getIioutreason_nameADesc(tblDesc));
		this.add(getIioutreaso_codeADesc(tblDesc));
		this.add(getDipathology_codeADesc(tblDesc));
		this.add(getDipathology_nameADesc(tblDesc));
		this.add(getHightestdi_nameADesc(tblDesc));
		this.add(getHightestdi_codeADesc(tblDesc));
		this.add(getNur_lev_codeADesc(tblDesc));
		this.add(getNur_lev_nameADesc(tblDesc));
		this.add(getInpath_codeADesc(tblDesc));
		this.add(getInpath_nameADesc(tblDesc));
		this.add(getComplete_codeADesc(tblDesc));
		this.add(getComplete_nameADesc(tblDesc));
		this.add(getVariation_codeADesc(tblDesc));
		this.add(getVariation_nameADesc(tblDesc));
		this.add(getTeam_codeADesc(tblDesc));
		this.add(getTeam_nameADesc(tblDesc));
		this.add(getByediag_codeADesc(tblDesc));
		this.add(getByediag_nameADesc(tblDesc));
		this.add(getInhos_di_nameADesc(tblDesc));
		this.add(getInhos_di_codeADesc(tblDesc));
		this.add(getDipathology_2_nameADesc(tblDesc));
		this.add(getDipathology_2_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cimrfpotherCDesc(tblDesc));
		tblDesc.add(getId_cimrfpotherCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getId_drug_allergyCDesc(tblDesc));
		tblDesc.add(getName_drug_allergyCDesc(tblDesc));
		tblDesc.add(getAllergic_drugsCDesc(tblDesc));
		tblDesc.add(getId_blood_typeCDesc(tblDesc));
		tblDesc.add(getName_blood_typeCDesc(tblDesc));
		tblDesc.add(getId_rh_typeCDesc(tblDesc));
		tblDesc.add(getName_rh_typeCDesc(tblDesc));
		tblDesc.add(getDirofdeptCDesc(tblDesc));
		tblDesc.add(getId_dirofdeptCDesc(tblDesc));
		tblDesc.add(getSd_dirofdeptCDesc(tblDesc));
		tblDesc.add(getName_zr_docCDesc(tblDesc));
		tblDesc.add(getSd_zr_docCDesc(tblDesc));
		tblDesc.add(getId_zr_docCDesc(tblDesc));
		tblDesc.add(getName_emp_phyCDesc(tblDesc));
		tblDesc.add(getId_emp_phyCDesc(tblDesc));
		tblDesc.add(getSd_emp_phyCDesc(tblDesc));
		tblDesc.add(getName_emp_nurCDesc(tblDesc));
		tblDesc.add(getId_emp_nurCDesc(tblDesc));
		tblDesc.add(getSd_emp_nurCDesc(tblDesc));
		tblDesc.add(getName_zz_docCDesc(tblDesc));
		tblDesc.add(getId_zz_docCDesc(tblDesc));
		tblDesc.add(getSd_zz_docCDesc(tblDesc));
		tblDesc.add(getName_zy_docCDesc(tblDesc));
		tblDesc.add(getId_zy_docCDesc(tblDesc));
		tblDesc.add(getSd_zy_docCDesc(tblDesc));
		tblDesc.add(getName_learn_docCDesc(tblDesc));
		tblDesc.add(getId_learn_docCDesc(tblDesc));
		tblDesc.add(getSd_learn_docCDesc(tblDesc));
		tblDesc.add(getName_intern_docCDesc(tblDesc));
		tblDesc.add(getId_intern_docCDesc(tblDesc));
		tblDesc.add(getSd_intern_docCDesc(tblDesc));
		tblDesc.add(getName_qcp_docCDesc(tblDesc));
		tblDesc.add(getId_qcp_docCDesc(tblDesc));
		tblDesc.add(getSd_qcp_docCDesc(tblDesc));
		tblDesc.add(getName_qcp_nurCDesc(tblDesc));
		tblDesc.add(getId_qcp_nurCDesc(tblDesc));
		tblDesc.add(getSd_qcp_nurCDesc(tblDesc));
		tblDesc.add(getName_coderCDesc(tblDesc));
		tblDesc.add(getId_coderCDesc(tblDesc));
		tblDesc.add(getSd_coderCDesc(tblDesc));
		tblDesc.add(getId_qom_recordCDesc(tblDesc));
		tblDesc.add(getName_qom_recordCDesc(tblDesc));
		tblDesc.add(getQc_dateCDesc(tblDesc));
		tblDesc.add(getNum_pathoCDesc(tblDesc));
		tblDesc.add(getOut_hos_modeCDesc(tblDesc));
		tblDesc.add(getCode_out_hos_modeCDesc(tblDesc));
		tblDesc.add(getName_out_hos_modeCDesc(tblDesc));
		tblDesc.add(getName_med_in_1CDesc(tblDesc));
		tblDesc.add(getName_med_in_2CDesc(tblDesc));
		tblDesc.add(getId_aut_dead_patCDesc(tblDesc));
		tblDesc.add(getName_aut_dead_patCDesc(tblDesc));
		tblDesc.add(getId_is_have_inhos_planCDesc(tblDesc));
		tblDesc.add(getName_is_have_inhos_planCDesc(tblDesc));
		tblDesc.add(getGoal_inhos_planCDesc(tblDesc));
		tblDesc.add(getComa_time_bef_inhos_daysCDesc(tblDesc));
		tblDesc.add(getComa_time_bef_inhos_hoursCDesc(tblDesc));
		tblDesc.add(getComa_time_bef_inhos_minsCDesc(tblDesc));
		tblDesc.add(getComa_time_inhos_daysCDesc(tblDesc));
		tblDesc.add(getComa_time_inhos_hoursCDesc(tblDesc));
		tblDesc.add(getComa_time_inhos_minsCDesc(tblDesc));
		tblDesc.add(getVentilator_use_timeCDesc(tblDesc));
		tblDesc.add(getTumor_grade_tCDesc(tblDesc));
		tblDesc.add(getTumor_grade_nCDesc(tblDesc));
		tblDesc.add(getTumor_grade_mCDesc(tblDesc));
		tblDesc.add(getDlb_score_inCDesc(tblDesc));
		tblDesc.add(getDlb_score_outCDesc(tblDesc));
		tblDesc.add(getId_cipathtypeCDesc(tblDesc));
		tblDesc.add(getId_usecmpCDesc(tblDesc));
		tblDesc.add(getId_usecmeCDesc(tblDesc));
		tblDesc.add(getId_usecmdtCDesc(tblDesc));
		tblDesc.add(getId_dnurCDesc(tblDesc));
		tblDesc.add(getId_iioutreasonCDesc(tblDesc));
		tblDesc.add(getSd_iioutreasonCDesc(tblDesc));
		tblDesc.add(getName_iioutreasonCDesc(tblDesc));
		tblDesc.add(getId_dipathologyCDesc(tblDesc));
		tblDesc.add(getSd_dipathologyCDesc(tblDesc));
		tblDesc.add(getName_dipathologyCDesc(tblDesc));
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
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_hightestdiCDesc(tblDesc));
		tblDesc.add(getSd_hightestdiCDesc(tblDesc));
		tblDesc.add(getName_hightestdiCDesc(tblDesc));
		tblDesc.add(getId_nur_levCDesc(tblDesc));
		tblDesc.add(getName_nur_levCDesc(tblDesc));
		tblDesc.add(getId_inpathstatusCDesc(tblDesc));
		tblDesc.add(getSd_inpathstatusCDesc(tblDesc));
		tblDesc.add(getName_inpathstatusCDesc(tblDesc));
		tblDesc.add(getId_completestatusCDesc(tblDesc));
		tblDesc.add(getSd_completestatusCDesc(tblDesc));
		tblDesc.add(getName_completestatusCDesc(tblDesc));
		tblDesc.add(getId_variationstausCDesc(tblDesc));
		tblDesc.add(getSd_variationstausCDesc(tblDesc));
		tblDesc.add(getName_variationstausCDesc(tblDesc));
		tblDesc.add(getId_team_docCDesc(tblDesc));
		tblDesc.add(getSd_team_docCDesc(tblDesc));
		tblDesc.add(getName_team_docCDesc(tblDesc));
		tblDesc.add(getSuperlev_nur_daysCDesc(tblDesc));
		tblDesc.add(getOnelev_nur_daysCDesc(tblDesc));
		tblDesc.add(getTwolev_nur_daysCDesc(tblDesc));
		tblDesc.add(getThreelev_nur_daysCDesc(tblDesc));
		tblDesc.add(getCode_icdo3CDesc(tblDesc));
		tblDesc.add(getId_byediagCDesc(tblDesc));
		tblDesc.add(getCode_byediagCDesc(tblDesc));
		tblDesc.add(getName_byediagCDesc(tblDesc));
		tblDesc.add(getId_cm_mainillCDesc(tblDesc));
		tblDesc.add(getCode_cm_mainillCDesc(tblDesc));
		tblDesc.add(getName_cm_mainillCDesc(tblDesc));
		tblDesc.add(getId_cm_mainsymCDesc(tblDesc));
		tblDesc.add(getCode_cm_mainsymCDesc(tblDesc));
		tblDesc.add(getName_cm_mainsymCDesc(tblDesc));
		tblDesc.add(getCertcode_dirofdeptCDesc(tblDesc));
		tblDesc.add(getCertcode_zr_docCDesc(tblDesc));
		tblDesc.add(getCertcode_zz_docCDesc(tblDesc));
		tblDesc.add(getCertcode_zy_docCDesc(tblDesc));
		tblDesc.add(getCertcode_emp_nurCDesc(tblDesc));
		tblDesc.add(getOut_hos_situationCDesc(tblDesc));
		tblDesc.add(getId_inhos_diCDesc(tblDesc));
		tblDesc.add(getSd_inhos_diCDesc(tblDesc));
		tblDesc.add(getName_inhos_diCDesc(tblDesc));
		tblDesc.add(getDt_inhos_diCDesc(tblDesc));
		tblDesc.add(getNum_patho_2CDesc(tblDesc));
		tblDesc.add(getId_dipathology_2CDesc(tblDesc));
		tblDesc.add(getSd_dipathology_2CDesc(tblDesc));
		tblDesc.add(getName_dipathology_2CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病案首页其他信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cimrfpotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cimrfpother",  getId_cimrfpotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页其他信息ID");
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
	 * 病案首页主表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页主表id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有无药物过敏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drug_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug_allergy",  getId_drug_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有无药物过敏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有无药物过敏名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drug_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drug_allergy",  getName_drug_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有无药物过敏名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllergic_drugsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allergic_drugs",  getAllergic_drugsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_type",  getId_blood_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_type",  getName_blood_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * RH血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rh_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rh_type",  getId_rh_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("RH血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * RH血型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rh_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rh_type",  getName_rh_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("RH血型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科主任属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dirofdept",  getDirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科主任(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dirofdept",  getId_dirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科主任(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dirofdept",  getSd_dirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任（副主任）医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zr_doc",  getName_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任（副主任）医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任（副主任）医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_zr_doc",  getSd_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任（副主任）医师(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任（副主任）医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_zr_doc",  getId_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任（副主任）医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主诊医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_phy",  getName_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主诊医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主诊医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_phy",  getId_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主诊医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主诊医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_phy",  getSd_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主诊医师(sd)");
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
	 * 责任护士(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nur",  getId_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 责任护士(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_nur",  getSd_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zz_doc",  getName_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_zz_doc",  getId_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主治医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_zz_doc",  getSd_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医师(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zy_doc",  getName_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_zy_doc",  getId_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_zy_doc",  getSd_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医师(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进修医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_learn_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_learn_doc",  getName_learn_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进修医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进修医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_learn_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_learn_doc",  getId_learn_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进修医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 进修医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_learn_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_learn_doc",  getSd_learn_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进修医师(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实习医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intern_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intern_doc",  getName_intern_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实习医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intern_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intern_doc",  getId_intern_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实习医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intern_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intern_doc",  getSd_intern_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习医师(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qcp_doc",  getName_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控医师(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qcp_doc",  getId_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质控医师(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qcp_doc",  getSd_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qcp_nur",  getName_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控护士(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qcp_nur",  getId_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质控护士(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qcp_nur",  getSd_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_coderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_coder",  getName_coderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码员(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_coderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_coder",  getId_coderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码员(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码员(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_coderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_coder",  getSd_coderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码员(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案质量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qom_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qom_record",  getId_qom_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案质量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案质量名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qom_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qom_record",  getName_qom_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案质量名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQc_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qc_date",  getQc_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("质控日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_pathoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_patho",  getNum_pathoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_hos_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_hos_mode",  getOut_hos_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 离院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_out_hos_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_out_hos_mode",  getCode_out_hos_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_hos_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_hos_mode",  getName_out_hos_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱转院_转入医疗机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_med_in_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_med_in_1",  getName_med_in_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱转院_转入医疗机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱转社区_转入医疗机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_med_in_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_med_in_2",  getName_med_in_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱转社区_转入医疗机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡患者尸检属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aut_dead_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aut_dead_pat",  getId_aut_dead_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡患者尸检");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 死亡患者尸检名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_aut_dead_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_aut_dead_pat",  getName_aut_dead_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡患者尸检名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有出院31天内再住院的计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_is_have_inhos_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_is_have_inhos_plan",  getId_is_have_inhos_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有出院31天内再住院的计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有出院31天内再住院的计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_is_have_inhos_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_is_have_inhos_plan",  getName_is_have_inhos_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有出院31天内再住院的计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 再次入院目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGoal_inhos_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Goal_inhos_plan",  getGoal_inhos_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("再次入院目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_bef_inhos_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_bef_inhos_days",  getComa_time_bef_inhos_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间（颅脑损伤患者）入院前 天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_bef_inhos_hoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_bef_inhos_hours",  getComa_time_bef_inhos_hoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间（颅脑损伤患者）入院前 小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_bef_inhos_minsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_bef_inhos_mins",  getComa_time_bef_inhos_minsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间（颅脑损伤患者）入院前 分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间入院后 天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_inhos_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_inhos_days",  getComa_time_inhos_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间入院后 天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间入院后 小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_inhos_hoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_inhos_hours",  getComa_time_inhos_hoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间入院后 小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间入院后 分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_inhos_minsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_inhos_mins",  getComa_time_inhos_minsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间入院后 分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸机使用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVentilator_use_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ventilator_use_time",  getVentilator_use_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸机使用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿瘤分期T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTumor_grade_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tumor_grade_t",  getTumor_grade_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肿瘤分期T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿瘤分期N属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTumor_grade_nADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tumor_grade_n",  getTumor_grade_nCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肿瘤分期N");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿瘤分期M属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTumor_grade_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tumor_grade_m",  getTumor_grade_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肿瘤分期M");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表得分入院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_score_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_score_in",  getDlb_score_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表得分入院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表得分出院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_score_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_score_out",  getDlb_score_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表得分出院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实施临床路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cipathtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cipathtype",  getId_cipathtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实施临床路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否使用医疗机构中药制剂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usecmpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usecmp",  getId_usecmpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否使用医疗机构中药制剂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否使用中医诊疗设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usecmeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usecme",  getId_usecmeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否使用中医诊疗设备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否使用中医诊疗技术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usecmdtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usecmdt",  getId_usecmdtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否使用中医诊疗技术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 辩证施护属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dnur",  getId_dnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辩证施护");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 损伤、中毒的外部原因（id）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_iioutreasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_iioutreason",  getId_iioutreasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("损伤、中毒的外部原因（id）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 损伤、中毒的外部原因（sd）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_iioutreasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_iioutreason",  getSd_iioutreasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("损伤、中毒的外部原因（sd）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 损伤、中毒的外部原因（name）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_iioutreasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_iioutreason",  getName_iioutreasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("损伤、中毒的外部原因（name）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理诊断（id）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dipathologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dipathology",  getId_dipathologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理诊断（id）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病理诊断（sd）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dipathologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dipathology",  getSd_dipathologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理诊断（sd）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理诊断（name）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dipathologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dipathology",  getName_dipathologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理诊断（name）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam60属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef0ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def0",  getDef0CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam60");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam61属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam61");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam62属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam62");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam63属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam63");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam64属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam64");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam65属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam65");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam66属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam66");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam67属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam67");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam68属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam68");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam69属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam69");
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
	 * 最高诊断依据id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hightestdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hightestdi",  getId_hightestdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断依据id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最高诊断依据sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hightestdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hightestdi",  getSd_hightestdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断依据sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最高诊断依据name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hightestdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hightestdi",  getName_hightestdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断依据name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_levADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_lev",  getId_nur_levCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理级别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_levADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_lev",  getName_nur_levCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理级别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入径情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inpathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inpathstatus",  getId_inpathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入径情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入径情况sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inpathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inpathstatus",  getSd_inpathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入径情况sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入径情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inpathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inpathstatus",  getName_inpathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入径情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_completestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_completestatus",  getId_completestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 完成情况sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_completestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_completestatus",  getSd_completestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成情况sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_completestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_completestatus",  getName_completestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_variationstausADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_variationstaus",  getId_variationstausCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 变异情况sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_variationstausADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_variationstaus",  getSd_variationstausCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异情况sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_variationstausADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_variationstaus",  getName_variationstausCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗组长(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_team_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_team_doc",  getId_team_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗组长(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗组长(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_team_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_team_doc",  getSd_team_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗组长(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗组长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_team_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_team_doc",  getName_team_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗组长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特级护理天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuperlev_nur_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Superlev_nur_days",  getSuperlev_nur_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("特级护理天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一级护理天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOnelev_nur_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Onelev_nur_days",  getOnelev_nur_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("一级护理天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二级护理天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTwolev_nur_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Twolev_nur_days",  getTwolev_nur_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("二级护理天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 三级护理天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThreelev_nur_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Threelev_nur_days",  getThreelev_nur_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("三级护理天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ICD-O-3编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_icdo3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_icdo3",  getCode_icdo3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICD-O-3编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西医出院诊断-主要诊断疾病id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_byediagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_byediag",  getId_byediagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("西医出院诊断-主要诊断疾病id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 西医出院诊断-主要诊断疾病code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_byediagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_byediag",  getCode_byediagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("西医出院诊断-主要诊断疾病code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西医出院诊断-主要诊断疾病name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_byediagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_byediag",  getName_byediagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("西医出院诊断-主要诊断疾病name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医出院诊断_主病id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cm_mainillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cm_mainill",  getId_cm_mainillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医出院诊断_主病id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医出院诊断_主病code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cm_mainillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cm_mainill",  getCode_cm_mainillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医出院诊断_主病code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医出院诊断_主病name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cm_mainillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cm_mainill",  getName_cm_mainillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医出院诊断_主病name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医出院诊断_主症id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cm_mainsymADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cm_mainsym",  getId_cm_mainsymCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医出院诊断_主症id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医出院诊断_主症code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cm_mainsymADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cm_mainsym",  getCode_cm_mainsymCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医出院诊断_主症code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医出院诊断_主症name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cm_mainsymADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cm_mainsym",  getName_cm_mainsymCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医出院诊断_主症name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科主任_执业证书编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertcode_dirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certcode_dirofdept",  getCertcode_dirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任_执业证书编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任（副主任）医师_执业证书编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertcode_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certcode_zr_doc",  getCertcode_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任（副主任）医师_执业证书编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治医师_执业证书编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertcode_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certcode_zz_doc",  getCertcode_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医师_执业证书编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院医师_执业证书编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertcode_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certcode_zy_doc",  getCertcode_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医师_执业证书编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任护士_执业证书编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertcode_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Certcode_emp_nur",  getCertcode_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士_执业证书编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院情况描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_hos_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_hos_situation",  getOut_hos_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院情况描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inhos_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inhos_di",  getId_inhos_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院诊断code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inhos_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inhos_di",  getSd_inhos_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inhos_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inhos_di",  getName_inhos_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院后确诊日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_inhos_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_inhos_di",  getDt_inhos_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("入院后确诊日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理号2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_patho_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_patho_2",  getNum_patho_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理号2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理诊断2id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dipathology_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dipathology_2",  getId_dipathology_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理诊断2id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病理诊断2code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dipathology_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dipathology_2",  getSd_dipathology_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理诊断2code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理诊断2name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dipathology_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dipathology_2",  getName_dipathology_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理诊断2name");
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
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b11","id_grp=id_grp","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b11","id_grp=id_grp","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b12","id_org=id_org","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b12","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDirofdept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dirofdept_code",  getDirofdept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b13","id_dirofdept=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDirofdept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dirofdept_name",  getDirofdept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b13","id_dirofdept=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZr_doc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zr_doc_code",  getZr_doc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_zr_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZr_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zr_doc_name",  getZr_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_zr_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_phy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_phy_code",  getEmp_phy_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_emp_phy=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_phy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_phy_name",  getEmp_phy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_emp_phy=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_nur_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_nur_code",  getEmp_nur_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_emp_nur=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_nur_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_nur_name",  getEmp_nur_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_emp_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZz_doc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zz_doc_code",  getZz_doc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_zz_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZz_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zz_doc_name",  getZz_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_zz_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZy_doc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zy_doc_code",  getZy_doc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b18","id_zy_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZy_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zy_doc_name",  getZy_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b18","id_zy_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLearn_doc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Learn_doc_code",  getLearn_doc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b19","id_learn_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLearn_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Learn_doc_name",  getLearn_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b19","id_learn_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntern_doc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intern_doc_code",  getIntern_doc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_intern_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntern_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intern_doc_name",  getIntern_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_intern_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQcp_doc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qcp_doc_code",  getQcp_doc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_qcp_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQcp_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qcp_doc_name",  getQcp_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_qcp_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQcp_nur_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qcp_nur_code",  getQcp_nur_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_qcp_nur=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQcp_nur_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qcp_nur_name",  getQcp_nur_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_qcp_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCoder_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coder_code",  getCoder_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b23","id_coder=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCoder_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coder_name",  getCoder_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b23","id_coder=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cipathtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cipathtype",  getCode_cipathtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_cipathtype=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cipathtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cipathtype",  getName_cipathtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_cipathtype=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSelectedtextADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Selectedtext",  getSelectedtextCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_usecmp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSelectedvalueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Selectedvalue",  getSelectedvalueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_usecmp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsecme_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usecme_code",  getUsecme_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_usecme=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsecme_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usecme_name",  getUsecme_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_usecme=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsecmdt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usecmdt_code",  getUsecmdt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_usecmdt=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsecmdt_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usecmdt_name",  getUsecmdt_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_usecmdt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDnur_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dnur_code",  getDnur_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_dnur=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDnur_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dnur_name",  getDnur_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_dnur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIioutreason_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iioutreason_name",  getIioutreason_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b6","id_iioutreason=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIioutreaso_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iioutreaso_code",  getIioutreaso_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b6","id_iioutreason=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDipathology_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dipathology_code",  getDipathology_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b7","id_dipathology=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDipathology_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dipathology_name",  getDipathology_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b7","id_dipathology=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHightestdi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hightestdi_name",  getHightestdi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_hightestdi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHightestdi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hightestdi_code",  getHightestdi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_hightestdi=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_lev_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_lev_code",  getNur_lev_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_nur_lev=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_lev_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_lev_name",  getNur_lev_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_nur_lev=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInpath_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inpath_code",  getInpath_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_inpathstatus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInpath_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inpath_name",  getInpath_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_inpathstatus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplete_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complete_code",  getComplete_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_completestatus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplete_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complete_name",  getComplete_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_completestatus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVariation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Variation_code",  getVariation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_variationstaus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVariation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Variation_name",  getVariation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_variationstaus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeam_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Team_code",  getTeam_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b28","id_team_doc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeam_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Team_name",  getTeam_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b28","id_team_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getByediag_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Byediag_code",  getByediag_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b30","id_byediag=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getByediag_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Byediag_name",  getByediag_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b30","id_byediag=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInhos_di_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_di_name",  getInhos_di_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b31","id_inhos_di=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInhos_di_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_di_code",  getInhos_di_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b31","id_inhos_di=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDipathology_2_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dipathology_2_name",  getDipathology_2_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b32","id_dipathology_2=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDipathology_2_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dipathology_2_code",  getDipathology_2_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b32","id_dipathology_2=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病案首页其他信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cimrfpotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cimrfpother");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病案首页其他信息ID"); 
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
	 * 获取病案首页主表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案首页主表id"); 
		return column;
	}
	/**
	 * 获取有无药物过敏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drug_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug_allergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有无药物过敏"); 
		return column;
	}
	/**
	 * 获取有无药物过敏名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drug_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drug_allergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有无药物过敏名称"); 
		return column;
	}
	/**
	 * 获取过敏药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllergic_drugsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allergic_drugs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏药物"); 
		return column;
	}
	/**
	 * 获取血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型"); 
		return column;
	}
	/**
	 * 获取血型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型名称"); 
		return column;
	}
	/**
	 * 获取RH血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rh_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rh_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("RH血型"); 
		return column;
	}
	/**
	 * 获取RH血型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rh_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rh_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("RH血型名称"); 
		return column;
	}
	/**
	 * 获取科主任表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dirofdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任"); 
		return column;
	}
	/**
	 * 获取科主任(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dirofdept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任(id)"); 
		return column;
	}
	/**
	 * 获取科主任(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dirofdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任(sd)"); 
		return column;
	}
	/**
	 * 获取主任（副主任）医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zr_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任（副主任）医师"); 
		return column;
	}
	/**
	 * 获取主任（副主任）医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_zr_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任（副主任）医师(sd)"); 
		return column;
	}
	/**
	 * 获取主任（副主任）医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_zr_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任（副主任）医师(id)"); 
		return column;
	}
	/**
	 * 获取主诊医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主诊医师"); 
		return column;
	}
	/**
	 * 获取主诊医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主诊医师(id)"); 
		return column;
	}
	/**
	 * 获取主诊医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主诊医师(sd)"); 
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
	 * 获取责任护士(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士(id)"); 
		return column;
	}
	/**
	 * 获取责任护士(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士(sd)"); 
		return column;
	}
	/**
	 * 获取主治医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zz_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医师"); 
		return column;
	}
	/**
	 * 获取主治医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_zz_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医师(id)"); 
		return column;
	}
	/**
	 * 获取主治医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_zz_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医师(sd)"); 
		return column;
	}
	/**
	 * 获取住院医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zy_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医师"); 
		return column;
	}
	/**
	 * 获取住院医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_zy_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医师(id)"); 
		return column;
	}
	/**
	 * 获取住院医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_zy_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医师(sd)"); 
		return column;
	}
	/**
	 * 获取进修医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_learn_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_learn_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进修医师"); 
		return column;
	}
	/**
	 * 获取进修医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_learn_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_learn_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进修医师(id)"); 
		return column;
	}
	/**
	 * 获取进修医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_learn_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_learn_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进修医师(sd)"); 
		return column;
	}
	/**
	 * 获取实习医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_intern_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intern_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习医师"); 
		return column;
	}
	/**
	 * 获取实习医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intern_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intern_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习医师(id)"); 
		return column;
	}
	/**
	 * 获取实习医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intern_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intern_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习医师(sd)"); 
		return column;
	}
	/**
	 * 获取质控医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qcp_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师"); 
		return column;
	}
	/**
	 * 获取质控医师(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qcp_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师(id)"); 
		return column;
	}
	/**
	 * 获取质控医师(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qcp_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师(sd)"); 
		return column;
	}
	/**
	 * 获取质控护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qcp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士"); 
		return column;
	}
	/**
	 * 获取质控护士(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qcp_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士(id)"); 
		return column;
	}
	/**
	 * 获取质控护士(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qcp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士(sd)"); 
		return column;
	}
	/**
	 * 获取编码员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_coderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_coder");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码员"); 
		return column;
	}
	/**
	 * 获取编码员(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_coderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_coder");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码员(id)"); 
		return column;
	}
	/**
	 * 获取编码员(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_coderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_coder");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码员(sd)"); 
		return column;
	}
	/**
	 * 获取病案质量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qom_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qom_record");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案质量"); 
		return column;
	}
	/**
	 * 获取病案质量名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qom_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qom_record");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案质量名称"); 
		return column;
	}
	/**
	 * 获取质控日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQc_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qc_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("质控日期"); 
		return column;
	}
	/**
	 * 获取病理号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_pathoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_patho");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理号"); 
		return column;
	}
	/**
	 * 获取离院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_hos_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_hos_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院方式"); 
		return column;
	}
	/**
	 * 获取离院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_out_hos_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_out_hos_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院方式编码"); 
		return column;
	}
	/**
	 * 获取离院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_out_hos_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_hos_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院方式名称"); 
		return column;
	}
	/**
	 * 获取医嘱转院_转入医疗机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_med_in_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_med_in_1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱转院_转入医疗机构名称"); 
		return column;
	}
	/**
	 * 获取医嘱转社区_转入医疗机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_med_in_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_med_in_2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱转社区_转入医疗机构名称"); 
		return column;
	}
	/**
	 * 获取死亡患者尸检表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aut_dead_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aut_dead_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡患者尸检"); 
		return column;
	}
	/**
	 * 获取死亡患者尸检名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_aut_dead_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_aut_dead_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡患者尸检名称"); 
		return column;
	}
	/**
	 * 获取是否有出院31天内再住院的计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_is_have_inhos_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_is_have_inhos_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有出院31天内再住院的计划"); 
		return column;
	}
	/**
	 * 获取是否有出院31天内再住院的计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_is_have_inhos_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_is_have_inhos_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有出院31天内再住院的计划名称"); 
		return column;
	}
	/**
	 * 获取再次入院目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGoal_inhos_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Goal_inhos_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("再次入院目的"); 
		return column;
	}
	/**
	 * 获取昏迷时间（颅脑损伤患者）入院前 天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_bef_inhos_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_bef_inhos_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间（颅脑损伤患者）入院前 天数"); 
		return column;
	}
	/**
	 * 获取昏迷时间（颅脑损伤患者）入院前 小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_bef_inhos_hoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_bef_inhos_hours");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间（颅脑损伤患者）入院前 小时"); 
		return column;
	}
	/**
	 * 获取昏迷时间（颅脑损伤患者）入院前 分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_bef_inhos_minsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_bef_inhos_mins");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间（颅脑损伤患者）入院前 分钟"); 
		return column;
	}
	/**
	 * 获取昏迷时间入院后 天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_inhos_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_inhos_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间入院后 天数"); 
		return column;
	}
	/**
	 * 获取昏迷时间入院后 小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_inhos_hoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_inhos_hours");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间入院后 小时"); 
		return column;
	}
	/**
	 * 获取昏迷时间入院后 分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_inhos_minsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_inhos_mins");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间入院后 分钟"); 
		return column;
	}
	/**
	 * 获取呼吸机使用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVentilator_use_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ventilator_use_time");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸机使用时间"); 
		return column;
	}
	/**
	 * 获取肿瘤分期T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTumor_grade_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tumor_grade_t");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肿瘤分期T"); 
		return column;
	}
	/**
	 * 获取肿瘤分期N表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTumor_grade_nCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tumor_grade_n");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肿瘤分期N"); 
		return column;
	}
	/**
	 * 获取肿瘤分期M表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTumor_grade_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tumor_grade_m");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肿瘤分期M"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表得分入院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_score_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_score_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表得分入院"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表得分出院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_score_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_score_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表得分出院"); 
		return column;
	}
	/**
	 * 获取实施临床路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cipathtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cipathtype");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实施临床路径"); 
		return column;
	}
	/**
	 * 获取是否使用医疗机构中药制剂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usecmpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usecmp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否使用医疗机构中药制剂"); 
		return column;
	}
	/**
	 * 获取是否使用中医诊疗设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usecmeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usecme");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否使用中医诊疗设备"); 
		return column;
	}
	/**
	 * 获取是否使用中医诊疗技术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usecmdtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usecmdt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否使用中医诊疗技术"); 
		return column;
	}
	/**
	 * 获取辩证施护表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dnur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辩证施护"); 
		return column;
	}
	/**
	 * 获取损伤、中毒的外部原因（id）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_iioutreasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_iioutreason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("损伤、中毒的外部原因（id）"); 
		return column;
	}
	/**
	 * 获取损伤、中毒的外部原因（sd）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_iioutreasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_iioutreason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("损伤、中毒的外部原因（sd）"); 
		return column;
	}
	/**
	 * 获取损伤、中毒的外部原因（name）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_iioutreasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_iioutreason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("损伤、中毒的外部原因（name）"); 
		return column;
	}
	/**
	 * 获取病理诊断（id）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dipathologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dipathology");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理诊断（id）"); 
		return column;
	}
	/**
	 * 获取病理诊断（sd）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dipathologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dipathology");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理诊断（sd）"); 
		return column;
	}
	/**
	 * 获取病理诊断（name）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dipathologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dipathology");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理诊断（name）"); 
		return column;
	}
	/**
	 * 获取displaynam60表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef0CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def0");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam60"); 
		return column;
	}
	/**
	 * 获取displaynam61表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam61"); 
		return column;
	}
	/**
	 * 获取displaynam62表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam62"); 
		return column;
	}
	/**
	 * 获取displaynam63表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam63"); 
		return column;
	}
	/**
	 * 获取displaynam64表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam64"); 
		return column;
	}
	/**
	 * 获取displaynam65表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam65"); 
		return column;
	}
	/**
	 * 获取displaynam66表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam66"); 
		return column;
	}
	/**
	 * 获取displaynam67表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam67"); 
		return column;
	}
	/**
	 * 获取displaynam68表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam68"); 
		return column;
	}
	/**
	 * 获取displaynam69表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam69"); 
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
	 * 获取最高诊断依据id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hightestdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hightestdi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断依据id"); 
		return column;
	}
	/**
	 * 获取最高诊断依据sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hightestdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hightestdi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断依据sd"); 
		return column;
	}
	/**
	 * 获取最高诊断依据name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hightestdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hightestdi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断依据name"); 
		return column;
	}
	/**
	 * 获取护理级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_levCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_lev");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理级别"); 
		return column;
	}
	/**
	 * 获取护理级别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_levCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_lev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理级别名称"); 
		return column;
	}
	/**
	 * 获取入径情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inpathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inpathstatus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入径情况id"); 
		return column;
	}
	/**
	 * 获取入径情况sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inpathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inpathstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入径情况sd"); 
		return column;
	}
	/**
	 * 获取入径情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inpathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inpathstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入径情况名称"); 
		return column;
	}
	/**
	 * 获取完成情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_completestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_completestatus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成情况id"); 
		return column;
	}
	/**
	 * 获取完成情况sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_completestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_completestatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成情况sd"); 
		return column;
	}
	/**
	 * 获取完成情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_completestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_completestatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成情况名称"); 
		return column;
	}
	/**
	 * 获取变异情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_variationstausCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_variationstaus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异情况id"); 
		return column;
	}
	/**
	 * 获取变异情况sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_variationstausCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_variationstaus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异情况sd"); 
		return column;
	}
	/**
	 * 获取变异情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_variationstausCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_variationstaus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异情况名称"); 
		return column;
	}
	/**
	 * 获取医疗组长(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_team_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_team_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗组长(id)"); 
		return column;
	}
	/**
	 * 获取医疗组长(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_team_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_team_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗组长(sd)"); 
		return column;
	}
	/**
	 * 获取医疗组长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_team_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_team_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗组长"); 
		return column;
	}
	/**
	 * 获取特级护理天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuperlev_nur_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Superlev_nur_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("特级护理天数"); 
		return column;
	}
	/**
	 * 获取一级护理天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOnelev_nur_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Onelev_nur_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("一级护理天数"); 
		return column;
	}
	/**
	 * 获取二级护理天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTwolev_nur_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Twolev_nur_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("二级护理天数"); 
		return column;
	}
	/**
	 * 获取三级护理天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThreelev_nur_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Threelev_nur_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("三级护理天数"); 
		return column;
	}
	/**
	 * 获取ICD-O-3编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_icdo3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_icdo3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICD-O-3编码"); 
		return column;
	}
	/**
	 * 获取西医出院诊断-主要诊断疾病id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_byediagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_byediag");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医出院诊断-主要诊断疾病id"); 
		return column;
	}
	/**
	 * 获取西医出院诊断-主要诊断疾病code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_byediagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_byediag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医出院诊断-主要诊断疾病code"); 
		return column;
	}
	/**
	 * 获取西医出院诊断-主要诊断疾病name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_byediagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_byediag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医出院诊断-主要诊断疾病name"); 
		return column;
	}
	/**
	 * 获取中医出院诊断_主病id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cm_mainillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cm_mainill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医出院诊断_主病id"); 
		return column;
	}
	/**
	 * 获取中医出院诊断_主病code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cm_mainillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cm_mainill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医出院诊断_主病code"); 
		return column;
	}
	/**
	 * 获取中医出院诊断_主病name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cm_mainillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cm_mainill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医出院诊断_主病name"); 
		return column;
	}
	/**
	 * 获取中医出院诊断_主症id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cm_mainsymCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cm_mainsym");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医出院诊断_主症id"); 
		return column;
	}
	/**
	 * 获取中医出院诊断_主症code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cm_mainsymCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cm_mainsym");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医出院诊断_主症code"); 
		return column;
	}
	/**
	 * 获取中医出院诊断_主症name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cm_mainsymCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cm_mainsym");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医出院诊断_主症name"); 
		return column;
	}
	/**
	 * 获取科主任_执业证书编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCertcode_dirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certcode_dirofdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任_执业证书编码"); 
		return column;
	}
	/**
	 * 获取主任（副主任）医师_执业证书编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCertcode_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certcode_zr_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任（副主任）医师_执业证书编码"); 
		return column;
	}
	/**
	 * 获取主治医师_执业证书编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCertcode_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certcode_zz_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医师_执业证书编码"); 
		return column;
	}
	/**
	 * 获取住院医师_执业证书编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCertcode_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certcode_zy_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医师_执业证书编码"); 
		return column;
	}
	/**
	 * 获取责任护士_执业证书编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCertcode_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Certcode_emp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士_执业证书编码"); 
		return column;
	}
	/**
	 * 获取出院情况描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_hos_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_hos_situation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院情况描述"); 
		return column;
	}
	/**
	 * 获取入院诊断id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inhos_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inhos_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断id"); 
		return column;
	}
	/**
	 * 获取入院诊断code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inhos_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inhos_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断code"); 
		return column;
	}
	/**
	 * 获取入院诊断name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inhos_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inhos_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断name"); 
		return column;
	}
	/**
	 * 获取入院后确诊日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_inhos_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_inhos_di");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院后确诊日期"); 
		return column;
	}
	/**
	 * 获取病理号2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_patho_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_patho_2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理号2"); 
		return column;
	}
	/**
	 * 获取病理诊断2id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dipathology_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dipathology_2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理诊断2id"); 
		return column;
	}
	/**
	 * 获取病理诊断2code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dipathology_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dipathology_2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理诊断2code"); 
		return column;
	}
	/**
	 * 获取病理诊断2name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dipathology_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dipathology_2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理诊断2name"); 
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
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDirofdept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dirofdept_code");
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
	private IColumnDesc getDirofdept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dirofdept_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZr_doc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zr_doc_code");
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
	private IColumnDesc getZr_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zr_doc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_phy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_phy_code");
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
	private IColumnDesc getEmp_phy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_phy_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_nur_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_nur_code");
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
	private IColumnDesc getEmp_nur_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_nur_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZz_doc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zz_doc_code");
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
	private IColumnDesc getZz_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zz_doc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZy_doc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zy_doc_code");
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
	private IColumnDesc getZy_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zy_doc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLearn_doc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Learn_doc_code");
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
	private IColumnDesc getLearn_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Learn_doc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntern_doc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intern_doc_code");
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
	private IColumnDesc getIntern_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intern_doc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQcp_doc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qcp_doc_code");
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
	private IColumnDesc getQcp_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qcp_doc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQcp_nur_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qcp_nur_code");
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
	private IColumnDesc getQcp_nur_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qcp_nur_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCoder_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coder_code");
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
	private IColumnDesc getCoder_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coder_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cipathtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cipathtype");
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
	private IColumnDesc getName_cipathtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cipathtype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSelectedtextCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Selectedtext");
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
	private IColumnDesc getSelectedvalueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Selectedvalue");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsecme_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usecme_code");
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
	private IColumnDesc getUsecme_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usecme_name");
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
	private IColumnDesc getUsecmdt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usecmdt_code");
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
	private IColumnDesc getUsecmdt_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usecmdt_name");
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
	private IColumnDesc getDnur_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dnur_code");
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
	private IColumnDesc getDnur_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dnur_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIioutreason_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iioutreason_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIioutreaso_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iioutreaso_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDipathology_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dipathology_code");
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
	private IColumnDesc getDipathology_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dipathology_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHightestdi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hightestdi_name");
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
	private IColumnDesc getHightestdi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hightestdi_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_lev_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_lev_code");
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
	private IColumnDesc getNur_lev_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_lev_name");
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
	private IColumnDesc getInpath_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inpath_code");
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
	private IColumnDesc getInpath_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inpath_name");
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
	private IColumnDesc getComplete_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complete_code");
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
	private IColumnDesc getComplete_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complete_name");
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
	private IColumnDesc getVariation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Variation_code");
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
	private IColumnDesc getVariation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Variation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTeam_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Team_code");
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
	private IColumnDesc getTeam_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Team_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getByediag_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Byediag_code");
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
	private IColumnDesc getByediag_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Byediag_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_di_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_di_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_di_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_di_code");
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
	private IColumnDesc getDipathology_2_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dipathology_2_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDipathology_2_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dipathology_2_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
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
