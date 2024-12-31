package iih.en.pv.custom.i;

import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 就诊门诊客开类
 * 
 * @author liubin
 *
 */
public interface IEnOpCustomService {
	/**
	 * 换患者处理
	 * 
	 * @param opRegPatDTO
	 * @return
	 * @throws BizException
	 */
	public boolean handleChangePat(OpRegPatDTO opRegPatDTO) throws BizException;
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	public boolean handleErRegist(RegInfoDTO regInfo) throws BizException;
	/**
	 * 急诊退号处理
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public boolean handleErRegistCanc(String entId) throws BizException;
	/**
	 * 组装ie挂号集成平台消息
	 * 
	 * @param obj
	 * @return
	 * @throws BizException
	 */
	public boolean handleWrapOpRegist4IeObj(Object obj) throws BizException;
}
