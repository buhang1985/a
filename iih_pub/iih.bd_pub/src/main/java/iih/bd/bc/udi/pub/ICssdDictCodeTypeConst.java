package iih.bd.bc.udi.pub;

public class ICssdDictCodeTypeConst {
	/**
	 * 生产包状态
	 */
	public static final String ID_STZ_STATUS_BALE = "@@@@Z81000000009UFGF";// 打包
	public static final String SD_STZ_STATUS_BALE = "40";// 40 打包
	public static final String ID_STZ_STATUS_STERILIZATION = "@@@@Z81000000009UFGH";// 消毒灭菌
	public static final String SD_STZ_STATUS_STERILIZATION = "50";// 50 消毒灭菌
	public static final String ID_DFP_STATUS_CLEAN = "@@@@Z81000000009UFGD";// 清洗
	public static final String SD_DFP_STATUS_CLEAN = "30";// 30清洗
	public static final String ID_REL_STATUS_BAS = "@@@@Z81000000009UFGG";//核包
	public static final String SD_REL_STATUS_BAS = "41";// 41核包
	public static final String ID_ISU_STATUS_SEND = "@@@@Z81000000009UFGL";//发放出库
	public static final String SD_ISU_STATUS_SEND = "61";//发放出库
	public static final String ID_REL_STATUS_STO = "@@@@Z81000000009UFGI"; //存储
	public static final String SD_REL_STATUS_STO = "51"; //存储
	public static final String ID_RECY_STATUS_DFP = "@@@@Z81000000009UFGC"; //回收
	public static final String SD_RECY_STATUS_DFP = "20"; //回收

	/**
	 * 消毒包状态
	 * 
	 * 打包
	 */
	public static final String ID_DFP_PKG = "@@@@Z81000000009LGSY";
	public static final String SD_DFP_PKG = "10";

	/**
	 * 灭菌
	 */
	public static final String ID_DFP_SRLZ = "@@@@Z81000000009LGT0";
	public static final String SD_DFP_SRLZ = "20";

	/**
	 * 存储
	 */
	public static final String ID_DFP_STOCK = "@@@@Z81000000009UFG7";
	public static final String SD_DFP_STOCK = "30";
	/**
	 * 发放
	 */
	public static final String ID_DFP_SEND = "@@@@Z81000000009UFG9";
	public static final String SD_DFP_SEND = "40";
	/**
	 * 接收
	 */
	public static final String ID_DFP_RCV = "@@@@Z81000000009UFGA";
	public static final String SD_DFP_RCV = "50";
	/**
	 * 使用
	 */
	public static final String ID_DFP_USE = "@@@@Z81000000009UFGB";
	public static final String SD_DFP_USE = "60";
	/**
	 * 清洗
	 */
	public static final String ID_DFP_CLN = "@@@@Z81000000009UFGC";
	public static final String SD_DFP_CLN = "70";
	/**
	 * 过期
	 */
	public static final String ID_DFP_BEOVD = "@@@@Z8100000000AZ46E";
	public static final String SD_DFP_BEOVD = "90";
	/**
	 * 丢失
	 */
	public static final String ID_DFP_LOST = "@@@@Z8100000000AZ46F";
	public static final String SD_DFP_LOST = "91";
	/**
	 * 报损
	 */
	public static final String ID_DFP_DMG = "@@@@Z8100000003BMVNF";
	public static final String SD_DFP_DMG = "92";

	/**
	 * 消毒包请领状态
	 * 
	 * 新建
	 */
	public static final String ID_APP_NEW = "@@@@Z8100000003B36RF";
	public static final String SD_APP_NEW = "10";

	/**
	 * 提交
	 */
	public static final String ID_APP_SUBMIT = "@@@@Z8100000003B36RG";
	public static final String SD_APP_SUBMIT = "20";

	/**
	 * 驳回
	 */
	public static final String ID_APP_REJECT = "@@@@Z8100000003B36RH";
	public static final String SD_APP_REJECT = "30";

	/**
	 * 拒发
	 */
	public static final String ID_APP_REFUSE = "@@@@Z8100000003C636L";
	public static final String SD_APP_REFUSE = "35";

	/**
	 *发送中
	 */
	public static final String ID_APP_SENDING = "@@@@Z8100000003B69R5";
	public static final String SD_APP_SENDING = "40";

	/**
	 * 发送完成
	 */
	public static final String ID_APP_SEND = "@@@@Z8100000003B36RJ";
	public static final String SD_APP_SEND = "50";

	/**
	 * 接收中
	 */
	public static final String ID_APP_RCVING = "@@@@Z8100000003B36RI";
	public static final String SD_APP_RCVING = "60";

	/**
	 * 接收完成
	 */
	public static final String ID_APP_RCV = "@@@@Z8100000003B36RK";
	public static final String SD_APP_RCV = "70";

	/**
	 * 消毒包过期提醒消息
	 */
	public static final String CSSD_DFP_LOSE_EFFE_WARING = "CssdDfpLoseEffeWarn";

	/**
	 * 消毒包过期提醒消息编码
	 */
	public static final String CSSD_DFP_LOSE_EFFE_CODE = "CssdDfpEffeWaring";

	/**
	 * 一次性耗材包类型
	 */
	public static final String ID_PKG_TP_CNSU = "@@@@Z8100000003B8JUT";
	public static final String SD_PKG_TP_CNSU = "90";
	
	/**
	 * 灭菌方式
	 */
	public static final String ID_DFP_STZ_STY = "@@@@Z81000000009LGSO";
	public static final String SD_DFP_STZ_STY = "01";
	
	
	/**
	 * 灭菌结果
	 */
	public static final String ID_DFP_STZ_RES_QU = "@@@@Z8100000000A3WEH";
	public static final String SD_DFP_STZ_RES_QU = "01";
	
	/**
	 * 灭菌程序
	 */
	public static final String ID_DFP_STZ_PRO = "@@@@Z8100000000AMUUA";
	public static final String SD_DFP_STZ_PRO = "02";
}
