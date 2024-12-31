package iih.en.pv.s.bp.mt.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.MedTechTransDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医技转出申请列表
 * @author Administrator
 *
 */
public class GetTransOutAppBP {
	/**
	 * 获取医技转出申请列表
	 * @param depId 科室ID
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MedTechTransDTO[] exec(String depId) throws BizException {
		MedTechTransDTO[] medTechTrans = null;
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT EN.ID_DEP_PHY AS ID_DEP_PHY,PHYDEP.NAME AS NAME_DEP_PHY,IP.NAME_BED AS NAME_BED,");
		builder.append(" EN.CODE AS CODE_ENT,EN.ID_PAT AS ID_PAT,EN.NAME_PAT AS NAME_PAT,ED.DT_B AS DT_B,");
		builder.append(" TRUNC(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EN.DT_BIRTH_PAT,1,10),'yyyy-mm-dd'))/12) AS AGE,");
		builder.append(" EN.ID_DEP_NUR AS ID_DEP_NUR,NURDEP.NAME AS NAME_DEP_NUR,ED.ID_ENTDEP AS ID_ENTDEP ");
		builder.append(" FROM EN_ENT_DEP ED INNER JOIN EN_ENT EN ON ED.ID_ENT=EN.ID_ENT ");
		builder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT=IP.ID_ENT ");
		builder.append(" INNER JOIN BD_DEP PHYDEP ON EN.ID_DEP_PHY=PHYDEP.ID_DEP ");
		builder.append(" INNER JOIN BD_DEP NURDEP ON EN.ID_DEP_NUR=NURDEP.ID_DEP ");
		builder.append(" WHERE ED.SD_ENTDEPROLE=? AND ED.SD_STATUS=? AND ISNULL(ED.DT_E,'~')='~' AND ED.ID_DEP=? AND EN.FG_IP='Y' ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_MT);
		param.addParam(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);
		param.addParam(depId);
		List<MedTechTransDTO> list = (List<MedTechTransDTO>) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(
						MedTechTransDTO.class));
		if (!EnValidator.isEmpty(list)) {
			medTechTrans = list.toArray(new MedTechTransDTO[0]);
		}
		return medTechTrans;
	}
}
