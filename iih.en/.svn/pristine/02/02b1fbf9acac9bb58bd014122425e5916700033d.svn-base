package iih.en.er.bp.register;

import iih.en.comm.custom.EnOpCustomServiceUtils;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 急诊换患者处理
 * 
 * @author liubin
 *
 */
public class ChangePatHandleBP {
	/**
	 * 急诊换患者处理
	 * 
	 * @param opRegPatDto
	 * @throws BizException
	 */
	public void exec(OpRegPatDTO opRegPatDto) throws BizException {
		//判断是否走客开并调用客开
		boolean isCustom = EnOpCustomServiceUtils.handleChangePat(opRegPatDto);
		if(isCustom)
			return;
		this.changePatHandle(opRegPatDto);
	}
	/**
	 * 换患者处理
	 * 
	 * @param opRegPatDto
	 * @param agg
	 * @throws BizException
	 */
	private void changePatHandle(OpRegPatDTO opRegPatDto)throws BizException{
		if(EnValidator.isEmpty(opRegPatDto.getId_pat_old()) || 
				EnValidator.isEmpty(opRegPatDto.getId_erpre()))
			return;
		IPatiRService serv = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = serv.findById(opRegPatDto.getId_pat());
		//预检换患者处理
		new ErPreEP().changePatHandle(opRegPatDto.getId_erpre(), agg);
		//判断是否存在预约记录和就诊记录，把旧患者置为无效
		if(!hasAptOrEnt(opRegPatDto.getId_pat_old())){
			PiPatEP patEP = new PiPatEP();
			PatDO pat = patEP.getPatByPK(opRegPatDto.getId_pat_old());
			pat.setStatus(DOStatus.UPDATED);
			pat.setFg_invd(FBoolean.TRUE);
			patEP.save(new PatDO[] {pat});
		}
		//记录换患者事件
		new EnEvtHandle().insertPatChgEvt(opRegPatDto);
	}
	/**
	 * 判断是否存在预约记录和就诊记录
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private boolean hasAptOrEnt(String patId) throws BizException {
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(patId);
		String sql = "select count(1) from sc_apt apt where apt.fg_canc = 'N' and apt.id_pat = ? ";
		Integer count = (Integer) daf.execQuery(sql, param, new ColumnHandler());
		if(count > 0)
			return true;
		sql = "select count(1) from en_ent ent where ent.fg_canc = 'N' and ent.id_pat = ? ";
		count = (Integer) daf.execQuery(sql, param, new ColumnHandler());
		if(count > 0)
			return true;
		return false;
	}
}
