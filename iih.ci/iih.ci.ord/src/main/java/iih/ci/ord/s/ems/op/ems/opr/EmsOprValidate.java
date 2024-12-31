package iih.ci.ord.s.ems.op.ems.opr;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.op.base.OpBaseEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 手术医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class EmsOprValidate extends OpBaseEmsValidate {

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {

		ErrorEmsList eeList = new ErrorEmsList();
		for (Object obj : objEms) {
			EmsOpitemDO opdo = (EmsOpitemDO) obj;
			List<String> errorlist = new ArrayList<String>();
			if (StringUtil.isEmpty(opdo.getId_mp_dep())) {
				errorlist.add(String.format("%s执行科室为空！", opdo.getName_srv()));
			}
			if (opdo.getDt_plan() == null) {
				errorlist.add(String.format("%s计划手术时间为空！", opdo.getName_srv()));
			}
			if (StringUtil.isEmpty(opdo.getId_di())) {
				errorlist.add(String.format("%s临床诊断为空！", opdo.getName_srv()));
			}
			if (StringUtil.isEmpty(opdo.getId_anestp())) {
				errorlist.add(String.format("%s麻醉方式为空！", opdo.getName_srv()));
			}
			if (errorlist.size() > 0)
				eeList.add(new ErrorEmsDTO(null,null, errorlist));
		}

		return eeList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		return null;
	}
}
