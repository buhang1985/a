package iih.en.que.s.bp.pharm;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 药房是否需要分诊
 * @author yank
 *
 */
public class CheckPharmNeedTriageBP {
	/**
	 * 药房是否分诊
	 * @param pharmDepId 药房科室id
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String pharmDepId) throws BizException{
		EnValidator.validateParam("药房科室id", pharmDepId);
		
		GetPharmQueByDepBP getPharamQueBP = new GetPharmQueByDepBP();
		QueDO queDO = getPharamQueBP.exec(pharmDepId);		
		if(queDO==null){
			throw new BizException(IEnMsgConst.ERROR_PHARM_NO_QUE);
		}		
		//需要分诊
		if(IBdFcDictCodeConst.SD_MODEL_PHA_YES.equals(queDO.getSd_mode()) || IBdFcDictCodeConst.SD_MODEL_PHA_OTHER.equals(queDO.getSd_mode())){
			return FBoolean.TRUE;
		}
		
		return FBoolean.FALSE;
	}
}
