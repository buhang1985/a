package iih.bd.mhi.hpdrugdircomp.i;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import xap.mw.core.data.BizException;

/**
 * 医保平台_药品对照数据维护服务
 *
 * @author hexx
 */
public interface IHpdrugdircompExtCudService {

	/**
	 * 保存药品对照
	 * 
	 * @param hpdrugdirCompDTOs
	 * @throws BizException
	 */
	public abstract HpDrugDirCompDTO[] saveHpDrugComp(String hpId, HpDrugDirCompDTO[] hpdrugdirCompDTOs)
			throws BizException;

	/**
	 * 药品自动对照
	 * 
	 * 
	 * @throws BizException
	 */
	public void autoComp(String hpId) throws BizException;

	/**
	 * 药品删除对照
	 *
	 * 
	 * @throws BizException
	 */
	HpDrugDirCompDTO[] deleteHpDrugComp(String HpId, HpDrugDirCompDTO[] hpdrugdirCompDTOs) throws BizException;

}
