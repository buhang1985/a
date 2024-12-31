
package iih.ci.mrm.cimrfpblcatado.d.desc;

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
 * 病案编目费用 DO 元数据信息
 */
public class CiMrFpBlCataDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.cimrfpblcatado.d.CiMrFpBlCataDO";
	public static final String CLASS_DISPALYNAME = "病案编目费用";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_BL_CATA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrfpbl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpBlCataDODesc(){
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
		this.setKeyDesc(getId_mrfpblADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mrfpblADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_mrfpADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_srv_blADesc(tblDesc));
		this.add(getName_srv_blADesc(tblDesc));
		this.add(getAmountADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCms_gmsfeeADesc(tblDesc));
		this.add(getCms_gtofeeADesc(tblDesc));
		this.add(getCms_nurfeeADesc(tblDesc));
		this.add(getCms_otherfeeADesc(tblDesc));
		this.add(getCms_spamountADesc(tblDesc));
		this.add(getDi_pdifeeADesc(tblDesc));
		this.add(getDi_ldifeeADesc(tblDesc));
		this.add(getDi_idifeeADesc(tblDesc));
		this.add(getDi_cdifeeADesc(tblDesc));
		this.add(getTc_nstpfeeADesc(tblDesc));
		this.add(getTc_cptfeeADesc(tblDesc));
		this.add(getTc_stfeeADesc(tblDesc));
		this.add(getTc_anfeeADesc(tblDesc));
		this.add(getTc_opfeeADesc(tblDesc));
		this.add(getRc_rcfeeADesc(tblDesc));
		this.add(getTcm_cmtfeeADesc(tblDesc));
		this.add(getWm_wmfeeADesc(tblDesc));
		this.add(getWm_agfeeADesc(tblDesc));
		this.add(getTcmt_cpmfeeADesc(tblDesc));
		this.add(getTcmt_chmfeeADesc(tblDesc));
		this.add(getBabp_bfeeADesc(tblDesc));
		this.add(getBabp_apfeeADesc(tblDesc));
		this.add(getBabp_gpfeeADesc(tblDesc));
		this.add(getBabp_bcffeeADesc(tblDesc));
		this.add(getBabp_cflfeeADesc(tblDesc));
		this.add(getSc_dmmfifeeADesc(tblDesc));
		this.add(getSc_dmmftfeeADesc(tblDesc));
		this.add(getSc_dmmfsfeeADesc(tblDesc));
		this.add(getOc_ocfeeADesc(tblDesc));
		this.add(getCms_decnfeeADesc(tblDesc));
		this.add(getCms_decfeeADesc(tblDesc));
		this.add(getTcm_difeeADesc(tblDesc));
		this.add(getTcm_etfeeADesc(tblDesc));
		this.add(getTcm_bffeeADesc(tblDesc));
		this.add(getTcm_tcmfeeADesc(tblDesc));
		this.add(getTcm_mnpfeeADesc(tblDesc));
		this.add(getTcm_anrfeeADesc(tblDesc));
		this.add(getTcm_spcialfeeADesc(tblDesc));
		this.add(getTcm_otherfeeADesc(tblDesc));
		this.add(getTcm_allocationfeeADesc(tblDesc));
		this.add(getTcm_dcfeeADesc(tblDesc));
		this.add(getTcmt_ppafeeADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getDef10ADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrfpblCDesc(tblDesc));
		tblDesc.add(getId_mrfpblCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_mrfpCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_srv_blCDesc(tblDesc));
		tblDesc.add(getName_srv_blCDesc(tblDesc));
		tblDesc.add(getAmountCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCms_gmsfeeCDesc(tblDesc));
		tblDesc.add(getCms_gtofeeCDesc(tblDesc));
		tblDesc.add(getCms_nurfeeCDesc(tblDesc));
		tblDesc.add(getCms_otherfeeCDesc(tblDesc));
		tblDesc.add(getCms_spamountCDesc(tblDesc));
		tblDesc.add(getDi_pdifeeCDesc(tblDesc));
		tblDesc.add(getDi_ldifeeCDesc(tblDesc));
		tblDesc.add(getDi_idifeeCDesc(tblDesc));
		tblDesc.add(getDi_cdifeeCDesc(tblDesc));
		tblDesc.add(getTc_nstpfeeCDesc(tblDesc));
		tblDesc.add(getTc_cptfeeCDesc(tblDesc));
		tblDesc.add(getTc_stfeeCDesc(tblDesc));
		tblDesc.add(getTc_anfeeCDesc(tblDesc));
		tblDesc.add(getTc_opfeeCDesc(tblDesc));
		tblDesc.add(getRc_rcfeeCDesc(tblDesc));
		tblDesc.add(getTcm_cmtfeeCDesc(tblDesc));
		tblDesc.add(getWm_wmfeeCDesc(tblDesc));
		tblDesc.add(getWm_agfeeCDesc(tblDesc));
		tblDesc.add(getTcmt_cpmfeeCDesc(tblDesc));
		tblDesc.add(getTcmt_chmfeeCDesc(tblDesc));
		tblDesc.add(getBabp_bfeeCDesc(tblDesc));
		tblDesc.add(getBabp_apfeeCDesc(tblDesc));
		tblDesc.add(getBabp_gpfeeCDesc(tblDesc));
		tblDesc.add(getBabp_bcffeeCDesc(tblDesc));
		tblDesc.add(getBabp_cflfeeCDesc(tblDesc));
		tblDesc.add(getSc_dmmfifeeCDesc(tblDesc));
		tblDesc.add(getSc_dmmftfeeCDesc(tblDesc));
		tblDesc.add(getSc_dmmfsfeeCDesc(tblDesc));
		tblDesc.add(getOc_ocfeeCDesc(tblDesc));
		tblDesc.add(getCms_decnfeeCDesc(tblDesc));
		tblDesc.add(getCms_decfeeCDesc(tblDesc));
		tblDesc.add(getTcm_difeeCDesc(tblDesc));
		tblDesc.add(getTcm_etfeeCDesc(tblDesc));
		tblDesc.add(getTcm_bffeeCDesc(tblDesc));
		tblDesc.add(getTcm_tcmfeeCDesc(tblDesc));
		tblDesc.add(getTcm_mnpfeeCDesc(tblDesc));
		tblDesc.add(getTcm_anrfeeCDesc(tblDesc));
		tblDesc.add(getTcm_spcialfeeCDesc(tblDesc));
		tblDesc.add(getTcm_otherfeeCDesc(tblDesc));
		tblDesc.add(getTcm_allocationfeeCDesc(tblDesc));
		tblDesc.add(getTcm_dcfeeCDesc(tblDesc));
		tblDesc.add(getTcmt_ppafeeCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getDef10CDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院病案编目费用ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpblADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfpbl",  getId_mrfpblCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编目费用ID");
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
	 * 住院病历首页属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfp",  getId_mrfpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病历首页");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srv_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv_bl",  getId_srv_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费用项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srv_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv_bl",  getName_srv_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费用项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总费用金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount",  getAmountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总费用金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊号");
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
	 * 综合医疗服务类_一般医疗服务费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_gmsfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_gmsfee",  getCms_gmsfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_一般医疗服务费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 综合医疗服务类_一般治疗操作费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_gtofeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_gtofee",  getCms_gtofeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_一般治疗操作费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 综合医疗服务类_护理费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_nurfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_nurfee",  getCms_nurfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_护理费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 综合医疗服务类_其他费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_otherfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_otherfee",  getCms_otherfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_其他费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 综合医疗服务类_自付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_spamountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_spamount",  getCms_spamountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_自付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断类_病理诊断费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_pdifeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_pdifee",  getDi_pdifeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("诊断类_病理诊断费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断类_实验室诊断费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_ldifeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_ldifee",  getDi_ldifeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("诊断类_实验室诊断费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断类_影像学诊断费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_idifeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_idifee",  getDi_idifeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("诊断类_影像学诊断费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断类_临床诊断项目费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_cdifeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_cdifee",  getDi_cdifeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("诊断类_临床诊断项目费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗类_非手术治疗项目费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_nstpfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_nstpfee",  getTc_nstpfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("治疗类_非手术治疗项目费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗类_临床物理治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_cptfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_cptfee",  getTc_cptfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("治疗类_临床物理治疗费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗类_手术治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_stfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_stfee",  getTc_stfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("治疗类_手术治疗费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗类_麻醉费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_anfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_anfee",  getTc_anfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("治疗类_麻醉费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗类_手术费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_opfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_opfee",  getTc_opfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("治疗类_手术费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 康复类_康复费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRc_rcfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rc_rcfee",  getRc_rcfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("康复类_康复费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_中医治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_cmtfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_cmtfee",  getTcm_cmtfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_中医治疗费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西药类_西药费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWm_wmfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wm_wmfee",  getWm_wmfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("西药类_西药费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西药类_抗菌药物费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWm_agfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wm_agfee",  getWm_agfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("西药类_抗菌药物费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中药类_中成药费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcmt_cpmfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcmt_cpmfee",  getTcmt_cpmfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中药类_中成药费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中药类_中草药费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcmt_chmfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcmt_chmfee",  getTcmt_chmfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中药类_中草药费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液和血液制品类_血液费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBabp_bfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Babp_bfee",  getBabp_bfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血液和血液制品类_血液费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液和血液制品类_白蛋白类制品费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBabp_apfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Babp_apfee",  getBabp_apfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血液和血液制品类_白蛋白类制品费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液和血液制品类_球蛋白类制品费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBabp_gpfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Babp_gpfee",  getBabp_gpfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血液和血液制品类_球蛋白类制品费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液和血液制品类_凝血因子类制品费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBabp_bcffeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Babp_bcffee",  getBabp_bcffeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血液和血液制品类_凝血因子类制品费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液和血液制品类_细胞因子类制品费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBabp_cflfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Babp_cflfee",  getBabp_cflfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血液和血液制品类_细胞因子类制品费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 耗材类_检查用一次性医用材料费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_dmmfifeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_dmmfifee",  getSc_dmmfifeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("耗材类_检查用一次性医用材料费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 耗材类_治疗用一次性医用材料费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_dmmftfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_dmmftfee",  getSc_dmmftfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("耗材类_治疗用一次性医用材料费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 耗材类_手术用一次性医用材料费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_dmmfsfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_dmmfsfee",  getSc_dmmfsfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("耗材类_手术用一次性医用材料费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他类_其他费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOc_ocfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oc_ocfee",  getOc_ocfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其他类_其他费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 综合医疗服务类_中医辨证论治费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_decnfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_decnfee",  getCms_decnfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_中医辨证论治费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 综合医疗服务类_中医辨证论治会诊费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCms_decfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cms_decfee",  getCms_decfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("综合医疗服务类_中医辨证论治会诊费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_中医诊断费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_difeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_difee",  getTcm_difeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_中医诊断费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_外治费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_etfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_etfee",  getTcm_etfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_外治费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_骨伤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_bffeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_bffee",  getTcm_bffeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_骨伤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_针刺与灸法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_tcmfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_tcmfee",  getTcm_tcmfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_针刺与灸法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_推拿治疗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_mnpfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_mnpfee",  getTcm_mnpfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_推拿治疗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_肛肠治疗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_anrfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_anrfee",  getTcm_anrfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_肛肠治疗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_特殊治疗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_spcialfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_spcialfee",  getTcm_spcialfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_特殊治疗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_otherfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_otherfee",  getTcm_otherfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_特殊调配加工属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_allocationfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_allocationfee",  getTcm_allocationfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_特殊调配加工");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医类_辨证施膳属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcm_dcfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcm_dcfee",  getTcm_dcfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中医类_辨证施膳");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中药类_制剂费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTcmt_ppafeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tcmt_ppafee",  getTcmt_ppafeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("中药类_制剂费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam51属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam51");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam52属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam52");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam53属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam53");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam54属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam54");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam55属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam55");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam56属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam56");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam57属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam57");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam58属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam58");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam59属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam59");
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
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
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
	 * 获取住院病案编目费用ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpblCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfpbl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院病案编目费用ID"); 
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
	 * 获取住院病历首页表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病历首页"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取费用项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srv_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv_bl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费用项目编码"); 
		return column;
	}
	/**
	 * 获取费用项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srv_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv_bl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费用项目名称"); 
		return column;
	}
	/**
	 * 获取总费用金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总费用金额"); 
		return column;
	}
	/**
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
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
	 * 获取综合医疗服务类_一般医疗服务费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_gmsfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_gmsfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_一般医疗服务费"); 
		return column;
	}
	/**
	 * 获取综合医疗服务类_一般治疗操作费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_gtofeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_gtofee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_一般治疗操作费"); 
		return column;
	}
	/**
	 * 获取综合医疗服务类_护理费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_nurfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_nurfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_护理费"); 
		return column;
	}
	/**
	 * 获取综合医疗服务类_其他费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_otherfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_otherfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_其他费用"); 
		return column;
	}
	/**
	 * 获取综合医疗服务类_自付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_spamountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_spamount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_自付金额"); 
		return column;
	}
	/**
	 * 获取诊断类_病理诊断费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_pdifeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_pdifee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("诊断类_病理诊断费"); 
		return column;
	}
	/**
	 * 获取诊断类_实验室诊断费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_ldifeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_ldifee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("诊断类_实验室诊断费"); 
		return column;
	}
	/**
	 * 获取诊断类_影像学诊断费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_idifeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_idifee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("诊断类_影像学诊断费"); 
		return column;
	}
	/**
	 * 获取诊断类_临床诊断项目费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_cdifeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_cdifee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("诊断类_临床诊断项目费"); 
		return column;
	}
	/**
	 * 获取治疗类_非手术治疗项目费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_nstpfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_nstpfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("治疗类_非手术治疗项目费"); 
		return column;
	}
	/**
	 * 获取治疗类_临床物理治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_cptfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_cptfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("治疗类_临床物理治疗费"); 
		return column;
	}
	/**
	 * 获取治疗类_手术治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_stfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_stfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("治疗类_手术治疗费"); 
		return column;
	}
	/**
	 * 获取治疗类_麻醉费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_anfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_anfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("治疗类_麻醉费"); 
		return column;
	}
	/**
	 * 获取治疗类_手术费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_opfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_opfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("治疗类_手术费"); 
		return column;
	}
	/**
	 * 获取康复类_康复费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRc_rcfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rc_rcfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("康复类_康复费"); 
		return column;
	}
	/**
	 * 获取中医类_中医治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_cmtfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_cmtfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_中医治疗费"); 
		return column;
	}
	/**
	 * 获取西药类_西药费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWm_wmfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wm_wmfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("西药类_西药费"); 
		return column;
	}
	/**
	 * 获取西药类_抗菌药物费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWm_agfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wm_agfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("西药类_抗菌药物费"); 
		return column;
	}
	/**
	 * 获取中药类_中成药费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcmt_cpmfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcmt_cpmfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中药类_中成药费"); 
		return column;
	}
	/**
	 * 获取中药类_中草药费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcmt_chmfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcmt_chmfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中药类_中草药费"); 
		return column;
	}
	/**
	 * 获取血液和血液制品类_血液费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBabp_bfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Babp_bfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血液和血液制品类_血液费"); 
		return column;
	}
	/**
	 * 获取血液和血液制品类_白蛋白类制品费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBabp_apfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Babp_apfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血液和血液制品类_白蛋白类制品费"); 
		return column;
	}
	/**
	 * 获取血液和血液制品类_球蛋白类制品费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBabp_gpfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Babp_gpfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血液和血液制品类_球蛋白类制品费"); 
		return column;
	}
	/**
	 * 获取血液和血液制品类_凝血因子类制品费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBabp_bcffeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Babp_bcffee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血液和血液制品类_凝血因子类制品费"); 
		return column;
	}
	/**
	 * 获取血液和血液制品类_细胞因子类制品费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBabp_cflfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Babp_cflfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血液和血液制品类_细胞因子类制品费"); 
		return column;
	}
	/**
	 * 获取耗材类_检查用一次性医用材料费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_dmmfifeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_dmmfifee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("耗材类_检查用一次性医用材料费"); 
		return column;
	}
	/**
	 * 获取耗材类_治疗用一次性医用材料费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_dmmftfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_dmmftfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("耗材类_治疗用一次性医用材料费"); 
		return column;
	}
	/**
	 * 获取耗材类_手术用一次性医用材料费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_dmmfsfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_dmmfsfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("耗材类_手术用一次性医用材料费"); 
		return column;
	}
	/**
	 * 获取其他类_其他费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOc_ocfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oc_ocfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其他类_其他费用"); 
		return column;
	}
	/**
	 * 获取综合医疗服务类_中医辨证论治费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_decnfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_decnfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_中医辨证论治费"); 
		return column;
	}
	/**
	 * 获取综合医疗服务类_中医辨证论治会诊费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCms_decfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cms_decfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("综合医疗服务类_中医辨证论治会诊费"); 
		return column;
	}
	/**
	 * 获取中医类_中医诊断费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_difeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_difee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_中医诊断费"); 
		return column;
	}
	/**
	 * 获取中医类_外治费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_etfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_etfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_外治费"); 
		return column;
	}
	/**
	 * 获取中医类_骨伤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_bffeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_bffee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_骨伤"); 
		return column;
	}
	/**
	 * 获取中医类_针刺与灸法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_tcmfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_tcmfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_针刺与灸法"); 
		return column;
	}
	/**
	 * 获取中医类_推拿治疗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_mnpfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_mnpfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_推拿治疗"); 
		return column;
	}
	/**
	 * 获取中医类_肛肠治疗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_anrfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_anrfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_肛肠治疗"); 
		return column;
	}
	/**
	 * 获取中医类_特殊治疗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_spcialfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_spcialfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_特殊治疗"); 
		return column;
	}
	/**
	 * 获取中医类_其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_otherfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_otherfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_其他"); 
		return column;
	}
	/**
	 * 获取中医类_特殊调配加工表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_allocationfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_allocationfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_特殊调配加工"); 
		return column;
	}
	/**
	 * 获取中医类_辨证施膳表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcm_dcfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcm_dcfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中医类_辨证施膳"); 
		return column;
	}
	/**
	 * 获取中药类_制剂费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTcmt_ppafeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tcmt_ppafee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("中药类_制剂费"); 
		return column;
	}
	/**
	 * 获取displaynam51表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam51"); 
		return column;
	}
	/**
	 * 获取displaynam52表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam52"); 
		return column;
	}
	/**
	 * 获取displaynam53表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam53"); 
		return column;
	}
	/**
	 * 获取displaynam54表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam54"); 
		return column;
	}
	/**
	 * 获取displaynam55表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam55"); 
		return column;
	}
	/**
	 * 获取displaynam56表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam56"); 
		return column;
	}
	/**
	 * 获取displaynam57表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam57"); 
		return column;
	}
	/**
	 * 获取displaynam58表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam58"); 
		return column;
	}
	/**
	 * 获取displaynam59表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam59"); 
		return column;
	}
	/**
	 * 获取displaynam60表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam60"); 
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
	}
	
}
