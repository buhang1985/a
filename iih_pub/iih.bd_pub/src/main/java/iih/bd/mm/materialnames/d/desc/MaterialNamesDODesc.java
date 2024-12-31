
package iih.bd.mm.materialnames.d.desc;

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
 * 药品通用名目录 DO 元数据信息
 */
public class MaterialNamesDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mm.materialnames.d.MaterialNamesDO";
	public static final String CLASS_DISPALYNAME = "药品通用名目录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "default";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_materialname";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MaterialNamesDODesc(){
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
		this.setKeyDesc(getId_materialnameADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_materialnameADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_srvcaADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getShortnameADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getQuan_dosageADesc(tblDesc));
		this.add(getId_unit_medADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getId_boildesADesc(tblDesc));
		this.add(getId_primdADesc(tblDesc));
		this.add(getSd_primdADesc(tblDesc));
		this.add(getPriADesc(tblDesc));
		this.add(getFg_ctmADesc(tblDesc));
		this.add(getFg_orADesc(tblDesc));
		this.add(getFg_mmADesc(tblDesc));
		this.add(getFg_blADesc(tblDesc));
		this.add(getEu_blmdADesc(tblDesc));
		this.add(getFg_setADesc(tblDesc));
		this.add(getId_setordADesc(tblDesc));
		this.add(getSd_setordADesc(tblDesc));
		this.add(getFg_use_opADesc(tblDesc));
		this.add(getFg_use_pipADesc(tblDesc));
		this.add(getFg_use_ipADesc(tblDesc));
		this.add(getFg_use_erADesc(tblDesc));
		this.add(getFg_use_er1ADesc(tblDesc));
		this.add(getFg_use_er2ADesc(tblDesc));
		this.add(getFg_use_peADesc(tblDesc));
		this.add(getFg_use_fmADesc(tblDesc));
		this.add(getId_mmbind_opADesc(tblDesc));
		this.add(getSd_mmbind_opADesc(tblDesc));
		this.add(getId_mmbind_ipADesc(tblDesc));
		this.add(getSd_mmbind_ipADesc(tblDesc));
		this.add(getId_mmbind_erADesc(tblDesc));
		this.add(getSd_mmbind_erADesc(tblDesc));
		this.add(getId_mmbind_peADesc(tblDesc));
		this.add(getSd_mmbind_peADesc(tblDesc));
		this.add(getId_mmbind_fmADesc(tblDesc));
		this.add(getSd_mmbind_fmADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getDes_priADesc(tblDesc));
		this.add(getId_incca_opADesc(tblDesc));
		this.add(getId_incca_ipADesc(tblDesc));
		this.add(getId_pritpADesc(tblDesc));
		this.add(getSd_pritpADesc(tblDesc));
		this.add(getCode_rel1ADesc(tblDesc));
		this.add(getCode_rel2ADesc(tblDesc));
		this.add(getCode_rel3ADesc(tblDesc));
		this.add(getCode_rel4ADesc(tblDesc));
		this.add(getCode_rel5ADesc(tblDesc));
		this.add(getCode_rel6ADesc(tblDesc));
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
		this.add(getFg_nedruglistADesc(tblDesc));
		this.add(getId_dosageADesc(tblDesc));
		this.add(getSd_dosageADesc(tblDesc));
		this.add(getId_pharmADesc(tblDesc));
		this.add(getSd_pharmADesc(tblDesc));
		this.add(getFg_poisADesc(tblDesc));
		this.add(getId_poisADesc(tblDesc));
		this.add(getSd_poisADesc(tblDesc));
		this.add(getFg_antiADesc(tblDesc));
		this.add(getId_antiADesc(tblDesc));
		this.add(getSd_antiADesc(tblDesc));
		this.add(getIndicaADesc(tblDesc));
		this.add(getConstrADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getReactADesc(tblDesc));
		this.add(getPrecautADesc(tblDesc));
		this.add(getInteractADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_mmtpADesc(tblDesc));
		this.add(getSd_mmtpADesc(tblDesc));
		this.add(getFg_highriskADesc(tblDesc));
		this.add(getFg_bindingADesc(tblDesc));
		this.add(getId_antdrugcaADesc(tblDesc));
		this.add(getSd_antdrugcaADesc(tblDesc));
		this.add(getSrvtp_nameADesc(tblDesc));
		this.add(getSrvtp_codeADesc(tblDesc));
		this.add(getSrvca_codeADesc(tblDesc));
		this.add(getSrvca_nameADesc(tblDesc));
		this.add(getSrvca_innercodeADesc(tblDesc));
		this.add(getUnit_med_codeADesc(tblDesc));
		this.add(getUnit_med_nameADesc(tblDesc));
		this.add(getFreq_codeADesc(tblDesc));
		this.add(getFreq_nameADesc(tblDesc));
		this.add(getFreq_fg_longADesc(tblDesc));
		this.add(getFreq_freqctADesc(tblDesc));
		this.add(getFreq_fg_prnorADesc(tblDesc));
		this.add(getFreq_sd_frequnitctADesc(tblDesc));
		this.add(getFreq_frequnitctADesc(tblDesc));
		this.add(getRoute_codeADesc(tblDesc));
		this.add(getRoute_nameADesc(tblDesc));
		this.add(getRoute_mnecodeADesc(tblDesc));
		this.add(getRoutedes_codeADesc(tblDesc));
		this.add(getRoutedes_nameADesc(tblDesc));
		this.add(getBoil_codeADesc(tblDesc));
		this.add(getBoil_nameADesc(tblDesc));
		this.add(getBoil_mnecodeADesc(tblDesc));
		this.add(getBoildes_codeADesc(tblDesc));
		this.add(getBoildes_nameADesc(tblDesc));
		this.add(getBoildes_mnecodeADesc(tblDesc));
		this.add(getPrimd_codeADesc(tblDesc));
		this.add(getPrimd_nameADesc(tblDesc));
		this.add(getSetord_codeADesc(tblDesc));
		this.add(getSetord_nameADesc(tblDesc));
		this.add(getMmbind_op_codeADesc(tblDesc));
		this.add(getMmbind_op_nameADesc(tblDesc));
		this.add(getMmbind_ip_codeADesc(tblDesc));
		this.add(getMmbind_ip_nameADesc(tblDesc));
		this.add(getMmbind_er_codeADesc(tblDesc));
		this.add(getMmbind_er_nameADesc(tblDesc));
		this.add(getMmbind_pe_codeADesc(tblDesc));
		this.add(getMmbind_pe_nameADesc(tblDesc));
		this.add(getMmbind_fm_codeADesc(tblDesc));
		this.add(getMmbind_fm_nameADesc(tblDesc));
		this.add(getIncca_op_nameADesc(tblDesc));
		this.add(getIncca_ip_nameADesc(tblDesc));
		this.add(getPritp_nameADesc(tblDesc));
		this.add(getPritp_codeADesc(tblDesc));
		this.add(getDosage_codeADesc(tblDesc));
		this.add(getDosage_nameADesc(tblDesc));
		this.add(getPharm_nameADesc(tblDesc));
		this.add(getPharm_codeADesc(tblDesc));
		this.add(getPois_nameADesc(tblDesc));
		this.add(getPois_codeADesc(tblDesc));
		this.add(getAnti_nameADesc(tblDesc));
		this.add(getAnti_codeADesc(tblDesc));
		this.add(getMmtp_nameADesc(tblDesc));
		this.add(getCode_zy_accsubADesc(tblDesc));
		this.add(getName_zy_accsubADesc(tblDesc));
		this.add(getId_acc_zyADesc(tblDesc));
		this.add(getCode_mz_accsubADesc(tblDesc));
		this.add(getName_mz_accsubADesc(tblDesc));
		this.add(getId_acc_mzADesc(tblDesc));
		this.add(getCode_gy_accsubADesc(tblDesc));
		this.add(getName_gy_accsubADesc(tblDesc));
		this.add(getId_acc_gyADesc(tblDesc));
		this.add(getName_antdrugcaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_materialnameCDesc(tblDesc));
		tblDesc.add(getId_materialnameCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_srvcaCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getShortnameCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getQuan_dosageCDesc(tblDesc));
		tblDesc.add(getId_unit_medCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getId_boildesCDesc(tblDesc));
		tblDesc.add(getId_primdCDesc(tblDesc));
		tblDesc.add(getSd_primdCDesc(tblDesc));
		tblDesc.add(getPriCDesc(tblDesc));
		tblDesc.add(getFg_ctmCDesc(tblDesc));
		tblDesc.add(getFg_orCDesc(tblDesc));
		tblDesc.add(getFg_mmCDesc(tblDesc));
		tblDesc.add(getFg_blCDesc(tblDesc));
		tblDesc.add(getEu_blmdCDesc(tblDesc));
		tblDesc.add(getFg_setCDesc(tblDesc));
		tblDesc.add(getId_setordCDesc(tblDesc));
		tblDesc.add(getSd_setordCDesc(tblDesc));
		tblDesc.add(getFg_use_opCDesc(tblDesc));
		tblDesc.add(getFg_use_pipCDesc(tblDesc));
		tblDesc.add(getFg_use_ipCDesc(tblDesc));
		tblDesc.add(getFg_use_erCDesc(tblDesc));
		tblDesc.add(getFg_use_er1CDesc(tblDesc));
		tblDesc.add(getFg_use_er2CDesc(tblDesc));
		tblDesc.add(getFg_use_peCDesc(tblDesc));
		tblDesc.add(getFg_use_fmCDesc(tblDesc));
		tblDesc.add(getId_mmbind_opCDesc(tblDesc));
		tblDesc.add(getSd_mmbind_opCDesc(tblDesc));
		tblDesc.add(getId_mmbind_ipCDesc(tblDesc));
		tblDesc.add(getSd_mmbind_ipCDesc(tblDesc));
		tblDesc.add(getId_mmbind_erCDesc(tblDesc));
		tblDesc.add(getSd_mmbind_erCDesc(tblDesc));
		tblDesc.add(getId_mmbind_peCDesc(tblDesc));
		tblDesc.add(getSd_mmbind_peCDesc(tblDesc));
		tblDesc.add(getId_mmbind_fmCDesc(tblDesc));
		tblDesc.add(getSd_mmbind_fmCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getDes_priCDesc(tblDesc));
		tblDesc.add(getId_incca_opCDesc(tblDesc));
		tblDesc.add(getId_incca_ipCDesc(tblDesc));
		tblDesc.add(getId_pritpCDesc(tblDesc));
		tblDesc.add(getSd_pritpCDesc(tblDesc));
		tblDesc.add(getCode_rel1CDesc(tblDesc));
		tblDesc.add(getCode_rel2CDesc(tblDesc));
		tblDesc.add(getCode_rel3CDesc(tblDesc));
		tblDesc.add(getCode_rel4CDesc(tblDesc));
		tblDesc.add(getCode_rel5CDesc(tblDesc));
		tblDesc.add(getCode_rel6CDesc(tblDesc));
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
		tblDesc.add(getFg_nedruglistCDesc(tblDesc));
		tblDesc.add(getId_dosageCDesc(tblDesc));
		tblDesc.add(getSd_dosageCDesc(tblDesc));
		tblDesc.add(getId_pharmCDesc(tblDesc));
		tblDesc.add(getSd_pharmCDesc(tblDesc));
		tblDesc.add(getFg_poisCDesc(tblDesc));
		tblDesc.add(getId_poisCDesc(tblDesc));
		tblDesc.add(getSd_poisCDesc(tblDesc));
		tblDesc.add(getFg_antiCDesc(tblDesc));
		tblDesc.add(getId_antiCDesc(tblDesc));
		tblDesc.add(getSd_antiCDesc(tblDesc));
		tblDesc.add(getIndicaCDesc(tblDesc));
		tblDesc.add(getConstrCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getReactCDesc(tblDesc));
		tblDesc.add(getPrecautCDesc(tblDesc));
		tblDesc.add(getInteractCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_mmtpCDesc(tblDesc));
		tblDesc.add(getSd_mmtpCDesc(tblDesc));
		tblDesc.add(getFg_highriskCDesc(tblDesc));
		tblDesc.add(getFg_bindingCDesc(tblDesc));
		tblDesc.add(getId_antdrugcaCDesc(tblDesc));
		tblDesc.add(getSd_antdrugcaCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 药品通用名主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_materialnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_materialname",  getId_materialnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品通用名主键标识");
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
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("URC,BDMODE");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvtp",  getId_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvca",  getId_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔码");
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
	 * 简称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getShortnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Shortname",  getShortnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("简称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认剂量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_dosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_dosage",  getQuan_dosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("默认剂量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认剂量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_med",  getId_unit_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认剂量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认用法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认用法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认煎法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boil",  getId_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认煎法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认煎法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boildesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boildes",  getId_boildesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认煎法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 定价模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_primdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_primd",  getId_primdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定价模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 定价模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_primdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_primd",  getSd_primdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定价模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri",  getPriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("参考价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自定义服务名称标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ctmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ctm",  getFg_ctmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自定义服务名称标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱可开立标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_or",  getFg_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医嘱可开立标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗物品标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mm",  getFg_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医疗物品标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bl",  getFg_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("费用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 划价方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blmd",  getEu_blmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("划价方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务套标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_set",  getFg_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("服务套标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务套开立方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_setordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_setord",  getId_setordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务套开立方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务套开立方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_setordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_setord",  getSd_setordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务套开立方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊可使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_op",  getFg_use_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("门诊可使用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院可使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_pip",  getFg_use_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("预住院可使用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院可使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_ip",  getFg_use_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("住院可使用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊流水标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er",  getFg_use_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊流水标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊抢救标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_er1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er1",  getFg_use_er1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊抢救标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊留观标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_er2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er2",  getFg_use_er2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊留观标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检可使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_pe",  getFg_use_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("体检可使用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭可使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_fm",  getFg_use_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("家庭可使用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊绑定时机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmbind_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmbind_op",  getId_mmbind_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊绑定时机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmbind_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmbind_op",  getSd_mmbind_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院绑定时机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmbind_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmbind_ip",  getId_mmbind_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院绑定时机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmbind_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmbind_ip",  getSd_mmbind_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊绑定时机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmbind_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmbind_er",  getId_mmbind_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊绑定时机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 急诊绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmbind_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmbind_er",  getSd_mmbind_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检绑定时机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmbind_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmbind_pe",  getId_mmbind_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检绑定时机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmbind_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmbind_pe",  getSd_mmbind_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭绑定时机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmbind_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmbind_fm",  getId_mmbind_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭绑定时机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 家庭绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmbind_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmbind_fm",  getSd_mmbind_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_pri",  getDes_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价格描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊账单项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incca_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incca_op",  getId_incca_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊账单项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院账单项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incca_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incca_ip",  getId_incca_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院账单项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收费分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pritpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pritp",  getId_pritpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收费分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pritpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pritp",  getSd_pritpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rel1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rel1",  getCode_rel1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rel2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rel2",  getCode_rel2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rel3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rel3",  getCode_rel3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rel4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rel4",  getCode_rel4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rel5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rel5",  getCode_rel5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rel6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rel6",  getCode_rel6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家药物基本目录标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nedruglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nedruglist",  getFg_nedruglistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("国家药物基本目录标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品剂型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dosage",  getId_dosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品剂型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dosage",  getSd_dosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药理分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pharmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pharm",  getId_pharmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药理分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药理分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pharmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pharm",  getSd_pharmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药理分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pois",  getFg_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("毒麻标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pois",  getId_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 毒麻分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pois",  getSd_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_anti",  getFg_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("抗菌药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anti",  getId_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗菌药分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anti",  getSd_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适应症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIndicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Indica",  getIndicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适应症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 禁忌症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConstrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Constr",  getConstrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("禁忌症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用量与用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usage",  getUsageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用量与用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("React",  getReactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrecautADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Precaut",  getPrecautCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品相互作用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInteractADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Interact",  getInteractCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品相互作用");
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
	 * 药品类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmtp",  getId_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmtp",  getSd_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高危药品标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_highriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_highrisk",  getFg_highriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("高危药品标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否绑定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bindingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_binding",  getFg_bindingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否绑定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗肿瘤药物分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antdrugcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_antdrugca",  getId_antdrugcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗肿瘤药物分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗肿瘤药物分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_antdrugcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_antdrugca",  getSd_antdrugcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗肿瘤药物分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvtp_name",  getSrvtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_srvtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvtp_code",  getSrvtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_srvtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvca_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvca_code",  getSrvca_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b5","id_srvca=id_srvca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvca_name",  getSrvca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b5","id_srvca=id_srvca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品分类内部编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvca_innercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvca_innercode",  getSrvca_innercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品分类内部编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b5","id_srvca=id_srvca","innercode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认剂量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnit_med_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit_med_code",  getUnit_med_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认剂量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b6","id_unit_med=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认剂量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnit_med_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit_med_name",  getUnit_med_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认剂量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b6","id_unit_med=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_code",  getFreq_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_name",  getFreq_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长临标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_fg_longADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_fg_long",  getFreq_fg_longCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("长临标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","fg_long"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期下次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_freqctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_freqct",  getFreq_freqctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("频次周期下次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","freqct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用医嘱标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_fg_prnorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_fg_prnor",  getFreq_fg_prnorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("备用医嘱标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","fg_prnor"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_sd_frequnitctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_sd_frequnitct",  getFreq_sd_frequnitctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次周期类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","sd_frequnitct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_frequnitctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_frequnitct",  getFreq_frequnitctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("频次周期数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b7","id_freq=id_freq","frequnitct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_code",  getRoute_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b8","id_route=id_route","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_name",  getRoute_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b8","id_route=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_mnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_mnecode",  getRoute_mnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b8","id_route=id_route","mnecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认用法要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoutedes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Routedes_code",  getRoutedes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认用法要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a0b9","id_routedes=id_routedes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认用法要求名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoutedes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Routedes_name",  getRoutedes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认用法要求名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a0b9","id_routedes=id_routedes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_code",  getBoil_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a0b10","id_boil=id_boil","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_name",  getBoil_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a0b10","id_boil=id_boil","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_mnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_mnecode",  getBoil_mnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a0b10","id_boil=id_boil","mnecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_code",  getBoildes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a0b11","id_boildes=id_boildes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_name",  getBoildes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a0b11","id_boildes=id_boildes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_mnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_mnecode",  getBoildes_mnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a0b11","id_boildes=id_boildes","mnecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 定价模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrimd_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Primd_code",  getPrimd_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定价模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri a0b12","id_primd=id_pri","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 定价模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrimd_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Primd_name",  getPrimd_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定价模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri a0b12","id_primd=id_pri","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务套开立方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSetord_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Setord_code",  getSetord_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务套开立方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_setord=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务套开立方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSetord_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Setord_name",  getSetord_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务套开立方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_setord=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_op_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_op_code",  getMmbind_op_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_mmbind_op=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊绑定时机名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_op_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_op_name",  getMmbind_op_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊绑定时机名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_mmbind_op=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_ip_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_ip_code",  getMmbind_ip_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_mmbind_ip=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院绑定时机名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_ip_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_ip_name",  getMmbind_ip_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院绑定时机名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_mmbind_ip=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_er_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_er_code",  getMmbind_er_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_mmbind_er=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊绑定时机名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_er_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_er_name",  getMmbind_er_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊绑定时机名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_mmbind_er=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_pe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_pe_code",  getMmbind_pe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_mmbind_pe=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检绑定时机名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_pe_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_pe_name",  getMmbind_pe_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检绑定时机名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_mmbind_pe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭绑定时机编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_fm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_fm_code",  getMmbind_fm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭绑定时机编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_mmbind_fm=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭绑定时机名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmbind_fm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmbind_fm_name",  getMmbind_fm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭绑定时机名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_mmbind_fm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊账单项名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncca_op_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incca_op_name",  getIncca_op_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊账单项名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca_itm a0b19","id_incca_op=id_inccaitm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院账单项名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncca_ip_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incca_ip_name",  getIncca_ip_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院账单项名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca_itm a0b20","id_incca_ip=id_inccaitm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPritp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pritp_name",  getPritp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_pritp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPritp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pritp_code",  getPritp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_pritp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品剂型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDosage_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage_code",  getDosage_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_dosage=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品剂型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDosage_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage_name",  getDosage_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_dosage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药理分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPharm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pharm_name",  getPharm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药理分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_pharm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药理分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPharm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pharm_code",  getPharm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药理分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_pharm=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPois_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pois_name",  getPois_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_pois=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPois_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pois_code",  getPois_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_pois=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnti_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anti_name",  getAnti_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_anti=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnti_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anti_code",  getAnti_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_anti=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmtp_name",  getMmtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_mmtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_zy_accsubADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_zy_accsub",  getCode_zy_accsubCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b29","id_account_zy=id_accountca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zy_accsubADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zy_accsub",  getName_zy_accsubCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b29","id_account_zy=id_accountca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算体系主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_acc_zyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_acc_zy",  getId_acc_zyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算体系主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b29","id_account_zy=id_accountca","id_account"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mz_accsubADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mz_accsub",  getCode_mz_accsubCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b30","id_account_mz=id_accountca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mz_accsubADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mz_accsub",  getName_mz_accsubCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b30","id_account_mz=id_accountca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算体系主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_acc_mzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_acc_mz",  getId_acc_mzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算体系主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b30","id_account_mz=id_accountca","id_account"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_gy_accsubADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_gy_accsub",  getCode_gy_accsubCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b31","id_account_gy=id_accountca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_gy_accsubADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_gy_accsub",  getName_gy_accsubCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b31","id_account_gy=id_accountca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算体系主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_acc_gyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_acc_gy",  getId_acc_gyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算体系主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ACCOUNT_CA a0b31","id_account_gy=id_accountca","id_account"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗肿瘤药物分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_antdrugcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_antdrugca",  getName_antdrugcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗肿瘤药物分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_antdrugca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取药品通用名主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_materialnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_materialname");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药品通用名主键标识"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
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
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取药品类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类别"); 
		return column;
	}
	/**
	 * 获取药品类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类别编码"); 
		return column;
	}
	/**
	 * 获取药品分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品分类"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取简称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getShortnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Shortname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("简称"); 
		return column;
	}
	/**
	 * 获取服务描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务描述"); 
		return column;
	}
	/**
	 * 获取默认剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_dosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_dosage");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("默认剂量"); 
		return column;
	}
	/**
	 * 获取默认剂量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_med");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认剂量单位"); 
		return column;
	}
	/**
	 * 获取默认频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认频次"); 
		return column;
	}
	/**
	 * 获取默认用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认用法"); 
		return column;
	}
	/**
	 * 获取默认用法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认用法要求"); 
		return column;
	}
	/**
	 * 获取默认煎法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boil");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认煎法"); 
		return column;
	}
	/**
	 * 获取默认煎法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boildesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boildes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认煎法要求"); 
		return column;
	}
	/**
	 * 获取定价模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_primdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_primd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定价模式"); 
		return column;
	}
	/**
	 * 获取定价模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_primdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_primd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定价模式编码"); 
		return column;
	}
	/**
	 * 获取参考价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("参考价格"); 
		return column;
	}
	/**
	 * 获取自定义服务名称标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ctmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ctm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自定义服务名称标志"); 
		return column;
	}
	/**
	 * 获取医嘱可开立标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_or");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱可开立标识"); 
		return column;
	}
	/**
	 * 获取医疗物品标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗物品标识"); 
		return column;
	}
	/**
	 * 获取费用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bl");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("费用标识"); 
		return column;
	}
	/**
	 * 获取划价方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blmd");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("划价方式"); 
		return column;
	}
	/**
	 * 获取服务套标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_set");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务套标识"); 
		return column;
	}
	/**
	 * 获取服务套开立方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_setordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_setord");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务套开立方式"); 
		return column;
	}
	/**
	 * 获取服务套开立方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_setordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_setord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务套开立方式编码"); 
		return column;
	}
	/**
	 * 获取门诊可使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊可使用标识"); 
		return column;
	}
	/**
	 * 获取预住院可使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_pip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预住院可使用标识"); 
		return column;
	}
	/**
	 * 获取住院可使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_ip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院可使用标识"); 
		return column;
	}
	/**
	 * 获取急诊流水标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊流水标志"); 
		return column;
	}
	/**
	 * 获取急诊抢救标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_er1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er1");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊抢救标志"); 
		return column;
	}
	/**
	 * 获取急诊留观标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_er2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er2");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊留观标志"); 
		return column;
	}
	/**
	 * 获取体检可使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_pe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检可使用标识"); 
		return column;
	}
	/**
	 * 获取家庭可使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_fm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("家庭可使用标识"); 
		return column;
	}
	/**
	 * 获取门诊绑定时机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmbind_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmbind_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊绑定时机"); 
		return column;
	}
	/**
	 * 获取门诊绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmbind_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmbind_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊绑定时机编码"); 
		return column;
	}
	/**
	 * 获取住院绑定时机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmbind_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmbind_ip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院绑定时机"); 
		return column;
	}
	/**
	 * 获取住院绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmbind_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmbind_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院绑定时机编码"); 
		return column;
	}
	/**
	 * 获取急诊绑定时机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmbind_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmbind_er");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊绑定时机"); 
		return column;
	}
	/**
	 * 获取急诊绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmbind_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmbind_er");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊绑定时机编码"); 
		return column;
	}
	/**
	 * 获取体检绑定时机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmbind_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmbind_pe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检绑定时机"); 
		return column;
	}
	/**
	 * 获取体检绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmbind_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmbind_pe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检绑定时机编码"); 
		return column;
	}
	/**
	 * 获取家庭绑定时机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmbind_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmbind_fm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭绑定时机"); 
		return column;
	}
	/**
	 * 获取家庭绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmbind_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmbind_fm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭绑定时机编码"); 
		return column;
	}
	/**
	 * 获取启用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标识"); 
		return column;
	}
	/**
	 * 获取价格描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_pri");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价格描述"); 
		return column;
	}
	/**
	 * 获取门诊账单项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incca_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incca_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊账单项"); 
		return column;
	}
	/**
	 * 获取住院账单项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incca_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incca_ip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院账单项"); 
		return column;
	}
	/**
	 * 获取收费分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pritpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pritp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费分类"); 
		return column;
	}
	/**
	 * 获取收费分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pritpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pritp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费分类编码"); 
		return column;
	}
	/**
	 * 获取对照编码1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rel1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rel1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码1"); 
		return column;
	}
	/**
	 * 获取对照编码2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rel2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rel2");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码2"); 
		return column;
	}
	/**
	 * 获取对照编码3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rel3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rel3");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码3"); 
		return column;
	}
	/**
	 * 获取对照编码4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rel4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rel4");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码4"); 
		return column;
	}
	/**
	 * 获取对照编码5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rel5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rel5");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码5"); 
		return column;
	}
	/**
	 * 获取对照编码6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rel6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rel6");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段7"); 
		return column;
	}
	/**
	 * 获取客户扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段8"); 
		return column;
	}
	/**
	 * 获取客户扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段9"); 
		return column;
	}
	/**
	 * 获取客户扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段10"); 
		return column;
	}
	/**
	 * 获取国家药物基本目录标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nedruglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nedruglist");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("国家药物基本目录标识"); 
		return column;
	}
	/**
	 * 获取药品剂型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dosage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂型"); 
		return column;
	}
	/**
	 * 获取药品剂型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dosage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂型编码"); 
		return column;
	}
	/**
	 * 获取药理分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pharmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pharm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药理分类"); 
		return column;
	}
	/**
	 * 获取药理分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pharmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pharm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药理分类编码"); 
		return column;
	}
	/**
	 * 获取毒麻标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pois");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("毒麻标识"); 
		return column;
	}
	/**
	 * 获取毒麻分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pois");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类"); 
		return column;
	}
	/**
	 * 获取毒麻分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pois");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类编码"); 
		return column;
	}
	/**
	 * 获取抗菌药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_anti");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("抗菌药标识"); 
		return column;
	}
	/**
	 * 获取抗菌药分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anti");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药分类"); 
		return column;
	}
	/**
	 * 获取抗菌药分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anti");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药分类编码"); 
		return column;
	}
	/**
	 * 获取适应症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIndicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Indica");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适应症"); 
		return column;
	}
	/**
	 * 获取禁忌症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConstrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Constr");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("禁忌症"); 
		return column;
	}
	/**
	 * 获取用量与用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usage");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用量与用法"); 
		return column;
	}
	/**
	 * 获取不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"React");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良反应"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrecautCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Precaut");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取药品相互作用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInteractCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Interact");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品相互作用"); 
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
	 * 获取药品类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型"); 
		return column;
	}
	/**
	 * 获取药品类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型编码"); 
		return column;
	}
	/**
	 * 获取高危药品标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_highriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_highrisk");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("高危药品标识"); 
		return column;
	}
	/**
	 * 获取是否绑定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bindingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_binding");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否绑定"); 
		return column;
	}
	/**
	 * 获取抗肿瘤药物分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antdrugcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_antdrugca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗肿瘤药物分类"); 
		return column;
	}
	/**
	 * 获取抗肿瘤药物分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_antdrugcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_antdrugca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗肿瘤药物分类编码"); 
		return column;
	}
	/**
	 * 获取药品类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型名称"); 
		return column;
	}
	/**
	 * 获取药品类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型编码"); 
		return column;
	}
	/**
	 * 获取药品分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvca_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvca_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品分类编码"); 
		return column;
	}
	/**
	 * 获取药品分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品分类名称"); 
		return column;
	}
	/**
	 * 获取药品分类内部编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvca_innercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvca_innercode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品分类内部编码"); 
		return column;
	}
	/**
	 * 获取默认剂量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnit_med_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit_med_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认剂量单位编码"); 
		return column;
	}
	/**
	 * 获取默认剂量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnit_med_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit_med_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认剂量单位名称"); 
		return column;
	}
	/**
	 * 获取频次编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次编码"); 
		return column;
	}
	/**
	 * 获取频次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次名称"); 
		return column;
	}
	/**
	 * 获取长临标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_fg_longCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_fg_long");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("长临标识"); 
		return column;
	}
	/**
	 * 获取频次周期下次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_freqctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_freqct");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("频次周期下次数"); 
		return column;
	}
	/**
	 * 获取备用医嘱标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_fg_prnorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_fg_prnor");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("备用医嘱标识"); 
		return column;
	}
	/**
	 * 获取频次周期类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_sd_frequnitctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_sd_frequnitct");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次周期类型编码"); 
		return column;
	}
	/**
	 * 获取频次周期数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_frequnitctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_frequnitct");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("频次周期数"); 
		return column;
	}
	/**
	 * 获取用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法编码"); 
		return column;
	}
	/**
	 * 获取用法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法名称"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_mnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_mnecode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取默认用法要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoutedes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Routedes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认用法要求编码"); 
		return column;
	}
	/**
	 * 获取默认用法要求名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoutedes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Routedes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认用法要求名称"); 
		return column;
	}
	/**
	 * 获取煎法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法编码"); 
		return column;
	}
	/**
	 * 获取煎法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法名称"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_mnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_mnecode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取煎法要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求编码"); 
		return column;
	}
	/**
	 * 获取煎法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_mnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_mnecode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取定价模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrimd_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Primd_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定价模式编码"); 
		return column;
	}
	/**
	 * 获取定价模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrimd_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Primd_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定价模式名称"); 
		return column;
	}
	/**
	 * 获取服务套开立方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSetord_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Setord_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务套开立方式编码"); 
		return column;
	}
	/**
	 * 获取服务套开立方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSetord_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Setord_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务套开立方式名称"); 
		return column;
	}
	/**
	 * 获取门诊绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_op_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_op_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊绑定时机编码"); 
		return column;
	}
	/**
	 * 获取门诊绑定时机名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_op_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_op_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊绑定时机名称"); 
		return column;
	}
	/**
	 * 获取住院绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_ip_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_ip_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院绑定时机编码"); 
		return column;
	}
	/**
	 * 获取住院绑定时机名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_ip_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_ip_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院绑定时机名称"); 
		return column;
	}
	/**
	 * 获取急诊绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_er_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_er_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊绑定时机编码"); 
		return column;
	}
	/**
	 * 获取急诊绑定时机名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_er_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_er_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊绑定时机名称"); 
		return column;
	}
	/**
	 * 获取体检绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_pe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_pe_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检绑定时机编码"); 
		return column;
	}
	/**
	 * 获取体检绑定时机名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_pe_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_pe_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检绑定时机名称"); 
		return column;
	}
	/**
	 * 获取家庭绑定时机编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_fm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_fm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭绑定时机编码"); 
		return column;
	}
	/**
	 * 获取家庭绑定时机名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmbind_fm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmbind_fm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭绑定时机名称"); 
		return column;
	}
	/**
	 * 获取门诊账单项名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncca_op_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incca_op_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊账单项名称"); 
		return column;
	}
	/**
	 * 获取住院账单项名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncca_ip_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incca_ip_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院账单项名称"); 
		return column;
	}
	/**
	 * 获取收费分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPritp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pritp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费分类名称"); 
		return column;
	}
	/**
	 * 获取收费分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPritp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pritp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费分类编码"); 
		return column;
	}
	/**
	 * 获取药品剂型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosage_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂型编码"); 
		return column;
	}
	/**
	 * 获取药品剂型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosage_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂型名称"); 
		return column;
	}
	/**
	 * 获取药理分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPharm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pharm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药理分类名称"); 
		return column;
	}
	/**
	 * 获取药理分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPharm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pharm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药理分类编码"); 
		return column;
	}
	/**
	 * 获取毒麻分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPois_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pois_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类名称"); 
		return column;
	}
	/**
	 * 获取毒麻分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPois_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pois_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类编码"); 
		return column;
	}
	/**
	 * 获取抗菌药分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnti_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anti_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药分类名称"); 
		return column;
	}
	/**
	 * 获取抗菌药分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnti_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anti_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药分类编码"); 
		return column;
	}
	/**
	 * 获取药品类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_zy_accsubCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_zy_accsub");
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
	private IColumnDesc getName_zy_accsubCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zy_accsub");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取核算体系主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_acc_zyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_acc_zy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算体系主键"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mz_accsubCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mz_accsub");
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
	private IColumnDesc getName_mz_accsubCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mz_accsub");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取核算体系主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_acc_mzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_acc_mz");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算体系主键"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_gy_accsubCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_gy_accsub");
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
	private IColumnDesc getName_gy_accsubCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_gy_accsub");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取核算体系主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_acc_gyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_acc_gy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算体系主键"); 
		return column;
	}
	/**
	 * 获取抗肿瘤药物分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_antdrugcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_antdrugca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗肿瘤药物分类名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_materialname");
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
		defaultValueMap.put("Fg_use_pip",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_nedruglist",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_highrisk",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
