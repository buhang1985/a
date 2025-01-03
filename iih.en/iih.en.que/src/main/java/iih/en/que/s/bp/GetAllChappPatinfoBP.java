package iih.en.que.s.bp;

import iih.en.comm.IEnConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.que.dto.d.MedTechAppDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetAllChappPatinfoBP {
	/**
	 * 根据分诊台，状态，午别查询患者列表
	 * 
	 * @param benId
	 *            工作台id
	 * @param acptStatus
	 *            状态
	 * @param dateslot
	 *            午别
	 * @return
	 */
	public MedTechAppDTO[] exec(String benId, String acptStatus, String dateslot, String queID,FBoolean fg_manual) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" select eq.ticketno as no_applyform,");
		sqlBuilder.append(" pi.name as name_pat,");
		sqlBuilder.append(" eq.dt_in as dt_in,");
		sqlBuilder.append(" pi.dt_birth as age,");
		sqlBuilder.append(" pi.id_sex as name_sex,");
		sqlBuilder.append(" pi.id_pat as id_pat,");
		sqlBuilder.append(" pi.code as code_pat,");
		sqlBuilder.append(" eq.sd_status_acpt as name_triage_status,");
		sqlBuilder.append(" s.name as quesite_name,");
		sqlBuilder.append(" eq.id_que_site as id_que_site,");
		sqlBuilder.append(" eq.level_pri as level_pri,");
		sqlBuilder.append(" eq.level_pri_rsn as level_reason,");
		sqlBuilder.append(" eq.id_ent_que as id_ent_que,");
		sqlBuilder.append(" eq.id_dateslot as dayslotsec");
		sqlBuilder.append(" from EN_ENT_QUE eq");
		sqlBuilder.append(" left join bd_que q on eq.id_que = q.id_que");
		sqlBuilder.append(" left join bd_que_site s on q.id_que = s.id_que");
		sqlBuilder.append("    and s.id_quesite = eq.id_que_site");
		sqlBuilder.append(" inner join pi_pat pi on eq.id_pat = pi.id_pat");
		sqlBuilder.append(" where eq.id_queben = ?");
		param.addParam(benId);
		sqlBuilder.append(" and eq.sd_entque_tp = 9");
		sqlBuilder.append(" and eq.dt_regist =to_char(sysdate,'yyyy-MM-dd')");
		
		if(fg_manual != null)
		{
			sqlBuilder.append(" and eq.fg_manual = ?");
			param.addParam(fg_manual.toString());
		}
		
		if (!dateslot.equals("ALL")) {
			sqlBuilder.append(" and eq.id_dateslot = ?");
			param.addParam(dateslot);
		}
		if (acptStatus.equals("到诊")) {
			sqlBuilder.append(" and eq.sd_status_acpt = '0'");
			sqlBuilder.append(" and eq.id_que_site is null ");
		} else if (acptStatus.equals("分诊")) {
			sqlBuilder.append(" and eq.sd_status_acpt = '0'");
			sqlBuilder.append(" and eq.id_que_site is not null ");
		} else if (acptStatus.equals("通知")) {
			sqlBuilder.append(" and eq.sd_status_acpt in ('1','2')");
		} else if (acptStatus.equals("处置")) {
			sqlBuilder.append(" and eq.sd_status_acpt = '7'");
		} else if (acptStatus.equals("处毕")) {
			sqlBuilder.append(" and eq.sd_status_acpt = '8'");
		}
		if (!"".equals(queID)) {
			sqlBuilder.append(" and eq.id_que_site = ?");
			sqlBuilder.append(" order by eq.level_pri desc nulls last, sortno");
			param.addParam(queID);
		}
		else
		{
			sqlBuilder.append(" order by eq.dt_in desc");
		}
		@SuppressWarnings("unchecked")
		List<MedTechAppDTO> list = (List<MedTechAppDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(MedTechAppDTO.class));
		if (list == null) {
			return new MedTechAppDTO[0];
		}
		for ( int i = 0;i < list.size();i++) {
			MedTechAppDTO mtDTO = (MedTechAppDTO)list.get(i);
			if (mtDTO.getName_sex() == IEnConst.SEX_ID_BOY) {
				mtDTO.setName_sex(IEnConst.SEX_NAME_BOY);
			} else if (mtDTO.getName_sex() == IEnConst.SEX_ID_GIRL) {
				mtDTO.setName_sex(IEnConst.SEX_NAME_GIRL);
			} else {
				mtDTO.setName_sex(IEnConst.SEX_NAME_UNKNOWN);
			}
			if(mtDTO.getAge() != null){
				mtDTO.setAge(EnAppUtils.getAge(FDate.getDate(mtDTO.getAge())) + "岁");
			}
			if (mtDTO.getName_triage_status() == "0" && (mtDTO.getId_que_site() == "" || mtDTO.getId_que_site() == null )) {
				mtDTO.setName_triage_status("到诊");
			} else if (mtDTO.getName_triage_status() == "0" && mtDTO.getId_que_site() != "") {
				mtDTO.setName_triage_status("分诊");
			} else if (mtDTO.getName_triage_status() == "1") {
				mtDTO.setName_triage_status("叫号");
			} else if (mtDTO.getName_triage_status() == "2") {
				mtDTO.setName_triage_status("过号");
			} else if (mtDTO.getName_triage_status() == "7") {
				mtDTO.setName_triage_status("处置");
			} else if (mtDTO.getName_triage_status() == "8") {
				mtDTO.setName_triage_status("处毕");
			}
			mtDTO.setSortno(String.valueOf(i+1));
		}
		return list.toArray(new MedTechAppDTO[0]);
	}
}
