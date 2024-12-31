
package iih.mm.st.settlement.d.desc;

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
 * 结算回冲关系表 DO 元数据信息
 */
public class SettlementInRelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.st.settlement.d.SettlementInRelDO";
	public static final String CLASS_DISPALYNAME = "结算回冲关系表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MM_BANL_IN_REL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_invinrel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SettlementInRelDODesc(){
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
		this.setKeyDesc(getId_invinrelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_invinrelADesc(tblDesc));
		this.add(getId_banlitmADesc(tblDesc));
		this.add(getId_initmADesc(tblDesc));
		this.add(getId_inADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_invinrelCDesc(tblDesc));
		tblDesc.add(getId_invinrelCDesc(tblDesc));
		tblDesc.add(getId_banlitmCDesc(tblDesc));
		tblDesc.add(getId_initmCDesc(tblDesc));
		tblDesc.add(getId_inCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 结算回冲关系主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_invinrelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_invinrel",  getId_invinrelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算回冲关系主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_banlitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_banlitm",  getId_banlitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 回冲入库明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_initmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_initm",  getId_initmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("回冲入库明细主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 回冲入库单外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_in",  getId_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("回冲入库单外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取结算回冲关系主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_invinrelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_invinrel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结算回冲关系主键"); 
		return column;
	}
	/**
	 * 获取结算明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_banlitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_banlitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算明细"); 
		return column;
	}
	/**
	 * 获取回冲入库明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_initmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_initm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("回冲入库明细主键"); 
		return column;
	}
	/**
	 * 获取回冲入库单外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_in");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("回冲入库单外键"); 
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
	
}
