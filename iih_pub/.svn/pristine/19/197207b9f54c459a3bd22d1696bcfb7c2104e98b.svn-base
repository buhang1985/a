
package iih.bd.srv.diagcate.d.desc;

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
 * 疾病诊断分类项目 DO 元数据信息
 */
public class DiCateItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.diagcate.d.DiCateItemDO";
	public static final String CLASS_DISPALYNAME = "疾病诊断分类项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_dica_itm_rel";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_dicaitmrel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DiCateItemDODesc(){
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
		this.setKeyDesc(getId_dicaitmrelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_dicaADesc(tblDesc));
		this.add(getId_dicaitmrelADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_dicaADesc(tblDesc));
		this.add(getId_didefADesc(tblDesc));
		this.add(getId_cdsysADesc(tblDesc));
		this.add(getId_cdsystpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getDica_nameADesc(tblDesc));
		this.add(getDiag_nameADesc(tblDesc));
		this.add(getCode_diagADesc(tblDesc));
		this.add(getSd_cdsystp_diagADesc(tblDesc));
		this.add(getId_distdca_diagADesc(tblDesc));
		this.add(getId_cdsys_diagADesc(tblDesc));
		this.add(getDt_id_cdsystpADesc(tblDesc));
		this.add(getCdsys_nameADesc(tblDesc));
		this.add(getCdsys_codeADesc(tblDesc));
		this.add(getTp_nameADesc(tblDesc));
		this.add(getTp_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dicaitmrelCDesc(tblDesc));
		tblDesc.add(getId_dicaitmrelCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_dicaCDesc(tblDesc));
		tblDesc.add(getId_didefCDesc(tblDesc));
		tblDesc.add(getId_cdsysCDesc(tblDesc));
		tblDesc.add(getId_cdsystpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 疾病诊断基本分类项目关系主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dicaitmrelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dicaitmrel",  getId_dicaitmrelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断基本分类项目关系主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dica",  getId_dicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_didefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_didef",  getId_didefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cdsysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cdsys",  getId_cdsysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断体系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cdsystpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cdsystp",  getId_cdsystpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断体系");
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
	 * 疾病诊断分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDica_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dica_name",  getDica_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dica a1b1","id_dica=id_dica","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_name",  getDiag_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a1b2","id_didef=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_diag",  getCode_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a1b2","id_didef=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断体系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cdsystp_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cdsystp_diag",  getSd_cdsystp_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断体系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a1b2","id_didef=id_didef","sd_cdsystp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断标准分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_distdca_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_distdca_diag",  getId_distdca_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断标准分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a1b2","id_didef=id_didef","id_distdca"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医学编码体系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cdsys_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cdsys_diag",  getId_cdsys_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医学编码体系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a1b2","id_didef=id_didef","id_cdsys"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断体系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_id_cdsystpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_id_cdsystp",  getDt_id_cdsystpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断体系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a1b2","id_didef=id_didef","id_cdsystp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗编码体系名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCdsys_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cdsys_name",  getCdsys_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗编码体系名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cdsys a1b3","id_cdsys=id_cdsys","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗编码体系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCdsys_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cdsys_code",  getCdsys_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗编码体系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cdsys a1b3","id_cdsys=id_cdsys","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tp_name",  getTp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_cdsystp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tp_code",  getTp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_cdsystp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取疾病诊断基本分类项目关系主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dicaitmrelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dicaitmrel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断基本分类项目关系主键标识"); 
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
	 * 获取疾病诊断分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dica");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断分类"); 
		return column;
	}
	/**
	 * 获取疾病诊断项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_didefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_didef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断项目"); 
		return column;
	}
	/**
	 * 获取诊断标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cdsysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cdsys");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断标准"); 
		return column;
	}
	/**
	 * 获取诊断体系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cdsystpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cdsystp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断体系"); 
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
	 * 获取疾病诊断分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDica_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dica_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断分类名称"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_diag");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断体系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cdsystp_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cdsystp_diag");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断体系"); 
		return column;
	}
	/**
	 * 获取诊断标准分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_distdca_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_distdca_diag");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断标准分类"); 
		return column;
	}
	/**
	 * 获取医学编码体系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cdsys_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cdsys_diag");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医学编码体系"); 
		return column;
	}
	/**
	 * 获取诊断体系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_id_cdsystpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_id_cdsystp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断体系"); 
		return column;
	}
	/**
	 * 获取医疗编码体系名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCdsys_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cdsys_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗编码体系名称"); 
		return column;
	}
	/**
	 * 获取医疗编码体系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCdsys_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cdsys_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗编码体系编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tp_name");
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
	private IColumnDesc getTp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_dicaitmrel");
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
	
}
