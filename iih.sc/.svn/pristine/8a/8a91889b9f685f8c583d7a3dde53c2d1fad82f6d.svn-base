package iih.sc.sch.s.ep.mt.apt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.comm.SchPkLockUtil;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScSrvKindItmRService;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.reg.refs.Res4RegRefModel;
import iih.sc.sch.s.bp.mt.apt.ep.ScSrvKindEP;
import iih.sc.sch.s.bp.mt.apt.filter.ScAptKinditmFilter;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.i.IScSchEnDORService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 渠道号位EP
 * 
 * @author zhengcm
 * @date 2017-07-27 10:31:19
 *
 */
public class TickChl4MtAptEP {

	/**
	 * 对当前排班加锁
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @throws BizException
	 */
	public void lockSch(String schId) throws BizException {
		if (StringUtil.isEmptyWithTrim(schId)) {
			return;
		}
		SchPkLockUtil.lock(schId);
	}

	/**
	 * 根据排班ID获取票号模式
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @return 票号模式编码
	 * @throws BizException
	 */
	public String getTickModeBySchId(String schId) throws BizException {
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(schId);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);// 排班不存在
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			throw new BizException(IScMsgConst.SC_SCH_CLOSE);// 停诊不能挂号
		}
		return schDO.getSd_tickmd();
	}
	
	/**
	 * 根据排班ID获取票号模式
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @return 票号模式编码
	 * @throws BizException
	 */
	public String getTickModeBySchId4Auto(String schId) throws BizException {
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(schId);
		if (schDO == null) {
			return null;
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			return null;
		}
		return schDO.getSd_tickmd();
	}
	/**
	 * 根据渠道获取排班可用最小号位
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickBySchId(String schId, List<Integer> polcnList, String scchlId) throws BizException{
		String tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
				schId);
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			throw new BizException("排班号源已用尽，请刷新后重试!");
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcnList);
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		return filterDOs[0];
	}
	/**
	 * 根据号段获取排班可用最小号位
	 * 
	 * @param ticksId 号段id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickByTicksId(String ticksId, List<Integer> polcnList, String scchlId) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null,null), EuUseState.WY, EuUseScope.APT,
				ticksId);
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			throw new BizException("排班号源已用尽，请刷新后重试!");
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcnList);
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		return filterDOs[0];
	}
	/**
	 * 根据渠道获取排班可用最小号位
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickBySchId(String schId, Map<Integer,Integer> polcnMap, String scchlId,MtResDTO resDTO,String idEnttp,String idSrv) throws BizException{
		// 获取票号模式
		String tickMd = this.getTickModeBySchId(schId);
		String tickCond = null;
		// 号段模式
		List<ScSchTicksDO> ticksList = new ArrayList<ScSchTicksDO>(); 
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			// 查询当前排班所有号段
			String cond = String.format("id_sch = '%s'", schId);
			ScSchTicksDO[] ticksDOs = this.getSchTicksByWhere(cond, "t_b");
			//校验实际时间点
			if(!IScDictCodeConst.SC_CHOICE_APT.equals(resDTO.getSc_oper_src())){// 选号预约
				ticksDOs = this.checkNowTime(ticksDOs);
			}
			if (ArrayUtil.isEmpty(ticksDOs)) {
				throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
			}
			List<String> ticksIdList = new ArrayList<String>();
			for (ScSchTicksDO ticks : ticksDOs) {
				ticksIdList.add(ticks.getId_ticks());
				ticksList.add(ticks);//先加入所有号段数据
			}
			tickCond = String.format(this.getTickQueryWherePart(schId, null, null,ticksIdList), EuUseState.WY, EuUseScope.APT,
					schId);
		}else{
			tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
					schId);
		}
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			throw new BizException("排班号源已用尽，请刷新后重试!");
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcnMap, resDTO);
		if (ArrayUtil.isEmpty(filterDOs)) {
			if(resDTO.getFg_stop_daysmsgs().booleanValue()){
				return null;
			}else{
				throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
			}
		}
		
		if(schDO.getFg_setentp() != null && schDO.getFg_setentp().booleanValue() && !StringUtil.isEmptyWithTrim(idEnttp)){
			// 按类型过滤
			filterDOs = this.filterTickByEntp(schId, idEnttp, filterDOs);
		}
		// 按照排班类别细目过滤
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			filterDOs = this.filterTicksItmsRelese(filterDOs,ticksList,resDTO,idSrv,schId);
		}else{
			filterDOs = new ScAptKinditmFilter().filterTickByScSrvKinditm4Manual(filterDOs, idSrv, schDO.getId_sch(),resDTO);
		}
		if(ArrayUtil.isEmpty(filterDOs)){
			throw new BizException(IScMsgConst.ERROR_SC_SCH_TICK_KINDITM);
		}
		Integer polcnNum = this.getMinPolcn(polcnMap);
		ScSchTickDO tick = this.getMinPolcnTick(filterDOs, polcnNum);
		if (tick == null) {
			return filterDOs[0];
		}
		return tick;
	}
	
	/**
	 * 根据渠道获取排班可用最小号位
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickBySchId4Auto(String schId, Map<Integer,Integer> polcnMap, String scchlId,MtResDTO resDTO,String idEnttp,String idSrv) throws BizException{
		// 获取票号模式
		String tickMd = this.getTickModeBySchId4Auto(schId);
		if (StringUtil.isEmpty(tickMd)) {
			return null;
		}
		String tickCond = null;
		// 号段模式
		List<ScSchTicksDO> ticksList = new ArrayList<ScSchTicksDO>(); 
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			// 查询当前排班所有号段
			String cond = String.format("id_sch = '%s'", schId);
			ScSchTicksDO[] ticksDOs = this.getSchTicksByWhere(cond, "t_b");
			//校验实际时间点
			ticksDOs = this.checkNowTime(ticksDOs);
			if (ArrayUtil.isEmpty(ticksDOs)) {
				return null;
			}
			List<String> ticksIdList = new ArrayList<String>();
			for (ScSchTicksDO ticks : ticksDOs) {
				ticksIdList.add(ticks.getId_ticks());
				ticksList.add(ticks);//先加入所有号段数据
			}
			tickCond = String.format(this.getTickQueryWherePart(schId, null, null,ticksIdList), EuUseState.WY, EuUseScope.APT,
					schId);
		}else{
			tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
					schId);
		}
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			return null;
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl4Auto(tickDOs, schDO, scchlId, polcnMap, resDTO);
		if (ArrayUtil.isEmpty(filterDOs)) {
			return null;
		}
		
		if(schDO.getFg_setentp() != null && schDO.getFg_setentp().booleanValue() && !StringUtil.isEmptyWithTrim(idEnttp)){
			// 按类型过滤
			filterDOs = this.filterTickByEntp(schId, idEnttp, filterDOs);
		}
		// 按照排班类别细目过滤
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			filterDOs = this.filterTicksItmsRelese4Auto(filterDOs,ticksList,resDTO,idSrv,schId);
		}else{
			filterDOs = new ScAptKinditmFilter().filterTickByScSrvKinditm4Manual(filterDOs, idSrv, schDO.getId_sch(),resDTO);
		}
		if(ArrayUtil.isEmpty(filterDOs)){
			return null;
		}
		Integer polcnNum = this.getMinPolcn(polcnMap);
		if(polcnNum == IScDictCodeConst.SC_CHL_REMAIN) return null;
		ScSchTickDO tick = this.getMinPolcnTick(filterDOs, polcnNum);
		if (tick == null) {
			return filterDOs[0];
		}
		return tick;
	}
	/**
	 * 号段不选号预约  过滤类别明细
	 * @return
	 * @throws BizException 
	 */
	private ScSchTickDO[] filterTicksItmsRelese(ScSchTickDO[] filterDOs,List<ScSchTicksDO> ticksList,MtResDTO resDTO,String idSrv,String schId) throws BizException
	{
		if(resDTO.getFg_stop_daysmsgs().booleanValue()){
			return null;
		}else{
			List<ScSchTicksDO> ticksExisTickList = new ArrayList<ScSchTicksDO>(); 
			//计算过滤渠道后的号段信息,进行类别明细校验
			for (ScSchTicksDO ticksDO : ticksList) {
				for (ScSchTickDO tickDO : filterDOs) {
					if(ticksDO.getId_ticks().equals(tickDO.getId_ticks())){
						ticksExisTickList.add(ticksDO);
						break;
					}
				}
			}
			//校验类别明细
			List<String> ticksIdList = new ScAptKinditmFilter().filterTicksByScSrvKinditm4Manuals(ticksExisTickList.toArray(new ScSchTicksDO[0]), idSrv, schId,resDTO);
			if(ticksIdList == null){
				throw new BizException(IScMsgConst.ERROR_SC_SCH_TICKS_KINDITM);
			}else{
				List<ScSchTickDO> ticksDOList = new ArrayList<ScSchTickDO>();
				for (ScSchTickDO tickDO : filterDOs) {
					if(ticksIdList.contains(tickDO.getId_ticks())){
						ticksDOList.add(tickDO);
					}
				}
				filterDOs = ticksDOList.toArray(new ScSchTickDO[0]);
			}
		}
		return filterDOs;
	}
	/**
	 * 号段不选号预约  过滤类别明细
	 * @return
	 * @throws BizException 
	 */
	private ScSchTickDO[] filterTicksItmsRelese(ScSchTickDO[] filterDOs,MtResDTO resDTO,String idSrv,String schId) throws BizException
	{
		if(resDTO.getFg_stop_daysmsgs().booleanValue()){
			return null;
		}else{
			List<ScSchTicksDO> ticksExisTickList = new ArrayList<ScSchTicksDO>(); 
			// 查询当前排班所有号段
			String cond = String.format("id_sch = '%s'", schId);
			ScSchTicksDO[] ticksDOs = this.getSchTicksByWhere(cond, "t_b");
			//计算过滤渠道后的号段信息,进行类别明细校验
			for (ScSchTicksDO ticksDO : ticksDOs) {
				for (ScSchTickDO tickDO : filterDOs) {
					if(ticksDO.getId_ticks().equals(tickDO.getId_ticks())){
						ticksExisTickList.add(ticksDO);
						break;
					}
				}
			}
			//校验类别明细
			List<String> ticksIdList = new ScAptKinditmFilter().filterTicksByScSrvKinditm4Manuals(ticksExisTickList.toArray(new ScSchTicksDO[0]), idSrv, schId,resDTO);
			if(ticksIdList == null){
				throw new BizException(IScMsgConst.ERROR_SC_SCH_TICKS_KINDITM);
			}else{
				List<ScSchTickDO> ticksDOList = new ArrayList<ScSchTickDO>();
				for (ScSchTickDO tickDO : filterDOs) {
					if(ticksIdList.contains(tickDO.getId_ticks())){
						ticksDOList.add(tickDO);
					}
				}
				filterDOs = ticksDOList.toArray(new ScSchTickDO[0]);
			}
		}
		return filterDOs;
	}
	/**
	 * 号段不选号预约  过滤类别明细
	 * @return
	 * @throws BizException 
	 */
	private ScSchTickDO[] filterTicksItmsRelese4Auto(ScSchTickDO[] filterDOs,List<ScSchTicksDO> ticksList,MtResDTO resDTO,String idSrv,String schId) throws BizException
	{
		if(resDTO.getFg_stop_daysmsgs().booleanValue()){
			return null;
		}else{
			List<ScSchTicksDO> ticksExisTickList = new ArrayList<ScSchTicksDO>(); 
			//计算过滤渠道后的号段信息,进行类别明细校验
			for (ScSchTicksDO ticksDO : ticksList) {
				for (ScSchTickDO tickDO : filterDOs) {
					if(ticksDO.getId_ticks().equals(tickDO.getId_ticks())){
						ticksExisTickList.add(ticksDO);
						break;
					}
				}
			}
			//校验类别明细
			List<String> ticksIdList = new ScAptKinditmFilter().filterTicksByScSrvKinditm4Manuals(ticksExisTickList.toArray(new ScSchTicksDO[0]), idSrv, schId,resDTO);
			if(ticksIdList == null){
				return null;
			}else{
				List<ScSchTickDO> ticksDOList = new ArrayList<ScSchTickDO>();
				for (ScSchTickDO tickDO : filterDOs) {
					if(ticksIdList.contains(tickDO.getId_ticks())){
						ticksDOList.add(tickDO);
					}
				}
				filterDOs = ticksDOList.toArray(new ScSchTickDO[0]);
			}
		}
		return filterDOs;
	}
	/**
	 * 排班类别明细过滤 号段模式下过滤号段的排班服务类别明细
	 * @author yzh
	 * @param filterDOs
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO[] filterTicksByScSrvKinditm(ScSchTicksDO[] filterDOs,String idSrv,String idSch) throws BizException{

		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		List<ScSchTicksDO> canUseKinditmresult = new ArrayList<ScSchTicksDO>();
		for (ScSchTicksDO ticks : filterDOs) {
			String ids_kinditm = ticks.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(ticks);
				continue;
			}
			boolean isCheckKinditm = true;
			if(!StringUtil.isEmpty(ids_kinditm)){
				for (ScBdSrvDTO scBdSrvDTO : scbdsrvs) {
					String id_scsrvkinditm = scBdSrvDTO.getId_scsrvkinditem();
					if(!StringUtil.isEmpty(id_scsrvkinditm)){
						if(!ids_kinditm.contains(id_scsrvkinditm)){
							isCheckKinditm = false;
						}
					}
				}
			}
			if (isCheckKinditm) {
				canUseKinditmresult.add(ticks);
			}
		}
		if(ListUtil.isEmpty(canUseKinditmresult)){
			return null;
		}
		return canUseKinditmresult.toArray(new ScSchTicksDO[canUseKinditmresult.size()]);
	
	}
	/**
	 * 根据条件获取排班号段
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTicksDO[] getSchTicksByWhere(String where, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		// 排班号段查询服务
		IScticksRService schTicksQryService = ServiceFinder.find(IScticksRService.class);
		return schTicksQryService.find(where, order, FBoolean.FALSE);
	}
	/**
	 * 根据号段获取排班可用最小号位
	 * 
	 * @param ticksId 号段id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickByTicksId(String ticksId, Map<Integer,Integer> polcnMap, String scchlId,MtResDTO resDTO) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null,null), EuUseState.WY, EuUseScope.APT,
				ticksId);
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			throw new BizException("排班号源已用尽，请刷新后重试!");
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcnMap, resDTO);
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		return filterDOs[0];
	}
	/**
	 * 按渠道根据排班占用排班最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyBySchId(String schId, Map<Integer,Integer> polcnMap, String scchlId,String idEnttp,MtResDTO resDTO,String idSrv) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
				schId);
		return this.occupyTickByCond(tickCond, null, polcnMap, scchlId,schId,idEnttp, resDTO,idSrv);
	}
	/**
	 * 按渠道根据排班占用排班最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyBySchId4Auto(String schId, Map<Integer,Integer> polcnMap, String scchlId,String idEnttp,MtResDTO resDTO,String idSrv) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
				schId);
		return this.occupyTickByCond4Auto(tickCond, null, polcnMap, scchlId,schId,idEnttp, resDTO,idSrv);
	}
	/**
	 * 按渠道根据排班占用排班最小号位（渠道号位优先）
	 * 自动定位预约日期
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyBySchId4AutoLocate(String schId, Map<Integer,Integer> polcnMap, String scchlId,String idEnttp,MtResDTO resDTO,String idSrv) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
				schId);
		return this.occupyTickByCond4AutoLocate(tickCond, null, polcnMap, scchlId,schId,idEnttp, resDTO,idSrv);
	}
	/**
	 * 根据渠道占用指定号位
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException 异常
	 */
	@SuppressWarnings("unchecked")
	public ScSchTickDO occupyByTickId(String tickId, Integer polcn, String scchlId,MtResDTO resDTO,Map<Integer,Integer> polcnMap) throws BizException {
		ScSchTickDO tickDO = (ScSchTickDO) new DAFacade().findByPK(ScSchTickDO.class, tickId);
		if(tickDO.getPolno() != null && tickDO.getPolno() != polcn && !polcnMap.containsKey(tickDO.getPolno())){
			throw new BizException(IScMsgConst.ERROR_SCH_POL_NOT_MATCH_FOR_TICK);
		}
		if(tickDO.getPolno() != null && tickDO.getPolno() != polcn){
			polcn = tickDO.getPolno();
		}
		if (tickDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		//互斥规则校验
		tickDO = mutualExclusionCheck(tickDO,resDTO);
		if(tickDO == null)
		{
			return null;
		}
		// 占用号位
		return this.occupyTick(tickDO, polcn, scchlId,true);
	}

	/**
	 * 互斥检查,检查是否存在禁止,如果禁止返回null
	 * @param tickDO
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO mutualExclusionCheck(ScSchTickDO tickDO,MtResDTO resDTO )throws BizException 
	{
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDO.getId_sch());
 		FDateTime aptTime = new FDateTime(schDO.getD_sch(),tickDO.getT_b());
 		boolean isUseTickDO = true;//不需要提示的号位
 		if(!ListUtil.isEmpty(resDTO.getDays_excl_times())){
 			for (Object object : resDTO.getDays_excl_times()){
 				Map<String, String> exclMap = (Map<String, String>) object;
 				FDateTime dt_b = new FDateTime(exclMap.get("dt_b") + " 00:00:00");
 				FDateTime dt_e = new FDateTime(exclMap.get("dt_e") + " 23:59:59");
 				if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<=0){
 					resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
 					return null;
 				}
 			}
 		}
 		if(!ListUtil.isEmpty(resDTO.getDays_excl_must())){
		for (Object object : resDTO.getDays_excl_must()) {
			Map<String, String> exclMap = (Map<String, String>) object;
			FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
			FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
			if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<0){
				resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
				return null;
			}
		}
 		}
 		if(!ListUtil.isEmpty(resDTO.getDays_together_must())){
		for (Object object : resDTO.getDays_together_must()) {
			Map<String, String> exclMap = (Map<String, String>) object;
			FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
			FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
			FDate apt_b = new FDate(exclMap.get("aptTime"));
			if(aptTime.compareTo(dt_b) < 0 || aptTime.compareTo(dt_e) > 0 ){
				resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
				return null;
			}
			resDTO.setFg_release(FBoolean.TRUE);
		}
 		}
		if (!ListUtil.isEmpty(resDTO.getDays_together_hint())) {
		for (Object object : resDTO.getDays_together_hint()) {
 				Map<String, String> togetherMap = (Map<String, String>) object;
 				FDateTime dt_b = new FDateTime(togetherMap.get("dt_b"));
 				FDateTime dt_e = new FDateTime(togetherMap.get("dt_e"));
				// FDate apt_b = new FDate(exclMap.get("aptTime"));
			resDTO.setFg_release(FBoolean.TRUE);

				if (aptTime.compareTo(dt_b) < 0 || aptTime.compareTo(dt_e) > 0) {
					// isUseTickDO = false;
 					Map<String, String> map = (Map<String, String>) object;
 					map.put("is_show", FBoolean.TRUE.toString());
				} 
				//else {
				//	isUseTickDO = true;
				//	break;
				//}
 				}
			//if (!isUseTickDO) {
			//	for (Object object : resDTO.getDays_together_hint()) {
			//		Map<String, String> map = (Map<String, String>) object;
			//		map.put("is_show", FBoolean.TRUE.toString());
			//	}
			//}
 			}
		if (!ListUtil.isEmpty(resDTO.getDays_excl_hint())) {
 			for (Object object : resDTO.getDays_excl_hint()) {
 				Map<String, String> exclMap = (Map<String, String>) object;
 				FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
 				FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
 				if (aptTime.compareTo(dt_b) >= 0 && aptTime.compareTo(dt_e) <= 0) {
 					//isUseTickDO = false;
 					Map<String, String> map = (Map<String, String>) object;
 					map.put("is_show", FBoolean.TRUE.toString());
 				} 
				//else {
				//	isUseTickDO = true;
				//	break;
				//}
			}
			//if (!isUseTickDO) {
			//	for (Object object : resDTO.getDays_excl_hint()) {
			//		Map<String, String> exclMap = (Map<String, String>) object;
			//		exclMap.put("is_show", FBoolean.TRUE.toString());
			//	}
			//}
		}
		return tickDO;
	}
	
	/**
	 * 按渠道根据号段占用号段最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param ticksId 号段ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksId(String ticksId, Map<Integer, Integer> polcnMap, String scchlId, String idEnttp,
			MtResDTO resDTO, String idSrv, String schId) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null, null), EuUseState.WY,
				EuUseScope.APT, ticksId);
		return this.occupyTickByCond(tickCond, null, polcnMap, scchlId, schId, idEnttp, resDTO, idSrv);
	}
	/**
	 * 按渠道根据号段占用号段最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param ticksId 号段ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksId4Auto(String ticksId, Map<Integer, Integer> polcnMap, String scchlId, String idEnttp,
			MtResDTO resDTO, String idSrv, String schId) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null, null), EuUseState.WY,
				EuUseScope.APT, ticksId);
		return this.occupyTickByCond4Auto(tickCond, null, polcnMap, scchlId, schId, idEnttp, resDTO, idSrv);
	}
	
	/**
	 * 按渠道根据号段占用号段最小号位（渠道号位优先）--自动定位可预约日期
	 *
	 * @author zhengcm
	 * 
	 * @param ticksId 号段ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksId4AutoLocate(String ticksId, Map<Integer, Integer> polcnMap, String scchlId, String idEnttp,
			MtResDTO resDTO, String idSrv, String schId) throws BizException {
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null, null), EuUseState.WY,
				EuUseScope.APT, ticksId);
		return this.occupyTickByCond4AutoLocate(tickCond, null, polcnMap, scchlId, schId, idEnttp, resDTO, idSrv);
	}
	/**
	 * 按渠道根据排班和服务占用最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param srvId 医疗服务ID
	 * @param scchlId 排班渠道ID
	 * @param exclDateList 排斥日期集合
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occpuyBySchAndSrv(String schId, Map<Integer,Integer> polcnMap, String srvId, String scchlId,String idEnttp,MtResDTO resDTO) throws BizException {
		// 参数校验
		ScValidator.validateParam(schId, srvId, scchlId);
		// 号位查询
		String tickCond = String.format(this.getTickQueryWherePart(schId, null, null,null), EuUseState.WY, EuUseScope.APT,
				schId);
		ScSchDO schDO = new Sch4MtAptEP().getById(schId);
		ScPlanDO planDO = new SchPl4MtAptEP().getScPl(schDO.getId_scpl());
		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = new Tick4MtAptEP().getWherePartBySysParam(srvId, planDO.getId_dep());
		String where = this.processWherePart(srvId, planDO);
		if (null != where) {
			wherePart = where;
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			tickCond += wherePart;
		}
		return this.occupyTickByCond(tickCond, schDO, polcnMap, scchlId,schId,idEnttp, resDTO,srvId);
	}

	/**
	 * 按渠道根据号段和服务占用最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param ticksId 号段ID
	 * @param polcn 号源池
	 * @param srvId 医疗服务ID
	 * @param scchlId 排班渠道ID
	 * @param exclDateList 排斥日期集合
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksAndSrv(String ticksId, Map<Integer,Integer> polcnMap, String srvId, String scchlId,String idEnttp,MtResDTO resDTO)
			throws BizException {
		// 参数校验
		ScValidator.validateParam(ticksId, srvId, scchlId);
		// 查询号位
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null,null), EuUseState.WY, EuUseScope.APT,
				ticksId);

		IScticksRService ticksQryService = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO tempDO = ticksQryService.findById(ticksId);
		ScSchDO schDO = new Sch4MtAptEP().getById(tempDO.getId_sch());
		ScPlanDO planDO = new SchPl4MtAptEP().getScPl(schDO.getId_scpl());
		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = new Tick4MtAptEP().getWherePartBySysParam(srvId, planDO.getId_dep());
		String where = this.processWherePart(srvId, planDO);
		if (null != where) {
			wherePart = where;
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			tickCond += wherePart;
		}
		return this.occupyTickByCond(tickCond, schDO, polcnMap, scchlId,schDO.getId_sch(),idEnttp, resDTO,srvId);
	}

	/**
	 * 按渠道根据服务占用指定号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickId 号位ID
	 * @param polcn 号源池
	 * @param srvId 服务ID
	 * @param scchlId 排班渠道ID
	 * @param exclDateList 排斥日期集合
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyTickBySrv(String tickId, Map<Integer,Integer> polcnMap, String srvId, String scchlId,MtResDTO resDTO) throws BizException {
		// 参数校验
		ScValidator.validateParam(tickId, srvId, scchlId);
		// 查询号位
		String tickCond = String.format(this.getTickQueryWherePart(null, null, tickId,null), EuUseState.WY, EuUseScope.APT,
				tickId);

		ScSchTickDO tickDO = (ScSchTickDO) new DAFacade().findByPK(ScSchTickDO.class, tickId);
		ScSchDO schDO = new Sch4MtAptEP().getById(tickDO.getId_sch());
		ScPlanDO planDO = new SchPl4MtAptEP().getScPl(schDO.getId_scpl());
		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = new Tick4MtAptEP().getWherePartBySysParam(srvId, planDO.getId_dep());
		String where = this.processWherePart(srvId, planDO);
		if (null != where) {
			wherePart = where;
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			tickCond += wherePart;
		}
		return this.occupyTickByCond(tickCond, schDO, polcnMap, scchlId,null,null, resDTO,srvId);
	}

	/**
	 * 按渠道根据号位查询条件占用号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickCond 号位查询条件
	 * @param schDO 排班DO
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @param exclDateList 排斥日期集合
	 * @return 占用的号位DO
	 * @throws BizException
	 */
private ScSchTickDO occupyTickByCond(String tickCond, ScSchDO schDO, Map<Integer, Integer> polcnMap, String scchlId,
		String schId, String idEnttp, MtResDTO resDTO, String idSrv)
			throws BizException {
		// 获取票号模式
		String tickMd = this.getTickModeBySchId(schId);
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
		//校验实际时间点
		if(!IScDictCodeConst.SC_CHOICE_APT.equals(resDTO.getSc_oper_src())){// 选号预约
			tickDOs = this.checkNowTime(tickDOs);
		}
		if (null == schDO || !ArrayUtil.isEmpty(tickDOs)) { 
			if(!StringUtil.isEmpty(schId)){
				schDO = new Sch4MtAptEP().getById(schId);
			}else{
				schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
			}
		}
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcnMap, resDTO);
		if (ArrayUtil.isEmpty(filterDOs)) {
			if(resDTO.getFg_stop_daysmsgs().booleanValue()){
				return null;
			}else{
				throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
			}
		}
		if(schDO.getFg_setentp() != null && schDO.getFg_setentp().booleanValue() && !StringUtil.isEmptyWithTrim(idEnttp)){
			// 按类型过滤
			filterDOs = this.filterTickByEntp(schId, idEnttp, filterDOs);
		}
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
			//return null;
		}
		// 按照排班类别细目过滤
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			filterDOs = this.filterTicksItmsRelese(filterDOs,resDTO,idSrv,schId);
		}else{
			// 按照排班类别细目过滤
		filterDOs = new ScAptKinditmFilter().filterTickByScSrvKinditm4Manual(filterDOs, idSrv, schDO.getId_sch(),resDTO);
		}
		
		if(ArrayUtil.isEmpty(filterDOs)){
			throw new BizException(IScMsgConst.ERROR_SC_SCH_TICK_KINDITM);
		}
		int polcnNum = getMinPolcn(polcnMap);
		ScSchTickDO tick = getMinPolcnTick(filterDOs, polcnNum);
		if(tick == null) return this.occupyTick(filterDOs[0], polcnNum, scchlId,false);
		return this.occupyTick(tick, polcnNum, scchlId,true);
	}

