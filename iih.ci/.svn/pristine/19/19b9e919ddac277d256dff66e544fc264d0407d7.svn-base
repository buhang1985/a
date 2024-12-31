package iih.ci.preop.imp.bp.sign;

import java.util.List;

import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.preop.imp.dto.TsOrIpOrAggDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class PreIpAfterImportSignBP {
	/**
	 * 自动签署
	 * @param ctx
	 * @param orderIdList
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	public SignResult exec(CiEnContextDTO ctx, List<TsOrIpOrAggDTO> tsIpAggDTOs) throws BizException {
		// 根据参数判断是否需要自动签署
		String param = ParamsetQryUtil.getParaString(ctx.getId_org(), "CIOR0806");
		if (!"10".equals(param)) {
			return null;
		}
		
		FArrayList orderIdList = new FArrayList();
		FMap2 signMap = new FMap2();
		for (TsOrIpOrAggDTO item : tsIpAggDTOs) {
			orderIdList.add(item.getId_or());
			signMap.put(item.getId_or(), item);
		}
		signMap.put("preImportAutoSign", new FBoolean(true));
		// 组装参数
		OrderOperateDTO operateDTO = new OrderOperateDTO();
		operateDTO.setExtension(signMap);
		operateDTO.setEnContext(ctx);
		operateDTO.setDocument(orderIdList);
		String[] orderIds = new String[orderIdList.size()];
		for (int i = 0; i < orderIds.length; i++) {
			orderIds[i] = (String) orderIdList.get(i);
		}
		// 调用签署接口
		ValidateRtnInfoDTO rst = ServiceFinder.find(ICiOrdMaintainService.class).ciOrderSign_TL(orderIds, ctx, false, operateDTO);
		if (rst.getScenedatum() != null && rst.getScenedatum().get("checkResult") != null) {
			return new SignResult(false, rst.getScenedatum().get("checkResult").toString());
		}
		FMap2 rtnvalue = rst.getRtnvalue();
		if (rtnvalue != null && rtnvalue.containsKey("Fail")) {
		    FBoolean failed = (FBoolean) rtnvalue.get("Fail");
		    if (failed != null && !failed.booleanValue()) {
		        return new SignResult(false, null);
		    }
		}
		return new SignResult(true, null);
	}
}
