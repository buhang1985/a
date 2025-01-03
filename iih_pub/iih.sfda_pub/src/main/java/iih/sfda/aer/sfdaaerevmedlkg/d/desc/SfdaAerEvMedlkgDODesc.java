
package iih.sfda.aer.sfdaaerevmedlkg.d.desc;

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
 * 输液药物渗漏事件 DO 元数据信息
 */
public class SfdaAerEvMedlkgDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevmedlkg.d.SfdaAerEvMedlkgDO";
	public static final String CLASS_DISPALYNAME = "输液药物渗漏事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_MEDLKG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_medlkg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvMedlkgDODesc(){
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
		this.setKeyDesc(getId_aer_ev_medlkgADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_medlkgADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getEv_smy_desADesc(tblDesc));
		this.add(getId_dtsarttpADesc(tblDesc));
		this.add(getSd_dtsarttpADesc(tblDesc));
		this.add(getId_medlkg_resasADesc(tblDesc));
		this.add(getSd_medlkg_resasADesc(tblDesc));
		this.add(getOth_medlkg_reasADesc(tblDesc));
		this.add(getId_lkg_ptyADesc(tblDesc));
		this.add(getSd_lkg_ptyADesc(tblDesc));
		this.add(getOth_lkg_ptyADesc(tblDesc));
		this.add(getId_medlkg_kindADesc(tblDesc));
		this.add(getSd_medlkg_kindADesc(tblDesc));
		this.add(getOth_medlkg_kindADesc(tblDesc));
		this.add(getId_medlkg_lvlADesc(tblDesc));
		this.add(getSd_medlkg_lvlADesc(tblDesc));
		this.add(getId_hdle_mthADesc(tblDesc));
		this.add(getSd_hdle_mthADesc(tblDesc));
		this.add(getOth_hdle_mthADesc(tblDesc));
		this.add(getExt1ADesc(tblDesc));
		this.add(getExt2ADesc(tblDesc));
		this.add(getExt3ADesc(tblDesc));
		this.add(getExt4ADesc(tblDesc));
		this.add(getExt5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getOth_dtsarttpADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_dtsarttpADesc(tblDesc));
		this.add(getName_medlkg_resasADesc(tblDesc));
		this.add(getName_lkg_ptyADesc(tblDesc));
		this.add(getName_medlkg_kindADesc(tblDesc));
		this.add(getCtrl1_medlkg_lvlADesc(tblDesc));
		this.add(getName_hdle_mthADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_medlkgCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_medlkgCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getEv_smy_desCDesc(tblDesc));
		tblDesc.add(getId_dtsarttpCDesc(tblDesc));
		tblDesc.add(getSd_dtsarttpCDesc(tblDesc));
		tblDesc.add(getId_medlkg_resasCDesc(tblDesc));
		tblDesc.add(getSd_medlkg_resasCDesc(tblDesc));
		tblDesc.add(getOth_medlkg_reasCDesc(tblDesc));
		tblDesc.add(getId_lkg_ptyCDesc(tblDesc));
		tblDesc.add(getSd_lkg_ptyCDesc(tblDesc));
		tblDesc.add(getOth_lkg_ptyCDesc(tblDesc));
		tblDesc.add(getId_medlkg_kindCDesc(tblDesc));
		tblDesc.add(getSd_medlkg_kindCDesc(tblDesc));
		tblDesc.add(getOth_medlkg_kindCDesc(tblDesc));
		tblDesc.add(getId_medlkg_lvlCDesc(tblDesc));
		tblDesc.add(getSd_medlkg_lvlCDesc(tblDesc));
		tblDesc.add(getId_hdle_mthCDesc(tblDesc));
		tblDesc.add(getSd_hdle_mthCDesc(tblDesc));
		tblDesc.add(getOth_hdle_mthCDesc(tblDesc));
		tblDesc.add(getExt1CDesc(tblDesc));
		tblDesc.add(getExt2CDesc(tblDesc));
		tblDesc.add(getExt3CDesc(tblDesc));
		tblDesc.add(getExt4CDesc(tblDesc));
		tblDesc.add(getExt5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getOth_dtsarttpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 输液药物渗漏事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_medlkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_medlkg",  getId_aer_ev_medlkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液药物渗漏事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理安全事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理安全事件外键");
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
	 * 事件概要说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEv_smy_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ev_smy_des",  getEv_smy_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件概要说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉导管类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dtsarttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dtsarttp",  getId_dtsarttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉导管类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 静脉导管类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dtsarttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dtsarttp",  getSd_dtsarttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉导管类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渗漏性损伤原因id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medlkg_resasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medlkg_resas",  getId_medlkg_resasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渗漏性损伤原因id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 渗漏性损伤原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medlkg_resasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medlkg_resas",  getSd_medlkg_resasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渗漏性损伤原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 损伤原因补充属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_medlkg_reasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_medlkg_reas",  getOth_medlkg_reasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("损伤原因补充");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渗漏部位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lkg_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lkg_pty",  getId_lkg_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渗漏部位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 渗漏部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lkg_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lkg_pty",  getSd_lkg_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渗漏部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他渗漏部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_lkg_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_lkg_pty",  getOth_lkg_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他渗漏部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 外渗药物种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medlkg_kindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medlkg_kind",  getId_medlkg_kindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外渗药物种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 外渗药物种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medlkg_kindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medlkg_kind",  getSd_medlkg_kindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外渗药物种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他外渗药物种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_medlkg_kindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_medlkg_kind",  getOth_medlkg_kindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他外渗药物种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物渗出的级别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medlkg_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medlkg_lvl",  getId_medlkg_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物渗出的级别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药物渗出的级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medlkg_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medlkg_lvl",  getSd_medlkg_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物渗出的级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理方法id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hdle_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hdle_mth",  getId_hdle_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理方法id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处理方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hdle_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hdle_mth",  getSd_hdle_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他处理方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_hdle_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_hdle_mth",  getOth_hdle_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他处理方法");
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
	 * 其他静脉导管类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_dtsarttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_dtsarttp",  getOth_dtsarttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他静脉导管类型");
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
	 * 静脉导管类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dtsarttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dtsarttp",  getName_dtsarttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉导管类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_dtsarttp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渗漏性损伤原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medlkg_resasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medlkg_resas",  getName_medlkg_resasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渗漏性损伤原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_medlkg_resas=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渗漏部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lkg_ptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lkg_pty",  getName_lkg_ptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渗漏部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_lkg_pty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medlkg_kindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medlkg_kind",  getName_medlkg_kindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_medlkg_kind=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1_medlkg_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1_medlkg_lvl",  getCtrl1_medlkg_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_medlkg_lvl=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hdle_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hdle_mth",  getName_hdle_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_hdle_mth=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取输液药物渗漏事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_medlkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_medlkg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输液药物渗漏事件主键"); 
		return column;
	}
	/**
	 * 获取护理安全事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理安全事件外键"); 
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
	 * 获取事件概要说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEv_smy_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ev_smy_des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件概要说明"); 
		return column;
	}
	/**
	 * 获取静脉导管类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dtsarttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dtsarttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉导管类型id"); 
		return column;
	}
	/**
	 * 获取静脉导管类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dtsarttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dtsarttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉导管类型"); 
		return column;
	}
	/**
	 * 获取渗漏性损伤原因id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medlkg_resasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medlkg_resas");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渗漏性损伤原因id"); 
		return column;
	}
	/**
	 * 获取渗漏性损伤原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medlkg_resasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medlkg_resas");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渗漏性损伤原因"); 
		return column;
	}
	/**
	 * 获取损伤原因补充表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_medlkg_reasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_medlkg_reas");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("损伤原因补充"); 
		return column;
	}
	/**
	 * 获取渗漏部位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lkg_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lkg_pty");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渗漏部位id"); 
		return column;
	}
	/**
	 * 获取渗漏部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lkg_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lkg_pty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渗漏部位"); 
		return column;
	}
	/**
	 * 获取其他渗漏部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_lkg_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_lkg_pty");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他渗漏部位"); 
		return column;
	}
	/**
	 * 获取外渗药物种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medlkg_kindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medlkg_kind");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外渗药物种类"); 
		return column;
	}
	/**
	 * 获取外渗药物种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medlkg_kindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medlkg_kind");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外渗药物种类编码"); 
		return column;
	}
	/**
	 * 获取其他外渗药物种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_medlkg_kindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_medlkg_kind");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他外渗药物种类"); 
		return column;
	}
	/**
	 * 获取药物渗出的级别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medlkg_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medlkg_lvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物渗出的级别id"); 
		return column;
	}
	/**
	 * 获取药物渗出的级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medlkg_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medlkg_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物渗出的级别"); 
		return column;
	}
	/**
	 * 获取处理方法id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hdle_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hdle_mth");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理方法id"); 
		return column;
	}
	/**
	 * 获取处理方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hdle_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hdle_mth");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理方法"); 
		return column;
	}
	/**
	 * 获取其他处理方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_hdle_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_hdle_mth");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他处理方法"); 
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
	 * 获取其他静脉导管类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_dtsarttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_dtsarttp");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他静脉导管类型"); 
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
	 * 获取静脉导管类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dtsarttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dtsarttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉导管类型"); 
		return column;
	}
	/**
	 * 获取渗漏性损伤原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medlkg_resasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medlkg_resas");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渗漏性损伤原因"); 
		return column;
	}
	/**
	 * 获取渗漏部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lkg_ptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lkg_pty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渗漏部位"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medlkg_kindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medlkg_kind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl1_medlkg_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1_medlkg_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取处理方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hdle_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hdle_mth");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理方法"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_aer_ev_medlkg");
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
