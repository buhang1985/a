
package iih.ci.mr.mrsign.d.desc;

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
 * 医疗记录_电子签名 DO 元数据信息
 */
public class CiMrSignCaDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.mrsign.d.CiMrSignCaDO";
	public static final String CLASS_DISPALYNAME = "医疗记录_电子签名";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_signca";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrsignca";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrSignCaDODesc(){
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
		this.setKeyDesc(getId_mrsigncaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mrsignADesc(tblDesc));
		this.add(getId_mrsigncaADesc(tblDesc));
		this.add(getId_mrsignADesc(tblDesc));
		this.add(getSign_cert_caADesc(tblDesc));
		this.add(getEmr_filepathADesc(tblDesc));
		this.add(getCryptd_emr_filepathADesc(tblDesc));
		this.add(getPlain_sign_timeADesc(tblDesc));
		this.add(getCrypt_sign_timeADesc(tblDesc));
		this.add(getEmr_fsADesc(tblDesc));
		this.add(getCryptd_emr_fsADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrsigncaCDesc(tblDesc));
		tblDesc.add(getId_mrsigncaCDesc(tblDesc));
		tblDesc.add(getId_mrsignCDesc(tblDesc));
		tblDesc.add(getSign_cert_caCDesc(tblDesc));
		tblDesc.add(getEmr_filepathCDesc(tblDesc));
		tblDesc.add(getCryptd_emr_filepathCDesc(tblDesc));
		tblDesc.add(getPlain_sign_timeCDesc(tblDesc));
		tblDesc.add(getCrypt_sign_timeCDesc(tblDesc));
		tblDesc.add(getEmr_fsCDesc(tblDesc));
		tblDesc.add(getCryptd_emr_fsCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 电子签名主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrsigncaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrsignca",  getId_mrsigncaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电子签名主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrsignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrsign",  getId_mrsignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签署人公钥属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_cert_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_cert_ca",  getSign_cert_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署人公钥");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历文件路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmr_filepathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emr_filepath",  getEmr_filepathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历文件路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加密后病历文件路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCryptd_emr_filepathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cryptd_emr_filepath",  getCryptd_emr_filepathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加密后病历文件路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlain_sign_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plain_sign_time",  getPlain_sign_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加密签署时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCrypt_sign_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Crypt_sign_time",  getCrypt_sign_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加密签署时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历数据流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmr_fsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emr_fs",  getEmr_fsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("病历数据流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 加密病历数据流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCryptd_emr_fsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cryptd_emr_fs",  getCryptd_emr_fsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("加密病历数据流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取电子签名主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrsigncaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrsignca");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("电子签名主键"); 
		return column;
	}
	/**
	 * 获取签署主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrsignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrsign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署主键"); 
		return column;
	}
	/**
	 * 获取签署人公钥表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_cert_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_cert_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署人公钥"); 
		return column;
	}
	/**
	 * 获取病历文件路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmr_filepathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emr_filepath");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历文件路径"); 
		return column;
	}
	/**
	 * 获取加密后病历文件路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCryptd_emr_filepathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cryptd_emr_filepath");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加密后病历文件路径"); 
		return column;
	}
	/**
	 * 获取签署时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlain_sign_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plain_sign_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署时间"); 
		return column;
	}
	/**
	 * 获取加密签署时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCrypt_sign_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Crypt_sign_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加密签署时间"); 
		return column;
	}
	/**
	 * 获取病历数据流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmr_fsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emr_fs");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("病历数据流"); 
		return column;
	}
	/**
	 * 获取加密病历数据流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCryptd_emr_fsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cryptd_emr_fs");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("加密病历数据流"); 
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
