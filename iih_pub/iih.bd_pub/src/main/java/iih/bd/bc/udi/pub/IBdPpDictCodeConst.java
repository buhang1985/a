package iih.bd.bc.udi.pub;

/**
 * 基础数据_费用域_字典编码常量定义
 * 
 * @author hao_wu
 *
 */
public interface IBdPpDictCodeConst {

	/**
	 * 费用模板类型_住院床位费用
	 */
	public static final String SD_BLTPLTP_HOSPITALIZEDBEDCOST = "01";
	/**
	 * 费用模板类型_其他
	 */
	public static final String SD_BTPLTP_OTHER = "99";
	/**
	 * 社会保险机构
	 */
	public static final String SD_PAYMENT_ORG = "000100";

	/**
	 * 付款方式类型_现金
	 */
	public static final String SD_PMTP_CASH = "00";

	/**
	 * 付款方式类型_支票
	 */
	public static final String SD_PMTP_CHECK = "01";

	/**
	 * 付款方式类型_汇款存款
	 */
	public static final String SD_PMTP_REMITTANCEDEPOSIT = "02";

	/**
	 * 付款方式类型_内部转账
	 */
	public static final String SD_PMTP_INTERNALTRANSFER = "03";

	/**
	 * 付款方式类型_单位记账
	 */
	public static final String SD_PMTP_UNITACCOUNTING = "04";

	/**
	 * 付款方式类型_账户金
	 */
	public static final String SD_PMTP_ACCOUNT = "05";

	/**
	 * 付款方式类型_统筹金
	 */
	public static final String SD_PMTP_SOCIALPOOLING = "06";

	/**
	 * 付款方式类型_银行卡
	 */
	public static final String SD_PMTP_BANKCARD = "07";

	/**
	 * 付款方式类型_其他
	 */
	public static final String SD_PMTP_OTHER = "08";

	/**
	 * 医保患者来源_跨省医保
	 */
	public static final String SD_HPPATSOURCE_tp = "01";

	/**
	 * 医保患者来源_省内异地
	 */
	public static final String SD_HPPATSOURCE_dp = "02";

	/**
	 * 医保患者来源_省内本地
	 */
	public static final String SD_HPPATSOURCE_lp = "03";

	/**
	 * 住院核算体系
	 */
	public static final String ID_ACCOUNT_ZY = "@@@@Z8100000000820L8";

	/**
	 * 门诊核算体系
	 */
	public static final String ID_ACCOUNT_MZ = "@@@@Z8100000000820L6";
	/**
	 * 共有核算体系
	 */
	public static final String ID_ACCOUNT_GY = "@@@@Z8100000000820L5";

	/**
	 * 01 门诊收费 收款
	 */
	public static final String SD_PRIPMSCENE_OPFEE = "01";
	/**
	 * 02 收门诊预交金 收款
	 */
	public static final String SD_PRIPMSCENE_OPPREPAY = "02";
	/**
	 * 03 收退门诊预交金 收款
	 */
	public static final String SD_PRIPMSCENE_RECEIVERETREATOPPREPAY = "03";
	/**
	 * 04 住院收付款 收款
	 */
	public static final String SD_PRIPMSCENE_IPRECEIVERETREAT = "04";
	/**
	 * 05 收住院预交金 收款
	 */
	public static final String SD_PRIPMSCENE_IPPREPAY = "05";
	/**
	 * 06 收退住院预交金 收款
	 */
	public static final String SD_PRIPMSCENE_RECEIVERETREATIPPREPAY = "06";
	/**
	 * 07 门诊个检收费 收款
	 */
	public static final String SD_PRIPMSCENE_OPCHECKFEE = "07";
	/**
	 * 08 门诊团检收费 收款
	 */
	public static final String SD_PRIPMSCENE_OPGROUPCHECKFEE = "08";
	/**
	 * 09 住院团检收费 收款
	 */
	public static final String SD_PRIPMSCENE_IPGROUPCHECKFEE = "09";
	/**
	 * 10 入院登记时收预交金
	 */
	public static final String SD_PRIPMSCENE_IPREGPREPAY = "10";
	/**
	 * 11 门诊挂号
	 */
	public static final String SD_PRIPMSCENE_PATREGISTER = "11";
	/**
	 * 12 患者注册收预交金
	 */
	public static final String SD_PRIPMSCENE_PATREGPRE = "12";
	/**
	 * 13 诊间结算
	 */
	public static final String SD_PRIPMSCENE_OPFEEROOM = "13";
	/**
	 * 14 便民工作站
	 */
	public static final String SD_PRIPMSCENE_OPSINGLEPRE = "14";

	/**
	 * 普通(禁止使用)<br/>
	 * 系统预置价格分类
	 */
	public static final String CODE_PRI_PAT_NORMAL = "999";

	/**
	 * 普通(禁止使用)<br/>
	 * 系统预置价格分类
	 */
	public static final String ID_PRI_PAT_NORMAL = "@@@@Z8100000002YL8PO";
}
