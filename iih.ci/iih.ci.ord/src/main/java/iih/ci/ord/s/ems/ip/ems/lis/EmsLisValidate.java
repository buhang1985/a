package iih.ci.ord.s.ems.ip.ems.lis;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dws.ip.ems.d.EmsLisViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

/**
 * 检验申请单校验
 * @author HUMS
 *
 */
public class EmsLisValidate extends BaseIpEmsValidate {

	/**
	 * 医疗单有效性，并返回错误信息
	 */
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		ErrorEmsList errorEmsList = super.viewModelValidate(objEms, ctx);
		for (Object objModel : objEms) {
			OrderListViewDTO viewDTO=(OrderListViewDTO)objModel;
			List<String> errorList = new ArrayList<String>();
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsLisViewDTO lisdo = (EmsLisViewDTO) objModel;
				if (CiOrdUtils.isEmpty(lisdo.getId_samptp())) {
					errorList.add(String.format("【%s】标本类型为空！", lisdo.getName_srv()));
				}
//				if (StringUtil.isEmpty(lisdo.getId_di())) {
//					errorList.add(String.format("【%s】临床诊断为空！", lisdo.getName_srv()));
//				}
			}else{
				if (CiOrdUtils.isEmpty(viewDTO.getId_extend())) {
					errorList.add(String.format("【%s】标本类型为空！", viewDTO.getName_srv()));
				}
			}
			if (errorList.size() > 0) {
				errorEmsList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errorList));
			}
		}
		assert false : "没有处理返回值结果";
		return errorEmsList;
	}

}
