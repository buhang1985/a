package iih.pi.reg.i;

import xap.mw.core.data.BizException;

/**
 * 患者信息更新用webservice
 * @author ly 2018/01/06
 *
 */
public interface IPiPatInfoUpdateService {

	/**
	 * 患者自费转北京医保
	 * @param patCode 患者编码
	 * @param cardNo 卡号
	 * @return 0:成功 -1:失败参数为空 -2:失败医保卡号不符合规则 -3:患者不存在
	 * @throws BizException
	 */
	public abstract Integer patBindBJHP(String patCode,String cardNo) throws BizException;
	
	/**
	 * 写入患者现住址接口
	 * @param patCode 患者编码
	 * @param admDivCode 区县码
	 * @param street 街道(可空)
	 * @return 0:成功 -1:失败参数为空 -2:行政区划不存在 -3:患者不存在
	 * @throws BizException
	 */
	public abstract Integer writeCurrentAddress(String patCode,String admDivCode,String street) throws BizException;
}
