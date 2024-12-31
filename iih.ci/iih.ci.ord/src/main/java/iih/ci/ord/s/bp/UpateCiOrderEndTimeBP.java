package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.dto.d.CiOrdModifyEndTimeDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 
 * @author 修改医嘱的停止时间
 *
 */
public class UpateCiOrderEndTimeBP {
	public CiOrdModifyEndTimeDTO exec(CiOrdModifyEndTimeDTO ciOrdModifyEndTimeDTO){
		IForeignService service=ServiceFinder.find(IForeignService.class);
		try {
			CiOrderDO ord = CiOrdAppUtils.getOrQryService().findById(ciOrdModifyEndTimeDTO.getId_or());
			if(CiOrdUtils.isEmpty(ord)){
				ciOrdModifyEndTimeDTO.setStatus(DOStatus.UNCHANGED);
				return ciOrdModifyEndTimeDTO;
			}
			ord.setDt_end(ciOrdModifyEndTimeDTO.getDt_end());
			ord.setDt_stop(CiOrdAppUtils.getServerDateTime());
			new DAFacade().updateDO(ord, new String[]{CiOrderDO.DT_END,CiOrderDO.DT_STOP});
			//持续类型需要判断
			String id_or = ciOrdModifyEndTimeDTO.getId_or();
			ICiorderMDORService iCiorderMDORService=ServiceFinder.find(ICiorderMDORService.class);
			CiOrderDO ciOrderDO = iCiorderMDORService.findById(id_or);
			String id_freq= ciOrderDO.getId_freq();
			if(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS.equals(id_freq)){
			  //如果修改的停止时间小于或等于当前服务器时间，立即执行；否则，再次创建计划任务
			  if(CiOrdAppUtils.getServerDateTime().compareTo(ciOrdModifyEndTimeDTO.getDt_end())>=0){
			  	service.UpdateOrderStatus(new String[]{ciOrdModifyEndTimeDTO.getId_or()});
			  	ciOrdModifyEndTimeDTO.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
			  	ciOrdModifyEndTimeDTO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
			  }else{
			  	FMap2 variableValueMap = new FMap2();
			  	variableValueMap.put("idor", ord.getId_or());
			  	variableValueMap.put("dtlast", ord.getDt_last_mp().toString());
			  	ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
			  	String taskId =api.submitTask0("CompleteStatus", ord.getDt_end(), variableValueMap);				
			  }
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		ciOrdModifyEndTimeDTO.setStatus(DOStatus.UNCHANGED);
		return ciOrdModifyEndTimeDTO;
	}
}
