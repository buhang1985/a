package iih.ci.ord.s.ems.op.ems.treat;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.op.base.OpBaseEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 治疗医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class EmsTreatValidate extends OpBaseEmsValidate {
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {

		ErrorEmsList eeList = new ErrorEmsList();
		for (Object objItem : objEms) {
			EmsDrugItemDO itemDO = (EmsDrugItemDO) objItem;
			EmsOrDrug emsDTO = (EmsOrDrug) itemDO.getEmsOrDrugListEx().get(0);
			List<String> errorlist = new ArrayList<String>();
			if (StringUtil.isEmpty(emsDTO.getId_mp_dep())) {
				errorlist.add(String.format("%s执行科室为空！", emsDTO.getName_srv()));
			}
			if (emsDTO.getQuan_med() == null || emsDTO.getQuan_med().toDouble() <= 0) {
				errorlist.add(String.format("%s剂量必须大于0！", emsDTO.getName_srv()));
			}
			///////// 添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
			if (errorlist.size() > 0) {
				eeList.add(new ErrorEmsDTO( null,null, errorlist));
			}
			///////// 添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		}
		return eeList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		return null;
	}

}
