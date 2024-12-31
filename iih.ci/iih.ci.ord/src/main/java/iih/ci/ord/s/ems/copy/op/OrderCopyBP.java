package iih.ci.ord.s.ems.copy.op;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.copy.i.IOrderCopy;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.copy.factory.BaseOrderCopyFactory;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class OrderCopyBP implements IOrderCopyBP {

	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		List<String> lstIdors = new ArrayList<String>();
		for (Object obj : paramList) {
			if (CiOrdUtils.isEmpty(obj))
				continue;
			lstIdors.add(obj.toString());
		}
		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		ICiorderRService orderAggService = ServiceFinder.find(ICiorderRService.class);
		CiorderAggDO[] aggs = orderAggService.findByIds(lstIdors.toArray(new String[0]),FBoolean.FALSE);
		if (aggs.length < 1) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		BaseOrderCopyFactory factory = BaseOrderCopyFactory.GetOrderCopyFactory(ctx.getCode_entp(), arg.getFuncCode());
		Map<String, List<CiorderAggDO>> mapAggs = factory.getMapAggs(aggs);

		for (String key : mapAggs.keySet()) {
			IOrderCopy bp = factory.getOrderCopyBP(key);
			bp.setOrderOperateDTO(arg);
			OrderRstDTO singleRst = bp.copy(ctx,mapAggs.get(key));
			
			String messageInfo = rstDTO.getMessageInfo();
			messageInfo=((StringUtils.isEmpty(messageInfo)||"null".equals(messageInfo)?"":messageInfo)+
					(StringUtils.isEmpty(singleRst.getMessageInfo()) ? "" : singleRst.getMessageInfo()));
			
			rstDTO.setMessageInfo(messageInfo);
			rstDTO.setIsSuccess(new FBoolean((rstDTO.getIsSuccess()==null||FBoolean.TRUE.equals(rstDTO.getIsSuccess()))&&FBoolean.TRUE.equals(singleRst.getIsSuccess())));
			rstDTO.setDocument(singleRst.getDocument());
			FMap2 singleErrorMap2 = singleRst.getExtension();
			if(singleErrorMap2 != null && singleErrorMap2.containsKey("errorEmsList")){
				if(rstDTO.getExtension() != null && rstDTO.getExtension().containsKey("errorEmsList")){
					FArrayList errorList = (FArrayList)rstDTO.getExtension().get("errorEmsList");
					errorList.addAll((FArrayList)singleErrorMap2.get("errorEmsList"));
				}else{
					FMap2 errorMap2 = new FMap2();
					errorMap2.put("errorEmsList",(FArrayList)singleErrorMap2.get("errorEmsList"));
					rstDTO.setExtension(errorMap2);
				}
			}
		}
		return rstDTO;
	
	}

	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
