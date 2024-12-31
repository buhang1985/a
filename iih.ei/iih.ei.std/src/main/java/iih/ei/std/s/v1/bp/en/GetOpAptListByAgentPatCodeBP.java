package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.opaptlistbyagentpatcode.d.OpAptListByAgentPatCodeDTO;
import iih.ei.std.d.v1.en.opaptlistbyagentpatcode.d.OpAptListByAgentPatCodeParamDTO;
import iih.ei.std.d.v1.en.opaptlistbyagentpatcode.d.OpAptListByAgentPatCodeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiCodeUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取代办人预约列表BP
 * 
 * @author li.wm
 */
public class GetOpAptListByAgentPatCodeBP extends IIHServiceBaseBP<OpAptListByAgentPatCodeParamDTO, OpAptListByAgentPatCodeResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(OpAptListByAgentPatCodeParamDTO param) throws BizException {
		if (param.getDt_begin() == null) {
			throw new BizException("开始日期不能为空！");
		}
		if (param.getDt_end() == null) {
			throw new BizException("结束日期不能为空！");
		}
		
		if (param.getCode_agent_pat() ==null) {
			throw new BizException("挂号代办人不能为空！");
		}
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
		
	}

	@Override
	protected OpAptListByAgentPatCodeResultDTO process(OpAptListByAgentPatCodeParamDTO param) throws BizException {
		OpAptListByAgentPatCodeResultDTO resultDTO = new OpAptListByAgentPatCodeResultDTO();
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		
		// 获取分页信息 获取list返回值
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<OpAptListByAgentPatCodeDTO> list = this.findPagingData(pageInfoDto, sql, sqlParam, OpAptListByAgentPatCodeDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//处理信息
		this.setStatus(list);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setOpaptlistbyagentpatcode(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/***
	 * @Description:获取患者预约信息sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(OpAptListByAgentPatCodeParamDTO param,SqlParam sqlParam) throws BizException {
		StringBuilder builder =new StringBuilder();
		builder.append("SELECT APT.ID_APT AS ID_APT, ");
		builder.append("PAT.CODE AS CODE_PAT, ");
		builder.append("PAT.NAME AS NAME_PAT, ");
		
		builder.append("CASE WHEN OP.SD_SVRTP = '090103'  OR SRV.SD_SCTP = '05'  THEN '01'  ELSE '00' END AS CODE_ENTP ,  ");
		builder.append("CASE WHEN OP.SD_SVRTP = '090103' OR SRV.SD_SCTP = '05'  THEN '急诊'  ELSE '门诊' END AS NAME_ENTP ,  ");
		builder.append("CA.CODE  AS CODE_PATCA, ");
		builder.append("CA.NAME  AS NAME_PATCA, ");
		builder.append("DEP.CODE AS CODE_DEPT, ");
		builder.append("DEP.NAME AS NAME_DEPT, ");
		builder.append("SRV.CODE AS CODE_SRVTP, ");
		builder.append("SRV.NAME AS NAME_SRVTP, ");
		builder.append("RES.CODE AS CODE_RES, ");
		builder.append("RES.NAME AS NAME_RESTP, ");
		builder.append("APT.DT_B AS ENT_TIME, ");
		builder.append("APT.DT_APPT AS OPR_TIME, ");
		builder.append("DLT.SD_DAYSLOTTP AS CODE_DAYSLOTTP, ");
		builder.append("DLT.NAME AS NAME_DAYSLOTTP, ");
		builder.append("EXCHL.EX_SEQNO AS CODE_TICKE, ");
		builder.append("PAYOEP.PAYMODENODE AS PAYMODE_NO, ");
		builder.append("PAYOEP.BANKNO AS BANK_NO, ");
		builder.append("PM.CODE AS CODE_PM, ");
		builder.append("PM.NAME AS NAME_PM, ");
		builder.append("EXCHL.CODE_PAT AS APT_NO, ");
		builder.append(" CASE WHEN APT.FG_CANC = 'N' and APT.FG_BILL = 'N'  THEN '0' ");
		builder.append(" WHEN  APT.FG_CANC = 'N' and APT.FG_BILL = 'Y'  THEN  '1' ");
		builder.append(" WHEN APT.FG_CANC = 'N' or APT.SD_STATUS = '4' THEN  '7'  END  AS FEE_STATUS ,");
		builder.append("CASE WHEN APT.FG_CANC = 'N'  AND APT.SD_STATUS = '3' THEN  '1'   ");
		builder.append("WHEN APT.FG_CANC = 'Y' or apt.sd_status = '4' then  '7' ");
		builder.append(" ELSE '0' END  AS CODE_STATUS_OP ,");
		
		builder.append("QUEBEN.DES AS  ADDRESS_ENT ,");
		builder.append("STOEP.AMT_PAT AS AMT_PAT , ");
		builder.append("PAYOEP.AMT AS AMT_TOTAL , ");
		builder.append("APT.CODE AS CODE_APT, ");
		builder.append("OP.TIMES_OP AS TIMES_OP , ");
		builder.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE, ");
		builder.append("CHL.CODE AS CHLTP_CODE， ");
		builder.append("CHL.NAME AS CHLTP_NAME ");
		builder.append("FROM SC_APT APT ");
		builder.append("INNER JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		builder.append("INNER JOIN SC_APT_OP APTOP ON APTOP.ID_APT = APT.ID_APT ");
		builder.append("INNER JOIN EN_ENT ENT ON ENT.ID_ENT = APTOP.ID_EN ");
		builder.append("INNER JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA ");
		builder.append("INNER JOIN BD_DAYSLOT DLT ON APT.ID_DATESLOT = DLT.ID_DAYSLOT ");
		builder.append("INNER JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("INNER JOIN SC_RES RES ON APT.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON ENT.ID_DEP_PHY = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
		builder.append("INNER JOIN SC_SCH SCSCH ON APT.ID_SCH = SCSCH.ID_SCH ");
		builder.append("INNER JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCSCH.ID_SCPL ");
		builder.append("INNER JOIN BD_QUE_BEN QUEBEN ON QUEBEN.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append("INNER JOIN EN_ENT_OP  OP ON OP.ID_ENT = ENT.ID_ENT ");
		builder.append("LEFT  JOIN SC_APT_EXCHL EXCHL ON EXCHL.ID_APT = APT.ID_APT ");
		builder.append("LEFT JOIN BL_ST_OEP STOEP ON STOEP.ID_ENT = ENT.ID_ENT AND STOEP.EU_STTP = '31' ");
		builder.append("LEFT JOIN BL_PAY_ITM_PAT_OEP PAYOEP ON PAYOEP.ID_PAYPATOEP =  STOEP.ID_PAYPATOEP ");
		builder.append("LEFT JOIN BD_PRI_PM PM ON PM.ID_PM = PAYOEP.ID_PM ");
		builder.append("LEFT JOIN BD_ENTP ENTP ON ENTP.ID_ENTP = ENT.ID_ENTP ");
		builder.append("WHERE  (APT.SD_STATUS IN (?,?,?) OR APT.FG_PAYMENT = ? ) AND SRV.SD_SCTP IN (?,?) ");
		sqlParam.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		sqlParam.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);
		sqlParam.addParam(IScDictCodeConst.SD_APTSTATUS_FINISH);
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
		builder.append(" AND (EXCHL.CODE_PAT_PROXY = ?   or PAT.CODE=? )   ");
		sqlParam.addParam(param.getCode_agent_pat());
		sqlParam.addParam(param.getCode_agent_pat());
		builder.append("AND APT.DT_B >= ? ");
		sqlParam.addParam(param.getDt_begin() + " 00:00:00");
		builder.append("AND APT.DT_B <= ? ");
		sqlParam.addParam(param.getDt_end()+" 23:59:59");

		return builder.toString();
	}
	
	/**
	 * 设置参数    li.wm
	 * @param patOpAptListDTOs
	 */
	private void setStatus(List<OpAptListByAgentPatCodeDTO> list) {
		for (OpAptListByAgentPatCodeDTO dto : list) {
			dto.setCode_dayslottp(EiCodeUtils.dayslotTpTOHisCode(dto.getCode_dayslottp()));
			
		}
	} 
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,OpAptListByAgentPatCodeResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
	
}
