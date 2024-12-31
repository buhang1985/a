package iih.en.pv.custom.s;

import iih.en.pv.custom.i.IEnOpCustomService;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 就诊门诊客开实现类
 * 
 * @author liubin
 *
 */
public class EnOpCustomBaseService implements IEnOpCustomService {

	/**
	 * 换患者处理
	 * 
	 * @param opRegPatDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handleChangePat(OpRegPatDTO opRegPatDTO) throws BizException {
		return false;
	}
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handleErRegist(RegInfoDTO regInfo) throws BizException {
		return false;
	}
	/**
	 * 急诊退号处理
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handleErRegistCanc(String entId) throws BizException {
		return false;
	}
	/**
	 * 组装ie挂号集成平台消息
	 * 
	 * @param obj
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handleWrapOpRegist4IeObj(Object obj) throws BizException {
		return false;
	}

}
