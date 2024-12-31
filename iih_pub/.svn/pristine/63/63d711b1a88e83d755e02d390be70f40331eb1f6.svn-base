
package iih.mp.dg.opdrugmp.d.desc;

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
 * 门诊药品执行明细 DO 元数据信息
 */
public class OpDrugExeItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.opdrugmp.d.OpDrugExeItemDO";
	public static final String CLASS_DISPALYNAME = "门诊药品执行明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_op_dt";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgopdt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OpDrugExeItemDODesc(){
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
		this.setKeyDesc(getId_dgopdtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_dgopADesc(tblDesc));
		this.add(getId_dgopdtADesc(tblDesc));
		this.add(getId_dgopADesc(tblDesc));
		this.add(getId_orsrvADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getQuan_pair_mpADesc(tblDesc));
		this.add(getQuan_mpADesc(tblDesc));
		this.add(getQuan_bkADesc(tblDesc));
		this.add(getId_pkgu_curADesc(tblDesc));
		this.add(getPrice_pkgu_curADesc(tblDesc));
		this.add(getAmt_dueADesc(tblDesc));
		this.add(getAmt_realADesc(tblDesc));
		this.add(getId_quesite_actADesc(tblDesc));
		this.add(getFg_bkfeeADesc(tblDesc));
		this.add(getOnlycodeADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getDes_batADesc(tblDesc));
		this.add(getQuan_pair_bkADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgopdtCDesc(tblDesc));
		tblDesc.add(getId_dgopdtCDesc(tblDesc));
		tblDesc.add(getId_dgopCDesc(tblDesc));
		tblDesc.add(getId_orsrvCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getQuan_pair_mpCDesc(tblDesc));
		tblDesc.add(getQuan_mpCDesc(tblDesc));
		tblDesc.add(getQuan_bkCDesc(tblDesc));
		tblDesc.add(getId_pkgu_curCDesc(tblDesc));
		tblDesc.add(getPrice_pkgu_curCDesc(tblDesc));
		tblDesc.add(getAmt_dueCDesc(tblDesc));
		tblDesc.add(getAmt_realCDesc(tblDesc));
		tblDesc.add(getId_quesite_actCDesc(tblDesc));
		tblDesc.add(getFg_bkfeeCDesc(tblDesc));
		tblDesc.add(getOnlycodeCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getDes_batCDesc(tblDesc));
		tblDesc.add(getQuan_pair_bkCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 门诊药品执行明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgopdtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgopdt",  getId_dgopdtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊药品执行明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊药品执行属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgop",  getId_dgopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊药品执行");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orsrv",  getId_orsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_pair_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_pair_mp",  getQuan_pair_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("执行付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_mp",  getQuan_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("执行数量");
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
	private IAttrDesc getQuan_bkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_bk",  getQuan_bkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("已退数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位_当前包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgu_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgu_cur",  getId_pkgu_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位_当前包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 单价_当前包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrice_pkgu_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price_pkgu_cur",  getPrice_pkgu_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单价_当前包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应收金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_dueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_due",  getAmt_dueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("应收金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实收金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_realADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_real",  getAmt_realCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实收金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际执行窗口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_quesite_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_quesite_act",  getId_quesite_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际执行窗口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bkfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bkfee",  getFg_bkfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("退费标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOnlycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Onlycode",  getOnlycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("唯一码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 批号描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_batADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_bat",  getDes_batCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("批号描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已退付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_pair_bkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_pair_bk",  getQuan_pair_bkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("已退付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取门诊药品执行明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgopdtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgopdt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊药品执行明细主键"); 
		return column;
	}
	/**
	 * 获取门诊药品执行表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊药品执行"); 
		return column;
	}
	/**
	 * 获取药品服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品服务"); 
		return column;
	}
	/**
	 * 获取药品物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品物品"); 
		return column;
	}
	/**
	 * 获取执行付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_pair_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_pair_mp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("执行付数"); 
		return column;
	}
	/**
	 * 获取执行数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_mp");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("执行数量"); 
		return column;
	}
	/**
	 * 获取已退数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_bk");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("已退数量"); 
		return column;
	}
	/**
	 * 获取单位_当前包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgu_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgu_cur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位_当前包装"); 
		return column;
	}
	/**
	 * 获取单价_当前包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrice_pkgu_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price_pkgu_cur");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单价_当前包装"); 
		return column;
	}
	/**
	 * 获取应收金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_dueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_due");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("应收金额"); 
		return column;
	}
	/**
	 * 获取实收金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_realCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_real");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实收金额"); 
		return column;
	}
	/**
	 * 获取实际执行窗口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_quesite_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_quesite_act");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际执行窗口"); 
		return column;
	}
	/**
	 * 获取退费标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bkfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bkfee");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退费标志"); 
		return column;
	}
	/**
	 * 获取唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOnlycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Onlycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一码"); 
		return column;
	}
	/**
	 * 获取服务类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型编码"); 
		return column;
	}
	/**
	 * 获取批号描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_batCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_bat");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("批号描述"); 
		return column;
	}
	/**
	 * 获取已退付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_pair_bkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_pair_bk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("已退付数"); 
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
