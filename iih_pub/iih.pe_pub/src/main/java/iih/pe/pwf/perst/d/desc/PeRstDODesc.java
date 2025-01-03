
package iih.pe.pwf.perst.d.desc;

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
 * 体检结果 DO 元数据信息
 */
public class PeRstDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.perst.d.PeRstDO";
	public static final String CLASS_DISPALYNAME = "体检结果";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_perst";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_perst";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstDODesc(){
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
		this.setKeyDesc(getId_perstADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_perstADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getSd_deptsetADesc(tblDesc));
		this.add(getId_pedeptsetADesc(tblDesc));
		this.add(getSd_catlogADesc(tblDesc));
		this.add(getId_pesrvbcatlogADesc(tblDesc));
		this.add(getSd_itemADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getPeitemstatusADesc(tblDesc));
		this.add(getRstADesc(tblDesc));
		this.add(getId_pitm_rstADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getRefADesc(tblDesc));
		this.add(getRef_maxADesc(tblDesc));
		this.add(getRef_minADesc(tblDesc));
		this.add(getUnitADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getMarkADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getFg_abnADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getFg_posiADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_emp_nurADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getDt_nurADesc(tblDesc));
		this.add(getId_emp_docADesc(tblDesc));
		this.add(getId_dep_docADesc(tblDesc));
		this.add(getDt_docADesc(tblDesc));
		this.add(getSort_showADesc(tblDesc));
		this.add(getWarnlevelADesc(tblDesc));
		this.add(getMark_arrowADesc(tblDesc));
		this.add(getFg_urgencyADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getCode_catlogADesc(tblDesc));
		this.add(getName_catlogADesc(tblDesc));
		this.add(getCode_itmADesc(tblDesc));
		this.add(getName_itmADesc(tblDesc));
		this.add(getResulttpADesc(tblDesc));
		this.add(getFg_copyADesc(tblDesc));
		this.add(getFg_imgADesc(tblDesc));
		this.add(getDefault_valueADesc(tblDesc));
		this.add(getFormulaADesc(tblDesc));
		this.add(getSexlimitADesc(tblDesc));
		this.add(getWf_leave_checkADesc(tblDesc));
		this.add(getWf_time_delayADesc(tblDesc));
		this.add(getWf_leave_statusADesc(tblDesc));
		this.add(getFg_abn_itmADesc(tblDesc));
		this.add(getValidADesc(tblDesc));
		this.add(getId_rulerefADesc(tblDesc));
		this.add(getId_rulelegalADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getNormalkeyADesc(tblDesc));
		this.add(getCode_optsADesc(tblDesc));
		this.add(getName_optsADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perstCDesc(tblDesc));
		tblDesc.add(getId_perstCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getSd_deptsetCDesc(tblDesc));
		tblDesc.add(getId_pedeptsetCDesc(tblDesc));
		tblDesc.add(getSd_catlogCDesc(tblDesc));
		tblDesc.add(getId_pesrvbcatlogCDesc(tblDesc));
		tblDesc.add(getSd_itemCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getPeitemstatusCDesc(tblDesc));
		tblDesc.add(getRstCDesc(tblDesc));
		tblDesc.add(getId_pitm_rstCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getRefCDesc(tblDesc));
		tblDesc.add(getRef_maxCDesc(tblDesc));
		tblDesc.add(getRef_minCDesc(tblDesc));
		tblDesc.add(getUnitCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getMarkCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getFg_abnCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getFg_posiCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_emp_nurCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getDt_nurCDesc(tblDesc));
		tblDesc.add(getId_emp_docCDesc(tblDesc));
		tblDesc.add(getId_dep_docCDesc(tblDesc));
		tblDesc.add(getDt_docCDesc(tblDesc));
		tblDesc.add(getSort_showCDesc(tblDesc));
		tblDesc.add(getWarnlevelCDesc(tblDesc));
		tblDesc.add(getMark_arrowCDesc(tblDesc));
		tblDesc.add(getFg_urgencyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检结果主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perst",  getId_perstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deptsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_deptset",  getSd_deptsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedeptsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedeptset",  getId_pedeptsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_catlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_catlog",  getSd_catlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvbcatlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvbcatlog",  getId_pesrvbcatlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_item",  getSd_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem",  getId_pesrvitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查结果状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPeitemstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Peitemstatus",  getPeitemstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检查结果状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查结果内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rst",  getRstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查结果内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 常用结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pitm_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pitm_rst",  getId_pitm_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("常用结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref",  getRefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_max",  getRef_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最大值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_min",  getRef_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最小值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit",  getUnitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位");
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
	 * 异常标识符号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mark",  getMarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常标识符号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 异常标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_abnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_abn",  getFg_abnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("异常标识");
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
	 * 阳性标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_posiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_posi",  getFg_posiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("阳性标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 录入护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nur",  getId_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_nur",  getDt_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("录入时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_doc",  getId_emp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_doc",  getId_dep_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_doc",  getDt_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("检查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 显示顺序属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSort_showADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sort_show",  getSort_showCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("显示顺序");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预警级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWarnlevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Warnlevel",  getWarnlevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("预警级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常标识符箭头属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMark_arrowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mark_arrow",  getMark_arrowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常标识符箭头");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 紧急标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgency",  getFg_urgencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("紧急标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b5","id_pedeptset=id_pedeptset","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b5","id_pedeptset=id_pedeptset","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_catlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_catlog",  getCode_catlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a0b6","id_pesrvbcatlog=id_pesrvbcatlog","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_catlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_catlog",  getName_catlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a0b6","id_pesrvbcatlog=id_pesrvbcatlog","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_itm",  getCode_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_itm",  getName_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检检查小项结果类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResulttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Resulttp",  getResulttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检检查小项结果类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","resulttp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否复制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_copyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_copy",  getFg_copyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否复制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","fg_copy"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有图片附件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_imgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_img",  getFg_imgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("有图片附件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","fg_img"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缺省值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDefault_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Default_value",  getDefault_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缺省值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","default_value"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计算公式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFormulaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Formula",  getFormulaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计算公式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","formula"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexlimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sexlimit",  getSexlimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","sexlimit"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程-离开时状态检测属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWf_leave_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wf_leave_check",  getWf_leave_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("流程-离开时状态检测");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","wf_leave_check"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程-延迟检查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWf_time_delayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wf_time_delay",  getWf_time_delayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流程-延迟检查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","wf_time_delay"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程-离开时状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWf_leave_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wf_leave_status",  getWf_leave_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流程-离开时状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","wf_leave_status"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否异常判断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_abn_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_abn_itm",  getFg_abn_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否异常判断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","fg_abn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效值范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Valid",  getValidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效值范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","valid"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正异常判断规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rulerefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ruleref",  getId_rulerefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正异常判断规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","id_ruleref"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据合法性规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rulelegalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rulelegal",  getId_rulelegalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据合法性规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","id_rulelegal"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","sortno"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正常关键字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNormalkeyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Normalkey",  getNormalkeyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正常关键字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b7","id_pesrvitem=id_pesrvitem","normalkey"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入可选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_optsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_opts",  getCode_optsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入可选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitmoptdef a0b2","id_pitm_rst=id_pesrvitmoptdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入可选项名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_optsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_opts",  getName_optsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入可选项名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitmoptdef a0b2","id_pitm_rst=id_pesrvitmoptdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检结果主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perst");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检结果主键标识"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取体检科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deptsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_deptset");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室编码"); 
		return column;
	}
	/**
	 * 获取所属科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedeptsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedeptset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属科室"); 
		return column;
	}
	/**
	 * 获取体检项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_catlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_catlog");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目编码"); 
		return column;
	}
	/**
	 * 获取体检项目ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvbcatlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvbcatlog");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目ID"); 
		return column;
	}
	/**
	 * 获取体检结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_item");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果编码"); 
		return column;
	}
	/**
	 * 获取体检结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果ID"); 
		return column;
	}
	/**
	 * 获取检查结果状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPeitemstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Peitemstatus");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检查结果状态"); 
		return column;
	}
	/**
	 * 获取检查结果内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rst");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查结果内容"); 
		return column;
	}
	/**
	 * 获取常用结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pitm_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pitm_rst");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("常用结果ID"); 
		return column;
	}
	/**
	 * 获取检查描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查描述"); 
		return column;
	}
	/**
	 * 获取参考范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考范围"); 
		return column;
	}
	/**
	 * 获取最大值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_max");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最大值"); 
		return column;
	}
	/**
	 * 获取最小值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_min");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最小值"); 
		return column;
	}
	/**
	 * 获取计量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位"); 
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
	 * 获取异常标识符号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mark");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常标识符号"); 
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
	 * 获取异常标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_abnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_abn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("异常标识"); 
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
	 * 获取阳性标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_posiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_posi");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("阳性标识"); 
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
	 * 获取录入护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入护士"); 
		return column;
	}
	/**
	 * 获取录入科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入科室"); 
		return column;
	}
	/**
	 * 获取录入时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_nur");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("录入时间"); 
		return column;
	}
	/**
	 * 获取检查医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查医生"); 
		return column;
	}
	/**
	 * 获取检查科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查科室"); 
		return column;
	}
	/**
	 * 获取检查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_doc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("检查时间"); 
		return column;
	}
	/**
	 * 获取显示顺序表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSort_showCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sort_show");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("显示顺序"); 
		return column;
	}
	/**
	 * 获取预警级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWarnlevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Warnlevel");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("预警级别"); 
		return column;
	}
	/**
	 * 获取异常标识符箭头表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMark_arrowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mark_arrow");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常标识符箭头"); 
		return column;
	}
	/**
	 * 获取紧急标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgency");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("紧急标识"); 
		return column;
	}
	/**
	 * 获取体检科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室编码"); 
		return column;
	}
	/**
	 * 获取体检科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_catlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_catlog");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_catlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_catlog");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取体检结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_itm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果编码"); 
		return column;
	}
	/**
	 * 获取体检结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_itm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果名称"); 
		return column;
	}
	/**
	 * 获取体检检查小项结果类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResulttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Resulttp");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检检查小项结果类型"); 
		return column;
	}
	/**
	 * 获取是否复制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_copyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_copy");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否复制"); 
		return column;
	}
	/**
	 * 获取有图片附件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_imgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_img");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有图片附件"); 
		return column;
	}
	/**
	 * 获取缺省值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDefault_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Default_value");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缺省值"); 
		return column;
	}
	/**
	 * 获取计算公式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFormulaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Formula");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计算公式"); 
		return column;
	}
	/**
	 * 获取性别限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexlimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sexlimit");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别限制"); 
		return column;
	}
	/**
	 * 获取流程-离开时状态检测表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWf_leave_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wf_leave_check");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("流程-离开时状态检测"); 
		return column;
	}
	/**
	 * 获取流程-延迟检查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWf_time_delayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wf_time_delay");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流程-延迟检查时间"); 
		return column;
	}
	/**
	 * 获取流程-离开时状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWf_leave_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wf_leave_status");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流程-离开时状态"); 
		return column;
	}
	/**
	 * 获取是否异常判断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_abn_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_abn_itm");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否异常判断"); 
		return column;
	}
	/**
	 * 获取有效值范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Valid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效值范围"); 
		return column;
	}
	/**
	 * 获取正异常判断规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rulerefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ruleref");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正异常判断规则"); 
		return column;
	}
	/**
	 * 获取数据合法性规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rulelegalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rulelegal");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据合法性规则"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取正常关键字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNormalkeyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Normalkey");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正常关键字"); 
		return column;
	}
	/**
	 * 获取录入可选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_optsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_opts");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入可选项编码"); 
		return column;
	}
	/**
	 * 获取录入可选项名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_optsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_opts");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入可选项名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perst");
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
