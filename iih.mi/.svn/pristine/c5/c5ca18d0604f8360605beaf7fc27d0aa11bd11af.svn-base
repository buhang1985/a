package iih.mi.inst.bizgrp.country.ruralcooperinsure;

import iih.bd.pp.exportdrugsrvdto.d.ExportDrugSrvDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.inst.bizbase.HpInnerServiceBaseImpl;
import iih.mi.inst.bizbase.bp.FindPagingByQCondBp;
import iih.mi.inst.bizbase.bp.FindZZInExportPagingByQCondBp;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 国家新农合医保内部服务实现类
 * 
 * @author dj.zhang
 *
 */
public class RuralHpInnerServiceImpl extends HpInnerServiceBaseImpl implements HpInnerService {

	@SuppressWarnings("unchecked")
	@Override
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(String id_hp,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) {
		ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> reOutParamDTO = new ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>>();

		FindPagingByQCondBp bp = new FindPagingByQCondBp();
		try {
			PagingRtnData<HPSrvorcaDO> result = bp.exec(id_hp, qryRootNodeDto, orderStr, pg);
			//FArrayList fArrayList = new FArrayList();
			//fArrayList.add(result);
			//reOutParamDTO.setData(fArrayList);
			reOutParamDTO.setData(result);
		} catch (BizException e) {
			reOutParamDTO.setFg_HisSuccess(FBoolean.FALSE);
			reOutParamDTO.setErrorMsg(e.getMessage());

		}
		return reOutParamDTO;
	}
	
}
