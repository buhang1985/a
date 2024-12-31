package iih.ci.mrm.cimrmdirheareportdto.s;

import java.util.List;

import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.cimrmdirheareportdto.i.ICiMrmDirHeaReportService;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateCSVBp;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateListBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={ICiMrmDirHeaReportService.class}, binding=Binding.JSONRPC)
public class CiMrmDirHeaReportServiceImpl  implements ICiMrmDirHeaReportService{

	@Override
	public PagingRtnData<CiMrmDirHeaReportDTO> getMrmDirHeaReportDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {

		CiMrmGenerateListBp cimrmlistbp = new CiMrmGenerateListBp();
		
		return cimrmlistbp.getReportList(qryRootNodeDTO, paginationInfo);
		
	}
	
	@Override
	public CiMrmDirHeaReportDTO[] getCSVReportDTO(QryRootNodeDTO qryRootNodeDTO,
	            String sqlWhere) throws BizException
	  {
		CiMrmGenerateCSVBp bp = new CiMrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO> lst = bp.getDatas(qryRootNodeDTO, sqlWhere);
		if(lst !=null)
		{
			 CiMrmDirHeaReportDTO[] arrReports = new  CiMrmDirHeaReportDTO[lst.size()];
			 lst.toArray(arrReports);
			 return arrReports;
		}
		else 
		{
			return new CiMrmDirHeaReportDTO[]{};
		}
	  }
	}
