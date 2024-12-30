package iih.sc.scbd.s.bp;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.d.SchedulesrvAggDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取诊疗类型
 * @author yank
 *
 */
public class GetSrvTpBP {
	/**
	 * 获取诊疗类型
	 * @param scSrvId 排班服务id
	 * @return
	 * @throws BizException
	 */
	public String exec(String scSrvId) throws BizException{
		String srvId = null;
		//1、获取关联的主医疗服务
		ISchedulesrvRService scSrvService = ServiceFinder.find(ISchedulesrvRService.class);
		SchedulesrvAggDO scsrvAggDO = scSrvService.findById(scSrvId);
		if(scsrvAggDO!=null){
			ScheduleSrvRelDO[] srvRelDOArray = (ScheduleSrvRelDO[]) scsrvAggDO.getChildren(ScheduleSrvRelDO.class);
			if(!ArrayUtil.isEmpty(srvRelDOArray)){
				for(ScheduleSrvRelDO relDO : srvRelDOArray){
					if(relDO.getFg_maj().equals(FBoolean.TRUE)){
						//如果为主服务,则返回
						srvId =  relDO.getId_mdsrv();
						break;
					}
				}
			}
		}
		//2、获取医疗服务类型
		if(!StringUtils.isEmpty(srvId)){
			IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO srvDO = srvService.findById(srvId);
			if(srvDO!=null){
				return srvDO.getSd_srvtp();
			}
		}
		
		
		return null;
	}
}
