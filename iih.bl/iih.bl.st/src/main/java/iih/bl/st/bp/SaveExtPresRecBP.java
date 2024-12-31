package iih.bl.st.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.hp.blputexrxpres.d.BlPutExRxPresDO;
import iih.bl.hp.blputexrxpres.i.IBlputexrxpresCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存外配处方上传记录
 * @author 
 *
 */
public class SaveExtPresRecBP {
	/**
	 * 保存外配处方上传记录
	 * @param exRxPresArray 外配处方集合
	 * @throws BizException
	 * @author 
	 */
	public void exec(BlPutExRxPresDO[] exRxPresArray) throws BizException{
		//1、参数校验
		if(exRxPresArray!=null&&exRxPresArray.length!=0){

			ICiorderCudService iCiOrderMainService = ServiceFinder.find(ICiorderCudService.class);
			ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
			ArrayList<CiOrderDO> orderList=new ArrayList<CiOrderDO>();
			ArrayList<String> idors=new ArrayList<String>();
			ArrayList<String> idsrv=new ArrayList<String>();
			for (BlPutExRxPresDO blPutExRxPresDO : exRxPresArray) {
			//设置上传时间
			blPutExRxPresDO.setDt_put(new FDateTime());
			
			idors.add(blPutExRxPresDO.getId_or());
			idsrv.add(blPutExRxPresDO.getId_orsrv());
			}
			
			//查询要更新数据
			CiorderAggDO[] updateDos= iCiorderRService.findByAttrValStrings(CiOrderDO.ID_OR, idors.toArray(new String[idors.size()]));

			//更改医嘱及服务状态,若服务状态未全部完成,则不修改医嘱状态
			//TODO 该过程应该调用接口
			for (CiorderAggDO ciOrderDO : updateDos) {
				boolean execParent=true;
				for(OrdSrvDO orsrv:ciOrderDO.getOrdSrvDO()){
					if(idsrv.indexOf(orsrv.getId_orsrv())!=-1||ICiDictCodeConst.SD_SU_MP_FINISH.equals(orsrv.getSd_su_mp())){
						orsrv.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
						orsrv.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
						orsrv.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
						orsrv.setId_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
						orsrv.setStatus(DOStatus.UPDATED);
					}
					else{
						execParent=false;
					}
				}
				if(execParent){
					ciOrderDO.getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
					ciOrderDO.getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
					ciOrderDO.getParentDO().setSd_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
					ciOrderDO.getParentDO().setId_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
					ciOrderDO.getParentDO().setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
					ciOrderDO.getParentDO().setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
					ciOrderDO.getParentDO().setStatus(DOStatus.UPDATED);
				}
			}
			
			
			//2、保存上传记录
			IBlputexrxpresCudService putService = ServiceFinder.find(IBlputexrxpresCudService.class); 
			
			putService.insert(exRxPresArray);
			
			//3、更新医嘱执行状态为完成
			iCiOrderMainService.update(updateDos);
		}
		
	}
}
