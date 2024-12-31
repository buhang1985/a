package iih.bd.res.bed.s.validate;

import java.util.ArrayList;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedAggDO;
import iih.bd.res.bed.s.validate.bp.BdBedBlTplValidateBp;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 床位服务项目校验
 * 
 * @author hao_wu
 *
 */
public class BdBedAggBlTplValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6022899386521892806L;

	@Override
	public ValidationFailure validate(Object... objs) {
		BedAggDO[] bdBedAggArr = convertToBdBedAggArr(objs);
		if (bdBedAggArr == null || bdBedAggArr.length <= 0) {
			return null;
		}
		BdBedBlTplValidateBp bp = new BdBedBlTplValidateBp();
		for (BedAggDO bedAggDO : bdBedAggArr) {
			Bdbed bdBed = bedAggDO.getParentDO();
			ValidationFailure vFailure = bp.exec(new Bdbed[] { bdBed });
			if (vFailure != null) {
				return vFailure;
			}
		}

		return null;
	}

	/**
	 * 转换为床位数组
	 * 
	 * @param aobj
	 * @return
	 */
	private BedAggDO[] convertToBdBedAggArr(Object[] objs) {
		ArrayList<BedAggDO> bedAggList = new ArrayList<BedAggDO>();
		for (Object object : objs) {
			if (object instanceof BedAggDO) {
				bedAggList.add((BedAggDO) object);
			}
		}
		return bedAggList.toArray(new BedAggDO[bedAggList.size()]);
	}
}
