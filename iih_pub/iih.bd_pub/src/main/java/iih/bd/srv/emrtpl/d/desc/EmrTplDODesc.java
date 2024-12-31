
package iih.bd.srv.emrtpl.d.desc;

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
 * 医疗记录模板 DO 元数据信息
 */
public class EmrTplDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.emrtpl.d.EmrTplDO";
	public static final String CLASS_DISPALYNAME = "医疗记录模板";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrtpl";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrtpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmrTplDODesc(){
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
		this.setKeyDesc(getId_mrtplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mrtplADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getVerADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getCode_stdADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_basemrtplADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_mredADesc(tblDesc));
		this.add(getFunc_editor_arguADesc(tblDesc));
		this.add(getId_owtpADesc(tblDesc));
		this.add(getSd_owtpADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getId_deptADesc(tblDesc));
		this.add(getId_su_mrptlADesc(tblDesc));
		this.add(getSd_su_mrptlADesc(tblDesc));
		this.add(getActivestateADesc(tblDesc));
		this.add(getId_emp_submitADesc(tblDesc));
		this.add(getDt_submitADesc(tblDesc));
		this.add(getId_emp_reviewADesc(tblDesc));
		this.add(getDt_reviewADesc(tblDesc));
		this.add(getId_emp_activeADesc(tblDesc));
		this.add(getDt_activeADesc(tblDesc));
		this.add(getId_emp_stopADesc(tblDesc));
		this.add(getDt_stopADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getTitle_expADesc(tblDesc));
		this.add(getName_prnADesc(tblDesc));
		this.add(getKeywordsADesc(tblDesc));
		this.add(getCriteriaxmlADesc(tblDesc));
		this.add(getTask_idADesc(tblDesc));
		this.add(getId_wf_typeADesc(tblDesc));
		this.add(getWf_prodefADesc(tblDesc));
		this.add(getId_diADesc(tblDesc));
		this.add(getName_diADesc(tblDesc));
		this.add(getId_mr_sign_lvlADesc(tblDesc));
		this.add(getId_ownorgADesc(tblDesc));
		this.add(getNewtopADesc(tblDesc));
		this.add(getNewendADesc(tblDesc));
		this.add(getSign_suggestionADesc(tblDesc));
		this.add(getIsdefaultADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getName_ownADesc(tblDesc));
		this.add(getOrderidADesc(tblDesc));
		this.add(getRecallreasonADesc(tblDesc));
		this.add(getId_mr_signlvlADesc(tblDesc));
		this.add(getSd_mr_signlvlADesc(tblDesc));
		this.add(getId_mrsigntplADesc(tblDesc));
		this.add(getFg_need_pat_signADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getMrtp_codeADesc(tblDesc));
		this.add(getMrtp_nameADesc(tblDesc));
		this.add(getBase_codeADesc(tblDesc));
		this.add(getBase_nameADesc(tblDesc));
		this.add(getBase_idmredADesc(tblDesc));
		this.add(getBase_id_mrtplstmdADesc(tblDesc));
		this.add(getBase_sd_mrtplstmdADesc(tblDesc));
		this.add(getEdit_codeADesc(tblDesc));
		this.add(getEdit_nameADesc(tblDesc));
		this.add(getFunc_editorADesc(tblDesc));
		this.add(getSd_mrfmtpADesc(tblDesc));
		this.add(getSd_mrtplstmdADesc(tblDesc));
		this.add(getName_classADesc(tblDesc));
		this.add(getDll_pathADesc(tblDesc));
		this.add(getOwtp_codeADesc(tblDesc));
		this.add(getOwtp_nameADesc(tblDesc));
		this.add(getEmp_nameADesc(tblDesc));
		this.add(getEmp_codeADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
		this.add(getMrtpl_codeADesc(tblDesc));
		this.add(getMrtpl_nameADesc(tblDesc));
		this.add(getEmp_sub_nameADesc(tblDesc));
		this.add(getEmp_sub_codeADesc(tblDesc));
		this.add(getEmp_rev_nameADesc(tblDesc));
		this.add(getEmp_rev_codeADesc(tblDesc));
		this.add(getEmp_active_nameADesc(tblDesc));
		this.add(getEmp_active_codeADesc(tblDesc));
		this.add(getEmp_stop_nameADesc(tblDesc));
		this.add(getEmp_stop_codeADesc(tblDesc));
		this.add(getCreby_nameADesc(tblDesc));
		this.add(getCreby_codeADesc(tblDesc));
		this.add(getModti_nameADesc(tblDesc));
		this.add(getModti_codeADesc(tblDesc));
		this.add(getWf_typecodeADesc(tblDesc));
		this.add(getWf_typenameADesc(tblDesc));
		this.add(getDi_codeADesc(tblDesc));
		this.add(getDi_nameADesc(tblDesc));
		this.add(getSign_codeADesc(tblDesc));
		this.add(getSign_nameADesc(tblDesc));
		this.add(getSign_flowtypeADesc(tblDesc));
		this.add(getGroup_codeADesc(tblDesc));
		this.add(getGroup_nameADesc(tblDesc));
		this.add(getMr_signlvl_codeADesc(tblDesc));
		this.add(getMr_signlvl_nameADesc(tblDesc));
		this.add(getMrsigntpl_codeADesc(tblDesc));
		this.add(getMrsigntpl_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrtplCDesc(tblDesc));
		tblDesc.add(getId_mrtplCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getVerCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getCode_stdCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_basemrtplCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_mredCDesc(tblDesc));
		tblDesc.add(getFunc_editor_arguCDesc(tblDesc));
		tblDesc.add(getId_owtpCDesc(tblDesc));
		tblDesc.add(getSd_owtpCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getId_deptCDesc(tblDesc));
		tblDesc.add(getId_su_mrptlCDesc(tblDesc));
		tblDesc.add(getSd_su_mrptlCDesc(tblDesc));
		tblDesc.add(getActivestateCDesc(tblDesc));
		tblDesc.add(getId_emp_submitCDesc(tblDesc));
		tblDesc.add(getDt_submitCDesc(tblDesc));
		tblDesc.add(getId_emp_reviewCDesc(tblDesc));
		tblDesc.add(getDt_reviewCDesc(tblDesc));
		tblDesc.add(getId_emp_activeCDesc(tblDesc));
		tblDesc.add(getDt_activeCDesc(tblDesc));
		tblDesc.add(getId_emp_stopCDesc(tblDesc));
		tblDesc.add(getDt_stopCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getTitle_expCDesc(tblDesc));
		tblDesc.add(getName_prnCDesc(tblDesc));
		tblDesc.add(getKeywordsCDesc(tblDesc));
		tblDesc.add(getCriteriaxmlCDesc(tblDesc));
		tblDesc.add(getTask_idCDesc(tblDesc));
		tblDesc.add(getId_wf_typeCDesc(tblDesc));
		tblDesc.add(getWf_prodefCDesc(tblDesc));
		tblDesc.add(getId_diCDesc(tblDesc));
		tblDesc.add(getName_diCDesc(tblDesc));
		tblDesc.add(getId_mr_sign_lvlCDesc(tblDesc));
		tblDesc.add(getId_ownorgCDesc(tblDesc));
		tblDesc.add(getNewtopCDesc(tblDesc));
		tblDesc.add(getNewendCDesc(tblDesc));
		tblDesc.add(getSign_suggestionCDesc(tblDesc));
		tblDesc.add(getIsdefaultCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getName_ownCDesc(tblDesc));
		tblDesc.add(getOrderidCDesc(tblDesc));
		tblDesc.add(getRecallreasonCDesc(tblDesc));
		tblDesc.add(getId_mr_signlvlCDesc(tblDesc));
		tblDesc.add(getSd_mr_signlvlCDesc(tblDesc));
		tblDesc.add(getId_mrsigntplCDesc(tblDesc));
		tblDesc.add(getFg_need_pat_signCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗记录模板主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl",  getId_mrtplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板主键标识");
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
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 版本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ver",  getVerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("版本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板国家编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_stdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_std",  getCode_stdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板国家编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联基础模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_basemrtplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_basemrtpl",  getId_basemrtplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联基础模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 医疗记录模板描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mredADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mred",  getId_mredCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编辑器启动函数参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFunc_editor_arguADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Func_editor_argu",  getFunc_editor_arguCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器启动函数参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板所属类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_owtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_owtp",  getId_owtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板所属类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录模板所属类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_owtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_owtp",  getSd_owtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板所属类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属个人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属个人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept",  getId_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录模板状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_mrptlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_mrptl",  getId_su_mrptlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录模板状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_mrptlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_mrptl",  getSd_su_mrptlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getActivestateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Activestate",  getActivestateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提交人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_submitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_submit",  getId_emp_submitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提交人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 提交时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_submitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_submit",  getDt_submitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("提交时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_reviewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_review",  getId_emp_reviewCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
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
	private IAttrDesc getDt_reviewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_review",  getDt_reviewCDesc(tblDesc), this);
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
	 * 启用人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_active",  getId_emp_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("启用人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 启用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_active",  getDt_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("启用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停用人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_stop",  getId_emp_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("停用人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 停用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_stop",  getDt_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("停用时间");
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
	 * 标题表达式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitle_expADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title_exp",  getTitle_expCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标题表达式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_prn",  getName_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("打印名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板关键字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKeywordsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Keywords",  getKeywordsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板关键字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适用条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCriteriaxmlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Criteriaxml",  getCriteriaxmlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适用条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 任务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTask_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Task_id",  getTask_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("任务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wf_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wf_type",  getId_wf_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流程类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 流程定义属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWf_prodefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wf_prodef",  getWf_prodefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流程定义");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di",  getId_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di",  getName_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签级别类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_sign_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_sign_lvl",  getId_mr_sign_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签级别类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 全院ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ownorgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ownorg",  getId_ownorgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("全院ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 前新起一页属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNewtopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Newtop",  getNewtopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("前新起一页");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 后新起一页属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNewendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Newend",  getNewendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("后新起一页");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_suggestionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_suggestion",  getSign_suggestionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签意见");
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
	private IAttrDesc getIsdefaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Isdefault",  getIsdefaultCDesc(tblDesc), this);
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
	 * 集团ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_group",  getId_groupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_own",  getName_ownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 顺序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrderidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Orderid",  getOrderidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("顺序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 召回原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRecallreasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Recallreason",  getRecallreasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("召回原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_signlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_signlvl",  getId_mr_signlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审签登记sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mr_signlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mr_signlvl",  getSd_mr_signlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签登记sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历签名模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrsigntplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrsigntpl",  getId_mrsigntplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历签名模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者签署属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_need_pat_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_need_pat_sign",  getFg_need_pat_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("患者签署");
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
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b1","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b1","id_grp=id_grp","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtp_code",  getMrtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b3","id_mrtp=id_mrtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtp_name",  getMrtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b3","id_mrtp=id_mrtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基础模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBase_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Base_code",  getBase_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基础模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_base_mrtpl a0b15","id_basemrtpl=id_basemrtpl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基础模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBase_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Base_name",  getBase_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基础模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_base_mrtpl a0b15","id_basemrtpl=id_basemrtpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBase_idmredADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Base_idmred",  getBase_idmredCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_base_mrtpl a0b15","id_basemrtpl=id_basemrtpl","id_mred"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录模板存储模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBase_id_mrtplstmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Base_id_mrtplstmd",  getBase_id_mrtplstmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板存储模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_base_mrtpl a0b15","id_basemrtpl=id_basemrtpl","id_mrtplstmd"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录模板存储模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBase_sd_mrtplstmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Base_sd_mrtplstmd",  getBase_sd_mrtplstmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板存储模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_base_mrtpl a0b15","id_basemrtpl=id_basemrtpl","sd_mrtplstmd"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEdit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Edit_code",  getEdit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEdit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Edit_name",  getEdit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器启动函数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFunc_editorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Func_editor",  getFunc_editorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器启动函数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","func_editor"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器记录格式类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrfmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrfmtp",  getSd_mrfmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器记录格式类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","sd_mrfmtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器记录存储模属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrtplstmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrtplstmd",  getSd_mrtplstmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器记录存储模");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","sd_mrtplstmd"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器函数类名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_class",  getName_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器函数类名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","name_class"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DLL全路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDll_pathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dll_path",  getDll_pathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DLL全路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","dll_path"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOwtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Owtp_code",  getOwtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_owtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOwtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Owtp_name",  getOwtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_owtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_name",  getEmp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_emp=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_code",  getEmp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_emp=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_code",  getDept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_name",  getDept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtpl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtpl_code",  getMrtpl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_su_mrptl=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtpl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtpl_name",  getMrtpl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_su_mrptl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sub_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sub_name",  getEmp_sub_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_emp_submit=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sub_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sub_code",  getEmp_sub_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_emp_submit=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_rev_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_rev_name",  getEmp_rev_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b10","id_emp_review=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_rev_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_rev_code",  getEmp_rev_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b10","id_emp_review=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_active_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_active_name",  getEmp_active_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b11","id_emp_active=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_active_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_active_code",  getEmp_active_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b11","id_emp_active=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_stop_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_stop_name",  getEmp_stop_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b12","id_emp_stop=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_stop_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_stop_code",  getEmp_stop_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b12","id_emp_stop=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreby_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Creby_name",  getCreby_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b13","createdby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreby_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Creby_code",  getCreby_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b13","createdby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModti_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modti_name",  getModti_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b14","modifiedby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModti_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modti_code",  getModti_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b14","modifiedby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWf_typecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wf_typecode",  getWf_typecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"wf_flwtype a0b17","id_wf_type=id_flowtype","typecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWf_typenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wf_typename",  getWf_typenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"wf_flwtype a0b17","id_wf_type=id_flowtype","typename"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_code",  getDi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b16","id_di=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_name",  getDi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b16","id_di=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_code",  getSign_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_reviewtp a0b18","id_mr_sign_lvl=id_reviewtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_name",  getSign_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_reviewtp a0b18","id_mr_sign_lvl=id_reviewtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审批流类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_flowtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_flowtype",  getSign_flowtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审批流类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_reviewtp a0b18","id_mr_sign_lvl=id_reviewtp","id_flowtype"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroup_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Group_code",  getGroup_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b19","id_group=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Group_name",  getGroup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b19","id_group=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_signlvl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_signlvl_code",  getMr_signlvl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mr_sign_type a0b21","id_mr_signlvl=id_mr_sign_type","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_signlvl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_signlvl_name",  getMr_signlvl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mr_sign_type a0b21","id_mr_signlvl=id_mr_sign_type","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 片段模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrsigntpl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrsigntpl_code",  getMrsigntpl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("片段模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl_sec a0b20","id_mrsigntpl=id_mrtplsec","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 片段模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrsigntpl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrsigntpl_name",  getMrsigntpl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("片段模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl_sec a0b20","id_mrsigntpl=id_mrtplsec","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗记录模板主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板主键标识"); 
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
	 * 获取医疗记录类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型"); 
		return column;
	}
	/**
	 * 获取版本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ver");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("版本"); 
		return column;
	}
	/**
	 * 获取医疗记录模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板编码"); 
		return column;
	}
	/**
	 * 获取医疗记录模板国家编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_stdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_std");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板国家编码"); 
		return column;
	}
	/**
	 * 获取医疗记录模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板名称"); 
		return column;
	}
	/**
	 * 获取关联基础模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_basemrtplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_basemrtpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联基础模板"); 
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
	 * 获取医疗记录模板描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板描述"); 
		return column;
	}
	/**
	 * 获取编辑器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mredCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mred");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器"); 
		return column;
	}
	/**
	 * 获取编辑器启动函数参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFunc_editor_arguCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Func_editor_argu");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器启动函数参数"); 
		return column;
	}
	/**
	 * 获取医疗记录模板所属类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_owtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_owtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板所属类型"); 
		return column;
	}
	/**
	 * 获取医疗记录模板所属类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_owtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_owtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板所属类型编码"); 
		return column;
	}
	/**
	 * 获取所属个人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属个人"); 
		return column;
	}
	/**
	 * 获取所属科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属科室"); 
		return column;
	}
	/**
	 * 获取医疗记录模板状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_mrptlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_mrptl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板状态"); 
		return column;
	}
	/**
	 * 获取医疗记录模板状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_mrptlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_mrptl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板状态编码"); 
		return column;
	}
	/**
	 * 获取启用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getActivestateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Activestate");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用状态"); 
		return column;
	}
	/**
	 * 获取提交人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_submitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_submit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提交人"); 
		return column;
	}
	/**
	 * 获取提交时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_submitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_submit");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("提交时间"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_reviewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_review");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_reviewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_review");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取启用人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_active");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("启用人"); 
		return column;
	}
	/**
	 * 获取启用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_active");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用时间"); 
		return column;
	}
	/**
	 * 获取停用人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_stop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("停用人"); 
		return column;
	}
	/**
	 * 获取停用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_stop");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停用时间"); 
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
	 * 获取标题表达式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitle_expCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title_exp");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标题表达式"); 
		return column;
	}
	/**
	 * 获取打印名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_prn");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("打印名称"); 
		return column;
	}
	/**
	 * 获取模板关键字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKeywordsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Keywords");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板关键字"); 
		return column;
	}
	/**
	 * 获取适用条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCriteriaxmlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Criteriaxml");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适用条件"); 
		return column;
	}
	/**
	 * 获取任务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTask_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Task_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("任务编码"); 
		return column;
	}
	/**
	 * 获取流程类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wf_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wf_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程类型"); 
		return column;
	}
	/**
	 * 获取流程定义表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWf_prodefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wf_prodef");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程定义"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取审签级别类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_sign_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_sign_lvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签级别类型"); 
		return column;
	}
	/**
	 * 获取全院ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ownorgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ownorg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("全院ID"); 
		return column;
	}
	/**
	 * 获取前新起一页表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNewtopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Newtop");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("前新起一页"); 
		return column;
	}
	/**
	 * 获取后新起一页表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNewendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Newend");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("后新起一页"); 
		return column;
	}
	/**
	 * 获取审签意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_suggestionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_suggestion");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签意见"); 
		return column;
	}
	/**
	 * 获取默认模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIsdefaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Isdefault");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认模板"); 
		return column;
	}
	/**
	 * 获取集团ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_group");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团ID"); 
		return column;
	}
	/**
	 * 获取所属名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_own");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属名称"); 
		return column;
	}
	/**
	 * 获取顺序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrderidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Orderid");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("顺序号"); 
		return column;
	}
	/**
	 * 获取召回原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRecallreasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Recallreason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("召回原因"); 
		return column;
	}
	/**
	 * 获取审签等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_signlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_signlvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签等级id"); 
		return column;
	}
	/**
	 * 获取审签登记sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mr_signlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mr_signlvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签登记sd"); 
		return column;
	}
	/**
	 * 获取病历签名模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrsigntplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrsigntpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历签名模板"); 
		return column;
	}
	/**
	 * 获取患者签署表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_need_pat_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_need_pat_sign");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者签署"); 
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
	 * 获取集团名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团名称"); 
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
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
		return column;
	}
	/**
	 * 获取基础模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBase_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Base_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基础模板编码"); 
		return column;
	}
	/**
	 * 获取基础模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBase_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Base_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基础模板名称"); 
		return column;
	}
	/**
	 * 获取编辑器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBase_idmredCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Base_idmred");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器"); 
		return column;
	}
	/**
	 * 获取医疗记录模板存储模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBase_id_mrtplstmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Base_id_mrtplstmd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板存储模式"); 
		return column;
	}
	/**
	 * 获取医疗记录模板存储模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBase_sd_mrtplstmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Base_sd_mrtplstmd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板存储模式编码"); 
		return column;
	}
	/**
	 * 获取编辑器编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEdit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Edit_code");
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
	private IColumnDesc getEdit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Edit_name");
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
	private IColumnDesc getFunc_editorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Func_editor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器启动函数"); 
		return column;
	}
	/**
	 * 获取编辑器记录格式类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrfmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrfmtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器记录格式类型"); 
		return column;
	}
	/**
	 * 获取编辑器记录存储模表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrtplstmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrtplstmd");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("编辑器记录存储模"); 
		return column;
	}
	/**
	 * 获取编辑器函数类名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_class");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器函数类名"); 
		return column;
	}
	/**
	 * 获取DLL全路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDll_pathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dll_path");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DLL全路径"); 
		return column;
	}
	/**
	 * 获取所属类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOwtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Owtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类型编码"); 
		return column;
	}
	/**
	 * 获取所属类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOwtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Owtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类型名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_name");
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
	private IColumnDesc getEmp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取部门编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门编码"); 
		return column;
	}
	/**
	 * 获取部门名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtpl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtpl_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取模板状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtpl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtpl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板状态名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_sub_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sub_name");
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
	private IColumnDesc getEmp_sub_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sub_code");
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
	private IColumnDesc getEmp_rev_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_rev_name");
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
	private IColumnDesc getEmp_rev_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_rev_code");
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
	private IColumnDesc getEmp_active_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_active_name");
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
	private IColumnDesc getEmp_active_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_active_code");
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
	private IColumnDesc getEmp_stop_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_stop_name");
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
	private IColumnDesc getEmp_stop_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_stop_code");
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
	private IColumnDesc getCreby_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Creby_name");
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
	private IColumnDesc getCreby_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Creby_code");
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
	private IColumnDesc getModti_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modti_name");
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
	private IColumnDesc getModti_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modti_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWf_typecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wf_typecode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("类型编码"); 
		return column;
	}
	/**
	 * 获取类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWf_typenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wf_typename");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("类型名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_code");
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
	private IColumnDesc getDi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_name");
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
	private IColumnDesc getSign_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_code");
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
	private IColumnDesc getSign_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取审批流类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_flowtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_flowtype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审批流类型"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGroup_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Group_code");
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
	private IColumnDesc getGroup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Group_name");
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
	private IColumnDesc getMr_signlvl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_signlvl_code");
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
	private IColumnDesc getMr_signlvl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_signlvl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取片段模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrsigntpl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrsigntpl_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("片段模板编码"); 
		return column;
	}
	/**
	 * 获取片段模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrsigntpl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrsigntpl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("片段模板名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_mrtpl");
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
