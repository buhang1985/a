package iih.sc.sch.s.bp.op;

import com.mysql.jdbc.StringUtils;

import iih.sc.sch.s.bp.DrawbackTicketBP;
import iih.sc.sch.s.ep.SchLockEP;
import iih.sc.sch.sclock.d.ScSchLockDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/****
 * 门诊排班解锁
 * @author fanlq
 * @date: 2019年10月22日 上午10:32:38
 */
public class UnLockSchOpBP {

	/***
	 * @Description:门诊排班解锁
	 * @param id_schlock
	 * @return
	 */
	public String exec(String id_schlock){
		String errMsg = "";
		try{
			//1.必填项校验
			this.validate(id_schlock);
			//2.获取锁信息
			ScSchLockDO schLockDO = new SchLockEP().findById(id_schlock);
			//3.校验锁状态
			if(FBoolean.TRUE.equals(schLockDO.getFg_unlock())) return null;
			//4.释放号位
			this.drawbackTick(schLockDO.getId_tick());
			//5.更新锁状态
			this.updateLockSatus(schLockDO);
		}catch(Exception e){
			errMsg = e.getMessage();
		}
		return errMsg;
	}

	/***
	 * @Description:必填项校验
	 * @param dto
	 * @return
	 */
	private void validate(String id_schlock) throws BizException{
		if(StringUtils.isNullOrEmpty(id_schlock)){
			throw new BizException("门诊排班使用锁入参id_schlock为空！");
		}
	}
	
	/***
	 * @Description:释放号位
	 * @param id_tick
	 * @throws BizException
	 */
	private void drawbackTick(String id_tick) throws BizException{
		DrawbackTicketBP drawbackBP = new DrawbackTicketBP();
		drawbackBP.exec(id_tick);
	}
	/***
	 * @Description:更新锁状态
	 * @param schLockDO
	 * @throws BizException
	 */
	private void updateLockSatus(ScSchLockDO schLockDO) throws BizException{
		schLockDO.setFg_unlock(FBoolean.TRUE);
		schLockDO.setFg_used(FBoolean.FALSE);
		schLockDO.setStatus(DOStatus.UPDATED);
		new SchLockEP().save(schLockDO);
	}
}
