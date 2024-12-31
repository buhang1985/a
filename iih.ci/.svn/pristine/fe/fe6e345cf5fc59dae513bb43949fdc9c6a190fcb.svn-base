package iih.ci.mrqry.mrreport.s;

import iih.ci.mrqc.mroperrisklistdto.d.MrOperRiskListDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqry.mrreport.bp.MrClosePatientQruBP;
import iih.ci.mrqry.mrreport.bp.MrInpatientStatisticQryBP;
import iih.ci.mrqry.mrreport.bp.MrOperRiskQryBP;
import iih.ci.mrqry.mrreport.bp.MrUnFileMrForDocQryBP;
import iih.ci.mrqry.mrreport.bp.MrUnFileMrmPatQryBP;
import iih.ci.mrqry.mrreport.i.IMrReportQryMaintainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IMrReportQryMaintainService.class }, binding = Binding.JSONRPC)
public class MrReportQryMaintainServiceImpl extends PagingServiceImpl<QaPatListDTO> implements IMrReportQryMaintainService{

	@Override
	public PagingRtnData<QaPatListDTO> getUnFileMrmPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		MrUnFileMrmPatQryBP mrUnFileMrmPatQryBp = new MrUnFileMrmPatQryBP();
		return mrUnFileMrmPatQryBp.getUnFileMrmPatList(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public QaPatListDTO[] getUnFileMrForQcDocList(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		MrUnFileMrForDocQryBP mrUnFileMrForDocQryBp = new MrUnFileMrForDocQryBP();
		return mrUnFileMrForDocQryBp.getUnFileMrForQcDocList(qryRootNodeDTO);
	}

	@Override
	public QaPatListDTO[] getInpatientStatistic(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		MrInpatientStatisticQryBP mrInpatientStatisticQryBp = new MrInpatientStatisticQryBP();
		return mrInpatientStatisticQryBp.getInpatientStatistic(qryRootNodeDTO);
	}

	@Override
	public MrOperRiskListDTO[] getMrOperRiskList(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		MrOperRiskQryBP mrOperRiskQryBp = new MrOperRiskQryBP();
		return mrOperRiskQryBp.getMrOperRiskList(qryRootNodeDTO);
	}

	@Override
	public PagingRtnData<QaPatListDTO> getClosePatientList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		MrClosePatientQruBP mrClosePatientBQ = new MrClosePatientQruBP();
		return mrClosePatientBQ.getClosePatientList(qryRootNodeDTO, paginationInfo);
	}

}
