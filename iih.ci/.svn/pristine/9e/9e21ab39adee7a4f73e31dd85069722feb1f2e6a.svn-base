package iih.ci.ord.s.bp.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 循环的定时任务，将已经停止确认且当前时间已经超过结束时间的医嘱设置为停止状态
 * 
 * @author zhangwq
 *
 */
public class CompleteStatusLoopTask implements IBackgroundWorkPlugin {
	// 当前系统时间
	private FDateTime nowDate;
	private FDateTime beforeDate;
	private String dateFormat="yyyy-mm-dd hh24:mi:ss";
	public CompleteStatusLoopTask() {
		this.nowDate = new FDateTime();
		beforeDate = this.nowDate.getDateTimeBefore(10);
	}

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		String[] idOrs = getUnCompleteOrder();
		if (!CiOrdUtils.isEmpty(idOrs)) {
			Map<String,Object> variableValueMap = arg0.getKeyMap();
			String id_org = (String) variableValueMap.get("id_org");
			Context.get().setOrgId(id_org);
			//122540	定时任务：医嘱完成状态空指针异常   轻量级中添加集团id参数 放入上下文中 
			String id_group = (String) variableValueMap.get("id_group");
			Context.get().setGroupId(id_group);
			
			CiOrdAppUtils.getIForeignService().UpdateOrderStatus(idOrs);
		}
		return null;
	}

	/**
	 * 查询已停止确认未设置完成状态的医嘱（08嘱托类全部，0601分级护理,0602治疗性护理,0603生命体征,0503吸氧,0505营养膳食）
	 * 
	 * @return String[]
	 */
	private String[] getUnCompleteOrder() {
		try {
			List<String> idList = new ArrayList<String>();
			/*List<Map<String, Object>> rst = (List<Map<String, Object>>) new DAFacade()
					.execQuery(this.getUnCompleteSql(), new MapListHandler());*/
			
			SqlParam param = new SqlParam();
			param.addParam(nowDate);
			param.addParam(beforeDate);
			
			List<Map<String, Object>> rst = (List<Map<String, Object>>) new DAFacade()
					.execQuery(this.getUnCompleteSql(), param, new MapListHandler());
			for (Map<String, Object> map : rst) {
				idList.add(map.get("id_or").toString());
			}
			return idList.toArray(new String[0]);
		} catch (DAException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 组装查询语句，用于查已停止确认未设置完成状态的医嘱（08嘱托类全部，0601分级护理,0602治疗性护理,0603生命体征,0503吸氧,0505营养膳食）
	 * @return
	 */
	private String getUnCompleteSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("select id_or from ci_order A");
		sb.append(" left join bd_measdoc b on A.id_unit_med=b.id_measdoc");
		//sb.append(" where A.fg_chk_stop='Y' and A.dt_end is not null and A.dt_end<='" + this.nowDate.toStdString()+"'");
		sb.append(" where A.fg_chk_stop='Y' and A.dt_end is not null and A.dt_end<=? and A.dt_end > ?");
		sb.append(" and A.Sd_Su_Or<>'60' and A.Sd_Su_Mp<>'20'");
		sb.append(" and A.id_freq='"+IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS+"'");
		sb.append(" and b.id_oppdimen='"+ICiDictCodeConst.DIMENSION_OF_TIME+"'");
//		sb.append(" and (A.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_TREAT_XIYANG + "' or A.sd_srvtp='"
//				+ IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT + "' ");
//		sb.append(" or A.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_NURSE_NSGREED + "' or A.sd_srvtp='"
//				+ IBdSrvDictCodeConst.SD_SRVTP_NURSE_TREATNS + "' or A.sd_srvtp='"
//				+ IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS + "' ");
//		sb.append(" or A.sd_srvtp like '" + IBdSrvDictCodeConst.SD_SRVTP_ENTRUST + "%')");
		return sb.toString();
	}
}
