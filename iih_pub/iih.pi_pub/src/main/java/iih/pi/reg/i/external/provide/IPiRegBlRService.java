package iih.pi.reg.i.external.provide;

import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import xap.mw.core.data.BizException;

/**
 * 患者注册提供给费用域的对外查询接口
 * 
 * @author hao_wu 2018-6-8
 *
 */
public interface IPiRegBlRService {

	/**
	 * 根据患者卡id查询卡类型
	 * 
	 * @param patcardId
	 * @return 卡类型
	 * @author ly 2018/07/12
	 */
	public abstract PiPatCardTpDO findCardTpByPatCardId(String patcardId) throws BizException;
}
