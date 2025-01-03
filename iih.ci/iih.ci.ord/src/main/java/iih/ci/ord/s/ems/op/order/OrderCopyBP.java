package iih.ci.ord.s.ems.op.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.op.order.copy.OrderBaseCopyBP;
import iih.ci.ord.s.ems.op.order.copy.OrderCopyFactory;
import iih.ci.ord.s.external.obtain.bp.bl.GetArrearageCheckBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱复制
 * 
 * @author Young
 *
 */
public class OrderCopyBP implements IOrderCopyBP {
	protected OrderCopyFactory factory;
	public OrderCopyBP(){
		this.factory  = new OrderCopyFactory();
	}
	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		
		Context.get().setAttribute("CiEnContextDTO", ctx);
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

		// 获得医嘱集合
		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().findByBIds(lstIdors.toArray(new String[lstIdors.size()]),
				FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(ciors)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		//预交金欠费校验
		arrearageCheck(ctx, ciors);
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		lstIdors.clear();
		
		for (CiOrderDO cior : ciors) {
			if(CiOrdUtils.isIpWf(ctx.getCode_entp())){
				lstCiOrderDOs.add(cior);
				lstIdors.add(cior.getId_or());
			}else{
//				if(ICiDictCodeConst.SD_SU_CANCEL.equals(cior.getSd_su_or()) && FBoolean.TRUE.equals(cior.getFg_sign())
//						&& FBoolean.TRUE.equals(cior.getFg_canc()) && FBoolean.FALSE.equals(cior.getFg_uncancelable())
//						&& (ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getSd_su_bl())
//								|| ICiDictCodeConst.SD_SU_BL_REFOUND.equals(cior.getSd_su_bl()))) {
					lstCiOrderDOs.add(cior);
					lstIdors.add(cior.getId_or());
//				}
			} 
		}

		if (lstCiOrderDOs.size() < 1) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		Map<String, List<String>> mapIdors = factory.getMapIdors(lstCiOrderDOs.toArray(new CiOrderDO[] {}));

		rstDTO.setDocument(new FArrayList());
		for (String key : mapIdors.keySet()) {
			OrderBaseCopyBP bp = factory.getOrderCopyBP(key);
			OrderRstDTO singleRst = bp.copy(mapIdors.get(key).toArray(new String[] {}), arg.getExtension(),arg.getDt_effe());
			
			String messageInfo = rstDTO.getMessageInfo();
			messageInfo=((StringUtils.isEmpty(messageInfo)||"null".equals(messageInfo)?"":messageInfo)+
					(StringUtils.isEmpty(singleRst.getMessageInfo()) ? "" : singleRst.getMessageInfo()));
			
			rstDTO.setMessageInfo(messageInfo);
			rstDTO.setIsSuccess(new FBoolean((rstDTO.getIsSuccess()==null||FBoolean.TRUE.equals(rstDTO.getIsSuccess()))&&FBoolean.TRUE.equals(singleRst.getIsSuccess())));
			if (singleRst.getDocument() != null && singleRst.getDocument().size() > 0) {
			    rstDTO.getDocument().addAll(singleRst.getDocument());
			}
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
			if(singleErrorMap2 != null && singleErrorMap2.containsKey("RelSrvMessageList")){
				FMap2 map=(FMap2)singleErrorMap2.get("RelSrvMessageList");
				FMap2 extension2=rstDTO.getExtension();
				if(extension2==null) {
					extension2=new FMap2();
					rstDTO.setExtension(extension2);
				}
				extension2.put("RelSrvMessageList", map);
			}
		}
		return rstDTO;
	}
	
	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		
		Context.get().setAttribute("CiEnContextDTO", ctx);
		// TODO Auto-generated method stub
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

		// 获得医嘱集合
		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().findByBIds(lstIdors.toArray(new String[lstIdors.size()]),
				FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(ciors)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		//预交金欠费校验
		arrearageCheck(ctx, ciors);
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		lstIdors.clear();
		
		for (CiOrderDO cior : ciors) {
			if(CiOrdUtils.isIpWf(ctx.getCode_entp())){
				lstCiOrderDOs.add(cior);
				lstIdors.add(cior.getId_or());
			}else{
				if(ICiDictCodeConst.SD_SU_CANCEL.equals(cior.getSd_su_or()) && FBoolean.TRUE.equals(cior.getFg_sign())
						&& FBoolean.TRUE.equals(cior.getFg_canc()) && FBoolean.FALSE.equals(cior.getFg_uncancelable())
						&& (ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getSd_su_bl())
								|| ICiDictCodeConst.SD_SU_BL_REFOUND.equals(cior.getSd_su_bl()))) {
					lstCiOrderDOs.add(cior);
					lstIdors.add(cior.getId_or());
				}
			} 
		}

		if (lstCiOrderDOs.size() < 1) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		Map<String, List<String>> mapIdors = factory.getMapIdors(lstCiOrderDOs.toArray(new CiOrderDO[] {}));

		for (String key : mapIdors.keySet()) {
			OrderBaseCopyBP bp = factory.getOrderCopyBP(key);
			OrderRstDTO singleRst = bp.addExtra(mapIdors.get(key).toArray(new String[] {}),arg.getDt_effe());
			
			String messageInfo = rstDTO.getMessageInfo();
			messageInfo=((StringUtils.isEmpty(messageInfo)||"null".equals(messageInfo)?"":messageInfo)+singleRst.getMessageInfo());
			
			rstDTO.setMessageInfo(messageInfo);
			rstDTO.setIsSuccess(new FBoolean((rstDTO.getIsSuccess()==null||FBoolean.TRUE.equals(rstDTO.getIsSuccess()))&&FBoolean.TRUE.equals(singleRst.getIsSuccess())));
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
			
			if(singleErrorMap2 != null && singleErrorMap2.containsKey("RelSrvMessageList")){
				FMap2 map=(FMap2)singleErrorMap2.get("RelSrvMessageList");
				FMap2 extension2=rstDTO.getExtension();
				if(extension2==null) {
					extension2=new FMap2();
					rstDTO.setExtension(extension2);
				}
				extension2.put("RelSrvMessageList", map);
			}
		}
		return rstDTO;
	}
	/**
	 * 预交金欠费校验
	 * @param ctx
	 * @param ciors
	 */
	protected void arrearageCheck(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		
	}
}
