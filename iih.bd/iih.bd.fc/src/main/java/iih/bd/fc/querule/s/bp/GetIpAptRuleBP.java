package iih.bd.fc.querule.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IQueruleRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取住院预约规则
 * @author liubin
 *
 */
public class GetIpAptRuleBP {
	/**
	 * 获取住院预约规则
	 * 只有一条住院预约规则
	 * @return
	 * @throws BizException
	 */
	public QueruleAggDO exec() throws BizException{
		IQueruleRService service = ServiceFinder.find(IQueruleRService.class);
		QueruleAggDO[] queruleAggDOs = service.findByAttrValString(QueRuleDO.SD_QUEBENTP, IBdFcDictCodeConst.SD_QUETP_APPIP);
		if(!ArrayUtil.isEmpty(queruleAggDOs)){
			return queruleAggDOs[0];
		}
		return null;
	}
}
