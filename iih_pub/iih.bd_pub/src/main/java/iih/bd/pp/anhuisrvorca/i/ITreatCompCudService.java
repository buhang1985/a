package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;

/**
 * 医保诊疗对照CUD服务
 * 
 * @author hao_wu
 *
 */
public interface ITreatCompCudService {
	/**
	 * 保存诊疗项目对照
	 * 
	 * @param treatCompDTOs
	 *            诊疗项目对照信息
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] SaveTreatComp(TreatCompDTO[] treatCompDTOs) throws BizException;

	/**
	 * 删除诊疗项目对照
	 * 
	 * @param treatCompDtos
	 *            诊疗项目对照信息
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] DeleteTreatComp(TreatCompDTO[] treatCompDTOs) throws BizException;
	
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
	/**
	 * 设为自费
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract String[] setTreatOwnExpense(TreatCompDTO[] drugCompDTOs) throws BizException;
	/**
	 * 取消自费
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract String[] canCleTreatOwnExpense(TreatCompDTO[] drugCompDTOs) throws BizException;
}
