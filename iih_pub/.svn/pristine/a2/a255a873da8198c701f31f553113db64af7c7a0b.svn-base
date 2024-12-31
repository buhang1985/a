
package iih.mp.dg.oepboilmed.d.desc;

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
 * 中草药煎药明细 DO 元数据信息
 */
public class OepBoilMedDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.oepboilmed.d.OepBoilMedDO";
	public static final String CLASS_DISPALYNAME = "中草药煎药明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_oep_boilmed";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgoepboilmed";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OepBoilMedDODesc(){
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
		this.setKeyDesc(getId_dgoepboilmedADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_dgoepboilmedADesc(tblDesc));
		this.add(getId_dgoepdtADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_org_mpADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getDt_blADesc(tblDesc));
		this.add(getDt_inseADesc(tblDesc));
		this.add(getId_emp_inseADesc(tblDesc));
		this.add(getId_emp_dpADesc(tblDesc));
		this.add(getId_quesite_plADesc(tblDesc));
		this.add(getFg_prinADesc(tblDesc));
		this.add(getDt_prinADesc(tblDesc));
		this.add(getId_emp_prinADesc(tblDesc));
		this.add(getFg_jy_finADesc(tblDesc));
		this.add(getDt_finADesc(tblDesc));
		this.add(getId_emp_finADesc(tblDesc));
		this.add(getFg_sendADesc(tblDesc));
		this.add(getDt_sendADesc(tblDesc));
		this.add(getId_emp_sendADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgoepboilmedCDesc(tblDesc));
		tblDesc.add(getId_dgoepboilmedCDesc(tblDesc));
		tblDesc.add(getId_dgoepdtCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_org_mpCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getDt_blCDesc(tblDesc));
		tblDesc.add(getDt_inseCDesc(tblDesc));
		tblDesc.add(getId_emp_inseCDesc(tblDesc));
		tblDesc.add(getId_emp_dpCDesc(tblDesc));
		tblDesc.add(getId_quesite_plCDesc(tblDesc));
		tblDesc.add(getFg_prinCDesc(tblDesc));
		tblDesc.add(getDt_prinCDesc(tblDesc));
		tblDesc.add(getId_emp_prinCDesc(tblDesc));
		tblDesc.add(getFg_jy_finCDesc(tblDesc));
		tblDesc.add(getDt_finCDesc(tblDesc));
		tblDesc.add(getId_emp_finCDesc(tblDesc));
		tblDesc.add(getFg_sendCDesc(tblDesc));
		tblDesc.add(getDt_sendCDesc(tblDesc));
		tblDesc.add(getId_emp_sendCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 煎药明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgoepboilmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgoepboilmed",  getId_dgoepboilmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎药明细主键");
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
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_mp",  getId_org_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目发生日期（记账日期）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_bl",  getDt_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("服务项目发生日期（记账日期）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据生成日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_inseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_inse",  getDt_inseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("数据生成日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据生成操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_inseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_inse",  getId_emp_inseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据生成操作员");
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 煎药证打印标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prin",  getFg_prinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("煎药证打印标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药证打印日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_prinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_prin",  getDt_prinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("煎药证打印日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药证打印操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_prinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_prin",  getId_emp_prinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎药证打印操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 煎药完成标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_jy_finADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_jy_fin",  getFg_jy_finCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("煎药完成标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药完成日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_finADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_fin",  getDt_finCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("煎药完成日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药完成操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_finADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_fin",  getId_emp_finCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎药完成操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 煎药发放标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_send",  getFg_sendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("煎药发放标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药发放日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_sendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_send",  getDt_sendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("煎药发放日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎药发放操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_sendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_send",  getId_emp_sendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎药发放操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 获取煎药明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgoepboilmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgoepboilmed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎药明细主键"); 
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
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取执行机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行机构"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取服务项目发生日期（记账日期）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_bl");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务项目发生日期（记账日期）"); 
		return column;
	}
	/**
	 * 获取数据生成日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_inseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_inse");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("数据生成日期"); 
		return column;
	}
	/**
	 * 获取数据生成操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_inseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_inse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据生成操作员"); 
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
	 * 获取计划发药窗口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_quesite_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_quesite_pl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划发药窗口"); 
		return column;
	}
	/**
	 * 获取煎药证打印标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药证打印标志"); 
		return column;
	}
	/**
	 * 获取煎药证打印日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_prinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_prin");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药证打印日期"); 
		return column;
	}
	/**
	 * 获取煎药证打印操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_prinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_prin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎药证打印操作员"); 
		return column;
	}
	/**
	 * 获取煎药完成标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_jy_finCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_jy_fin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药完成标志"); 
		return column;
	}
	/**
	 * 获取煎药完成日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_finCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_fin");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药完成日期"); 
		return column;
	}
	/**
	 * 获取煎药完成操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_finCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_fin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎药完成操作员"); 
		return column;
	}
	/**
	 * 获取煎药发放标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_send");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药发放标志"); 
		return column;
	}
	/**
	 * 获取煎药发放日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_sendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_send");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("煎药发放日期"); 
		return column;
	}
	/**
	 * 获取煎药发放操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_sendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_send");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎药发放操作员"); 
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
		iBDDataInfoFldMap.put("id","Id_dgoepboilmed");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
