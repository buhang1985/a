package iih.bl.comm.util;

import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;

/**
 * 票据分类编码和id转换分类
 * @author hanjq
 *
 */
public class BlInccaParamUtil {
	
	/***
	 * 根据发票类型获取发票id
	 * @param code_incca
	 * @return
	 * @throws BizException
	 */
	public static String getIdIncca(String code_incca) throws BizException{
		if (IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(code_incca)) {
			return IBdInccaCodeConst.ID_OUTPATIENT_INVOICE;
		}
		//住院发票12
		if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(code_incca)){
			return IBdInccaCodeConst.ID_INHOS_INVOICE;
		}
		//门诊押金条21
		if(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT.equals(code_incca)){
			return IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
		}
		//住院押金条22
		if(IBdInccaCodeConst.CODE_INHOS_DEPOSIT.equals(code_incca)){
			return IBdInccaCodeConst.ID_INHOS_DEPOSIT;
		}
		//优惠套餐收据23
		if(IBdInccaCodeConst.CODE_DESIGNED_FUND.equals(code_incca)){
			return IBdInccaCodeConst.ID_DESIGNED_FUND;
		}
		//门诊挂号发票
		if(IBdInccaCodeConst.CODE_OUTPATREGIST_INVOICE.equals(code_incca)){
			return IBdInccaCodeConst.ID_OUTPATREGIST_INVOICE;
		}
		// 急诊留观押金条25
		if (IBdInccaCodeConst.CODE_ET_INVOICE.equals(code_incca)) {
			return IBdInccaCodeConst.ID_ET_INVOICE;
		}
		throw new BizException("未查询到对应类型的发票");
	}
	
	/**
	 * 判断是否是计算机模式（包含判断过滤条件）
	 * @param id_incca
	 * @return
	 * @throws BizException
	 */
	public static boolean isPc(String id_incca) throws BizException{
		String pcIncs = BlParams.BLINC0013();
		String hostId = Context.get().getClientHost();
		String idPc = null;
		if(BlParamValueConst.BLINC0012_PC.equals(BlParams.BLINC0012()) && 
				!StringUtil.isEmpty(pcIncs) && pcIncs.contains(id_incca)){
			idPc = BlParams.getRealPcId(hostId);
			if(StringUtil.isEmpty(idPc)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_NOPC_ALERT);
			}
			return true;				
		}
		return false;
	}
}
