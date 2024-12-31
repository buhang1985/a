
package iih.bd.srv.mrmtype.d.desc;

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
 * 病案分类数据集对照 DO 元数据信息
 */
public class MrmTypeMrtpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.mrmtype.d.MrmTypeMrtpDO";
	public static final String CLASS_DISPALYNAME = "病案分类数据集对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrm_tp_mrtp";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_bd_mrm_mrtp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MrmTypeMrtpDODesc(){
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
		this.setKeyDesc(getId_bd_mrm_mrtpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_bd_mrm_tpADesc(tblDesc));
		this.add(getId_bd_mrm_mrtpADesc(tblDesc));
		this.add(getId_bd_mrm_tpADesc(tblDesc));
		this.add(getId_setADesc(tblDesc));
		this.add(getDataset_codeADesc(tblDesc));
		this.add(getDataset_nameADesc(tblDesc));
		this.add(getDataset_pycodeADesc(tblDesc));
		this.add(getDataset_wbcodeADesc(tblDesc));
		this.add(getDataset_mnecodeADesc(tblDesc));
		this.add(getDataset_desADesc(tblDesc));
		this.add(getDataset_setcaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_bd_mrm_mrtpCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_mrtpCDesc(tblDesc));
		tblDesc.add(getId_bd_mrm_tpCDesc(tblDesc));
		tblDesc.add(getId_setCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_mrtp",  getId_bd_mrm_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案分类主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_mrm_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_mrm_tp",  getId_bd_mrm_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案分类主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据集主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_set",  getId_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据集编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_code",  getDataset_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据集名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_name",  getDataset_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_pycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_pycode",  getDataset_pycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","pycode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_wbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_wbcode",  getDataset_wbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","wbcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_mnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_mnecode",  getDataset_mnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","mnecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据集描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_des",  getDataset_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","des"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据集分类主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataset_setcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataset_setca",  getDataset_setcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集分类主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a1b3","id_set=id_set","id_setca"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_mrtp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取病案分类主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_mrm_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_mrm_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案分类主键"); 
		return column;
	}
	/**
	 * 获取数据集主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_set");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集主键"); 
		return column;
	}
	/**
	 * 获取数据集编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集编码"); 
		return column;
	}
	/**
	 * 获取数据集名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集名称"); 
		return column;
	}
	/**
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_pycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_pycode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_wbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_wbcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_mnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_mnecode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取数据集描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_des");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集描述"); 
		return column;
	}
	/**
	 * 获取数据集分类主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataset_setcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataset_setca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集分类主键"); 
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
