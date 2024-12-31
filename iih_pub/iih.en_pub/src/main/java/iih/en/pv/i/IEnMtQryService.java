package iih.en.pv.i;

import iih.en.pv.dto.d.MedTechTransDTO;
import xap.mw.core.data.BizException;

/**
 * 医技查询服务
 * @author yank
 *
 */
public interface IEnMtQryService {
	/**
	 * 获取医技转入申请列表
	 * @param depId 科室ID
	 * @return
	 * @throws BizException
	 */
	MedTechTransDTO[] getTransInApp(String depId) throws BizException;
	/**
	 * 获取医技转出申请列表
	 * @param depId 科室ID
	 * @return
	 * @throws BizException
	 */
	MedTechTransDTO[] getTransOutApp(String depId) throws BizException;
}
