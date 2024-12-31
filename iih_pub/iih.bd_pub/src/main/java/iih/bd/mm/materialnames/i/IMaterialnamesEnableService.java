package iih.bd.mm.materialnames.i;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import xap.mw.core.data.BizException;

/**
 * 药品通用名目录启用服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMaterialnamesEnableService {

	/**
	 * 启用药品通用名
	 * 
	 * @param materialNamesDOs
	 * @return
	 * @throws BizException
	 */
	public abstract MaterialNamesDO[] Enable(MaterialNamesDO[] materialNamesDOs) throws BizException;

	/**
	 * 停用药品通用名
	 * 
	 * @param materialNamesDOs
	 * @return
	 * @throws BizException
	 */
	public abstract MaterialNamesDO[] Disable(MaterialNamesDO[] materialNamesDOs) throws BizException;

}
