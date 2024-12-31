package iih.pi.reg.i;

/**
 * 患者卡类型
 * 
 * @author hao_wu 2018-5-31
 *
 */
public interface PatCardTp {
	/**
	 * 身份证号码
	 */
	public final String CODE_IDTYPE_IDCARD = "01";
	/**
	 * 医保号
	 */
	public final String CODE_IDTYPE_HPNO = "02";
	/**
	 * CHIS条码号
	 */
	public final String CODE_IDTYPE_BARCODE_CHIS = "03";
	/**
	 * 患者编码
	 */
	public final String CODE_IDTYPE_CODE = "04";
	/**
	 * 其他卡
	 */
	public final String CODE_CARDTP_CODE = "05";
}
