package iih.en.pv.out.i;

import iih.pi.banner.d.PatientBannerDTO;
import xap.mw.core.data.BizException;

/**
 * 对PI提供查询接口
 * 
 * @author liubin
 *
 */
public interface IEn4PiQryService extends IEn4CommQryService {
	/**
	 * 患者banner处理预检信息
	 * 
	 * @param banners
	 * @throws BizException
	 */
	public abstract void handleBannerErPreInfo(PatientBannerDTO[] banners) throws BizException;
}
