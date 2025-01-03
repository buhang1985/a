package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.utils.ContextUtils;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.opaptlist.d.OpAptListDTO;
import iih.ei.std.d.v1.en.opaptlist.d.OpAptListParamDTO;
import iih.ei.std.d.v1.en.opaptlist.d.OpAptListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.ChlTpEP;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取门诊预约记录
 * @author fanlq
 * @date: 2019年9月23日 下午6:09:01
 */
public class GetOpAptListBP extends IIHServiceBaseBP<OpAptListParamDTO, OpAptListResultDTO> {
	
	/***
	 * 参数校验
	 */
	@Override
	protected void checkParam(OpAptListParamDTO param) throws BizException {
		if(StringUtil.isEmpty(param.getDt_begin())){
			throw new BizException("开始日期不能为空！");
		}
		if(StringUtil.isEmpty(param.getDt_end())){
			throw new BizException("结束日期不能为空！");
		}
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected OpAptListResultDTO process(OpAptListParamDTO param) throws BizException {
		OpAptListResultDTO resultDto = new OpAptListResultDTO();
		SqlParam sqlParam = new SqlParam();
		
		// 获取渠道
		SchedulechlDO chlDo = new ChlTpEP().getScChlByTp(param.getCode_chltp());

		String sql = getSql(param,sqlParam,chlDo == null ? null:chlDo.getId_scchl());
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<OpAptListDTO> list = findPagingData(pageInfoDto,sql, sqlParam, OpAptListDTO.class);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到患者预约记录！");
		}
		//返回值设置分页信息
		this.setPageInfo(pageInfoDto,resultDto);
		resultDto.setOpaptinfo(ArrayListUtil.ConvertToFArrayList(list));
		return resultDto;
	}
	/***
	 * @Description:
	 * @param param
	 * @param sqlParam
	 * @return
	 */
	private String getSql(OpAptListParamDTO param, SqlParam sqlParam,String chlId) throws BizException {
		StringBuilder builder =new StringBuilder();
		builder.append("SELECT APT.ID_APT AS ID_APT, ");
		builder.append("APT.CODE AS CODE_APT, ");
		builder.append("PAT.CODE AS CODE_PAT, ");
		builder.append("PAT.NAME AS NAME_PAT, ");
		builder.append("DEP.CODE AS CODE_DEP, ");
		builder.append("DEP.NAME AS NAME_DEP, ");
		builder.append("ENT.DT_ACPT AS ENT_TIME, ");
		builder.append("APT.DT_APPT AS OPR_TIME, ");
		builder.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE, ");
		builder.append("DLT.SD_DAYSLOTTP AS CODE_DAYSLOTTP, ");
		builder.append("DLT.NAME AS NAME_DAYSLOTTP, ");
		builder.append("DP.SUGEST_EXMINT AS EXPECTED_WAITTIME, ");
		builder.append("RES.NAME AS NAME_RES, ");
		builder.append("RES.CODE AS CODE_RES, ");
		builder.append("APT.QUENO AS CODE_TICKET, ");
		builder.append("SRV.SD_SRVTP AS CODE_SRVTP,");
		builder.append("SRVTP.NAME AS NAME_SRVTP,");
		builder.append("SRV.CODE AS CODE_SCSRV,");
		builder.append("SRV.NAME AS NAME_SCSRV,");
		builder.append("CHL.SD_SCCHLTP AS CODE_CHLTP, ");
		builder.append("CHL.NAME AS NAME_CHLTP, ");
		builder.append("APT.FG_PAYMENT FG_PAYMENT, ");
		builder.append("APT.SD_STATUS AS CODE_APTSTATUS, ");//预约状态
		builder.append("ENTOP.SD_STATUS AS CODE_ENTSTATUS, ");//就诊状态
		builder.append("EXCHL.CODE_APT AS CODE_EXAPT  ");
		builder.append("FROM SC_APT APT ");
		builder.append("INNER JOIN SC_SCH SCH ON APT.ID_SCH = SCH.ID_SCH ");
		builder.append("INNER JOIN SC_PL CPL ON SCH.ID_SCPL = CPL.ID_SCPL ");
		builder.append("INNER JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("INNER JOIN SC_RES RES ON CPL.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON CPL.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		builder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
		builder.append("INNER JOIN BD_DAYSLOT DLT ON APT.ID_DATESLOT = DLT.ID_DAYSLOT ");
		builder.append("INNER JOIN BD_UDIDOC LOTTP ON LOTTP.ID_UDIDOC = DLT.ID_DAYSLOTTP ");
		builder.append("LEFT JOIN SC_DEP_PARAM DP ON CPL.ID_DEP = DP.ID_DEP ");
		builder.append("AND (CPL.ID_DEPPARAM IS NULL OR CPL.ID_DEPPARAM = DP.ID_DEPTPARAM) ");
		builder.append("LEFT JOIN BD_UDIDOC OPSTAT ON OPSTAT.ID_UDIDOC = APT.ID_STATUS ");
		builder.append("LEFT JOIN EN_ENT_OP ENTOP ON ENTOP.ID_SCHAPT = APT.ID_APT ");
		builder.append("LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = ENTOP.ID_ENT ");
		builder.append("LEFT JOIN SC_APT_EXCHL EXCHL ON EXCHL.ID_APT = APT.ID_APT ");
		builder.append("LEFT JOIN BD_UDIDOC SRVTP ON SRVTP.ID_UDIDOC  = SRV.ID_SRVTP  ");
		builder.append("LEFT JOIN BD_UDIDOC CHLTP ON CHLTP.CODE = CHL.SD_SCCHLTP AND CHLTP.ID_UDIDOCLIST = '"+IBdFcDictCodeConst.ID_CODE_SRVTP+"' ");
		builder.append("WHERE DEP.ACTIVESTATE = ? ");
		builder.append("AND  APT.SD_SCTP = ? AND APT.ID_ORG = ? ");
		sqlParam.addParam(ActiveStateEnum.ACTIVE);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		sqlParam.addParam(ContextUtils.getOrgId());
		builder.append("AND APT.DT_B >= ? ");
		sqlParam.addParam(param.getDt_begin()+" 00:00:00");
		builder.append("AND APT.DT_B <= ? ");
		sqlParam.addParam(param.getDt_end()+" 23:59:59");
		if(!StringUtil.isEmpty(chlId)){
			builder.append(" AND APT.ID_SCCHL = ? ");
			sqlParam.addParam(chlId);
		}
		if(!StringUtil.isEmpty(param.getCode_aptstatus())){
			builder.append(" AND APT.SD_STATUS = ? ");
			sqlParam.addParam(param.getCode_aptstatus());
		}
		if(!StringUtil.isEmpty(param.getName_dep())){
			builder.append(" AND DEP.NAME LIKE ? ");
			sqlParam.addParam("%"+param.getName_dep()+"%");
		}
		if(!StringUtil.isEmpty(param.getCode_pat())){
			builder.append("AND PAT.CODE = ? ");
			sqlParam.addParam(param.getCode_pat());
		}
		if(!StringUtil.isEmpty(param.getName_pat())){
			builder.append(" AND PAT.NAME LIKE ? ");
			sqlParam.addParam("%"+param.getName_pat()+"%");
		}
		return builder.toString();
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,OpAptListResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
