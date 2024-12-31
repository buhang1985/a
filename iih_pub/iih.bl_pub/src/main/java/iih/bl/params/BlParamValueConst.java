package iih.bl.params;

/**
 * 费用域参数值常量
 * 
 * @author ly 2018/03/06
 *
 */
public class BlParamValueConst {

	/**
	 * 按天计（在前优先）
	 */
	public static final String BLCG0001_DAY_BEF = "11";
	/**
	 * 按天计（在后优先）
	 */
	public static final String BLCG0001_DAY_AFT = "12";
	/**
	 * 按天计（价高优先）
	 */
	public static final String BLCG0001_DAY_HIGN = "13";
	/**
	 * 按天计（价低优先）
	 */
	public static final String BLCG0001_DAY_LOW = "14";
	/**
	 * 按秒计
	 */
	public static final String BLCG0001_SECOND = "21";
	
	/*--------------------------------------------------*/
	
	/**
	 * 结算记账
	 */
	public static final String BLCG0002_ST = "1";
	/**
	 * 开立记账
	 */
	public static final String BLCG0002_OPEN = "2";
	/**
	 * 诊间划价
	 */
	public static final String BLCG0002_CLINIC = "3";
	/**
	 * 执行记账
	 */
	public static final String BLCG0002_EXEC = "4";
	
	/**
	 * 住院退记账模式 0:记负账
	 */
	public static final String BLCG0029_NEGATIVE = "0";
	/**
	 * 住院退记账模式  1:红冲原记账数据
	 */
	public static final String BLCG0029_RED = "1";
	
	/*--------------------------------------------------*/
	
	/*--------------------------------------------------*/
	
	/**
	 *  急诊留观费用结账到门诊
	 */
	public static final Integer BLST0002_OP = 1;
	
	/**
	 *  急诊留观费用结账到住院
	 */
	public static final Integer BLST0002_IP = 2;
	
	/*--------------------------------------------------*/
	/**
	 * 收费时价格计价
	 */
	public static final String BLSTOEP0016_WHENCHARGE = "1";
	/**
	 * 开单时价格计价
	 */
	public static final String BLSTOEP0016_WHENORDER = "2";
	
	/**
	 * 按医嘱收费
	 */
	public static final String BLSTOEP0029_OR = "1";
	
	/**
	 * 按医疗单据收费
	 */
	public static final String BLSTOEP0029_BILL = "2";
	
	/*--------------------------------------------------*/
	
	/**
	 * 住院审核与医保审核没有先后关系
	 */
	public static final String BLSTIP0012_NONE = "0";
	/**
	 * 先住院审核，再医保审核
	 */
	public static final String BLSTIP0012_HISFIRST = "1";
	/**
	 * 先医保审核，再住院审核
	 */
	public static final String BLSTIP0012_HPFIRST = "2";
	
	/*--------------------------------------------------*/
	
	/**
	 * 1:结算记账
	 */
	public static final String BLPREPAY0001_CGWHENCHARGE = "1";
	/**
	 * 2:开立记账 
	 */
	public static final String BLPREPAY0001_CGWHENORDER = "2";
	/**
	 * 3:诊间划价
	 */
	public static final String BLPREPAY0001_CGWHENROOM = "3";
	/**
	 * 4:执行记账
	 */
	public static final String BLPREPAY0001_CGWHENMP = "4";
	
	
	/*--------------------------------------------------*/
	
	/**
	 * 收付款启用货币差额处理方式 0:不启用
	 */
	public static final String BLPAY008_DISABLED = "0";
	
	/**
	 * 收付款启用货币差额处理方式(支付) 0:不启用
	 */
	public static final String BLPAY011_DISABLED = "0";
	
	/*--------------------------------------------------*/
	
	/**
	 * 发票分发到个人
	 */
	public static final String BLINC0012_PERSON = "01";
	/**
	 * 发票分发到计算机
	 */
	public static final String BLINC0012_PC = "02";
	
	/*--------------------------------------------------*/
	
	/**
	 * 耗材获取医保对照数据时的对照类型：按照诊疗对照获取
	 */
	public static final String BLHP000024_SRV = "1";
	
	/**
	 * 耗材获取医保对照数据时的对照类型：按照药品对照获取
	 */
	public static final String BLHP000024_MM = "2";
	
	/*--------------------------------------------------*/
	
	/**
	 * 预住院中止住院使用:门诊结算
	 */
	public static final Integer ENIP0302_OP = 0;
	
	/**
	 * 预住院中止住院使用:住院结算
	 */
	public static final Integer ENIP0302_IP = 1;
}
