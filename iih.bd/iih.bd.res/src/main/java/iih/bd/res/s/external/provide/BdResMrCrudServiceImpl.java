package iih.bd.res.s.external.provide;

import iih.bd.res.bizgrp.d.BizgrpAggDO;
import iih.bd.res.bizgrp.i.IBizGrpExtRService;
import iih.bd.res.i.external.provide.IBdResMrQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 提供给病历域查询服务
 * 
 * @author hao_wu 2020-1-9
 *
 */
public class BdResMrCrudServiceImpl implements IBdResMrQryService {

	@Override
	public BizgrpAggDO[] findBizGrpByPsnId(String psnId) throws BizException {
		IBizGrpExtRService bizGrpExtRService = ServiceFinder.find(IBizGrpExtRService.class);
		return bizGrpExtRService.findBizGrpByPsnId(psnId);
	}

}
