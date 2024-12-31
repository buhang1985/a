package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.EuDrawTickMod;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.scapt.d.ScAptOpDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 退号接口
 * @author yank
 *
 */
public class CancOpReg4BlBP {
	/**
	 * 退号
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException{
		EnValidator.validateParam("就诊ID", entId);
		
		IScAptOutQryService aptQryService = ServiceFinder.find(IScAptOutQryService.class);
		ScAptOpDO aptOpDO = aptQryService.getAptOpByEntId(entId);
		String aptId = null;
		if(aptOpDO!=null){
			aptId = aptOpDO.getId_apt();
		}
		
		CancOpRegBP cancRegBP = new CancOpRegBP();
		cancRegBP.exec(entId, aptId, EuDrawTickMod.DRAWBACK, IBlDictCodeConst.SD_PTTP_WINDOW);
	}
}
