package iih.bd.pp.bdcpnca.s.validator;

import org.apache.commons.lang3.ArrayUtils;

import xap.sys.appfw.bizrule.validation.ValidationFailure;

public class ProDeleteBdCpncaDOValidator implements xap.sys.appfw.bizrule.validation.Validator {

	@Override
	public ValidationFailure validate(Object... arg0) {
		ValidationFailure vFailure = null;
		if (ArrayUtils.isEmpty(arg0)) {
			return null;
		}
		//暂时系统支持此验证，如需扩展 启动此代码
//		Object[] objs = (Object[]) arg0;
//		if (objs.length == 1) {
//			BdcpncaAggDO aggDO = (BdcpncaAggDO) objs[0];
//
//			IBlCpnDORService service = ServiceFinder.find(IBlCpnDORService.class);
//
//			try {
//				BlCpnDO[] dos = service.findByAttrValString("ID_CPNCA", aggDO.getParentDO().getId_cpnca());
//				if (dos.length != 0) {
//					vFailure = new ValidationFailure("优惠劵分类：" + aggDO.getParentDO().getName() + "，已存在优惠劵无法删除！");
//				}
//			} catch (BizException e) {
//
//				e.printStackTrace();
//			}
//
//		}
		return vFailure;
	}
}
