package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保_服务设施对照审核服务
 * 
 * @author hao_wu
 *
 */
public interface IFwssCompApprovalService {
	/**
	 * 审核通过
	 * 
	 * @param fwssCompDTOs
	 *            服务设施对照列表
	 * @return
	 */
	public abstract FwssCompDTO[] Approval(FwssCompDTO[] fwssCompDTOs) throws BizException;

	/**
	 * 审核驳回
	 * 
	 * @param fwssCompDTOs
	 *            服务设施对照列表
	 * @return
	 */
	public abstract FwssCompDTO[] Reject(FwssCompDTO[] fwssCompDTOs) throws BizException;
	
	/**
	 * 过期
	 * 
	 * @param fwssCompDTOs
	 *            服务设施对照列表
	 * @return
	 */
	public abstract FwssCompDTO[] Expired(FwssCompDTO[] fwssCompDTOs) throws BizException;
}
