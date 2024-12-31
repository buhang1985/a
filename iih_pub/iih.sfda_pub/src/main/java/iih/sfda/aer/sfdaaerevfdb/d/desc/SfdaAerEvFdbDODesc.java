
package iih.sfda.aer.sfdaaerevfdb.d.desc;

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
 * 跌倒/坠床 DO 元数据信息
 */
public class SfdaAerEvFdbDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevfdb.d.SfdaAerEvFdbDO";
	public static final String CLASS_DISPALYNAME = "跌倒/坠床";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_FDB";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_fdb";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvFdbDODesc(){
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
		this.setKeyDesc(getId_aer_ev_fdbADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_fdbADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_fdb_tpADesc(tblDesc));
		this.add(getSd_fdb_tpADesc(tblDesc));
		this.add(getId_fdb_occurobjADesc(tblDesc));
		this.add(getSd_fdb_occurobjADesc(tblDesc));
		this.add(getId_fdb_occurlinkADesc(tblDesc));
		this.add(getSd_fdb_occurlinkADesc(tblDesc));
		this.add(getId_fdb_occurreasADesc(tblDesc));
		this.add(getSd_fdb_occurreasADesc(tblDesc));
		this.add(getOth_fdb_occurreasADesc(tblDesc));
		this.add(getFg_fdb_hurtADesc(tblDesc));
		this.add(getId_fdb_hurtlvlADesc(tblDesc));
		this.add(getSd_fdb_hurtlvlADesc(tblDesc));
		this.add(getEu_acurbef_hrskADesc(tblDesc));
		this.add(getId_indepdt_atyADesc(tblDesc));
		this.add(getSd_indepdt_atyADesc(tblDesc));
		this.add(getId_bedrail_statADesc(tblDesc));
		this.add(getSd_bedrail_statADesc(tblDesc));
		this.add(getId_party_idlgyADesc(tblDesc));
		this.add(getSd_party_idlgyADesc(tblDesc));
		this.add(getId_occur_atypresADesc(tblDesc));
		this.add(getSd_occur_atypresADesc(tblDesc));
		this.add(getOth_occur_atypresADesc(tblDesc));
		this.add(getEu_any_cpyADesc(tblDesc));
		this.add(getEu_cpy_hereADesc(tblDesc));
		this.add(getName_cpy_hereADesc(tblDesc));
		this.add(getFg_recur_fdbADesc(tblDesc));
		this.add(getEu_recur_reportADesc(tblDesc));
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
		this.add(getName_fdb_tpADesc(tblDesc));
		this.add(getName_fdb_occurobjADesc(tblDesc));
		this.add(getName_fdb_occurlinkADesc(tblDesc));
		this.add(getName_fdb_occurreasADesc(tblDesc));
		this.add(getName_fdb_hurtlvlADesc(tblDesc));
		this.add(getName_indepdt_atyADesc(tblDesc));
		this.add(getName_bedrail_statADesc(tblDesc));
		this.add(getName_party_idlgyADesc(tblDesc));
		this.add(getName_occur_atypresADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_fdbCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_fdbCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_fdb_tpCDesc(tblDesc));
		tblDesc.add(getSd_fdb_tpCDesc(tblDesc));
		tblDesc.add(getId_fdb_occurobjCDesc(tblDesc));
		tblDesc.add(getSd_fdb_occurobjCDesc(tblDesc));
		tblDesc.add(getId_fdb_occurlinkCDesc(tblDesc));
		tblDesc.add(getSd_fdb_occurlinkCDesc(tblDesc));
		tblDesc.add(getId_fdb_occurreasCDesc(tblDesc));
		tblDesc.add(getSd_fdb_occurreasCDesc(tblDesc));
		tblDesc.add(getOth_fdb_occurreasCDesc(tblDesc));
		tblDesc.add(getFg_fdb_hurtCDesc(tblDesc));
		tblDesc.add(getId_fdb_hurtlvlCDesc(tblDesc));
		tblDesc.add(getSd_fdb_hurtlvlCDesc(tblDesc));
		tblDesc.add(getEu_acurbef_hrskCDesc(tblDesc));
		tblDesc.add(getId_indepdt_atyCDesc(tblDesc));
		tblDesc.add(getSd_indepdt_atyCDesc(tblDesc));
		tblDesc.add(getId_bedrail_statCDesc(tblDesc));
		tblDesc.add(getSd_bedrail_statCDesc(tblDesc));
		tblDesc.add(getId_party_idlgyCDesc(tblDesc));
		tblDesc.add(getSd_party_idlgyCDesc(tblDesc));
		tblDesc.add(getId_occur_atypresCDesc(tblDesc));
		tblDesc.add(getSd_occur_atypresCDesc(tblDesc));
		tblDesc.add(getOth_occur_atypresCDesc(tblDesc));
		tblDesc.add(getEu_any_cpyCDesc(tblDesc));
		tblDesc.add(getEu_cpy_hereCDesc(tblDesc));
		tblDesc.add(getName_cpy_hereCDesc(tblDesc));
		tblDesc.add(getFg_recur_fdbCDesc(tblDesc));
		tblDesc.add(getEu_recur_reportCDesc(tblDesc));
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
	 * 跌倒坠床事件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_fdbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_fdb",  getId_aer_ev_fdbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒坠床事件");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理安全事件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理安全事件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团组织");
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
	 * 跌倒/坠床事件类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fdb_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fdb_tp",  getId_fdb_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床事件类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床事件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fdb_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fdb_tp",  getSd_fdb_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床事件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床发生的对象id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fdb_occurobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fdb_occurobj",  getId_fdb_occurobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床发生的对象id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床发生的对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fdb_occurobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fdb_occurobj",  getSd_fdb_occurobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床发生的对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床发生的环节id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fdb_occurlinkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fdb_occurlink",  getId_fdb_occurlinkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床发生的环节id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床发生的环节属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fdb_occurlinkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fdb_occurlink",  getSd_fdb_occurlinkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床发生的环节");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床发生的原因(三甲指标)id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fdb_occurreasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fdb_occurreas",  getId_fdb_occurreasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床发生的原因(三甲指标)id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床发生的原因(三甲指标)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fdb_occurreasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fdb_occurreas",  getSd_fdb_occurreasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床发生的原因(三甲指标)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他跌倒/坠床发生的原因(三甲指标)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_fdb_occurreasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_fdb_occurreas",  getOth_fdb_occurreasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他跌倒/坠床发生的原因(三甲指标)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床有无造成伤害(三甲指标)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_fdb_hurtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fdb_hurt",  getFg_fdb_hurtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("跌倒/坠床有无造成伤害(三甲指标)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床造成伤害等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fdb_hurtlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fdb_hurtlvl",  getId_fdb_hurtlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床造成伤害等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床造成伤害等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fdb_hurtlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fdb_hurtlvl",  getSd_fdb_hurtlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床造成伤害等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生前是否为跌倒/坠床高危险群属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_acurbef_hrskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_acurbef_hrsk",  getEu_acurbef_hrskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件发生前是否为跌倒/坠床高危险群");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生前的独立活动能力id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_indepdt_atyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_indepdt_aty",  getId_indepdt_atyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生前的独立活动能力id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件发生前的独立活动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_indepdt_atyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_indepdt_aty",  getSd_indepdt_atyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生前的独立活动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生前床栏使用情形id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedrail_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bedrail_stat",  getId_bedrail_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生前床栏使用情形id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件发生前床栏使用情形属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bedrail_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bedrail_stat",  getSd_bedrail_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生前床栏使用情形");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当事人当时意识状态id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_party_idlgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_party_idlgy",  getId_party_idlgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当事人当时意识状态id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当事人当时意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_party_idlgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_party_idlgy",  getSd_party_idlgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当事人当时意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生于何项活动过程id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_occur_atypresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_occur_atypres",  getId_occur_atypresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生于何项活动过程id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件发生于何项活动过程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_occur_atypresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_occur_atypres",  getSd_occur_atypresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生于何项活动过程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他事件发生于何项活动过程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_occur_atypresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_occur_atypres",  getOth_occur_atypresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他事件发生于何项活动过程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平日有无陪伴者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_any_cpyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_any_cpy",  getEu_any_cpyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("平日有无陪伴者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生时有无陪伴者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cpy_hereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cpy_here",  getEu_cpy_hereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件发生时有无陪伴者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生时陪伴者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cpy_hereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cpy_here",  getName_cpy_hereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生时陪伴者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次住院期间是否发生再次跌倒/坠床属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_recur_fdbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_recur_fdb",  getFg_recur_fdbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("本次住院期间是否发生再次跌倒/坠床");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 再次发生跌倒/坠床是否上报属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_recur_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_recur_report",  getEu_recur_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("再次发生跌倒/坠床是否上报");
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
	 * 集团组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团组织");
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
	private IAttrDesc getName_fdb_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fdb_tp",  getName_fdb_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_fdb_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fdb_occurobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fdb_occurobj",  getName_fdb_occurobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_fdb_occurobj=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fdb_occurlinkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fdb_occurlink",  getName_fdb_occurlinkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_fdb_occurlink=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fdb_occurreasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fdb_occurreas",  getName_fdb_occurreasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_fdb_occurreas=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fdb_hurtlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fdb_hurtlvl",  getName_fdb_hurtlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_fdb_hurtlvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_indepdt_atyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_indepdt_aty",  getName_indepdt_atyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_indepdt_aty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedrail_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bedrail_stat",  getName_bedrail_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_bedrail_stat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_party_idlgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_party_idlgy",  getName_party_idlgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_party_idlgy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_occur_atypresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_occur_atypres",  getName_occur_atypresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_occur_atypres=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取跌倒坠床事件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_fdbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_fdb");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("跌倒坠床事件"); 
		return column;
	}
	/**
	 * 获取护理安全事件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理安全事件"); 
		return column;
	}
	/**
	 * 获取集团组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团组织"); 
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
	 * 获取跌倒/坠床事件类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fdb_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fdb_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床事件类型id"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床事件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fdb_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fdb_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床事件类型"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床发生的对象id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fdb_occurobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fdb_occurobj");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床发生的对象id"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床发生的对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fdb_occurobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fdb_occurobj");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床发生的对象"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床发生的环节id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fdb_occurlinkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fdb_occurlink");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床发生的环节id"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床发生的环节表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fdb_occurlinkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fdb_occurlink");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床发生的环节"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床发生的原因(三甲指标)id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fdb_occurreasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fdb_occurreas");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床发生的原因(三甲指标)id"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床发生的原因(三甲指标)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fdb_occurreasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fdb_occurreas");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床发生的原因(三甲指标)"); 
		return column;
	}
	/**
	 * 获取其他跌倒/坠床发生的原因(三甲指标)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_fdb_occurreasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_fdb_occurreas");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他跌倒/坠床发生的原因(三甲指标)"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床有无造成伤害(三甲指标)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_fdb_hurtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fdb_hurt");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床有无造成伤害(三甲指标)"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床造成伤害等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fdb_hurtlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fdb_hurtlvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床造成伤害等级id"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床造成伤害等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fdb_hurtlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fdb_hurtlvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床造成伤害等级"); 
		return column;
	}
	/**
	 * 获取事件发生前是否为跌倒/坠床高危险群表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_acurbef_hrskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_acurbef_hrsk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件发生前是否为跌倒/坠床高危险群"); 
		return column;
	}
	/**
	 * 获取事件发生前的独立活动能力id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_indepdt_atyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_indepdt_aty");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生前的独立活动能力id"); 
		return column;
	}
	/**
	 * 获取事件发生前的独立活动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_indepdt_atyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_indepdt_aty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生前的独立活动能力"); 
		return column;
	}
	/**
	 * 获取事件发生前床栏使用情形id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedrail_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bedrail_stat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生前床栏使用情形id"); 
		return column;
	}
	/**
	 * 获取事件发生前床栏使用情形表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bedrail_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bedrail_stat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生前床栏使用情形"); 
		return column;
	}
	/**
	 * 获取当事人当时意识状态id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_party_idlgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_party_idlgy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当事人当时意识状态id"); 
		return column;
	}
	/**
	 * 获取当事人当时意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_party_idlgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_party_idlgy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当事人当时意识状态"); 
		return column;
	}
	/**
	 * 获取事件发生于何项活动过程id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_occur_atypresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_occur_atypres");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生于何项活动过程id"); 
		return column;
	}
	/**
	 * 获取事件发生于何项活动过程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_occur_atypresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_occur_atypres");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生于何项活动过程"); 
		return column;
	}
	/**
	 * 获取其他事件发生于何项活动过程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_occur_atypresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_occur_atypres");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他事件发生于何项活动过程"); 
		return column;
	}
	/**
	 * 获取平日有无陪伴者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_any_cpyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_any_cpy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("平日有无陪伴者"); 
		return column;
	}
	/**
	 * 获取事件发生时有无陪伴者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cpy_hereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cpy_here");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件发生时有无陪伴者"); 
		return column;
	}
	/**
	 * 获取事件发生时陪伴者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cpy_hereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cpy_here");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生时陪伴者"); 
		return column;
	}
	/**
	 * 获取本次住院期间是否发生再次跌倒/坠床表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_recur_fdbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_recur_fdb");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("本次住院期间是否发生再次跌倒/坠床"); 
		return column;
	}
	/**
	 * 获取再次发生跌倒/坠床是否上报表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_recur_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_recur_report");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("再次发生跌倒/坠床是否上报"); 
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
	 * 获取集团组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团组织"); 
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
	private IColumnDesc getName_fdb_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fdb_tp");
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
	private IColumnDesc getName_fdb_occurobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fdb_occurobj");
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
	private IColumnDesc getName_fdb_occurlinkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fdb_occurlink");
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
	private IColumnDesc getName_fdb_occurreasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fdb_occurreas");
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
	private IColumnDesc getName_fdb_hurtlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fdb_hurtlvl");
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
	private IColumnDesc getName_indepdt_atyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_indepdt_aty");
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
	private IColumnDesc getName_bedrail_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bedrail_stat");
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
	private IColumnDesc getName_party_idlgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_party_idlgy");
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
	private IColumnDesc getName_occur_atypresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_occur_atypres");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
