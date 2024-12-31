package iih.bd.fc.task;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.d.BdEnStateDepDO;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.bd.fc.enstate.i.IEnstatedepCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 科室就诊状态生成任务</br>
 * 当科室类型为临床或护理单元的科室在科室就诊状况表bd_en_state_dep中不存在数据时，给该科室预置6个就诊状况（特级护理、一级护理、二级护理、入院、出院、手术）
 * 
 * @author hao_wu 2018-8-8
 *
 */
public class DeptEnStateGenerateTask implements IBackgroundWorkPlugin {

	private String ContextKey_EnStateIds = "EnStateIds";
	private String ContextKey_UserId = "UserId";

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException {

		initContext(bgwc);

		String[] enStateIds = getEnStateIds(bgwc);

		BdEnStateDO[] enStateDos = findEnStatesByIds(enStateIds);

		DeptDO[] detps = findDepts();

		generateDeptEnState(enStateDos, detps);

		return new PreAlertObject();
	}

	/**
	 * 初始化上下文
	 * 
	 * @param bgwc
	 * @throws BizException
	 */
	private void initContext(BgWorkingContext bgwc) throws BizException {
		if (!bgwc.getKeyMap().containsKey(ContextKey_UserId)) {
			throwParamNullException(this.ContextKey_UserId);
		}

		String userId = (String) bgwc.getKeyMap().get(this.ContextKey_UserId);

		IUserRService userRService = ServiceFinder.find(IUserRService.class);
		UserDO userDO = userRService.findById(userId);
		if (userDO == null) {
			throw new BizException("根据用户主键\"%s\"未查询到用户信息。");
		}

		Context.get().setGroupId(userDO.getId_group());
		Context.get().setOrgId(userDO.getId_org());
		Context.get().setUserId(userDO.getId_user());
		Context.get().setStuffId(userDO.getId_psn());
	}

	/**
	 * 生成科室就诊状态
	 * 
	 * @param enStateDos
	 * @param detps
	 * @throws BizException
	 */
	private void generateDeptEnState(BdEnStateDO[] enStateDos, DeptDO[] detps) throws BizException {

		ArrayList<BdEnStateDepDO> stateDepList = new ArrayList<BdEnStateDepDO>();
		for (DeptDO deptDO : detps) {
			for (int i = 0; i < enStateDos.length; i++) {
				BdEnStateDO enStateDo = enStateDos[i];
				BdEnStateDepDO enStateDepDO = generateDeptEnState(deptDO, enStateDo, i + 1);
				stateDepList.add(enStateDepDO);
			}
		}

		IEnstatedepCudService enstatedepCudService = ServiceFinder.find(IEnstatedepCudService.class);
		enstatedepCudService.insert(stateDepList.toArray(new BdEnStateDepDO[0]));
	}

	/**
	 * 生成科室就诊状态
	 * 
	 * @param deptDO
	 * @param enStateDo
	 * @param sortNo
	 * @return
	 */
	private BdEnStateDepDO generateDeptEnState(DeptDO deptDO, BdEnStateDO enStateDo, Integer sortNo) {
		BdEnStateDepDO enStateDepDO = new BdEnStateDepDO();
		enStateDepDO.setId_grp(Context.get().getGroupId());
		enStateDepDO.setId_org(Context.get().getOrgId());
		enStateDepDO.setId_dep(deptDO.getId_dep());
		enStateDepDO.setSortno(sortNo);
		enStateDepDO.setId_enstate(enStateDo.getId_enstate());
		enStateDepDO.setId_enstatetp(enStateDo.getId_enstatetp());
		enStateDepDO.setSd_enstatetp(enStateDo.getSd_enstatetp());
		enStateDepDO.setVal(enStateDo.getVal());
		enStateDepDO.setLabel(enStateDo.getName());
		enStateDepDO.setFg_showicon(FBoolean.TRUE);
		return enStateDepDO;
	}

	/**
	 * 查询科室信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private DeptDO[] findDepts() throws BizException {
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		String wherePart = String.format(
				"Activestate = '%s' and (sd_depttp like '%s%%' or sd_depttp like '%s%%') and id_dep not in (select id_dep from bd_en_state_dep)",
				ActiveStateEnum.ACTIVE, ISysDictCodeConst.SD_DEPTTP_CLINIC, ISysDictCodeConst.SD_DEPTTP_NURSE);
		DeptDO[] detps = deptRService.find(wherePart, "", FBoolean.FALSE);
		return detps;
	}

	/**
	 * 根据就诊状态主键查询就诊状态列表
	 * 
	 * @param enStateIds
	 * @return
	 * @throws BizException
	 */
	private BdEnStateDO[] findEnStatesByIds(String[] enStateIds) throws BizException {
		IEnstateRService enstateRService = ServiceFinder.find(IEnstateRService.class);
		String wherePart = String.format("fg_active = 'Y' and (%s)", SqlUtils.getInSqlByIds("Id_enstate", enStateIds));
		BdEnStateDO[] enStateDos = enstateRService.find(wherePart, "", FBoolean.FALSE);
		if (enStateDos == null || enStateDos.length <= 0) {
			throw new BizException("根据就诊状态主键集合未查询到就诊状态信息。");
		}
		return enStateDos;
	}

	/**
	 * 获取就诊状态主键集合
	 * 
	 * @param bgwc
	 * @return
	 * @throws BizException
	 */
	private String[] getEnStateIds(BgWorkingContext bgwc) throws BizException {
		if (!bgwc.getKeyMap().containsKey(ContextKey_EnStateIds)) {
			throwParamNullException(this.ContextKey_EnStateIds);
		}

		String enStateIdStr = (String) bgwc.getKeyMap().get(this.ContextKey_EnStateIds);
		if (StringUtils.isEmpty(enStateIdStr)) {
			throwParamNullException(this.ContextKey_EnStateIds);
		}

		String[] enStateIds = enStateIdStr.split(",");
		if (enStateIds == null || enStateIds.length <= 0) {
			throwParamNullException(this.ContextKey_EnStateIds);
		}
		return enStateIds;
	}

	/**
	 * 抛出参数空异常
	 * 
	 * @param paramName
	 * @throws BizException
	 */
	private void throwParamNullException(String paramName) throws BizException {
		String msg = String.format("参数%s不允许为空。", paramName);
		throw new BizException(msg);
	}
}
