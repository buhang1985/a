
package iih.mc.mc.monthaccdetail.d.desc;

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
 * 仓库月结明细账 DO 元数据信息
 */
public class McMonthAccDetailDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mc.mc.monthaccdetail.d.McMonthAccDetailDO";
	public static final String CLASS_DISPALYNAME = "仓库月结明细账";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MC_MCDE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mcde";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public McMonthAccDetailDODesc(){
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
		this.setKeyDesc(getId_mcdeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mcdeADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getYear_monthADesc(tblDesc));
		this.add(getQuan_bADesc(tblDesc));
		this.add(getAmt_cost_bADesc(tblDesc));
		this.add(getAmt_sale_bADesc(tblDesc));
		this.add(getQuan_inADesc(tblDesc));
		this.add(getAmt_cost_inADesc(tblDesc));
		this.add(getAmt_sale_inADesc(tblDesc));
		this.add(getQuan_outADesc(tblDesc));
		this.add(getAmt_cost_outADesc(tblDesc));
		this.add(getAmt_sale_outADesc(tblDesc));
		this.add(getQuan_eADesc(tblDesc));
		this.add(getAmt_cost_eADesc(tblDesc));
		this.add(getAmt_sale_eADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mcdeCDesc(tblDesc));
		tblDesc.add(getId_mcdeCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getYear_monthCDesc(tblDesc));
		tblDesc.add(getQuan_bCDesc(tblDesc));
		tblDesc.add(getAmt_cost_bCDesc(tblDesc));
		tblDesc.add(getAmt_sale_bCDesc(tblDesc));
		tblDesc.add(getQuan_inCDesc(tblDesc));
		tblDesc.add(getAmt_cost_inCDesc(tblDesc));
		tblDesc.add(getAmt_sale_inCDesc(tblDesc));
		tblDesc.add(getQuan_outCDesc(tblDesc));
		tblDesc.add(getAmt_cost_outCDesc(tblDesc));
		tblDesc.add(getAmt_sale_outCDesc(tblDesc));
		tblDesc.add(getQuan_eCDesc(tblDesc));
		tblDesc.add(getAmt_cost_eCDesc(tblDesc));
		tblDesc.add(getAmt_sale_eCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 月结账主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mcdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mcde",  getId_mcdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("月结账主键");
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
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 账务年月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYear_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year_month",  getYear_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账务年月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期初数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_b",  getQuan_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期初数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期初金额_成本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cost_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cost_b",  getAmt_cost_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期初金额_成本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期初金额_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sale_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sale_b",  getAmt_sale_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期初金额_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期入数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_in",  getQuan_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期入数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期入金额_成本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cost_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cost_in",  getAmt_cost_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期入金额_成本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期入金额_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sale_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sale_in",  getAmt_sale_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期入金额_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期出数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_out",  getQuan_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期出数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期出金额_成本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cost_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cost_out",  getAmt_cost_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期出金额_成本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期出金额_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sale_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sale_out",  getAmt_sale_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期出金额_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期末数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_e",  getQuan_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期末数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期末金额_成本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cost_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cost_e",  getAmt_cost_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期末金额_成本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期末金额_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sale_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sale_e",  getAmt_sale_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期末金额_零售");
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
	 * 获取月结账主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mcdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mcde");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("月结账主键"); 
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
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取账务年月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYear_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year_month");
		column.setLength(6);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("账务年月"); 
		return column;
	}
	/**
	 * 获取期初数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_b");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期初数量"); 
		return column;
	}
	/**
	 * 获取期初金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_b");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期初金额_成本"); 
		return column;
	}
	/**
	 * 获取期初金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sale_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sale_b");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期初金额_零售"); 
		return column;
	}
	/**
	 * 获取本期入数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_in");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期入数量"); 
		return column;
	}
	/**
	 * 获取本期入金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_in");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期入金额_成本"); 
		return column;
	}
	/**
	 * 获取本期入金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sale_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sale_in");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期入金额_零售"); 
		return column;
	}
	/**
	 * 获取本期出数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_out");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期出数量"); 
		return column;
	}
	/**
	 * 获取本期出金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_out");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期出金额_成本"); 
		return column;
	}
	/**
	 * 获取本期出金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sale_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sale_out");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期出金额_零售"); 
		return column;
	}
	/**
	 * 获取期末数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_e");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期末数量"); 
		return column;
	}
	/**
	 * 获取期末金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_e");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期末金额_成本"); 
		return column;
	}
	/**
	 * 获取期末金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sale_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sale_e");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期末金额_零售"); 
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
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_mcde");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
