
package iih.pe.pqn.peevalchrorisk.d.desc;

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
 * 体检慢性病风险因素-检查结果 DO 元数据信息
 */
public class PeChroRstDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peevalchrorisk.d.PeChroRstDO";
	public static final String CLASS_DISPALYNAME = "体检慢性病风险因素-检查结果";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_pechrorst";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_pechroriskrst";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeChroRstDODesc(){
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
		this.setKeyDesc(getId_pechroriskrstADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pechroriskADesc(tblDesc));
		this.add(getId_pechroriskrstADesc(tblDesc));
		this.add(getId_pechroriskADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getMarkADesc(tblDesc));
		this.add(getCode_rstADesc(tblDesc));
		this.add(getName_rstADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pechroriskrstCDesc(tblDesc));
		tblDesc.add(getId_pechroriskrstCDesc(tblDesc));
		tblDesc.add(getId_pechroriskCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getMarkCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检慢性病风险因素结果主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pechroriskrstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pechroriskrst",  getId_pechroriskrstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检慢性病风险因素结果主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检慢性病风险因素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pechroriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pechrorisk",  getId_pechroriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检慢性病风险因素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem",  getId_pesrvitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检结果异常标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mark",  getMarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果异常标识");
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
	private IAttrDesc getCode_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rst",  getCode_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a3b2","id_pesrvitem=id_pesrvitem","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rst",  getName_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a3b2","id_pesrvitem=id_pesrvitem","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检慢性病风险因素结果主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pechroriskrstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pechroriskrst");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病风险因素结果主键标识"); 
		return column;
	}
	/**
	 * 获取体检慢性病风险因素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pechroriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pechrorisk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病风险因素ID"); 
		return column;
	}
	/**
	 * 获取体检结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果ID"); 
		return column;
	}
	/**
	 * 获取体检结果异常标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mark");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果异常标识"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rst");
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
	private IColumnDesc getName_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rst");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pechroriskrst");
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