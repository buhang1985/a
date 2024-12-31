package iih.mp.nr.mpnuhandoverrpt.i;

import iih.mp.nr.dto.mpnuhs.d.MpNuHsHeadDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 交班报告服务
 * @author HYZ
 *
 */
public interface IMpnuhandoverrptExtService {
	
	/**
	 * 取得交班报告数据
	 * @param time
	 * @return
	 * @throws BizException
	 */
	public abstract MpNuHsHeadDTO getHandoverReport(FDateTime time) throws BizException;
	
	/**
	 * 保存交班报告数据
	 * @param report
	 * @throws BizException
	 */
	public abstract void saveHandoverReport(MpNuHsHeadDTO report) throws BizException;

}
