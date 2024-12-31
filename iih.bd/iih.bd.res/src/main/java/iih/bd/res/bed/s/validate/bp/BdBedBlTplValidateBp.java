package iih.bd.res.bed.s.validate.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.bed.d.Bdbed;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 床位服务项目校验业务逻辑
 * 
 * @author hao_wu
 *
 */
public class BdBedBlTplValidateBp {

	public ValidationFailure exec(Bdbed[] bdBedArr) {
		if (bdBedArr == null || bdBedArr.length <= 0) {
			return null;
		}
		ValidationFailure vFailure = blTplValidate(bdBedArr);
		return vFailure;
	}

	/**
	 * 床位服务项目校验
	 * 
	 * @param bdBedArr
	 * @return
	 */
	private ValidationFailure blTplValidate(Bdbed[] bdBedArr) {
		for (Bdbed bdbed : bdBedArr) {
			ValidationFailure vFailure = blTplValidate(bdbed);
			if (vFailure != null) {
				return vFailure;
			}
		}
		return null;
	}

	/**
	 * 床位服务项目校验
	 * 
	 * @param bdbed
	 * @return
	 */
	private ValidationFailure blTplValidate(Bdbed bdbed) {
		FBoolean fgActive = bdbed.getFg_act();
		String idBlTpl = bdbed.getId_bltpl();
		if (fgActive.equals(FBoolean.TRUE) && StringUtils.isBlank(idBlTpl)) {
			return new ValidationFailure("床位服务项目不允许为空。");
		}
		return null;
	}

}
