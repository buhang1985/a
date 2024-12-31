package iih.bl.cg.s.bp.ip.backcg;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import xap.mw.coreitf.d.FDateTime;

/**
 * 选择器
 * @author yankan
 * @since 2017-09-28
 *
 */
public interface IChooser {
	/**
	 * 抉择
	 * @param paramList 计费参数集合
	 * @param cgEndTime 记账截止时间
	 * @param comparator 比较器
	 * @return
	 */
	public abstract Map<String,DayFeeParam> choose(List<DayFeeParam> paramList,FDateTime cgEndTime,Comparator comparator);
}
