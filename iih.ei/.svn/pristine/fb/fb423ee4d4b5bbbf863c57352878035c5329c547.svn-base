package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.opstopschlist.d.OpStopSchListDTO;
import iih.ei.std.d.v1.en.opstopschlist.d.OpStopSchListParamDTO;
import iih.ei.std.d.v1.en.opstopschlist.d.OpStopSchListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取门诊停诊列表  BP
 * 
 * @author li.wm
 */
public class GetOpStopSchListBP extends IIHServiceBaseBP<OpStopSchListParamDTO, OpStopSchListResultDTO> {
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(OpStopSchListParamDTO param) throws BizException {
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
	protected OpStopSchListResultDTO process(OpStopSchListParamDTO param) throws BizException {
		OpStopSchListResultDTO resultDto = new OpStopSchListResultDTO();

		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param, sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<OpStopSchListDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, OpStopSchListDTO.class);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到门诊停诊列表！");
		}
		//设置停诊排班信息价格
		this.setPrice(list);
		
		//返回值设置分页信息
		this.setPageInfo(pageInfoDto,resultDto);
		resultDto.setOpstopschlist(ArrayListUtil.ConvertToFArrayList(list));
		return resultDto;
	}
	/***
	 * @Description:
	 * @param param
	 * @param sqlParam
	 * @return
	 */
	private String getSql(OpStopSchListParamDTO param, SqlParam sqlParam) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SC_SCH.ID_SCH AS ID_SCH,");
		sb.append("SC_SCH.D_SCH AS DT_SCH,");
		sb.append("BD_DEP.CODE AS CODE_DEP,");
		sb.append("BD_DEP.NAME AS NAME_DEP,");
		sb.append("SC_RES.CODE AS CODE_RES,");
		sb.append("SC_RES.NAME AS NAME_RES,");
		sb.append("SC_RES.DES AS SPECIALITY,");
		sb.append("BD_DAYSLOT.NAME AS CODE_DAYSLOTTP,  ");
		sb.append("BD_DAYSLOT.SD_DAYSLOTTP AS NAME_DAYSLOTTP,");
		sb.append("NVL(SC_SCH.QUAN_TOTAL_APPT,0) - NVL(SC_SCH.QUAN_TOTAL_USED,0) AS REMAIN_TICKET,");
		sb.append("SC_SRV.ID_SCSRV AS ID_SCSRV,");
		sb.append("SC_SRV.CODE AS CODE_SCSRV,");
		sb.append("SC_SRV.NAME AS NAME_SCSRV ");
		sb.append("FROM SC_SCH SC_SCH INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		sb.append("INNER JOIN SC_RES SC_RES ON SC_PL.ID_SCRES = SC_RES.ID_SCRES ");
		sb.append("INNER JOIN SC_SRV SC_SRV ON SC_PL.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("INNER JOIN BD_DAYSLOT BD_DAYSLOT ON SC_SCH.ID_DAYSLOT = BD_DAYSLOT.ID_DAYSLOT ");
		sb.append("LEFT JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("WHERE SC_SCH.FG_ACTIVE = ? ");
		sb.append("AND SC_SCH.D_SCH >= ? ");
		sb.append("AND SC_SCH.D_SCH <= ? ");
		sb.append("AND SC_SCH.SD_SCTP = ? ");
		sb.append("ORDER BY SC_SCH.D_SCH,SC_PL.ID_DEP,BD_DAYSLOT.TIME_BEGIN,REMAIN_TICKET DESC ");
		sqlParam.addParam(FBoolean.FALSE);
		sqlParam.addParam(param.getDt_begin());
		sqlParam.addParam(param.getDt_end());
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		return sb.toString();
	}
	
	/**
	 * 对排班信息做处理
	 * 
	 * @param schInfos 排班信息集合
	 * @throws BizException 
	 */
	private void setPrice(List<OpStopSchListDTO> list) throws BizException{
		List<String> set = new ArrayList<String>();
		for(OpStopSchListDTO opStopSchListDTO : list){
			set.add(opStopSchListDTO.getId_scsrv());
		}
		Map<String, FDouble> map = this.getPrice(set);
		if(map == null || map.size() <= 0)
			return;
		for(OpStopSchListDTO schInfo : list){
			schInfo.setPrice_ticket(map.get(schInfo.getId_scsrv()));
		}
	}
	
	/**
	 * 获取服务价格
	 * 
	 * @param scSrvIds 排班服务集合
	 * @return Map<br/>  
	 * 		key : 排班服务id<br/>
	 * 		value : 价格
	 * @throws BizException
	 */
	public Map<String, FDouble> getPrice(List<String> scSrvIds) throws BizException{
		if(ListUtil.isEmpty(scSrvIds))
			return null;
		//去重
		Set<String> set = new HashSet<>();
		set.addAll(scSrvIds);
		//构造资源信息
		List<RegResDTO> list = new LinkedList<RegResDTO>();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			RegResDTO regRes = new RegResDTO();
			regRes.setId_scsrv(it.next());
			list.add(regRes);
		}	
		
		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] resResult = scSchOutQryService.loadResPri(list.toArray(new RegResDTO[0]));
		
		Map<String, FDouble> regResMap = new HashMap<String, FDouble>();
		for (RegResDTO regResDTO : resResult) {
			regResMap.put(regResDTO.getId_scsrv(), regResDTO.getAmt_st());
		}
		return regResMap;
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,OpStopSchListResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
