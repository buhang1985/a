package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱拷贝业务逻辑
 * 
 * @author wangqingzhu
 *
 */
public interface IOrderCopyBP extends IOrderConstString {
	/**
	 * 拷贝医嘱
	 * 
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	/**
	 * 医嘱加顿
	 * 
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;

}
