package iih.pi.reg.s.bp;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通过患者编码取得患者信息
 * @author ly
 *
 */
public class GetPatInfoByCodeFromEmpiBP {

	/**
	 * 通过患者编码取得患者信息
	 * 本地库不存在时，会通过empi取得患者信息并同步到本地库中
	 * @param code 患者编码（对应empi的患者id）
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(String code)throws BizException{
		
		if(StringUtil.isEmptyWithTrim(code))
			return null;
		
		//查询本地数据
		IPatiRService service = ServiceFinder.find(IPatiRService.class);
		PatiAggDO[] aggDos = service.find("a0.code = '" +code + "' ", "", FBoolean.FALSE);
		
		if(!ArrayUtil.isEmpty(aggDos)){
			
			PatiAggDO aggDo = null;
			for (PatiAggDO patiAggDO : aggDos) {
				PatDO patDo = patiAggDO.getParentDO();
				if(FBoolean.FALSE.equals(patDo.getFg_invd())){
					aggDo = patiAggDO;
					break;
				}
			}
			
			if(aggDo == null){
				throw new BizException("该患者编码查询到的患者已失效");
			}else{
				return aggDo;
			}
		}
		
		//同步empi数据
		PatiAggDO result = new SyncPatiInfoFromEmpiBP().exec(code);
		
		return result;
	}
}
