
package iih.cssd.dpus.dfpapp.d.desc;

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
 * 消毒包请领 DO 元数据信息
 */
public class DfpAppDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.cssd.dpus.dfpapp.d.DfpAppDO";
	public static final String CLASS_DISPALYNAME = "消毒包请领";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CSSD_DFP_APP";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dfp_app";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DfpAppDODesc(){
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
		this.setKeyDesc(getId_dfp_appADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_dfp_appADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getApplynoADesc(tblDesc));
		this.add(getId_dep_appADesc(tblDesc));
		this.add(getId_emp_appADesc(tblDesc));
		this.add(getDt_appADesc(tblDesc));
		this.add(getDt_planADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getId_chk_empADesc(tblDesc));
		this.add(getDt_chkADesc(tblDesc));
		this.add(getNote_appADesc(tblDesc));
		this.add(getNote_rcvADesc(tblDesc));
		this.add(getId_app_statusADesc(tblDesc));
		this.add(getSd_app_statusADesc(tblDesc));
		this.add(getEu_noonADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getNote_rejectADesc(tblDesc));
		this.add(getName_acc_depADesc(tblDesc));
		this.add(getName_acc_empADesc(tblDesc));
		this.add(getName_chk_empADesc(tblDesc));
		this.add(getName_app_staADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dfp_appCDesc(tblDesc));
		tblDesc.add(getId_dfp_appCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getApplynoCDesc(tblDesc));
		tblDesc.add(getId_dep_appCDesc(tblDesc));
		tblDesc.add(getId_emp_appCDesc(tblDesc));
		tblDesc.add(getDt_appCDesc(tblDesc));
		tblDesc.add(getDt_planCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getId_chk_empCDesc(tblDesc));
		tblDesc.add(getDt_chkCDesc(tblDesc));
		tblDesc.add(getNote_appCDesc(tblDesc));
		tblDesc.add(getNote_rcvCDesc(tblDesc));
		tblDesc.add(getId_app_statusCDesc(tblDesc));
		tblDesc.add(getSd_app_statusCDesc(tblDesc));
		tblDesc.add(getEu_noonCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getNote_rejectCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 请领主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dfp_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dfp_app",  getId_dfp_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 请领单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApplynoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Applyno",  getApplynoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领单号");
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
	 * 请领人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_app",  getId_emp_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_app",  getDt_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请领时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划使用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_plan",  getDt_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("计划使用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加急标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加急标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chk_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chk_emp",  getId_chk_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_chk",  getDt_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_app",  getNote_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_rcv",  getNote_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_app_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_app_status",  getId_app_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领状态ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领状态请领状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_app_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_app_status",  getSd_app_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领状态请领状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 午别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_noonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_noon",  getEu_noonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("午别");
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
	 * 驳回原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_rejectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_reject",  getNote_rejectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("驳回原因");
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
	private IAttrDesc getName_acc_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_acc_dep",  getName_acc_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_app=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_acc_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_acc_emp",  getName_acc_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","id_emp_app=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chk_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chk_emp",  getName_chk_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","id_chk_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_app_staADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_app_sta",  getName_app_staCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_app_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取请领主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dfp_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dfp_app");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请领主键"); 
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
	 * 获取请领单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApplynoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Applyno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领单号"); 
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
	 * 获取请领人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领人"); 
		return column;
	}
	/**
	 * 获取请领时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_app");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请领时间"); 
		return column;
	}
	/**
	 * 获取计划使用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_plan");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划使用时间"); 
		return column;
	}
	/**
	 * 获取加急标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加急标识"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chk_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chk_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_chk");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取请领备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_app");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领备注"); 
		return column;
	}
	/**
	 * 获取接收备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_rcv");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收备注"); 
		return column;
	}
	/**
	 * 获取请领状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_app_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_app_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领状态ID"); 
		return column;
	}
	/**
	 * 获取请领状态请领状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_app_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_app_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领状态请领状态编码"); 
		return column;
	}
	/**
	 * 获取午别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_noonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_noon");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("午别"); 
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
	 * 获取驳回原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_rejectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_reject");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("驳回原因"); 
		return column;
	}
	/**
	 * 获取请领科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_acc_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_acc_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领科室"); 
		return column;
	}
	/**
	 * 获取请领人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_acc_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_acc_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领人"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chk_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chk_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取请领状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_app_staCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_app_sta");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领状态名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
