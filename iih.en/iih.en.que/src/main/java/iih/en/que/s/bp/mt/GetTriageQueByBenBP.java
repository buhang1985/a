package iih.en.que.s.bp.mt;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.util.AgeCalcUtil;

/***
 * 根据status获取待分诊的患者列表
 * 
 * @author fanlq
 * @date: 2020年1月6日 上午10:55:01
 */
public class GetTriageQueByBenBP {

	public TriagePatInfoDTO[] exec(TriageBenInfoDTO triageInfo, String dayslotId, int status) throws BizException {
		if (triageInfo == null || EnValidator.isEmpty(triageInfo.getId_queben())) {
			return null;
		}
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("SELECT PAT.ID_PAT AS ID_PAT, ");
		sql.append("PAT.CODE AS CODE_PAT, ");
		sql.append("EQ.NAME_PAT AS NAME_PAT, ");
		sql.append("EQ.ID_QUEBEN AS ID_BEN, ");
		sql.append("BEN.NAME AS NAME_BEN, ");
		sql.append("SIT.ID_QUESITE AS ID_SITE, ");
		sql.append("SIT.CODE AS SD_SITE, ");
		sql.append("SIT.NAME AS NAME_SITE, ");
		sql.append("EQ.SD_STATUS_ACPT AS SD_STATUS, ");
		sql.append("SIT.EU_PAUSE AS SD_STATUS_SITE, ");
		sql.append("EQ.SORTNO AS SORTNO, ");
		sql.append("EQ.DT_IN AS DT_IN, ");
		sql.append("EQ.DT_ACPT AS DT_ACPT, ");
		sql.append("PAT.DT_BIRTH AS DT_BIRTHDAY, ");
		sql.append("SEX.NAME AS NAME_SEX, ");
		sql.append("EQ.LEVEL_PRI AS LEVEL_PRI, ");
		sql.append("EQ.LEVEL_PRI_RSN AS LEVEL_PRI_RSN, ");
		sql.append("EQ.ID_QUE AS ID_QUE, ");
		sql.append("QUE.NAME AS NAME_QUE, ");
		sql.append("EQ.ID_ENT_QUE AS ID_ENT_QUE, ");
		sql.append("EQ.ID_DATESLOT AS ID_DAYSLOT, ");
		sql.append("LOT.CODE AS SD_DAYSLOT, ");
		sql.append("LOT.NAME AS NAME_DAYSLOT ");
		sql.append("FROM EN_ENT_QUE EQ ");
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = EQ.ID_PAT ");
		sql.append("INNER JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX ");
		sql.append("INNER JOIN BD_QUE_BEN BEN ON BEN.ID_QUEBEN = EQ.ID_QUEBEN ");
		sql.append("INNER JOIN BD_DAYSLOT LOT ON LOT.ID_DAYSLOT = EQ.ID_DATESLOT ");
		sql.append("LEFT JOIN BD_QUE_SITE SIT ON SIT.ID_QUESITE = EQ.ID_QUE_SITE ");
		sql.append("LEFT JOIN BD_QUE QUE ON QUE.ID_QUE = EQ.ID_QUE ");
		sql.append("WHERE EQ.ID_QUEBEN = ? ");
		sql.append("AND EQ.DT_REGIST = ? ");
		sql.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(triageInfo.getId_queben());
		param.addParam(EnAppUtils.getServerDate());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		if(EnValidator.isEmail(dayslotId)){
			sql.append("AND EQ.ID_DATESLOT = ? ");
			param.addParam(dayslotId);
		}
		if (status == EntQueStatus.Arrived) {
			sql.append("AND EQ.SD_STATUS_ACPT = ? ");
			sql.append("AND NVL(EQ.ID_QUE_SITE, '~') = '~' ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		} else if (status == EntQueStatus.Triaged) {
			sql.append("AND EQ.SD_STATUS_ACPT = ? ");
			sql.append("AND NVL(EQ.ID_QUE_SITE, '~') <> '~' ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		} else if (status == EntQueStatus.Called) {
			sql.append("AND EQ.SD_STATUS_ACPT IN (?,?) ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		} else if (status == EntQueStatus.Accept) {
			sql.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CHECKED);
		} else if (status == EntQueStatus.CHECKEDFINISH) {
			sql.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED);
		}
		sql.append("ORDER BY EQ.ID_DATESLOT,EQ.SORTNO ");
		@SuppressWarnings("unchecked")
		List<TriagePatInfoDTO> list = (List<TriagePatInfoDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(TriagePatInfoDTO.class));
		if(!EnValidator.isEmpty(list)){
			for(TriagePatInfoDTO dto : list){
				dto.setAge(AgeCalcUtil.getAge(dto.getDt_birthday()));
			}
			return list.toArray(new TriagePatInfoDTO[0]);
		}
		return null;
	}
}
