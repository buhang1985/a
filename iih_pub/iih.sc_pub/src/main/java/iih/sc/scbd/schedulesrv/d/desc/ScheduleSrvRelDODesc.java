
package iih.sc.scbd.schedulesrv.d.desc;

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
 * 排班资源对照 DO 元数据信息
 */
public class ScheduleSrvRelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO";
	public static final String CLASS_DISPALYNAME = "排班资源对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_srv_rel";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_scsrvrel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScheduleSrvRelDODesc(){
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
		this.setKeyDesc(getId_scsrvrelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_scsrvADesc(tblDesc));
		this.add(getId_scsrvrelADesc(tblDesc));
		this.add(getId_scsrvADesc(tblDesc));
		this.add(getId_mdsrvADesc(tblDesc));
		this.add(getFg_majADesc(tblDesc));
		this.add(getName_scsrvADesc(tblDesc));
		this.add(getCode_scsrvADesc(tblDesc));
		this.add(getCode_mdsrvADesc(tblDesc));
		this.add(getName_mdsrvADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getPri_mdsrvADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_scsrvrelCDesc(tblDesc));
		tblDesc.add(getId_scsrvrelCDesc(tblDesc));
		tblDesc.add(getId_scsrvCDesc(tblDesc));
		tblDesc.add(getId_mdsrvCDesc(tblDesc));
		tblDesc.add(getFg_majCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 排班服务对照ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scsrvrelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsrvrel",  getId_scsrvrelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务对照ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsrv",  getId_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mdsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mdsrv",  getId_mdsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否主要属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_majADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_maj",  getFg_majCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否主要");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scsrv",  getName_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a1b1","id_scsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scsrv",  getCode_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a1b1","id_scsrv=id_scsrv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mdsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mdsrv",  getCode_mdsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_mdsrv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mdsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mdsrv",  getName_mdsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_mdsrv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_mdsrv=id_srv","sd_srvtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvtp",  getId_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_mdsrv=id_srv","id_srvtp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 参考价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_mdsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_mdsrv",  getPri_mdsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("参考价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b2","id_mdsrv=id_srv","pri"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取排班服务对照ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsrvrelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsrvrel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班服务对照ID"); 
		return column;
	}
	/**
	 * 获取排班服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务"); 
		return column;
	}
	/**
	 * 获取医疗服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mdsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mdsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务"); 
		return column;
	}
	/**
	 * 获取是否主要表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_majCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_maj");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否主要"); 
		return column;
	}
	/**
	 * 获取排班服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务名称"); 
		return column;
	}
	/**
	 * 获取排班服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务编码"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mdsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mdsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mdsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mdsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取服务类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型编码"); 
		return column;
	}
	/**
	 * 获取服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型"); 
		return column;
	}
	/**
	 * 获取参考价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_mdsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_mdsrv");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("参考价格"); 
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
