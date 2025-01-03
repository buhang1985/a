package iih.bd.bc.udi.pub;

/**
 * 医疗物品管理模块(IIH.MM)相关的基础数据常量定义。
 * @author wu.junhui
 */
public interface IMmDictCodeConst {
	
	// 库存计划类型
    public static final String SD_PLTP = "MM.PL.0505";
   
    // 库存计划状态
    public static final String SD_SU_PL = "MM.PL.0510";
   
    // 采购状态
    public static final String SD_SU_PO = "MM.PO.0515";
   
    // 出入库单状态
    public static final String SD_SU_ST = "MM.ST.0520";
   
    // 出入库项目关联类型
    public static final String SD_STITMRELTp = "MM.ST.0525";
   
    // 出入库关联类型
    public static final String SD_STRELTP = "MM.ST.0530";
   
    // 关联角色
    public static final String SD_RELROLE = "MM.ST.0535";
   
    // 库存盘点类型
    public static final String SD_STTKTP = "MM.ST.0540";
   
    // 库存盘点状态
    public static final String SD_SU_STTK = "MM.ST.0545";
   
    // 库存调价类型
    public static final String SD_STPRITP = "MM.ST.0550";
   
    // 库存调价状态
    public static final String SD_SU_STPRI = "MM.ST.0555";
   
    // 期初记账状态
    public static final String SD_INI = "MM.ST.0560";
   
    // 月结状态
    public static final String SD_MC = "MM.ST.0561";
   
    // 采购发票单状态
    public static final String SD_INV_ST = "MM.ST.0562";
   
    // 调拨申请单状态
    public static final String SD_TRRE_PL = "MM.PL.0565";
   
    // 调拨单状态
    public static final String SD_TR_PL = "MM.PL.0570";
   
    // 领用申请单状态
    public static final String SD_DA_PL = "MM.PL.0575";
    
    // 高值耗材报损单状态
    public static final String SD_DM_ST = "MM.ST.0580";
	
	/**
	 * MM.PL.0510库存计划状态
	 */
	//新建
	public static final String SD_SU_PL_NEW = "0";
	//提交
	public static final String SD_SU_PL_SUBMIT = "1";
	//审批中
	public static final String SD_SU_PL_CONFIRM_ING = "2";
	//审批驳回
	public static final String SD_SU_PL_CONFIRM_REFUSE = "3";
	//审批通过
	public static final String SD_SU_PL_CONFIRM_PASS = "4";
	public static final String ID_SU_PL_CONFIRM_PASS = "@@@@AA1000000001D8DP";
	//订单制单
	public static final String SD_SU_PL_ACCEPT = "5";
	public static final String ID_SU_PL_ACCEPT = "@@@@AA1000000006OE67";
	/**
	 * MM.PO.0515采购状态
	 */
	//新建
	public static final String SD_SU_PO_NEW = "0";
	//提交
	public static final String SD_SU_PO_SUBMIT = "1";
	//审批中
	public static final String SD_SU_PO_CONFIRM_ING = "2";
	//审批驳回
	public static final String SD_SU_PO_CONFIRM_REFUSE = "3";
	//审批通过
	public static final String SD_SU_PO_CONFIRM_PASS = "4";
	//已入库制单
	public static final String SD_SU_PO_ACCEPT = "5";
	public static final String ID_SU_PO_ACCEPT = "@@@@AA1000000006OZ5X";
	//入库完成
	public static final String SD_SU_PO_ACCEPT_COMPLETE = "6";
	public static final String ID_SU_PO_ACCEPT_COMPLETE = "@@@@Z8100000003O9GU1";
	/**
	 * MM.ST.0520出入库单状态
	 */
	//新建
	public static final String SD_SU_ST_NEW = "0";
	//已确认
	public static final String SD_SU_ST_SUBMIT = "1";
	//已退货
	public static final String SD_SU_ST_RETURN = "2";

	/**
	 * MM.ST.0540库存盘点类型
	 */
	//全库盘点
	public static final String SD_STTKTP_All = "0";
	//种类盘点
	public static final String SD_STTKTP_CLASS = "1";
	//其它盘点
	public static final String SD_STTKTP_OTHER = "2";
	
	/**
	 * MM.ST.0545库存盘点状态
	 */
	//新建
	public static final String SD_SU_STTK_NEW = "0";
	//录入完成
	public static final String SD_SU_STTK_ENTCOMP = "1";
	//提交
	public static final String SD_SU_STTK_SUBMIT = "2";
	//审批中
	public static final String SD_SU_STTK_CONFIRM_ING = "3";
	//审核驳回
	public static final String SD_SU_STTK_CONFIRM_REFUSE = "4";
	//盘点完成
	public static final String SD_SU_STTK_CONFIRM_PASS = "5";
	
