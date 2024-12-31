
package iih.bd.srv.mrtaskrule.d.desc;

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
 * 病历书写任务排斥 DO 元数据信息
 */
public class MrTaskRuleExcludeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.mrtaskrule.d.MrTaskRuleExcludeDO";
	public static final String CLASS_DISPALYNAME = "病历书写任务排斥";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mr_tr_ec";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_mr_tr_ec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MrTaskRuleExcludeDODesc(){
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
		this.setKeyDesc(getId_mr_tr_ecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mr_task_ruleADesc(tblDesc));
		this.add(getId_mr_tr_ecADesc(tblDesc));
		this.add(getId_mr_task_ruleADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getExclude_codeADesc(tblDesc));
		this.add(getExclude_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mr_tr_ecCDesc(tblDesc));
		tblDesc.add(getId_mr_tr_ecCDesc(tblDesc));
		tblDesc.add(getId_mr_task_ruleCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 排斥表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_tr_ecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_tr_ec",  getId_mr_tr_ecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排斥表主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_task_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_task_rule",  getId_mr_task_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主表主键");
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
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExclude_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exclude_code",  getExclude_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a2b3","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExclude_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exclude_name",  getExclude_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a2b3","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取排斥表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_tr_ecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_tr_ec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排斥表主键"); 
		return column;
	}
	/**
	 * 获取主表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_task_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_task_rule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主表主键"); 
		return column;
	}
	/**
	 * 获取医疗服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExclude_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exclude_code");
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
	private IColumnDesc getExclude_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exclude_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
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
