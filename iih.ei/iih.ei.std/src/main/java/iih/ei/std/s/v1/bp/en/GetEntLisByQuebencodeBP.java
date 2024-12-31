package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.entlistbyquebencode.d.EntListByQuebencodeDTO;
import iih.ei.std.d.v1.en.entlistbyquebencode.d.EntListByQuebencodeParamDTO;
import iih.ei.std.d.v1.en.entlistbyquebencode.d.EntListByQuebencodeResultDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.ei.std.s.v1.bp.common.PsnDocEP;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.i.IEnQueQryService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取本次就诊患者分类  BP
 * 
 * @author li.wm
 */
public class GetEntLisByQuebencodeBP extends IIHServiceBaseBP<EntListByQuebencodeParamDTO, EntListByQuebencodeResultDTO>{
	/*
	 * 身份标志类型
	 */
	private static final String SD_IDTP_IDENTITY = "01";// 居民身份证
	private static final String SD_IDTP_OTHER = "02";// 其他
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(EntListByQuebencodeParamDTO param) throws BizException {
		if (param.getCode_pat() == null) {
			throw new BizException("患者编码不能为空！");
		}
		if (param.getCode_queben() == null) {
			throw new BizException("分诊台编码不能为空！");
		}
		if (param.getCode_opr() == null){
			throw new BizException("操作员编码不能为空！");
		}
	}

