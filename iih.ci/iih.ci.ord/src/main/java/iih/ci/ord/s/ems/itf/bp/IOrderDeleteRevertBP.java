package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱删除撤回业务逻辑
 * @author Young
 *
 */
public interface IOrderDeleteRevertBP extends IOrderConstString {
	/**
	 * 删除撤回医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO deleterevert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
}
