package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.schlist.d.SchInfoDTO;
import iih.ei.std.d.v1.en.schlist.d.SchListParamDTO;
import iih.ei.std.d.v1.en.schlist.d.SchListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.ChlTpEP;
import iih.en.pv.outpatient.dto.d.SchDayslotDTO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 获取门诊排班参数列表BP
 *
 * @author fanlq
 * @date: 2019年9月2日 下午1:07:56
 */
public class GetSchListBP extends IIHServiceBaseBP<SchListParamDTO, SchListResultDTO> {

	/***
	 * 校验入参
	 */
	@Override
	protected void checkParam(SchListParamDTO param) throws BizException {
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

	/****
	 * 核心处理
	 */
	@Override
	protected SchListResultDTO process(SchListParamDTO param) throws BizException {
		SchListResultDTO resultDto = new SchListResultDTO();
		List<SchInfoDTO> schInfoList = new ArrayList<SchInfoDTO>();

		// 获取渠道
		SchedulechlDO chlDo = new ChlTpEP().getScChlByTp(param.getCode_chltp());

		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam,chlDo);

		//执行sql语句，分页
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo();
		schInfoList = findPagingData(pageInfoDto, sql, sqlParam, SchInfoDTO.class);
		if(ListUtil.isEmpty(schInfoList)){
			return resultDto;
		}

		//查询所有排班同号源池不包含当前渠道的号位
		schInfoList = setTotalNumber(schInfoList,chlDo);
		// 加载价格信息
		this.loadSrvPrice(schInfoList);
		//获取没有过停止挂号时间的排班
		this.getNotEndReg(schInfoList);
		//设置医生职称名称、编码空串
		this.setNameAndCodeEmptitle(schInfoList);

		//返回值设置分页信息
		resultDto.setPageinfo(pageInfoDto);
		//返回值设置排班信息
		resultDto.setSchinfo(ArrayListUtil.ConvertToFArrayList(schInfoList));
		return resultDto;
	}


