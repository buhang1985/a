package iih.ci.mr.resumeprint;

import iih.ci.mr.resumeprint.bp.MrResumePrintBp;
import iih.ci.mr.resumeprint.i.MrResumePrintService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class MrResumePrintServiceImpl implements MrResumePrintService{

	
	/**
	 * 门诊病历补打-查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<PatiVisitDO> getMrResumePrintQryList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		MrResumePrintBp pageBp=new MrResumePrintBp();
		return pageBp.getMrResumePrintQryList(qryRootNodeDTO, paginationInfo);
		
	}

}
