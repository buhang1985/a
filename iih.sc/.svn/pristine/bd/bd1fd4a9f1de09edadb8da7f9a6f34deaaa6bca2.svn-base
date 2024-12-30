package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 更新口腔科排班BP
 * 
 * @author zhengcm
 * @date 2016-09-18 10:42:32
 *
 */
public class UpdateOralSchBP {

	/**
	 * 更新口腔科排班
	 *
	 * @param schDTOList
	 *            口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(List<SchOralInfoDTO> schDTOList) throws BizException {
		if (ListUtil.isEmpty(schDTOList)) {
			return;
		}
		// 排班主键列表
		List<String> schIds = new ArrayList<String>();
		// 需要更新的排班数据
		List<ScSchDO> schDOList = new ArrayList<ScSchDO>();
		// 需要更新的排班渠道数据
		List<ScSchChlDO> schChlDOList = new ArrayList<ScSchChlDO>();
		// 需要更新的排班号位数据
		List<ScSchTickDO> schTickDOList = new ArrayList<ScSchTickDO>();
		// 排班Map
		Map<String, ScSchDO> schMap = new HashMap<String, ScSchDO>();

		// 1、获取排班主键
		schIds = this.getSchIds(schDTOList);

		// 2、查询排班信息
		schMap = this.getSchDO(schIds);

		// 3、处理更新排班数据
		this.processUpdateSchData(schDTOList, schMap, schDOList, schChlDOList, schTickDOList);

		// 4、数据检查
		this.checkOralSchDatas(schChlDOList);

		// 5、更新排班
		this.updateSch(schDOList);

		// 6、更新排班渠道
		this.updateSchChl(schChlDOList);

		// 7、更新排班号位
		this.updateSchTick(schTickDOList);
	}

	/**
	 * 获取排班主键列表
	 *
	 * @param schDTOList
	 *            口腔科排班信息DTO列表
	 * @return 排班主键列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getSchIds(List<SchOralInfoDTO> schDTOList) throws BizException {
		List<String> schIds = new ArrayList<String>();
		for (SchOralInfoDTO schDTO : schDTOList) {
			schIds.add(schDTO.getId_sch());
		}
		return schIds;
	}

	/**
	 * 获取排班
	 *
	 * @param schIds
	 *            排班主键列表
	 * @return 排班DO的Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, ScSchDO> getSchDO(List<String> schIds) throws BizException {
		if (ListUtil.isEmpty(schIds)) {
			return null;
		}
		String where = "id_sch in (" + ScSqlUtils.buildIdStr(schIds) + ")";
		ScSchDO[] schDOs = new OralSchEP().getSchByCond(where, null);
		if (ArrayUtil.isEmpty(schDOs)) {
			return null;
		}
		Map<String, ScSchDO> map = new HashMap<String, ScSchDO>();
		for (ScSchDO schDO : schDOs) {
			map.put(schDO.getId_sch(), schDO);
		}
		return map;
	}

	/**
	 * 处理需要更新的排班数据
	 *
	 * @param schDTOList
	 *            口腔科排班信息DTO列表
	 * @param schMap
	 *            排班Map
	 * @param schDOList排班DO列表
	 * @param schChlDOList
	 *            排班渠道DO列表
	 * @param schTickDOList
	 *            排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processUpdateSchData(List<SchOralInfoDTO> schDTOList, Map<String, ScSchDO> schMap,
			List<ScSchDO> schDOList, List<ScSchChlDO> schChlDOList, List<ScSchTickDO> schTickDOList)
			throws BizException {
		for (SchOralInfoDTO schDTO : schDTOList) {
			ScSchDO schDO = schMap.get(schDTO.getId_sch());
			// 处理排班数据
			this.processSch(schDO, schDTO);

			// 取到排班渠道和排班号位
			ScSchChlDO[] schChlDOs = null;
			ScSchTickDO[] schTickDOs = null;
			if (null != schDTO.getSch_chl_list() && schDTO.getSch_chl_list().size() > 0) {
				FArrayList flist = schDTO.getSch_chl_list();
				schChlDOs = (ScSchChlDO[]) flist.toArray(new ScSchChlDO[] {});
			}
			if (null != schDTO.getSch_tick_list() && schDTO.getSch_tick_list().size() > 0) {
				FArrayList flist = schDTO.getSch_tick_list();
				schTickDOs = (ScSchTickDO[]) flist.toArray(new ScSchTickDO[] {});
			}

			// 处理排班渠道数据
			this.processSchChl(schDO, schChlDOs, schChlDOList);
			// 处理排班号位数据
			this.processSchTick(schTickDOs, schTickDOList);
			schDOList.add(schDO);
		}
	}

	/**
	 * 处理更新排班数据
	 *
	 * @param schDO
	 *            排班DO
	 * @param schDTO
	 *            口腔科排班信息DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processSch(ScSchDO schDO, SchOralInfoDTO schDTO) throws BizException {
		if (null == schDO || null == schDTO) {
			return;
		}
		schDO.setStatus(DOStatus.UPDATED);
		schDO.setId_quesite(schDTO.getId_quesite());
		schDO.setId_dayslot(schDTO.getId_dayslot());
		schDO.setId_emp_nurse(schDTO.getId_emp_nurse());
		schDO.setId_scpl(schDTO.getId_scpl());
		schDO.setScpolcn(schDTO.getScpolcn());
		schDO.setQuan_total(schDTO.getQuan_total() == null ? 0 : schDTO.getQuan_total());
		schDO.setQuan_total_appt(schDTO.getQuan_total() == null ? 0 : schDTO.getQuan_total());
		schDO.setQuan0_appt(schDTO.getQuan0_appt() == null ? 0 : schDTO.getQuan0_appt());
		schDO.setQuan1_appt(schDTO.getQuan1_appt() == null ? 0 : schDTO.getQuan1_appt());
		schDO.setQuan2_appt(schDTO.getQuan2_appt() == null ? 0 : schDTO.getQuan2_appt());
		schDO.setQuan3_appt(schDTO.getQuan3_appt() == null ? 0 : schDTO.getQuan3_appt());
		schDO.setQuan4_appt(schDTO.getQuan4_appt() == null ? 0 : schDTO.getQuan4_appt());
		schDO.setQuan5_appt(schDTO.getQuan5_appt() == null ? 0 : schDTO.getQuan5_appt());
		schDO.setQuan6_appt(schDTO.getQuan6_appt() == null ? 0 : schDTO.getQuan6_appt());
		schDO.setQuan7_appt(schDTO.getQuan7_appt() == null ? 0 : schDTO.getQuan7_appt());
		schDO.setQuan8_appt(schDTO.getQuan8_appt() == null ? 0 : schDTO.getQuan8_appt());
		schDO.setQuan9_appt(schDTO.getQuan9_appt() == null ? 0 : schDTO.getQuan9_appt());
		schDO.setQuan_total_appt(schDO.getQuan_total());
		schDO.setMax_num_add(schDTO.getMax_num_add() == null ? 0 : schDTO.getMax_num_add());
		if (schDTO.getFg_active() != null)
			schDO.setFg_active(schDTO.getFg_active());
	}

	/**
	 * 处理更新的排班渠道
	 *
	 * @param schDO
	 *            排班DO
	 * @param schChlDOs
	 *            排班渠道DO数组
	 * @param schChlDOList
	 *            排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processSchChl(ScSchDO schDO, ScSchChlDO[] schChlDOs, List<ScSchChlDO> schChlDOList)
			throws BizException {
		if (ArrayUtil.isEmpty(schChlDOs)) {
			return;
		}
		for (ScSchChlDO chlDO : schChlDOs) {
			if (chlDO.getStatus() == DOStatus.UPDATED || chlDO.getStatus() == DOStatus.NEW) {
				chlDO.setId_sch(schDO.getId_sch());
				chlDO.setId_grp(ScContextUtils.getGrpId());
				chlDO.setId_org(ScContextUtils.getOrgId());
				schChlDOList.add(chlDO);
			} else if (chlDO.getStatus() == DOStatus.DELETED) {
				schChlDOList.add(chlDO);
			}
		}
	}

	/**
	 * 处理更新的排班号位
	 *
	 * @param schTickDOs
	 *            排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processSchTick(ScSchTickDO[] schTickDOs, List<ScSchTickDO> schTickDOList) throws BizException {
		if (ArrayUtil.isEmpty(schTickDOs)) {
			return;
		}
		for (ScSchTickDO tickDO : schTickDOs) {
			if (tickDO.getStatus() == DOStatus.UPDATED) {
				tickDO.setEu_add(EuAddTickMod.ZCH);// 设置为正常号
				tickDO.setId_grp(ScContextUtils.getGrpId());
				tickDO.setId_org(ScContextUtils.getOrgId());
				schTickDOList.add(tickDO);
			}
		}
	}

	/**
	 * 更新排班
	 *
	 * @param schDOList
	 *            排班DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSch(List<ScSchDO> schDOList) throws BizException {
		if (ListUtil.isEmpty(schDOList)) {
			return;
		}
		new OralSchEP().updateSch(schDOList.toArray(new ScSchDO[] {}));
	}

	/**
	 * 更新排班渠道
	 *
	 * @param schChlDOList
	 *            排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchChl(List<ScSchChlDO> schChlDOList) throws BizException {
		if (ListUtil.isEmpty(schChlDOList)) {
			return;
		}
		new OralSchEP().saveSchChl(schChlDOList.toArray(new ScSchChlDO[] {}));
	}

	/**
	 * 更新排班号位
	 *
	 * @param schTickDOList
	 *            排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchTick(List<ScSchTickDO> schTickDOList) throws BizException {
		if (ListUtil.isEmpty(schTickDOList)) {
			return;
		}
		new OralSchEP().updateSchTick(schTickDOList.toArray(new ScSchTickDO[] {}));
	}

	/**
	 * 排班数据检查
	 *
	 * @param schChlDOList
	 *            排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void checkOralSchDatas(List<ScSchChlDO> schChlDOList) throws BizException {
		if (ListUtil.isEmpty(schChlDOList)) {
			return;
		}
		for (ScSchChlDO chlDO : schChlDOList) {
			if (StringUtil.isEmptyWithTrim(chlDO.getId_scchl()) || null == chlDO.getScpolcn()) {
				throw new BizException(IScMsgConst.SC_SCH_CHL_EXIST_EMPTY);// 排班渠道数据存在号源池可预约数或渠道为空，请检查！
			}
		}
	}
}
