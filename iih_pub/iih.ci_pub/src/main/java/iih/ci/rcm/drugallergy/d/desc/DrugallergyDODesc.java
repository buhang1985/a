
package iih.ci.rcm.drugallergy.d.desc;

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
 * 药敏详情 DO 元数据信息
 */
public class DrugallergyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.drugallergy.d.DrugallergyDO";
	public static final String CLASS_DISPALYNAME = "药敏详情";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_HOS_DRUGALLERGY";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_drugallergy";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DrugallergyDODesc(){
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
		this.setKeyDesc(getId_drugallergyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_drugallergyADesc(tblDesc));
		this.add(getId_drugseinfoADesc(tblDesc));
		this.add(getId_dis_pbADesc(tblDesc));
		this.add(getName_dis_pbADesc(tblDesc));
		this.add(getCode_dis_pbADesc(tblDesc));
		this.add(getId_antibioticADesc(tblDesc));
		this.add(getName_antibioticADesc(tblDesc));
		this.add(getCode_antibioticADesc(tblDesc));
		this.add(getId_sensitiveADesc(tblDesc));
		this.add(getName_sensitiveADesc(tblDesc));
		this.add(getCode_sensitiveADesc(tblDesc));
		this.add(getBack_up_field1ADesc(tblDesc));
		this.add(getBack_up_field2ADesc(tblDesc));
		this.add(getBack_up_field3ADesc(tblDesc));
		this.add(getBack_up_field4ADesc(tblDesc));
		this.add(getBack_up_field5ADesc(tblDesc));
		this.add(getDrugsens_resultADesc(tblDesc));
		this.add(getCode_drugsens_resultADesc(tblDesc));
		this.add(getName_drugsens_resultADesc(tblDesc));
		this.add(getDis_pb_codeADesc(tblDesc));
		this.add(getDis_pb_nameADesc(tblDesc));
		this.add(getAntibiotic_codeADesc(tblDesc));
		this.add(getAntibiotic_nameADesc(tblDesc));
		this.add(getSensitive_codeADesc(tblDesc));
		this.add(getSensitive_nameADesc(tblDesc));
		this.add(getDrugsens_result_codeADesc(tblDesc));
		this.add(getDrugsens_result_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_drugallergyCDesc(tblDesc));
		tblDesc.add(getId_drugallergyCDesc(tblDesc));
		tblDesc.add(getId_drugseinfoCDesc(tblDesc));
		tblDesc.add(getId_dis_pbCDesc(tblDesc));
		tblDesc.add(getName_dis_pbCDesc(tblDesc));
		tblDesc.add(getCode_dis_pbCDesc(tblDesc));
		tblDesc.add(getId_antibioticCDesc(tblDesc));
		tblDesc.add(getName_antibioticCDesc(tblDesc));
		tblDesc.add(getCode_antibioticCDesc(tblDesc));
		tblDesc.add(getId_sensitiveCDesc(tblDesc));
		tblDesc.add(getName_sensitiveCDesc(tblDesc));
		tblDesc.add(getCode_sensitiveCDesc(tblDesc));
		tblDesc.add(getBack_up_field1CDesc(tblDesc));
		tblDesc.add(getBack_up_field2CDesc(tblDesc));
		tblDesc.add(getBack_up_field3CDesc(tblDesc));
		tblDesc.add(getBack_up_field4CDesc(tblDesc));
		tblDesc.add(getBack_up_field5CDesc(tblDesc));
		tblDesc.add(getDrugsens_resultCDesc(tblDesc));
		tblDesc.add(getCode_drugsens_resultCDesc(tblDesc));
		tblDesc.add(getName_drugsens_resultCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 药敏详情主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugallergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drugallergy",  getId_drugallergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏详情主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药敏信息主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugseinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drugseinfo",  getId_drugseinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏信息主键");
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
	private IAttrDesc getId_dis_pbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dis_pb",  getId_dis_pbCDesc(tblDesc), this);
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
	 * 病原体名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dis_pbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dis_pb",  getName_dis_pbCDesc(tblDesc), this);
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
	 * 病原体编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dis_pbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dis_pb",  getCode_dis_pbCDesc(tblDesc), this);
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
	 * 抗生素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antibioticADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_antibiotic",  getId_antibioticCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗生素名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_antibioticADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_antibiotic",  getName_antibioticCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_antibioticADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_antibiotic",  getCode_antibioticCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 敏感度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sensitiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sensitive",  getId_sensitiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("敏感度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 敏感度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sensitiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sensitive",  getName_sensitiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("敏感度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 敏感度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sensitiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sensitive",  getCode_sensitiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("敏感度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBack_up_field1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Back_up_field1",  getBack_up_field1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBack_up_field2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Back_up_field2",  getBack_up_field2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBack_up_field3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Back_up_field3",  getBack_up_field3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBack_up_field4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Back_up_field4",  getBack_up_field4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBack_up_field5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Back_up_field5",  getBack_up_field5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药敏效果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugsens_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugsens_result",  getDrugsens_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏效果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药敏效果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_drugsens_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_drugsens_result",  getCode_drugsens_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏效果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药敏效果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drugsens_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drugsens_result",  getName_drugsens_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏效果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDis_pb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dis_pb_code",  getDis_pb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_dis_pb=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDis_pb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dis_pb_name",  getDis_pb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_dis_pb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAntibiotic_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Antibiotic_code",  getAntibiotic_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b3","id_antibiotic=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAntibiotic_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Antibiotic_name",  getAntibiotic_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b3","id_antibiotic=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSensitive_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sensitive_code",  getSensitive_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sensitive=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSensitive_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sensitive_name",  getSensitive_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sensitive=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugsens_result_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugsens_result_code",  getDrugsens_result_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","drugsens_result=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugsens_result_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugsens_result_name",  getDrugsens_result_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","drugsens_result=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取药敏详情主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugallergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drugallergy");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药敏详情主键"); 
		return column;
	}
	/**
	 * 获取药敏信息主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugseinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drugseinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏信息主键"); 
		return column;
	}
	/**
	 * 获取病原体表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dis_pbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dis_pb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体"); 
		return column;
	}
	/**
	 * 获取病原体名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dis_pbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dis_pb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体名称"); 
		return column;
	}
	/**
	 * 获取病原体编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dis_pbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dis_pb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体编码"); 
		return column;
	}
	/**
	 * 获取抗生素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antibioticCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_antibiotic");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素"); 
		return column;
	}
	/**
	 * 获取抗生素名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_antibioticCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_antibiotic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素名称"); 
		return column;
	}
	/**
	 * 获取抗生素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_antibioticCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_antibiotic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素编码"); 
		return column;
	}
	/**
	 * 获取敏感度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sensitiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sensitive");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("敏感度"); 
		return column;
	}
	/**
	 * 获取敏感度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sensitiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sensitive");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("敏感度名称"); 
		return column;
	}
	/**
	 * 获取敏感度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sensitiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sensitive");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("敏感度编码"); 
		return column;
	}
	/**
	 * 获取备用字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBack_up_field1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Back_up_field1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段1"); 
		return column;
	}
	/**
	 * 获取备用字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBack_up_field2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Back_up_field2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段2"); 
		return column;
	}
	/**
	 * 获取备用字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBack_up_field3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Back_up_field3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段3"); 
		return column;
	}
	/**
	 * 获取备用字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBack_up_field4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Back_up_field4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段4"); 
		return column;
	}
	/**
	 * 获取备用字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBack_up_field5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Back_up_field5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段5"); 
		return column;
	}
	/**
	 * 获取药敏效果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrugsens_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugsens_result");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏效果"); 
		return column;
	}
	/**
	 * 获取药敏效果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_drugsens_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_drugsens_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏效果编码"); 
		return column;
	}
	/**
	 * 获取药敏效果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drugsens_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drugsens_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药敏效果名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDis_pb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dis_pb_code");
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
	private IColumnDesc getDis_pb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dis_pb_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAntibiotic_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Antibiotic_code");
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
	private IColumnDesc getAntibiotic_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Antibiotic_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSensitive_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sensitive_code");
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
	private IColumnDesc getSensitive_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sensitive_name");
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
	private IColumnDesc getDrugsens_result_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugsens_result_code");
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
	private IColumnDesc getDrugsens_result_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugsens_result_name");
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
	
}
