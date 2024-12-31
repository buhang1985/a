package iih.ci.mr.s;

import iih.ci.mr.i.ICiMrBrowseParamService;
import iih.ci.mr.mrbrowse.s.bp.common.CiMrBrowseParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {ICiMrBrowseParamService.class }, binding = Binding.JSONRPC)
public class CiMrBrowseParamServiceImpl implements ICiMrBrowseParamService{

	@Override
	public String GetSysParamNoArchive(String id_org) throws BizException {
		return CiMrBrowseParamUtils.GetSysParamNoArchive(id_org);
	}

	@Override
	public String GetSysParamArchived(String id_org) throws BizException {
		return CiMrBrowseParamUtils.GetSysParamArchived(id_org);
	}

}
