package iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.inst.bizbase.HpInnerServiceBaseImpl;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 郑州省内异地医保内部服务实现类
 * 
 */
public class LLHpInnerServiceImpl extends HpInnerServiceBaseImpl implements HpInnerService {
	@Override
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(String hpId,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) {
		return null;
	}

	@Override
	public ResultOutParamDTO<FArrayList> exportHpDirList(String hpId,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg, String miSrvTp) {
		return null;
	}


}
