package iih.mbh.mp.scan.i;

import iih.mbh.mp.scan.d.ScanInfoDTO;
import xap.mw.core.data.BizException;

/**
 * @Description:PDA扫码计算
 * @author: xu_xing@founder.com.cn
 * @version：2019年11月23日 上午11:05:00 创建
 */
public interface IScanService {

	/**
	 * 扫码
	 * @param no_bars
	 * @param eu_scantp
	 * @return
	 * @throws BizException
	 */
	public abstract ScanInfoDTO onScan(String no_bars, Integer eu_scantp) throws BizException;
}
