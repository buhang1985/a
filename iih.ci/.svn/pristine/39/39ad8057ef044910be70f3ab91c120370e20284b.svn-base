package iih.ci.ord.s.ems.ip.ems.transdept;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.dws.ip.ems.d.EmsTransDeptViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

public class EmsTransDeptLoadBP extends BaseIpEmsLoadBP{
	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = this.orderPakageInfoArrayFrom(new String[] { arg.getId_or() });
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取医疗单信息失败！");
			rst.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { rst };
		}
		OrderPackageInfo opInfo = szOrderPackageInfo[0];
		EmsTransDeptViewDTO ems = modelFrom(ctx, opInfo);
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, ems);
		}
		//医疗单驱动
		ems.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		rst.setDocument(handleReturnDocument(ems));
		// 医疗单类型
		// rst.setEmsDriver(EmsType.COMMON.toString());
		return rsts;
	}
	public EmsTransDeptViewDTO modelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo) throws BizException {
		EmsTransDeptViewDTO emsTransDto=new EmsTransDeptViewDTO();
		OrdApTransDO tansdo=(OrdApTransDO)opInfo.getOrderAppSheetList().get(0);
		emsTransDto.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsTransDto);
		emsTransDto.setId_dep_to(tansdo.getId_dep_to()); 	//目标科室		 
		emsTransDto.setName_dep_to(tansdo.getName_dep_to());
		emsTransDto.setId_dep_nur_to(tansdo.getId_dep_nur_to()); 	//目标病区	
		emsTransDto.setName_dep_nur_to(tansdo.getName_dep_nur_to());
		emsTransDto.setDt_trans_apply(tansdo.getDt_trans_apply()); 	//转科申请时间	 	 	 	 				 	 			 	 	 	
		emsTransDto.setId_transreason(tansdo.getId_transreason()); 	    //转科申请原因	
		emsTransDto.setTransreason(tansdo.getTransreason());
		emsTransDto.setDes_or(opInfo.getOrderInfo().getDes_or()); 	        //备注
		return emsTransDto;
	}
}
