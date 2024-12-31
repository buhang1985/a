package iih.bl.cg.oep.s.bp;

import org.apache.commons.lang3.StringUtils;

import iih.bl.cg.service.s.bp.BLCiOrderToBlCgServiceImplBp;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 针对已经生成发票数据，但是未实际打印的场景 例如 1、挂号票，先挂号，后需如果需要再打发票 2、预交金，可以先结算，发票也可以后打
 * 3、以后场景，多次结算对应一张发票，例如体检
 * 
 * @author yangyang
 * @date 2018-05-29
 */
public class IncDataPrintNoIncnoBP {

	public BlIncItmVsTypeDTO[] exec(String strStKey) throws BizException {
		if (StringUtils.isEmpty(strStKey))
			throw new BizException("传入的结算信息为空！");
		// 1、打印发票
		IBlincoepRService iblincService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] incOepAggDo = iblincService.find(" id_stoep ='" + strStKey + "'", "", FBoolean.FALSE);

		if (incOepAggDo == null || incOepAggDo.length <= 0)
			throw new BizException("未找到发票数据！");

		// 2、找到结算信息
		IBlstoepRService rService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDo = rService.findById(strStKey);
		// 2、组装实际的发票数据源
		BLCiOrderToBlCgServiceImplBp bp = new BLCiOrderToBlCgServiceImplBp();
		return bp.assemblyIncInfoDtos(stOepDo, incOepAggDo);
	}
}
