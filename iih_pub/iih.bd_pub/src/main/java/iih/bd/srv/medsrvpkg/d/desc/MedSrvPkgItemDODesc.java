
package iih.bd.srv.medsrvpkg.d.desc;

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
 * 医疗服务包项目 DO 元数据信息
 */
public class MedSrvPkgItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medsrvpkg.d.MedSrvPkgItemDO";
	public static final String CLASS_DISPALYNAME = "医疗服务包项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_pkg_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvpkgitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MedSrvPkgItemDODesc(){
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
		this.setKeyDesc(getId_srvpkgitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_srvADesc(tblDesc));
		this.add(getId_srvpkgitmADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_srv_inpkgADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getId_boildesADesc(tblDesc));
		this.add(getId_medADesc(tblDesc));
		this.add(getQuan_medADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getSrv_codeADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getInpk_codeADesc(tblDesc));
		this.add(getInpk_nameADesc(tblDesc));
		this.add(getFreq_codeADesc(tblDesc));
		this.add(getFreq_nameADesc(tblDesc));
		this.add(getRoute_codeADesc(tblDesc));
		this.add(getRoute_nameADesc(tblDesc));
		this.add(getRoutedes_codeADesc(tblDesc));
		this.add(getRoutedes_nameADesc(tblDesc));
		this.add(getBoil_codeADesc(tblDesc));
		this.add(getBoil_nameADesc(tblDesc));
		this.add(getBoildes_codeADesc(tblDesc));
		this.add(getBoildes_nameADesc(tblDesc));
		this.add(getMed_codeADesc(tblDesc));
		this.add(getMed_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvpkgitmCDesc(tblDesc));
		tblDesc.add(getId_srvpkgitmCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_srv_inpkgCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getId_boildesCDesc(tblDesc));
		tblDesc.add(getId_medCDesc(tblDesc));
		tblDesc.add(getQuan_medCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 服务包项目主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvpkgitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvpkgitm",  getId_srvpkgitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包项目主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务包对应服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务包对应服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包内服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srv_inpkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv_inpkg",  getId_srv_inpkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包内服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 频次_默认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次_默认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用法_默认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法_默认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用法要求_默认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求_默认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 煎法_默认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boil",  getId_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法_默认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 煎法要求_默认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boildesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boildes",  getId_boildesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求_默认");
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
	private IAttrDesc getId_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_med",  getId_medCDesc(tblDesc), this);
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
	 * 服务价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("服务价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_code",  getSrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b1","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b1","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInpk_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inpk_code",  getInpk_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_srv_inpkg=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInpk_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inpk_name",  getInpk_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_srv_inpkg=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_code",  getFreq_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a1b3","id_freq=id_freq","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreq_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq_name",  getFreq_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a1b3","id_freq=id_freq","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_code",  getRoute_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a1b4","id_route=id_route","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_name",  getRoute_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a1b4","id_route=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoutedes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Routedes_code",  getRoutedes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a1b5","id_routedes=id_routedes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoutedes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Routedes_name",  getRoutedes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a1b5","id_routedes=id_routedes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_code",  getBoil_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a1b6","id_boil=id_boil","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoil_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boil_name",  getBoil_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a1b6","id_boil=id_boil","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_code",  getBoildes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a1b7","id_boildes=id_boildes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoildes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boildes_name",  getBoildes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a1b7","id_boildes=id_boildes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMed_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Med_code",  getMed_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b8","id_med=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMed_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Med_name",  getMed_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b8","id_med=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取服务包项目主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvpkgitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvpkgitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务包项目主键标识"); 
		return column;
	}
	/**
	 * 获取服务包对应服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务包对应服务"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取包内服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srv_inpkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv_inpkg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包内服务"); 
		return column;
	}
	/**
	 * 获取频次_默认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次_默认"); 
		return column;
	}
	/**
	 * 获取用法_默认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法_默认"); 
		return column;
	}
	/**
	 * 获取用法要求_默认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法要求_默认"); 
		return column;
	}
	/**
	 * 获取煎法_默认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boil");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法_默认"); 
		return column;
	}
	/**
	 * 获取煎法要求_默认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boildesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boildes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求_默认"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_med");
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
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医学单位数值"); 
		return column;
	}
	/**
	 * 获取服务价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("服务价格"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInpk_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inpk_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInpk_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inpk_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取频次编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次编码"); 
		return column;
	}
	/**
	 * 获取频次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreq_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次名称"); 
		return column;
	}
	/**
	 * 获取用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法编码"); 
		return column;
	}
	/**
	 * 获取用法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法名称"); 
		return column;
	}
	/**
	 * 获取用法要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoutedes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Routedes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法要求编码"); 
		return column;
	}
	/**
	 * 获取用法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoutedes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Routedes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法要求"); 
		return column;
	}
	/**
	 * 获取煎法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法编码"); 
		return column;
	}
	/**
	 * 获取煎法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoil_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boil_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法名称"); 
		return column;
	}
	/**
	 * 获取煎法要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求编码"); 
		return column;
	}
	/**
	 * 获取煎法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoildes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boildes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求"); 
		return column;
	}
	/**
	 * 获取计量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMed_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Med_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位编码"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMed_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Med_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
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
