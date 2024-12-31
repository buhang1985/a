package iih.pi.reg.pat.s.bp;

import iih.bl.pay.dto.blspclpatamt.d.BlSpclPatAmtDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.pi.reg.d.PiSpclPatAmtDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author dj.zhang
 *
 */
public class GetPatCardAmtBp {

	public PiSpclPatAmtDTO[] exec(String[] patcardIds, String euCardCgMod) throws BizException {
		IBlPayOutQryService iBlPayOutQryService = ServiceFinder.find(IBlPayOutQryService.class);
		BlSpclPatAmtDTO[] patCardAmt = iBlPayOutQryService.getPatCardAmt(patcardIds, euCardCgMod);
		PiSpclPatAmtDTO[] result = adaptor(patCardAmt);
		return result;
	}

	private PiSpclPatAmtDTO[] adaptor(BlSpclPatAmtDTO[] patCardAmt) {
		if(patCardAmt != null) {
			PiSpclPatAmtDTO[] patAmtDTOs = new PiSpclPatAmtDTO[patCardAmt.length];
			for (int i = 0; i < patCardAmt.length; i++) {
				PiSpclPatAmtDTO piSpclPatAmtDTO = new PiSpclPatAmtDTO();
				piSpclPatAmtDTO.setAmt(patCardAmt[0].getAmt());
				piSpclPatAmtDTO.setFg_pay(patCardAmt[0].getFg_pay());
				piSpclPatAmtDTO.setId_src(patCardAmt[0].getId_src());
				patAmtDTOs[i] = piSpclPatAmtDTO;
			}
			return patAmtDTOs;
		}
		return null;
	}

}
