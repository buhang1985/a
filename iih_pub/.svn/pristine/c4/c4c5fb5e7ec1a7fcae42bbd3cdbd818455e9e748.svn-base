package iih.bd.fc.que.i;

import iih.bd.fc.que.d.QueDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 队列查询服务
 * @author yankan
 *
 */
public interface IQueQryService {
	/**
	 * 获取排班队列
	 * @param scResId 排班资源id
	 * @param depId 出诊科室id
	 * @param quebenId 分诊台id
	 * @param queTp 队列类型
	 * @return
	 * @throws BizException
	 */
	QueDO getQue(String scResId, String depId, String quebenId, String queTp) throws BizException;
	/**
     * 判断队列是否在分诊台管理之下
     * 
     * @param benId 分诊台ID
     * @param queId 队列ID
     * @return
     * @throws BizException
     * @author liubin
     */
	FBoolean isBenContainQue(String benId, String queId) throws BizException;
	/**
	 * 判断队列是否有相对应排班计划
	 * 
	 * @param que
	 * 		队列DO
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	FBoolean hasScPl(QueDO que) throws BizException;
	/**
	 * 获取门诊分诊台地址
	 * 
	 * @param depId
	 * @param scresId
	 * @return
	 * @throws BizException
	 */
	String getOpBenAddr(String depId, String scresId, String benId)throws BizException;
}
