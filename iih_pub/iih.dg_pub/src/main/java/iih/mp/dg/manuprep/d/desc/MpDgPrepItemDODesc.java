
package iih.mp.dg.manuprep.d.desc;

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
 * 药品_门诊摆药明细 DO 元数据信息
 */
public class MpDgPrepItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.manuprep.d.MpDgPrepItemDO";
	public static final String CLASS_DISPALYNAME = "药品_门诊摆药明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MP_DG_OPDISP_DT";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgopdispdt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpDgPrepItemDODesc(){
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
		this.setKeyDesc(getId_dgopdispdtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_dgopdispADesc(tblDesc));
		this.add(getId_dgopdispdtADesc(tblDesc));
		this.add(getId_dgopdispADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_orsrvADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getCode_batchADesc(tblDesc));
		this.add(getId_pgku_curADesc(tblDesc));
		this.add(getQuan_curADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getQuan_orADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getId_unit_meduADesc(tblDesc));
		this.add(getQuan_meduADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getId_boildesADesc(tblDesc));
		this.add(getFg_boilADesc(tblDesc));
		this.add(getQuan_orders_boilADesc(tblDesc));
		this.add(getFg_jy_finADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getFg_byADesc(tblDesc));
		this.add(getFg_otcADesc(tblDesc));
		this.add(getSd_valADesc(tblDesc));
		this.add(getCharacterADesc(tblDesc));
		this.add(getOnlycodeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgopdispdtCDesc(tblDesc));
		tblDesc.add(getId_dgopdispdtCDesc(tblDesc));
		tblDesc.add(getId_dgopdispCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_orsrvCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getCode_srvCDesc(tblDesc));
		tblDesc.add(getName_srvCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getCode_batchCDesc(tblDesc));
		tblDesc.add(getId_pgku_curCDesc(tblDesc));
		tblDesc.add(getQuan_curCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getQuan_orCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getId_unit_meduCDesc(tblDesc));
		tblDesc.add(getQuan_meduCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getId_boildesCDesc(tblDesc));
		tblDesc.add(getFg_boilCDesc(tblDesc));
		tblDesc.add(getQuan_orders_boilCDesc(tblDesc));
		tblDesc.add(getFg_jy_finCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getFg_byCDesc(tblDesc));
		tblDesc.add(getFg_otcCDesc(tblDesc));
		tblDesc.add(getSd_valCDesc(tblDesc));
		tblDesc.add(getCharacterCDesc(tblDesc));
		tblDesc.add(getOnlycodeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgopdispdtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgopdispdt",  getId_dgopdispdtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摆药单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgopdispADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgopdisp",  getId_dgopdispCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摆药单主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orsrv",  getId_orsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱服务");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品批次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_batchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_batch",  getCode_batchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品批次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pgku_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pgku_cur",  getId_pgku_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品包装单位");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_当前包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_cur",  getQuan_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量_当前包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_or",  getQuan_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_meduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_medu",  getId_unit_meduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值_医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_meduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_medu",  getQuan_meduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数值_医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中药煎法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boil",  getId_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中药煎法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boildesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boildes",  getId_boildesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 代煎标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_boil",  getFg_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("代煎标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 代煎付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_orders_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_orders_boil",  getQuan_orders_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("代煎付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_jy_finADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_jy_fin",  getFg_jy_finCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("煎药标志");
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
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
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
	 * 服务频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配药(摆药)标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_byADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_by",  getFg_byCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("配药(摆药)标志");
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
	 * 贵重物品标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_val",  getSd_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("贵重物品标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品特性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharacterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Character",  getCharacterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品特性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOnlycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Onlycode",  getOnlycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品唯一码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgopdispdtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgopdispdt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("明细主键"); 
		return column;
	}
	/**
	 * 获取摆药单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgopdispCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgopdisp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("摆药单主键"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取医嘱服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orsrv");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱服务"); 
		return column;
	}
	/**
	 * 获取服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务项目"); 
		return column;
	}
	/**
	 * 获取服务项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目编码"); 
		return column;
	}
	/**
	 * 获取服务项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目名称"); 
		return column;
	}
	/**
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取物品批次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_batchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_batch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品批次"); 
		return column;
	}
	/**
	 * 获取物品包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pgku_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pgku_cur");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("物品包装单位"); 
		return column;
	}
	/**
	 * 获取数量_当前包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_cur");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量_当前包装"); 
		return column;
	}
	/**
	 * 获取价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格"); 
		return column;
	}
	/**
	 * 获取医嘱付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_or");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱付数"); 
		return column;
	}
	/**
	 * 获取金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_meduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_medu");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医学单位"); 
		return column;
	}
	/**
	 * 获取数值_医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_meduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_medu");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数值_医学单位"); 
		return column;
	}
	/**
	 * 获取用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用法编码"); 
		return column;
	}
	/**
	 * 获取用法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(2000);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用法要求"); 
		return column;
	}
	/**
	 * 获取中药煎法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boil");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("中药煎法"); 
		return column;
	}
	/**
	 * 获取煎法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boildesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boildes");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎法要求"); 
		return column;
	}
	/**
	 * 获取代煎标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_boil");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("代煎标志"); 
		return column;
	}
	/**
	 * 获取代煎付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_orders_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_orders_boil");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("代煎付数"); 
		return column;
	}
	/**
	 * 获取煎药标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_jy_finCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_jy_fin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药标志"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取服务频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务频次"); 
		return column;
	}
	/**
	 * 获取配药(摆药)标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_byCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_by");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("配药(摆药)标志"); 
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
	 * 获取贵重物品标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("贵重物品标志"); 
		return column;
	}
	/**
	 * 获取物品特性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharacterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Character");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品特性"); 
		return column;
	}
	/**
	 * 获取物品唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOnlycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Onlycode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品唯一码"); 
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
	
}
