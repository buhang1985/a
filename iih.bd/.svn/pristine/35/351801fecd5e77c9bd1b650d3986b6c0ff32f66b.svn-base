package iih.bd.mm.certi.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.mm.certi.d.CertificationDO;
import iih.bd.mm.certi.i.ICertiRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CertiCuAfterBp {
	
	public void exec(CertificationDO[] certiCationDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(certiCationDOS);
		
		// ■ 编码唯一性验证
		this.checkCodeOnly(certiCationDOS);
	}

	private void validaPara(CertificationDO[] certiCationDOS) throws BizException {
		
		if(certiCationDOS == null || certiCationDOS.length <= 0) {
			
			throw new BizException("传入物品资质证书字典为空。");
		}
	}
	
	private void checkCodeOnly(CertificationDO[] certiCationDOS) throws BizException {
		
		ICertiRService certiRSrv = ServiceFinder.find(ICertiRService.class);
		
		Map<String, CertificationDO> certiMap = new HashMap<String, CertificationDO>();
		CertificationDO[] result = certiRSrv.find("1=1", "", FBoolean.TRUE);
		for(CertificationDO certiCationDO : result) {
			
			if(certiMap.containsKey(certiCationDO.getCode())) {
				
				throw new BizException(String.format("编码【%s】重复。", certiCationDO.getCode()));
			}
			certiMap.put(certiCationDO.getCode(), certiCationDO);
		}
	}
}
