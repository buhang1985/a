package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 根据就诊id 获取结算发票数据（不重新获取发票号）
 * 
 * @author zhangxin 2019年1月2日
 *
 */
public class GetIncInfoByEntIdBP {

	/**
	 * 获取结算发票数据（不重新获取发票号）
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String entId) throws BizException {
		if (StringUtil.isEmpty(entId))
			throw new BizException("传入的就诊id为空！");
		//1 查询就诊对应的结算信息
		IBlstoepRService stoepSerivce = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOs = stoepSerivce.find(" id_ent ='"+entId+"' and (eu_sttp ='31' or eu_sttp='43') ", "",FBoolean.FALSE);
		if (ArrayUtil.isEmpty(blStOepDOs)) {
			throw new BizException("未找到就诊结算信息！");
		}
		List<BlIncItmVsTypeDTO> incDtoList = new ArrayList<BlIncItmVsTypeDTO>();
		for (BlStOepDO blStOepDO : blStOepDOs) {
			//2根据结算信息返回发票信息
			IBlincoepRService iblincService = ServiceFinder.find(IBlincoepRService.class);
			BlincoepAggDO[] incOepAggDo = iblincService.find(" id_stoep ='" + blStOepDO.getId_stoep() + "'", "",
					FBoolean.FALSE);
			
			if (ArrayUtil.isEmpty(incOepAggDo))
				throw new BizException("未找到发票数据！");
			// 3、组装实际的发票数据源
			AssIncInfoBP bp = new AssIncInfoBP();
			BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = bp.exec(blStOepDO, incOepAggDo);
			//添加到发票信息集合
			List<BlIncItmVsTypeDTO> list = Arrays.asList(blIncItmVsTypeDTOs);
			incDtoList.addAll(list);
		}
		return incDtoList.toArray(new BlIncItmVsTypeDTO[]{});
	}
}
