package iih.en.que.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageEntDTO;

import java.util.List;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取TriageEntDTO
 * 
 * @author liubin
 *
 */
public class GetTriageEntBP {
	
	public TriageEntDTO getTriageEntByEntId(String entId) throws DAException{
		if(EnValidator.isEmpty(entId))
			return null;
		StringBuilder sb = this.getBaseBuilder();
		sb.append(" WHERE EN.ID_ENT = ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(entId);
		TriageEntDTO[] triages = this.getTriageEnts(sql, param);
		if(!EnValidator.isEmpty(triages))
			return triages[0];
		return null;
	}
	
	/**
	 * 得到TriageEntDTO集合
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	public List<TriageEntDTO> getTriageEntList(String sql, SqlParam param) throws DAException{
		return (List<TriageEntDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageEntDTO.class));
	}
	/**
	 * 得到TriageEntDTO集合
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws DAException
	 */
	public TriageEntDTO[] getTriageEnts(String sql, SqlParam param) throws DAException{
		List<TriageEntDTO> list = this.getTriageEntList(sql, param);
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageEntDTO[0]);
		}
		return null;
	}
	/**
	 * 得到基础的SQL语句
	 * @return
	 */
	public StringBuilder getBaseBuilder(){
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EQ.ID_ENT_QUE ID_ENTQUE,EN.ID_ENT ID_ENT,EQ.ID_QUE ID_QUE,EN.ID_PAT ID_PAT,EQ.SORTNO TICKNO,OP.TIMES_OP,");
		builder.append("EN.NAME_PAT PAT_NAME,EQ.ID_QUE_SITE ID_QUESITE,EQ.LEVEL_PRI,EQ.LEVEL_PRI_RSN,OP.FG_FIRST,EQ.SD_STATUS_ACPT, ");
		builder.append("OP.ID_SCRES AS ID_SCRES,SR.NAME AS RES, OP.ID_SCSRV AS ID_SCSRV,SS.NAME AS NAME_SRV,OP.SD_STATUS, PL.ID_SCPL,PL.NAME AS NAME_SCPL,");
		builder.append("EQ.DT_REGIST AS DT_REGIST,EQ.FG_MANUAL, EQ.DT_IN, OP.FG_NEEDRTN,EQ.SORTNO_CALLED,DL.NAME AS NAME_DAYSLOT,EN.DT_BIRTH_PAT Dt_birth ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EQ.ID_ENT = OP.ID_ENT ");
		builder.append("INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("LEFT JOIN BD_QUE_SITE BS ON EQ.ID_QUE_SITE = BS.ID_QUESITE ");
		builder.append("LEFT JOIN SC_RES SR ON OP.ID_SCRES = SR.ID_SCRES ");
		builder.append("LEFT JOIN SC_SRV SS ON OP.ID_SCSRV = SS.ID_SCSRV ");
		builder.append("LEFT JOIN SC_SCH SCH ON OP.ID_SCH = SCH.ID_SCH ");
		builder.append("LEFT JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
		builder.append("LEFT JOIN BD_DAYSLOT DL ON EQ.ID_DATESLOT = DL.ID_DAYSLOT ");
		return builder;
	}
}
