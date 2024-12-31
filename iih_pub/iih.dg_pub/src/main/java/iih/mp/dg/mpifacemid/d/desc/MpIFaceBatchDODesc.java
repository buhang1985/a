
package iih.mp.dg.mpifacemid.d.desc;

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
 * 日志表 DO 元数据信息
 */
public class MpIFaceBatchDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.mpifacemid.d.MpIFaceBatchDO";
	public static final String CLASS_DISPALYNAME = "日志表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "IIH_GL_HIS_BATCH_IFACE";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Iface_batch_id";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpIFaceBatchDODesc(){
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
		this.setKeyDesc(getIface_batch_idADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getIface_batch_idADesc(tblDesc));
		this.add(getHospital_codeADesc(tblDesc));
		this.add(getBatch_typeADesc(tblDesc));
		this.add(getSync_dateADesc(tblDesc));
		this.add(getProcess_flagADesc(tblDesc));
		this.add(getProcess_dateADesc(tblDesc));
		this.add(getDescriptionADesc(tblDesc));
		this.add(getAttribute1ADesc(tblDesc));
		this.add(getAttribute2ADesc(tblDesc));
		this.add(getAttribute3ADesc(tblDesc));
		this.add(getAttribute4ADesc(tblDesc));
		this.add(getAttribute5ADesc(tblDesc));
		this.add(getAttribute6ADesc(tblDesc));
		this.add(getAttribute7ADesc(tblDesc));
		this.add(getAttribute8ADesc(tblDesc));
		this.add(getAttribute9ADesc(tblDesc));
		this.add(getAttribute10ADesc(tblDesc));
		this.add(getAttribute11ADesc(tblDesc));
		this.add(getAttribute12ADesc(tblDesc));
		this.add(getAttribute13ADesc(tblDesc));
		this.add(getAttribute14ADesc(tblDesc));
		this.add(getAttribute15ADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getIface_batch_idCDesc(tblDesc));
		tblDesc.add(getIface_batch_idCDesc(tblDesc));
		tblDesc.add(getHospital_codeCDesc(tblDesc));
		tblDesc.add(getBatch_typeCDesc(tblDesc));
		tblDesc.add(getSync_dateCDesc(tblDesc));
		tblDesc.add(getProcess_flagCDesc(tblDesc));
		tblDesc.add(getProcess_dateCDesc(tblDesc));
		tblDesc.add(getDescriptionCDesc(tblDesc));
		tblDesc.add(getAttribute1CDesc(tblDesc));
		tblDesc.add(getAttribute2CDesc(tblDesc));
		tblDesc.add(getAttribute3CDesc(tblDesc));
		tblDesc.add(getAttribute4CDesc(tblDesc));
		tblDesc.add(getAttribute5CDesc(tblDesc));
		tblDesc.add(getAttribute6CDesc(tblDesc));
		tblDesc.add(getAttribute7CDesc(tblDesc));
		tblDesc.add(getAttribute8CDesc(tblDesc));
		tblDesc.add(getAttribute9CDesc(tblDesc));
		tblDesc.add(getAttribute10CDesc(tblDesc));
		tblDesc.add(getAttribute11CDesc(tblDesc));
		tblDesc.add(getAttribute12CDesc(tblDesc));
		tblDesc.add(getAttribute13CDesc(tblDesc));
		tblDesc.add(getAttribute14CDesc(tblDesc));
		tblDesc.add(getAttribute15CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 每次上传号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIface_batch_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iface_batch_id",  getIface_batch_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("每次上传号");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_code",  getHospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上传类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBatch_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Batch_type",  getBatch_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上传类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上传日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSync_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sync_date",  getSync_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("上传日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProcess_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Process_flag",  getProcess_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProcess_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Process_date",  getProcess_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("处理日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDescriptionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Description",  getDescriptionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute1",  getAttribute1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute2",  getAttribute2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute3",  getAttribute3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute4",  getAttribute4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute5",  getAttribute5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute6",  getAttribute6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute7",  getAttribute7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute8",  getAttribute8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute9",  getAttribute9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute10",  getAttribute10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute11",  getAttribute11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute12",  getAttribute12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute13",  getAttribute13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute14",  getAttribute14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttribute15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attribute15",  getAttribute15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取每次上传号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIface_batch_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iface_batch_id");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("每次上传号"); 
		return column;
	}
	/**
	 * 获取医院编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_code");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院编码"); 
		return column;
	}
	/**
	 * 获取上传类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBatch_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Batch_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上传类型"); 
		return column;
	}
	/**
	 * 获取上传日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSync_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sync_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上传日期"); 
		return column;
	}
	/**
	 * 获取处理标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProcess_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Process_flag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理标识"); 
		return column;
	}
	/**
	 * 获取处理日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProcess_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Process_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("处理日期"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDescriptionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Description");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
		return column;
	}
	/**
	 * 获取属性1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性1"); 
		return column;
	}
	/**
	 * 获取属性2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性2"); 
		return column;
	}
	/**
	 * 获取属性3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性3"); 
		return column;
	}
	/**
	 * 获取属性4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性4"); 
		return column;
	}
	/**
	 * 获取属性5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性5"); 
		return column;
	}
	/**
	 * 获取属性6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性6"); 
		return column;
	}
	/**
	 * 获取属性7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute7");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性7"); 
		return column;
	}
	/**
	 * 获取属性8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute8");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性8"); 
		return column;
	}
	/**
	 * 获取属性9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute9");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性9"); 
		return column;
	}
	/**
	 * 获取属性10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute10");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性10"); 
		return column;
	}
	/**
	 * 获取属性11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute11");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性11"); 
		return column;
	}
	/**
	 * 获取属性12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute12");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性12"); 
		return column;
	}
	/**
	 * 获取属性13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute13");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性13"); 
		return column;
	}
	/**
	 * 获取属性14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute14");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性14"); 
		return column;
	}
	/**
	 * 获取属性15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttribute15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attribute15");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性15"); 
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
