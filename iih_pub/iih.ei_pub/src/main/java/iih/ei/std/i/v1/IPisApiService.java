package iih.ei.std.i.v1;


import iih.ei.std.d.v1.pis.patreg.d.PatRegDTO;
import iih.ei.std.d.v1.pis.pisreturn.d.PisReturnDTO;
import iih.ei.std.d.v1.pis.userreg.d.UserRegDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * @ClassName: IPeApiService
 * @Description: IIH体检标准对外接口
 * @author 聂利生
 * @date 2020年3月31日
 *
 */
public interface IPisApiService {

	/**
	 * 用户注册
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PisReturnDTO userRegister(UserRegDTO param) throws BizException;
	//取消注册
	public PisReturnDTO userCancelRegister(UserRegDTO param) throws BizException;
	//注册更新
	public PisReturnDTO userUpdateRegister(UserRegDTO param) throws BizException;

	/**
	 * 更新用户openid
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PisReturnDTO updateUserOpenid(UserRegDTO param) throws BizException;

	/**
	 * 添加患者
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PisReturnDTO addPatient(PatRegDTO param) throws BizException;
	
	/**
	 * 更新患者信息
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PisReturnDTO updatePatient(PatRegDTO param) throws BizException;

	/**
	 * 删除患者
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PisReturnDTO deletePatient(PatRegDTO param) throws BizException;
	
}
