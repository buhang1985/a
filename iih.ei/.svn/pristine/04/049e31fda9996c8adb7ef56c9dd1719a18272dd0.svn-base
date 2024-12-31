package iih.ei.std.s.v1.bp.en;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.chlschstats.d.ChlSchStatsDTO;
import iih.ei.std.d.v1.en.chlschstats.d.ChlSchStatsParamDTO;
import iih.ei.std.d.v1.en.chlschstats.d.ChlSchStatsResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.ChlTpEP;
import iih.ei.std.s.v1.bp.common.EiCodeUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取渠道预约统计信息  BP
 * 
 * @author li.wm
 */
public class GetChlSchStatsBP extends IIHServiceBaseBP<ChlSchStatsParamDTO, ChlSchStatsResultDTO>{
	
	
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(ChlSchStatsParamDTO param) throws BizException {
		if (StringUtils.isNullOrEmpty(param.getDt_begin())) {
			throw new BizException("开始日期不能为空！");
		}
		if (StringUtils.isNullOrEmpty(param.getDt_end())) {
			throw new BizException("结束日期不能为空！");
		}
		if (StringUtils.isNullOrEmpty(param.getCode_chltp())){
			throw new BizException("渠道类型编码不能为空！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected ChlSchStatsResultDTO process(ChlSchStatsParamDTO param) throws BizException {
		ChlSchStatsResultDTO resultDTO = new ChlSchStatsResultDTO();
		SqlParam sqlParam = new SqlParam();
		
		//1.获取渠道
		SchedulechlDO schedulechlDO = new ChlTpEP().getScChlByTp(param.getCode_chltp());
		if(schedulechlDO == null){
			throw new BizException("未查询到该渠道类型编码对应的渠道信息！渠道类型编码为："+param.getCode_chltp());
		}
		
		//2.获取SQL
		String sql = getChlSchStatsInfos(param,sqlParam,schedulechlDO.getId_scchl());
		
		List<ChlSchStatsDTO> list = this.findDataList(sql, sqlParam, ChlSchStatsDTO.class);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到该渠道类型编码对应的排班信息！渠道类型编码为："+param.getCode_chltp());
		}
		
		ChlSchStatsDTO chlDTO = list.toArray(new ChlSchStatsDTO[]{})[0];
		
		chlDTO.setValid_ticket(chlDTO.getTotal_ticket() - chlDTO.getUsed_ticket());
		chlDTO.setCode_chltp(param.getCode_chltp());
		//获取预约数量信息
		this.getAptNumInfo(param,chlDTO,schedulechlDO.getId_scchl());
		//获取就诊数量信息
		this.getEntNumInfo(param,chlDTO,schedulechlDO.getId_scchl());
		//设置返回值
		resultDTO.setChlschstat(chlDTO);
		return resultDTO;
	}
	/**
	 * 获取排班信息（总数、剩余数）
	 * @param chlId 渠道ID
	 * @param srvType 号别类型编码
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @param deptCode 科室编码
	 * @param deptName 科室名称
	 * @throws DAException 
	 */
	private String getChlSchStatsInfos(ChlSchStatsParamDTO param,SqlParam sqlParam,String chlId) throws DAException{
		StringBuilder builder =new StringBuilder();
		builder.append("select sum(a.total) Total_ticket,sum(a.used) Used_ticket from ( ");
		builder.append("SELECT SCH.ID_SCH, ");
		builder.append("DECODE(CHL.SCPOLCN,0,NVL(SCH.QUAN0_APPT, 0),1,NVL(SCH.QUAN1_APPT, 0),2,NVL(SCH.QUAN2_APPT, 0),3,NVL(SCH.QUAN3_APPT, 0),4,NVL(SCH.QUAN4_APPT, 0),5,NVL(SCH.QUAN5_APPT, 0),6,NVL(SCH.QUAN6_APPT, 0),7,NVL(SCH.QUAN7_APPT, 0),8,NVL(SCH.QUAN8_APPT, 0),9,NVL(SCH.QUAN9_APPT, 0),NVL(QUAN_TOTAL_APPT，0)) TOTAL, ");
		builder.append("DECODE(CHL.SCPOLCN,0,NVL(SCH.QUAN0_USED, 0),1,NVL(SCH.QUAN1_USED, 0),2,NVL(SCH.QUAN2_USED, 0),3,NVL(SCH.QUAN3_USED, 0),4,NVL(SCH.QUAN4_USED, 0),5,NVL(SCH.QUAN5_USED, 0),6,NVL(SCH.QUAN6_USED, 0),7,NVL(SCH.QUAN7_USED, 0),8,NVL(SCH.QUAN8_USED, 0),9,NVL(SCH.QUAN9_USED, 0),NVL(QUAN_TOTAL_USED，0)) USED ");
		builder.append("FROM SC_SCH SCH INNER JOIN SC_PL CPL ON SCH.ID_SCPL = CPL.ID_SCPL ");
		builder.append("INNER JOIN SC_RES RES ON CPL.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN SC_SRV SRV ON CPL.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("INNER JOIN SC_SCH_CHL CHL ON CHL.ID_SCH = SCH.ID_SCH ");
		builder.append("INNER JOIN BD_DEP DEP ON CPL.ID_DEP = DEP.ID_DEP ");
		builder.append("WHERE 1 = 1  ");
		builder.append(" AND SCH.D_SCH >= ? ");
		sqlParam.addParam(param.getDt_begin());
		builder.append(" AND SCH.D_SCH <= ? ");
		sqlParam.addParam(param.getDt_end());
		builder.append("AND CHL.ID_SCCHL = ? ");
		sqlParam.addParam(chlId);
		if(!StringUtil.isEmpty(param.getCode_srvtp())){
			builder.append("AND SRV.SD_SRVTP = ? ");
			sqlParam.addParam(param.getCode_srvtp());
		}
		if(!StringUtil.isEmpty(param.getCode_dep())){
			builder.append("AND DEP.CODE= ? ");
			sqlParam.addParam(param.getCode_dep());
		}else if(!StringUtil.isEmpty(param.getName_dep())){
			builder.append("AND DEP.NAME LIKE '%").append(param.getName_dep()).append("%'");
		}
		builder.append(" ) a");
		return builder.toString();
	}

	/***
	 * @Description:获取预约数量信息
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private void getAptNumInfo(ChlSchStatsParamDTO param,ChlSchStatsDTO chlDTO,String chlId) throws BizException{
		StringBuilder builder =new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		builder.append("select ");
		builder.append("nvl(sum(case when apt.sd_status='1' then '1' end),'0') as num_aptNotFee, ");
		builder.append("nvl(sum(case when apt.sd_status='2' then '1' end),'0') as num_aptWithFee, ");
		builder.append("nvl(sum(case when apt.sd_status='3' then '1' end),'0') as num_aptCfm, ");
		builder.append("nvl(sum(case when apt.sd_status='4' then '1' end),'0') as num_aptCanc ");
		builder.append("from sc_apt apt  ");
		builder.append("inner join sc_sch sch on apt.id_sch = sch.id_sch ");
		builder.append("inner join sc_chl scchl on scchl.id_scchl = apt.id_scchl ");
		builder.append("LEFT JOIN SC_APT_OP OP ON  APT.ID_APT = OP.ID_APT  ");
		builder.append("LEFT JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV  ");
		builder.append("LEFT JOIN BD_DEP DEP ON APT.ID_DEP_APPT = DEP.ID_DEP  ");
		builder.append("WHERE 1 = 1  ");
		builder.append(" AND SCH.D_SCH >= ? ");
		sqlParam.addParam(param.getDt_begin());
		builder.append(" AND SCH.D_SCH <= ? ");
		sqlParam.addParam(param.getDt_end());
		builder.append("AND APT.ID_SCCHL = ? ");
		sqlParam.addParam(chlId);
		if(!StringUtil.isEmpty(param.getCode_srvtp())){
			String[] srvTps = EiCodeUtils.srvTypeTOIIHSrvTp(param.getCode_srvtp());
			if(!ArrayUtil.isEmpty(srvTps)){
				builder.append("AND " + SqlUtils.getInSqlByIds("SRV.SD_SRVTP", srvTps));
			}
		}
		if(!StringUtil.isEmpty(param.getCode_dep())){
			builder.append("AND DEP.CODE= ? ");
			sqlParam.addParam(param.getCode_dep());
		}else if(!StringUtil.isEmpty(param.getName_dep())){
			builder.append("AND DEP.NAME LIKE '%").append(param.getName_dep()).append("%'");
		}
		builder.append("GROUP BY APT.ID_SCCHL,SCCHL.CODE  ");
		@SuppressWarnings("unchecked")
		List<ChlSchStatsDTO> chlSchStatsList =(List<ChlSchStatsDTO>) new DAFacade().execQuery(builder.toString(),sqlParam,new BeanListHandler(ChlSchStatsDTO.class));	
		if (ListUtil.isEmpty(chlSchStatsList)) return;
		chlDTO.setNum_aprnotfee(chlSchStatsList.get(0).getNum_aprnotfee());
		chlDTO.setNum_aptcanc(chlSchStatsList.get(0).getNum_aptcanc());
		chlDTO.setNum_aptcfm(chlSchStatsList.get(0).getNum_aptcfm());
		chlDTO.setNum_aptwithfee(chlSchStatsList.get(0).getNum_aptwithfee());
	}
	/**
	 * 获取退号和未到诊的数量
	 * @param chlType 渠道类型
	 * @return
	 * @throws BizException 
	 */
	private void getEntNumInfo(ChlSchStatsParamDTO param,ChlSchStatsDTO chlDTO,String chlId)throws BizException{
		StringBuilder builder =new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		builder.append("select ");
		builder.append("nvl(sum(case when ent.fg_canc = 'Y' then '1' end),'0') as num_aptCfmCanc, ");
		builder.append("nvl(sum(case when ent.fg_canc = 'N'  AND ENTOP.SD_STATUS ='02' then '1' end),'0') as num_aptCfmAbsent ");
		builder.append("from  en_ent_op entop inner join en_ent ent on ent.id_ent = entop.id_ent ");
		builder.append("inner join sc_apt_op op on ent.id_ent = op.id_en ");
		builder.append("inner join sc_apt apt on apt.id_apt = op.id_apt ");
		builder.append("left join sc_sch sch  on apt.id_sch = sch.id_sch ");
		builder.append("left join sc_chl scchl on scchl.id_scchl = apt.id_scchl ");
		builder.append("left join sc_res res on apt.id_scres = res.id_scres ");
		builder.append("left join sc_srv srv on apt.id_scsrv = srv.id_scsrv ");
		builder.append("left join bd_dep dep on apt.id_dep_appt = dep.id_dep ");
		builder.append("where 1 = 1 ");
		builder.append("and sch.d_sch >= ? ");
		sqlParam.addParam(param.getDt_begin());
		builder.append("and sch.d_sch <= ? ");
		sqlParam.addParam(param.getDt_end());
		builder.append("and apt.id_scchl = ? ");
		sqlParam.addParam(chlId);
		if(!StringUtil.isEmpty(param.getCode_srvtp())){
			builder.append("and srv.sd_srvtp = ? ");
			sqlParam.addParam(param.getCode_srvtp());
		}
		if(!StringUtil.isEmpty(param.getCode_dep())){
			builder.append("and dep.code = ? ");
			sqlParam.addParam(param.getCode_dep());
		}else if(!StringUtil.isEmpty(param.getName_dep())){
			builder.append("and dep.name like '%").append(param.getName_dep()).append("%'");
		}
		builder.append("group by scchl.id_scchl,scchl.code  ");
		@SuppressWarnings("unchecked")
		List<ChlSchStatsDTO> chlSchStatsList =(List<ChlSchStatsDTO>) new DAFacade().execQuery(builder.toString(),sqlParam,new BeanListHandler(ChlSchStatsDTO.class));	
		if (ListUtil.isEmpty(chlSchStatsList)) return;
		chlDTO.setNum_aptcfmabsent(chlSchStatsList.get(0).getNum_aptcfmabsent());//取号未到诊
		chlDTO.setNum_aptcfmcanc(chlSchStatsList.get(0).getNum_aptcfmcanc());//退号
	}
	
}
