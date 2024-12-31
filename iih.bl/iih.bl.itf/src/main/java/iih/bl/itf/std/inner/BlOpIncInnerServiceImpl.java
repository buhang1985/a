package iih.bl.itf.std.inner;

import iih.bl.itf.std.IBlOpIncRService;
import iih.bl.itf.std.bean.input.inc.WsParamGetIncItm;
import iih.bl.itf.std.bean.input.inc.WsParamGetPatInc;
import iih.bl.itf.std.bean.output.inc.WsResultGetIncItm;
import iih.bl.itf.std.bean.output.inc.WsResultGetPatInc;
import iih.bl.itf.std.bp.opinc.GetIncItmInfoBP;
import iih.bl.itf.std.bp.opinc.GetPatIncInfoBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊发票服务
 * 
 * @author shaokx 2019/7/22
 *
 */
public class BlOpIncInnerServiceImpl implements IBlOpIncInnerRService {

	/**
	 * 门诊自助发票查询（查询一个患者的发票信息）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultGetPatInc getPatIncInfo(WsParamGetPatInc inParam) throws BizException {
		GetPatIncInfoBP bp = new GetPatIncInfoBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultGetIncItm getIncItmInfo(WsParamGetIncItm inParam) throws BizException {
		GetIncItmInfoBP bp = new GetIncItmInfoBP();
		return bp.execTV(inParam);
	}

}
