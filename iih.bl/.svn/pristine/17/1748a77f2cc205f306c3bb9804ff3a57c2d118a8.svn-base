package iih.bl.st.blstip.bp;

import iih.bl.st.blcgipdto.d.BlCgIpDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetBlCgIpItemByIdStBp {

	public BlCgIpDTO[] exec(String stipId) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select Z.id_srv,Z.eu_direct,Z.spec,m.name as UNIT,Z.name_srv,Z.name_mm,Z.amt,Z.amt_ratio,Z.quan ")
				.append("from (SELECT A.ID_SRV,A.Eu_Direct,A.ID_MM,A.SPEC,A.SRVU AS ID_UNIT,A.NAME_SRV,A.NAME_MM,SUM(A.AMT)*A.Eu_Direct AS AMT,SUM(A.Amt_Ratio)*A.Eu_Direct as AMT_RATIO,SUM(A.QUAN)*A.Eu_Direct AS QUAN ")
				.append("FROM BL_CG_IP A ")
				.append("WHERE A.ID_STIP = '")
				.append(stipId)
				.append("' ")
				.append("GROUP BY A.ID_SRV,A.Eu_Direct,A.ID_MM,A.SPEC,A.SRVU,A.PGKU_CUR,A.NAME_SRV,A.NAME_MM) Z ")
				.append("left join bd_measdoc m on Z.ID_UNIT = m.id_measdoc");
		List<BlCgIpDTO> list = (List<BlCgIpDTO>) new DAFacade().execQuery(
				sql.toString(), new BeanListHandler(BlCgIpDTO.class));
		return list.toArray(new BlCgIpDTO[] {});
	}
}
