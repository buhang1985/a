package iih.ci.ord.s.ems.ip.ems.transdept;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dws.ip.ems.d.EmsTransDeptViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class EmsTransDeptValidate extends BaseIpEmsValidate {

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException  {
		ErrorEmsList errList = super.viewModelValidate(objEms, ctx);
		for (Object objItem : objEms){
			OrderListViewDTO viewDTO=(OrderListViewDTO)objItem;
			List<String> errorlist=new ArrayList<String>();
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsTransDeptViewDTO emsTreatDto = (EmsTransDeptViewDTO)objItem;
				
				if(emsTreatDto.getId_dep_to()==ctx.getId_dep_or() && emsTreatDto.getId_dep_nur_to()==ctx.getId_dep_ns()){
					errorlist.add("目标科室、目标病区不能与原科室、原病区相同！");
				}
			}else{
				if(CiOrdUtils.isEmpty(viewDTO.getId_extend())){
					errorlist.add(String.format("【%s】目标科室为空！", viewDTO.getName_srv()));
				}
			}
			if(errorlist.size() > 0){
				errList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errorlist));
			}
		}
		return errList;
	}
}
