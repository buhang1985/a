package iih.bd.res.dayslot.s.bp;

import java.util.ArrayList;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.DayslotAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 日期分组Agg时间交叉校验业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DayslotAggTimeCrossValidateBp {

	public ValidationFailure exec(Object[] aobj) throws BizException {
		ArrayList<DayslotAggDO> aggList = convertToDayslotAggList(aobj);
		TimeCrossValidateBp bp = new TimeCrossValidateBp();
		for (DayslotAggDO dayslotAggDO : aggList) {
			DaysLotDO mData = dayslotAggDO.getParentDO();
			ValidationFailure vFailure = bp.exec(new DaysLotDO[] { mData });
			if (vFailure != null) {
				return vFailure;
			}
		}
		return null;
	}

	/**
	 * 转换为Agg列表
	 * 
	 * @param aobj
	 * @return
	 */
	private ArrayList<DayslotAggDO> convertToDayslotAggList(Object[] aobj) {
		ArrayList<DayslotAggDO> arrayList = new ArrayList<DayslotAggDO>();
		for (Object obj : aobj) {
			if (obj instanceof DayslotAggDO) {
				arrayList.add((DayslotAggDO) obj);
			}
		}
		return arrayList;
	}
}
