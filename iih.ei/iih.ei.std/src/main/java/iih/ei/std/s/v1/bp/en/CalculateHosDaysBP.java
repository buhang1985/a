package iih.ei.std.s.v1.bp.en;

import iih.bd.base.utils.AppUtils;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 计算住院天数BP
 * 
 * @author zhengcm
 * @date 2016-06-06 19:37:56
 *
 */

public class CalculateHosDaysBP {

	/**
	 * 根据【入院时间】【出院时间】【在院标志】计算【住院天数】
	 * 
	 * @author zhengcm
	 *
	 * @param dt_acpt
	 *            入院时间
	 * @param dt_end
	 *            出院时间
	 * @param fg_ip
	 *            在院标志
	 * @return 住院天数
	 * @throws BizException
	 */
	public int calculate(FDateTime dt_acpt, FDateTime dt_end, FBoolean fg_ip)
			throws BizException {
		if (FBoolean.TRUE.equals(fg_ip)) {
			if(dt_acpt != null){
				FDate curDate = AppUtils.getServerDate();
				return this.calculate(dt_acpt.getDate().asLocalBegin(), curDate);
			}
		}else{
			if(dt_acpt != null && dt_end !=null)
				return this.calculate(dt_acpt.getDate().asLocalBegin(), 
						dt_end.getDate().asLocalBegin());
		}
		return 0;
	}
	/**
	 * 计算住院天数
	 * 
	 * @param begin
	 * @param end
	 * @return
	 * @throws BizException 
	 */
	private int calculate(FDate begin, FDate end) throws BizException{
		if(begin.compareTo(end)==0)
			return 1;
		Integer type = null;
		Object obj = Context.get().getAttribute("Key_CalculateHosDaysType");
		if(obj == null){
			type = EiParamUtils.GetCalculateHosDaysType();
			if(type == null){
				throw new BizException("住院天数的计算方式(ENIP0210)配置错误！");
			}
			Context.get().setAttribute("Key_CalculateHosDaysType", type);
		}else{
			type = (Integer)obj;
		}
		int day = Math.abs(FDate.getDaysBetween(begin, end));
		if(type == 0){
			return day;
		}
		if(type == 1){
			return day+1;
		}
		return day+1;
	}
}
