
package iih.bd.srv.srvpkggrpitm.d.desc;

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
 * 服务包项目服务对照 DO 元数据信息
 */
public class SrvPkgItmSrvContrastDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.srvpkggrpitm.d.SrvPkgItmSrvContrastDO";
	public static final String CLASS_DISPALYNAME = "服务包项目服务对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_pkg_itm_comp";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvpkgitmcomp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SrvPkgItmSrvContrastDODesc(){
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
		this.setKeyDesc(getId_srvpkgitmcompADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_srvpkgitmADesc(tblDesc));
		this.add(getId_srvpkgitmcompADesc(tblDesc));
		this.add(getId_srvpkgitmADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getId_unit_medADesc(tblDesc));
		this.add(getQuan_medADesc(tblDesc));
		this.add(getId_primodeADesc(tblDesc));
		this.add(getSd_primodeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_opentpADesc(tblDesc));
		this.add(getSd_opentpADesc(tblDesc));
		this.add(getDays_srvADesc(tblDesc));
		this.add(getQuan_minADesc(tblDesc));
		this.add(getQuan_maxADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvpkgitmcompCDesc(tblDesc));
		tblDesc.add(getId_srvpkgitmcompCDesc(tblDesc));
		tblDesc.add(getId_srvpkgitmCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getId_unit_medCDesc(tblDesc));
		tblDesc.add(getQuan_medCDesc(tblDesc));
		tblDesc.add(getId_primodeCDesc(tblDesc));
		tblDesc.add(getSd_primodeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_opentpCDesc(tblDesc));
		tblDesc.add(getSd_opentpCDesc(tblDesc));
		tblDesc.add(getDays_srvCDesc(tblDesc));
		tblDesc.add(getQuan_minCDesc(tblDesc));
		tblDesc.add(getQuan_maxCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 服务包项目对照主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvpkgitmcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvpkgitmcomp",  getId_srvpkgitmcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包项目对照主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务包项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvpkgitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvpkgitm",  getId_srvpkgitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvtp",  getId_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_med",  getId_unit_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医学单位数值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_med",  getQuan_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医学单位数值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_primodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_primode",  getId_primodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价格模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 价格模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_primodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_primode",  getSd_primodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价格模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务包说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务开立模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opentpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opentp",  getId_opentpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务开立模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务开立模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_opentpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_opentp",  getSd_opentpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务开立模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_srv",  getDays_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("服务天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_min",  getQuan_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最小数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_max",  getQuan_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取服务包项目对照主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvpkgitmcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvpkgitmcomp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务包项目对照主键标识"); 
		return column;
	}
	/**
	 * 获取服务包项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvpkgitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvpkgitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务包项目"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型"); 
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
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法"); 
		return column;
	}
	/**
	 * 获取频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_med");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医学单位"); 
		return column;
	}
	/**
	 * 获取医学单位数值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_med");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医学单位数值"); 
		return column;
	}
	/**
	 * 获取价格模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_primodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_primode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价格模式"); 
		return column;
	}
	/**
	 * 获取价格模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_primodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_primode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价格模式编码"); 
		return column;
	}
	/**
	 * 获取服务包说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务包说明"); 
		return column;
	}
	/**
	 * 获取服务开立模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opentpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opentp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务开立模式"); 
		return column;
	}
	/**
	 * 获取服务开立模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_opentpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_opentp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务开立模式编码"); 
		return column;
	}
	/**
	 * 获取服务天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_srv");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("服务天数"); 
		return column;
	}
	/**
	 * 获取最小数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_min");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最小数量"); 
		return column;
	}
	/**
	 * 获取最大数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_max");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大数量"); 
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
