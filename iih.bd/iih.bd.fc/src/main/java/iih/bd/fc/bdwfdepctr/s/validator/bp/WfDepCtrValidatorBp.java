package iih.bd.fc.bdwfdepctr.s.validator.bp;

import iih.bd.fc.bdwfdepctr.d.BdWfDepCtrDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 流程配置_医嘱流向_整体控制校验bp
 * 
 * @author guoyang
 *
 */
public class WfDepCtrValidatorBp {

	public ValidationFailure exec(Object[] object) {
		if (object == null || object.length <= 0) {
			return null;
		}
		BdWfDepCtrDO[] bdWfDepCtrs = convertToBdWfDepCtrDO(object);
		return Validator(bdWfDepCtrs);
	}

	/**
	 * 校验最大值和最小值
	 * 
	 * @param bdWfDepCtrs
	 * @return
	 */
	private ValidationFailure Validator(BdWfDepCtrDO[] bdWfDepCtrs) {
		if (bdWfDepCtrs == null || bdWfDepCtrs.length <= 0) {
			return null;
		}

		for (BdWfDepCtrDO bdWfDepCtrDO : bdWfDepCtrs) {
			if (bdWfDepCtrDO.getItmcnt_max() < bdWfDepCtrDO.getItmcnt_min()) {
				String msg = String.format("序号：%s 的流向控制【药品最小项目数】不得大于【药品最大项目数】！", bdWfDepCtrDO.getSortno());
				return new ValidationFailure(msg);
			}
		}
		return null;
	}

	/**
	 * 转换为DO
	 * 
	 * @param object
	 * @return
	 */
	private BdWfDepCtrDO[] convertToBdWfDepCtrDO(Object[] object) {
		BdWfDepCtrDO[] bdWfDepCtrs = new BdWfDepCtrDO[object.length];
		for (int i = 0; i < bdWfDepCtrs.length; i++) {
			bdWfDepCtrs[i] = (BdWfDepCtrDO) object[i];
		}
		return bdWfDepCtrs;
	}

}
