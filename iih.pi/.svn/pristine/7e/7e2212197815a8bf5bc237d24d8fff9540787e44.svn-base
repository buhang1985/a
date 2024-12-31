package iih.pi.reg.s.customer.guoji.util;

import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * chis患者分类转换工具类
 * @author ly 2017-11-06
 *
 */
public class PiPatCaChangeForChisUtil {

	/**
	 * chis患者分类转换
	 * @param patcaId
	 * @return
	 * @throws BizException
	 */
	public static String getChisPatCaCode(String patcaId) throws BizException{
		if(StringUtil.isEmpty(patcaId))
			return null;
		
		DAFacade daf = new DAFacade();
		PiPatCaDO caDo = (PiPatCaDO)daf.findByPK(PiPatCaDO.class, patcaId);
		if(caDo == null)
			return null;
		
		return caDo.getCode_chis();
	}
}
