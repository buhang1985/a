
package iih.mi.biz.insureprop.ynyuxiethip.d.desc;

import java.sql.Types;
import java.util.HashMap;

import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;

/**
 * 玉溪住院医保分摊 DO 元数据信息
 */
public class MiPropArIpYXNeusoftDODesc extends DODesc {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String CLASS_FULLNAME = "iih.mi.biz.insureprop.ynyuxiethip.d.MiPropArIpYXNeusoftDO";
	public static final String CLASS_DISPALYNAME = "玉溪住院医保分摊";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_prop_arip_yxneusoft";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_prop_yx";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiPropArIpYXNeusoftDODesc(){
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
		this.setKeyDesc(getId_prop_yxADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_prop_yxADesc(tblDesc));
		this.add(getSer_noADesc(tblDesc));
		this.add(getCash_dateADesc(tblDesc));
		this.add(getRec_lshADesc(tblDesc));
		this.add(getSend_lshADesc(tblDesc));
		this.add(getReceipt_noADesc(tblDesc));
		this.add(getBusiness_noADesc(tblDesc));
		this.add(getRec_cor_lshADesc(tblDesc));
		this.add(getSend_cor_lshADesc(tblDesc));
		this.add(getRec_rev_lshADesc(tblDesc));
		this.add(getSend_rev_lshADesc(tblDesc));
		this.add(getIsreadADesc(tblDesc));
		this.add(getLast_balanceADesc(tblDesc));
		this.add(getTotalADesc(tblDesc));
		this.add(getZhzfADesc(tblDesc));
		this.add(getCashADesc(tblDesc));
		this.add(getGb_zhzfADesc(tblDesc));
		this.add(getQb_zhzfADesc(tblDesc));
		this.add(getTczfADesc(tblDesc));
		this.add(getQbzfADesc(tblDesc));
		this.add(getGwyzfADesc(tblDesc));
		this.add(getJfqgzrybzADesc(tblDesc));
		this.add(getEyzfADesc(tblDesc));
		this.add(getGszfADesc(tblDesc));
		this.add(getBirthzfADesc(tblDesc));
		this.add(getLosezfADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getCard_back_infoADesc(tblDesc));
		this.add(getReg_inputADesc(tblDesc));
		this.add(getReg_backADesc(tblDesc));
		this.add(getYjs_inputADesc(tblDesc));
		this.add(getYjs_backADesc(tblDesc));
		this.add(getJs_inputADesc(tblDesc));
		this.add(getJs_backADesc(tblDesc));
		this.add(getTf_inputADesc(tblDesc));
		this.add(getTf_backADesc(tblDesc));
		this.add(getTf_dateADesc(tblDesc));
		this.add(getSubsys_idADesc(tblDesc));
		this.add(getDblpADesc(tblDesc));
		this.add(getZgrybzADesc(tblDesc));
		this.add(getQfxADesc(tblDesc));
		this.add(getIn_timesADesc(tblDesc));
		this.add(getQfxsyADesc(tblDesc));
		this.add(getBgbzADesc(tblDesc));
		this.add(getBgjyADesc(tblDesc));
		this.add(getQzfjeADesc(tblDesc));
		this.add(getMxbxesyADesc(tblDesc));
		this.add(getJbylzhADesc(tblDesc));
		this.add(getGwylyzhADesc(tblDesc));
		this.add(getJbdbxjeADesc(tblDesc));
		this.add(getDbbxjeADesc(tblDesc));
		this.add(getZnshydxxADesc(tblDesc));
		this.add(getDrgs_ffbzADesc(tblDesc));
		this.add(getDrgs_jjbzADesc(tblDesc));
		this.add(getYljzADesc(tblDesc));
		this.add(getDdbzADesc(tblDesc));
		this.add(getBxjesmADesc(tblDesc));
		this.add(getJsqsxxADesc(tblDesc));
		this.add(getJbyltczfADesc(tblDesc));
		this.add(getYycdADesc(tblDesc));
		this.add(getId_proparipADesc(tblDesc));
		this.add(getHpacc_beforeADesc(tblDesc));
		this.add(getQxtcqbhADesc(tblDesc));
		this.add(getZstcqbhADesc(tblDesc));
		this.add(getGrbhADesc(tblDesc));
		this.add(getRylbbmADesc(tblDesc));
		this.add(getZgjmbzADesc(tblDesc));
		this.add(getCode_medkindADesc(tblDesc));
		this.add(getDi_codeADesc(tblDesc));
		this.add(getDi_nameADesc(tblDesc));
		this.add(getSt_typeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_prop_yxCDesc(tblDesc));
		tblDesc.add(getId_prop_yxCDesc(tblDesc));
		tblDesc.add(getSer_noCDesc(tblDesc));
		tblDesc.add(getCash_dateCDesc(tblDesc));
		tblDesc.add(getRec_lshCDesc(tblDesc));
		tblDesc.add(getSend_lshCDesc(tblDesc));
		tblDesc.add(getReceipt_noCDesc(tblDesc));
		tblDesc.add(getBusiness_noCDesc(tblDesc));
		tblDesc.add(getRec_cor_lshCDesc(tblDesc));
		tblDesc.add(getSend_cor_lshCDesc(tblDesc));
		tblDesc.add(getRec_rev_lshCDesc(tblDesc));
		tblDesc.add(getSend_rev_lshCDesc(tblDesc));
		tblDesc.add(getIsreadCDesc(tblDesc));
		tblDesc.add(getLast_balanceCDesc(tblDesc));
		tblDesc.add(getTotalCDesc(tblDesc));
		tblDesc.add(getZhzfCDesc(tblDesc));
		tblDesc.add(getCashCDesc(tblDesc));
		tblDesc.add(getGb_zhzfCDesc(tblDesc));
		tblDesc.add(getQb_zhzfCDesc(tblDesc));
		tblDesc.add(getTczfCDesc(tblDesc));
		tblDesc.add(getQbzfCDesc(tblDesc));
		tblDesc.add(getGwyzfCDesc(tblDesc));
		tblDesc.add(getJfqgzrybzCDesc(tblDesc));
		tblDesc.add(getEyzfCDesc(tblDesc));
		tblDesc.add(getGszfCDesc(tblDesc));
		tblDesc.add(getBirthzfCDesc(tblDesc));
		tblDesc.add(getLosezfCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getCard_back_infoCDesc(tblDesc));
		tblDesc.add(getReg_inputCDesc(tblDesc));
		tblDesc.add(getReg_backCDesc(tblDesc));
		tblDesc.add(getYjs_inputCDesc(tblDesc));
		tblDesc.add(getYjs_backCDesc(tblDesc));
		tblDesc.add(getJs_inputCDesc(tblDesc));
		tblDesc.add(getJs_backCDesc(tblDesc));
		tblDesc.add(getTf_inputCDesc(tblDesc));
		tblDesc.add(getTf_backCDesc(tblDesc));
		tblDesc.add(getTf_dateCDesc(tblDesc));
		tblDesc.add(getSubsys_idCDesc(tblDesc));
		tblDesc.add(getDblpCDesc(tblDesc));
		tblDesc.add(getZgrybzCDesc(tblDesc));
		tblDesc.add(getQfxCDesc(tblDesc));
		tblDesc.add(getIn_timesCDesc(tblDesc));
		tblDesc.add(getQfxsyCDesc(tblDesc));
		tblDesc.add(getBgbzCDesc(tblDesc));
		tblDesc.add(getBgjyCDesc(tblDesc));
		tblDesc.add(getQzfjeCDesc(tblDesc));
		tblDesc.add(getMxbxesyCDesc(tblDesc));
		tblDesc.add(getJbylzhCDesc(tblDesc));
		tblDesc.add(getGwylyzhCDesc(tblDesc));
		tblDesc.add(getJbdbxjeCDesc(tblDesc));
		tblDesc.add(getDbbxjeCDesc(tblDesc));
		tblDesc.add(getZnshydxxCDesc(tblDesc));
		tblDesc.add(getDrgs_ffbzCDesc(tblDesc));
		tblDesc.add(getDrgs_jjbzCDesc(tblDesc));
		tblDesc.add(getYljzCDesc(tblDesc));
		tblDesc.add(getDdbzCDesc(tblDesc));
		tblDesc.add(getBxjesmCDesc(tblDesc));
		tblDesc.add(getJsqsxxCDesc(tblDesc));
		tblDesc.add(getJbyltczfCDesc(tblDesc));
		tblDesc.add(getYycdCDesc(tblDesc));
		tblDesc.add(getId_proparipCDesc(tblDesc));
		tblDesc.add(getHpacc_beforeCDesc(tblDesc));
		tblDesc.add(getQxtcqbhCDesc(tblDesc));
		tblDesc.add(getZstcqbhCDesc(tblDesc));
		tblDesc.add(getGrbhCDesc(tblDesc));
		tblDesc.add(getRylbbmCDesc(tblDesc));
		tblDesc.add(getZgjmbzCDesc(tblDesc));
		tblDesc.add(getCode_medkindCDesc(tblDesc));
		tblDesc.add(getDi_codeCDesc(tblDesc));
		tblDesc.add(getDi_nameCDesc(tblDesc));
		tblDesc.add(getSt_typeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 应收扩展表主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_prop_yxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prop_yx",  getId_prop_yxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收扩展表主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSer_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ser_no",  getSer_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCash_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cash_date",  getCash_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结算时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRec_lshADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rec_lsh",  getRec_lshCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发送流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSend_lshADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Send_lsh",  getSend_lshCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发送流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发票序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReceipt_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Receipt_no",  getReceipt_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发票序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务周期号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBusiness_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Business_no",  getBusiness_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务周期号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收方被冲正交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRec_cor_lshADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rec_cor_lsh",  getRec_cor_lshCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收方被冲正交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发送方被冲正交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSend_cor_lshADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Send_cor_lsh",  getSend_cor_lshCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发送方被冲正交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收方被撤销交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRec_rev_lshADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rec_rev_lsh",  getRec_rev_lshCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收方被撤销交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发送方被撤销交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSend_rev_lshADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Send_rev_lsh",  getSend_rev_lshCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发送方被撤销交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否读卡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIsreadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Isread",  getIsreadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否读卡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上次余额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLast_balanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Last_balance",  getLast_balanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("上次余额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total",  getTotalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账户支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZhzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zhzf",  getZhzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("账户支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现金属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cash",  getCashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("现金");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公补账户支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGb_zhzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gb_zhzf",  getGb_zhzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("公补账户支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 企补账户支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQb_zhzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qb_zhzf",  getQb_zhzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("企补账户支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统筹支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTczfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tczf",  getTczfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("统筹支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 企补支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQbzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qbzf",  getQbzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("企补支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公务员补助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGwyzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gwyzf",  getGwyzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("公务员补助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 解放前工作人员补助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJfqgzrybzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jfqgzrybz",  getJfqgzrybzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("解放前工作人员补助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二等乙基金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEyzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eyzf",  getEyzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("二等乙基金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工伤基金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGszfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gszf",  getGszfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("工伤基金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生育支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirthzfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birthzf",  getBirthzfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("生育支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失业支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLosezfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Losezf",  getLosezfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("失业支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_back_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_back_info",  getCard_back_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记入参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReg_inputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reg_input",  getReg_inputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记入参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记出参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReg_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reg_back",  getReg_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记出参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预结算入参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYjs_inputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Yjs_input",  getYjs_inputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预结算入参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预结算出参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYjs_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Yjs_back",  getYjs_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预结算出参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算入参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJs_inputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Js_input",  getJs_inputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算入参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算出参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJs_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Js_back",  getJs_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算出参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费入参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTf_inputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tf_input",  getTf_inputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费入参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费出参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTf_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tf_back",  getTf_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费出参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTf_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tf_date",  getTf_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("退费时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 子系统标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubsys_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subsys_id",  getSubsys_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("子系统标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病理赔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDblpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dblp",  getDblpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("大病理赔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 照顾人员补助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZgrybzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zgrybz",  getZgrybzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("照顾人员补助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 起付线属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQfxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qfx",  getQfxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("起付线");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_times",  getIn_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 起付线剩余属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQfxsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qfxsy",  getQfxsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("起付线剩余");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包干标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBgbzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bgbz",  getBgbzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("包干标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包干结余属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBgjyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bgjy",  getBgjyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("包干结余");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 全自费金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQzfjeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qzfje",  getQzfjeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("全自费金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 慢性病限额剩余属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMxbxesyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mxbxesy",  getMxbxesyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("慢性病限额剩余");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本医疗账户属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJbylzhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jbylzh",  getJbylzhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("基本医疗账户");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公务员医疗账户属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGwylyzhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gwylyzh",  getGwylyzhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("公务员医疗账户");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 符合基本段报销金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJbdbxjeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jbdbxje",  getJbdbxjeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("符合基本段报销金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 符合大病报销金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDbbxjeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dbbxje",  getDbbxjeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("符合大病报销金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 智能审核疑点信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZnshydxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Znshydxx",  getZnshydxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("智能审核疑点信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * drgs付费标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrgs_ffbzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drgs_ffbz",  getDrgs_ffbzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("drgs付费标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * drgs基金标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrgs_jjbzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drgs_jjbz",  getDrgs_jjbzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("drgs基金标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗救助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYljzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Yljz",  getYljzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医疗救助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 兜底保障属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDdbzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ddbz",  getDdbzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("兜底保障");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报销金额说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBxjesmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bxjesm",  getBxjesmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报销金额说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算提示信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJsqsxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jsqsxx",  getJsqsxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算提示信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本医疗统筹支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJbyltczfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jbyltczf",  getJbyltczfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("基本医疗统筹支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院承担属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYycdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Yycd",  getYycdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医院承担");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应收主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proparip",  getId_proparipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算前医保账户余额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHpacc_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hpacc_before",  getHpacc_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("结算前医保账户余额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 区县统筹区编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQxtcqbhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qxtcqbh",  getQxtcqbhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("区县统筹区编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 州市统筹区编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZstcqbhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zstcqbh",  getZstcqbhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("州市统筹区编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrbhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grbh",  getGrbhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员类别编码(医保身份)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRylbbmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rylbbm",  getRylbbmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员类别编码(医保身份)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职工居民标志(1:居民,0:职工)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZgjmbzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zgjmbz",  getZgjmbzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职工居民标志(1:居民,0:职工)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_medkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_medkind",  getCode_medkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确诊疾病编码 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_code",  getDi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确诊疾病编码 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院疾病名称 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_name",  getDi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院疾病名称 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算类型(1:正常,2:中途,3:挂失,4:自费)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSt_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("St_type",  getSt_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算类型(1:正常,2:中途,3:挂失,4:自费)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取应收扩展表主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_prop_yxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prop_yx");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应收扩展表主键ID"); 
		return column;
	}
	/**
	 * 获取交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSer_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ser_no");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易流水号"); 
		return column;
	}
	/**
	 * 获取结算时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCash_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cash_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结算时间"); 
		return column;
	}
	/**
	 * 获取接收流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRec_lshCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rec_lsh");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收流水号"); 
		return column;
	}
	/**
	 * 获取发送流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSend_lshCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Send_lsh");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发送流水号"); 
		return column;
	}
	/**
	 * 获取发票序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReceipt_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Receipt_no");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发票序号"); 
		return column;
	}
	/**
	 * 获取业务周期号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBusiness_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Business_no");
		column.setLength(29);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务周期号"); 
		return column;
	}
	/**
	 * 获取接收方被冲正交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRec_cor_lshCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rec_cor_lsh");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收方被冲正交易流水号"); 
		return column;
	}
	/**
	 * 获取发送方被冲正交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSend_cor_lshCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Send_cor_lsh");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发送方被冲正交易流水号"); 
		return column;
	}
	/**
	 * 获取接收方被撤销交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRec_rev_lshCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rec_rev_lsh");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收方被撤销交易流水号"); 
		return column;
	}
	/**
	 * 获取发送方被撤销交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSend_rev_lshCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Send_rev_lsh");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发送方被撤销交易流水号"); 
		return column;
	}
	/**
	 * 获取是否读卡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIsreadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Isread");
		column.setLength(1);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否读卡"); 
		return column;
	}
	/**
	 * 获取上次余额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLast_balanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Last_balance");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("上次余额"); 
		return column;
	}
	/**
	 * 获取总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总额"); 
		return column;
	}
	/**
	 * 获取账户支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZhzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zhzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("账户支付"); 
		return column;
	}
	/**
	 * 获取现金表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cash");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("现金"); 
		return column;
	}
	/**
	 * 获取公补账户支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGb_zhzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gb_zhzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("公补账户支付"); 
		return column;
	}
	/**
	 * 获取企补账户支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQb_zhzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qb_zhzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("企补账户支付"); 
		return column;
	}
	/**
	 * 获取统筹支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTczfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tczf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("统筹支付"); 
		return column;
	}
	/**
	 * 获取企补支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQbzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qbzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("企补支付"); 
		return column;
	}
	/**
	 * 获取公务员补助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGwyzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gwyzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("公务员补助"); 
		return column;
	}
	/**
	 * 获取解放前工作人员补助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJfqgzrybzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jfqgzrybz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("解放前工作人员补助"); 
		return column;
	}
	/**
	 * 获取二等乙基金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEyzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eyzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("二等乙基金支付"); 
		return column;
	}
	/**
	 * 获取工伤基金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGszfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gszf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("工伤基金支付"); 
		return column;
	}
	/**
	 * 获取生育支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirthzfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birthzf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("生育支付"); 
		return column;
	}
	/**
	 * 获取失业支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLosezfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Losezf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("失业支付"); 
		return column;
	}
	/**
	 * 获取卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(40);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡号"); 
		return column;
	}
	/**
	 * 获取卡信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_back_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_back_info");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡信息"); 
		return column;
	}
	/**
	 * 获取登记入参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReg_inputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reg_input");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记入参"); 
		return column;
	}
	/**
	 * 获取登记出参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReg_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reg_back");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记出参"); 
		return column;
	}
	/**
	 * 获取预结算入参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYjs_inputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Yjs_input");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预结算入参"); 
		return column;
	}
	/**
	 * 获取预结算出参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYjs_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Yjs_back");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预结算出参"); 
		return column;
	}
	/**
	 * 获取结算入参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJs_inputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Js_input");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算入参"); 
		return column;
	}
	/**
	 * 获取结算出参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJs_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Js_back");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算出参"); 
		return column;
	}
	/**
	 * 获取退费入参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTf_inputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tf_input");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费入参"); 
		return column;
	}
	/**
	 * 获取退费出参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTf_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tf_back");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费出参"); 
		return column;
	}
	/**
	 * 获取退费时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTf_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tf_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退费时间"); 
		return column;
	}
	/**
	 * 获取子系统标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubsys_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subsys_id");
		column.setLength(4);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("子系统标志"); 
		return column;
	}
	/**
	 * 获取大病理赔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDblpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dblp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("大病理赔"); 
		return column;
	}
	/**
	 * 获取照顾人员补助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZgrybzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zgrybz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("照顾人员补助"); 
		return column;
	}
	/**
	 * 获取起付线表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQfxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qfx");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("起付线"); 
		return column;
	}
	/**
	 * 获取住院次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院次数"); 
		return column;
	}
	/**
	 * 获取起付线剩余表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQfxsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qfxsy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("起付线剩余"); 
		return column;
	}
	/**
	 * 获取包干标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBgbzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bgbz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("包干标准"); 
		return column;
	}
	/**
	 * 获取包干结余表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBgjyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bgjy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("包干结余"); 
		return column;
	}
	/**
	 * 获取全自费金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQzfjeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qzfje");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("全自费金额"); 
		return column;
	}
	/**
	 * 获取慢性病限额剩余表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMxbxesyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mxbxesy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("慢性病限额剩余"); 
		return column;
	}
	/**
	 * 获取基本医疗账户表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJbylzhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jbylzh");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("基本医疗账户"); 
		return column;
	}
	/**
	 * 获取公务员医疗账户表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGwylyzhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gwylyzh");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("公务员医疗账户"); 
		return column;
	}
	/**
	 * 获取符合基本段报销金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJbdbxjeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jbdbxje");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("符合基本段报销金额"); 
		return column;
	}
	/**
	 * 获取符合大病报销金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDbbxjeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dbbxje");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("符合大病报销金额"); 
		return column;
	}
	/**
	 * 获取智能审核疑点信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZnshydxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Znshydxx");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("智能审核疑点信息"); 
		return column;
	}
	/**
	 * 获取drgs付费标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrgs_ffbzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drgs_ffbz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("drgs付费标准"); 
		return column;
	}
	/**
	 * 获取drgs基金标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrgs_jjbzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drgs_jjbz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("drgs基金标准"); 
		return column;
	}
	/**
	 * 获取医疗救助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYljzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Yljz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医疗救助"); 
		return column;
	}
	/**
	 * 获取兜底保障表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDdbzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ddbz");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("兜底保障"); 
		return column;
	}
	/**
	 * 获取报销金额说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBxjesmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bxjesm");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报销金额说明"); 
		return column;
	}
	/**
	 * 获取结算提示信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJsqsxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jsqsxx");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算提示信息"); 
		return column;
	}
	/**
	 * 获取基本医疗统筹支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJbyltczfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jbyltczf");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("基本医疗统筹支付"); 
		return column;
	}
	/**
	 * 获取医院承担表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYycdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Yycd");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医院承担"); 
		return column;
	}
	/**
	 * 获取应收主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proparip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应收主键"); 
		return column;
	}
	/**
	 * 获取结算前医保账户余额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHpacc_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hpacc_before");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("结算前医保账户余额"); 
		return column;
	}
	/**
	 * 获取区县统筹区编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQxtcqbhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qxtcqbh");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("区县统筹区编号"); 
		return column;
	}
	/**
	 * 获取州市统筹区编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZstcqbhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zstcqbh");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("州市统筹区编号"); 
		return column;
	}
	/**
	 * 获取个人编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrbhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grbh");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人编号"); 
		return column;
	}
	/**
	 * 获取人员类别编码(医保身份)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRylbbmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rylbbm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员类别编码(医保身份)"); 
		return column;
	}
	/**
	 * 获取职工居民标志(1:居民,0:职工)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZgjmbzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zgjmbz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职工居民标志(1:居民,0:职工)"); 
		return column;
	}
	/**
	 * 获取医疗类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_medkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_medkind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗类别"); 
		return column;
	}
	/**
	 * 获取确诊疾病编码 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确诊疾病编码 "); 
		return column;
	}
	/**
	 * 获取出院疾病名称 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_name");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院疾病名称 "); 
		return column;
	}
	/**
	 * 获取结算类型(1:正常,2:中途,3:挂失,4:自费)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSt_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"St_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算类型(1:正常,2:中途,3:挂失,4:自费)"); 
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
