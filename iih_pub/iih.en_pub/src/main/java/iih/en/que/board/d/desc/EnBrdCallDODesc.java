
package iih.en.que.board.d.desc;

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
 * 大屏叫号信息 DO 元数据信息
 */
public class EnBrdCallDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.que.board.d.EnBrdCallDO";
	public static final String CLASS_DISPALYNAME = "大屏叫号信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_brd_call";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_enbrdcall";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnBrdCallDODesc(){
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
		this.setKeyDesc(getId_enbrdcallADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_enbrdcallADesc(tblDesc));
		this.add(getId_brdADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getCode_siteADesc(tblDesc));
		this.add(getName_siteADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_deptADesc(tblDesc));
		this.add(getRes_nameADesc(tblDesc));
		this.add(getTick_noADesc(tblDesc));
		this.add(getDt_insertADesc(tblDesc));
		this.add(getDt_callADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_srvtpADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAddr_brdADesc(tblDesc));
		this.add(getCode_patADesc(tblDesc));
		this.add(getId_pc_board2ADesc(tblDesc));
		this.add(getName_call_patADesc(tblDesc));
		this.add(getId_pcADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_enbrdcallCDesc(tblDesc));
		tblDesc.add(getId_enbrdcallCDesc(tblDesc));
		tblDesc.add(getId_brdCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getCode_siteCDesc(tblDesc));
		tblDesc.add(getName_siteCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_deptCDesc(tblDesc));
		tblDesc.add(getRes_nameCDesc(tblDesc));
		tblDesc.add(getTick_noCDesc(tblDesc));
		tblDesc.add(getDt_insertCDesc(tblDesc));
		tblDesc.add(getDt_callCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_srvtpCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAddr_brdCDesc(tblDesc));
		tblDesc.add(getCode_patCDesc(tblDesc));
		tblDesc.add(getId_pc_board2CDesc(tblDesc));
		tblDesc.add(getName_call_patCDesc(tblDesc));
		tblDesc.add(getId_pcCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 大屏叫号ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enbrdcallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enbrdcall",  getId_enbrdcallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大屏叫号ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大屏ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_brdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_brd",  getId_brdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大屏ID");
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
	 * 站点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_site",  getCode_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("站点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 站点名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_site",  getName_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("站点名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept",  getName_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Res_name",  getRes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTick_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tick_no",  getTick_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("票号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 插入时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_insertADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_insert",  getDt_insertCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("插入时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 叫号时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_callADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_call",  getDt_callCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("叫号时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srvtp",  getName_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号别");
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
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
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
	 * 大屏地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_brdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_brd",  getAddr_brdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大屏地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat",  getCode_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二次屏pc属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pc_board2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pc_board2",  getId_pc_board2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("二次屏pc");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 叫号患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_call_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_call_pat",  getName_call_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("叫号患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 显示屏pc属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pc",  getId_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("显示屏pc");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取大屏叫号ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enbrdcallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enbrdcall");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("大屏叫号ID"); 
		return column;
	}
	/**
	 * 获取大屏ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_brdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_brd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大屏ID"); 
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
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取站点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("站点编码"); 
		return column;
	}
	/**
	 * 获取站点名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("站点名称"); 
		return column;
	}
	/**
	 * 获取就诊姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊姓名"); 
		return column;
	}
	/**
	 * 获取科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室名称"); 
		return column;
	}
	/**
	 * 获取资源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Res_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资源名称"); 
		return column;
	}
	/**
	 * 获取票号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTick_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tick_no");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("票号"); 
		return column;
	}
	/**
	 * 获取插入时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_insertCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_insert");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("插入时间"); 
		return column;
	}
	/**
	 * 获取叫号时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_callCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_call");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("叫号时间"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取号别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号别"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取大屏地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_brdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_brd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大屏地址"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取二次屏pc表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pc_board2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pc_board2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("二次屏pc"); 
		return column;
	}
	/**
	 * 获取叫号患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_call_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_call_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("叫号患者姓名"); 
		return column;
	}
	/**
	 * 获取显示屏pc表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("显示屏pc"); 
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
