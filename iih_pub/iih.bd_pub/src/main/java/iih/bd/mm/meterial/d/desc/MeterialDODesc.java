
package iih.bd.mm.meterial.d.desc;

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
 * 医疗物品_基本信息 DO 元数据信息
 */
public class MeterialDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mm.meterial.d.MeterialDO";
	public static final String CLASS_DISPALYNAME = "医疗物品_基本信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_MM";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MeterialDODesc(){
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
		this.setKeyDesc(getId_mmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_mmtpADesc(tblDesc));
		this.add(getSd_mmtpADesc(tblDesc));
		this.add(getId_mmcaADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getSpecADesc(tblDesc));
		this.add(getId_unit_pkgbaseADesc(tblDesc));
		this.add(getId_unit_pkgspADesc(tblDesc));
		this.add(getName_unit_pkgbaseADesc(tblDesc));
		this.add(getName_unit_pkgspADesc(tblDesc));
		this.add(getFactor_sbADesc(tblDesc));
		this.add(getFactor_mbADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getDddADesc(tblDesc));
		this.add(getId_unit_dddADesc(tblDesc));
		this.add(getBarcodeADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getFg_outADesc(tblDesc));
		this.add(getHinameADesc(tblDesc));
		this.add(getChemistrynameADesc(tblDesc));
		this.add(getId_primodeADesc(tblDesc));
		this.add(getSd_primodeADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getPrice_inADesc(tblDesc));
		this.add(getId_supADesc(tblDesc));
		this.add(getSup_nameADesc(tblDesc));
		this.add(getApprnoADesc(tblDesc));
		this.add(getId_abrdADesc(tblDesc));
		this.add(getSd_abrdADesc(tblDesc));
		this.add(getId_valADesc(tblDesc));
		this.add(getSd_valADesc(tblDesc));
		this.add(getIndicaADesc(tblDesc));
		this.add(getConstrADesc(tblDesc));
		this.add(getReactADesc(tblDesc));
		this.add(getInteractADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getPrecautADesc(tblDesc));
		this.add(getId_pipmutpADesc(tblDesc));
		this.add(getSd_pipmutpADesc(tblDesc));
		this.add(getId_mupkgutpADesc(tblDesc));
		this.add(getSd_mupkgutpADesc(tblDesc));
		this.add(getId_opmutpADesc(tblDesc));
		this.add(getSd_opmutpADesc(tblDesc));
		this.add(getId_ermutpADesc(tblDesc));
		this.add(getSd_ermutpADesc(tblDesc));
		this.add(getId_er1mutpADesc(tblDesc));
		this.add(getSd_er1mutpADesc(tblDesc));
		this.add(getId_er2mutpADesc(tblDesc));
		this.add(getSd_er2mutpADesc(tblDesc));
		this.add(getValid_cnADesc(tblDesc));
		this.add(getId_validuADesc(tblDesc));
		this.add(getSd_validuADesc(tblDesc));
		this.add(getId_papADesc(tblDesc));
		this.add(getSd_papADesc(tblDesc));
		this.add(getRate_papADesc(tblDesc));
		this.add(getId_unit_weightADesc(tblDesc));
		this.add(getFactor_wbADesc(tblDesc));
		this.add(getId_unit_volbaseADesc(tblDesc));
		this.add(getFactor_vbADesc(tblDesc));
		this.add(getFg_skinADesc(tblDesc));
		this.add(getId_skincaADesc(tblDesc));
		this.add(getSd_skincaADesc(tblDesc));
		this.add(getId_srvskinADesc(tblDesc));
		this.add(getId_mmskinADesc(tblDesc));
		this.add(getFg_patADesc(tblDesc));
		this.add(getId_outmodeADesc(tblDesc));
		this.add(getSd_outmodeADesc(tblDesc));
		this.add(getFg_batchADesc(tblDesc));
		this.add(getFg_priceADesc(tblDesc));
		this.add(getFg_chargeADesc(tblDesc));
		this.add(getFg_otcADesc(tblDesc));
		this.add(getPlaceADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getPrintnameADesc(tblDesc));
		this.add(getEngnameADesc(tblDesc));
		this.add(getFg_gmpADesc(tblDesc));
		this.add(getFg_essdgADesc(tblDesc));
		this.add(getFg_batchmixADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getQuan_medADesc(tblDesc));
		this.add(getId_unit_medADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getId_boildesADesc(tblDesc));
		this.add(getFg_use_opADesc(tblDesc));
		this.add(getFg_use_pipADesc(tblDesc));
		this.add(getFg_use_ipADesc(tblDesc));
		this.add(getFg_use_erADesc(tblDesc));
		this.add(getFg_use_er1ADesc(tblDesc));
		this.add(getFg_use_er2ADesc(tblDesc));
		this.add(getFg_use_peADesc(tblDesc));
		this.add(getFg_use_fmADesc(tblDesc));
		this.add(getId_basedrugrangeADesc(tblDesc));
		this.add(getSd_basedrugrangeADesc(tblDesc));
		this.add(getFg_oa_applyreceiveADesc(tblDesc));
		this.add(getUsedrug_numADesc(tblDesc));
		this.add(getId_storecondsADesc(tblDesc));
		this.add(getSd_storecondsADesc(tblDesc));
		this.add(getId_herbpreparationtpADesc(tblDesc));
		this.add(getSd_herbpreparationtpADesc(tblDesc));
		this.add(getFg_effectiveADesc(tblDesc));
		this.add(getDdd2ADesc(tblDesc));
		this.add(getId_unit_ddd2ADesc(tblDesc));
		this.add(getCode_reguADesc(tblDesc));
		this.add(getCode_idADesc(tblDesc));
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
		this.add(getFg_assisADesc(tblDesc));
		this.add(getFg_bidADesc(tblDesc));
		this.add(getFg_keymonitorADesc(tblDesc));
		this.add(getFg_chargeableADesc(tblDesc));
		this.add(getId_stor_conADesc(tblDesc));
		this.add(getSd_stor_conADesc(tblDesc));
		this.add(getFg_stop_mmpoADesc(tblDesc));
		this.add(getFg_stop_mmtrADesc(tblDesc));
		this.add(getId_stcaADesc(tblDesc));
		this.add(getSd_stcaADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getMmtp_nameADesc(tblDesc));
		this.add(getMmca_nameADesc(tblDesc));
		this.add(getMmca_codeADesc(tblDesc));
		this.add(getPkgbase_nameADesc(tblDesc));
		this.add(getPkgbase_codeADesc(tblDesc));
		this.add(getPkgsp_nameADesc(tblDesc));
		this.add(getPkgsp_codeADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getSrv_codeADesc(tblDesc));
		this.add(getSrv_id_unit_medADesc(tblDesc));
		this.add(getDddunit_codeADesc(tblDesc));
		this.add(getDddunit_nameADesc(tblDesc));
		this.add(getPrimode_nameADesc(tblDesc));
		this.add(getFactory_nameADesc(tblDesc));
		this.add(getAbrd_nameADesc(tblDesc));
		this.add(getVal_nameADesc(tblDesc));
		this.add(getName_pipmutpADesc(tblDesc));
		this.add(getMupkgutp_nameADesc(tblDesc));
		this.add(getOpmutp_nameADesc(tblDesc));
		this.add(getErmutp_nameADesc(tblDesc));
		this.add(getErmutp_codeADesc(tblDesc));
		this.add(getEr1mutp_nameADesc(tblDesc));
		this.add(getEr1mutp_codeADesc(tblDesc));
		this.add(getEr2mutp_nameADesc(tblDesc));
		this.add(getEr2mutp_codeADesc(tblDesc));
		this.add(getValidu_nameADesc(tblDesc));
		this.add(getPap_nameADesc(tblDesc));
		this.add(getWeight_codeADesc(tblDesc));
		this.add(getWeight_nameADesc(tblDesc));
		this.add(getVolbase_nameADesc(tblDesc));
		this.add(getVolbase_codeADesc(tblDesc));
		this.add(getSkinca_nameADesc(tblDesc));
		this.add(getSrvskin_nameADesc(tblDesc));
		this.add(getSrvskin_codeADesc(tblDesc));
		this.add(getMmskin_codeADesc(tblDesc));
		this.add(getMmskin_nameADesc(tblDesc));
		this.add(getOutmode_nameADesc(tblDesc));
		this.add(getRoute_nameADesc(tblDesc));
		this.add(getRoute_codeADesc(tblDesc));
		this.add(getRoutedes_nameADesc(tblDesc));
		this.add(getRoutedes_codeADesc(tblDesc));
		this.add(getFreq_nameADesc(tblDesc));
		this.add(getFreq_codeADesc(tblDesc));
		this.add(getSd_frequnitctADesc(tblDesc));
		this.add(getId_frequnitctADesc(tblDesc));
		this.add(getFrequnitctADesc(tblDesc));
		this.add(getFreqctADesc(tblDesc));
		this.add(getFg_prnorADesc(tblDesc));
		this.add(getFg_longADesc(tblDesc));
		this.add(getUnit_med_nameADesc(tblDesc));
		this.add(getUnit_med_codeADesc(tblDesc));
		this.add(getBoil_codeADesc(tblDesc));
		this.add(getBoil_nameADesc(tblDesc));
		this.add(getBoildes_codeADesc(tblDesc));
		this.add(getBoildes_nameADesc(tblDesc));
		this.add(getBasedrugrange_nameADesc(tblDesc));
		this.add(getName_storecondsADesc(tblDesc));
		this.add(getHerbpreparationtp_nameADesc(tblDesc));
		this.add(getName_ddd2ADesc(tblDesc));
		this.add(getPri_nameADesc(tblDesc));
		this.add(getPriADesc(tblDesc));
		this.add(getName_stor_conADesc(tblDesc));
		this.add(getStca_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_mmtpCDesc(tblDesc));
		tblDesc.add(getSd_mmtpCDesc(tblDesc));
		tblDesc.add(getId_mmcaCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getSpecCDesc(tblDesc));
		tblDesc.add(getId_unit_pkgbaseCDesc(tblDesc));
		tblDesc.add(getId_unit_pkgspCDesc(tblDesc));
		tblDesc.add(getName_unit_pkgbaseCDesc(tblDesc));
		tblDesc.add(getName_unit_pkgspCDesc(tblDesc));
		tblDesc.add(getFactor_sbCDesc(tblDesc));
		tblDesc.add(getFactor_mbCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getDddCDesc(tblDesc));
		tblDesc.add(getId_unit_dddCDesc(tblDesc));
		tblDesc.add(getBarcodeCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getFg_outCDesc(tblDesc));
		tblDesc.add(getHinameCDesc(tblDesc));
		tblDesc.add(getChemistrynameCDesc(tblDesc));
		tblDesc.add(getId_primodeCDesc(tblDesc));
		tblDesc.add(getSd_primodeCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getPrice_inCDesc(tblDesc));
		tblDesc.add(getId_supCDesc(tblDesc));
		tblDesc.add(getSup_nameCDesc(tblDesc));
		tblDesc.add(getApprnoCDesc(tblDesc));
		tblDesc.add(getId_abrdCDesc(tblDesc));
		tblDesc.add(getSd_abrdCDesc(tblDesc));
		tblDesc.add(getId_valCDesc(tblDesc));
		tblDesc.add(getSd_valCDesc(tblDesc));
		tblDesc.add(getIndicaCDesc(tblDesc));
		tblDesc.add(getConstrCDesc(tblDesc));
		tblDesc.add(getReactCDesc(tblDesc));
		tblDesc.add(getInteractCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getPrecautCDesc(tblDesc));
		tblDesc.add(getId_pipmutpCDesc(tblDesc));
		tblDesc.add(getSd_pipmutpCDesc(tblDesc));
		tblDesc.add(getId_mupkgutpCDesc(tblDesc));
		tblDesc.add(getSd_mupkgutpCDesc(tblDesc));
		tblDesc.add(getId_opmutpCDesc(tblDesc));
		tblDesc.add(getSd_opmutpCDesc(tblDesc));
		tblDesc.add(getId_ermutpCDesc(tblDesc));
		tblDesc.add(getSd_ermutpCDesc(tblDesc));
		tblDesc.add(getId_er1mutpCDesc(tblDesc));
		tblDesc.add(getSd_er1mutpCDesc(tblDesc));
		tblDesc.add(getId_er2mutpCDesc(tblDesc));
		tblDesc.add(getSd_er2mutpCDesc(tblDesc));
		tblDesc.add(getValid_cnCDesc(tblDesc));
		tblDesc.add(getId_validuCDesc(tblDesc));
		tblDesc.add(getSd_validuCDesc(tblDesc));
		tblDesc.add(getId_papCDesc(tblDesc));
		tblDesc.add(getSd_papCDesc(tblDesc));
		tblDesc.add(getRate_papCDesc(tblDesc));
		tblDesc.add(getId_unit_weightCDesc(tblDesc));
		tblDesc.add(getFactor_wbCDesc(tblDesc));
		tblDesc.add(getId_unit_volbaseCDesc(tblDesc));
		tblDesc.add(getFactor_vbCDesc(tblDesc));
		tblDesc.add(getFg_skinCDesc(tblDesc));
		tblDesc.add(getId_skincaCDesc(tblDesc));
		tblDesc.add(getSd_skincaCDesc(tblDesc));
		tblDesc.add(getId_srvskinCDesc(tblDesc));
		tblDesc.add(getId_mmskinCDesc(tblDesc));
		tblDesc.add(getFg_patCDesc(tblDesc));
		tblDesc.add(getId_outmodeCDesc(tblDesc));
		tblDesc.add(getSd_outmodeCDesc(tblDesc));
		tblDesc.add(getFg_batchCDesc(tblDesc));
		tblDesc.add(getFg_priceCDesc(tblDesc));
		tblDesc.add(getFg_chargeCDesc(tblDesc));
		tblDesc.add(getFg_otcCDesc(tblDesc));
		tblDesc.add(getPlaceCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getPrintnameCDesc(tblDesc));
		tblDesc.add(getEngnameCDesc(tblDesc));
		tblDesc.add(getFg_gmpCDesc(tblDesc));
		tblDesc.add(getFg_essdgCDesc(tblDesc));
		tblDesc.add(getFg_batchmixCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getQuan_medCDesc(tblDesc));
		tblDesc.add(getId_unit_medCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getId_boildesCDesc(tblDesc));
		tblDesc.add(getFg_use_opCDesc(tblDesc));
		tblDesc.add(getFg_use_pipCDesc(tblDesc));
		tblDesc.add(getFg_use_ipCDesc(tblDesc));
		tblDesc.add(getFg_use_erCDesc(tblDesc));
		tblDesc.add(getFg_use_er1CDesc(tblDesc));
		tblDesc.add(getFg_use_er2CDesc(tblDesc));
		tblDesc.add(getFg_use_peCDesc(tblDesc));
		tblDesc.add(getFg_use_fmCDesc(tblDesc));
		tblDesc.add(getId_basedrugrangeCDesc(tblDesc));
		tblDesc.add(getSd_basedrugrangeCDesc(tblDesc));
		tblDesc.add(getFg_oa_applyreceiveCDesc(tblDesc));
		tblDesc.add(getUsedrug_numCDesc(tblDesc));
		tblDesc.add(getId_storecondsCDesc(tblDesc));
		tblDesc.add(getSd_storecondsCDesc(tblDesc));
		tblDesc.add(getId_herbpreparationtpCDesc(tblDesc));
		tblDesc.add(getSd_herbpreparationtpCDesc(tblDesc));
		tblDesc.add(getFg_effectiveCDesc(tblDesc));
		tblDesc.add(getDdd2CDesc(tblDesc));
		tblDesc.add(getId_unit_ddd2CDesc(tblDesc));
		tblDesc.add(getCode_reguCDesc(tblDesc));
		tblDesc.add(getCode_idCDesc(tblDesc));
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
		tblDesc.add(getFg_assisCDesc(tblDesc));
		tblDesc.add(getFg_bidCDesc(tblDesc));
		tblDesc.add(getFg_keymonitorCDesc(tblDesc));
		tblDesc.add(getFg_chargeableCDesc(tblDesc));
		tblDesc.add(getId_stor_conCDesc(tblDesc));
		tblDesc.add(getSd_stor_conCDesc(tblDesc));
		tblDesc.add(getFg_stop_mmpoCDesc(tblDesc));
		tblDesc.add(getFg_stop_mmtrCDesc(tblDesc));
		tblDesc.add(getId_stcaCDesc(tblDesc));
		tblDesc.add(getSd_stcaCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗物品主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗物品主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构");
		attrDesc.setNullable(false);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmca",  getId_mmcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品分类");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
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
	 * 物品描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品描述");
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
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_pkgbaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_pkgbase",  getId_unit_pkgbaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本包装单位");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 零售包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_pkgspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_pkgsp",  getId_unit_pkgspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 基本包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_pkgbaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_pkgbase",  getName_unit_pkgbaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_pkgspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_pkgsp",  getName_unit_pkgspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 换算系数_零基属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_sbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_sb",  getFactor_sbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数_零基");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 换算系数_医基属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_mbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_mb",  getFactor_mbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数_医基");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ddd值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDddADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ddd",  getDddCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("ddd值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ddd单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_dddADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_ddd",  getId_unit_dddCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ddd单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 条形码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBarcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Barcode",  getBarcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("条形码");
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
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用状态");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停发标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_out",  getFg_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("停发标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保名称(废弃)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHinameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hiname",  getHinameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保名称(废弃)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 化学名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChemistrynameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chemistryname",  getChemistrynameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("化学名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售价计算方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_primodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_primode",  getId_primodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售价计算方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 零售价计算方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_primodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_primode",  getSd_primodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售价计算方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("零售价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进价_零售单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrice_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price_in",  getPrice_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进价_零售单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_supADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sup",  getId_supCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生产厂家名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_name",  getSup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前批准文号/注册号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApprnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apprno",  getApprnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前批准文号/注册号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进口分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_abrdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_abrd",  getId_abrdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进口分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 进口分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_abrdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_abrd",  getSd_abrdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进口分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价值分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_val",  getId_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价值分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 价值分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_val",  getSd_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价值分类编码");
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
	 * 预住院取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipmutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipmutp",  getId_pipmutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预住院取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipmutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipmutp",  getSd_pipmutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位住院取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mupkgutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mupkgutp",  getId_mupkgutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位住院取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位住院取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mupkgutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mupkgutp",  getSd_mupkgutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位住院取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位门诊取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opmutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opmutp",  getId_opmutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位门诊取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位门诊取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_opmutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_opmutp",  getSd_opmutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位门诊取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊流水取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ermutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ermutp",  getId_ermutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊流水取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位急诊流水取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ermutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ermutp",  getSd_ermutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊流水取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊抢救取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_er1mutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_er1mutp",  getId_er1mutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊抢救取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位急诊抢救取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_er1mutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_er1mutp",  getSd_er1mutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊抢救取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊留观取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_er2mutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_er2mutp",  getId_er2mutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊留观取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位急诊留观取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_er2mutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_er2mutp",  getSd_er2mutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊留观取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品有效期限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValid_cnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Valid_cn",  getValid_cnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("物品有效期限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效期限单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_validuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_validu",  getId_validuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效期限单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有效期限单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_validuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_validu",  getSd_validuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效期限单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 售价管理模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_papADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pap",  getId_papCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("售价管理模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 售价管理模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_papADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pap",  getSd_papCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("售价管理模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本物品计算加成率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_papADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_pap",  getRate_papCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本物品计算加成率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_weight",  getId_unit_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 重量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_wbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_wb",  getFactor_wbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("重量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本体积单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_volbaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_volbase",  getId_unit_volbaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本体积单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 换算系数_体基属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_vbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_vb",  getFactor_vbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数_体基");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_skin",  getFg_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("皮试标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skincaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skinca",  getId_skincaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮试类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skincaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skinca",  getSd_skincaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvskinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvskin",  getId_srvskinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮试药品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmskinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmskin",  getId_mmskinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试药品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pat",  getFg_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("患者使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认物品出库方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outmodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_outmode",  getId_outmodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认物品出库方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认物品出库方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_outmodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_outmode",  getSd_outmodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认物品出库方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否批次管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_batchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_batch",  getFg_batchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否批次管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否价格管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_price",  getFg_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否价格管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费出库标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_chargeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_charge",  getFg_chargeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("收费出库标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * OTC标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_otcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_otc",  getFg_otcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("OTC标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产地属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Place",  getPlaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产地");
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
	 * 打印名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrintnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Printname",  getPrintnameCDesc(tblDesc), this);
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
	 * 英文名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEngnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Engname",  getEngnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * GMP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_gmpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_gmp",  getFg_gmpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("GMP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本药物标识(废弃)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_essdgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_essdg",  getFg_essdgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("基本药物标识(废弃)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 批次混发标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_batchmixADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_batchmix",  getFg_batchmixCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("批次混发标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 默认剂量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_med",  getQuan_medCDesc(tblDesc), this);
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
	 * 家床可使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_fm",  getFg_use_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("家床可使用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本药物范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_basedrugrangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_basedrugrange",  getId_basedrugrangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本药物范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 基本药物范围编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_basedrugrangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_basedrugrange",  getSd_basedrugrangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本药物范围编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * OA请领标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_oa_applyreceiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_oa_applyreceive",  getFg_oa_applyreceiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("OA请领标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药最大天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsedrug_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usedrug_num",  getUsedrug_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("用药最大天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 储存条件串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_storecondsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_storeconds",  getId_storecondsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("储存条件串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 储存条件编码串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_storecondsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_storeconds",  getSd_storecondsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("储存条件编码串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 草药制剂类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_herbpreparationtp",  getId_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药制剂类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 草药制剂类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_herbpreparationtp",  getSd_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药制剂类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否效期管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_effectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_effective",  getFg_effectiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否效期管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院ddd值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDdd2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ddd2",  getDdd2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医院ddd值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院ddd单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_ddd2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_ddd2",  getId_unit_ddd2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院ddd单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 监管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_reguADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_regu",  getCode_reguCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("监管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品本位码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_id",  getCode_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品本位码");
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
	 * 辅助用药标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_assisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_assis",  getFg_assisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("辅助用药标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中标药品标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bid",  getFg_bidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("中标药品标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重点监控标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_keymonitorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_keymonitor",  getFg_keymonitorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("重点监控标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否可收费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_chargeableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_chargeable",  getFg_chargeableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否可收费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 耗材存储条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_con",  getId_stor_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("耗材存储条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 耗材存储条件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stor_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stor_con",  getSd_stor_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("耗材存储条件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采购计划停用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stop_mmpoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stop_mmpo",  getFg_stop_mmpoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("采购计划停用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调拨单停用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stop_mmtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stop_mmtr",  getFg_stop_mmtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("调拨单停用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stca",  getId_stcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 库存分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stca",  getSd_stcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
	 * 物品类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmtp_name",  getMmtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_mmtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmca_name",  getMmca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MMCA a0b4","id_mmca=id_mmca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmca_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmca_code",  getMmca_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MMCA a0b4","id_mmca=id_mmca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkgbase_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkgbase_name",  getPkgbase_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b5","id_unit_pkgbase=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本包装单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkgbase_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkgbase_code",  getPkgbase_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本包装单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b5","id_unit_pkgbase=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkgsp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkgsp_name",  getPkgsp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b6","id_unit_pkgsp=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售包装单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkgsp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkgsp_code",  getPkgsp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b6","id_unit_pkgsp=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b26","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_code",  getSrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b26","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_id_unit_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_id_unit_med",  getSrv_id_unit_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b26","id_srv=id_srv","id_unit_med"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ddd值计量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDddunit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dddunit_code",  getDddunit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ddd值计量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b30","id_unit_ddd=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ddd值计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDddunit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dddunit_name",  getDddunit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ddd值计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b30","id_unit_ddd=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrimode_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Primode_name",  getPrimode_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_primode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供应商与厂商名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactory_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factory_name",  getFactory_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供应商与厂商名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_SUP a0b9","id_sup=id_sup","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进口分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAbrd_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Abrd_name",  getAbrd_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进口分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_abrd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价值分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_name",  getVal_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价值分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_val=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院取整模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipmutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipmutp",  getName_pipmutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院取整模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b46","id_pipmutp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位取整模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMupkgutp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mupkgutp_name",  getMupkgutp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位取整模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_mupkgutp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位门诊取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpmutp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Opmutp_name",  getOpmutp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位门诊取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_opmutp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊流水取整模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getErmutp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ermutp_name",  getErmutp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊流水取整模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_ermutp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊流水取整模编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getErmutp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ermutp_code",  getErmutp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊流水取整模编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_ermutp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊抢救取整模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEr1mutp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Er1mutp_name",  getEr1mutp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊抢救取整模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_er1mutp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊抢救取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEr1mutp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Er1mutp_code",  getEr1mutp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊抢救取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_er1mutp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊留观取整模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEr2mutp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Er2mutp_name",  getEr2mutp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊留观取整模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","id_er2mutp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位急诊留观取整模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEr2mutp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Er2mutp_code",  getEr2mutp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位急诊留观取整模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","id_er2mutp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效期限名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValidu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Validu_name",  getValidu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效期限名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_validu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加成计算率名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPap_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pap_name",  getPap_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加成计算率名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_pap=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_code",  getWeight_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b29","id_unit_weight=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_name",  getWeight_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b29","id_unit_weight=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体积单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVolbase_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Volbase_name",  getVolbase_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体积单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b20","id_unit_volbase=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体积单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVolbase_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Volbase_code",  getVolbase_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体积单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b20","id_unit_volbase=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSkinca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Skinca_name",  getSkinca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_skinca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvskin_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvskin_name",  getSrvskin_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b27","id_srvskin=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvskin_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvskin_code",  getSrvskin_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b27","id_srvskin=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmskin_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmskin_code",  getMmskin_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b37","id_mmskin=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmskin_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmskin_name",  getMmskin_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮试物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b37","id_mmskin=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutmode_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outmode_name",  getOutmode_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_outmode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_name",  getRoute_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b31","id_route=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_code",  getRoute_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b31","id_route=id_route","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a0b32","id_routedes=id_routedes","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a0b32","id_routedes=id_routedes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认频次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_name",  getFreq_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认频次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认频次编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_code",  getFreq_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认频次编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_frequnitctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_frequnitct",  getSd_frequnitctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次周期类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","sd_frequnitct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_frequnitctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_frequnitct",  getId_frequnitctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次周期类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","id_frequnitct"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 频次周期数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFrequnitctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Frequnitct",  getFrequnitctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("频次周期数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","frequnitct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期下次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreqctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freqct",  getFreqctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("频次周期下次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","freqct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用医嘱标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prnorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prnor",  getFg_prnorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("备用医嘱标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","fg_prnor"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长临标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_longADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_long",  getFg_longCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("长临标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b33","id_freq=id_freq","fg_long"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b7","id_unit_med=id_measdoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b7","id_unit_med=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认煎法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_code",  getBoil_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认煎法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a0b34","id_boil=id_boil","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认煎法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_name",  getBoil_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认煎法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a0b34","id_boil=id_boil","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认煎法要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_code",  getBoildes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认煎法要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a0b35","id_boildes=id_boildes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认煎法要求名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_name",  getBoildes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认煎法要求名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a0b35","id_boildes=id_boildes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本药物范围名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBasedrugrange_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Basedrugrange_name",  getBasedrugrange_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本药物范围名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_basedrugrange=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 储存条件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_storecondsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_storeconds",  getName_storecondsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("储存条件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_storeconds=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 草药制剂类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHerbpreparationtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Herbpreparationtp_name",  getHerbpreparationtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药制剂类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_herbpreparationtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院ddd单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ddd2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ddd2",  getName_ddd2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院ddd单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b40","id_unit_ddd2=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_name",  getPri_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b41","id_srvpri=id_srv","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b41","id_srvpri=id_srv","pri"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_con",  getName_stor_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b45","id_stor_con=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stca_name",  getStca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b47","id_stca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗物品主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗物品主键"); 
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
	 * 获取机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构"); 
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
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品类型编码"); 
		return column;
	}
	/**
	 * 获取物品分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品分类"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
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
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(100);
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
		column.setLength(100);
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
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取物品描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品描述"); 
		return column;
	}
	/**
	 * 获取物品规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品规格"); 
		return column;
	}
	/**
	 * 获取基本包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_pkgbaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_pkgbase");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本包装单位"); 
		return column;
	}
	/**
	 * 获取零售包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_pkgspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_pkgsp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位"); 
		return column;
	}
	/**
	 * 获取基本包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_pkgbaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_pkgbase");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本包装单位名称"); 
		return column;
	}
	/**
	 * 获取零售包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_pkgspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_pkgsp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位名称"); 
		return column;
	}
	/**
	 * 获取换算系数_零基表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_sbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_sb");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数_零基"); 
		return column;
	}
	/**
	 * 获取换算系数_医基表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_mbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_mb");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数_医基"); 
		return column;
	}
	/**
	 * 获取服务项目外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目外键"); 
		return column;
	}
	/**
	 * 获取ddd值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDddCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ddd");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("ddd值"); 
		return column;
	}
	/**
	 * 获取ddd单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_dddCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_ddd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ddd单位"); 
		return column;
	}
	/**
	 * 获取条形码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBarcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Barcode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("条形码"); 
		return column;
	}
	/**
	 * 获取启用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用状态"); 
		return column;
	}
	/**
	 * 获取停发标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_out");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停发标志"); 
		return column;
	}
	/**
	 * 获取医保名称(废弃)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHinameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hiname");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保名称(废弃)"); 
		return column;
	}
	/**
	 * 获取化学名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChemistrynameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chemistryname");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("化学名称"); 
		return column;
	}
	/**
	 * 获取零售价计算方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_primodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_primode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售价计算方式"); 
		return column;
	}
	/**
	 * 获取零售价计算方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_primodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_primode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售价计算方式编码"); 
		return column;
	}
	/**
	 * 获取零售价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("零售价"); 
		return column;
	}
	/**
	 * 获取进价_零售单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrice_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price_in");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进价_零售单位"); 
		return column;
	}
	/**
	 * 获取生产厂家主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_supCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sup");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家主键"); 
		return column;
	}
	/**
	 * 获取生产厂家名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家名称"); 
		return column;
	}
	/**
	 * 获取当前批准文号/注册号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApprnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apprno");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前批准文号/注册号"); 
		return column;
	}
	/**
	 * 获取进口分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_abrdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_abrd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进口分类"); 
		return column;
	}
	/**
	 * 获取进口分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_abrdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_abrd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进口分类编码"); 
		return column;
	}
	/**
	 * 获取价值分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_val");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价值分类"); 
		return column;
	}
	/**
	 * 获取价值分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_val");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价值分类编码"); 
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
	 * 获取预住院取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipmutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipmutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院取整模式"); 
		return column;
	}
	/**
	 * 获取预住院取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipmutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipmutp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院取整模式编码"); 
		return column;
	}
	/**
	 * 获取包装单位住院取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mupkgutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mupkgutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位住院取整模式"); 
		return column;
	}
	/**
	 * 获取包装单位住院取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mupkgutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mupkgutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位住院取整模式编码"); 
		return column;
	}
	/**
	 * 获取包装单位门诊取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opmutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opmutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位门诊取整模式"); 
		return column;
	}
	/**
	 * 获取包装单位门诊取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_opmutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_opmutp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位门诊取整模式编码"); 
		return column;
	}
	/**
	 * 获取包装单位急诊流水取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ermutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ermutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊流水取整模式"); 
		return column;
	}
	/**
	 * 获取包装单位急诊流水取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ermutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ermutp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊流水取整模式编码"); 
		return column;
	}
	/**
	 * 获取包装单位急诊抢救取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_er1mutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_er1mutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊抢救取整模式"); 
		return column;
	}
	/**
	 * 获取包装单位急诊抢救取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_er1mutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_er1mutp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊抢救取整模式编码"); 
		return column;
	}
	/**
	 * 获取包装单位急诊留观取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_er2mutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_er2mutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊留观取整模式"); 
		return column;
	}
	/**
	 * 获取包装单位急诊留观取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_er2mutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_er2mutp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊留观取整模式编码"); 
		return column;
	}
	/**
	 * 获取物品有效期限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValid_cnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Valid_cn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("物品有效期限"); 
		return column;
	}
	/**
	 * 获取有效期限单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_validuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_validu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效期限单位"); 
		return column;
	}
	/**
	 * 获取有效期限单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_validuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_validu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效期限单位编码"); 
		return column;
	}
	/**
	 * 获取售价管理模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_papCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("售价管理模式"); 
		return column;
	}
	/**
	 * 获取售价管理模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_papCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("售价管理模式编码"); 
		return column;
	}
	/**
	 * 获取本物品计算加成率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_papCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_pap");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本物品计算加成率"); 
		return column;
	}
	/**
	 * 获取重量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_weight");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重量单位"); 
		return column;
	}
	/**
	 * 获取重量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_wbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_wb");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("重量"); 
		return column;
	}
	/**
	 * 获取基本体积单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_volbaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_volbase");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本体积单位"); 
		return column;
	}
	/**
	 * 获取换算系数_体基表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_vbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_vb");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数_体基"); 
		return column;
	}
	/**
	 * 获取皮试标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_skin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("皮试标志"); 
		return column;
	}
	/**
	 * 获取皮试类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skincaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skinca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试类型"); 
		return column;
	}
	/**
	 * 获取皮试类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skincaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skinca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试类型编码"); 
		return column;
	}
	/**
	 * 获取皮试项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvskinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvskin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试项目"); 
		return column;
	}
	/**
	 * 获取皮试药品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmskinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmskin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试药品"); 
		return column;
	}
	/**
	 * 获取患者使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pat");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者使用标志"); 
		return column;
	}
	/**
	 * 获取默认物品出库方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outmodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_outmode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认物品出库方式"); 
		return column;
	}
	/**
	 * 获取默认物品出库方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_outmodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_outmode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认物品出库方式编码"); 
		return column;
	}
	/**
	 * 获取是否批次管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_batchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_batch");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否批次管理"); 
		return column;
	}
	/**
	 * 获取是否价格管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_price");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否价格管理"); 
		return column;
	}
	/**
	 * 获取收费出库标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_chargeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_charge");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("收费出库标识"); 
		return column;
	}
	/**
	 * 获取OTC标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_otcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_otc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("OTC标志"); 
		return column;
	}
	/**
	 * 获取产地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Place");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产地"); 
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
	 * 获取打印名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrintnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Printname");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("打印名称"); 
		return column;
	}
	/**
	 * 获取英文名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEngnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Engname");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文名称"); 
		return column;
	}
	/**
	 * 获取GMP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_gmpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_gmp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("GMP标识"); 
		return column;
	}
	/**
	 * 获取基本药物标识(废弃)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_essdgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_essdg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("基本药物标识(废弃)"); 
		return column;
	}
	/**
	 * 获取批次混发标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_batchmixCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_batchmix");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("批次混发标识"); 
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
	 * 获取默认剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_med");
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
	 * 获取家床可使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_fm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("家床可使用标识"); 
		return column;
	}
	/**
	 * 获取基本药物范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_basedrugrangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_basedrugrange");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本药物范围"); 
		return column;
	}
	/**
	 * 获取基本药物范围编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_basedrugrangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_basedrugrange");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本药物范围编码"); 
		return column;
	}
	/**
	 * 获取OA请领标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_oa_applyreceiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_oa_applyreceive");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("OA请领标识"); 
		return column;
	}
	/**
	 * 获取用药最大天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsedrug_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usedrug_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("用药最大天数"); 
		return column;
	}
	/**
	 * 获取储存条件串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_storecondsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_storeconds");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("储存条件串"); 
		return column;
	}
	/**
	 * 获取储存条件编码串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_storecondsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_storeconds");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("储存条件编码串"); 
		return column;
	}
	/**
	 * 获取草药制剂类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_herbpreparationtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药制剂类型"); 
		return column;
	}
	/**
	 * 获取草药制剂类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_herbpreparationtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药制剂类型编码"); 
		return column;
	}
	/**
	 * 获取是否效期管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_effectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_effective");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否效期管理"); 
		return column;
	}
	/**
	 * 获取医院ddd值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDdd2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ddd2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医院ddd值"); 
		return column;
	}
	/**
	 * 获取医院ddd单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_ddd2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_ddd2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院ddd单位"); 
		return column;
	}
	/**
	 * 获取监管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_reguCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_regu");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("监管编码"); 
		return column;
	}
	/**
	 * 获取药品本位码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_id");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品本位码"); 
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
	 * 获取辅助用药标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_assisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_assis");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("辅助用药标志"); 
		return column;
	}
	/**
	 * 获取中标药品标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bid");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("中标药品标志"); 
		return column;
	}
	/**
	 * 获取重点监控标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_keymonitorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_keymonitor");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("重点监控标志"); 
		return column;
	}
	/**
	 * 获取是否可收费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_chargeableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_chargeable");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否可收费"); 
		return column;
	}
	/**
	 * 获取耗材存储条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_con");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("耗材存储条件"); 
		return column;
	}
	/**
	 * 获取耗材存储条件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stor_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stor_con");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("耗材存储条件编码"); 
		return column;
	}
	/**
	 * 获取采购计划停用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stop_mmpoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stop_mmpo");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("采购计划停用标志"); 
		return column;
	}
	/**
	 * 获取调拨单停用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stop_mmtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stop_mmtr");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调拨单停用标志"); 
		return column;
	}
	/**
	 * 获取库存分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存分类"); 
		return column;
	}
	/**
	 * 获取库存分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存分类编码"); 
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
	 * 获取物品类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品类型名称"); 
		return column;
	}
	/**
	 * 获取基本分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本分类名称"); 
		return column;
	}
	/**
	 * 获取物品分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmca_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmca_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品分类编码"); 
		return column;
	}
	/**
	 * 获取基本包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkgbase_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkgbase_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本包装单位名称"); 
		return column;
	}
	/**
	 * 获取基本包装单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkgbase_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkgbase_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本包装单位编码"); 
		return column;
	}
	/**
	 * 获取零售包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkgsp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkgsp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位名称"); 
		return column;
	}
	/**
	 * 获取零售包装单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkgsp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkgsp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_id_unit_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_id_unit_med");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医学单位"); 
		return column;
	}
	/**
	 * 获取ddd值计量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDddunit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dddunit_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ddd值计量单位编码"); 
		return column;
	}
	/**
	 * 获取ddd值计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDddunit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dddunit_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ddd值计量单位名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrimode_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Primode_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取供应商与厂商名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactory_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factory_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供应商与厂商名称"); 
		return column;
	}
	/**
	 * 获取进口分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAbrd_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Abrd_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进口分类名称"); 
		return column;
	}
	/**
	 * 获取价值分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价值分类名称"); 
		return column;
	}
	/**
	 * 获取预住院取整模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipmutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipmutp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院取整模式名称"); 
		return column;
	}
	/**
	 * 获取包装单位取整模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMupkgutp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mupkgutp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位取整模式名称"); 
		return column;
	}
	/**
	 * 获取包装单位门诊取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpmutp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Opmutp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位门诊取整模式"); 
		return column;
	}
	/**
	 * 获取包装单位急诊流水取整模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getErmutp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ermutp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊流水取整模式名称"); 
		return column;
	}
	/**
	 * 获取包装单位急诊流水取整模编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getErmutp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ermutp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊流水取整模编码"); 
		return column;
	}
	/**
	 * 获取包装单位急诊抢救取整模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEr1mutp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Er1mutp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊抢救取整模式名称"); 
		return column;
	}
	/**
	 * 获取包装单位急诊抢救取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEr1mutp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Er1mutp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊抢救取整模式编码"); 
		return column;
	}
	/**
	 * 获取包装单位急诊留观取整模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEr2mutp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Er2mutp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊留观取整模式名称"); 
		return column;
	}
	/**
	 * 获取包装单位急诊留观取整模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEr2mutp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Er2mutp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位急诊留观取整模式编码"); 
		return column;
	}
	/**
	 * 获取有效期限名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValidu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Validu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效期限名称"); 
		return column;
	}
	/**
	 * 获取加成计算率名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPap_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pap_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加成计算率名称"); 
		return column;
	}
	/**
	 * 获取重量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重量单位编码"); 
		return column;
	}
	/**
	 * 获取重量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重量单位名称"); 
		return column;
	}
	/**
	 * 获取体积单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVolbase_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Volbase_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体积单位名称"); 
		return column;
	}
	/**
	 * 获取体积单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVolbase_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Volbase_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体积单位编码"); 
		return column;
	}
	/**
	 * 获取皮试类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSkinca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Skinca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试类型名称"); 
		return column;
	}
	/**
	 * 获取皮试项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvskin_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvskin_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试项目名称"); 
		return column;
	}
	/**
	 * 获取皮试项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvskin_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvskin_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试项目编码"); 
		return column;
	}
	/**
	 * 获取皮试物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmskin_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmskin_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试物品编码"); 
		return column;
	}
	/**
	 * 获取皮试物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmskin_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmskin_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮试物品名称"); 
		return column;
	}
	/**
	 * 获取出库方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutmode_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outmode_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出库方式名称"); 
		return column;
	}
	/**
	 * 获取默认用法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认用法名称"); 
		return column;
	}
	/**
	 * 获取默认用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认用法编码"); 
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
	 * 获取默认频次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认频次名称"); 
		return column;
	}
	/**
	 * 获取默认频次编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认频次编码"); 
		return column;
	}
	/**
	 * 获取频次周期类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_frequnitctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_frequnitct");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次周期类型编码"); 
		return column;
	}
	/**
	 * 获取频次周期类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_frequnitctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_frequnitct");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次周期类型"); 
		return column;
	}
	/**
	 * 获取频次周期数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFrequnitctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Frequnitct");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("频次周期数"); 
		return column;
	}
	/**
	 * 获取频次周期下次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreqctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freqct");
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
	private IColumnDesc getFg_prnorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prnor");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("备用医嘱标识"); 
		return column;
	}
	/**
	 * 获取长临标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_longCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_long");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("长临标识"); 
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
	 * 获取默认煎法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认煎法编码"); 
		return column;
	}
	/**
	 * 获取默认煎法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认煎法名称"); 
		return column;
	}
	/**
	 * 获取默认煎法要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认煎法要求编码"); 
		return column;
	}
	/**
	 * 获取默认煎法要求名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认煎法要求名称"); 
		return column;
	}
	/**
	 * 获取基本药物范围名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBasedrugrange_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Basedrugrange_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本药物范围名称"); 
		return column;
	}
	/**
	 * 获取储存条件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_storecondsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_storeconds");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("储存条件名称"); 
		return column;
	}
	/**
	 * 获取草药制剂类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHerbpreparationtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Herbpreparationtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药制剂类型名称"); 
		return column;
	}
	/**
	 * 获取医院ddd单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ddd2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ddd2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院ddd单位名称"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取参考价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("参考价格"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stor_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_con");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取库存分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存分类名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_mm");
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
		defaultValueMap.put("Fg_active",new xap.mw.coreitf.d.FBoolean("Y"));
		defaultValueMap.put("Fg_skin",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_pat",new xap.mw.coreitf.d.FBoolean("Y"));
		defaultValueMap.put("Fg_batch",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_price",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_batchmix",new xap.mw.coreitf.d.FBoolean("Y"));
		defaultValueMap.put("Fg_use_pip",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_effective",new xap.mw.coreitf.d.FBoolean("Y"));
		defaultValueMap.put("Fg_keymonitor",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
