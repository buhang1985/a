package iih.sc.sch.s.bp.op;

import com.mysql.jdbc.StringUtils;

import iih.sc.comm.ScAppUtils;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchLockEP;
import iih.sc.sch.sclock.d.ScSchLockDO;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 门诊排班使用锁
 * @author fanlq
 * @date: 2019年10月22日 上午10:40:27
 */
public class UseLockSchOpBP {

	/***
	 * @Description:门诊排班使用锁
	 * @param id_schlock
	 * @param id_pat
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public LockResultDTO exec(String id_schlock,String id_pat,String id_ent) throws BizException{
		LockResultDTO result = new LockResultDTO();
		//1.必填项校验
		this.validate(id_schlock,id_pat);
		FDateTime nowTime = ScAppUtils.getServerDateTime();
		//2.获取锁信息
		ScSchLockDO schLockDO = new SchLockEP().findById(id_schlock);
		//3.校验锁的状态
		this.validateSchLock(schLockDO,id_schlock,id_pat,nowTime);
		//4.更新锁状态
		this.updateLockSatus(schLockDO,id_ent);
		//5.更新号位状态
		this.updateTickStatus(schLockDO,result);
		return result;
	}
	
	/***
	 * @Description:必填项校验
	 * @param dto
	 * @return
	 */
	private void validate(String id_schlock,String id_pat) throws BizException{
		if(StringUtils.isNullOrEmpty(id_schlock)){
			throw new BizException("门诊排班使用锁入参id_schlock为空！");
		}
		if(StringUtils.isNullOrEmpty(id_pat)){
			throw new BizException("门诊排班使用锁入参id_pat为空！");
		}
	}
	
	/***
	 * @Description:校验锁的状态
	 * @param schLockDO
	 * @param id_schlock
	 * @param id_pat
	 * @param nowTime
	 * @throws BizException
	 */
	private void validateSchLock(ScSchLockDO schLockDO,String id_schlock,String id_pat,FDateTime nowTime) throws BizException{
		if(schLockDO == null){
			throw new BizException("没有查询到排班锁信息！id_schlock = "+id_schlock);
		}
		if(!id_pat.equals(schLockDO.getId_pat())){
			throw new BizException("传入的患者id和锁记录对应的患者id不一致！");
		}
		if(FBoolean.TRUE.equals(schLockDO.getFg_unlock())){
			throw new BizException("锁已经被释放，不可以使用！");
		}
		if(FBoolean.TRUE.equals(schLockDO.getFg_used())){
			throw new BizException("锁已经被使用，不可以使用！");
		}
		if(nowTime.compareTo(schLockDO.getDt_e_lock()) >= 0){
			throw new BizException("锁已经过期，不可以使用！");
		}
	}
	/***
	 * @Description:更新锁状态
	 * @param schLockDO
	 * @param id_ent
	 * @throws BizException 
	 */
	private void updateLockSatus(ScSchLockDO schLockDO,String id_ent) throws BizException{
		schLockDO.setFg_unlock(FBoolean.TRUE);
		schLockDO.setFg_used(FBoolean.TRUE);
		schLockDO.setId_ent(id_ent);
		schLockDO.setStatus(DOStatus.UPDATED);
		new SchLockEP().save(schLockDO);
	}
	
	/***
	 * @Description:更新号位状态
	 * @param schLockDO
	 * @throws BizException
	 */
	private void updateTickStatus(ScSchLockDO schLockDO,LockResultDTO result) throws BizException{
		if(StringUtils.isNullOrEmpty(schLockDO.getId_tick())){
			throw new BizException("号位id为空！id_schlock = " +schLockDO.getId_sclock());
		}
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] ticks = tickRService.find("id_tick = '"+schLockDO.getId_tick()+"' and eu_used = '"+EuUseState.LOCK+"' and eu_usescope = '"+EuUseScope.APT+"' ",null,FBoolean.FALSE);
		if(ticks == null || ticks.length <= 0){
			throw new BizException("锁定号位状态已改变！id_tick = "+schLockDO.getId_tick());
		}
		ScSchChlDO[] scSchChlDOs = new SchChlEP().getSchChl(schLockDO.getId_sch(),schLockDO.getId_chl());
		ticks[0].setEu_used(EuUseState.SY);
		ticks[0].setPolno_used(scSchChlDOs != null && scSchChlDOs.length > 0 ? scSchChlDOs[0].getScpolcn() : 0);
		ticks[0].setStatus(DOStatus.UPDATED);
		ISctickCudService cudService = ServiceFinder.find(ISctickCudService.class);
		cudService.save(ticks);
		result.setSctick(ticks[0]);
		result.setId_schlock(schLockDO.getId_sclock());
	}
}
