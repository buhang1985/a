package iih.pi.reg.pat.s.rule;

import iih.bd.base.utils.DateTimeUtils;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 更新患者时设置默认值规则
 * 
 * @author hao_wu
 *		   version ly 2019/01/17 设置出生日期(时分秒)默认值
 *
 * @param <T>
 * 
 */
public class SetPatDefaultValueWhenUpdateRule<T> implements ICompareRule<T> {

	@Override
	public void process(T[] newDatas, T[] oldDatas) throws BizException {
		if (newDatas == null || newDatas.length <= 0) {
			return;
		}

		for (T t : newDatas) {
			if (t instanceof PatiAggDO) {
				setDefaultValue((PatiAggDO[]) newDatas);
			} else if (t instanceof PatDO) {
				setDefaultValue((PatDO[]) newDatas);
			}
		}
	}

	private void setDefaultValue(PatDO[] pats) {
		// TODO Auto-generated method stub

	}

	private void setDefaultValue(PatiAggDO[] patAggs) throws BizException {
		SetPatAggDefaultValueBp bp = new SetPatAggDefaultValueBp();
		bp.exec(patAggs);
		
		//设置出生日期(时分秒默认值)
		setDtBirthHms(patAggs);
	}
	
	/**
	 * 设置出生日期(时分秒)默认值
	 * @param patAggs
	 */
	private void setDtBirthHms(PatiAggDO[] patAggs) {
		
		for (PatiAggDO patiAggDO : patAggs) {
			PatDO patDO = patiAggDO.getParentDO();
			if(patDO.getDt_birth() != null){
				if(patDO.getDt_birth_hms() == null){
					patDO.setDt_birth_hms(new FDateTime(patDO.getDt_birth().getMillis()));
				}else if(!DateTimeUtils.isSameDay(new FDateTime(patDO.getDt_birth().getMillis()), patDO.getDt_birth_hms())){
					//同步日期部分
					String date = patDO.getDt_birth().toString();
					String time = patDO.getDt_birth_hms().toString().substring(11, 19);
					patDO.setDt_birth_hms(new FDateTime(date + " " + time));
				}
			}
		}
	}
}
