
package iih.mm.gl.generalledger.d.desc;

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
 * 总账 DO 元数据信息
 */
public class GeneralLedgerDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.gl.generalledger.d.GeneralLedgerDO";
	public static final String CLASS_DISPALYNAME = "总账";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MM_GL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_gl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public GeneralLedgerDODesc(){
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
		this.setKeyDesc(getId_glADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_glADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getYearADesc(tblDesc));
		this.add(getMonthADesc(tblDesc));
		this.add(getQuan_bADesc(tblDesc));
		this.add(getAmt_sales_bADesc(tblDesc));
		this.add(getAmt_cost_bADesc(tblDesc));
		this.add(getQuan_inADesc(tblDesc));
		this.add(getAmt_sales_inADesc(tblDesc));
		this.add(getAmt_cost_inADesc(tblDesc));
		this.add(getQuan_outADesc(tblDesc));
		this.add(getAmt_sales_outADesc(tblDesc));
		this.add(getAmt_cost_outADesc(tblDesc));
		this.add(getSd_su_cashADesc(tblDesc));
		this.add(getId_su_cashADesc(tblDesc));
		this.add(getAmt_sales_stpriADesc(tblDesc));
		this.add(getAmt_cost_stpriADesc(tblDesc));
		this.add(getAmt_cost_eADesc(tblDesc));
		this.add(getQuan_eADesc(tblDesc));
		this.add(getAmt_sales_eADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_glCDesc(tblDesc));
		tblDesc.add(getId_glCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getYearCDesc(tblDesc));
		tblDesc.add(getMonthCDesc(tblDesc));
		tblDesc.add(getQuan_bCDesc(tblDesc));
		tblDesc.add(getAmt_sales_bCDesc(tblDesc));
		tblDesc.add(getAmt_cost_bCDesc(tblDesc));
		tblDesc.add(getQuan_inCDesc(tblDesc));
		tblDesc.add(getAmt_sales_inCDesc(tblDesc));
		tblDesc.add(getAmt_cost_inCDesc(tblDesc));
		tblDesc.add(getQuan_outCDesc(tblDesc));
		tblDesc.add(getAmt_sales_outCDesc(tblDesc));
		tblDesc.add(getAmt_cost_outCDesc(tblDesc));
		tblDesc.add(getSd_su_cashCDesc(tblDesc));
		tblDesc.add(getId_su_cashCDesc(tblDesc));
		tblDesc.add(getAmt_sales_stpriCDesc(tblDesc));
		tblDesc.add(getAmt_cost_stpriCDesc(tblDesc));
		tblDesc.add(getAmt_cost_eCDesc(tblDesc));
		tblDesc.add(getQuan_eCDesc(tblDesc));
		tblDesc.add(getAmt_sales_eCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 总账主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_glADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_gl",  getId_glCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总账主键");
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
	 * 库存地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wh",  getId_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存地点");
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
	 * 年度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year",  getYearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 月份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMonthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Month",  getMonthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("月份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期初数量_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_b",  getQuan_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期初数量_基本");
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
	private IAttrDesc getAmt_sales_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sales_b",  getAmt_sales_bCDesc(tblDesc), this);
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
	 * 本期入数量_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_in",  getQuan_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期入数量_基本");
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
	private IAttrDesc getAmt_sales_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sales_in",  getAmt_sales_inCDesc(tblDesc), this);
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
	 * 本期出数量_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_out",  getQuan_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期出数量_基本");
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
	private IAttrDesc getAmt_sales_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sales_out",  getAmt_sales_outCDesc(tblDesc), this);
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
	 * 账务状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_cashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_cash",  getSd_su_cashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账务状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账务状态主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_cashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_cash",  getId_su_cashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账务状态主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期调价金额_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sales_stpriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sales_stpri",  getAmt_sales_stpriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期调价金额_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本期调价金额_成本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cost_stpriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cost_stpri",  getAmt_cost_stpriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本期调价金额_成本");
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
	 * 期末数量_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_e",  getQuan_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("期末数量_基本");
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
	private IAttrDesc getAmt_sales_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sales_e",  getAmt_sales_eCDesc(tblDesc), this);
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b5","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取总账主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_glCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_gl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("总账主键"); 
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
	 * 获取库存地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存地点"); 
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
	 * 获取年度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year");
		column.setLength(4);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年度"); 
		return column;
	}
	/**
	 * 获取月份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMonthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Month");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("月份"); 
		return column;
	}
	/**
	 * 获取期初数量_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_b");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期初数量_基本"); 
		return column;
	}
	/**
	 * 获取期初金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sales_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sales_b");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期初金额_零售"); 
		return column;
	}
	/**
	 * 获取期初金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_b");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期初金额_成本"); 
		return column;
	}
	/**
	 * 获取本期入数量_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_in");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期入数量_基本"); 
		return column;
	}
	/**
	 * 获取本期入金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sales_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sales_in");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期入金额_零售"); 
		return column;
	}
	/**
	 * 获取本期入金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_in");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期入金额_成本"); 
		return column;
	}
	/**
	 * 获取本期出数量_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_out");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期出数量_基本"); 
		return column;
	}
	/**
	 * 获取本期出金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sales_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sales_out");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期出金额_零售"); 
		return column;
	}
	/**
	 * 获取本期出金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_out");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期出金额_成本"); 
		return column;
	}
	/**
	 * 获取账务状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_cashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_cash");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账务状态"); 
		return column;
	}
	/**
	 * 获取账务状态主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_cashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_cash");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账务状态主键"); 
		return column;
	}
	/**
	 * 获取本期调价金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sales_stpriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sales_stpri");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期调价金额_零售"); 
		return column;
	}
	/**
	 * 获取本期调价金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_stpriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_stpri");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本期调价金额_成本"); 
		return column;
	}
	/**
	 * 获取期末金额_成本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cost_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cost_e");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期末金额_成本"); 
		return column;
	}
	/**
	 * 获取期末数量_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_e");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期末数量_基本"); 
		return column;
	}
	/**
	 * 获取期末金额_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sales_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sales_e");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("期末金额_零售"); 
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
		iBDDataInfoFldMap.put("id","Id_gl");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
