package iih.sc.scp.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.MtPlWkBriefDTO;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 根据计划id查询周计划
 * @author 
 *
 */
public class GetMtPlWkBriefBP {
	/**
	 * 根据计划id查询周计划
	 * @param scplId 计划id
	 * @param tickmd 号位模式
	 * @return
	 * @throws BizException
	 */
	public MtPlWkBriefDTO[] exec(String scplId, String tickmd) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(scplId))
			return null;
		ScPlanWeekDO[] weeks = getPlWeeks(scplId);
		if(ScValidator.isNullOrEmpty(weeks))
			return null;
		Map<String, MtPlWkBriefDTO> map = new HashMap<String, MtPlWkBriefDTO>();
		this.wrapWeek(weeks, map, tickmd);
		this.wrapWeekSrvs(map, scplId, tickmd);
		if(map.values() == null)
			return null;
		return map.values().toArray(new MtPlWkBriefDTO[0]);
	}
	/**
	 * 获取周计划集合
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException
	 */
	private ScPlanWeekDO[] getPlWeeks(String scplId) throws BizException{
		ScplWeekEP ep = new ScplWeekEP();
		return ep.getPlWeekByPlId(scplId);
	}
	/**
	 * 获取周计划号位或号段的指定服务
	 * 
	 * @param map
	 * @param tickmd
	 * @throws BizException 
	 */
	private void wrapWeekSrvs(Map<String, MtPlWkBriefDTO> map, String scplId, String tickmd) throws BizException{
		if(map == null || ScValidator.isEmptyIgnoreBlank(tickmd))
			return;
		String[] id_plweeks = map.keySet().toArray(new String[0]);
		if(ScValidator.isNullOrEmpty(id_plweeks))
			return;
		if(IScDictCodeConst.SD_TICKMD_TICK.equals(tickmd)){
			//号位模式
			List<ScPlanWeekTickDO> tk_srvs = this.getTickSrv(scplId);
			this.proccessTickSrv(map, tk_srvs);
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickmd)){
			//号段模式
			List<ScPlanWeekTicksDO> tks_srvs = this.getTicksSrv(scplId);
			this.proccessTicksSrv(map, tks_srvs);
		}
	}
	/**
	 * 处理周计划DO，组装为MtPlWkBriefDTO字典
	 * 
	 * @param weeks
	 * @param map
	 */
	private void wrapWeek(ScPlanWeekDO[] weeks, Map<String, MtPlWkBriefDTO> map, String tickmd){
		if(ScValidator.isNullOrEmpty(weeks) || map == null)
			return;
		for(ScPlanWeekDO week : weeks){
			MtPlWkBriefDTO mt_dto = new MtPlWkBriefDTO();
			mt_dto.setId_scplweek(week.getId_scplweek());
			mt_dto.setId_scpl(week.getId_scpl());
			mt_dto.setSd_tickmd(tickmd);
			mt_dto.setSv(week.getSv());
			mt_dto.setQuan_total(week.getQuan_total());
			mt_dto.setQuan_total_appt(week.getQuan_total_appt());
			mt_dto.setScpolcn(week.getScpolcn());
			mt_dto.setId_dayslot(week.getId_dayslot());
			mt_dto.setIdx_week(week.getIdx_week());
			mt_dto.setWeekno(week.getWeekno());
			map.put(week.getId_scplweek(), mt_dto);
		}
	}
	/**
	 * 获取号位排班服务
	 * 
	 * @param id_plweeks
	 * @throws BizException 
	 */
	private List<ScPlanWeekTickDO> getTickSrv(String scplId) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT TK.ID_SCPLWEEK, SRV.NAME AS NAME_SCSRV, SRV.CODE ");
		sb.append("FROM SC_PL_WEEK_TICK TK ");
		sb.append("INNER JOIN SC_PL_WEEK WEEK ON TK.ID_SCPLWEEK = WEEK.ID_SCPLWEEK ");
		sb.append("INNER JOIN SC_SRV SRV ON TK.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("WHERE WEEK.ID_SCPL = ? ");
		sb.append("ORDER BY SRV.CODE ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(scplId);
		return (List<ScPlanWeekTickDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ScPlanWeekTickDO.class));
	}
	/**
	 * 获取号段排班服务
	 * 
	 * @param id_plweeks
	 * @throws BizException 
	 */
	private List<ScPlanWeekTicksDO> getTicksSrv(String scplId) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT TK.ID_SCPLWEEK, SRV.NAME AS NAME_SCSRV, SRV.CODE ");
		sb.append("FROM SC_PL_WEEK_TICKS TK ");
		sb.append("INNER JOIN SC_PL_WEEK WEEK ON TK.ID_SCPLWEEK = WEEK.ID_SCPLWEEK ");
		sb.append("INNER JOIN SC_SRV SRV ON TK.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("WHERE WEEK.ID_SCPL = ? ");
		sb.append("ORDER BY SRV.CODE ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(scplId);
		return (List<ScPlanWeekTicksDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ScPlanWeekTicksDO.class));
	}
	/**
	 * 处理号位服务
	 * 
	 * @param map
	 * @param list
	 */
	private void proccessTickSrv(Map<String, MtPlWkBriefDTO> map, List<ScPlanWeekTickDO> list){
		if(map == null || ListUtil.isEmpty(list))
			return;
		for(ScPlanWeekTickDO tk_srv : list){
			if(map.containsKey(tk_srv.getId_scplweek())){
				if(ScValidator.isEmptyIgnoreBlank(tk_srv.getName_scsrv()))
					continue;
				MtPlWkBriefDTO week_dto = map.get(tk_srv.getId_scplweek());
				if(ScValidator.isEmptyIgnoreBlank(week_dto.getName_srvs())){
					week_dto.setName_srvs(tk_srv.getName_scsrv());
				}else{
					week_dto.setName_srvs(week_dto.getName_srvs() + "," +tk_srv.getName_scsrv());
				}
			}
		}
	}
	/**
	 * 处理号段服务
	 * 
	 * @param map
	 * @param list
	 */
	private void proccessTicksSrv(Map<String, MtPlWkBriefDTO> map, List<ScPlanWeekTicksDO> list){
		if(map == null || ListUtil.isEmpty(list))
			return;
		for(ScPlanWeekTicksDO tk_srv : list){
			if(map.containsKey(tk_srv.getId_scplweek())){
				if(ScValidator.isEmptyIgnoreBlank(tk_srv.getName_scsrv()))
					continue;
				MtPlWkBriefDTO week_dto = map.get(tk_srv.getId_scplweek());
				if(ScValidator.isEmptyIgnoreBlank(week_dto.getName_srvs())){
					week_dto.setName_srvs(tk_srv.getName_scsrv());
				}else{
					week_dto.setName_srvs(week_dto.getName_srvs() + "," +tk_srv.getName_scsrv());
				}
			}
		}
	}
	
}
