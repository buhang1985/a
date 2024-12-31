package iih.bl.cg.bp.op.rpt;

import iih.bl.cg.rpt.dto.d.OpCostStatsDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 获取门诊费用汇总信息
 * @author liming
 *
 */
public class GetOpCostStatsListBP {
	/**
	 * 获取门诊费用汇总信息
	 * @param pg 分页对象
	 * @param nodeDTO 查询方案
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OpCostStatsDTO> exec(PaginationInfo pg, QryRootNodeDTO nodeDTO) throws BizException{
		   IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
			String whereStr = ser.getQueryStringWithoutDesc(nodeDTO);
			StringBuffer sql = new StringBuffer();
			sql.append(" select ent.id_dep_phy as cdeptcode,  ");
			sql.append(" dep.name as cdeptname,");
			sql.append(" (select count(distinct id_pat)  from en_ent where en_ent.id_dep_phy=ent.id_dep_phy) as timesoep,");
			sql.append(" sum(inc.eu_direct*inc.amt_ratio) as amt,");
			sql.append(" round(sum(inc.eu_direct*inc.amt_ratio)/count(ent.id_ent),2) as time_amt,");
			sql.append(" round(sum(inc.eu_direct*inc.amt_ratio)/(select count(distinct id_pat)  from en_ent where en_ent.id_dep_phy=ent.id_dep_phy),2) as per_amt");
			sql.append(" from en_ent ent");
			sql.append(" inner join bl_st_oep st on ent.id_ent=st.id_ent");
			sql.append(" inner join BL_ST_INC_OEP stinc on st.id_stoep=stinc.id_stoep");
			sql.append(" inner join bl_inc_oep inc on stinc.id_incoep= inc.id_incoep");
			sql.append(" left join bd_dep dep on ent.id_dep_phy=dep.id_dep");
			if (whereStr != null) {
				sql.append(" where     ");
				sql.append(whereStr);
			}
			sql.append(" group by ent.id_dep_phy,dep.name");
			OpCostStatsDTO incdto = new OpCostStatsDTO();
			PagingServiceImpl<OpCostStatsDTO> pagingServiceImpl = new PagingServiceImpl<OpCostStatsDTO>();

			PagingRtnData<OpCostStatsDTO> prd = pagingServiceImpl.findByPageInfo(incdto, pg, sql.toString(), "", null);
			return prd;
	}
}
