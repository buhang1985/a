package iih.bl.cg.s.bp.newrfd;

import java.util.List;

import iih.bl.cg.dto.d.BlRefundSrvItemDTO;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询待审核费用明细
 * @author zhangxin
 * @date  2019年6月26日
 */
public class GetIpFefundAppDetailListBP {
      public BlRefundSrvItemDTO[] exec(String id_ent,String sd_rfdaptp) throws BizException{
    	  
  		if(StringUtil.isEmpty(id_ent)){
			throw new BizException("没有获取到就诊主键!");
		}
  		
		StringBuilder sqlSb = new StringBuilder();
    	  sqlSb.append("select rtm.id_rfditm, ");
  		sqlSb.append("       rtm.id_rfdap, ");
  		sqlSb.append("       rtm.id_rfdcanc, ");
  		sqlSb.append("       rtm.id_rfdchk, ");
  		sqlSb.append("       rtm.sortno, ");
  		sqlSb.append("       rtm.eu_rfditmtp, ");
  		sqlSb.append("       (case rtm.eu_rfditmtp ");
  		sqlSb.append("         when 1 then ");
  		sqlSb.append("          '记账明细' ");
  		sqlSb.append("         when 2 then ");
  		sqlSb.append("          '医嘱' ");
  		sqlSb.append("         else ");
  		sqlSb.append("          '未知' ");
  		sqlSb.append("       end) as name_rfditmtp, ");
  		sqlSb.append("       rtm.quan, ");
  		sqlSb.append("       cg.id_srv, ");
  		sqlSb.append("       cg.code_srv, ");
  		sqlSb.append("       cg.name_srv, ");
  		sqlSb.append("       cg.id_mm, ");
  		sqlSb.append("       cg.code_mm, ");
  		sqlSb.append("       cg.name_mm, ");
  		sqlSb.append("       rtm.id_ent, ");
  		sqlSb.append("       rtm.id_pat, ");
  		sqlSb.append("       ent.name_pat, ");
  		sqlSb.append("       rtm.id_or, ");
  		sqlSb.append("       ord.name_or, ");
  		sqlSb.append("       ord.code_or, ");
  		sqlSb.append("       rtm.id_cgip, ");
  		sqlSb.append("       cg.code_cg, ");
		sqlSb.append("       cg.price_ratio as price, ");
		sqlSb.append("       rap.code_rfdap as code_ap,");
  		sqlSb.append("       rtm.des as itm_des, ");
  		sqlSb.append("       rtm.id_su_rdfitm, ");
  		sqlSb.append("       rtm.id_rfdaptp, ");
  		sqlSb.append("       rtm.sd_su_rdfitm, ");
  		sqlSb.append("       rtm.sd_rfdaptp, ");
  		sqlSb.append("       udi2.name as name_rfdaptp, ");
  		sqlSb.append("       udi1.name as name_su_rdfitm ");
  		sqlSb.append("  from bl_rfd_itm rtm ");
  		sqlSb.append("  left join bl_cg_ip cg ");
  		sqlSb.append("    on cg.id_cgip = rtm.Id_Cgip ");
  		sqlSb.append("  left join en_ent ent ");
  		sqlSb.append("    on ent.id_ent = rtm.id_ent ");
  		sqlSb.append("  left join ci_order ord ");
  		sqlSb.append("    on ord.id_or = rtm.id_or ");
  		sqlSb.append("  left join bd_udidoc udi1 ");
  		sqlSb.append("    on udi1.id_udidoc = rtm.id_su_rdfitm ");
  		sqlSb.append("  left join bd_udidoc udi2 ");
  		sqlSb.append("    on udi2.id_udidoc = rtm.id_rfdaptp ");
		sqlSb.append("  left join  bl_rfd_ap rap ");
		sqlSb.append("    on rap.id_rfdap = rtm.id_rfdap ");
  		sqlSb.append(" where 1 = 1");
  		sqlSb.append("  and rtm.id_su_rdfitm='").append(IBlCustomFileConst.ID_INAPPLY).append("' ");
  		sqlSb.append("   and rtm.fg_active = 'Y' ");
  		sqlSb.append(" and rtm.id_ent=? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_ent);
		if(!StringUtil.isEmpty(sd_rfdaptp)){
	  		sqlSb.append(" and rtm.sd_rfdaptp=?");
			sqlParam.addParam(sd_rfdaptp);
		}
  		sqlSb.append(" order by rtm.sortno  ");
		@SuppressWarnings("unchecked")
		List<BlRefundSrvItemDTO> entList = (List<BlRefundSrvItemDTO>) new DAFacade().execQuery(sqlSb.toString(), sqlParam,
				new BeanListHandler(BlRefundSrvItemDTO.class));
    	if(ListUtil.isEmpty(entList)){
    		 return null;
    	}
    	return entList.toArray(new BlRefundSrvItemDTO[]{});
      }
}
