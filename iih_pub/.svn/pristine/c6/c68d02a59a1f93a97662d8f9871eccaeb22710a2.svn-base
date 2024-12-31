
package iih.ci.mr.cimracrecords.d.desc;

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
 * 产程其他信息 DO 元数据信息
 */
public class CiMrACOtherDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.cimracrecords.d.CiMrACOtherDO";
	public static final String CLASS_DISPALYNAME = "产程其他信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_ac_other";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_acother";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrACOtherDODesc(){
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
		this.setKeyDesc(getId_acotherADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_mracbaseADesc(tblDesc));
		this.add(getId_acotherADesc(tblDesc));
		this.add(getId_mracbaseADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_inspectADesc(tblDesc));
		this.add(getSd_inspectADesc(tblDesc));
		this.add(getName_inspectADesc(tblDesc));
		this.add(getId_caulADesc(tblDesc));
		this.add(getSd_caulADesc(tblDesc));
		this.add(getName_caulADesc(tblDesc));
		this.add(getValue_ootuADesc(tblDesc));
		this.add(getId_level_ootuADesc(tblDesc));
		this.add(getSd_level_ootuADesc(tblDesc));
		this.add(getName_level_ootuADesc(tblDesc));
		this.add(getId_amnioticfluidADesc(tblDesc));
		this.add(getSd_amnioticfluidADesc(tblDesc));
		this.add(getName_amnioticfluidADesc(tblDesc));
		this.add(getOxytocinADesc(tblDesc));
		this.add(getFg_childbirthADesc(tblDesc));
		this.add(getAbnormitysituADesc(tblDesc));
		this.add(getSolvesituADesc(tblDesc));
		this.add(getDate_childbirthADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getDef10ADesc(tblDesc));
		this.add(getInspect_codeADesc(tblDesc));
		this.add(getInspect_nameADesc(tblDesc));
		this.add(getCaul_nameADesc(tblDesc));
		this.add(getCaul_codeADesc(tblDesc));
		this.add(getLevel_ootu_codeADesc(tblDesc));
		this.add(getLevel_ootu_nameADesc(tblDesc));
		this.add(getAmnioticfluid_nameADesc(tblDesc));
		this.add(getAmnioticfluid_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_acotherCDesc(tblDesc));
		tblDesc.add(getId_acotherCDesc(tblDesc));
		tblDesc.add(getId_mracbaseCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_inspectCDesc(tblDesc));
		tblDesc.add(getSd_inspectCDesc(tblDesc));
		tblDesc.add(getName_inspectCDesc(tblDesc));
		tblDesc.add(getId_caulCDesc(tblDesc));
		tblDesc.add(getSd_caulCDesc(tblDesc));
		tblDesc.add(getName_caulCDesc(tblDesc));
		tblDesc.add(getValue_ootuCDesc(tblDesc));
		tblDesc.add(getId_level_ootuCDesc(tblDesc));
		tblDesc.add(getSd_level_ootuCDesc(tblDesc));
		tblDesc.add(getName_level_ootuCDesc(tblDesc));
		tblDesc.add(getId_amnioticfluidCDesc(tblDesc));
		tblDesc.add(getSd_amnioticfluidCDesc(tblDesc));
		tblDesc.add(getName_amnioticfluidCDesc(tblDesc));
		tblDesc.add(getOxytocinCDesc(tblDesc));
		tblDesc.add(getFg_childbirthCDesc(tblDesc));
		tblDesc.add(getAbnormitysituCDesc(tblDesc));
		tblDesc.add(getSolvesituCDesc(tblDesc));
		tblDesc.add(getDate_childbirthCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getDef10CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_acotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_acother",  getId_acotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产程基本信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mracbaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mracbase",  getId_mracbaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产程基本信息ID");
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
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
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
	 * 检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inspectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inspect",  getId_inspectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inspectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inspect",  getSd_inspectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inspectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inspect",  getName_inspectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_caulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_caul",  getId_caulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎膜(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_caulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_caul",  getSd_caulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_caulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_caul",  getName_caulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口值(0-10)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_ootuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_ootu",  getValue_ootuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫口值(0-10)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_ootuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_ootu",  getId_level_ootuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫口程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宫口程度(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_ootuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_ootu",  getSd_level_ootuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫口程度(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口程度(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_level_ootuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_level_ootu",  getName_level_ootuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫口程度(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_amnioticfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_amnioticfluid",  getId_amnioticfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 羊水色(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_amnioticfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_amnioticfluid",  getSd_amnioticfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水色(sd)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水色(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_amnioticfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_amnioticfluid",  getName_amnioticfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水色(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 催产素（滴/分）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxytocinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxytocin",  getOxytocinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("催产素（滴/分）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否分娩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_childbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_childbirth",  getFg_childbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否分娩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAbnormitysituADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Abnormitysitu",  getAbnormitysituCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSolvesituADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Solvesitu",  getSolvesituCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩时间（备用）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDate_childbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Date_childbirth",  getDate_childbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("分娩时间（备用）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInspect_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inspect_code",  getInspect_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b3","id_inspect=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInspect_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inspect_name",  getInspect_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b3","id_inspect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCaul_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Caul_name",  getCaul_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b4","id_caul=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCaul_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Caul_code",  getCaul_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b4","id_caul=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLevel_ootu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Level_ootu_code",  getLevel_ootu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b5","id_level_ootu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLevel_ootu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Level_ootu_name",  getLevel_ootu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b5","id_level_ootu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmnioticfluid_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amnioticfluid_name",  getAmnioticfluid_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b6","id_amnioticfluid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmnioticfluid_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amnioticfluid_code",  getAmnioticfluid_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b6","id_amnioticfluid=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_acotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_acother");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主键ID"); 
		return column;
	}
	/**
	 * 获取产程基本信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mracbaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mracbase");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产程基本信息ID"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inspectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inspect");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查"); 
		return column;
	}
	/**
	 * 获取检查(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inspectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inspect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查(sd)"); 
		return column;
	}
	/**
	 * 获取检查(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inspectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inspect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查(name)"); 
		return column;
	}
	/**
	 * 获取胎膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_caulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_caul");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜"); 
		return column;
	}
	/**
	 * 获取胎膜(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_caulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_caul");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜(sd)"); 
		return column;
	}
	/**
	 * 获取胎膜(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_caulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_caul");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜(name)"); 
		return column;
	}
	/**
	 * 获取宫口值(0-10)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_ootuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_ootu");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫口值(0-10)"); 
		return column;
	}
	/**
	 * 获取宫口程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_ootuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_ootu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫口程度"); 
		return column;
	}
	/**
	 * 获取宫口程度(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_ootuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_ootu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫口程度(sd)"); 
		return column;
	}
	/**
	 * 获取宫口程度(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_level_ootuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_level_ootu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫口程度(name)"); 
		return column;
	}
	/**
	 * 获取羊水色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_amnioticfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_amnioticfluid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水色"); 
		return column;
	}
	/**
	 * 获取羊水色(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_amnioticfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_amnioticfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水色(sd)"); 
		return column;
	}
	/**
	 * 获取羊水色(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_amnioticfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_amnioticfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水色(name)"); 
		return column;
	}
	/**
	 * 获取催产素（滴/分）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxytocinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxytocin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("催产素（滴/分）"); 
		return column;
	}
	/**
	 * 获取是否分娩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_childbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_childbirth");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否分娩"); 
		return column;
	}
	/**
	 * 获取异常情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAbnormitysituCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Abnormitysitu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常情况"); 
		return column;
	}
	/**
	 * 获取处理情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSolvesituCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Solvesitu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理情况"); 
		return column;
	}
	/**
	 * 获取分娩时间（备用）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDate_childbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Date_childbirth");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩时间（备用）"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段7"); 
		return column;
	}
	/**
	 * 获取客户扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段8"); 
		return column;
	}
	/**
	 * 获取客户扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段9"); 
		return column;
	}
	/**
	 * 获取客户扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段10"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInspect_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inspect_code");
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
	private IColumnDesc getInspect_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inspect_name");
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
	private IColumnDesc getCaul_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Caul_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCaul_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Caul_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLevel_ootu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Level_ootu_code");
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
	private IColumnDesc getLevel_ootu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Level_ootu_name");
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
	private IColumnDesc getAmnioticfluid_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amnioticfluid_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmnioticfluid_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amnioticfluid_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
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