/**
 * 按渠道根据号位查询条件占用号位
 *
 * @author zhengcm
 * 
 * @param tickCond 号位查询条件
 * @param schDO 排班DO
 * @param polcn 号源池
 * @param scchlId 排班渠道ID
 * @param exclDateList 排斥日期集合
 * @return 占用的号位DO
 * @throws BizException
 */
private ScSchTickDO occupyTickByCond4Auto(String tickCond, ScSchDO schDO, Map<Integer, Integer> polcnMap, String scchlId,
	String schId, String idEnttp, MtResDTO resDTO, String idSrv)
		throws BizException {
	// 获取票号模式
	String tickMd = this.getTickModeBySchId(schId);
	ISctickRService rService = ServiceFinder.find(ISctickRService.class);
	ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
	//校验实际时间点
	tickDOs = this.checkNowTime(tickDOs);
	if (null == schDO || !ArrayUtil.isEmpty(tickDOs)) { 
		if(!StringUtil.isEmpty(schId)){
			schDO = new Sch4MtAptEP().getById(schId);
		}else{
			schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		}
	}
	// 按渠道过滤
	ScSchTickDO[] filterDOs = this.filterTickByChl4Auto(tickDOs, schDO, scchlId, polcnMap, resDTO);
	if (ArrayUtil.isEmpty(filterDOs)) {
		return null;
	}
	if(schDO.getFg_setentp() != null && schDO.getFg_setentp().booleanValue() && !StringUtil.isEmptyWithTrim(idEnttp)){
		// 按类型过滤
		filterDOs = this.filterTickByEntp(schId, idEnttp, filterDOs);
	}
	if (ArrayUtil.isEmpty(filterDOs)) {
		return null;
	}
	// 按照排班类别细目过滤
	if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
		filterDOs = this.filterTicksItmsRelese(filterDOs,resDTO,idSrv,schId);
	}else{
		// 按照排班类别细目过滤
	filterDOs = new ScAptKinditmFilter().filterTickByScSrvKinditm4Manual(filterDOs, idSrv, schDO.getId_sch(),resDTO);
	}
	if(ArrayUtil.isEmpty(filterDOs)){
		return null;
	}
	int polcnNum = getMinPolcn4Auto(polcnMap);
	if(polcnNum == IScDictCodeConst.SC_CHL_REMAIN){
		return null;
	}
	ScSchTickDO tick = getMinPolcnTick(filterDOs, polcnNum);
	if(tick == null) return this.occupyTick4Auto(filterDOs[0], polcnNum, scchlId,false);
	return this.occupyTick4Auto(tick, polcnNum, scchlId,true);
}
/**
 * 按渠道根据号位查询条件占用号位
 * 自动定位预约日期
 * @author zhengcm
 * 
 * @param tickCond 号位查询条件
 * @param schDO 排班DO
 * @param polcn 号源池
 * @param scchlId 排班渠道ID
 * @param exclDateList 排斥日期集合
 * @return 占用的号位DO
 * @throws BizException
 */
