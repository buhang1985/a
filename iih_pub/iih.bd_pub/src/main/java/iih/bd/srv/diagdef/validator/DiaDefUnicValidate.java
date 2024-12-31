package iih.bd.srv.diagdef.validator;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.srv.diagdef.d.DiagCompDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.i.IDiagdefRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

public class DiaDefUnicValidate implements Validator {

	/**
		 * 
		 */
	private static final long serialVersionUID = 2463432927291060510L;

	private String cdsysname;

	private ValidationFailure batchValidate(Object[] objs) throws BizException {

		ValidationFailure failure = null;
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] instanceof BaseAggDO) {
				BaseAggDO do1 = (BaseAggDO) objs[i];

				if (doValidate(do1)) {

					if (failure == null) {
						failure = new ValidationFailure(cdsysname + "   重复");
					}

				}
			}
		}
		return failure;
	}

	private Boolean doValidate(BaseAggDO vo) throws BizException {

		Boolean b = false;
		DiagdefAggDO agg = (DiagdefAggDO) vo;
		if (vo != null) {
			DiagCompDO[] reldos = agg.getDiagCompDO();

			for (DiagCompDO RelCaDO : reldos) {
				for (DiagCompDO diagRelCaDO : reldos) {
					if (!diagRelCaDO.getId_dicomp().equals(RelCaDO.getId_dicomp())
							&& diagRelCaDO.getId_didef() == RelCaDO.getId_didef()
							&& diagRelCaDO.getId_distd_comp() == RelCaDO.getId_distd_comp()) {
						this.cdsysname = RelCaDO.getDistd_comp_name();
						b = true;
						break;
					}
				}
			}
			if (!b) {
				IDiagdefRService diadef = ServiceFinder.find(IDiagdefRService.class);
				DiagdefAggDO agg1 = diadef.findById(agg.getParentDO().getId_didef());

				DiagCompDO[] reldos1 = agg1.getDiagCompDO();
				for (DiagCompDO RelCaDO : reldos) {
					for (DiagCompDO diagRelCaDO : reldos1) {
						if (!diagRelCaDO.getId_dicomp().equals(RelCaDO.getId_dicomp())
								&& diagRelCaDO.getId_didef() == RelCaDO.getId_didef()
								&& diagRelCaDO.getId_distd_comp() == RelCaDO.getId_distd_comp()) {
							this.cdsysname = RelCaDO.getDistd_comp_name();
							b = true;
							break;
						}
					}
				}
			}
		}
		return b;
	}

	@SuppressWarnings("finally")
	@Override
	public ValidationFailure validate(Object... arg0) {

		if (ArrayUtils.isEmpty(arg0)) {
			return null;
		}
		Object[] objs = (Object[]) arg0;
		ValidationFailure vl = null;
		try {
			vl = batchValidate(objs);
		} catch (BizException e) {
			e.printStackTrace();
		} finally {
			return vl;
		}
	}

}
