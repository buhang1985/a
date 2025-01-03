package iih.en.comm.custom;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.custom.d.EnResultOutParam;
import iih.en.pv.custom.i.IEnIpCustomService;
import iih.en.pv.custom.s.EnIpCustomBaseService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 就诊住院客开接口调用帮助类
 * 
 * @author liubin
 *
 */
public class EnIpCustomServiceUtils {
	
	/***
	 * @Description:就诊账户客开处理
	 * @author fanlq
	 * @param balanceDTOs
	 * @return
	 * @throws BizException
	 */
	public static boolean handleBalanceDTO(BalanceDTO[] balanceDTOs) throws BizException{
		if(EnValidator.isEmpty(balanceDTOs))
			return true;
		long b = System.currentTimeMillis();
		boolean result = getServices().handleBalanceDTO(balanceDTOs);
		long e = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo(String.format("患者就诊账户-客开查询自定义信息耗时:%s", e -b));
		return result;
	}
	/**
	 * 住院医生站患者列表数据处理
	 * 
	 * @param pats
	 * @return
	 * @throws BizException
	 */
	public static boolean handleIpPatients(PatientsDTO[] pats) throws BizException {
		if(EnValidator.isEmpty(pats))
			return true;
		long b = System.currentTimeMillis();
		boolean result = getServices().handleIpPatients(pats);
		long e = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo(String.format("住院患者列表-客开查询自定义信息耗时:%s", e -b));
		return result;
	}
	/**
	 * 根据医保设置医疗付费方式
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO getPayMethodByHp(EnHpPatCaInParamsDTO inParam) throws BizException{
		EnResultOutParam<UdidocDO> result = getServices().getPayMethodByHp(inParam);
		if(result == null)
			return null;
		if(!FBoolean.TRUE.equals(result.getFg_deal()))
			return null;
		return result.getData();
	}
	/**
	 * 获取所有服务实现
	 * 
	 * @return
	 */
	private static IEnIpCustomService getServices(){
		IEnIpCustomService serv = ServiceFinder.find(IEnIpCustomService.class);
		return serv != null ? serv : new EnIpCustomBaseService();
	}
}
