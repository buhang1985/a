package iih.bd.pp.hp.s.validator;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

public class HpDOValidator implements Validator {

	private static final long serialVersionUID = 1L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		if (arg0 != null && arg0.length == 1) {
			HPDO hPDO = (HPDO) arg0[0];
			IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
			HPDO[] hPDOfindByAttr;
			try {
				hPDOfindByAttr = iHpMDORService.findByAttrValString(HPDO.ID_REFHP, hPDO.getId_hp());
				HPDO hPDOFindById = iHpMDORService.findById(hPDO.getId_hp());
				if (hPDOFindById != null && StringUtils.isNotBlank(hPDO.getRefhp_name()) && hPDOfindByAttr != null && hPDOfindByAttr.length > 0) {
					return new ValidationFailure("该医保已被其他医保引用，该产品不允许引用其他医保！");
				}
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
