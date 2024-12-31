
package iih.sc.scp.aidset.d.desc;

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
 * 辅助样本设置 DO 元数据信息
 */
public class ScPlanAidSetDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scp.aidset.d.ScPlanAidSetDO";
	public static final String CLASS_DISPALYNAME = "辅助样本设置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_pl_aidset";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_scpladiset";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScPlanAidSetDODesc(){
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
		this.setKeyDesc(getId_scpladisetADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();

		this.add(getId_scpladisetADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_dayslotADesc(tblDesc));
		this.add(getId_scplADesc(tblDesc));
		this.add(getD_bADesc(tblDesc));
		this.add(getD_eADesc(tblDesc));
		this.add(getVal_minADesc(tblDesc));
		this.add(getVal_maxADesc(tblDesc));
		this.add(getEu_valtpADesc(tblDesc));
		this.add(getNum_avg_tickADesc(tblDesc));
		this.add(getFg_plselfADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_scpladisetCDesc(tblDesc));
		tblDesc.add(getId_scpladisetCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_dayslotCDesc(tblDesc));
		tblDesc.add(getId_scplCDesc(tblDesc));
		tblDesc.add(getD_bCDesc(tblDesc));
		tblDesc.add(getD_eCDesc(tblDesc));
		tblDesc.add(getVal_minCDesc(tblDesc));
		tblDesc.add(getVal_maxCDesc(tblDesc));
		tblDesc.add(getEu_valtpCDesc(tblDesc));
		tblDesc.add(getNum_avg_tickCDesc(tblDesc));
		tblDesc.add(getFg_plselfCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 样本设置主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scpladisetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scpladiset",  getId_scpladisetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本设置主键");
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
	 * 午别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dayslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dayslot",  getId_dayslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("午别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班计划id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scpl",  getId_scplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班计划id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_b",  getD_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("开始日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_e",  getD_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("结束日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_min",  getVal_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最小值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_max",  getVal_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取值类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_valtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_valtp",  getEu_valtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("取值类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号位数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_avg_tickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_avg_tick",  getNum_avg_tickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("号位数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否本计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_plselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_plself",  getFg_plselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否本计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取样本设置主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scpladisetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scpladiset");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("样本设置主键"); 
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
	 * 获取午别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dayslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dayslot");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("午别id"); 
		return column;
	}
	/**
	 * 获取排班计划id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班计划id"); 
		return column;
	}
	/**
	 * 获取开始日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_b");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始日期"); 
		return column;
	}
	/**
	 * 获取结束日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_e");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束日期"); 
		return column;
	}
	/**
	 * 获取最小值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_min");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最小值"); 
		return column;
	}
	/**
	 * 获取最大值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_max");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大值"); 
		return column;
	}
	/**
	 * 获取取值类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_valtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_valtp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("取值类型"); 
		return column;
	}
	/**
	 * 获取号位数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_avg_tickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_avg_tick");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("号位数量"); 
		return column;
	}
	/**
	 * 获取是否本计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_plselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_plself");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否本计划"); 
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
