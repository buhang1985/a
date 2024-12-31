package iih.bl.cg.i;

import iih.bl.cg.dto.d.BlNurSubsidyErrorReturnDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
* @ClassName: BlEtCgCmdService  
* @Description: 费用急诊记账命令服务 
* @author xy.zhou
* @date 2019年3月14日
 */
public interface IBlEtCgCmdService {

	/**
	 * 
	* @Title: doEtRefundFeeSubmit  
	* @Description: 留观（病区）退费确认
	* @param @param dtoArr
	* @throws BizException  
    * @author xy.zhou
	* @return FBoolean 
	* @throws
	 */
	public FBoolean doEtRefundFeeSubmit(NurseCompFeeItmDTO[] dtoArr) throws BizException;
	
	/**
	 * 
	* @Title: doEtCompensationSubmit  
	* @Description: 留观（病区）补费确认 
	* @param  dtoArr
	* @param list_id_ent
	* @throws BizException  
	* @author xy.zhou
	* @return BlNurSubsidyErrorReturnDTO[] 
	* @throws
	 */
	public BlNurSubsidyErrorReturnDTO[] doEtCompensationSubmit(NurseCompFeeItmDTO[] dtoArr,String[] list_id_ent) throws BizException;
}
