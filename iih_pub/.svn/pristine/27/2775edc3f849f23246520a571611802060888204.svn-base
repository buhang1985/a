package iih.pi.reg.i;

import iih.pi.reg.dto.ws.PatBasicInfoBean;
import iih.pi.reg.dto.ws.PatCreateRtnBean;
import xap.mw.core.data.BizException;

/**
 * 患者建档webservice
 * @author ly 2017/08/10
 *
 */
public interface IPiPatCreateService {

	/**
	 * 患者建档
	 * @param patInfo 患者信息
	 * @return 建档信息
	 * @throws BizException
	 */
	public abstract PatCreateRtnBean createPat(PatBasicInfoBean patInfo) throws BizException;
	
	/**
	 * 患者建档
	 * @param patInfo 患者信息xml
	 * @return xml
	 * @throws BizException
	 */
	public abstract String createPat2(String patInfo) throws BizException;
}
