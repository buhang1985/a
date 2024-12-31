
package iih.mm.qy.priceadjust.d.desc;

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
 * 调价查询视图 DO 元数据信息
 */
public class PriceAdjustViewDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.qy.priceadjust.d.PriceAdjustView";
	public static final String CLASS_DISPALYNAME = "调价查询视图";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "V_MM_PRICEADJUST";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_stpri";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PriceAdjustViewDesc(){
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
		this.setKeyDesc(getId_stpriADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_stpriADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getDt_priADesc(tblDesc));
		this.add(getDt_pri_shortADesc(tblDesc));
		this.add(getId_emp_stpriADesc(tblDesc));
		this.add(getId_su_stpriADesc(tblDesc));
		this.add(getSd_su_stpriADesc(tblDesc));
		this.add(getDoc_noADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_mmpkgu_salesADesc(tblDesc));
		this.add(getId_primd_oldADesc(tblDesc));
		this.add(getSd_primd_oldADesc(tblDesc));
		this.add(getId_primd_newADesc(tblDesc));
		this.add(getSd_primd_newADesc(tblDesc));
		this.add(getRate_oldADesc(tblDesc));
		this.add(getRate_newADesc(tblDesc));
		this.add(getPri_old_salesADesc(tblDesc));
		this.add(getPri_new_salesADesc(tblDesc));
		this.add(getSup_idADesc(tblDesc));
		this.add(getYear_monthADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getBatchADesc(tblDesc));
		this.add(getPri_actADesc(tblDesc));
		this.add(getQuanADesc(tblDesc));
		this.add(getId_mmcaADesc(tblDesc));
		this.add(getEmp_stpri_nameADesc(tblDesc));
		this.add(getSu_stpri_nameADesc(tblDesc));
		this.add(getMm_specADesc(tblDesc));
		this.add(getSup_nameADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getName_unit_pkgspADesc(tblDesc));
		this.add(getSale_priceADesc(tblDesc));
		this.add(getId_supADesc(tblDesc));
		this.add(getSale_mmpkgunameADesc(tblDesc));
		this.add(getPrimd_old_nameADesc(tblDesc));
		this.add(getPrimd_new_nameADesc(tblDesc));
		this.add(getWh_nameADesc(tblDesc));
		this.add(getMmca_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_stpriCDesc(tblDesc));
		tblDesc.add(getId_stpriCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getDt_priCDesc(tblDesc));
		tblDesc.add(getDt_pri_shortCDesc(tblDesc));
		tblDesc.add(getId_emp_stpriCDesc(tblDesc));
		tblDesc.add(getId_su_stpriCDesc(tblDesc));
		tblDesc.add(getSd_su_stpriCDesc(tblDesc));
		tblDesc.add(getDoc_noCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_mmpkgu_salesCDesc(tblDesc));
		tblDesc.add(getId_primd_oldCDesc(tblDesc));
		tblDesc.add(getSd_primd_oldCDesc(tblDesc));
		tblDesc.add(getId_primd_newCDesc(tblDesc));
		tblDesc.add(getSd_primd_newCDesc(tblDesc));
		tblDesc.add(getRate_oldCDesc(tblDesc));
		tblDesc.add(getRate_newCDesc(tblDesc));
		tblDesc.add(getPri_old_salesCDesc(tblDesc));
		tblDesc.add(getPri_new_salesCDesc(tblDesc));
		tblDesc.add(getSup_idCDesc(tblDesc));
		tblDesc.add(getYear_monthCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getBatchCDesc(tblDesc));
		tblDesc.add(getPri_actCDesc(tblDesc));
		tblDesc.add(getQuanCDesc(tblDesc));
		tblDesc.add(getId_mmcaCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 库存调价主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stpriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stpri",  getId_stpriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存调价主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 调价单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调价单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调价生效时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pri",  getDt_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("调价生效时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调价生效日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_pri_shortADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pri_short",  getDt_pri_shortCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("调价生效日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调价员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_stpriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_stpri",  getId_emp_stpriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调价员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调价状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_stpriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_stpri",  getId_su_stpriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调价状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调价状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_stpriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_stpri",  getSd_su_stpriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调价状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调价文件号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoc_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doc_no",  getDoc_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调价文件号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkgu_salesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgu_sales",  getId_mmpkgu_salesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 原售价模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_primd_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_primd_old",  getId_primd_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原售价模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 原售价模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_primd_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_primd_old",  getSd_primd_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原售价模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新售价模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_primd_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_primd_new",  getId_primd_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新售价模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 新售价模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_primd_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_primd_new",  getSd_primd_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新售价模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原加成率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_old",  getRate_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("原加成率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新加成率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_new",  getRate_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("新加成率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原价格_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_old_salesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_old_sales",  getPri_old_salesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("原价格_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新价格_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_new_salesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_new_sales",  getPri_new_salesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("新价格_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_id",  getSup_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 年月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYear_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year_month",  getYear_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wh",  getId_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 批次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Batch",  getBatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("批次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进价_零售包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_act",  getPri_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进价_零售包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结存数量_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan",  getQuanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("结存数量_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmca",  getId_mmcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_stpri_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_stpri_name",  getEmp_stpri_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_emp_stpri=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSu_stpri_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Su_stpri_name",  getSu_stpri_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_su_stpri=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_spec",  getMm_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","spec"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_name",  getSup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","sup_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_name",  getMm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_pkgspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_pkgsp",  getName_unit_pkgspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","name_unit_pkgsp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSale_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sale_price",  getSale_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("零售价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","price"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_supADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sup",  getId_supCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b6","id_mm=id_mm","id_sup"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSale_mmpkgunameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sale_mmpkguname",  getSale_mmpkgunameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGU a0b7","id_mmpkgu_sales=id_mmpkgu","mmpkguname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrimd_old_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Primd_old_name",  getPrimd_old_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_primd_old=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrimd_new_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Primd_new_name",  getPrimd_new_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_primd_new=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWh_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wh_name",  getWh_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b11","id_wh=id_wh","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmca_name",  getMmca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MMCA a0b12","id_mmca=id_mmca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取库存调价主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stpriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stpri");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("库存调价主键"); 
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
	 * 获取调价单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调价单号"); 
		return column;
	}
	/**
	 * 获取调价生效时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pri");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调价生效时间"); 
		return column;
	}
	/**
	 * 获取调价生效日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_pri_shortCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pri_short");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调价生效日期"); 
		return column;
	}
	/**
	 * 获取调价员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_stpriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_stpri");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调价员"); 
		return column;
	}
	/**
	 * 获取调价状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_stpriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_stpri");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调价状态"); 
		return column;
	}
	/**
	 * 获取调价状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_stpriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_stpri");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调价状态编码"); 
		return column;
	}
	/**
	 * 获取调价文件号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoc_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doc_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调价文件号"); 
		return column;
	}
	/**
	 * 获取物品主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品主键"); 
		return column;
	}
	/**
	 * 获取包装单位_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkgu_salesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgu_sales");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位_零售"); 
		return column;
	}
	/**
	 * 获取原售价模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_primd_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_primd_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原售价模式"); 
		return column;
	}
	/**
	 * 获取原售价模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_primd_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_primd_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原售价模式编码"); 
		return column;
	}
	/**
	 * 获取新售价模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_primd_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_primd_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新售价模式"); 
		return column;
	}
	/**
	 * 获取新售价模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_primd_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_primd_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新售价模式编码"); 
		return column;
	}
	/**
	 * 获取原加成率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_old");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("原加成率"); 
		return column;
	}
	/**
	 * 获取新加成率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_new");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("新加成率"); 
		return column;
	}
	/**
	 * 获取原价格_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_old_salesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_old_sales");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("原价格_零售"); 
		return column;
	}
	/**
	 * 获取新价格_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_new_salesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_new_sales");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("新价格_零售"); 
		return column;
	}
	/**
	 * 获取生产厂家表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_id");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家"); 
		return column;
	}
	/**
	 * 获取年月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYear_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year_month");
		column.setLength(6);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("年月"); 
		return column;
	}
	/**
	 * 获取仓库表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库"); 
		return column;
	}
	/**
	 * 获取批次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Batch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("批次"); 
		return column;
	}
	/**
	 * 获取进价_零售包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_act");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进价_零售包装单位"); 
		return column;
	}
	/**
	 * 获取结存数量_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("结存数量_零售"); 
		return column;
	}
	/**
	 * 获取物品分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品分类"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_stpri_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_stpri_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSu_stpri_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Su_stpri_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取物品规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品规格"); 
		return column;
	}
	/**
	 * 获取生产厂家名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家名称"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取零售包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_pkgspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_pkgsp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位名称"); 
		return column;
	}
	/**
	 * 获取零售价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSale_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sale_price");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("零售价"); 
		return column;
	}
	/**
	 * 获取生产厂家主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_supCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sup");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生产厂家主键"); 
		return column;
	}
	/**
	 * 获取包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSale_mmpkgunameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sale_mmpkguname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrimd_old_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Primd_old_name");
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
	private IColumnDesc getPrimd_new_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Primd_new_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取仓库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWh_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wh_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库名称"); 
		return column;
	}
	/**
	 * 获取基本分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本分类名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_stpri");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
