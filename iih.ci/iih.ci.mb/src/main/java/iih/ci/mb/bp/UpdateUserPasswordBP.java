package iih.ci.mb.bp;

import iih.bd.base.validator.ParamValidator;
import iih.ci.mb.i.UpadateUserPassResponse;
import iih.ci.mb.utils.LogUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.permfw.rbac.userpassword.i.IUserPasswordManage;

/**
 * 修改用户密码
 * @author yankan
 * @since 2018-03-14
 *
 */
public class UpdateUserPasswordBP {
	/**
	 * 原密码不正确
	 */
	private static Integer ERROR_OF_OLD_PASS = 0; 
	/**
	 * 修改成功
	 */
	private static final Integer SUCCESS_OF_CHAGE = 1;
	/**
	 * 修改出错
	 */
	private static final Integer ERROR_OF_CHANGE = -1;
	/**
	 * 数据库出错请联系管理员
	 */
	private static final Integer ERROR_OF_DB = 2;
	/**
	 * 修改用户密码
	 * @param username 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public UpadateUserPassResponse exec(String username,String oldPassword,String newPassword) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("用户名", username);
		
		UpadateUserPassResponse response =new UpadateUserPassResponse();
		//1、验证旧密码
		IUserPasswordManage passManage = ServiceFinder.find(IUserPasswordManage.class);
		boolean isRightOldPass = passManage.checkUserPassWord(username, oldPassword);
		if(isRightOldPass){			
			try{
				//2、更新新密码
				passManage.changeUserPassWord(username, newPassword);
				response.setUpadateUserPassResult(SUCCESS_OF_CHAGE);
//			}catch(DbException dbException){
//				LogUtils.error("修改密码，数据库错误，具体信息：" + dbException.getMessage());
//				response.setUpadateUserPassResult(ERROR_OF_DB);
			}catch(Exception ex){
				response.setUpadateUserPassResult(ERROR_OF_CHANGE);
			}
		}else{
			response.setUpadateUserPassResult(ERROR_OF_OLD_PASS);
		}
		
		return response;
	}
}
