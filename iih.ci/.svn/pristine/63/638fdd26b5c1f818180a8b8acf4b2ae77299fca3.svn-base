package iih.ci.mr.s;

import iih.ci.mr.d.MrSginDTO;
import iih.ci.mr.i.ICiMrSignService;
import iih.ci.mr.s.bp.GetCiMrSignDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = {ICiMrSignService.class }, binding = Binding.JSONRPC)
public class CiMrSignDTOServiceImpl implements ICiMrSignService {

	@Override
	public PagingRtnData<MrSginDTO> getMrSignDTO(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo)
			throws BizException {
		GetCiMrSignDTO gct= new GetCiMrSignDTO();
		return gct.exec(qryRootNodeDTO,paginationInfo);
	}
}
