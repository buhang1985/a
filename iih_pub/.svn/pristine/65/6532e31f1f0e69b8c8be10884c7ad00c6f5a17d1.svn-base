package iih.ci.mi.external.obtain.mi;

import java.util.List;
import java.util.Map;

import iih.ci.mi.srv.i.meta.HpsrvtpQryParamDTO;
import iih.ci.mi.srv.i.meta.HpsrvtpQryRstDTO;
import xap.mw.core.data.BizException;

/**
 * 获取医保数据接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdHpRService {



	/**
	 * 获取医保目录结果<br>
	 * 不在医保目录里的设置为丙类
	 * 
	 * @param hpsrvtpParamList
	 * @return
	 * @throws BizException 
	 */
	public Map<String, HpsrvtpQryRstDTO> getHpsrvtp(String id_hp, List<HpsrvtpQryParamDTO> hpsrvtpParamList)
			throws BizException;
	
	
}
