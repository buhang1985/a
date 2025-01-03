package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.brokenaptlist.d.BrokenAptListDTO;
import iih.ei.std.d.v1.en.brokenaptlist.d.BrokenAptListParamDTO;
import iih.ei.std.d.v1.en.brokenaptlist.d.BrokenAptListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取门诊患者爽约记录  BP
 * 
 * @author li.wm
 */
public class GetBrokenAptListBP extends IIHServiceBaseBP<BrokenAptListParamDTO, BrokenAptListResultDTO> {

	/***
	 * 参数校验
	 */
	@Override
	protected void checkParam(BrokenAptListParamDTO param) throws BizException {
		if(StringUtil.isEmpty(param.getCode_pat())){
			throw new BizException("患者编码不能为空！");
		}
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}
	
	/***
	 * 核心处理
	 */
	@Override
	protected BrokenAptListResultDTO process(BrokenAptListParamDTO param) throws BizException {
		BrokenAptListResultDTO resultDTO = new BrokenAptListResultDTO();
		//1.校验患者是否存在
		PatDO patDO = new PatEP().getPatByCode(param.getCode_pat());
		if(patDO == null){
			throw new BizException("在IIH中未查询到该编码对应的患者！患者编码为："+param.getCode_pat());
		}
		
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param, sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<BrokenAptListDTO> list   = findPagingData(pageInfoDto, sql, sqlParam,BrokenAptListDTO.class);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到该患者的门诊爽约记录！患者编码为："+param.getCode_pat());
		}
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setBrokenapt(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/***
	 * @Description:获取爽约记录
	 * @param param
	 * @param sqlParam
	 * @return
	 */
	private String getSql(BrokenAptListParamDTO param, SqlParam sqlParam) {
		StringBuilder sb = new StringBuilder();
		
		//预约爽约
		sb.append("SELECT BBR.ID_KEY AS ID_KEY,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("PAT.NAME AS NAME_PAT,");
		sb.append("SEX.CODE AS CODE_SEX,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("SRV.CODE AS CODE_SCSRV,");
		sb.append("SRV.NAME AS NAME_SCSRV,");
		sb.append("BBR.DT_ACT AS DT_BROKEN,");
		sb.append("BBR.SD_BBRTP AS EU_BBRTP,");
		sb.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE ");
		sb.append("FROM PI_PAT_BBR BBR ");
		sb.append("INNER JOIN PI_PAT PAT ON BBR.ID_PAT = PAT.ID_PAT ");
		sb.append("INNER JOIN SC_APT APT ON BBR.ID_KEY = APT.ID_APT ");
		sb.append("LEFT JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX ");
		sb.append("WHERE PAT.CODE  = ? ");
		sb.append("AND BBR.FG_ACTIVE = ? ");
		sb.append("AND BBR.SD_BBRTP = ? ");

		sb.append(" UNION ");
		
		//就诊爽约
		//预约爽约
		sb.append("SELECT BBR.ID_KEY AS ID_KEY,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("PAT.NAME AS NAME_PAT,");
		sb.append("SEX.CODE AS CODE_SEX,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("SRV.CODE AS CODE_SCSRV,");
		sb.append("SRV.NAME AS NAME_SCSRV,");
		sb.append("BBR.DT_ACT AS DT_BROKEN,");
		sb.append("BBR.SD_BBRTP AS EU_BBRTP,");
		sb.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE ");
		sb.append("FROM PI_PAT_BBR BBR ");
		sb.append("INNER JOIN PI_PAT PAT ON BBR.ID_PAT = PAT.ID_PAT ");
		sb.append("INNER JOIN EN_ENT ENT ON BBR.ID_KEY = ENT.ID_ENT ");
		sb.append("INNER JOIN EN_ENT_OP ENTOP ON ENTOP.ID_ENT = ENT.ID_ENT ");
		sb.append("LEFT JOIN SC_SRV SRV ON ENTOP.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX ");
		sb.append("WHERE PAT.CODE  = ? ");
		sb.append("AND BBR.FG_ACTIVE = ? ");
		sb.append("AND BBR.SD_BBRTP = ? ");
		
		sqlParam.addParam(param.getCode_pat());
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(IPiDictCodeConst.SD_BBRTP_OPORDERBREAK);
		sqlParam.addParam(param.getCode_pat());
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(IPiDictCodeConst.SD_BBRTP_NOTREGISTEAFTERREGISTRATION);
		return sb.toString();
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,BrokenAptListResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
