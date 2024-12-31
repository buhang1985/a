package iih.ci.ord.s.ems.ip.ems.ris;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BizException;

/**
 * 检查医疗单校验逻辑
 * 
 * @author Young
 *
 */
public class EmsRisValidate extends BaseIpEmsValidate {

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		ErrorEmsList errorList = super.viewModelValidate(objEms, ctx);
		for (Object objModel : objEms) {
			OrderListViewDTO viewDTO = (OrderListViewDTO) objModel;
			List<String> errors = new ArrayList<String>();
			if (CiOrdUtils.isTrue(viewDTO.getFg_set())) {
				boolean hasItems = false;
				for (Object obj : viewDTO.getExtInfoList()) {
					EmsRisViewItemDTO itemDto = (EmsRisViewItemDTO) obj;
					if (!hasItems && CiOrdUtils.isTrue(itemDto.getFg_check())) {
						hasItems = true;
					}
				}
				if (!hasItems) {
					errors.add(String.format("【%s】套内项目为空！", viewDTO.getName_srv()));
				}
			}
			if (OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())) {
				//EmsRisViewDTO emsRisViewDTO = (EmsRisViewDTO) objModel;

				// if (CiOrdUtils.isEmpty(emsRisViewDTO.getId_pps())) {
				// errors.add(String.format("【%s】检查目的为空！",
				// emsRisViewDTO.getName_srv()));
				// }
				// if (StringUtil.isEmpty(emsRisViewDTO.getId_di())) {
				// errors.add(String.format("【%s】临床诊断为空！",
				// emsRisViewDTO.getName_srv()));
				// }
			}
			if (errors.size() > 0) {
				errorList.add(new ErrorEmsDTO(((OrderListViewDTO) objEms[0]).getCode_or(),
						((OrderListViewDTO) objEms[0]).getName_srv(), errors));
			}
		}
		return errorList;
	}
}