private ScSchTickDO occupyTickByCond4AutoLocate(String tickCond, ScSchDO schDO, Map<Integer, Integer> polcnMap, String scchlId,
	String schId, String idEnttp, MtResDTO resDTO, String idSrv)
		throws BizException {
	// 获取票号模式
	String tickMd = this.getTickModeBySchId4Auto(schId);
	ISctickRService rService = ServiceFinder.find(ISctickRService.class);
	ScSchTickDO[] tickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
	//校验实际时间点
	tickDOs = this.checkNowTime(tickDOs);
	if (null == schDO || !ArrayUtil.isEmpty(tickDOs)) { 
		if(!StringUtil.isEmpty(schId)){
			schDO = new Sch4MtAptEP().getById(schId);
		}else{
			schDO = new Sch4MtAptEP().getById(tickDOs[0].getId_sch());
		}
	}
	// 按渠道过滤
	ScSchTickDO[] filterDOs = this.filterTickByChl4Auto(tickDOs, schDO, scchlId, polcnMap, resDTO);
	if (ArrayUtil.isEmpty(filterDOs)) {
		return null;
	}
	if(schDO.getFg_setentp() != null && schDO.getFg_setentp().booleanValue() && !StringUtil.isEmptyWithTrim(idEnttp)){
		// 按类型过滤
		filterDOs = this.filterTickByEntp(schId, idEnttp, filterDOs);
	}
	if (ArrayUtil.isEmpty(filterDOs)) {
		return null;
	}
	// 按照排班类别细目过滤
	if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
		List<String> ticksIdList = new ArrayList<String>();
		for (ScSchTickDO tick : filterDOs) {
			ticksIdList.add(tick.getId_ticks());
		}
		String ticksCond = ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_TICKS, ticksIdList);
		IScticksRService ticksRService = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO[] tks = ticksRService.find(ticksCond, null, FBoolean.FALSE);
		List<ScSchTicksDO> tickList = new ArrayList<ScSchTicksDO>(Arrays.asList(tks));
		filterDOs = this.filterTicksItmsRelese4Auto(filterDOs,tickList,resDTO,idSrv,schId);
	}else{
	filterDOs = new ScAptKinditmFilter().filterTickByScSrvKinditm4Manual(filterDOs, idSrv, schDO.getId_sch(),resDTO);
	}
	if(ArrayUtil.isEmpty(filterDOs)){
		return null;
	}
	int polcnNum = getMinPolcn4Auto(polcnMap);
	if(polcnNum == IScDictCodeConst.SC_CHL_REMAIN){
		return null;
	}
	ScSchTickDO tick = getMinPolcnTick(filterDOs, polcnNum);
	if(tick == null) return this.occupyTick4AutoLocate(filterDOs[0], polcnNum, scchlId,false);
	return this.occupyTick4AutoLocate(tick, polcnNum, scchlId,true);
}
	/**
	 * 获取可用的最小号源池号
	 * @param tickDOs
	 * @author yzh
	 * @return
	 * @throws BizException 
	 */
	private int getMinPolcn(Map<Integer,Integer> polcnMap) throws BizException{
		int polcn = IScDictCodeConst.SC_CHL_REMAIN;
		for (Integer polcnNum : polcnMap.keySet()) {
			if ((polcnNum == null || polcnNum < 0 || polcnNum > 10) && polcnNum != IScDictCodeConst.SC_CHL_REMAIN) {
				throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
			}
			if (polcnNum < polcn && polcnMap.get(polcnNum) > 0) {
				polcn = polcnNum;
			}
		}
		return polcn;
	}
	
	/**
	 * 获取可用的最小号源池号
	 * @param tickDOs
	 * @author yzh
	 * @return
	 * @throws BizException 
	 */
	private int getMinPolcn4Auto(Map<Integer,Integer> polcnMap) throws BizException{
		int polcn = IScDictCodeConst.SC_CHL_REMAIN;
		for (Integer polcnNum : polcnMap.keySet()) {
			if ((polcnNum == null || polcnNum < 0 || polcnNum > 10) && polcnNum != IScDictCodeConst.SC_CHL_REMAIN) {
				return IScDictCodeConst.SC_CHL_REMAIN;
			}
			if (polcnNum < polcn && polcnMap.get(polcnNum) > 0) {
				polcn = polcnNum;
			}
		}
		return polcn;
	}
	/**
	 * 获取最小可用号位
	 * @param tickDOs
	 * @param polcnNum
	 * @return
	 */
	private ScSchTickDO getMinPolcnTick(ScSchTickDO[] tickDOs,Integer polcnNum){
		for (ScSchTickDO scSchTickDO : tickDOs) {
			if(scSchTickDO.getPolno() == null || scSchTickDO.getPolno() == polcnNum){
				return scSchTickDO;
			}
		}
		return null;
	}
	/**
	 * 根据排班类别明细过滤号位
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO[] filterTickByScSrvKinditm(ScSchTickDO[] ticks,String idSrv,String idSch,String schKindItms) throws BizException{
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		List<ScSchTickDO> canUseKinditmresult = new ArrayList<ScSchTickDO>();
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		for (ScSchTickDO tick : ticks) {
			String ids_kinditm = tick.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(tick);
				continue;
			}
			
			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String,String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND, "Id_scsrvkinditem", scbdsrvs,schKindItms);
			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String,List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND, ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if(!StringUtil.isEmpty(ids_kinditm)){
				for (Map.Entry<String,List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();
					// 判断服务是否包含号位号段上的类别
					if(scSrvKindItmMap.containsKey(id_scsrvkind)){
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细    释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind)) && !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							isCheckKinditm = false;
						} 
					}else{
						isCheckKinditm = false;
					}
				}
			}
			if (isCheckKinditm) {
				canUseKinditmresult.add(tick);
			}
		}
		if(ListUtil.isEmpty(canUseKinditmresult)){
			return null;
		}
		return canUseKinditmresult.toArray(new ScSchTickDO[canUseKinditmresult.size()]);
	}
	
	/**
	 * 根据就诊类型过滤号位
	 * @param schId
	 * @param idEnttp
	 * @param tickDOs
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO[] filterTickByEntp(String schId,String idEnttp,ScSchTickDO[] tickDOs) throws BizException{
		IScSchEnDORService rService = ServiceFinder.find(IScSchEnDORService.class);
		// 根据排班id获取排班就诊信息
		ScSchEnDO[] scSchEnDos = rService.find("id_sch='"+schId+"'", null, FBoolean.FALSE);
		List<Integer> polcnList = new ArrayList<Integer>();
		// 筛选出符合就诊类型的号源池
		for (ScSchEnDO scSchEnDO : scSchEnDos) {
			if(scSchEnDos[0].getId_entp() == null || StringUtil.isEmpty(idEnttp)){//第三方没有就诊类型,不进行过滤
				polcnList.add(scSchEnDO.getScpolcn());
			}else{
				if(scSchEnDO.getId_entp().contains(idEnttp)){
					polcnList.add(scSchEnDO.getScpolcn());
				}
			}
		}
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		// 根据号源池过滤出符合就诊类型要求的号位
		for (ScSchTickDO tick : tickDOs) {
			boolean check = false;
			for (Integer polcn : polcnList) {
				if(polcn == tick.getPolno() || tick.getPolno() == null){
					check = true;
				}
			}
			if(check){
				tickList.add(tick);
			}
		}
		if(ListUtil.isEmpty(tickList)){
			return null;
		}else{
			return (ScSchTickDO[]) tickList.toArray(new ScSchTickDO[tickList.size()]);
		}
	}
	
	/**
	 * 根据渠道占用指定号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick(ScSchTickDO tickDO, Integer polcn, String scchlId,boolean isMin) throws BizException {
		// 检查号位渠道（包含渠道或无渠道的号位才可占用）
		this.checkTickChl(tickDO, scchlId);
		// 占用号位
		return new Tick4MtAptEP().occupy(tickDO, polcn,isMin);
	}
	/**
	 * 根据渠道占用指定号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick4Auto(ScSchTickDO tickDO, Integer polcn, String scchlId,boolean isMin) throws BizException {
		// 检查号位渠道（包含渠道或无渠道的号位才可占用）
		if(!this.checkTickChl4Auto(tickDO, scchlId)){
			return null;
		}
		// 占用号位
		return new Tick4MtAptEP().occupy4Auto(tickDO, polcn,isMin);
	}
	
	/**
	 * 根据渠道占用指定号位
	 * 自动定位预约日期
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick4AutoLocate(ScSchTickDO tickDO, Integer polcn, String scchlId,boolean isMin) throws BizException {
		// 检查号位渠道（包含渠道或无渠道的号位才可占用）
		if(!this.checkTickChl4Auto(tickDO, scchlId)){
			return null;
		}
		boolean check = this.checkIsAvailable4Auto(tickDO);
		if(!check){
			return null;
		}
		// 占用号位
		tickDO.setPolno_used(polcn);
		return tickDO;
	}
	/**
	 * 是否可用
	 * 
	 * @param tickDO
	 * @throws BizException
	 */
	private boolean checkIsAvailable4Auto(ScSchTickDO tickDO) throws BizException {
		if (tickDO == null) {
			return false;
		}
		if (EuUseState.SY.equals(tickDO.getEu_used()))
			return false;
		if (EuUseState.QXSY.equals(tickDO.getEu_used()))
			return false;
		return true;
	}
	/**
	 * 获取号位查询条件
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param ticksId 号段ID
	 * @param tickId 号位ID
	 * @return 号位查询where条件
	 * @throws BizException
	 */
	private String getTickQueryWherePart(String schId, String ticksId, String tickId,List<String> ticksIdList) throws BizException {
		String where = "eu_used = %d and fg_active = 'Y' and eu_usescope = %d";
		if (!StringUtil.isEmptyWithTrim(schId)) {
			where = where + " and id_sch = '%s' ";
		}
		if (!StringUtil.isEmptyWithTrim(ticksId)) {
			where = where + " and id_ticks = '%s' ";
		}
		if (!StringUtil.isEmptyWithTrim(tickId)) {
			where = where + " and id_tick = '%s' ";
		}
		if (!ListUtil.isEmpty(ticksIdList)) {
			where = where + " and "+ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_TICKS, ticksIdList);
		}
		return where;
	}
	/**
	 * 按渠道过滤号位并排序（渠道优先）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDOs 号位DO数组
	 * @param schDO 排班DO
	 * @param scchlId 排班渠道ID
	 * @param polcn 号源池
	 * @return 过滤排序后的号位DO数组
	 * @throws BizException
	 */
	private ScSchTickDO[] filterTickByChl(ScSchTickDO[] tickDOs, ScSchDO schDO, String scchlId, List<Integer> polcnList)
			throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || null == schDO) {
			return null;
		}
		// 有渠道号位
		List<ScSchTickDO> haveChlList = new ArrayList<ScSchTickDO>();
		// 可占用的号位：空渠道或包含当前渠道的号位
		List<ScSchTickDO> canUseList = new ArrayList<ScSchTickDO>();
		// 同号源池且不包含当前渠道的号位数量
		int other = 0;
		for (ScSchTickDO tickDO : tickDOs) {
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())) {
				canUseList.add(tickDO);
			} 
			for (Integer polcn : polcnList) {
				if (tickDO.getPolno() == polcn && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
					other = other + 1;
				}else if (tickDO.getPolno() == polcn && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && tickDO.getIds_scchl().contains(scchlId)) {
					haveChlList.add(tickDO);
					canUseList.add(tickDO);
				} 
			}
			
		}
		int remain = 0;
		for (Integer polcn : polcnList) {
			// 当前号源池剩余可预约数量
			remain += (schDO.getAttrVal("Quan" + polcn + "_appt") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
					+ "_appt"))
					- (schDO.getAttrVal("Quan" + polcn + "_used") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
							+ "_used")) - other;
		}
		if (remain <= 0) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		// 若剩余可预约数量比指定当前渠道的号位数量多，则顺序占用可使用的最小号位
		if (remain > haveChlList.size()) {
			// 顺序占用空渠道或者包含当前渠道的最小号位
			if (!ListUtil.isEmpty(canUseList)) {
				return canUseList.toArray(new ScSchTickDO[0]);
			}
		} else {
			// 占用有渠道号位
			if (!ListUtil.isEmpty(haveChlList)) {
				return haveChlList.toArray(new ScSchTickDO[0]);
			}
		}
		return null;
	}
	/**
	 * 按渠道过滤号位并排序（渠道优先）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDOs 号位DO数组
	 * @param schDO 排班DO
	 * @param scchlId 排班渠道ID
	 * @param polcn 号源池
	 * @param exclDateList 排斥日期集合
	 * @return 过滤排序后的号位DO数组
	 * @throws BizException
	 */
	private ScSchTickDO[] filterTickByChl(ScSchTickDO[] tickDOs, ScSchDO schDO, String scchlId, Map<Integer,Integer> polcnMap,MtResDTO resDTO)
			throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || null == schDO) {
			return null;
		}
		// 有渠道号位
		List<ScSchTickDO> haveChlList = new ArrayList<ScSchTickDO>();
		// 可占用的号位：空渠道或包含当前渠道的号位
		List<ScSchTickDO> canUseList = new ArrayList<ScSchTickDO>();
		// 同号源池且不包含当前渠道的号位数量
		int other = 0;
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(schDO.getSd_tickmd())){
			String tickCond = String.format(this.getTickQueryWherePart(schDO.getId_sch(), null, null, null), EuUseState.WY,
					EuUseScope.APT, schDO.getId_sch());
			ISctickRService rService = ServiceFinder.find(ISctickRService.class);
			ScSchTickDO[] alltickDOs = rService.find(tickCond, "queno", FBoolean.FALSE);// 按票号升序
			for (ScSchTickDO tickDO : alltickDOs) {
				if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())) {
					canUseList.add(tickDO);
				}
				for (Integer polcn : polcnMap.keySet()) {
					if (!StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && tickDO.getIds_scchl().contains(scchlId) && tickDO.getPolno() == polcn) {
						haveChlList.add(tickDO);
						canUseList.add(tickDO);
					} else if (tickDO.getPolno() == polcn && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
						other = other + 1;
					}
				}
			}
		}else{
		for (ScSchTickDO tickDO : tickDOs) {
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())) {
				canUseList.add(tickDO);
			}
			for (Integer polcn : polcnMap.keySet()) {
				if (!StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && tickDO.getIds_scchl().contains(scchlId) && tickDO.getPolno() == polcn) {
					haveChlList.add(tickDO);
					canUseList.add(tickDO);
				} else if (tickDO.getPolno() == polcn && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
					other = other + 1;
				}
			}
		}
		
			
		}
		//FIXME 如果要回去每个号源池可预约数量则在这里进行数据返回操作 2018年7月21日 16:36:44
		int remain = 0;
		for (Integer polcn : polcnMap.keySet()) {
			// 当前号源池剩余可预约数量
			remain += (schDO.getAttrVal("Quan" + polcn + "_appt") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
					+ "_appt"))
					- (schDO.getAttrVal("Quan" + polcn + "_used") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
							+ "_used"));
		}
		remain = remain - other;
		if (remain <= 0) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(schDO.getSd_tickmd())){
			List<ScSchTickDO> isHaveChl = this.isContains(haveChlList, tickDOs);
			List<ScSchTickDO> isCanUse = this.isContains(canUseList, tickDOs);
			// 若剩余可预约数量比指定当前渠道的号位数量多，则顺序占用可使用的最小号位
			if (remain > haveChlList.size()) {
				// 顺序占用空渠道或者包含当前渠道的最小号位
				if (!ListUtil.isEmpty(isCanUse)) {
					if(resDTO != null){
						isCanUse = filterTicks8ExclDate(isCanUse, resDTO, schDO);
					}
					if(!ListUtil.isEmpty(isCanUse)){
						return isCanUse.toArray(new ScSchTickDO[0]);
					}
				}
			} else {
				// 占用有渠道号位
				if (!ListUtil.isEmpty(isHaveChl)) {
					if(resDTO != null){
						isHaveChl = filterTicks8ExclDate(isHaveChl, resDTO, schDO);
					}
					if(!ListUtil.isEmpty(isHaveChl)){
						return isHaveChl.toArray(new ScSchTickDO[0]);
					}
				}else{
					throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_MATCH_CHL);
				}
			}
		}else{
		// 若剩余可预约数量比指定当前渠道的号位数量多，则顺序占用可使用的最小号位
		if (remain > haveChlList.size()) {
			// 顺序占用空渠道或者包含当前渠道的最小号位
			if (!ListUtil.isEmpty(canUseList)) {
				if(resDTO != null){
					canUseList = filterTicks8ExclDate(canUseList, resDTO, schDO);
				}
				if(!ListUtil.isEmpty(canUseList)){
					return canUseList.toArray(new ScSchTickDO[0]);
				}
			}
		} else {
			// 占用有渠道号位
			if (!ListUtil.isEmpty(haveChlList)) {
				if(resDTO != null){
					haveChlList = filterTicks8ExclDate(haveChlList, resDTO, schDO);
				}
				if(!ListUtil.isEmpty(haveChlList)){
					return haveChlList.toArray(new ScSchTickDO[0]);
				}
			}
		}
		}
		
		return null;
	}
	
	/**
	 * 按渠道过滤号位并排序（渠道优先）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDOs 号位DO数组
	 * @param schDO 排班DO
	 * @param scchlId 排班渠道ID
	 * @param polcn 号源池
	 * @param exclDateList 排斥日期集合
	 * @return 过滤排序后的号位DO数组
	 * @throws BizException
	 */
	private ScSchTickDO[] filterTickByChl4Auto(ScSchTickDO[] tickDOs, ScSchDO schDO, String scchlId, Map<Integer,Integer> polcnMap,MtResDTO resDTO)
			throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || null == schDO) {
			return null;
		}
		// 有渠道号位
		List<ScSchTickDO> haveChlList = new ArrayList<ScSchTickDO>();
		// 可占用的号位：空渠道或包含当前渠道的号位
		List<ScSchTickDO> canUseList = new ArrayList<ScSchTickDO>();
		// 同号源池且不包含当前渠道的号位数量
		int other = 0;
		for (ScSchTickDO tickDO : tickDOs) {
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())) {
				canUseList.add(tickDO);
			}
			for (Integer polcn : polcnMap.keySet()) {
				if (!StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && tickDO.getIds_scchl().contains(scchlId) && tickDO.getPolno() == polcn) {
					haveChlList.add(tickDO);
					canUseList.add(tickDO);
				} else if (tickDO.getPolno() == polcn && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
					other = other + 1;
				}
			}
			
		}
		//FIXME 如果要回去每个号源池可预约数量则在这里进行数据返回操作 2018年7月21日 16:36:44
		int remain = 0;
		for (Integer polcn : polcnMap.keySet()) {
			// 当前号源池剩余可预约数量
			remain += (schDO.getAttrVal("Quan" + polcn + "_appt") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
					+ "_appt"))
					- (schDO.getAttrVal("Quan" + polcn + "_used") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
							+ "_used"));
		}
		remain = remain - other;
		if (remain <= 0) {
			return null;
		}
		// 若剩余可预约数量比指定当前渠道的号位数量多，则顺序占用可使用的最小号位
		if (remain > haveChlList.size()) {
			// 顺序占用空渠道或者包含当前渠道的最小号位
			if (!ListUtil.isEmpty(canUseList)) {
				if(resDTO != null){
					canUseList = filterTicks8ExclDate4Auto(canUseList, resDTO, schDO);
				}
				if(!ListUtil.isEmpty(canUseList)){
					return canUseList.toArray(new ScSchTickDO[0]);
				}
			}
		} else {
			// 占用有渠道号位
			if (!ListUtil.isEmpty(haveChlList)) {
				if(resDTO != null){
					haveChlList = filterTicks8ExclDate4Auto(haveChlList, resDTO, schDO);
				}
				if(!ListUtil.isEmpty(haveChlList)){
					return haveChlList.toArray(new ScSchTickDO[0]);
				}
			}
		}
		return null;
	}
	/**
	 * 通过排斥日期过滤可用号位
	 * @param tickList
	 * @param exclDateList
	 * @param schDO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<ScSchTickDO> filterTicks8ExclDate(List<ScSchTickDO> tickList,MtResDTO resDTO,ScSchDO schDO){
		List<ScSchTickDO> result = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> result4Hint = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> result4TogetherHint = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> result4ExclHint = new ArrayList<ScSchTickDO>();
		FArrayList exclMust = new FArrayList();
		FArrayList togetherMust = new FArrayList();
		FArrayList exclTimesMust = new FArrayList();
		for (ScSchTickDO scschtickdo : tickList) {
			FDateTime aptTime = new FDateTime(schDO.getD_sch(),scschtickdo.getT_b());
			boolean isUseTickDO = true;//提示并行-不需要提示的号位
			boolean hintUseTick =  false;//提示并行-需要提示使用的号位
			boolean isUseExclTip = true;  //排斥提示-不需要提示的号位
			boolean hintExcl = false; //排斥提示-不需要提示使用的号位
			
			boolean isExclMust = false;
			boolean isTogetherMust = false;
			boolean isExclTimes = false;
			boolean isStop = false;//是否停止
			FMap exclMustMap = new FMap();
			FMap togetherMustMap = new FMap();
			FMap exclTimesMap = new FMap();
			if(!ListUtil.isEmpty(resDTO.getDays_excl_must())){
				for (Object object : resDTO.getDays_excl_must()) {
					FMap exclMap = (FMap) object;
					if(MapUtils.isEmpty(exclMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(exclMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(exclMap.get("dt_e").toString());
					if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<0){
						isUseTickDO = false;
						isExclMust = true;
						isStop = true;
						exclMustMap = exclMap;
						exclMustMap.put("is_show", FBoolean.TRUE.toString());
					}
				}
			}
			if(!ListUtil.isEmpty(resDTO.getDays_together_must())){
				for (Object object : resDTO.getDays_together_must()) {
					FMap togetherMap = (FMap) object;
					if(MapUtils.isEmpty(togetherMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(togetherMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(togetherMap.get("dt_e").toString());
					if(aptTime.compareTo(dt_b) < 0 || aptTime.compareTo(dt_e) > 0 ){
						isUseTickDO = false;
						isTogetherMust = true;
						isStop = true;
						togetherMustMap = togetherMap;
						togetherMustMap.put("is_show", FBoolean.TRUE.toString());
					}
					resDTO.setFg_release(FBoolean.TRUE);
				}
			}
			if(!ListUtil.isEmpty(resDTO.getDays_excl_times())){
				for (Object object : resDTO.getDays_excl_times()) {
					FMap timesMap = (FMap) object;
					if(MapUtils.isEmpty(timesMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(timesMap.get("dt_b") + " 00:00:00");
					FDateTime dt_e = new FDateTime(timesMap.get("dt_e") + " 23:59:59");
					if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<=0){
						isUseTickDO = false;
						isExclTimes = true;
						isStop = true;
						exclTimesMap = timesMap;
						exclTimesMap.put("is_show", FBoolean.TRUE.toString());
					}
				}
			}
			if(!ListUtil.isEmpty(resDTO.getDays_excl_hint())){
				for (Object object : resDTO.getDays_excl_hint()) {
					FMap hintMap = (FMap) object;
					if(MapUtils.isEmpty(hintMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(hintMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(hintMap.get("dt_e").toString());
					if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<0){
						isUseExclTip = false;
						hintExcl = true;
						FMap map = (FMap) object;
						map.put("is_show", FBoolean.TRUE.toString());
					}
					//else{
					//	isUseExclTip = true;
					//	hintExcl = false;
					//	break;
					//}
				}
			}
			if (!ListUtil.isEmpty(resDTO.getDays_together_hint())) {
				for (Object object : resDTO.getDays_together_hint()) {
					FMap hintMap = (FMap) object;
					if (MapUtils.isEmpty(hintMap)) {
						continue;
					}
					FDateTime dt_b = new FDateTime(hintMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(hintMap.get("dt_e").toString());
					resDTO.setFg_release(FBoolean.TRUE);
					if (aptTime.compareTo(dt_b) <= 0 || aptTime.compareTo(dt_e) >= 0) {
						isUseTickDO = false;
						hintUseTick = true;
						FMap map = (FMap) object;
						map.put("is_show", FBoolean.TRUE.toString());
					} 
					//else {
					//	isUseTickDO = true;
					//	hintUseTick = false;
					//	break;
					//}
					}
				}
			//不符合排斥提示 或者 不符合并行提示的号位
			if(hintUseTick || hintExcl){
				result4Hint.add(scschtickdo);
			}
			//符合并行提示 不符合排斥提示 并且通过 强制并行 排斥禁止 和次数限制校验的号位
			if(isUseTickDO && !isStop && !isUseExclTip){
				result4TogetherHint.add(scschtickdo);
				}
			//符合排斥提示 不符合并行提示 并且通过 强制并行 排斥禁止 和次数限制校验的号位
			if(isUseExclTip && !isStop && !isUseTickDO){
				result4ExclHint.add(scschtickdo);
				}
			//通过所有校验的号位
			if (isUseTickDO && isUseExclTip && !isStop) {
				result.add(scschtickdo);
			}else{
				if(isExclMust){
					exclMust.add(exclMustMap);
				}
				if(isTogetherMust){
					togetherMust.add(togetherMustMap);
				}
				if(isExclTimes){
					exclTimesMust.add(exclTimesMap);
				}
				
			}
		}
		if(result.size() == 0 && result4Hint.size() == 0){
			resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
			resDTO.setDays_excl_must(exclMust);
			resDTO.setDays_together_must(togetherMust);
			resDTO.setDays_excl_times(exclTimesMust);
		}else  if(result.size() >0 ){
			resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
			return result;
		}else if(result4ExclHint.size() > 0){
			resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
			//this.setIsShow(resDTO, false, true);
			return result4ExclHint;
		}else if(result4TogetherHint.size() > 0){
			resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
			//this.setIsShow(resDTO, true, false);
			return result4TogetherHint;
		}else if(result4Hint.size() > 0){
			//this.setIsShow(resDTO,true,true);
			return result4Hint;
		}
		return null;
	}
	
	/**
	 * 通过排斥日期过滤可用号位
	 * @param tickList
	 * @param exclDateList
	 * @param schDO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<ScSchTickDO> filterTicks8ExclDate4Auto(List<ScSchTickDO> tickList,MtResDTO resDTO,ScSchDO schDO){
		List<ScSchTickDO> result = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> result4Hint = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> result4TogetherHint = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> result4ExclHint = new ArrayList<ScSchTickDO>();
		FArrayList exclMust = new FArrayList();
		FArrayList togetherMust = new FArrayList();
		FArrayList exclTimesMust = new FArrayList();
		for (ScSchTickDO scschtickdo : tickList) {
			FDateTime aptTime = new FDateTime(schDO.getD_sch(),scschtickdo.getT_b());
			boolean isUseTickDO = true;//提示并行-不需要提示的号位
			boolean hintUseTick =  false;//提示并行-需要提示使用的号位
			boolean isUseExclTip = true;  //排斥提示-不需要提示的号位
			boolean hintExcl = false; //排斥提示-不需要提示使用的号位
			
			boolean isExclMust = false;
			boolean isTogetherMust = false;
			boolean isExclTimes = false;
			boolean isStop = false;//是否停止
			boolean isExclHint = false;
			FMap exclMustMap = new FMap();
			FMap togetherMustMap = new FMap();
			FMap exclTimesMap = new FMap();
			FMap exclHintMap = new FMap();
			if(!ListUtil.isEmpty(resDTO.getDays_excl_must())){
				for (Object object : resDTO.getDays_excl_must()) {
					FMap exclMap = (FMap) object;
					if(MapUtils.isEmpty(exclMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(exclMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(exclMap.get("dt_e").toString());
					if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<0){
						isUseTickDO = false;
						isExclMust = true;
						isStop = true;
						exclMustMap = exclMap;
						exclMustMap.put("is_show", FBoolean.TRUE.toString());
					}
				}
			}
			if(!ListUtil.isEmpty(resDTO.getDays_together_must())){
				for (Object object : resDTO.getDays_together_must()) {
					FMap togetherMap = (FMap) object;
					if(MapUtils.isEmpty(togetherMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(togetherMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(togetherMap.get("dt_e").toString());
					if(aptTime.compareTo(dt_b) < 0 || aptTime.compareTo(dt_e) > 0 ){
						isUseTickDO = false;
						isTogetherMust = true;
						isStop = true;
						togetherMustMap = togetherMap;
						togetherMustMap.put("is_show", FBoolean.TRUE.toString());
					}
					resDTO.setFg_release(FBoolean.TRUE);
				}
			}
			/*if(!ListUtil.isEmpty(resDTO.getDays_excl_times())){
				for (Object object : resDTO.getDays_excl_times()) {
					FMap timesMap = (FMap) object;
					if(MapUtils.isEmpty(timesMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(timesMap.get("dt_b") + " 00:00:00");
					FDateTime dt_e = new FDateTime(timesMap.get("dt_e") + " 23:59:59");
					if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<=0){
						isUseTickDO = false;
						isExclTimes = true;
						isStop = true;
						exclTimesMap = timesMap;
						exclTimesMap.put("is_show", FBoolean.TRUE.toString());
					}
				}
			}*/
			if(!ListUtil.isEmpty(resDTO.getDays_excl_hint())){
				for (Object object : resDTO.getDays_excl_hint()) {
					FMap hintMap = (FMap) object;
					if(MapUtils.isEmpty(hintMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(hintMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(hintMap.get("dt_e").toString());
					if(aptTime.compareTo(dt_b)>=0 && aptTime.compareTo(dt_e)<0){
						isUseExclTip = false;
						hintExcl = true;
						isStop = true;
						isExclHint = true;
						exclHintMap = hintMap;
						exclHintMap.put("is_show", FBoolean.TRUE.toString());
					}
					//else{
					//	isUseExclTip = true;
					//	hintExcl = false;
					//	break;
					//}
				}
			}
			if(!ListUtil.isEmpty(resDTO.getDays_together_hint())){
				for (Object object : resDTO.getDays_together_hint()) {
					FMap hintMap = (FMap) object;
					if(MapUtils.isEmpty(hintMap)){
						continue;
					}
					FDateTime dt_b = new FDateTime(hintMap.get("dt_b").toString());
					FDateTime dt_e = new FDateTime(hintMap.get("dt_e").toString());
					resDTO.setFg_release(FBoolean.TRUE);
					if(aptTime.compareTo(dt_b) <= 0 || aptTime.compareTo(dt_e) >= 0 ){
						isUseTickDO = false;
						hintUseTick = true;
						FMap map = (FMap) object;
						map.put("is_show", FBoolean.TRUE.toString());
					}
					//else{
					//	isUseTickDO = true;
					//	hintUseTick = false;
					//	break;
					//}
					}
				}
			//不符合排斥提示 或者 不符合并行提示的号位
			if(hintUseTick || hintExcl){
				result4Hint.add(scschtickdo);
			}
			//符合并行提示 不符合排斥提示 并且通过 强制并行 排斥禁止 和次数限制校验的号位
			if(isUseTickDO && !isStop && !isUseExclTip){
				result4TogetherHint.add(scschtickdo);
				}
			//符合排斥提示 不符合并行提示 并且通过 强制并行 排斥禁止 和次数限制校验的号位
			if(isUseExclTip && !isStop && !isUseTickDO){
				result4ExclHint.add(scschtickdo);
				}
			//通过所有校验的号位
			if (isUseTickDO && isUseExclTip && !isStop) {
				result.add(scschtickdo);
			}else{
				if(isExclMust){
					exclMust.add(exclMustMap);
				}
				if(isTogetherMust){
					togetherMust.add(togetherMustMap);
				}
				if(isExclTimes){
					exclTimesMust.add(exclTimesMap);
				}
				
			}
		}
		if(result.size() == 0 && result4Hint.size() == 0){
			resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
			resDTO.setDays_excl_must(exclMust);
			resDTO.setDays_together_must(togetherMust);
			resDTO.setDays_excl_times(exclTimesMust);
		}else  if(result.size() >0 ){
			resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
			return result;
		}else if(result4ExclHint.size() > 0){
			resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
			//this.setIsShow(resDTO, false, true);
			return result4ExclHint;
		}else if(result4TogetherHint.size() > 0){
			resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
			//this.setIsShow(resDTO, true, false);
			return result4TogetherHint;
		}else if(result4Hint.size() > 0){
			//this.setIsShow(resDTO,true,true);
			return result4Hint;
		}
		return null;
	}
	/**
	 * 设置需要提示的信息
	 * @param resDTO
	 */
	private void setIsShow(MtResDTO resDTO,boolean exclShow,boolean togetherShow){
		if (exclShow) {
			if(!ListUtil.isEmpty(resDTO.getDays_excl_hint())){
				for (Object object : resDTO.getDays_excl_hint()) {
					FMap hintMap = (FMap) object;
					hintMap.put("is_show", FBoolean.TRUE.toString());
				}
			}
		}
		if (togetherShow) {
			if(!ListUtil.isEmpty(resDTO.getDays_together_hint())){
				for (Object object : resDTO.getDays_together_hint()) {
					FMap hintMap = (FMap) object;
					hintMap.put("is_show", FBoolean.TRUE.toString());
				}
			}
		}
	}
	/**
	 * 检查号位渠道（号位渠道是否包含指定渠道）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param scchlId 排班渠道ID
	 * @throws BizException
	 */
	private void checkTickChl(ScSchTickDO tickDO, String scchlId) throws BizException {
		if (tickDO == null) {
			return;
		}
		// 检查号位渠道（渠道匹配或者无渠道的号位才可占用）
		if (!StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_MATCH_CHL);
		}
	}
	
	/**
	 * 检查号位渠道（号位渠道是否包含指定渠道）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param scchlId 排班渠道ID
	 * @throws BizException
	 */
	private boolean checkTickChl4Auto(ScSchTickDO tickDO, String scchlId) throws BizException {
		if (tickDO == null) {
			return true;
		}
		// 检查号位渠道（渠道匹配或者无渠道的号位才可占用）
		if (!StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
			return false;
		}
		return true;
	}

	/**
	 * 处理号位号段根据服务过滤条件（医技和手术有别，针对手术特殊处理）
	 * 
	 * @author zhengcm
	 *
	 * @param id_srv
	 * @param planDO
	 * @throws BizException
	 */
	private String processWherePart(String id_srv, ScPlanDO planDO) throws BizException {
		// 手术排班检查对应计划的排班服务
		if (planDO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT)) {
			String wherePart = null;
			// 排班服务查询服务
			IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
			String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", id_srv);
			ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
			if (ArrayUtil.isEmpty(relDOs)) {
				wherePart = " and 1 = 2";
			}
			boolean isHas = false;
			for (ScheduleSrvRelDO relDO : relDOs) {
				if (relDO.getId_scsrv().equals(planDO.getId_scsrv())) {
					isHas = true;
					break;
				}
			}
			if (isHas) {
				wherePart = " and 1 = 1";
			} else {
				wherePart = " and 1 = 2";
			}
			return wherePart;
		}
		return null;
	}
	/**
	 * (号段)根据参数SC275 校验实际时间点 —— 号段开始时间必须大于当前时间
	 * @param ticks
	 * @return
	 * @throws BizException 
	 */
	private ScSchTicksDO[] checkNowTime(ScSchTicksDO[] ticks) throws BizException{
		if(ArrayUtil.isEmpty(ticks)) return null;
		ScSchDO schDO = new Sch4MtAptEP().getById(ticks[0].getId_sch());
		FBoolean isCheck = ScParamUtils.getscMtAptChkNowTime();
		List<ScSchTicksDO> result = new ArrayList<ScSchTicksDO>();
		FDateTime now = ScAppUtils.getServerDateTime();
		FTime nowTime = now.getUFTime();
		if (isCheck.booleanValue()) {
			if(schDO.getD_sch().asBegin().compareTo(now.getBeginDate()) == 0){
				for (ScSchTicksDO ticksDO : ticks) {
					FTime t_b = ticksDO.getT_b();
					if(nowTime.compareTo(t_b) < 0){
						result.add(ticksDO);
					}
				}	
			}else if(schDO.getD_sch().asBegin().compareTo(now.getBeginDate()) > 0){
				return ticks;
			}
			
		}else{
			return ticks;
		}
		return result.toArray(new ScSchTicksDO[0]);
	}
	/**
	 * (号位)根据参数SC275 校验实际时间点 —— 号段开始时间必须大于当前时间
	 * @param tick
	 * @return
	 * @throws BizException 
	 */
	private ScSchTickDO[] checkNowTime(ScSchTickDO[] ticks) throws BizException{
		if(ArrayUtil.isEmpty(ticks)) return null;
		ScSchDO schDO = new Sch4MtAptEP().getById(ticks[0].getId_sch());
		FBoolean isCheck = ScParamUtils.getscMtAptChkNowTime();
		List<ScSchTickDO> result = new ArrayList<ScSchTickDO>();
		FDateTime now = ScAppUtils.getServerDateTime();
		FTime nowTime = now.getUFTime();
		if (isCheck.booleanValue()) {
			if(schDO.getD_sch().asBegin().compareTo(now.getBeginDate()) == 0){
				for (ScSchTickDO tickDO : ticks) {
					FTime t_b = tickDO.getT_b();
					if(nowTime.compareTo(t_b) < 0){
						result.add(tickDO);
					}
				}
			}else if(schDO.getD_sch().asBegin().compareTo(now.getBeginDate()) > 0){
				return ticks;
			}
		}else{
			return ticks;
		}
		return result.toArray(new ScSchTickDO[0]);
	}
	/**
	 * 返回target存在于src中的号位
	 * @param srcTicks
	 * @param targetTicks
	 * @return
	 */
	private List<ScSchTickDO> isContains(List<ScSchTickDO> srcTicks,ScSchTickDO[] targetTicks){
		if(ListUtil.isEmpty(srcTicks) || ArrayUtil.isEmpty(targetTicks)) return null;
		List<ScSchTickDO> reuslt = new ArrayList<ScSchTickDO>();
		for (ScSchTickDO src : srcTicks) {
			for (ScSchTickDO target : targetTicks) {
				if(src.getId_tick().equals(target.getId_tick()) ){
					reuslt.add(target);
				}
			}
			
		}
		return reuslt;
	}
}
