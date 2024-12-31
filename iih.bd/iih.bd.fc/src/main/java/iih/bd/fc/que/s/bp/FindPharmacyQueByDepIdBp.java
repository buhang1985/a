package iih.bd.fc.que.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据药房科室主键查询药房队列信息业务逻辑
 * 
 * @author hao_wu 2018-8-15
 *
 */
public class FindPharmacyQueByDepIdBp {

	public QueDO exec(String depId) throws BizException {
		if (StringUtils.isEmpty(depId)) {
			throw new BizException("药房科室主键不允许为空。");
		}

		String wherePart = String.format("sd_quetp = '%s' and id_dep = '%s'", IBdFcDictCodeConst.SD_QUETP_PHARMACY,
				depId);
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		QueDO[] ques = queRService.find(wherePart, "", FBoolean.FALSE);
		if (ArrayUtils.isNotEmpty(ques) && ques.length == 1) {
			return ques[0];
		}
		
		return null;
	}
}
