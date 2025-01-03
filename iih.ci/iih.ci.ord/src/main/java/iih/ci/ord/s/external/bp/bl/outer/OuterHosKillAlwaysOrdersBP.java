package iih.ci.ord.s.external.bp.bl.outer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 患者出院或转科时，对持续性医嘱进行完成或作废操作
 * @author zhangwq
 *
 */
public class OuterHosKillAlwaysOrdersBP {
	public OrderRstDTO exec(String[] id_ents) throws BizException{
		OrderRstDTO rstDto = new OrderRstDTO();
		String[] id_ors = this.getUnCompleteOrder(id_ents);
		if (!CiOrdUtils.isEmpty(id_ors)) {
			CiOrdAppUtils.getIForeignService().UpdateOrderStatus(id_ors);
			try{
				CiOrderDO[] ciOrders = CiOrdAppUtils.getCiorderMDORService().findByIds(id_ors, FBoolean.FALSE);
				FDateTime dtnow = new FDateTime();
				for(CiOrderDO order :ciOrders){
					order.setFg_stop(FBoolean.TRUE);
					order.setFg_chk_stop(FBoolean.TRUE);
					if(order.getDt_stop() == null){
						order.setDt_stop(dtnow);
					}
					if(order.getDt_chk_stop() == null){
						order.setDt_chk_stop(dtnow);
					}
					if(order.getDt_end() == null){
						order.setDt_end(dtnow);
					}
					if(StringUtils.isEmpty(order.getId_emp_stop())){
						order.setId_emp_stop(order.getId_emp_or());
					}
					if(StringUtils.isEmpty(order.getId_dep_stop())){
						order.setId_dep_stop(order.getId_dep_or());
					}
					if(StringUtils.isEmpty(order.getId_emp_chk_stop())){
						order.setId_emp_chk_stop(order.getId_emp_chk());
					}
					if(order.getDt_chk_stop() == null){
						order.setDt_chk_stop(CiOrdAppUtils.getServerDateTime());
					}
				}
				CiOrdAppUtils.getOrService().update(ciOrders);
			}catch(Exception ex)
			{
				OrdBizLogger.info(null, ex.getMessage());
			}
		}
		//给医嘱设置停止时间
		rstDto.setIsSuccess(FBoolean.TRUE);
		return rstDto;
	}
	/**
	 * 查询当前就诊下，所有未完成的持续性医嘱
	 * 
	 * @return String[]
	 */
	private String[] getUnCompleteOrder(String[] id_ents) {
		try {
			List<String> idList = new ArrayList<String>();
			List<Map<String, Object>> rst = (List<Map<String, Object>>) new DAFacade()
					.execQuery(this.getUnCompleteSql(id_ents), new MapListHandler());
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
	private String getUnCompleteSql(String[] id_ents) {
		StringBuilder sb = new StringBuilder();
		sb.append("select id_or from ci_order A");
		sb.append(" left join bd_measdoc b on A.id_unit_med=b.id_measdoc");
		sb.append(" where A.Sd_Su_Or<>'60' and A.fg_canc = 'N' ");
		sb.append(" and A.id_freq='"+IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS+"'");
		sb.append(" and b.id_oppdimen='"+ICiDictCodeConst.DIMENSION_OF_TIME+"'");
		sb.append(" and A.fg_chk='Y'");
		sb.append(" and A.id_en in (");
		
		for(int i=0;i<id_ents.length;i++){
			sb.append(" '"+id_ents[i]+"' ");
			if(i!=id_ents.length-1){
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
