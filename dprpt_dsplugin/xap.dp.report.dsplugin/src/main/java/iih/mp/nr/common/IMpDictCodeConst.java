package iih.mp.nr.common;

public interface IMpDictCodeConst {

	/**
	 * 频次
	 */
	public static final String SD_FREQ_AWAYS = "always";// 持续医嘱
	public static final String ID_FREQ_AWAYS = "@@@@AA1000000006AEHV";// 持续医嘱

	/**
	 * 进口药
	 */
	public static final String SD_ABRD = "1";//进口药
	public static final String ID_ABRD = "@@@@AA1000000000ELOI";//进口药
	
	/**
	 * 就诊类型编码
	 */
	public static final String SD_CODE_ENTP_OP = "00";// 门诊
	public static final String SD_CODE_ENTP_ET = "01";// 急诊
    public static final String SD_CODE_ENTP_ET_FLOW = "0101";//急诊流水
    public static final String SD_CODE_ENTP_ET_FSTAID = "0102"; //急诊抢救
    public static final String SD_CODE_ENTP_ET_OBS = "0103";//急诊留观
	public static final String SD_CODE_ENTP_PE = "02";// 体检
	public static final String SD_CODE_ENTP_IP = "10";// 住院
	public static final String SD_CODE_ENTP_FA = "20";// 家庭病床
	public static final String SD_CODE_ENTP_ES = "30";// 出留观标识
}
