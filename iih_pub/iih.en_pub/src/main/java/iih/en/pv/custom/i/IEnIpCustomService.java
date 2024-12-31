package iih.en.pv.custom.i;

import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.custom.d.EnResultOutParam;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;
import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 就诊住院客开接口
 * 
 * @author liubin
 *
 */
public interface IEnIpCustomService {
	
	/***
	 * @Description:就诊账户客开处理
	 * @author fanlq
	 * @param balanceDTOList
	 * @return
	 * @throws BizException
	 */
	public abstract boolean handleBalanceDTO(BalanceDTO[] balanceDTOs) throws BizException;
	/**
	 * 住院医生站患者列表数据处理
	 * 
	 * @param pats
	 * @return
	 * @throws BizException
	 */
	public abstract boolean handleIpPatients(PatientsDTO[] pats) throws BizException;
	/**
	 * 根据医保设置医疗付费方式
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public abstract EnResultOutParam<UdidocDO> getPayMethodByHp(EnHpPatCaInParamsDTO inParam) throws BizException;
}
