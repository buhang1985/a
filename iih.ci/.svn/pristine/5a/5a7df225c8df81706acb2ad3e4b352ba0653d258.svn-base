package iih.ci.sdk.order.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 医嘱签署业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderSignBP {
	/**
	 * 签署医嘱 v1.0 版本
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO sign(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 医嘱签署业务逻辑 v1.2版本
	 * @param ctx
	 * @param szId_ors
	 * @param extension
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO sign(CiEnContextDTO ctx, String[] szId_ors, FMap2 extension) throws BizException;
}
