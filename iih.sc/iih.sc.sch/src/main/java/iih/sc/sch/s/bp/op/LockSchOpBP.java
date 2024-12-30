package iih.sc.sch.s.bp.op;

import com.mysql.jdbc.StringUtils;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.dto.d.SchLockDTO;
import iih.sc.sch.s.bp.OccupyTickBySchBP;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchLockEP;
import iih.sc.sch.sclock.d.ScSchLockDO;
import iih.sc.sch.sclock.d.desc.ScSchLockDODesc;
import iih.sc.sch.sclock.i.IScschlockdoCudService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 门诊排班加锁
 * @author fanlq
 * @date: 2019年10月21日 下午3:05:54
 */
public class LockSchOpBP {

	/***
	 * @Description:门诊排班加锁
	 * @param dto
	 * @return
	 * @throws BizException 
	 */
	public LockResultDTO exec(SchLockDTO dto) throws BizException{
		LockResultDTO result = new LockResultDTO();
		FDateTime nowTime = ScAppUtils.getServerDateTime();
		//1.必填项校验
		this.validate(dto);
		//2.获取患者未过期未释放的号位，存在则直接返回锁号信息
		ScSchLockDO scSchLockDO = this.getNoLockPat(dto,nowTime);
		if(scSchLockDO != null){
			result.setId_schlock(scSchLockDO.getId_sclock());
			result.setSctick(ServiceFinder.find(ISctickRService.class).findById(scSchLockDO.getId_tick()));
			return result;
		}
		//3.释放患者过期锁
		this.deleteLock(dto,nowTime);
		//4.占用号源
		ScSchTickDO tickDO = this.occupyTick(dto);
		//5.修改排班锁表
		ScSchLockDO lockDO = this.updateSchLock(dto,tickDO,nowTime);
		//6.更新号位状态
		this.updateTickStatus(lockDO);
		//7.设置返回值
		result.setSctick(tickDO);
		result.setId_schlock(lockDO.getId_sclock());
		return result;
	}
	
	/**
	 * 更新号位状态
	 * @param dto
	 * @throws BizException 
	 */
	private void updateTickStatus(ScSchLockDO lockDO) throws BizException {
		if(StringUtils.isNullOrEmpty(lockDO.getId_tick())){
			throw new BizException("号位id为空！id_schlock = " +lockDO.getId_sclock());
		}
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		String whereStr = "id_tick = ? and eu_usescope = ? ";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(lockDO.getId_tick());
		param.addParam(EuUseScope.APT);
		ScSchTickDO[] ticks = tickRService.find2(whereStr, param, null, FBoolean.FALSE);
		if(ticks == null || ticks.length <= 0){
			throw new BizException("被锁定号位为空！id_tick = "+lockDO.getId_tick());
		}
		ScSchChlDO[] scSchChlDOs = new SchChlEP().getSchChl(lockDO.getId_sch(),lockDO.getId_chl());
		ticks[0].setEu_used(EuUseState.LOCK);
		ticks[0].setPolno_used(scSchChlDOs != null && scSchChlDOs.length > 0 ? scSchChlDOs[0].getScpolcn() : 0);
		ticks[0].setStatus(DOStatus.UPDATED);
		ISctickCudService cudService = ServiceFinder.find(ISctickCudService.class);
		cudService.save(ticks);
	}

