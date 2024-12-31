package iih.pis.phk.phkemp.i;

import iih.pis.phk.phkemp.d.PhkEmpDO;
import xap.mw.core.data.BizException;

/**
 * 患者管家扩展CUD服务
 * 
 * @author lq
 *
 */
public interface IPhkEmpExtCudService {

	/**
	 * 适用人员主键集合批量新增患者管家
	 * 
	 * @param psndocIds
	 *            人员主键集合
	 * @return
	 * @throws BizException
	 */
	public PhkEmpDO[] addPhkEmpByPsnIds(String[] psndocIds) throws BizException;
}
