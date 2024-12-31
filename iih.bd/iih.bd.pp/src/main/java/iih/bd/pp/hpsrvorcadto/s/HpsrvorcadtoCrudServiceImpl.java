package iih.bd.pp.hpsrvorcadto.s;

import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import iih.bd.pp.hpsrvorcadto.i.IHpSrvorcadtoRService;
import iih.bd.pp.hpsrvorcadto.s.bp.FindAuditedDrugPagingDataBp;
import iih.bd.pp.hpsrvorcadto.s.bp.FindAuditedFwssPagingDataBp;
import iih.bd.pp.hpsrvorcadto.s.bp.FindAuditedZlPagingDataBp;
import iih.bd.pp.hpsrvorcadto.s.bp.FindsrvorcaDtoBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保对照dto服务
 * 
 * @author guoyang, hao_wu
 *
 */
public class HpsrvorcadtoCrudServiceImpl implements IHpSrvorcadtoRService {

	@Override
	public PagingRtnData<HpsrvorcaDTO> findAuditedDataList(QryRootNodeDTO qryRootNodeDto, PaginationInfo pg)
			throws BizException {
		FindsrvorcaDtoBp bp = new FindsrvorcaDtoBp();
		PagingRtnData<HpsrvorcaDTO> result = bp.exec(qryRootNodeDto,pg);
		return result;
	}

	@Override
	public PagingRtnData<HpsrvorcaDTO> findAuditedDrugDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindAuditedDrugPagingDataBp bp = new FindAuditedDrugPagingDataBp();
		PagingRtnData<HpsrvorcaDTO> result = bp.exec(qryRootNodeDto, hpId, pg);
		return result;
	}

	@Override
	public PagingRtnData<HpsrvorcaDTO> findAuditedZlDataList(QryRootNodeDTO qryRootNodeDto, String hpId,PaginationInfo pg)
			throws BizException {
		FindAuditedZlPagingDataBp bp = new FindAuditedZlPagingDataBp();
		PagingRtnData<HpsrvorcaDTO> result = bp.exec(qryRootNodeDto,hpId, pg);
		return result;
	}

	@Override
	public PagingRtnData<HpsrvorcaDTO> findAuditedFwssDataList(QryRootNodeDTO qryRootNodeDto, PaginationInfo pg)
			throws BizException {
		FindAuditedFwssPagingDataBp bp = new FindAuditedFwssPagingDataBp();
		PagingRtnData<HpsrvorcaDTO> result = bp.exec(qryRootNodeDto, pg);
		return result;
	}
}
