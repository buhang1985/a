package iih.ci.ord.i.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 住院医生站主服务接口
 * @author wangqingzhu
 *
 */
public interface ICiIpOrderMainService {

	/**
	 * 从医嘱加载医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO load(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
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
	 * 取消作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revertcancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 停止医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO stop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 取消停止医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revertstop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 医嘱科研项目确认
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO reserchconfirm(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	/**
	 * 医嘱加顿
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
}
