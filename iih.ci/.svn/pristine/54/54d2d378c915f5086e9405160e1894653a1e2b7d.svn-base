package iih.ci.ord.s.ems.ip.ems.pathgy;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.dws.ip.ems.d.EmsPathgyItemViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyViewDTO;
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

/**
 * 病理医疗单校验逻辑
 * @author Young
 *
 */
public class EmsPathgyValidate extends BaseIpEmsValidate {
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		ErrorEmsList eeList = super.viewModelValidate(objEms, ctx);
		for (Object obj : objEms) {
			OrderListViewDTO viewDTO=(OrderListViewDTO)obj;
			List<String> errorList = new ArrayList<String>();
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsPathgyViewDTO pathgydo = (EmsPathgyViewDTO) obj;
				if (CiOrdUtils.isEmpty((pathgydo.getId_samptp()))) {
					errorList.add(String.format("%s标本类型为空！", pathgydo.getName_srv()));
				}
				FArrayList samplist = pathgydo.getExtInfoList();
				if (samplist != null && samplist.size() > 0) {
					//标本信息校验
					checkSampInfo(samplist, errorList);
				}
				
			}
			if (errorList.size() > 0){
				eeList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errorList));
			}
		}
		return eeList;
	}

	/**
	 * 校验病理标本信息
	 * @param samplist
	 * @param errorList
	 */
	private void checkSampInfo(FArrayList samplist, List<String> errorList) {
		for (Object obj : samplist) {
			EmsPathgyItemViewDTO sampDO = (EmsPathgyItemViewDTO) obj;
			if (CiOrdUtils.isEmpty(sampDO.getName_labsamp())) {
				errorList.add("标本名称不完整，请重新检查！");
			}
			if (CiOrdUtils.isEmpty(sampDO.getName_body_coll())) {
				errorList.add("标本采集部位不完整，请重新检查！");
			}
			if (CiOrdUtils.isEmpty(sampDO.getName_fixative())) {
				errorList.add("标本固定液不完整，请重新检查！");
			}
			if (!CiOrdUtils.isEmpty(sampDO.getQuan_coll()) && sampDO.getQuan_coll() <= 0) {
				errorList.add("标本数量不能为零，请重新检查！");
			}
		}
	}
}
