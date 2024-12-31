package iih.pi.reg.pat.s.validator;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者信息空值校验
 * 
 * @author hao_wu 2018-8-23
 *
 */
public class CheckNullValidator implements Validator {

	private static final long serialVersionUID = 1L;

	@Override
	public ValidationFailure validate(Object... arg0) {

		if (ArrayUtil.isEmpty(arg0)) {
			return null;
		}
		ValidationFailure vf = null;
		if (arg0.length > 1) {
			PatiAggDO[] vos = new PatiAggDO[arg0.length];
			for (int i = 0; i < arg0.length; i++) {
				vos[i] = (PatiAggDO) arg0[i];
			}
			vf = validateMultiVO(vos);
		} else {
			// 进行单对象的唯一性规则校验
			PatiAggDO vo = (PatiAggDO) arg0[0];
			vf = validateSingleVO(vo);
		}

		return vf;
	}

	private ValidationFailure validateMultiVO(Object[] objs) {
		for (Object object : objs) {
			PatiAggDO aggDo = (PatiAggDO) object;
			ValidationFailure vf = validateSingleVO(aggDo);
			if (vf != null)
				return vf;
		}
		return null;
	}

	private ValidationFailure validateSingleVO(PatiAggDO aggDo) {
		ValidationFailure vf = null;
		if (aggDo != null) {
			PatDO patDo = aggDo.getParentDO();
			if (StringUtil.isEmptyWithTrim(patDo.getCode())) {
				vf = new ValidationFailure("注册患者时，编码不允许为空！");
			} else if (StringUtil.isEmptyWithTrim(patDo.getName())) {
				vf = new ValidationFailure("注册患者时，姓名不能为空！");
			} else if (StringUtil.isEmptyWithTrim(patDo.getId_paticate())) {
				vf = new ValidationFailure("注册患者时，患者分类不能为空！");
			} else if (StringUtil.isEmptyWithTrim(patDo.getId_patpritp())) {
				vf = new ValidationFailure("注册患者时，患者价格分类不能为空！");
			} else if (StringUtil.isEmptyWithTrim(patDo.getId_patcrettp())) {
				vf = new ValidationFailure("注册患者时，患者信用分类不能为空！");
			}
		}
		return vf;
	}

}
