package iih.sc.sch.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取口腔科已有的排班BP
 * 
 * @author zhengcm
 * @date 2016-09-13 14:51:26
 *
 */
public class GetOralSchBP {

	/**
	 * 获取口腔科已有排班
	 *
	 * @param id_dep 当前科室id
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @param name_room 诊间名称（可空，为空查所有）
	 * @return 口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public FArrayList exec(String id_dep, String dt_begin, String dt_end, String name_room)
			throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_dep", id_dep);
		ScValidator.validateParam("dt_begin", dt_begin);
		ScValidator.validateParam("dt_end", dt_end);

		// 2、查询数据
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.id_quesite,");
		sb.append("sch.id_emp_nurse,");
		sb.append("psn.name as name_emp_nurse,");
		sb.append("sch.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("sch.d_sch,");
		sb.append("sch.id_dayslot,");
		sb.append("lot.name as name_dayslot,");
		sb.append("sch.scpolcn,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.quan0_appt,");
		sb.append("sch.quan1_appt,");
		sb.append("sch.quan2_appt,");
		sb.append("sch.quan3_appt,");
		sb.append("sch.quan4_appt,");
		sb.append("sch.quan5_appt,");
		sb.append("sch.quan6_appt,");
		sb.append("sch.quan7_appt,");
		sb.append("sch.quan8_appt,");
		sb.append("sch.quan9_appt,");
		sb.append("sch.quan0_used,");
		sb.append("sch.quan1_used,");
		sb.append("sch.quan2_used,");
		sb.append("sch.quan3_used,");
		sb.append("sch.quan4_used,");
		sb.append("sch.quan5_used,");
		sb.append("sch.quan6_used,");
		sb.append("sch.quan7_used,");
		sb.append("sch.quan8_used,");
		sb.append("sch.quan9_used,");
		sb.append("sch.id_depparam");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on sch.id_scpl = pl.id_scpl ");
		sb.append("left join bd_psndoc psn on psn.id_psndoc = sch.id_emp_nurse ");
		sb.append("left join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		// 诊间不为空就按照诊间过滤
		if (!StringUtil.isEmptyWithTrim(name_room) && !name_room.equals("%")) {
			sb.append("left join bd_que_site site on site.id_quesite = sch.id_quesite and site.name = ? ");
		}
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		sb.append("and sch.d_sch >= ? ");
		sb.append("and sch.d_sch <= ? ");
		
		SqlParam params = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(name_room) && !name_room.equals("%")) {
			params.addParam(name_room);
		}
		params.addParam(id_dep);
		params.addParam(dt_begin);
		params.addParam(dt_end);
		String sqlStr =ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch");
		sb.append("and ");	
		sb.append(sqlStr);
		List<SchOralInfoDTO> datas = (List<SchOralInfoDTO>) new DAFacade().execQuery(sb.toString(),
				params, new BeanListHandler(SchOralInfoDTO.class));

		// 3、查询排班号位和排班渠道条件
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		List<String> schIds = new ArrayList<String>();
		for (SchOralInfoDTO schDTO : datas) {
			String id_sch = schDTO.getId_sch();
			if (!schIds.contains(id_sch)) {
				schIds.add(id_sch);
			}
		}
		String where = ScSqlUtils.getInSqlByIds("id_sch", schIds);

		// 4、查询排班号位数据
		Map<String, List<ScSchTickDO>> schTickMap = this.getSchTickByCond(where);
		// 5、查询排班渠道数据
		Map<String, List<ScSchChlDO>> schChlMap = this.getSchChlByCond(where);

		// 6、处理排班渠道数据
		this.processSchChl(datas, schChlMap);

		// 7、处理排班号位数据
		this.processSchTick(datas, schTickMap);

		FArrayList flist = new FArrayList();
		flist.addAll(datas);

		return flist;
	}

	/**
	 * 根据条件获取排班号位
	 *
	 * @param where 查询条件
	 * @return 排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<ScSchTickDO>> getSchTickByCond(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		ScSchTickDO[] schTickDOs = new OralSchEP().getSchTickByCond(where, "queno", null);
		if (ArrayUtil.isEmpty(schTickDOs)) {
			return null;
		}
		Map<String, List<ScSchTickDO>> schTickMap = new HashMap<String, List<ScSchTickDO>>();
		for (ScSchTickDO tickDO : schTickDOs) {
			if (schTickMap.containsKey(tickDO.getId_sch())) {
				schTickMap.get(tickDO.getId_sch()).add(tickDO);
			} else {
				List<ScSchTickDO> temp = new ArrayList<ScSchTickDO>();
				temp.add(tickDO);
				schTickMap.put(tickDO.getId_sch(), temp);
			}
		}
		return schTickMap;
	}

	/**
	 * 根据条件获取排班渠道
	 *
	 * @param where 查询条件
	 * @return 排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<ScSchChlDO>> getSchChlByCond(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		ScSchChlDO[] schChlDOs = new OralSchEP().getSchChlByCond(where, "scpolcn");
		if (ArrayUtil.isEmpty(schChlDOs)) {
			return null;
		}
		Map<String, List<ScSchChlDO>> schChlMap = new HashMap<String, List<ScSchChlDO>>();
		for (ScSchChlDO chlDO : schChlDOs) {
			if (schChlMap.containsKey(chlDO.getId_sch())) {
				schChlMap.get(chlDO.getId_sch()).add(chlDO);
			} else {
				List<ScSchChlDO> temp = new ArrayList<ScSchChlDO>();
				temp.add(chlDO);
				schChlMap.put(chlDO.getId_sch(), temp);
			}
		}
		return schChlMap;
	}

	/**
	 * 处理排班号位数据
	 *
	 * @param schDTOList 口腔科排班信息DTO列表
	 * @param schTickMap 排班号位Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processSchTick(List<SchOralInfoDTO> schDTOList,
			Map<String, List<ScSchTickDO>> schTickMap) throws BizException {
		if (ListUtil.isEmpty(schDTOList) || null == schTickMap || schTickMap.isEmpty()) {
			return;
		}
		for (SchOralInfoDTO schDTO : schDTOList) {
			List<ScSchTickDO> schTickDOs = schTickMap.get(schDTO.getId_sch());
			if (!ListUtil.isEmpty(schTickDOs)) {
				FArrayList schTickFArray = new FArrayList();
				schTickFArray.addAll(schTickDOs);
				schDTO.setSch_tick_list(schTickFArray);
			}
		}
	}

	/**
	 * 处理排班渠道数据
	 *
	 * @param schDTOList 口腔科排班信息DTO列表
	 * @param schChlkMap 排班渠道Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processSchChl(List<SchOralInfoDTO> schDTOList,
			Map<String, List<ScSchChlDO>> schChlkMap) throws BizException {
		if (ListUtil.isEmpty(schDTOList) || null == schChlkMap || schChlkMap.isEmpty()) {
			return;
		}
		for (SchOralInfoDTO schDTO : schDTOList) {
			List<ScSchChlDO> schChlDOs = schChlkMap.get(schDTO.getId_sch());
			if (!ListUtil.isEmpty(schChlDOs)) {
				FArrayList schChlFArray = new FArrayList();
				schChlFArray.addAll(schChlDOs);
				schDTO.setSch_chl_list(schChlFArray);
			}
		}
	}

}
