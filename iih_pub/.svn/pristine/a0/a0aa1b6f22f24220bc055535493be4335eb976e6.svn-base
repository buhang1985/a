package iih.en.pv.i;

import iih.en.pv.dto.d.ObservationDTO;
import xap.mw.core.data.BizException;

/**
 * 急诊命令服务
 * @author yank
 *
 */
public interface IEnEmCmdService {
	/**
	 * 开急诊留观许可证
	 * @param obsDTO 留观DTO
	 * @throws BizException
	 */
	void openObsPermit(ObservationDTO obsDTO) throws BizException;
	/**
	 * 取消许可
	 * @param obsDTO 留观DTO
	 * @throws BizException
	 */
	void cancObsPermit(ObservationDTO obsDTO) throws BizException;

	/**
	 * 确认留观许可
	 * @param obsDTO 留观DTO
	 * @throws BizException
	 */
	void cfmObsPermit(ObservationDTO obsDTO) throws BizException;	
}
