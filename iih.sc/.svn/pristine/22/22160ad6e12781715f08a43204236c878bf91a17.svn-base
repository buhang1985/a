package iih.sc.sch.s.bp;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据排班id获取挂号资源
 * @author yank
 *
 */
public class BatchGetRegResBySchBP {
	/**
	 * 根据排班id获取挂号资源
	 * @param schId 排班id
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegResDTO[] exec(String[] schIds,FBoolean withPri) throws BizException{
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(ScCollectionUtils.arrayToList(schIds));
		GetResBySchmBP getBySchmBP = new GetResBySchmBP(); 
		RegResDTO[] regResArray = getBySchmBP.exec(qryScheme);
		if(ArrayUtils.isNotEmpty(regResArray)){
			LoadResPriceBP loadPriceBP = new LoadResPriceBP();
			loadPriceBP.exec(regResArray);
			return regResArray;
		}
		return null;
	}
	
	/**
	 * 根据排班id获取挂号资源
	 * fanlq-2017-09-25
	 * @param schId
	 *            排班id
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegResDTO[] exec4CancReg(String patId,String[] schIds, FBoolean withPri) throws BizException {
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(ScCollectionUtils.arrayToList(schIds));
		GetResBySch4CancReg getBySch4CancRegBP = new GetResBySch4CancReg();
		RegResDTO[] regResArray = getBySch4CancRegBP.exec(patId,qryScheme);
		if (ArrayUtils.isNotEmpty(regResArray) && FBoolean.TRUE.equals(withPri)) {
			LoadResPriceBP loadPriceBP = new LoadResPriceBP();
			loadPriceBP.exec(regResArray);
		}
		return regResArray;
	}
}
