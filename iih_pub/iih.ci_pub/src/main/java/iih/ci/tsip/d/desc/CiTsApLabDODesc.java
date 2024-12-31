
package iih.ci.tsip.d.desc;

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
 * 治疗方案检验申请 DO 元数据信息
 */
public class CiTsApLabDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.tsip.d.CiTsApLabDO";
	public static final String CLASS_DISPALYNAME = "治疗方案检验申请";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ts_ap_lab";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_tsaplab";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiTsApLabDODesc(){
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
		this.setKeyDesc(getId_tsaplabADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_tsaplabADesc(tblDesc));
		this.add(getId_tsorADesc(tblDesc));
		this.add(getId_samptpADesc(tblDesc));
		this.add(getSd_samptpADesc(tblDesc));
		this.add(getName_samptpADesc(tblDesc));
		this.add(getId_sampcoltimeADesc(tblDesc));
		this.add(getName_sampcoltimeADesc(tblDesc));
		this.add(getId_sampcollecttimetpADesc(tblDesc));
		this.add(getSd_sampcollecttimetpADesc(tblDesc));
		this.add(getLen_sampcoltimeADesc(tblDesc));
		this.add(getId_unit_sampcoltimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_tsaplabCDesc(tblDesc));
		tblDesc.add(getId_tsaplabCDesc(tblDesc));
		tblDesc.add(getId_tsorCDesc(tblDesc));
		tblDesc.add(getId_samptpCDesc(tblDesc));
		tblDesc.add(getSd_samptpCDesc(tblDesc));
		tblDesc.add(getName_samptpCDesc(tblDesc));
		tblDesc.add(getId_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getName_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getId_sampcollecttimetpCDesc(tblDesc));
		tblDesc.add(getSd_sampcollecttimetpCDesc(tblDesc));
		tblDesc.add(getLen_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getId_unit_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 治疗方案检验申请ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tsaplabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tsaplab",  getId_tsaplabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗方案检验申请ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗方案医嘱ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tsorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tsor",  getId_tsorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗方案医嘱ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_samptp",  getId_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本类型SD属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_samptp",  getSd_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型SD");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_samptp",  getName_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sampcoltime",  getId_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sampcoltime",  getName_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sampcollecttimetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sampcollecttimetp",  getId_sampcollecttimetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sampcollecttimetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sampcollecttimetp",  getSd_sampcollecttimetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLen_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Len_sampcoltime",  getLen_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标本采集时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时长单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_sampcoltime",  getId_unit_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时长单位");
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
	 * 获取治疗方案检验申请ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tsaplabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tsaplab");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗方案检验申请ID"); 
		return column;
	}
	/**
	 * 获取治疗方案医嘱ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tsorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tsor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗方案医嘱ID"); 
		return column;
	}
	/**
	 * 获取标本类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_samptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型ID"); 
		return column;
	}
	/**
	 * 获取标本类型SD表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_samptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型SD"); 
		return column;
	}
	/**
	 * 获取标本类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_samptp");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型名称"); 
		return column;
	}
	/**
	 * 获取标本采集时间ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sampcoltime");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间ID"); 
		return column;
	}
	/**
	 * 获取标本采集时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sampcoltime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间"); 
		return column;
	}
	/**
	 * 获取标本采集时间类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sampcollecttimetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sampcollecttimetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间类型ID"); 
		return column;
	}
	/**
	 * 获取标本采集时间类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sampcollecttimetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sampcollecttimetp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间类型编码"); 
		return column;
	}
	/**
	 * 获取标本采集时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLen_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Len_sampcoltime");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标本采集时长"); 
		return column;
	}
	/**
	 * 获取标本采集时长单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_sampcoltime");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时长单位"); 
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
