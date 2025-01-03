package iih.ci.rcm.reportcardremind.s;

import iih.bd.srv.reportcardtpl.d.ReportCardTplDo;
import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import iih.ci.rcm.contagionrejectremind.bp.ContagionRejectRemindBp;
import iih.ci.rcm.reportcardremind.bp.FindDefQryBp;
import iih.ci.rcm.reportcardremind.bp.HasCiRcmPassBp;
import iih.ci.rcm.reportcardremind.bp.HasDiagPassBp;
import iih.ci.rcm.reportcardremind.bp.NewCiRcmPassBp;
import iih.ci.rcm.reportcardremind.bp.ReportCardRemindBp;
import iih.ci.rcm.reportcardremind.i.IReportCardRemindService;
import xap.mw.core.data.BizException;

/**
 * 报卡填报提醒相关服务
 */
public class ReportCardRemindServiceImpl implements IReportCardRemindService{
	
	/**
	 * 判断当前诊断是否关联报卡类型并且需要提醒填写报卡，如果关联则返回报卡类型主键
	 * @param id_di
	 * @return
	 * @throws BizException
	 */
	@Override
	public ReportCardTypeDiagDO hasDiagPass(String id_di) throws BizException {
		HasDiagPassBp bp = new HasDiagPassBp();
		return bp.hasDiagPass(id_di);
	}
	
	/**
	 * 判断当次就诊当前诊断是否弹报卡弹框提示,如果需要true，不需要false
	 * @param id_ent
	 * @param id_bd_rcm_tp
	 * @param id_di
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean hasCiRcmPass(String id_ent, String id_bd_rcm_tp,String id_di) throws BizException {
		HasCiRcmPassBp bp = new HasCiRcmPassBp();
		return bp.hasCiRcmPass(id_ent,id_bd_rcm_tp,id_di);
	}
	
	/**
	 * 创建既往已报数据
	 * @param id_ent
	 * @param id_bd_rcm_tp
	 * @param id_di
	 * @return true 成功  false 失败
	 * @throws BizException
	 */
	@Override
	public Boolean newCiRcmPass(String id_ent, String id_bd_rcm_tp,String id_di) throws BizException {
		NewCiRcmPassBp bp = new NewCiRcmPassBp();
		return bp.newCiRcmPass(id_ent,id_bd_rcm_tp,id_di);
	}
	
	/**
	 * 根据报卡类型主键查找默认模板，如果没有返回null
	 * @param id_bd_rcm_tp
	 * @return 
	 * @throws BizException
	 */
	@Override
	public ReportCardTplDo findDefQry(String id_bd_rcm_tp) throws BizException {
		FindDefQryBp bp = new FindDefQryBp();
		return bp.findDefQry(id_bd_rcm_tp);
	}

	/**
	 *  判断是否需要填写统一报卡(住院医生站住院诊断界面诊断签署时CI调用)
	 * @param id_ent
	 * @param id_di
	 * @return 
	 * @throws BizException
	 */
	@Override
	public ReportCardTypeDiagDO reportcardremind(String id_ent, String id_di) throws BizException {
		ReportCardRemindBp bp = new ReportCardRemindBp();
		return bp.reportcardremind(id_ent, id_di);
	}

	/**
	 * 传染病报卡驳回提醒
	 * @param remindMsgDto
	 * @return 
	 * @throws BizException
	 */
	@Override
	public void sendRejectReminderMsg(QcRemindMsgDTO remindMsgDto) throws BizException {
		ContagionRejectRemindBp bp=new ContagionRejectRemindBp();
		bp.sendRejectReminderMsg(remindMsgDto);
	}
}
