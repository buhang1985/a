
package iih.bd.bs.workcalendar.d.desc;

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
 * 年度信息 DO 元数据信息
 */
public class WorkCalendYearDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.bs.workcalendar.d.WorkCalendYearDO";
	public static final String CLASS_DISPALYNAME = "年度信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_workcalendyear";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_workcalendyear";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public WorkCalendYearDODesc(){
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
		this.setKeyDesc(getId_workcalendyearADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_workcalendarADesc(tblDesc));
		this.add(getId_workcalendyearADesc(tblDesc));
		this.add(getWorkyearADesc(tblDesc));
		this.add(getWorkyearstartdateADesc(tblDesc));
		this.add(getWorkamountADesc(tblDesc));
		this.add(getShowyearADesc(tblDesc));
		this.add(getDatafromtypeADesc(tblDesc));
		this.add(getId_workcalendarADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_workcalendyearCDesc(tblDesc));
		tblDesc.add(getId_workcalendyearCDesc(tblDesc));
		tblDesc.add(getWorkyearCDesc(tblDesc));
		tblDesc.add(getWorkyearstartdateCDesc(tblDesc));
		tblDesc.add(getWorkamountCDesc(tblDesc));
		tblDesc.add(getShowyearCDesc(tblDesc));
		tblDesc.add(getDatafromtypeCDesc(tblDesc));
		tblDesc.add(getId_workcalendarCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 年度信息主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_workcalendyearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_workcalendyear",  getId_workcalendyearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年度信息主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作年度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkyearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workyear",  getWorkyearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("工作年度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年度起始日属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkyearstartdateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workyearstartdate",  getWorkyearstartdateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("年度起始日");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkamountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workamount",  getWorkamountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 显示年度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getShowyearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Showyear",  getShowyearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("显示年度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDatafromtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Datafromtype",  getDatafromtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数据来源方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作日历属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_workcalendarADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_workcalendar",  getId_workcalendarCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作日历");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取年度信息主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_workcalendyearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_workcalendyear");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("年度信息主键标识"); 
		return column;
	}
	/**
	 * 获取工作年度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkyearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workyear");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("工作年度"); 
		return column;
	}
	/**
	 * 获取年度起始日表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkyearstartdateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workyearstartdate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("年度起始日"); 
		return column;
	}
	/**
	 * 获取周数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkamountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workamount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周数"); 
		return column;
	}
	/**
	 * 获取显示年度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getShowyearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Showyear");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("显示年度"); 
		return column;
	}
	/**
	 * 获取数据来源方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDatafromtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Datafromtype");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数据来源方式"); 
		return column;
	}
	/**
	 * 获取工作日历表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_workcalendarCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_workcalendar");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作日历"); 
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
