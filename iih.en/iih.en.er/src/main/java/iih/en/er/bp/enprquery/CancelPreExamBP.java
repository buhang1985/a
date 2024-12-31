package iih.en.er.bp.enprquery;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.PiPatEP;
import iih.en.er.dto.d.EnErPrQueryDTO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.i.IEnerpreCudService;
import iih.en.er.pre.i.IEnerpreRService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 预检查询取消预检
 * 
 */
public class CancelPreExamBP {
	/**
	 * 预检查询取消预检
	 * 
	 * @param dtos
	 * @return
	 * @throws BizException
	 */
	public void exec(EnErPrQueryDTO[] dtos) throws BizException {
		DAFacade daf = null;
		SqlParam param = null;
		PatDO pat = null;
		for (EnErPrQueryDTO enErPrQueryDTO : dtos) {
			daf = new DAFacade();
			param = new SqlParam();
			param.addParam(enErPrQueryDTO.getId_pat());
			String sql = "select count(1) from en_ent ent where ent.fg_canc = 'N' and ent.id_pat = ? ";
			int count = (Integer) daf.execQuery(sql, param, new ColumnHandler());
			sql = "select count(1) from sc_apt apt where apt.fg_canc = 'N' and apt.id_pat = ? ";
			int count2 = (Integer) daf.execQuery(sql, param, new ColumnHandler());
			PiPatEP ep = new PiPatEP();
			pat = ep.getPatById(enErPrQueryDTO.getId_pat());
			if(pat == null)
				break;
			//未实名且无就诊记录
			if(count <= 0 && count2<=0 && (FBoolean.FALSE.equals(pat.getFg_realname()) || pat.getFg_realname() == null)){
				pat.setStatus(DOStatus.UPDATED);
				pat.setFg_invd(FBoolean.TRUE);
				ep.save(new PatDO[] {pat});
				this.cancelPreExam(enErPrQueryDTO);
			}else if(FBoolean.TRUE.equals(pat.getFg_realname())){//实名患者
				this.cancelPreExam(enErPrQueryDTO);
			}
		}
	}
	
	/**
	 * 取消预检
	 * @param enErPrQueryDTO
	 * @throws BizException
	 */
	private void cancelPreExam(EnErPrQueryDTO enErPrQueryDTO) throws BizException {
		IEnerpreRService serv = ServiceFinder.find(IEnerpreRService.class);
		EnErPreDO enerpredo = serv.findById(enErPrQueryDTO.getId_erpre());
		if(enerpredo == null){
			return;
		}
		enerpredo.setStatus(DOStatus.UPDATED);
		enerpredo.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL);
		IEnerpreCudService serv2 = ServiceFinder.find(IEnerpreCudService.class);
		serv2.save(new EnErPreDO[]{enerpredo});
	}
	
}	
