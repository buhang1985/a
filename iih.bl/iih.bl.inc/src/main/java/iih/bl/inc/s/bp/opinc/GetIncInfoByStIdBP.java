package iih.bl.inc.s.bp.opinc;

import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.s.oldbp.AssIncInfoBP;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取结算发票数据（不重新获取发票号）
 * @author wq.li 2019年1月2日
 *
 */
public class GetIncInfoByStIdBP {

	/**
	 * 获取结算发票数据（不重新获取发票号）
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String stId)throws BizException{
		if (StringUtil.isEmpty(stId))
			throw new BizException("传入的结算信息为空！");
		// 1、打印发票
		IBlincoepRService iblincService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] incOepAggDo = iblincService.find(" id_stoep ='" + stId + "'", "", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(incOepAggDo))
			throw new BizException("未找到发票数据！");

		// 2、找到结算信息
		IBlstoepRService rService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDo = rService.findById(stId);
		// 2、组装实际的发票数据源
		AssIncInfoBP bp = new AssIncInfoBP();
		return bp.exec(stOepDo, incOepAggDo);
	}
}
