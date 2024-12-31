package iih.ci.ord.s.ems.biz.ip.mqmsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.i.mqmsg.meta.NurseWaitConfirmMsgDTO;
import iih.ci.ord.s.ems.cache.BDDeptInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.message.message.i.IGenerateMessageExtdService;


/**
 * 医嘱操作时向护士站发送消息
 * 会发送消息的操作：签署、停止
 * 2019年2月26日
 * @author gh
 *
 */
public class CiOrderNurseMQBP {

	
	/**
	 * 发送签署消息给护士工作站
	 * @param msgList
	 * @throws BizException
	 */
	public void broadcastNurseConfirmMsg(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		
			List<NurseWaitConfirmMsgDTO> msgList = this.getWaitConfirmMsgList(ctx, ciors);
			// 组织消息参数
			Map<String, Object> msgMap = new HashMap<String, Object>();

			msgMap.put(IMQMsgTypeConst.CIS_MSG_NURSE_WAIT_CONFIRM, msgList);

			IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
			// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
			msgService.GenerateMessageAndMap(IMQMsgTypeConst.CIS_MSG_NURSE_WAIT_CONFIRM, msgMap, null);

	}
	
	
	/**
	 * 构造待确认的消息
	 * @param ctx
	 * @param ciors 待护士确认的医嘱
	 * @return 发送到消息的待确认信息
	 * @throws BizException
	 */
	private List<NurseWaitConfirmMsgDTO> getWaitConfirmMsgList(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException{
		//患者信息补充
		Map patInfromation = getPatInformation(ciors[0].getId_en());
		
		List<NurseWaitConfirmMsgDTO>  waitConfirmMsgList = new ArrayList<NurseWaitConfirmMsgDTO>();
		for(CiOrderDO orderInfo : ciors){
			NurseWaitConfirmMsgDTO confirmMsg = new NurseWaitConfirmMsgDTO();
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
				confirmMsg.setName_pat(StringUtils.isNotEmpty(patInfromation.get("name_pat").toString())?patInfromation.get("name_pat").toString():"");
				confirmMsg.setCode_bed(StringUtils.isNotEmpty(patInfromation.get("name_bed").toString())?patInfromation.get("name_bed").toString():"");
			}
				confirmMsg.setName_dep_ns(StringUtils.isNotEmpty(patInfromation.get("name_dep").toString())?patInfromation.get("name_dep").toString():"");
			
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
		return String.format( " select  en.Name_pat,dep.Name as Name_dep,ip.Name_bed from en_ent en "
							+ " left join en_ent_ip ip on ip.id_ent=en.id_ent           			"
							+ " left join bd_dep dep on dep.id_dep = en.ID_DEP_NUR      			"
							+ " where en.id_ent='%s'												", id_en);
	}
}
