package iih.ci.ord.printmanage.srv;

/**
 * 常量定义
 * @author Young
 *
 */
public interface ICiorderPrintConst {
	/**
	 * 临床医生站打印单据类型_自定义档案 编码		
	 */
	public static final String SD_CIPRNSHEETTP_OR="01";   //01 医嘱相关打印
	
	public static final String SD_CIPRNSHEETTP_PRES="0101";   //0101 处方
	public static final String SD_CIPRNSHEETTP_PRES_POIS="010101";   //010101 毒麻处方
	public static final String SD_CIPRNSHEETTP_PRES_WEST="010102";   //010102 西药处方
	public static final String SD_CIPRNSHEETTP_PRES_HERB="010103";   //010103 草药处方
	
	public static final String SD_CIPRNSHEETTP_APP="0102";   //0102 申请单
	public static final String SD_CIPRNSHEETTP_APP_RIS="010201";   //010201检查申请单
	public static final String SD_CIPRNSHEETTP_APP_LIS="010202";   //010202检验 申请单
	public static final String SD_CIPRNSHEETTP_APP_TREAT="010203"; //010203诊疗 申请单
	public static final String SD_CIPRNSHEETTP_APP_BT="010204";   //010204输血 申请单
	public static final String SD_CIPRNSHEETTP_APP_BTUSE="010205";   //010205取血 申请单
	public static final String SD_CIPRNSHEETTP_APP_OP="010206";   //010206手术 申请单
	
	public static final String SD_CIPRNSHEETTP_AUXI="0103";   //0103 辅助执行
	public static final String SD_CIPRNSHEETTP_AUXI_INJECT="010301";   //010301 注射治疗单
	public static final String SD_CIPRNSHEETTP_AUXI_TREATE="010302";   //010302 门诊费用清单
	
	public static final String SD_CIPRNSHEETTP_WORKMR="02";   //02 临床医生工作文书
	
	public static final String SD_CIPRNSHEETTP_MR="0201";   //0201 病历
	public static final String SD_CIPRNSHEETTP_MR_OP="020101";   //020101 门诊病历
	
	/**
	 * 医嘱诊疗执行申请类型_自定义档案 编码
	 */
	public static final String SD_ORTREATEAPPEXECTP_INJECT="01";   //01 注射
	public static final String SD_ORTREATEAPPEXECTP_TREAT="02";   //02 诊疗

	public static final String BLSTATE_UNPAID = "0";//未结算
	public static final String BLSTATE_PAID = "1";//已结算
	public static final String BLSTATE_ALL = "2";//全部
	
//	public static final String SD_CIPRNSHEETTP_COST="01";   //01 费用类别
//	public static final String SD_CIPRNSHEETTP_CIORSRVCOST="0101";   //0101 门诊费用清单
	
	/**
	 * 服务类型 编码
	 */
	public static final String SD_SRVTP_DRUG = "01"; // 药品
	public static final String SD_SRVTP_HERBDRUG = "0103"; // 草药
	public static final String SD_SRVTP_RIS = "02"; // 检查
	public static final String SD_SRVTP_OP = "04"; // 手术
	public static final String SD_SRVTP_TREAT = "05"; // 治疗
	public static final String SD_SRVTP_TREAT_SKINMINGANTEST = "0506"; // 治疗--->皮肤敏感性试验
	public static final String SD_SRVTP_SANI = "07"; // 卫材
	public static final String SD_SRVTP_DIAGTREAT_OP_CONCROSS = "0902"; // 会诊与跨科
	public static final String SD_SRVTP_BLOODPROD_PREPARE = "140101"; // 备血
	public static final String SD_SRVTP_BLOODPROD_USE = "140102"; // 用血
	
	/**
	 * 医嘱单签字模式
	 */
    public static final String PARAM_POSSIGNMODE_ALLPAGE_AUTO = "01";//整页手签（系统生成干系人信息）
    public static final String PARAM_POSSIGNMODE_ALLPAGE_MANU = "02";//整页手签（护士人工确认干系人）
    public static final String PARAM_POSSIGNMODE_EVERY_AUTO = "11";//逐条手签（系统批量处理相同干系人信息）
    public static final String PARAM_POSSIGNMODE_EVERY_MANU = "12";//逐条手签（系统不处理）
    public static final String PARAM_POSSIGNMODE_ELEC = "21";//电子签章

}
