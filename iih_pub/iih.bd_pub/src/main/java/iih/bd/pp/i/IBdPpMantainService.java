package iih.bd.pp.i;

import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppricnstdto.d.SampPricnstDTO;
import xap.mw.core.data.BizException;

public interface IBdPpMantainService {

	/**
	 * 标本费用对照，标本费用及明细保存
	 * 
	 * @throws BizException
	 */
	public abstract void saveSamppri(SampPriDO sampPriDO, BdSampPriItmDO bdSampPriItmDO) throws BizException;

	/**
	 * 
	* @Title: saveSamppricnst 
	* @Description: 儿童采集费用对照保存
	* @date 2019年6月12日 上午10:57:11 
	* @param @param dto
	* @param @throws BizException 设定文件 
	* @return void 返回类型 
	* @throws
	 */
	public abstract void saveSamppricnst(SampPricnstDTO[] inParams) throws BizException;
}
