package iih.ci.rcm.i;

import iih.ci.rcm.contagion.dto.d.EntDto;
import xap.mw.core.data.BizException;

/**
 * 传染病既往已报相关接口
 * 〈功能详细描述〉
 * @author    [任亚平]
 * @version   [1.0, 2018-04-26]
 */
public interface ICiRcmConPassService {

	/**
	 * 当次就诊是否存在既往已报
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean hasCiRcmConPass(String id_ent) throws BizException;
	
	/**
	 * 门急诊医生站创建既往已报数据
	 * @param id_ent
	 * @return true 成功  false 失败
	 */
	public abstract Boolean newCiRcmConPass(String id_ent)  throws BizException;
	
	/**
	 * 修改既往已报数据状态
	 * @param id_ent
	 * @param id_status
	 * @param sd_status
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean updateCiRcmConPass(String id_mr_con_pa,String id_status,String sd_status) throws BizException;
	
	/**
	 * 审核通过既往已报数据
	 * @param entDto
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean submitCiRcmConPass(EntDto entDto) throws BizException;
	
	/**
	 * 驳回既往已报数据
	 * @param entDto
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean rejectCiRcmConPass(EntDto entDto,String reason) throws BizException;
}
