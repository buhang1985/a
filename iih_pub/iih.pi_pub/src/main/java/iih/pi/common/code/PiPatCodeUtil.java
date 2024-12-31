package iih.pi.common.code;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import iih.pi.params.PiParams;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.desc.PatDODesc;

/**
 * 患者编码相关工具类
 * @author ly 2018/01/02
 *
 */
public class PiPatCodeUtil {

	/**
	 * 取得新患者编码及chis编码
	 * chis编码为患者编码去掉后两位
	 * @return 数组:患者编码，chis编码
	 * @throws BizException
	 */
	public static String[] GetPatCodeAndChisCode() throws BizException {
		String[] rtn = new String[2];

		FBoolean chisCreate = new PiParams().PIPAT0002();
		if (FBoolean.TRUE.equals(chisCreate)) {
			rtn[0] = IPiPatConst.DEFAULT_CHIS_PAT_CODE;
			rtn[1] = IPiPatConst.DEFAULT_CHIS_PAT_CODE;
			return rtn;
		}

		IBillcodeManage billcodeManage = ServiceFinder
				.find(IBillcodeManage.class);
		String patCode = billcodeManage
				.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
		if (StringUtil.isEmpty(patCode))
			return rtn;

		String chisCode = patCode.length() > 2 ? patCode.substring(0,
				patCode.length() - 2) : patCode;

		rtn[0] = patCode;
		rtn[1] = chisCode;

		return rtn;
	}

    /**
     * 医保卡取前九位作为chis条码
     * @param hpNO
     * @return
     */
	public static String GetBarCodeChisFromHpNO(String hpNO) {
		if (!StringUtil.isEmpty(hpNO)) {
			return hpNO.length() > 9 ? hpNO.substring(0, 9) : hpNO;
		}

		return hpNO;
	}
}
