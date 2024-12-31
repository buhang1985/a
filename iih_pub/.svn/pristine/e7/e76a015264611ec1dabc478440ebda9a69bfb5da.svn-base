package iih.sc.apt.out.i;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import xap.mw.core.data.BizException;
/**
 * 预约域对患者管家接口
 * @author renying
 *
 */
public interface ISc4PisCmdService {
	/**
	 * 保存医技预约信息
	 * 
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	public MtResDTO saveMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException;
	
	/**
	 * 保存医技预约信息
	 * 
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	public MtResDTO saveManualMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException;
	
	/**
	 * 取消医技预约
	 * 
	 * @param appdto
	 * @throws BizException
	 */
	public void cancelMtApt(MtAppDTO appdto) throws BizException ;
}
