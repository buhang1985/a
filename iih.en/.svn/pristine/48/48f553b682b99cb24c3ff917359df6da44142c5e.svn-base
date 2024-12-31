package iih.en.doc.s;

import iih.en.doc.i.IPregDocOutQryService;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.s.bp.preg.qry.GetPregDocBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 产科建档对外查询服务
 * 
 * @author fanlq
 *
 */
@Service(serviceInterfaces={IPregDocOutQryService.class}, binding=Binding.JSONRPC)
public class PregDocOutQryServiceImpl  implements IPregDocOutQryService {

	/**
	 * 根据患者id获取建档信息
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public PregDocDTO getPregDoc(String patId) throws BizException {
		GetPregDocBP getPregDocBP = new GetPregDocBP();
		PregDocDTO result = getPregDocBP.exec(patId);
		return result;
	}
}
