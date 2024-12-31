
package iih.mkr.ms.mkrms.d.desc;

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
 * 组套与疾病诊断关系 DO 元数据信息
 */
public class MkrMsDiDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mkr.ms.mkrms.d.MkrMsDiDO";
	public static final String CLASS_DISPALYNAME = "组套与疾病诊断关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MKR_MS_DI";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_msdi";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MkrMsDiDODesc(){
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
		this.setKeyDesc(getId_msdiADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_msADesc(tblDesc));
		this.add(getId_msdiADesc(tblDesc));
		this.add(getId_msADesc(tblDesc));
		this.add(getId_didefADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getId_cdsysADesc(tblDesc));
		this.add(getSupplementADesc(tblDesc));
		this.add(getFg_majdiADesc(tblDesc));
		this.add(getDidef_nameADesc(tblDesc));
		this.add(getDidef_codeADesc(tblDesc));
		this.add(getDidef_desADesc(tblDesc));
		this.add(getFg_chronicADesc(tblDesc));
		this.add(getFg_specialADesc(tblDesc));
		this.add(getId_cdsystpADesc(tblDesc));
		this.add(getSd_cdsystpADesc(tblDesc));
		this.add(getCdsys_nameADesc(tblDesc));
		this.add(getCdsys_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_msdiCDesc(tblDesc));
		tblDesc.add(getId_msdiCDesc(tblDesc));
		tblDesc.add(getId_msCDesc(tblDesc));
		tblDesc.add(getId_didefCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getId_cdsysCDesc(tblDesc));
		tblDesc.add(getSupplementCDesc(tblDesc));
		tblDesc.add(getFg_majdiCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 组套与疾病诊断关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_msdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_msdi",  getId_msdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组套与疾病诊断关系");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组套ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ms",  getId_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组套ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_didefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_didef",  getId_didefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 上级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
	 * 诊断补充说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSupplementADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Supplement",  getSupplementCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断补充说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_majdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_majdi",  getFg_majdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("主诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDidef_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Didef_name",  getDidef_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDidef_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Didef_code",  getDidef_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDidef_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Didef_des",  getDidef_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","des"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 慢性病标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_chronicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_chronic",  getFg_chronicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("慢性病标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","fg_chronic"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特种病标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_specialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_special",  getFg_specialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("特种病标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","fg_special"});
		attrDesc.setRefType(false);
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
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","id_cdsystp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断体系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cdsystpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cdsystp",  getSd_cdsystpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断体系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a4b3","id_didef=id_didef","sd_cdsystp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCdsys_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cdsys_name",  getCdsys_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cdsys a4b7","id_cdsys=id_cdsys","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCdsys_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cdsys_code",  getCdsys_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cdsys a4b7","id_cdsys=id_cdsys","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取组套与疾病诊断关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_msdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_msdi");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("组套与疾病诊断关系"); 
		return column;
	}
	/**
	 * 获取组套ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ms");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组套ID"); 
		return column;
	}
	/**
	 * 获取疾病诊断主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_didefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_didef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断主键"); 
		return column;
	}
	/**
	 * 获取上级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上级"); 
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
	 * 获取诊断补充说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSupplementCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Supplement");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断补充说明"); 
		return column;
	}
	/**
	 * 获取主诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_majdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_majdi");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主诊断"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDidef_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Didef_name");
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
	private IColumnDesc getDidef_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Didef_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDidef_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Didef_des");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断描述"); 
		return column;
	}
	/**
	 * 获取慢性病标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_chronicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_chronic");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("慢性病标志"); 
		return column;
	}
	/**
	 * 获取特种病标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_specialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_special");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("特种病标志"); 
		return column;
	}
	/**
	 * 获取诊断体系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cdsystpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cdsystp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断体系"); 
		return column;
	}
	/**
	 * 获取诊断体系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cdsystpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cdsystp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断体系编码"); 
		return column;
	}
	/**
	 * 获取标准名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCdsys_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cdsys_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准名称"); 
		return column;
	}
	/**
	 * 获取标准编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCdsys_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cdsys_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准编码"); 
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
	
}
