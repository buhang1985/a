package iih.ci.rcm.reportcardmissqry.bp;

import java.util.List;

import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
* 无报卡但是既往已报时查询既往已报文书ID
*/
public class FindReportedHistoryBp {
	
	public String findReportedHistory(EntDto enDto) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select rd.id_ci_rcm_rd  ");
		sql.append("from ci_rcm_rd rd ");
		sql.append("left join en_ent ee on rd.id_ent = ee.id_ent  ");
		sql.append("left join pi_pat pp on pp.id_pat = ee.id_pat  ");
		sql.append("where pp.id_pat='" + enDto.getId_pat() + "' ");
		sql.append("and  rd.id_di='" + enDto.getId_didef_dis() + "' ");
		sql.append("and  rd.fg_reported_history='N' ");
		sql.append("order by rd.sv desc");
		String sqlStr = sql.toString();
		@SuppressWarnings("unchecked")
		List<ReportCardDocDo> listMr = (List<ReportCardDocDo>) daf.execQuery(sqlStr,
				new BeanListHandler(ReportCardDocDo.class));
		if (listMr != null && listMr.size() > 0) {
			ReportCardDocDo doc = listMr.get(0);
			return doc.getId_ci_rcm_rd();
		}
		return null;
	}
}
