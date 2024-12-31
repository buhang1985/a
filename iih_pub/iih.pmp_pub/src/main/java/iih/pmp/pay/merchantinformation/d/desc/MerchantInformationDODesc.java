
package iih.pmp.pay.merchantinformation.d.desc;

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
 * 商户信息 DO 元数据信息
 */
public class MerchantInformationDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pmp.pay.merchantinformation.d.MerchantInformationDO";
	public static final String CLASS_DISPALYNAME = "商户信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pmp_merchantinformation";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_config";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MerchantInformationDODesc(){
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
		this.setKeyDesc(getId_configADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_configADesc(tblDesc));
		this.add(getId_appADesc(tblDesc));
		this.add(getPidADesc(tblDesc));
		this.add(getId_mchADesc(tblDesc));
		this.add(getPrivate_keyADesc(tblDesc));
		this.add(getPublic_keyADesc(tblDesc));
		this.add(getNotify_urlADesc(tblDesc));
		this.add(getPaychannelsADesc(tblDesc));
		this.add(getSigntypeADesc(tblDesc));
		this.add(getMaxqueryretryADesc(tblDesc));
		this.add(getQuerydurationADesc(tblDesc));
		this.add(getMaxcancelretryADesc(tblDesc));
		this.add(getCanceldurationADesc(tblDesc));
		this.add(getHeartbeatdelayADesc(tblDesc));
		this.add(getHeartbeatdurationADesc(tblDesc));
		this.add(getKeyADesc(tblDesc));
		this.add(getCertADesc(tblDesc));
		this.add(getReadtimeoutADesc(tblDesc));
		this.add(getConnecttimeoutADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_configCDesc(tblDesc));
		tblDesc.add(getId_configCDesc(tblDesc));
		tblDesc.add(getId_appCDesc(tblDesc));
		tblDesc.add(getPidCDesc(tblDesc));
		tblDesc.add(getId_mchCDesc(tblDesc));
		tblDesc.add(getPrivate_keyCDesc(tblDesc));
		tblDesc.add(getPublic_keyCDesc(tblDesc));
		tblDesc.add(getNotify_urlCDesc(tblDesc));
		tblDesc.add(getPaychannelsCDesc(tblDesc));
		tblDesc.add(getSigntypeCDesc(tblDesc));
		tblDesc.add(getMaxqueryretryCDesc(tblDesc));
		tblDesc.add(getQuerydurationCDesc(tblDesc));
		tblDesc.add(getMaxcancelretryCDesc(tblDesc));
		tblDesc.add(getCanceldurationCDesc(tblDesc));
		tblDesc.add(getHeartbeatdelayCDesc(tblDesc));
		tblDesc.add(getHeartbeatdurationCDesc(tblDesc));
		tblDesc.add(getKeyCDesc(tblDesc));
		tblDesc.add(getCertCDesc(tblDesc));
		tblDesc.add(getReadtimeoutCDesc(tblDesc));
		tblDesc.add(getConnecttimeoutCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_configADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_config",  getId_configCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_app",  getId_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * partnerid属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pid",  getPidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("partnerid");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * MchID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mch",  getId_mchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("MchID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 私钥属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrivate_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Private_key",  getPrivate_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("私钥");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公钥属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPublic_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Public_key",  getPublic_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("公钥");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 回调地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNotify_urlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Notify_url",  getNotify_urlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("回调地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaychannelsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paychannels",  getPaychannelsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("支付类型");
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
	private IAttrDesc getSigntypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Signtype",  getSigntypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大查询次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMaxqueryretryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Maxqueryretry",  getMaxqueryretryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大查询次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查询间隔（毫秒）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuerydurationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Queryduration",  getQuerydurationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("查询间隔（毫秒）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大撤销次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMaxcancelretryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Maxcancelretry",  getMaxcancelretryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大撤销次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 撤销间隔（毫秒）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCanceldurationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cancelduration",  getCanceldurationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("撤销间隔（毫秒）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 线程延迟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartbeatdelayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartbeatdelay",  getHeartbeatdelayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("线程延迟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartbeatdurationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartbeatduration",  getHeartbeatdurationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("交易间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 *  API密钥属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKeyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Key",  getKeyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel(" API密钥");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证书内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCertADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cert",  getCertCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("证书内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 读数据超时时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReadtimeoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Readtimeout",  getReadtimeoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("读数据超时时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 连接超时时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConnecttimeoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Connecttimeout",  getConnecttimeoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("连接超时时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否启用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否启用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_configCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_config");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取服务号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_app");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务号"); 
		return column;
	}
	/**
	 * 获取partnerid表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("partnerid"); 
		return column;
	}
	/**
	 * 获取MchID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("MchID"); 
		return column;
	}
	/**
	 * 获取私钥表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrivate_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Private_key");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("私钥"); 
		return column;
	}
	/**
	 * 获取公钥表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPublic_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Public_key");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("公钥"); 
		return column;
	}
	/**
	 * 获取回调地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNotify_urlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Notify_url");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("回调地址"); 
		return column;
	}
	/**
	 * 获取支付类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaychannelsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paychannels");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("支付类型"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSigntypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Signtype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取最大查询次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMaxqueryretryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Maxqueryretry");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大查询次数"); 
		return column;
	}
	/**
	 * 获取查询间隔（毫秒）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuerydurationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Queryduration");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("查询间隔（毫秒）"); 
		return column;
	}
	/**
	 * 获取最大撤销次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMaxcancelretryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Maxcancelretry");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大撤销次数"); 
		return column;
	}
	/**
	 * 获取撤销间隔（毫秒）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCanceldurationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cancelduration");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("撤销间隔（毫秒）"); 
		return column;
	}
	/**
	 * 获取线程延迟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartbeatdelayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartbeatdelay");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("线程延迟"); 
		return column;
	}
	/**
	 * 获取交易间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartbeatdurationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartbeatduration");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("交易间隔"); 
		return column;
	}
	/**
	 * 获取 API密钥表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKeyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Key");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel(" API密钥"); 
		return column;
	}
	/**
	 * 获取证书内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCertCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cert");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("证书内容"); 
		return column;
	}
	/**
	 * 获取读数据超时时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReadtimeoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Readtimeout");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("读数据超时时间"); 
		return column;
	}
	/**
	 * 获取连接超时时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConnecttimeoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Connecttimeout");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("连接超时时间"); 
		return column;
	}
	/**
	 * 获取是否启用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否启用"); 
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
