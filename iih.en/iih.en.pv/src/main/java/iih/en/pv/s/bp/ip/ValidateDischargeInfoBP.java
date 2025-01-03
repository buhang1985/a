package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.NbEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.s.bp.ip.qry.GetDisChargeBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消登记校验
 * @author Sarah
 *
 */
public class ValidateDischargeInfoBP {

	/**
	 * 校验退院状态
	 * @param dischargeDTO
	 * @throws BizException
	 */
	public void exec(DischargeDTO dischargeDTO) throws BizException{
		if(dischargeDTO==null || EnValidator.isEmpty(dischargeDTO.getId_ent() ))
			throw new BizException("该患者不存在");		
		this.validateNB(dischargeDTO.getId_ent());
		this.validateInpatientDO(dischargeDTO);
	}
	
	/**
	 * 校验患者是否存在新生儿
	 * @param entId
	 * @throws BizException
	 */
	private void validateNB(String entId) throws BizException{
		NbEP nbep = new NbEP();
		NewbornDO[] nbs =  nbep.getNbListByMomEnt(entId);
		if(!EnValidator.isEmpty(nbs))
			throw  new BizException("患者已有新生儿，不能退院");
	}
	/**
	 * 校验住院数据
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private InpatientDO validateInpatientDO(DischargeDTO dischargeDTO) throws BizException {
		// 入科校验
		IInpatientRService ipRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO inpatientDO = null;
		if (EnValidator.isEmpty(dischargeDTO.getId_ent())) {
			return null;
		}
		String whereStr = InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '" + dischargeDTO.getId_ent() + "'";
		InpatientDO[] inpatientDOs = ipRService.find(whereStr, null, FBoolean.FALSE);
		if (EnValidator.isEmpty(inpatientDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		inpatientDO = inpatientDOs[0];
		int cancAptTp = EnParamUtils.getNeedCancAptForCancIp();
		if(1==cancAptTp){
			if(inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)){
				throw  new BizException("请先取消入科再退院");
			}
			if (!inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN)) {
				throw  new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
			}
		}else{
			if (!inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN) && !inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
				throw  new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
			}
		}
		String erroMsg = "";
		if(!FDouble.ZERO_DBL.equals(dischargeDTO.getAmt_prepay())){
			erroMsg += "预交金不为0;";
		}
		GetDisChargeBP checkBp = new GetDisChargeBP();
		if(GetDisChargeBP.HAS_VALUE.equals(checkBp.checkConsume(dischargeDTO.getId_ent())))
			erroMsg += GetDisChargeBP.HAS_VALUE +";";
		String erro_or = checkBp.checkOR(dischargeDTO.getId_ent());
		if(!EnValidator.isEmpty(erro_or))
			erroMsg += erro_or+";";
		if(!EnValidator.isEmpty(erroMsg)){
			throw  new BizException(erroMsg);
		}
		return inpatientDO;
	}
}
