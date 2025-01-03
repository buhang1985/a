package iih.pis.mbw.i;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.pis.mbw.dto.csssqappwrapdto.d.CssSqAppWrapDTO;
import iih.pis.mbw.dto.pismbwfocdocdto.d.PismbwFocdocDTO;
import iih.pis.mbw.dto.pismbwmakeaptdto.d.PismbwMakeaptDTO;
import iih.pis.mbw.dto.pismbwmedguidedto.d.PismbwMedGuideDTO;
import iih.pis.mbw.dto.pismbwuserdto.d.PismbwUserDTO;
import xap.mw.core.data.BizException;
import iih.pis.mbw.dto.pismbwpatdto.d.PismbwPatDTO;

@WebService
public interface IPisMbwMaintanceService {

	/**
	 * 用户注册
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PismbwUserDTO userRegister(@WebParam(name = "userDto") PismbwUserDTO userDto) throws BizException;

	/**
	 * 更新用户openid
	 * 
	 * @param openid
	 * @throws BizException
	 */
	public abstract void updateUserOpenid(String openid) throws BizException;

	/**
	 * 满意度调查问卷保存
	 * 
	 * @param cssSqAppWrapDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveCssTplPsqByRecId(@WebParam(name = "cssSqAppWrapDTO") CssSqAppWrapDTO cssSqAppWrapDTO)
			throws BizException;

	/**
	 * 添加患者
	 * 
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public abstract void addPatient(@WebParam(name = "patDto") PismbwPatDTO patDto) throws BizException;

	/**
	 * 用户登陆
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PismbwUserDTO userLogin(@WebParam(name = "userDto") PismbwUserDTO userDto) throws BizException;

	/**
	 * 更新患者
	 * 
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public abstract void updatePatient(@WebParam(name = "patDto") PismbwPatDTO patDto) throws BizException;

	/**
	 * 删除患者
	 * 
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public abstract void deletePatient(@WebParam(name = "id_mbw_pat") String id_mbw_pat) throws BizException;

	/**
	 * 用户关注医生
	 * 
	 * @param code_doc
	 * @param name_doc
	 * @throws BizException
	 */
	public abstract PismbwFocdocDTO userFocdoc(@WebParam(name = "code_doc") String code_doc,
			@WebParam(name = "name_doc") String name_doc) throws BizException;

	/**
	 * 预约门诊号
	 * 
	 * @param code_pat
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	public abstract PismbwMakeaptDTO makeApt(@WebParam(name = "code_pat") String code_pat,
			@WebParam(name = "id_sch") String id_sch) throws BizException;

	/**
	 * 取消关注医生
	 * 
	 * @param id_mbw_focdoc
	 * @return
	 * @throws BizException
	 */
	public abstract boolean userUnFocdoc(@WebParam(name = "id_mbw_focdoc") String id_mbw_focdoc) throws BizException;

	/**
	 * 就诊指南增删改
	 * @param guideDto
	 * @param status
	 * @return
	 * @throws BizException
	 */
	public abstract void medGuideCUD(@WebParam(name = "guideDto") PismbwMedGuideDTO guideDto,@WebParam(name = "status") int status) throws BizException;

	/**
	 * @Description: 取消注册
	 * @Author: chen.zhao
	 * @param userDto
	 * @throws BizException
	 * @date: 2020年4月20日
	 */
	public abstract void userCancelRegister(String id_user) throws BizException;

	/**
	 * @Description: 更新用户信息
	 * @Author: chen.zhao
	 * @param id_user
	 * @throws BizException
	 * @date: 2020年4月20日
	 */
	public abstract void userUpdateRegister(PismbwUserDTO userDto) throws BizException;

}
