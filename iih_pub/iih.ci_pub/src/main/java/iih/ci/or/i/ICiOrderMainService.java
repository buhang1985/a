package iih.ci.or.i;

import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱操作主接口
 * @author wangqingzhu
 *
 */
public interface ICiOrderMainService  {

	/**
	 * 从医嘱加载医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO load(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 根据给定的医嘱标志状态查询医嘱数据集合
	 * @param ctx
	 * @param sd_srvtp
	 * @param fg_sign
	 * @param fg_canc
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO loadByStatus(CiEnContextDTO ctx, String sd_srvtp, FBoolean fg_sign, FBoolean fg_canc) throws BizException;
	
	/**
	 * 删除医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO delete(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 签署医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO sign(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 撤回医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 根据停止事件小于生效时间，作废给定集合中的医嘱
	 * @param ctx
	 * @param szOrder
	 * @param dt_stop
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel4Stop(CiEnContextDTO ctx,CiOrderDO[] szOrder, FDateTime dt_stop) throws BizException;
	
	/**
	 * 拷贝医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO copy(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 另存为医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveAs(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 备血可用血余量更新
	 * @param ctx
	 * @param ciors
	 * @param flag
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updateApbuWithBtOrNumMargin(CiEnContextDTO ctx, CiOrderDO[] ciors, boolean flag) throws BizException;
	
	/**
	 * 更新停止医嘱状态
	 * @param ctx
	 * @param orders
	 * @param dt_stop
	 * @param dt_now
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updateOrderStopStatus(CiEnContextDTO ctx, CiOrderDO[] orders, FDateTime dt_stop, FDateTime dt_now) throws BizException;
	
	/**
	 * 清除医嘱护士拒绝确认信息
	 * @param ctx
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO clearOrderRefuseCheckInfo(CiEnContextDTO ctx, CiOrderDO[] orders)  throws BizException ;
	
	/**
	 * 更新医嘱的保外诊断
	 * @param ctx
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updateOrdersExtraParoleDiagInfo(CiEnContextDTO ctx, CiOrderDO[] orders) throws BizException;
	
	/**
	 * 更新检查医疗单，申请单 计划时间
	 * @param ctx
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updateOrderRisAppPlanDate(CiEnContextDTO ctx, String id_or, String dt_appointment) throws BizException;
	
	/**
	 * 获取执行闭环类型ID
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getOrderClosedLoopTpIdByParam(OrpltpMatchParamDTO param) throws BizException;
	
	/**
	 * 获取执行闭环类型ID
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getOrderClosedLoopTpIdByOrder(CiOrderDO param) throws BizException;
}
