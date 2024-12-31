package iih.ci.ord.s.ems.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BizException;

public class BaseEmsValidate implements IEmsValidate {

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
