package iih.ci.ord.s.ems.op.ems.cons;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.ciordems.d.EmsItemInCons;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.op.base.OpBaseEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 会诊医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class EmsConsValidate extends OpBaseEmsValidate {
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEmsList, CiEnContextDTO ctx) throws BizException {

		ErrorEmsList eeList = new ErrorEmsList();

		for (Object objItem : objEmsList) {
			List<String> errorlist = new ArrayList<String>();
			EmsConsItemDO consdo = (EmsConsItemDO) objItem;

			FArrayList consitems = consdo.getConsAssList();

			if (!CiOrdUtils.isEmpty(consitems)) {
				boolean flag = false;

				for (Object obj : consitems) {
					EmsItemInCons conitem = (EmsItemInCons) obj;
					if (CiOrdUtils.isEmpty(conitem.getId_dep_emp()))
						flag = true;

				}
				if (flag)
					errorlist.add(String.format("%s缺少受邀科室！", consdo.getName_srv()));

			} else {
				errorlist.add(String.format("%s缺少受邀方信息！", consdo.getName_srv()));
			}

			eeList.add(new ErrorEmsDTO(null,null, errorlist));
		}

		return eeList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		return null;
	}
}
