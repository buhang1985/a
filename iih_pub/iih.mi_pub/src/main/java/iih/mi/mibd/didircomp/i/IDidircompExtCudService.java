package iih.mi.mibd.didircomp.i;

import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import xap.mw.core.data.BizException;

/**
 * 医保平台_病种对照扩展服务
 */
public interface IDidircompExtCudService {

	/**
	 * @Title: SaveDiComp
	 * @Description: 保存对照信息
	 * @param misId
	 * @param diDirCompDtOs
	 * @return
	 */
	DiDirCompDTO[] saveDiComp(String misId, DiDirCompDTO[] diDirCompDtos) throws BizException;

	/**
	 * @Title: AutoDiComp
	 * @Description: 自动对照
	 * @param misId
	 */
	void autoDiComp(String misId) throws BizException;

	/**  
	* @Title: delDiComp  
	* @Description: 删除对照
	* @param misId
	* @param diDirCompDtOs
	* @return
	* @throws BizException   
	*/  
	DiDirCompDTO[] delDiComp(String misId, DiDirCompDTO[] diDirCompDtOs) throws BizException;
}
