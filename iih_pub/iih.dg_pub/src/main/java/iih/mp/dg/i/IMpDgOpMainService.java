package iih.mp.dg.i;

import iih.mp.dg.dto.opdgdisp.d.OpDrugDispenseCondDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDTO;
import iih.mp.dg.pharmacysignin.d.OpPharmacySignInParamDTO;
import iih.mp.dg.pharmacysignin.d.OpPharmacySignInResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 药品执行门诊主服务</br>
 * 提供门诊药品主流程业务服务</br>
 * 1.签到 </br>
 * 2.发药
 * 
 * @author hao_wu 2018-7-18
 *
 */
public interface IMpDgOpMainService {

	public static String SEPARAT = "@#@";

	/**
	 * 门诊药房签到
	 * 
	 * @param paramDto
	 * @return
	 * @throws BizException
	 */
	public abstract OpPharmacySignInResultDTO[] signIn(OpPharmacySignInParamDTO paramDto) throws BizException;

	/**
	 * 取消摆药
	 * 
	 * @param presIds 处方主键集合
	 * @throws BizException
	 */
	public abstract void cancelDispDrug(String[] presIds) throws BizException;

	/**
	 * 门诊药房窗口叫号
	 * 
	 * @param callNum
	 * @return
	 * @throws BizException
	 */
	public abstract String OpPharmacyWinCallNum(Integer callNum) throws BizException;

	/**
	 * 发药
	 * 
	 * @param presList
	 * @throws BizException
	 */
	public abstract void outDrug(PresDTO[] presList) throws BizException;

	/**
	 * 配药完成
	 * 
	 * @param presIds
	 * @param operId
	 * @param dt_disp
	 * @throws BizException
	 */
	public abstract void collDrugFinish(String[] presIds, String operId, FDateTime dt_disp) throws BizException;
	
	/**
	 * 患者二次分窗口逻辑
	 * 
	 * @param fMap
	 * @return
	 * @throws BizException
	 */
	public abstract String[] splitWinByPatIds(boolean fgHerb, OpDrugDispenseCondDTO condDto, String Id_quesite, String splitWay, FBoolean fg_getPresList) throws BizException;
	
	
	/**
	 * 更新站点id
	 * 
	 * @param wherePate
	 * @param idQueSite
	 * @throws BizException
	 */
	public abstract void updateDispWin(String wherePate, String idQueSite) throws BizException;
}
