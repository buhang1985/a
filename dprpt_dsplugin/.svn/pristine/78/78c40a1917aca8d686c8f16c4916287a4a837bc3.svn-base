package iih.ci.ord.printmanage.srv.ord;

import java.util.Date;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.CiBloodAdverseReactionCountDTO;
import iih.ci.ord.printmanage.dto.ItemDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 *  输血不良反应统计打印 Service 
 *  2018年2月9日
 *  @author LiYue
 *  
 */
public class CiBloodAdverseReactionCountService implements ICiorderPrintService<CiBloodAdverseReactionCountDTO, ItemDTO>  {

	/**
	 * 
	 * @param code_entp 门诊类型
	 * @param qry_begin_date 开始时间
	 * @param qry_end_date 截止时间
	 * @param bad_reaction_type 有无不良反应
	 * @param orderStr 排序参数
	 * @return
	 * @throws Exception
	 */
	public List<CiBloodAdverseReactionCountDTO> exec1 ( String code_entp , String qry_begin_date , String qry_end_date , String bad_reaction_type , String orderStr ) throws Exception {
	
	//          后端名称     = 前端名称
		String codeEntp   = code_entp;
		String beginDate  = qry_begin_date;
		String endDate    = qry_end_date;
		String condition  = bad_reaction_type;
		                    
		List<CiBloodAdverseReactionCountDTO>  preslist = this.getOrderList( this.getOrdInfoSqlQry( codeEntp ,  beginDate ,  endDate ,  condition ,  orderStr ) );
		
		 setOrdInfo(preslist);
		return preslist;
	}
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CiBloodAdverseReactionCountDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		return this.exec(ids);
	}

	//SQL查询拼接

public String getOrdInfoSqlQry(String codeEntp , String beginDate , String endDate , String condition , String orderStr){            //外键ID
	StringBuilder str = new StringBuilder();
	
	str.append(" select rownum, ");
	
	str.append("  blood.id_ar,");
	
	str.append(" blood.use_id_or, ");
	
	str.append("DE.name as Name_en_ward ,");
	
	str.append(" blood.pre_id_or, ");
	
	str.append(" p.name as name_pat,");
	
	str.append("  (case ");
	
	str.append(" when c.code_entp = '00' then '门诊' ");

	str.append(" when c.code_entp = '10' then  '住院' " );
	
	str.append(" else ' ' ");
	
	str.append(" end) as name_entp, ");
	
	str.append("  c.code_entp, ");
	
	str.append(" bu.no_applyform as use_apply_no, ");
	
	str.append("  bt.no_applyform as pre_apply_no, ");
	
	str.append("  p.code as code_pat, ");
	
	str.append(" (case ");
	
	str.append("  when F.Times_Ip is null then 0 ");
	
	str.append(" else F.Times_Ip   end) + (case ");
	
	str.append(" when J.Times_Op is null then 0 ");
	
	str.append(" else ");
	
	str.append(" J.Times_Op ");
	
	str.append("   end) as en_times, ");
	
	str.append("  u1.name as sex, ");
	
	str.append("  p.dt_birth as age, ");
	
	str.append("  dep.name as name_en_dept, ");
	
	str.append("   (case ");
	
	str.append("  when blood.fg_tran_blood_bad_reaction = 'N' then '查看'");
	
	str.append(" else ");
	
	str.append("  '无' ");
	
	str.append("  end) as bad_reaction ");	
	
	str.append("  from ci_blood_adverse_reaction blood   ");
	
	str.append("  left outer join ci_order c on blood.use_id_or = c.id_or ");
	
 	str.append("  left outer join en_ent_ip ENTIP on ENTIP.id_ent = c.id_en ");	
 	str.append("  left outer join bd_dep DE on DE.id_dep = ENTIP.Id_dep_nuradm ");
	
	str.append("  left outer join ci_ap_bu bu on blood.use_id_or = bu.id_or");
	
	str.append("  left outer join pi_pat p on c.id_pat = p.id_pat");
	
	str.append("  left outer join bd_udidoc u1 on p.id_sex = u1.id_udidoc");
	
	str.append("  left outer join ci_ap_bt bt on bt.id_or = c.id_or_rel");
	
	str.append("  left outer join bd_dep dep on c.id_dep_or = dep.id_dep ");
	
	str.append("  left outer join en_ent_ip F ON C.Id_En = F.Id_Ent ");
	
	str.append("  left outer join en_ent_op J ON C.Id_En = J.Id_Ent ");
	
	str.append(" where c.fg_canc = 'N' ");
	
	

	if (codeEntp!=null && !codeEntp.isEmpty()) {	
		if(!"0".equals(codeEntp)){
			str.append("  and  c.code_entp='"+codeEntp+"'  ");
		}
		
	} 
	
	if (beginDate!=null && !beginDate.isEmpty()) {	

		str.append("   and blood.report_time >= '"+ beginDate +" 00:00:00'  ");

	}
	
	if (endDate!=null && !endDate.isEmpty()) {	
		
		str.append("   and blood.report_time <= '"+ endDate +" 23:59:59'  ");
		
	}
	
	if (condition!=null && !condition.isEmpty()) {
		
		//2 表示全部
		
		if("2".equals(condition)){
			
		}else{
		 String condition_append = " and blood.fg_tran_blood_bad_reaction=";
		    if("1".equals(condition)){
		 	   str.append(condition_append + "'N'");
		      }else if("0".equals(condition)){
			str.append(condition_append + "'Y'");
		    }
		}
	}
//  排序取消	
//	if (orderStr!=null && !orderStr.isEmpty()) {	
//		
//		str.append(" order by blood."+orderStr);
//	}

//



	return str.toString();
	

	}

	/**
	 * 获取检验、检查、诊疗医嘱信息
	 */
	@Override
	public List<CiBloodAdverseReactionCountDTO> getOrderList(String sqlQry) throws Exception {
		List<CiBloodAdverseReactionCountDTO> result = CiorderPrintUtils.GetQueryResulte(CiBloodAdverseReactionCountDTO.class, sqlQry);

		return result;
	}

	/**
	 * 
	 */
	@Override
	public String getItmInfoSqlQry(String id) {
		return "";
	}

	@Override
	public List<ItemDTO> getItemList(String sqlQry) throws Exception {
		List<ItemDTO> result = CiorderPrintUtils.GetQueryResulte(ItemDTO.class, sqlQry);
		
		return result;
	}

	/**
	 * 
	 */
	@Override
	public void setOrdInfo(List<CiBloodAdverseReactionCountDTO> dtos) throws Exception {
		// 设置年龄（格式）
		for (CiBloodAdverseReactionCountDTO dto : dtos) {
			
			if (dto.getAge() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(dto.getAge());
				FDate dt = new FDate(birth);
				dto.setAge(AgeCalcUtil.getAge(dt));
			}

		}
	}

	@Override
	public String getOrdInfoSqlQry(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiBloodAdverseReactionCountDTO> exec(String ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
