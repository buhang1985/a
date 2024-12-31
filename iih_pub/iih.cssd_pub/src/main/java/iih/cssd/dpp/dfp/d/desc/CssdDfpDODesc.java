
package iih.cssd.dpp.dfp.d.desc;

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
 * 消毒包生产 DO 元数据信息
 */
public class CssdDfpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.cssd.dpp.dfp.d.CssdDfpDO";
	public static final String CLASS_DISPALYNAME = "消毒包生产";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CSSD_DFP";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dfp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CssdDfpDODesc(){
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
		this.setKeyDesc(getId_dfpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_dfpADesc(tblDesc));
		this.add(getId_pkgADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_pkg_caADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getNo_barADesc(tblDesc));
		this.add(getId_pkgtpADesc(tblDesc));
		this.add(getSd_pkgtpADesc(tblDesc));
		this.add(getId_pkgcleanADesc(tblDesc));
		this.add(getSd_pkgcleanADesc(tblDesc));
		this.add(getId_pkgstzADesc(tblDesc));
		this.add(getSd_pkgstzADesc(tblDesc));
		this.add(getId_pkgmtrADesc(tblDesc));
		this.add(getSd_pkgmtrADesc(tblDesc));
		this.add(getSpecADesc(tblDesc));
		this.add(getId_statusADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getDt_effeADesc(tblDesc));
		this.add(getDt_invalADesc(tblDesc));
		this.add(getDays_effecADesc(tblDesc));
		this.add(getId_dep_prdADesc(tblDesc));
		this.add(getId_emp_prdADesc(tblDesc));
		this.add(getDt_prdADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getFg_srlzADesc(tblDesc));
		this.add(getId_dep_srlzADesc(tblDesc));
		this.add(getId_emp_srlzADesc(tblDesc));
		this.add(getDt_srlzADesc(tblDesc));
		this.add(getFg_rcvADesc(tblDesc));
		this.add(getId_dep_rcvADesc(tblDesc));
		this.add(getId_emp_rcvADesc(tblDesc));
		this.add(getDt_rcvADesc(tblDesc));
		this.add(getFg_useADesc(tblDesc));
		this.add(getId_dep_useADesc(tblDesc));
		this.add(getId_emp_useADesc(tblDesc));
		this.add(getDt_useADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getFg_clnADesc(tblDesc));
		this.add(getId_dep_clnADesc(tblDesc));
		this.add(getId_emp_clnADesc(tblDesc));
		this.add(getDt_clnADesc(tblDesc));
		this.add(getFg_storeADesc(tblDesc));
		this.add(getId_instrADesc(tblDesc));
		this.add(getFg_appADesc(tblDesc));
		this.add(getId_dep_appADesc(tblDesc));
		this.add(getEu_weightADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getPkg_nameADesc(tblDesc));
		this.add(getName_pkg_caADesc(tblDesc));
		this.add(getName_pkgtpADesc(tblDesc));
		this.add(getName_pkgcleanADesc(tblDesc));
		this.add(getName_pkgstzADesc(tblDesc));
		this.add(getName_pkgmtrADesc(tblDesc));
		this.add(getName_statusADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_emp_prdADesc(tblDesc));
		this.add(getName_dep_srlzADesc(tblDesc));
		this.add(getName_emp_srlzADesc(tblDesc));
		this.add(getName_dep_rcvADesc(tblDesc));
		this.add(getName_emp_rcvADesc(tblDesc));
		this.add(getName_dep_useADesc(tblDesc));
		this.add(getName_emp_useADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_patADesc(tblDesc));
		this.add(getName_dep_clnADesc(tblDesc));
		this.add(getName_emp_clnADesc(tblDesc));
		this.add(getName_instrADesc(tblDesc));
		this.add(getCode_instrADesc(tblDesc));
		this.add(getId_dep_instrADesc(tblDesc));
		this.add(getName_dep_appADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dfpCDesc(tblDesc));
		tblDesc.add(getId_dfpCDesc(tblDesc));
		tblDesc.add(getId_pkgCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_pkg_caCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getNo_barCDesc(tblDesc));
		tblDesc.add(getId_pkgtpCDesc(tblDesc));
		tblDesc.add(getSd_pkgtpCDesc(tblDesc));
		tblDesc.add(getId_pkgcleanCDesc(tblDesc));
		tblDesc.add(getSd_pkgcleanCDesc(tblDesc));
		tblDesc.add(getId_pkgstzCDesc(tblDesc));
		tblDesc.add(getSd_pkgstzCDesc(tblDesc));
		tblDesc.add(getId_pkgmtrCDesc(tblDesc));
		tblDesc.add(getSd_pkgmtrCDesc(tblDesc));
		tblDesc.add(getSpecCDesc(tblDesc));
		tblDesc.add(getId_statusCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getDt_effeCDesc(tblDesc));
		tblDesc.add(getDt_invalCDesc(tblDesc));
		tblDesc.add(getDays_effecCDesc(tblDesc));
		tblDesc.add(getId_dep_prdCDesc(tblDesc));
		tblDesc.add(getId_emp_prdCDesc(tblDesc));
		tblDesc.add(getDt_prdCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getFg_srlzCDesc(tblDesc));
		tblDesc.add(getId_dep_srlzCDesc(tblDesc));
		tblDesc.add(getId_emp_srlzCDesc(tblDesc));
		tblDesc.add(getDt_srlzCDesc(tblDesc));
		tblDesc.add(getFg_rcvCDesc(tblDesc));
		tblDesc.add(getId_dep_rcvCDesc(tblDesc));
		tblDesc.add(getId_emp_rcvCDesc(tblDesc));
		tblDesc.add(getDt_rcvCDesc(tblDesc));
		tblDesc.add(getFg_useCDesc(tblDesc));
		tblDesc.add(getId_dep_useCDesc(tblDesc));
		tblDesc.add(getId_emp_useCDesc(tblDesc));
		tblDesc.add(getDt_useCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getFg_clnCDesc(tblDesc));
		tblDesc.add(getId_dep_clnCDesc(tblDesc));
		tblDesc.add(getId_emp_clnCDesc(tblDesc));
		tblDesc.add(getDt_clnCDesc(tblDesc));
		tblDesc.add(getFg_storeCDesc(tblDesc));
		tblDesc.add(getId_instrCDesc(tblDesc));
		tblDesc.add(getFg_appCDesc(tblDesc));
		tblDesc.add(getId_dep_appCDesc(tblDesc));
		tblDesc.add(getEu_weightCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 消毒包主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dfpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dfp",  getId_dfpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消毒包主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkg",  getId_pkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
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
	 * 消毒包分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkg_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkg_ca",  getId_pkg_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消毒包分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 识别码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_barADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_bar",  getNo_barCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("识别码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgtp",  getId_pkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包类型sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pkgtp",  getSd_pkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包类型sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgcleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgclean",  getId_pkgcleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗类型sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pkgcleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pkgclean",  getSd_pkgcleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗类型sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 灭菌方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgstzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgstz",  getId_pkgstzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("灭菌方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 灭菌方式sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pkgstzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pkgstz",  getSd_pkgstzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("灭菌方式sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装材料id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgmtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgmtr",  getId_pkgmtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装材料id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装材料sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pkgmtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pkgmtr",  getSd_pkgmtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装材料sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spec",  getSpecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 消毒包状态id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_status",  getId_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消毒包状态id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 消毒包状态sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消毒包状态sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生效时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_effeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_effe",  getDt_effeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("生效时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失效时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_invalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_inval",  getDt_invalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("失效时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_effecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_effec",  getDays_effecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("有效天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_prdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_prd",  getId_dep_prdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生产人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_prdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_prd",  getId_emp_prdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生产时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_prdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_prd",  getDt_prdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("生产时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 灭菌标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_srlzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_srlz",  getFg_srlzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("灭菌标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 灭菌科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_srlzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_srlz",  getId_dep_srlzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("灭菌科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 灭菌人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_srlzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_srlz",  getId_emp_srlzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("灭菌人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 灭菌时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_srlzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_srlz",  getDt_srlzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("灭菌时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室接收标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_rcv",  getFg_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("科室接收标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_rcv",  getId_dep_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接收人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_rcv",  getId_emp_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接收时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rcv",  getDt_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("接收时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use",  getFg_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("使用标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_use",  getId_dep_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 使用人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_use",  getId_emp_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 使用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_use",  getDt_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("使用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cln",  getFg_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("清洗标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_cln",  getId_dep_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_cln",  getId_emp_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cln",  getDt_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("清洗时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 储藏标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_storeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_store",  getFg_storeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("储藏标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 储藏位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_instr",  getId_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("储藏位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_app",  getFg_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("请领标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_app",  getId_dep_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包重量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_weight",  getEu_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("包重量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnecode",  getMnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkg_name",  getPkg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CSSD_PKG a0b2","id_pkg=id_pkg","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pkg_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pkg_ca",  getName_pkg_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"cssd_pkg_ca a0b3","id_pkg_ca=id_pkg_ca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 消毒包类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pkgtp",  getName_pkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消毒包类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_pkgtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pkgcleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pkgclean",  getName_pkgcleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_pkgclean=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pkgstzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pkgstz",  getName_pkgstzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_pkgstz=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pkgmtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pkgmtr",  getName_pkgmtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_pkgmtr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_status",  getName_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_prd=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_prdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_prd",  getName_emp_prdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","id_emp_prd=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 灭菌科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_srlzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_srlz",  getName_dep_srlzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("灭菌科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b17","id_dep_srlz=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 灭菌人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_srlzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_srlz",  getName_emp_srlzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("灭菌人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b18","id_emp_srlz=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_rcv",  getName_dep_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b19","id_dep_rcv=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_rcv",  getName_emp_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_emp_rcv=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_use",  getName_dep_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b21","id_dep_use=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_use",  getName_emp_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_emp_use=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b23","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat",  getCode_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b23","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_cln",  getName_dep_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b24","id_dep_cln=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_cln",  getName_emp_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b25","id_emp_cln=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 器械名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_instr",  getName_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("器械名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CSSD_INSTR a0b26","id_instr=id_instr","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 器械编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_instr",  getCode_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("器械编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CSSD_INSTR a0b26","id_instr=id_instr","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 器械所属部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_instr",  getId_dep_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("器械所属部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CSSD_INSTR a0b26","id_instr=id_instr","id_dep"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_app",  getName_dep_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b27","id_dep_app=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取消毒包主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dfpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dfp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("消毒包主键"); 
		return column;
	}
	/**
	 * 获取包主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包主键"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
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
	 * 获取消毒包分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkg_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkg_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消毒包分类"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取识别码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_barCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_bar");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("识别码"); 
		return column;
	}
	/**
	 * 获取包类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包类型id"); 
		return column;
	}
	/**
	 * 获取包类型sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pkgtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包类型sd"); 
		return column;
	}
	/**
	 * 获取清洗类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgcleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgclean");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗类型id"); 
		return column;
	}
	/**
	 * 获取清洗类型sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pkgcleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pkgclean");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗类型sd"); 
		return column;
	}
	/**
	 * 获取灭菌方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgstzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgstz");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("灭菌方式id"); 
		return column;
	}
	/**
	 * 获取灭菌方式sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pkgstzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pkgstz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("灭菌方式sd"); 
		return column;
	}
	/**
	 * 获取包装材料id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgmtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgmtr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装材料id"); 
		return column;
	}
	/**
	 * 获取包装材料sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pkgmtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pkgmtr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装材料sd"); 
		return column;
	}
	/**
	 * 获取包规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包规格"); 
		return column;
	}
	/**
	 * 获取消毒包状态id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消毒包状态id"); 
		return column;
	}
	/**
	 * 获取消毒包状态sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消毒包状态sd"); 
		return column;
	}
	/**
	 * 获取生效时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_effeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_effe");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生效时间"); 
		return column;
	}
	/**
	 * 获取失效时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_invalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_inval");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("失效时间"); 
		return column;
	}
	/**
	 * 获取有效天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_effecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_effec");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("有效天数"); 
		return column;
	}
	/**
	 * 获取生产科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_prdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_prd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产科室"); 
		return column;
	}
	/**
	 * 获取生产人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_prdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_prd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产人"); 
		return column;
	}
	/**
	 * 获取生产时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_prdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_prd");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生产时间"); 
		return column;
	}
	/**
	 * 获取包描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包描述"); 
		return column;
	}
	/**
	 * 获取价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格"); 
		return column;
	}
	/**
	 * 获取灭菌标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_srlzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_srlz");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("灭菌标记"); 
		return column;
	}
	/**
	 * 获取灭菌科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_srlzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_srlz");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("灭菌科室"); 
		return column;
	}
	/**
	 * 获取灭菌人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_srlzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_srlz");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("灭菌人"); 
		return column;
	}
	/**
	 * 获取灭菌时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_srlzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_srlz");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("灭菌时间"); 
		return column;
	}
	/**
	 * 获取科室接收标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_rcv");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("科室接收标记"); 
		return column;
	}
	/**
	 * 获取接收科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_rcv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收科室"); 
		return column;
	}
	/**
	 * 获取接收人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_rcv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收人"); 
		return column;
	}
	/**
	 * 获取接收时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rcv");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("接收时间"); 
		return column;
	}
	/**
	 * 获取使用标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("使用标记"); 
		return column;
	}
	/**
	 * 获取使用科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_use");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用科室"); 
		return column;
	}
	/**
	 * 获取使用人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_use");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用人"); 
		return column;
	}
	/**
	 * 获取使用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_use");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("使用时间"); 
		return column;
	}
	/**
	 * 获取使用患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用患者"); 
		return column;
	}
	/**
	 * 获取清洗标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cln");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清洗标识"); 
		return column;
	}
	/**
	 * 获取清洗科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_cln");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗科室"); 
		return column;
	}
	/**
	 * 获取清洗人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_cln");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗人"); 
		return column;
	}
	/**
	 * 获取清洗时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cln");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清洗时间"); 
		return column;
	}
	/**
	 * 获取储藏标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_storeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_store");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("储藏标记"); 
		return column;
	}
	/**
	 * 获取储藏位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_instr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("储藏位置"); 
		return column;
	}
	/**
	 * 获取请领标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_app");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请领标记"); 
		return column;
	}
	/**
	 * 获取请领科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领科室"); 
		return column;
	}
	/**
	 * 获取包重量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_weight");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("包重量"); 
		return column;
	}
	/**
	 * 获取五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pkg_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pkg_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取消毒包类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pkgtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消毒包类型"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pkgcleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pkgclean");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pkgstzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pkgstz");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pkgmtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pkgmtr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_prdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_prd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取灭菌科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_srlzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_srlz");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("灭菌科室名称"); 
		return column;
	}
	/**
	 * 获取灭菌人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_srlzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_srlz");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("灭菌人姓名"); 
		return column;
	}
	/**
	 * 获取接收科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_rcv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收科室名称"); 
		return column;
	}
	/**
	 * 获取接收人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_rcv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收人姓名"); 
		return column;
	}
	/**
	 * 获取使用科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_use");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用科室名称"); 
		return column;
	}
	/**
	 * 获取使用人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_use");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用人姓名"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取清洗科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_cln");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗科室名称"); 
		return column;
	}
	/**
	 * 获取清洗人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_cln");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗人姓名"); 
		return column;
	}
	/**
	 * 获取器械名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_instr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("器械名称"); 
		return column;
	}
	/**
	 * 获取器械编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_instr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("器械编码"); 
		return column;
	}
	/**
	 * 获取器械所属部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_instr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("器械所属部门"); 
		return column;
	}
	/**
	 * 获取请领科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_app");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领科室名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Mnecode");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
