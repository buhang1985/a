/**
 * 
 */
package iih.bl.itf.std;

import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.std.bp.ipprepay.BlPrepayExternalBp;
import xap.mw.core.data.BizException;

/**
 * @author dupeng
 *
 */
public class BlPrepayExternalServiceImpl implements IBlPrepayExternalService {

	@Override
	public String saveIpPrepayToIIH(String paramXml) throws BizException {
		BLThirdItfLogger.info("调用保存住院预交金（住院押金）接口开始："+ paramXml);
		// TODO Auto-generated method stub
		BlPrepayExternalBp newBP = new BlPrepayExternalBp();
		return newBP.SaveIpPrepayInfo(paramXml);
	}

	@Override
	public String saveOpPrepayToIIH(String paramXml) throws BizException {
		// TODO Auto-generated method stub
		BLThirdItfLogger.info("调用保存门诊预交金（预付费账户）接口开始："+ paramXml);
		return null;
	}

}
