package iih.sc.apt.out.i;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约域对外部第三方接口
 * @author yzh
 *
 */
public interface ISc4OutThirdCmdService {
	
	/**
	 * 医技预约 (与第三方调用共同方法)
	 * @param mtresdto
	 * @param appdto
	 * @param fg_out 第三方标识
	 * @return
	 * @throws BizException
	 */
	public FMap saveMtAptPub(MtResDTO resDTO, MtAppDTO appDTO, String sd_sctp, FBoolean fg_out) throws BizException;
}
