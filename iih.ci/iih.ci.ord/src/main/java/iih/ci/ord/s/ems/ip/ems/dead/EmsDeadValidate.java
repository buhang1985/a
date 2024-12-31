package iih.ci.ord.s.ems.ip.ems.dead;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dws.ip.ems.d.EmsDeadViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class EmsDeadValidate extends BaseIpEmsValidate{
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException  {
		ErrorEmsList errorList = super.viewModelValidate(objEms, ctx);
		for (Object obj : objEms) {
			OrderListViewDTO viewDTO=(OrderListViewDTO)obj;
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsDeadViewDTO emsDeadViewDTO = (EmsDeadViewDTO) obj;
				List<String> errors = new ArrayList<String>();
				if (errors.size() > 0){
					errorList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errors));
				}
			}
		}
		return errorList;
	}
}
