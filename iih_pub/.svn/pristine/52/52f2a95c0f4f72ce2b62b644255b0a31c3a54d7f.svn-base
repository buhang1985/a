
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
 * 日期信息 DO 元数据信息
 */
public class WorkCalendDateDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.bs.workcalendar.d.WorkCalendDateDO";
	public static final String CLASS_DISPALYNAME = "日期信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_workcalenddate";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_workcalenddate";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public WorkCalendDateDODesc(){
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
		this.setKeyDesc(getId_workcalenddateADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_workcalendarADesc(tblDesc));
		this.add(getId_workcalenddateADesc(tblDesc));
		this.add(getCalendardateADesc(tblDesc));
		this.add(getDateworktypeADesc(tblDesc));
		this.add(getOndutytimeADesc(tblDesc));
		this.add(getOffdutytimeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_workcalenddateCDesc(tblDesc));
		tblDesc.add(getId_workcalenddateCDesc(tblDesc));
		tblDesc.add(getCalendardateCDesc(tblDesc));
		tblDesc.add(getDateworktypeCDesc(tblDesc));
		tblDesc.add(getOndutytimeCDesc(tblDesc));
		tblDesc.add(getOffdutytimeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getDatafromtypeCDesc(tblDesc));
		tblDesc.add(getId_workcalendarCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 日期信息主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_workcalenddateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_workcalenddate",  getId_workcalenddateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期信息主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日历日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCalendardateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Calendardate",  getCalendardateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日历日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDateworktypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dateworktype",  getDateworktypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("日期类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上班时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOndutytimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ondutytime",  getOndutytimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("上班时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下班时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOffdutytimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Offdutytime",  getOffdutytimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("下班时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注说明");
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
	 * 获取日期信息主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_workcalenddateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_workcalenddate");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期信息主键标识"); 
		return column;
	}
	/**
	 * 获取日历日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCalendardateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Calendardate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日历日期"); 
		return column;
	}
	/**
	 * 获取日期类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDateworktypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dateworktype");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("日期类型"); 
		return column;
	}
	/**
	 * 获取上班时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOndutytimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ondutytime");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上班时间"); 
		return column;
	}
	/**
	 * 获取下班时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOffdutytimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Offdutytime");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("下班时间"); 
		return column;
	}
	/**
	 * 获取备注说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(1024);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注说明"); 
		return column;
	}
	/**
	 * 获取数据来源方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDatafromtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Datafromtype");
		column.setLength(50);
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
