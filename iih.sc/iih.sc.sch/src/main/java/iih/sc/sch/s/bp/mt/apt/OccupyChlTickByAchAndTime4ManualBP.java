package iih.sc.sch.s.bp.mt.apt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyTicks4TimeMd4ManualBP;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.mt.apt.Sch4MtAptEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.s.bp.OccupyTicks4TimeMdBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据排班和时间片时段占用号位(根据渠道)
 * 
 * @author liubin
 *
 */
public class OccupyChlTickByAchAndTime4ManualBP {
	/**
	 * 根据排班和时间片时段占用号位
	 * 
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO exec(String id_sch, SchTickMdTimeDTO schTickMdTime, String id_scchl,String id_enttp,MtResDTO resDTO) throws BizException {
		//1.校验参数
		this.validateParam(id_sch, schTickMdTime, id_scchl);
		FTime t_b = schTickMdTime.getT_b();
		FTime t_e = schTickMdTime.getT_e();
		resDTO.setSpend_time((t_e.getHour()*60+t_e.getMinute())-(t_b.getHour()*60+t_b.getMinute()));
		//2.查询排班渠道信息
		ScSchChlDO[] schChlDos = getScSchChlDO(id_sch, id_scchl,id_enttp);
		//3.互斥校验
		if(!this.mutualExclusionCheck(schTickMdTime, id_sch, resDTO)){
			return null;
		}
		//4.排班加锁
		lockSch(id_sch);
		//5.验证排班剩余时间是否足够使用
		ScSchChlDO schChlDo = validateSch(id_sch, schTickMdTime, schChlDos);
		//6.占用号段
		ScSchTicksDO schTicks = occupyTicks(resDTO.getId_scsrv(),id_sch, schTickMdTime);
		//7.占用号位
		ScSchTickDO schTickDO = occupyTick(resDTO.getId_scsrv(),schTicks, schChlDo.getScpolcn());
		//8.占用排班号源
		occupySch(id_sch, schTickMdTime, schChlDo.getScpolcn());
		return schTickDO;
	}
	
	/**
	 * 时间片预约互斥校验
	 * @author yzh
	 * @param schTickMdTime
	 * @param id_sch
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	private boolean mutualExclusionCheck(SchTickMdTimeDTO schTickMdTime,String id_sch,MtResDTO resDTO) throws BizException{

		ScSchDO schDO = new SchEP().getById(id_sch);
		FDateTime aptTime = new FDateTime(schDO.getD_sch(),schTickMdTime.getT_b());
		boolean isUseTickDO = true;//不需要提示的号位
		boolean isCheckExclHint = false;
		if(!ListUtil.isEmpty(resDTO.getDays_excl_times())){
			for (Object object : resDTO.getDays_excl_times()){
				Map<String, String> exclMap = (Map<String, String>) object;
				FDateTime dt_b = new FDateTime(exclMap.get("dt_b") + " 00:00:00");
				FDateTime dt_e = new FDateTime(exclMap.get("dt_e") + " 23:59:59");
				if(aptTime.compareTo(dt_b)>0 && aptTime.compareTo(dt_e)<=0){
					resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
					exclMap.put("is_show", FBoolean.TRUE.toString());
					return false;
				}
			}
		}
		if(!ListUtil.isEmpty(resDTO.getDays_excl_must())){
			for (Object object : resDTO.getDays_excl_must()) {
				Map<String, String> exclMap = (Map<String, String>) object;
				FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
				FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
				if(aptTime.compareTo(dt_b)>0 && aptTime.compareTo(dt_e)<0){
					resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
					exclMap.put("is_show", FBoolean.TRUE.toString());
					return false;
				}
			}
		}
		if(!ListUtil.isEmpty(resDTO.getDays_together_must())){
			for (Object object : resDTO.getDays_together_must()) {
				Map<String, String> exclMap = (Map<String, String>) object;
				FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
				FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
				//FDate apt_b = new FDate(exclMap.get("aptTime"));
				if(aptTime.compareTo(dt_b) < 0 || aptTime.compareTo(dt_e) > 0 ){
					resDTO.setFg_stop_daysmsgs(FBoolean.TRUE);
					exclMap.put("is_show", FBoolean.TRUE.toString());
					return false;
				}
				resDTO.setFg_release(FBoolean.TRUE);
			}
		}
		if (!ListUtil.isEmpty(resDTO.getDays_excl_hint())) {
			for (Object object : resDTO.getDays_excl_hint()) {
				Map<String, String> exclMap = (Map<String, String>) object;
				FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
				FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
				//FDate apt_b = new FDate(exclMap.get("aptTime"));
			resDTO.setFg_release(FBoolean.TRUE);
				if (aptTime.compareTo(dt_b) > 0 && aptTime.compareTo(dt_e) < 0) {
					isUseTickDO = false;
					Map<String, String> map = (Map<String, String>) object;
					map.put("is_show", FBoolean.TRUE.toString());
				}
				//else{
				//	isUseTickDO = true;
				//	isCheckExclHint = true;
				//	break;
				//}
			}
			//if(!isUseTickDO){
			//	for (Object object : resDTO.getDays_excl_hint()) {
			//		Map<String, String> exclMap = (Map<String, String>) object;
			//		exclMap.put("is_show", FBoolean.TRUE.toString());
			//	}
			//}
		}else{
			isCheckExclHint = true;
		}
		if (isCheckExclHint) {
		if(!ListUtil.isEmpty(resDTO.getDays_together_hint())){
			for (Object object : resDTO.getDays_together_hint()) {
				Map<String, String> exclMap = (Map<String, String>) object;
				FDateTime dt_b = new FDateTime(exclMap.get("dt_b"));
				FDateTime dt_e = new FDateTime(exclMap.get("dt_e"));
				//FDate apt_b = new FDate(exclMap.get("aptTime"));
				if(aptTime.compareTo(dt_b) < 0 || aptTime.compareTo(dt_e) > 0 ){
					isUseTickDO = false;
					Map<String, String> map = (Map<String, String>) object;
					map.put("is_show", FBoolean.TRUE.toString());
				}
				//else{
				//	isUseTickDO = true;
				//	break;
				//}
				}
			//if(!isUseTickDO){
			//	for (Object object : resDTO.getDays_together_hint()) {
			//		Map<String, String> exclMap = (Map<String, String>) object;
			//		exclMap.put("is_show", FBoolean.TRUE.toString());
			//	}
			//}
			}
		}
		return true;
	
	}
	
	/**
	 * 参数校验
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @throws BizException
	 */
	private void validateParam(String id_sch, SchTickMdTimeDTO schTickMdTime, String id_scchl) throws BizException {
		ScValidator.validateParam("OccupyChlTickByAchAndTimeBP.exec()", "id_sch", id_sch);
		ScValidator.validateParam("OccupyChlTickByAchAndTimeBP.exec()", "schTickMdTime", schTickMdTime);
		ScValidator.validateParam("OccupyChlTickByAchAndTimeBP.exec()", "id_scchl", id_scchl);
		if(schTickMdTime.getT_b() == null)
			throw new BizException("选择时间段开始时间不能为空！");
		if(schTickMdTime.getT_e() == null)
			throw new BizException("选择时间段结束时间不能为空！");
		if(schTickMdTime.getT_b().after(schTickMdTime.getT_e()))
			throw new BizException("选择时间段开始时间不能小于结束时间！");
	}
	/**
	 * 排班加锁
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @throws BizException
	 */
	private void lockSch(String id_sch) throws BizException{
		TickChlEP tickEP = new TickChlEP();
		tickEP.lockSch(id_sch);
	}
	/**
	 * 获取排班渠道信息
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param id_schchl
	 * @return
	 * @throws BizException
	 */
	private ScSchChlDO[] getScSchChlDO(String id_sch, String id_scchl, String id_enttp) throws BizException {
		SchChlEP schChlEp = new SchChlEP();
		ScSchChlDO[] schChlDOs = schChlEp.getSchChl(id_sch, id_scchl);

		if (ArrayUtil.isEmpty(schChlDOs)) {
			IScBdOutQryService bdQry = ServiceFinder.find(IScBdOutQryService.class);
			SchedulechlDO chl = bdQry.getChlById(id_scchl);
			if (chl == null)
				throw new BizException("未找到该渠道排班信息!");
			else
				throw new BizException(String.format("未找到渠道[%s]排班信息!", chl.getName()));
		}
		SchEP schEp = new SchEP();
		ScSchDO schDo = schEp.getById(id_sch);
		// FIXME 校验就诊类型
		if (schDo.getFg_setentp().booleanValue()) {
			ScSchEnDO[] schEnDos = schChlEp.getSchChlByEnId(id_sch);
			List<ScSchChlDO> schChlList = new ArrayList<ScSchChlDO>();
			for (ScSchChlDO scSchChlDO : schChlDOs) {
				int scpolcn = scSchChlDO.getScpolcn();
				for (ScSchEnDO scSchEnDO : schEnDos) {
					if (scSchEnDO.getScpolcn() == scpolcn) {
						if (scSchEnDO.getId_entp().contains(id_enttp)) {
							schChlList.add(scSchChlDO);
						}
					}
				}
			}
			if (ListUtil.isEmpty(schChlList)) {
				throw new BizException(IScMsgConst.SC_APT_NOT_FIND_ENTP_CHL);
			}
			return schChlList.toArray(new ScSchChlDO[0]);
		}

		return schChlDOs;
	}
	/**
	 * 验证排班剩余时间是否足够使用
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @throws BizException
	 */
	private ScSchChlDO validateSch(String id_sch, SchTickMdTimeDTO schTickMdTime, ScSchChlDO[] schChlDos) throws BizException{
		SchEP schBP = new SchEP();
		ScSchDO schDo = schBP.getByPK(id_sch);
		if(schTickMdTime.getT_b().before(schDo.getT_b_acpt())
				|| schTickMdTime.getT_e().after(schDo.getT_e_acpt()))
			throw new BizException(String.format("选择的时间段必须在诊疗时间内![%s-%s]", schDo.getT_b_acpt(), schDo.getT_e_acpt()));
		int mins = DateTimeUtils.getMins(schTickMdTime.getT_b(), schTickMdTime.getT_e());
		Map<Integer,ScSchChlDO> canUseSchChlMap = new HashMap<Integer,ScSchChlDO>();
		for (ScSchChlDO scSchChlDO : schChlDos) {
			Integer canUse = (Integer)schDo.getAttrVal(String.format("Quan%s_appt", scSchChlDO.getScpolcn())) - (Integer)schDo.getAttrVal(String.format("Quan%s_used", scSchChlDO.getScpolcn()));
			if(canUse.intValue() >= mins){
				canUseSchChlMap.put(scSchChlDO.getScpolcn(), scSchChlDO);
			}
		}
		if (canUseSchChlMap.size() == 0) {
			throw new BizException("选择的时间段时长大于排班剩余时长!");
		}else{
			//只有一个的情况下直接返回该号源池, 多个的情况下返回号源池号小的
			return this.getMinPolcn(canUseSchChlMap);
		}
	}
	/**
	 * 时间片模式占用号段处理
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO occupyTicks(String id_scsrv,String id_sch, SchTickMdTimeDTO schTickMdTime) throws BizException{
		OccupyTicks4TimeMd4ManualBP bp = new OccupyTicks4TimeMd4ManualBP();
		ScSchTicksDO schTicks = bp.exec(id_scsrv,id_sch, schTickMdTime);
		if(schTicks == null)
			throw new BizException("时间片模式占用号段出错!");
		return schTicks;
	}
	/**
	 * 时间片模式占用号位处理
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick(String id_scsrv,ScSchTicksDO schTicks, Integer polcn) throws BizException{
		TickEP ep = new TickEP();
		ScSchTickDO[] schTickDOs = ep.insert4TimeMd(schTicks, polcn,id_scsrv);
		if(ArrayUtil.isEmpty(schTickDOs))
			throw new BizException("时间片模式新增号位出错!");
		return schTickDOs[0];
	}
	/**
	 * 占用排班号源
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @param polcn
	 * @throws BizException
	 */
	private void occupySch(String id_sch, SchTickMdTimeDTO schTickMdTime, Integer polcn)throws BizException{
		int mins = DateTimeUtils.getMins(schTickMdTime.getT_b(), schTickMdTime.getT_e());
		SchEP schBP = new SchEP();
		schBP.occupyTick(id_sch, polcn, mins);
	}
	
	/**
	 * 获取可用最小号源池
	 * @param polcnMap
	 * @return
	 */
	private ScSchChlDO getMinPolcn(Map<Integer,ScSchChlDO> polcnMap ){
		int polcn = 99;
		for (Integer polcnNum : polcnMap.keySet()) {
			if(polcnNum < polcn){
				polcn = polcnNum;
			}
		}
		if(polcn == 99) return null;
		return polcnMap.get(polcn);
	}
}
