package iih.bd.fc.que.i;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.data.BizException;

/**
 * 队列生成服务
 * @author yankan
 * @since date 2015-11-12
 *
 */
public interface IQueGenService {
    
	/**
	 * 根据排班计划生成队列
	 * @param scTp
	 * <table border = 3>
	 * <caption align="center">排班类型</caption>
	 * <tr><th>可用编码</th><th>对应静态常量</th><th>排班类型</th></tr>
	 * <tr><td>01</td><td>IScDictCodeConst.SD_SCTP_OP</td><td>门诊排班类型</td></tr>
	 * <tr><td>03</td><td>IScDictCodeConst.SD_SCTP_MT</td><td>医技排班类型</td></tr>
	 * <tr><td>05</td><td>IScDictCodeConst.SD_SCTP_JZ</td><td>医技排班类型</td></tr>
	 * </table>
	 * @throws BizException
	 */
    QueDO[] genFromScPlan(String scTp) throws BizException;
	/**
	 * 生成药房队列
	 * @throws BizException
	 */
    QueDO[] genDsQue() throws BizException;
    /**
     * 保存队列和站点
     * 
     * @param ques 队列集合
     * @param quesites 站点集合
     * @return
     * @throws BizException
     */
    QueDO[] saveQueAndSite(QueDO[] ques, QueSiteDO[] quesites) throws BizException;
    /**
     * 删除队列和队列下站点
     * 
     * @param ques 队列集合
     * @throws BizException
     */
    void delQueAndSite(QueDO[] ques) throws BizException;
    /**
     * 生成队列(排班计划调用)
     * 
     * @param depId 科室ID
     * @param resId 资源ID
     * @param scTp 排班类型编码
     * @throws BizException
     */
    void createQueue(String depId, String resId, String scTp) throws BizException; /***
     * 生成队列(排班计划调用)
     * 统一科室、统一资源、不同服务生成不同队列
     * @author fanlq 2017年12月1日
     * @param depId 科室ID
     * @param resId 资源ID
     * @param queBenId 诊区ID
     * @param scTp 排班类型编码
     * @throws BizException
     */
    void createQueueNew(String depId, String resId, String queBenId,String scTp) throws BizException;
}
