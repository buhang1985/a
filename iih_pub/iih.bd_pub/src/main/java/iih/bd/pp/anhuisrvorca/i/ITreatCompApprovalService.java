package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保_诊疗对照审核服务
 * 
 * @author hao_wu
 *
 */
public interface ITreatCompApprovalService {
	/**
	 * 审核通过
	 * 
	 * @param treatCompDtos
	 *            诊疗对照列表
	 * @return
	 */
	public abstract TreatCompDTO[] Approval(TreatCompDTO[] treatCompDtos) throws BizException;

	/**
	 * 审核驳回
	 * 
	 * @param treatCompDtos
	 *            诊疗对照列表
	 * @return
	 */
	public abstract TreatCompDTO[] Reject(TreatCompDTO[] treatCompDtos) throws BizException;

	/**
	 * 过期
	 * 
	 * @param treatCompDtos
	 *            诊疗对照列表
	 * @return
	 */
	public abstract TreatCompDTO[] Expired(TreatCompDTO[] treatCompDtos) throws BizException;
}
