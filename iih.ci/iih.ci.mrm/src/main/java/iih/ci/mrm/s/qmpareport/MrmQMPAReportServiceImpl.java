package iih.ci.mrm.s.qmpareport;

import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.i.qmpareport.IMrmQMPAReportService;
import iih.ci.mrm.s.qmpareport.bp.MrmGenerateCSVBp;
import iih.ci.mrm.s.qmpareport.bp.MrmGenerateListBp;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IMrmQMPAReportService.class }, binding = Binding.JSONRPC)
public class MrmQMPAReportServiceImpl implements IMrmQMPAReportService {

	@Override
	public PagingRtnData<CiMrmDirHeaReportDTO> getMrmDirHeaReportDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		MrmGenerateListBp cimrmlistbp = new MrmGenerateListBp();
		return cimrmlistbp.getReportList(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public CiMrmDirHeaReportDTO[] getCSVReportDTO(QryRootNodeDTO qryRootNodeDTO, String sqlWhere) throws BizException {
		MrmGenerateCSVBp bp = new MrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO> lst = bp.getDatas(qryRootNodeDTO, sqlWhere);
		
		if (lst != null) {
			CiMrmDirHeaReportDTO[] arrReports = new CiMrmDirHeaReportDTO[lst.size()];
			lst.toArray(arrReports);
			return arrReports;
		} else {
			return new CiMrmDirHeaReportDTO[] {};
		}
	}
	
}
