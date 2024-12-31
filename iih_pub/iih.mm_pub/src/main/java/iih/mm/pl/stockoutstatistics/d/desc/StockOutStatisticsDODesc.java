
package iih.mm.pl.stockoutstatistics.d.desc;

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
 * 出库统计表 DO 元数据信息
 */
public class StockOutStatisticsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.pl.stockoutstatistics.d.StockOutStatisticsDO";
	public static final String CLASS_DISPALYNAME = "出库统计表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mm_stat_out";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_stat_out";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public StockOutStatisticsDODesc(){
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
		this.setKeyDesc(getId_stat_outADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_stat_outADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getQuan_1dayADesc(tblDesc));
		this.add(getQuan_2dayADesc(tblDesc));
		this.add(getQuan_3dayADesc(tblDesc));
		this.add(getQuan_4dayADesc(tblDesc));
		this.add(getQuan_5dayADesc(tblDesc));
		this.add(getQuan_6dayADesc(tblDesc));
		this.add(getQuan_7dayADesc(tblDesc));
		this.add(getQuan_14dayADesc(tblDesc));
		this.add(getQuan_21dayADesc(tblDesc));
		this.add(getQuan_28dayADesc(tblDesc));
		this.add(getQuan_90dayADesc(tblDesc));
		this.add(getQuan_60dayADesc(tblDesc));
		this.add(getQuan_30dayADesc(tblDesc));
		this.add(getQuan_curmonADesc(tblDesc));
		this.add(getQuan_2ndmonADesc(tblDesc));
		this.add(getQuan_3rdmonADesc(tblDesc));
		this.add(getQuan_7day_dispADesc(tblDesc));
		this.add(getQuan_14day_dispADesc(tblDesc));
		this.add(getDt_statADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getWh_codeADesc(tblDesc));
		this.add(getWh_nameADesc(tblDesc));
		this.add(getMm_codeADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_stat_outCDesc(tblDesc));
		tblDesc.add(getId_stat_outCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getQuan_1dayCDesc(tblDesc));
		tblDesc.add(getQuan_2dayCDesc(tblDesc));
		tblDesc.add(getQuan_3dayCDesc(tblDesc));
		tblDesc.add(getQuan_4dayCDesc(tblDesc));
		tblDesc.add(getQuan_5dayCDesc(tblDesc));
		tblDesc.add(getQuan_6dayCDesc(tblDesc));
		tblDesc.add(getQuan_7dayCDesc(tblDesc));
		tblDesc.add(getQuan_14dayCDesc(tblDesc));
		tblDesc.add(getQuan_21dayCDesc(tblDesc));
		tblDesc.add(getQuan_28dayCDesc(tblDesc));
		tblDesc.add(getQuan_90dayCDesc(tblDesc));
		tblDesc.add(getQuan_60dayCDesc(tblDesc));
		tblDesc.add(getQuan_30dayCDesc(tblDesc));
		tblDesc.add(getQuan_curmonCDesc(tblDesc));
		tblDesc.add(getQuan_2ndmonCDesc(tblDesc));
		tblDesc.add(getQuan_3rdmonCDesc(tblDesc));
		tblDesc.add(getQuan_7day_dispCDesc(tblDesc));
		tblDesc.add(getQuan_14day_dispCDesc(tblDesc));
		tblDesc.add(getDt_statCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 出库汇总表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stat_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stat_out",  getId_stat_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库汇总表主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 物品id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 1天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_1dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_1day",  getQuan_1dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("1天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 2天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_2dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_2day",  getQuan_2dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("2天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 3天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_3dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_3day",  getQuan_3dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("3天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 4天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_4dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_4day",  getQuan_4dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("4天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 5天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_5dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_5day",  getQuan_5dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("5天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 6天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_6dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_6day",  getQuan_6dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("6天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 7天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_7dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_7day",  getQuan_7dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("7天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 14天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_14dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_14day",  getQuan_14dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("14天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 21天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_21dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_21day",  getQuan_21dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("21天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 28天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_28dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_28day",  getQuan_28dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("28天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 90天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_90dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_90day",  getQuan_90dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("90天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 60天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_60dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_60day",  getQuan_60dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("60天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 30天销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_30dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_30day",  getQuan_30dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("30天销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本月销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_curmonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_curmon",  getQuan_curmonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本月销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上月销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_2ndmonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_2ndmon",  getQuan_2ndmonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("上月销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上上月销量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_3rdmonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_3rdmon",  getQuan_3rdmonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("上上月销量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 7天发药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_7day_dispADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_7day_disp",  getQuan_7day_dispCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("7天发药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 14天发药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_14day_dispADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_14day_disp",  getQuan_14day_dispCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("14天发药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统计时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_stat",  getDt_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("统计时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
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
	 * 仓库编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWh_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wh_code",  getWh_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b5","id_wh=id_wh","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWh_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wh_name",  getWh_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b5","id_wh=id_wh","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_code",  getMm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_name",  getMm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取出库汇总表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stat_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stat_out");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出库汇总表主键"); 
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
	 * 获取物品id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品id"); 
		return column;
	}
	/**
	 * 获取1天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_1dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_1day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("1天销量"); 
		return column;
	}
	/**
	 * 获取2天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_2dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_2day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("2天销量"); 
		return column;
	}
	/**
	 * 获取3天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_3dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_3day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("3天销量"); 
		return column;
	}
	/**
	 * 获取4天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_4dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_4day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("4天销量"); 
		return column;
	}
	/**
	 * 获取5天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_5dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_5day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("5天销量"); 
		return column;
	}
	/**
	 * 获取6天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_6dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_6day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("6天销量"); 
		return column;
	}
	/**
	 * 获取7天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_7dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_7day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("7天销量"); 
		return column;
	}
	/**
	 * 获取14天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_14dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_14day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("14天销量"); 
		return column;
	}
	/**
	 * 获取21天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_21dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_21day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("21天销量"); 
		return column;
	}
	/**
	 * 获取28天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_28dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_28day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("28天销量"); 
		return column;
	}
	/**
	 * 获取90天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_90dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_90day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("90天销量"); 
		return column;
	}
	/**
	 * 获取60天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_60dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_60day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("60天销量"); 
		return column;
	}
	/**
	 * 获取30天销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_30dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_30day");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("30天销量"); 
		return column;
	}
	/**
	 * 获取本月销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_curmonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_curmon");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本月销量"); 
		return column;
	}
	/**
	 * 获取上月销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_2ndmonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_2ndmon");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("上月销量"); 
		return column;
	}
	/**
	 * 获取上上月销量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_3rdmonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_3rdmon");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("上上月销量"); 
		return column;
	}
	/**
	 * 获取7天发药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_7day_dispCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_7day_disp");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("7天发药"); 
		return column;
	}
	/**
	 * 获取14天发药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_14day_dispCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_14day_disp");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("14天发药"); 
		return column;
	}
	/**
	 * 获取统计时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_stat");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("统计时间"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
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
	 * 获取仓库编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWh_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wh_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库编码"); 
		return column;
	}
	/**
	 * 获取仓库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWh_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wh_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库名称"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_code");
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
	private IColumnDesc getMm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
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
