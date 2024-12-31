package iih.mi.verify.i;

import iih.mi.biz.dto.verify.d.VerifyInputDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 智能审核-医保接口
 * @author hanjq 2019-03-29
 *
 */
public interface IMIVerifyRService {

	/**
	 * 获取就诊审核信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author hanjq 2019年4月9日
	 */
	public abstract VerifyInputDTO getEntVerifyInput(String id_ent) throws BizException;
	
	/**
	 * 获取门诊审核信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author hanjq 2019年4月9日
	 */
	public abstract VerifyInputDTO getOepVerifyInput(FArrayList id_ors ,String id_ent) throws BizException;
	
	/**
	 * 获取住院审核信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author hanjq 2019年4月9日
	 */
	public abstract VerifyInputDTO getIpVerifyInput(FArrayList id_ors ,String id_ent) throws BizException;
}
