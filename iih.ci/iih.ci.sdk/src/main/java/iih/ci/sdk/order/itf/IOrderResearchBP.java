package iih.ci.sdk.order.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱科研项目确认业务逻辑
 * @author Young
 *
 */
public interface IOrderResearchBP {

	/**
	 * 医嘱科研
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO research(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
}
