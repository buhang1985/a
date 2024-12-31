package iih.en.pv.s;

import iih.en.pv.dto.d.MedTechTransDTO;
import iih.en.pv.i.IEnMtCmdService;
import iih.en.pv.s.bp.mt.MtTransInBP;
import iih.en.pv.s.bp.mt.MtTransOutBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医技持久化服务
 * @author yank,renying
 *
 */
@Service(serviceInterfaces={IEnMtCmdService.class}, binding=Binding.JSONRPC)
public class EnMtCmdServiceImpl implements IEnMtCmdService {
	/**
	 * 构造函数
	 */
	public EnMtCmdServiceImpl(){}
	/**
	 * 医技转入
	 * @param dto 医技转入DTO
	 * @throws BizException
	 */
	@Override
	public void transIn(MedTechTransDTO dto) throws BizException{
		MtTransInBP transInBP = new MtTransInBP();
		transInBP.exec(dto);
	}
	/**
	 * 医技转出
	 * @param dto 医技转入DTO
	 * @throws BizException
	 */
	@Override
	public void transOut(MedTechTransDTO dto) throws BizException{
		MtTransOutBP mtTransBP = new MtTransOutBP();
		mtTransBP.exec(dto);
	}
}
