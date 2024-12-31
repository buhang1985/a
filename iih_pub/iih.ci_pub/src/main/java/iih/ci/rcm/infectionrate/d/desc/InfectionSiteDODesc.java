
package iih.ci.rcm.infectionrate.d.desc;

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
 * 感染部位 DO 元数据信息
 */
public class InfectionSiteDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.infectionrate.d.InfectionSiteDO";
	public static final String CLASS_DISPALYNAME = "感染部位";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_rcm_infectsite";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_infectsite";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public InfectionSiteDODesc(){
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
		this.setKeyDesc(getId_infectsiteADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mmratehospitalinfectionADesc(tblDesc));
		this.add(getId_infectsiteADesc(tblDesc));
		this.add(getInfectedateADesc(tblDesc));
		this.add(getId_pathogenADesc(tblDesc));
		this.add(getSd_pathogenADesc(tblDesc));
		this.add(getName_pathogenADesc(tblDesc));
		this.add(getId_drugsenresultADesc(tblDesc));
		this.add(getSd_drugsenresultADesc(tblDesc));
		this.add(getName_drugsenresultADesc(tblDesc));
		this.add(getId_infecte_siteADesc(tblDesc));
		this.add(getSd_infecte_siteADesc(tblDesc));
		this.add(getName_infecte_siteADesc(tblDesc));
		this.add(getId_mmratehospitalinfectionADesc(tblDesc));
		this.add(getPathogen_codeADesc(tblDesc));
		this.add(getPathogen_nameADesc(tblDesc));
		this.add(getDrugsenresult_codeADesc(tblDesc));
		this.add(getDrugsenresult_nameADesc(tblDesc));
		this.add(getInfecte_site_codeADesc(tblDesc));
		this.add(getInfecte_site_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_infectsiteCDesc(tblDesc));
		tblDesc.add(getId_infectsiteCDesc(tblDesc));
		tblDesc.add(getInfectedateCDesc(tblDesc));
		tblDesc.add(getId_pathogenCDesc(tblDesc));
		tblDesc.add(getSd_pathogenCDesc(tblDesc));
		tblDesc.add(getName_pathogenCDesc(tblDesc));
		tblDesc.add(getId_drugsenresultCDesc(tblDesc));
		tblDesc.add(getSd_drugsenresultCDesc(tblDesc));
		tblDesc.add(getName_drugsenresultCDesc(tblDesc));
		tblDesc.add(getId_infecte_siteCDesc(tblDesc));
		tblDesc.add(getSd_infecte_siteCDesc(tblDesc));
		tblDesc.add(getName_infecte_siteCDesc(tblDesc));
		tblDesc.add(getId_mmratehospitalinfectionCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 感染部位主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infectsiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infectsite",  getId_infectsiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfectedateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infectedate",  getInfectedateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("感染日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原体属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pathogenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pathogen",  getId_pathogenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病原体");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病原体编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pathogenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pathogen",  getSd_pathogenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病原体编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原体名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pathogenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pathogen",  getName_pathogenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病原体名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药敏结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugsenresultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drugsenresult",  getId_drugsenresultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药敏结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drugsenresultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drugsenresult",  getSd_drugsenresultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药敏结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drugsenresultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drugsenresult",  getName_drugsenresultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infecte_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infecte_site",  getId_infecte_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infecte_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infecte_site",  getSd_infecte_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infecte_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infecte_site",  getName_infecte_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院感染现患率主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmratehospitalinfectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmratehospitalinfection",  getId_mmratehospitalinfectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院感染现患率主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPathogen_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pathogen_code",  getPathogen_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_pathogen=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPathogen_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pathogen_name",  getPathogen_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_pathogen=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugsenresult_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugsenresult_code",  getDrugsenresult_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_drugsenresult=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugsenresult_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugsenresult_name",  getDrugsenresult_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_drugsenresult=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfecte_site_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infecte_site_code",  getInfecte_site_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_infecte_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfecte_site_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infecte_site_name",  getInfecte_site_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_infecte_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取感染部位主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infectsiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infectsite");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("感染部位主键"); 
		return column;
	}
	/**
	 * 获取感染日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfectedateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infectedate");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("感染日期"); 
		return column;
	}
	/**
	 * 获取病原体表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pathogenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pathogen");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体"); 
		return column;
	}
	/**
	 * 获取病原体编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pathogenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pathogen");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体编码"); 
		return column;
	}
	/**
	 * 获取病原体名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pathogenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pathogen");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体名称"); 
		return column;
	}
	/**
	 * 获取药敏结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugsenresultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drugsenresult");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏结果"); 
		return column;
	}
	/**
	 * 获取药敏结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drugsenresultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drugsenresult");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏结果编码"); 
		return column;
	}
	/**
	 * 获取药敏结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drugsenresultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drugsenresult");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏结果名称"); 
		return column;
	}
	/**
	 * 获取感染部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infecte_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infecte_site");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位"); 
		return column;
	}
	/**
	 * 获取感染部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infecte_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infecte_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位编码"); 
		return column;
	}
	/**
	 * 获取感染部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infecte_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infecte_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位名称"); 
		return column;
	}
	/**
	 * 获取医院感染现患率主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmratehospitalinfectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmratehospitalinfection");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院感染现患率主键"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPathogen_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pathogen_code");
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
	private IColumnDesc getPathogen_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pathogen_name");
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
	private IColumnDesc getDrugsenresult_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugsenresult_code");
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
	private IColumnDesc getDrugsenresult_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugsenresult_name");
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
	private IColumnDesc getInfecte_site_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infecte_site_code");
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
	private IColumnDesc getInfecte_site_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infecte_site_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