	/**
	 * MM.ST.0555库存调价状态
	 */
	//新建
	public static final String SD_SU_STPRI_NEW = "0";
	//提交
	public static final String SD_SU_STPRI_SUBMIT = "1";
	//审批中
	public static final String SD_SU_STPRI_CONFIRM_ING = "2";
	//审核驳回
	public static final String SD_SU_STPRI_CONFIRM_REFUSE = "3";
	//审核通过
	public static final String SD_SU_STPRI_CONFIRM_PASS = "4";
	//调价完成
	public static final String SD_SU_STPRI_COMPLETE = "5";
	
	/**
	 * MM.ST.0560期初记账状态
	 */
	//未记账
	public static final String SD_INI_NOTCHARGE = "0";
	//已记账
	public static final String SD_INI_CHARGED = "1";
	
	/**
	 * MM.ST.0561月结状态
	 */
	//未启账
	public static final String SD_MC_NOTOPEN = "0";
	//未月结
	public static final String SD_MC_OPEN = "1";
	//已月结
	public static final String SD_MC_ACCOUNT = "2";
	
	/**
	 * MM.ST.0562发票单状态
	 */
	//新建
	public static final String SD_SU_INV_NEW = "0";
	//提交
	public static final String SD_SU_INV_SUBMIT = "1";
	//审批中
	public static final String SD_SU_INV_CONFIRM_ING = "2";
	//审核驳回
	public static final String SD_SU_INV_CONFIRM_REFUSE = "3";
	//审核通过
	public static final String SD_SU_INV_CONFIRM_PASS = "4";
	
	/**
	 * MM.PL.0565调拨申请单状态
	 */
	//新建
	public static final String SD_SU_TRRE_NEW = "0";
	//提交
	public static final String SD_SU_TRRE_SUBMIT = "1";
	//已制单
	public static final String SD_SU_TRRE_ACCEPT = "2";
	//已出库
	public static final String SD_SU_TRRE_OUT = "3";
	//已回库
	public static final String SD_SU_TRRE_BACK = "4";
	//调拨完成
	public static final String SD_SU_TRRE_ALLOCACOMP = "5";
	
	/**
	 * MM.PL.0570调拨单状态
	 */
	//新建
	public static final String SD_SU_TR_NEW = "0";
	//出库确认
	public static final String SD_SU_TR_CONFOUT = "1";
	//已回库
	public static final String SD_SU_TR_BACK = "2";
	//调拨完成
	public static final String SD_SU_TR_ALLOCACOMP = "3";

	/**
	 * MM.PL.0575领用申请单状态
	 */
	//新建
	public static final String SD_SU_DA_NEW = "0";
	//提交
	public static final String SD_SU_DA_SUBMIT = "1";
	//出库中
	public static final String SD_SU_DA_OUTING = "2";
	//出库完成
	public static final String SD_SU_DA_OUTCOMP = "3";
	
	//药品入库采购价获取来源
	public static final String SD_MM_PURPRICE_SOURCE = "MMDG0001";
	//药品入库采购价获取来源 1 药品基本信息价格
	public static final String SD_MM_PURPRICE_SOURCE_1 = "1";
	//药品入库采购价获取来源 2 供应商协议价
	public static final String SD_MM_PURPRICE_SOURCE_2 = "2";

	// MM.PL.0505 库存交易类型

	/**
	 * 采购入库
	 */
	public static final String SD_STTP_IN_CAIGOU = "11";

	/**
	 * 其他入库
	 */
	public static final String SD_STTP_IN_OTHER = "12";

	/**
	 * 调拨入
	 */
	public static final String SD_STTP_IN_DIAOBO = "13";

	/**
	 * 盘点盈
	 */
	public static final String SD_STTP_IN_PANDIAN = "14";

	/**
	 * 期初入库
	 */
	public static final String SD_STTP_IN_INIT = "31";

	/**
	 * 领用出库
	 */
	public static final String SD_STTP_OUT_LINGYONG = "21";

	/**
	 * 其他出库
	 */
	public static final String SD_STTP_OUT_OTHER = "22";

	/**
	 * 调拨出
	 */
	public static final String SD_STTP_OUT_DIAOBO = "23";

	/**
	 * 发药出库
	 */
	public static final String SD_STTP_OUT_FAYAO = "24";

	/**
	 * 盘点亏
	 */
	public static final String SD_STTP_OUT_PANDIAN = "25";

	/**
	 * 报损出
	 */
	public static final String SD_STTP_OUT_BAOSUN = "26";

	//采购入库是否生成采购发票
	public static final String FG_MM_PURPRICE_GENINVOICE = "MMDG0002";
	
	//调拨单出入库模式
	public static final String SD_MM_TRAN_MODE = "MMDG0003";
	//调拨单出入库模式 1自动出入库
	public static final String SD_MM_TRAN_MODE_1 = "1";
	//调拨单出入库模式 2手动入库
	public static final String SD_MM_TRAN_MODE_2 = "2";
	
