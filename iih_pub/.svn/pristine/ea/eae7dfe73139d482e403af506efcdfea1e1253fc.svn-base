
package iih.ems.einv.emda.d.desc;

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
 * 设备领用申请细目 DO 元数据信息
 */
public class EmsDaItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.einv.emda.d.EmsDaItmDO";
	public static final String CLASS_DISPALYNAME = "设备领用申请细目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ems_da_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_apitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsDaItmDODesc(){
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
		this.setKeyDesc(getId_apitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_daADesc(tblDesc));
		this.add(getId_apitmADesc(tblDesc));
		this.add(getId_daADesc(tblDesc));
		this.add(getId_emblADesc(tblDesc));
		this.add(getId_emADesc(tblDesc));
		this.add(getReq_numADesc(tblDesc));
		this.add(getApp_numADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getEm_nameADesc(tblDesc));
		this.add(getEm_codeADesc(tblDesc));
		this.add(getEmca_inrcodeADesc(tblDesc));
		this.add(getId_cardADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getCard_nameADesc(tblDesc));
		this.add(getSpecsADesc(tblDesc));
		this.add(getBrand_nameADesc(tblDesc));
		this.add(getModelADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_apitmCDesc(tblDesc));
		tblDesc.add(getId_apitmCDesc(tblDesc));
		tblDesc.add(getId_daCDesc(tblDesc));
		tblDesc.add(getId_emblCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getReq_numCDesc(tblDesc));
		tblDesc.add(getApp_numCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getEm_nameCDesc(tblDesc));
		tblDesc.add(getEm_codeCDesc(tblDesc));
		tblDesc.add(getEmca_inrcodeCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getCard_nameCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 申请细目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apitm",  getId_apitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请细目");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_daADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_da",  getId_daCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备库存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emblADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_embl",  getId_emblCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备库存");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备基本信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_em",  getId_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备基本信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReq_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Req_num",  getReq_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("申请数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApp_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("App_num",  getApp_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("审核数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Em_name",  getEm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Em_code",  getEm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分类树内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmca_inrcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emca_inrcode",  getEmca_inrcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分类树内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资产名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_name",  getCard_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资产名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specs",  getSpecsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b4","id_em=id_em","specs"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 品牌名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBrand_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Brand_name",  getBrand_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("品牌名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b4","id_em=id_em","brand_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 型号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Model",  getModelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("型号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b4","id_em=id_em","model"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取申请细目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请细目"); 
		return column;
	}
	/**
	 * 获取申请单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_daCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_da");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单主键"); 
		return column;
	}
	/**
	 * 获取设备库存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emblCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_embl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备库存"); 
		return column;
	}
	/**
	 * 获取设备基本信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_em");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备基本信息"); 
		return column;
	}
	/**
	 * 获取申请数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReq_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Req_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("申请数量"); 
		return column;
	}
	/**
	 * 获取审核数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApp_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"App_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("审核数量"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取设备名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Em_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备名称"); 
		return column;
	}
	/**
	 * 获取设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Em_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备编码"); 
		return column;
	}
	/**
	 * 获取分类树内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmca_inrcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emca_inrcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分类树内码"); 
		return column;
	}
	/**
	 * 获取资产主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产主键"); 
		return column;
	}
	/**
	 * 获取资产编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产编号"); 
		return column;
	}
	/**
	 * 获取资产名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资产名称"); 
		return column;
	}
	/**
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规格"); 
		return column;
	}
	/**
	 * 获取品牌名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrand_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brand_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("品牌名称"); 
		return column;
	}
	/**
	 * 获取型号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Model");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("型号"); 
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
