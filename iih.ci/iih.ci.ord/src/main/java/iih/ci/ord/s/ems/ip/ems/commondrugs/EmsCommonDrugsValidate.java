package iih.ci.ord.s.ems.ip.ems.commondrugs;

import xap.mw.core.data.DOStatus;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpDrugsEmsValidate;
import iih.ci.ord.s.ems.meta.StringList;

/**
 * 西成药医疗单有效性校验
 * 
 * @author wangqingzhu
 *
 */
public class EmsCommonDrugsValidate extends BaseIpDrugsEmsValidate {


	@Override
	protected ErrorEmsDTO analysisErrorOfSrvInfo(Object[] objEms) {
		StringList errorList = new StringList();
		for (Object objInfo : objEms) {
			OrderListViewDTO drug = (OrderListViewDTO) objInfo;
			if(drug.getStatus()==DOStatus.DELETED)
				continue;
			if (CiOrdUtils.isEmpty(drug.getId_freq())) {
				errorList.add(String.format("【%s】频次为空！", drug.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(drug.getId_route())) {
				errorList.add(String.format("【%s】用法为空！", drug.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(drug.getId_dep_wh()) && null == drug.getSd_nodispense()) {
				errorList.add(String.format("【%s】物资仓库为空！", drug.getName_srv()));
			}
			if (!CiOrdUtils.isEmpty(drug.getQuan_firday_mp()) && !CiOrdUtils.isEmpty(drug.getFreqct()) && drug.getQuan_firday_mp() > drug.getFreqct()) {
				errorList.add(String.format("【%s】首次执行次数大于医嘱频次数！", drug.getName_srv()));
			}
			if (CiOrdUtils.isTrue(drug.getFg_pres_outp()) && CiOrdUtils.isTrue(drug.getFg_long())
					&& CiOrdUtils.isEmpty(drug.getDt_end())) {
				errorList.add(String.format("【%s】为出院带药，停止时间不可为空！", drug.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(drug.getFactor_cb())) {
				errorList.add(String.format("【%s】基本包装单位换算系数为空，请检查新建逻辑！", drug.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(drug.getId_unit_cur())) {
				errorList.add(String.format("【%s】基本包装单位换算系数为空，请检查新建逻辑！", drug.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(drug.getId_unit_cur())) {
				errorList.add(String.format("【%s】基本包装单位换算系数为空，请检查新建逻辑！", drug.getName_srv()));
			}
		}
		// 定义医疗单错误信息对象
		if (errorList.size() > 0) {
			OrderListViewDTO drug = (OrderListViewDTO) objEms[0];
			return new ErrorEmsDTO(drug.getCode_or(), drug.getName_mm(), errorList.toStringWithNO(1));
		}

		return null;
	}

}