	//调拨单出库确认时更新库存模式
	public static final String SD_MM_TRAN_STOCK_MODE = "MMDG0009";
	//调拨单出库确认时更新库存模式 1扣库存模式
	public static final String SD_MM_TRAN_STOCK_MODE_1 = "1";
	//调拨单出库确认时更新库存模式 2扣预留模式
	public static final String SD_MM_TRAN_STOCK_MODE_2 = "2";
	
	//最低储值计算依据天数
	public static final String SD_MM_LOW_STOCK_NUM = "MMDG0004";
	//最高储值计算依据天数
	public static final String SD_MM_HIGH_STOCK_NUM = "MMDG0005";
	
	//药品效期预警天数
	public static final String MM_DATEEXPI_INVALID_INT = "MMDG0006";
	//药品滞销预警天数
	public static final String MM_UNUSABLE_INT = "MMDG0007";
	//医嘱开立是否返回药品最高价格
	public static final String FG_MM_ORDER_HIGHPRICE = "MMDG0010";
	//采购入库选择物品参照后是否弹窗显示历史入库信息
	public static final String MM_IN_HISTORY_MSG = "MMDG0011";
	//采购入库弹窗显示物品历史入库信息的时间范围
	public static final String MM_IN_HISTORY_DAY = "MMDG0012";
	
	// 采购发票模式
	public static final String SD_MM_PURINV_MODE = "MMDG0013";
	// 采购发票模式 1:入库单主表模式
	public static final String SD_MM_PURINV_MODE_1 = "1";
	// 采购发票模式 2:入库单子表模式
	public static final String SD_MM_PURINV_MODE_2 = "2";
	
	//药品入库时批次是否区分大小写
    public static final String FG_MM_BATCH_CASESENSITIVE = "MMDG0015";
    
    //系统上线日期
    public static final String System_Online_Date = "MMDG0016";
    
    //盘点明细排序方式
    public static final String SD_MM_ST_CHECKSORT = "MMDG0110";
    //按货位编码排序
    public static final String SD_MM_ST_CHECKSORT_0 = "0";
    //按货位名称拼音码排序
    public static final String SD_MM_ST_CHECKSORT_1 = "1";
    //按药品编码排序
    public static final String SD_MM_ST_CHECKSORT_2 = "2";
    
    //0库存是否自动停发
    public static final String FG_AUTO_STOP_ZERO = "MMDG0018";
    
    //是否支持零差价自动调价
    public static final String FG_AUTO_ZERO_STPRI = "MMDG0020";
	
	//门诊、住院、毒麻药品入出存查询节点，是否显示发药状态异常的数据
	public static final String MM_QUERY_DISP_STATE = "MMQY0001";
	
	//采购计划是否校验供应商为空
	public static final String MM_PL_CHECK_SUP = "MMPL0001";
	/**
	 * MM.ST.0580高值报损单状态
	 */
    // 新建   
    public static final String SD_DM_ST_NEW = "0";
    // 提交
    public static final String SD_DM_ST_SUBMIT = "1";
    // 审批完成
    public static final String SD_DM_ST_CHKCOMP = "2";
    // 审批驳回
    public static final String SD_DM_ST_CHKREJ = "3";
    // 出库完成
    public static final String SD_DM_ST_OUTCOMP = "4";
    
    //高值耗材设备科一级库ID
  	public static final String MC_ST_HVWHID = "MCHV0001";
  	
  	//门诊预留保留天数
  	public static final String Reserve_keep_Days_OP = "MMBL0001";
  	
  	//住院预留保留天数
  	public static final String Reserve_keep_Days_IP = "MMBL0002";
  	
  	//未使用药品库存信息自动关闭期限天数
	public static final String Stockbl_close_Days = "MMBL0003";
	
  	//结存信息是否用新模式更新
	public static final String Stockbl_update_mode = "MMBL0004";

  	//药房统计销量包含的出库类型
	public static final String SD_MM_PL_QUAN = "MMDG0120";
	//药房统计发药量包含的出库类型
	public static final String SD_MM_PL_DISP = "MMDG0121";
	//药库统计销量时包含的出入库类型
	public static final String SD_MM_PL_STATISTICSYKTP = "MMDG0122";
	//仓库统计消耗的方式   0-按药库自身统计  1-按药房汇总
	public static final String SD_MM_PL_STATISTICSTP = "MMDG0123";
	public static final String SD_MM_PL_STATISTICSTP_0 = "0";
	public static final String SD_MM_PL_STATISTICSTP_1 = "1";
	//采购入库中，固定价格模式下需要入库单价等于零售价的物品类型。
	public static final String SD_MM_PURINV_PRIEQUAL_MMTP = "MMDG0030";
}
