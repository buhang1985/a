
package iih.mp.dg.ipdgapp.d.desc;

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
 * 住院药品请领发放明细 DO 元数据信息
 */
public class IpDgApdeItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.ipdgapp.d.IpDgApdeItmDO";
	public static final String CLASS_DISPALYNAME = "住院药品请领发放明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_ip_apde_dt";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgipdt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public IpDgApdeItmDODesc(){
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
		this.setKeyDesc(getId_dgipdtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_dgipdtADesc(tblDesc));
		this.add(getId_dgipapADesc(tblDesc));
		this.add(getId_dgipdeADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_srvcaADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getFg_mmADesc(tblDesc));
		this.add(getId_unit_srvADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getId_orsrvADesc(tblDesc));
		this.add(getCharacterADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_mmtpADesc(tblDesc));
		this.add(getSd_mmtpADesc(tblDesc));
		this.add(getCode_mmADesc(tblDesc));
		this.add(getOnlycodeADesc(tblDesc));
		this.add(getName_mmADesc(tblDesc));
		this.add(getBatchnoADesc(tblDesc));
		this.add(getId_pkgu_baseADesc(tblDesc));
		this.add(getId_pkgu_curADesc(tblDesc));
		this.add(getFactorADesc(tblDesc));
		this.add(getQuan_curADesc(tblDesc));
		this.add(getPri_poADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getQuan_apADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getId_unit_medADesc(tblDesc));
		this.add(getQuan_medADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getFg_boilADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getId_boildesADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getFg_longADesc(tblDesc));
		this.add(getFg_pres_outtpADesc(tblDesc));
		this.add(getFg_wholepackADesc(tblDesc));
		this.add(getFg_or_backADesc(tblDesc));
		this.add(getDt_mp_planADesc(tblDesc));
		this.add(getOrders_orADesc(tblDesc));
		this.add(getOrders_boilADesc(tblDesc));
		this.add(getAmt_stdADesc(tblDesc));
		this.add(getDt_orADesc(tblDesc));
		this.add(getId_org_orADesc(tblDesc));
		this.add(getId_dep_orADesc(tblDesc));
		this.add(getId_emp_orADesc(tblDesc));
		this.add(getId_org_mpADesc(tblDesc));
		this.add(getId_dep_whADesc(tblDesc));
		this.add(getFg_bbADesc(tblDesc));
		this.add(getNo_bbADesc(tblDesc));
		this.add(getQuan_mpADesc(tblDesc));
		this.add(getQuan_bkADesc(tblDesc));
		this.add(getId_ipcg_relADesc(tblDesc));
		this.add(getEu_su_mpADesc(tblDesc));
		this.add(getId_emp_dispenseADesc(tblDesc));
		this.add(getEu_cg_blADesc(tblDesc));
		this.add(getId_ipcgADesc(tblDesc));
		this.add(getDt_blADesc(tblDesc));
		this.add(getDt_stADesc(tblDesc));
		this.add(getFg_otcADesc(tblDesc));
		this.add(getId_valADesc(tblDesc));
		this.add(getSd_valADesc(tblDesc));
		this.add(getCode_dgipapADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getQuan_num_baseADesc(tblDesc));
		this.add(getQuan_den_baseADesc(tblDesc));
		this.add(getId_outADesc(tblDesc));
		this.add(getDt_mm_out_confADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_pkgu_apADesc(tblDesc));
		this.add(getFactor_mbADesc(tblDesc));
		this.add(getPkuroundmodeADesc(tblDesc));
		this.add(getQuan_add_medADesc(tblDesc));
		this.add(getEn_opapADesc(tblDesc));
		this.add(getEn_opdeADesc(tblDesc));
		this.add(getFg_invalidADesc(tblDesc));
		this.add(getFg_need_opbkADesc(tblDesc));
		this.add(getFg_baseADesc(tblDesc));
		this.add(getId_out_keyADesc(tblDesc));
		this.add(getId_or_pr_srvADesc(tblDesc));
		this.add(getSpecADesc(tblDesc));
		this.add(getId_dgpresstADesc(tblDesc));
		this.add(getId_dgipdt_retADesc(tblDesc));
		this.add(getId_or_backADesc(tblDesc));
		this.add(getId_or_pr_srv_backADesc(tblDesc));
		this.add(getDt_mp_plan_backADesc(tblDesc));
		this.add(getId_or_pr_srv_cgADesc(tblDesc));
		this.add(getId_fddgipapADesc(tblDesc));
		this.add(getSd_fddgipapADesc(tblDesc));
		this.add(getEn_sendADesc(tblDesc));
		this.add(getId_chktypeADesc(tblDesc));
		this.add(getSd_chktypeADesc(tblDesc));
		this.add(getFg_ipADesc(tblDesc));
		this.add(getSd_frequnitctADesc(tblDesc));
		this.add(getSd_su_blADesc(tblDesc));
		this.add(getFddgipap_codeADesc(tblDesc));
		this.add(getFddgipap_nameADesc(tblDesc));
		this.add(getChktype_codeADesc(tblDesc));
		this.add(getChktype_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgipdtCDesc(tblDesc));
		tblDesc.add(getId_dgipdtCDesc(tblDesc));
		tblDesc.add(getId_dgipapCDesc(tblDesc));
		tblDesc.add(getId_dgipdeCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getName_srvCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_srvcaCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getFg_mmCDesc(tblDesc));
		tblDesc.add(getId_unit_srvCDesc(tblDesc));
		tblDesc.add(getCode_srvCDesc(tblDesc));
		tblDesc.add(getId_orsrvCDesc(tblDesc));
		tblDesc.add(getCharacterCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_mmtpCDesc(tblDesc));
		tblDesc.add(getSd_mmtpCDesc(tblDesc));
		tblDesc.add(getCode_mmCDesc(tblDesc));
		tblDesc.add(getOnlycodeCDesc(tblDesc));
		tblDesc.add(getName_mmCDesc(tblDesc));
		tblDesc.add(getBatchnoCDesc(tblDesc));
		tblDesc.add(getId_pkgu_baseCDesc(tblDesc));
		tblDesc.add(getId_pkgu_curCDesc(tblDesc));
		tblDesc.add(getFactorCDesc(tblDesc));
		tblDesc.add(getQuan_curCDesc(tblDesc));
		tblDesc.add(getPri_poCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getQuan_apCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getId_unit_medCDesc(tblDesc));
		tblDesc.add(getQuan_medCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getFg_boilCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getId_boildesCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getFg_longCDesc(tblDesc));
		tblDesc.add(getFg_pres_outtpCDesc(tblDesc));
		tblDesc.add(getFg_wholepackCDesc(tblDesc));
		tblDesc.add(getFg_or_backCDesc(tblDesc));
		tblDesc.add(getDt_mp_planCDesc(tblDesc));
		tblDesc.add(getOrders_orCDesc(tblDesc));
		tblDesc.add(getOrders_boilCDesc(tblDesc));
		tblDesc.add(getAmt_stdCDesc(tblDesc));
		tblDesc.add(getDt_orCDesc(tblDesc));
		tblDesc.add(getId_org_orCDesc(tblDesc));
		tblDesc.add(getId_dep_orCDesc(tblDesc));
		tblDesc.add(getId_emp_orCDesc(tblDesc));
		tblDesc.add(getId_org_mpCDesc(tblDesc));
		tblDesc.add(getId_dep_whCDesc(tblDesc));
		tblDesc.add(getFg_bbCDesc(tblDesc));
		tblDesc.add(getNo_bbCDesc(tblDesc));
		tblDesc.add(getQuan_mpCDesc(tblDesc));
		tblDesc.add(getQuan_bkCDesc(tblDesc));
		tblDesc.add(getId_ipcg_relCDesc(tblDesc));
		tblDesc.add(getEu_su_mpCDesc(tblDesc));
		tblDesc.add(getId_emp_dispenseCDesc(tblDesc));
		tblDesc.add(getEu_cg_blCDesc(tblDesc));
		tblDesc.add(getId_ipcgCDesc(tblDesc));
		tblDesc.add(getDt_blCDesc(tblDesc));
		tblDesc.add(getDt_stCDesc(tblDesc));
		tblDesc.add(getFg_otcCDesc(tblDesc));
		tblDesc.add(getId_valCDesc(tblDesc));
		tblDesc.add(getSd_valCDesc(tblDesc));
		tblDesc.add(getCode_dgipapCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getQuan_num_baseCDesc(tblDesc));
		tblDesc.add(getQuan_den_baseCDesc(tblDesc));
		tblDesc.add(getId_outCDesc(tblDesc));
		tblDesc.add(getDt_mm_out_confCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_pkgu_apCDesc(tblDesc));
		tblDesc.add(getFactor_mbCDesc(tblDesc));
		tblDesc.add(getPkuroundmodeCDesc(tblDesc));
		tblDesc.add(getQuan_add_medCDesc(tblDesc));
		tblDesc.add(getEn_opapCDesc(tblDesc));
		tblDesc.add(getEn_opdeCDesc(tblDesc));
		tblDesc.add(getFg_invalidCDesc(tblDesc));
		tblDesc.add(getFg_need_opbkCDesc(tblDesc));
		tblDesc.add(getFg_baseCDesc(tblDesc));
		tblDesc.add(getId_out_keyCDesc(tblDesc));
		tblDesc.add(getId_or_pr_srvCDesc(tblDesc));
		tblDesc.add(getSpecCDesc(tblDesc));
		tblDesc.add(getId_dgpresstCDesc(tblDesc));
		tblDesc.add(getId_dgipdt_retCDesc(tblDesc));
		tblDesc.add(getId_or_backCDesc(tblDesc));
		tblDesc.add(getId_or_pr_srv_backCDesc(tblDesc));
		tblDesc.add(getDt_mp_plan_backCDesc(tblDesc));
		tblDesc.add(getId_or_pr_srv_cgCDesc(tblDesc));
		tblDesc.add(getId_fddgipapCDesc(tblDesc));
		tblDesc.add(getSd_fddgipapCDesc(tblDesc));
		tblDesc.add(getEn_sendCDesc(tblDesc));
		tblDesc.add(getId_chktypeCDesc(tblDesc));
		tblDesc.add(getSd_chktypeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院药品请领发放明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipdtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipdt",  getId_dgipdtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院药品请领发放明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院药品请领主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipap",  getId_dgipapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院药品请领主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院药品发放主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipde",  getId_dgipdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院药品发放主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(false);
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
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp",  getId_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvca",  getId_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvtp",  getId_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mm",  getFg_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("物品标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_srv",  getId_unit_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orsrv",  getId_orsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品特性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharacterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Character",  getCharacterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品特性");
		attrDesc.setNullable(true);
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
	 * 物品类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmtp",  getId_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmtp",  getSd_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mm",  getCode_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOnlycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Onlycode",  getOnlycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品唯一码");
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
	private IAttrDesc getName_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mm",  getName_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品批次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBatchnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Batchno",  getBatchnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品批次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品包装单位_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgu_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgu_base",  getId_pkgu_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品包装单位_基本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品包装单位_当前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgu_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgu_cur",  getId_pkgu_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品包装单位_当前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 换算系数(基当)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor",  getFactorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数(基当)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_当前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_cur",  getQuan_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量_当前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进价_零售属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_poADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_po",  getPri_poCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进价_零售");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领实际数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_ap",  getQuan_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("请领实际数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_med",  getId_unit_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数值_医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_med",  getQuan_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数值_医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否代煎属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_boil",  getFg_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否代煎");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boil",  getId_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 剪法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boildesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boildes",  getId_boildesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剪法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 长临标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_longADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_long",  getFg_longCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("长临标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院带药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pres_outtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pres_outtp",  getFg_pres_outtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("出院带药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在院整领标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_wholepackADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_wholepack",  getFg_wholepackCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("在院整领标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退药医嘱标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_or_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_or_back",  getFg_or_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("退药医嘱标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 医嘱付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrders_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Orders_or",  getOrders_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 代煎付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrders_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Orders_boil",  getOrders_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("代煎付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_stdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_std",  getAmt_stdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标准金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_or",  getDt_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开立时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_or",  getId_org_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_or",  getId_dep_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_or",  getId_emp_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_mp",  getId_org_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 库房属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_wh",  getId_dep_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库房");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婴儿标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bb",  getFg_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("婴儿标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_bb",  getNo_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("婴儿序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已发药数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_mp",  getQuan_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("已发药数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已退药数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_bkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_bk",  getQuan_bkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("已退药数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费关联记账主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ipcg_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ipcg_rel",  getId_ipcg_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费关联记账主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发药状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_su_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_su_mp",  getEu_su_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("发药状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发药人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_dispenseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_dispense",  getId_emp_dispenseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发药人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 费用状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cg_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cg_bl",  getEu_cg_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("费用状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院记账属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ipcgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ipcg",  getId_ipcgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院记账");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记账日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_bl",  getDt_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记账日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_st",  getDt_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结算日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * otc标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_otcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_otc",  getFg_otcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("otc标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价值分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_val",  getId_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价值分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 价值分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_val",  getSd_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("价值分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dgipap",  getCode_dgipapCDesc(tblDesc), this);
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
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
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
	 * 数量分子_基本包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_num_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_num_base",  getQuan_num_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量分子_基本包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量分母_基本包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_den_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_den_base",  getQuan_den_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量分母_基本包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_out",  getId_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出库时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mm_out_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mm_out_conf",  getDt_mm_out_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出库时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgu_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgu_ap",  getId_pkgu_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 换算系数(医基)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_mbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_mb",  getFactor_mbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数(医基)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品取整模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkuroundmodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkuroundmode",  getPkuroundmodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品取整模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区合用分担_医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_add_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_add_med",  getQuan_add_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("病区合用分担_医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领处理状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_opapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_opap",  getEn_opapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("请领处理状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发放处理状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_opdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_opde",  getEn_opdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("发放处理状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 作废标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_invalidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_invalid",  getFg_invalidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("作废标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需退药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_need_opbkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_need_opbk",  getFg_need_opbkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("需退药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基数药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_base",  getFg_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("基数药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退药关联主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_out_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_out_key",  getId_out_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退药关联主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱服务执行点主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_pr_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr_srv",  getId_or_pr_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱服务执行点主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spec",  getSpecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方执行状态主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgpresstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgpresst",  getId_dgpresstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方执行状态主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退药原数据主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipdt_retADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipdt_ret",  getId_dgipdt_retCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退药原数据主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退药医嘱主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_back",  getId_or_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退药医嘱主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退药医嘱服务执行点主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_pr_srv_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr_srv_back",  getId_or_pr_srv_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退药医嘱服务执行点主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退药医嘱计划执行时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mp_plan_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mp_plan_back",  getDt_mp_plan_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("退药医嘱计划执行时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计费医嘱执行点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_pr_srv_cgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr_srv_cg",  getId_or_pr_srv_cgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计费医嘱执行点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首日摆药状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fddgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fddgipap",  getId_fddgipapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("首日摆药状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 首日摆药状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fddgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fddgipap",  getSd_fddgipapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("首日摆药状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发送状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_sendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_send",  getEn_sendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("发送状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chktypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chktype",  getId_chktypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 异常类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chktypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chktype",  getSd_chktypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在院标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ip",  getFg_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("在院标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b7","id_ent=id_ent","fg_ip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次周期类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_frequnitctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_frequnitct",  getSd_frequnitctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次周期类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a0b23","id_freq=id_freq","sd_frequnitct"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_bl",  getSd_su_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"MP_OR_PR_SRV a0b41","id_or_pr_srv=id_or_pr_srv","sd_su_bl"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFddgipap_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fddgipap_code",  getFddgipap_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_fddgipap=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFddgipap_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fddgipap_name",  getFddgipap_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_fddgipap=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChktype_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chktype_code",  getChktype_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_chktype=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChktype_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chktype_name",  getChktype_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_chktype=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取住院药品请领发放明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipdtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipdt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院药品请领发放明细主键标识"); 
		return column;
	}
	/**
	 * 获取住院药品请领主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院药品请领主键"); 
		return column;
	}
	/**
	 * 获取住院药品发放主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipde");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院药品发放主键"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
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
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
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
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取服务项目类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目类型编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
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
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取服务项目分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目分类"); 
		return column;
	}
	/**
	 * 获取服务项目类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目类型"); 
		return column;
	}
	/**
	 * 获取物品标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("物品标识"); 
		return column;
	}
	/**
	 * 获取服务项目单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目单位"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取医嘱服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱服务"); 
		return column;
	}
	/**
	 * 获取物品特性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharacterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Character");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品特性"); 
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
	 * 获取物品类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品类型"); 
		return column;
	}
	/**
	 * 获取物品类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品类型编码"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品编码"); 
		return column;
	}
	/**
	 * 获取物品唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOnlycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Onlycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品唯一码"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mm");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取物品批次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBatchnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Batchno");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品批次"); 
		return column;
	}
	/**
	 * 获取物品包装单位_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgu_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgu_base");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品包装单位_基本"); 
		return column;
	}
	/**
	 * 获取物品包装单位_当前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgu_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgu_cur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品包装单位_当前"); 
		return column;
	}
	/**
	 * 获取换算系数(基当)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数(基当)"); 
		return column;
	}
	/**
	 * 获取数量_当前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_cur");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量_当前"); 
		return column;
	}
	/**
	 * 获取进价_零售表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_poCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_po");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进价_零售"); 
		return column;
	}
	/**
	 * 获取单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单价"); 
		return column;
	}
	/**
	 * 获取请领实际数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_ap");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("请领实际数量"); 
		return column;
	}
	/**
	 * 获取金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_med");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医学单位"); 
		return column;
	}
	/**
	 * 获取数值_医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_med");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数值_医学单位"); 
		return column;
	}
	/**
	 * 获取用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法编码"); 
		return column;
	}
	/**
	 * 获取用法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法要求"); 
		return column;
	}
	/**
	 * 获取是否代煎表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_boil");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否代煎"); 
		return column;
	}
	/**
	 * 获取煎法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boil");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法"); 
		return column;
	}
	/**
	 * 获取剪法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boildesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boildes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剪法要求"); 
		return column;
	}
	/**
	 * 获取服务频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务频次"); 
		return column;
	}
	/**
	 * 获取长临标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_longCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_long");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("长临标识"); 
		return column;
	}
	/**
	 * 获取出院带药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pres_outtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pres_outtp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院带药标识"); 
		return column;
	}
	/**
	 * 获取在院整领标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_wholepackCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_wholepack");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("在院整领标识"); 
		return column;
	}
	/**
	 * 获取退药医嘱标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_or_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_or_back");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退药医嘱标识"); 
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
	 * 获取医嘱付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrders_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Orders_or");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱付数"); 
		return column;
	}
	/**
	 * 获取代煎付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrders_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Orders_boil");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("代煎付数"); 
		return column;
	}
	/**
	 * 获取标准金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_stdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_std");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标准金额"); 
		return column;
	}
	/**
	 * 获取开立时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_or");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开立时间"); 
		return column;
	}
	/**
	 * 获取开立机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立机构"); 
		return column;
	}
	/**
	 * 获取开立科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立科室"); 
		return column;
	}
	/**
	 * 获取开立医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立医生"); 
		return column;
	}
	/**
	 * 获取执行机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行机构"); 
		return column;
	}
	/**
	 * 获取库房表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库房"); 
		return column;
	}
	/**
	 * 获取婴儿标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bb");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("婴儿标识"); 
		return column;
	}
	/**
	 * 获取婴儿序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_bb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("婴儿序号"); 
		return column;
	}
	/**
	 * 获取已发药数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_mp");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("已发药数量"); 
		return column;
	}
	/**
	 * 获取已退药数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_bk");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("已退药数量"); 
		return column;
	}
	/**
	 * 获取退费关联记账主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ipcg_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ipcg_rel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费关联记账主键标识"); 
		return column;
	}
	/**
	 * 获取发药状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_su_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_su_mp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("发药状态"); 
		return column;
	}
	/**
	 * 获取发药人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_dispenseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_dispense");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发药人"); 
		return column;
	}
	/**
	 * 获取费用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cg_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cg_bl");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("费用状态"); 
		return column;
	}
	/**
	 * 获取住院记账表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ipcgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ipcg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院记账"); 
		return column;
	}
	/**
	 * 获取记账日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_bl");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记账日期"); 
		return column;
	}
	/**
	 * 获取结算日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_st");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结算日期"); 
		return column;
	}
	/**
	 * 获取otc标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_otcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_otc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("otc标识"); 
		return column;
	}
	/**
	 * 获取价值分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_val");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价值分类"); 
		return column;
	}
	/**
	 * 获取价值分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("价值分类编码"); 
		return column;
	}
	/**
	 * 获取请领单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dgipap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领单号"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(1000);
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
	 * 获取数量分子_基本包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_num_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_num_base");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量分子_基本包装"); 
		return column;
	}
	/**
	 * 获取数量分母_基本包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_den_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_den_base");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量分母_基本包装"); 
		return column;
	}
	/**
	 * 获取出库单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_out");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出库单号"); 
		return column;
	}
	/**
	 * 获取出库时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mm_out_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mm_out_conf");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出库时间"); 
		return column;
	}
	/**
	 * 获取开立病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立病区"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取请领包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgu_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgu_ap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领包装单位"); 
		return column;
	}
	/**
	 * 获取换算系数(医基)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_mbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_mb");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数(医基)"); 
		return column;
	}
	/**
	 * 获取药品取整模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkuroundmodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkuroundmode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品取整模式"); 
		return column;
	}
	/**
	 * 获取病区合用分担_医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_add_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_add_med");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("病区合用分担_医学单位"); 
		return column;
	}
	/**
	 * 获取请领处理状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_opapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_opap");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("请领处理状态"); 
		return column;
	}
	/**
	 * 获取发放处理状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_opdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_opde");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("发放处理状态"); 
		return column;
	}
	/**
	 * 获取作废标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_invalidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_invalid");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("作废标识"); 
		return column;
	}
	/**
	 * 获取需退药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_need_opbkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_need_opbk");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("需退药标识"); 
		return column;
	}
	/**
	 * 获取基数药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_base");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("基数药标识"); 
		return column;
	}
	/**
	 * 获取退药关联主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_out_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_out_key");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退药关联主键"); 
		return column;
	}
	/**
	 * 获取医嘱服务执行点主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_pr_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱服务执行点主键"); 
		return column;
	}
	/**
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规格"); 
		return column;
	}
	/**
	 * 获取处方执行状态主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgpresstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgpresst");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方执行状态主键"); 
		return column;
	}
	/**
	 * 获取退药原数据主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipdt_retCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipdt_ret");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退药原数据主键"); 
		return column;
	}
	/**
	 * 获取退药医嘱主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_back");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退药医嘱主键"); 
		return column;
	}
	/**
	 * 获取退药医嘱服务执行点主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_pr_srv_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr_srv_back");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退药医嘱服务执行点主键"); 
		return column;
	}
	/**
	 * 获取退药医嘱计划执行时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mp_plan_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mp_plan_back");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退药医嘱计划执行时间"); 
		return column;
	}
	/**
	 * 获取计费医嘱执行点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_pr_srv_cgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr_srv_cg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计费医嘱执行点"); 
		return column;
	}
	/**
	 * 获取首日摆药状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fddgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fddgipap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("首日摆药状态"); 
		return column;
	}
	/**
	 * 获取首日摆药状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fddgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fddgipap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("首日摆药状态编码"); 
		return column;
	}
	/**
	 * 获取发送状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_sendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_send");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("发送状态"); 
		return column;
	}
	/**
	 * 获取异常类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chktypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chktype");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常类型"); 
		return column;
	}
	/**
	 * 获取异常类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chktypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chktype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常类型编码"); 
		return column;
	}
	/**
	 * 获取在院标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ip");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("在院标志"); 
		return column;
	}
	/**
	 * 获取频次周期类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_frequnitctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_frequnitct");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次周期类型编码"); 
		return column;
	}
	/**
	 * 获取记账状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_bl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账状态编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFddgipap_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fddgipap_code");
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
	private IColumnDesc getFddgipap_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fddgipap_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取异常类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChktype_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chktype_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常类型编码"); 
		return column;
	}
	/**
	 * 获取异常类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChktype_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chktype_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常类型名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_dgipdt");
		iBDDataInfoFldMap.put("pid","Id_dgipap");
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
		defaultValueMap.put("Fg_invalid",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_need_opbk",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
