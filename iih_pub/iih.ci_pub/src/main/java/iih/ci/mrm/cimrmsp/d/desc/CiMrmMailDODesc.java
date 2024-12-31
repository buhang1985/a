
package iih.ci.mrm.cimrmsp.d.desc;

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
 * 病案邮寄 DO 元数据信息
 */
public class CiMrmMailDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.cimrmsp.d.CiMrmMailDO";
	public static final String CLASS_DISPALYNAME = "病案邮寄";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_sp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ci_mrm_sp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrmMailDODesc(){
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
		this.setKeyDesc(getId_ci_mrm_spADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ci_mrm_spADesc(tblDesc));
		this.add(getId_ci_amrADesc(tblDesc));
		this.add(getMa_contactsADesc(tblDesc));
		this.add(getMa_code_zipADesc(tblDesc));
		this.add(getMa_telephoneADesc(tblDesc));
		this.add(getMa_addADesc(tblDesc));
		this.add(getAgentADesc(tblDesc));
		this.add(getId_mrpi_relationshipADesc(tblDesc));
		this.add(getSd_mrpi_relationshipADesc(tblDesc));
		this.add(getAdvance_payADesc(tblDesc));
		this.add(getReceivable_payADesc(tblDesc));
		this.add(getCopiesADesc(tblDesc));
		this.add(getId_bd_mrm_ptADesc(tblDesc));
		this.add(getId_purposeADesc(tblDesc));
		this.add(getSd_purposeADesc(tblDesc));
		this.add(getCode_fileADesc(tblDesc));
		this.add(getId_psn_registerADesc(tblDesc));
		this.add(getDt_registerADesc(tblDesc));
		this.add(getId_psn_confirmADesc(tblDesc));
		this.add(getDt_confirmADesc(tblDesc));
		this.add(getId_mail_stateADesc(tblDesc));
		this.add(getSd_mail_stateADesc(tblDesc));
		this.add(getId_mail_tpADesc(tblDesc));
		this.add(getSd_mail_tpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getMrm_pt_nameADesc(tblDesc));
		this.add(getMrm_pt_codeADesc(tblDesc));
		this.add(getPsn_register_codeADesc(tblDesc));
		this.add(getPsn_register_nameADesc(tblDesc));
		this.add(getPsn_confirm_codeADesc(tblDesc));
		this.add(getPsn_confirm_nameADesc(tblDesc));
		this.add(getMail_state_codeADesc(tblDesc));
		this.add(getMail_state_nameADesc(tblDesc));
		this.add(getMail_tp_codeADesc(tblDesc));
		this.add(getMail_tp_nameADesc(tblDesc));
		this.add(getModifiedby_nameADesc(tblDesc));
		this.add(getModifiedby_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ci_mrm_spCDesc(tblDesc));
		tblDesc.add(getId_ci_mrm_spCDesc(tblDesc));
		tblDesc.add(getId_ci_amrCDesc(tblDesc));
		tblDesc.add(getMa_contactsCDesc(tblDesc));
		tblDesc.add(getMa_code_zipCDesc(tblDesc));
		tblDesc.add(getMa_telephoneCDesc(tblDesc));
		tblDesc.add(getMa_addCDesc(tblDesc));
		tblDesc.add(getAgentCDesc(tblDesc));
		tblDesc.add(getId_mrpi_relationshipCDesc(tblDesc));
		tblDesc.add(getSd_mrpi_relationshipCDesc(tblDesc));
		tblDesc.add(getAdvance_payCDesc(tblDesc));
		tblDesc.add(getReceivable_payCDesc(tblDesc));
		tblDesc.add(getCopiesCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_ptCDesc(tblDesc));
		tblDesc.add(getId_purposeCDesc(tblDesc));
		tblDesc.add(getSd_purposeCDesc(tblDesc));
		tblDesc.add(getCode_fileCDesc(tblDesc));
		tblDesc.add(getId_psn_registerCDesc(tblDesc));
		tblDesc.add(getDt_registerCDesc(tblDesc));
		tblDesc.add(getId_psn_confirmCDesc(tblDesc));
		tblDesc.add(getDt_confirmCDesc(tblDesc));
		tblDesc.add(getId_mail_stateCDesc(tblDesc));
		tblDesc.add(getSd_mail_stateCDesc(tblDesc));
		tblDesc.add(getId_mail_tpCDesc(tblDesc));
		tblDesc.add(getSd_mail_tpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ci_mrm_spADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ci_mrm_sp",  getId_ci_mrm_spCDesc(tblDesc), this);
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
	 * 病案表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ci_amrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ci_amr",  getId_ci_amrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案表主键");
		attrDesc.setNullable(false);
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
	private IAttrDesc getMa_contactsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ma_contacts",  getMa_contactsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 邮编属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMa_code_zipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ma_code_zip",  getMa_code_zipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮编");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMa_telephoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ma_telephone",  getMa_telephoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 邮寄地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMa_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ma_add",  getMa_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮寄地址");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 代理人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Agent",  getAgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("代理人");
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
	private IAttrDesc getId_mrpi_relationshipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrpi_relationship",  getId_mrpi_relationshipCDesc(tblDesc), this);
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
	 * 关系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrpi_relationshipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrpi_relationship",  getSd_mrpi_relationshipCDesc(tblDesc), this);
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
	 * 预收金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdvance_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advance_pay",  getAdvance_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("预收金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应收金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReceivable_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Receivable_pay",  getReceivable_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("应收金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复印份数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCopiesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Copies",  getCopiesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("复印份数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印模板表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_ptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_pt",  getId_bd_mrm_ptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("打印模板表主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用途属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_purpose",  getId_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用途");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用途编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_purpose",  getSd_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用途编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文件系统编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_fileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_file",  getCode_fileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文件系统编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_registerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_register",  getId_psn_registerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记人");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 登记时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_registerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_register",  getDt_registerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("登记时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_confirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_confirm",  getId_psn_confirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 确认时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_confirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_confirm",  getDt_confirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("确认时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 邮寄状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mail_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mail_state",  getId_mail_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮寄状态");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 邮寄状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mail_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mail_state",  getSd_mail_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮寄状态编码");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 邮寄方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mail_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mail_tp",  getId_mail_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮寄方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 邮寄方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mail_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mail_tp",  getSd_mail_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("邮寄方式编码");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrm_pt_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrm_pt_name",  getMrm_pt_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_pt a0b3","id_bd_mrm_pt=id_bd_mrm_pt","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrm_pt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrm_pt_code",  getMrm_pt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_pt a0b3","id_bd_mrm_pt=id_bd_mrm_pt","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_register_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_register_code",  getPsn_register_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_psn_register=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_register_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_register_name",  getPsn_register_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_psn_register=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_confirm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_confirm_code",  getPsn_confirm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_psn_confirm=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_confirm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_confirm_name",  getPsn_confirm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_psn_confirm=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMail_state_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mail_state_code",  getMail_state_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_mail_state=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMail_state_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mail_state_name",  getMail_state_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_mail_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMail_tp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mail_tp_code",  getMail_tp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_mail_tp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMail_tp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mail_tp_name",  getMail_tp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_mail_tp=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","modifiedby=id_user","name"});
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
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","modifiedby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ci_mrm_spCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ci_mrm_sp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取病案表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ci_amrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ci_amr");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病案表主键"); 
		return column;
	}
	/**
	 * 获取联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMa_contactsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ma_contacts");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人"); 
		return column;
	}
	/**
	 * 获取邮编表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMa_code_zipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ma_code_zip");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮编"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMa_telephoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ma_telephone");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取邮寄地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMa_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ma_add");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮寄地址"); 
		return column;
	}
	/**
	 * 获取代理人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Agent");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("代理人"); 
		return column;
	}
	/**
	 * 获取关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrpi_relationshipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrpi_relationship");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关系"); 
		return column;
	}
	/**
	 * 获取关系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrpi_relationshipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrpi_relationship");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关系编码"); 
		return column;
	}
	/**
	 * 获取预收金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdvance_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advance_pay");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("预收金额"); 
		return column;
	}
	/**
	 * 获取应收金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReceivable_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Receivable_pay");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("应收金额"); 
		return column;
	}
	/**
	 * 获取复印份数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCopiesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Copies");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("复印份数"); 
		return column;
	}
	/**
	 * 获取打印模板表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_ptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_pt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("打印模板表主键"); 
		return column;
	}
	/**
	 * 获取用途表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_purpose");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用途"); 
		return column;
	}
	/**
	 * 获取用途编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_purpose");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用途编码"); 
		return column;
	}
	/**
	 * 获取文件系统编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_fileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_file");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文件系统编号"); 
		return column;
	}
	/**
	 * 获取登记人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_registerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_register");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记人"); 
		return column;
	}
	/**
	 * 获取登记时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_registerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_register");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("登记时间"); 
		return column;
	}
	/**
	 * 获取确认人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_confirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_confirm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认人"); 
		return column;
	}
	/**
	 * 获取确认时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_confirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_confirm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("确认时间"); 
		return column;
	}
	/**
	 * 获取邮寄状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mail_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mail_state");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮寄状态"); 
		return column;
	}
	/**
	 * 获取邮寄状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mail_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mail_state");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮寄状态编码"); 
		return column;
	}
	/**
	 * 获取邮寄方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mail_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mail_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮寄方式"); 
		return column;
	}
	/**
	 * 获取邮寄方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mail_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mail_tp");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("邮寄方式编码"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrm_pt_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrm_pt_name");
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
	private IColumnDesc getMrm_pt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrm_pt_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPsn_register_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_register_code");
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
	private IColumnDesc getPsn_register_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_register_name");
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
	private IColumnDesc getPsn_confirm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_confirm_code");
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
	private IColumnDesc getPsn_confirm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_confirm_name");
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
	private IColumnDesc getMail_state_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mail_state_code");
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
	private IColumnDesc getMail_state_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mail_state_name");
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
	private IColumnDesc getMail_tp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mail_tp_code");
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
	private IColumnDesc getMail_tp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mail_tp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
