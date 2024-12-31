
package iih.pe.phm.pehmlifestyle.d.desc;

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
 * 健康生活方式评估结果 DO 元数据信息
 */
public class PeHmLifestyleDtlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDtlDO";
	public static final String CLASS_DISPALYNAME = "健康生活方式评估结果";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_lifestyledtl";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_lifestyledtl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeHmLifestyleDtlDODesc(){
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
		this.setKeyDesc(getId_lifestyledtlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_lifestyleADesc(tblDesc));
		this.add(getId_lifestyledtlADesc(tblDesc));
		this.add(getId_lifestyleADesc(tblDesc));
		this.add(getId_peevallifestyleitmADesc(tblDesc));
		this.add(getRstADesc(tblDesc));
		this.add(getFg_improveADesc(tblDesc));
		this.add(getFg_contimproveADesc(tblDesc));
		this.add(getFg_maintainADesc(tblDesc));
		this.add(getScoreADesc(tblDesc));
		this.add(getCode_itemADesc(tblDesc));
		this.add(getName_itemADesc(tblDesc));
		this.add(getValue_ref_itemADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_lifestyledtlCDesc(tblDesc));
		tblDesc.add(getId_lifestyledtlCDesc(tblDesc));
		tblDesc.add(getId_lifestyleCDesc(tblDesc));
		tblDesc.add(getId_peevallifestyleitmCDesc(tblDesc));
		tblDesc.add(getRstCDesc(tblDesc));
		tblDesc.add(getFg_improveCDesc(tblDesc));
		tblDesc.add(getFg_contimproveCDesc(tblDesc));
		tblDesc.add(getFg_maintainCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康生活方式评估明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lifestyledtlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lifestyledtl",  getId_lifestyledtlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康生活方式评估明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康生活方式评估ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lifestyleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lifestyle",  getId_lifestyleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康生活方式评估ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 健康生活方式评估项目定义ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peevallifestyleitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peevallifestyleitm",  getId_peevallifestyleitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康生活方式评估项目定义ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rst",  getRstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 立即改善属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_improveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_improve",  getFg_improveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("立即改善");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 继续改善属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_contimproveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_contimprove",  getFg_contimproveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("继续改善");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 继续保存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_maintainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_maintain",  getFg_maintainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("继续保存");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score",  getScoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本次得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_item",  getCode_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevallifestyleitm a1b2","id_peevallifestyleitm=id_peevallifestyleitm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_item",  getName_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevallifestyleitm a1b2","id_peevallifestyleitm=id_peevallifestyleitm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_ref_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_ref_item",  getValue_ref_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevallifestyleitm a1b2","id_peevallifestyleitm=id_peevallifestyleitm","value_ref"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康生活方式评估明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lifestyledtlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lifestyledtl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康生活方式评估明细主键标识"); 
		return column;
	}
	/**
	 * 获取健康生活方式评估ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lifestyleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lifestyle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康生活方式评估ID"); 
		return column;
	}
	/**
	 * 获取健康生活方式评估项目定义ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peevallifestyleitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peevallifestyleitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康生活方式评估项目定义ID"); 
		return column;
	}
	/**
	 * 获取评估结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估结果"); 
		return column;
	}
	/**
	 * 获取立即改善表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_improveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_improve");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("立即改善"); 
		return column;
	}
	/**
	 * 获取继续改善表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_contimproveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_contimprove");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("继续改善"); 
		return column;
	}
	/**
	 * 获取继续保存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_maintainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_maintain");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("继续保存"); 
		return column;
	}
	/**
	 * 获取本次得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本次得分"); 
		return column;
	}
	/**
	 * 获取项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_item");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目编码"); 
		return column;
	}
	/**
	 * 获取项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_item");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目名称"); 
		return column;
	}
	/**
	 * 获取参考值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_ref_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_ref_item");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考值"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_lifestyledtl");
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
