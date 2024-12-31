package iih.en.pv.custom.s;

import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.custom.d.EnResultOutParam;
import iih.en.pv.custom.i.IEnIpCustomService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 就诊住院客开实现基类
 * 
 * @author liubin
 *
 */
public class EnIpCustomBaseService implements IEnIpCustomService {
	
	/***
	 * @Description:就诊账户客开处理
	 * @author fanlq
	 * @param balanceDTOList
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handleBalanceDTO(BalanceDTO[] balanceDTOs) throws BizException{
		return true;
	}
	/**
	 * 住院医生站患者列表数据处理
	 * 
	 * @param pats
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handleIpPatients(PatientsDTO[] pats) throws BizException {
		return true;
	}
	/**
	 * 根据医保设置医疗付费方式
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnResultOutParam<UdidocDO> getPayMethodByHp(EnHpPatCaInParamsDTO inParam) throws BizException {
		EnResultOutParam<UdidocDO> result = new EnResultOutParam<UdidocDO>();
		result.setFg_deal(FBoolean.FALSE);
		return result;
	}

}
