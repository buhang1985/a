package iih.pis.ivx.listener.notice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pis.ivx.constant.WeChatConfigConstant;
import iih.pis.ivx.msgs.i.IPisivxMsgSendService;
import iih.pis.ivx.pisivxaccount.d.PisIvxAccountDO;
import iih.pis.ivx.pisivxaccount.i.IPisivxaccountRService;
import iih.pis.ivx.pisivxmember.d.PisIvxMemberDO;
import iih.pis.ivx.pisivxmember.i.IPisivxmemberRService;
import iih.pis.ivx.pisivxnotice.d.PisIvxNoticeDO;
import iih.pis.ivx.pisivxnotice.i.IPisivxnoticeCudService;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingDO;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingTemplateDO;
import iih.pis.ivx.pisivxsetting.i.IPisIvxSettingTemplateDORService;
import iih.pis.ivx.pisivxsetting.i.IPisivxsettingMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 医嘱结果状态修改为报告初出时，发送微信通知
 * @author 32797
 *
 */
public class CiOrderRstModifyAfterListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//医嘱结果状态被修改为报告初发时触发
	    if(!(event.getSourceID().equals(CiOrderDODesc.CLASS_FULLNAME) && event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
	    CiOrderDO[] ciOrderDosNew = (CiOrderDO[])((BDCommonEvent)event).getNewObjs();
	    CiOrderDO[] ciOrderDosOld = (CiOrderDO[])((BDCommonEvent)event).getOldObjs();
		
		if(ArrayUtil.isEmpty(ciOrderDosNew)||ArrayUtil.isEmpty(ciOrderDosOld))return;
		
		if(!NoticeConstant.CI_ORDER_CODE_RPTOUT.equals(ciOrderDosNew[0].getSd_orrsttp()))return;
		
		String sd_srvtp = ciOrderDosNew[0].getSd_srvtp();
		//只有检查/检验报告才会发送微信通知
		if(sd_srvtp!=null && (sd_srvtp.startsWith("02") || sd_srvtp.startsWith("03"))){
			//执行状态修改后体检报告信息上传操作
			try {
				this.doActionCiOrderRstChange(ciOrderDosNew,ciOrderDosOld);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void doActionCiOrderRstChange(CiOrderDO[] ciOrderDosNew, CiOrderDO[] ciOrderDosOld) throws Exception {
		//1、获取到接收通知的对象
		PisIvxAccountDO pisIvxAccountDO = getNotifyPat(ciOrderDosNew[0]);
		
		PisIvxMemberDO pisIvxMemberDO = getWeChatMember(ciOrderDosNew[0]);
		//2、编辑消息并发送
		sendMessage(pisIvxAccountDO, pisIvxMemberDO);
	}
	
	private PisIvxAccountDO getNotifyPat(CiOrderDO ciOrderDo) throws BizException {
		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
		IPisivxaccountRService pisivxaccountRService = ServiceFinder.find(IPisivxaccountRService.class);
		IPisivxmemberRService pisivxmemberRService = ServiceFinder.find(IPisivxmemberRService.class);
		PatDO pat = patiMDORService.findById(ciOrderDo.getId_pat());
		PisIvxAccountDO pisIvxAccountDO = null;
		if(pat != null){
			PisIvxMemberDO[] pisIvxMemberDO = pisivxmemberRService.find(String.format("Patcode = '%s'", pat.getCode()), "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(pisIvxMemberDO)){
				 pisIvxAccountDO = pisivxaccountRService.findById(String.format(pisIvxMemberDO[0].getId_pisivxaccount()));
			}
		}
		return pisIvxAccountDO;
	}
	
	private PisIvxMemberDO getWeChatMember(CiOrderDO ciOrderDo) throws BizException {
		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
		IPisivxmemberRService pisivxmemberRService = ServiceFinder.find(IPisivxmemberRService.class);
		PatDO pat = patiMDORService.findById(ciOrderDo.getId_pat());
		PisIvxMemberDO memberDO = null;
		if(pat != null){
			PisIvxMemberDO[] pisIvxMemberDO = pisivxmemberRService.find(String.format("Patcode = '%s'", pat.getCode()), "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(pisIvxMemberDO)){
				memberDO = pisIvxMemberDO[0];
			}
		}
		return memberDO;
	}

	private Map<String, Object> sendMessage(PisIvxAccountDO pisIvxAccountDO, PisIvxMemberDO pisIvxMemberDO) throws BizException{
		Map<String, Object> result = new HashMap<String, Object>();
		
		IPisivxsettingMDORService pisivxsettingMDORService = ServiceFinder.find(IPisivxsettingMDORService.class);
		IPisIvxSettingTemplateDORService pisIvxSettingTemplateDORService = ServiceFinder.find(IPisIvxSettingTemplateDORService.class);
		IPisivxMsgSendService pisivxMsgSendService = ServiceFinder.find(IPisivxMsgSendService.class);
		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
		
		PisIvxSettingDO[] settings = pisivxsettingMDORService.find(String.format("code = %s" , WeChatConfigConstant.SERVER_CODE), "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(settings)){
			PisIvxSettingTemplateDO[] pisIvxSettingTemplateDOs = 
					pisIvxSettingTemplateDORService.find(String.format("Id_pisivxsetting = '%s'", settings[0].getId_pisivxsetting()), "", FBoolean.FALSE);
			//没有模板则不向微信发送消息,也不往pis_ivx_notice表中存记录
			//用户未绑定,同上
			if(!ArrayUtil.isEmpty(pisIvxSettingTemplateDOs) || pisIvxAccountDO==null){
				String openId = pisIvxAccountDO.getOpenid(); 
				PatDO[] pat = patiMDORService.find(String.format("Code = '%s'", pisIvxMemberDO.getPatcode()), "", FBoolean.FALSE);
				try {
//					pisivxMsgSendService.sendReportMessage(openId, 1, pat[0].getName(), 2, "检验报告", new FDateTime().toString(), pisIvxSettingTemplateDOs[0].getTemplate_id(),pat[0].getId_pat());
					//仅测试使用,后续需要修改
//					pisivxMsgSendService.sendReportMessage(openId, 1, pat[0].getName(), 2, pisIvxAccountDO.getPatname(), pisIvxAccountDO.getId_pisivxent(), pisIvxSettingTemplateDOs[0].getTemplate_id(),pat[0].getId_pat());
					pisivxMsgSendService.sendReportMessage(openId, pisIvxAccountDO.getPatname(), pisIvxAccountDO.getId_pisivxent(), pisIvxSettingTemplateDOs[0].getTemplate_id(),pisIvxAccountDO.getPatcode());
				} catch (BizException e) {
					e.printStackTrace();
					result.put("msg", "failed");
					return result;
				}
				result.put("msg", "success");
				saveNoticeInfo(pisIvxAccountDO, settings[0], pisIvxSettingTemplateDOs[0], pisIvxMemberDO);
			}
		}
		return result;		
	}

	private void saveNoticeInfo(PisIvxAccountDO pisIvxAccountDO, PisIvxSettingDO pisIvxSettingDO, PisIvxSettingTemplateDO pisIvxSettingTemplateDO, PisIvxMemberDO pisIvxMemberDO) throws BizException {
		IPisivxnoticeCudService pisivxnoticeCudService = ServiceFinder.find(IPisivxnoticeCudService.class);
		PisIvxNoticeDO noticeDo = new PisIvxNoticeDO();
		PisIvxNoticeDO[] notices = new PisIvxNoticeDO[1];
		noticeDo.setId_pisivxsettingtemplate(pisIvxSettingTemplateDO.getId_pisivxsettingtemplate());
		noticeDo.setId_grp(pisIvxAccountDO.getId_grp());
		noticeDo.setId_org(pisIvxAccountDO.getId_org());
		
//		noticeDo.setNotice(pisIvxSettingTemplateDO.getNote());
		//测试用,之后需要修改
		Map<String,String> map = new HashMap<>();
		map.put("test", pisIvxAccountDO.getPatname());
		map.put("testdate", pisIvxAccountDO.getId_pisivxent());
		String realNote = getNoteByTemple(pisIvxSettingTemplateDO.getNote(),map);
		noticeDo.setNotice(realNote);
		
		noticeDo.setTm_notice(new FDateTime());
		
		noticeDo.setLinkurl("http://"+pisIvxSettingDO.getAuthdomain()+pisIvxSettingTemplateDO.getUrl()+"?patCode="+pisIvxAccountDO.getPatcode());
		
		noticeDo.setId_pisivxaccount(pisIvxAccountDO.getId_pisivxaccount());
		noticeDo.setId_pisivxmember(pisIvxMemberDO.getId_pisivxmember());
		noticeDo.setId_pisivxent(pisIvxAccountDO.getId_pisivxent());
		noticeDo.setStatus(DOStatus.NEW);
		notices[0] = noticeDo;
		pisivxnoticeCudService.save(notices);
	}
	
	//根据模板内容及参数得到真正发送的消息(参数参考iih.pis.ivx.api.MessageUtils)
	private String getNoteByTemple(String note,Map<String,String> map){
		Pattern pattern = Pattern.compile("\\{\\{(.*?).DATA\\}\\}");
		Matcher matcher = pattern.matcher(note);
		while(matcher.find()){
			String allStr = matcher.group();
			String attrName = matcher.group(1);
			note = note.replace(allStr, map.get(attrName));
		}
		return note;
	}
	
}
