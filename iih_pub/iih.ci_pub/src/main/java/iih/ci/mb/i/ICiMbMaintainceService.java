package iih.ci.mb.i;

import xap.mw.core.data.BizException;

/**
 * 移动医生站修改服务
 * @author yankan
 * @since 2018-03-12
 *
 */
public interface ICiMbMaintainceService {
	/**
	 * 修改用户密码
	 * @param username 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public abstract UpadateUserPassResponse updateUserPassword(String username,String oldPassword,String newPassword) throws BizException;
}
