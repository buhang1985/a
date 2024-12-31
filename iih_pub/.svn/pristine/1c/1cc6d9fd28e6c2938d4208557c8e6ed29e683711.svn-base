
package iih.pis.ivx.pisivxsetting.d.desc;

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
 * 微信服务-微信服务号配置 DO 元数据信息
 */
public class PisIvxSettingDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pis.ivx.pisivxsetting.d.PisIvxSettingDO";
	public static final String CLASS_DISPALYNAME = "微信服务-微信服务号配置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pis_ivx_setting";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pisivxsetting";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PisIvxSettingDODesc(){
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
		this.setKeyDesc(getId_pisivxsettingADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pisivxsettingADesc(tblDesc));
		this.add(getId_pisivxsetting_parADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getAppidADesc(tblDesc));
		this.add(getAppsecrectADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getBackurlADesc(tblDesc));
		this.add(getBacktokenADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_debugADesc(tblDesc));
		this.add(getOpenid_debugADesc(tblDesc));
		this.add(getLprotocolADesc(tblDesc));
		this.add(getLhostADesc(tblDesc));
		this.add(getLportADesc(tblDesc));
		this.add(getLpathADesc(tblDesc));
		this.add(getUsercodeADesc(tblDesc));
		this.add(getAuthdomainADesc(tblDesc));
		this.add(getTc_secretidADesc(tblDesc));
		this.add(getTc_secretkeyADesc(tblDesc));
		this.add(getTc_endpointADesc(tblDesc));
		this.add(getMsgwelcomeADesc(tblDesc));
		this.add(getFg_releasedADesc(tblDesc));
		this.add(getTrain_urlADesc(tblDesc));
		this.add(getCode_parADesc(tblDesc));
		this.add(getName_parADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pisivxsettingCDesc(tblDesc));
		tblDesc.add(getId_pisivxsettingCDesc(tblDesc));
		tblDesc.add(getId_pisivxsetting_parCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getAppidCDesc(tblDesc));
		tblDesc.add(getAppsecrectCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getBackurlCDesc(tblDesc));
		tblDesc.add(getBacktokenCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_debugCDesc(tblDesc));
		tblDesc.add(getOpenid_debugCDesc(tblDesc));
		tblDesc.add(getLprotocolCDesc(tblDesc));
		tblDesc.add(getLhostCDesc(tblDesc));
		tblDesc.add(getLportCDesc(tblDesc));
		tblDesc.add(getLpathCDesc(tblDesc));
		tblDesc.add(getUsercodeCDesc(tblDesc));
		tblDesc.add(getAuthdomainCDesc(tblDesc));
		tblDesc.add(getTc_secretidCDesc(tblDesc));
		tblDesc.add(getTc_secretkeyCDesc(tblDesc));
		tblDesc.add(getTc_endpointCDesc(tblDesc));
		tblDesc.add(getMsgwelcomeCDesc(tblDesc));
		tblDesc.add(getFg_releasedCDesc(tblDesc));
		tblDesc.add(getTrain_urlCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 微信服务号配置主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxsettingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxsetting",  getId_pisivxsettingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信服务号配置主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信服务号配置父ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxsetting_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxsetting_par",  getId_pisivxsetting_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信服务号配置父ID");
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
	 * 开发者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAppidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Appid",  getAppidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开发者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开发者密码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAppsecrectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Appsecrect",  getAppsecrectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开发者密码");
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
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务号编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信服务号名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信服务号名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * backurl属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackurlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backurl",  getBackurlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("backurl");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * backtoken属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBacktokenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backtoken",  getBacktokenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("backtoken");
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
	 * 调试模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_debugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_debug",  getFg_debugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("调试模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调试模式下的OpenId属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpenid_debugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Openid_debug",  getOpenid_debugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调试模式下的OpenId");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本地网络协议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLprotocolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lprotocol",  getLprotocolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("本地网络协议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本地主机域名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLhostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lhost",  getLhostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("本地主机域名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本地主机端口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lport",  getLportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("本地主机端口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本地主机路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLpathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lpath",  getLpathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("本地主机路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usercode",  getUsercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 验证域名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAuthdomainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Authdomain",  getAuthdomainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("验证域名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腾讯云SecretId属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_secretidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_secretid",  getTc_secretidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腾讯云SecretId");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腾讯云SECRETKEY属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_secretkeyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_secretkey",  getTc_secretkeyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腾讯云SECRETKEY");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腾信云身份证人脸验证接口地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTc_endpointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tc_endpoint",  getTc_endpointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腾信云身份证人脸验证接口地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 欢迎消息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMsgwelcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Msgwelcome",  getMsgwelcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("欢迎消息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发布标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_releasedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_released",  getFg_releasedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("发布标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 培训课程地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrain_urlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Train_url",  getTrain_urlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("培训课程地址");
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
	private IAttrDesc getCode_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_par",  getCode_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务号编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_setting a0b6","id_pisivxsetting_par=id_pisivxsetting","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信服务号名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_par",  getName_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信服务号名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pis_ivx_setting a0b6","id_pisivxsetting_par=id_pisivxsetting","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取微信服务号配置主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxsettingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxsetting");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("微信服务号配置主键标识"); 
		return column;
	}
	/**
	 * 获取微信服务号配置父ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxsetting_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxsetting_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信服务号配置父ID"); 
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
	 * 获取开发者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAppidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Appid");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开发者ID"); 
		return column;
	}
	/**
	 * 获取开发者密码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAppsecrectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Appsecrect");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开发者密码"); 
		return column;
	}
	/**
	 * 获取服务号编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
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
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信服务号名称"); 
		return column;
	}
	/**
	 * 获取backurl表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackurlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backurl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("backurl"); 
		return column;
	}
	/**
	 * 获取backtoken表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBacktokenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backtoken");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("backtoken"); 
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
	 * 获取调试模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_debugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_debug");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调试模式"); 
		return column;
	}
	/**
	 * 获取调试模式下的OpenId表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpenid_debugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Openid_debug");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调试模式下的OpenId"); 
		return column;
	}
	/**
	 * 获取本地网络协议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLprotocolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lprotocol");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("本地网络协议"); 
		return column;
	}
	/**
	 * 获取本地主机域名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLhostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lhost");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("本地主机域名"); 
		return column;
	}
	/**
	 * 获取本地主机端口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lport");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("本地主机端口"); 
		return column;
	}
	/**
	 * 获取本地主机路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLpathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lpath");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("本地主机路径"); 
		return column;
	}
	/**
	 * 获取操作员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usercode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作员编码"); 
		return column;
	}
	/**
	 * 获取验证域名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAuthdomainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Authdomain");
		column.setLength(120);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("验证域名"); 
		return column;
	}
	/**
	 * 获取腾讯云SecretId表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_secretidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_secretid");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腾讯云SecretId"); 
		return column;
	}
	/**
	 * 获取腾讯云SECRETKEY表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_secretkeyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_secretkey");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腾讯云SECRETKEY"); 
		return column;
	}
	/**
	 * 获取腾信云身份证人脸验证接口地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTc_endpointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tc_endpoint");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腾信云身份证人脸验证接口地址"); 
		return column;
	}
	/**
	 * 获取欢迎消息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMsgwelcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Msgwelcome");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("欢迎消息"); 
		return column;
	}
	/**
	 * 获取发布标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_releasedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_released");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发布标识"); 
		return column;
	}
	/**
	 * 获取培训课程地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrain_urlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Train_url");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("培训课程地址"); 
		return column;
	}
	/**
	 * 获取服务号编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_par");
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
	private IColumnDesc getName_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信服务号名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pisivxsetting");
		iBDDataInfoFldMap.put("pid","Id_pisivxsetting_par");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
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
