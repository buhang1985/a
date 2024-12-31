package iih.en.pv.i;

import iih.en.pv.dto.d.MedTechTransDTO;
import xap.mw.core.data.BizException;

/**
 * 医技持久化服务
 * @author yank
 *
 */
public interface IEnMtCmdService {
	/**
	 * 医技转入
	 * @param dto 医技转入DTO
	 * @throws BizException
	 */
	void transIn(MedTechTransDTO dto) throws BizException;
	/**
	 * 医技转出
	 * @param dto 医技转入DTO
	 * @throws BizException
	 */
	void transOut(MedTechTransDTO dto) throws BizException;
}
