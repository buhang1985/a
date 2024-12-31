package iih.en.pv.opinplusticket;

import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 预约查询
 * 
 * @author liubin
 *
 */
public class ScAptQryService {
	/**
	 * 获取预约信息
	 * 
	 * @param id_apt 预约Id
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ScAptDTO getAptInfo(String id_apt) throws Exception{
		if(StringUtil.isEmptyWithTrim(id_apt))
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SC_APT.ID_APT AS ID_APT,");
		sb.append("SC_APT.CODE AS CODE_APT,");
		sb.append("PI_PAT.NAME AS NAME_PAT,");
		sb.append("SC_SCH.D_SCH AS D_SCH,");
		sb.append("BD_DEP.NAME AS NAME_DEP_APPT,");
		sb.append("SC_RES.NAME AS NAME_SCRES,");
		sb.append("SC_SRV.NAME AS NAME_SCSRV,");
		sb.append("SC_APT.QUENO AS SORTNO,");
		sb.append("BD_DAYSLOT.NAME AS NAME_DAYSLOT,");
		sb.append("BD_PSNDOC.NAME AS NAME_EMP_APPT,");
		sb.append("SC_APT.DT_APPT AS DT_APPT ");
		sb.append("FROM SC_APT SC_APT ");
		sb.append("INNER JOIN SC_APT_OP SC_APT_OP ON SC_APT.ID_APT = SC_APT_OP.ID_APT ");
		sb.append("INNER JOIN SC_SCH SC_SCH ON SC_APT.ID_SCH = SC_SCH.ID_SCH ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON SC_APT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_DEP BD_DEP ON SC_APT_OP.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("LEFT JOIN BD_PSNDOC BD_PSNDOC ON SC_APT.ID_EMP_APPT = BD_PSNDOC.ID_PSNDOC ");
		sb.append("LEFT JOIN SC_RES SC_RES ON SC_APT.ID_SCRES = SC_RES.ID_SCRES ");
		sb.append("LEFT JOIN SC_SRV SC_SRV ON SC_APT.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("LEFT JOIN BD_DAYSLOT BD_DAYSLOT ON SC_APT.ID_DATESLOT = BD_DAYSLOT.ID_DAYSLOT ");
		sb.append("WHERE SC_APT.ID_APT = '").append(id_apt).append("'");
		String sql = sb.toString();
		SqlReader sqlReader = new SqlReader(null, sql);
		sqlReader.runSql(null, true);
		CachedRowSetImpl cached_rs = sqlReader.getCacheRowSet();
		BeanListHandler beanlist_handler = new BeanListHandler(ScAptDTO.class);
		List<ScAptDTO> list = (List<ScAptDTO>)beanlist_handler.processRs(cached_rs);
		if(!ListUtil.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
}
