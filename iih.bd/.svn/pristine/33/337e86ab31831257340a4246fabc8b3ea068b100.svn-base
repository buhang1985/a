package iih.bd.mm.intelcabinet.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import iih.bd.mm.intelcabinet.i.IIntelcabinetRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IntelCabiCuAfterBp {
	
	public void exec(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(intelCabiDOS);
		
		// ■ 数据唯一性校验
		this.checkDataOnly(intelCabiDOS);
	}

	private void validaPara(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		if(intelCabiDOS == null || intelCabiDOS.length <= 0) {
			
			throw new BizException("传入智能柜数据为空。");
		}
	}
	
	private void checkDataOnly(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		IIntelcabinetRService intelRSrv = ServiceFinder.find(IIntelcabinetRService.class);
		
		Map<String, IntelCabinetDO> intelMap = new HashMap<String, IntelCabinetDO>();
		IntelCabinetDO[] result = intelRSrv.find("1=1", "", FBoolean.TRUE);
		
		for(IntelCabinetDO intelCabiDO : result) {
			
			//Mantis:0123011: 智能柜字典，新增界面，保存时，提示仓库【西药库】不允许有多个智能柜
//			if(intelCabiDO.getFg_wh().booleanValue()) {
//				
//				if(intelMap.containsKey(intelCabiDO.getId_wh())) {
//					
//					throw new BizException(String.format("仓库【%s】不允许有多个智能柜。", intelCabiDO.getWh_name()));
//				}
//				intelMap.put(intelCabiDO.getId_wh(), intelCabiDO);
//			}
//			
			String key_code = "CODE " + intelCabiDO.getSmc_code();
			String key_name = "NAME " + intelCabiDO.getSmc_name();
			if(intelMap.containsKey(key_code)) {
				
				throw new BizException(String.format("智能柜编码【%s】重复。", intelCabiDO.getSmc_code()));
			}
			
			if(intelMap.containsKey(key_name)) {
				
				throw new BizException(String.format("智能柜名称【%s】重复。", intelCabiDO.getSmc_name()));
			}
			
			intelMap.put(key_code, intelCabiDO);
			intelMap.put(key_name, intelCabiDO);
		}
	}
}
