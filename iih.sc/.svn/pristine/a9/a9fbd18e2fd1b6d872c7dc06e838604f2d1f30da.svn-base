package iih.sc.sch.s.bp;

import org.apache.commons.lang3.ArrayUtils;

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
public class GetRegResBySchBP {
	/**
	 * 根据排班id获取挂号资源
	 * @param schId 排班id
	 * @param withPri 是否包含价格
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegResDTO exec(String schId,FBoolean withPri) throws BizException{
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(ScCollectionUtils.arrayToList(new String[]{schId}));
		GetResBySchmBP getBySchmBP = new GetResBySchmBP(); 
		RegResDTO[] regResArray = getBySchmBP.exec(qryScheme);
		if(ArrayUtils.isNotEmpty(regResArray)){
			LoadResPriceBP loadPriceBP = new LoadResPriceBP();
			loadPriceBP.exec(regResArray);
			return regResArray[0];
		}
		return null;
	}
	
	/**
	 * 根据排班id获取挂号资源
	 *  fanlq-2017-09-25
	 * @param schId
	 *            排班id
	 * @param withPri
	 *            是否包含价格
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegResDTO exec4Apt(String aptId, FBoolean withPri) throws BizException {
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(ScCollectionUtils.arrayToList(new String[] { aptId }));
		GetResBySchOralBP getBySchOralBP = new GetResBySchOralBP();
		RegResDTO[] regResArray = getBySchOralBP.exec(qryScheme);
		if (ArrayUtils.isNotEmpty(regResArray)) {
			LoadResPriceBP loadPriceBP = new LoadResPriceBP();
			loadPriceBP.exec(regResArray);
			return regResArray[0];
		}
		return null;
	}
}
