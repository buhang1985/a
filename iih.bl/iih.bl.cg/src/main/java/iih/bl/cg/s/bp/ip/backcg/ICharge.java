package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 记账接口
 * @author yankan
 * @since 2017-09-18
 *
 */
public interface ICharge {
	/**
	 * 记账
	 * @param patInfo 患者住院信息
	 * @param pripatAgg 患者价格分类
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 */
	public abstract void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException;	

	/**
	 * 当日出院记账
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @throws BizException
	 */
	public abstract void execTodayOut(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException;
}
