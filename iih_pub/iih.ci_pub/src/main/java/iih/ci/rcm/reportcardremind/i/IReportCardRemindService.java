package iih.ci.rcm.reportcardremind.i;

import iih.bd.srv.reportcardtpl.d.ReportCardTplDo;
import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import xap.mw.core.data.BizException;

/**
 * 报卡填报提醒相关服务
 */
public interface IReportCardRemindService {
	
	/**
	 * 判断当前诊断是否关联报卡类型并且需要提醒填写报卡，如果关联则返回报卡类型主键
	 * @param id_di
	 * @return
	 * @throws BizException
	 */
	public abstract ReportCardTypeDiagDO hasDiagPass(String id_di) throws BizException;
	
	/**
	 * 判断当次就诊当前诊断是否弹报卡弹框提示,如果需要true，不需要false
	 * @param id_ent
	 * @param id_bd_rcm_tp
	 * @param id_di
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean hasCiRcmPass(String id_ent,String id_bd_rcm_tp,String id_di) throws BizException;
	
	/**
	 * 创建既往已报数据
	 * @param id_ent
	 * @param id_bd_rcm_tp
	 * @param id_di
	 * @return true 成功  false 失败
	 * @throws BizException
	 */
	public abstract Boolean newCiRcmPass(String id_ent,String id_bd_rcm_tp,String id_di)  throws BizException;
	
	/**
	 * 根据报卡类型主键查找默认模板，如果没有返回
	 * @param id_bd_rcm_tp
	 * @return 
	 * @throws BizException
	 */
	public abstract ReportCardTplDo findDefQry(String id_bd_rcm_tp) throws BizException;
	
	/**
	 * 诊断签署判断是否需要填写统一报卡(住院医生站CI调用)
	 * @param id_ent
	 * @param id_di
	 * @return 
	 * @throws BizException
	 */
	public abstract  ReportCardTypeDiagDO reportcardremind(String id_ent, String id_di) throws BizException;

	/**
	 * 传染病报卡驳回提醒
	 * @param remindMsgDto
	 * @return 
	 * @throws BizException
	 */
	public abstract void sendRejectReminderMsg(QcRemindMsgDTO remindMsgDto) throws BizException;
}
