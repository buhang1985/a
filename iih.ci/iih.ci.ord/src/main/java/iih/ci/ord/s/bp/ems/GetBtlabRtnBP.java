package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ie.ICiIEMainService;
import iih.ci.ord.iemsg.d.IELisQryItemInDTO;
import iih.ci.ord.iemsg.d.IELisQryOutDTO;


import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;

public class GetBtlabRtnBP {
	
	/**
	 * 从IE平台取回检验结果值
	 * @param ordbtitemlist
	 * @param ctx
	 * @throws BizException
	 */
	public FArrayList exec(CiEnContextDTO ctx,FArrayList ordbtitemlist) throws BizException{
		ICiIEMainService ieMgrService=ServiceFinder.find(ICiIEMainService.class);
		if(ieMgrService==null)return null;
		FArrayList paramList=new FArrayList();
		for(Object btitemdto:ordbtitemlist){
			OrdApBtViewItemDO btitem=(OrdApBtViewItemDO)btitemdto;
			IELisQryItemInDTO ieitemdto=new IELisQryItemInDTO();
			if(ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) 
					|| ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW)
					|| ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID)){
				ieitemdto.setDomainid("01");
			}else if(ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
					|| ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)){
				ieitemdto.setDomainid("02");
			}			
			ieitemdto.setPatientid(ctx.getCode_pat());
			ieitemdto.setTestdetailitemcode(btitem.getCode_srv());
			ieitemdto.setHospitalcode(ctx.getCode_org());
			ieitemdto.setHospitalname(ctx.getName_org());
			paramList.add(ieitemdto);
		}
		IELisQryOutDTO rtndto=ieMgrService.ieLisQry(paramList);
		if(rtndto==null && rtndto.getItems().size()<1)return null;
		FArrayList2 rtnitemlist=rtndto.getItems();
		for(Object rtnitemdto:rtnitemlist){
			IELisQryItemInDTO rtnitem=(IELisQryItemInDTO)rtnitemdto;
			for(Object btitemdto:ordbtitemlist){
				OrdApBtViewItemDO btitem=(OrdApBtViewItemDO)btitemdto;
				if(btitem.getCode_srv().equals(rtnitem.getTestdetailitemcode())){
					btitem.setVal_restrptlab(rtnitem.getTestresult());
					break;
				}
			}
		}
		return ordbtitemlist;
	}

}
