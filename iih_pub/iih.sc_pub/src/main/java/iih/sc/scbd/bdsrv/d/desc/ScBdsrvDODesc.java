
package iih.sc.scbd.bdsrv.d.desc;

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
 * 排班计划_医疗服务 DO 元数据信息
 */
public class ScBdsrvDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scbd.bdsrv.d.ScBdsrvDO";
	public static final String CLASS_DISPALYNAME = "排班计划_医疗服务";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_bdsrv";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_scbdsrv";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;

	/**
	 * 无参构造函数
	 */
	public ScBdsrvDODesc(){
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
		this.setKeyDesc(getId_scbdsrvADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_scbdsrvADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_sccaADesc(tblDesc));
		this.add(getSrvslotADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_needcfmADesc(tblDesc));
		this.add(getFg_autoapt_opADesc(tblDesc));
		this.add(getFg_autoapt_ipADesc(tblDesc));
		this.add(getNum_days_validADesc(tblDesc));
		this.add(getPriADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getCode_sccaADesc(tblDesc));
		this.add(getName_sccaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_scbdsrvCDesc(tblDesc));
		tblDesc.add(getId_scbdsrvCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_sccaCDesc(tblDesc));
		tblDesc.add(getSrvslotCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_needcfmCDesc(tblDesc));
		tblDesc.add(getFg_autoapt_opCDesc(tblDesc));
		tblDesc.add(getFg_autoapt_ipCDesc(tblDesc));
		tblDesc.add(getNum_days_validCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);

		return tblDesc;
	}

	/**
	 * sc医疗服务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scbdsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scbdsrv",  getId_scbdsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("sc医疗服务id");
		attrDesc.setNullable(true);
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
	 * 医疗服务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scca",  getId_sccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvslot",  getSrvslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("时长");
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
	 * 需确认标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needcfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needcfm",  getFg_needcfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("需确认标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊是否自动预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_autoapt_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_autoapt_op",  getFg_autoapt_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("门诊是否自动预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院是否自动预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_autoapt_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_autoapt_ip",  getFg_autoapt_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("住院是否自动预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗项目有效期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_days_validADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_days_valid",  getNum_days_validCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("诊疗项目有效期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri",  getPriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("参考价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b2","id_srv=id_srv","pri"});
		attrDesc.setRefType(false);
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
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b2","id_srv=id_srv","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b2","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scca",  getCode_sccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_ca a0b3","id_scca=id_scca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scca",  getName_sccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_ca a0b3","id_scca=id_scca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取sc医疗服务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scbdsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scbdsrv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("sc医疗服务id");
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
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团");
		return column;
	}
	/**
	 * 获取医疗服务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务id");
		return column;
	}
	/**
	 * 获取排班分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班分类");
		return column;
	}
	/**
	 * 获取时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvslot");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("时长");
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
	 * 获取需确认标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needcfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needcfm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("需确认标志");
		return column;
	}
	/**
	 * 获取门诊是否自动预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_autoapt_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_autoapt_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊是否自动预约");
		return column;
	}
	/**
	 * 获取住院是否自动预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_autoapt_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_autoapt_ip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院是否自动预约");
		return column;
	}
	/**
	 * 获取诊疗项目有效期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_days_validCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_days_valid");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("诊疗项目有效期");
		return column;
	}
	/**
	 * 获取参考价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("参考价格");
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
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
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称");
		return column;
	}
	/**
	 * 获取排班分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班分类编码");
		return column;
	}
	/**
	 * 获取排班分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班分类名称");
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_scbdsrv");
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
