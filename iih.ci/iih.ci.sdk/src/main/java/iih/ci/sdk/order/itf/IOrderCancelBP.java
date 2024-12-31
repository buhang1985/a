package iih.ci.sdk.order.itf;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱作废业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderCancelBP {
	/**
	 * 作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	public abstract OrderRstDTO cancel(CiEnContextDTO ctx, CiOrderDO[] szOrder, FDateTime dt_stop) throws BizException;
}
