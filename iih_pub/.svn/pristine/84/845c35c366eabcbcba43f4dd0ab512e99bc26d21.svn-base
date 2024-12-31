package iih.ci.mrm.i.qmpareport;

import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmQMPAReportService {
	
	/**
	 * 病案首页信息分页查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrmDirHeaReportDTO> getMrmDirHeaReportDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;

	/**
	 * 获取上报数据
	 * @param qryRootNodeDTO
	 * @param sqlWhere
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrmDirHeaReportDTO[] getCSVReportDTO(QryRootNodeDTO qryRootNodeDTO, String sqlWhere) throws BizException;

}
