package iih.pi.reg.s;

import xap.mw.core.data.BizException;
import iih.pi.reg.i.IPiPatInfoUpdateService;
import iih.pi.reg.s.ws.PatBindBJHPWSBP;
import iih.pi.reg.s.ws.PatWriteCurAddrWSBP;

/**
 * 患者信息更新用webservice
 * @author ly 2018/01/06
 *
 */
public class PiPatInfoUpdateServiceImpl implements IPiPatInfoUpdateService {

	/**
	 * 患者自费转北京医保
	 * @param patCode 患者编码
	 * @param cardNo 卡号
	  * @return 0:成功</br>
	 *         -1:失败,参数为空 </br>
	 *         -2:失败,医保卡号不符合规则 </br>
	 *         -3:患者不存在</br>
	 *         -4:失败,患者不是自费
	 * @throws BizException
	 */
	@Override
	public Integer patBindBJHP(String patCode, String cardNo) throws BizException {
		PatBindBJHPWSBP bp = new PatBindBJHPWSBP();
		return bp.exec(patCode, cardNo);
	}

	/**
	 * 写入患者现住址接口
	 * @param patCode 患者编码
	 * @param admDivCode 区县码
	 * @param street 街道(可空)
	 * @return 0:成功 -1:失败参数为空 -2:行政区划不存在 -3:患者不存在
	 * @throws BizException
	 */
	@Override
	public Integer writeCurrentAddress(String patCode, String admDivCode, String street) throws BizException {
		PatWriteCurAddrWSBP bp = new PatWriteCurAddrWSBP();
		return bp.exec(patCode, admDivCode, street);
	}
}
