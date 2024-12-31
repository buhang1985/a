package iih.bl.cg.s.bp.ip.backcg;

import java.util.Comparator;

import xap.mw.coreitf.d.FDateTime;

/**
 * 比较器工厂
 * @author yankan
 * @since 2017-10-17
 *
 */
public class ComparatorFactory {
	/**
	 * 早者优先
	 * @return
	 */
	public static Comparator<DayFeeParam> createEarlierComp(){
		return new Comparator<DayFeeParam>(){
			public int compare(DayFeeParam param1, DayFeeParam param2){
				return param1.getDt_b().compareTo(param2.getDt_b());
			}
		};
	}
	/**
	 * 晚者优先
	 * @return
	 */
	public static Comparator<DayFeeParam> createLatterComp(){
		return new Comparator<DayFeeParam>(){
			public int compare(DayFeeParam param1, DayFeeParam param2){
				return param2.getDt_b().compareTo(param1.getDt_b());
			}
		};
	}
	/**
	 * 价格高者优先
	 * @return
	 */
	public static Comparator<DayFeeParam> createHigherComp(){
		return new Comparator<DayFeeParam>(){
			public int compare(DayFeeParam param1, DayFeeParam param2){
				return param1.getPrice().compareTo(param2.getPrice());
			}
		};
	}
	/**
	 * 价格低者优先
	 * @return
	 */
	public static Comparator<DayFeeParam> createLowerComp(){
		return new Comparator<DayFeeParam>(){
			public int compare(DayFeeParam param1, DayFeeParam param2){
				return param2.getPrice().compareTo(param1.getPrice());
			}
		};
	}	
	/**
	 * 已经计费者优先
	 * @return
	 */
	public static Comparator<DayFeeParam> createChargedComp(final FDateTime cgEndTime){
		return new Comparator<DayFeeParam>(){
			public int compare(DayFeeParam param1, DayFeeParam param2){
				boolean param1HasChged = hasCharged(param1,cgEndTime);
				boolean param2HasChged = hasCharged(param2,cgEndTime);
				if(param1HasChged){
					return 1;
				}else if(param2HasChged){
					return -1;
				}else{
					return 0;
				}
			}
		};
	}	
	/**
	 * 是否已记账
	 * @param feeParam
	 * @param cgEndTime
	 * @return
	 */
	public static boolean hasCharged(DayFeeParam feeParam,FDateTime cgEndTime){
		return hasCharged(feeParam.getDt_e(),feeParam.getDt_chg_bill(),cgEndTime);
	}
	/**
	 * 是否已经记账
	 * @param dt_e
	 * @param dt_chg_bill
	 * @param cgEndTime
	 * @return
	 */
	public static boolean hasCharged(FDateTime dt_e,FDateTime dt_chg_bill,FDateTime cgEndTime){
		if(dt_chg_bill ==null){
			return false;
		}
		if(dt_e ==null){
			return dt_chg_bill.after(cgEndTime);//当前使用的,根据记账时间判定
		}
		else{
			return dt_e.before(dt_chg_bill);//如果记账晚于结束，则已记账，否则为未记账
		}
	}
}
