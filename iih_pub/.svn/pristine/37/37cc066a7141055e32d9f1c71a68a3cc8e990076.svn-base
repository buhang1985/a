
package iih.pi.overview.overview.d.desc;

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
 * 患者关键生命体征 DO 元数据信息
 */
public class PiPatVsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.overview.overview.d.PiPatVsDO";
	public static final String CLASS_DISPALYNAME = "患者关键生命体征";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "PI_PAT_VS";
	public static final String TABLE_ALIAS_NAME = "a19";
	public static final String PRIMARYKEY_FIELDNAME="Id_patvs";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatVsDODesc(){
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
		this.setKeyDesc(getId_patvsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patvsADesc(tblDesc));
		this.add(getSd_datasrcADesc(tblDesc));
		this.add(getId_datasrcADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getVal_vsADesc(tblDesc));
		this.add(getU_vsADesc(tblDesc));
		this.add(getDt_vsADesc(tblDesc));
		this.add(getSd_ymd_vsADesc(tblDesc));
		this.add(getId_ymd_vsADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patvsCDesc(tblDesc));
		tblDesc.add(getId_patvsCDesc(tblDesc));
		tblDesc.add(getSd_datasrcCDesc(tblDesc));
		tblDesc.add(getId_datasrcCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getVal_vsCDesc(tblDesc));
		tblDesc.add(getU_vsCDesc(tblDesc));
		tblDesc.add(getDt_vsCDesc(tblDesc));
		tblDesc.add(getSd_ymd_vsCDesc(tblDesc));
		tblDesc.add(getId_ymd_vsCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者关键生命体征ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patvsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patvs",  getId_patvsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者关键生命体征ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_datasrc",  getSd_datasrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_datasrc",  getId_datasrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生命体征属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生命体征");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生命体征名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生命体征名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生命体征描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生命体征描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生命体征数值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_vs",  getVal_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("生命体征数值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生命体征单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getU_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("U_vs",  getU_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生命体征单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生命体征采集日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_vs",  getDt_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("生命体征采集日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集日期精度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ymd_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ymd_vs",  getSd_ymd_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集日期精度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集日期精度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ymd_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ymd_vs",  getId_ymd_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("采集日期精度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者关键生命体征ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patvsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patvs");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者关键生命体征ID"); 
		return column;
	}
	/**
	 * 获取数据来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_datasrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源编码"); 
		return column;
	}
	/**
	 * 获取数据来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_datasrc");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("数据来源"); 
		return column;
	}
	/**
	 * 获取生命体征表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生命体征"); 
		return column;
	}
	/**
	 * 获取生命体征名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生命体征名称"); 
		return column;
	}
	/**
	 * 获取生命体征描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生命体征描述"); 
		return column;
	}
	/**
	 * 获取生命体征数值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_vs");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("生命体征数值"); 
		return column;
	}
	/**
	 * 获取生命体征单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getU_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"U_vs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生命体征单位"); 
		return column;
	}
	/**
	 * 获取生命体征采集日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_vs");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生命体征采集日期"); 
		return column;
	}
	/**
	 * 获取采集日期精度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ymd_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ymd_vs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集日期精度编码"); 
		return column;
	}
	/**
	 * 获取采集日期精度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ymd_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ymd_vs");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("采集日期精度"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
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
