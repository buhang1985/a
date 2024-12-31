package iih.hp.cp.itf.i;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import xap.mw.core.data.BizException;

public interface IHpcpAppItfService {
	
	/**
	 *  判断开立医嘱是否为径外医嘱
	 * @param id_ent 患者就诊ID
	 * @param ciorList 患者开立医嘱
	 * @return
	 * @throws BizException
	 */
	public abstract void checkCiorderSrv(String id_ent, CiorderAggDO[] ciorList) throws BizException;
	
	/**
	 *  判断患者是否在径(在径待建路径除外)
	 * @param id_ent 患者就诊ID
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean getEntIncpFlagExcludeWaitcp(String id_ent) throws BizException;
	
	/**
	 *  获取患者临床路径使用状态(待建路径除外)
	 * @param id_ents 患者就诊ID
	 * @return
	 * @throws BizException
	 */
	public abstract String getEntHpcpStatus(String id_ent) throws BizException;
	
	/**
	 *  判断患者是否使用过路径(待建路径除外)
	 * @param id_ent 患者就诊ID
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean getEntUsedHpcp(String id_ent) throws BizException;
}