package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.patopaptandent.d.PatOpAptAndEntListDTO;
import iih.ei.std.d.v1.en.patopaptandent.d.PatOpAptAndEntListParamDTO;
import iih.ei.std.d.v1.en.patopaptandent.d.PatOpAptAndEntListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiCodeUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 获取患者预约 和挂号 列表BP
 * 
 * @author li.wm
 */
public class GetPatOpAptAndEntListBP extends IIHServiceBaseBP<PatOpAptAndEntListParamDTO, PatOpAptAndEntListResultDTO> {
	

	/**
	 * 入参检查
	 */
	@Override
	protected void checkParam(PatOpAptAndEntListParamDTO param) throws BizException {
		if (param.getDt_begin() == null) {
			throw new BizException("开始日期不能为空！");
		}
		if (param.getDt_end() == null) {
			throw new BizException("结束日期不能为空！");
		}
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	@Override
	protected PatOpAptAndEntListResultDTO process(PatOpAptAndEntListParamDTO param) throws BizException {
		PatOpAptAndEntListResultDTO resultDTO = new PatOpAptAndEntListResultDTO();
		
		SqlParam sqlParam = new SqlParam();
		
		//获取挂号sql
		String entsql = this.getEntSql(param,sqlParam);
		//获取预约sql
		String aptsql = this.getAptSql(param,sqlParam);
		//合并sql
		String sql = entsql+" UNION "+aptsql;

		// 获取分页数据  执行sql 获取list返回值
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<PatOpAptAndEntListDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, PatOpAptAndEntListDTO.class);
		if (ListUtil.isEmpty(list)) {
			return resultDTO;
		}
		// 设置信息
		this.setStatus(list);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		
		resultDTO.setPatopaptandent(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}

	/***
	 * @Description:获取患者预约sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException
	 */
	private String getAptSql(PatOpAptAndEntListParamDTO param, SqlParam sqlParam) throws BizException {
		StringBuilder builder =new StringBuilder();
		builder.append("SELECT APT.ID_APT AS ID_APT, ");
		builder.append("ENT.ID_ENT, ");
		builder.append("PAT.CODE AS CODE_PAT, ");
		builder.append("PAT.NAME AS NAME_PAT, ");
		builder.append("EXCHL.CODE_PAT AS CODE_EXAPT,");
		builder.append("APT.CODE AS CODE_APT, ");
		builder.append("SRV.SD_SCTP AS CODE_ENTP ,  ");
		builder.append("SRV.NAME AS NAME_ENTP ,  ");
		builder.append("CA.CODE AS CODE_PATCA, ");
		builder.append("CA.NAME AS NAME_PATCA, ");
		builder.append("DEP.CODE AS CODE_DEP, ");
		builder.append("DEP.NAME AS NAME_DEP, ");
		builder.append("SRV.CODE AS CODE_SCSRV, ");
		builder.append("SRV.NAME AS NAME_SCSRV, ");
		builder.append("RES.CODE AS CODE_RES, ");
		builder.append("RES.NAME AS NAME_RES, ");
		builder.append("SRVTP.CODE AS CODE_SRVTP, ");
		builder.append("SRVTP.NAME AS NAME_SRVTP, ");
		builder.append("DLT.SD_DAYSLOTTP AS CODE_DAYSLOTTP, ");
		builder.append("LOTTP.NAME AS NAME_DAYSLOTTP,");
		builder.append("SUBSTR(ENT.DT_ENTRY, 0, 10) AS DT_ENTRY,");
		builder.append("APT.DT_APPT AS DT_APT, ");
		builder.append("EXCHL.EX_SEQNO AS CODE_TICKE,");
		builder.append("PAYOEP.PAYMODENODE AS PAYMODE_NO,");
		builder.append("PAYOEP.BANKNO AS BANK_NO,");
		builder.append("PM.CODE AS CODE_PM,");
		builder.append("PM.NAME AS NAME_PM,");
		builder.append("OP.TIMES_OP AS TIMES_OP , ");
		builder.append("CASE WHEN APT.FG_PAYMENT ='Y' THEN '1' ELSE '0' END AS FEE_STATUS, ");
		builder.append("APT.SD_STATUS AS CODE_APTSTATUS,");
		builder.append("QUEBEN.DES AS ADDRESS_ENT ,");
		builder.append("STOEP.AMT_PAT AS AMT_PAT , ");
		builder.append("PAYOEP.AMT AS AMT_TOTAL , ");
		builder.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE, ");
		builder.append("CHLTP.CODE AS CODE_CHLTP, ");
		builder.append("CHLTP.NAME AS NAME_CHLTP, ");
		builder.append("TICK.T_B AS T_B_TICK, ");
		builder.append("TICK.T_E AS T_E_TICK ");
		builder.append("FROM SC_APT APT ");
		builder.append("INNER JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		builder.append("INNER JOIN SC_APT_OP APTOP ON APTOP.ID_APT = APT.ID_APT ");
		builder.append("INNER JOIN EN_ENT ENT ON ENT.ID_ENT = APTOP.ID_EN ");
		builder.append("INNER JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA ");
		builder.append("INNER JOIN BD_DAYSLOT DLT ON APT.ID_DATESLOT = DLT.ID_DAYSLOT ");
		builder.append("LEFT JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("LEFT JOIN SC_RES RES ON APT.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON ENT.ID_DEP_PHY = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
		builder.append("INNER JOIN SC_SCH SCSCH ON APT.ID_SCH = SCSCH.ID_SCH ");
		builder.append("INNER JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCSCH.ID_SCPL ");
		builder.append("INNER JOIN BD_QUE_BEN QUEBEN ON QUEBEN.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append("LEFT JOIN EN_ENT_OP  OP ON OP.ID_ENT = ENT.ID_ENT ");
		builder.append("LEFT JOIN SC_TICK TICK   ON APT.ID_TICK = TICK.ID_TICK ");
		builder.append("LEFT JOIN SC_APT_EXCHL EXCHL ON EXCHL.ID_APT = APT.ID_APT ");
		builder.append("LEFT JOIN BL_ST_OEP STOEP ON STOEP.ID_ENT = ENT.ID_ENT AND STOEP.EU_STTP = '31' ");
		builder.append("LEFT JOIN BL_PAY_ITM_PAT_OEP PAYOEP ON PAYOEP.ID_PAYPATOEP =  STOEP.ID_PAYPATOEP ");
		builder.append("LEFT JOIN BD_PRI_PM PM ON PM.ID_PM = PAYOEP.ID_PM ");
		builder.append("LEFT JOIN BD_UDIDOC SRVTP ON SRVTP.CODE = SRV.CODE AND SRVTP.ID_UDIDOCLIST = '"+IBdFcDictCodeConst.ID_CODE_SRVTP+"' ");
		builder.append("LEFT JOIN BD_UDIDOC CHLTP ON CHLTP.CODE = CHL.SD_SCCHLTP AND CHLTP.ID_UDIDOCLIST = '"+IBdFcDictCodeConst.ID_CODE_SRVTP+"' ");
		builder.append("LEFT JOIN BD_UDIDOC LOTTP ON LOTTP.ID_UDIDOC = DLT.ID_DAYSLOTTP ");
		builder.append("WHERE (APT.SD_STATUS IN (?,?,?) OR APT.FG_PAYMENT = ?) AND SRV.SD_SCTP IN(?,?)  ");
		sqlParam.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		sqlParam.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);
		sqlParam.addParam(IScDictCodeConst.SD_APTSTATUS_FINISH);
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
		if(!StringUtil.isEmpty(param.getCode_agent_pat()))
		{
			builder.append(" AND (EXCHL.CODE_PAT_PROXY = ? OR PAT.CODE= ? )   ");
			sqlParam.addParam(param.getCode_agent_pat());
			sqlParam.addParam(param.getCode_agent_pat());
		
		}
		if(!StringUtil.isEmpty(param.getCode_pat()))
		{
			builder.append(" AND PAT.CODE = ? ");
			sqlParam.addParam(param.getCode_pat());
		}
		builder.append("AND APT.DT_B >= ? ");
		sqlParam.addParam(param.getDt_begin()+" 00:00:00");
		builder.append("AND APT.DT_B <= ? ");
		sqlParam.addParam(param.getDt_end()+" 23:59:59");
		
		return builder.toString();
	}
	
	/***
	 * @Description:获取患者预约sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("static-access")
	private String getEntSql(PatOpAptAndEntListParamDTO param, SqlParam sqlParam) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT APT.ID_APT,  ");
		sb.append("ENT.ID_ENT, ");
		sb.append("PAT.CODE AS CODE_PAT, ");
		sb.append("PAT.NAME AS NAME_PAT, ");
		sb.append("EXCHL.CODE_APT AS CODE_EXAPT, ");
		sb.append("APT.CODE AS CODE_APT, ");
		sb.append("ENTP.CODE AS CODE_ENTP, ");
		sb.append("ENTP.NAME AS NAME_ENTP, ");
		sb.append("CA.CODE AS CODE_PATCA, ");
		sb.append("CA.NAME AS NAME_PATCA, ");
		sb.append("DEP.CODE AS CODE_DEP, ");
		sb.append("DEP.NAME AS NAME_DEP, ");
		sb.append("SRV.CODE AS CODE_SCSRV, ");
		sb.append("SRV.NAME AS NAME_SCSRV, ");
		sb.append("RES.CODE AS CODE_RES,  ");
		sb.append("RES.NAME AS NAME_RES, ");
		sb.append("SRVTP.CODE AS CODE_SRVTP,");
		sb.append("SRVTP.NAME AS NAME_SRVTP,");
		sb.append("LOT.SD_DAYSLOTTP AS CODE_DAYSLOTTP,");
		sb.append("LOT.NAME AS NAME_DAYSLOTTP,");
		sb.append("SUBSTR(ENT.DT_ENTRY, 0, 10) AS DT_ENTRY,");
		sb.append("ENT.DT_INSERT AS DT_ENT, ");
		sb.append("OP.TICKETNO AS CODE_TICKET, ");
		sb.append("PAYOEP.PAYMODENODE AS PAYMODE_NO, ");
		sb.append("PAYOEP.BANKNO AS BANK_NO, ");
		sb.append("PM.CODE AS CODE_PM, ");
		sb.append("PM.NAME AS NAME_PM, ");
		sb.append("OP.TIMES_OP AS TIMES_OP, ");
		sb.append("CASE WHEN ENT.FG_ST ='Y' THEN '1' ELSE '0' END AS FEE_STATUS, ");
		sb.append("APT.SD_STATUS AS CODE_APTSTATUS, ");
		sb.append("ENT.ADDR_PAT AS ADDRESS_ENT,  ");
		sb.append("STOEP.AMT_PAT AS AMT_PAT , ");
		sb.append("PAYOEP.AMT AS AMT_TOTAL , ");
		sb.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE, ");
		sb.append("CHL.CODE AS CODE_CHLTP , ");
		sb.append("CHL.NAME AS NAME_CHLTP, ");
		sb.append("TICK.T_B AS T_B_TICKET, ");
		sb.append("TICK.T_E AS T_E_TICKET ");
		sb.append("FROM EN_ENT ENT  ");
		sb.append("INNER JOIN EN_ENT_OP OP     ON OP.ID_ENT = ENT.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT       ON PAT.ID_PAT = ENT.ID_PAT  ");
		sb.append("LEFT JOIN SC_APT_OP APTOP ON APTOP.ID_EN = ENT.ID_ENT ");
		sb.append("LEFT JOIN SC_APT APT ON APT.ID_APT = APTOP.ID_APT ");
		sb.append("LEFT JOIN PI_PAT_CA CA      ON CA.ID_PATCA = ENT.ID_PATCA ");
		sb.append("LEFT JOIN SC_SCH SCH  ON SCH.ID_SCH = OP.ID_SCH ");
		sb.append("LEFT JOIN SC_PL PL   ON SCH.ID_SCPL = PL.ID_SCPL  ");
		sb.append("LEFT JOIN BD_DEP DEP  ON DEP.ID_DEP = OP.ID_DEP_REG ");
		sb.append("LEFT JOIN SC_SRV SRV  ON SRV.ID_SCSRV = OP.ID_SCSRV ");
		sb.append("LEFT JOIN BD_DEP DEP  ON DEP.ID_DEP = OP.ID_DEP_REG ");
		sb.append("LEFT JOIN SC_SRV SRV  ON SRV.ID_SCSRV = OP.ID_SCSRV ");
		sb.append("LEFT JOIN SC_RES RES  ON RES.ID_SCRES = OP.ID_SCRES   ");
		sb.append("LEFT JOIN SC_CHL CHL  ON CHL.ID_SCCHL = APT.ID_SCCHL  ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT  ON LOT.ID_DAYSLOT = OP.ID_DATESLOT ");
		sb.append("LEFT JOIN SC_APT_EXCHL EXCHL  ON EXCHL.ID_APT = APT.ID_APT ");
		sb.append("LEFT JOIN SC_TICK TICK        ON OP.ID_TICK = TICK.ID_TICK  ");
		sb.append("LEFT JOIN BL_ST_OEP STOEP    ON STOEP.ID_ENT = ENT.ID_ENT AND STOEP.EU_STTP = '31' ");
		sb.append("LEFT JOIN BL_PAY_ITM_PAT_OEP PAYOEP ON PAYOEP.ID_PAYPATOEP =  STOEP.ID_PAYPATOEP   ");
		sb.append("LEFT JOIN BD_PRI_PM PM        ON PM.ID_PM = PAYOEP.ID_PM   ");
		sb.append("LEFT  JOIN BD_ENTP ENTP     ON ENTP.ID_ENTP = ENT.ID_ENTP  ");
		sb.append("LEFT JOIN BD_UDIDOC SRVTP ON SRVTP.ID_UDIDOC = SRV.ID_SRVTP ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT  ON LOT.ID_DAYSLOT = OP.ID_DATESLOT  ");
		sb.append("where 1=1 AND SRV.SD_SCTP IN (?,?) ");
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
		if(!StringUtil.isEmpty(param.getCode_pat())){
			sb.append(" AND PAT.CODE = ? ");
			sqlParam.addParam(param.getCode_pat());
		}
		sb.append("and ent.dt_entry >= ? ");
		sb.append("and ent.dt_entry < ? ");
		sqlParam.addParam(param.getDt_begin()+" 00:00:00");
		sqlParam.addParam(param.getDt_end()+" 23:59:59");
		return sb.toString();
	}

	
	/**
	 * 进行过滤 li.wm
	 * 
	 * @param patOpAptListDTOs
	 */
	private void setStatus(List<PatOpAptAndEntListDTO> patOpAptListDTOs) {
		for (PatOpAptAndEntListDTO patOpEntListDTO : patOpAptListDTOs) {
			patOpEntListDTO.setCode_dayslottp(EiCodeUtils.dayslotTpTOHisCode(patOpEntListDTO.getCode_dayslottp()));

		}
	}


	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,PatOpAptAndEntListResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
