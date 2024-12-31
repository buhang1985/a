
package iih.ems.embd.eminfo.d.desc;

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
 * 设备基本信息 DO 元数据信息
 */
public class EmsInfoDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.embd.eminfo.d.EmsInfoDO";
	public static final String CLASS_DISPALYNAME = "设备基本信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ems_info";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_em";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsInfoDODesc(){
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
		this.setKeyDesc(getId_emADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_emADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_emcaADesc(tblDesc));
		this.add(getEmca_inrcodeADesc(tblDesc));
		this.add(getSpecsADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getCurr_priceADesc(tblDesc));
		this.add(getNation_codeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getMnscodeADesc(tblDesc));
		this.add(getId_emtpADesc(tblDesc));
		this.add(getSd_emtpADesc(tblDesc));
		this.add(getLead_codeADesc(tblDesc));
		this.add(getFg_deADesc(tblDesc));
		this.add(getFg_validADesc(tblDesc));
		this.add(getId_deADesc(tblDesc));
		this.add(getDe_yearADesc(tblDesc));
		this.add(getFg_gaugeADesc(tblDesc));
		this.add(getFg_appendADesc(tblDesc));
		this.add(getId_stor_levelADesc(tblDesc));
		this.add(getSd_stor_levelADesc(tblDesc));
		this.add(getMost_numADesc(tblDesc));
		this.add(getLowest_numADesc(tblDesc));
		this.add(getBrand_nameADesc(tblDesc));
		this.add(getEnglish_nameADesc(tblDesc));
		this.add(getFg_selfADesc(tblDesc));
		this.add(getId_gecaADesc(tblDesc));
		this.add(getUpkeep_cycADesc(tblDesc));
		this.add(getGauge_cycADesc(tblDesc));
		this.add(getFg_fixedADesc(tblDesc));
		this.add(getFg_aidemADesc(tblDesc));
		this.add(getFg_isspecialADesc(tblDesc));
		this.add(getTest_cycADesc(tblDesc));
		this.add(getFg_housesADesc(tblDesc));
		this.add(getModelADesc(tblDesc));
		this.add(getFg_pressureADesc(tblDesc));
		this.add(getFg_radiologyADesc(tblDesc));
		this.add(getMoh_codeADesc(tblDesc));
		this.add(getGover_codeADesc(tblDesc));
		this.add(getFg_testemADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getName_caADesc(tblDesc));
		this.add(getCode_caADesc(tblDesc));
		this.add(getName_unitADesc(tblDesc));
		this.add(getCode_unitADesc(tblDesc));
		this.add(getName_emtpADesc(tblDesc));
		this.add(getName_deADesc(tblDesc));
		this.add(getCode_deADesc(tblDesc));
		this.add(getName_slADesc(tblDesc));
		this.add(getName_geADesc(tblDesc));
		this.add(getCode_geADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_emCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_emcaCDesc(tblDesc));
		tblDesc.add(getEmca_inrcodeCDesc(tblDesc));
		tblDesc.add(getSpecsCDesc(tblDesc));
		tblDesc.add(getId_unitCDesc(tblDesc));
		tblDesc.add(getCurr_priceCDesc(tblDesc));
		tblDesc.add(getNation_codeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getMnscodeCDesc(tblDesc));
		tblDesc.add(getId_emtpCDesc(tblDesc));
		tblDesc.add(getSd_emtpCDesc(tblDesc));
		tblDesc.add(getLead_codeCDesc(tblDesc));
		tblDesc.add(getFg_deCDesc(tblDesc));
		tblDesc.add(getFg_validCDesc(tblDesc));
		tblDesc.add(getId_deCDesc(tblDesc));
		tblDesc.add(getDe_yearCDesc(tblDesc));
		tblDesc.add(getFg_gaugeCDesc(tblDesc));
		tblDesc.add(getFg_appendCDesc(tblDesc));
		tblDesc.add(getId_stor_levelCDesc(tblDesc));
		tblDesc.add(getSd_stor_levelCDesc(tblDesc));
		tblDesc.add(getMost_numCDesc(tblDesc));
		tblDesc.add(getLowest_numCDesc(tblDesc));
		tblDesc.add(getBrand_nameCDesc(tblDesc));
		tblDesc.add(getEnglish_nameCDesc(tblDesc));
		tblDesc.add(getFg_selfCDesc(tblDesc));
		tblDesc.add(getId_gecaCDesc(tblDesc));
		tblDesc.add(getUpkeep_cycCDesc(tblDesc));
		tblDesc.add(getGauge_cycCDesc(tblDesc));
		tblDesc.add(getFg_fixedCDesc(tblDesc));
		tblDesc.add(getFg_aidemCDesc(tblDesc));
		tblDesc.add(getFg_isspecialCDesc(tblDesc));
		tblDesc.add(getTest_cycCDesc(tblDesc));
		tblDesc.add(getFg_housesCDesc(tblDesc));
		tblDesc.add(getModelCDesc(tblDesc));
		tblDesc.add(getFg_pressureCDesc(tblDesc));
		tblDesc.add(getFg_radiologyCDesc(tblDesc));
		tblDesc.add(getMoh_codeCDesc(tblDesc));
		tblDesc.add(getGover_codeCDesc(tblDesc));
		tblDesc.add(getFg_testemCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 设备主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_em",  getId_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备编码");
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
	 * 设备分类树内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmca_inrcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emca_inrcode",  getEmca_inrcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备分类树内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最新单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurr_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Curr_price",  getCurr_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最新单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国标码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_code",  getNation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国标码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	private IAttrDesc getMnscodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnscode",  getMnscodeCDesc(tblDesc), this);
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
	 * 设备大类管理类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emtp",  getId_emtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备大类管理类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备大类管理类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emtp",  getSd_emtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备大类管理类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卫生局设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLead_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lead_code",  getLead_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卫生局设备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否折旧属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_de",  getFg_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否折旧");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有效属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_validADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_valid",  getFg_validCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否有效");
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
	 * 是否附加设备(附件)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_appendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_append",  getFg_appendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否附加设备(附件)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 库存上限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMost_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Most_num",  getMost_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("库存上限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存下限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLowest_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lowest_num",  getLowest_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("库存下限");
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
	 * 英文名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnglish_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("English_name",  getEnglish_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 计量仪器分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gecaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_geca",  getId_gecaCDesc(tblDesc), this);
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
	 * 是否急救设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_aidemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_aidem",  getFg_aidemCDesc(tblDesc), this);
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
	 * 是否特殊设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_isspecialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_isspecial",  getFg_isspecialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否特殊设备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备检测周期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTest_cycADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Test_cyc",  getTest_cycCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("设备检测周期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否房屋属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_housesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_houses",  getFg_housesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否房屋");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 型号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Model",  getModelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("型号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否压力容器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pressureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pressure",  getFg_pressureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否压力容器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否放射设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_radiologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_radiology",  getFg_radiologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否放射设备");
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
	 * 是否试用设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_testemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_testem",  getFg_testemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否试用设备");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ca",  getName_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_ca a0b2","id_emca=id_emca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ca",  getCode_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_ca a0b2","id_emca=id_emca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit",  getName_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a0b3","id_unit=id_mmpkgutp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_unit",  getCode_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a0b3","id_unit=id_mmpkgutp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emtp",  getName_emtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_emtp=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"ems_detp a0b5","id_de=id_de","name"});
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
		attrDesc.setRefTblInfos(new String[]{"ems_detp a0b5","id_de=id_de","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_slADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sl",  getName_slCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_stor_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_geADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ge",  getName_geCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_geca a0b7","id_geca=id_geca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_geADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ge",  getCode_geCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_geca a0b7","id_geca=id_geca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取设备主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_em");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("设备主键"); 
		return column;
	}
	/**
	 * 获取设备名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备名称"); 
		return column;
	}
	/**
	 * 获取设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备编码"); 
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
	 * 获取设备分类树内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmca_inrcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emca_inrcode");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类树内码"); 
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
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取最新单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCurr_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Curr_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最新单价"); 
		return column;
	}
	/**
	 * 获取国标码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国标码"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(50);
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
		column.setLength(50);
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
	private IColumnDesc getMnscodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnscode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取设备大类管理类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备大类管理类别"); 
		return column;
	}
	/**
	 * 获取设备大类管理类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备大类管理类别编码"); 
		return column;
	}
	/**
	 * 获取卫生局设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLead_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lead_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卫生局设备编码"); 
		return column;
	}
	/**
	 * 获取是否折旧表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_de");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否折旧"); 
		return column;
	}
	/**
	 * 获取是否有效表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_validCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_valid");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否有效"); 
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
	 * 获取是否附加设备(附件)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_appendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_append");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否附加设备(附件)"); 
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
	 * 获取库存上限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMost_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Most_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("库存上限"); 
		return column;
	}
	/**
	 * 获取库存下限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLowest_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lowest_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("库存下限"); 
		return column;
	}
	/**
	 * 获取品牌名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrand_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brand_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("品牌名称"); 
		return column;
	}
	/**
	 * 获取英文名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnglish_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"English_name");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文名"); 
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
	 * 获取计量仪器分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gecaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_geca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量仪器分类"); 
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
	 * 获取是否急救设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_aidemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_aidem");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否急救设备"); 
		return column;
	}
	/**
	 * 获取是否特殊设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_isspecialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_isspecial");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否特殊设备"); 
		return column;
	}
	/**
	 * 获取设备检测周期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTest_cycCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Test_cyc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("设备检测周期"); 
		return column;
	}
	/**
	 * 获取是否房屋表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_housesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_houses");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否房屋"); 
		return column;
	}
	/**
	 * 获取型号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Model");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("型号"); 
		return column;
	}
	/**
	 * 获取是否压力容器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pressureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pressure");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否压力容器"); 
		return column;
	}
	/**
	 * 获取是否放射设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_radiologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_radiology");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否放射设备"); 
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
	 * 获取是否试用设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_testemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_testem");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否试用设备"); 
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
		column.setLength(50);
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
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ca");
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
	private IColumnDesc getCode_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取包装单位类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位类型名称"); 
		return column;
	}
	/**
	 * 获取包装单位类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位类型编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emtp");
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
	private IColumnDesc getName_slCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sl");
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
	private IColumnDesc getName_geCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ge");
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
	private IColumnDesc getCode_geCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ge");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_em");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Mnscode");
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
