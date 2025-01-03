
package iih.pe.phm.pedietplan.d.desc;

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
 * 体检三餐分配比例 DO 元数据信息
 */
public class PeDietDivideDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pedietplan.d.PeDietDivideDO";
	public static final String CLASS_DISPALYNAME = "体检三餐分配比例";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_pedietdivide";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pedietdivide";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeDietDivideDODesc(){
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
		this.setKeyDesc(getId_pedietdivideADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pedietplanADesc(tblDesc));
		this.add(getId_pedietdivideADesc(tblDesc));
		this.add(getId_pedietplanADesc(tblDesc));
		this.add(getThreemealADesc(tblDesc));
		this.add(getEnergyADesc(tblDesc));
		this.add(getProteinADesc(tblDesc));
		this.add(getFatADesc(tblDesc));
		this.add(getCarbohydrateADesc(tblDesc));
		this.add(getStaplefoodADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pedietdivideCDesc(tblDesc));
		tblDesc.add(getId_pedietdivideCDesc(tblDesc));
		tblDesc.add(getId_pedietplanCDesc(tblDesc));
		tblDesc.add(getThreemealCDesc(tblDesc));
		tblDesc.add(getEnergyCDesc(tblDesc));
		tblDesc.add(getProteinCDesc(tblDesc));
		tblDesc.add(getFatCDesc(tblDesc));
		tblDesc.add(getCarbohydrateCDesc(tblDesc));
		tblDesc.add(getStaplefoodCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检三餐分配比例主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedietdivideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedietdivide",  getId_pedietdivideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检三餐分配比例主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检饮食计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedietplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedietplan",  getId_pedietplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检饮食计划ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 三餐属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThreemealADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Threemeal",  getThreemealCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("三餐");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 能量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Energy",  getEnergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("能量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 蛋白质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProteinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Protein",  getProteinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("蛋白质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脂肪属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fat",  getFatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("脂肪");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 碳水化合物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCarbohydrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Carbohydrate",  getCarbohydrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("碳水化合物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStaplefoodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Staplefood",  getStaplefoodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("主食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检三餐分配比例主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedietdivideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedietdivide");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检三餐分配比例主键标识"); 
		return column;
	}
	/**
	 * 获取体检饮食计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedietplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedietplan");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检饮食计划ID"); 
		return column;
	}
	/**
	 * 获取三餐表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThreemealCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Threemeal");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("三餐"); 
		return column;
	}
	/**
	 * 获取能量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Energy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("能量"); 
		return column;
	}
	/**
	 * 获取蛋白质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProteinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Protein");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("蛋白质"); 
		return column;
	}
	/**
	 * 获取脂肪表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("脂肪"); 
		return column;
	}
	/**
	 * 获取碳水化合物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCarbohydrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Carbohydrate");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("碳水化合物"); 
		return column;
	}
	/**
	 * 获取主食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStaplefoodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Staplefood");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("主食"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pedietdivide");
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
