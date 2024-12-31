
package iih.sc.apt.aptipbedday.d.desc;

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
 * 住院预约日间诊疗 DO 元数据信息
 */
public class AptIpBeddayDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.aptipbedday.d.AptIpBeddayDO";
	public static final String CLASS_DISPALYNAME = "住院预约日间诊疗";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_apt_ip_bedday";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptipbedday";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AptIpBeddayDODesc(){
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
		this.setKeyDesc(getId_aptipbeddayADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aptipbeddayADesc(tblDesc));
		this.add(getId_aptipADesc(tblDesc));
		this.add(getId_srv_optADesc(tblDesc));
		this.add(getName_srv_optADesc(tblDesc));
		this.add(getDt_optADesc(tblDesc));
		this.add(getDaysADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptipbeddayCDesc(tblDesc));
		tblDesc.add(getId_aptipbeddayCDesc(tblDesc));
		tblDesc.add(getId_aptipCDesc(tblDesc));
		tblDesc.add(getId_srv_optCDesc(tblDesc));
		tblDesc.add(getName_srv_optCDesc(tblDesc));
		tblDesc.add(getDt_optCDesc(tblDesc));
		tblDesc.add(getDaysCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 日间诊疗id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptipbeddayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptipbedday",  getId_aptipbeddayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日间诊疗id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院预约id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptip",  getId_aptipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院预约id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srv_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv_opt",  getId_srv_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srv_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv_opt",  getName_srv_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_opt",  getDt_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days",  getDaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("在院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取日间诊疗id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptipbeddayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptipbedday");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日间诊疗id"); 
		return column;
	}
	/**
	 * 获取住院预约id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院预约id"); 
		return column;
	}
	/**
	 * 获取手术id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srv_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv_opt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术id"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srv_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv_opt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取手术日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_opt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术日期"); 
		return column;
	}
	/**
	 * 获取在院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("在院天数"); 
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
