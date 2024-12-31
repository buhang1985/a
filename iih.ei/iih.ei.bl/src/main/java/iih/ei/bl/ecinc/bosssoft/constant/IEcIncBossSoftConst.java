package iih.ei.bl.ecinc.bosssoft.constant;

/**
 * 博思电子发票常量
 * @author ly
 *
 */
public interface IEcIncBossSoftConst {

	/**
	 * 版本
	 */
	public static final String VERSION = "1.0";
	
	/**
	 * 调用成功编码
	 */
	public static final String SUCCESS_CODE = "S0000";
	
	
	/*****************调用方法常量********************/
	/**
	 * 门诊电子票据开具
	 */
	public static final String METHOD_INVOICEEBILLOUTPATIENT = "invoiceEBillOutpatient";
	
	/**
	 * 住院电子票据开具
	 */
	public static final String METHOD_INVEBILLHOSPITALIZED = "invEBillHospitalized";
	
	/**
	 * 挂号电子发票开具
	 */
	public static final String METHOD_INVEBILLREGISTRATION ="invEBillRegistration";
	
	/**
	 * 体检电子发票开具
	 */
	public static final String METHOD_INVEBILLCHECKUP = "invEBillCheckUp";
	
	
	/**
	 * 电子票据冲红
	 */
	public static final String METHOD_WRITEOFFEBILL = "writeOffEBill";
	
	/**
	 * 获取当前纸质票据可用号码
	 */
	public static final String METHOD_GETPAPERBILLNO = "getPaperBillNo";
	
	/**
	 * 换开纸质票据
	 */
	public static final String METHOD_TURNPAPER = "turnPaper";
	
	/**
	 * 重新换开纸质票据
	 */
	public static final String METHOD_RETURNPAPER = "reTurnPaper";
	
	/**
	 * 作废换开的纸质票据接口
	 */
	public static final String METHOD_INVALIDPAPER = "invalidPaper";
	
	/**
	 * 获取纸质票据有效票据代码列表接口
	 */
	public static final String METHOD_GETVALIDBILLBATCHCODE = "getValidBillBatchCode";
	
	/**
	 * 总笔数核对接口
	 */
	public static final String METHOD_CHECKTOTALDATACODE = "checkTotalData";
	
	/**
	 * 退费数据核对接口
	 */
	public static final String METHOD_CHECKWRITEOFFDATACODE = "checkWriteOffData ";
	
	/**
	 * 根据业务时间获取开票信息接口
	 */
	public static final String METHOD_GETBILLBYBUSDATECODE = "getBillByBusDate";
	
	/**
	 * 门诊电子票据开具名称
	 */
	public static final String METHOD_INVOICEEBILLOUTPATIENT_NAME = "门诊电子票据开具";
	
	/**
	 * 住院电子票据开具名称
	 */
	public static final String METHOD_INVEBILLHOSPITALIZED_NAME = "住院电子票据开具";
	
	/**
	 * 挂号电子发票开具名称
	 */
	public static final String METHOD_INVEBILLREGISTRATION_NAME ="挂号电子发票开具";
	
	/**
	 * 体检电子发票开具
	 */
	public static final String METHOD_INVEBILLCHECKUP_NAME = "体检电子发票开具";
	
	/**
	 * 电子票据冲红
	 */
	public static final String METHOD_WRITEOFFEBILL_NAME = "电子票据冲红";
	
	/**
	 * 获取当前纸质票据可用号码
	 */
	public static final String METHOD_GETPAPERBILLNO_NAME = "获取当前纸质票据可用号码";
	
	/**
	 * 换开纸质票据
	 */
	public static final String METHOD_TURNPAPER_NAME = "换开纸质票据";
	
	/**
	 * 重新换开纸质票据
	 */
	public static final String METHOD_RETURNPAPER_NAME = "重新换开纸质票据";
	
	/**
	 * 作废换开的纸质票据接口
	 */
	public static final String METHOD_INVALIDPAPER_NAME = "作废换开的纸质票据接口";
	
	/**
	 * 获取纸质票据有效票据代码列表接口
	 */
	public static final String METHOD_GETVALIDBILLBATCHCODE_NAME = "获取纸质票据有效票据代码列表接口";
	
	/**
	 * 总笔数核对接口
	 */
	public static final String METHOD_CHECKTOTALDATANAME = "总笔数核对接口";
	
	/**
	 * 退费数据核对接口
	 */
	public static final String METHOD_CHECKWRITEOFFDATANAME = "退费数据核对接口 ";
	
	/**
	 * 根据业务时间获取开票信息接口
	 */
	public static final String METHOD_GETBILLBYBUSDATENAME = "根据业务时间获取开票信息接口";
	/*****************调用方法常量END********************/
	
}
