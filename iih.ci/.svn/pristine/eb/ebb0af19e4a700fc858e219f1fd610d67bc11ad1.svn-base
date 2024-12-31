package iih.ci.ord.s.ems.biz.ip.mqmsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.i.ICiorappconsultMDORService;
import iih.ci.ord.cior.i.ICiordInviteConsDORService;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.i.mqmsg.meta.NurseWaitConfirmMsgDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.base.BaseMsgReceiveController;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.ci.ord.s.external.thirdws.utils.DeptUtils;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CisYnhzConfirmMsgReceiveController extends BaseMsgReceiveController {
	public static final String ID_OR= "Id_or";
	public static final String ID_APCONS= "Id_apcons";
	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
			
			String param = SysParamUtils.getSysParam().getSYS_PARAM_SpecantiConsRecordValue().getOrgParam();
			// param 参数值
			/*手术不发送消息        0
			手术 勾选加急标志   1
			手术全部发送       2*/
			List<String> recipient = new ArrayList<>();
			// TODO : 消息接收用户ID数组
			
			List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);
			if("1".equals(param)) {
				return this.getUrgentMessageContext(msgList);
			}else if ("2".equals(param)) {
				return this.getMessageContext(msgList);
			}else {
				return  "";
			}
		
	}
			
	/**
	 * 手术  全部时消息内容   
	 * @param msgList
	 */
	private String  getMessageContext(List<NurseWaitConfirmMsgDTO> msgList) throws BizException{
		StringBuilder sb = new StringBuilder();
			if (msgList != null && msgList.size() > 0) {
				String id_dep_or = msgList.get(0).getId_dep_or();
				DeptDO dept = DeptUtils.getDept(id_dep_or);
				if (dept!=null) {
					sb.append(dept.getName() +"邀请");
				}
				//根据id_or 获取受邀科室信息
				String id_or = msgList.get(0).getId_or();
				ICiorappconsultMDORService ciorappconsultMDORService = ServiceFinder.find(ICiorappconsultMDORService.class);
				OrdApConsDO[] ordApConsDOs = ciorappconsultMDORService.findByAttrValString(ID_OR, id_or);
				for (OrdApConsDO ordApConsDO : ordApConsDOs) {
					String id_apcons = ordApConsDO.getId_apcons();
					ICiordInviteConsDORService iCiordInviteConsDORService = ServiceFinder.find(ICiordInviteConsDORService.class);
					CiordInviteConsDO[] ciordInviteConsDOs = iCiordInviteConsDORService.findByAttrValString(ID_APCONS,id_apcons);
					for (CiordInviteConsDO ciordInviteConsDO : ciordInviteConsDOs) {
						String id_dep = ciordInviteConsDO.getId_dep();//受邀科室
						String id_emp = ciordInviteConsDO.getId_emp();//受邀人
						DeptDO dept1 = DeptUtils.getDept(id_dep);
						IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
						
						
						if (dept1!=null&&dept1.getName()!=null) {
							if (id_emp!=null) {
								PsnDocDO[] psndocs = service.findByAttrValString(PsnDocDO.ID_PSNDOC, id_emp);
								if (psndocs!=null&&psndocs[0].getName()!=null) {
									sb.append(dept1.getName()+"("+ psndocs[0].getName()+"),");
								}
							}else{
								sb.append(dept1.getName()+",");
							}
						}
						
					}
				}
				sb.append("参加会诊，请尽快处理！");
			sb.append(this.getWaitConfirmMsg(msgList.get(0)));
			
		}
		return sb.toString();
	}
	
	
	/**
	 * 手术 加急是时消息内容 
	 * @param msgList
	 */
	private String  getUrgentMessageContext(List<NurseWaitConfirmMsgDTO> msgList) throws BizException{
		StringBuilder sb = new StringBuilder();
		if (msgList != null && msgList.size() > 0) {
			String id_dep_or = msgList.get(0).getId_dep_or();
			DeptDO dept = DeptUtils.getDept(id_dep_or);
			if (dept!=null) {
				sb.append(dept.getName() +"邀请");
			}
			//根据id_or 获取受邀科室信息
			String id_or = msgList.get(0).getId_or();
			ICiorappconsultMDORService ciorappconsultMDORService = ServiceFinder.find(ICiorappconsultMDORService.class);
			OrdApConsDO[] ordApConsDOs = ciorappconsultMDORService.findByAttrValString(ID_OR, id_or);
			for (OrdApConsDO ordApConsDO : ordApConsDOs) {
				String id_apcons = ordApConsDO.getId_apcons();
				ICiordInviteConsDORService iCiordInviteConsDORService = ServiceFinder.find(ICiordInviteConsDORService.class);
				CiordInviteConsDO[] ciordInviteConsDOs = iCiordInviteConsDORService.findByAttrValString(ID_APCONS,id_apcons);
				for (CiordInviteConsDO ciordInviteConsDO : ciordInviteConsDOs) {
					String id_dep = ciordInviteConsDO.getId_dep();//受邀科室
					String id_emp = ciordInviteConsDO.getId_emp();//受邀人
					DeptDO dept1 = DeptUtils.getDept(id_dep);
					IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
					
					
					if (dept1!=null&&dept1.getName()!=null) {
						if (id_emp!=null) {
							PsnDocDO[] psndocs = service.findByAttrValString(PsnDocDO.ID_PSNDOC, id_emp);
							if (psndocs!=null&&psndocs[0].getName()!=null) {
								sb.append(dept1.getName()+"("+ psndocs[0].getName()+"),");
							}
						}else{
							sb.append(dept1.getName()+",");
						}
					}
		
	}
			}
			sb.append("参加会诊，请尽快处理！");
			sb.append(this.getWaitConfirmMsg(msgList.get(0)));
	     }
	   return sb.toString();
	}

