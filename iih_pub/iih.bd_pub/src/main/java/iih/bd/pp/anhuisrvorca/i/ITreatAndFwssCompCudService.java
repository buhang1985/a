package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;

/**
 * 诊疗和服务设施对照服务
 * 
 * @author hao_wu
 *
 */
public interface ITreatAndFwssCompCudService {
	/**
	 * 保存诊疗项目和服务设施对照
	 * 
	 * @param treatCompDTOs
	 *            诊疗项目和服务设施对照信息
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] SaveTreatAndFwssComp(TreatCompDTO[] treatCompDTOs) throws BizException;

	/**
	 * 删除诊疗项目和服务设施对照
	 * 
	 * @param treatCompDtos
	 *            诊疗项目和服务设施对照信息
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] DeleteTreatAndFwssComp(TreatCompDTO[] treatCompDTOs) throws BizException;

	/**
	 * 自动对照
	 * 
	 * @throws BizException
	 */
	public abstract void AutoComp(String hpCode) throws BizException;

	/**
	 * 刷新对照
	 * 
	 * @throws BizException
	 */
	public abstract void RefreshComp(String hpCode) throws BizException;
}
