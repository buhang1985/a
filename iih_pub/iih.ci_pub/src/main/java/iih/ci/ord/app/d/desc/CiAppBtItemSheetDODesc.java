
package iih.ci.ord.app.d.desc;

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
 * 备血观察检验指标 DO 元数据信息
 */
public class CiAppBtItemSheetDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.app.d.CiAppBtItemSheetDO";
	public static final String CLASS_DISPALYNAME = "备血观察检验指标";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_app_bt_item";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_ciappbtsheet_item";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiAppBtItemSheetDODesc(){
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
		this.setKeyDesc(getId_ciappbtsheet_itemADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_ciappbtsheetADesc(tblDesc));
		this.add(getId_ciappbtsheet_itemADesc(tblDesc));
		this.add(getId_apbtobsindexADesc(tblDesc));
		this.add(getId_ciappbtsheetADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getVal_rstrptlaADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getName_unitADesc(tblDesc));
		this.add(getVal_restrptlabADesc(tblDesc));
		this.add(getSd_restrptlabtpADesc(tblDesc));
		this.add(getId_restrptlabtpADesc(tblDesc));
		this.add(getReporttimeADesc(tblDesc));
		this.add(getBarcodeADesc(tblDesc));
		this.add(getFg_allowemptyADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ciappbtsheet_itemCDesc(tblDesc));
		tblDesc.add(getId_ciappbtsheet_itemCDesc(tblDesc));
		tblDesc.add(getId_apbtobsindexCDesc(tblDesc));
		tblDesc.add(getId_ciappbtsheetCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getCode_srvCDesc(tblDesc));
		tblDesc.add(getName_srvCDesc(tblDesc));
		tblDesc.add(getVal_rstrptlaCDesc(tblDesc));
		tblDesc.add(getId_unitCDesc(tblDesc));
		tblDesc.add(getName_unitCDesc(tblDesc));
		tblDesc.add(getVal_restrptlabCDesc(tblDesc));
		tblDesc.add(getSd_restrptlabtpCDesc(tblDesc));
		tblDesc.add(getId_restrptlabtpCDesc(tblDesc));
		tblDesc.add(getReporttimeCDesc(tblDesc));
		tblDesc.add(getBarcodeCDesc(tblDesc));
		tblDesc.add(getFg_allowemptyCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 备血观察指标打印主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciappbtsheet_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciappbtsheet_item",  getId_ciappbtsheet_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血观察指标打印主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血观察指标主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apbtobsindexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apbtobsindex",  getId_apbtobsindexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血观察指标主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血打印申请单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciappbtsheetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciappbtsheet",  getId_ciappbtsheetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血打印申请单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目结果值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_rstrptlaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_rstrptla",  getVal_rstrptlaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目结果值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验项目单位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验项目单位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验项目单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit",  getName_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验项目单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验结果值域属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_restrptlabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_restrptlab",  getVal_restrptlabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果值域");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验结果类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_restrptlabtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_restrptlabtp",  getSd_restrptlabtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验结果类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_restrptlabtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_restrptlabtp",  getId_restrptlabtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReporttimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reporttime",  getReporttimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本条码号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBarcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Barcode",  getBarcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本条码号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否允许为空属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_allowemptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_allowempty",  getFg_allowemptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许为空");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取备血观察指标打印主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciappbtsheet_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciappbtsheet_item");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("备血观察指标打印主键"); 
		return column;
	}
	/**
	 * 获取备血观察指标主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apbtobsindexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apbtobsindex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血观察指标主键标识"); 
		return column;
	}
	/**
	 * 获取备血打印申请单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciappbtsheetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciappbtsheet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血打印申请单"); 
		return column;
	}
	/**
	 * 获取检验项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验项目编码"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取检验项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验项目名称"); 
		return column;
	}
	/**
	 * 获取项目结果值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_rstrptlaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_rstrptla");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目结果值"); 
		return column;
	}
	/**
	 * 获取检验项目单位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验项目单位id"); 
		return column;
	}
	/**
	 * 获取检验项目单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验项目单位"); 
		return column;
	}
	/**
	 * 获取检验结果值域表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_restrptlabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_restrptlab");
		column.setLength(250);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果值域"); 
		return column;
	}
	/**
	 * 获取检验结果类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_restrptlabtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_restrptlabtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果类型编码"); 
		return column;
	}
	/**
	 * 获取检验结果类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_restrptlabtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_restrptlabtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果类型"); 
		return column;
	}
	/**
	 * 获取报告日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReporttimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reporttime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告日期"); 
		return column;
	}
	/**
	 * 获取标本条码号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBarcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Barcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本条码号"); 
		return column;
	}
	/**
	 * 获取是否允许为空表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_allowemptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_allowempty");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许为空"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
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
