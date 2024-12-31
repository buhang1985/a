package iih.pmp.pay.s.bp.validate;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.utils.FileUtils;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

public class OrderVidator implements Validator {

	private static final long serialVersionUID = 1L;

	PmpPayAppBaseUtils utils = new PmpPayAppBaseUtils();

	@Override
	public ValidationFailure validate(Object... arg0) {
		// TODO Auto-generated method stub
		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		for (Object object : arg0) {
			if (object instanceof OrdDO) {
				OrdDO dto = (OrdDO) object;
				try {
					IOrdRService ordRService = utils.getOrdRService();
					OrdDO[] ords = ordRService.findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());
					if (ArrayUtils.isNotEmpty(ords)) {
						String msg = String.format("外部订单号重复！%s重复订单号:%s.", FileUtils.NewLine, dto.getOrd_no());
						return new ValidationFailure(msg);
					}
					ords = ordRService.findByAttrValString(OrdDO.CODE, dto.getCode());
					if (ArrayUtils.isNotEmpty(ords)) {
						String msg = String.format("编码重复！%s重复编码:%s.", FileUtils.NewLine, dto.getCode());
						return new ValidationFailure(msg);
					}
//					OrdDO[] ords=utils.getOrdRService().find("("+OrdDO.ORD_NO+"='"+dto.getOrd_no()+"' and "+OrdDO.ID_EMP_OP+"='"+dto.getId_emp_op()+"') or code='"+dto.getCode()+"'", "", FBoolean.FALSE);
//					if(ords!=null&&ords.length>0)
//						return new ValidationFailure("编码或者外部订单加人员id重复！");
				} catch (BizException e) {
					// TODO Auto-generated catch block
					return new ValidationFailure(e.getMessage());
				}
			}

		}
		return null;
	}

}
