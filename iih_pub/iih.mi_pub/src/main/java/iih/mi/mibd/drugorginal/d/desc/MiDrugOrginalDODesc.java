
package iih.mi.mibd.drugorginal.d.desc;

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
 * (新)医保药品原始目录 DO 元数据信息
 */
public class MiDrugOrginalDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.mibd.drugorginal.d.MiDrugOrginalDO";
	public static final String CLASS_DISPALYNAME = "(新)医保药品原始目录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_drug_orginal";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_midrugorginal";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiDrugOrginalDODesc(){
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
		this.setKeyDesc(getId_midrugorginalADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_midrugorginalADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getDrug_trade_nameADesc(tblDesc));
		this.add(getPy_codeADesc(tblDesc));
		this.add(getWb_codeADesc(tblDesc));
		this.add(getCode_caADesc(tblDesc));
		this.add(getSd_hpsrvtpADesc(tblDesc));
		this.add(getPrice_fixedADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getRate_oepADesc(tblDesc));
		this.add(getRate_ipADesc(tblDesc));
		this.add(getRate_retireADesc(tblDesc));
		this.add(getRate_injuryADesc(tblDesc));
		this.add(getRate_birthADesc(tblDesc));
		this.add(getRate_unitADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getSpecADesc(tblDesc));
		this.add(getUnitADesc(tblDesc));
		this.add(getBidding_priceADesc(tblDesc));
		this.add(getReference_priceADesc(tblDesc));
		this.add(getFg_spec_drugADesc(tblDesc));
		this.add(getPharm_nameADesc(tblDesc));
		this.add(getQuasi_drugADesc(tblDesc));
		this.add(getOrigin_placeADesc(tblDesc));
		this.add(getFg_effectiveADesc(tblDesc));
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
		this.add(getDef11ADesc(tblDesc));
		this.add(getDef12ADesc(tblDesc));
		this.add(getDef13ADesc(tblDesc));
		this.add(getDef14ADesc(tblDesc));
		this.add(getDef15ADesc(tblDesc));
		this.add(getDef16ADesc(tblDesc));
		this.add(getDef17ADesc(tblDesc));
		this.add(getDef18ADesc(tblDesc));
		this.add(getDef19ADesc(tblDesc));
		this.add(getDef20ADesc(tblDesc));
		this.add(getDef21ADesc(tblDesc));
		this.add(getDef22ADesc(tblDesc));
		this.add(getDef23ADesc(tblDesc));
		this.add(getDef24ADesc(tblDesc));
		this.add(getDef25ADesc(tblDesc));
		this.add(getDef26ADesc(tblDesc));
		this.add(getDef27ADesc(tblDesc));
		this.add(getDef28ADesc(tblDesc));
		this.add(getDef29ADesc(tblDesc));
		this.add(getDef30ADesc(tblDesc));
		this.add(getDef31ADesc(tblDesc));
		this.add(getDef32ADesc(tblDesc));
		this.add(getDef33ADesc(tblDesc));
		this.add(getDef34ADesc(tblDesc));
		this.add(getDef35ADesc(tblDesc));
		this.add(getDef36ADesc(tblDesc));
		this.add(getDef37ADesc(tblDesc));
		this.add(getDef38ADesc(tblDesc));
		this.add(getDef39ADesc(tblDesc));
		this.add(getDef40ADesc(tblDesc));
		this.add(getDef41ADesc(tblDesc));
		this.add(getDef42ADesc(tblDesc));
		this.add(getDef43ADesc(tblDesc));
		this.add(getDef44ADesc(tblDesc));
		this.add(getDef45ADesc(tblDesc));
		this.add(getDef46ADesc(tblDesc));
		this.add(getDef47ADesc(tblDesc));
		this.add(getDef48ADesc(tblDesc));
		this.add(getDef49ADesc(tblDesc));
		this.add(getDef50ADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_midrugorginalCDesc(tblDesc));
		tblDesc.add(getId_midrugorginalCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getDrug_trade_nameCDesc(tblDesc));
		tblDesc.add(getPy_codeCDesc(tblDesc));
		tblDesc.add(getWb_codeCDesc(tblDesc));
		tblDesc.add(getCode_caCDesc(tblDesc));
		tblDesc.add(getSd_hpsrvtpCDesc(tblDesc));
		tblDesc.add(getPrice_fixedCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getRate_oepCDesc(tblDesc));
		tblDesc.add(getRate_ipCDesc(tblDesc));
		tblDesc.add(getRate_retireCDesc(tblDesc));
		tblDesc.add(getRate_injuryCDesc(tblDesc));
		tblDesc.add(getRate_birthCDesc(tblDesc));
		tblDesc.add(getRate_unitCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getSpecCDesc(tblDesc));
		tblDesc.add(getUnitCDesc(tblDesc));
		tblDesc.add(getBidding_priceCDesc(tblDesc));
		tblDesc.add(getReference_priceCDesc(tblDesc));
		tblDesc.add(getFg_spec_drugCDesc(tblDesc));
		tblDesc.add(getPharm_nameCDesc(tblDesc));
		tblDesc.add(getQuasi_drugCDesc(tblDesc));
		tblDesc.add(getOrigin_placeCDesc(tblDesc));
		tblDesc.add(getFg_effectiveCDesc(tblDesc));
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
		tblDesc.add(getDef11CDesc(tblDesc));
		tblDesc.add(getDef12CDesc(tblDesc));
		tblDesc.add(getDef13CDesc(tblDesc));
		tblDesc.add(getDef14CDesc(tblDesc));
		tblDesc.add(getDef15CDesc(tblDesc));
		tblDesc.add(getDef16CDesc(tblDesc));
		tblDesc.add(getDef17CDesc(tblDesc));
		tblDesc.add(getDef18CDesc(tblDesc));
		tblDesc.add(getDef19CDesc(tblDesc));
		tblDesc.add(getDef20CDesc(tblDesc));
		tblDesc.add(getDef21CDesc(tblDesc));
		tblDesc.add(getDef22CDesc(tblDesc));
		tblDesc.add(getDef23CDesc(tblDesc));
		tblDesc.add(getDef24CDesc(tblDesc));
		tblDesc.add(getDef25CDesc(tblDesc));
		tblDesc.add(getDef26CDesc(tblDesc));
		tblDesc.add(getDef27CDesc(tblDesc));
		tblDesc.add(getDef28CDesc(tblDesc));
		tblDesc.add(getDef29CDesc(tblDesc));
		tblDesc.add(getDef30CDesc(tblDesc));
		tblDesc.add(getDef31CDesc(tblDesc));
		tblDesc.add(getDef32CDesc(tblDesc));
		tblDesc.add(getDef33CDesc(tblDesc));
		tblDesc.add(getDef34CDesc(tblDesc));
		tblDesc.add(getDef35CDesc(tblDesc));
		tblDesc.add(getDef36CDesc(tblDesc));
		tblDesc.add(getDef37CDesc(tblDesc));
		tblDesc.add(getDef38CDesc(tblDesc));
		tblDesc.add(getDef39CDesc(tblDesc));
		tblDesc.add(getDef40CDesc(tblDesc));
		tblDesc.add(getDef41CDesc(tblDesc));
		tblDesc.add(getDef42CDesc(tblDesc));
		tblDesc.add(getDef43CDesc(tblDesc));
		tblDesc.add(getDef44CDesc(tblDesc));
		tblDesc.add(getDef45CDesc(tblDesc));
		tblDesc.add(getDef46CDesc(tblDesc));
		tblDesc.add(getDef47CDesc(tblDesc));
		tblDesc.add(getDef48CDesc(tblDesc));
		tblDesc.add(getDef49CDesc(tblDesc));
		tblDesc.add(getDef50CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 原始目录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_midrugorginalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_midrugorginal",  getId_midrugorginalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原始目录主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品商品名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_trade_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_trade_name",  getDrug_trade_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品商品名");
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
	private IAttrDesc getPy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Py_code",  getPy_codeCDesc(tblDesc), this);
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
	private IAttrDesc getWb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wb_code",  getWb_codeCDesc(tblDesc), this);
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
	 * 收费类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ca",  getCode_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目录等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hpsrvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hpsrvtp",  getSd_hpsrvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目录等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 限价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrice_fixedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price_fixed",  getPrice_fixedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("限价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b",  getDt_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_oep",  getRate_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("门诊自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_ip",  getRate_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离休自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_retireADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_retire",  getRate_retireCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("离休自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工伤自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_injury",  getRate_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("工伤自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生育自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_birth",  getRate_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("生育自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_unit",  getRate_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单位自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usage",  getUsageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法");
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
	private IAttrDesc getSpecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spec",  getSpecCDesc(tblDesc), this);
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
	private IAttrDesc getUnitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit",  getUnitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 招标价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBidding_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bidding_price",  getBidding_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("招标价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReference_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reference_price",  getReference_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("参考价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特药标志(处方药标志)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_spec_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_spec_drug",  getFg_spec_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特药标志(处方药标志)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药厂名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPharm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pharm_name",  getPharm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药厂名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国药准字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuasi_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quasi_drug",  getQuasi_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国药准字");
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
	private IAttrDesc getOrigin_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Origin_place",  getOrigin_placeCDesc(tblDesc), this);
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
	 * 有效标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_effectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_effective",  getFg_effectiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def11",  getDef11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def12",  getDef12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def13",  getDef13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def14",  getDef14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def15",  getDef15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def16",  getDef16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段17属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def17",  getDef17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段17");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段18属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def18",  getDef18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段18");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段19属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def19",  getDef19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段19");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段20属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def20",  getDef20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段20");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段21属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def21",  getDef21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段21");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段22属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def22",  getDef22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段22");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段23属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def23",  getDef23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段23");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段24属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def24",  getDef24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段24");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段25属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def25",  getDef25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段25");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段26属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def26",  getDef26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段26");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段27属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def27",  getDef27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段27");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段28属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def28",  getDef28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段28");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段29属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def29",  getDef29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段29");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段30属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def30",  getDef30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段30");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段31属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def31",  getDef31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段31");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段32属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def32",  getDef32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段32");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段33属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def33",  getDef33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段33");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段34属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def34",  getDef34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段34");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段35属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def35",  getDef35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段35");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段36属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def36",  getDef36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段36");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段37属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def37",  getDef37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段37");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段38属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def38",  getDef38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段38");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段39属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def39",  getDef39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段39");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段40属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def40",  getDef40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段40");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段41属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def41",  getDef41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段41");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段42属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def42",  getDef42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段42");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段43属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def43",  getDef43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段43");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段44属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def44",  getDef44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段44");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段45属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def45",  getDef45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段45");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段46属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def46",  getDef46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段46");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段47属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def47",  getDef47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段47");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段48属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def48",  getDef48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段48");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段49属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def49",  getDef49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段49");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段50属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def50",  getDef50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段50");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取原始目录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_midrugorginalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_midrugorginal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原始目录主键"); 
		return column;
	}
	/**
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取药品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品编码"); 
		return column;
	}
	/**
	 * 获取药品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品名称"); 
		return column;
	}
	/**
	 * 获取药品商品名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_trade_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_trade_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品商品名"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Py_code");
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
	private IColumnDesc getWb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wb_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取收费类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费类别"); 
		return column;
	}
	/**
	 * 获取目录等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hpsrvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hpsrvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目录等级"); 
		return column;
	}
	/**
	 * 获取限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrice_fixedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price_fixed");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("限价"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取门诊自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_oep");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("门诊自付比例"); 
		return column;
	}
	/**
	 * 获取住院自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院自付比例"); 
		return column;
	}
	/**
	 * 获取离休自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_retireCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_retire");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("离休自付比例"); 
		return column;
	}
	/**
	 * 获取工伤自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_injury");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("工伤自付比例"); 
		return column;
	}
	/**
	 * 获取生育自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_birth");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("生育自付比例"); 
		return column;
	}
	/**
	 * 获取单位自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_unit");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单位自付比例"); 
		return column;
	}
	/**
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法"); 
		return column;
	}
	/**
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec");
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
	private IColumnDesc getUnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取招标价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBidding_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bidding_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("招标价格"); 
		return column;
	}
	/**
	 * 获取参考价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReference_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reference_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("参考价"); 
		return column;
	}
	/**
	 * 获取特药标志(处方药标志)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_spec_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_spec_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特药标志(处方药标志)"); 
		return column;
	}
	/**
	 * 获取药厂名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPharm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pharm_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药厂名称"); 
		return column;
	}
	/**
	 * 获取国药准字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuasi_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quasi_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国药准字"); 
		return column;
	}
	/**
	 * 获取产地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrigin_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Origin_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产地"); 
		return column;
	}
	/**
	 * 获取有效标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_effectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_effective");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效标志"); 
		return column;
	}
	/**
	 * 获取备用字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段1"); 
		return column;
	}
	/**
	 * 获取备用字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段2"); 
		return column;
	}
	/**
	 * 获取备用字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段3"); 
		return column;
	}
	/**
	 * 获取备用字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段4"); 
		return column;
	}
	/**
	 * 获取备用字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段5"); 
		return column;
	}
	/**
	 * 获取备用字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段6"); 
		return column;
	}
	/**
	 * 获取备用字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段7"); 
		return column;
	}
	/**
	 * 获取备用字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段8"); 
		return column;
	}
	/**
	 * 获取备用字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段9"); 
		return column;
	}
	/**
	 * 获取备用字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段10"); 
		return column;
	}
	/**
	 * 获取备用字段11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def11");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段11"); 
		return column;
	}
	/**
	 * 获取备用字段12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def12");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段12"); 
		return column;
	}
	/**
	 * 获取备用字段13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def13");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段13"); 
		return column;
	}
	/**
	 * 获取备用字段14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def14");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段14"); 
		return column;
	}
	/**
	 * 获取备用字段15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def15");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段15"); 
		return column;
	}
	/**
	 * 获取备用字段16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def16");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段16"); 
		return column;
	}
	/**
	 * 获取备用字段17表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def17");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段17"); 
		return column;
	}
	/**
	 * 获取备用字段18表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def18");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段18"); 
		return column;
	}
	/**
	 * 获取备用字段19表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def19");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段19"); 
		return column;
	}
	/**
	 * 获取备用字段20表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def20");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段20"); 
		return column;
	}
	/**
	 * 获取备用字段21表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def21");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段21"); 
		return column;
	}
	/**
	 * 获取备用字段22表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def22");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段22"); 
		return column;
	}
	/**
	 * 获取备用字段23表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def23");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段23"); 
		return column;
	}
	/**
	 * 获取备用字段24表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def24");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段24"); 
		return column;
	}
	/**
	 * 获取备用字段25表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def25");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段25"); 
		return column;
	}
	/**
	 * 获取备用字段26表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def26");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段26"); 
		return column;
	}
	/**
	 * 获取备用字段27表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def27");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段27"); 
		return column;
	}
	/**
	 * 获取备用字段28表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def28");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段28"); 
		return column;
	}
	/**
	 * 获取备用字段29表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def29");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段29"); 
		return column;
	}
	/**
	 * 获取备用字段30表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def30");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段30"); 
		return column;
	}
	/**
	 * 获取备用字段31表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def31");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段31"); 
		return column;
	}
	/**
	 * 获取备用字段32表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def32");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段32"); 
		return column;
	}
	/**
	 * 获取备用字段33表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def33");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段33"); 
		return column;
	}
	/**
	 * 获取备用字段34表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def34");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段34"); 
		return column;
	}
	/**
	 * 获取备用字段35表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def35");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段35"); 
		return column;
	}
	/**
	 * 获取备用字段36表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def36");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段36"); 
		return column;
	}
	/**
	 * 获取备用字段37表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def37");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段37"); 
		return column;
	}
	/**
	 * 获取备用字段38表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def38");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段38"); 
		return column;
	}
	/**
	 * 获取备用字段39表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def39");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段39"); 
		return column;
	}
	/**
	 * 获取备用字段40表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def40");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段40"); 
		return column;
	}
	/**
	 * 获取备用字段41表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def41");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段41"); 
		return column;
	}
	/**
	 * 获取备用字段42表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def42");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段42"); 
		return column;
	}
	/**
	 * 获取备用字段43表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def43");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段43"); 
		return column;
	}
	/**
	 * 获取备用字段44表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def44");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段44"); 
		return column;
	}
	/**
	 * 获取备用字段45表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def45");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段45"); 
		return column;
	}
	/**
	 * 获取备用字段46表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def46");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段46"); 
		return column;
	}
	/**
	 * 获取备用字段47表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def47");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段47"); 
		return column;
	}
	/**
	 * 获取备用字段48表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def48");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段48"); 
		return column;
	}
	/**
	 * 获取备用字段49表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def49");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段49"); 
		return column;
	}
	/**
	 * 获取备用字段50表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def50");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段50"); 
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
