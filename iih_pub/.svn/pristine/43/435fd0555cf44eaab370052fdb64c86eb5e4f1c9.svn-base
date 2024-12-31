
package iih.bd.srv.ems.d.desc;

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
 * 医疗单打印模板关联处方类型 DO 元数据信息
 */
public class EmsPrnTmplRelPresDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.ems.d.EmsPrnTmplRelPresDO";
	public static final String CLASS_DISPALYNAME = "医疗单打印模板关联处方类型";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_ems_prntmpl_relpres";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_emsprntmplrelpres";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsPrnTmplRelPresDODesc(){
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
		this.setKeyDesc(getId_emsprntmplrelpresADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_emsprntmplADesc(tblDesc));
		this.add(getId_emsprntmplrelpresADesc(tblDesc));
		this.add(getId_emsprntmplADesc(tblDesc));
		this.add(getId_prestpADesc(tblDesc));
		this.add(getSd_prestpADesc(tblDesc));
		this.add(getId_prestpwordADesc(tblDesc));
		this.add(getSd_prestpwordADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getEu_presprnrelfactortpADesc(tblDesc));
		this.add(getName_prestpADesc(tblDesc));
		this.add(getPrestpword_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_emsprntmplrelpresCDesc(tblDesc));
		tblDesc.add(getId_emsprntmplrelpresCDesc(tblDesc));
		tblDesc.add(getId_emsprntmplCDesc(tblDesc));
		tblDesc.add(getId_prestpCDesc(tblDesc));
		tblDesc.add(getSd_prestpCDesc(tblDesc));
		tblDesc.add(getId_prestpwordCDesc(tblDesc));
		tblDesc.add(getSd_prestpwordCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getEu_presprnrelfactortpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 打印模板关联处方主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emsprntmplrelpresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emsprntmplrelpres",  getId_emsprntmplrelpresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("打印模板关联处方主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗单打印模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emsprntmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emsprntmpl",  getId_emsprntmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗单打印模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处方类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_prestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prestp",  getId_prestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处方类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_prestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_prestp",  getSd_prestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方标识类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_prestpwordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prestpword",  getId_prestpwordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方标识类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处方标识类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_prestpwordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_prestpword",  getSd_prestpwordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方标识类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 增减项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_directADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_direct",  getEu_directCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("增减项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方打印关联因素类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_presprnrelfactortpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_presprnrelfactortp",  getEu_presprnrelfactortpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方打印关联因素类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处方类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_prestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_prestp",  getName_prestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b2","id_prestp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方标识类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrestpword_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prestpword_name",  getPrestpword_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方标识类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b3","id_prestpword=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取打印模板关联处方主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emsprntmplrelpresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emsprntmplrelpres");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印模板关联处方主键标识"); 
		return column;
	}
	/**
	 * 获取医疗单打印模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emsprntmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emsprntmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗单打印模板"); 
		return column;
	}
	/**
	 * 获取处方类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_prestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prestp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方类型"); 
		return column;
	}
	/**
	 * 获取处方类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_prestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_prestp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方类型编码"); 
		return column;
	}
	/**
	 * 获取处方标识类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_prestpwordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prestpword");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方标识类型"); 
		return column;
	}
	/**
	 * 获取处方标识类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_prestpwordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_prestpword");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方标识类型编码"); 
		return column;
	}
	/**
	 * 获取增减项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_directCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_direct");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("增减项"); 
		return column;
	}
	/**
	 * 获取处方打印关联因素类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_presprnrelfactortpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_presprnrelfactortp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方打印关联因素类型"); 
		return column;
	}
	/**
	 * 获取处方类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_prestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_prestp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方类型名称"); 
		return column;
	}
	/**
	 * 获取处方标识类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrestpword_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prestpword_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方标识类型名称"); 
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
