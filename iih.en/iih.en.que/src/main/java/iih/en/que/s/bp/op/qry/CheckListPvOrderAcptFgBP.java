package iih.en.que.s.bp.op.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.que.enqueue.d.EnQueueDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 接诊时判断是否可以顺序接诊(列表模式)
 * 
 * @author liubin
 *
 */
public class CheckListPvOrderAcptFgBP {
	/**
     * 接诊时判断是否可以顺序接诊(列表模式)
     * 
     * @param entId
     * @param benId
     * @param type
     * @return
     * @throws BizException
     */
	public ResultDTO exec(String entId, String benId, String type) throws BizException {
		ResultDTO result = new ResultDTO();
		result.setFlag(FBoolean.TRUE);
		//无分诊台，分诊台不在线，可不按顺序接诊
		if(!isBenOnLine(benId))
			return result;
		return isFirstLevelOrNtn(entId);
	}
	/**
	 * 判定分诊台是否在线
	 * 
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	public static boolean isBenOnLine(String benId) throws BizException{
		if(EnValidator.isEmpty(benId))
			return false;
		QueBenDO ben = (QueBenDO) new DAFacade().findByPK(QueBenDO.class, benId, null);
		if(ben == null)
			return false;
		return PauseEnum.ONLINE.equals(ben.getEu_pause());
	}
	/**
	 * 顺序接诊回诊时间限制(分钟)
	 * 顺序接诊就诊优先级限制
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static ResultDTO isFirstLevelOrNtn(String entId) throws BizException{
		ResultDTO result = new ResultDTO();
		result.setFlag(FBoolean.FALSE);
		EnQueueDO enque = getEnQue(entId);
		if(enque != null){
			int level = EnParamUtils.getPvOrderAcptLevel();
			int entLevel = enque.getLevel_pri() == null ? 0 : enque.getLevel_pri().intValue();
			boolean res = entLevel > level;
			int rtnMin = EnParamUtils.getPvOrderAcptRtnMin(EnContextUtils.getDeptId());
			if(!res && enque.getDt_acpt() != null){
				res = FDateTime.getMinutesBetween(enque.getDt_acpt(), EnAppUtils.getServerDateTime()) <= rtnMin;
			}
			if(!res){
				result.setMsg(String.format("患者优先级小于%s或者回诊时间大于%s分钟,请按候诊顺序接诊！", level, rtnMin));
			}else{
				result.setFlag(FBoolean.TRUE);
			}
		}
		return result;
	}
	/**
	 * 获取就诊队列
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static EnQueueDO getEnQue(String entId) throws BizException{
		String cond = "id_ent = ? and sd_entque_tp = ?";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().findByCond(EnQueueDO.class, cond, param);
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
}
