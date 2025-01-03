package iih.bl.comm;

import xap.mw.coreitf.d.FDouble;

/**
 * 费用域业务常量
 * 
 * @author ly
 *
 */
public interface IBlConst {
	
	/**
	 * -1
	 */
	public static FDouble NEGATIVE_ONE_DBL = new FDouble(-1.0D);
	
	// 门诊费用导出所用 业务编码 01
	public static final String BUSINESSACT_NODE_NAME = "门诊费用导出";
	public static final String BUSINESS_NODE_CODE = "01";

	// 精度
	public static final Integer PRECISION_AMOUNT = 2;// 金额精度
	public static final Integer PRECISION_PRICE = 4;// 单价精度
	public static final Integer PRECISION_QUANTITY = 2;// 数量精度

	public static final String ALL_PATTERN = "*";// 所有

	public static final String DEFAULT_WINDOWNO = "99";// 默认发药窗口号

	/**
	 * 费用状态
	 * */
	public static final String FEE_BL_TYPE_CODE_LR = "1";// 编码
	public static final String FEE_BL_TYPE_NAME_LR = "录入";// 名称

	public static final String FEE_BL_TYPE__CODESZ = "2";// 编码
	public static final String FEE_BL_TYPE__NAME_SZ = "上帐";// 名称

	public static final String FEE_BL_TYPE_CODE_JS = "3";// 编码
	public static final String FEE_BL_TYPE_NAME_JS = "结算";// 名称

	public static final String FEE_BL_TYPE_CODE_SF = "4";// 编码
	public static final String FEE_BL_TYPE_NAME_SF = "收费";// 名称

	public static final String FEE_BL_TYPE_CODE_YS = "5";// 编码
	public static final String FEE_BL_TYPE_NAME_YS = "应收";// 名称

	public static final String FEE_BL_TYPE_CODE_DP = "6";// 编码
	public static final String FEE_BL_TYPE_NAME_DP = "打票";// 名称

	public static final String FEE_BL_TYPE_CODE_CZ = "7";// 编码
	public static final String FEE_BL_TYPE_NAME_CZ = "冲账";// 名称

	// 收退费
	public static final int BL_CHARGES = 1;// 收费
	public static final int BL_REFUND = -1;// 退费

	// 医保诊断删除依赖性校验类型
	public static final String BL_DE_DEP = "01";// 适应症依赖
	public static final String BL_DE_SPEC = "02";// 特殊病依赖
	public static final String BL_DE_SUPMED = "03";// 超量开药依赖

	// 重打原因 重打预交金使用
	public static final String SD_RES_REPRINT_NOTNORMAL = "01";// 未正常打印
	public static final String SD_RES_REPRINT_BAD = "02";// 打印污损
	public static final String SD_RES_REPRINT_LOST = "03";// 原收据丢失

	// 支付分类（商保上传接口使用）
	public static final String PAY_TYPE_OEP_YB = "OEP_YB";// 门诊医保
	public static final String PAY_TYPE_OEP_ZF = "OEP_ZF";// 门诊自费
	public static final String PAY_TYPE_IP_YB = "IP_YB";// 住院医保
	public static final String PAY_TYPE_IP_ZF = "IP_ZF";// 住院自费

	/**
	 * 备注常量
	 */
	public static final String NOTE_CANCELSETTLEMENT = "取消结算";
	public static final String NOTE_CANCELTRADE = "取消出纳";
	public static final String NOTE_CHARGECARDDEPOSIT = "收取卡押金";
	public static final String NOTE_REFUNDCARDDEPOSIT = "退还卡押金";
	public static final String NOTE_CHARGECARDDEPOSIT_VSSPCLPAT = "收取卡押金,对应专用款%s";
	public static final String NOTE_REFUNDCARDDEPOSIT_TRANSFER = "退卡押金转入";
	public static final String NOTE_CANCELTRADERESTORE = "取消出纳退还押金";
	public static final String NOTE_IPSTREVERSE = "住院结算冲预交金 ";
	public static final String NOTE_PREPAYVOID = "作废:票据号%s";
	public static final String NOTE_PREPAYREFUND = "已退费";
	public static final String NOTE_PREPAYABOLISH = "已作废";
	
	
	// 预交金控制策略类型0不控制，1警告提醒，2部分控制，3完全控制
	public static final String ACC_PREWARN_NONE = "0";
	public static final String ACC_PREWARN_LIMIT = "1";
	public static final String ACC_PREWARN_PCONTROL = "2";
	public static final String ACC_PREWARN_FCONTROL = "3";
	// 策略控制角色类型0个人，1团检中个人，2团检单位
	public static final String ACC_PATTP_PAT = "0";
	public static final String ACC_PATTP_PECMPYPAT = "1";
	public static final String ACC_PATTP_PECMPY = "2";
	
	// 预交金账户类型--门诊账户
	public static final String PREPAY_OPACC="1";
	// 预交金账户类型--住院账户
	public static final String PREPAY_IPACC="2";
	// 预交金账户类型--团检账户
	public static final String PREPAY_PEACC="3";
	// 预交金账户类型--留观账户
	public static final String PREPAY_ETACC = "4";
	/**
	 * 费用审核日志审核活动
	 */
	//住院审核通过
	public static final String IP_AUDIT_PASS="10";
	//住院审核取消
	public static final String IP_AUDIT_CANCEL="11";
	//医保审核通过
	public static final String INSUR_AUDIT_PASS="20";
	//医保审核取消
	public static final String INSUR_AUDIT_CANCEL="21";
}
