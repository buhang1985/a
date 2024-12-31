package iih.bl.itf.std;

import iih.bl.itf.std.bp.opinc.GetIncItmInfoBP;
import iih.bl.itf.std.bp.opinc.GetPatIncInfoBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊发票服务
 * 
 * @author shaokx 2019/2/25
 *
 */
public class BlOpIncServiceImpl implements IBlOpIncRService {

	/**
	 * 门诊自助发票查询（查询一个患者的发票信息）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/2/25
	 */
	@Override
	public String getPatIncInfo(String param) throws BizException {
		GetPatIncInfoBP bp = new GetPatIncInfoBP();
		return bp.exec(param);
	}

	/**
	 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2018/2/25
	 */
	@Override
	public String getIncItmInfo(String param) throws BizException {
		GetIncItmInfoBP bp = new GetIncItmInfoBP();
		return bp.exec(param);
	}

}
