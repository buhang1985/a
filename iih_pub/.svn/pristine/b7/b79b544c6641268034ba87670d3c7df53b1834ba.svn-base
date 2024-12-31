
package iih.bl.hp.hpblllitm.d.desc;

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
 * 医保交易明细 DO 元数据信息
 */
public class BlHpCgItmIpDoDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo";
	public static final String CLASS_DISPALYNAME = "医保交易明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_hp_cgitm_ip";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hpblllitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlHpCgItmIpDoDesc(){
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
		this.setKeyDesc(getId_hpblllitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hpblllitmADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_cgipADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getAmt_payzlADesc(tblDesc));
		this.add(getAmt_payzfADesc(tblDesc));
		this.add(getAmt_cxj_payzfADesc(tblDesc));
		this.add(getAmt_czl_payzfADesc(tblDesc));
		this.add(getCode_caADesc(tblDesc));
		this.add(getSd_hpsrvtpADesc(tblDesc));
		this.add(getFg_selfpayADesc(tblDesc));
		this.add(getRate_payzlADesc(tblDesc));
		this.add(getLimited_priADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getHp_srvcodeADesc(tblDesc));
		this.add(getSender_flow_noADesc(tblDesc));
		this.add(getFail_cntADesc(tblDesc));
		this.add(getPresauth_selfADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hpblllitmCDesc(tblDesc));
		tblDesc.add(getId_hpblllitmCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_cgipCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getAmt_payzlCDesc(tblDesc));
		tblDesc.add(getAmt_payzfCDesc(tblDesc));
		tblDesc.add(getAmt_cxj_payzfCDesc(tblDesc));
		tblDesc.add(getAmt_czl_payzfCDesc(tblDesc));
		tblDesc.add(getCode_caCDesc(tblDesc));
		tblDesc.add(getSd_hpsrvtpCDesc(tblDesc));
		tblDesc.add(getFg_selfpayCDesc(tblDesc));
		tblDesc.add(getRate_payzlCDesc(tblDesc));
		tblDesc.add(getLimited_priCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getHp_srvcodeCDesc(tblDesc));
		tblDesc.add(getSender_flow_noCDesc(tblDesc));
		tblDesc.add(getFail_cntCDesc(tblDesc));
		tblDesc.add(getPresauth_selfCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保交易明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpblllitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpblllitm",  getId_hpblllitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保交易明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院记账主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cgipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cgip",  getId_cgipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院记账主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 项目金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("项目金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_payzlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_payzl",  getAmt_payzlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自理金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自费金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_payzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_payzf",  getAmt_payzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自费金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超限价自付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cxj_payzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cxj_payzf",  getAmt_cxj_payzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超限价自付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超出治疗方案金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_czl_payzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_czl_payzf",  getAmt_czl_payzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超出治疗方案金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ca",  getCode_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费项目等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hpsrvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hpsrvtp",  getSd_hpsrvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费项目等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额自费标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_selfpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_selfpay",  getFg_selfpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("金额自费标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_payzlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_payzl",  getRate_payzlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自理比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 限价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLimited_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Limited_pri",  getLimited_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("限价");
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
	 * 医保中心编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_srvcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_srvcode",  getHp_srvcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保中心编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 明细上传发送方流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSender_flow_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sender_flow_no",  getSender_flow_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("明细上传发送方流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失败次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFail_cntADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fail_cnt",  getFail_cntCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失败次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医师无处方权限自费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPresauth_selfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Presauth_self",  getPresauth_selfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医师无处方权限自费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保交易明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpblllitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpblllitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保交易明细主键"); 
		return column;
	}
	/**
	 * 获取就诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊主键"); 
		return column;
	}
	/**
	 * 获取住院记账主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cgipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cgip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院记账主键"); 
		return column;
	}
	/**
	 * 获取项目金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(18);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("项目金额"); 
		return column;
	}
	/**
	 * 获取自理金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_payzlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_payzl");
		column.setLength(18);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自理金额"); 
		return column;
	}
	/**
	 * 获取自费金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_payzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_payzf");
		column.setLength(18);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自费金额"); 
		return column;
	}
	/**
	 * 获取超限价自付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cxj_payzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cxj_payzf");
		column.setLength(18);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超限价自付金额"); 
		return column;
	}
	/**
	 * 获取超出治疗方案金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_czl_payzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_czl_payzf");
		column.setLength(18);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超出治疗方案金额"); 
		return column;
	}
	/**
	 * 获取收费类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费类别"); 
		return column;
	}
	/**
	 * 获取收费项目等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hpsrvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hpsrvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费项目等级"); 
		return column;
	}
	/**
	 * 获取金额自费标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_selfpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_selfpay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("金额自费标志"); 
		return column;
	}
	/**
	 * 获取自理比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_payzlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_payzl");
		column.setLength(15);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自理比例"); 
		return column;
	}
	/**
	 * 获取限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLimited_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Limited_pri");
		column.setLength(10);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("限价"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取医保中心编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_srvcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_srvcode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保中心编码"); 
		return column;
	}
	/**
	 * 获取明细上传发送方流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSender_flow_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sender_flow_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("明细上传发送方流水号"); 
		return column;
	}
	/**
	 * 获取失败次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFail_cntCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fail_cnt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失败次数"); 
		return column;
	}
	/**
	 * 获取医师无处方权限自费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPresauth_selfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Presauth_self");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医师无处方权限自费"); 
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
		defaultValueMap.put("Fail_cnt",0);
	}
	
}
