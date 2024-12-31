package iih.bd.fc.que.s;

import iih.bd.fc.que.bp.CreateQueueBP;
import iih.bd.fc.que.bp.DelQueAndSiteBP;
import iih.bd.fc.que.bp.GenQueBP;
import iih.bd.fc.que.bp.GenerateQueBP;
import iih.bd.fc.que.bp.SaveQueAndSiteBP;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueGenService;
import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IQueGenService.class,IQueGenService.class}, binding=Binding.JSONRPC)
public class QueGenServiceImpl implements IQueGenService{	
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
	 * @return 队列集合
	 * @throws BizException
	 */
	public QueDO[] genFromScPlan(String scTp) throws BizException{
		GenerateQueBP bp = new GenerateQueBP();
		return bp.genQue(scTp);
	}
	/**
	 * 生成药房队列
	 * @throws BizException
	 */
	public QueDO[] genDsQue() throws BizException{
		GenQueBP bp= new GenQueBP();
		return bp.genDsQue();
	}
    /**
     * 保存队列和站点
     * 
     * @param ques 队列集合
     * @param quesites 站点集合
     * @return
     * @throws BizException
     */
	@Override
	public QueDO[] saveQueAndSite(QueDO[] ques, QueSiteDO[] quesites) throws BizException {
		SaveQueAndSiteBP bp = new SaveQueAndSiteBP();
		return bp.exec(ques, quesites);
	}
	/**
     * 删除队列和队列下站点
     * 
     * @param ques 队列集合
     * @throws BizException
     */
	@Override
	public void delQueAndSite(QueDO[] ques) throws BizException {
		DelQueAndSiteBP bp = new DelQueAndSiteBP();
		bp.exec(ques);
	}
	/**
     * 生成队列(排班计划调用)
     * 
     * @param depId 科室ID
     * @param resId 资源ID
     * @param scTpCode 排班类型编码
     * @throws BizException
     */
	@Override
	public void createQueue(String depId, String resId, String scTp)
			throws BizException {
		CreateQueueBP bp = new CreateQueueBP();
		bp.exec(depId, resId, scTp);
	}
	
	 /***
     * 生成队列(排班计划调用)
     * 统一科室、统一资源、不同服务生成不同队列
     * @author fanlq 2017年12月1日
     * @param depId 科室ID
     * @param resId 资源ID
     * @param queBenId 诊区ID
     * @param scTp 排班类型编码
     * @throws BizException
     */
	@Override
	public void createQueueNew(String depId, String resId, String queBenId,String scTp) throws BizException{
		CreateQueueBP bp = new CreateQueueBP();
		bp.exec2(depId, resId,queBenId, scTp);
    }
}
