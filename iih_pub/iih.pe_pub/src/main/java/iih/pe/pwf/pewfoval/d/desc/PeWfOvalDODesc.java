
package iih.pe.pwf.pewfoval.d.desc;

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
 * 体检总检主表 DO 元数据信息
 */
public class PeWfOvalDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pewfoval.d.PeWfOvalDO";
	public static final String CLASS_DISPALYNAME = "体检总检主表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_pewfoval";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pewfoval";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeWfOvalDODesc(){
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
		this.setKeyDesc(getId_pewfovalADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pewfovalADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getFg_ovalADesc(tblDesc));
		this.add(getId_doc_ovalADesc(tblDesc));
		this.add(getDt_ovalADesc(tblDesc));
		this.add(getFg_aduitADesc(tblDesc));
		this.add(getId_doc_auditADesc(tblDesc));
		this.add(getDt_auditADesc(tblDesc));
		this.add(getRelease_wayADesc(tblDesc));
		this.add(getRelease_baileeADesc(tblDesc));
		this.add(getFg_releaseADesc(tblDesc));
		this.add(getId_releaseADesc(tblDesc));
		this.add(getDt_releaseADesc(tblDesc));
		this.add(getId_confirmerADesc(tblDesc));
		this.add(getFg_confirmADesc(tblDesc));
		this.add(getFg_printADesc(tblDesc));
		this.add(getDt_printADesc(tblDesc));
		this.add(getDt_confirmADesc(tblDesc));
		this.add(getFg_chroADesc(tblDesc));
		this.add(getCover_wordADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_followupADesc(tblDesc));
		this.add(getDt_followupADesc(tblDesc));
		this.add(getFg_interviewADesc(tblDesc));
		this.add(getDt_interviewADesc(tblDesc));
		this.add(getEnum_ecgADesc(tblDesc));
		this.add(getEnum_lisADesc(tblDesc));
		this.add(getEnum_xADesc(tblDesc));
		this.add(getEnum_ctADesc(tblDesc));
		this.add(getSt_diningADesc(tblDesc));
		this.add(getDt_diningADesc(tblDesc));
		this.add(getFg_qualifiedADesc(tblDesc));
		this.add(getDt_certificateADesc(tblDesc));
		this.add(getRegistry_timesADesc(tblDesc));
		this.add(getReexam_timesADesc(tblDesc));
		this.add(getExam_resultADesc(tblDesc));
		this.add(getHandle_ideaADesc(tblDesc));
		this.add(getExam_decisionADesc(tblDesc));
		this.add(getExam_commentADesc(tblDesc));
		this.add(getFg_suggestleaveADesc(tblDesc));
		this.add(getFg_diagnosisADesc(tblDesc));
		this.add(getFg_follupADesc(tblDesc));
		this.add(getFg_passedADesc(tblDesc));
		this.add(getFg_lockingADesc(tblDesc));
		this.add(getId_locking_docADesc(tblDesc));
		this.add(getPe_timesADesc(tblDesc));
		this.add(getCard_peADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getMobADesc(tblDesc));
		this.add(getName_ovalADesc(tblDesc));
		this.add(getCode_ovalADesc(tblDesc));
		this.add(getName_aduitADesc(tblDesc));
		this.add(getCode_aduitADesc(tblDesc));
		this.add(getName_releaseADesc(tblDesc));
		this.add(getCode_releaseADesc(tblDesc));
		this.add(getCode_confirmADesc(tblDesc));
		this.add(getName_lockingADesc(tblDesc));
		this.add(getCode_lockingADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pewfovalCDesc(tblDesc));
		tblDesc.add(getId_pewfovalCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getFg_ovalCDesc(tblDesc));
		tblDesc.add(getId_doc_ovalCDesc(tblDesc));
		tblDesc.add(getDt_ovalCDesc(tblDesc));
		tblDesc.add(getFg_aduitCDesc(tblDesc));
		tblDesc.add(getId_doc_auditCDesc(tblDesc));
		tblDesc.add(getDt_auditCDesc(tblDesc));
		tblDesc.add(getRelease_wayCDesc(tblDesc));
		tblDesc.add(getRelease_baileeCDesc(tblDesc));
		tblDesc.add(getFg_releaseCDesc(tblDesc));
		tblDesc.add(getId_releaseCDesc(tblDesc));
		tblDesc.add(getDt_releaseCDesc(tblDesc));
		tblDesc.add(getId_confirmerCDesc(tblDesc));
		tblDesc.add(getFg_confirmCDesc(tblDesc));
		tblDesc.add(getFg_printCDesc(tblDesc));
		tblDesc.add(getDt_printCDesc(tblDesc));
		tblDesc.add(getDt_confirmCDesc(tblDesc));
		tblDesc.add(getFg_chroCDesc(tblDesc));
		tblDesc.add(getCover_wordCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_followupCDesc(tblDesc));
		tblDesc.add(getDt_followupCDesc(tblDesc));
		tblDesc.add(getFg_interviewCDesc(tblDesc));
		tblDesc.add(getDt_interviewCDesc(tblDesc));
		tblDesc.add(getEnum_ecgCDesc(tblDesc));
		tblDesc.add(getEnum_lisCDesc(tblDesc));
		tblDesc.add(getEnum_xCDesc(tblDesc));
		tblDesc.add(getEnum_ctCDesc(tblDesc));
		tblDesc.add(getSt_diningCDesc(tblDesc));
		tblDesc.add(getDt_diningCDesc(tblDesc));
		tblDesc.add(getFg_qualifiedCDesc(tblDesc));
		tblDesc.add(getDt_certificateCDesc(tblDesc));
		tblDesc.add(getRegistry_timesCDesc(tblDesc));
		tblDesc.add(getReexam_timesCDesc(tblDesc));
		tblDesc.add(getExam_resultCDesc(tblDesc));
		tblDesc.add(getHandle_ideaCDesc(tblDesc));
		tblDesc.add(getExam_decisionCDesc(tblDesc));
		tblDesc.add(getExam_commentCDesc(tblDesc));
		tblDesc.add(getFg_suggestleaveCDesc(tblDesc));
		tblDesc.add(getFg_diagnosisCDesc(tblDesc));
		tblDesc.add(getFg_follupCDesc(tblDesc));
		tblDesc.add(getFg_passedCDesc(tblDesc));
		tblDesc.add(getFg_lockingCDesc(tblDesc));
		tblDesc.add(getId_locking_docCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检总检主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pewfovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pewfoval",  getId_pewfovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检总检主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检客户ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnbinfo",  getId_pepsnbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检客户ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 总检标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_oval",  getFg_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("总检标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doc_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc_oval",  getId_doc_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 总检时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oval",  getDt_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("总检时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_aduitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_aduit",  getFg_aduitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("审核标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doc_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc_audit",  getId_doc_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit",  getDt_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告领取方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelease_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Release_way",  getRelease_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("报告领取方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告代领人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelease_baileeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Release_bailee",  getRelease_baileeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告代领人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告发放标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_releaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_release",  getFg_releaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("报告发放标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告发放人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_releaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_release",  getId_releaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告发放人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报告领取时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_releaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_release",  getDt_releaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告领取时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告核对人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_confirmerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_confirmer",  getId_confirmerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告核对人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报告核对标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_confirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_confirm",  getFg_confirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("报告核对标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_printADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_print",  getFg_printCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("报告打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告打印时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_printADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_print",  getDt_printCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告打印时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告核对时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_confirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_confirm",  getDt_confirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告核对时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 纳入慢性病管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_chroADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_chro",  getFg_chroCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("纳入慢性病管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检报告封面语属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCover_wordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cover_word",  getCover_wordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检报告封面语");
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
	 * 追踪标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_followupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_followup",  getFg_followupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("追踪标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 追踪日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_followupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_followup",  getDt_followupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("追踪日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随访标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_interviewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_interview",  getFg_interviewCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("随访标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随访日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_interviewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_interview",  getDt_interviewCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("随访日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心电图完成标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_ecgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_ecg",  getEnum_ecgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心电图完成标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验完成标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_lisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_lis",  getEnum_lisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检验完成标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * X线完成标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_xADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_x",  getEnum_xCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("X线完成标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * CT完成标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_ctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_ct",  getEnum_ctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("CT完成标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用餐标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSt_diningADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("St_dining",  getSt_diningCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("用餐标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用餐时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_diningADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_dining",  getDt_diningCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("用餐时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 合格标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_qualifiedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_qualified",  getFg_qualifiedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("合格标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发证日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_certificateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_certificate",  getDt_certificateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("发证日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRegistry_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Registry_times",  getRegistry_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检查次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复查次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReexam_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reexam_times",  getReexam_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("复查次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_result",  getExam_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHandle_ideaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Handle_idea",  getHandle_ideaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查结论属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_decisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_decision",  getExam_decisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查结论");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_commentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_comment",  getExam_commentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议离岗标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_suggestleaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_suggestleave",  getFg_suggestleaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("建议离岗标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_diagnosis",  getFg_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("诊断标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 追踪标识_职业病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_follupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_follup",  getFg_follupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("追踪标识_职业病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通过标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_passedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_passed",  getFg_passedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("通过标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检锁定标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_lockingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_locking",  getFg_lockingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("总检锁定标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检锁定医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_locking_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_locking_doc",  getId_locking_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检锁定医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_times",  getPe_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt C8397EE6-BD20-0001-666B-1ED317C5C5E0,pe_code,体检唯一码,pe_code,体检唯一码,java.lang.String,varchar,pe_apt_pepsnappt,id_pepsnappt,C8215648-B480-0001-95F6-D9C5B2001079","id_pepsnappt=id_pepsnappt","pe_times"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe",  getCard_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt C8397EE6-BD20-0001-666B-1ED317C5C5E0,pe_code,体检唯一码,pe_code,体检唯一码,java.lang.String,varchar,pe_apt_pepsnappt,id_pepsnappt,C8215648-B480-0001-95F6-D9C5B2001079","id_pepsnappt=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn",  getName_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b8","id_pepsnbinfo=id_pepsnbinfo","name"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b8","id_pepsnbinfo=id_pepsnbinfo","sd_sex"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob",  getMobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b8","id_pepsnbinfo=id_pepsnbinfo","mob"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oval",  getName_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b2","id_doc_oval=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_oval",  getCode_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b2","id_doc_oval=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_aduitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_aduit",  getName_aduitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b3","id_doc_audit=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_aduitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_aduit",  getCode_aduitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b3","id_doc_audit=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_releaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_release",  getName_releaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b4","id_release=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_releaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_release",  getCode_releaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b4","id_release=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_confirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_confirm",  getCode_confirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b5","id_confirmer=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lockingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_locking",  getName_lockingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_locking_doc=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_lockingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_locking",  getCode_lockingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_locking_doc=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检总检主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pewfovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pewfoval");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检总检主键标识"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取体检客户ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检客户ID"); 
		return column;
	}
	/**
	 * 获取总检标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_oval");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("总检标识"); 
		return column;
	}
	/**
	 * 获取总检医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doc_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc_oval");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检医生"); 
		return column;
	}
	/**
	 * 获取总检时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oval");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("总检时间"); 
		return column;
	}
	/**
	 * 获取审核标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_aduitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_aduit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核标识"); 
		return column;
	}
	/**
	 * 获取审核医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doc_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc_audit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核医生"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取报告领取方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelease_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Release_way");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("报告领取方式"); 
		return column;
	}
	/**
	 * 获取报告代领人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelease_baileeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Release_bailee");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告代领人"); 
		return column;
	}
	/**
	 * 获取报告发放标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_releaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_release");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告发放标识"); 
		return column;
	}
	/**
	 * 获取报告发放人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_releaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_release");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告发放人"); 
		return column;
	}
	/**
	 * 获取报告领取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_releaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_release");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告领取时间"); 
		return column;
	}
	/**
	 * 获取报告核对人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_confirmerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_confirmer");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告核对人"); 
		return column;
	}
	/**
	 * 获取报告核对标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_confirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_confirm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告核对标识"); 
		return column;
	}
	/**
	 * 获取报告打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_printCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_print");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告打印标识"); 
		return column;
	}
	/**
	 * 获取报告打印时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_printCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_print");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告打印时间"); 
		return column;
	}
	/**
	 * 获取报告核对时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_confirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_confirm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告核对时间"); 
		return column;
	}
	/**
	 * 获取纳入慢性病管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_chroCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_chro");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("纳入慢性病管理"); 
		return column;
	}
	/**
	 * 获取总检报告封面语表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCover_wordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cover_word");
		column.setLength(800);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检报告封面语"); 
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
	 * 获取追踪标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_followupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_followup");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("追踪标识"); 
		return column;
	}
	/**
	 * 获取追踪日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_followupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_followup");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("追踪日期"); 
		return column;
	}
	/**
	 * 获取随访标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_interviewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_interview");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("随访标识"); 
		return column;
	}
	/**
	 * 获取随访日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_interviewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_interview");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("随访日期"); 
		return column;
	}
	/**
	 * 获取心电图完成标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_ecgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_ecg");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心电图完成标识"); 
		return column;
	}
	/**
	 * 获取检验完成标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_lisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_lis");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检验完成标识"); 
		return column;
	}
	/**
	 * 获取X线完成标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_xCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_x");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("X线完成标识"); 
		return column;
	}
	/**
	 * 获取CT完成标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_ctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_ct");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("CT完成标识"); 
		return column;
	}
	/**
	 * 获取用餐标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSt_diningCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"St_dining");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("用餐标识"); 
		return column;
	}
	/**
	 * 获取用餐时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_diningCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_dining");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用餐时间"); 
		return column;
	}
	/**
	 * 获取合格标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_qualifiedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_qualified");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("合格标识"); 
		return column;
	}
	/**
	 * 获取发证日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_certificateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_certificate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发证日期"); 
		return column;
	}
	/**
	 * 获取检查次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRegistry_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Registry_times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检查次数"); 
		return column;
	}
	/**
	 * 获取复查次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReexam_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reexam_times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("复查次数"); 
		return column;
	}
	/**
	 * 获取检查结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_result");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查结果"); 
		return column;
	}
	/**
	 * 获取处理意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHandle_ideaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Handle_idea");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理意见"); 
		return column;
	}
	/**
	 * 获取检查结论表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_decisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_decision");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查结论"); 
		return column;
	}
	/**
	 * 获取检查备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_commentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_comment");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查备注"); 
		return column;
	}
	/**
	 * 获取建议离岗标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_suggestleaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_suggestleave");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("建议离岗标识"); 
		return column;
	}
	/**
	 * 获取诊断标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_diagnosis");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊断标识"); 
		return column;
	}
	/**
	 * 获取追踪标识_职业病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_follupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_follup");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("追踪标识_职业病"); 
		return column;
	}
	/**
	 * 获取通过标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_passedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_passed");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("通过标识"); 
		return column;
	}
	/**
	 * 获取总检锁定标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_lockingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_locking");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("总检锁定标识"); 
		return column;
	}
	/**
	 * 获取总检锁定医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_locking_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_locking_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检锁定医生"); 
		return column;
	}
	/**
	 * 获取体检次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_times");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检次数"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取移动电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动电话"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oval");
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
	private IColumnDesc getCode_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_oval");
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
	private IColumnDesc getName_aduitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_aduit");
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
	private IColumnDesc getCode_aduitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_aduit");
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
	private IColumnDesc getName_releaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_release");
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
	private IColumnDesc getCode_releaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_release");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_confirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_confirm");
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
	private IColumnDesc getName_lockingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_locking");
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
	private IColumnDesc getCode_lockingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_locking");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pewfoval");
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
