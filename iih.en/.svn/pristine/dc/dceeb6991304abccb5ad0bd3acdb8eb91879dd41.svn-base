package iih.en.pv.s.bp.mt.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.MedTechTransDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTransInAppBP {
	/**
	 * 获取医技转入申请列表
	 * @param depId 科室ID
	 * @return
	 * @throws BizException
	 */
	public MedTechTransDTO[] getTransInApp(String depId) throws BizException {
		MedTechTransDTO[] medTechTrans = null;
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT CI.ID_EN AS ID_ENT,EN.ID_DEP_PHY AS ID_DEP_PHY,PHYDEP.NAME AS NAME_DEP_PHY,IP.NAME_BED AS NAME_BED,");
		builder.append(" EN.CODE AS CODE_ENT,EN.ID_PAT AS ID_PAT,EN.NAME_PAT AS NAME_PAT,CI.ID_OR AS ID_OR,CI.CONTENT_OR AS OR_CONTENT,");
		builder.append(" TRUNC(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EN.DT_BIRTH_PAT,1,10),'yyyy-mm-dd'))/12) AS AGE,");
		builder.append(" AP.ID_ORTRANS AS ID_ORTRANS,CI.ID_EMP_SIGN AS ID_EMP_SIGN,PS.NAME AS NAME_EMP_SIGN,EN.ID_DEP_NUR AS ID_DEP_NUR,");
		builder.append(" NURDEP.NAME AS NAME_DEP_NUR,AP.ID_DEP_TO AS ID_DEP_TO ");
		builder.append(" FROM CI_AP_TRANS AP ");
		builder.append(" INNER JOIN CI_ORDER CI ON AP.ID_OR=CI.ID_OR AND CI.SD_SU_OR IN ('20','30','40','50') AND AP.SD_SU_TRANS IN ('1','2') AND AP.ID_DEP_TO=? ");
		builder.append(" AND AP.FG_TECH_TRANS='Y' ");
		builder.append(" INNER JOIN EN_ENT EN ON CI.ID_EN=EN.ID_ENT ");
		builder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT=IP.ID_ENT ");
		builder.append(" INNER JOIN BD_PSNDOC PS ON PS.ID_PSNDOC=CI.ID_EMP_SIGN ");
		builder.append(" INNER JOIN BD_DEP PHYDEP ON EN.ID_DEP_PHY=PHYDEP.ID_DEP ");
		builder.append(" INNER JOIN BD_DEP NURDEP ON EN.ID_DEP_NUR=NURDEP.ID_DEP ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(depId);
		@SuppressWarnings("unchecked")
		List<MedTechTransDTO> list = (List<MedTechTransDTO>) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(
						MedTechTransDTO.class));
		if (!EnValidator.isEmpty(list)) {
			medTechTrans = list.toArray(new MedTechTransDTO[0]);
		}
		return medTechTrans;
	}
}
