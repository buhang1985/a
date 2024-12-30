package iih.sc.scbd.s.bp;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.primd.i.IPriCalService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.d.SchedulesrvAggDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 根据服务code查服务子DO
 * @author renying
 *
 */
public class GetSchSrvRelBP {
	/**
	 * 根据服务code查服务子DO
	 * @param srvCode
	 * @return
	 * @throws BizException 
	 */
	public ScheduleSrvRelDO[] exec(String srvCode) throws BizException{
		ISchedulesrvRService rService = ServiceFinder.find(ISchedulesrvRService.class);
		SchedulesrvAggDO[] aggDOs = rService.find("code ='"+srvCode+"'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aggDOs)){
			throw new BizException("未检索到"+srvCode+"对应的服务");
		}
		if(ArrayUtil.isEmpty(aggDOs[0].getScheduleSrvRelDO())){
			throw new BizException("未检索到"+srvCode+"对应的子服务");
		}
		ScheduleSrvRelDO[] srvRelDOs = aggDOs[0].getScheduleSrvRelDO();
		for(ScheduleSrvRelDO srvRelDO : srvRelDOs){
			if(!StringUtils.isNullOrEmpty(srvRelDO.getId_mdsrv())){
				IPriCalService priCalService = ServiceFinder.find(IPriCalService.class);
				srvRelDO.setPri_mdsrv(priCalService.CalSingleSrvStdPrice(srvRelDO.getId_mdsrv()));
			}
		}
		return  srvRelDOs;
	}
}
