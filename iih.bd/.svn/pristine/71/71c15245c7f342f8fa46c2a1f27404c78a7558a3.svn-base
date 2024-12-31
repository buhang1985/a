package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.i.IEmrNormWordService;
import iih.bd.srv.i.IBdSrvQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 常用词分类服务
 * 
 * @author hao_wu
 *
 */
@Service(serviceInterfaces = { IEmrNormWordService.class }, binding = Binding.JSONRPC)
public class EmrNormWordServiceImpl implements IEmrNormWordService {

	/**
	 * 获取新的常用词分类编码
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getEmrTermCateCode() throws BizException {
		IBdSrvQryService bdSrvQryService = ServiceFinder.find(IBdSrvQryService.class);
		return bdSrvQryService.getEmrTermCateCode();
	}
}
