package iih.sc.sch.s.bp;

import org.apache.commons.lang3.ArrayUtils;

import iih.sc.comm.ScCollectionUtils;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据排班id和渠道ID，获取预约资源
 * @author yank
 *
 */
public class GetAptResBP {
	/**
	 * 根据排班id获取挂号资源
	 * @param schId 排班id
	 * @param withPri 是否加载价格
	 * @param chlId 渠道ID
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegResDTO exec(String schId,FBoolean withPri,String chlId) throws BizException{
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(ScCollectionUtils.arrayToList(new String[]{schId}));
		qryScheme.setId_scchl(chlId);
		qryScheme.setFg_reg(FBoolean.FALSE);
		qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
		GetResBySchmBP getBySchmBP = new GetResBySchmBP(); 
		RegResDTO[] regResArray = getBySchmBP.exec(qryScheme);
		if(ArrayUtils.isNotEmpty(regResArray)){
			LoadResPriceBP loadPriceBP = new LoadResPriceBP();
			loadPriceBP.exec(regResArray);
			return regResArray[0];
		}
		return null;
	}
}
