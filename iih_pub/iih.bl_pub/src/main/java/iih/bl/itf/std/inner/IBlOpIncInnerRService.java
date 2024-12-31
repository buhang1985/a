package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.inc.WsParamGetIncItm;
import iih.bl.itf.std.bean.input.inc.WsParamGetPatInc;
import iih.bl.itf.std.bean.output.inc.WsResultGetIncItm;
import iih.bl.itf.std.bean.output.inc.WsResultGetPatInc;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊自助发票查询
 * @author shaokx 2019/7/22
 *
 */
public interface IBlOpIncInnerRService {

	/**
	 * 门诊自助发票查询（查询一个患者的发票信息）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultGetPatInc getPatIncInfo(WsParamGetPatInc inParam) throws BizException;
	
	/**
	 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultGetIncItm getIncItmInfo(WsParamGetIncItm inParam) throws BizException;
}
