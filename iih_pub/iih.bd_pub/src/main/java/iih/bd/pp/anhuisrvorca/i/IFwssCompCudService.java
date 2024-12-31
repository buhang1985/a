package iih.bd.pp.anhuisrvorca.i;

import java.text.ParseException;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import xap.mw.core.data.BizException;

/**
 * 服务设施对照信息CUD服务
 * 
 * @author hao_wu
 *
 */
public interface IFwssCompCudService {
	/**
	 * 保存服务设施对照
	 * 
	 * @param fwssCompDTOs
	 *            服务设施对照信息
	 * 
	 * @throws BizException
	 * @throws ParseException
	 */
	public abstract FwssCompDTO[] SaveFwssComp(FwssCompDTO[] fwssCompDTOs) throws BizException;

	/**
	 * 删除服务设施对照
	 * 
	 * @param srvFacilityDtos
	 *            服务设施对照信息
	 * @throws BizException
	 */
	public abstract FwssCompDTO[] DeleteFwssComp(FwssCompDTO[] FwssCompDTOs) throws BizException;
	
	/**
	 * 自动对照
	 * 
	 * @throws BizException
	 */
	public abstract void AutoComp(String hpCode) throws BizException;
	
	/**
	 * 刷新对照
	 * 
	 * @throws BizException
	 */
	public abstract void RefreshComp(String hpCode) throws BizException;
}
