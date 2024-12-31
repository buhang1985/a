package iih.bl.cg.s.bp.ip.backcg;

import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 服务取整结果
 * 根据取整结果计算后，记账时间也要往后延
 * 比如：不足一小时，按一小时算，那记账时间，应该+1小时
 * @author yankan
 *
 */
public class SrvRoundResult {
	/**
	 * 数量
	 */
	private FDouble quan;
	/**
	 * 上次记账时间
	 */
	private FDateTime lastCgTime;
	public FDouble getQuan() {
		return quan;
	}
	public void setQuan(FDouble quan) {
		this.quan = quan;
	}
	public FDateTime getLastCgTime() {
		return lastCgTime;
	}
	public void setLastCgTime(FDateTime lastCgTime) {
		this.lastCgTime = lastCgTime;
	}
}
