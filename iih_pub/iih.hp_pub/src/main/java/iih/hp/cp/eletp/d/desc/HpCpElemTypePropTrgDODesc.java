
package iih.hp.cp.eletp.d.desc;

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
 * 诊疗计划元素类型属性联动设置 DO 元数据信息
 */
public class HpCpElemTypePropTrgDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletp.d.HpCpElemTypePropTrgDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素类型属性联动设置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELETP_PPE_TRG";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_eletpppetrg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemTypePropTrgDODesc(){
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
		this.setKeyDesc(getId_eletpppetrgADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_eletpADesc(tblDesc));
		this.add(getId_eletpppetrgADesc(tblDesc));
		this.add(getId_eletpADesc(tblDesc));
		this.add(getTrg_ppe_lstADesc(tblDesc));
		this.add(getPpe_trg_srvADesc(tblDesc));
		this.add(getPpe_inpara_lstADesc(tblDesc));
		this.add(getPpe_outpara_lstADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_eletpppetrgCDesc(tblDesc));
		tblDesc.add(getId_eletpppetrgCDesc(tblDesc));
		tblDesc.add(getId_eletpCDesc(tblDesc));
		tblDesc.add(getTrg_ppe_lstCDesc(tblDesc));
		tblDesc.add(getPpe_trg_srvCDesc(tblDesc));
		tblDesc.add(getPpe_inpara_lstCDesc(tblDesc));
		tblDesc.add(getPpe_outpara_lstCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 属性联动ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpppetrgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletpppetrg",  getId_eletpppetrgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性联动ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletp",  getId_eletpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 触发元素属性串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrg_ppe_lstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trg_ppe_lst",  getTrg_ppe_lstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("触发元素属性串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性联动服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPpe_trg_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ppe_trg_srv",  getPpe_trg_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性联动服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性入参对串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPpe_inpara_lstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ppe_inpara_lst",  getPpe_inpara_lstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性入参对串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性出参对串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPpe_outpara_lstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ppe_outpara_lst",  getPpe_outpara_lstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性出参对串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取属性联动ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpppetrgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletpppetrg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("属性联动ID"); 
		return column;
	}
	/**
	 * 获取元素类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型id"); 
		return column;
	}
	/**
	 * 获取触发元素属性串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrg_ppe_lstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trg_ppe_lst");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("触发元素属性串"); 
		return column;
	}
	/**
	 * 获取属性联动服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPpe_trg_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ppe_trg_srv");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性联动服务"); 
		return column;
	}
	/**
	 * 获取属性入参对串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPpe_inpara_lstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ppe_inpara_lst");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性入参对串"); 
		return column;
	}
	/**
	 * 获取属性出参对串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPpe_outpara_lstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ppe_outpara_lst");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性出参对串"); 
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
