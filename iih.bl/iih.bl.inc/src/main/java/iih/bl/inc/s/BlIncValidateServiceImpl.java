package iih.bl.inc.s;

import iih.bl.inc.i.IBlIncValidateService;
import iih.bl.inc.s.bp.validate.IsEcIncBP;
import iih.bl.inc.s.bp.validate.IsIncThisPCOrPsnBP;
import iih.bl.inc.s.bp.validate.IsPrintRedInc2BP;
import iih.bl.inc.s.bp.validate.IsPrintRedIncBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 发票域校验服务
 * @author ly 2018/04/04
 *
 */
@Service(serviceInterfaces={IBlIncValidateService.class}, binding=Binding.JSONRPC)
public class BlIncValidateServiceImpl implements IBlIncValidateService {

	/**
	 * 是否打印红冲发票
	 * @param entId 就诊ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yanglu
	 */
	@Override
	public FBoolean isPrintRedInc(String entId) throws BizException {
		IsPrintRedIncBP checkBP = new IsPrintRedIncBP();
		return checkBP.exec(entId);
	}
	
	/**
	 * 是否打印红冲发票
	 * @param hpId 医保产品id
	 * @param fgEnt 是否挂号发票
	 * @return 判断结果
	 * @throws BizException
	 * @author ly 2018/12/13
	 */
	@Override
	public FBoolean isPrintRedInc2(String hpId, FBoolean fgEnt) throws BizException{
		IsPrintRedInc2BP bp = new IsPrintRedInc2BP();
		return bp.exec(hpId, fgEnt);
	}
	
	/**
	 * 发票是否属于当前PC或者人员
	 * @param inccaId 票据分类id
	 * @param incno 发票号
	 * @return true:属于 false:不属于
	 * @throws BizException
	 * @author ly 2018/09/14
	 */
	@Override
	public FBoolean isIncThisPCOrPsn(String inccaId, String incno) throws BizException{
		IsIncThisPCOrPsnBP bp = new IsIncThisPCOrPsnBP();
		return bp.exec(inccaId, incno);
	}
	
	/**
	 * 判断结算对应的发票是否是电子发票
	 * @param stIds 结算id数组
	 * @param ecIncType 发票类型(1:门诊 2:住院)
	 * @return key：结算id value:FBoolean
	 * @throws BizException
	 * @author ly 2019/12/25
	 */
	@Override
	public FMap isEcInc(String[] stIds,String ecIncType) throws BizException{
		IsEcIncBP bp = new IsEcIncBP();
		return bp.exec(stIds, ecIncType);
	}
}
