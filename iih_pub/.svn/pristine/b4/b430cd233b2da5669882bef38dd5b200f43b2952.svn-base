
package iih.pe.phm.peexerciseplan.d.desc;

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
 * 体检运动计划运动量 DO 元数据信息
 */
public class PeExercisePlanDtlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.peexerciseplan.d.PeExercisePlanDtlDO";
	public static final String CLASS_DISPALYNAME = "体检运动计划运动量";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_peexerciseplandtl";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_peexerciseplandtl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeExercisePlanDtlDODesc(){
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
		this.setKeyDesc(getId_peexerciseplandtlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peexerciseplanADesc(tblDesc));
		this.add(getId_peexerciseplandtlADesc(tblDesc));
		this.add(getId_peexerciseplanADesc(tblDesc));
		this.add(getFrqADesc(tblDesc));
		this.add(getDuADesc(tblDesc));
		this.add(getName5ADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peexerciseplandtlCDesc(tblDesc));
		tblDesc.add(getId_peexerciseplandtlCDesc(tblDesc));
		tblDesc.add(getId_peexerciseplanCDesc(tblDesc));
		tblDesc.add(getFrqCDesc(tblDesc));
		tblDesc.add(getDuCDesc(tblDesc));
		tblDesc.add(getName5CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检运动计划明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peexerciseplandtlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peexerciseplandtl",  getId_peexerciseplandtlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检运动计划明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检运动处方ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peexerciseplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peexerciseplan",  getId_peexerciseplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检运动处方ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 运动频率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFrqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Frq",  getFrqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("运动频率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运动时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Du",  getDuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("运动时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name5",  getName5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检运动计划明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peexerciseplandtlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peexerciseplandtl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检运动计划明细主键标识"); 
		return column;
	}
	/**
	 * 获取体检运动处方ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peexerciseplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peexerciseplan");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检运动处方ID"); 
		return column;
	}
	/**
	 * 获取运动频率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFrqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Frq");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("运动频率"); 
		return column;
	}
	/**
	 * 获取运动时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Du");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("运动时长"); 
		return column;
	}
	/**
	 * 获取displaynam5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam5"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_peexerciseplandtl");
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
