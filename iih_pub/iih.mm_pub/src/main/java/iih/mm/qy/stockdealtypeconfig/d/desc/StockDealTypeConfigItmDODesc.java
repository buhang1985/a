
package iih.mm.qy.stockdealtypeconfig.d.desc;

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
 * 库存交易分类方案项目 DO 元数据信息
 */
public class StockDealTypeConfigItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.qy.stockdealtypeconfig.d.StockDealTypeConfigItmDO";
	public static final String CLASS_DISPALYNAME = "库存交易分类方案项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MM_SDT_CONFIG_ITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_sdk_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public StockDealTypeConfigItmDODesc(){
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
		this.setKeyDesc(getId_sdk_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_sdtADesc(tblDesc));
		this.add(getId_sdk_itmADesc(tblDesc));
		this.add(getId_sdtADesc(tblDesc));
		this.add(getId_mmstcaADesc(tblDesc));
		this.add(getDisplay_nmADesc(tblDesc));
		this.add(getFg_sumADesc(tblDesc));
		this.add(getMmstca_codeADesc(tblDesc));
		this.add(getMmstca_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_sdk_itmCDesc(tblDesc));
		tblDesc.add(getId_sdk_itmCDesc(tblDesc));
		tblDesc.add(getId_sdtCDesc(tblDesc));
		tblDesc.add(getId_mmstcaCDesc(tblDesc));
		tblDesc.add(getDisplay_nmCDesc(tblDesc));
		tblDesc.add(getFg_sumCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 库存交易分类方案项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sdk_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sdk_itm",  getId_sdk_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存交易分类方案项目主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存交易分类方案主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sdtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sdt",  getId_sdtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存交易分类方案主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 库存交易分类主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmstcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmstca",  getId_mmstcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存交易分类主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 显示名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisplay_nmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Display_nm",  getDisplay_nmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("显示名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 求和列标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sum",  getFg_sumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("求和列标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存交易分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmstca_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmstca_code",  getMmstca_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存交易分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_STCA a1b2","id_mmstca=id_mmstca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存交易分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmstca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmstca_name",  getMmstca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存交易分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_STCA a1b2","id_mmstca=id_mmstca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取库存交易分类方案项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sdk_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sdk_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("库存交易分类方案项目主键"); 
		return column;
	}
	/**
	 * 获取库存交易分类方案主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sdtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sdt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存交易分类方案主键"); 
		return column;
	}
	/**
	 * 获取库存交易分类主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmstcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmstca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存交易分类主键"); 
		return column;
	}
	/**
	 * 获取显示名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisplay_nmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Display_nm");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("显示名称"); 
		return column;
	}
	/**
	 * 获取求和列标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sum");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("求和列标志"); 
		return column;
	}
	/**
	 * 获取库存交易分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmstca_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmstca_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存交易分类编码"); 
		return column;
	}
	/**
	 * 获取库存交易分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmstca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmstca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存交易分类名称"); 
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
