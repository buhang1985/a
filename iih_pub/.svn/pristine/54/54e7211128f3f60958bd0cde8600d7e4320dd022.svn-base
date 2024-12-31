
package iih.en.que.board.d.desc;

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
 * 大屏 DO 元数据信息
 */
public class EnBrdDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.que.board.d.EnBrdDO";
	public static final String CLASS_DISPALYNAME = "大屏";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_brd";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_brd";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnBrdDODesc(){
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
		this.setKeyDesc(getId_brdADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_brdADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getTitleADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getAddrADesc(tblDesc));
		this.add(getMsg_rollADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getEu_brdtpcADesc(tblDesc));
		this.add(getT_clear1ADesc(tblDesc));
		this.add(getT_clear2ADesc(tblDesc));
		this.add(getT_clear3ADesc(tblDesc));
		this.add(getT_clear4ADesc(tblDesc));
		this.add(getTimes_callADesc(tblDesc));
		this.add(getId_pcADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getBrd_widthADesc(tblDesc));
		this.add(getNum_row_blockADesc(tblDesc));
		this.add(getBrd_heightADesc(tblDesc));
		this.add(getNum_col_blockADesc(tblDesc));
		this.add(getCircle_diamADesc(tblDesc));
		this.add(getCircle_fontADesc(tblDesc));
		this.add(getList_fontADesc(tblDesc));
		this.add(getFront_widthADesc(tblDesc));
		this.add(getAfter_widthADesc(tblDesc));
		this.add(getFg_singleADesc(tblDesc));
		this.add(getFg_prefaceADesc(tblDesc));
		this.add(getColor_skinADesc(tblDesc));
		this.add(getSd_styleADesc(tblDesc));
		this.add(getFg_showrestpADesc(tblDesc));
		this.add(getCode_pcADesc(tblDesc));
		this.add(getName_pcADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_brdCDesc(tblDesc));
		tblDesc.add(getId_brdCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getTitleCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getAddrCDesc(tblDesc));
		tblDesc.add(getMsg_rollCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getEu_brdtpcCDesc(tblDesc));
		tblDesc.add(getT_clear1CDesc(tblDesc));
		tblDesc.add(getT_clear2CDesc(tblDesc));
		tblDesc.add(getT_clear3CDesc(tblDesc));
		tblDesc.add(getT_clear4CDesc(tblDesc));
		tblDesc.add(getTimes_callCDesc(tblDesc));
		tblDesc.add(getId_pcCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getBrd_widthCDesc(tblDesc));
		tblDesc.add(getNum_row_blockCDesc(tblDesc));
		tblDesc.add(getBrd_heightCDesc(tblDesc));
		tblDesc.add(getNum_col_blockCDesc(tblDesc));
		tblDesc.add(getCircle_diamCDesc(tblDesc));
		tblDesc.add(getCircle_fontCDesc(tblDesc));
		tblDesc.add(getList_fontCDesc(tblDesc));
		tblDesc.add(getFront_widthCDesc(tblDesc));
		tblDesc.add(getAfter_widthCDesc(tblDesc));
		tblDesc.add(getFg_singleCDesc(tblDesc));
		tblDesc.add(getFg_prefaceCDesc(tblDesc));
		tblDesc.add(getColor_skinCDesc(tblDesc));
		tblDesc.add(getSd_styleCDesc(tblDesc));
		tblDesc.add(getFg_showrestpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 大屏主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_brdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_brd",  getId_brdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大屏主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC,BCR");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC,BCR");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title",  getTitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补充说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补充说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 唯一地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr",  getAddrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("唯一地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("URC,BDMODE,BCR");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 滚动消息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMsg_rollADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Msg_roll",  getMsg_rollCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("滚动消息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大屏类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_brdtpcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_brdtpc",  getEu_brdtpcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大屏类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清屏时间1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_clear1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_clear1",  getT_clear1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("清屏时间1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清屏时间2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_clear2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_clear2",  getT_clear2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("清屏时间2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清屏时间3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_clear3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_clear3",  getT_clear3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("清屏时间3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清屏时间4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_clear4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_clear4",  getT_clear4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("清屏时间4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 叫号次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_callADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_call",  getTimes_callCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("叫号次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大屏自身PC属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pc",  getId_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大屏自身PC");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 屏幕宽度(像素)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBrd_widthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Brd_width",  getBrd_widthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("屏幕宽度(像素)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 显示块行数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_row_blockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_row_block",  getNum_row_blockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("显示块行数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 屏幕高度(像素)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBrd_heightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Brd_height",  getBrd_heightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("屏幕高度(像素)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 显示块列数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_col_blockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_col_block",  getNum_col_blockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("显示块列数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 圆圈直径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCircle_diamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Circle_diam",  getCircle_diamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("圆圈直径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 圆圈字号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCircle_fontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Circle_font",  getCircle_fontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("圆圈字号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 列表字号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getList_fontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("List_font",  getList_fontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("列表字号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 前面间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFront_widthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Front_width",  getFront_widthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("前面间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 后面间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAfter_widthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("After_width",  getAfter_widthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("后面间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单列显示属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_singleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_single",  getFg_singleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("单列显示");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正序排列属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prefaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_preface",  getFg_prefaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("正序排列");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤主题色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getColor_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Color_skin",  getColor_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤主题色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大屏样式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_styleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_style",  getSd_styleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大屏样式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否显示号类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_showrestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_showrestp",  getFg_showrestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否显示号类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计算机工作站编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pc",  getCode_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计算机工作站编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pc a0b2","id_pc=id_pc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计算机工作站名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pc",  getName_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计算机工作站名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pc a0b2","id_pc=id_pc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取大屏主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_brdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_brd");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("大屏主键"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
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
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取标题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标题"); 
		return column;
	}
	/**
	 * 获取补充说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补充说明"); 
		return column;
	}
	/**
	 * 获取唯一地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一地址"); 
		return column;
	}
	/**
	 * 获取滚动消息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMsg_rollCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Msg_roll");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("滚动消息"); 
		return column;
	}
	/**
	 * 获取启用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标识"); 
		return column;
	}
	/**
	 * 获取大屏类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_brdtpcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_brdtpc");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大屏类型"); 
		return column;
	}
	/**
	 * 获取清屏时间1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_clear1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_clear1");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清屏时间1"); 
		return column;
	}
	/**
	 * 获取清屏时间2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_clear2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_clear2");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清屏时间2"); 
		return column;
	}
	/**
	 * 获取清屏时间3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_clear3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_clear3");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清屏时间3"); 
		return column;
	}
	/**
	 * 获取清屏时间4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_clear4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_clear4");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清屏时间4"); 
		return column;
	}
	/**
	 * 获取叫号次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_callCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_call");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("叫号次数"); 
		return column;
	}
	/**
	 * 获取大屏自身PC表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大屏自身PC"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取屏幕宽度(像素)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrd_widthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brd_width");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("屏幕宽度(像素)"); 
		return column;
	}
	/**
	 * 获取显示块行数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_row_blockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_row_block");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("显示块行数"); 
		return column;
	}
	/**
	 * 获取屏幕高度(像素)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrd_heightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brd_height");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("屏幕高度(像素)"); 
		return column;
	}
	/**
	 * 获取显示块列数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_col_blockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_col_block");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("显示块列数"); 
		return column;
	}
	/**
	 * 获取圆圈直径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCircle_diamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Circle_diam");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("圆圈直径"); 
		return column;
	}
	/**
	 * 获取圆圈字号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCircle_fontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Circle_font");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("圆圈字号"); 
		return column;
	}
	/**
	 * 获取列表字号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getList_fontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"List_font");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("列表字号"); 
		return column;
	}
	/**
	 * 获取前面间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFront_widthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Front_width");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("前面间隔"); 
		return column;
	}
	/**
	 * 获取后面间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAfter_widthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"After_width");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("后面间隔"); 
		return column;
	}
	/**
	 * 获取单列显示表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_singleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_single");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("单列显示"); 
		return column;
	}
	/**
	 * 获取正序排列表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prefaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_preface");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("正序排列"); 
		return column;
	}
	/**
	 * 获取皮肤主题色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getColor_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Color_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤主题色"); 
		return column;
	}
	/**
	 * 获取大屏样式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_styleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_style");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大屏样式"); 
		return column;
	}
	/**
	 * 获取是否显示号类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_showrestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_showrestp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否显示号类"); 
		return column;
	}
	/**
	 * 获取计算机工作站编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计算机工作站编码"); 
		return column;
	}
	/**
	 * 获取计算机工作站名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计算机工作站名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_brd");
		iBDDataInfoFldMap.put("pid","Id_brd");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
