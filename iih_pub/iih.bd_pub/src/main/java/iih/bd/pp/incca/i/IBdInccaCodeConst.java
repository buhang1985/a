package iih.bd.pp.incca.i;

/**
 * 票据分类系统编码
 * @author 
 * @since 2015-08-26
 *
 */
public interface IBdInccaCodeConst {
	/**
	 * 票据类型编码
	 */
    public static final String CODE_OUTPATIENT_INVOICE = "11"; //门诊发票
    public static final String CODE_INHOS_INVOICE = "12"; //住院发票
    public static final String CODE_OUTPATREGIST_INVOICE = "13";//门诊挂号发票
    public static final String CODE_OUTPATIENT_DEPOSIT = "21"; //门诊押金条
    public static final String CODE_INHOS_DEPOSIT = "22"; //住院押金条
    public static final String CODE_DESIGNED_FUND = "23"; //优惠套餐收费收据
    public static final String CODE_PREINHOS_PREPAY = "24"; //预住院预交金
    public static final String CODE_ET_INVOICE = "25"; // 急诊留观押金条
    
	/**
	 * 票据类型ID
	 */
    public static final String ID_OUTPATIENT_INVOICE = "@@@@AA1000000001SHRD"; //门诊发票
    public static final String ID_INHOS_INVOICE = "@@@@AA1000000001SHRE"; //住院发票
    public static final String ID_OUTPATREGIST_INVOICE = "@@@@AA1000000001SHRN";//门诊挂号发票
    public static final String ID_OUTPATIENT_DEPOSIT = "@@@@AA1000000001SHRF"; //门诊押金条
    public static final String ID_INHOS_DEPOSIT = "@@@@AA1000000001SHRG"; //住院押金条
    public static final String ID_DESIGNED_FUND = "@@@@AA1000000007H9P0"; //优惠套餐收据
    public static final String ID_PREINHOS_PREPAY = "@@@@AA100000000622B5"; //预住院预交金
    public static final String ID_ET_INVOICE = "@@@@AA1000000001SHRM";// 急诊留观押金条
}
