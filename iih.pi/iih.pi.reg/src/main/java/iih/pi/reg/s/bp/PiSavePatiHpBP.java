package iih.pi.reg.s.bp;

import iih.pi.reg.d.PiPatHpDTO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPiPatHpDOCudService;
import iih.pi.reg.pat.i.IPiPatHpDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保保存类
 * @author ly
 *
 */
public class PiSavePatiHpBP {

	/**
	 * 医保保存处理
	 * 主医保和辅助医保同时登录
	 * @param piPatHpDto 医保数据
	 * @throws BizException
	 */
	public void exec(PiPatHpDTO piPatHpDto) throws BizException {
		
		//没有主医保，也肯定没有辅医保，辅医保依附主医保存在
		if(StringUtil.isEmpty(piPatHpDto.getId_prim_hp())){
			return;
		}
		
		//医保号重复校验 TODO
		
		IPiPatHpDORService patHPRService = ServiceFinder.find(IPiPatHpDORService.class);
		String whereStr = String.format("id_pat='%s'", piPatHpDto.getId_pat());
		PiPatHpDO[] piPatHpDOs = patHPRService.find(whereStr, null, FBoolean.TRUE);		
	
		PiPatHpDO mainHpDO = null;
		PiPatHpDO extraHpDO = null;
		int sortNo = -1;
		FBoolean hasMaj = FBoolean.FALSE;//是否含有主医保
		List<PiPatHpDO> saveList = new ArrayList<PiPatHpDO>();
		if(!ArrayUtil.isEmpty(piPatHpDOs)){
			for (PiPatHpDO piPatHpDO : piPatHpDOs) {
				if(piPatHpDO.getFg_deft()!=null && piPatHpDO.getFg_deft().booleanValue()){
					hasMaj = FBoolean.TRUE;
				}
				if(piPatHpDto.getId_prim_hp().equals(piPatHpDO.getId_hp())){
					mainHpDO = piPatHpDO;
					mainHpDO.setNo_hp(piPatHpDto.getCode_prim_hp());
					saveList.add(mainHpDO);
				}else if(!StringUtil.isEmpty(piPatHpDto.getId_auxi_hp()) 
						&& piPatHpDto.getId_auxi_hp().equals(piPatHpDO.getId_hp())){
					extraHpDO = piPatHpDO;
					extraHpDO.setNo_hp(piPatHpDto.getCode_auxi_hp());
					saveList.add(extraHpDO);
				}
				if(piPatHpDO.getSortno()==null){
					sortNo =0;
				}
				else if(sortNo < piPatHpDO.getSortno()){
					sortNo = piPatHpDO.getSortno();
				}
			}
		}
		
		// 没有找到，则新建主医保
		if(mainHpDO == null){
			mainHpDO = new PiPatHpDO();
			mainHpDO.setStatus(DOStatus.NEW);
			mainHpDO.setId_pat(piPatHpDto.getId_pat()); //患者ID
			mainHpDO.setSortno(++sortNo); //序号
			mainHpDO.setId_hp(piPatHpDto.getId_prim_hp()); //医保计划
			mainHpDO.setNo_hp(piPatHpDto.getCode_prim_hp()); //医保号
			//没有主医保，则此就是主医保
			if(hasMaj.booleanValue()){
				mainHpDO.setFg_deft(FBoolean.FALSE); //默认标志
			}else{
				mainHpDO.setFg_deft(FBoolean.TRUE); 
			}
			mainHpDO.setDt_b(new FDateTime()); //有效日期开始
			mainHpDO.setFg_act(new FBoolean(true)); //启用标志
			saveList.add(mainHpDO);
		}	
		
		// 新建辅助医保
		if(!StringUtil.isEmpty(piPatHpDto.getId_auxi_hp()) && extraHpDO == null){
			extraHpDO = new PiPatHpDO();
			extraHpDO.setStatus(DOStatus.NEW);
			extraHpDO.setId_pat(piPatHpDto.getId_pat()); //患者ID
			extraHpDO.setSortno(++sortNo); //序号
			extraHpDO.setId_hp(piPatHpDto.getId_auxi_hp()); //医保计划
			extraHpDO.setNo_hp(piPatHpDto.getCode_auxi_hp()); //医保号
			extraHpDO.setFg_deft(FBoolean.FALSE); //默认标志
			extraHpDO.setDt_b(new FDateTime()); //有效日期开始
			extraHpDO.setFg_act(FBoolean.TRUE); //启用标志
			saveList.add(extraHpDO);
		}
		
		if(saveList.size() > 0){			
			IPiPatHpDOCudService patHPCrudService = ServiceFinder.find(IPiPatHpDOCudService.class);
			patHPCrudService.save(saveList.toArray(new PiPatHpDO[saveList.size()]));
		}
	}
}
