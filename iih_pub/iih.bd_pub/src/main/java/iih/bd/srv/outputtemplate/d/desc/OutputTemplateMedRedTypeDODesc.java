
package iih.bd.srv.outputtemplate.d.desc;

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
 * 输出模板对应病案类型 DO 元数据信息
 */
public class OutputTemplateMedRedTypeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.outputtemplate.d.OutputTemplateMedRedTypeDO";
	public static final String CLASS_DISPALYNAME = "输出模板对应病案类型";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrm_pt_tp";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_bd_mrm_pp_tp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OutputTemplateMedRedTypeDODesc(){
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
		this.setKeyDesc(getId_bd_mrm_pp_tpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_bd_mrm_ptADesc(tblDesc));
		this.add(getId_bd_mrm_pp_tpADesc(tblDesc));
		this.add(getId_bd_mrm_ptADesc(tblDesc));
		this.add(getId_bd_mrm_tpADesc(tblDesc));
		this.add(getOutputtemplate_nameADesc(tblDesc));
		this.add(getOutputtemplate_codeADesc(tblDesc));
		this.add(getMrmtype_nameADesc(tblDesc));
		this.add(getMrmtype_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_bd_mrm_pp_tpCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_pp_tpCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_ptCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_tpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_pp_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_pp_tp",  getId_bd_mrm_pp_tpCDesc(tblDesc), this);
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
	 * 输出模板主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_ptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_pt",  getId_bd_mrm_ptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输出模板主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_tp",  getId_bd_mrm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutputtemplate_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outputtemplate_name",  getOutputtemplate_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_pt a1b2","id_bd_mrm_pt=id_bd_mrm_pt","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutputtemplate_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outputtemplate_code",  getOutputtemplate_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_pt a1b2","id_bd_mrm_pt=id_bd_mrm_pt","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrmtype_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrmtype_name",  getMrmtype_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_tp a1b3","id_bd_mrm_tp=id_bd_mrm_tp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrmtype_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrmtype_code",  getMrmtype_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_tp a1b3","id_bd_mrm_tp=id_bd_mrm_tp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_pp_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_pp_tp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取输出模板主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_ptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_pt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输出模板主键"); 
		return column;
	}
	/**
	 * 获取病案分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案分类"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutputtemplate_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outputtemplate_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutputtemplate_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outputtemplate_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrmtype_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrmtype_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrmtype_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrmtype_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
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
