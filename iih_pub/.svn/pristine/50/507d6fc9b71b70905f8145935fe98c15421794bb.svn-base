package iih.sc.sch.dto.d;

import xap.mw.coreitf.d.FDate;

/**
 * 排班key
 * 
 * @author yank
 *
 */
public class SchKey {
	private String key;

	/**
	 * 构造函数
	 * 
	 * @param planId 排班计划ID
	 * @param date 排班日期
	 * @param dayslotId 日期分组ID
	 */
	public SchKey(String planId, FDate date, String dayslotId) {
		this.key = String.format("%s,%s,%s", planId, date.toLocalString(), dayslotId);
	}

	/**
	 * 
	 */
	public String toString() {
		return key;
	}

	/**
	 * 是否相同
	 * 
	 * @param target
	 * @return
	 */
	@Override
	public boolean equals(Object target) {
		if(this == target){
			return true;
		}
		if (target == null)
			return false;
		if(!(target instanceof SchKey)){
			return false;
		}
		SchKey targetKey = (SchKey)target;		
		return this.toString().equals(targetKey.toString());
	}
	/**
	 * 如果是调用HashMap，则需要重写改方法
	 */
	@Override
	public int hashCode(){
		return this.key.hashCode();
	}
}
