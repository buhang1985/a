package iih.ci.sdk.order.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱删除业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderDeleteBP {
	/**
	 * 删除医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO delete(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
}