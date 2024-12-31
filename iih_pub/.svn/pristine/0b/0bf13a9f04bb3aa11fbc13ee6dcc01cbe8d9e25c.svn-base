package iih.bd.srv.empphydto.i;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import xap.mw.core.data.BizException;

/**
 * 医师属性DTOCUD服务
 * 
 * @author guoyang
 *
 */
public interface IEmpPhyDtoCudService {

	/**
	 * 医生处方权限授权
	 * 
	 * @param empphyDtos
	 * @throws BizException
	 */
	public void Authorize(EmpphyDTO[] empphyDtos) throws BizException;

	/**
	 * 医生处方权限取消授权
	 * 
	 * @param empphyDtos
	 * @throws BizException
	 */
	public void CancleAuthorize(EmpphyDTO[] empphyDtos) throws BizException;

	/**
	 * 保存医生信息</br>
	 * 只保存医师医保编码
	 * 
	 * @author hao_wu
	 * @date 2020-3-13
	 * 
	 * @param empPhyDTO
	 * @return
	 * @throws BizException
	 */
	public EmpphyDTO saveEmpPhyDto(EmpphyDTO empPhyDTO) throws BizException;
}
