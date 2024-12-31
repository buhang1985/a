package iih.bd.res.bed.s.validate;

import java.util.ArrayList;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.s.validate.bp.BdBedBlTplValidateBp;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 床位服务项目校验
 * 
 * @author hao_wu
 *
 */
public class BdBedBlTplValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4058313322880188962L;

	@Override
	public ValidationFailure validate(Object... objs) {
		Bdbed[] bdBedArr = convertToBdBedArr(objs);
		BdBedBlTplValidateBp bp = new BdBedBlTplValidateBp();
		ValidationFailure vFailure = bp.exec(bdBedArr);

		return vFailure;
	}

	/**
	 * 转换为床位主DO数组
	 * 
	 * @param aobj
	 * @return
	 */
	private Bdbed[] convertToBdBedArr(Object[] objs) {
		ArrayList<Bdbed> bedList = new ArrayList<Bdbed>();
		for (Object object : objs) {
			if (object instanceof Bdbed) {
				bedList.add((Bdbed) object);
			}
		}
		return bedList.toArray(new Bdbed[bedList.size()]);
	}

}
