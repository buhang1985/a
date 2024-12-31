
package iih.en.pv.enhpreferral.d.desc;

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
 * 医保转诊单 DO 元数据信息
 */
public class EnHpReferralDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.enhpreferral.d.EnHpReferralDO";
	public static final String CLASS_DISPALYNAME = "医保转诊单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_ent_hp_referral";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ent_hpreferral";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnHpReferralDODesc(){
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
		this.setKeyDesc(getId_ent_hpreferralADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ent_hpreferralADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getEnt_codeADesc(tblDesc));
		this.add(getReferralcodeADesc(tblDesc));
		this.add(getPersoncodeADesc(tblDesc));
		this.add(getPatnameADesc(tblDesc));
		this.add(getDicodeADesc(tblDesc));
		this.add(getApplydateADesc(tblDesc));
		this.add(getApplynoteADesc(tblDesc));
		this.add(getAgenciescodeADesc(tblDesc));
		this.add(getHosfromcodeADesc(tblDesc));
		this.add(getHosincodeADesc(tblDesc));
		this.add(getReferralstatusADesc(tblDesc));
		this.add(getAuditdateADesc(tblDesc));
		this.add(getChareacodeADesc(tblDesc));
		this.add(getDinameADesc(tblDesc));
		this.add(getAgenciesnameADesc(tblDesc));
		this.add(getHosfromnameADesc(tblDesc));
		this.add(getHosinnameADesc(tblDesc));
		this.add(getAuditornameADesc(tblDesc));
		this.add(getAuditnoteADesc(tblDesc));
		this.add(getChareanameADesc(tblDesc));
		this.add(getAuditstatusnameADesc(tblDesc));
		this.add(getIdcardADesc(tblDesc));
		this.add(getIdcardstoreADesc(tblDesc));
		this.add(getMedicalcodeADesc(tblDesc));
		this.add(getMedicalcodestoreADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getInstitucontactorADesc(tblDesc));
		this.add(getInstitucontactwayADesc(tblDesc));
		this.add(getInstitumailADesc(tblDesc));
		this.add(getBirthdayADesc(tblDesc));
		this.add(getReferral_createtimeADesc(tblDesc));
		this.add(getReferral_updatetimeADesc(tblDesc));
		this.add(getDrgs_codeADesc(tblDesc));
		this.add(getDrgs_nameADesc(tblDesc));
		this.add(getPatcontactorADesc(tblDesc));
		this.add(getPatphoneADesc(tblDesc));
		this.add(getCivilassist_identADesc(tblDesc));
		this.add(getGraveassist_identADesc(tblDesc));
		this.add(getFamilycodeADesc(tblDesc));
		this.add(getHosin2codeADesc(tblDesc));
		this.add(getHosin2nameADesc(tblDesc));
		this.add(getHosin3codeADesc(tblDesc));
		this.add(getHosin3nameADesc(tblDesc));
		this.add(getAccumulamtADesc(tblDesc));
		this.add(getBankaccount_nameADesc(tblDesc));
		this.add(getBankaccount_noADesc(tblDesc));
		this.add(getBanknameADesc(tblDesc));
		this.add(getPaytp_codeADesc(tblDesc));
		this.add(getPaytp_nameADesc(tblDesc));
		this.add(getChprovcodeADesc(tblDesc));
		this.add(getChprovnameADesc(tblDesc));
		this.add(getChcitycodeADesc(tblDesc));
		this.add(getChcitynameADesc(tblDesc));
		this.add(getExportdateADesc(tblDesc));
		this.add(getDatatypeADesc(tblDesc));
		this.add(getSourcetypeADesc(tblDesc));
		this.add(getSourcecodeADesc(tblDesc));
		this.add(getTargetcodeADesc(tblDesc));
		this.add(getId_referraltpADesc(tblDesc));
		this.add(getStageADesc(tblDesc));
		this.add(getAccumulamt_hpADesc(tblDesc));
		this.add(getTimes_hpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getHousemaster_relADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getReferraltp_codeADesc(tblDesc));
		this.add(getReferraltp_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ent_hpreferralCDesc(tblDesc));
		tblDesc.add(getId_ent_hpreferralCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getEnt_codeCDesc(tblDesc));
		tblDesc.add(getReferralcodeCDesc(tblDesc));
		tblDesc.add(getPersoncodeCDesc(tblDesc));
		tblDesc.add(getPatnameCDesc(tblDesc));
		tblDesc.add(getDicodeCDesc(tblDesc));
		tblDesc.add(getApplydateCDesc(tblDesc));
		tblDesc.add(getApplynoteCDesc(tblDesc));
		tblDesc.add(getAgenciescodeCDesc(tblDesc));
		tblDesc.add(getHosfromcodeCDesc(tblDesc));
		tblDesc.add(getHosincodeCDesc(tblDesc));
		tblDesc.add(getReferralstatusCDesc(tblDesc));
		tblDesc.add(getAuditdateCDesc(tblDesc));
		tblDesc.add(getChareacodeCDesc(tblDesc));
		tblDesc.add(getDinameCDesc(tblDesc));
		tblDesc.add(getAgenciesnameCDesc(tblDesc));
		tblDesc.add(getHosfromnameCDesc(tblDesc));
		tblDesc.add(getHosinnameCDesc(tblDesc));
		tblDesc.add(getAuditornameCDesc(tblDesc));
		tblDesc.add(getAuditnoteCDesc(tblDesc));
		tblDesc.add(getChareanameCDesc(tblDesc));
		tblDesc.add(getAuditstatusnameCDesc(tblDesc));
		tblDesc.add(getIdcardCDesc(tblDesc));
		tblDesc.add(getIdcardstoreCDesc(tblDesc));
		tblDesc.add(getMedicalcodeCDesc(tblDesc));
		tblDesc.add(getMedicalcodestoreCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getInstitucontactorCDesc(tblDesc));
		tblDesc.add(getInstitucontactwayCDesc(tblDesc));
		tblDesc.add(getInstitumailCDesc(tblDesc));
		tblDesc.add(getBirthdayCDesc(tblDesc));
		tblDesc.add(getReferral_createtimeCDesc(tblDesc));
		tblDesc.add(getReferral_updatetimeCDesc(tblDesc));
		tblDesc.add(getDrgs_codeCDesc(tblDesc));
		tblDesc.add(getDrgs_nameCDesc(tblDesc));
		tblDesc.add(getPatcontactorCDesc(tblDesc));
		tblDesc.add(getPatphoneCDesc(tblDesc));
		tblDesc.add(getCivilassist_identCDesc(tblDesc));
		tblDesc.add(getGraveassist_identCDesc(tblDesc));
		tblDesc.add(getFamilycodeCDesc(tblDesc));
		tblDesc.add(getHosin2codeCDesc(tblDesc));
		tblDesc.add(getHosin2nameCDesc(tblDesc));
		tblDesc.add(getHosin3codeCDesc(tblDesc));
		tblDesc.add(getHosin3nameCDesc(tblDesc));
		tblDesc.add(getAccumulamtCDesc(tblDesc));
		tblDesc.add(getBankaccount_nameCDesc(tblDesc));
		tblDesc.add(getBankaccount_noCDesc(tblDesc));
		tblDesc.add(getBanknameCDesc(tblDesc));
		tblDesc.add(getPaytp_codeCDesc(tblDesc));
		tblDesc.add(getPaytp_nameCDesc(tblDesc));
		tblDesc.add(getChprovcodeCDesc(tblDesc));
		tblDesc.add(getChprovnameCDesc(tblDesc));
		tblDesc.add(getChcitycodeCDesc(tblDesc));
		tblDesc.add(getChcitynameCDesc(tblDesc));
		tblDesc.add(getExportdateCDesc(tblDesc));
		tblDesc.add(getDatatypeCDesc(tblDesc));
		tblDesc.add(getSourcetypeCDesc(tblDesc));
		tblDesc.add(getSourcecodeCDesc(tblDesc));
		tblDesc.add(getTargetcodeCDesc(tblDesc));
		tblDesc.add(getId_referraltpCDesc(tblDesc));
		tblDesc.add(getStageCDesc(tblDesc));
		tblDesc.add(getAccumulamt_hpCDesc(tblDesc));
		tblDesc.add(getTimes_hpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getHousemaster_relCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 转诊单申请主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_hpreferralADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_hpreferral",  getId_ent_hpreferralCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊单申请主键");
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
	 * 患者主键Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者主键Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊主键Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊主键Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ent_code",  getEnt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferralcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referralcode",  getReferralcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPersoncodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Personcode",  getPersoncodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人编号");
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
	private IAttrDesc getPatnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patname",  getPatnameCDesc(tblDesc), this);
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
	 * 疾病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDicodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dicode",  getDicodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApplydateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Applydate",  getApplydateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("申请日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApplynoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Applynote",  getApplynoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经办机构代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgenciescodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Agenciescode",  getAgenciescodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经办机构代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转出医院代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosfromcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosfromcode",  getHosfromcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转出医院代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入医院代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosincodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosincode",  getHosincodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入医院代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferralstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referralstatus",  getReferralstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAuditdateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Auditdate",  getAuditdateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参合区（县）地区代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChareacodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chareacode",  getChareacodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参合区（县）地区代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDinameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diname",  getDinameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经办机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgenciesnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Agenciesname",  getAgenciesnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经办机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转出医院名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosfromnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosfromname",  getHosfromnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转出医院名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入医院名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosinnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosinname",  getHosinnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入医院名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAuditornameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Auditorname",  getAuditornameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAuditnoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Auditnote",  getAuditnoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参合区（县）地区名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChareanameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chareaname",  getChareanameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参合区（县）地区名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAuditstatusnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Auditstatusname",  getAuditstatusnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身份证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcard",  getIdcardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身份证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身份证号存储地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcardstoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcardstore",  getIdcardstoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身份证号存储地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedicalcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medicalcode",  getMedicalcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗证号存储地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedicalcodestoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medicalcodestore",  getMedicalcodestoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗证号存储地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("就诊日期");
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
	 * 机构联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstitucontactorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Institucontactor",  getInstitucontactorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机构联系方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstitucontactwayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Institucontactway",  getInstitucontactwayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构联系方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机构联系邮箱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstitumailADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Institumail",  getInstitumailCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构联系邮箱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生日属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirthdayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birthday",  getBirthdayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("生日");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊单创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferral_createtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referral_createtime",  getReferral_createtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("转诊单创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 更新时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferral_updatetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referral_updatetime",  getReferral_updatetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("更新时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单病种代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrgs_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drgs_code",  getDrgs_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单病种代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单病种名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrgs_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drgs_name",  getDrgs_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单病种名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcontactorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcontactor",  getPatcontactorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatphoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patphone",  getPatphoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民政救助标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCivilassist_identADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Civilassist_ident",  getCivilassist_identCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民政救助标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病救助标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGraveassist_identADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Graveassist_ident",  getGraveassist_identCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大病救助标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFamilycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Familycode",  getFamilycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入医院 2 代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosin2codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosin2code",  getHosin2codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入医院 2 代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入医院 2 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosin2nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosin2name",  getHosin2nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入医院 2 名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入医院 3 代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosin3codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosin3code",  getHosin3codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入医院 3 代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入医院 3名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosin3nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosin3name",  getHosin3nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入医院 3名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 累计金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAccumulamtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Accumulamt",  getAccumulamtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("累计金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBankaccount_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankaccount_name",  getBankaccount_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行账号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBankaccount_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankaccount_no",  getBankaccount_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行账号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开户银行名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBanknameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankname",  getBanknameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开户银行名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗付费方式代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaytp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paytp_code",  getPaytp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗付费方式代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗付费方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaytp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paytp_name",  getPaytp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗付费方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参合省代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChprovcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chprovcode",  getChprovcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参合省代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参合省名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChprovnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chprovname",  getChprovnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参合省名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参合市代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChcitycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chcitycode",  getChcitycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参合市代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参合市名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChcitynameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chcityname",  getChcitynameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参合市名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导出日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExportdateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exportdate",  getExportdateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("导出日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDatatypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Datatype",  getDatatypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSourcetypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sourcetype",  getSourcetypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家平台属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSourcecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sourcecode",  getSourcecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家平台");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 符合国家行政区划的导 出参合区（县）地区代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTargetcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Targetcode",  getTargetcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("符合国家行政区划的导 出参合区（县）地区代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊类型代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_referraltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_referraltp",  getId_referraltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊类型代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接诊状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stage",  getStageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接诊状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本年度累计报销金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAccumulamt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Accumulamt_hp",  getAccumulamt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本年度累计报销金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本年度累计报销次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_hp",  getTimes_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("本年度累计报销次数");
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
	 * 与户主关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHousemaster_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Housemaster_rel",  getHousemaster_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与户主关系");
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferraltp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referraltp_code",  getReferraltp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MHI_REFERRALTP a0b6","id_referraltp=id_referraltp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReferraltp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Referraltp_name",  getReferraltp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MHI_REFERRALTP a0b6","id_referraltp=id_referraltp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取转诊单申请主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_hpreferralCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_hpreferral");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转诊单申请主键"); 
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
	 * 获取患者主键Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者主键Id"); 
		return column;
	}
	/**
	 * 获取就诊主键Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊主键Id"); 
		return column;
	}
	/**
	 * 获取就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ent_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊编码"); 
		return column;
	}
	/**
	 * 获取转诊单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferralcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referralcode");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转诊单号"); 
		return column;
	}
	/**
	 * 获取个人编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPersoncodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Personcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人编号"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取疾病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDicodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dicode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病编码"); 
		return column;
	}
	/**
	 * 获取申请日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApplydateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Applydate");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请日期"); 
		return column;
	}
	/**
	 * 获取申请说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApplynoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Applynote");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请说明"); 
		return column;
	}
	/**
	 * 获取经办机构代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgenciescodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Agenciescode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经办机构代码"); 
		return column;
	}
	/**
	 * 获取转出医院代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosfromcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosfromcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转出医院代码"); 
		return column;
	}
	/**
	 * 获取转入医院代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosincodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosincode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入医院代码"); 
		return column;
	}
	/**
	 * 获取转诊状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferralstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referralstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转诊状态"); 
		return column;
	}
	/**
	 * 获取审核日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAuditdateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Auditdate");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核日期"); 
		return column;
	}
	/**
	 * 获取参合区（县）地区代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChareacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chareacode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参合区（县）地区代码"); 
		return column;
	}
	/**
	 * 获取疾病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDinameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病名称"); 
		return column;
	}
	/**
	 * 获取经办机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgenciesnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Agenciesname");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经办机构名称"); 
		return column;
	}
	/**
	 * 获取转出医院名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosfromnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosfromname");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转出医院名称"); 
		return column;
	}
	/**
	 * 获取转入医院名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosinnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosinname");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入医院名称"); 
		return column;
	}
	/**
	 * 获取审核人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAuditornameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Auditorname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人姓名"); 
		return column;
	}
	/**
	 * 获取审核说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAuditnoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Auditnote");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核说明"); 
		return column;
	}
	/**
	 * 获取参合区（县）地区名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChareanameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chareaname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参合区（县）地区名称"); 
		return column;
	}
	/**
	 * 获取审核状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAuditstatusnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Auditstatusname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核状态名称"); 
		return column;
	}
	/**
	 * 获取身份证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcard");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身份证号"); 
		return column;
	}
	/**
	 * 获取身份证号存储地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcardstoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcardstore");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身份证号存储地址"); 
		return column;
	}
	/**
	 * 获取医疗证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedicalcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medicalcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗证号"); 
		return column;
	}
	/**
	 * 获取医疗证号存储地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedicalcodestoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medicalcodestore");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗证号存储地址"); 
		return column;
	}
	/**
	 * 获取就诊日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("就诊日期"); 
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
	 * 获取机构联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstitucontactorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Institucontactor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构联系人"); 
		return column;
	}
	/**
	 * 获取机构联系方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstitucontactwayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Institucontactway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构联系方式"); 
		return column;
	}
	/**
	 * 获取机构联系邮箱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstitumailCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Institumail");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构联系邮箱"); 
		return column;
	}
	/**
	 * 获取生日表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirthdayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birthday");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生日"); 
		return column;
	}
	/**
	 * 获取转诊单创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferral_createtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referral_createtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转诊单创建时间"); 
		return column;
	}
	/**
	 * 获取更新时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferral_updatetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referral_updatetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("更新时间"); 
		return column;
	}
	/**
	 * 获取单病种代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrgs_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drgs_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单病种代码"); 
		return column;
	}
	/**
	 * 获取单病种名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrgs_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drgs_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单病种名称"); 
		return column;
	}
	/**
	 * 获取患者联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcontactorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcontactor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者联系人"); 
		return column;
	}
	/**
	 * 获取患者联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatphoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patphone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者联系电话"); 
		return column;
	}
	/**
	 * 获取民政救助标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCivilassist_identCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Civilassist_ident");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民政救助标识"); 
		return column;
	}
	/**
	 * 获取大病救助标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGraveassist_identCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Graveassist_ident");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大病救助标识"); 
		return column;
	}
	/**
	 * 获取家庭编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFamilycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Familycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭编码"); 
		return column;
	}
	/**
	 * 获取转入医院 2 代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosin2codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosin2code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入医院 2 代码"); 
		return column;
	}
	/**
	 * 获取转入医院 2 名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosin2nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosin2name");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入医院 2 名称"); 
		return column;
	}
	/**
	 * 获取转入医院 3 代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosin3codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosin3code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入医院 3 代码"); 
		return column;
	}
	/**
	 * 获取转入医院 3名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosin3nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosin3name");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入医院 3名称"); 
		return column;
	}
	/**
	 * 获取累计金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAccumulamtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Accumulamt");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("累计金额"); 
		return column;
	}
	/**
	 * 获取账户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBankaccount_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankaccount_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账户名称"); 
		return column;
	}
	/**
	 * 获取银行账号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBankaccount_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankaccount_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行账号"); 
		return column;
	}
	/**
	 * 获取开户银行名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBanknameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankname");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开户银行名称"); 
		return column;
	}
	/**
	 * 获取医疗付费方式代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaytp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paytp_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗付费方式代码"); 
		return column;
	}
	/**
	 * 获取医疗付费方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaytp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paytp_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗付费方式名称"); 
		return column;
	}
	/**
	 * 获取参合省代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChprovcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chprovcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参合省代码"); 
		return column;
	}
	/**
	 * 获取参合省名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChprovnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chprovname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参合省名称"); 
		return column;
	}
	/**
	 * 获取参合市代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChcitycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chcitycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参合市代码"); 
		return column;
	}
	/**
	 * 获取参合市名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChcitynameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chcityname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参合市名称"); 
		return column;
	}
	/**
	 * 获取导出日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExportdateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exportdate");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("导出日期"); 
		return column;
	}
	/**
	 * 获取数据类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDatatypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Datatype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据类型"); 
		return column;
	}
	/**
	 * 获取数据来源类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSourcetypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sourcetype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源类型"); 
		return column;
	}
	/**
	 * 获取国家平台表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSourcecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sourcecode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家平台"); 
		return column;
	}
	/**
	 * 获取符合国家行政区划的导 出参合区（县）地区代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTargetcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Targetcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("符合国家行政区划的导 出参合区（县）地区代码"); 
		return column;
	}
	/**
	 * 获取转诊类型代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_referraltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_referraltp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转诊类型代码"); 
		return column;
	}
	/**
	 * 获取接诊状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接诊状态"); 
		return column;
	}
	/**
	 * 获取本年度累计报销金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAccumulamt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Accumulamt_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本年度累计报销金额"); 
		return column;
	}
	/**
	 * 获取本年度累计报销次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_hp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("本年度累计报销次数"); 
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
	 * 获取与户主关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHousemaster_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Housemaster_rel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与户主关系"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取转诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferraltp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referraltp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转诊类型编码"); 
		return column;
	}
	/**
	 * 获取转诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReferraltp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Referraltp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转诊类型名称"); 
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
