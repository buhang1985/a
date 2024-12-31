package iih.en.er.bp.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErOutPatinQuirDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetErPreEntByIdErPreBP {

	public EnErOutPatinQuirDTO[] exec(String id_erpre) throws BizException{
		if(EnValidator.isEmpty(id_erpre)){
			return null;
		}
		List<EnErOutPatinQuirDTO> list = this.getFstaidEntDetails(id_erpre);
		List<EnErOutPatinQuirDTO> obslist = this.getObsEntDetails(id_erpre);
		if(obslist != null && obslist.size() > 0){
			for(EnErOutPatinQuirDTO dto : obslist){
				if(list != null && list.size() > 0 && !list.contains(dto)){
					list.add(dto);
				}
			}
		}
		if(list != null && list.size() > 0){
			for(EnErOutPatinQuirDTO dto: list){
				dto.setEntno(String.valueOf(list.indexOf(dto)+1));
			}
		}
		return list != null && list.size() > 0 ? list.toArray(new EnErOutPatinQuirDTO[0]):null;
	}
	/***
	 * 获取流水、抢救就诊详情
	 * @param id_erpre
	 * @return
	 * @throws BizException
	 */
	private List<EnErOutPatinQuirDTO> getFstaidEntDetails(String id_erpre) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select pre.code, " );
		sql.append("pat.name name_pat, " );
		sql.append("substr(ent.dt_entry,1,10) dt_entry, " );
		sql.append("entp.name name_entp, " );
		sql.append("ca.name name_patca, " );
		sql.append("status.name name_status, " );
		sql.append("doc.name name_emp_phy, " );
		sql.append("bed.name name_bed, " );
		sql.append("dep.name name_dep_phy, " );
		sql.append("nur.name name_dep_nur, " );
		sql.append("ent.dt_acpt, " );
		sql.append("op.times_op times " );
		sql.append("from en_erpre pre " );
		sql.append("inner join pi_pat pat on pat.id_pat = pre.id_pat " );
		sql.append("inner join en_ent_op_er oper on oper.id_erpre = pre.id_erpre " );
		sql.append("inner join en_ent_op op on op.id_ent = oper.id_ent " );
		sql.append("inner join en_ent ent on ent.id_ent = op.id_ent " );
		sql.append("inner join bd_entp entp on entp.code = ent.code_entp " );
		sql.append("inner join pi_pat_ca ca on ca.id_patca = ent.id_patca " );
		sql.append("inner join bd_udidoc status on status.code = op.sd_status and status.id_udidoclist = '@@@@ZZ2000000000006C' " );
		sql.append("left join bd_psndoc doc on doc.id_psndoc = ent.id_emp_phy " );
		sql.append("left join bd_bed bed on bed.id_bed = oper.id_bed " );
		sql.append("left join bd_dep dep on dep.id_dep = ent.id_dep_phy " );
		sql.append("left join bd_dep nur on nur.id_dep = ent.id_dep_nur " );
		sql.append("where pre.id_erpre = ? " );
		sql.append("order by op.times_op ");
		SqlParam param = new SqlParam();
		param.addParam(id_erpre);
		List<EnErOutPatinQuirDTO> list = (List<EnErOutPatinQuirDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnErOutPatinQuirDTO.class));
		return list;
	}
	/***
	 * 获取留观就诊详情
	 * @param id_erpre
	 * @return
	 * @throws BizException
	 */
	private List<EnErOutPatinQuirDTO> getObsEntDetails(String id_erpre) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select pre.code, " );
		sql.append("pat.name name_pat, " );
		sql.append("substr(ent.dt_entry,1,10) dt_entry, " );
		sql.append("entp.name name_entp, " );
		sql.append("ca.name name_patca, " );
		sql.append("status.name name_status, " );
		sql.append("doc.name name_emp_phy, " );
		sql.append("bed.name name_bed, " );
		sql.append("dep.name name_dep_phy, " );
		sql.append("nur.name name_dep_nur, " );
		sql.append("ent.dt_acpt, " );
		sql.append("ip.times_ip times " );
		sql.append("from en_erpre pre " );
		sql.append("inner join pi_pat pat on pat.id_pat = pre.id_pat " );
		sql.append("inner join en_ent_ip_er er on er.id_erpre = pre.id_erpre " );
		sql.append("inner join en_ent_ip ip on ip.id_ent = er.id_ent " );
		sql.append("inner join en_ent ent on ent.id_ent = ip.id_ent " );
		sql.append("inner join bd_entp entp on entp.code = ent.code_entp " );
		sql.append("inner join pi_pat_ca ca on ca.id_patca = ent.id_patca " );
		sql.append("inner join bd_udidoc status on status.code = ip.sd_status and status.id_udidoclist = '@@@@ZZ2000000000006C' " );
		sql.append("left join bd_psndoc doc on doc.id_psndoc = ent.id_emp_phy " );
		sql.append("left join bd_bed bed on bed.id_bed = ip.id_bed " );
		sql.append("left join bd_dep dep on dep.id_dep = ent.id_dep_phy " );
		sql.append("left join bd_dep nur on nur.id_dep = ent.id_dep_nur " );
		sql.append("where pre.id_erpre = ? " );
		sql.append("order by ip.times_ip");
		SqlParam param = new SqlParam();
		param.addParam(id_erpre);
		List<EnErOutPatinQuirDTO> list = (List<EnErOutPatinQuirDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnErOutPatinQuirDTO.class));
		return list;
	}
}
