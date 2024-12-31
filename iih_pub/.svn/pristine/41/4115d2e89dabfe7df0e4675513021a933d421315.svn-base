
package iih.nmr.pkuf.barthel.d.desc;

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
 * Barthel指数评定量表 DO 元数据信息
 */
public class BarthelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.barthel.d.BarthelDO";
	public static final String CLASS_DISPALYNAME = "Barthel指数评定量表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_BARTHEL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_barthel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BarthelDODesc(){
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
		this.setKeyDesc(getId_barthelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_barthelADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getId_assess_pointADesc(tblDesc));
		this.add(getSd_assess_pointADesc(tblDesc));
		this.add(getId_eatADesc(tblDesc));
		this.add(getSd_eatADesc(tblDesc));
		this.add(getSc_eatADesc(tblDesc));
		this.add(getId_take_showerADesc(tblDesc));
		this.add(getSd_take_showerADesc(tblDesc));
		this.add(getSc_take_showerADesc(tblDesc));
		this.add(getId_modifiADesc(tblDesc));
		this.add(getSd_modifiADesc(tblDesc));
		this.add(getSc_modifiADesc(tblDesc));
		this.add(getId_dressADesc(tblDesc));
		this.add(getSd_dressADesc(tblDesc));
		this.add(getSc_dressADesc(tblDesc));
		this.add(getId_contro_stoolADesc(tblDesc));
		this.add(getSd_contro_stoolADesc(tblDesc));
		this.add(getSc_contro_stoolADesc(tblDesc));
		this.add(getId_contro_urinADesc(tblDesc));
		this.add(getSd_contro_urinADesc(tblDesc));
		this.add(getSc_contro_urinADesc(tblDesc));
		this.add(getId_toiletADesc(tblDesc));
		this.add(getSd_toiletADesc(tblDesc));
		this.add(getSc_toiletADesc(tblDesc));
		this.add(getId_seat_transADesc(tblDesc));
		this.add(getSd_seat_transADesc(tblDesc));
		this.add(getSc_seat_transADesc(tblDesc));
		this.add(getId_walk_groundADesc(tblDesc));
		this.add(getSd_walk_groundADesc(tblDesc));
		this.add(getSc_walk_groundADesc(tblDesc));
		this.add(getId_stairADesc(tblDesc));
		this.add(getSd_stairADesc(tblDesc));
		this.add(getSc_stairADesc(tblDesc));
		this.add(getSc_totalADesc(tblDesc));
		this.add(getId_proposalADesc(tblDesc));
		this.add(getSd_proposalADesc(tblDesc));
		this.add(getId_self_leaveADesc(tblDesc));
		this.add(getSd_self_leaveADesc(tblDesc));
		this.add(getIs_deadthADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_assess_pointADesc(tblDesc));
		this.add(getName_eatADesc(tblDesc));
		this.add(getName_take_showerADesc(tblDesc));
		this.add(getName_modifiADesc(tblDesc));
		this.add(getName_dressADesc(tblDesc));
		this.add(getName_contro_stoolADesc(tblDesc));
		this.add(getName_contro_urinADesc(tblDesc));
		this.add(getName_toiletADesc(tblDesc));
		this.add(getName_seat_transADesc(tblDesc));
		this.add(getName_walk_groundADesc(tblDesc));
		this.add(getName_stairADesc(tblDesc));
		this.add(getName_proposalADesc(tblDesc));
		this.add(getName_self_leaveADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_barthelCDesc(tblDesc));
		tblDesc.add(getId_barthelCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getId_assess_pointCDesc(tblDesc));
		tblDesc.add(getSd_assess_pointCDesc(tblDesc));
		tblDesc.add(getId_eatCDesc(tblDesc));
		tblDesc.add(getSd_eatCDesc(tblDesc));
		tblDesc.add(getSc_eatCDesc(tblDesc));
		tblDesc.add(getId_take_showerCDesc(tblDesc));
		tblDesc.add(getSd_take_showerCDesc(tblDesc));
		tblDesc.add(getSc_take_showerCDesc(tblDesc));
		tblDesc.add(getId_modifiCDesc(tblDesc));
		tblDesc.add(getSd_modifiCDesc(tblDesc));
		tblDesc.add(getSc_modifiCDesc(tblDesc));
		tblDesc.add(getId_dressCDesc(tblDesc));
		tblDesc.add(getSd_dressCDesc(tblDesc));
		tblDesc.add(getSc_dressCDesc(tblDesc));
		tblDesc.add(getId_contro_stoolCDesc(tblDesc));
		tblDesc.add(getSd_contro_stoolCDesc(tblDesc));
		tblDesc.add(getSc_contro_stoolCDesc(tblDesc));
		tblDesc.add(getId_contro_urinCDesc(tblDesc));
		tblDesc.add(getSd_contro_urinCDesc(tblDesc));
		tblDesc.add(getSc_contro_urinCDesc(tblDesc));
		tblDesc.add(getId_toiletCDesc(tblDesc));
		tblDesc.add(getSd_toiletCDesc(tblDesc));
		tblDesc.add(getSc_toiletCDesc(tblDesc));
		tblDesc.add(getId_seat_transCDesc(tblDesc));
		tblDesc.add(getSd_seat_transCDesc(tblDesc));
		tblDesc.add(getSc_seat_transCDesc(tblDesc));
		tblDesc.add(getId_walk_groundCDesc(tblDesc));
		tblDesc.add(getSd_walk_groundCDesc(tblDesc));
		tblDesc.add(getSc_walk_groundCDesc(tblDesc));
		tblDesc.add(getId_stairCDesc(tblDesc));
		tblDesc.add(getSd_stairCDesc(tblDesc));
		tblDesc.add(getSc_stairCDesc(tblDesc));
		tblDesc.add(getSc_totalCDesc(tblDesc));
		tblDesc.add(getId_proposalCDesc(tblDesc));
		tblDesc.add(getSd_proposalCDesc(tblDesc));
		tblDesc.add(getId_self_leaveCDesc(tblDesc));
		tblDesc.add(getSd_self_leaveCDesc(tblDesc));
		tblDesc.add(getIs_deadthCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * Brarthel主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_barthelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_barthel",  getId_barthelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Brarthel主键");
		attrDesc.setNullable(true);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * id_sign属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("id_sign");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * dt_create属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("dt_create");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_assess_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_assess_point",  getId_assess_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_assess_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_assess_point",  getSd_assess_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eat",  getId_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 进食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eat",  getSd_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_eat",  getSc_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("进食评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 洗澡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_take_showerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_take_shower",  getId_take_showerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("洗澡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 洗澡编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_take_showerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_take_shower",  getSd_take_showerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("洗澡编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 洗澡评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_take_showerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_take_shower",  getSc_take_showerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("洗澡评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 修饰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_modifiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_modifi",  getId_modifiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修饰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 修饰编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_modifiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_modifi",  getSd_modifiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修饰编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 修饰评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_modifiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_modifi",  getSc_modifiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("修饰评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿衣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dress",  getId_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿衣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 穿衣编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dress",  getSd_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿衣编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿衣评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_dress",  getSc_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("穿衣评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制大便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contro_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contro_stool",  getId_contro_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制大便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 控制大便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_contro_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_contro_stool",  getSd_contro_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制大便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制大便评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_contro_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_contro_stool",  getSc_contro_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("控制大便评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制小便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contro_urinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contro_urin",  getId_contro_urinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制小便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 控制小便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_contro_urinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_contro_urin",  getSd_contro_urinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制小便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制小便评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_contro_urinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_contro_urin",  getSc_contro_urinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("控制小便评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如厕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_toiletADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_toilet",  getId_toiletCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如厕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 如厕编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_toiletADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_toilet",  getSd_toiletCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如厕编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如厕评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_toiletADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_toilet",  getSc_toiletCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("如厕评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 座椅转移属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_seat_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_seat_trans",  getId_seat_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("座椅转移");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 座椅转移编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_seat_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_seat_trans",  getSd_seat_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("座椅转移编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 座椅转移评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_seat_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_seat_trans",  getSc_seat_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("座椅转移评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平地行走属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_walk_groundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_walk_ground",  getId_walk_groundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("平地行走");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 平地行走编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_walk_groundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_walk_ground",  getSd_walk_groundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("平地行走编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平地行走评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_walk_groundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_walk_ground",  getSc_walk_groundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("平地行走评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下楼梯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stair",  getId_stairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下楼梯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 上下楼梯编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stair",  getSd_stairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下楼梯编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下楼梯评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_stairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_stair",  getSc_stairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("上下楼梯评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_totalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_total",  getSc_totalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proposalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proposal",  getId_proposalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 建议编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_proposalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_proposal",  getSd_proposalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_self_leaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_self_leave",  getId_self_leaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自理能力等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_self_leaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_self_leave",  getSd_self_leaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡出院请选择属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_deadthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_deadth",  getIs_deadthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("死亡出院请选择");
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
	 * 记录人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记录人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_assess_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_assess_point",  getName_assess_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_assess_point=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eat",  getName_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_eat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 洗澡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_take_showerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_take_shower",  getName_take_showerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("洗澡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_take_shower=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 修饰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_modifiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_modifi",  getName_modifiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修饰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_modifi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿衣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dress",  getName_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿衣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_dress=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制大便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contro_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_contro_stool",  getName_contro_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制大便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_contro_stool=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制小便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contro_urinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_contro_urin",  getName_contro_urinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制小便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_contro_urin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如厕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_toiletADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_toilet",  getName_toiletCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如厕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_toilet=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 座椅转移属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_seat_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_seat_trans",  getName_seat_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("座椅转移");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_seat_trans=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平地行走属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_walk_groundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_walk_ground",  getName_walk_groundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("平地行走");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_walk_ground=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下楼梯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stair",  getName_stairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下楼梯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_stair=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_proposalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_proposal",  getName_proposalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_proposal=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_self_leaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_self_leave",  getName_self_leaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_self_leave=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取Brarthel主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_barthelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_barthel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Brarthel主键"); 
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
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取就诊病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊病区"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取id_sign表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("id_sign"); 
		return column;
	}
	/**
	 * 获取dt_create表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("dt_create"); 
		return column;
	}
	/**
	 * 获取评估点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_assess_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_assess_point");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估点"); 
		return column;
	}
	/**
	 * 获取评估点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_assess_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_assess_point");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估点编码"); 
		return column;
	}
	/**
	 * 获取进食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食"); 
		return column;
	}
	/**
	 * 获取进食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eat");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食编码"); 
		return column;
	}
	/**
	 * 获取进食评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_eat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("进食评分"); 
		return column;
	}
	/**
	 * 获取洗澡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_take_showerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_take_shower");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("洗澡"); 
		return column;
	}
	/**
	 * 获取洗澡编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_take_showerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_take_shower");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("洗澡编码"); 
		return column;
	}
	/**
	 * 获取洗澡评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_take_showerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_take_shower");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("洗澡评分"); 
		return column;
	}
	/**
	 * 获取修饰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_modifiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_modifi");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修饰"); 
		return column;
	}
	/**
	 * 获取修饰编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_modifiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_modifi");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修饰编码"); 
		return column;
	}
	/**
	 * 获取修饰评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_modifiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_modifi");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("修饰评分"); 
		return column;
	}
	/**
	 * 获取穿衣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dress");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿衣"); 
		return column;
	}
	/**
	 * 获取穿衣编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dress");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿衣编码"); 
		return column;
	}
	/**
	 * 获取穿衣评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_dress");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("穿衣评分"); 
		return column;
	}
	/**
	 * 获取控制大便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contro_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contro_stool");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制大便"); 
		return column;
	}
	/**
	 * 获取控制大便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_contro_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_contro_stool");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制大便编码"); 
		return column;
	}
	/**
	 * 获取控制大便评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_contro_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_contro_stool");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("控制大便评分"); 
		return column;
	}
	/**
	 * 获取控制小便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contro_urinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contro_urin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制小便"); 
		return column;
	}
	/**
	 * 获取控制小便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_contro_urinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_contro_urin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制小便编码"); 
		return column;
	}
	/**
	 * 获取控制小便评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_contro_urinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_contro_urin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("控制小便评分"); 
		return column;
	}
	/**
	 * 获取如厕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_toiletCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_toilet");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如厕"); 
		return column;
	}
	/**
	 * 获取如厕编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_toiletCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_toilet");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如厕编码"); 
		return column;
	}
	/**
	 * 获取如厕评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_toiletCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_toilet");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("如厕评分"); 
		return column;
	}
	/**
	 * 获取座椅转移表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_seat_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_seat_trans");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("座椅转移"); 
		return column;
	}
	/**
	 * 获取座椅转移编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_seat_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_seat_trans");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("座椅转移编码"); 
		return column;
	}
	/**
	 * 获取座椅转移评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_seat_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_seat_trans");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("座椅转移评分"); 
		return column;
	}
	/**
	 * 获取平地行走表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_walk_groundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_walk_ground");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("平地行走"); 
		return column;
	}
	/**
	 * 获取平地行走编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_walk_groundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_walk_ground");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("平地行走编码"); 
		return column;
	}
	/**
	 * 获取平地行走评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_walk_groundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_walk_ground");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("平地行走评分"); 
		return column;
	}
	/**
	 * 获取上下楼梯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stair");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下楼梯"); 
		return column;
	}
	/**
	 * 获取上下楼梯编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stair");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下楼梯编码"); 
		return column;
	}
	/**
	 * 获取上下楼梯评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_stairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_stair");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("上下楼梯评分"); 
		return column;
	}
	/**
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_totalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_total");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总分"); 
		return column;
	}
	/**
	 * 获取建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proposalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proposal");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议"); 
		return column;
	}
	/**
	 * 获取建议编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_proposalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_proposal");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议编码"); 
		return column;
	}
	/**
	 * 获取自理能力等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_self_leaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_self_leave");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力等级"); 
		return column;
	}
	/**
	 * 获取自理能力等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_self_leaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_self_leave");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力等级编码"); 
		return column;
	}
	/**
	 * 获取死亡出院请选择表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_deadthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_deadth");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("死亡出院请选择"); 
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
	 * 获取记录人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记录人"); 
		return column;
	}
	/**
	 * 获取评估点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_assess_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_assess_point");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估点"); 
		return column;
	}
	/**
	 * 获取进食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食"); 
		return column;
	}
	/**
	 * 获取洗澡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_take_showerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_take_shower");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("洗澡"); 
		return column;
	}
	/**
	 * 获取修饰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_modifiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_modifi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修饰"); 
		return column;
	}
	/**
	 * 获取穿衣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dress");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿衣"); 
		return column;
	}
	/**
	 * 获取控制大便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contro_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_contro_stool");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制大便"); 
		return column;
	}
	/**
	 * 获取控制小便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contro_urinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_contro_urin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制小便"); 
		return column;
	}
	/**
	 * 获取如厕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_toiletCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_toilet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如厕"); 
		return column;
	}
	/**
	 * 获取座椅转移表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_seat_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_seat_trans");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("座椅转移"); 
		return column;
	}
	/**
	 * 获取平地行走表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_walk_groundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_walk_ground");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("平地行走"); 
		return column;
	}
	/**
	 * 获取上下楼梯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stair");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下楼梯"); 
		return column;
	}
	/**
	 * 获取建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_proposalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_proposal");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议"); 
		return column;
	}
	/**
	 * 获取自理能力等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_self_leaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_self_leave");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力等级"); 
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