	/***
	 * @Description:必填项校验
	 * @param dto
	 * @return
	 */
	private void validate(SchLockDTO dto) throws BizException{
		if(dto == null){
			throw new BizException("入参不能为空！");
		}
		if(StringUtils.isNullOrEmpty(dto.getId_pat())){
			throw new BizException("使用患者不能为空！");
		}
		if(StringUtils.isNullOrEmpty(dto.getId_chl())){
			throw new BizException("加锁渠道不能为空！");
		}
		if(StringUtils.isNullOrEmpty(dto.getId_sch())){
			throw new BizException("排班id不能为空！");
		}
		if(StringUtils.isNullOrEmpty(dto.getId_emp())){
			throw new BizException("加锁操作员不能为空！");
		}
	}
	/***
	 * @Description:获取患者未过期未释放的号位
	 * @param dto
	 * @throws BizException
	 */
	private ScSchLockDO getNoLockPat(SchLockDTO dto,FDateTime nowTime) throws BizException{
		SchLockEP ep = new SchLockEP();
		String whereStr = String.format(" and %s.id_pat = '%s' and %s.dt_e_lock >= '%s' and %s.fg_unlock= 'N'", 
				ScSchLockDODesc.TABLE_ALIAS_NAME,dto.getId_pat(),ScSchLockDODesc.TABLE_ALIAS_NAME,nowTime,ScSchLockDODesc.TABLE_ALIAS_NAME);
		ScSchLockDO[] scSchLockDOs = ep.getLockList(whereStr);
		//ScSchDO[] scSchDOs = ep.getSchByLock(scSchLockDOs,IScDictCodeConst.SD_SCTP_OP);
		//if(scSchDOs != null && scSchDOs.length > 0){
		//	throw new BizException("患者"+dto.getId_pat()+"存在未释放的号位"+dto.getId_tick()+",请先释放号位再锁号！"); 
		//}
		return scSchLockDOs != null && scSchLockDOs.length >0 ? scSchLockDOs[0]:null;
	}

	/****
	 * @Description:释放患者门诊过期锁
	 * @param dto
	 * @throws BizException
	 */
	private void deleteLock(SchLockDTO dto,FDateTime nowTime) throws BizException{
		SchLockEP ep = new SchLockEP();
		String whereStr = String.format(" and %s.id_pat = '%s' and %s.dt_e_lock < '%s' and %s.fg_unlock= 'N'", 
				ScSchLockDODesc.TABLE_ALIAS_NAME,dto.getId_pat(),ScSchLockDODesc.TABLE_ALIAS_NAME,nowTime,ScSchLockDODesc.TABLE_ALIAS_NAME);
		ScSchLockDO[] scSchLockDOs = ep.getLockList(whereStr);
		ScSchDO[] scSchDOs = ep.getSchByLock(scSchLockDOs,IScDictCodeConst.SD_SCTP_OP);
		if(scSchDOs != null && scSchDOs.length > 0){
			UnLockSchOpBP bp = new UnLockSchOpBP();
			for(ScSchLockDO schlock : scSchLockDOs){
				bp.exec(schlock.getId_sclock());
			}
		}
	}
	
	/****
	 * @Description:占用号源
	 * @param dto
	 * @throws BizException 
	 */
	private ScSchTickDO occupyTick(SchLockDTO dto) throws BizException{
		OccupyTickBySchBP occupyBP = new OccupyTickBySchBP();
		ScSchTickDO tickDO = occupyBP.exec(dto.getId_sch(), dto.getPolcn(), dto.getId_ticks(),dto.getId_chl(),FBoolean.TRUE);
		return tickDO;
	}
	/***
	 * @Description:修改排班锁表
	 * @param tickDO
	 * @throws BizException 
	 */
	private ScSchLockDO updateSchLock(SchLockDTO dto,ScSchTickDO tickDO,FDateTime nowTime) throws BizException{
		int min = ScParamUtils.getScLockValidityMin();
		ScSchLockDO lockDO = new ScSchLockDO();
		lockDO.setId_session(dto.getId_session());
		lockDO.setId_pat(dto.getId_pat());
		lockDO.setId_sch(tickDO.getId_sch());
		lockDO.setId_srv(tickDO.getId_scsrv());
		lockDO.setId_chl(dto.getId_chl());
		lockDO.setId_tick(tickDO.getId_tick());
		lockDO.setDt_b_lock(nowTime);
		lockDO.setDt_e_lock(nowTime.addSeconds(min*60));
		lockDO.setFg_unlock(FBoolean.FALSE);
		lockDO.setFg_used(FBoolean.FALSE);
		lockDO.setId_emp(dto.getId_emp());
		lockDO.setStatus(DOStatus.NEW);
		new SchLockEP().save(lockDO);
		return lockDO;
	}
}
