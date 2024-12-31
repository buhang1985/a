package iih.pi.reg.s.external.provide;

import iih.pi.reg.dto.d.PiPatBasicInfoDTO;
import iih.pi.reg.i.external.provide.IPiRegMpRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.s.external.provide.bp.FindPatDoByEntCardNoBp;
import xap.mw.core.data.BizException;

/**
 * 患者注册提供给执行域的对外接口实现
 * 
 * @author hao_wu 2018-6-8
 *
 */
public class PiRegMpServiceImpl implements IPiRegMpRService {

	@Override
	public PiPatBasicInfoDTO findPatBasicInfoByEntCardNo(String entCardNo) throws BizException {
		FindPatDoByEntCardNoBp bp = new FindPatDoByEntCardNoBp();
		PiPatBasicInfoDTO patInfo = bp.exec(entCardNo);
		return patInfo;
	}
}
