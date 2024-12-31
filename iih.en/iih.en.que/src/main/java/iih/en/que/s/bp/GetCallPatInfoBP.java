package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.ReceptionQueDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/****
 * 获取当前叫号患者信息
 * @author fanlq
 *
 */
public class GetCallPatInfoBP {

	/***
	 * 获取当前叫号患者信息
	 * @author fanlq 
	 * @param que
	 * @param queSite
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public ReceptionQueDTO exec(QueDO que, QueSiteDO queSite, FDate date, String dayslotId) throws BizException{
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("select pat.id_pat as Id_pat,pat.name as Name_pat,pat.dt_birth as Dt_birth_pat,d.name as Name_sex,eq.id_ent as Id_ent ");
		sb.append("from en_ent_que eq ");
		sb.append("left join pi_pat pat on pat.id_pat = eq.id_pat ");
		sb.append("left join bd_udidoc d on d.id_udidoc = pat.id_sex ");
		sb.append("left join en_ent ent  on ent.id_ent = eq.id_ent ");
		sb.append("where 1=1  and ent.fg_canc = 'N' ");
		if(que != null && !EnValidator.isEmpty(que.getId_que())){
			sb.append("and eq.id_que = ? ");
			param.addParam(que.getId_que());
		}
		if(queSite != null && !EnValidator.isEmpty(queSite.getId_quesite())){
			sb.append("and eq.id_que_site = ? ");
			param.addParam(queSite.getId_quesite());
		}
		if(date != null){
			sb.append("and eq.dt_regist = ? ");
			param.addParam(date);
		}
		if(!EnValidator.isEmpty(dayslotId)){
			sb.append("and eq.id_dateslot = ? ");
			param.addParam(dayslotId);
		}
		sb.append("and eq.sd_status_acpt = ? ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		sb.append("and EQ.SD_ENTQUE_TP  = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		@SuppressWarnings("unchecked")
		List<ReceptionQueDTO> list = (List<ReceptionQueDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(ReceptionQueDTO.class));
		if(list != null && list.size() == 1){
			//list.get(0).setAge(AgeCalcUtil.getAge(list.get(0).getDt_birth_pat()));
			EnAgeCalcUtil.setDoAges(new ReceptionQueDTO[]{list.get(0)}, "Id_ent", "Age");
			return list.get(0);
		}
		return null;
	}
}
