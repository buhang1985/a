package iih.pi.reg.s.external.provide.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.dto.d.PiPatBasicInfoDTO;
import iih.pi.reg.i.IPiRegQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据就诊卡号查询患者基本信息业务逻辑
 * 
 * @author hao_wu 2018-7-20
 *
 */
public class FindPatDoByEntCardNoBp {

	public PiPatBasicInfoDTO exec(String entCardNo) throws BizException {
		if (StringUtils.isEmpty(entCardNo)) {
			throw new BizException("就诊卡号不允许为空。");
		}

		IPiRegQryService patInfoQryService = ServiceFinder.find(IPiRegQryService.class);
		String patId = patInfoQryService.getPatIdBySpecialCond(IPiDictCodeConst.PAT_CONDITION_TYPE_CARDCODE, entCardNo);
		if (StringUtils.isEmpty(patId)) {
			return null;
		}

		PiPatBasicInfoDTO[] result = patInfoQryService.findPiPatBasicInfoByPatIds(new String[] { patId });
		if (result != null && result.length == 1) {
			return result[0];
		}
		return null;
	}
}
