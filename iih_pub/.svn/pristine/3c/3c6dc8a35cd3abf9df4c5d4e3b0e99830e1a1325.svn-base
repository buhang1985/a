package iih.mi.itf2.util;

import iih.mi.itf2.dto.MiResultOutParam;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 返回值校验及包装工具
 * @author ly
 *
 */
public class MiResultUtil {
	
	/**
	 * 校验返回值
	 * @param rlt
	 * @throws BizException
	 */
	public static <T extends BaseDTO> void check(MiResultOutParam<T> rlt) throws BizException{
		if(FBoolean.TRUE.equals(rlt.getFg_deal()) && FBoolean.FALSE.equals(rlt.getFg_HpSuccess())){
			throw new BizException(rlt.getErrorMsg());
		}
	}
	
	/**
	 * 包装返回值
	 * @param rlt
	 * @throws BizException
	 */
	public static <T extends BaseDTO> void wrap(MiResultOutParam<T> rlt) throws BizException{
		rlt.wrap();
	}

	/**
	 * 校验及包装返回值
	 * @param rlt
	 * @throws BizException
	 */
	public static <T extends BaseDTO> void checkAndWrap(MiResultOutParam<T> rlt) throws BizException{
		check(rlt);
		wrap(rlt);
	}
}
