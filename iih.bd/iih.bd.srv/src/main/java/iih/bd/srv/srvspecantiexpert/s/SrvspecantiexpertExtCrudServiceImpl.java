package iih.bd.srv.srvspecantiexpert.s;
import iih.bd.srv.srvspecantiexpert.d.SrvSpecAntiExpertDO;
import iih.bd.srv.srvspecantiexpert.i.ISrvspecantiexpertExtRService;
import iih.bd.srv.srvspecantiexpert.s.bp.FindSrvSpecAntiExpertByQCondBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;


/**
 * 特殊抗菌药专家扩展服务
 */
@Service(serviceInterfaces={ISrvspecantiexpertExtRService.class}, binding=Binding.JSONRPC)
public class SrvspecantiexpertExtCrudServiceImpl implements ISrvspecantiexpertExtRService {

	@Override
	public SrvSpecAntiExpertDO[] findByPsndocQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr)
			throws BizException {
		FindSrvSpecAntiExpertByQCondBp bp = new FindSrvSpecAntiExpertByQCondBp();
		return bp.exec(qryRootNodeDTO, orderStr);
	}
}
