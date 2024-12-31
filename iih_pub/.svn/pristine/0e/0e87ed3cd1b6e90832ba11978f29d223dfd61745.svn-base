
package iih.pe.pwf.pewfrmswitch.d.desc;

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
 * 体检流程诊间开关 DO 元数据信息
 */
public class PeWfRmSwitchDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pewfrmswitch.d.PeWfRmSwitchDO";
	public static final String CLASS_DISPALYNAME = "体检流程诊间开关";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_pewfrmswitch";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pewfrmswitch";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeWfRmSwitchDODesc(){
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
		this.setKeyDesc(getId_pewfrmswitchADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pewfrmswitchADesc(tblDesc));
		this.add(getId_pefuncareaADesc(tblDesc));
		this.add(getId_pedeptsetADesc(tblDesc));
		this.add(getId_pediroomADesc(tblDesc));
		this.add(getDt_peroomADesc(tblDesc));
		this.add(getSexlimitADesc(tblDesc));
		this.add(getFg_openADesc(tblDesc));
		this.add(getFg_vipADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_docADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getWaitingsADesc(tblDesc));
		this.add(getCheckedADesc(tblDesc));
		this.add(getUncheckedADesc(tblDesc));
		this.add(getGiveupsADesc(tblDesc));
		this.add(getDu_waitADesc(tblDesc));
		this.add(getFg_guidestationADesc(tblDesc));
		this.add(getDu_checkADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getWait1ADesc(tblDesc));
		this.add(getWait2ADesc(tblDesc));
		this.add(getWait3ADesc(tblDesc));
		this.add(getWait4ADesc(tblDesc));
		this.add(getWait5ADesc(tblDesc));
		this.add(getWait6ADesc(tblDesc));
		this.add(getWait7ADesc(tblDesc));
		this.add(getWait8ADesc(tblDesc));
		this.add(getWait9ADesc(tblDesc));
		this.add(getWait10ADesc(tblDesc));
		this.add(getWait11ADesc(tblDesc));
		this.add(getWait12ADesc(tblDesc));
		this.add(getWait13ADesc(tblDesc));
		this.add(getWait14ADesc(tblDesc));
		this.add(getWait15ADesc(tblDesc));
		this.add(getWait16ADesc(tblDesc));
		this.add(getWait17ADesc(tblDesc));
		this.add(getWait18ADesc(tblDesc));
		this.add(getWait19ADesc(tblDesc));
		this.add(getWait20ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_roomADesc(tblDesc));
		this.add(getCode_roomADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_docADesc(tblDesc));
		this.add(getCard_pe_curADesc(tblDesc));
		this.add(getFg_vip_curADesc(tblDesc));
		this.add(getName_psn_curADesc(tblDesc));
		this.add(getSd_sex_psn_curADesc(tblDesc));
		this.add(getCard_pe1ADesc(tblDesc));
		this.add(getName_psn1ADesc(tblDesc));
		this.add(getSd_sex_psn1ADesc(tblDesc));
		this.add(getFg_vip1ADesc(tblDesc));
		this.add(getCard_pe2ADesc(tblDesc));
		this.add(getName_psn2ADesc(tblDesc));
		this.add(getSd_sex_psn2ADesc(tblDesc));
		this.add(getFg_vip2ADesc(tblDesc));
		this.add(getName_psn3ADesc(tblDesc));
		this.add(getSd_sex_psn3ADesc(tblDesc));
		this.add(getCard_pe3ADesc(tblDesc));
		this.add(getFg_vip3ADesc(tblDesc));
		this.add(getName_psn4ADesc(tblDesc));
		this.add(getSd_sex_psn4ADesc(tblDesc));
		this.add(getCard_pe4ADesc(tblDesc));
		this.add(getFg_vip4ADesc(tblDesc));
		this.add(getCard_pe5ADesc(tblDesc));
		this.add(getName_psn5ADesc(tblDesc));
		this.add(getSd_sex_psn5ADesc(tblDesc));
		this.add(getFg_vip5ADesc(tblDesc));
		this.add(getName_psn6ADesc(tblDesc));
		this.add(getSd_sex_psn6ADesc(tblDesc));
		this.add(getCard_pe6ADesc(tblDesc));
		this.add(getFg_vip6ADesc(tblDesc));
		this.add(getCard_pe7ADesc(tblDesc));
		this.add(getName_psn7ADesc(tblDesc));
		this.add(getSd_sex_psn7ADesc(tblDesc));
		this.add(getFg_vip7ADesc(tblDesc));
		this.add(getName_psn8ADesc(tblDesc));
		this.add(getSd_sex_psn8ADesc(tblDesc));
		this.add(getCard_pe8ADesc(tblDesc));
		this.add(getFg_vip8ADesc(tblDesc));
		this.add(getName_psn9ADesc(tblDesc));
		this.add(getSd_sex_psn9ADesc(tblDesc));
		this.add(getCard_pe9ADesc(tblDesc));
		this.add(getFg_vip9ADesc(tblDesc));
		this.add(getCard_pe10ADesc(tblDesc));
		this.add(getName_psn10ADesc(tblDesc));
		this.add(getSd_sex_psn10ADesc(tblDesc));
		this.add(getFg_vip10ADesc(tblDesc));
		this.add(getName_psn11ADesc(tblDesc));
		this.add(getSd_sex_psn11ADesc(tblDesc));
		this.add(getCard_pe11ADesc(tblDesc));
		this.add(getFg_vip11ADesc(tblDesc));
		this.add(getCard_pe12ADesc(tblDesc));
		this.add(getName_psn12ADesc(tblDesc));
		this.add(getSd_sex_psn12ADesc(tblDesc));
		this.add(getFg_vip12ADesc(tblDesc));
		this.add(getName_psn13ADesc(tblDesc));
		this.add(getSd_sex_psn13ADesc(tblDesc));
		this.add(getCard_pe13ADesc(tblDesc));
		this.add(getFg_vip13ADesc(tblDesc));
		this.add(getCard_pe14ADesc(tblDesc));
		this.add(getName_psn14ADesc(tblDesc));
		this.add(getSd_sex_psn14ADesc(tblDesc));
		this.add(getFg_vip14ADesc(tblDesc));
		this.add(getName_psn15ADesc(tblDesc));
		this.add(getSd_sex_psn15ADesc(tblDesc));
		this.add(getCard_pe15ADesc(tblDesc));
		this.add(getFg_vip15ADesc(tblDesc));
		this.add(getCard_pe16ADesc(tblDesc));
		this.add(getName_psn16ADesc(tblDesc));
		this.add(getSd_sex_psn16ADesc(tblDesc));
		this.add(getFg_vip16ADesc(tblDesc));
		this.add(getName_psn17ADesc(tblDesc));
		this.add(getSd_sex_psn17ADesc(tblDesc));
		this.add(getCard_pe17ADesc(tblDesc));
		this.add(getFg_vip17ADesc(tblDesc));
		this.add(getCard_pe18ADesc(tblDesc));
		this.add(getName_psn18ADesc(tblDesc));
		this.add(getSd_sex_psn18ADesc(tblDesc));
		this.add(getFg_vip18ADesc(tblDesc));
		this.add(getName_psn19ADesc(tblDesc));
		this.add(getSd_sex_psn19ADesc(tblDesc));
		this.add(getCard_pe19ADesc(tblDesc));
		this.add(getFg_vip19ADesc(tblDesc));
		this.add(getCard_pe20ADesc(tblDesc));
		this.add(getName_psn20ADesc(tblDesc));
		this.add(getSd_sex_psn20ADesc(tblDesc));
		this.add(getFg_vip20ADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pewfrmswitchCDesc(tblDesc));
		tblDesc.add(getId_pewfrmswitchCDesc(tblDesc));
		tblDesc.add(getId_pefuncareaCDesc(tblDesc));
		tblDesc.add(getId_pedeptsetCDesc(tblDesc));
		tblDesc.add(getId_pediroomCDesc(tblDesc));
		tblDesc.add(getDt_peroomCDesc(tblDesc));
		tblDesc.add(getSexlimitCDesc(tblDesc));
		tblDesc.add(getFg_openCDesc(tblDesc));
		tblDesc.add(getFg_vipCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_docCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getWaitingsCDesc(tblDesc));
		tblDesc.add(getCheckedCDesc(tblDesc));
		tblDesc.add(getUncheckedCDesc(tblDesc));
		tblDesc.add(getGiveupsCDesc(tblDesc));
		tblDesc.add(getDu_waitCDesc(tblDesc));
		tblDesc.add(getFg_guidestationCDesc(tblDesc));
		tblDesc.add(getDu_checkCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getWait1CDesc(tblDesc));
		tblDesc.add(getWait2CDesc(tblDesc));
		tblDesc.add(getWait3CDesc(tblDesc));
		tblDesc.add(getWait4CDesc(tblDesc));
		tblDesc.add(getWait5CDesc(tblDesc));
		tblDesc.add(getWait6CDesc(tblDesc));
		tblDesc.add(getWait7CDesc(tblDesc));
		tblDesc.add(getWait8CDesc(tblDesc));
		tblDesc.add(getWait9CDesc(tblDesc));
		tblDesc.add(getWait10CDesc(tblDesc));
		tblDesc.add(getWait11CDesc(tblDesc));
		tblDesc.add(getWait12CDesc(tblDesc));
		tblDesc.add(getWait13CDesc(tblDesc));
		tblDesc.add(getWait14CDesc(tblDesc));
		tblDesc.add(getWait15CDesc(tblDesc));
		tblDesc.add(getWait16CDesc(tblDesc));
		tblDesc.add(getWait17CDesc(tblDesc));
		tblDesc.add(getWait18CDesc(tblDesc));
		tblDesc.add(getWait19CDesc(tblDesc));
		tblDesc.add(getWait20CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检诊间开关主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pewfrmswitchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pewfrmswitch",  getId_pewfrmswitchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊间开关主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检功能区ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pefuncareaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pefuncarea",  getId_pefuncareaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检功能区ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检科室ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedeptsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedeptset",  getId_pedeptsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检诊间ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pediroomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pediroom",  getId_pediroomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊间ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_peroomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_peroom",  getDt_peroomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("体检日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开关状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_openADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_open",  getFg_openCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("开关状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip",  getFg_vipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc",  getId_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 在检体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("在检体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 在检体检客户ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnbinfo",  getId_pepsnbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("在检体检客户ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 等候人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWaitingsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Waitings",  getWaitingsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("等候人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已检人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheckedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Checked",  getCheckedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("已检人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 未检人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUncheckedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unchecked",  getUncheckedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("未检人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 弃检人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGiveupsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Giveups",  getGiveupsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("弃检人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 等候时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDu_waitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Du_wait",  getDu_waitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("等候时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导诊台标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_guidestationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_guidestation",  getFg_guidestationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("导诊台标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人均检查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDu_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Du_check",  getDu_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("人均检查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 等候1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait1",  getWait1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait2",  getWait2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait3",  getWait3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait4",  getWait4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait5",  getWait5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait6",  getWait6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait7",  getWait7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait8",  getWait8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait9",  getWait9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait10",  getWait10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait11",  getWait11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait12",  getWait12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait13",  getWait13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait14",  getWait14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait15",  getWait15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait16",  getWait16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候17属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait17",  getWait17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候17");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候18属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait18",  getWait18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候18");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候19属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait19",  getWait19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候19");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 等候20属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWait20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wait20",  getWait20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("等候20");
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
	 * 诊间名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_roomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_room",  getName_roomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊间名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_diroom a0b6","id_pediroom=id_pediroom","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_roomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_room",  getCode_roomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_diroom a0b6","id_pediroom=id_pediroom","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b28","id_nur=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doc",  getName_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b29","id_doc=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe_cur",  getCard_pe_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b27","id_pepsnappt=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip_cur",  getFg_vip_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b27","id_pepsnappt=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn_cur",  getName_psn_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b27","id_pepsnappt=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn_cur",  getSd_sex_psn_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b27","id_pepsnappt=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe1",  getCard_pe1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b7","wait1=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn1",  getName_psn1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b7","wait1=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn1",  getSd_sex_psn1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b7","wait1=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip1",  getFg_vip1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b7","wait1=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe2",  getCard_pe2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b8","wait2=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn2",  getName_psn2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b8","wait2=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn2",  getSd_sex_psn2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b8","wait2=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip2",  getFg_vip2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b8","wait2=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn3",  getName_psn3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b9","wait3=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn3",  getSd_sex_psn3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b9","wait3=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe3",  getCard_pe3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b9","wait3=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip3",  getFg_vip3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b9","wait3=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn4",  getName_psn4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b10","wait4=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn4",  getSd_sex_psn4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b10","wait4=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe4",  getCard_pe4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b10","wait4=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip4",  getFg_vip4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b10","wait4=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe5",  getCard_pe5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b11","wait5=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn5",  getName_psn5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b11","wait5=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn5",  getSd_sex_psn5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b11","wait5=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip5",  getFg_vip5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b11","wait5=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn6",  getName_psn6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b12","wait6=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn6",  getSd_sex_psn6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b12","wait6=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe6",  getCard_pe6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b12","wait6=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip6",  getFg_vip6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b12","wait6=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe7",  getCard_pe7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b13","wait7=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn7",  getName_psn7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b13","wait7=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn7",  getSd_sex_psn7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b13","wait7=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip7",  getFg_vip7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b13","wait7=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn8",  getName_psn8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b14","wait8=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn8",  getSd_sex_psn8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b14","wait8=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe8",  getCard_pe8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b14","wait8=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip8",  getFg_vip8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b14","wait8=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn9",  getName_psn9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b15","wait9=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn9",  getSd_sex_psn9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b15","wait9=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe9",  getCard_pe9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b15","wait9=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip9",  getFg_vip9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b15","wait9=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe10",  getCard_pe10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b16","wait10=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn10",  getName_psn10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b16","wait10=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn10",  getSd_sex_psn10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b16","wait10=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip10",  getFg_vip10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b16","wait10=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn11",  getName_psn11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b17","wait11=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn11",  getSd_sex_psn11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b17","wait11=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe11",  getCard_pe11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b17","wait11=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip11",  getFg_vip11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b17","wait11=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe12",  getCard_pe12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b18","wait12=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn12",  getName_psn12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b18","wait12=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn12",  getSd_sex_psn12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b18","wait12=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip12",  getFg_vip12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b18","wait12=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn13",  getName_psn13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b19","wait13=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn13",  getSd_sex_psn13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b19","wait13=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe13",  getCard_pe13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b19","wait13=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip13",  getFg_vip13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b19","wait13=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe14",  getCard_pe14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b20","wait14=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn14",  getName_psn14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b20","wait14=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn14",  getSd_sex_psn14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b20","wait14=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip14",  getFg_vip14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b20","wait14=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn15",  getName_psn15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b21","wait15=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn15",  getSd_sex_psn15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b21","wait15=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe15",  getCard_pe15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b21","wait15=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip15",  getFg_vip15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b21","wait15=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe16",  getCard_pe16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b22","wait16=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn16",  getName_psn16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b22","wait16=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn16",  getSd_sex_psn16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b22","wait16=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip16",  getFg_vip16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b22","wait16=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn17",  getName_psn17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b23","wait17=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn17",  getSd_sex_psn17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b23","wait17=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe17",  getCard_pe17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b23","wait17=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip17",  getFg_vip17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b23","wait17=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe18",  getCard_pe18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b24","wait18=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn18",  getName_psn18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b24","wait18=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn18",  getSd_sex_psn18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b24","wait18=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip18",  getFg_vip18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b24","wait18=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn19",  getName_psn19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b25","wait19=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn19",  getSd_sex_psn19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b25","wait19=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe19",  getCard_pe19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b25","wait19=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip19",  getFg_vip19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b25","wait19=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_pe20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe20",  getCard_pe20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b26","wait20=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn20",  getName_psn20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b26","wait20=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psn20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn20",  getSd_sex_psn20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b26","wait20=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vip20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip20",  getFg_vip20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b26","wait20=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检诊间开关主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pewfrmswitchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pewfrmswitch");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检诊间开关主键标识"); 
		return column;
	}
	/**
	 * 获取体检功能区ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pefuncareaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pefuncarea");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检功能区ID"); 
		return column;
	}
	/**
	 * 获取体检科室ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedeptsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedeptset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室ID"); 
		return column;
	}
	/**
	 * 获取体检诊间ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pediroomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pediroom");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊间ID"); 
		return column;
	}
	/**
	 * 获取体检日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_peroomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_peroom");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检日期"); 
		return column;
	}
	/**
	 * 获取性别限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexlimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sexlimit");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别限制"); 
		return column;
	}
	/**
	 * 获取开关状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_openCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_open");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开关状态"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士"); 
		return column;
	}
	/**
	 * 获取医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生"); 
		return column;
	}
	/**
	 * 获取在检体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("在检体检预约单ID"); 
		return column;
	}
	/**
	 * 获取在检体检客户ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("在检体检客户ID"); 
		return column;
	}
	/**
	 * 获取等候人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWaitingsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Waitings");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("等候人数"); 
		return column;
	}
	/**
	 * 获取已检人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheckedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Checked");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("已检人数"); 
		return column;
	}
	/**
	 * 获取未检人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUncheckedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unchecked");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("未检人数"); 
		return column;
	}
	/**
	 * 获取弃检人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGiveupsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Giveups");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("弃检人数"); 
		return column;
	}
	/**
	 * 获取等候时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDu_waitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Du_wait");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("等候时间"); 
		return column;
	}
	/**
	 * 获取导诊台标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_guidestationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_guidestation");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("导诊台标识"); 
		return column;
	}
	/**
	 * 获取人均检查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDu_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Du_check");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("人均检查时间"); 
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
	 * 获取等候1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候1"); 
		return column;
	}
	/**
	 * 获取等候2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候2"); 
		return column;
	}
	/**
	 * 获取等候3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait3");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候3"); 
		return column;
	}
	/**
	 * 获取等候4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait4");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候4"); 
		return column;
	}
	/**
	 * 获取等候5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait5");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候5"); 
		return column;
	}
	/**
	 * 获取等候6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait6");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候6"); 
		return column;
	}
	/**
	 * 获取等候7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait7");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候7"); 
		return column;
	}
	/**
	 * 获取等候8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait8");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候8"); 
		return column;
	}
	/**
	 * 获取等候9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait9");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候9"); 
		return column;
	}
	/**
	 * 获取等候10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait10");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候10"); 
		return column;
	}
	/**
	 * 获取等候11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait11");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候11"); 
		return column;
	}
	/**
	 * 获取等候12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait12");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候12"); 
		return column;
	}
	/**
	 * 获取等候13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait13");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候13"); 
		return column;
	}
	/**
	 * 获取等候14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait14");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候14"); 
		return column;
	}
	/**
	 * 获取等候15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait15");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候15"); 
		return column;
	}
	/**
	 * 获取等候16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait16");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候16"); 
		return column;
	}
	/**
	 * 获取等候17表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait17");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候17"); 
		return column;
	}
	/**
	 * 获取等候18表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait18");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候18"); 
		return column;
	}
	/**
	 * 获取等候19表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait19");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候19"); 
		return column;
	}
	/**
	 * 获取等候20表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWait20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wait20");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("等候20"); 
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
	 * 获取诊间名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_roomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_room");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊间名称"); 
		return column;
	}
	/**
	 * 获取诊间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_roomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_room");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊间编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
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
	private IColumnDesc getName_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe_cur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip_cur");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn_cur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn_cur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip1");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip2");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip3");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn4");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn4");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe4");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip4");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe5");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn5");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn5");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip5");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn6");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn6");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe6");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip6");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe7");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn7");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn7");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip7");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn8");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn8");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe8");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip8");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn9");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn9");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe9");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip9");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe10");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn10");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn10");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip10");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn11");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn11");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe11");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip11");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe12");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn12");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn12");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip12");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn13");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn13");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe13");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip13");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe14");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn14");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn14");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip14");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn15");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn15");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe15");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip15");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe16");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn16");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn16");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip16");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn17");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn17");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe17");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip17");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe18");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn18");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn18");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip18");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn19");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn19");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe19");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip19");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_pe20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe20");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn20");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psn20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn20");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vip20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip20");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pewfrmswitch");
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
