
package iih.ci.mr.nu.regformfordeliver.d.desc;

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
 * 分娩登记表 DO 元数据信息
 */
public class RegformDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.regformfordeliver.d.RegformDO";
	public static final String CLASS_DISPALYNAME = "分娩登记表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_REGFORM";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_regform";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public RegformDODesc(){
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
		this.setKeyDesc(getId_regformADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_regformADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getNum_pregADesc(tblDesc));
		this.add(getNum_produceADesc(tblDesc));
		this.add(getNum_abortionADesc(tblDesc));
		this.add(getNum_miscarADesc(tblDesc));
		this.add(getOther_pregADesc(tblDesc));
		this.add(getNum_checkbfADesc(tblDesc));
		this.add(getDt_lastmenstruADesc(tblDesc));
		this.add(getDt_duechildADesc(tblDesc));
		this.add(getId_bloodtpADesc(tblDesc));
		this.add(getSd_bloodtpADesc(tblDesc));
		this.add(getNum_sonADesc(tblDesc));
		this.add(getNum_daughterADesc(tblDesc));
		this.add(getDes_pregpastADesc(tblDesc));
		this.add(getDt_beginmatsADesc(tblDesc));
		this.add(getDt_rupbranADesc(tblDesc));
		this.add(getId_ruptpADesc(tblDesc));
		this.add(getSd_ruptpADesc(tblDesc));
		this.add(getDt_cervcompADesc(tblDesc));
		this.add(getDt_orientfetintADesc(tblDesc));
		this.add(getId_birthchild_situatADesc(tblDesc));
		this.add(getSd_birthchild_situatADesc(tblDesc));
		this.add(getDt_orientfetinttwoADesc(tblDesc));
		this.add(getId_birthchild_situattwoADesc(tblDesc));
		this.add(getSd_birthchild_situattwoADesc(tblDesc));
		this.add(getDt_orientfetintthreeADesc(tblDesc));
		this.add(getId_birthchild_situatthreeADesc(tblDesc));
		this.add(getSd_birthchild_situatthreeADesc(tblDesc));
		this.add(getDt_placentaADesc(tblDesc));
		this.add(getId_orientfetintwoADesc(tblDesc));
		this.add(getSd_orientfetintwoADesc(tblDesc));
		this.add(getId_pla_statusADesc(tblDesc));
		this.add(getSd_pla_statusADesc(tblDesc));
		this.add(getEnum_sexchildoneADesc(tblDesc));
		this.add(getWeight_childoneADesc(tblDesc));
		this.add(getHeight_childoneADesc(tblDesc));
		this.add(getHdcircu_childoneADesc(tblDesc));
		this.add(getChest_childoneADesc(tblDesc));
		this.add(getId_cheststatuoneADesc(tblDesc));
		this.add(getSd_cheststatuoneADesc(tblDesc));
		this.add(getEnum_sexchildtwoADesc(tblDesc));
		this.add(getWeight_childtwoADesc(tblDesc));
		this.add(getHeight_childtwoADesc(tblDesc));
		this.add(getHdcircu_childtwoADesc(tblDesc));
		this.add(getChest_childtwoADesc(tblDesc));
		this.add(getId_cheststatutwoADesc(tblDesc));
		this.add(getSd_cheststatutwoADesc(tblDesc));
		this.add(getEnum_sexchildthreeADesc(tblDesc));
		this.add(getWeight_childthreeADesc(tblDesc));
		this.add(getHeight_childthreeADesc(tblDesc));
		this.add(getHdcircu_childthreeADesc(tblDesc));
		this.add(getChest_childthreeADesc(tblDesc));
		this.add(getId_cheststatuthreeADesc(tblDesc));
		this.add(getSd_cheststatuthreeADesc(tblDesc));
		this.add(getTotal_laborADesc(tblDesc));
		this.add(getFirst_laborADesc(tblDesc));
		this.add(getSecond_laborADesc(tblDesc));
		this.add(getThird_laborADesc(tblDesc));
		this.add(getNum_bldlostADesc(tblDesc));
		this.add(getNum_bldlostdurADesc(tblDesc));
		this.add(getNum_bldlosthADesc(tblDesc));
		this.add(getNum_bldtlostthADesc(tblDesc));
		this.add(getId_reasonbdlostADesc(tblDesc));
		this.add(getSd_reasonbdlostADesc(tblDesc));
		this.add(getReasonbdlostoADesc(tblDesc));
		this.add(getPost_medicADesc(tblDesc));
		this.add(getId_peruptADesc(tblDesc));
		this.add(getSd_peruptADesc(tblDesc));
		this.add(getBdpress_highADesc(tblDesc));
		this.add(getBdpress_lowADesc(tblDesc));
		this.add(getEnum_heartADesc(tblDesc));
		this.add(getEnum_breathADesc(tblDesc));
		this.add(getEnum_tensionADesc(tblDesc));
		this.add(getEnum_throatADesc(tblDesc));
		this.add(getEnum_skincolorADesc(tblDesc));
		this.add(getScore_totalchildADesc(tblDesc));
		this.add(getChildbirth_sumaryADesc(tblDesc));
		this.add(getId_diagdocADesc(tblDesc));
		this.add(getHd_conditionADesc(tblDesc));
		this.add(getId_nurseoneADesc(tblDesc));
		this.add(getId_nursetwoADesc(tblDesc));
		this.add(getPla_lengthADesc(tblDesc));
		this.add(getPla_widthADesc(tblDesc));
		this.add(getPla_heightADesc(tblDesc));
		this.add(getId_umbcordADesc(tblDesc));
		this.add(getSd_umbcordADesc(tblDesc));
		this.add(getLength_umbcordADesc(tblDesc));
		this.add(getId_necktwiningADesc(tblDesc));
		this.add(getSd_necktwiningADesc(tblDesc));
		this.add(getId_amniotic_fluidADesc(tblDesc));
		this.add(getSd_amniotic_fluidADesc(tblDesc));
		this.add(getId_numamnfluidADesc(tblDesc));
		this.add(getSd_numamnfluidADesc(tblDesc));
		this.add(getColor_amnfluidADesc(tblDesc));
		this.add(getSmell_amnfluidADesc(tblDesc));
		this.add(getId_surgeryADesc(tblDesc));
		this.add(getSd_surgeryADesc(tblDesc));
		this.add(getNum_needleoutADesc(tblDesc));
		this.add(getIntrap_medicADesc(tblDesc));
		this.add(getPreg_complicatADesc(tblDesc));
		this.add(getBirth_complicatADesc(tblDesc));
		this.add(getEnumbranecompltADesc(tblDesc));
		this.add(getId_signatureADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_bloodtpADesc(tblDesc));
		this.add(getName_ruptpADesc(tblDesc));
		this.add(getName_birth_situatADesc(tblDesc));
		this.add(getName_birthchild_situattwoADesc(tblDesc));
		this.add(getName_birthchild_situatthreeADesc(tblDesc));
		this.add(getName_orientfetintwoADesc(tblDesc));
		this.add(getName_pla_statusADesc(tblDesc));
		this.add(getName_chetstatuoneADesc(tblDesc));
		this.add(getName_chetstatutwoADesc(tblDesc));
		this.add(getName_cheststatuthreeADesc(tblDesc));
		this.add(getName_reasonbdlostADesc(tblDesc));
		this.add(getName_peruptADesc(tblDesc));
		this.add(getName_diagdocADesc(tblDesc));
		this.add(getName_nurseoneADesc(tblDesc));
		this.add(getName_nursetwoADesc(tblDesc));
		this.add(getName_umbcordADesc(tblDesc));
		this.add(getName_necktwiningADesc(tblDesc));
		this.add(getName_amniotic_fluidADesc(tblDesc));
		this.add(getName_numamnfluidADesc(tblDesc));
		this.add(getName_surgeryADesc(tblDesc));
		this.add(getName_signatureADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_regformCDesc(tblDesc));
		tblDesc.add(getId_regformCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getNum_pregCDesc(tblDesc));
		tblDesc.add(getNum_produceCDesc(tblDesc));
		tblDesc.add(getNum_abortionCDesc(tblDesc));
		tblDesc.add(getNum_miscarCDesc(tblDesc));
		tblDesc.add(getOther_pregCDesc(tblDesc));
		tblDesc.add(getNum_checkbfCDesc(tblDesc));
		tblDesc.add(getDt_lastmenstruCDesc(tblDesc));
		tblDesc.add(getDt_duechildCDesc(tblDesc));
		tblDesc.add(getId_bloodtpCDesc(tblDesc));
		tblDesc.add(getSd_bloodtpCDesc(tblDesc));
		tblDesc.add(getNum_sonCDesc(tblDesc));
		tblDesc.add(getNum_daughterCDesc(tblDesc));
		tblDesc.add(getDes_pregpastCDesc(tblDesc));
		tblDesc.add(getDt_beginmatsCDesc(tblDesc));
		tblDesc.add(getDt_rupbranCDesc(tblDesc));
		tblDesc.add(getId_ruptpCDesc(tblDesc));
		tblDesc.add(getSd_ruptpCDesc(tblDesc));
		tblDesc.add(getDt_cervcompCDesc(tblDesc));
		tblDesc.add(getDt_orientfetintCDesc(tblDesc));
		tblDesc.add(getId_birthchild_situatCDesc(tblDesc));
		tblDesc.add(getSd_birthchild_situatCDesc(tblDesc));
		tblDesc.add(getDt_orientfetinttwoCDesc(tblDesc));
		tblDesc.add(getId_birthchild_situattwoCDesc(tblDesc));
		tblDesc.add(getSd_birthchild_situattwoCDesc(tblDesc));
		tblDesc.add(getDt_orientfetintthreeCDesc(tblDesc));
		tblDesc.add(getId_birthchild_situatthreeCDesc(tblDesc));
		tblDesc.add(getSd_birthchild_situatthreeCDesc(tblDesc));
		tblDesc.add(getDt_placentaCDesc(tblDesc));
		tblDesc.add(getId_orientfetintwoCDesc(tblDesc));
		tblDesc.add(getSd_orientfetintwoCDesc(tblDesc));
		tblDesc.add(getId_pla_statusCDesc(tblDesc));
		tblDesc.add(getSd_pla_statusCDesc(tblDesc));
		tblDesc.add(getEnum_sexchildoneCDesc(tblDesc));
		tblDesc.add(getWeight_childoneCDesc(tblDesc));
		tblDesc.add(getHeight_childoneCDesc(tblDesc));
		tblDesc.add(getHdcircu_childoneCDesc(tblDesc));
		tblDesc.add(getChest_childoneCDesc(tblDesc));
		tblDesc.add(getId_cheststatuoneCDesc(tblDesc));
		tblDesc.add(getSd_cheststatuoneCDesc(tblDesc));
		tblDesc.add(getEnum_sexchildtwoCDesc(tblDesc));
		tblDesc.add(getWeight_childtwoCDesc(tblDesc));
		tblDesc.add(getHeight_childtwoCDesc(tblDesc));
		tblDesc.add(getHdcircu_childtwoCDesc(tblDesc));
		tblDesc.add(getChest_childtwoCDesc(tblDesc));
		tblDesc.add(getId_cheststatutwoCDesc(tblDesc));
		tblDesc.add(getSd_cheststatutwoCDesc(tblDesc));
		tblDesc.add(getEnum_sexchildthreeCDesc(tblDesc));
		tblDesc.add(getWeight_childthreeCDesc(tblDesc));
		tblDesc.add(getHeight_childthreeCDesc(tblDesc));
		tblDesc.add(getHdcircu_childthreeCDesc(tblDesc));
		tblDesc.add(getChest_childthreeCDesc(tblDesc));
		tblDesc.add(getId_cheststatuthreeCDesc(tblDesc));
		tblDesc.add(getSd_cheststatuthreeCDesc(tblDesc));
		tblDesc.add(getTotal_laborCDesc(tblDesc));
		tblDesc.add(getFirst_laborCDesc(tblDesc));
		tblDesc.add(getSecond_laborCDesc(tblDesc));
		tblDesc.add(getThird_laborCDesc(tblDesc));
		tblDesc.add(getNum_bldlostCDesc(tblDesc));
		tblDesc.add(getNum_bldlostdurCDesc(tblDesc));
		tblDesc.add(getNum_bldlosthCDesc(tblDesc));
		tblDesc.add(getNum_bldtlostthCDesc(tblDesc));
		tblDesc.add(getId_reasonbdlostCDesc(tblDesc));
		tblDesc.add(getSd_reasonbdlostCDesc(tblDesc));
		tblDesc.add(getReasonbdlostoCDesc(tblDesc));
		tblDesc.add(getPost_medicCDesc(tblDesc));
		tblDesc.add(getId_peruptCDesc(tblDesc));
		tblDesc.add(getSd_peruptCDesc(tblDesc));
		tblDesc.add(getBdpress_highCDesc(tblDesc));
		tblDesc.add(getBdpress_lowCDesc(tblDesc));
		tblDesc.add(getEnum_heartCDesc(tblDesc));
		tblDesc.add(getEnum_breathCDesc(tblDesc));
		tblDesc.add(getEnum_tensionCDesc(tblDesc));
		tblDesc.add(getEnum_throatCDesc(tblDesc));
		tblDesc.add(getEnum_skincolorCDesc(tblDesc));
		tblDesc.add(getScore_totalchildCDesc(tblDesc));
		tblDesc.add(getChildbirth_sumaryCDesc(tblDesc));
		tblDesc.add(getId_diagdocCDesc(tblDesc));
		tblDesc.add(getHd_conditionCDesc(tblDesc));
		tblDesc.add(getId_nurseoneCDesc(tblDesc));
		tblDesc.add(getId_nursetwoCDesc(tblDesc));
		tblDesc.add(getPla_lengthCDesc(tblDesc));
		tblDesc.add(getPla_widthCDesc(tblDesc));
		tblDesc.add(getPla_heightCDesc(tblDesc));
		tblDesc.add(getId_umbcordCDesc(tblDesc));
		tblDesc.add(getSd_umbcordCDesc(tblDesc));
		tblDesc.add(getLength_umbcordCDesc(tblDesc));
		tblDesc.add(getId_necktwiningCDesc(tblDesc));
		tblDesc.add(getSd_necktwiningCDesc(tblDesc));
		tblDesc.add(getId_amniotic_fluidCDesc(tblDesc));
		tblDesc.add(getSd_amniotic_fluidCDesc(tblDesc));
		tblDesc.add(getId_numamnfluidCDesc(tblDesc));
		tblDesc.add(getSd_numamnfluidCDesc(tblDesc));
		tblDesc.add(getColor_amnfluidCDesc(tblDesc));
		tblDesc.add(getSmell_amnfluidCDesc(tblDesc));
		tblDesc.add(getId_surgeryCDesc(tblDesc));
		tblDesc.add(getSd_surgeryCDesc(tblDesc));
		tblDesc.add(getNum_needleoutCDesc(tblDesc));
		tblDesc.add(getIntrap_medicCDesc(tblDesc));
		tblDesc.add(getPreg_complicatCDesc(tblDesc));
		tblDesc.add(getBirth_complicatCDesc(tblDesc));
		tblDesc.add(getEnumbranecompltCDesc(tblDesc));
		tblDesc.add(getId_signatureCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 分娩登记表ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_regformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_regform",  getId_regformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩登记表ID");
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
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_pregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_preg",  getNum_pregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("孕次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_produceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_produce",  getNum_produceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_abortionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_abortion",  getNum_abortionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("人流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流产属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_miscarADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_miscar",  getNum_miscarCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流产");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他生产属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_pregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_preg",  getOther_pregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他生产");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产前检查次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_checkbfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_checkbf",  getNum_checkbfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产前检查次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 末次月经日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_lastmenstruADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_lastmenstru",  getDt_lastmenstruCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("末次月经日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预产期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_duechildADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_duechild",  getDt_duechildCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("预产期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodtp",  getId_bloodtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodtp",  getSd_bloodtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现有小孩(男)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_sonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_son",  getNum_sonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("现有小孩(男)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现有小孩(女)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_daughterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_daughter",  getNum_daughterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("现有小孩(女)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过去妊娠摘要属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_pregpastADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_pregpast",  getDes_pregpastCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过去妊娠摘要");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阵缩起始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beginmatsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_beginmats",  getDt_beginmatsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("阵缩起始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rupbranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rupbran",  getDt_rupbranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎膜破裂时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ruptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ruptp",  getId_ruptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎膜破裂方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ruptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ruptp",  getSd_ruptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口开全时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cervcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cervcomp",  getDt_cervcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("宫口开全时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_orientfetintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_orientfetint",  getDt_orientfetintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎儿1娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1娩出情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birthchild_situatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birthchild_situat",  getId_birthchild_situatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿1娩出情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿1娩出情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_birthchild_situatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_birthchild_situat",  getSd_birthchild_situatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿1娩出情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_orientfetinttwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_orientfetinttwo",  getDt_orientfetinttwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎儿2娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2娩出情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birthchild_situattwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birthchild_situattwo",  getId_birthchild_situattwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿2娩出情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿2娩出情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_birthchild_situattwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_birthchild_situattwo",  getSd_birthchild_situattwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿2娩出情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_orientfetintthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_orientfetintthree",  getDt_orientfetintthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎儿3娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3娩出情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birthchild_situatthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birthchild_situatthree",  getId_birthchild_situatthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿3娩出情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿3娩出情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_birthchild_situatthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_birthchild_situatthree",  getSd_birthchild_situatthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿3娩出情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_placenta",  getDt_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎盘娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时胎儿方位2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orientfetintwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orientfetintwo",  getId_orientfetintwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时胎儿方位2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产时胎儿方位2编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_orientfetintwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_orientfetintwo",  getSd_orientfetintwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时胎儿方位2编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pla_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pla_status",  getId_pla_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pla_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pla_status",  getSd_pla_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_sexchildoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_sexchildone",  getEnum_sexchildoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿1性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_childoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_childone",  getWeight_childoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎儿1体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_childoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_childone",  getHeight_childoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿1身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1头围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHdcircu_childoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hdcircu_childone",  getHdcircu_childoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿1头围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1胸围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChest_childoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chest_childone",  getChest_childoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿1胸围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿1状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cheststatuoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cheststatuone",  getId_cheststatuoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿1状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿1状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cheststatuoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cheststatuone",  getSd_cheststatuoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿1状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_sexchildtwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_sexchildtwo",  getEnum_sexchildtwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿2性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_childtwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_childtwo",  getWeight_childtwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎儿2体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_childtwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_childtwo",  getHeight_childtwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿2身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2头围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHdcircu_childtwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hdcircu_childtwo",  getHdcircu_childtwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿2头围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2胸围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChest_childtwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chest_childtwo",  getChest_childtwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿2胸围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cheststatutwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cheststatutwo",  getId_cheststatutwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿2状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿2状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cheststatutwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cheststatutwo",  getSd_cheststatutwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿2状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_sexchildthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_sexchildthree",  getEnum_sexchildthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿3性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_childthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_childthree",  getWeight_childthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎儿3体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_childthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_childthree",  getHeight_childthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿3身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3头围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHdcircu_childthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hdcircu_childthree",  getHdcircu_childthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿3头围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3胸围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChest_childthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chest_childthree",  getChest_childthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎儿3胸围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿3状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cheststatuthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cheststatuthree",  getId_cheststatuthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿3状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿3状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cheststatuthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cheststatuthree",  getSd_cheststatuthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿3状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_laborADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_labor",  getTotal_laborCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第一产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirst_laborADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("First_labor",  getFirst_laborCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("第一产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第二产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSecond_laborADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Second_labor",  getSecond_laborCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("第二产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThird_laborADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Third_labor",  getThird_laborCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("第三产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后失血总量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bldlostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bldlost",  getNum_bldlostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后失血总量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时失血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bldlostdurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bldlostdur",  getNum_bldlostdurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产时失血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后2h失血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bldlosthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bldlosth",  getNum_bldlosthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后2h失血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后24h失血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bldtlostthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bldtlostth",  getNum_bldtlostthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后24h失血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后出血原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reasonbdlostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reasonbdlost",  getId_reasonbdlostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后出血原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产后出血原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reasonbdlostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reasonbdlost",  getSd_reasonbdlostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后出血原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后其他出血原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReasonbdlostoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reasonbdlosto",  getReasonbdlostoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后其他出血原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPost_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Post_medic",  getPost_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴破裂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perupt",  getId_peruptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴破裂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴破裂编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_peruptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perupt",  getSd_peruptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴破裂编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后血压(高)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBdpress_highADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bdpress_high",  getBdpress_highCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后血压(高)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后血压(低)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBdpress_lowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bdpress_low",  getBdpress_lowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后血压(低)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心率评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_heartADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_heart",  getEnum_heartCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心率评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_breath",  getEnum_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_tension",  getEnum_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肌张力评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 喉反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_throatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_throat",  getEnum_throatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("喉反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤颜色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnum_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enum_skincolor",  getEnum_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤颜色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_totalchildADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_totalchild",  getScore_totalchildCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断分娩小结属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChildbirth_sumaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Childbirth_sumary",  getChildbirth_sumaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断分娩小结");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagdoc",  getId_diagdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与产科护士交接情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHd_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hd_condition",  getHd_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与产科护士交接情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurseoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nurseone",  getId_nurseoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护士签名2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nursetwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nursetwo",  getId_nursetwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPla_lengthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pla_length",  getPla_lengthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘宽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPla_widthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pla_width",  getPla_widthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘宽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPla_heightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pla_height",  getPla_heightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带附着属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_umbcordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_umbcord",  getId_umbcordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脐带附着编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_umbcordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_umbcord",  getSd_umbcordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带长短属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLength_umbcordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Length_umbcord",  getLength_umbcordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脐带长短");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缠颈属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_necktwiningADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_necktwining",  getId_necktwiningCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缠颈");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 缠颈编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_necktwiningADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_necktwining",  getSd_necktwiningCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缠颈编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_amniotic_fluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_amniotic_fluid",  getId_amniotic_fluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 羊水编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_amniotic_fluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_amniotic_fluid",  getSd_amniotic_fluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_numamnfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_numamnfluid",  getId_numamnfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 羊水量编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_numamnfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_numamnfluid",  getSd_numamnfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水量编码");
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
	private IAttrDesc getColor_amnfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Color_amnfluid",  getColor_amnfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水味属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmell_amnfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smell_amnfluid",  getSmell_amnfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水味");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_surgery",  getId_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_surgery",  getSd_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 外缝针数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_needleoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_needleout",  getNum_needleoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("外缝针数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntrap_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intrap_medic",  getIntrap_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 妊娠并发症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreg_complicatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preg_complicat",  getPreg_complicatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("妊娠并发症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩并发症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirth_complicatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_complicat",  getBirth_complicatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩并发症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜完整属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnumbranecompltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enumbranecomplt",  getEnumbranecompltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎膜完整");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_signature",  getId_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 血型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodtp",  getName_bloodtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_bloodtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ruptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ruptp",  getName_ruptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_ruptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿娩出情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_birth_situatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_birth_situat",  getName_birth_situatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿娩出情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_birthchild_situat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿2娩出情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_birthchild_situattwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_birthchild_situattwo",  getName_birthchild_situattwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿2娩出情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_birthchild_situattwo=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿三娩出情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_birthchild_situatthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_birthchild_situatthree",  getName_birthchild_situatthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿三娩出情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_birthchild_situatthree=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orientfetintwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_orientfetintwo",  getName_orientfetintwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_orientfetintwo=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pla_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pla_status",  getName_pla_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_pla_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chetstatuoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chetstatuone",  getName_chetstatuoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_cheststatuone=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chetstatutwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chetstatutwo",  getName_chetstatutwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_cheststatutwo=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿死亡情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cheststatuthreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cheststatuthree",  getName_cheststatuthreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿死亡情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_cheststatuthree=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reasonbdlostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_reasonbdlost",  getName_reasonbdlostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_reasonbdlost=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_peruptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perupt",  getName_peruptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_perupt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagdoc",  getName_diagdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_diagdoc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurseoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nurseone",  getName_nurseoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_nurseone=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nursetwoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nursetwo",  getName_nursetwoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_nursetwo=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带附着名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_umbcordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_umbcord",  getName_umbcordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_umbcord=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缠颈名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_necktwiningADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_necktwining",  getName_necktwiningCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缠颈名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_necktwining=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_amniotic_fluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_amniotic_fluid",  getName_amniotic_fluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_amniotic_fluid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水量名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_numamnfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_numamnfluid",  getName_numamnfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水量名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_numamnfluid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_surgery",  getName_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_surgery=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_signature",  getName_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b26","id_signature=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取分娩登记表ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_regformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_regform");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩登记表ID"); 
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
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取孕次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_pregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_preg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("孕次"); 
		return column;
	}
	/**
	 * 获取产次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_produceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_produce");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产次"); 
		return column;
	}
	/**
	 * 获取人流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_abortionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_abortion");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("人流"); 
		return column;
	}
	/**
	 * 获取流产表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_miscarCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_miscar");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流产"); 
		return column;
	}
	/**
	 * 获取其他生产表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_pregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_preg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他生产"); 
		return column;
	}
	/**
	 * 获取产前检查次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_checkbfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_checkbf");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产前检查次数"); 
		return column;
	}
	/**
	 * 获取末次月经日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_lastmenstruCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_lastmenstru");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("末次月经日期"); 
		return column;
	}
	/**
	 * 获取预产期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_duechildCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_duechild");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预产期"); 
		return column;
	}
	/**
	 * 获取血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型"); 
		return column;
	}
	/**
	 * 获取血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型编码"); 
		return column;
	}
	/**
	 * 获取现有小孩(男)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_sonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_son");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("现有小孩(男)"); 
		return column;
	}
	/**
	 * 获取现有小孩(女)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_daughterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_daughter");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("现有小孩(女)"); 
		return column;
	}
	/**
	 * 获取过去妊娠摘要表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_pregpastCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_pregpast");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过去妊娠摘要"); 
		return column;
	}
	/**
	 * 获取阵缩起始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginmatsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_beginmats");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("阵缩起始时间"); 
		return column;
	}
	/**
	 * 获取胎膜破裂时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rupbranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rupbran");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂时间"); 
		return column;
	}
	/**
	 * 获取胎膜破裂方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ruptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ruptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂方式"); 
		return column;
	}
	/**
	 * 获取胎膜破裂方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ruptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ruptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂方式编码"); 
		return column;
	}
	/**
	 * 获取宫口开全时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cervcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cervcomp");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宫口开全时间"); 
		return column;
	}
	/**
	 * 获取胎儿1娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_orientfetintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_orientfetint");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎儿1娩出时间"); 
		return column;
	}
	/**
	 * 获取胎儿1娩出情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birthchild_situatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birthchild_situat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿1娩出情况"); 
		return column;
	}
	/**
	 * 获取胎儿1娩出情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_birthchild_situatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_birthchild_situat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿1娩出情况编码"); 
		return column;
	}
	/**
	 * 获取胎儿2娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_orientfetinttwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_orientfetinttwo");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎儿2娩出时间"); 
		return column;
	}
	/**
	 * 获取胎儿2娩出情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birthchild_situattwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birthchild_situattwo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿2娩出情况"); 
		return column;
	}
	/**
	 * 获取胎儿2娩出情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_birthchild_situattwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_birthchild_situattwo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿2娩出情况编码"); 
		return column;
	}
	/**
	 * 获取胎儿3娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_orientfetintthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_orientfetintthree");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎儿3娩出时间"); 
		return column;
	}
	/**
	 * 获取胎儿3娩出情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birthchild_situatthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birthchild_situatthree");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿3娩出情况"); 
		return column;
	}
	/**
	 * 获取胎儿3娩出情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_birthchild_situatthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_birthchild_situatthree");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿3娩出情况编码"); 
		return column;
	}
	/**
	 * 获取胎盘娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_placenta");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出时间"); 
		return column;
	}
	/**
	 * 获取产时胎儿方位2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orientfetintwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orientfetintwo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时胎儿方位2"); 
		return column;
	}
	/**
	 * 获取产时胎儿方位2编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_orientfetintwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_orientfetintwo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时胎儿方位2编码"); 
		return column;
	}
	/**
	 * 获取胎盘状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pla_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pla_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘状况"); 
		return column;
	}
	/**
	 * 获取胎盘状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pla_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pla_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘状况编码"); 
		return column;
	}
	/**
	 * 获取胎儿1性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_sexchildoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_sexchildone");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿1性别"); 
		return column;
	}
	/**
	 * 获取胎儿1体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_childoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_childone");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎儿1体重"); 
		return column;
	}
	/**
	 * 获取胎儿1身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_childoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_childone");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿1身长"); 
		return column;
	}
	/**
	 * 获取胎儿1头围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHdcircu_childoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hdcircu_childone");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿1头围"); 
		return column;
	}
	/**
	 * 获取胎儿1胸围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChest_childoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chest_childone");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿1胸围"); 
		return column;
	}
	/**
	 * 获取胎儿1状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cheststatuoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cheststatuone");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿1状态"); 
		return column;
	}
	/**
	 * 获取胎儿1状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cheststatuoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cheststatuone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿1状态编码"); 
		return column;
	}
	/**
	 * 获取胎儿2性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_sexchildtwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_sexchildtwo");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿2性别"); 
		return column;
	}
	/**
	 * 获取胎儿2体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_childtwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_childtwo");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎儿2体重"); 
		return column;
	}
	/**
	 * 获取胎儿2身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_childtwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_childtwo");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿2身长"); 
		return column;
	}
	/**
	 * 获取胎儿2头围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHdcircu_childtwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hdcircu_childtwo");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿2头围"); 
		return column;
	}
	/**
	 * 获取胎儿2胸围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChest_childtwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chest_childtwo");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿2胸围"); 
		return column;
	}
	/**
	 * 获取胎儿2状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cheststatutwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cheststatutwo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿2状态"); 
		return column;
	}
	/**
	 * 获取胎儿2状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cheststatutwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cheststatutwo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿2状态编码"); 
		return column;
	}
	/**
	 * 获取胎儿3性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_sexchildthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_sexchildthree");
		column.setLength(10);
        column.setPrecision(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿3性别"); 
		return column;
	}
	/**
	 * 获取胎儿3体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_childthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_childthree");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎儿3体重"); 
		return column;
	}
	/**
	 * 获取胎儿3身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_childthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_childthree");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿3身长"); 
		return column;
	}
	/**
	 * 获取胎儿3头围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHdcircu_childthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hdcircu_childthree");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿3头围"); 
		return column;
	}
	/**
	 * 获取胎儿3胸围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChest_childthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chest_childthree");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎儿3胸围"); 
		return column;
	}
	/**
	 * 获取胎儿3状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cheststatuthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cheststatuthree");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿3状态"); 
		return column;
	}
	/**
	 * 获取胎儿3状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cheststatuthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cheststatuthree");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿3状态编码"); 
		return column;
	}
	/**
	 * 获取总产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_laborCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_labor");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总产程"); 
		return column;
	}
	/**
	 * 获取第一产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirst_laborCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"First_labor");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("第一产程"); 
		return column;
	}
	/**
	 * 获取第二产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSecond_laborCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Second_labor");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("第二产程"); 
		return column;
	}
	/**
	 * 获取第三产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThird_laborCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Third_labor");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("第三产程"); 
		return column;
	}
	/**
	 * 获取产后失血总量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bldlostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bldlost");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后失血总量"); 
		return column;
	}
	/**
	 * 获取产时失血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bldlostdurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bldlostdur");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产时失血量"); 
		return column;
	}
	/**
	 * 获取产后2h失血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bldlosthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bldlosth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后2h失血量"); 
		return column;
	}
	/**
	 * 获取产后24h失血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bldtlostthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bldtlostth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后24h失血量"); 
		return column;
	}
	/**
	 * 获取产后出血原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reasonbdlostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reasonbdlost");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后出血原因"); 
		return column;
	}
	/**
	 * 获取产后出血原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reasonbdlostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reasonbdlost");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后出血原因编码"); 
		return column;
	}
	/**
	 * 获取产后其他出血原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReasonbdlostoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reasonbdlosto");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后其他出血原因"); 
		return column;
	}
	/**
	 * 获取产后用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPost_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Post_medic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后用药"); 
		return column;
	}
	/**
	 * 获取会阴破裂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perupt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴破裂"); 
		return column;
	}
	/**
	 * 获取会阴破裂编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_peruptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perupt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴破裂编码"); 
		return column;
	}
	/**
	 * 获取产后血压(高)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBdpress_highCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bdpress_high");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后血压(高)"); 
		return column;
	}
	/**
	 * 获取产后血压(低)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBdpress_lowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bdpress_low");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后血压(低)"); 
		return column;
	}
	/**
	 * 获取心率评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_heartCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_heart");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心率评分"); 
		return column;
	}
	/**
	 * 获取呼吸评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸评分"); 
		return column;
	}
	/**
	 * 获取肌张力评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_tension");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肌张力评分"); 
		return column;
	}
	/**
	 * 获取喉反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_throatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_throat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("喉反射"); 
		return column;
	}
	/**
	 * 获取皮肤颜色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnum_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enum_skincolor");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤颜色"); 
		return column;
	}
	/**
	 * 获取新生儿总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_totalchildCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_totalchild");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿总分"); 
		return column;
	}
	/**
	 * 获取诊断分娩小结表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChildbirth_sumaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Childbirth_sumary");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断分娩小结"); 
		return column;
	}
	/**
	 * 获取诊断医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagdoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断医生"); 
		return column;
	}
	/**
	 * 获取与产科护士交接情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHd_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hd_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与产科护士交接情况"); 
		return column;
	}
	/**
	 * 获取护士签名1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurseoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nurseone");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名1"); 
		return column;
	}
	/**
	 * 获取护士签名2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nursetwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nursetwo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名2"); 
		return column;
	}
	/**
	 * 获取胎盘长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPla_lengthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pla_length");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘长"); 
		return column;
	}
	/**
	 * 获取胎盘宽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPla_widthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pla_width");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘宽"); 
		return column;
	}
	/**
	 * 获取胎盘高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPla_heightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pla_height");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘高"); 
		return column;
	}
	/**
	 * 获取脐带附着表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_umbcordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_umbcord");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着"); 
		return column;
	}
	/**
	 * 获取脐带附着编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_umbcordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_umbcord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着编码"); 
		return column;
	}
	/**
	 * 获取脐带长短表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLength_umbcordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Length_umbcord");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脐带长短"); 
		return column;
	}
	/**
	 * 获取缠颈表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_necktwiningCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_necktwining");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缠颈"); 
		return column;
	}
	/**
	 * 获取缠颈编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_necktwiningCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_necktwining");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缠颈编码"); 
		return column;
	}
	/**
	 * 获取羊水表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_amniotic_fluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_amniotic_fluid");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水"); 
		return column;
	}
	/**
	 * 获取羊水编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_amniotic_fluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_amniotic_fluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水编码"); 
		return column;
	}
	/**
	 * 获取羊水量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_numamnfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_numamnfluid");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水量"); 
		return column;
	}
	/**
	 * 获取羊水量编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_numamnfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_numamnfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水量编码"); 
		return column;
	}
	/**
	 * 获取羊水色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getColor_amnfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Color_amnfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水色"); 
		return column;
	}
	/**
	 * 获取羊水味表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmell_amnfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smell_amnfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水味"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_surgery");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取手术名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_surgery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称编码"); 
		return column;
	}
	/**
	 * 获取外缝针数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_needleoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_needleout");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("外缝针数"); 
		return column;
	}
	/**
	 * 获取产时用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntrap_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intrap_medic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时用药"); 
		return column;
	}
	/**
	 * 获取妊娠并发症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreg_complicatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preg_complicat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("妊娠并发症"); 
		return column;
	}
	/**
	 * 获取分娩并发症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_complicatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_complicat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩并发症"); 
		return column;
	}
	/**
	 * 获取胎膜完整表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnumbranecompltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enumbranecomplt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎膜完整"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_signature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
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
	 * 获取血型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型名称"); 
		return column;
	}
	/**
	 * 获取胎膜破裂名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ruptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ruptp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂名称"); 
		return column;
	}
	/**
	 * 获取胎儿娩出情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_birth_situatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_birth_situat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿娩出情况名称"); 
		return column;
	}
	/**
	 * 获取胎儿2娩出情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_birthchild_situattwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_birthchild_situattwo");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿2娩出情况"); 
		return column;
	}
	/**
	 * 获取胎儿三娩出情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_birthchild_situatthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_birthchild_situatthree");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿三娩出情况"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orientfetintwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_orientfetintwo");
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
	private IColumnDesc getName_pla_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pla_status");
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
	private IColumnDesc getName_chetstatuoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chetstatuone");
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
	private IColumnDesc getName_chetstatutwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chetstatutwo");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取胎儿死亡情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cheststatuthreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cheststatuthree");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿死亡情况"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_reasonbdlostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_reasonbdlost");
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
	private IColumnDesc getName_peruptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perupt");
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
	private IColumnDesc getName_diagdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagdoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurseoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nurseone");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nursetwoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nursetwo");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取脐带附着名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_umbcordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_umbcord");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着名称"); 
		return column;
	}
	/**
	 * 获取缠颈名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_necktwiningCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_necktwining");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缠颈名称"); 
		return column;
	}
	/**
	 * 获取羊水名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_amniotic_fluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_amniotic_fluid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水名称"); 
		return column;
	}
	/**
	 * 获取羊水量名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_numamnfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_numamnfluid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水量名称"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_surgery");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取签名姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_signature");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名姓名"); 
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
	
}
