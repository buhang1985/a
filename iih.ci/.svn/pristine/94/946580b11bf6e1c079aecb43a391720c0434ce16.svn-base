package iih.ci.pre.obspre.s;

import iih.ci.pre.dto.d.EmergPreDTO;
import iih.ci.pre.obspre.i.IObsPreExtService;
import iih.ci.pre.obspre.i.IObspreCudService;
import iih.ci.pre.obspre.i.IObspreRService;
import iih.ci.pre.obspre.s.bp.ObsPreBP;
import iih.en.pv.dto.d.OpRegDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 预检扩展服务
 * @author yankan
 *
 */
@Service(serviceInterfaces={IObsPreExtService.class}, binding=Binding.JSONRPC)
public class ObsPreExtServiceImpl implements IObsPreExtService {
	private ObsPreBP _obspreBP = new ObsPreBP();
	public ObsPreExtServiceImpl(){
		
		
	}
	
	/**
	 * 获取预检模板
	 * @param entpCode 就诊类型
	 * @param depId 科室id	 
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO getPreTpl(String entpCode,String depId) throws BizException{
		return this._obspreBP.getPreTpl(entpCode, depId);
	}
	/**
	 * 加载预检数据
	 * @param preDTO 预检模板
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO loadData(EmergPreDTO preDTO) throws BizException{
		return this._obspreBP.loadData(preDTO);
	}
	/**
	 * 获取预检信息
	 * @param OPRegDTO 就诊登记DTO
	 * @param entpCode 就诊类型
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO getPreDTO(OpRegDTO opRegDTO,String entpCode) throws BizException{
		return this._obspreBP.getPreDTO(opRegDTO, entpCode);
	}
	/**
	 * 保存预检信息
	 * @param preDTO
	 * @param entpCode 就诊类型
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO savePre(EmergPreDTO preDTO,String entpCode) throws BizException{
		return this._obspreBP.savePre(preDTO,entpCode);
	}
	
	
}
