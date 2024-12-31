package iih.ci.ord.printmanage.srv;

import iih.ci.ord.printmanage.dto.OutExecOrderItemDTO;
import iih.ci.ord.printmanage.dto.OutExedepHeadDTO;
import iih.ci.ord.printmanage.dto.OutSendExecInfoDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

import com.mysql.jdbc.StringUtils;

public class OutSendExecPrintService {

	public List<OutExedepHeadDTO> exec(String ids) throws Exception {
	
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		//查询医嘱信息
		List<OutSendExecInfoDTO> execInfoDTOs = this.getOrderList(this.getOrdInfoSqlQry(ids));
		
		//
		Map<String, OutExedepHeadDTO> headDTOMap = new HashMap<String, OutExedepHeadDTO>(); 
		
		List<OutExedepHeadDTO> exedepHeadDTOs = new ArrayList<OutExedepHeadDTO>();
		
		for (OutSendExecInfoDTO outSendExecInfoDTO : execInfoDTOs) {
			
			String id = outSendExecInfoDTO.getId_ent()+","+outSendExecInfoDTO.getId_dep_mp();//以就诊id，和执行科室作为逻辑主键
			
			OutExecOrderItemDTO itemDTO = new OutExecOrderItemDTO();
			itemDTO.setId_or(outSendExecInfoDTO.getId_or());
			
			itemDTO.setName_or(outSendExecInfoDTO.getName_or());
			itemDTO.setName_su_bl(outSendExecInfoDTO.getName_su_bl());
			itemDTO.setSd_su_bl(outSendExecInfoDTO.getSd_su_bl());
			itemDTO.setPri_total(outSendExecInfoDTO.getPri_total());
			itemDTO.setQuan_medu(outSendExecInfoDTO.getQuan_medu());
			itemDTO.setContent_or(outSendExecInfoDTO.getContent_or());
			
			if(headDTOMap.containsKey(id)){
				
				headDTOMap.get(id).getItemdtolist().add(itemDTO);
			}else {
				
				OutExedepHeadDTO headDTO = new OutExedepHeadDTO();
				
				exedepHeadDTOs.add(headDTO);
				
				List<OutExecOrderItemDTO> itemDTOs = new ArrayList<OutExecOrderItemDTO>();
				
				itemDTOs.add(itemDTO);
				headDTO.setItemdtolist(itemDTOs);
				headDTO.setName_bed(outSendExecInfoDTO.getName_bed());
				headDTO.setId_org(outSendExecInfoDTO.getId_org());
				headDTO.setName_org(outSendExecInfoDTO.getName_org());
				headDTO.setCode_amr_ip(outSendExecInfoDTO.getCode_amr_ip());
				headDTO.setDt_birth(outSendExecInfoDTO.getDt_birth_pat());
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(headDTO.getDt_birth());
				FDate dt = new FDate(birth);
				headDTO.setAge(AgeCalcUtil.getAge(dt));
				headDTO.setId_dep_or(outSendExecInfoDTO.getId_dep_or());
				headDTO.setId_dep_mp(outSendExecInfoDTO.getId_dep_mp());
				headDTO.setName_dep_or(outSendExecInfoDTO.getName_dep_or());
				headDTO.setName_dep_mp(outSendExecInfoDTO.getName_dep_mp());
				headDTO.setName_pati(outSendExecInfoDTO.getName_pat());
				
				headDTOMap.put(id, headDTO);
			}
			

			
		}
	
		//计算费用合计
		for (OutExedepHeadDTO outExedepHeadDTO : exedepHeadDTOs) {
			
			List<OutExecOrderItemDTO> arrayList = outExedepHeadDTO.getItemdtolist();
			
			FDouble pri = new FDouble();
			for (OutExecOrderItemDTO outExecOrderItemDTO : arrayList) {
				FDouble fee =  new FDouble(outExecOrderItemDTO.getPri_total());
				pri = pri.add(fee);
				
			}
			
			outExedepHeadDTO.setFee_total(pri.setScale(-2, FDouble.ROUND_HALF_UP)+"");
		}
		
		return exedepHeadDTOs;
	}
	
	//获取送检单信息
	private List<OutSendExecInfoDTO> getOrderList(String sqlQry) throws Exception {
		List<OutSendExecInfoDTO> result = CiorderPrintUtils.GetQueryResulte(OutSendExecInfoDTO.class, sqlQry);
		return result;
	}
	
	/**
	 * 查询医嘱信息
	 * @param ids
	 * @return
	 */
	private String getOrdInfoSqlQry(String ids) {
		
		StringBuilder str = new StringBuilder();
		
		str.append(" select");
		str.append(" cior.id_or,");
		str.append(" cior.id_en as id_ent,");
		str.append(" ORG.ID_ORG,");
		str.append(" ORG.NAME as name_org,");
		str.append(" enentip.code_amr_ip,");
		str.append(" enent.name_pat,");
		str.append(" enent.dt_birth_pat,");
		str.append(" enentip.name_bed,");
		str.append(" cior.id_dep_mp,");
		str.append(" cior.id_dep_or,");
		str.append(" depor.name as name_dep_or,");
		str.append(" depmp.name as name_dep_mp,");
		
		
		str.append(" cior.name_or,");
		str.append(" cior.quan_medu,");
		str.append(" ( ");
		str.append("  select sum(orsrv.pri*orsrv.quan_medu)");
		str.append("  from ci_or_srv orsrv where orsrv.id_or=cior.id_or and orsrv.fg_bl='Y' ");
		str.append("  group by orsrv.id_or");
		str.append("   ) as pri_total,");
		str.append("  cior.sd_su_bl,");
		str.append("  cior.content_or,");
		str.append("  udi.name as name_su_bl");
		
		str.append("  from ci_order cior ");
		str.append("  left join bd_org ORG on ORG.id_org = cior.id_org ");
		str.append("  inner join en_ent enent on enent.id_ent = cior.id_en");
		str.append("  inner join en_ent_ip enentip on enentip.id_ent = enent.id_ent");
		str.append(" left join bd_dep depor on depor.id_dep = cior.id_dep_or ");
		str.append(" left join bd_dep depmp on depmp.id_dep = cior.id_dep_mp ");
		str.append(" left join bd_udidoc udi on udi.id_udidoc = cior.id_su_bl ");
		
		
		String wherestr = "";
		if (!StringUtils.isNullOrEmpty(ids)) {

			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " cior.Id_or in (" + ids + ") and cior.sd_su_or in ('20','30','60') order by cior.Id_en,cior.Dt_chk desc";
		}
		str.append(wherestr);
		return str.toString();
	}

}
