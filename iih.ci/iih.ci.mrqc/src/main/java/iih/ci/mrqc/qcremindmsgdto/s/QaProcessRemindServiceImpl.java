package iih.ci.mrqc.qcremindmsgdto.s;

import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import iih.ci.mrqc.qcremindmsgdto.i.IQaProcessRemindService;
import iih.ci.mrqc.qcremindmsgdto.s.bp.QcRemindMsgBP;
import xap.mw.core.data.BizException;

public class QaProcessRemindServiceImpl implements IQaProcessRemindService{
	@Override
	public void sendQcReminderMsg(QcRemindMsgDTO remindMsgDto) throws BizException{
		QcRemindMsgBP bp=new QcRemindMsgBP();
		bp.sendQcReminderMsg(remindMsgDto);	
	}
}
