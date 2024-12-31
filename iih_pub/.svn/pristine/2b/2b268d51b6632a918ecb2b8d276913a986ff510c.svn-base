package iih.sc.apt.out.i;

import iih.sc.apt.dto.d.ScAptMtDto;
import iih.sc.apt.out.ci.d.ScAptInfoDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import xap.mw.core.data.BizException;

/**
 * 为CI提供查询服务
 * 
 * 
 * @author liubin
 * 
 * 下午4:07:27
 */
public interface ISc4CiQryService {
	
	/**
	 * 
	 * 获取手术安排人员列表
	 * 
	 * @param id_or 医嘱id
	 * @return
	 * @throws BizException
	 */
	public ScAptOptEmpDTO[] getSCAptOptEmpList(String id_or) throws BizException;
	/**
	 * 
	 * 获取手术预约信息
	 * 
	 * @author liubin
	 * 
	 * @param id_or 医嘱id
	 * @return
	 * @throws BizException
	 */
	public ScAptInfoDTO getScAptOpt(String id_or) throws BizException;
	
	/**
	 * 根据医嘱id批量获取医技预约DO
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	public ScAptMtDto[] getAptByIdOrs(String[] idOrs) throws BizException;
}
