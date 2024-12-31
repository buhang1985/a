package iih.pi.reg.s;

import xap.mw.core.data.BizException;
import iih.pi.reg.dto.ws.PatBasicInfoBean;
import iih.pi.reg.dto.ws.PatCreateRtnBean;
import iih.pi.reg.i.IPiPatCreateService;
import iih.pi.reg.s.customer.guoji.PiPatCreateWSBP;
import iih.pi.reg.s.ws.PatCreateWSBP;

/**
 * 患者建档webservice
 * @author ly 2017/08/10
 *
 */
public class PiPatCreateServiceImpl implements IPiPatCreateService{

	/**
	 * 患者建档
	 * @param patInfo 患者信息xml
	 * @return xml
	 * @throws BizException
	 */
	@Override
	public String createPat2(String patInfo) throws BizException {
		PiPatCreateWSBP bp = new PiPatCreateWSBP();
		return bp.exec(patInfo);
	}
	
	/**
	 * 患者建档
	 * @param patInfo 患者信息
	 * @return 建档信息
	 * @throws BizException
	 */
	@Override
	public PatCreateRtnBean createPat(PatBasicInfoBean patInfo) throws BizException{
		PatCreateWSBP bp = new PatCreateWSBP();
		return bp.exec(patInfo);
	}
}
