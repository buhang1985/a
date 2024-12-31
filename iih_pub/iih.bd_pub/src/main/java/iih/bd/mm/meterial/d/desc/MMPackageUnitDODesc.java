
package iih.bd.mm.meterial.d.desc;

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
 * 医疗物品_包装单位集 DO 元数据信息
 */
public class MMPackageUnitDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mm.meterial.d.MMPackageUnitDO";
	public static final String CLASS_DISPALYNAME = "医疗物品_包装单位集";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_MM_PKGU";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mmpkgu";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MMPackageUnitDODesc(){
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
		this.setKeyDesc(getId_mmpkguADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mmADesc(tblDesc));
		this.add(getId_mmpkguADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_mmpkgutpADesc(tblDesc));
		this.add(getId_unit_pkgADesc(tblDesc));
		this.add(getFactorADesc(tblDesc));
		this.add(getSd_mmpkguproADesc(tblDesc));
		this.add(getId_mmpkguproADesc(tblDesc));
		this.add(getMmpkgunameADesc(tblDesc));
		this.add(getEn_pippkgtpADesc(tblDesc));
		this.add(getEn_ippkgtpADesc(tblDesc));
		this.add(getEn_oppkgtpADesc(tblDesc));
		this.add(getEn_erpkgtpADesc(tblDesc));
		this.add(getEn_er1pkgtpADesc(tblDesc));
		this.add(getEn_er2pkgtpADesc(tblDesc));
		this.add(getEn_pepkgtpADesc(tblDesc));
		this.add(getEn_fmpkgtpADesc(tblDesc));
		this.add(getM_nameADesc(tblDesc));
		this.add(getMmpkgutp_nameADesc(tblDesc));
		this.add(getEn_ippkgtp_refADesc(tblDesc));
		this.add(getEn_oppkgtp_refADesc(tblDesc));
		this.add(getEn_erpkgtp_refADesc(tblDesc));
		this.add(getEn_pepkgtp_refADesc(tblDesc));
		this.add(getEn_fmpkgtp_refADesc(tblDesc));
		this.add(getUnit_pkg_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mmpkguCDesc(tblDesc));
		tblDesc.add(getId_mmpkguCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_mmpkgutpCDesc(tblDesc));
		tblDesc.add(getId_unit_pkgCDesc(tblDesc));
		tblDesc.add(getFactorCDesc(tblDesc));
		tblDesc.add(getSd_mmpkguproCDesc(tblDesc));
		tblDesc.add(getId_mmpkguproCDesc(tblDesc));
		tblDesc.add(getMmpkgunameCDesc(tblDesc));
		tblDesc.add(getEn_pippkgtpCDesc(tblDesc));
		tblDesc.add(getEn_ippkgtpCDesc(tblDesc));
		tblDesc.add(getEn_oppkgtpCDesc(tblDesc));
		tblDesc.add(getEn_erpkgtpCDesc(tblDesc));
		tblDesc.add(getEn_er1pkgtpCDesc(tblDesc));
		tblDesc.add(getEn_er2pkgtpCDesc(tblDesc));
		tblDesc.add(getEn_pepkgtpCDesc(tblDesc));
		tblDesc.add(getEn_fmpkgtpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗物品包装单位主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkguADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgu",  getId_mmpkguCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗物品包装单位主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkgutpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgutp",  getId_mmpkgutpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_pkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_pkg",  getId_unit_pkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 换算系数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor",  getFactorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位性质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmpkguproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmpkgupro",  getSd_mmpkguproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位性质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkguproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgupro",  getId_mmpkguproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmpkgunameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmpkguname",  getMmpkgunameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_pippkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_pippkgtp",  getEn_pippkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("预住院发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_ippkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_ippkgtp",  getEn_ippkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_oppkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_oppkgtp",  getEn_oppkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("门诊发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊流水发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_erpkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_erpkgtp",  getEn_erpkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("急诊流水发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊抢救发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_er1pkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_er1pkgtp",  getEn_er1pkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("急诊抢救发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊留观发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_er2pkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_er2pkgtp",  getEn_er2pkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("急诊留观发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_pepkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_pepkgtp",  getEn_pepkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_fmpkgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_fmpkgtp",  getEn_fmpkgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("家庭发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M_name",  getM_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b1","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmpkgutp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmpkgutp_name",  getMmpkgutp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b2","id_mmpkgutp=id_mmpkgutp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_ippkgtp_refADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_ippkgtp_ref",  getEn_ippkgtp_refCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b2","id_mmpkgutp=id_mmpkgutp","en_ippkgtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_oppkgtp_refADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_oppkgtp_ref",  getEn_oppkgtp_refCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("门诊发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b2","id_mmpkgutp=id_mmpkgutp","en_oppkgtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_erpkgtp_refADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_erpkgtp_ref",  getEn_erpkgtp_refCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("急诊发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b2","id_mmpkgutp=id_mmpkgutp","en_erpkgtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_pepkgtp_refADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_pepkgtp_ref",  getEn_pepkgtp_refCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b2","id_mmpkgutp=id_mmpkgutp","en_pepkgtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭发药包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_fmpkgtp_refADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_fmpkgtp_ref",  getEn_fmpkgtp_refCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("家庭发药包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGUTP a1b2","id_mmpkgutp=id_mmpkgutp","en_fmpkgtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnit_pkg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit_pkg_name",  getUnit_pkg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b3","id_unit_pkg=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗物品包装单位主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkguCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgu");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗物品包装单位主键"); 
		return column;
	}
	/**
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取包装单位类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkgutpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgutp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位类型"); 
		return column;
	}
	/**
	 * 获取包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_pkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_pkg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位"); 
		return column;
	}
	/**
	 * 获取换算系数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数"); 
		return column;
	}
	/**
	 * 获取包装单位性质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmpkguproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmpkgupro");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位性质编码"); 
		return column;
	}
	/**
	 * 获取包装单位性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkguproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgupro");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位性质"); 
		return column;
	}
	/**
	 * 获取包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmpkgunameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmpkguname");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位名称"); 
		return column;
	}
	/**
	 * 获取预住院发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_pippkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_pippkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("预住院发药包装单位"); 
		return column;
	}
	/**
	 * 获取住院发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_ippkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_ippkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院发药包装单位"); 
		return column;
	}
	/**
	 * 获取门诊发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_oppkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_oppkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("门诊发药包装单位"); 
		return column;
	}
	/**
	 * 获取急诊流水发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_erpkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_erpkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("急诊流水发药包装单位"); 
		return column;
	}
	/**
	 * 获取急诊抢救发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_er1pkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_er1pkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("急诊抢救发药包装单位"); 
		return column;
	}
	/**
	 * 获取急诊留观发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_er2pkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_er2pkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("急诊留观发药包装单位"); 
		return column;
	}
	/**
	 * 获取体检发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_pepkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_pepkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检发药包装单位"); 
		return column;
	}
	/**
	 * 获取家庭发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_fmpkgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_fmpkgtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("家庭发药包装单位"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取包装单位类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmpkgutp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmpkgutp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位类型名称"); 
		return column;
	}
	/**
	 * 获取住院发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_ippkgtp_refCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_ippkgtp_ref");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院发药包装单位"); 
		return column;
	}
	/**
	 * 获取门诊发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_oppkgtp_refCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_oppkgtp_ref");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("门诊发药包装单位"); 
		return column;
	}
	/**
	 * 获取急诊发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_erpkgtp_refCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_erpkgtp_ref");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("急诊发药包装单位"); 
		return column;
	}
	/**
	 * 获取体检发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_pepkgtp_refCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_pepkgtp_ref");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检发药包装单位"); 
		return column;
	}
	/**
	 * 获取家庭发药包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_fmpkgtp_refCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_fmpkgtp_ref");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("家庭发药包装单位"); 
		return column;
	}
	/**
	 * 获取包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnit_pkg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit_pkg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位名称"); 
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
