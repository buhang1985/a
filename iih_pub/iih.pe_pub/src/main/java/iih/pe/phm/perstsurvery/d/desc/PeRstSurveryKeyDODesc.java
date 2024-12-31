
package iih.pe.phm.perstsurvery.d.desc;

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
 * 体检问卷结果答案 DO 元数据信息
 */
public class PeRstSurveryKeyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.perstsurvery.d.PeRstSurveryKeyDO";
	public static final String CLASS_DISPALYNAME = "体检问卷结果答案";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_perstsurverykey";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_perstsurverykey";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstSurveryKeyDODesc(){
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
		this.setKeyDesc(getId_perstsurverykeyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_perstsurveryADesc(tblDesc));
		this.add(getId_perstsurverykeyADesc(tblDesc));
		this.add(getId_perstsurveryADesc(tblDesc));
		this.add(getId_peqacontentdefADesc(tblDesc));
		this.add(getId_peqakeydefADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getId_peqacatlogADesc(tblDesc));
		this.add(getCode_qaADesc(tblDesc));
		this.add(getName_qaADesc(tblDesc));
		this.add(getCode_keyADesc(tblDesc));
		this.add(getName_keyADesc(tblDesc));
		this.add(getFg_posiADesc(tblDesc));
		this.add(getCode_groupADesc(tblDesc));
		this.add(getName_groupADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perstsurverykeyCDesc(tblDesc));
		tblDesc.add(getId_perstsurverykeyCDesc(tblDesc));
		tblDesc.add(getId_perstsurveryCDesc(tblDesc));
		tblDesc.add(getId_peqacontentdefCDesc(tblDesc));
		tblDesc.add(getId_peqakeydefCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getId_peqacatlogCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检问卷结果主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstsurverykeyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstsurverykey",  getId_perstsurverykeyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷结果主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstsurveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstsurvery",  getId_perstsurveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷ID");
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
	 * 开放问题答案属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开放问题答案");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题分组ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacatlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqacatlog",  getId_peqacatlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题分组ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检问卷问题编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_qaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_qa",  getCode_qaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a1b3","id_peqacontentdef=id_peqacontentdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qa",  getName_qaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a1b3","id_peqacontentdef=id_peqacontentdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_key",  getCode_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a1b4","id_peqakeydef=id_peqakeydef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_key",  getName_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a1b4","id_peqakeydef=id_peqakeydef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阳性标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_posiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_posi",  getFg_posiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("阳性标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a1b4","id_peqakeydef=id_peqakeydef","fg_posi"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问卷分组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_group",  getCode_groupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问卷分组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacat a1b5","id_peqacatlog=id_peqacatlog","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问卷分组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_group",  getName_groupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问卷分组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacat a1b5","id_peqacatlog=id_peqacatlog","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检问卷结果主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstsurverykeyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstsurverykey");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检问卷结果主键标识"); 
		return column;
	}
	/**
	 * 获取体检问卷ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstsurveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstsurvery");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷ID"); 
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
	 * 获取开放问题答案表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开放问题答案"); 
		return column;
	}
	/**
	 * 获取体检问卷问题分组ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacatlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqacatlog");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题分组ID"); 
		return column;
	}
	/**
	 * 获取体检问卷问题编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_qaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_qa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题编码"); 
		return column;
	}
	/**
	 * 获取体检问卷问题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_key");
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
	private IColumnDesc getName_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_key");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取阳性标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_posiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_posi");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("阳性标识"); 
		return column;
	}
	/**
	 * 获取问卷分组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_group");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问卷分组编码"); 
		return column;
	}
	/**
	 * 获取问卷分组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_group");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问卷分组名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perstsurverykey");
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
