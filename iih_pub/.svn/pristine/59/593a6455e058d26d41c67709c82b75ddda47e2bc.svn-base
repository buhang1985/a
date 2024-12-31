
package iih.pis.ivx.pisivxaccount.d.desc;

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
 * 微信登录账户 DO 元数据信息
 */
public class PisIvxAccountDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pis.ivx.pisivxaccount.d.PisIvxAccountDO";
	public static final String CLASS_DISPALYNAME = "微信登录账户";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pis_ivx_account";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pisivxaccount";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PisIvxAccountDODesc(){
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
		this.setKeyDesc(getId_pisivxaccountADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pisivxaccountADesc(tblDesc));
		this.add(getId_pisivxsettingADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getOpenidADesc(tblDesc));
		this.add(getLanguageADesc(tblDesc));
		this.add(getCityADesc(tblDesc));
		this.add(getProvinceADesc(tblDesc));
		this.add(getCountryADesc(tblDesc));
		this.add(getHeadimgurlADesc(tblDesc));
		this.add(getSubscribe_timeADesc(tblDesc));
		this.add(getSubscribeADesc(tblDesc));
		this.add(getPatientcountADesc(tblDesc));
		this.add(getSt_accountADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getGroupidADesc(tblDesc));
		this.add(getDefaultfnoADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_pisivxmemberADesc(tblDesc));
		this.add(getId_pisivxentADesc(tblDesc));
		this.add(getNicknameADesc(tblDesc));
		this.add(getFg_bindADesc(tblDesc));
		this.add(getDt_bindADesc(tblDesc));
		this.add(getDt_unbindADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
		this.add(getSubscribe_sceneADesc(tblDesc));
		this.add(getQr_sceneADesc(tblDesc));
		this.add(getQr_scene_strADesc(tblDesc));
		this.add(getSexADesc(tblDesc));
		this.add(getUnsubscribe_timeADesc(tblDesc));
		this.add(getId_pisivxtagsADesc(tblDesc));
		this.add(getAcctpADesc(tblDesc));
		this.add(getCode_serviceADesc(tblDesc));
		this.add(getName_serviceADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getRelADesc(tblDesc));
		this.add(getFg_defADesc(tblDesc));
		this.add(getCardcodeADesc(tblDesc));
		this.add(getIpcodeADesc(tblDesc));
		this.add(getEcardnoADesc(tblDesc));
		this.add(getPatcodeADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getMobADesc(tblDesc));
		this.add(getOptimesADesc(tblDesc));
		this.add(getIptimesADesc(tblDesc));
		this.add(getDtacptADesc(tblDesc));
		this.add(getEntidADesc(tblDesc));
		this.add(getEntpcodeADesc(tblDesc));
		this.add(getPatnameADesc(tblDesc));
		this.add(getPhydepidADesc(tblDesc));
		this.add(getPhydepcodeADesc(tblDesc));
		this.add(getStatuscodeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pisivxaccountCDesc(tblDesc));
		tblDesc.add(getId_pisivxaccountCDesc(tblDesc));
		tblDesc.add(getId_pisivxsettingCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getOpenidCDesc(tblDesc));
		tblDesc.add(getLanguageCDesc(tblDesc));
		tblDesc.add(getCityCDesc(tblDesc));
		tblDesc.add(getProvinceCDesc(tblDesc));
		tblDesc.add(getCountryCDesc(tblDesc));
		tblDesc.add(getHeadimgurlCDesc(tblDesc));
		tblDesc.add(getSubscribe_timeCDesc(tblDesc));
		tblDesc.add(getSubscribeCDesc(tblDesc));
		tblDesc.add(getPatientcountCDesc(tblDesc));
		tblDesc.add(getSt_accountCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getGroupidCDesc(tblDesc));
		tblDesc.add(getDefaultfnoCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_pisivxmemberCDesc(tblDesc));
		tblDesc.add(getId_pisivxentCDesc(tblDesc));
		tblDesc.add(getNicknameCDesc(tblDesc));
		tblDesc.add(getFg_bindCDesc(tblDesc));
		tblDesc.add(getDt_bindCDesc(tblDesc));
		tblDesc.add(getDt_unbindCDesc(tblDesc));
		tblDesc.add(getRemarkCDesc(tblDesc));
		tblDesc.add(getSubscribe_sceneCDesc(tblDesc));
		tblDesc.add(getQr_sceneCDesc(tblDesc));
		tblDesc.add(getQr_scene_strCDesc(tblDesc));
		tblDesc.add(getSexCDesc(tblDesc));
		tblDesc.add(getUnsubscribe_timeCDesc(tblDesc));
		tblDesc.add(getId_pisivxtagsCDesc(tblDesc));
		tblDesc.add(getAcctpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 微信账户主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxaccountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxaccount",  getId_pisivxaccountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信账户主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信服务号配置ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxsettingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxsetting",  getId_pisivxsettingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信服务号配置ID");
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
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpenidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Openid",  getOpenidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信唯一码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLanguageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Language",  getLanguageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 城市属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("City",  getCityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("城市");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 省份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProvinceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Province",  getProvinceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("省份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Country",  getCountryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 头像地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeadimgurlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Headimgurl",  getHeadimgurlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("头像地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关注时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubscribe_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subscribe_time",  getSubscribe_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("关注时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关注状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubscribeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subscribe",  getSubscribeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关注状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绑定患者数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatientcountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patientcount",  getPatientcountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("绑定患者数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账号状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSt_accountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("St_account",  getSt_accountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账号状态");
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
	 * displaynam16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroupidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Groupid",  getGroupidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认家属属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDefaultfnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Defaultfno",  getDefaultfnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认家属");
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
	 * 当前就诊人ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxmemberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxmember",  getId_pisivxmemberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前就诊人ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前就诊记录ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxent",  getId_pisivxentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前就诊记录ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 昵称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNicknameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nickname",  getNicknameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("昵称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绑定标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bind",  getFg_bindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("绑定标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绑定时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_bind",  getDt_bindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("绑定时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 解除绑定时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_unbindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_unbind",  getDt_unbindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("解除绑定时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark",  getRemarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam33属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubscribe_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subscribe_scene",  getSubscribe_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam33");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam34属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQr_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qr_scene",  getQr_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam34");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam35属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQr_scene_strADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qr_scene_str",  getQr_scene_strCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam35");
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
	private IAttrDesc getSexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex",  getSexCDesc(tblDesc), this);
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
	 * 取消关注时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnsubscribe_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unsubscribe_time",  getUnsubscribe_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("取消关注时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户分组标签属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxtagsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxtags",  getId_pisivxtagsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户分组标签");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 账户类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAcctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Acctp",  getAcctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("账户类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务号编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_serviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_service",  getCode_serviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务号编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_setting a0b9","id_pisivxsetting=id_pisivxsetting","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信服务号名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_serviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_service",  getName_serviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信服务号名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_setting a0b9","id_pisivxsetting=id_pisivxsetting","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rel",  getRelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","rel"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认就诊人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_def",  getFg_defCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("默认就诊人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","fg_def"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCardcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cardcode",  getCardcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","cardcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ipcode",  getIpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","ipcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电子就诊卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEcardnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ecardno",  getEcardnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电子就诊卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","ecardno"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIS患者编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcode",  getPatcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIS患者编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","patcode"});
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
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","name_sex"});
		attrDesc.setRefType(false);
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
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","sd_sex"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob",  getMobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_member a0b7","id_pisivxmember=id_pisivxmember","mob"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊就诊次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOptimesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Optimes",  getOptimesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("门诊就诊次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","optimes"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院就诊次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIptimesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iptimes",  getIptimesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院就诊次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","iptimes"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDtacptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dtacpt",  getDtacptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("接诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","dtacpt"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entid",  getEntidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","entid"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entpcode",  getEntpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","entpcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patname",  getPatnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","patname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPhydepidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Phydepid",  getPhydepidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","phydepid"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPhydepcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Phydepcode",  getPhydepcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","phydepcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStatuscodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Statuscode",  getStatuscodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_ent a0b8","id_pisivxent=id_pisivxent","statuscode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取微信账户主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxaccountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxaccount");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("微信账户主键标识"); 
		return column;
	}
	/**
	 * 获取微信服务号配置ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxsettingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxsetting");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信服务号配置ID"); 
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
	 * 获取微信唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpenidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Openid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信唯一码"); 
		return column;
	}
	/**
	 * 获取语言表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLanguageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Language");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言"); 
		return column;
	}
	/**
	 * 获取城市表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"City");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("城市"); 
		return column;
	}
	/**
	 * 获取省份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProvinceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Province");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("省份"); 
		return column;
	}
	/**
	 * 获取国家表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCountryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Country");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家"); 
		return column;
	}
	/**
	 * 获取头像地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeadimgurlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Headimgurl");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("头像地址"); 
		return column;
	}
	/**
	 * 获取关注时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubscribe_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subscribe_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("关注时间"); 
		return column;
	}
	/**
	 * 获取关注状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubscribeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subscribe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关注状态"); 
		return column;
	}
	/**
	 * 获取绑定患者数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatientcountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patientcount");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("绑定患者数"); 
		return column;
	}
	/**
	 * 获取账号状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSt_accountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"St_account");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账号状态"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取displaynam16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGroupidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Groupid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam16"); 
		return column;
	}
	/**
	 * 获取默认家属表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDefaultfnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Defaultfno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认家属"); 
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
	 * 获取当前就诊人ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxmemberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxmember");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前就诊人ID"); 
		return column;
	}
	/**
	 * 获取当前就诊记录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前就诊记录ID"); 
		return column;
	}
	/**
	 * 获取昵称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNicknameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nickname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("昵称"); 
		return column;
	}
	/**
	 * 获取绑定标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bind");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("绑定标识"); 
		return column;
	}
	/**
	 * 获取绑定时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_bind");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("绑定时间"); 
		return column;
	}
	/**
	 * 获取解除绑定时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_unbindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_unbind");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("解除绑定时间"); 
		return column;
	}
	/**
	 * 获取微信备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信备注"); 
		return column;
	}
	/**
	 * 获取displaynam33表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubscribe_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subscribe_scene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam33"); 
		return column;
	}
	/**
	 * 获取displaynam34表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQr_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qr_scene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam34"); 
		return column;
	}
	/**
	 * 获取displaynam35表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQr_scene_strCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qr_scene_str");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam35"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取取消关注时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnsubscribe_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unsubscribe_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取消关注时间"); 
		return column;
	}
	/**
	 * 获取用户分组标签表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxtagsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxtags");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户分组标签"); 
		return column;
	}
	/**
	 * 获取账户类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAcctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Acctp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("账户类型"); 
		return column;
	}
	/**
	 * 获取服务号编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_serviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_service");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务号编码"); 
		return column;
	}
	/**
	 * 获取微信服务号名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_serviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_service");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信服务号名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rel");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("关系"); 
		return column;
	}
	/**
	 * 获取默认就诊人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_def");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认就诊人"); 
		return column;
	}
	/**
	 * 获取就诊卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCardcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cardcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊卡号"); 
		return column;
	}
	/**
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ipcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
		return column;
	}
	/**
	 * 获取电子就诊卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEcardnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ecardno");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电子就诊卡号"); 
		return column;
	}
	/**
	 * 获取HIS患者编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIS患者编号"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
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
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取移动电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动电话"); 
		return column;
	}
	/**
	 * 获取门诊就诊次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOptimesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Optimes");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("门诊就诊次数"); 
		return column;
	}
	/**
	 * 获取住院就诊次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIptimesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iptimes");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院就诊次数"); 
		return column;
	}
	/**
	 * 获取接诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDtacptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dtacpt");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("接诊时间"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entpcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPhydepidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Phydepid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取就诊科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPhydepcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Phydepcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室编码"); 
		return column;
	}
	/**
	 * 获取状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStatuscodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Statuscode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pisivxaccount");
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
