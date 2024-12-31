
package iih.mp.dg.oepmanu.d.desc;

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
 * 手工预摆药实体 DO 元数据信息
 */
public class OepManuPrepDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.oepmanu.d.OepManuPrepDO";
	public static final String CLASS_DISPALYNAME = "手工预摆药实体";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_oep_manu_prep";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgoepmanuprep";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OepManuPrepDODesc(){
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
		this.setKeyDesc(getId_dgoepmanuprepADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_dgoepmanuprepADesc(tblDesc));
		this.add(getId_dgoepdtADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getDt_inseADesc(tblDesc));
		this.add(getId_emp_inseADesc(tblDesc));
		this.add(getId_quesite_plADesc(tblDesc));
		this.add(getFg_prinADesc(tblDesc));
		this.add(getDt_prinADesc(tblDesc));
		this.add(getFg_byADesc(tblDesc));
		this.add(getDt_finADesc(tblDesc));
		this.add(getId_emp_finADesc(tblDesc));
		this.add(getId_emp_prinADesc(tblDesc));
		this.add(getId_emp_dpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgoepmanuprepCDesc(tblDesc));
		tblDesc.add(getId_dgoepmanuprepCDesc(tblDesc));
		tblDesc.add(getId_dgoepdtCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getDt_inseCDesc(tblDesc));
		tblDesc.add(getId_emp_inseCDesc(tblDesc));
		tblDesc.add(getId_quesite_plCDesc(tblDesc));
		tblDesc.add(getFg_prinCDesc(tblDesc));
		tblDesc.add(getDt_prinCDesc(tblDesc));
		tblDesc.add(getFg_byCDesc(tblDesc));
		tblDesc.add(getDt_finCDesc(tblDesc));
		tblDesc.add(getId_emp_finCDesc(tblDesc));
		tblDesc.add(getId_emp_prinCDesc(tblDesc));
		tblDesc.add(getId_emp_dpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手工预摆药主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgoepmanuprepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgoepmanuprep",  getId_dgoepmanuprepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手工预摆药主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgoepdtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgoepdt",  getId_dgoepdtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领明细主键");
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
	 * 数据产生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_inseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_inse",  getDt_inseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("数据产生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据产生操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_inseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_inse",  getId_emp_inseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据产生操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划发药窗口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_quesite_plADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_quesite_pl",  getId_quesite_plCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划发药窗口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prin",  getFg_prinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_prinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_prin",  getDt_prinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("打印日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摆药标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_byADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_by",  getFg_byCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("摆药标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摆药完成日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_finADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_fin",  getDt_finCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("摆药完成日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摆药完成操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_finADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_fin",  getId_emp_finCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摆药完成操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 打印操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_prinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_prin",  getId_emp_prinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("打印操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发药人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_dpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_dp",  getId_emp_dpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发药人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取手工预摆药主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgoepmanuprepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgoepmanuprep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手工预摆药主键"); 
		return column;
	}
	/**
	 * 获取请领明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgoepdtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgoepdt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领明细主键"); 
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
	 * 获取数据产生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_inseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_inse");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("数据产生日期"); 
		return column;
	}
	/**
	 * 获取数据产生操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_inseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_inse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据产生操作员"); 
		return column;
	}
	/**
	 * 获取计划发药窗口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_quesite_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_quesite_pl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划发药窗口"); 
		return column;
	}
	/**
	 * 获取打印标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印标志"); 
		return column;
	}
	/**
	 * 获取打印日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_prinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_prin");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印日期"); 
		return column;
	}
	/**
	 * 获取摆药标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_byCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_by");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("摆药标志"); 
		return column;
	}
	/**
	 * 获取摆药完成日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_finCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_fin");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("摆药完成日期"); 
		return column;
	}
	/**
	 * 获取摆药完成操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_finCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_fin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摆药完成操作员"); 
		return column;
	}
	/**
	 * 获取打印操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_prinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_prin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("打印操作员"); 
		return column;
	}
	/**
	 * 获取发药人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_dpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_dp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发药人"); 
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
