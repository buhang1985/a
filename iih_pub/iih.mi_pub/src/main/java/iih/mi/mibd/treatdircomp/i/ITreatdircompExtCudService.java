package iih.mi.mibd.treatdircomp.i;

import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import xap.mw.core.data.BizException;

/**
 * @ClassName: ITreatdircompExtCudService
 * @Description: 医保平台_诊疗对照扩展维护服务
 * @author: dj.zhang
 * @date: 2018年1月31日 下午1:53:44
 */
public interface ITreatdircompExtCudService {
	/**
	 * 保存诊疗项目对照
	 * 
	 * @param treatDirCompDTOs
	 *            诊疗项目对照信息
	 * @throws BizException
	 */
	public abstract TreatDirCompDTO[] saveTreatComp(String misId, TreatDirCompDTO[] treatDirCompDTOs)
			throws BizException;

	/**
	 * @Title: AutoComp
	 * @Description: 自动对照
	 * @param misId
	 */
	public void autoTreatComp(String misId) throws BizException;
	
	/**  
	* @Title: delTreatComp  
	* @Description: 删除对照
	* @param misId
	* @param treatDirCompDtOs
	* @return   
	 * @throws BizException 
	*/  
	TreatDirCompDTO[] delTreatComp(String misId, TreatDirCompDTO[] treatDirCompDtOs) throws BizException;
}
