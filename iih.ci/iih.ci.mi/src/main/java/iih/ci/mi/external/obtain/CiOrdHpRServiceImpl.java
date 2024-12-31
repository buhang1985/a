package iih.ci.mi.external.obtain;

import java.util.List;
import java.util.Map;

import iih.ci.mi.external.obtain.mi.HpsrvtpQryBP;
import iih.ci.mi.srv.i.meta.HpsrvtpQryParamDTO;
import iih.ci.mi.srv.i.meta.HpsrvtpQryRstDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 获取医保数据接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdHpRService.class }, binding = Binding.JSONRPC)
public class CiOrdHpRServiceImpl implements ICiOrdHpRService {

	

	/**
	 * 获取医保目录
	 * @throws BizException 
	 */
	@Override
	public Map<String, HpsrvtpQryRstDTO> getHpsrvtp(String id_hp, List<HpsrvtpQryParamDTO> hpsrvtpParamList) throws BizException {

		HpsrvtpQryBP bp = new HpsrvtpQryBP();
		return bp.getHpsrvtpRstMap(id_hp,hpsrvtpParamList);
	}
	
	
}