
package iih.mp.dg.mpdgshetpprntmpl.d.desc;

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
 * 药单打印模板关联类型 DO 元数据信息
 */
public class MpdgShetpPrntmplIitmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.mpdgshetpprntmpl.d.MpdgShetpPrntmplIitmDO";
	public static final String CLASS_DISPALYNAME = "药单打印模板关联类型";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_shetp_prntmpl_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_shetp_prn_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpdgShetpPrntmplIitmDODesc(){
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
		this.setKeyDesc(getId_shetp_prn_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_dgshetp_prntmplADesc(tblDesc));
		this.add(getId_shetp_prn_itmADesc(tblDesc));
		this.add(getId_dgshetp_prntmplADesc(tblDesc));
		this.add(getEu_ofreftpADesc(tblDesc));
		this.add(getId_dgshetpADesc(tblDesc));
		this.add(getFg_autoprintADesc(tblDesc));
		this.add(getDg_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_shetp_prn_itmCDesc(tblDesc));
		tblDesc.add(getId_shetp_prn_itmCDesc(tblDesc));
		tblDesc.add(getId_dgshetp_prntmplCDesc(tblDesc));
		tblDesc.add(getEu_ofreftpCDesc(tblDesc));
		tblDesc.add(getId_dgshetpCDesc(tblDesc));
		tblDesc.add(getFg_autoprintCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 模板关联类型主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_shetp_prn_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_shetp_prn_itm",  getId_shetp_prn_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板关联类型主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgshetp_prntmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgshetp_prntmpl",  getId_dgshetp_prntmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 关联类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ofreftpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ofreftp",  getEu_ofreftpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("关联类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药单类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgshetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgshetp",  getId_dgshetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药单类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否自动打印属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_autoprintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_autoprint",  getFg_autoprintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否自动打印");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药单名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dg_name",  getDg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药单名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_dg_shetp a1b2","id_dgshetp=id_dgshetp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取模板关联类型主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_shetp_prn_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_shetp_prn_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("模板关联类型主键"); 
		return column;
	}
	/**
	 * 获取模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgshetp_prntmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgshetp_prntmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板名称"); 
		return column;
	}
	/**
	 * 获取关联类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ofreftpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ofreftp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("关联类型"); 
		return column;
	}
	/**
	 * 获取药单类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgshetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgshetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药单类型"); 
		return column;
	}
	/**
	 * 获取是否自动打印表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_autoprintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_autoprint");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否自动打印"); 
		return column;
	}
	/**
	 * 获取药单名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药单名称"); 
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
