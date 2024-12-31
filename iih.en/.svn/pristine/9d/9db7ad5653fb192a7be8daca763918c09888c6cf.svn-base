package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.enqueue.d.EntQueStatus;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊医生接诊
 * 得到患者接诊信息
 * 
 * @author liubin
 *
 */
public class GetAcptEntBP {
	/**
	 * 根据状态得到接诊队列
	 * 
	 * @param entIds
	 * @param status
	 * 		状态  
	 * 参照枚举：EntQueStatus
	 * <ul>
	 * <li>[1] 分诊状态患者</li>
	 * <li>[2] 通知状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * <li>[5] 回诊状态患者</li>
	 * </ul>
	 * @return
	 * @throws DAException 
	 */
	public List<ReceptionQueDTO> getAcptEnt(String[] entIds, int status, String acptStatus) throws DAException {
		if(EnValidator.isEmpty(entIds)){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT T.* FROM (");
		builder.append(this.getSql());
		builder.append("WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		SqlParam param = new SqlParam();
		param.addParam(acptStatus);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		if(EntQueStatus.Triaged == status){
			//候诊
			builder.append("ORDER BY EQ.SORTNO_CALLED,EQ.LEVEL_PRI DESC NULLS LAST, EQ.SORTNO, EQ.DT_IN ");
		}else if(EntQueStatus.Called == status){
			builder.append("ORDER BY EQ.SORTNO_CALLED ");
		}else if(EntQueStatus.Accept == status){
			builder.append("AND OP.FG_NEEDRTN = ? ");
			param.addParam(FBoolean.FALSE);
			builder.append("ORDER BY SLOT.TIME_BEGIN,OP.ID_SCH NULLS LAST,EQ.SORTNO,EN.DT_ACPT ");
		}else if(EntQueStatus.ReturnVisit == status){
			builder.append("AND OP.FG_NEEDRTN = ? ");
			param.addParam(FBoolean.TRUE);
			builder.append("ORDER BY SLOT.TIME_BEGIN,OP.ID_SCH NULLS LAST,EQ.SORTNO,EN.DT_ACPT ");
		}else{
			return null;
		}
		builder.append(" ) T ");
		builder.append("WHERE T.NEW_INDEX = 1 ");
		String sql = builder.toString();
		List<ReceptionQueDTO> list = (List<ReceptionQueDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ReceptionQueDTO.class));
		return list;
	}
	/**
	 * 获取未分诊患者记录
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public List<ReceptionQueDTO> getNoTriageEnt(String[] entIds) throws BizException{
		if(EnValidator.isEmpty(entIds)){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT T.* FROM (");
		builder.append(this.getSql());
		builder.append("WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		builder.append("ORDER BY EQ.SD_STATUS_ACPT DESC, EQ.SORTNO ");
		builder.append(" ) T ");
		builder.append("WHERE T.NEW_INDEX = 1 ");
		String sql = builder.toString();
		List<ReceptionQueDTO> list = (List<ReceptionQueDTO>) new DAFacade().execQuery(sql, new BeanListHandler(ReceptionQueDTO.class));
		return list;
	}
	
	/**
	 * 得到接诊DTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	public List<ReceptionQueDTO> getAcptEnt(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT T.* FROM (");
		builder.append(this.getSql());
		builder.append("WHERE EN.ID_ENT = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append(" ) T ");
		builder.append("WHERE T.NEW_INDEX = 1 ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		List<ReceptionQueDTO> list = (List<ReceptionQueDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ReceptionQueDTO.class));
		return list;
	}
	/**
	 * 得到SQL语句
	 * 
	 * @return
	 */
	public StringBuilder getSql(){
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EN.ID_ENT AS ID_ENT,");
		builder.append("PAT.CODE AS CODE_PAT,");
		builder.append("PAT.PYCODE AS PYCODE,");
		builder.append("PAT.BARCODE_CHIS AS BARCODE_CHIS,");
		builder.append("EN.ID_PAT AS ID_PAT,");
		builder.append("EN.ID_ENTP AS ID_ENTP,");
		builder.append("EN.CODE_ENTP AS CODE_ENTP,");
		builder.append("EN.CODE AS CODE_ENT,");
		builder.append("EN.NAME_PAT AS NAME_PAT,");
		builder.append("CASE WHEN NVL(OP.ID_TICKS,'~')<>'~' THEN SUBSTR(TRIM(TKS.T_B),0,5)||'-'||SUBSTR(TRIM(TKS.T_E),0,5) ELSE SUBSTR(TRIM(TK.T_B),0,5)||'-'||SUBSTR(TRIM(TK.T_E),0,5) END AS TICKS,");
		builder.append("EN.ID_SEX_PAT AS ID_SEX_PAT,");
		builder.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		builder.append("EN.TELNO_PAT AS TELNO_PAT,");
		builder.append("EN.ID_HP AS ID_HP,");
		builder.append("EN.ID_PATCA AS ID_PATCA,");
		builder.append("EN.DT_END AS DT_ENT,");
		builder.append("OP.ID_DEP_REG AS ID_DEP_PHY,");
		builder.append("EQ.ID_ENT_QUE AS ID_ENT_QUE,");
	    builder.append("EQ.SD_STATUS_ACPT AS SD_STATUS_ACPT,"); 
	    builder.append("EQ.SORTNO AS TICKETNO,");
	    builder.append("EQ.DT_IN,");
	    builder.append("EQ.LEVEL_PRI,");
	    builder.append("EQ.SORTNO_CALLED AS SORTNO_CALLED,");
	    builder.append("EQ.ID_QUE_SITE AS ID_QUE_SITE,");
	    builder.append(" EQ.DEF1 AS DEF1 ,");
		builder.append(" EQ.DEF2 AS DEF2 ,");
		builder.append(" EQ.DEF3 AS DEF3 ,");
		builder.append(" EQ.DEF4 AS DEF4 ,");
		builder.append(" EQ.DEF5 AS DEF5 ,");
	    builder.append("OP.FG_NEEDRTN AS FG_NEEDRTN,"); 
	    builder.append("OP.SD_STATUS AS SD_STATUS,"); 
	    builder.append("OP.TIMES_OP AS TIMES_OP,");
	    builder.append("DI.ID_DIDEF_DIS AS ID_DIDEF_DIS,"); 
	    builder.append("DI.NAME_DIDEF_DIS AS NAME_DIDEF_DIS,"); 
	    builder.append("UDI.NAME AS NAME_SEX,");
	    builder.append("HP.NAME AS NAME_HP,");
	    builder.append("CA.NAME AS NAME_PATCA,");
	    builder.append("SCSRV.NAME AS NAME_SRV,");
	    builder.append("ROW_NUMBER() OVER(PARTITION BY EN.ID_ENT ORDER by DI.ID_ENTDI) AS NEW_INDEX ");
	    builder.append("FROM EN_ENT EN ");
	    builder.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
	    builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
	    builder.append("INNER JOIN EN_ENT_QUE EQ ON EN.ID_ENT = EQ.ID_ENT ");
	    builder.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");//fanlq
	    builder.append("LEFT JOIN BD_DAYSLOT SLOT ON EQ.ID_DATESLOT = SLOT.ID_DAYSLOT ");
	    builder.append("LEFT JOIN SC_TICKS TKS ON OP.ID_TICKS = TKS.ID_TICKS ");
	    builder.append("LEFT JOIN SC_TICK TK ON OP.ID_TICK = TK.ID_TICK ");
	    builder.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP ");
	    builder.append("LEFT JOIN BD_UDIDOC UDI ON EN.ID_SEX_PAT = UDI.ID_UDIDOC ");
	    builder.append("LEFT JOIN PI_PAT_CA CA ON EN.ID_PATCA = CA.ID_PATCA ");
	    builder.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = 'Y' ");
		return builder;
	}
}
