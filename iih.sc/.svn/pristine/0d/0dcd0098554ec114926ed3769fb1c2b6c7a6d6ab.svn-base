package iih.sc.scbd.s.ep;

import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import org.apache.commons.lang.ArrayUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班服务Ep
 * @author ccj
 *
 */
public class ScBdSrvEP {
	
	
	/**
	 * 根据医疗服务id 求所对应的 排班服务ids
	 * @param id_srv
	 * @throws BizException
	 */
	public ScBdsrvDO[] getScBdSrvByIdSrv(String[] idSrvs) throws BizException{
		if(ArrayUtils.isEmpty(idSrvs)) return null;
		IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
		String cond = ScSqlUtils.getInSqlByIds(ScBdsrvDO.ID_SRV, idSrvs);
		ScBdsrvDO[] scbdsrvs = iscbdsrvmdorservice.find(cond, null, FBoolean.FALSE);
		return scbdsrvs;
	}
	

}