	/***
	 * @Description:获取门诊排班信息sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException
	 */
	private String getSql(SchListParamDTO param, SqlParam sqlParam,SchedulechlDO chlDo) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select sch.id_sch as Id_sch, ");
		sql.append("sch.d_sch as Dt_sch, ");
		sql.append("dep.code as Code_dep,");
		sql.append("dep.name as Name_dep,");
		sql.append("nvl(doc.code, dep.code) as Code_doc, ");
		sql.append("nvl(doc.name, dep.name) as Name_doc, ");
		sql.append("srv.id_scsrv as Id_srv, ");
		sql.append("srv.code as Code_srv, ");
		sql.append("srv.name as Name_srv, ");
		sql.append("srvtp.code as Code_srvtp, ");
		sql.append("srvtp.name as Name_srvtp, ");
		sql.append("lottp.code as Code_dayslottp, ");
		sql.append("lottp.name as Name_dayslottp, ");
		if (chlDo != null) {
			sql.append("case schchl.scpolcn when 0 then nvl(sch.quan0_appt,0) when 1 then nvl(sch.quan1_appt,0) when 2 then nvl(sch.quan2_appt,0) when 3 then nvl(sch.quan3_appt,0) when 4 then nvl(sch.quan4_appt,0) when 5 then nvl(sch.quan5_appt,0) when 6 then nvl(sch.quan6_appt,0) when 7 then nvl(sch.quan7_appt,0) when 8 then nvl(sch.quan8_appt,0) when 9 then nvl(sch.quan9_appt,0) else nvl(quan_total_appt，0) end as total,");
			sql.append("case schchl.scpolcn when 0 then nvl(sch.quan0_used,0) when 1 then nvl(sch.quan1_used,0) when 2 then nvl(sch.quan2_used,0) when 3 then nvl(sch.quan3_used,0) when 4 then nvl(sch.quan4_used,0) when 5 then nvl(sch.quan5_used,0) when 6 then nvl(sch.quan6_used,0) when 7 then nvl(sch.quan7_used,0) when 8 then nvl(sch.quan8_used,0) when 9 then nvl(sch.quan9_used,0) else nvl(quan_total_used，0) end as used,");
			sql.append("schchl.scpolcn, ");// 号源池
		} else {
			sql.append("quan_total_appt total,");
			sql.append("quan_total_used used,");
		}
		sql.append("chl.code as code_chltp, ");
		sql.append("chl.name as chl_name, ");
		sql.append("title.code as Code_emptitle,");
		sql.append("title.name as Name_emptitle, ");
		sql.append("RES.DES AS DOC_SPECIALITY, ");
		sql.append(" res.sd_screstp, "); //资源类型编码
		sql.append("sch.fg_active ");
		sql.append("from sc_sch sch ");
		sql.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sql.append("inner join sc_res res on res.id_scres = pl.id_scres ");
		sql.append("left join bd_psndoc doc on doc.id_psndoc = res.id_emp ");
		sql.append("inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sql.append("inner join bd_dep dep on dep.id_dep = pl.id_dep ");
		sql.append("inner join bd_udidoc srvtp on srvtp.id_udidoc = srv.id_srvtp ");
		sql.append("inner join bd_dayslot dayslot on dayslot.id_dayslot = sch.id_dayslot ");
		sql.append("inner join bd_udidoc lottp on lottp.id_udidoc = dayslot.id_dayslottp ");
		sql.append("inner join sc_sch_chl schchl on schchl.id_sch = sch.id_sch ");
		sql.append("inner join sc_chl chl on chl.id_scchl = schchl.id_scchl ");
		sql.append("left join bd_udidoc title on title.id_udidoc = doc.id_emptitle ");
		sql.append("where SCH.SD_SCTP = ?  ");
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		// 开始日期
		if (param.getDt_begin() != null) {
			sql.append("and sch.d_sch >= ? ");
			sqlParam.addParam(param.getDt_begin());
		}
		// 结束日期
		if (param.getDt_end() != null) {
			sql.append("and sch.d_sch <= ? ");
			sqlParam.addParam(param.getDt_end());
		}
		//启用标识
		if(param.getFg_active() != null){
			sql.append("and sch.fg_active = ? ");
			sqlParam.addParam(param.getFg_active());
		}
		// 科室编码
		if (!StringUtils.isNullOrEmpty(param.getCode_dep())) {
			sql.append("and dep.code = ? ");
			sqlParam.addParam(param.getCode_dep());
		}
		// 资源名称
		if (!StringUtils.isNullOrEmpty(param.getName_res())) {
			sql.append("and (doc.name like ? or res.name like ? ) ");
			sqlParam.addParam("%" + param.getName_res() + "%");
			sqlParam.addParam("%" + param.getName_res() + "%");
		}
		// 号别
		if (!StringUtils.isNullOrEmpty(param.getCode_srvtp())) {
			sql.append("and srvtp.code = ? ");
			sqlParam.addParam(param.getCode_srvtp());
		}
		// 渠道
		if (!StringUtils.isNullOrEmpty(param.getCode_chltp())) {
			sql.append("and chl.sd_scchltp = ? ");
			sqlParam.addParam(param.getCode_chltp());
		}
		//排序
		sql.append("order by sch.d_sch, lottp.code ");
		return sql.toString();
	}

	/***
	 * @Description:查询所有排班同号源池不包含当前渠道的号位
	 * @return
	 * @throws BizException
	 */
	private List<SchInfoDTO> setTotalNumber(List<SchInfoDTO> schInfoList,SchedulechlDO chlDo) throws BizException{
		Map<String, List<ScSchTickDO>> map = null;
		if (null != chlDo) {
			Map<String, Integer> schMap = new HashMap<String, Integer>();
			for (SchInfoDTO info : schInfoList) {
				if (!schMap.containsKey(info.getId_sch())) {
					schMap.put(info.getId_sch(), info.getScpolcn());
				}
			}
			map = ServiceFinder.find(IScSchOutQryService.class).batchGetSchOtherChlTick(schMap, chlDo);
		}
		List<SchInfoDTO> schInfos = new LinkedList<>();
		for (SchInfoDTO schInfo : schInfoList) {
			if (schInfo.getTotal() == 0)
				continue;
			schInfo.setRemain(schInfo.getTotal() - schInfo.getUsed());// 计算剩余
			if (StringUtil.isEmptyWithTrim(schInfo.getName_doc()))
				schInfo.setName_doc("-1");
			if (StringUtil.isEmptyWithTrim(schInfo.getCode_doc()))
				schInfo.setCode_doc("-1");
			// 渠道非空时可预约数需要减去同号源池不包含当前渠道的号位数量
			if (null != chlDo && null != map && map.containsKey(schInfo.getId_sch())) {
				schInfo.setTotal(schInfo.getTotal() - map.get(schInfo.getId_sch()).size());
				schInfo.setRemain(schInfo.getTotal() - schInfo.getUsed());
			}
			schInfos.add(schInfo);
		}
		return schInfos;
	}

