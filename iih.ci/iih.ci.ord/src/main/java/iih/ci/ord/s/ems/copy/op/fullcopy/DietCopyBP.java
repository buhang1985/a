package iih.ci.ord.s.ems.copy.op.fullcopy;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 膳食医嘱完全复制逻辑
 * @author zhangwq
 *
 */
public class DietCopyBP extends BaseCopyBP {
	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT);
	}
}
