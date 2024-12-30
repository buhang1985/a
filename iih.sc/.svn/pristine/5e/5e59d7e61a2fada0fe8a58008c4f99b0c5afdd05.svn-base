package iih.sc.scbd.s.ep;

import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班服务Ep
 * @author ccj
 *
 */
public class SrvEp {
	
	
	/**
	 * 根据医疗服务id 求所对应的 排班服务ids
	 * @param id_srv
	 * @throws BizException
	 */
	public String getScSrvIdsByBdSrv(String id_srv) throws BizException{
		if(StringUtils.isEmpty(id_srv)) return null;
		IScheduleSrvRelDORService srvRelDORService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		ScheduleSrvRelDO[] srvRelDOs = srvRelDORService.findByAttrValString(ScheduleSrvRelDO.ID_MDSRV, id_srv);
		if(ArrayUtils.isEmpty(srvRelDOs)) return null;
		StringBuffer sb = new StringBuffer();
		for (ScheduleSrvRelDO scheduleSrvRelDO : srvRelDOs) {
			sb.append("'");
			sb.append(scheduleSrvRelDO.getId_scsrv());
			sb.append("',");
		}
		return sb.substring(0, sb.length()-1);
	}
	

}
