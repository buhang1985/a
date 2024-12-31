package iih.ems.common.udi;

public class EmsUdiConst {
	/**
	 * 设备交易分类采购入库id
	 */
	public static final String EMSTCA_CGRK = "1001Z81000000031P849";
	/**
	 * 设备交易分类采购入库编码
	 */
	public static final String EMSTCA_CGRK_SD = "1101"; 
	
	 // 出入库单状态
    public static final String SD_SU_IN = "EMS.EINV.1505";
	
	/**
	 * EMS.EINV.1505出入库单状态
	 */
	//新建
	public static final String SD_SU_IN_NEW = "0";
	//已确认
	public static final String SD_SU_IN_SUBMIT = "1";
	//审核通过
	public static final String SD_SU_IN_CONFIRM_PASS = "2";
	//审核驳回
	public static final String SD_SU_IN_CONFIRM_REFUSE = "3";
	//作废
	public static final String SD_SU_IN_OVER ="9";
	
	// 领用申请
    public static final String DA_UDI_CODE = "EMS.EINV.1540";
	
	/**
	 * EMS.EINV.1540领用申请单状态
	 */
	//新建
	public static final String SD_SU_DA_NEW = "0";
	//已确认
	public static final String SD_SU_DA_SUBMIT = "1";
	//审核通过
	public static final String SD_SU_DA_CONFIRM_PASS = "2";
	//审核驳回
	public static final String SD_SU_DA_CONFIRM_REFUSE = "3";

	// 领用出库
    public static final String OUT_UDI_CODE = "EMS.EINV.1510";
	
	/**
	 * EMS.EINV.1510领用出库单状态
	 */
	//新建
	public static final String SD_SU_OUT_NEW = "0";
	//已确认
	public static final String SD_SU_OUT_SUBMIT = "1";
	//审核通过
	public static final String SD_SU_OUT_CONFIRM_PASS = "2";
	//审核驳回
	public static final String SD_SU_OUT_CONFIRM_REFUSE = "3";
	
	// 入库类型
    public static final String ST_UDI_CODE = "EMS.EMBD.0505";
	/**
	 * 采购入库
	 */
	public static final String SD_STTP_IN_CAIGOU = "1101";

	/**
	 * 其他入库
	 */
	public static final String SD_STTP_IN_OTHER = "1201";
	
	/**
	 * 领用出库
	 */
	public static final String SD_STTP_OUT_GET = "2101";
	
	
	
	/**
	 * 资产状态
	 */
	public static final String CARD_UDI_CODE = "EMS.EASS.2050";
	
	public static final String ID_CARD_ST_RK = "@@@@Z8100000003FYENC";
	public static final String ID_CARD_ST_ZK = "@@@@Z8100000003FYEND";
	public static final String ID_CARD_ST_ZY = "@@@@Z8100000003FYENE";
	public static final String ID_CARD_ST_DX = "@@@@Z8100000003FYENF";
	public static final String ID_CARD_ST_ZX = "@@@@Z8100000003FYENG";
	public static final String ID_CARD_ST_BY = "@@@@Z8100000003FYENH";
	public static final String ID_CARD_ST_XZ = "@@@@Z8100000003FYENI";
	public static final String ID_CARD_ST_TJ = "@@@@Z8100000003FYENJ";
	public static final String ID_CARD_ST_DBF = "@@@@Z8100000003FYENK";
	public static final String ID_CARD_ST_BF = "@@@@Z8100000003FYENL";
	public static final String ID_CARD_ST_YTH = "@@@@Z8100000003JTNR0";
	
	
	public static final String SD_CARD_ST_RK = "0";//入库生成
	public static final String SD_CARD_ST_ZK = "1";//在库
	public static final String SD_CARD_ST_ZY = "2";//在用
	public static final String SD_CARD_ST_DX = "3";//待修
	public static final String SD_CARD_ST_ZX = "4";//在修
	public static final String SD_CARD_ST_BY = "5";//备用
	public static final String SD_CARD_ST_XZ = "6";//闲置
	public static final String SD_CARD_ST_TJ = "7";//调剂
	public static final String SD_CARD_ST_DBF = "8";//待报废
	public static final String SD_CARD_ST_BF = "9";//报废
	public static final String SD_CARD_ST_YTH = "99";//已退货
	
	
	/**
	 * 资产建卡状态
	 */
	public static final String CARD_CREAT_UDI_CODE = "EMS.EASS.2010";

	public static final String ID_BUILD_CARD_XJ = "@@@@Z8100000003FYEN9";
	public static final String ID_BUILD_CARD_TJ = "@@@@Z8100000003FYENA";
	public static final String ID_BUILD_CARD_SH = "@@@@Z8100000003FYENB";
	
	public static final String SD_BUILD_CARD_XJ = "0";
	public static final String SD_BUILD_CARD_TJ = "1";
	public static final String SD_BUILD_CARD_SH = "2";
	
	/**
	 * 资产卡片录入方式
	 */
	
