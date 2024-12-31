package iih.en.doc.s.bp.preg.s;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.endoc.d.EntDocFlupDO;
import iih.en.doc.endoc.d.FlupEnum;
import iih.en.doc.endoc.i.IEntdocflupCudService;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.pub.IScSmsConst;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 建档未就诊发送短信
 * 
 * @author fanliqin
 *
 */
public class SendMessageBP {
	/**
	 * 建档未就诊发送短信
	 * 
	 * @param pregDocInfos
	 * @return
	 * @throws BizException
	 */
	public PregDocInfoDTO[] exec(PregDocInfoDTO[] pregDocInfos) throws BizException {
		if (EnValidator.isEmpty(pregDocInfos)) {
			return null;
		}
		FDateTime nowdate = EnAppUtils.getServerDateTime();
		IEntdocflupCudService _iEntdocflupCudService = ServiceFinder
				.find(IEntdocflupCudService.class);
		IScAptOutCmdService aptOutCmdService = ServiceFinder.find(IScAptOutCmdService.class);
		// 手机号码（支持多个）
		String mobiles = "";
		// 短信内容
		String msg_content = "";
		List<EntDocFlupDO> dataList = new ArrayList<EntDocFlupDO>();
		for (PregDocInfoDTO pregDocInfo : pregDocInfos) {
			if (EnValidator.isEmpty(pregDocInfo.getTelno_pat())) {
				continue;
			}
			if (EnValidator.isEmpty(mobiles)) {
				mobiles = mobiles + pregDocInfo.getTelno_pat();
			} else {
				mobiles = mobiles + "," + pregDocInfo.getTelno_pat();
			}
			if (EnValidator.isEmpty(msg_content)) {
				msg_content = pregDocInfo.getContent();
			}
			EntDocFlupDO entDocFlupDO = new EntDocFlupDO();
			entDocFlupDO.setStatus(DOStatus.NEW);
			entDocFlupDO.setId_pat(pregDocInfo.getId_pat());
			entDocFlupDO.setId_entdoc(pregDocInfo.getId_entdoc());
			entDocFlupDO.setId_apt(pregDocInfo.getId_apt());
			entDocFlupDO.setDt_flup(nowdate);
			entDocFlupDO.setContent(pregDocInfo.getContent());
			entDocFlupDO.setDt_insert(nowdate);
			entDocFlupDO.setEu_flup(FlupEnum.EU_FLUP_MESSAGE);
			dataList.add(entDocFlupDO);
		}
		// 发送短信
		aptOutCmdService.sendSmsMsg(mobiles, IScSmsConst.PREG_DOC_SEND_MSG, msg_content);
		// 保存数据
		_iEntdocflupCudService.save(dataList.toArray(new EntDocFlupDO[0]));
		return pregDocInfos;
	}
}