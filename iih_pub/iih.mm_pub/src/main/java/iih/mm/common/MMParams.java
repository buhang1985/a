package iih.mm.common;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class MMParams {
	
	public static final Double MISTAKE_BL_QUAN = 0.01;
	
	/**
	 * 药品入库采购价获取来源
	 * 1 药品基本信息价格; 2 供应商协议价
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0001() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PURPRICE_SOURCE);
	}
	
	/**
	 * 药品采购入库时是否生成采购发票
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMDG0002() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.FG_MM_PURPRICE_GENINVOICE);
	}
	
	/**
	 * 调拨单出入库模式
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0003() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_TRAN_MODE);
	}
	
	/**
	 * 最低储值计算依据天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0004() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_LOW_STOCK_NUM);
	}
	
	/**
	 * 最高储值计算依据天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0005() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_HIGH_STOCK_NUM);
	}
	
	/**
	 * 药品效期预警天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0006() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.MM_DATEEXPI_INVALID_INT);
	}
	
	/**
	 * 药品滞销预警天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0007() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.MM_UNUSABLE_INT);
	}
	
	/**
	 * 调拨单出库确认时更新库存模式
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0009() throws BizException {
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_TRAN_STOCK_MODE);
	}
	
	/**
	 * 调拨单出库确认时更新库存模式
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMDG0010() throws BizException {
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.FG_MM_ORDER_HIGHPRICE);
	}
	
	/**
	 * 采购入库选择物品参照后是否弹窗显示历史入库信息
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMDG0011() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.MM_IN_HISTORY_MSG);
	}
	
	/**
	 * 采购入库弹窗显示物品历史入库信息的时间范围
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0012() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.MM_IN_HISTORY_DAY);
	}
	
	/**
	 * 采购发票模式
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0013() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PURINV_MODE);
	}
	
	/**
	 * 药品入库时批次是否区分大小写
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMDG0015() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.FG_MM_BATCH_CASESENSITIVE);
	}
	
	/**
	 * 系统上线日期
	 * @return
	 * @throws BizException
	 */
	public static String MMDG0016() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.System_Online_Date);
	}
	
	/**
	 * 0库存是否自动停发
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMDG0018() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.FG_AUTO_STOP_ZERO);
	}
	
	/**
	 * 是否支持零差价自动调价
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMDG0020() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.FG_AUTO_ZERO_STPRI);
	}
	
	/**
	 * 门诊、住院、毒麻药品入出存查询节点，是否显示发药状态异常的数据
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMQY0001() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.MM_QUERY_DISP_STATE);
	}
	
	/**
	 * 采购计划是否校验供应商为空
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMPL0001() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.MM_PL_CHECK_SUP);
	}
	
	/**
	 * 门诊预留保留天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMBL0001() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.Reserve_keep_Days_OP);
	}
	
	/**
	 *  住院预留保留天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMBL0002() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.Reserve_keep_Days_IP);
	}
	
	/**
	 *  未使用药品库存信息自动关闭期限天数
	 * @return
	 * @throws BizException
	 */
	public static Integer MMBL0003() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.Stockbl_close_Days);
	}
	
	/**
	 *  结存信息是否用新模式更新
	 * @return
	 * @throws BizException
	 */
	public static FBoolean MMBL0004() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IMmDictCodeConst.Stockbl_update_mode);
	}
	
	/**
	 * 盘点明细排序方式
	 * @return
	 * @throws BizException
	 */
	public static Integer MMDG0110() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_ST_CHECKSORT);
	}
	
	/**
	 * 药房统计销量包含的出库类型（补货用)，默认24,21
	 * @return
	 * @throws BizException
	 */
	public static String MMDG0120() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PL_QUAN);
	}
	
	/**
	 * 药品统计出库包含的出库类型（补货用)，默认24-发药出库
	 * @return
	 * @throws BizException
	 */
	public static String MMDG0121() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PL_DISP);
	}
	
	/**
	 * 药库统计销量包含的出入库类型（补货用)，默认21，23,13
	 * @return
	 * @throws BizException
	 */
	public static String MMDG0122() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PL_STATISTICSYKTP);
	}
	
	/**
	 * 药库统计消耗方式（补货用) 0-按药库自身统计  1-按药房汇总
	 * @return
	 * @throws BizException
	 */
	public static String MMDG0123() throws BizException {
		
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PL_STATISTICSTP);
	}
	
	/**
	 * 采购入库中，固定价格模式下需要入库单价等于零售价的物品类型。
	 * @return
	 * @throws BizException
	 */
	public static String MMDG0030() throws BizException {
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PURINV_PRIEQUAL_MMTP);
	}
}
