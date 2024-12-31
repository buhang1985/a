package iih.ci.mb.s;

import iih.ci.mb.bp.UpdateUserPasswordBP;
import iih.ci.mb.i.ICiMbMaintainceService;
import iih.ci.mb.i.UpadateUserPassResponse;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 移动医生站维护服务
 * @author yankan
 * @since 2018-03-12
 *
 */
@Service(serviceInterfaces = {ICiMbMaintainceService.class}, binding = Binding.JSONRPC)
public class CiMbMaintainceServiceImpl implements ICiMbMaintainceService {
	/**
	 * 修改用户密码
	 * @param username 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public UpadateUserPassResponse updateUserPassword(String username,String oldPassword,String newPassword) throws BizException{
		UpdateUserPasswordBP updatePassBP = new UpdateUserPasswordBP();
		return updatePassBP.exec(username, oldPassword, newPassword);
	}
}
