package iih.bl.comm.s.bp;

import iih.bl.comm.util.BlCodeUtils;
import xap.mw.core.data.BizException;

/**
 * 生成结算编码
 * @author ly 2019/08/02
 *
 */
public class BlCreateStCodeBP {

	/**
	 * 生成门诊结算编码
	 * @return
	 * @throws BizException
	 */
	public String createStOepCode() throws BizException{
		String code = BlCodeUtils.generateOepStCode();
		return code;
	}
}
