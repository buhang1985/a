package iih.pi.reg.i.custom;

import iih.pi.reg.dto.piimport.d.PiImportFromThirdDBDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;

/**
 * 
 * 患者从第三方数据库导入任务客户化组装数据服务
 * @author ly 2019/07/17
 *
 */
public interface IPiImortService {

	/**
	 * 组装数据
	 * @param patAggDO 患者数据
	 * @param importData 导入数据
	 * @throws BizException
	 */
	public abstract void assembleData(PatiAggDO patAggDO, PiImportFromThirdDBDTO importData) throws BizException;
}
