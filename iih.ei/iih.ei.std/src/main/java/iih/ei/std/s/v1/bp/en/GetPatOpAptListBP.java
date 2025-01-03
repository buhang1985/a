package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.patopapt.d.PatOpAptListDTO;
import iih.ei.std.d.v1.en.patopapt.d.PatOpAptListParamDTO;
import iih.ei.std.d.v1.en.patopapt.d.PatOpAptListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取患者预约列表BP
 * 
 * @author li.wm
 */
public class GetPatOpAptListBP extends IIHServiceBaseBP<PatOpAptListParamDTO, PatOpAptListResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(PatOpAptListParamDTO param) throws BizException {
		if (param.getDt_begin() == null) {
			throw new BizException("开始日期不能为空！");
		}
		if (param.getDt_end() == null) {
			throw new BizException("结束日期不能为空！");
		}
		if (param.getPageinfo() == null) {
			throw new BizException("未传入分页信息！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected PatOpAptListResultDTO process(PatOpAptListParamDTO param) throws BizException {
		PatOpAptListResultDTO resultDTO = new PatOpAptListResultDTO();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo();
		//1.校验患者是否存在
		PatDO patDO = new PatEP().getPatByCode(param.getCode_pat());
		if(patDO == null){
			throw new BizException("在IIH中未查询到该编码对应的患者！患者编码为："+param.getCode_pat());
		}
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam,patDO.getId_pat());
		//获取分页信息执行SQl
		List<PatOpAptListDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, PatOpAptListDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		resultDTO.setPageinfo(pageInfoDto);
		resultDTO.setPatopapt(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/***
	 * @Description:获取患者预约信息sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(PatOpAptListParamDTO param,SqlParam sqlParam,String patId) throws BizException {
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
		builder.append("SUBSTR(APT.DT_B, 0, 10) AS DT_ENTRY,");
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
		builder.append("LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = APTOP.ID_EN ");
		builder.append("LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA ");
		builder.append("INNER JOIN BD_DAYSLOT DLT ON APT.ID_DATESLOT = DLT.ID_DAYSLOT ");
		builder.append("LEFT JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("LEFT JOIN SC_RES RES ON APT.ID_SCRES = RES.ID_SCRES ");
		builder.append("LEFT JOIN BD_DEP DEP ON APTOP.ID_DEP = DEP.ID_DEP ");
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
		builder.append("WHERE SRV.SD_SCTP IN(?,?)  ");
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
		builder.append(" AND APT.DT_B >= ? ");
		sqlParam.addParam(param.getDt_begin()+" 00:00:00");
		builder.append(" AND APT.DT_B <= ? ");
		sqlParam.addParam(param.getDt_end()+" 23:59:59");
		if(!StringUtil.isEmpty(patId)){
			builder.append(" AND PAT.ID_PAT = ? ");
			sqlParam.addParam(patId);
		}
		return builder.toString();
	}
}
