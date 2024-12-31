package iih.en.que.s.bp.er;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageEntDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * TriageEntDTO 急诊信息处理
 * 
 * @author liubin
 *
 */
public class HandleTriageEntErInfoBP {
	/**
	 * TriageEntDTO急诊信息查询
	 * 
	 * @param ents
	 * @param codeEntp
	 * @throws BizException
	 */
	public void exec(TriageEntDTO[] ents, String codeEntp) throws BizException {
		if(EnValidator.isEmpty(ents) || !IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(codeEntp))
			return;
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", ents);
		TriageEntDTO[] erInfos = getErInfos(entIds);
		new ErPreEP().setErScoleName(erInfos, "Sd_scale_triage", "Name_scale_triage");
		Map<String, TriageEntDTO> map = EnFMapUtils.getMap("Id_ent", erInfos);
		if(map == null || map.isEmpty())
			return;
		FDateTime curDateTime = EnAppUtils.getServerDateTime();
		for(TriageEntDTO ent : ents){
			if(!map.containsKey(ent.getId_ent()))
				continue;
			TriageEntDTO erInfo = map.get(ent.getId_ent());
			ent.setId_erpre(erInfo.getId_erpre());
			ent.setId_scale_triage(erInfo.getId_scale_triage());
			ent.setSd_scale_triage(erInfo.getSd_scale_triage());
			ent.setName_scale_triage(erInfo.getName_scale_triage());
			ent.setDt_entry_erpre(erInfo.getDt_entry_erpre());
			ent.setTime_retention(DateTimeUtils.getTimeLength(erInfo.getDt_entry_erpre(), curDateTime));
		}
	}
	
	/**
	 * 急诊信息查询
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private TriageEntDTO[] getErInfos(String[] entIds)throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.ID_ENT, ");
		sqlBuilder.append(" ERPRE.ID_ERPRE, ");
		sqlBuilder.append(" OPER.ID_SCALE_TRIAGE AS ID_SCALE_TRIAGE, ");
		sqlBuilder.append(" OPER.SD_SCALE_TRIAGE AS SD_SCALE_TRIAGE, ");
		sqlBuilder.append(" ERPRE.DT_ENTRY AS DT_ENTRY_ERPRE  ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON EN.ID_ENT = OPER.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN EN_ERPRE ERPRE ON OPER.ID_ERPRE = ERPRE.ID_ERPRE  ");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC SCALE ON OPER.ID_SCALE_TRIAGE = SCALE.ID_UDIDOC  ");
		sqlBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		String sql = sqlBuilder.toString();
		@SuppressWarnings("unchecked")
		List<TriageEntDTO> list = (List<TriageEntDTO>) new DAFacade().execQuery(sql, new BeanListHandler(TriageEntDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new TriageEntDTO[list.size()]);
	}
}
