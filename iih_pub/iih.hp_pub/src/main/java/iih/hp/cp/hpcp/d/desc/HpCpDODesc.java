
package iih.hp.cp.hpcp.d.desc;

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
 * 诊疗计划 DO 元数据信息
 */
public class HpCpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.hpcp.d.HpCpDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "hp_cp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpDODesc(){
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
		this.setKeyDesc(getId_cpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cpADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_cp_sdADesc(tblDesc));
		this.add(getId_ele_appADesc(tblDesc));
		this.add(getMinspandaysADesc(tblDesc));
		this.add(getMaxspandaysADesc(tblDesc));
		this.add(getAvgcostADesc(tblDesc));
		this.add(getId_ele_admitADesc(tblDesc));
		this.add(getId_ele_haltADesc(tblDesc));
		this.add(getId_ele_finishADesc(tblDesc));
		this.add(getVersionADesc(tblDesc));
		this.add(getEu_owtpADesc(tblDesc));
		this.add(getId_ow_depADesc(tblDesc));
		this.add(getId_ow_empADesc(tblDesc));
		this.add(getEu_enbltpADesc(tblDesc));
		this.add(getId_enbl_empADesc(tblDesc));
		this.add(getId_statusADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_fromtbbADesc(tblDesc));
		this.add(getFg_delADesc(tblDesc));
		this.add(getDt_activeADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_taskADesc(tblDesc));
		this.add(getName_cp_sdADesc(tblDesc));
		this.add(getCode_cp_sdADesc(tblDesc));
		this.add(getId_ow_dep_nameADesc(tblDesc));
		this.add(getId_ow_emp_nameADesc(tblDesc));
		this.add(getName_statusADesc(tblDesc));
		this.add(getName_createdbyADesc(tblDesc));
		this.add(getName_modifiedbyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cpCDesc(tblDesc));
		tblDesc.add(getId_cpCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_cp_sdCDesc(tblDesc));
		tblDesc.add(getId_ele_appCDesc(tblDesc));
		tblDesc.add(getMinspandaysCDesc(tblDesc));
		tblDesc.add(getMaxspandaysCDesc(tblDesc));
		tblDesc.add(getAvgcostCDesc(tblDesc));
		tblDesc.add(getId_ele_admitCDesc(tblDesc));
		tblDesc.add(getId_ele_haltCDesc(tblDesc));
		tblDesc.add(getId_ele_finishCDesc(tblDesc));
		tblDesc.add(getVersionCDesc(tblDesc));
		tblDesc.add(getEu_owtpCDesc(tblDesc));
		tblDesc.add(getId_ow_depCDesc(tblDesc));
		tblDesc.add(getId_ow_empCDesc(tblDesc));
		tblDesc.add(getEu_enbltpCDesc(tblDesc));
		tblDesc.add(getId_enbl_empCDesc(tblDesc));
		tblDesc.add(getId_statusCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_fromtbbCDesc(tblDesc));
		tblDesc.add(getFg_delCDesc(tblDesc));
		tblDesc.add(getDt_activeCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getId_taskCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 诊疗计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cp",  getId_cpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划ID");
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
	 * 诊疗计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cp_sdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cp_sd",  getId_cp_sdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 适用对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_app",  getId_ele_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适用对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小平均住院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMinspandaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Minspandays",  getMinspandaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最小平均住院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大平均住院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMaxspandaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Maxspandays",  getMaxspandaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大平均住院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平均费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAvgcostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Avgcost",  getAvgcostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("平均费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 准入规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_admitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_admit",  getId_ele_admitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("准入规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退出规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_haltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_halt",  getId_ele_haltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退出规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_finishADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_finish",  getId_ele_finishCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 版本号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVersionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Version",  getVersionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("版本号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划所属类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_owtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_owtp",  getEu_owtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("计划所属类型");
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
	private IAttrDesc getId_ow_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ow_dep",  getId_ow_depCDesc(tblDesc), this);
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
	 * 所属个人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ow_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ow_emp",  getId_ow_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属个人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 可用范围类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_enbltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_enbltp",  getEu_enbltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("可用范围类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适用个人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enbl_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enbl_emp",  getId_enbl_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适用个人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_status",  getId_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
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
	 * 源自新建待建路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_fromtbbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fromtbb",  getFg_fromtbbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("源自新建待建路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_delADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_del",  getFg_delCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("删除标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_active",  getDt_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("启用日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程任务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_task",  getId_taskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流程任务ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cp_sdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cp_sd",  getName_cp_sdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_SD a0b15","id_cp_sd=id_sd","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cp_sdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cp_sd",  getCode_cp_sdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_SD a0b15","id_cp_sd=id_sd","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ow_dep_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ow_dep_name",  getId_ow_dep_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b9","id_ow_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ow_emp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ow_emp_name",  getId_ow_emp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b10","id_ow_emp=id_psndoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_createdbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_createdby",  getName_createdbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b12","createdby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_modifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_modifiedby",  getName_modifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b13","modifiedby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取诊疗计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划ID"); 
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
	 * 获取诊疗计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划名称"); 
		return column;
	}
	/**
	 * 获取诊疗计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划编码"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(450);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
		return column;
	}
	/**
	 * 获取标准ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cp_sdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cp_sd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准ID"); 
		return column;
	}
	/**
	 * 获取适用对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适用对象"); 
		return column;
	}
	/**
	 * 获取最小平均住院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMinspandaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Minspandays");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最小平均住院天数"); 
		return column;
	}
	/**
	 * 获取最大平均住院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMaxspandaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Maxspandays");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大平均住院天数"); 
		return column;
	}
	/**
	 * 获取平均费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAvgcostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Avgcost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("平均费用"); 
		return column;
	}
	/**
	 * 获取准入规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_admitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_admit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("准入规则"); 
		return column;
	}
	/**
	 * 获取退出规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_haltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_halt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退出规则"); 
		return column;
	}
	/**
	 * 获取完成规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_finishCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_finish");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成规则"); 
		return column;
	}
	/**
	 * 获取版本号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVersionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Version");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("版本号"); 
		return column;
	}
	/**
	 * 获取计划所属类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_owtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_owtp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("计划所属类型"); 
		return column;
	}
	/**
	 * 获取所属科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ow_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ow_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属科室"); 
		return column;
	}
	/**
	 * 获取所属个人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ow_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ow_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属个人"); 
		return column;
	}
	/**
	 * 获取可用范围类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_enbltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_enbltp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("可用范围类型"); 
		return column;
	}
	/**
	 * 获取适用个人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enbl_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enbl_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适用个人"); 
		return column;
	}
	/**
	 * 获取状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态ID"); 
		return column;
	}
	/**
	 * 获取状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态编码"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(30);
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
	 * 获取源自新建待建路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_fromtbbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fromtbb");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("源自新建待建路径"); 
		return column;
	}
	/**
	 * 获取删除标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_delCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_del");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("删除标志"); 
		return column;
	}
	/**
	 * 获取启用日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_active");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用日期"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
		return column;
	}
	/**
	 * 获取流程任务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_task");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程任务ID"); 
		return column;
	}
	/**
	 * 获取标准名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cp_sdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cp_sd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准名称"); 
		return column;
	}
	/**
	 * 获取标准编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cp_sdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cp_sd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ow_dep_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ow_dep_name");
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
	private IColumnDesc getId_ow_emp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ow_emp_name");
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
	private IColumnDesc getName_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_createdbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_createdby");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_modifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_modifiedby");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
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
