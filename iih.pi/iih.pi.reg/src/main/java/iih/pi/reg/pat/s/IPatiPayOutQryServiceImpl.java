package iih.pi.reg.pat.s;

import iih.pi.reg.d.PiSpclPatAmtDTO;
import iih.pi.reg.pat.i.IPatiPayOutQryService;
import iih.pi.reg.pat.s.bp.GetPatCardAmtBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * @author dj.zhang
 *
 */
@Service(serviceInterfaces = { IPatiPayOutQryService.class }, binding = Binding.JSONRPC)
public class IPatiPayOutQryServiceImpl implements IPatiPayOutQryService {

	/**
	 * 查询患者卡交费押金
	 * 
	 * @param patcardIds
	 * @param euCardCgMod
	 * @return
	 * @throws BizException
	 */
	@Override
	public PiSpclPatAmtDTO[] getPatCardAmt(String[] patcardIds, String euCardCgMod) throws BizException {

		GetPatCardAmtBp GetPatCardAmtBp = new GetPatCardAmtBp();
		PiSpclPatAmtDTO[] result = GetPatCardAmtBp.exec(patcardIds, euCardCgMod);
		return result;
	}
}
