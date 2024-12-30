package iih.sc.apt.s.bp.mt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.mp.nr.api.d.PlanParamDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * MP域接收BS024消息后调用该接口接收MP参数修改医技预约申请单到检状态
 * @author yzh
 * @date 2019年6月13日19:28:35
 */
public class UpdateMtApplAryBP {
	
	public void exec(FArrayList params) throws BizException{
		if(ListUtil.isEmpty(params)) return;
		
		this.updateApplStatus(params);
	}
	/**
	 * 根据执行状态和医嘱id找到对应未作废 未预约的申请单修改申请单到检状态
	 * @param ciorMap
	 * @throws BizException 
	 */
	private void updateApplStatus(FArrayList params) throws BizException{
		Map<String,List<PlanParamDTO>> ciorMap = new HashMap<String,List<PlanParamDTO>>();
		List<String> idOrList = new ArrayList<String>();
		for (Object obj : params) {
			PlanParamDTO param = (PlanParamDTO) obj;
			//检查类医嘱信息
			if(param.getSd_srvtp().startsWith("02")){
				idOrList.add(param.getId_or());
				if(IScDictCodeConst.SD_MP_ARY.equals(param.getSd_status())){//到检
					if(!ciorMap.containsKey(IScDictCodeConst.SD_MP_ARY)){
						List<PlanParamDTO> paramList = new ArrayList<PlanParamDTO>();
						paramList.add(param);
						ciorMap.put(IScDictCodeConst.SD_MP_ARY, paramList);
					}else{
						List<PlanParamDTO> paramList = ciorMap.get(IScDictCodeConst.SD_MP_ARY);
						paramList.add(param);
						ciorMap.put(IScDictCodeConst.SD_MP_ARY, paramList);
					}
				}
				if(IScDictCodeConst.SD_MP_CANC_ARY.equals(param.getSd_status())){//取消到检
					if(!ciorMap.containsKey(IScDictCodeConst.SD_MP_CANC_ARY)){
						List<PlanParamDTO> paramList = new ArrayList<PlanParamDTO>();
						paramList.add(param);
						ciorMap.put(IScDictCodeConst.SD_MP_CANC_ARY, paramList);
					}else{
						List<PlanParamDTO> paramList = ciorMap.get(IScDictCodeConst.SD_MP_CANC_ARY);
						paramList.add(param);
						ciorMap.put(IScDictCodeConst.SD_MP_CANC_ARY, paramList);
					}
				}
			}
		}
		if(MapUtils.isEmpty(ciorMap)) return;
		//根据医嘱查询申请单子表
		ScAptApplItmDO[] applItms = this.getScAptApplItm(idOrList);
		if(ArrayUtil.isEmpty(applItms)) return;
		//根据申请单ID对数据分组
		Map<String,String> applIdMap = this.handleApplItms(applItms);
		//根据医嘱获取对应医技申请单数据
		ScAptApplDO[] appls = this.getScAptAppl(applIdMap);
		if(ArrayUtil.isEmpty(appls)) return;
		List<String> idAptList = new ArrayList<String>();
		//根据医嘱id医技预约申请单分组
		Map<String,ScAptApplDO> applMap = new HashMap<String,ScAptApplDO>();
		for (ScAptApplDO applDO : appls) {
			if(!applMap.containsKey(applDO.getId_or())){
				applMap.put(applDO.getId_or(), applDO);
			}
			if(applDO.getFg_comfirm().booleanValue()){
				idAptList.add(applDO.getId_scapt());
			}
		}
		//获取所有已预约申请单对应的预约记录数据
		ScAptDO[] apts = this.getScApt(idAptList);
		//将预约记录按照预约id分组
		Map<String,ScAptDO> aptMap = new HashMap<String,ScAptDO>();
		for (ScAptDO scAptDO : apts) {
			if(!aptMap.containsKey(scAptDO.getId_apt())){
				aptMap.put(scAptDO.getId_apt(), scAptDO);
			}
		}
		//所有需要处理的申请单数据
		List<ScAptApplDO> applResult = new ArrayList<ScAptApplDO>();
		//所有需要处理的预约数据
		List<ScAptDO> aptResult = new ArrayList<ScAptDO>();
		if(ciorMap.containsKey(IScDictCodeConst.SD_MP_ARY)){
			List<PlanParamDTO> paramList = ciorMap.get(IScDictCodeConst.SD_MP_ARY);
			for (PlanParamDTO planParamDTO : paramList) {
				if(applMap.containsKey(planParamDTO.getId_or())){
					ScAptApplDO scaptappldo = applMap.get(planParamDTO.getId_or());
					if(scaptappldo.getFg_comfirm().booleanValue()){
						ScAptDO scaptdo = aptMap.get(scaptappldo.getId_scapt());
						if(scaptdo != null && !scaptdo.getFg_canc().booleanValue()){
							scaptdo.setStatus(DOStatus.UPDATED);
							scaptdo.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
							scaptdo.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH);
							aptResult.add(scaptdo);
						}
					}
					scaptappldo.setStatus(DOStatus.UPDATED);
					scaptappldo.setFg_reg_arv(FBoolean.TRUE);
					applResult.add(scaptappldo);
				}
			}
		}
		if(ciorMap.containsKey(IScDictCodeConst.SD_MP_CANC_ARY)){
			List<PlanParamDTO> paramList = ciorMap.get(IScDictCodeConst.SD_MP_CANC_ARY);
			for (PlanParamDTO planParamDTO : paramList) {
				if(applMap.containsKey(planParamDTO.getId_or())){
					ScAptApplDO scaptappldo = applMap.get(planParamDTO.getId_or());
					if(scaptappldo.getFg_comfirm().booleanValue()){
						ScAptDO scaptdo = aptMap.get(scaptappldo.getId_scapt());
						if(scaptdo != null && !scaptdo.getFg_canc().booleanValue()){
							scaptdo.setStatus(DOStatus.UPDATED);
							scaptdo.setId_status(IScDictCodeConst.ID_APTSTATUS_ORDER);
							scaptdo.setSd_status(IScDictCodeConst.SD_APTSTATUS_ORDER);
							aptResult.add(scaptdo);
						}
					}
					scaptappldo.setStatus(DOStatus.UPDATED);
					scaptappldo.setFg_reg_arv(FBoolean.FALSE);
					applResult.add(scaptappldo);
				}
			}
		}
		IScaptapplMDOCudService iscaptapplmdocudservice = ServiceFinder.find(IScaptapplMDOCudService.class);
		IScaptMDOCudService iscaptmdocudservice = ServiceFinder.find(IScaptMDOCudService.class);
		if(!ListUtil.isEmpty(applResult)){
			iscaptapplmdocudservice.save((ScAptApplDO[]) applResult.toArray(new ScAptApplDO[applResult.size()]));
		}
		if(!ListUtil.isEmpty(aptResult)){
			iscaptmdocudservice.save((ScAptDO[]) aptResult.toArray(new ScAptDO[aptResult.size()]));
		}
	}
	/**
	 * 根据申请单id对申请单子表数据进行分组
	 * @param applItms
	 * @return
	 * @throws BizException
	 */
	private Map<String,String> handleApplItms(ScAptApplItmDO[] applItms) throws BizException{
		Map<String,String> result = new HashMap<String,String>();
		for (ScAptApplItmDO scAptApplItmDO : applItms) {
			String id_aptappl = scAptApplItmDO.getId_aptappl();
			if(!result.containsKey(id_aptappl)){
				result.put(id_aptappl, null);
			}
		}
		return result;
	}
	/**
	 * 根据医嘱id获取医技预约申请单子表数据
	 * @param idOrList
	 * @return
	 * @throws BizException
	 */
	private ScAptApplItmDO[] getScAptApplItm(List<String> idOrList) throws BizException{
		if(ListUtil.isEmpty(idOrList)) return null;
		IScAptApplItmDORService iscaptapplitmdorservice = ServiceFinder.find(IScAptApplItmDORService.class);
		StringBuilder whereStr = new StringBuilder();
		whereStr.append(ScSqlUtils.getInSqlByIds(ScAptApplDO.ID_OR, idOrList));
		return iscaptapplitmdorservice.find(whereStr.toString(), null, FBoolean.FALSE);
	}
	/**
	 * 根据医嘱id获取医技预约申请单
	 * @param idOrList
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO[] getScAptAppl(Map<String,String> applIdMap) throws BizException{
		if(MapUtils.isEmpty(applIdMap)) return null;
		Iterator<Entry<String, String>> iterator = applIdMap.entrySet().iterator();
		List<String> aptapplIdList = new ArrayList<String>();
	    while (iterator.hasNext()) {
	        String id_aptappl = iterator.next().getKey();
	        aptapplIdList.add(id_aptappl);
	    }
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		StringBuilder whereStr = new StringBuilder();
		whereStr.append(ScSqlUtils.getInSqlByIds(ScAptApplDO.ID_APTAPPL, aptapplIdList));
		whereStr.append(" and fg_canc='N' and sd_sctp='03'");
		return iscaptapplmdorservice.find(whereStr.toString(), null, FBoolean.FALSE);
	}
	/**
	 * 查询预约记录数据
	 * @param idAptList
	 * @return
	 * @throws BizException 
	 */
	private ScAptDO[] getScApt(List<String> idAptList) throws BizException{
		if(ListUtil.isEmpty(idAptList)) return null;
		IScaptMDORService iscaptmdorservice = ServiceFinder.find(IScaptMDORService.class);
		StringBuilder whereStr = new StringBuilder();
		whereStr.append(ScSqlUtils.getInSqlByIds(ScAptDO.ID_APT, idAptList));
		whereStr.append(" and fg_canc='N'");
		return iscaptmdorservice.find(whereStr.toString(), null, FBoolean.FALSE);
	}
	
	public static final String SD_APTSTATUS_ORDER = "1"; // 预约
	public static final String SD_APTSTATUS_PAY = "2"; // 支付
	public static final String SD_APTSTATUS_FINISH = "3"; // 完成
	public static final String SD_APTSTATUS_CANCEL = "4"; // 取消
	public static final String SD_APTSTATUS_BEF_CONF = "5";//术前确认
	/**
	 * 预约状态ID
	 */
	public static final String ID_APTSTATUS_ORDER = "@@@@AA10000000025498"; // 预约
	public static final String ID_APTSTATUS_PAY = "@@@@AA10000000025499"; // 支付
	public static final String ID_APTSTATUS_FINISH = "@@@@AA1000000002549A"; // 完成
	public static final String ID_APTSTATUS_CANCEL = "@@@@AA1000000002549B"; // 取消
	public static final String ID_APTSTATUS_BEF_CONF = "@@@@Z8100000000XJ1PQ";//术前确认
}
