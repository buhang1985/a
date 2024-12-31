package iih.ci.ord.s.ems.biz.ip.mqmsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.mqmsg.meta.ExecDepWaitConfirmMsgDTO;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.s.ems.cache.BDDeptInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.message.message.i.IGenerateMessageExtdService;


/**
 * 住院医嘱签署操作时向医生站发送消息
 * 2020年6月15日
 * @author daixb
 *
 */
public class CiOrderExecDepMQBP {

	
	/**
	 * 发送签署消息给住院医生工作站
	 * @param msgList
	 * @throws BizException
	 */
	public void broadcastOrderListViewMsg(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		
			List<ExecDepWaitConfirmMsgDTO> msgList = this.getWaitConfirmMsgList(ctx, ciors);
			if(msgList == null || msgList.size() == 0){
				return;
			}
			// 组织消息参数
			Map<String, Object> msgMap = new HashMap<String, Object>();

			msgMap.put(IMQMsgTypeConst.CI_MSG_IP_OPR_CONFIRM, msgList);

			IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
			// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
			msgService.GenerateMessageAndMap(IMQMsgTypeConst.CI_MSG_IP_OPR_CONFIRM, msgMap, null);

	}
	
	
	/**
	 * 构造待确认的消息
	 * @param ctx
	 * @param ciors 待护士确认的医嘱
	 * @return 发送到消息的待确认信息
	 * @throws BizException
	 */
	private List<ExecDepWaitConfirmMsgDTO> getWaitConfirmMsgList(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException{
		//患者信息补充
		Map patInfromation = getPatInformation(ciors[0].getId_en());
		
		List<ExecDepWaitConfirmMsgDTO>  waitConfirmMsgList = new ArrayList<ExecDepWaitConfirmMsgDTO>();
		for(CiOrderDO orderInfo : ciors){
			if(!orderInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){
				continue;
			}
			ExecDepWaitConfirmMsgDTO confirmMsg = new ExecDepWaitConfirmMsgDTO();
			confirmMsg.setWait_config_msgtype(orderInfo.getSd_su_or());
			confirmMsg.setCode_or(orderInfo.getCode_or());
			confirmMsg.setName_or(orderInfo.getName_or());
			confirmMsg.setId_dep_or(orderInfo.getId_dep_or());
			if(StringUtils.isNotEmpty(orderInfo.getId_dep_or())){
				confirmMsg.setName_dep_or(BDDeptInfoCache.GetNameOfBDeptInfo(orderInfo.getId_dep_or()));
			}
			confirmMsg.setId_emp_or(orderInfo.getId_emp_or());
			if(ctx != null) {
				confirmMsg.setCode_bed(ctx.getName_bed());
				confirmMsg.setCode_amr_ip(ctx.getCode_amr_ip());
				confirmMsg.setName_pat(ctx.getName_pat());
				confirmMsg.setId_dep_ns(ctx.getId_dep_ns());
				confirmMsg.setName_emp_or(ctx.getName_psndoc());
			}else{
				confirmMsg.setId_dep_ns(orderInfo.getId_dep_nur());
				confirmMsg.setCode_amr_ip(this.getFieldValue(patInfromation, "code_amr_ip"));
				confirmMsg.setName_pat(this.getFieldValue(patInfromation, "name_pat"));
				confirmMsg.setCode_bed(this.getFieldValue(patInfromation, "name_bed"));
			}
			confirmMsg.setName_dep_ns(this.getFieldValue(patInfromation, "name_dep"));
			confirmMsg.setId_dep_mp(orderInfo.getId_dep_mp());
			confirmMsg.setName_dep_mp(orderInfo.getName_dep_mp());
			//年龄
			if(patInfromation.get("dt_birth_pat") != null && !OrdEventUtil.isEmpty(patInfromation.get("dt_birth_pat").toString())){
				confirmMsg.setAge(AgeCalcUtil.getAge(new FDate(patInfromation.get("dt_birth_pat").toString())));    
			}
			
			waitConfirmMsgList.add(confirmMsg);
		}
		return waitConfirmMsgList;
	}
	/**
	 * @code 补全患者信息
	 * @author LiYue
	 * @date Dec 11, 2019,4:38:40 PM
	 * @param id_en
	 * @return Map
	 * @throws DAException
	 */
	public Map getPatInformation(String id_en) throws DAException {
		String sql = getSql(id_en);
		Map<String, Object> queryResult = (Map<String, Object>) new DAFacade().execQuery(sql, new MapHandler());
		return queryResult;
	}
	
	public String getSql(String id_en) {
		return String.format( " select  en.Name_pat,dep.Name as Name_dep,ip.Name_bed"
							+ ",en.dt_birth_pat,nvl(ip.code_amr_ip,'') code_amr_ip  "
							+ " from en_ent en                                      "
							+ " left join en_ent_ip ip on ip.id_ent=en.id_ent       "
							+ " left join bd_dep dep on dep.id_dep = en.ID_DEP_NUR  "
							+ " where en.id_ent='%s'								", id_en);
	}
	
	private String getFieldValue(Map patInfromation, String fldName){
		if(patInfromation.get(fldName) == null){
			return "";
		}
		if(StringUtils.isNotEmpty(patInfromation.get(fldName).toString())){
			return patInfromation.get(fldName).toString();
		}
		return "";
	}
}
