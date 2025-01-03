
package iih.sfda.aer.sfdaaerevps.d.desc;

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
 * 压疮事件 DO 元数据信息
 */
public class SfdaAerEvPsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevps.d.SfdaAerEvPsDO";
	public static final String CLASS_DISPALYNAME = "压疮事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_PS";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_ps";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvPsDODesc(){
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
		this.setKeyDesc(getId_aer_ev_psADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_psADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_psrpt_tpADesc(tblDesc));
		this.add(getSd_psrpt_tpADesc(tblDesc));
		this.add(getId_psassADesc(tblDesc));
		this.add(getSd_psassADesc(tblDesc));
		this.add(getDt_occurADesc(tblDesc));
		this.add(getDt_findADesc(tblDesc));
		this.add(getId_psin_msADesc(tblDesc));
		this.add(getSd_psin_msADesc(tblDesc));
		this.add(getOth_psin_msADesc(tblDesc));
		this.add(getId_feel_pwADesc(tblDesc));
		this.add(getSd_feel_pwADesc(tblDesc));
		this.add(getOth_feel_pwADesc(tblDesc));
		this.add(getId_hmdADesc(tblDesc));
		this.add(getSd_hmdADesc(tblDesc));
		this.add(getOth_hmdADesc(tblDesc));
		this.add(getId_act_pwADesc(tblDesc));
		this.add(getSd_act_pwADesc(tblDesc));
		this.add(getOth_act_pwADesc(tblDesc));
		this.add(getId_move_pwADesc(tblDesc));
		this.add(getSd_move_pwADesc(tblDesc));
		this.add(getOth_move_pwADesc(tblDesc));
		this.add(getId_ntr_sptADesc(tblDesc));
		this.add(getSd_ntr_sptADesc(tblDesc));
		this.add(getOth_ntr_sptADesc(tblDesc));
		this.add(getId_fcefrADesc(tblDesc));
		this.add(getSd_fcefrADesc(tblDesc));
		this.add(getOth_fcefrADesc(tblDesc));
		this.add(getTot_scoreADesc(tblDesc));
		this.add(getId_oxyADesc(tblDesc));
		this.add(getSd_oxyADesc(tblDesc));
		this.add(getOth_oxyADesc(tblDesc));
		this.add(getId_grlcADesc(tblDesc));
		this.add(getSd_grlcADesc(tblDesc));
		this.add(getOth_grlcADesc(tblDesc));
		this.add(getEu_ps_surADesc(tblDesc));
		this.add(getId_ps_stgADesc(tblDesc));
		this.add(getSd_ps_stgADesc(tblDesc));
		this.add(getId_oldps_surADesc(tblDesc));
		this.add(getSd_oldps_surADesc(tblDesc));
		this.add(getId_ps_ptyADesc(tblDesc));
		this.add(getSd_ps_ptyADesc(tblDesc));
		this.add(getOth_ps_ptyADesc(tblDesc));
		this.add(getArea_psADesc(tblDesc));
		this.add(getId_ps_ntADesc(tblDesc));
		this.add(getSd_ps_ntADesc(tblDesc));
		this.add(getFg_smo_wthADesc(tblDesc));
		this.add(getFg_in_icuADesc(tblDesc));
		this.add(getFg_fill_psADesc(tblDesc));
		this.add(getFg_sugADesc(tblDesc));
		this.add(getDt_sugADesc(tblDesc));
		this.add(getId_sug_nrsADesc(tblDesc));
		this.add(getSd_sug_nrsADesc(tblDesc));
		this.add(getId_sug_ptyADesc(tblDesc));
		this.add(getSd_sug_ptyADesc(tblDesc));
		this.add(getOtr_sug_ptyADesc(tblDesc));
		this.add(getFg_ps_csADesc(tblDesc));
		this.add(getExt1ADesc(tblDesc));
		this.add(getExt2ADesc(tblDesc));
		this.add(getExt3ADesc(tblDesc));
		this.add(getExt4ADesc(tblDesc));
		this.add(getExt5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_psrpt_tpADesc(tblDesc));
		this.add(getName_psassADesc(tblDesc));
		this.add(getName_psin_msADesc(tblDesc));
		this.add(getName_feel_pwADesc(tblDesc));
		this.add(getName_hmdADesc(tblDesc));
		this.add(getName_act_pwADesc(tblDesc));
		this.add(getName_move_pwADesc(tblDesc));
		this.add(getName_ntr_sptADesc(tblDesc));
		this.add(getName_fcefrADesc(tblDesc));
		this.add(getName_oxyADesc(tblDesc));
		this.add(getName_grlcADesc(tblDesc));
		this.add(getName_ps_stgADesc(tblDesc));
		this.add(getName_oldps_surADesc(tblDesc));
		this.add(getName_ps_ptyADesc(tblDesc));
		this.add(getName_ps_ntADesc(tblDesc));
		this.add(getName_sug_nrsADesc(tblDesc));
		this.add(getName_sug_ptyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_psCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_psCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_psrpt_tpCDesc(tblDesc));
		tblDesc.add(getSd_psrpt_tpCDesc(tblDesc));
		tblDesc.add(getId_psassCDesc(tblDesc));
		tblDesc.add(getSd_psassCDesc(tblDesc));
		tblDesc.add(getDt_occurCDesc(tblDesc));
		tblDesc.add(getDt_findCDesc(tblDesc));
		tblDesc.add(getId_psin_msCDesc(tblDesc));
		tblDesc.add(getSd_psin_msCDesc(tblDesc));
		tblDesc.add(getOth_psin_msCDesc(tblDesc));
		tblDesc.add(getId_feel_pwCDesc(tblDesc));
		tblDesc.add(getSd_feel_pwCDesc(tblDesc));
		tblDesc.add(getOth_feel_pwCDesc(tblDesc));
		tblDesc.add(getId_hmdCDesc(tblDesc));
		tblDesc.add(getSd_hmdCDesc(tblDesc));
		tblDesc.add(getOth_hmdCDesc(tblDesc));
		tblDesc.add(getId_act_pwCDesc(tblDesc));
		tblDesc.add(getSd_act_pwCDesc(tblDesc));
		tblDesc.add(getOth_act_pwCDesc(tblDesc));
		tblDesc.add(getId_move_pwCDesc(tblDesc));
		tblDesc.add(getSd_move_pwCDesc(tblDesc));
		tblDesc.add(getOth_move_pwCDesc(tblDesc));
		tblDesc.add(getId_ntr_sptCDesc(tblDesc));
		tblDesc.add(getSd_ntr_sptCDesc(tblDesc));
		tblDesc.add(getOth_ntr_sptCDesc(tblDesc));
		tblDesc.add(getId_fcefrCDesc(tblDesc));
		tblDesc.add(getSd_fcefrCDesc(tblDesc));
		tblDesc.add(getOth_fcefrCDesc(tblDesc));
		tblDesc.add(getTot_scoreCDesc(tblDesc));
		tblDesc.add(getId_oxyCDesc(tblDesc));
		tblDesc.add(getSd_oxyCDesc(tblDesc));
		tblDesc.add(getOth_oxyCDesc(tblDesc));
		tblDesc.add(getId_grlcCDesc(tblDesc));
		tblDesc.add(getSd_grlcCDesc(tblDesc));
		tblDesc.add(getOth_grlcCDesc(tblDesc));
		tblDesc.add(getEu_ps_surCDesc(tblDesc));
		tblDesc.add(getId_ps_stgCDesc(tblDesc));
		tblDesc.add(getSd_ps_stgCDesc(tblDesc));
		tblDesc.add(getId_oldps_surCDesc(tblDesc));
		tblDesc.add(getSd_oldps_surCDesc(tblDesc));
		tblDesc.add(getId_ps_ptyCDesc(tblDesc));
		tblDesc.add(getSd_ps_ptyCDesc(tblDesc));
		tblDesc.add(getOth_ps_ptyCDesc(tblDesc));
		tblDesc.add(getArea_psCDesc(tblDesc));
		tblDesc.add(getId_ps_ntCDesc(tblDesc));
		tblDesc.add(getSd_ps_ntCDesc(tblDesc));
		tblDesc.add(getFg_smo_wthCDesc(tblDesc));
		tblDesc.add(getFg_in_icuCDesc(tblDesc));
		tblDesc.add(getFg_fill_psCDesc(tblDesc));
		tblDesc.add(getFg_sugCDesc(tblDesc));
		tblDesc.add(getDt_sugCDesc(tblDesc));
		tblDesc.add(getId_sug_nrsCDesc(tblDesc));
		tblDesc.add(getSd_sug_nrsCDesc(tblDesc));
		tblDesc.add(getId_sug_ptyCDesc(tblDesc));
		tblDesc.add(getSd_sug_ptyCDesc(tblDesc));
		tblDesc.add(getOtr_sug_ptyCDesc(tblDesc));
		tblDesc.add(getFg_ps_csCDesc(tblDesc));
		tblDesc.add(getExt1CDesc(tblDesc));
		tblDesc.add(getExt2CDesc(tblDesc));
		tblDesc.add(getExt3CDesc(tblDesc));
		tblDesc.add(getExt4CDesc(tblDesc));
		tblDesc.add(getExt5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 压疮事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_psADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_ps",  getId_aer_ev_psCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理安全外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理安全外键");
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
	 * 压疮上报类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psrpt_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psrpt_tp",  getId_psrpt_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮上报类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮上报类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psrpt_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psrpt_tp",  getSd_psrpt_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮上报类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮评估表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psass",  getId_psassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮评估表id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮评估表属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psass",  getSd_psassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮评估表");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮发生时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_occurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_occur",  getDt_occurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("压疮发生时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮发现时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_findADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_find",  getDt_findCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("压疮发现时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮干预措施id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psin_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psin_ms",  getId_psin_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮干预措施id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮干预措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psin_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psin_ms",  getSd_psin_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮干预措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮其他干预措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_psin_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_psin_ms",  getOth_psin_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮其他干预措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感知能力id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_feel_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_feel_pw",  getId_feel_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知能力id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感知能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_feel_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_feel_pw",  getSd_feel_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感知能力分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_feel_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_feel_pw",  getOth_feel_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("感知能力分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮湿度id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hmd",  getId_hmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿度id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 潮湿度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hmd",  getSd_hmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮湿度分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_hmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_hmd",  getOth_hmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("潮湿度分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动能力id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_act_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_act_pw",  getId_act_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动能力id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_act_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_act_pw",  getSd_act_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动能力分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_act_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_act_pw",  getOth_act_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("活动能力分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动能力id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_move_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_move_pw",  getId_move_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动能力id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 移动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_move_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_move_pw",  getSd_move_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动能力分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_move_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_move_pw",  getOth_move_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("移动能力分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养支持id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ntr_sptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ntr_spt",  getId_ntr_sptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养支持id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 营养支持属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ntr_sptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ntr_spt",  getSd_ntr_sptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养支持");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养支持分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_ntr_sptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_ntr_spt",  getOth_ntr_sptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("营养支持分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fcefrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fcefr",  getId_fcefrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fcefrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fcefr",  getSd_fcefrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_fcefrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_fcefr",  getOth_fcefrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("摩擦力和剪切力分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评分总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTot_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tot_score",  getTot_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("评分总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织灌注氧合id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oxy",  getId_oxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织灌注氧合id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织灌注氧合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oxy",  getSd_oxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织灌注氧合");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织灌注氧合分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_oxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_oxy",  getOth_oxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("组织灌注氧合分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一般情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grlcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grlc",  getId_grlcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("一般情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 一般情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_grlcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_grlc",  getSd_grlcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("一般情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一般情况分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_grlcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_grlc",  getOth_grlcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("一般情况分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者压疮来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ps_surADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ps_sur",  getEu_ps_surCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者压疮来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮分期id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ps_stgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ps_stg",  getId_ps_stgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮分期id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮分期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ps_stgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ps_stg",  getSd_ps_stgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮分期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院前已有压疮来源id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oldps_surADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oldps_sur",  getId_oldps_surCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院前已有压疮来源id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院前已有压疮来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oldps_surADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oldps_sur",  getSd_oldps_surCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院前已有压疮来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮部位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ps_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ps_pty",  getId_ps_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮部位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ps_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ps_pty",  getSd_ps_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮其他部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_ps_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_ps_pty",  getOth_ps_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮其他部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮面积属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getArea_psADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Area_ps",  getArea_psCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("压疮面积");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮性质id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ps_ntADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ps_nt",  getId_ps_ntCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮性质id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ps_ntADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ps_nt",  getSd_ps_ntCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有人看护属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_smo_wthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_smo_wth",  getFg_smo_wthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否有人看护");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否入住ICU属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_in_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_in_icu",  getFg_in_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否入住ICU");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否填报过高危压疮或难免压疮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_fill_psADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fill_ps",  getFg_fill_psCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否填报过高危压疮或难免压疮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sug",  getFg_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_sug",  getDt_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中麻醉id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sug_nrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sug_nrs",  getId_sug_nrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中麻醉id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中麻醉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sug_nrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sug_nrs",  getSd_sug_nrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中麻醉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术体位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sug_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sug_pty",  getId_sug_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术体位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sug_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sug_pty",  getSd_sug_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他手术体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtr_sug_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Otr_sug_pty",  getOtr_sug_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他手术体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否请压疮会诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ps_csADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ps_cs",  getFg_ps_csCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否请压疮会诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext1",  getExt1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext2",  getExt2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext3",  getExt3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext4",  getExt4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext5",  getExt5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段5");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psrpt_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psrpt_tp",  getName_psrpt_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_psrpt_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psass",  getName_psassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_psass=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psin_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psin_ms",  getName_psin_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_psin_ms=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_feel_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_feel_pw",  getName_feel_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_feel_pw=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hmd",  getName_hmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_hmd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_act_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_act_pw",  getName_act_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_act_pw=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_move_pwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_move_pw",  getName_move_pwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_move_pw=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ntr_sptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ntr_spt",  getName_ntr_sptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_ntr_spt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fcefrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fcefr",  getName_fcefrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_fcefr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oxy",  getName_oxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_oxy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grlcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grlc",  getName_grlcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_grlc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ps_stgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ps_stg",  getName_ps_stgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_ps_stg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oldps_surADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oldps_sur",  getName_oldps_surCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_oldps_sur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ps_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ps_pty",  getName_ps_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_ps_pty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ps_ntADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ps_nt",  getName_ps_ntCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_ps_nt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sug_nrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sug_nrs",  getName_sug_nrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_sug_nrs=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sug_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sug_pty",  getName_sug_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_sug_pty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取压疮事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_psCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_ps");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("压疮事件主键"); 
		return column;
	}
	/**
	 * 获取护理安全外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理安全外键"); 
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
	 * 获取压疮上报类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psrpt_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psrpt_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮上报类型id"); 
		return column;
	}
	/**
	 * 获取压疮上报类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psrpt_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psrpt_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮上报类型"); 
		return column;
	}
	/**
	 * 获取压疮评估表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psass");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮评估表id"); 
		return column;
	}
	/**
	 * 获取压疮评估表表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psass");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮评估表"); 
		return column;
	}
	/**
	 * 获取压疮发生时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_occurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_occur");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("压疮发生时间"); 
		return column;
	}
	/**
	 * 获取压疮发现时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_findCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_find");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("压疮发现时间"); 
		return column;
	}
	/**
	 * 获取压疮干预措施id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psin_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psin_ms");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮干预措施id"); 
		return column;
	}
	/**
	 * 获取压疮干预措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psin_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psin_ms");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮干预措施"); 
		return column;
	}
	/**
	 * 获取压疮其他干预措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_psin_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_psin_ms");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮其他干预措施"); 
		return column;
	}
	/**
	 * 获取感知能力id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_feel_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_feel_pw");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知能力id"); 
		return column;
	}
	/**
	 * 获取感知能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_feel_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_feel_pw");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知能力"); 
		return column;
	}
	/**
	 * 获取感知能力分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_feel_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_feel_pw");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("感知能力分数"); 
		return column;
	}
	/**
	 * 获取潮湿度id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hmd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿度id"); 
		return column;
	}
	/**
	 * 获取潮湿度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿度"); 
		return column;
	}
	/**
	 * 获取潮湿度分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_hmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_hmd");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("潮湿度分数"); 
		return column;
	}
	/**
	 * 获取活动能力id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_act_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_act_pw");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动能力id"); 
		return column;
	}
	/**
	 * 获取活动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_act_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_act_pw");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动能力"); 
		return column;
	}
	/**
	 * 获取活动能力分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_act_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_act_pw");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("活动能力分数"); 
		return column;
	}
	/**
	 * 获取移动能力id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_move_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_move_pw");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动能力id"); 
		return column;
	}
	/**
	 * 获取移动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_move_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_move_pw");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动能力"); 
		return column;
	}
	/**
	 * 获取移动能力分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_move_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_move_pw");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("移动能力分数"); 
		return column;
	}
	/**
	 * 获取营养支持id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ntr_sptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ntr_spt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养支持id"); 
		return column;
	}
	/**
	 * 获取营养支持表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ntr_sptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ntr_spt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养支持"); 
		return column;
	}
	/**
	 * 获取营养支持分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_ntr_sptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_ntr_spt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("营养支持分数"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fcefrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fcefr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力id"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fcefrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fcefr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_fcefrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_fcefr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力分数"); 
		return column;
	}
	/**
	 * 获取评分总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTot_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tot_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("评分总分"); 
		return column;
	}
	/**
	 * 获取组织灌注氧合id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oxy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织灌注氧合id"); 
		return column;
	}
	/**
	 * 获取组织灌注氧合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oxy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织灌注氧合"); 
		return column;
	}
	/**
	 * 获取组织灌注氧合分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_oxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_oxy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("组织灌注氧合分数"); 
		return column;
	}
	/**
	 * 获取一般情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grlcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grlc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("一般情况id"); 
		return column;
	}
	/**
	 * 获取一般情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_grlcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_grlc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("一般情况"); 
		return column;
	}
	/**
	 * 获取一般情况分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_grlcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_grlc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("一般情况分数"); 
		return column;
	}
	/**
	 * 获取患者压疮来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ps_surCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ps_sur");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者压疮来源"); 
		return column;
	}
	/**
	 * 获取压疮分期id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ps_stgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ps_stg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮分期id"); 
		return column;
	}
	/**
	 * 获取压疮分期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ps_stgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ps_stg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮分期"); 
		return column;
	}
	/**
	 * 获取入院前已有压疮来源id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oldps_surCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oldps_sur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院前已有压疮来源id"); 
		return column;
	}
	/**
	 * 获取入院前已有压疮来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oldps_surCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oldps_sur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院前已有压疮来源"); 
		return column;
	}
	/**
	 * 获取压疮部位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ps_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ps_pty");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮部位id"); 
		return column;
	}
	/**
	 * 获取压疮部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ps_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ps_pty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮部位"); 
		return column;
	}
	/**
	 * 获取压疮其他部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_ps_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_ps_pty");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮其他部位"); 
		return column;
	}
	/**
	 * 获取压疮面积表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getArea_psCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Area_ps");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("压疮面积"); 
		return column;
	}
	/**
	 * 获取压疮性质id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ps_ntCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ps_nt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮性质id"); 
		return column;
	}
	/**
	 * 获取压疮性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ps_ntCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ps_nt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮性质"); 
		return column;
	}
	/**
	 * 获取是否有人看护表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_smo_wthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_smo_wth");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否有人看护"); 
		return column;
	}
	/**
	 * 获取是否入住ICU表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_in_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_in_icu");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否入住ICU"); 
		return column;
	}
	/**
	 * 获取是否填报过高危压疮或难免压疮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_fill_psCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fill_ps");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否填报过高危压疮或难免压疮"); 
		return column;
	}
	/**
	 * 获取是否手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sug");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否手术"); 
		return column;
	}
	/**
	 * 获取手术时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_sug");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术时间"); 
		return column;
	}
	/**
	 * 获取术中麻醉id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sug_nrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sug_nrs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中麻醉id"); 
		return column;
	}
	/**
	 * 获取术中麻醉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sug_nrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sug_nrs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中麻醉"); 
		return column;
	}
	/**
	 * 获取手术体位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sug_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sug_pty");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术体位id"); 
		return column;
	}
	/**
	 * 获取手术体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sug_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sug_pty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术体位"); 
		return column;
	}
	/**
	 * 获取其他手术体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtr_sug_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Otr_sug_pty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他手术体位"); 
		return column;
	}
	/**
	 * 获取是否请压疮会诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ps_csCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ps_cs");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否请压疮会诊"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext1");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext2");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext3");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext4");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段4"); 
		return column;
	}
	/**
	 * 获取扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext5");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psrpt_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psrpt_tp");
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
	private IColumnDesc getName_psassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psass");
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
	private IColumnDesc getName_psin_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psin_ms");
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
	private IColumnDesc getName_feel_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_feel_pw");
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
	private IColumnDesc getName_hmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hmd");
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
	private IColumnDesc getName_act_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_act_pw");
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
	private IColumnDesc getName_move_pwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_move_pw");
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
	private IColumnDesc getName_ntr_sptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ntr_spt");
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
	private IColumnDesc getName_fcefrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fcefr");
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
	private IColumnDesc getName_oxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oxy");
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
	private IColumnDesc getName_grlcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grlc");
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
	private IColumnDesc getName_ps_stgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ps_stg");
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
	private IColumnDesc getName_oldps_surCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oldps_sur");
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
	private IColumnDesc getName_ps_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ps_pty");
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
	private IColumnDesc getName_ps_ntCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ps_nt");
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
	private IColumnDesc getName_sug_nrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sug_nrs");
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
	private IColumnDesc getName_sug_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sug_pty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_aer_ev_ps");
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
