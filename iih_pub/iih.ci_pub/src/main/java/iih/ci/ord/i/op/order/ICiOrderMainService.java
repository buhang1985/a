package iih.ci.ord.i.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱操作主接口
 * @author wangqingzhu
 *
 */
public interface ICiOrderMainService {
	/**
	 * 读取医嘱内容
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	/**
	 * 删除医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO delete(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 删除作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO deleteCancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 删除撤回医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO deleteRevert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 高端商保退费
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO deleteHBI(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 签署医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 撤回医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 作废复制（撤回）医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancelCopy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 拷贝医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	
	/**
	 * 另存为医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveAs(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	/**
	 * 重新分方
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO recoverPres(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	/**
	 * 医嘱加顿
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;

}