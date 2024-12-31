
package iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc;

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
 * 患者服务包服务项目对照 DO 元数据信息
 */
public class PiPatSrvPkgItemCompDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItemCompDO";
	public static final String CLASS_DISPALYNAME = "患者服务包服务项目对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_srv_pkg_itm_comp";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id_patsrvpkgsrv";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatSrvPkgItemCompDODesc(){
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
		this.setKeyDesc(getId_patsrvpkgsrvADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_patsrvpkgitmADesc(tblDesc));
		this.add(getId_patsrvpkgsrvADesc(tblDesc));
		this.add(getId_patsrvpkgitmADesc(tblDesc));
		this.add(getId_srvpkgitmcompADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_usageADesc(tblDesc));
		this.add(getId_fregADesc(tblDesc));
		this.add(getQuan_medADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getId_opentpADesc(tblDesc));
		this.add(getSd_opentpADesc(tblDesc));
		this.add(getDays_srvADesc(tblDesc));
		this.add(getQuan_minADesc(tblDesc));
		this.add(getQuan_maxADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patsrvpkgsrvCDesc(tblDesc));
		tblDesc.add(getId_patsrvpkgsrvCDesc(tblDesc));
		tblDesc.add(getId_patsrvpkgitmCDesc(tblDesc));
		tblDesc.add(getId_srvpkgitmcompCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_usageCDesc(tblDesc));
		tblDesc.add(getId_fregCDesc(tblDesc));
		tblDesc.add(getQuan_medCDesc(tblDesc));
		tblDesc.add(getId_unitCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getId_opentpCDesc(tblDesc));
		tblDesc.add(getSd_opentpCDesc(tblDesc));
		tblDesc.add(getDays_srvCDesc(tblDesc));
		tblDesc.add(getQuan_minCDesc(tblDesc));
		tblDesc.add(getQuan_maxCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者服务包服务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patsrvpkgsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patsrvpkgsrv",  getId_patsrvpkgsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者服务包服务ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者服务包项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patsrvpkgitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patsrvpkgitm",  getId_patsrvpkgitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者服务包项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务包项目对照属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvpkgitmcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvpkgitmcomp",  getId_srvpkgitmcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包项目对照");
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
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usage",  getId_usageCDesc(tblDesc), this);
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
	private IAttrDesc getId_fregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freg",  getId_fregCDesc(tblDesc), this);
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
	 * 医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
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
	 * 服务包中说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包中说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opentpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opentp",  getId_opentpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_opentpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_opentp",  getSd_opentpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立模式编码");
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
	 * 获取患者服务包服务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patsrvpkgsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patsrvpkgsrv");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者服务包服务ID"); 
		return column;
	}
	/**
	 * 获取患者服务包项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patsrvpkgitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patsrvpkgitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者服务包项目"); 
		return column;
	}
	/**
	 * 获取服务包项目对照表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvpkgitmcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvpkgitmcomp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务包项目对照"); 
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
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usage");
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
	private IColumnDesc getId_fregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次"); 
		return column;
	}
	/**
	 * 获取医学单位数值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_med");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医学单位数值"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医学单位"); 
		return column;
	}
	/**
	 * 获取服务包中说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务包中说明"); 
		return column;
	}
	/**
	 * 获取开立模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opentpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opentp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立模式"); 
		return column;
	}
	/**
	 * 获取开立模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_opentpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_opentp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立模式编码"); 
		return column;
	}
	/**
	 * 获取服务天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_srv");
		column.setLength(10);
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
		column.setLength(10);
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
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大数量"); 
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
