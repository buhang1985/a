
package iih.mp.dg.adr.d.desc;

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
 * 药品不良反应 DO 元数据信息
 */
public class MpDgAdrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.adr.d.MpDgAdrDO";
	public static final String CLASS_DISPALYNAME = "药品不良反应";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_adr";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mpdgadr";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpDgAdrDODesc(){
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
		this.setKeyDesc(getId_mpdgadrADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_mpdgadrADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_or_prADesc(tblDesc));
		this.add(getDt_mp_planADesc(tblDesc));
		this.add(getDt_mp_atcstartADesc(tblDesc));
		this.add(getDt_mp_atcendADesc(tblDesc));
		this.add(getId_dgadrtpADesc(tblDesc));
		this.add(getSd_dgadrtpADesc(tblDesc));
		this.add(getAdr_desADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getDt_creaADesc(tblDesc));
		this.add(getId_emp_creaADesc(tblDesc));
		this.add(getEn_confADesc(tblDesc));
		this.add(getDt_confADesc(tblDesc));
		this.add(getId_emp_confADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getContent_orADesc(tblDesc));
		this.add(getName_dgadrtpADesc(tblDesc));
		this.add(getName_dep_mpADesc(tblDesc));
		this.add(getName_creaADesc(tblDesc));
		this.add(getName_confADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mpdgadrCDesc(tblDesc));
		tblDesc.add(getId_mpdgadrCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getDt_birthCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_or_prCDesc(tblDesc));
		tblDesc.add(getDt_mp_planCDesc(tblDesc));
		tblDesc.add(getDt_mp_atcstartCDesc(tblDesc));
		tblDesc.add(getDt_mp_atcendCDesc(tblDesc));
		tblDesc.add(getId_dgadrtpCDesc(tblDesc));
		tblDesc.add(getSd_dgadrtpCDesc(tblDesc));
		tblDesc.add(getAdr_desCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getDt_creaCDesc(tblDesc));
		tblDesc.add(getId_emp_creaCDesc(tblDesc));
		tblDesc.add(getEn_confCDesc(tblDesc));
		tblDesc.add(getDt_confCDesc(tblDesc));
		tblDesc.add(getId_emp_confCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 药品不良反应ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mpdgadrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mpdgadr",  getId_mpdgadrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品不良反应ID");
		attrDesc.setNullable(true);
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
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生日属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("生日");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel",  getTelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重(kg)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体重(kg)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱执行记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_prADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr",  getId_or_prCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱执行记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划执行时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mp_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mp_plan",  getDt_mp_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划执行时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际用药开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mp_atcstartADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mp_atcstart",  getDt_mp_atcstartCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际用药开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际用药结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mp_atcendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mp_atcend",  getDt_mp_atcendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际用药结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药反应类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgadrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgadrtp",  getId_dgadrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药反应类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用药反应类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dgadrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dgadrtp",  getSd_dgadrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药反应类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药反应描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdr_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adr_des",  getAdr_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药反应描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记录时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_creaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_crea",  getDt_creaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记录时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_creaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_crea",  getId_emp_creaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 确认状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_conf",  getEn_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("确认状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_conf",  getDt_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("确认日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_conf",  getId_emp_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b4","id_pat=id_pat","name"});
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b4","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContent_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content_or",  getContent_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a0b5","id_or=id_or","content_or"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药反应类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dgadrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dgadrtp",  getName_dgadrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药反应类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_dgadrtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_mp",  getName_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b11","id_dep_mp=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_creaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_crea",  getName_creaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b12","id_emp_crea=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_conf",  getName_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b13","id_emp_conf=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取药品不良反应ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mpdgadrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mpdgadr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品不良反应ID"); 
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
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取生日表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生日"); 
		return column;
	}
	/**
	 * 获取电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电话"); 
		return column;
	}
	/**
	 * 获取体重(kg)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体重(kg)"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取医嘱执行记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_prCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱执行记录"); 
		return column;
	}
	/**
	 * 获取计划执行时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mp_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mp_plan");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划执行时间"); 
		return column;
	}
	/**
	 * 获取实际用药开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mp_atcstartCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mp_atcstart");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际用药开始时间"); 
		return column;
	}
	/**
	 * 获取实际用药结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mp_atcendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mp_atcend");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际用药结束时间"); 
		return column;
	}
	/**
	 * 获取用药反应类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgadrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgadrtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药反应类型"); 
		return column;
	}
	/**
	 * 获取用药反应类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dgadrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dgadrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药反应类型编码"); 
		return column;
	}
	/**
	 * 获取用药反应描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdr_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adr_des");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药反应描述"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取记录时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_creaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_crea");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记录时间"); 
		return column;
	}
	/**
	 * 获取操作员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_creaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_crea");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作员"); 
		return column;
	}
	/**
	 * 获取确认状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_conf");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("确认状态"); 
		return column;
	}
	/**
	 * 获取确认日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_conf");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("确认日期"); 
		return column;
	}
	/**
	 * 获取确认人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_conf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认人"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取医嘱内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContent_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱内容"); 
		return column;
	}
	/**
	 * 获取用药反应类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dgadrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dgadrtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药反应类型名称"); 
		return column;
	}
	/**
	 * 获取执行科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_mp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室名称"); 
		return column;
	}
	/**
	 * 获取操作员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_creaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_crea");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作员姓名"); 
		return column;
	}
	/**
	 * 获取确认人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_conf");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认人姓名"); 
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
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
