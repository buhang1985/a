package iih.ci.ord.s.ems.biz.ip.mqmsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import ch.ethz.ssh2.log.Logger;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.i.mqmsg.meta.NurseWaitConfirmMsgDTO;
import iih.ci.ord.s.ems.cache.BDDeptInfoCache;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 医嘱签署加急的院内会诊时向受邀科室发送消息
 * @author yangdong
 *
 */
public class CiOrderYnhzMQBP {
	/**
	 * 发送签署消息给受邀科室
	 * @param msgList
	 * @throws BizException
	 */
	public void broadcastYnhzConfirmMsg(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
			//获取需要发送的信息
			List<NurseWaitConfirmMsgDTO> msgList = this.getWaitConfirmMsgList(ctx, ciors);
			// 组织消息参数
			Map<String, Object> msgMap = new HashMap<String, Object>();

			msgMap.put(IMQMsgTypeConst.CIS_MSG_HZ_CONFIRM, msgList);

			IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
			// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
			msgService.GenerateMessageAndMap(IMQMsgTypeConst.CIS_MSG_HZ_CONFIRM, msgMap, null);

	}

	private List<NurseWaitConfirmMsgDTO> getWaitConfirmMsgList(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		List<NurseWaitConfirmMsgDTO>  waitConfirmMsgList = new ArrayList<NurseWaitConfirmMsgDTO>();
		for(CiOrderDO orderInfo : ciors){
			NurseWaitConfirmMsgDTO confirmMsg = new NurseWaitConfirmMsgDTO();
			confirmMsg.setWait_config_msgtype("Sign");
			confirmMsg.setCode_or(orderInfo.getCode_or());
			confirmMsg.setName_or(orderInfo.getName_or());
			confirmMsg.setId_or(orderInfo.getId_or());
			if(StringUtils.isNotEmpty(orderInfo.getId_dep_ns())){
				confirmMsg.setName_dep_ns(BDDeptInfoCache.GetNameOfBDeptInfo(orderInfo.getId_dep_ns()));
			}
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
			}
			 
			confirmMsg.setDiag_name(getDiagName(ctx.getId_en()));
			waitConfirmMsgList.add(confirmMsg);
		}
		return waitConfirmMsgList;
	}
	
	/**
	 * 当次就诊的最新诊断 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String getDiagName(String id_ent)throws BizException {
		CidiagAggDO[]  diagAgg = ServiceFinder.find(ICidiagQryService.class).getLastCiDiags(id_ent);
		 StringBuffer sb = new StringBuffer();
		if(diagAgg != null) {
			for(CidiagAggDO agg:diagAgg) {
				CiDiagItemDO[] items = agg.getCiDiagItemDO();
				for(CiDiagItemDO item:items) {
					sb.append(item.getId_didef_name()).append(",");
				}
			}
		}
		return sb.toString();
		
	}
}
