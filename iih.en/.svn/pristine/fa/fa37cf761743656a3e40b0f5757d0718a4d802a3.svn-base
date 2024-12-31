package iih.en.que.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriagePatQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 通用队列管理(新)，获取列表患者信息
 * @author zhangpp
 *
 */
public class GetAllQueuePatNewBP {

	/**
	 * 获取列表患者信息,执行
	 * @param triagePat
	 * @return
	 */
	public TriagePatInfoDTO[] exec(TriagePatQryDTO triagePat) throws BizException {
		
		//校验参数
		validate(triagePat);
		//查询数据
		TriagePatInfoDTO[] triagePats = getTriagePat(triagePat);
		//组装数据
		assemble(triagePats);
		return triagePats;
	}
	
	/**
	 * 校验入参参数
	 * @param triagePat
	 */
	private void validate(TriagePatQryDTO triagePat) throws BizException {
		if (EnValidator.isEmpty(triagePat.getId_site())) {
			throw new BizException("工作点不能为空！");
		}
		if (EnValidator.isEmpty(triagePat.getId_ben())) {
			throw new BizException("分诊台为空！");
		}
		if (EnValidator.isEmpty(triagePat.getId_dayslot())) {
			throw new BizException("午别不能为空！");
		}
	}

	/**
	 * 查询TriagePatInfoDTO
	 * @param triagePat
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private TriagePatInfoDTO[] getTriagePat(TriagePatQryDTO triagePat) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" select ");
		sqlBuilder.append(" 1 as call, ");
		sqlBuilder.append(" eq.sortno as sortno, ");
		sqlBuilder.append(" q.name as name_que, ");
		sqlBuilder.append(" pi.name as name_pat, ");
		sqlBuilder.append(" pi.dt_birth as age, ");
		sqlBuilder.append(" doc.name as name_sex, ");
		sqlBuilder.append(" eq.sd_status_acpt as sd_status, ");
		sqlBuilder.append(" ben.name as name_ben, ");
		sqlBuilder.append(" eq.dt_regist as dt_app, ");
		sqlBuilder.append(" eq.dt_in as dt_in, ");
		sqlBuilder.append(" eq.level_pri as level_pri, ");
		sqlBuilder.append(" eq.level_pri_rsn as level_pri_rsn, ");
		sqlBuilder.append(" eq.id_ent_que as id_ent_que, ");
		sqlBuilder.append(" eq.id_pat as id_pat ");
		sqlBuilder.append(" from en_ent_que eq ");
		sqlBuilder.append(" inner join bd_que q on eq.id_que = q.id_que ");
		sqlBuilder.append(" inner join pi_pat pi on eq.id_pat = pi.id_pat ");
		sqlBuilder.append(" inner join bd_que_ben ben on ben.id_queben = q.id_queben ");
		sqlBuilder.append(" left join bd_udidoc doc on pi.id_sex = doc.id_udidoc ");
		sqlBuilder.append(" where ");
		//工作点
		sqlBuilder.append(" eq.id_que_site = ? ");
		param.addParam(triagePat.getId_site());
		//分诊台
		sqlBuilder.append(" and eq.id_queben = ? ");
		param.addParam(triagePat.getId_ben());
		//就诊日期
		sqlBuilder.append(" and eq.dt_regist = ? ");
		param.addParam(EnAppUtils.getServerDate());
		//午别
		if (!"ALL".equals(triagePat.getId_dayslot())) {
			sqlBuilder.append(" and eq.id_dateslot = ? ");
			param.addParam(triagePat.getId_dayslot());
		}
		//队列状态
		String[] chbState = GetChbState(triagePat);
		if (!ArrayUtil.isEmpty(chbState)) {
			sqlBuilder.append(" and eq.sd_status_acpt in (");
			for (int i = 0; i < chbState.length; i++) {
				if (i == chbState.length - 1) {
					sqlBuilder.append(" ?)");
				} else {
					sqlBuilder.append(" ?,");
				}
				param.addParam(chbState[i]);
			}
		} else {
			return new TriagePatInfoDTO[0];
		}
		sqlBuilder.append(" order by eq.level_pri desc nulls last, sortno ");
		List<TriagePatInfoDTO> list = (List<TriagePatInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(TriagePatInfoDTO.class));
		if (ListUtil.isEmpty(list)) {
			return new TriagePatInfoDTO[0];
		}
		return list.toArray(new TriagePatInfoDTO[0]);
	}
	
	/**
	 * 获取队列状态信息，组装成String[]
	 * @param triagePat
	 * @return
	 */
	private String[] GetChbState(TriagePatQryDTO triagePat){
		List<String> list = new ArrayList<String>();
		if (FBoolean.TRUE.equals(triagePat.getFg_triage())){
			list.add("0");
		}
		if (FBoolean.TRUE.equals(triagePat.getFg_called())){
			list.add("1");
			list.add("2");
		}
		if (FBoolean.TRUE.equals(triagePat.getFg_check())){
			list.add("7");
		}
		if (FBoolean.TRUE.equals(triagePat.getFg_checked())){
			list.add("8");
		}
		return list.toArray(new String[0]);
	}
	
	/**
	 * 组装数据
	 * @param triagePats
	 */
	private void assemble(TriagePatInfoDTO[] triagePats){
		for (TriagePatInfoDTO triagePatInfo : triagePats) {
			if (!EnValidator.isEmpty(triagePatInfo.getAge())) {
				triagePatInfo.setAge(EnAppUtils.getAge(FDate.getDate(triagePatInfo.getAge())) + "岁");
			}
			if (IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(triagePatInfo.getSd_status())) {
				triagePatInfo.setName_status("分诊");
			} else if (IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(triagePatInfo.getSd_status())) {
				triagePatInfo.setName_status("叫号");
			} else if (IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(triagePatInfo.getSd_status())) {
				triagePatInfo.setName_status("过号");
			} else if (IEnDictCodeConst.SD_STATUS_ACPT_CHECKED.equals(triagePatInfo.getSd_status())) {
				triagePatInfo.setName_status("处置");
			} else if (IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED.equals(triagePatInfo.getSd_status())) {
				triagePatInfo.setName_status("处毕");
			}
		}
	}
	
}
