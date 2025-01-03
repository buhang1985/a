package iih.en.comm.custom;

import iih.en.pv.custom.i.IEnOpCustomService;
import iih.en.pv.custom.s.EnOpCustomBaseService;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊门诊客开接口调用帮助类
 * 
 * @author liubin
 *
 */
public class EnOpCustomServiceUtils {
	/**
	 * 换患者处理
	 * 
	 * @param opRegPatDTO
	 * @return
	 * @throws BizException
	 */
	public static boolean handleChangePat(OpRegPatDTO opRegPatDTO) throws BizException {
		return getServices().handleChangePat(opRegPatDTO);
	}
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	public static boolean handleErRegist(RegInfoDTO regInfo) throws BizException {
		return getServices().handleErRegist(regInfo);
	}
	/**
	 * 急诊挂号处理
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static boolean handleErRegistCanc(String entId) throws BizException {
		return getServices().handleErRegistCanc(entId);
	}
	/**
	 * 组装ie挂号集成平台消息
	 * 
	 * @param obj
	 * @return
	 * @throws BizException
	 */
	public static boolean handleWrapOpRegist4IeObj(Object obj) throws BizException {
		return getServices().handleWrapOpRegist4IeObj(obj);
	}
	/**
	 * 获取所有服务实现
	 * 
	 * @return
	 */
	private static IEnOpCustomService getServices(){
		IEnOpCustomService serv = ServiceFinder.find(IEnOpCustomService.class);
		return serv != null ? serv : new EnOpCustomBaseService();
	}
}
