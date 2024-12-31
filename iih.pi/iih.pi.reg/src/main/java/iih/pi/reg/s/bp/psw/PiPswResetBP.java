package iih.pi.reg.s.bp.psw;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 修改患者密码逻辑类
 * @author ly 2017/06/29
 *
 */
public class PiPswResetBP {

	/**
	 * 重置患者密码
	 * @param patId 患者id
	 * @param pwd 密码
	 * @return 校验结果
	 * @throws BizException
	 */
	public void exec(String patId, String pwd) throws BizException{
		
		if(StringUtil.isEmpty(patId)){
			throw new BizException("患者密码重置服务：入参患者id为空");
		}
		
		IPatiRService rService = ServiceFinder.find(IPatiRService.class);
		IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
		
		PatiAggDO aggDo = rService.findById(patId);
		if(aggDo == null){
			throw new BizException("患者密码重置服务：未查询到患者信息");
		}
	
		PatDO patDo = aggDo.getParentDO();
		//String newPsw = PiPswUtil.createPassword(patDo, pwd);
		
		patDo.setStatus(DOStatus.UPDATED);
		patDo.setPassword(pwd);
		
		cudService.update(new PatiAggDO[]{aggDo});
	}
}
