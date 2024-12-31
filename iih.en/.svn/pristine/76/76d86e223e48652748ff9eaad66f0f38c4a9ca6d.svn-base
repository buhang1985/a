package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import iih.en.pv.dto.d.TransDepPatDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 撤销转出BP
 * 
 * @author jizb
 *
 */
public class CancelTransOutBP {

	/**
	 * 撤销转出
	 * 
	 * @param cancelDTO
	 * @throws BizException
	 */
	public void exec(TransDepPatDTO[] cancelDTOs) throws BizException {
		
		if (EnValidator.isEmpty(cancelDTOs)) {
			return;
		}
		
		//校验转科状态
		List<String> idDepTrans = new ArrayList<>();
		for (TransDepPatDTO transDepPatDTO : cancelDTOs) {
			idDepTrans.add(transDepPatDTO.getId_dep_trans());
		}
		IEndeptransRService rService = ServiceFinder.find(IEndeptransRService.class);
		EnDepTransDO[] enDepTransDOs = rService.findByIds(idDepTrans.toArray(new String[]{}), FBoolean.FALSE);
		if (EnValidator.isEmpty(enDepTransDOs)) 
			throw new BizException("患者状态发生变化，请刷新后重试！");
		for (EnDepTransDO enDepTransDO : enDepTransDOs) {
			if (enDepTransDO == null || !EnEuTrans.APPLY.equals(enDepTransDO.getEu_trans())) {
				throw new BizException("患者状态发生变化，请刷新后重试！");
			}
		}
		
		//回滚医嘱状态
		for (TransDepPatDTO transDepPatDTO : cancelDTOs) {
			if(EnValidator.isEmpty(transDepPatDTO.getId_ortrans()))
				continue;
			ICiOrdQryService iCiorderRService = ServiceFinder.find(ICiOrdQryService.class);
			boolean fg = iCiorderRService.TransferStatusUpdates(transDepPatDTO.getId_ortrans(), IEnDictCodeConst.SD_SU_OPEN);
			if (fg != true)
				throw new BizException("撤销转科失败，请刷新后重试！");// "转科失败"
		}
		
		//删除转科记录表记录
	    IEndeptransCudService cudService = ServiceFinder.find(IEndeptransCudService.class);
	    cudService.delete(enDepTransDOs);
	}
	
	/**
	 * 校验医嘱状态
	 * 
	 * @param cancelDTO
	 * @return
	 * @throws BizException
	 */
	private void validateOrStatus(TransDepPatDTO cancelDTO) throws BizException{
		ICiorapptransdeptRService QryService = ServiceFinder.find(ICiorapptransdeptRService.class);
		OrdApTransDO[] orderAptrans = QryService.find("id_ortrans ='"+cancelDTO.getId_ortrans()+"'", "id_ortrans", FBoolean.FALSE);
		if (orderAptrans == null || orderAptrans.length <= 0 && !IEnDictCodeConst.SD_SU_APPLY.equals(orderAptrans[0].getSd_su_trans())) {
			throw new BizException("医嘱状态发生改变，请刷新后重试！");
		}
	}
}
