package iih.en.pv.s;

import iih.en.pv.dto.d.MedTechTransDTO;
import iih.en.pv.i.IEnMtQryService;
import iih.en.pv.s.bp.mt.qry.GetTransInAppBP;
import iih.en.pv.s.bp.mt.qry.GetTransOutAppBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医技查询服务
 * @author yank,renying
 *
 */
@Service(serviceInterfaces={IEnMtQryService.class}, binding=Binding.JSONRPC)
public class EnMtQryServiceImpl implements IEnMtQryService{	
	/**
	 * 构造函数
	 */
	public EnMtQryServiceImpl(){
	}
	/**
	 * 获取医技转入申请列表
	 * @param depId 科室ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedTechTransDTO[] getTransInApp(String depId) throws BizException{
		GetTransInAppBP getTransInApp = new GetTransInAppBP();
		return getTransInApp.getTransInApp(depId);
	}

	/**
	 * 获取医技转出申请列表
	 * @param depId 科室ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedTechTransDTO[] getTransOutApp(String depId) throws BizException {
		GetTransOutAppBP getBP = new GetTransOutAppBP();
		return getBP.exec(depId);
	}

}
