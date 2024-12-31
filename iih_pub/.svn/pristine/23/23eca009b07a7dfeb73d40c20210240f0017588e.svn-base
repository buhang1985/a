package iih.en.pv.out.i;

import java.util.Map;

import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 为执行提供接口（移动护理）
 * 
 * @author jizb
 *
 */
public interface IEn4MbService {

	/**
	 * 入科服务
	 * 
	 * @param endepDTO 一条记录患者信息的入科DTO
	 * @return boolean 反应是否入科成功
	 * @throws BizException
	 */
	boolean enterDep(EnDepDTO enDepDTO) throws BizException;
	
	/**
	 * 转科转入申请确认
	 * 
	 * @param patDTO 申请患者
	 * @param endepDTO 入科信息
	 * @throws BizException 
	 */
	void cfmTransDepApp(TransDepPatDTO patDTO,EnDepDTO endepDTO) throws BizException;
	
	/**
	 * 转科转出确认
	 * 
	 * @param patDTO 患者信息
	 * @throws BizException 
	 */
	Integer applyTransDep(TransDepPatDTO[] patDTO) throws BizException;
	
	/**
	 * 出科
	 * @param appDTO 出院申请DTO
	 * @throws BizException
	 */
	void leaveHos(LvHosAppDTO appDTO) throws BizException;
	
	/**
	 * 查询出院检查项
	 * 
	 * @param idEnts 就诊ID
	 * @return
	 * @throws BizException
	 */
	LvHosAppDTO[] checkApp(String[] idEnts) throws BizException;
	
	/**
	 * 转科转出前校验
	 * 
	 * @param idEnt
	 * @return
	 */
	Map<String, Boolean> checkTransOut(String idEnt) throws BizException ;
}
