package iih.sfda.aer.i;

import iih.sfda.aer.dto.sfdaaerinfodto.d.SfdaEvInfoDTO;
import iih.sfda.aer.dto.sfdaevsumryinfo.d.SfdaEvSumryInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface ISfdaAerMaintanceService {

	/**
	 * 不良事件上报保存
	 * 
	 * @param sfdaEvInfoDTO
	 * @param fullClassName
	 * @return
	 * @throws BizException
	 * @author guo.xiao
	 */
	public abstract SfdaEvInfoDTO saveAerEventReport(SfdaEvInfoDTO sfdaEvInfoDTO, String fullClassName) throws BizException;

	/**
	 * 删除事件报告
	 * 
	 * @param SfdaEvSumryInfoDTO
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean deleteAerEventReport(SfdaEvSumryInfoDTO SfdaEvSumryInfoDTO) throws BizException;
}
