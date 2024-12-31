package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱停止业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderStopBP  extends IOrderConstString{
	/**
	 * 停止医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO stop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
}
