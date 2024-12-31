package iih.ci.ord.s.ems.op.ems.apbu;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.ciordems.d.EmsBuItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.op.base.OpBaseEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用血医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class EmsApBuValidate extends OpBaseEmsValidate {

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		return null;
	}

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx)
			throws BizException {
		ErrorEmsList eeList = new ErrorEmsList();
		for (Object objInfo : objEms) {
			EmsBuItemDO ubdo = (EmsBuItemDO) objInfo;
			List<String> errorList = new ArrayList<String>();
			// 用血量小于等于备血量
			if (ubdo.getQuan_medu_bu().toDouble() > ubdo.getQuan_medu_bt().toDouble()) {
				errorList.add("用血量不能大于备血量！");
			}
			eeList.add(new ErrorEmsDTO(null,null, errorList));
		}
		return eeList;
	}
	
	private OrdApBtDO getAppBtDO(String id_or) 
			throws BizException {
		ICiorappbtMDORService service = ServiceFinder.find(ICiorappbtMDORService.class);
		OrdApBtDO[] apbts = service.find(OrdApBtDODesc.TABLE_ALIAS_NAME + ".id_or='" + id_or + "'", null, FBoolean.FALSE);
		if (apbts != null && apbts.length > 0)
			return apbts[0];
		else {
			return null;
		}
	}
}