	public static final String CARD_ENTER_UDI_CODE = "EMS.EASS.2060";
	
	public static final String ID_ENTER_CARD_RK = "@@@@Z8100000003FZIQE";//入库录入
	public static final String ID_ENTER_CARD_DJ = "@@@@Z8100000003FZIQF";//卡片登记录入
	public static final String ID_ENTER_CARD_DR = "@@@@Z8100000003FZIQG";//数据导入
	
	public static final String SD_ENTER_CARD_RK = "0";//入库录入
	public static final String SD_ENTER_CARD_DJ = "1";//卡片登记录入
	public static final String SD_ENTER_CARD_DR = "2";//数据导入
	
	 // 报废管理
    public static final String SCRAP_SU_IN = "EMS.EASS.2020";
	
	/**
	 * EMS.EINV.1505出入库单状态
	 */
	//新建
	public static final String SCRAP_SU_IN_NEW = "0";
	//已确认
	public static final String SCRAP_SU_IN_SUBMIT = "1";
	//审核通过
	public static final String SCRAP_SU_IN_CONFIRM_PASS = "2";
	//审核驳回
	public static final String SCRAP_SU_IN_CONFIRM_REFUSE = "3";
	//作废
	public static final String SCRAP_SU_IN_OVER ="4";
	// MM.PL.0505 库存交易类型
	
	 // 卡片录入方式
    public static final String CARD_ENTER_TP = "EMS.EASS.2060";
	
    //入库方式建卡
  	public static final String ID_CARD_ENTER_RK = "@@@@Z8100000003FZIQE";
    //登记方式建卡
  	public static final String ID_CARD_ENTER_DG = "@@@@Z8100000003FZIQF";
    //导入方式建卡
  	public static final String ID_CARD_ENTER_DR = "@@@@Z8100000003FZIQG";
  	
  	 //入库方式建卡
  	public static final String SD_CARD_ENTER_RK = "0";
    //登记方式建卡
  	public static final String SD_CARD_ENTER_DG = "1";
    //导入方式建卡
  	public static final String SD_CARD_ENTER_DR = "2";
  	
  	
  	 // 卡片入账审核状态
    public static final String CARD_INACC_STU = "EMS.EASS.2080";
	
    //申请
  	public static final String ID_CARD_INACC_SQ = "@@@@Z8100000003JT7EO";
    //提交
  	public static final String ID_CARD_INACC_TJ = "@@@@Z8100000003JT7EP";
    //审核
  	public static final String ID_CARD_INACC_SH = "@@@@Z8100000003JT7EQ";
  	
    //申请
  	public static final String SD_CARD_INACC_SQ = "0";
  	 //提交
  	public static final String SD_CARD_INACC_TJ = "1";
    //审核
  	public static final String SD_CARD_INACC_SH = "2";
	
	 // 报废管理
    public static final String ADJ_SU_IN = "EMS.EASS.2075";
	
	/**
	 * EMS.EASS.2075价值变更单状态
	 */
	//新建
	public static final String ADJ_SU_IN_NEW = "0";
	//已确认
	public static final String ADJ_SU_IN_SUBMIT = "1";
	//审核通过
	public static final String ADJ_SU_IN_CONFIRM_PASS = "2";
	//审核驳回
	public static final String ADJ_SU_IN_CONFIRM_REFUSE = "3";
	//作废
	public static final String ADJ_SU_IN_OVER ="9";
	
    //保管变更
     public static final String SH_SU_IN = "EMS.EASS.2015";
	
	/**
	 * EMS.EASS.2015保管变更单状态
	 */
	//新建
	public static final String SH_SU_IN_NEW = "0";
	//已确认
	public static final String SH_SU_IN_SUBMIT = "1";
	//审核通过
	public static final String SH_SU_IN_CONFIRM_PASS = "2";
	//审核驳回
	public static final String SH_SU_IN_CONFIRM_REFUSE = "3";
	//作废
	public static final String SH_SU_IN_OVER ="9";
    
	 //计量检测
    public static final String GE_SU_IN = "EMS.EMCM.2515";
	
	/**
	 * EMS.EMCM.2515计量检测单状态
	 */
	//新建
	public static final String GE_SU_IN_NEW = "0";
	//已确认
	public static final String GE_SU_IN_SUBMIT = "1";
	
	 //设备维修
    public static final String REP_SU_IN = "EMS.EMCM.2510";
	
	/**
	 * EMS.EMCM.2510计量检测单状态
	 */
	//新建
	public static final String REP_SU_IN_NEW = "0";
	//已确认
	public static final String REP_SU_IN_SUBMIT = "1";
	
	 //保养
    public static final String UP_SU_IN = "EMS.EMCM.2505";
	
	/**
	 * EMS.EMCM.2505保养单状态
	 */
	//新建
	public static final String UP_SU_IN_NEW = "0";
	//已确认
	public static final String UP_SU_IN_SUBMIT = "1";
	//作废
	public static final String UP_SU_IN_OVER ="9";
}
