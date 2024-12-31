package iih.ci.mr.s;


import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mr.cimrcontentdto.d.CiMrContentDTO;
import iih.ci.mr.cimrcontentdto.s.bp.CiMrContentQryBp;
import iih.ci.mr.i.ICiMrContentQryService;

@Service(serviceInterfaces={ICiMrContentQryService.class}, binding=Binding.JSONRPC)
public class CiMrContentQryServiceImpl implements ICiMrContentQryService {

	@Override
	public PagingRtnData<CiMrContentDTO> findByPageInfo(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		CiMrContentQryBp bp = new CiMrContentQryBp();
		return bp.getMrContentByPageInfo(qryRootNodeDTO, paginationInfo);
		
	}

}
