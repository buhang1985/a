
package iih.nmr.pkuf.surgpathandover.d.desc;

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
 * 手术患者交接记录单 DO 元数据信息
 */
public class SurgPatHandoverDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.surgpathandover.d.SurgPatHandoverDO";
	public static final String CLASS_DISPALYNAME = "手术患者交接记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_SURGPATHANDOVER";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_surgpat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SurgPatHandoverDODesc(){
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
		this.setKeyDesc(getId_surgpatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_surgpatADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getDt_receADesc(tblDesc));
		this.add(getId_operationADesc(tblDesc));
		this.add(getId_preo_markADesc(tblDesc));
		this.add(getSd_preo_markADesc(tblDesc));
		this.add(getId_preo_siteADesc(tblDesc));
		this.add(getSd_preo_siteADesc(tblDesc));
		this.add(getId_preo_consciousADesc(tblDesc));
		this.add(getSd_preo_consciousADesc(tblDesc));
		this.add(getPreo_tADesc(tblDesc));
		this.add(getPreo_pADesc(tblDesc));
		this.add(getPreo_rADesc(tblDesc));
		this.add(getPreo_spo2ADesc(tblDesc));
		this.add(getPreo_int_sbpADesc(tblDesc));
		this.add(getPreo_int_dbpADesc(tblDesc));
		this.add(getId_preparADesc(tblDesc));
		this.add(getSd_preparADesc(tblDesc));
		this.add(getId_preo_pipeADesc(tblDesc));
		this.add(getSd_preo_pipeADesc(tblDesc));
		this.add(getId_preo_unob_pipADesc(tblDesc));
		this.add(getSd_preo_unob_pipADesc(tblDesc));
		this.add(getId_preo_articlesADesc(tblDesc));
		this.add(getSd_preo_articlesADesc(tblDesc));
		this.add(getPreo_drug_informADesc(tblDesc));
		this.add(getId_preo_allerADesc(tblDesc));
		this.add(getSd_preo_allerADesc(tblDesc));
		this.add(getPreo_batchADesc(tblDesc));
		this.add(getPreo_goods_othADesc(tblDesc));
		this.add(getId_preo_his_allerADesc(tblDesc));
		this.add(getSd_preo_his_allerADesc(tblDesc));
		this.add(getPreo_sit_allerADesc(tblDesc));
		this.add(getId_preo_infusADesc(tblDesc));
		this.add(getSd_preo_infusADesc(tblDesc));
		this.add(getPreo_infus_sitADesc(tblDesc));
		this.add(getId_preo_infus_unobADesc(tblDesc));
		this.add(getSd_preo_infus_unobADesc(tblDesc));
		this.add(getId_preo_infus_toolADesc(tblDesc));
		this.add(getSd_preo_infus_toolADesc(tblDesc));
		this.add(getPreo_tool_othADesc(tblDesc));
		this.add(getId_preo_skinADesc(tblDesc));
		this.add(getSd_preo_skinADesc(tblDesc));
		this.add(getPreo_stagesADesc(tblDesc));
		this.add(getPreo_positionADesc(tblDesc));
		this.add(getPreo_spe_handADesc(tblDesc));
		this.add(getId_preo_nurADesc(tblDesc));
		this.add(getFami_patADesc(tblDesc));
		this.add(getId_preo_oper_nurADesc(tblDesc));
		this.add(getDt_enterADesc(tblDesc));
		this.add(getId_intra_consciousADesc(tblDesc));
		this.add(getSd_intra_consciousADesc(tblDesc));
		this.add(getId_intra_articlesADesc(tblDesc));
		this.add(getSd_intra_articlesADesc(tblDesc));
		this.add(getIntra_articles_othADesc(tblDesc));
		this.add(getId_intra_markADesc(tblDesc));
		this.add(getSd_intra_markADesc(tblDesc));
		this.add(getId_intra_siteADesc(tblDesc));
		this.add(getSd_intra_siteADesc(tblDesc));
		this.add(getIntra_site_othADesc(tblDesc));
		this.add(getId_intra_pipeADesc(tblDesc));
		this.add(getSd_intra_pipeADesc(tblDesc));
		this.add(getId_intra_unob_pipADesc(tblDesc));
		this.add(getSd_intra_unob_pipADesc(tblDesc));
		this.add(getId_intra_skinADesc(tblDesc));
		this.add(getSd_intra_skinADesc(tblDesc));
		this.add(getIntra_stagesADesc(tblDesc));
		this.add(getIntra_positionADesc(tblDesc));
		this.add(getIntra_tADesc(tblDesc));
		this.add(getIntra_pADesc(tblDesc));
		this.add(getIntra_rADesc(tblDesc));
		this.add(getIntra_spo2ADesc(tblDesc));
		this.add(getIntra_int_sbpsADesc(tblDesc));
		this.add(getIntra_int_dbpsADesc(tblDesc));
		this.add(getDt_oper_endADesc(tblDesc));
		this.add(getId_anesthesADesc(tblDesc));
		this.add(getId_surgeonADesc(tblDesc));
		this.add(getId_intra_oper_nurADesc(tblDesc));
		this.add(getId_send_bakeADesc(tblDesc));
		this.add(getSd_send_bakeADesc(tblDesc));
		this.add(getDt_sendADesc(tblDesc));
		this.add(getPos_tADesc(tblDesc));
		this.add(getPos_pADesc(tblDesc));
		this.add(getPos_rADesc(tblDesc));
		this.add(getPos_spo2ADesc(tblDesc));
		this.add(getPos_int_sbpsADesc(tblDesc));
		this.add(getPos_int_dbpsADesc(tblDesc));
		this.add(getId_pat_conditionADesc(tblDesc));
		this.add(getSd_pat_conditionADesc(tblDesc));
		this.add(getId_pos_infusADesc(tblDesc));
		this.add(getSd_pos_infusADesc(tblDesc));
		this.add(getPos_infus_sitADesc(tblDesc));
		this.add(getId_pos_infus_unobADesc(tblDesc));
		this.add(getSd_pos_infus_unobADesc(tblDesc));
		this.add(getPreo_pipe_condADesc(tblDesc));
		this.add(getIntra_pipe_condADesc(tblDesc));
		this.add(getId_pos_infus_toolADesc(tblDesc));
		this.add(getSd_pos_infus_toolADesc(tblDesc));
		this.add(getPos_tool_othADesc(tblDesc));
		this.add(getBring_drugADesc(tblDesc));
		this.add(getId_pos_articlesADesc(tblDesc));
		this.add(getSd_pos_articlesADesc(tblDesc));
		this.add(getPos_articles_othADesc(tblDesc));
		this.add(getNum_specimenADesc(tblDesc));
		this.add(getId_pos_tubeADesc(tblDesc));
		this.add(getSd_pos_tubeADesc(tblDesc));
		this.add(getPos_tube_sitADesc(tblDesc));
		this.add(getId_pos_tube_unobADesc(tblDesc));
		this.add(getSd_pos_tube_unobADesc(tblDesc));
		this.add(getId_inci_dresADesc(tblDesc));
		this.add(getSd_inci_dresADesc(tblDesc));
		this.add(getId_pos_skinADesc(tblDesc));
		this.add(getSd_pos_skinADesc(tblDesc));
		this.add(getPos_stagesADesc(tblDesc));
		this.add(getPos_positionADesc(tblDesc));
		this.add(getPos_spe_handADesc(tblDesc));
		this.add(getId_oper_pos_nurADesc(tblDesc));
		this.add(getId_pos_anesthesADesc(tblDesc));
		this.add(getId_receiv_docADesc(tblDesc));
		this.add(getId_receiv_nurADesc(tblDesc));
		this.add(getId_preo_by_stagesADesc(tblDesc));
		this.add(getSd_preo_by_stagesADesc(tblDesc));
		this.add(getId_inter_by_stagesADesc(tblDesc));
		this.add(getSd_inter_by_stagesADesc(tblDesc));
		this.add(getId_pos_by_stagesADesc(tblDesc));
		this.add(getSd_pos_by_stagesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_operationADesc(tblDesc));
		this.add(getName_preo_markADesc(tblDesc));
		this.add(getName_preo_siteADesc(tblDesc));
		this.add(getName_preo_consciousADesc(tblDesc));
		this.add(getName_preparADesc(tblDesc));
		this.add(getName_preo_pipeADesc(tblDesc));
		this.add(getName_preo_unob_pipADesc(tblDesc));
		this.add(getName_preo_articlesADesc(tblDesc));
		this.add(getName_preo_allerADesc(tblDesc));
		this.add(getName_preo_his_allerADesc(tblDesc));
		this.add(getName_preo_infusADesc(tblDesc));
		this.add(getName_preo_infus_unobADesc(tblDesc));
		this.add(getName_preo_infus_toolADesc(tblDesc));
		this.add(getName_preo_skinADesc(tblDesc));
		this.add(getName_preo_nurADesc(tblDesc));
		this.add(getName_preo_oper_nurADesc(tblDesc));
		this.add(getName_intra_consciousADesc(tblDesc));
		this.add(getName_intra_articlesADesc(tblDesc));
		this.add(getName_intra_markADesc(tblDesc));
		this.add(getName_intra_siteADesc(tblDesc));
		this.add(getName_intra_pipeADesc(tblDesc));
		this.add(getName_intra_unob_pipADesc(tblDesc));
		this.add(getName_intra_skinADesc(tblDesc));
		this.add(getName_anesthesADesc(tblDesc));
		this.add(getName_surgeonADesc(tblDesc));
		this.add(getName_intra_oper_nurADesc(tblDesc));
		this.add(getName_send_bakeADesc(tblDesc));
		this.add(getName_pat_conditionADesc(tblDesc));
		this.add(getName_pos_infusADesc(tblDesc));
		this.add(getName_pos_infus_unobADesc(tblDesc));
		this.add(getName_pos_infus_toolADesc(tblDesc));
		this.add(getName_pos_articlesADesc(tblDesc));
		this.add(getName_pos_tubeADesc(tblDesc));
		this.add(getName_pos_tube_unobADesc(tblDesc));
		this.add(getName_inci_dresADesc(tblDesc));
		this.add(getName_pos_skinADesc(tblDesc));
		this.add(getName_oper_pos_nurADesc(tblDesc));
		this.add(getName_pos_anesthesADesc(tblDesc));
		this.add(getName_receiv_docADesc(tblDesc));
		this.add(getName_receiv_nurADesc(tblDesc));
		this.add(getName_preo_by_stagesADesc(tblDesc));
		this.add(getName_inter_by_stagesADesc(tblDesc));
		this.add(getName_pos_by_stagesADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_surgpatCDesc(tblDesc));
		tblDesc.add(getId_surgpatCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getDt_receCDesc(tblDesc));
		tblDesc.add(getId_operationCDesc(tblDesc));
		tblDesc.add(getId_preo_markCDesc(tblDesc));
		tblDesc.add(getSd_preo_markCDesc(tblDesc));
		tblDesc.add(getId_preo_siteCDesc(tblDesc));
		tblDesc.add(getSd_preo_siteCDesc(tblDesc));
		tblDesc.add(getId_preo_consciousCDesc(tblDesc));
		tblDesc.add(getSd_preo_consciousCDesc(tblDesc));
		tblDesc.add(getPreo_tCDesc(tblDesc));
		tblDesc.add(getPreo_pCDesc(tblDesc));
		tblDesc.add(getPreo_rCDesc(tblDesc));
		tblDesc.add(getPreo_spo2CDesc(tblDesc));
		tblDesc.add(getPreo_int_sbpCDesc(tblDesc));
		tblDesc.add(getPreo_int_dbpCDesc(tblDesc));
		tblDesc.add(getId_preparCDesc(tblDesc));
		tblDesc.add(getSd_preparCDesc(tblDesc));
		tblDesc.add(getId_preo_pipeCDesc(tblDesc));
		tblDesc.add(getSd_preo_pipeCDesc(tblDesc));
		tblDesc.add(getId_preo_unob_pipCDesc(tblDesc));
		tblDesc.add(getSd_preo_unob_pipCDesc(tblDesc));
		tblDesc.add(getId_preo_articlesCDesc(tblDesc));
		tblDesc.add(getSd_preo_articlesCDesc(tblDesc));
		tblDesc.add(getPreo_drug_informCDesc(tblDesc));
		tblDesc.add(getId_preo_allerCDesc(tblDesc));
		tblDesc.add(getSd_preo_allerCDesc(tblDesc));
		tblDesc.add(getPreo_batchCDesc(tblDesc));
		tblDesc.add(getPreo_goods_othCDesc(tblDesc));
		tblDesc.add(getId_preo_his_allerCDesc(tblDesc));
		tblDesc.add(getSd_preo_his_allerCDesc(tblDesc));
		tblDesc.add(getPreo_sit_allerCDesc(tblDesc));
		tblDesc.add(getId_preo_infusCDesc(tblDesc));
		tblDesc.add(getSd_preo_infusCDesc(tblDesc));
		tblDesc.add(getPreo_infus_sitCDesc(tblDesc));
		tblDesc.add(getId_preo_infus_unobCDesc(tblDesc));
		tblDesc.add(getSd_preo_infus_unobCDesc(tblDesc));
		tblDesc.add(getId_preo_infus_toolCDesc(tblDesc));
		tblDesc.add(getSd_preo_infus_toolCDesc(tblDesc));
		tblDesc.add(getPreo_tool_othCDesc(tblDesc));
		tblDesc.add(getId_preo_skinCDesc(tblDesc));
		tblDesc.add(getSd_preo_skinCDesc(tblDesc));
		tblDesc.add(getPreo_stagesCDesc(tblDesc));
		tblDesc.add(getPreo_positionCDesc(tblDesc));
		tblDesc.add(getPreo_spe_handCDesc(tblDesc));
		tblDesc.add(getId_preo_nurCDesc(tblDesc));
		tblDesc.add(getFami_patCDesc(tblDesc));
		tblDesc.add(getId_preo_oper_nurCDesc(tblDesc));
		tblDesc.add(getDt_enterCDesc(tblDesc));
		tblDesc.add(getId_intra_consciousCDesc(tblDesc));
		tblDesc.add(getSd_intra_consciousCDesc(tblDesc));
		tblDesc.add(getId_intra_articlesCDesc(tblDesc));
		tblDesc.add(getSd_intra_articlesCDesc(tblDesc));
		tblDesc.add(getIntra_articles_othCDesc(tblDesc));
		tblDesc.add(getId_intra_markCDesc(tblDesc));
		tblDesc.add(getSd_intra_markCDesc(tblDesc));
		tblDesc.add(getId_intra_siteCDesc(tblDesc));
		tblDesc.add(getSd_intra_siteCDesc(tblDesc));
		tblDesc.add(getIntra_site_othCDesc(tblDesc));
		tblDesc.add(getId_intra_pipeCDesc(tblDesc));
		tblDesc.add(getSd_intra_pipeCDesc(tblDesc));
		tblDesc.add(getId_intra_unob_pipCDesc(tblDesc));
		tblDesc.add(getSd_intra_unob_pipCDesc(tblDesc));
		tblDesc.add(getId_intra_skinCDesc(tblDesc));
		tblDesc.add(getSd_intra_skinCDesc(tblDesc));
		tblDesc.add(getIntra_stagesCDesc(tblDesc));
		tblDesc.add(getIntra_positionCDesc(tblDesc));
		tblDesc.add(getIntra_tCDesc(tblDesc));
		tblDesc.add(getIntra_pCDesc(tblDesc));
		tblDesc.add(getIntra_rCDesc(tblDesc));
		tblDesc.add(getIntra_spo2CDesc(tblDesc));
		tblDesc.add(getIntra_int_sbpsCDesc(tblDesc));
		tblDesc.add(getIntra_int_dbpsCDesc(tblDesc));
		tblDesc.add(getDt_oper_endCDesc(tblDesc));
		tblDesc.add(getId_anesthesCDesc(tblDesc));
		tblDesc.add(getId_surgeonCDesc(tblDesc));
		tblDesc.add(getId_intra_oper_nurCDesc(tblDesc));
		tblDesc.add(getId_send_bakeCDesc(tblDesc));
		tblDesc.add(getSd_send_bakeCDesc(tblDesc));
		tblDesc.add(getDt_sendCDesc(tblDesc));
		tblDesc.add(getPos_tCDesc(tblDesc));
		tblDesc.add(getPos_pCDesc(tblDesc));
		tblDesc.add(getPos_rCDesc(tblDesc));
		tblDesc.add(getPos_spo2CDesc(tblDesc));
		tblDesc.add(getPos_int_sbpsCDesc(tblDesc));
		tblDesc.add(getPos_int_dbpsCDesc(tblDesc));
		tblDesc.add(getId_pat_conditionCDesc(tblDesc));
		tblDesc.add(getSd_pat_conditionCDesc(tblDesc));
		tblDesc.add(getId_pos_infusCDesc(tblDesc));
		tblDesc.add(getSd_pos_infusCDesc(tblDesc));
		tblDesc.add(getPos_infus_sitCDesc(tblDesc));
		tblDesc.add(getId_pos_infus_unobCDesc(tblDesc));
		tblDesc.add(getSd_pos_infus_unobCDesc(tblDesc));
		tblDesc.add(getPreo_pipe_condCDesc(tblDesc));
		tblDesc.add(getIntra_pipe_condCDesc(tblDesc));
		tblDesc.add(getId_pos_infus_toolCDesc(tblDesc));
		tblDesc.add(getSd_pos_infus_toolCDesc(tblDesc));
		tblDesc.add(getPos_tool_othCDesc(tblDesc));
		tblDesc.add(getBring_drugCDesc(tblDesc));
		tblDesc.add(getId_pos_articlesCDesc(tblDesc));
		tblDesc.add(getSd_pos_articlesCDesc(tblDesc));
		tblDesc.add(getPos_articles_othCDesc(tblDesc));
		tblDesc.add(getNum_specimenCDesc(tblDesc));
		tblDesc.add(getId_pos_tubeCDesc(tblDesc));
		tblDesc.add(getSd_pos_tubeCDesc(tblDesc));
		tblDesc.add(getPos_tube_sitCDesc(tblDesc));
		tblDesc.add(getId_pos_tube_unobCDesc(tblDesc));
		tblDesc.add(getSd_pos_tube_unobCDesc(tblDesc));
		tblDesc.add(getId_inci_dresCDesc(tblDesc));
		tblDesc.add(getSd_inci_dresCDesc(tblDesc));
		tblDesc.add(getId_pos_skinCDesc(tblDesc));
		tblDesc.add(getSd_pos_skinCDesc(tblDesc));
		tblDesc.add(getPos_stagesCDesc(tblDesc));
		tblDesc.add(getPos_positionCDesc(tblDesc));
		tblDesc.add(getPos_spe_handCDesc(tblDesc));
		tblDesc.add(getId_oper_pos_nurCDesc(tblDesc));
		tblDesc.add(getId_pos_anesthesCDesc(tblDesc));
		tblDesc.add(getId_receiv_docCDesc(tblDesc));
		tblDesc.add(getId_receiv_nurCDesc(tblDesc));
		tblDesc.add(getId_preo_by_stagesCDesc(tblDesc));
		tblDesc.add(getSd_preo_by_stagesCDesc(tblDesc));
		tblDesc.add(getId_inter_by_stagesCDesc(tblDesc));
		tblDesc.add(getSd_inter_by_stagesCDesc(tblDesc));
		tblDesc.add(getId_pos_by_stagesCDesc(tblDesc));
		tblDesc.add(getSd_pos_by_stagesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 记录单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_surgpatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_surgpat",  getId_surgpatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记录单主键");
		attrDesc.setNullable(true);
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
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 录入日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("录入日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
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
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
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
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断ID(通用)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断ID(通用)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断(通用)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断(通用)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接病人时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_receADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rece",  getDt_receCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("接病人时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟行手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operation",  getId_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟行手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前手术部位标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_mark",  getId_preo_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前手术部位标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前手术部位标识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_mark",  getSd_preo_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前手术部位标识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前手术部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_site",  getId_preo_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前手术部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前手术部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_site",  getSd_preo_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前手术部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_conscious",  getId_preo_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前意识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_conscious",  getSd_preo_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前意识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_t",  getPreo_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术前T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前P属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_pADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_p",  getPreo_pCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前P");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前R属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_rADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_r",  getPreo_rCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前R");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_spo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_spo2",  getPreo_spo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术前SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_int_sbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_int_sbp",  getPreo_int_sbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_int_dbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_int_dbp",  getPreo_int_dbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前准备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preparADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prepar",  getId_preparCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前准备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前准备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preparADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_prepar",  getSd_preparCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前准备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前留置管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_pipe",  getId_preo_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前留置管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前留置管路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_pipe",  getSd_preo_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前留置管路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前留置管路通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_unob_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_unob_pip",  getId_preo_unob_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前留置管路通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前留置管路通畅情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_unob_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_unob_pip",  getSd_preo_unob_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前留置管路通畅情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前携带物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_articles",  getId_preo_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前携带物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前携带物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_articles",  getSd_preo_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前携带物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前药品信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_drug_informADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_drug_inform",  getPreo_drug_informCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前药品信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前过敏试验属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_aller",  getId_preo_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前过敏试验");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前过敏试验编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_aller",  getSd_preo_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前过敏试验编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前批号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_batchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_batch",  getPreo_batchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前批号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前携带物品其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_goods_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_goods_oth",  getPreo_goods_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前携带物品其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_his_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_his_aller",  getId_preo_his_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前过敏史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_his_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_his_aller",  getSd_preo_his_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前过敏史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前过敏史情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_sit_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_sit_aller",  getPreo_sit_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前过敏史情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前输液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_infusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_infus",  getId_preo_infusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前输液编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_infusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_infus",  getSd_preo_infusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前输液情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_infus_sitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_infus_sit",  getPreo_infus_sitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前输液通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_infus_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_infus_unob",  getId_preo_infus_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前输液通畅情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_infus_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_infus_unob",  getSd_preo_infus_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液通畅情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前输液工具属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_infus_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_infus_tool",  getId_preo_infus_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液工具");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前输液工具编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_infus_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_infus_tool",  getSd_preo_infus_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液工具编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前输液工具其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_tool_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_tool_oth",  getPreo_tool_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前输液工具其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_skin",  getId_preo_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_skin",  getSd_preo_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前分期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_stages",  getPreo_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前分期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_position",  getPreo_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前特殊交接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_spe_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_spe_hand",  getPreo_spe_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前特殊交接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前科室护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_nur",  getId_preo_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前科室护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者/家属属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFami_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fami_pat",  getFami_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者/家属");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前手术室护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_oper_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_oper_nur",  getId_preo_oper_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前手术室护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入手术室时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_enterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_enter",  getDt_enterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入手术室时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_conscious",  getId_intra_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中意识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_conscious",  getSd_intra_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中意识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中携带物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_articles",  getId_intra_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中携带物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中携带物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_articles",  getSd_intra_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中携带物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中携带物品其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_articles_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_articles_oth",  getIntra_articles_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中携带物品其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中手术部位标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_mark",  getId_intra_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中手术部位标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中手术部位标识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_mark",  getSd_intra_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中手术部位标识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中手术部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_site",  getId_intra_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中手术部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中手术部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_site",  getSd_intra_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中手术部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中手术部位其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_site_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_site_oth",  getIntra_site_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中手术部位其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中留置管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_pipe",  getId_intra_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中留置管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中留置管路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_pipe",  getSd_intra_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中留置管路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中留置管路通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_unob_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_unob_pip",  getId_intra_unob_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中留置管路通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中留置管路通畅情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_unob_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_unob_pip",  getSd_intra_unob_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中留置管路通畅情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_skin",  getId_intra_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intra_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intra_skin",  getSd_intra_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中分期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_stages",  getIntra_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中分期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_position",  getIntra_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_t",  getIntra_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术中T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中P属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_pADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_p",  getIntra_pCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术中P");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中R属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_rADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_r",  getIntra_rCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术中R");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_spo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_spo2",  getIntra_spo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术中SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_int_sbpsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_int_sbps",  getIntra_int_sbpsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术中收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_int_dbpsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_int_dbps",  getIntra_int_dbpsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术中舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_oper_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper_end",  getDt_oper_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中麻醉医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anesthesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anesthes",  getId_anesthesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中麻醉医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_surgeonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_surgeon",  getId_surgeonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中手术室护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intra_oper_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intra_oper_nur",  getId_intra_oper_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中手术室护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后送回属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_send_bakeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_send_bake",  getId_send_bakeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后送回");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后送回编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_send_bakeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_send_bake",  getSd_send_bakeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后送回编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后送回时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_sendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_send",  getDt_sendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("术后送回时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_t",  getPos_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术后T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后P属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_pADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_p",  getPos_pCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后P");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后R属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_rADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_r",  getPos_rCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后R");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_spo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_spo2",  getPos_spo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术后SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_int_sbpsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_int_sbps",  getPos_int_sbpsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_int_dbpsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_int_dbps",  getPos_int_dbpsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_condition",  getId_pat_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病人情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_condition",  getSd_pat_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后输液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_infusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_infus",  getId_pos_infusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后输液编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_infusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_infus",  getSd_pos_infusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后输液情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_infus_sitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_infus_sit",  getPos_infus_sitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后输液通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_infus_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_infus_unob",  getId_pos_infus_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后输液通畅情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_infus_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_infus_unob",  getSd_pos_infus_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液通畅情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前留置管路情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreo_pipe_condADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preo_pipe_cond",  getPreo_pipe_condCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前留置管路情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中留置管路情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntra_pipe_condADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intra_pipe_cond",  getIntra_pipe_condCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中留置管路情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后输液工具属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_infus_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_infus_tool",  getId_pos_infus_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液工具");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后输液工具编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_infus_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_infus_tool",  getSd_pos_infus_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液工具编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后输液工具其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_tool_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_tool_oth",  getPos_tool_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后输液工具其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带回药品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBring_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bring_drug",  getBring_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带回药品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后携带物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_articles",  getId_pos_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后携带物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后携带物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_articles",  getSd_pos_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后携带物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后携带物品其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_articles_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_articles_oth",  getPos_articles_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后携带物品其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本份数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_specimenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_specimen",  getNum_specimenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("标本份数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后引流管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_tube",  getId_pos_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后引流管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后引流管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_tube",  getSd_pos_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后引流管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后引流管情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_tube_sitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_tube_sit",  getPos_tube_sitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后引流管情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后引流管通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_tube_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_tube_unob",  getId_pos_tube_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后引流管通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后引流管通畅情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_tube_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_tube_unob",  getSd_pos_tube_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后引流管通畅情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后切口敷料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inci_dresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inci_dres",  getId_inci_dresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后切口敷料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后切口敷料编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inci_dresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inci_dres",  getSd_inci_dresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后切口敷料编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_skin",  getId_pos_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_skin",  getSd_pos_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后分期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_stages",  getPos_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后分期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_position",  getPos_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后特殊交接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPos_spe_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pos_spe_hand",  getPos_spe_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后特殊交接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后手术室护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oper_pos_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper_pos_nur",  getId_oper_pos_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后手术室护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后麻醉医师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_anesthesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_anesthes",  getId_pos_anesthesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后麻醉医师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接收医生签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_receiv_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_receiv_doc",  getId_receiv_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收医生签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后接收护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_receiv_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_receiv_nur",  getId_receiv_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后接收护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前分期选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preo_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preo_by_stages",  getId_preo_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前分期选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前分期选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preo_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preo_by_stages",  getSd_preo_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前分期选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中分期选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inter_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inter_by_stages",  getId_inter_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中分期选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中分期选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inter_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inter_by_stages",  getSd_inter_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中分期选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后分期选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pos_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos_by_stages",  getId_pos_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后分期选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后分期选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pos_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos_by_stages",  getSd_pos_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后分期选项编码");
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operation",  getName_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b7","id_operation=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_mark",  getName_preo_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_preo_mark=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_site",  getName_preo_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_preo_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_conscious",  getName_preo_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_preo_conscious=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preparADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_prepar",  getName_preparCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_prepar=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_pipe",  getName_preo_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_preo_pipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_unob_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_unob_pip",  getName_preo_unob_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_preo_unob_pip=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_articles",  getName_preo_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_preo_articles=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_aller",  getName_preo_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_preo_aller=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_his_allerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_his_aller",  getName_preo_his_allerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_preo_his_aller=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_infusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_infus",  getName_preo_infusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_preo_infus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_infus_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_infus_unob",  getName_preo_infus_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_preo_infus_unob=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_infus_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_infus_tool",  getName_preo_infus_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_preo_infus_tool=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_skin",  getName_preo_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_preo_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_nur",  getName_preo_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_preo_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_oper_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_oper_nur",  getName_preo_oper_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_preo_oper_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_conscious",  getName_intra_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_intra_conscious=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_articles",  getName_intra_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_intra_articles=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_mark",  getName_intra_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_intra_mark=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_site",  getName_intra_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_intra_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_pipe",  getName_intra_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_intra_pipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_unob_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_unob_pip",  getName_intra_unob_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_intra_unob_pip=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_skin",  getName_intra_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_intra_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anesthesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anesthes",  getName_anesthesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b30","id_anesthes=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_surgeonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_surgeon",  getName_surgeonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b31","id_surgeon=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intra_oper_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intra_oper_nur",  getName_intra_oper_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b32","id_intra_oper_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_send_bakeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_send_bake",  getName_send_bakeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_send_bake=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_condition",  getName_pat_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_pat_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_infusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_infus",  getName_pos_infusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_pos_infus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_infus_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_infus_unob",  getName_pos_infus_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_pos_infus_unob=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_infus_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_infus_tool",  getName_pos_infus_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_pos_infus_tool=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_articlesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_articles",  getName_pos_articlesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_pos_articles=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_tube",  getName_pos_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_pos_tube=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_tube_unobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_tube_unob",  getName_pos_tube_unobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_pos_tube_unob=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inci_dresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inci_dres",  getName_inci_dresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_inci_dres=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_skin",  getName_pos_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_pos_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_pos_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_pos_nur",  getName_oper_pos_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b43","id_oper_pos_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_anesthesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_anesthes",  getName_pos_anesthesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b44","id_pos_anesthes=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_receiv_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_receiv_doc",  getName_receiv_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b45","id_receiv_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_receiv_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_receiv_nur",  getName_receiv_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b46","id_receiv_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preo_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preo_by_stages",  getName_preo_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b47","id_preo_by_stages=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inter_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inter_by_stages",  getName_inter_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b48","id_inter_by_stages=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pos_by_stagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pos_by_stages",  getName_pos_by_stagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b49","id_pos_by_stages=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取记录单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_surgpatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_surgpat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记录单主键"); 
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
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取就诊病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊病区"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取录入人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入人员"); 
		return column;
	}
	/**
	 * 获取录入日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("录入日期"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
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
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
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
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取诊断ID(通用)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断ID(通用)"); 
		return column;
	}
	/**
	 * 获取诊断(通用)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断(通用)"); 
		return column;
	}
	/**
	 * 获取接病人时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_receCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rece");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("接病人时间"); 
		return column;
	}
	/**
	 * 获取拟行手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟行手术名称"); 
		return column;
	}
	/**
	 * 获取术前手术部位标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_mark");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前手术部位标识"); 
		return column;
	}
	/**
	 * 获取术前手术部位标识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_mark");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前手术部位标识编码"); 
		return column;
	}
	/**
	 * 获取术前手术部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_site");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前手术部位"); 
		return column;
	}
	/**
	 * 获取术前手术部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_site");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前手术部位编码"); 
		return column;
	}
	/**
	 * 获取术前意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_conscious");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前意识"); 
		return column;
	}
	/**
	 * 获取术前意识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_conscious");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前意识编码"); 
		return column;
	}
	/**
	 * 获取术前T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_t");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术前T"); 
		return column;
	}
	/**
	 * 获取术前P表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_pCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_p");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前P"); 
		return column;
	}
	/**
	 * 获取术前R表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_rCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_r");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前R"); 
		return column;
	}
	/**
	 * 获取术前SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_spo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术前SPO2"); 
		return column;
	}
	/**
	 * 获取术前收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_int_sbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_int_sbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前收缩压"); 
		return column;
	}
	/**
	 * 获取术前舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_int_dbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_int_dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前舒张压"); 
		return column;
	}
	/**
	 * 获取术前准备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preparCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prepar");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前准备"); 
		return column;
	}
	/**
	 * 获取术前准备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preparCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_prepar");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前准备编码"); 
		return column;
	}
	/**
	 * 获取术前留置管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_pipe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前留置管路"); 
		return column;
	}
	/**
	 * 获取术前留置管路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_pipe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前留置管路编码"); 
		return column;
	}
	/**
	 * 获取术前留置管路通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_unob_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_unob_pip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前留置管路通畅情况"); 
		return column;
	}
	/**
	 * 获取术前留置管路通畅情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_unob_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_unob_pip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前留置管路通畅情况编码"); 
		return column;
	}
	/**
	 * 获取术前携带物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_articles");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前携带物品"); 
		return column;
	}
	/**
	 * 获取术前携带物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_articles");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前携带物品编码"); 
		return column;
	}
	/**
	 * 获取术前药品信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_drug_informCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_drug_inform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前药品信息"); 
		return column;
	}
	/**
	 * 获取术前过敏试验表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_aller");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前过敏试验"); 
		return column;
	}
	/**
	 * 获取术前过敏试验编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_aller");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前过敏试验编码"); 
		return column;
	}
	/**
	 * 获取术前批号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_batchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_batch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前批号"); 
		return column;
	}
	/**
	 * 获取术前携带物品其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_goods_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_goods_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前携带物品其它"); 
		return column;
	}
	/**
	 * 获取术前过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_his_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_his_aller");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前过敏史"); 
		return column;
	}
	/**
	 * 获取术前过敏史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_his_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_his_aller");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前过敏史编码"); 
		return column;
	}
	/**
	 * 获取术前过敏史情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_sit_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_sit_aller");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前过敏史情况"); 
		return column;
	}
	/**
	 * 获取术前输液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_infusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_infus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液"); 
		return column;
	}
	/**
	 * 获取术前输液编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_infusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_infus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液编码"); 
		return column;
	}
	/**
	 * 获取术前输液情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_infus_sitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_infus_sit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液情况"); 
		return column;
	}
	/**
	 * 获取术前输液通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_infus_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_infus_unob");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液通畅情况"); 
		return column;
	}
	/**
	 * 获取术前输液通畅情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_infus_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_infus_unob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液通畅情况编码"); 
		return column;
	}
	/**
	 * 获取术前输液工具表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_infus_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_infus_tool");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液工具"); 
		return column;
	}
	/**
	 * 获取术前输液工具编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_infus_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_infus_tool");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液工具编码"); 
		return column;
	}
	/**
	 * 获取术前输液工具其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_tool_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_tool_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前输液工具其它"); 
		return column;
	}
	/**
	 * 获取术前皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_skin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前皮肤"); 
		return column;
	}
	/**
	 * 获取术前皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_skin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前皮肤编码"); 
		return column;
	}
	/**
	 * 获取术前分期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_stages");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前分期"); 
		return column;
	}
	/**
	 * 获取术前部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前部位"); 
		return column;
	}
	/**
	 * 获取术前特殊交接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_spe_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_spe_hand");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前特殊交接"); 
		return column;
	}
	/**
	 * 获取术前科室护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前科室护士"); 
		return column;
	}
	/**
	 * 获取患者/家属表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFami_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fami_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者/家属"); 
		return column;
	}
	/**
	 * 获取术前手术室护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_oper_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_oper_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前手术室护士"); 
		return column;
	}
	/**
	 * 获取入手术室时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_enterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_enter");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入手术室时间"); 
		return column;
	}
	/**
	 * 获取术中意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_conscious");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中意识"); 
		return column;
	}
	/**
	 * 获取术中意识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_conscious");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中意识编码"); 
		return column;
	}
	/**
	 * 获取术中携带物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_articles");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中携带物品"); 
		return column;
	}
	/**
	 * 获取术中携带物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_articles");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中携带物品编码"); 
		return column;
	}
	/**
	 * 获取术中携带物品其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_articles_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_articles_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中携带物品其它"); 
		return column;
	}
	/**
	 * 获取术中手术部位标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_mark");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中手术部位标识"); 
		return column;
	}
	/**
	 * 获取术中手术部位标识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_mark");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中手术部位标识编码"); 
		return column;
	}
	/**
	 * 获取术中手术部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_site");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中手术部位"); 
		return column;
	}
	/**
	 * 获取术中手术部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_site");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中手术部位编码"); 
		return column;
	}
	/**
	 * 获取术中手术部位其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_site_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_site_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中手术部位其它"); 
		return column;
	}
	/**
	 * 获取术中留置管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_pipe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中留置管路"); 
		return column;
	}
	/**
	 * 获取术中留置管路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_pipe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中留置管路编码"); 
		return column;
	}
	/**
	 * 获取术中留置管路通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_unob_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_unob_pip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中留置管路通畅情况"); 
		return column;
	}
	/**
	 * 获取术中留置管路通畅情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_unob_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_unob_pip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中留置管路通畅情况编码"); 
		return column;
	}
	/**
	 * 获取术中皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_skin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中皮肤"); 
		return column;
	}
	/**
	 * 获取术中皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intra_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intra_skin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中皮肤编码"); 
		return column;
	}
	/**
	 * 获取术中分期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_stages");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中分期"); 
		return column;
	}
	/**
	 * 获取术中部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中部位"); 
		return column;
	}
	/**
	 * 获取术中T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_t");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术中T"); 
		return column;
	}
	/**
	 * 获取术中P表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_pCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_p");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术中P"); 
		return column;
	}
	/**
	 * 获取术中R表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_rCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_r");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术中R"); 
		return column;
	}
	/**
	 * 获取术中SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_spo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术中SPO2"); 
		return column;
	}
	/**
	 * 获取术中收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_int_sbpsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_int_sbps");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术中收缩压"); 
		return column;
	}
	/**
	 * 获取术中舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_int_dbpsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_int_dbps");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术中舒张压"); 
		return column;
	}
	/**
	 * 获取手术结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_oper_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术结束时间"); 
		return column;
	}
	/**
	 * 获取术中麻醉医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anesthesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anesthes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中麻醉医师"); 
		return column;
	}
	/**
	 * 获取手术医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_surgeonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_surgeon");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医生"); 
		return column;
	}
	/**
	 * 获取术中手术室护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intra_oper_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intra_oper_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中手术室护士"); 
		return column;
	}
	/**
	 * 获取术后送回表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_send_bakeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_send_bake");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后送回"); 
		return column;
	}
	/**
	 * 获取术后送回编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_send_bakeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_send_bake");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后送回编码"); 
		return column;
	}
	/**
	 * 获取术后送回时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_sendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_send");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术后送回时间"); 
		return column;
	}
	/**
	 * 获取术后T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_t");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术后T"); 
		return column;
	}
	/**
	 * 获取术后P表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_pCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_p");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后P"); 
		return column;
	}
	/**
	 * 获取术后R表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_rCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_r");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后R"); 
		return column;
	}
	/**
	 * 获取术后SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_spo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术后SPO2"); 
		return column;
	}
	/**
	 * 获取术后收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_int_sbpsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_int_sbps");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后收缩压"); 
		return column;
	}
	/**
	 * 获取术后舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_int_dbpsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_int_dbps");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后舒张压"); 
		return column;
	}
	/**
	 * 获取病人情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_condition");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人情况"); 
		return column;
	}
	/**
	 * 获取病人情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_condition");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人情况编码"); 
		return column;
	}
	/**
	 * 获取术后输液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_infusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_infus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液"); 
		return column;
	}
	/**
	 * 获取术后输液编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_infusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_infus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液编码"); 
		return column;
	}
	/**
	 * 获取术后输液情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_infus_sitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_infus_sit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液情况"); 
		return column;
	}
	/**
	 * 获取术后输液通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_infus_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_infus_unob");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液通畅情况"); 
		return column;
	}
	/**
	 * 获取术后输液通畅情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_infus_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_infus_unob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液通畅情况编码"); 
		return column;
	}
	/**
	 * 获取术前留置管路情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreo_pipe_condCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preo_pipe_cond");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前留置管路情况"); 
		return column;
	}
	/**
	 * 获取术中留置管路情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntra_pipe_condCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intra_pipe_cond");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中留置管路情况"); 
		return column;
	}
	/**
	 * 获取术后输液工具表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_infus_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_infus_tool");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液工具"); 
		return column;
	}
	/**
	 * 获取术后输液工具编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_infus_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_infus_tool");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液工具编码"); 
		return column;
	}
	/**
	 * 获取术后输液工具其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_tool_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_tool_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后输液工具其它"); 
		return column;
	}
	/**
	 * 获取带回药品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBring_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bring_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带回药品"); 
		return column;
	}
	/**
	 * 获取术后携带物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_articles");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后携带物品"); 
		return column;
	}
	/**
	 * 获取术后携带物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_articles");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后携带物品编码"); 
		return column;
	}
	/**
	 * 获取术后携带物品其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_articles_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_articles_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后携带物品其它"); 
		return column;
	}
	/**
	 * 获取标本份数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_specimenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_specimen");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("标本份数"); 
		return column;
	}
	/**
	 * 获取术后引流管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_tube");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后引流管"); 
		return column;
	}
	/**
	 * 获取术后引流管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_tube");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后引流管编码"); 
		return column;
	}
	/**
	 * 获取术后引流管情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_tube_sitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_tube_sit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后引流管情况"); 
		return column;
	}
	/**
	 * 获取术后引流管通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_tube_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_tube_unob");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后引流管通畅情况"); 
		return column;
	}
	/**
	 * 获取术后引流管通畅情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_tube_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_tube_unob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后引流管通畅情况编码"); 
		return column;
	}
	/**
	 * 获取术后切口敷料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inci_dresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inci_dres");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后切口敷料"); 
		return column;
	}
	/**
	 * 获取术后切口敷料编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inci_dresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inci_dres");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后切口敷料编码"); 
		return column;
	}
	/**
	 * 获取术后皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_skin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后皮肤"); 
		return column;
	}
	/**
	 * 获取术后皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_skin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后皮肤编码"); 
		return column;
	}
	/**
	 * 获取术后分期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_stages");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后分期"); 
		return column;
	}
	/**
	 * 获取术后部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后部位"); 
		return column;
	}
	/**
	 * 获取术后特殊交接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPos_spe_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pos_spe_hand");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后特殊交接"); 
		return column;
	}
	/**
	 * 获取术后手术室护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oper_pos_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper_pos_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后手术室护士签名"); 
		return column;
	}
	/**
	 * 获取术后麻醉医师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_anesthesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_anesthes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后麻醉医师签名"); 
		return column;
	}
	/**
	 * 获取接收医生签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_receiv_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_receiv_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收医生签名"); 
		return column;
	}
	/**
	 * 获取术后接收护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_receiv_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_receiv_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后接收护士签名"); 
		return column;
	}
	/**
	 * 获取术前分期选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preo_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preo_by_stages");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前分期选项"); 
		return column;
	}
	/**
	 * 获取术前分期选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preo_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preo_by_stages");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前分期选项编码"); 
		return column;
	}
	/**
	 * 获取术中分期选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inter_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inter_by_stages");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中分期选项"); 
		return column;
	}
	/**
	 * 获取术中分期选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inter_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inter_by_stages");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中分期选项编码"); 
		return column;
	}
	/**
	 * 获取术后分期选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pos_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos_by_stages");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后分期选项"); 
		return column;
	}
	/**
	 * 获取术后分期选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pos_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos_by_stages");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后分期选项编码"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_preo_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_mark");
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
	private IColumnDesc getName_preo_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_site");
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
	private IColumnDesc getName_preo_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_conscious");
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
	private IColumnDesc getName_preparCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_prepar");
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
	private IColumnDesc getName_preo_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_pipe");
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
	private IColumnDesc getName_preo_unob_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_unob_pip");
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
	private IColumnDesc getName_preo_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_articles");
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
	private IColumnDesc getName_preo_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_aller");
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
	private IColumnDesc getName_preo_his_allerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_his_aller");
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
	private IColumnDesc getName_preo_infusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_infus");
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
	private IColumnDesc getName_preo_infus_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_infus_unob");
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
	private IColumnDesc getName_preo_infus_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_infus_tool");
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
	private IColumnDesc getName_preo_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_preo_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_preo_oper_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_oper_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_intra_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_conscious");
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
	private IColumnDesc getName_intra_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_articles");
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
	private IColumnDesc getName_intra_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_mark");
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
	private IColumnDesc getName_intra_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_site");
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
	private IColumnDesc getName_intra_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_pipe");
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
	private IColumnDesc getName_intra_unob_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_unob_pip");
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
	private IColumnDesc getName_intra_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anesthesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anesthes");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_surgeonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_surgeon");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_intra_oper_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intra_oper_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_send_bakeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_send_bake");
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
	private IColumnDesc getName_pat_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_condition");
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
	private IColumnDesc getName_pos_infusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_infus");
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
	private IColumnDesc getName_pos_infus_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_infus_unob");
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
	private IColumnDesc getName_pos_infus_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_infus_tool");
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
	private IColumnDesc getName_pos_articlesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_articles");
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
	private IColumnDesc getName_pos_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_tube");
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
	private IColumnDesc getName_pos_tube_unobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_tube_unob");
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
	private IColumnDesc getName_inci_dresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inci_dres");
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
	private IColumnDesc getName_pos_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_pos_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_pos_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pos_anesthesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_anesthes");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_receiv_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_receiv_doc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_receiv_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_receiv_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_preo_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preo_by_stages");
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
	private IColumnDesc getName_inter_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inter_by_stages");
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
	private IColumnDesc getName_pos_by_stagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pos_by_stages");
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
