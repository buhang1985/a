package iih.en.comm.ep;

import iih.en.comm.util.EnAppUtils;
import iih.en.pv.enres.d.EnPlcDO;
import iih.en.pv.enres.i.IEnplcCudService;
import iih.en.pv.enres.i.IEnplcRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊地点EP
 * @author yankan
 *
 */
public class EntPlcEP {
	/**
	 * 结束当前地点
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public void endPlc(String entId) throws BizException{
		//更新旧地点
		IEnplcRService retrieveService = ServiceFinder.find(IEnplcRService.class);
		IEnplcCudService cudService = ServiceFinder.find(IEnplcCudService.class);
		String whereStr = String.format("id_ent=%s AND dt_e=null", entId);
		EnPlcDO[] oriDOs = retrieveService.find(whereStr,"",FBoolean.FALSE);
		if(oriDOs!=null){
			EnPlcDO oriDO = oriDOs[0];
			FDateTime curTime = EnAppUtils.getServerDateTime();
			oriDO.setDt_e(curTime);//结束日期为当期时间
			cudService.save(new EnPlcDO[]{(oriDO)});			
		}
	}
	/**
	 * 更新地点
	 * @param plcDO 地点
	 * @throws BizException 
	 */
	public void changePlc(EnPlcDO plcDO) throws BizException{
		this.endPlc(plcDO.getId_ent());
		
		//新增地点	
		IEnplcCudService cudService = ServiceFinder.find(IEnplcCudService.class);
		cudService.insert(new EnPlcDO[]{plcDO});		
	}
}
