
package iih.ci.mrm.cimrmsupplement.d.desc;

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
 * 病案补充记录 DO 元数据信息
 */
public class CiMrmSupplementDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.cimrmsupplement.d.CiMrmSupplementDO";
	public static final String CLASS_DISPALYNAME = "病案补充记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_su";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ci_mrm_su";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrmSupplementDODesc(){
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
		this.setKeyDesc(getId_ci_mrm_suADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ci_mrm_suADesc(tblDesc));
		this.add(getId_ci_amrADesc(tblDesc));
		this.add(getId_bd_mrm_tpADesc(tblDesc));
		this.add(getId_ci_mrm_fiADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_bd_mrm_tpADesc(tblDesc));
		this.add(getCode_bd_mrm_tpADesc(tblDesc));
		this.add(getName_ci_mrm_fiADesc(tblDesc));
		this.add(getSortno_ci_mrm_fiADesc(tblDesc));
		this.add(getCode_file_ci_mrm_fiADesc(tblDesc));
		this.add(getDsc_su_ci_mrm_fiADesc(tblDesc));
		this.add(getId_psn_su_ci_mrm_fiADesc(tblDesc));
		this.add(getDt_psn_su_ci_mrm_fiADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ci_mrm_suCDesc(tblDesc));
		tblDesc.add(getId_ci_mrm_suCDesc(tblDesc));
		tblDesc.add(getId_ci_amrCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_tpCDesc(tblDesc));
		tblDesc.add(getId_ci_mrm_fiCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ci_mrm_suADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ci_mrm_su",  getId_ci_mrm_suCDesc(tblDesc), this);
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
	 * 病案主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ci_amrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ci_amr",  getId_ci_amrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案分类主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_tp",  getId_bd_mrm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案分类主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案文件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ci_mrm_fi",  getId_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案文件主键");
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
	 * 病案分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bd_mrm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bd_mrm_tp",  getName_bd_mrm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_tp a0b2","id_bd_mrm_tp=id_bd_mrm_tp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_bd_mrm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_bd_mrm_tp",  getCode_bd_mrm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrm_tp a0b2","id_bd_mrm_tp=id_bd_mrm_tp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ci_mrm_fi",  getName_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_fi a0b3","id_ci_mrm_fi=id_ci_mrm_fi","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排序属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortno_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno_ci_mrm_fi",  getSortno_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("排序");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_fi a0b3","id_ci_mrm_fi=id_ci_mrm_fi","sortno"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文件系统编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_file_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_file_ci_mrm_fi",  getCode_file_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文件系统编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_fi a0b3","id_ci_mrm_fi=id_ci_mrm_fi","code_file"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补充描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDsc_su_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dsc_su_ci_mrm_fi",  getDsc_su_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补充描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_fi a0b3","id_ci_mrm_fi=id_ci_mrm_fi","dsc_su"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补充人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_su_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_su_ci_mrm_fi",  getId_psn_su_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补充人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_fi a0b3","id_ci_mrm_fi=id_ci_mrm_fi","id_psn_su"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 补充时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_psn_su_ci_mrm_fiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_psn_su_ci_mrm_fi",  getDt_psn_su_ci_mrm_fiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("补充时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_fi a0b3","id_ci_mrm_fi=id_ci_mrm_fi","dt_psn_su"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ci_mrm_suCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ci_mrm_su");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取病案主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ci_amrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ci_amr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案主键"); 
		return column;
	}
	/**
	 * 获取病案分类主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案分类主键"); 
		return column;
	}
	/**
	 * 获取病案文件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ci_mrm_fi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案文件主键"); 
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
	 * 获取病案分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bd_mrm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bd_mrm_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案分类名称"); 
		return column;
	}
	/**
	 * 获取病案分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_bd_mrm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_bd_mrm_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案分类编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ci_mrm_fi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取排序表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortno_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno_ci_mrm_fi");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("排序"); 
		return column;
	}
	/**
	 * 获取文件系统编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_file_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_file_ci_mrm_fi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文件系统编码"); 
		return column;
	}
	/**
	 * 获取补充描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDsc_su_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dsc_su_ci_mrm_fi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补充描述"); 
		return column;
	}
	/**
	 * 获取补充人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_su_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_su_ci_mrm_fi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补充人"); 
		return column;
	}
	/**
	 * 获取补充时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_psn_su_ci_mrm_fiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_psn_su_ci_mrm_fi");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("补充时间"); 
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