	@Override
	protected EntListByQuebencodeResultDTO process(EntListByQuebencodeParamDTO param) throws BizException {
		EntListByQuebencodeResultDTO resultDTO = new EntListByQuebencodeResultDTO();
		//1.校验患者是否存在
		PatDO patDO = new PatEP().getPatByCode(param.getCode_pat());
		if(patDO == null){
			throw new BizException("在IIH中未查询到该编码对应的患者！患者编码为："+param.getCode_pat());
		}
				
		//1.获取当前分诊台信息
		TriageBenInfoDTO benInfo = this.getBenInfo(param.getCode_queben());
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam,benInfo,patDO.getId_pat());
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		
		List<EntListByQuebencodeDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, EntListByQuebencodeDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		//设置DTO里的一些值，并把它放进  resultDTO
		resultDTO.setEntlistbyquebencode(ArrayListUtil.ConvertToFArrayList(setStatus(list)));
		return resultDTO;
	}
	
	/***
	 * @Description:获取sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(EntListByQuebencodeParamDTO param,SqlParam sqlParam,TriageBenInfoDTO benInfo,String patId) throws BizException{
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" SELECT PAT.CODE  AS CODE_PAT, ");
		sqlSb.append(" PAT.NAME         AS NAME_PAT, ");
		sqlSb.append(" EN.DT_ENTRY      AS DT_ENTRY, ");
		sqlSb.append(" DL.SD_DAYSLOTTP  AS CODE_DAYSLOTTP, ");
		sqlSb.append(" DL.NAME  		AS NAME_DAYSLOTTP, ");
		sqlSb.append(" SR.CODE          AS CODE_RES, ");
		sqlSb.append(" SR.NAME          AS NAME_RES,");
		sqlSb.append(" SS.CODE          AS CODE_SRVTP, ");
		sqlSb.append(" SS.NAME          AS NAME_SRVTP, ");
		sqlSb.append(" CHL.CODE         AS CODE_CHLTP, ");
		sqlSb.append(" CHL.CODE         AS NAME_CHLTP, ");
		sqlSb.append(" DEP.CODE         AS CODE_DEPT,");
		sqlSb.append(" DEP.NAME         AS NAME_DEPT,");
		sqlSb.append(" OP.TIMES_OP      AS TIMES_OP,");
		sqlSb.append(" OP.TICKETNO      AS Ticket_no,");
		sqlSb.append(" EN.DT_INSERT     AS DT_OPR,");
		sqlSb.append(" PAT.ID_CODE      AS CODE_ID,");
		sqlSb.append(" PAT.SD_IDTP      AS TYPE_ID,");
		sqlSb.append(" PAT.BARCODE_CHIS AS CODE_BAR,");
		sqlSb.append(" PAT.SD_SEX       AS SEX,");
		sqlSb.append(" PAT.DT_BIRTH, ");
		sqlSb.append(" OP.SD_STATUS,");
		sqlSb.append(" QUE.SD_STATUS_ACPT, ");
		sqlSb.append(" QUE.ID_QUE_SITE, ");
		sqlSb.append(" QUE.SORTNO_CALLED ");
	    sqlSb.append(" FROM EN_ENT EN");
	    sqlSb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = EN.ID_PAT ");
	    sqlSb.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
	    sqlSb.append(" INNER JOIN EN_ENT_QUE QUE ON QUE.ID_ENT = EN.ID_ENT ");
	    sqlSb.append(" INNER JOIN SC_SCH SCH ON OP.ID_SCH = SCH.ID_SCH ");
	    sqlSb.append(" INNER JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
	    sqlSb.append(" LEFT OUTER JOIN SC_RES SR ON OP.ID_SCRES = SR.ID_SCRES ");
	    sqlSb.append(" LEFT OUTER JOIN SC_SRV SS ON OP.ID_SCSRV = SS.ID_SCSRV ");
	    sqlSb.append(" LEFT JOIN SC_APT APT ON OP.ID_SCHAPT = APT.ID_APT ");
	    sqlSb.append(" LEFT JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
	    sqlSb.append(" LEFT OUTER JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
	    sqlSb.append(" LEFT OUTER JOIN BD_DAYSLOT DL ON SCH.ID_DAYSLOT = DL.ID_DAYSLOT ");
	    sqlSb.append(" WHERE PAT.ID_PAT = ?");
	    sqlParam.addParam(patId);
	    sqlSb.append(" AND PL.ID_QUEBEN = ?");
	    sqlParam.addParam(benInfo.getId_queben());
	    sqlSb.append(" AND QUE.SD_ENTQUE_TP = ?");
	    sqlParam.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
	    FDateTime curDateTime = EiAppUtils.getAcptQryDateTime(benInfo.getDate(), benInfo.getId_dayslot());
	    sqlSb.append(" AND OP.DT_VALID_B <= ?");
	    sqlSb.append(" AND OP.DT_VALID_E >= ?");
	    sqlParam.addParam(curDateTime);
	    sqlParam.addParam(curDateTime);
	    sqlSb.append(" AND EN.FG_CANC='N'");
	    
		return sqlSb.toString();
	}
	
	/**
	 * 2.获取分诊台
	 * @param queBenCode
	 * @throws BizException
	 */
	private TriageBenInfoDTO  getBenInfo(String queBenCode) throws BizException{
		IQuebenRService rService = ServiceFinder.find(IQuebenRService.class);
		QueBenDO[] bendos = rService.find(" code ='"+queBenCode+"'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(bendos)){
			throw new BizException("未获取编码为"+queBenCode+"的分诊台");
		}
		IEnQueQryService serv = ServiceFinder.find(IEnQueQryService.class);
		TriageBenInfoDTO ben =  serv.getTriageBenInfo(bendos[0].getId_queben(), IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		if(ben == null)
			throw new BizException(String.format("分诊台[%s]信息获取失败！", bendos[0].getName()));
		return ben;
	}
	
	/**
	 * 2.获取分诊台
	 * @param queBenCode
	 * @throws BizException
	 */
	private List<EntListByQuebencodeDTO>  setStatus(List<EntListByQuebencodeDTO> list) throws BizException{
		GetEntStatusBP statusBP = new GetEntStatusBP();
		for (EntListByQuebencodeDTO dto : list) {
			dto.setType_id(getIdentStatus(dto.getType_id()));
			dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getDt_birth())));
			dto.setVisit_flag(statusBP.getVisitStatusNew(dto.getSd_status(),dto.getSd_status_acpt(),dto.getId_que_site(),dto.getSortno_called()));
			
		}
		return list;
	}
	
	/**new
	 * 获取身份类型
	 * 
	 * @param curTime
	 * @param birth
	 * @param level_pri
	 * @return
	 */
	private String getIdentStatus(String idTp){
		if(!StringUtil.isEmpty(idTp)&& IPiDictCodeConst.SD_IDTP_IDENTITY.equals(idTp)){
			return  SD_IDTP_IDENTITY;//居民身份证
		}else{
			return SD_IDTP_OTHER;//其他
		}
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,EntListByQuebencodeResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
