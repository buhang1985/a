
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
 * 体检慢性病风险因素-诊断 DO 元数据信息
 */
public class PeChroDiDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peevalchrorisk.d.PeChroDiDO";
	public static final String CLASS_DISPALYNAME = "体检慢性病风险因素-诊断";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_pechrodi";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pechroriskdi";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeChroDiDODesc(){
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
		this.setKeyDesc(getId_pechroriskdiADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pechroriskADesc(tblDesc));
		this.add(getId_pechroriskdiADesc(tblDesc));
		this.add(getId_pechroriskADesc(tblDesc));
		this.add(getId_perstdidefADesc(tblDesc));
		this.add(getScoreADesc(tblDesc));
		this.add(getFg_sumADesc(tblDesc));
		this.add(getCode_diADesc(tblDesc));
		this.add(getName_diADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pechroriskdiCDesc(tblDesc));
		tblDesc.add(getId_pechroriskdiCDesc(tblDesc));
		tblDesc.add(getId_pechroriskCDesc(tblDesc));
		tblDesc.add(getId_perstdidefCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		tblDesc.add(getFg_sumCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检慢性病风险因素诊断主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pechroriskdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pechroriskdi",  getId_pechroriskdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检慢性病风险因素诊断主键标识");
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
	 * 体检诊断ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstdidefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstdidef",  getId_perstdidefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊断ID");
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
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_di",  getCode_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstdidef a1b2","id_perstdidef=id_perstdidef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di",  getName_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstdidef a1b2","id_perstdidef=id_perstdidef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检慢性病风险因素诊断主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pechroriskdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pechroriskdi");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病风险因素诊断主键标识"); 
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
	 * 获取体检诊断ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstdidefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstdidef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊断ID"); 
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
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_di");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pechroriskdi");
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
