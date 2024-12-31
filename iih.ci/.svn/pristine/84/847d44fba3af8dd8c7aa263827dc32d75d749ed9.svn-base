package iih.ci.ord.s.bp.specant;


import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.specanti.d.SpecantOrderDTO;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 特殊级抗菌药申请界面左侧列表树查询方法
 * @author gh
 *
 */
public class SpecAntiConsTreeQryBP {

	public SpecantOrderDTO[] exec(String id_ent,String whereParm) throws DAException{
		if(CiOrdUtils.isEmpty(id_ent))return null;
		String sql = getSql(id_ent,whereParm); //1001Z81000000007RWQ4
		//String sql = getSql(patId,whereParm);
		@SuppressWarnings("unchecked")
		ArrayList<SpecantOrderDTO> result = (ArrayList<SpecantOrderDTO>) new DAFacade()
				.execQuery(sql, new BeanListHandler(SpecantOrderDTO.class));
		if(result!=null&&result.size()>0){
			//将重复存在的特数据抗菌药删除掉，规则：已经存在一个药品的申请单时，不需要存在第二个；如果没有申请单，相同药品可同时存在
			List<String> specIdsrvs = new ArrayList<String>();
			//查询出已经保存的申请单
			for(int i=result.size()-1;i>=0;i--){
				if(!specIdsrvs.contains(result.get(i).getId_srv())&&!StringUtils.isEmpty(result.get(i).getId_su_speccons())){
					specIdsrvs.add(result.get(i).getId_srv());
				}
			}
			for(int i=result.size()-1;i>=0;i--){
				if(specIdsrvs.contains(result.get(i).getId_srv())&&StringUtils.isEmpty(result.get(i).getId_su_speccons())){
					result.remove(i);
				}
			}
			return result.toArray(new SpecantOrderDTO[0]);
		}
		return null;
	}
	
	private String getSql(String id_ent,String whereParm){
		StringBuffer sql  = new StringBuffer();
		sql.append(" select ci_or_srv.id_srv Id_srv, ");
		sql.append("        ci_order.id_or , ");
		sql.append(" ci_or_srv.id_orsrv,");
		sql.append("        ci_or_srv.name DrugName , ");
		sql.append("        cons.id_apspecanticons Id_apspecanticons, ");
		sql.append("        cons.Id_su_speccons Id_su_speccons,");
		sql.append(" ci_order.dt_effe,");
		sql.append(" p.name as name_emp_or");
		sql.append(" from ci_order ci_order");
		sql.append(" left join  ci_ap_spec_anti_cons cons ");
		sql.append(" on cons.id_or = ci_order.ID_OR ");
		sql.append(" left join ci_or_srv ci_or_srv ");
		sql.append(" on ci_or_srv.id_or = ci_order.ID_OR ");
		sql.append(" left join bd_srv_drug bd_srv_drug  ");
		sql.append(" on bd_srv_drug.id_srv = ci_or_srv.id_srv ");
		sql.append(" left join bd_psndoc p on p.id_psndoc=ci_order.id_emp_or");
		sql.append(" where ci_or_srv.sd_srvtp like '0101%' ");
		sql.append("   and bd_srv_drug.sd_anti = '"+IBdMmDictCodeConst.SD_ANTI_SPECIAL+"'  "); //特殊级抗菌药code
		sql.append("   and ci_order.id_en = '"+id_ent+"' ");
		if(!CiOrdUtils.isEmpty(whereParm)){
			sql.append(" and  ci_or_srv.name like '%"+whereParm+"%'");
		}
		sql.append(" order by ci_order.dt_effe desc");
		return sql.toString();
	}
	
}
