
package iih.pe.pitm.pesrvitem.d.desc;

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
 * 体检体征定义 DO 元数据信息
 */
public class PeSrvitmSignDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pesrvitem.d.PeSrvitmSignDO";
	public static final String CLASS_DISPALYNAME = "体检体征定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_pesrvitmsign";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesrvitmsign";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSrvitmSignDODesc(){
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
		this.setKeyDesc(getId_pesrvitmsignADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pesrvitemADesc(tblDesc));
		this.add(getId_pesrvitmsignADesc(tblDesc));
		this.add(getId_pesrvitmsign_parADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getCode_parentADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getComptpADesc(tblDesc));
		this.add(getNodelevelADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getUnitADesc(tblDesc));
		this.add(getFg_leafADesc(tblDesc));
		this.add(getFg_foldADesc(tblDesc));
		this.add(getSexlimitADesc(tblDesc));
		this.add(getFg_copyADesc(tblDesc));
		this.add(getFg_rp_printADesc(tblDesc));
		this.add(getName_rptADesc(tblDesc));
		this.add(getCode_parADesc(tblDesc));
		this.add(getName_parADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pesrvitmsignCDesc(tblDesc));
		tblDesc.add(getId_pesrvitmsignCDesc(tblDesc));
		tblDesc.add(getId_pesrvitmsign_parCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getCode_parentCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getComptpCDesc(tblDesc));
		tblDesc.add(getNodelevelCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getUnitCDesc(tblDesc));
		tblDesc.add(getFg_leafCDesc(tblDesc));
		tblDesc.add(getFg_foldCDesc(tblDesc));
		tblDesc.add(getSexlimitCDesc(tblDesc));
		tblDesc.add(getFg_copyCDesc(tblDesc));
		tblDesc.add(getFg_rp_printCDesc(tblDesc));
		tblDesc.add(getName_rptCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检体征定义主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitmsignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitmsign",  getId_pesrvitmsignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检体征定义主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检体征定义父ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitmsign_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitmsign_par",  getId_pesrvitmsign_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检体征定义父ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 体征编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征父编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_parentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_parent",  getCode_parentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征父编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comptp",  getComptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("控件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 层级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNodelevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nodelevel",  getNodelevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("层级");
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
	 * 计量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit",  getUnitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 叶子标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_leafADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_leaf",  getFg_leafCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("叶子标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折叠标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_foldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fold",  getFg_foldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("折叠标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexlimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sexlimit",  getSexlimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否复制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_copyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_copy",  getFg_copyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否复制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告-打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_rp_printADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_rp_print",  getFg_rp_printCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("报告-打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rpt",  getName_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("打印名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_par",  getCode_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitmsign a4b4","id_pesrvitmsign_par=id_pesrvitmsign","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_par",  getName_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitmsign a4b4","id_pesrvitmsign_par=id_pesrvitmsign","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检体征定义主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitmsignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitmsign");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检体征定义主键标识"); 
		return column;
	}
	/**
	 * 获取体检体征定义父ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitmsign_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitmsign_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检体征定义父ID"); 
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
	 * 获取体征编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征编码"); 
		return column;
	}
	/**
	 * 获取体征父编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_parentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_parent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征父编码"); 
		return column;
	}
	/**
	 * 获取体征名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征名称"); 
		return column;
	}
	/**
	 * 获取控件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comptp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("控件类型"); 
		return column;
	}
	/**
	 * 获取层级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNodelevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nodelevel");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("层级"); 
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
	 * 获取计量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位"); 
		return column;
	}
	/**
	 * 获取叶子标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_leafCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_leaf");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("叶子标识"); 
		return column;
	}
	/**
	 * 获取折叠标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_foldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fold");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("折叠标识"); 
		return column;
	}
	/**
	 * 获取性别限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexlimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sexlimit");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别限制"); 
		return column;
	}
	/**
	 * 获取是否复制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_copyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_copy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否复制"); 
		return column;
	}
	/**
	 * 获取报告-打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_rp_printCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_rp_print");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告-打印标识"); 
		return column;
	}
	/**
	 * 获取打印名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rpt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("打印名称"); 
		return column;
	}
	/**
	 * 获取体征编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征编码"); 
		return column;
	}
	/**
	 * 获取体征名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pesrvitmsign");
		iBDDataInfoFldMap.put("pid","Id_pesrvitmsign_par");
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
