
package iih.ems.einv.emin.d.desc;

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
 * 设备入库细目 DO 元数据信息
 */
public class EmsInItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.einv.emin.d.EmsInItmDO";
	public static final String CLASS_DISPALYNAME = "设备入库细目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ems_in_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_initm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsInItmDODesc(){
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
		this.setKeyDesc(getId_initmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_inADesc(tblDesc));
		this.add(getId_initmADesc(tblDesc));
		this.add(getId_inADesc(tblDesc));
		this.add(getId_emADesc(tblDesc));
		this.add(getInnercodeADesc(tblDesc));
		this.add(getId_emblADesc(tblDesc));
		this.add(getBarcodeADesc(tblDesc));
		this.add(getDt_facADesc(tblDesc));
		this.add(getIn_numADesc(tblDesc));
		this.add(getBuy_priceADesc(tblDesc));
		this.add(getBuy_costADesc(tblDesc));
		this.add(getLess_monthADesc(tblDesc));
		this.add(getDe_yearADesc(tblDesc));
		this.add(getInv_noADesc(tblDesc));
		this.add(getDt_invADesc(tblDesc));
		this.add(getVoucher_noADesc(tblDesc));
		this.add(getProducing_areaADesc(tblDesc));
		this.add(getBrand_nameADesc(tblDesc));
		this.add(getFg_newADesc(tblDesc));
		this.add(getFg_payADesc(tblDesc));
		this.add(getId_payADesc(tblDesc));
		this.add(getId_cardADesc(tblDesc));
		this.add(getFg_fixedADesc(tblDesc));
		this.add(getUsefullifeADesc(tblDesc));
		this.add(getVoucher_wordADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getFg_printedADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getId_emcaADesc(tblDesc));
		this.add(getBatchADesc(tblDesc));
		this.add(getEmca_inrcodeADesc(tblDesc));
		this.add(getRtned_numADesc(tblDesc));
		this.add(getId_resitmADesc(tblDesc));
		this.add(getName_emADesc(tblDesc));
		this.add(getCode_emADesc(tblDesc));
		this.add(getSpecs_emADesc(tblDesc));
		this.add(getEnglish_name_cADesc(tblDesc));
		this.add(getName_cardADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getCode_unitADesc(tblDesc));
		this.add(getName_unitADesc(tblDesc));
		this.add(getName_emcaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_initmCDesc(tblDesc));
		tblDesc.add(getId_initmCDesc(tblDesc));
		tblDesc.add(getId_inCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getInnercodeCDesc(tblDesc));
		tblDesc.add(getId_emblCDesc(tblDesc));
		tblDesc.add(getBarcodeCDesc(tblDesc));
		tblDesc.add(getDt_facCDesc(tblDesc));
		tblDesc.add(getIn_numCDesc(tblDesc));
		tblDesc.add(getBuy_priceCDesc(tblDesc));
		tblDesc.add(getBuy_costCDesc(tblDesc));
		tblDesc.add(getLess_monthCDesc(tblDesc));
		tblDesc.add(getDe_yearCDesc(tblDesc));
		tblDesc.add(getInv_noCDesc(tblDesc));
		tblDesc.add(getDt_invCDesc(tblDesc));
		tblDesc.add(getVoucher_noCDesc(tblDesc));
		tblDesc.add(getProducing_areaCDesc(tblDesc));
		tblDesc.add(getBrand_nameCDesc(tblDesc));
		tblDesc.add(getFg_newCDesc(tblDesc));
		tblDesc.add(getFg_payCDesc(tblDesc));
		tblDesc.add(getId_payCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getFg_fixedCDesc(tblDesc));
		tblDesc.add(getUsefullifeCDesc(tblDesc));
		tblDesc.add(getVoucher_wordCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getFg_printedCDesc(tblDesc));
		tblDesc.add(getId_unitCDesc(tblDesc));
		tblDesc.add(getId_emcaCDesc(tblDesc));
		tblDesc.add(getBatchCDesc(tblDesc));
		tblDesc.add(getEmca_inrcodeCDesc(tblDesc));
		tblDesc.add(getRtned_numCDesc(tblDesc));
		tblDesc.add(getId_resitmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 入库单细目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_initmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_initm",  getId_initmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单细目");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入库单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_in",  getId_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单");
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
	 * 院内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInnercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Innercode",  getInnercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首次入库库存ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emblADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_embl",  getId_emblCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("首次入库库存ID");
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
	 * 入库数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_num",  getIn_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入库数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBuy_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Buy_price",  getBuy_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 购买总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBuy_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Buy_cost",  getBuy_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("购买总金额");
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
	 * 发票号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInv_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inv_no",  getInv_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发票号码");
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
	 * 凭证号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVoucher_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Voucher_no",  getVoucher_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("凭证号码");
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
	private IAttrDesc getProducing_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Producing_area",  getProducing_areaCDesc(tblDesc), this);
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
	 * 供货商结算流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pay",  getId_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供货商结算流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 使用年限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsefullifeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usefullife",  getUsefullifeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用年限");
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
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
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
	 * 包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 分类树码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmca_inrcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emca_inrcode",  getEmca_inrcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分类树码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已退数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRtned_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rtned_num",  getRtned_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("已退数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原入库单明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_resitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_resitm",  getId_resitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原入库单明细");
		attrDesc.setNullable(true);
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
	private IAttrDesc getName_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_em",  getName_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","name"});
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
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecs_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specs_em",  getSpecs_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","specs"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英文名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnglish_name_cADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("English_name_c",  getEnglish_name_cCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","english_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_card",  getName_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_card a1b6","id_card=id_card","name"});
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
		attrDesc.setRefTblInfos(new String[]{"ems_card a1b6","id_card=id_card","card_no"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b4","id_unit=id_mmpkgutp","code"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b4","id_unit=id_mmpkgutp","name"});
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
		attrDesc.setRefTblInfos(new String[]{"ems_ca a1b5","id_emca=id_emca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取入库单细目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_initmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_initm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入库单细目"); 
		return column;
	}
	/**
	 * 获取入库单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_in");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入库单"); 
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
	 * 获取院内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInnercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Innercode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院内码"); 
		return column;
	}
	/**
	 * 获取首次入库库存ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emblCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_embl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("首次入库库存ID"); 
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
	 * 获取入库数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入库数量"); 
		return column;
	}
	/**
	 * 获取单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBuy_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Buy_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单价"); 
		return column;
	}
	/**
	 * 获取购买总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBuy_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Buy_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("购买总金额"); 
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
	 * 获取发票号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInv_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inv_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发票号码"); 
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
	 * 获取凭证号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVoucher_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Voucher_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("凭证号码"); 
		return column;
	}
	/**
	 * 获取产地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProducing_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Producing_area");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产地"); 
		return column;
	}
	/**
	 * 获取品牌名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrand_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brand_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("品牌名称"); 
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
	 * 获取供货商结算流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pay");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供货商结算流水号"); 
		return column;
	}
	/**
	 * 获取卡片流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片流水号"); 
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
	 * 获取使用年限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsefullifeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usefullife");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用年限"); 
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
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	 * 获取包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位"); 
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
	 * 获取分类树码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmca_inrcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emca_inrcode");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分类树码"); 
		return column;
	}
	/**
	 * 获取已退数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRtned_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rtned_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("已退数量"); 
		return column;
	}
	/**
	 * 获取原入库单明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_resitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_resitm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原入库单明细"); 
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
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecs_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specs_em");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规格"); 
		return column;
	}
	/**
	 * 获取英文名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnglish_name_cCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"English_name_c");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文名"); 
		return column;
	}
	/**
	 * 获取卡片名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_card");
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
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片编号"); 
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
