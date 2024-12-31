package iih.ci.ord.s.bp;
import iih.ci.ord.dto.d.OrderByPriceDTO;
import iih.ci.ord.dto.d.QueryOrderDTO;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 
 * @author li_zheng
 *
 */
public class getCiOrderDOByConditionBP {

	
	public  OrderByPriceDTO[] getCiOrderDOByCondition(String[] id_ents,QryRootNodeDTO qryRootNodeDTO)throws BizException{
	   
		
	   IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	   String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTO);
	   if(id_ents==null || id_ents.length==0){
		   return null;
	   }
	   String sql  = getCondition(id_ents,wherePart); 
	   DAFacade dafacade=  new DAFacade();
	   List<OrderByPriceDTO> orderbyPriceDTOS =  (List<OrderByPriceDTO>) dafacade.execQuery(sql, new BeanListHandler(OrderByPriceDTO.class));
	   if(orderbyPriceDTOS != null && orderbyPriceDTOS.size() >0){
		   OrderByPriceDTO[] priceDTOs = orderbyPriceDTOS.toArray(new OrderByPriceDTO[orderbyPriceDTOS.size()]);
		   CiOrdUtils.GetOrdState(priceDTOs);
		   return priceDTOs;
	   }
      return null;
	}
	
	
   private  String getCondition(String[] id_ents,String wherePart){
	   StringBuffer sb = new StringBuffer();
	   sb.append(" select ci_order.id_or,ci_order.sd_su_bl,ci_order.sd_su_or,ci_order.content_or,ci_order.sd_su_mp,ci_order.fg_stop,ci_order.fg_pres_outp Fg_pres_out, ");
	   sb.append(" ci_order.dt_entry,ci_order.dt_effe,ci_order.sd_srvtp,ci_order.dt_end,ci_order.id_freq,ci_order.id_route,ci_order.id_emp_or, ");
	   sb.append(" bd_psndoc.name emp_name ,bd_route.name  route_name ,bd_freq.name  freq_name, ");
	   sb.append(" case sd_su_bl when '0' then '未计费'  when '1'   then '已计费' ");
	   sb.append(" else '退费' end  sd_su_bl_name, ");
	   sb.append(" case sd_su_or  when '0'  then '开立' ");
	   sb.append(" when '10' then '签署'  when '20' then '核对通过' ");
	   sb.append(" when '30' then '执行中' when '40' then '医生停止' ");
	   sb.append(" when '50' then '核对停止' when '60' then '完成' ");
	   sb.append(" when '70' then '作废' when '80' then '核对作废'");
	   sb.append(" end  sd_su_or_name, ");
	   sb.append(" case ci_order.fg_long when 'Y' then '长' ");
	   sb.append("       when 'N' then '临' ");
	   sb.append("       end  longLinName, ");
	   sb.append("  ci_order.fg_long,");
	   sb.append(" ci_order.id_dep_or,");
	   sb.append(" bd_dep.name as name_dep_or ");
	   sb.append("  from ci_order  ci_order  ");
	   sb.append("  left join bd_psndoc  bd_psndoc on bd_psndoc.id_psndoc = ci_Order.Id_Emp_Or ");
	   sb.append("  left join bd_freq  bd_freq on bd_freq.id_freq= ci_order.id_freq ");
	   sb.append("  left join bd_route  bd_route on bd_route.id_route = ci_order.id_route ");
	   sb.append(" left join bd_dep on ci_order.id_dep_or=bd_dep.id_dep");
	   sb.append("  where  1=1 ");
	   if(id_ents != null){
		   sb.append(" and ci_order.id_en in ("+CiOrdUtils.IdsConveretCharacterString(id_ents)+")" );
	   }
	   if(!StringUtils.isEmpty(wherePart)){
		   sb.append("   and "+ wherePart);
	   }
	   sb.append(" order by ci_order.dt_effe desc,nvl(ci_order.sortno,0) desc,ci_order.createdtime desc");
	   return sb.toString();
 
	   
	   
   }
}
