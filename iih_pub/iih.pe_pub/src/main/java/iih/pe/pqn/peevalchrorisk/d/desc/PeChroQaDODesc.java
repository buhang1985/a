
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
 * 体检慢性病风险因素-问卷 DO 元数据信息
 */
public class PeChroQaDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peevalchrorisk.d.PeChroQaDO";
	public static final String CLASS_DISPALYNAME = "体检慢性病风险因素-问卷";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_pechroqa";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_pechroriskqa";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeChroQaDODesc(){
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
		this.setKeyDesc(getId_pechroriskqaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pechroriskADesc(tblDesc));
		this.add(getId_pechroriskqaADesc(tblDesc));
		this.add(getId_pechroriskADesc(tblDesc));
		this.add(getId_peqacontentdefADesc(tblDesc));
		this.add(getId_peqakeydefADesc(tblDesc));
		this.add(getScoreADesc(tblDesc));
		this.add(getFg_sumADesc(tblDesc));
		this.add(getCode_qaADesc(tblDesc));
		this.add(getName_qaADesc(tblDesc));
		this.add(getCode_keyADesc(tblDesc));
		this.add(getName_keyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pechroriskqaCDesc(tblDesc));
		tblDesc.add(getId_pechroriskqaCDesc(tblDesc));
		tblDesc.add(getId_pechroriskCDesc(tblDesc));
		tblDesc.add(getId_peqacontentdefCDesc(tblDesc));
		tblDesc.add(getId_peqakeydefCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		tblDesc.add(getFg_sumCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检慢性病风险因素问卷主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pechroriskqaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pechroriskqa",  getId_pechroriskqaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检慢性病风险因素问卷主键标识");
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检问卷问题库ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacontentdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqacontentdef",  getId_peqacontentdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题库ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检问卷选项ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqakeydefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqakeydef",  getId_peqakeydefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷选项ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score",  getScoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 求和标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sum",  getFg_sumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("求和标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_qaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_qa",  getCode_qaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问题编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a2b6","id_peqacontentdef=id_peqacontentdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qa",  getName_qaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问题名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a2b6","id_peqacontentdef=id_peqacontentdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 答案编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_key",  getCode_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("答案编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a2b5","id_peqakeydef=id_peqakeydef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 答案名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_key",  getName_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("答案名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a2b5","id_peqakeydef=id_peqakeydef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检慢性病风险因素问卷主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pechroriskqaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pechroriskqa");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病风险因素问卷主键标识"); 
		return column;
	}
	/**
	 * 获取体检慢性病风险因素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pechroriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pechrorisk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病风险因素ID"); 
		return column;
	}
	/**
	 * 获取体检问卷问题库ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacontentdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqacontentdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题库ID"); 
		return column;
	}
	/**
	 * 获取体检问卷选项ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqakeydefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqakeydef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷选项ID"); 
		return column;
	}
	/**
	 * 获取分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("分值"); 
		return column;
	}
	/**
	 * 获取求和标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sum");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("求和标识"); 
		return column;
	}
	/**
	 * 获取问题编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_qaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_qa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问题编码"); 
		return column;
	}
	/**
	 * 获取问题名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问题名称"); 
		return column;
	}
	/**
	 * 获取答案编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_key");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("答案编码"); 
		return column;
	}
	/**
	 * 获取答案名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_key");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("答案名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pechroriskqa");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
