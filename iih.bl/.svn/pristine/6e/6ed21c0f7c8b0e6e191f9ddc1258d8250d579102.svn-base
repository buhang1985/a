package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blwardrefund.d.BlRefundItemDO;
import iih.bl.cg.dto.d.BlOrderRefundListDTO;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据退费单获取医嘱明细
 * @author xy.zhou
 *
 */
public class GetRefundApOrdListBP {

	@SuppressWarnings("unchecked")
	public BlOrderRefundListDTO [] exec(String [] id_rfdaps)throws BizException{
		
		if(ArrayUtil.isEmpty(id_rfdaps)){
			throw new BizException("申请单数据为空！");
		}
		List<BlRefundItemDO> blRefundItemDOs=(List<BlRefundItemDO>)new DAFacade().findByAttrValStrings(
				BlRefundItemDO.class, BlRefundItemDO.ID_RFDAP,id_rfdaps,new String []{BlRefundItemDO.ID_OR,BlRefundItemDO.ID_CGIP,BlRefundItemDO.ID_RFDITM,BlRefundItemDO.ID_ENT});
		
		List<String> id_ors= new ArrayList<>();
		for (BlRefundItemDO blRefundItemDO : blRefundItemDOs) {
			id_ors.add(blRefundItemDO.getId_or());
		}
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select cio.id_en       id_ent, ");
		sqlSb.append("            cio.sd_su_or, ");
		sqlSb.append("            cio.fg_stop, ");
		sqlSb.append("            cio.sd_su_mp, ");
		sqlSb.append("            cio.content_or, ");
		sqlSb.append("            cio.name_or, ");
		sqlSb.append("            cio.code_or, ");
		sqlSb.append("            cio.fg_long, ");
		sqlSb.append("            cio.dt_entry, ");
		sqlSb.append("            cio.dt_effe     dt_effc, ");
		sqlSb.append("            cio.dt_end, ");
		sqlSb.append("            cio.id_or, ");
		sqlSb.append("            cio.fg_bb, ");
		sqlSb.append("            cio.fg_research, ");
		sqlSb.append("            psn.name        name_emp_or, ");
		sqlSb.append("            dep.name        name_dep_or, ");
		sqlSb.append("            tp.name         tp_name ");
		sqlSb.append("       from ci_order cio ");
		sqlSb.append("      inner join bd_psndoc psn ");
		sqlSb.append("         on cio.id_emp_or = psn.id_psndoc ");
		sqlSb.append("      inner join bd_dep dep ");
		sqlSb.append("         on cio.id_dep_or = dep.id_dep ");
		sqlSb.append("      inner join bd_srvca tp ");
		sqlSb.append("         on cio.id_srvca = tp.id_srvca ");
		sqlSb.append(" where 1=1 ");
		sqlSb.append("and ").append(SqlUtils.getInSqlByIds("cio.id_or", id_ors));
		List<BlOrderRefundListDTO> ordList = (List<BlOrderRefundListDTO>) new DAFacade().execQuery(sqlSb.toString(),new BeanListHandler(BlOrderRefundListDTO.class));
		if(ListUtil.isEmpty(ordList)){
			return null;

		}
		PatiVisitDO entDo=(PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, blRefundItemDOs.get(0).getId_ent());
		ICiOrdBlService iCiOrdBlService=ServiceFinder.find(ICiOrdBlService.class);
		for (BlOrderRefundListDTO blOrderRefundListDTO2 : ordList) {

			//设置医嘱展示状态
			String sd_or_show=iCiOrdBlService.getOrderStatus(entDo.getCode_entp(), blOrderRefundListDTO2.getSd_su_or(), blOrderRefundListDTO2.getSd_su_mp(),blOrderRefundListDTO2.getFg_stop());
			blOrderRefundListDTO2.setSd_or_show(sd_or_show);
		}
		
		return ordList.toArray(new BlOrderRefundListDTO []{});
	}
}
