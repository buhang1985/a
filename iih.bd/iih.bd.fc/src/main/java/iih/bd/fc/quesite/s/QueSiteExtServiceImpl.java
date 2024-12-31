package iih.bd.fc.quesite.s;

import iih.bd.fc.quesite.bp.QueSiteExtBp;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQueSiteExtService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 就诊队列工作点扩展接口服务实现
 * @author Liu Bin
 *
 */
@Service(serviceInterfaces={IQueSiteExtService.class}, binding=Binding.JSONRPC)
public class QueSiteExtServiceImpl implements IQueSiteExtService {

	@Override
	public void stopQueSite(QueSiteDO queSite) throws BizException {
		QueSiteExtBp bp = new QueSiteExtBp();
		bp.stopQueSite(queSite);
	}

	@Override
	public void startQueSite(QueSiteDO queSite) throws BizException {
		QueSiteExtBp bp = new QueSiteExtBp();
		bp.startQueSite(queSite);
	}
	/**
	 * 登陆工作站点
	 * @param quesiteId 工作站点id
	 * @param empId 人员id
	 * @throws BizException
	 */
	public void login(String quesiteId,String empId) throws BizException{
		QueSiteExtBp bp = new QueSiteExtBp();
		bp.login(quesiteId, empId);
	}
	/**
	 * 退出工作点
	 * @param quesiteId 工作点
	 * @throws BizException
	 */
	public void logout(String quesiteId) throws BizException{
		QueSiteExtBp bp = new QueSiteExtBp();
		bp.logout(quesiteId);
	}
}
