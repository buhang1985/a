
package iih.ems.eass.emcard.d.desc;

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
 * 资产卡片 DO 元数据信息
 */
public class EmCardDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.eass.emcard.d.EmCardDO";
	public static final String CLASS_DISPALYNAME = "资产卡片";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ems_card";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_card";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmCardDODesc(){
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
		this.setKeyDesc(getId_cardADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cardADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_deptADesc(tblDesc));
		this.add(getId_emADesc(tblDesc));
		this.add(getFg_gaugeADesc(tblDesc));
		this.add(getId_gauge_caADesc(tblDesc));
		this.add(getFg_selfADesc(tblDesc));
		this.add(getId_fee_sourceADesc(tblDesc));
		this.add(getSd_fee_sourceADesc(tblDesc));
		this.add(getId_equ_sourceADesc(tblDesc));
		this.add(getSd_equ_sourceADesc(tblDesc));
		this.add(getRight_typeADesc(tblDesc));
		this.add(getCountryADesc(tblDesc));
		this.add(getBarcodeADesc(tblDesc));
		this.add(getDt_facADesc(tblDesc));
		this.add(getPact_codeADesc(tblDesc));
		this.add(getId_useADesc(tblDesc));
		this.add(getSd_useADesc(tblDesc));
		this.add(getSource_priceADesc(tblDesc));
		this.add(getNet_priceADesc(tblDesc));
		this.add(getLeave_priceADesc(tblDesc));
		this.add(getInit_numADesc(tblDesc));
		this.add(getBuy_priceADesc(tblDesc));
		this.add(getBuy_costADesc(tblDesc));
		this.add(getId_deADesc(tblDesc));
		this.add(getDe_yearADesc(tblDesc));
		this.add(getLess_monthADesc(tblDesc));
		this.add(getDe_month_costADesc(tblDesc));
		this.add(getDt_de_operADesc(tblDesc));
		this.add(getRepair_numADesc(tblDesc));
		this.add(getRepair_costADesc(tblDesc));
		this.add(getId_card_stADesc(tblDesc));
		this.add(getSd_card_stADesc(tblDesc));
		this.add(getId_stateADesc(tblDesc));
		this.add(getSd_stateADesc(tblDesc));
		this.add(getPre_net_priceADesc(tblDesc));
		this.add(getDt_repair_endADesc(tblDesc));
		this.add(getRepair_contactADesc(tblDesc));
		this.add(getBrand_nameADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getId_inADesc(tblDesc));
		this.add(getId_initmADesc(tblDesc));
		this.add(getId_stor_levelADesc(tblDesc));
		this.add(getSd_stor_levelADesc(tblDesc));
		this.add(getId_stor_deptADesc(tblDesc));
		this.add(getDt_getADesc(tblDesc));
		this.add(getId_stor_empADesc(tblDesc));
		this.add(getDt_startADesc(tblDesc));
		this.add(getFg_newADesc(tblDesc));
		this.add(getFg_payADesc(tblDesc));
		this.add(getFg_annexADesc(tblDesc));
		this.add(getAnnex_noteADesc(tblDesc));
		this.add(getFg_importADesc(tblDesc));
		this.add(getImport_noteADesc(tblDesc));
		this.add(getFg_partADesc(tblDesc));
		this.add(getId_card_parentADesc(tblDesc));
		this.add(getId_enter_typeADesc(tblDesc));
		this.add(getSd_enter_typeADesc(tblDesc));
		this.add(getId_reg_operADesc(tblDesc));
		this.add(getDt_regADesc(tblDesc));
		this.add(getUpkeep_cycADesc(tblDesc));
		this.add(getDt_upkeep_firstADesc(tblDesc));
		this.add(getDt_upkeep_lastADesc(tblDesc));
		this.add(getDt_upkeep_nextADesc(tblDesc));
		this.add(getGauge_cycADesc(tblDesc));
		this.add(getDt_last_gaugeADesc(tblDesc));
		this.add(getDt_next_gaugeADesc(tblDesc));
		this.add(getFg_fixedADesc(tblDesc));
		this.add(getMaintenanceinfoADesc(tblDesc));
		this.add(getUsefullifeADesc(tblDesc));
		this.add(getFg_printADesc(tblDesc));
		this.add(getFg_isaidequADesc(tblDesc));
		this.add(getInv_noADesc(tblDesc));
		this.add(getDt_invADesc(tblDesc));
		this.add(getVoucher_wordADesc(tblDesc));
		this.add(getStop_monthsADesc(tblDesc));
		this.add(getDt_last_stopdeADesc(tblDesc));
		this.add(getDt_last_restartdeADesc(tblDesc));
		this.add(getFg_stopdepADesc(tblDesc));
		this.add(getFg_postponeADesc(tblDesc));
		this.add(getId_last_operADesc(tblDesc));
		this.add(getSave_placeADesc(tblDesc));
		this.add(getMoh_codeADesc(tblDesc));
		this.add(getGover_codeADesc(tblDesc));
		this.add(getFilenoADesc(tblDesc));
		this.add(getStandarnameADesc(tblDesc));
		this.add(getAccount_noADesc(tblDesc));
		this.add(getGauge_noADesc(tblDesc));
		this.add(getFg_printedADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getAppopADesc(tblDesc));
		this.add(getEmca_inrcodeADesc(tblDesc));
		this.add(getId_emcaADesc(tblDesc));
		this.add(getFg_availADesc(tblDesc));
		this.add(getBatchADesc(tblDesc));
		this.add(getYear_monthADesc(tblDesc));
		this.add(getFg_outADesc(tblDesc));
		this.add(getDt_outADesc(tblDesc));
		this.add(getId_outADesc(tblDesc));
		this.add(getId_out_itmADesc(tblDesc));
		this.add(getId_stuADesc(tblDesc));
		this.add(getSd_stuADesc(tblDesc));
		this.add(getId_supADesc(tblDesc));
		this.add(getSpecsADesc(tblDesc));
		this.add(getIn_codeADesc(tblDesc));
		this.add(getOut_codeADesc(tblDesc));
		this.add(getName_deptADesc(tblDesc));
		this.add(getCode_emADesc(tblDesc));
		this.add(getName_emADesc(tblDesc));
		this.add(getCode_gaADesc(tblDesc));
		this.add(getName_gaADesc(tblDesc));
		this.add(getName_sourceADesc(tblDesc));
		this.add(getName_source_feeADesc(tblDesc));
		this.add(getName_useADesc(tblDesc));
		this.add(getName_deADesc(tblDesc));
		this.add(getCode_deADesc(tblDesc));
		this.add(getName_card_stADesc(tblDesc));
		this.add(getCode_card_stADesc(tblDesc));
		this.add(getName_stateADesc(tblDesc));
		this.add(getCode_stateADesc(tblDesc));
		this.add(getName_whADesc(tblDesc));
		this.add(getName_stor_levelADesc(tblDesc));
		this.add(getName_stor_deptADesc(tblDesc));
		this.add(getName_stor_empADesc(tblDesc));
		this.add(getName_card_parentADesc(tblDesc));
		this.add(getCard_no_parentADesc(tblDesc));
		this.add(getName_enter_typeADesc(tblDesc));
		this.add(getName_reg_operADesc(tblDesc));
		this.add(getName_last_operADesc(tblDesc));
		this.add(getName_emcaADesc(tblDesc));
		this.add(getName_stuADesc(tblDesc));
		this.add(getName_supADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cardCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_deptCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getFg_gaugeCDesc(tblDesc));
		tblDesc.add(getId_gauge_caCDesc(tblDesc));
		tblDesc.add(getFg_selfCDesc(tblDesc));
		tblDesc.add(getId_fee_sourceCDesc(tblDesc));
		tblDesc.add(getSd_fee_sourceCDesc(tblDesc));
		tblDesc.add(getId_equ_sourceCDesc(tblDesc));
		tblDesc.add(getSd_equ_sourceCDesc(tblDesc));
		tblDesc.add(getRight_typeCDesc(tblDesc));
		tblDesc.add(getCountryCDesc(tblDesc));
		tblDesc.add(getBarcodeCDesc(tblDesc));
		tblDesc.add(getDt_facCDesc(tblDesc));
		tblDesc.add(getPact_codeCDesc(tblDesc));
		tblDesc.add(getId_useCDesc(tblDesc));
		tblDesc.add(getSd_useCDesc(tblDesc));
		tblDesc.add(getSource_priceCDesc(tblDesc));
		tblDesc.add(getNet_priceCDesc(tblDesc));
		tblDesc.add(getLeave_priceCDesc(tblDesc));
		tblDesc.add(getInit_numCDesc(tblDesc));
		tblDesc.add(getBuy_priceCDesc(tblDesc));
		tblDesc.add(getBuy_costCDesc(tblDesc));
		tblDesc.add(getId_deCDesc(tblDesc));
		tblDesc.add(getDe_yearCDesc(tblDesc));
		tblDesc.add(getLess_monthCDesc(tblDesc));
		tblDesc.add(getDe_month_costCDesc(tblDesc));
		tblDesc.add(getDt_de_operCDesc(tblDesc));
		tblDesc.add(getRepair_numCDesc(tblDesc));
		tblDesc.add(getRepair_costCDesc(tblDesc));
		tblDesc.add(getId_card_stCDesc(tblDesc));
		tblDesc.add(getSd_card_stCDesc(tblDesc));
		tblDesc.add(getId_stateCDesc(tblDesc));
		tblDesc.add(getSd_stateCDesc(tblDesc));
		tblDesc.add(getPre_net_priceCDesc(tblDesc));
		tblDesc.add(getDt_repair_endCDesc(tblDesc));
		tblDesc.add(getRepair_contactCDesc(tblDesc));
		tblDesc.add(getBrand_nameCDesc(tblDesc));
		tblDesc.add(getRemarkCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getId_inCDesc(tblDesc));
		tblDesc.add(getId_initmCDesc(tblDesc));
		tblDesc.add(getId_stor_levelCDesc(tblDesc));
		tblDesc.add(getSd_stor_levelCDesc(tblDesc));
		tblDesc.add(getId_stor_deptCDesc(tblDesc));
		tblDesc.add(getDt_getCDesc(tblDesc));
		tblDesc.add(getId_stor_empCDesc(tblDesc));
		tblDesc.add(getDt_startCDesc(tblDesc));
		tblDesc.add(getFg_newCDesc(tblDesc));
		tblDesc.add(getFg_payCDesc(tblDesc));
		tblDesc.add(getFg_annexCDesc(tblDesc));
		tblDesc.add(getAnnex_noteCDesc(tblDesc));
		tblDesc.add(getFg_importCDesc(tblDesc));
		tblDesc.add(getImport_noteCDesc(tblDesc));
		tblDesc.add(getFg_partCDesc(tblDesc));
		tblDesc.add(getId_card_parentCDesc(tblDesc));
		tblDesc.add(getId_enter_typeCDesc(tblDesc));
		tblDesc.add(getSd_enter_typeCDesc(tblDesc));
		tblDesc.add(getId_reg_operCDesc(tblDesc));
		tblDesc.add(getDt_regCDesc(tblDesc));
		tblDesc.add(getUpkeep_cycCDesc(tblDesc));
		tblDesc.add(getDt_upkeep_firstCDesc(tblDesc));
		tblDesc.add(getDt_upkeep_lastCDesc(tblDesc));
		tblDesc.add(getDt_upkeep_nextCDesc(tblDesc));
		tblDesc.add(getGauge_cycCDesc(tblDesc));
		tblDesc.add(getDt_last_gaugeCDesc(tblDesc));
		tblDesc.add(getDt_next_gaugeCDesc(tblDesc));
		tblDesc.add(getFg_fixedCDesc(tblDesc));
		tblDesc.add(getMaintenanceinfoCDesc(tblDesc));
		tblDesc.add(getUsefullifeCDesc(tblDesc));
		tblDesc.add(getFg_printCDesc(tblDesc));
		tblDesc.add(getFg_isaidequCDesc(tblDesc));
		tblDesc.add(getInv_noCDesc(tblDesc));
		tblDesc.add(getDt_invCDesc(tblDesc));
		tblDesc.add(getVoucher_wordCDesc(tblDesc));
		tblDesc.add(getStop_monthsCDesc(tblDesc));
		tblDesc.add(getDt_last_stopdeCDesc(tblDesc));
		tblDesc.add(getDt_last_restartdeCDesc(tblDesc));
		tblDesc.add(getFg_stopdepCDesc(tblDesc));
		tblDesc.add(getFg_postponeCDesc(tblDesc));
		tblDesc.add(getId_last_operCDesc(tblDesc));
		tblDesc.add(getSave_placeCDesc(tblDesc));
		tblDesc.add(getMoh_codeCDesc(tblDesc));
		tblDesc.add(getGover_codeCDesc(tblDesc));
		tblDesc.add(getFilenoCDesc(tblDesc));
		tblDesc.add(getStandarnameCDesc(tblDesc));
		tblDesc.add(getAccount_noCDesc(tblDesc));
		tblDesc.add(getGauge_noCDesc(tblDesc));
		tblDesc.add(getFg_printedCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getAppopCDesc(tblDesc));
		tblDesc.add(getEmca_inrcodeCDesc(tblDesc));
		tblDesc.add(getId_emcaCDesc(tblDesc));
		tblDesc.add(getFg_availCDesc(tblDesc));
		tblDesc.add(getBatchCDesc(tblDesc));
		tblDesc.add(getYear_monthCDesc(tblDesc));
		tblDesc.add(getFg_outCDesc(tblDesc));
		tblDesc.add(getDt_outCDesc(tblDesc));
		tblDesc.add(getId_outCDesc(tblDesc));
		tblDesc.add(getId_out_itmCDesc(tblDesc));
		tblDesc.add(getId_stuCDesc(tblDesc));
		tblDesc.add(getSd_stuCDesc(tblDesc));
		tblDesc.add(getId_supCDesc(tblDesc));
		tblDesc.add(getSpecsCDesc(tblDesc));
		tblDesc.add(getIn_codeCDesc(tblDesc));
		tblDesc.add(getOut_codeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 资产卡主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产卡主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept",  getId_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备基本信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_em",  getId_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备基本信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否计量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_gaugeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_gauge",  getFg_gaugeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否计量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量仪器分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gauge_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_gauge_ca",  getId_gauge_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量仪器分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否自制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_selfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_self",  getFg_selfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否自制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经费来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fee_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fee_source",  getId_fee_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经费来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 经费来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fee_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fee_source",  getSd_fee_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经费来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_equ_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_equ_source",  getId_equ_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_equ_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_equ_source",  getSd_equ_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产权性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRight_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Right_type",  getRight_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产权性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Country",  getCountryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出厂编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBarcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Barcode",  getBarcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出厂编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_facADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_fac",  getDt_facCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("生产日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 合同编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPact_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pact_code",  getPact_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("合同编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产用途属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_use",  getId_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产用途");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 资产用途编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_use",  getSd_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产用途编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产原值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSource_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Source_price",  getSource_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("资产原值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产净值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNet_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Net_price",  getNet_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("资产净值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产残值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLeave_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Leave_price",  getLeave_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("资产残值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 初始数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInit_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Init_num",  getInit_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("初始数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 购入单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBuy_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Buy_price",  getBuy_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("购入单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 购入金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBuy_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Buy_cost",  getBuy_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("购入金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折旧方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_de",  getId_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("折旧方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 折旧年限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDe_yearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("De_year",  getDe_yearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("折旧年限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已折旧月份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLess_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Less_month",  getLess_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("已折旧月份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 月折旧金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDe_month_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("De_month_cost",  getDe_month_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("月折旧金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最新折旧时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_de_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_de_oper",  getDt_de_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("最新折旧时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_num",  getRepair_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("维修次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_cost",  getRepair_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维修费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产建卡状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_card_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card_st",  getId_card_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产建卡状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 资产建卡状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_card_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_card_st",  getSd_card_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产建卡状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_state",  getId_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 资产状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_state",  getSd_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预计净残值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_net_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_net_price",  getPre_net_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("预计净残值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保修截止日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_repair_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_repair_end",  getDt_repair_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("保修截止日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修联系方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepair_contactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Repair_contact",  getRepair_contactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修联系方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 品牌名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBrand_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Brand_name",  getBrand_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("品牌名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片备注信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark",  getRemarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片备注信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wh",  getId_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入库单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_in",  getId_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入库单细目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_initmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_initm",  getId_initmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单细目主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保管等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_level",  getId_stor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保管等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stor_level",  getSd_stor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保管科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_dept",  getId_stor_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 领用日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_getADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_get",  getDt_getCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("领用日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保管人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stor_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stor_emp",  getId_stor_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 启用日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_startADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_start",  getDt_startCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("启用日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否新设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_new",  getFg_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否新设备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要付款属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pay",  getFg_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要付款");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否含有附件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_annexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_annex",  getFg_annexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否含有附件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 附件信息说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnnex_noteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Annex_note",  getAnnex_noteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("附件信息说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否进口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_importADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_import",  getFg_importCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否进口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进口信息说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImport_noteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Import_note",  getImport_noteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进口信息说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否是设备附件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_part",  getFg_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否是设备附件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备附件对应的主设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_card_parentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card_parent",  getId_card_parentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备附件对应的主设备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 卡片录入类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enter_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enter_type",  getId_enter_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片录入类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 卡片录入类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_enter_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_enter_type",  getSd_enter_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片录入类型编码");
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
	private IAttrDesc getId_reg_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reg_oper",  getId_reg_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记人");
		attrDesc.setNullable(true);
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
	private IAttrDesc getDt_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_reg",  getDt_regCDesc(tblDesc), this);
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
	 * 保养周期（天）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUpkeep_cycADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Upkeep_cyc",  getUpkeep_cycCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("保养周期（天）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首次保养日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_upkeep_firstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_upkeep_first",  getDt_upkeep_firstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("首次保养日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上次保养日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_upkeep_lastADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_upkeep_last",  getDt_upkeep_lastCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("上次保养日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下次保养日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_upkeep_nextADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_upkeep_next",  getDt_upkeep_nextCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("下次保养日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量周期（天）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGauge_cycADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gauge_cyc",  getGauge_cycCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("计量周期（天）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上次计量时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_last_gaugeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_last_gauge",  getDt_last_gaugeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("上次计量时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下次计量时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_next_gaugeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_next_gauge",  getDt_next_gaugeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("下次计量时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否固定资产属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_fixedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fixed",  getFg_fixedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否固定资产");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维修信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMaintenanceinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Maintenanceinfo",  getMaintenanceinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("维修信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用年限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsefullifeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usefullife",  getUsefullifeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("使用年限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否打印条码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_printADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_print",  getFg_printCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否打印条码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否急救设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_isaidequADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_isaidequ",  getFg_isaidequCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否急救设备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发票号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInv_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inv_no",  getInv_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发票号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发票日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_invADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_inv",  getDt_invCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("发票日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 凭证字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVoucher_wordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Voucher_word",  getVoucher_wordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("凭证字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停止折旧月份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStop_monthsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stop_months",  getStop_monthsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("停止折旧月份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最近停止折旧时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_last_stopdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_last_stopde",  getDt_last_stopdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("最近停止折旧时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最近重新启用折旧时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_last_restartdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_last_restartde",  getDt_last_restartdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("最近重新启用折旧时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否停止折旧属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stopdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stopdep",  getFg_stopdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否停止折旧");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否顺延折旧年限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_postponeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_postpone",  getFg_postponeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否顺延折旧年限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最近停用或启用操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_last_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_last_oper",  getId_last_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最近停用或启用操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保管地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSave_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Save_place",  getSave_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保管地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卫生部编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMoh_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Moh_code",  getMoh_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卫生部编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 政府编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGover_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gover_code",  getGover_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("政府编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 档案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fileno",  getFilenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("档案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗设备标准名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStandarnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Standarname",  getStandarnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗设备标准名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 财务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAccount_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Account_no",  getAccount_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("财务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGauge_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gauge_no",  getGauge_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 条码是否已经打印属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_printedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_printed",  getFg_printedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("条码是否已经打印");
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
	 * 审批意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAppopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Appop",  getAppopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审批意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备分类内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmca_inrcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emca_inrcode",  getEmca_inrcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备分类内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emca",  getId_emcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否失效属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_availADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_avail",  getFg_availCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否失效");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 批次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Batch",  getBatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("批次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 财务年月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYear_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year_month",  getYear_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("财务年月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否出库属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_out",  getFg_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否出库");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_out",  getDt_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出库日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_out",  getId_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库细目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_out_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_out_itm",  getId_out_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库细目主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入帐审核状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stu",  getId_stuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入帐审核状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入帐审核状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stu",  getSd_stuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入帐审核状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供应商属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_supADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sup",  getId_supCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供应商");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specs",  getSpecsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入库单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_code",  getIn_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_code",  getOut_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库单号");
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
	private IAttrDesc getName_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept",  getName_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b6","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_em",  getCode_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a0b7","id_em=id_em","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_em",  getName_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a0b7","id_em=id_em","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_gaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ga",  getCode_gaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_geca a0b8","id_gauge_ca=id_geca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_gaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ga",  getName_gaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_geca a0b8","id_gauge_ca=id_geca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_source",  getName_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_fee_source=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_source_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_source_fee",  getName_source_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_equ_source=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_use",  getName_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_use=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折旧名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_de",  getName_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("折旧名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_detp a0b12","id_de=id_de","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折旧编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_de",  getCode_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("折旧编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_detp a0b12","id_de=id_de","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_card_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_card_st",  getName_card_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_card_st=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_card_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_card_st",  getCode_card_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_card_st=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_state",  getName_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_state",  getCode_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_state=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wh",  getName_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b15","id_wh=id_wh","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_level",  getName_stor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_stor_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_dept",  getName_stor_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b19","id_stor_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stor_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stor_emp",  getName_stor_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_stor_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_card_parentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_card_parent",  getName_card_parentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_card a0b21","id_card_parent=id_card","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_no_parentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no_parent",  getCard_no_parentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_card a0b21","id_card_parent=id_card","card_no"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_enter_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_enter_type",  getName_enter_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_enter_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reg_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_reg_oper",  getName_reg_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b23","id_reg_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_last_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_last_oper",  getName_last_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b24","id_last_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emca",  getName_emcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_ca a0b25","id_emca=id_emca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stu",  getName_stuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_stu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供应商与厂商名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_supADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sup",  getName_supCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供应商与厂商名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_SUP a0b26","id_sup=id_sup","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取资产卡主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("资产卡主键"); 
		return column;
	}
	/**
	 * 获取卡片编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片编号"); 
		return column;
	}
	/**
	 * 获取卡片名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片名称"); 
		return column;
	}
	/**
	 * 获取使用科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用科室编码"); 
		return column;
	}
	/**
	 * 获取设备基本信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_em");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备基本信息"); 
		return column;
	}
	/**
	 * 获取是否计量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_gaugeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_gauge");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否计量"); 
		return column;
	}
	/**
	 * 获取计量仪器分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gauge_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_gauge_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量仪器分类"); 
		return column;
	}
	/**
	 * 获取是否自制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_selfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_self");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否自制"); 
		return column;
	}
	/**
	 * 获取经费来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fee_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fee_source");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经费来源"); 
		return column;
	}
	/**
	 * 获取经费来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fee_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fee_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经费来源编码"); 
		return column;
	}
	/**
	 * 获取设备来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_equ_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_equ_source");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备来源"); 
		return column;
	}
	/**
	 * 获取设备来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_equ_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_equ_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备来源编码"); 
		return column;
	}
	/**
	 * 获取产权性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRight_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Right_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产权性质"); 
		return column;
	}
	/**
	 * 获取国家名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCountryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Country");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家名称"); 
		return column;
	}
	/**
	 * 获取出厂编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBarcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Barcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出厂编号"); 
		return column;
	}
	/**
	 * 获取生产日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_facCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_fac");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生产日期"); 
		return column;
	}
	/**
	 * 获取合同编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPact_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pact_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("合同编号"); 
		return column;
	}
	/**
	 * 获取资产用途表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_use");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产用途"); 
		return column;
	}
	/**
	 * 获取资产用途编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_use");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产用途编码"); 
		return column;
	}
	/**
	 * 获取资产原值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSource_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Source_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("资产原值"); 
		return column;
	}
	/**
	 * 获取资产净值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNet_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Net_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("资产净值"); 
		return column;
	}
	/**
	 * 获取资产残值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLeave_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Leave_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("资产残值"); 
		return column;
	}
	/**
	 * 获取初始数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInit_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Init_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("初始数量"); 
		return column;
	}
	/**
	 * 获取购入单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBuy_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Buy_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("购入单价"); 
		return column;
	}
	/**
	 * 获取购入金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBuy_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Buy_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("购入金额"); 
		return column;
	}
	/**
	 * 获取折旧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_de");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("折旧方式"); 
		return column;
	}
	/**
	 * 获取折旧年限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDe_yearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"De_year");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("折旧年限"); 
		return column;
	}
	/**
	 * 获取已折旧月份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLess_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Less_month");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("已折旧月份"); 
		return column;
	}
	/**
	 * 获取月折旧金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDe_month_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"De_month_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("月折旧金额"); 
		return column;
	}
	/**
	 * 获取最新折旧时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_de_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_de_oper");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最新折旧时间"); 
		return column;
	}
	/**
	 * 获取维修次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("维修次数"); 
		return column;
	}
	/**
	 * 获取维修费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维修费用"); 
		return column;
	}
	/**
	 * 获取资产建卡状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_card_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card_st");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产建卡状态"); 
		return column;
	}
	/**
	 * 获取资产建卡状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_card_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_card_st");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产建卡状态编码"); 
		return column;
	}
	/**
	 * 获取资产状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_state");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产状态"); 
		return column;
	}
	/**
	 * 获取资产状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_state");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产状态编码"); 
		return column;
	}
	/**
	 * 获取预计净残值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_net_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_net_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("预计净残值"); 
		return column;
	}
	/**
	 * 获取保修截止日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_repair_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_repair_end");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("保修截止日期"); 
		return column;
	}
	/**
	 * 获取维修联系方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepair_contactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Repair_contact");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修联系方式"); 
		return column;
	}
	/**
	 * 获取品牌名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrand_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brand_name");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("品牌名称"); 
		return column;
	}
	/**
	 * 获取卡片备注信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片备注信息"); 
		return column;
	}
	/**
	 * 获取仓库表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库"); 
		return column;
	}
	/**
	 * 获取入库单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_in");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入库单主键"); 
		return column;
	}
	/**
	 * 获取入库单细目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_initmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_initm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入库单细目主键"); 
		return column;
	}
	/**
	 * 获取保管等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管等级"); 
		return column;
	}
	/**
	 * 获取保管等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stor_level");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管等级编码"); 
		return column;
	}
	/**
	 * 获取保管科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管科室"); 
		return column;
	}
	/**
	 * 获取领用日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_getCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_get");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("领用日期"); 
		return column;
	}
	/**
	 * 获取保管人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stor_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stor_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管人"); 
		return column;
	}
	/**
	 * 获取启用日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_startCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_start");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用日期"); 
		return column;
	}
	/**
	 * 获取是否新设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_new");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否新设备"); 
		return column;
	}
	/**
	 * 获取是否需要付款表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要付款"); 
		return column;
	}
	/**
	 * 获取是否含有附件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_annexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_annex");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否含有附件"); 
		return column;
	}
	/**
	 * 获取附件信息说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnnex_noteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Annex_note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("附件信息说明"); 
		return column;
	}
	/**
	 * 获取是否进口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_importCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_import");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否进口"); 
		return column;
	}
	/**
	 * 获取进口信息说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImport_noteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Import_note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进口信息说明"); 
		return column;
	}
	/**
	 * 获取是否是设备附件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_part");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否是设备附件"); 
		return column;
	}
	/**
	 * 获取设备附件对应的主设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_card_parentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card_parent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备附件对应的主设备"); 
		return column;
	}
	/**
	 * 获取卡片录入类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enter_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enter_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片录入类型"); 
		return column;
	}
	/**
	 * 获取卡片录入类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_enter_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_enter_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片录入类型编码"); 
		return column;
	}
	/**
	 * 获取登记人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reg_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reg_oper");
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
	private IColumnDesc getDt_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_reg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("登记时间"); 
		return column;
	}
	/**
	 * 获取保养周期（天）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUpkeep_cycCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Upkeep_cyc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("保养周期（天）"); 
		return column;
	}
	/**
	 * 获取首次保养日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_upkeep_firstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_upkeep_first");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("首次保养日期"); 
		return column;
	}
	/**
	 * 获取上次保养日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_upkeep_lastCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_upkeep_last");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上次保养日期"); 
		return column;
	}
	/**
	 * 获取下次保养日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_upkeep_nextCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_upkeep_next");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("下次保养日期"); 
		return column;
	}
	/**
	 * 获取计量周期（天）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGauge_cycCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gauge_cyc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("计量周期（天）"); 
		return column;
	}
	/**
	 * 获取上次计量时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_last_gaugeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_last_gauge");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上次计量时间"); 
		return column;
	}
	/**
	 * 获取下次计量时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_next_gaugeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_next_gauge");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("下次计量时间"); 
		return column;
	}
	/**
	 * 获取是否固定资产表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_fixedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fixed");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否固定资产"); 
		return column;
	}
	/**
	 * 获取维修信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMaintenanceinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Maintenanceinfo");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("维修信息"); 
		return column;
	}
	/**
	 * 获取使用年限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsefullifeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usefullife");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("使用年限"); 
		return column;
	}
	/**
	 * 获取是否打印条码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_printCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_print");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否打印条码"); 
		return column;
	}
	/**
	 * 获取是否急救设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_isaidequCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_isaidequ");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否急救设备"); 
		return column;
	}
	/**
	 * 获取发票号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInv_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inv_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发票号"); 
		return column;
	}
	/**
	 * 获取发票日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_invCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_inv");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发票日期"); 
		return column;
	}
	/**
	 * 获取凭证字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVoucher_wordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Voucher_word");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("凭证字"); 
		return column;
	}
	/**
	 * 获取停止折旧月份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStop_monthsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stop_months");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("停止折旧月份"); 
		return column;
	}
	/**
	 * 获取最近停止折旧时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_last_stopdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_last_stopde");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最近停止折旧时间"); 
		return column;
	}
	/**
	 * 获取最近重新启用折旧时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_last_restartdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_last_restartde");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最近重新启用折旧时间"); 
		return column;
	}
	/**
	 * 获取是否停止折旧表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stopdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stopdep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否停止折旧"); 
		return column;
	}
	/**
	 * 获取是否顺延折旧年限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_postponeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_postpone");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否顺延折旧年限"); 
		return column;
	}
	/**
	 * 获取最近停用或启用操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_last_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_last_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最近停用或启用操作员"); 
		return column;
	}
	/**
	 * 获取保管地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSave_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Save_place");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保管地点"); 
		return column;
	}
	/**
	 * 获取卫生部编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMoh_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Moh_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卫生部编码"); 
		return column;
	}
	/**
	 * 获取政府编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGover_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gover_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("政府编码"); 
		return column;
	}
	/**
	 * 获取档案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fileno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("档案编号"); 
		return column;
	}
	/**
	 * 获取医疗设备标准名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStandarnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Standarname");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗设备标准名称"); 
		return column;
	}
	/**
	 * 获取财务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAccount_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Account_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("财务编码"); 
		return column;
	}
	/**
	 * 获取计量编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGauge_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gauge_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量编号"); 
		return column;
	}
	/**
	 * 获取条码是否已经打印表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_printedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_printed");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("条码是否已经打印"); 
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
	 * 获取审批意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAppopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Appop");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审批意见"); 
		return column;
	}
	/**
	 * 获取设备分类内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmca_inrcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emca_inrcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类内码"); 
		return column;
	}
	/**
	 * 获取设备分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类"); 
		return column;
	}
	/**
	 * 获取是否失效表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_availCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_avail");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否失效"); 
		return column;
	}
	/**
	 * 获取批次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Batch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("批次"); 
		return column;
	}
	/**
	 * 获取财务年月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYear_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year_month");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("财务年月"); 
		return column;
	}
	/**
	 * 获取是否出库表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_out");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否出库"); 
		return column;
	}
	/**
	 * 获取出库日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_out");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出库日期"); 
		return column;
	}
	/**
	 * 获取出库主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出库主键"); 
		return column;
	}
	/**
	 * 获取出库细目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_out_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_out_itm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出库细目主键"); 
		return column;
	}
	/**
	 * 获取入帐审核状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入帐审核状态"); 
		return column;
	}
	/**
	 * 获取入帐审核状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入帐审核状态编码"); 
		return column;
	}
	/**
	 * 获取供应商表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_supCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sup");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供应商"); 
		return column;
	}
	/**
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规格"); 
		return column;
	}
	/**
	 * 获取入库单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入库单号"); 
		return column;
	}
	/**
	 * 获取出库单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出库单号"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_em");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备编码"); 
		return column;
	}
	/**
	 * 获取设备名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_em");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_gaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ga");
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
	private IColumnDesc getName_gaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ga");
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
	private IColumnDesc getName_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_source");
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
	private IColumnDesc getName_source_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_source_fee");
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
	private IColumnDesc getName_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_use");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取折旧名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_de");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("折旧名称"); 
		return column;
	}
	/**
	 * 获取折旧编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_de");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("折旧编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_card_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_card_st");
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
	private IColumnDesc getCode_card_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_card_st");
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
	private IColumnDesc getName_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_state");
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
	private IColumnDesc getCode_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_state");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取仓库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wh");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_level");
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
	private IColumnDesc getName_stor_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_dept");
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
	private IColumnDesc getName_stor_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stor_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取卡片名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_card_parentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_card_parent");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片名称"); 
		return column;
	}
	/**
	 * 获取卡片编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_no_parentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no_parent");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片编号"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_enter_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_enter_type");
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
	private IColumnDesc getName_reg_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_reg_oper");
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
	private IColumnDesc getName_last_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_last_oper");
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
	private IColumnDesc getName_emcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emca");
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
	private IColumnDesc getName_stuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stu");
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
	private IColumnDesc getName_supCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sup");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供应商与厂商名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_card");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Card_no");
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
