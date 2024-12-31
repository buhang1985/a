
package iih.ci.ord.app.d.desc;

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
 * 用血打印申请单 DO 元数据信息
 */
public class CiAppBuSheetDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.app.d.CiAppBuSheetDO";
	public static final String CLASS_DISPALYNAME = "用血打印申请单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_app_bu";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ciappbusheet";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiAppBuSheetDODesc(){
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
		this.setKeyDesc(getId_ciappbusheetADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ciappbusheetADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_enADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_orsrvADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_apbuADesc(tblDesc));
		this.add(getId_apbtADesc(tblDesc));
		this.add(getCode_app_buADesc(tblDesc));
		this.add(getCode_app_btADesc(tblDesc));
		this.add(getId_app_bloodtypeADesc(tblDesc));
		this.add(getSd_app_bloodtypeADesc(tblDesc));
		this.add(getId_app_rhdADesc(tblDesc));
		this.add(getSd_app_rhdADesc(tblDesc));
		this.add(getId_blootpADesc(tblDesc));
		this.add(getSd_blootpADesc(tblDesc));
		this.add(getQuan_medu_buADesc(tblDesc));
		this.add(getId_medu_unitADesc(tblDesc));
		this.add(getDt_pl_buADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getId_emp_buADesc(tblDesc));
		this.add(getApplydoctortelADesc(tblDesc));
		this.add(getDes_orADesc(tblDesc));
		this.add(getFg_prnADesc(tblDesc));
		this.add(getCnt_prnADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ciappbusheetCDesc(tblDesc));
		tblDesc.add(getId_ciappbusheetCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_enCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_orsrvCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_apbuCDesc(tblDesc));
		tblDesc.add(getId_apbtCDesc(tblDesc));
		tblDesc.add(getCode_app_buCDesc(tblDesc));
		tblDesc.add(getCode_app_btCDesc(tblDesc));
		tblDesc.add(getId_app_bloodtypeCDesc(tblDesc));
		tblDesc.add(getSd_app_bloodtypeCDesc(tblDesc));
		tblDesc.add(getId_app_rhdCDesc(tblDesc));
		tblDesc.add(getSd_app_rhdCDesc(tblDesc));
		tblDesc.add(getId_blootpCDesc(tblDesc));
		tblDesc.add(getSd_blootpCDesc(tblDesc));
		tblDesc.add(getQuan_medu_buCDesc(tblDesc));
		tblDesc.add(getId_medu_unitCDesc(tblDesc));
		tblDesc.add(getDt_pl_buCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getId_emp_buCDesc(tblDesc));
		tblDesc.add(getApplydoctortelCDesc(tblDesc));
		tblDesc.add(getDes_orCDesc(tblDesc));
		tblDesc.add(getFg_prnCDesc(tblDesc));
		tblDesc.add(getCnt_prnCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 用血申请单主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciappbusheetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciappbusheet",  getId_ciappbusheetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用血申请单主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_en",  getId_enCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱服务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orsrv",  getId_orsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱服务ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血申请单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apbuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apbu",  getId_apbuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取血申请单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血申请单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apbtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apbt",  getId_apbtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血申请单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_app_buADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_app_bu",  getCode_app_buCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取血申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_app_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_app_bt",  getCode_app_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请血型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_app_bloodtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_app_bloodtype",  getId_app_bloodtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请血型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_app_bloodtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_app_bloodtype",  getSd_app_bloodtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请Rh(D)ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_app_rhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_app_rhd",  getId_app_rhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请Rh(D)ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请Rh(D)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_app_rhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_app_rhd",  getSd_app_rhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请Rh(D)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请血液种类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blootpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blootp",  getId_blootpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请血液种类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请血液种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blootpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blootp",  getSd_blootpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请血液种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次用血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_medu_buADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_medu_bu",  getQuan_medu_buCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本次用血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medu_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medu_unit",  getId_medu_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划用血时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_pl_buADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pl_bu",  getDt_pl_buCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划用血时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用血申请医师ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_buADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_bu",  getId_emp_buCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用血申请医师ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApplydoctortelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Applydoctortel",  getApplydoctortelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嘱托属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_or",  getDes_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嘱托");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prn",  getFg_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCnt_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cnt_prn",  getCnt_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("打印次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取用血申请单主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciappbusheetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciappbusheet");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用血申请单主键标识"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_en");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取医嘱ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱ID"); 
		return column;
	}
	/**
	 * 获取医嘱服务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orsrv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱服务ID"); 
		return column;
	}
	/**
	 * 获取服务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务ID"); 
		return column;
	}
	/**
	 * 获取取血申请单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apbuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apbu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取血申请单ID"); 
		return column;
	}
	/**
	 * 获取备血申请单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apbtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apbt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血申请单ID"); 
		return column;
	}
	/**
	 * 获取取血申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_app_buCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_app_bu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取血申请单号"); 
		return column;
	}
	/**
	 * 获取备血申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_app_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_app_bt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血申请单号"); 
		return column;
	}
	/**
	 * 获取申请血型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_app_bloodtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_app_bloodtype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请血型ID"); 
		return column;
	}
	/**
	 * 获取申请血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_app_bloodtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_app_bloodtype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请血型编码"); 
		return column;
	}
	/**
	 * 获取申请Rh(D)ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_app_rhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_app_rhd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请Rh(D)ID"); 
		return column;
	}
	/**
	 * 获取申请Rh(D)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_app_rhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_app_rhd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请Rh(D)编码"); 
		return column;
	}
	/**
	 * 获取申请血液种类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blootpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blootp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请血液种类ID"); 
		return column;
	}
	/**
	 * 获取申请血液种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blootpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blootp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请血液种类编码"); 
		return column;
	}
	/**
	 * 获取本次用血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medu_buCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_medu_bu");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本次用血量"); 
		return column;
	}
	/**
	 * 获取血量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medu_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medu_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血量单位"); 
		return column;
	}
	/**
	 * 获取计划用血时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_pl_buCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pl_bu");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划用血时间"); 
		return column;
	}
	/**
	 * 获取执行科室ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室ID"); 
		return column;
	}
	/**
	 * 获取用血申请医师ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_buCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_bu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用血申请医师ID"); 
		return column;
	}
	/**
	 * 获取医生联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApplydoctortelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Applydoctortel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生联系电话"); 
		return column;
	}
	/**
	 * 获取嘱托表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_or");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嘱托"); 
		return column;
	}
	/**
	 * 获取打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印标识"); 
		return column;
	}
	/**
	 * 获取打印次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCnt_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cnt_prn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("打印次数"); 
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
