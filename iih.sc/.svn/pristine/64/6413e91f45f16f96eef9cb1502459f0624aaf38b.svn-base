package iih.sc.apt.s.bp.opt;

import iih.bd.base.utils.SqlUtils;
import iih.sc.apt.out.ci.d.ScAptInfoDTO;
import iih.sc.comm.ScValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * 获取手术预约信息
 * 
 * @author liubin
 * 
 * 上午11:09:06
 */
public class GetScAptOptByOrIdBP {
	/**
	 * 
	 * 获取手术预约信息
	 * 
	 * @author liubin
	 * 
	 * @param id_or 医嘱id
	 * @return
	 * @throws BizException
	 */
	public ScAptInfoDTO exec(String id_or) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(id_or))
			return null;
		ScAptInfoDTO[] scAptInfos = exec(new String[] {id_or});
		return ArrayUtil.isEmpty(scAptInfos) ? null : scAptInfos[0];
	}
	/**
	 * 获取手术预约信息集合
	 * 
	 * @author liubin
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private ScAptInfoDTO[] exec(String[] id_ors) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APT.ID_APT AS ID_APT,");
		sqlBuilder.append("PAT.ID_PAT AS ID_PAT,");
		sqlBuilder.append("PAT.CODE AS CODE_PAT,");
		sqlBuilder.append("PAT.NAME AS NAME_PAT,");
		sqlBuilder.append("APT.SD_SCTP AS SD_SCTP,");
		sqlBuilder.append("APT.CODE AS CODE_APT,");
		sqlBuilder.append("APT.DES AS DES,");
		sqlBuilder.append("APT.ID_SCH AS ID_SCH,");
		sqlBuilder.append("APTOPT.ID_DEP_BELONG AS ID_DEP,");
		sqlBuilder.append("DEP.CODE AS CODE_DEP,");
		sqlBuilder.append("DEP.NAME AS NAME_DEP,");
		sqlBuilder.append("APT.ID_DATESLOT AS ID_DAYSLOT,");
		sqlBuilder.append("DAYSLOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("APT.ID_SCRES AS ID_SCRES,");
		sqlBuilder.append("SCRES.NAME AS NAME_SCRES,");
		sqlBuilder.append("APT.ID_SCSRV AS ID_SCSRV,");
		sqlBuilder.append("SCSRV.NAME AS NAME_SCSRV,");
		sqlBuilder.append("APT.ID_TICK AS ID_TICK,");
		sqlBuilder.append("APT.ID_TICKS AS ID_TICKS,");
		sqlBuilder.append("APT.QUENO AS QUENO,");
		sqlBuilder.append("APT.DT_APPT AS DT_APPT,");
		sqlBuilder.append("APT.DT_B AS DT_B,");
		sqlBuilder.append("APT.DT_E AS DT_E,");
		sqlBuilder.append("APT.ID_SCCHL AS ID_SCCHL,");
		sqlBuilder.append("CHL.CODE AS CODE_SCCHL,");
		sqlBuilder.append("CHL.NAME AS NAME_SCCHL,");
		sqlBuilder.append("APT.ID_EMP_APPT AS ID_OPER_APPT,");
		sqlBuilder.append("OPER.CODE AS CODE_OPER_APPT,");
		sqlBuilder.append("OPER.NAME AS NAME_OPER_APPT,");
		sqlBuilder.append("APT.SD_STATUS AS SD_STATUS,");
		sqlBuilder.append("APT.FG_PAYMENT AS FG_PAYMENT,");
		sqlBuilder.append("APT.FG_NOTICE AS FG_NOTICE,");
		sqlBuilder.append("APT.FG_CANC AS FG_CANC,");
		sqlBuilder.append("APT.DT_CANC AS DT_CANC,");
		sqlBuilder.append("APT.ID_EMP_CANC AS ID_EMP_CANC,");
		sqlBuilder.append("CANCEMP.CODE AS CODE_EMP_CANC,");
		sqlBuilder.append("CANCEMP.NAME AS NAME_EMP_CANC,");
		sqlBuilder.append("BDOPT.ID_OPT AS ID_OPT,");
		sqlBuilder.append("BDOPT.CODE AS CODE_OPT,");
		sqlBuilder.append("BDOPT.NAME AS NAME_OPT,");
		sqlBuilder.append("APT.FG_CANC_NOTICE AS FG_CANC_NOTICE,");
		sqlBuilder.append("APT.NOTE_CANC AS NOTE_CANC,");
		sqlBuilder.append("APT.FG_BILL AS FG_BILL,");
		sqlBuilder.append("APT.ID_SCAPT_CANCTO AS ID_SCAPT_CANCTO ");
		sqlBuilder.append("FROM SC_APT APT ");
		sqlBuilder.append("INNER JOIN SC_APT_OPT APTOPT ON APTOPT.ID_APT = APT.ID_APT ");
		sqlBuilder.append("INNER JOIN SC_APT_APPL APPL ON APPL.ID_APTAPPL = APTOPT.ID_APTAPPL ");
		sqlBuilder.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = APT.ID_PAT ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = APTOPT.ID_DEP_BELONG ");
		sqlBuilder.append("LEFT JOIN BD_DAYSLOT DAYSLOT ON DAYSLOT.ID_DAYSLOT = APT.ID_DATESLOT ");
		sqlBuilder.append("LEFT JOIN SC_RES SCRES ON SCRES.ID_SCRES = APT.ID_SCRES ");
		sqlBuilder.append("LEFT JOIN SC_SRV SCSRV ON SCSRV.ID_SCSRV = APT.ID_SCSRV ");
		sqlBuilder.append("LEFT JOIN SC_CHL CHL ON CHL.ID_SCCHL = APT.ID_SCCHL ");
		sqlBuilder.append("LEFT JOIN BD_PSNDOC OPER ON OPER.ID_PSNDOC = APT.ID_EMP_APPT ");
		sqlBuilder.append("LEFT JOIN BD_PSNDOC CANCEMP ON CANCEMP.ID_PSNDOC  = APT.ID_EMP_CANC ");
		sqlBuilder.append("LEFT JOIN BD_OPT BDOPT ON BDOPT.ID_OPT = APTOPT.ID_OPT ");
		sqlBuilder.append("WHERE APPL.FG_CANC = 'N' AND  APT.FG_CANC ='N'");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByBigIds(" APPL.ID_OR ", id_ors));
		List<ScAptInfoDTO> list = (List<ScAptInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(ScAptInfoDTO.class));
		return ListUtil.isEmpty(list) ? null : list.toArray(new ScAptInfoDTO[0]);
	} 
}
