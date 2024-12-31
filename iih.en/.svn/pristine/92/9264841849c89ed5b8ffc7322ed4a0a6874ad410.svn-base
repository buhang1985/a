package iih.en.er.bp.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErPreInfoDTO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;

/**
 * 就诊记录校验患者
 * 
 */
public class CheckValidPatBP{
	/**
	 *  就诊记录校验患者
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public void exec(EnErPreInfoDTO dto) throws BizException {
		ErPreEP erPreEp = new ErPreEP();
		EnErPreDO enerpredo = erPreEp.findById(dto.getId_erpre());
		if(EnValidator.isEmpty(enerpredo)){
			return;
		}
		FDateTime nowTime = EnAppUtils.getServerDateTime();
		OpEP opEp = new OpEP();
		OutpatientDO op = opEp.getOpByEntId(dto.getId_ent());
		if (EnValidator.isEmpty(op))
			return;
		op.setStatus(DOStatus.UPDATED);
		//如果是就诊记录最后一条
		if(dto.getId_ent().equals(enerpredo.getId_ent_last())){
			//如果是非"离院"状况
			if(!IEnDictCodeConst.SD_STATUS_ERPRE_END.equals(enerpredo.getSd_status())){
				//如果在有效期
				if(nowTime.compareTo(dto.getDt_valid_b())>0 && nowTime.compareTo(dto.getDt_valid_e())<0){
					op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
				}else{//不在有效期
					op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
				}
			}
		}else{
			op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		}
		opEp.save(op);
	}
}