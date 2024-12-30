package iih.sc.apt.s.bp.oral;

import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者口腔预约BP
 * 
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 * @date 2016-09-27 19:19:25
 *
 */
public class GetOralPatAptBP {

	/**
	 * 获取患者口腔预约
	 *
	 * @param patId 患者id
	 * @return 患者口腔科预约信息DTO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptOralDTO[] exec(String patId) throws BizException {
		// 检查参数
		ScValidator.validateParam("patId", patId);

		// 查询数据
		List<AptOralDTO> oralAptDTOList = this.queryDatas(patId);
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return null;
		}

		// 所有号位ID
		List<String> tickIdList = new ArrayList<String>();

		// 取出排班号位主键和记录预约数据
		this.processAptDTO(oralAptDTOList, tickIdList);

		// 获取所有号位的占用情况
		Map<String, ScSchTickDO[]> tickOccupiedMap = this.getBatchTickOccupied(tickIdList);

		// 设置号位的占用情况
		this.setTickOccupiedData(oralAptDTOList, tickOccupiedMap);

		// 处理患者的不良行为信息
		new OralAptPatBbrProccessBP().exec(oralAptDTOList);

		// 设置排班版本
		new SetOralAptSchVersionBP().exec(oralAptDTOList);

		return oralAptDTOList.toArray(new AptOralDTO[0]);
	}

	/**
	 * 查询数据
	 *
	 * @param patId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<AptOralDTO> queryDatas(String patId) throws BizException {
		// 拼装SQL
		StringBuilder sqlBuilder = this.getSql();
		// SQL参数
		SqlParam params = new SqlParam();
		params.addParam(patId);
		// 查询数据
		List<AptOralDTO> oralAptDTOList = (List<AptOralDTO>) new DAFacade().execQuery(sqlBuilder.toString(), params,
				new BeanListHandler(AptOralDTO.class));
		return oralAptDTOList;
	}

	/**
	 * 拼接查询SQL
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("apt.id_apt,");
		sb.append("apt.id_pat,");
		sb.append("apt.sd_status,");
		sb.append("apt.id_scsrv,");
		sb.append("srv.name as name_scsrv,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_scpl,");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("sch.id_dayslot,");
		sb.append("lot.code as code_dayslot,");
		sb.append("site.name as name_quesite,");
		sb.append("site.room,");
		sb.append("oral.posi_teeth,");
		sb.append("oral.id_proc_oral,");
		sb.append("oral.sd_proc_oral,");
		sb.append("oral.dt_lastmdf,");
		sb.append("oral.id_emp_lastmdf,");
		sb.append("psn.name as name_emp_lastmdf,");
		sb.append("case when (oral.id_proc_oral is null or oral.id_proc_oral = '~') then oral.name_proc_oral else doc.name end as name_proc_oral,");
		sb.append("tick.queno,");
		sb.append("tick.id_tick,");
		sb.append("tick.eu_used as eu_used_tick,");
		sb.append("tick.t_b as t_b_tick,");
		sb.append("tick.sd_reserve_rsn,");
		sb.append("tick.note_reserve,");
		sb.append("tick.fg_active as fg_active_tick,");
		sb.append("tick.id_tick_occupier,");
		sb.append("oral.d_next_appt,");
		sb.append("oral.note_next,");
		sb.append("oral.note,");
		sb.append("oral.svrslot,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.tel as tel_pat,");
		sb.append("oral.id_statustag,");
		sb.append("oral.sd_statustag,");
		sb.append("sta.name as name_statustag ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_tick tick on tick.id_tick = apt.id_tick ");
		sb.append("inner join sc_sch sch on sch.id_sch = tick.id_sch ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join bd_que_site site on site.id_quesite = sch.id_quesite ");
		sb.append("inner join sc_apt_op_oral oral on oral.id_apt = apt.id_apt ");
		sb.append("inner join sc_srv srv on srv.id_scsrv = apt.id_scsrv ");
		sb.append("left join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("left join bd_udidoc doc on doc.id_udidoc = oral.id_proc_oral ");
		sb.append("left join bd_udidoc sta on sta.id_udidoc = oral.id_statustag ");
		sb.append("left join bd_psndoc psn on psn.id_psndoc = oral.id_emp_lastmdf ");
		sb.append("where ");
		sb.append("apt.id_pat = ? and apt.fg_canc = 'N' ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		sb.append("order by sch.d_sch desc ");// zhengcm 2017-03-14 排序
		return sb;
	}

	/**
	 * 处理查询到的号位数据：获取号位ID
	 *
	 * @param oralAptDTOList
	 * @param tickIdList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processAptDTO(List<AptOralDTO> oralAptDTOList, List<String> tickIdList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return;
		}
		for (AptOralDTO aptOralDTO : oralAptDTOList) {
			tickIdList.add(aptOralDTO.getId_tick());
		}
	}

	/**
	 * 批量获取号位占用情况
	 *
	 * @param tickIdList
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, ScSchTickDO[]> getBatchTickOccupied(List<String> tickIdList) throws BizException {
		if (ListUtil.isEmpty(tickIdList)) {
			return null;
		}
		// 排班对外查询服务
		IScSchOutQryService qryService = ServiceFinder.find(IScSchOutQryService.class);
		return qryService.batchGetOccupiedTickList(tickIdList.toArray(new String[0]));
	}

	/**
	 * 设置号位占用情况数据
	 *
	 * @param oralAptDTOList
	 * @param tickOccupiedMap
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void setTickOccupiedData(List<AptOralDTO> oralAptDTOList, Map<String, ScSchTickDO[]> tickOccupiedMap)
			throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList) || null == tickOccupiedMap || tickOccupiedMap.isEmpty()) {
			return;
		}
		for (AptOralDTO aptDTO : oralAptDTOList) {
			if (null == aptDTO.getTickarray()) {
				aptDTO.setTickarray(new FArrayList());
			}
			aptDTO.getTickarray().add(aptDTO.getId_tick());
			String key = aptDTO.getId_tick();
			if (!tickOccupiedMap.containsKey(key)) {
				continue;
			}
			ScSchTickDO[] tickDOs = tickOccupiedMap.get(key);
			if (ArrayUtil.isEmpty(tickDOs)) {
				continue;
			}
			for (ScSchTickDO tickDO : tickDOs) {
				aptDTO.getTickarray().add(tickDO.getId_tick());
			}
		}
	}
}
