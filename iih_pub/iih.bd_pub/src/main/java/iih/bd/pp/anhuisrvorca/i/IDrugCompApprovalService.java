package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保_药品对照审核服务
 * 
 * @author hao_wu
 *
 */
public interface IDrugCompApprovalService {
	/**
	 * 审核通过
	 * 
	 * @param drugCompDTOs
	 *            药品对照列表
	 * @return
	 */
	public abstract DrugCompDTO[] Approval(DrugCompDTO[] drugCompDTOs) throws BizException;

	/**
	 * 审核驳回
	 * 
	 * @param drugCompDTOs
	 *            药品对照列表
	 * @return
	 */
	public abstract DrugCompDTO[] Reject(DrugCompDTO[] drugCompDTOs) throws BizException;
	
	/**
	 * 过期
	 * 
	 * @param treatCompDtos
	 *            药品对照列表
	 * @return
	 */
	public abstract DrugCompDTO[] Expired(DrugCompDTO[] drugCompDTOs) throws BizException;
}
