package iih.bd.bc.udi.pub;

public interface IBdBcDictCodeConst {

	/**
	 * 标本采集时间类型ID BD.BC.0600
	 */
	public static final String ID_SAMPCOLLECTTIMETP_SSHJZ = "@@@@AA1000000006DXVS"; // 01
																					// 随时或急诊
	public static final String ID_SAMPCOLLECTTIMETP_SS = "@@@@Z7100000000MKV0O"; // 0101
																					// 随时
	public static final String ID_SAMPCOLLECTTIMETP_JZ = "@@@@Z7100000000MKV0P"; // 0102
																					// 急诊
	public static final String ID_SAMPCOLLECTTIMETP_ZDSJ = "@@@@AA1000000006DXV0"; // 02
																					// 指定时间
	public static final String ID_SAMPCOLLECTTIMETP_ZRSJ = "@@@@AA1000000006DXV3"; // 0201
																					// 自然时间
	public static final String ID_SAMPCOLLECTTIMETP_YC = "@@@@AA1000000006DXV4"; // 0202
																					// 用餐
	public static final String ID_SAMPCOLLECTTIMETP_FY = "@@@@AA1000000006DXV5"; // 0203
																					// 服药
	public static final String ID_SAMPCOLLECTTIMETP_JQ = "@@@@AA1000000006DXV6"; // 0204
																					// 就寝
	public static final String ID_SAMPCOLLECTTIMETP_PB = "@@@@AA1000000006DXV7"; // 0205
																					// 排便
	public static final String ID_SAMPCOLLECTTIMETP_QCKF = "@@@@AA1000000006DXV1"; // 03
																					// 清晨空腹

	/**
	 * 标本采集时间类型编码 BD.BC.0600
	 */
	public static final String SD_SAMPCOLLECTTIMETP_SSHJZ = "01"; // 01 随时或急诊
	public static final String SD_SAMPCOLLECTTIMETP_SS = "0101"; // 0101 随时
	public static final String SD_SAMPCOLLECTTIMETP_JZ = "0102"; // 0102 急诊
	public static final String SD_SAMPCOLLECTTIMETP_ZDSJ = "02"; // 02 指定时间
	public static final String SD_SAMPCOLLECTTIMETP_ZRSJ = "0201"; // 0201 自然时间
	public static final String SD_SAMPCOLLECTTIMETP_YC = "0202"; // 0202 用餐
	public static final String SD_SAMPCOLLECTTIMETP_FY = "0203"; // 0203 服药
	public static final String SD_SAMPCOLLECTTIMETP_JQ = "0204"; // 0204 就寝
	public static final String SD_SAMPCOLLECTTIMETP_PB = "0205"; // 0205 排便
	public static final String SD_SAMPCOLLECTTIMETP_QCKF = "03"; // 03 清晨空腹

	/**
	 * 服务体系
	 */
	public static final String SD_CDSYSTP_SER = "0";
	/**
	 * 诊断体系
	 */
	public static final String SD_CDSYSTP_DIAG = "1";
	/**
	 * 西医诊断体系
	 */
	public static final String SD_CDSYSTP_DIAG_XIYI = "11";
	/**
	 * 中医诊断体系
	 */
	public static final String SD_CDSYSTP_DIAG_ZHONGYI = "12";
	/**
	 * 蒙医诊断体系
	 */
	public static final String SD_CDSYSTP_DIAG_MENGYI = "13";
	/**
	 * 手术诊断体系
	 */
	public static final String SD_CDSYSTP_DIAG_SHOUSHU = "14";
}
