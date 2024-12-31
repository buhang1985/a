package iih.ci.ord.s.ems.ip.ems.icons;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dws.ip.ems.d.EmsConsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class EmsIConsValidate extends BaseIpEmsValidate{

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException  {

		ErrorEmsList errList = super.viewModelValidate(objEms, ctx);
		for (Object objItem : objEms){
			OrderListViewDTO viewDTO=(OrderListViewDTO)objItem;
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsConsViewDTO emsConsDto=(EmsConsViewDTO)objItem;
				List<String> errorlist=new ArrayList<String>();
				if(CiOrdUtils.isEmpty(emsConsDto.getExtInfoList())){
					errorlist.add("请录入协诊方！");
				}
				if(errorlist.size() > 0){
					errList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errorlist));
				}
			}
		}
		return errList;
	}
}