/*	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		StringBuilder sb = new StringBuilder();
		// TODO:返回消息接收科室
		List<String> recipient = new ArrayList<>();
		// TODO : 消息接收用户ID数组
		List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);//0001Z8100000000007PO 0001Z8100000000007R0
		if (msgList != null && msgList.size() > 0) {
			//根据id_or 获取受邀科室信息
			String id_or = msgList.get(0).getId_or();
			ICiorappconsultMDORService ciorappconsultMDORService = ServiceFinder.find(ICiorappconsultMDORService.class);
			OrdApConsDO[] ordApConsDOs = ciorappconsultMDORService.findByAttrValString(ID_OR, id_or);
			for (OrdApConsDO ordApConsDO : ordApConsDOs) {
				String id_apcons = ordApConsDO.getId_apcons();
				ICiordInviteConsDORService iCiordInviteConsDORService = ServiceFinder.find(ICiordInviteConsDORService.class);
				CiordInviteConsDO[] ciordInviteConsDOs = iCiordInviteConsDORService.findByAttrValString(ID_APCONS,id_apcons);
				for (CiordInviteConsDO ciordInviteConsDO : ciordInviteConsDOs) {
					String id_dep = ciordInviteConsDO.getId_dep();//受邀科室
					if (id_dep!=null) {
						sb.append(id_dep+",");
					}
				}
				
			}
						
		}
		
		
		return sb.toString().substring(0, sb.length()-1);
	}*/
	
	

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		//String id_deps = ParamsetQryUtil.getParaString(Context.get().getOrgId(), ICiOrdCustomSysParamConst.LL_PARAM_MSGRECEIVE_DEPS);
		List<String> recipient = new ArrayList<>();
		// TODO : 消息接收用户ID数组
		List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);//0001Z8100000000007PO 0001Z8100000000007R0
		if (msgList != null && msgList.size() > 0) {
			//根据id_or 获取受邀科室信息
			String id_or = msgList.get(0).getId_or();
			String Id_dep_ns =    msgList.get(0).getId_dep_ns();
			ICiorappconsultMDORService ciorappconsultMDORService = ServiceFinder.find(ICiorappconsultMDORService.class);
			OrdApConsDO[] ordApConsDOs = ciorappconsultMDORService.findByAttrValString(ID_OR, id_or);
			for (OrdApConsDO ordApConsDO : ordApConsDOs) {
				String id_apcons = ordApConsDO.getId_apcons();
				ICiordInviteConsDORService iCiordInviteConsDORService = ServiceFinder.find(ICiordInviteConsDORService.class);
				CiordInviteConsDO[] ciordInviteConsDOs = iCiordInviteConsDORService.findByAttrValString(ID_APCONS,id_apcons);
				for (CiordInviteConsDO ciordInviteConsDO : ciordInviteConsDOs) {
					String id_dep = ciordInviteConsDO.getId_dep();//受邀科室
					String id_emp = ciordInviteConsDO.getId_emp();//受邀人
						recipient.add(id_dep);				
						recipient.add(Id_dep_ns);//患者所在的病区的护士 收到会诊信息
				}
			}
			String[] array = (String[]) recipient.toArray(new String[recipient.size()]);
			return array;			
		}
		
		return null;
	}
	

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		
		List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);		
		// TODO : 组织标题
		return "提示！有需要参加的院内会诊信息";
	}

	protected List<NurseWaitConfirmMsgDTO> getMessageDataInfo(Map<String, Object> arg0) {
		
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey(IMQMsgTypeConst.CIS_MSG_HZ_CONFIRM)) {
			return (List<NurseWaitConfirmMsgDTO>) arg0.get(IMQMsgTypeConst.CIS_MSG_HZ_CONFIRM);
		}
		return null;
	}

	private String getWaitConfirmMsg(NurseWaitConfirmMsgDTO o) {
		// 病区 | 床号 | 患者 | 医嘱号 | 医嘱内容
		
		/*return String.format("  %s  %s(%s、%s床)  %s(%s) ", o.getName_dep_ns(),  o.getName_pat(), o.getCode_amr_ip(),
				o.getCode_bed(), o.getName_or(), o.getCode_or());*/
		//科室、床号、姓名、住院号、诊断
		return String.format(" %s 、  %s 、 %s  、 %s 、 %s  、%s  ",o.getName_or(), o.getName_dep_ns(), o.getCode_bed(), o.getName_pat(), o.getCode_amr_ip(),
				 o.getDiag_name());
	}
	
	@Override
	public String getTitles(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return "AA";
	}
}
