package iih.bd.res.bizgrp.s;

import iih.bd.res.bizgrp.d.BizgrpAggDO;
import iih.bd.res.bizgrp.i.IBizGrpExtCudService;
import iih.bd.res.bizgrp.i.IBizGrpExtRService;
import iih.bd.res.bizgrp.s.bp.FindBizGrpByPsnIdBp;
import xap.mw.core.data.BizException;

/**
 * 业务组扩展服务
 * 
 * @author hao_wu 2020-1-9
 *
 */
public class BizGrpExtCrudServiceImpl implements IBizGrpExtCudService, IBizGrpExtRService {

	@Override
	public BizgrpAggDO[] findBizGrpByPsnId(String psnId) throws BizException {
		FindBizGrpByPsnIdBp bp = new FindBizGrpByPsnIdBp();
		BizgrpAggDO[] rtn = bp.exec(psnId);
		return rtn;
	}
}