	/**
	 * 获取服务价格信息
	 *
	 * @param regResList 资源集合
	 * @return
	 * @throws BizException
	 */
	private void loadSrvPrice(List<SchInfoDTO> schInfoList) throws BizException {
		RegResDTO[] regResDTOs = new RegResDTO[schInfoList.size()];
		for (int i = 0; i < schInfoList.size(); i++) {
			RegResDTO regRes = new RegResDTO();
			regRes.setId_scsrv(schInfoList.get(i).getId_srv());
			regResDTOs[i] = regRes;
		}
		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] resResult = scSchOutQryService.loadResPri(regResDTOs);
		Map<String, FDouble> regResMap = new LinkedHashMap<String, FDouble>();
		for (RegResDTO regResDTO : resResult) {
			regResMap.put(regResDTO.getId_scsrv(), regResDTO.getAmt_st());
		}
		for (SchInfoDTO schInfo : schInfoList) {
			schInfo.setPrice(regResMap.get(schInfo.getId_srv()));
		}
	}

	/***
	 * @Description:获取没有过停止挂号时间的排班
	 * @param beginDate
	 * @param schInfoList
	 * @return
	 * @throws BizException
	 */
	private void getNotEndReg(List<SchInfoDTO> schInfoList) throws BizException{
		List<String> schIds = new ArrayList<String>();
		for(SchInfoDTO schInfoDTO : schInfoList){
			schIds.add(schInfoDTO.getId_sch());
		}
		if(schIds.size() <= 0) return;
		StringBuffer sql = new StringBuffer();
		sql.append("select sch.id_sch, ");
		sql.append("sch.d_sch, " );
		sql.append("sch.t_e_reg, " );
		sql.append("dayslot.time_begin, " );
		sql.append("dayslot.time_end " );
		sql.append("from sc_sch sch " );
		sql.append("inner join bd_dayslot dayslot on dayslot.id_dayslot = sch.id_dayslot " );
		sql.append("where "+SqlUtils.getInSqlByBigIds("sch.id_sch", schIds.toArray(new String[0])));
		@SuppressWarnings("unchecked")
		List<SchDayslotDTO> schDayslotList = (List<SchDayslotDTO>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(SchDayslotDTO.class));
		if (ListUtil.isEmpty(schDayslotList)) return;
		FMap map = new FMap();
		for(SchDayslotDTO dto : schDayslotList){
			map.put(dto.getId_sch(), dto);
		}
		for(SchInfoDTO schInfoDTO : schInfoList){
			SchDayslotDTO dto = (SchDayslotDTO)map.get(schInfoDTO.getId_sch());
			if(dto.getTime_begin().after(dto.getTime_end()))
				schInfoDTO.setDt_stopreg(new FDateTime(dto.getD_sch().getDateAfter(1), dto.getT_e_reg()));
			else
				schInfoDTO.setDt_stopreg(new FDateTime(dto.getD_sch(), dto.getT_e_reg()));
		}
	}

	/***
	 * @Description:若职位编码、名称为空，设置为空串
	 * @author yu.b 2020-07-27
	 * @param schInfoList
	 * @return
	 */
	private void setNameAndCodeEmptitle(List<SchInfoDTO> schInfoList){
		for (SchInfoDTO schInfoDTO : schInfoList) {
			if (StringUtil.isEmpty(schInfoDTO.getCode_emptitle())) {
				schInfoDTO.setCode_emptitle("");
			}
			if (StringUtil.isEmpty(schInfoDTO.getName_emptitle())) {
				schInfoDTO.setName_emptitle("");
			}
		}
	}

}
