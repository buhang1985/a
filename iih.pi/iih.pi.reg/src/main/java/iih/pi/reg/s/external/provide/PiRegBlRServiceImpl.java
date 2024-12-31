package iih.pi.reg.s.external.provide;

import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.reg.i.external.provide.IPiRegBlRService;
import iih.pi.reg.i.external.provide.IPiRegBlService;
import iih.pi.reg.s.external.provide.bp.GetCardTpByPatCardIdBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 患者注册提供给费用域的对外接口实现
 * 
 * @author hao_wu 2018-6-8
 *
 */
@Service(serviceInterfaces={IPiRegBlService.class, IPiRegBlRService.class}, binding=Binding.JSONRPC)
public class PiRegBlRServiceImpl implements IPiRegBlService, IPiRegBlRService {

	@Override
	public String updatePatInfo(String inputParam) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据患者卡id查询卡类型
	 * @param patcardId
	 * @return 卡类型
	 * @author ly 2018/07/12
	 */
	@Override
	public PiPatCardTpDO findCardTpByPatCardId(String patcardId) throws BizException{
		GetCardTpByPatCardIdBP bp = new GetCardTpByPatCardIdBP();
		return bp.exec(patcardId);
	}
}
