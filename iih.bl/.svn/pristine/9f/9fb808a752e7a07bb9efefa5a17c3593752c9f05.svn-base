package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blwardrefund.d.BlRefundItemDO;
import iih.bl.cg.dto.d.BlRefundApplyBillDTO;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取申请单
 * @author xy.zhou
 *
 */
public class GetRefundApplysBP {
	
	@SuppressWarnings("unchecked")
	public BlRefundApplyBillDTO [] exec(String id_dep,String [] rdfitmIds)throws BizException{
		
		List<String> ApIds=new ArrayList<>();
		if(!ArrayUtil.isEmpty(rdfitmIds)){
			List<BlRefundItemDO> bItemDOs=(List<BlRefundItemDO>)new DAFacade().findByPKs(BlRefundItemDO.class, rdfitmIds);
			for (BlRefundItemDO blRefundItemDO : bItemDOs) {
				ApIds.add(blRefundItemDO.getId_rfdap());
			}
		}
		
		BlRefundApplyBillDTO[] refundApplyBillDTOs = this.dataQry(id_dep, ApIds,IBlCustomFileConst.SD_NURSE_APPLY);
		return refundApplyBillDTOs;
		
	}
	@SuppressWarnings("unchecked")
	public BlRefundApplyBillDTO [] dataQry(String id_dep,List<String> ApIds,String sd_rfdaptp) throws BizException{
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select rap.id_rfdap, ");
		sqlSb.append("       rap.code_rfdap, ");
		sqlSb.append("       rap.id_dep_ap, ");
		sqlSb.append("       dep.name       as name_dep_ap, ");
		sqlSb.append("       rap.id_emp_ap, ");
		sqlSb.append("       psn.name       as name_emp_ap, ");
		sqlSb.append("       rap.dt_ap, ");
		sqlSb.append("       rap.sd_rfdaptp, ");
		sqlSb.append("       rap.id_rfdaptp, ");
		sqlSb.append("       udi.name       as name_rfdaptp, ");
		sqlSb.append("       rap.fg_canc, ");
		sqlSb.append("        rap.fg_audit ");
		sqlSb.append("  from bl_rfd_ap rap ");
		sqlSb.append("  left join bd_dep dep ");
		sqlSb.append("    on dep.id_dep = rap.id_dep_ap ");
		sqlSb.append("  left join bd_Psndoc psn ");
		sqlSb.append("    on psn.id_psndoc = rap.id_emp_ap ");
		sqlSb.append("  left join bd_udidoc udi ");
		sqlSb.append("    on udi.id_udidoc = rap.id_rfdaptp");

		sqlSb.append(" where 1=1 ");
		SqlParam param=new SqlParam();
		if(!ListUtil.isEmpty(ApIds)){
			sqlSb.append(" and ").append(SqlUtils.getInSqlByIds("rap.id_rfdap", ApIds));
		}
		if(!StringUtil.isEmpty(id_dep)){
			sqlSb.append(" and rap.id_dep_ap=?");
			param.addParam(id_dep);
		}
		if(!StringUtil.isEmpty(sd_rfdaptp)){
			sqlSb.append(" and rap.sd_rfdaptp='").append(sd_rfdaptp).append("'");
		}
		sqlSb.append(" and rap.fg_canc='N' ");
		sqlSb.append(" and rap.fg_audit='N' ");
		sqlSb.append(" order by rap.dt_ap desc ");
		List<BlRefundApplyBillDTO> blRefundApplyBillDTOs = (List<BlRefundApplyBillDTO>) new DAFacade().execQuery(sqlSb.toString(),param, new BeanListHandler(BlRefundApplyBillDTO.class));
		if(ListUtil.isEmpty(blRefundApplyBillDTOs)){
			return null;
		}
		return blRefundApplyBillDTOs.toArray(new BlRefundApplyBillDTO[]{});
	}
}
