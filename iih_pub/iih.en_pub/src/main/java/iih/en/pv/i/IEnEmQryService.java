package iih.en.pv.i;

import iih.en.pv.dto.d.ObservationDTO;
import xap.mw.core.data.BizException;

/**
 * 急诊查询服务
 * @author yank
 * 
 *
 */
public interface IEnEmQryService {
	/**
	 * 获取急诊留观许可证
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	ObservationDTO[] getObsPermit(String patId) throws BizException;
	/**
	 * 获取留观许可
	 * @param entId 就诊id
	 * @return
	 */
	ObservationDTO getObsPermitByEntId(String entId) throws BizException;
}
