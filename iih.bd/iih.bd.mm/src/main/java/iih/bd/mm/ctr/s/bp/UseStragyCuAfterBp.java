package iih.bd.mm.ctr.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.mm.ctr.d.MmUseStrategyDO;
import iih.bd.mm.ctr.i.IMmusestrategyRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UseStragyCuAfterBp {
	
	public void exec(MmUseStrategyDO[] useStrategyDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(useStrategyDOS);
		
		// ■ 部门+药品保持唯一性
		this.checkDataOnly(useStrategyDOS);
	}

	private void validaPara(MmUseStrategyDO[] useStrategyDOS) throws BizException {
		
		if(useStrategyDOS == null || useStrategyDOS.length <= 0) {
			
			throw new BizException("传入物品使用策略数据为空。");
		}
	}
	
	private void checkDataOnly(MmUseStrategyDO[] useStrategyDOS) throws BizException {
		
		IMmusestrategyRService useStrategyRsrv = ServiceFinder.find(IMmusestrategyRService.class);
		
		Map<String, MmUseStrategyDO> useStramap = new HashMap<String, MmUseStrategyDO>();
		MmUseStrategyDO[] result = useStrategyRsrv.find("1=1", "", FBoolean.TRUE);
		for(MmUseStrategyDO useStrategyDO : result) {
			
			String key = useStrategyDO.getId_dep() + " " + useStrategyDO.getId_mm();
			if(useStramap.containsKey(key)) {
				
				throw new BizException(String.format("部门【%s】下物品【%s】重复。", useStrategyDO.getDep_name(), useStrategyDO.getMm_name()));
			}
			useStramap.put(key, useStrategyDO);
		}
	}
}
