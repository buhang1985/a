package iih.bd.srv.diagdef.s;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.i.IDiagdefExtService;
import iih.bd.srv.diagdef.s.bp.FindDiagdefAggByIdBp;
import iih.bd.srv.diagdef.s.bp.FindPagingByQCondAndCateBp;
import iih.bd.srv.diagstaca.d.DiagStacaDO;
import iih.bd.srv.s.bp.GetDiDefSpecBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IDiagdefExtService.class }, binding = Binding.JSONRPC)
public class DiagdefExtServiceImpl implements IDiagdefExtService {

	@Override
	public DiagDefDO[] findDiagdefSpec(String id_org, String sqlWhere) throws BizException {
		if (StringUtils.isNullOrEmpty(id_org))
			return null;
		GetDiDefSpecBP bp = new GetDiDefSpecBP();
		return bp.exec(id_org, sqlWhere);
	}

	@Override
	public DiagdefAggDO findById(String id_Diagdef) throws BizException {
		FindDiagdefAggByIdBp bp = new FindDiagdefAggByIdBp();
		return bp.exec(id_Diagdef);
	}

	@Override
	public PagingRtnData<DiagDefDO> FindPagingByQCondAndCate(MedCdSystemDO medCdSystemDo, DiagStacaDO diagStacaDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		FindPagingByQCondAndCateBp bp = new FindPagingByQCondAndCateBp();
		PagingRtnData<DiagDefDO> result = bp.exec(medCdSystemDo, diagStacaDo, qryRootNodeDto, pg);
		return result;
	}
}
