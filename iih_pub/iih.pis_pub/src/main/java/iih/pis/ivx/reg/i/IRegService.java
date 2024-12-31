package iih.pis.ivx.reg.i;

import javax.servlet.http.HttpServletRequest;

import iih.pis.ivx.reg.d.RegResultBean;
import xap.mw.core.data.BizException;

public interface IRegService {
	
	/**
	 * 患者注册
	 * @param name
	 * @param type
	 * @param code
	 * @param sdCode
	 * @param mob
	 * @return
	 * @throws BizException
	 */
	public RegResultBean register(String name, String type, String code, String sdCode, String mob) throws BizException;
	/**
	 * 患者绑定
	 * @param name
	 * @param type
	 * @param code
	 * @param sdCode
	 * @param mob
	 * @param openid
	 * @param rel
	 * @return
	 * @throws BizException
	 */
	public RegResultBean bind(String name, String type, String code, String sdCode, String mob, String openid, Integer rel) throws BizException;
	
	/**
	 * 职工绑定
	 * @param request
	 * @throws BizException
	 */
	public RegResultBean staffRegister(HttpServletRequest request) throws BizException;


	/**
	 * 职工绑定
	 * @param request
	 * @throws BizException
	 */
	public RegResultBean trainRegister(HttpServletRequest request) throws BizException;

}
