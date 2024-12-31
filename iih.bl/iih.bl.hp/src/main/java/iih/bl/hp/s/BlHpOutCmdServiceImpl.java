package iih.bl.hp.s;

import iih.bl.hp.i.IBlHpOutCmdService;
import iih.bl.hp.s.bp.IpUpdteAfterChangeHpIdentityBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医保对外命令服务
 * @author yankan
 * @since 2017-08-31
 *
 */
@Service(serviceInterfaces={IBlHpOutCmdService.class}, binding=Binding.JSONRPC)
public class BlHpOutCmdServiceImpl implements IBlHpOutCmdService {

	/**
	 * 医保身份转换后更新数据
	 * @param entId 就诊id
	 * @throws BizException
	 * @author ly 2018/10/05
	 */
	@Override
	public void updteAfterChangeHpIdentity(String entId) throws BizException{
		IpUpdteAfterChangeHpIdentityBP bp = new IpUpdteAfterChangeHpIdentityBP();
		bp.exec(entId);
	}
}
