package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱另存为业务逻辑
 * 
 * @author wangqingzhu
 *
 */
public interface IOrderSaveAsBP extends IOrderConstString {
	/**
	 * 另存为医嘱
	 * 
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveAs(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
}
