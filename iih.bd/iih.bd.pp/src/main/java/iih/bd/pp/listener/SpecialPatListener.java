package iih.bd.pp.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.event.pub.IBdPpEventCodeConst;
import iih.bd.pp.listener.d.BdSpecialPatDTO;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDiDO;
import iih.bl.hp.blhppatspec.d.BlhppatspecAggDO;
import iih.bl.hp.blhppatspec.i.IBlhppatspecCudService;
import iih.bl.hp.blhppatspec.i.IBlhppatspecRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
/**
 * MS092特殊病患者标识字典
 * */
public class SpecialPatListener implements IBusinessListener {

	@Override
	@SuppressWarnings("unchecked")
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(event.getSourceID().equals(IBdPpEventCodeConst.EVENT_BD_PP_SPC)))return;
		
		FArrayList2 bizUserObj = (FArrayList2) event.getUserObject();
		
		if(bizUserObj == null || bizUserObj.size() ==0) return;
		BdSpecialPatDTO[] list = (BdSpecialPatDTO[]) bizUserObj.toArray(new BdSpecialPatDTO[]{});
		this.saveSpecialPatInfo(list);
	}
	
	public void saveSpecialPatInfo(BdSpecialPatDTO[] list) throws BizException{
		Map<String,BlhppatspecAggDO> map = new HashMap<String,BlhppatspecAggDO>();
		IBlhppatspecRService rService = ServiceFinder.find(IBlhppatspecRService.class);
		BlhppatspecAggDO[] aggDOArr = rService.find(" 1=1 ", null, FBoolean.FALSE);
		for(BlhppatspecAggDO aggDO : aggDOArr){
			map.put(aggDO.getParentDO().getNo_hp(), aggDO);
		}
		for(BdSpecialPatDTO specialDTO : list){
			if("insert".equals(specialDTO.getAction())){
				//增加判断患者是否存在，如果存在则不再插入 by lim 2017-08-01
				if("insert".equals(specialDTO.getAction())){
					String hp_pat = specialDTO.getInsuranceno();
					String[] pat = {"no_hp"};
					List<BlHpPatSpecDO> patDoList = (List<BlHpPatSpecDO>)new DAFacade().findByCond(BlHpPatSpecDO.class, "no_hp = '"+hp_pat+"' ","no_hp", pat);  
					
					if(patDoList.size() > 0)
					{
						continue;
					}
				}
				BlHpPatSpecDiDO specDiDO = new BlHpPatSpecDiDO();
				specDiDO.setCode_di(specialDTO.getCode_diagnos());
				specDiDO.setName_di(specialDTO.getName_diagnos());
				specDiDO.setDt_b(specialDTO.getDt_eff());
				specDiDO.setDt_e(specialDTO.getDt_end());
				specDiDO.setStatus(DOStatus.NEW);
	
				
				if(map.get(specialDTO.getInsuranceno()) == null){
					BlhppatspecAggDO aggDO = new BlhppatspecAggDO();
					BlHpPatSpecDO patDO = new BlHpPatSpecDO();
					patDO.setName_pat(specialDTO.getName_pat());
					patDO.setNo_hp(specialDTO.getInsuranceno());
					patDO.setTel_pat(specialDTO.getPhonenumber());
					patDO.setStatus(DOStatus.NEW);
					patDO.setId_grp(Context.get().getGroupId());
					patDO.setId_org(Context.get().getOrgId());
					
					aggDO.setParentDO(patDO);
					aggDO.setBlHpPatSpecDiDO(new BlHpPatSpecDiDO[]{specDiDO});
					
					map.put(specialDTO.getInsuranceno(), aggDO);
				}else{
					BlhppatspecAggDO aggDO = map.get(specialDTO.getInsuranceno());
					ArrayUtils.add(aggDO.getBlHpPatSpecDiDO(), specDiDO);
//					List<BlHpPatSpecDiDO> speclist = Arrays.asList(aggDO.getBlHpPatSpecDiDO());
//					speclist.add(specDiDO);
//					aggDO.setBlHpPatSpecDiDO(speclist.toArray(new BlHpPatSpecDiDO[]{}));
					aggDO.getParentDO().setStatus(DOStatus.UPDATED);
				}
			}else if("update".equals(specialDTO.getAction())){
				String[] pat_hpno = {"no_hp"};
				List<BlHpPatSpecDO> patDoList = (List<BlHpPatSpecDO>)new DAFacade().findByCond(BlHpPatSpecDO.class, "no_hp = '"+specialDTO.getInsuranceno()+"' ","no_hp", pat_hpno);  
				
				if(patDoList.size() > 0)
				{
					BlhppatspecAggDO aggDO=map.get(specialDTO.getInsuranceno());
					if(aggDO ==null) 
					{
						continue;
					}
					BlHpPatSpecDiDO[] specDiDO = aggDO.getBlHpPatSpecDiDO();
					for(BlHpPatSpecDiDO specDO : specDiDO){
						if(specDO.getId_hppatspec().equals(patDoList.get(0).getId_hppatspec())){
							specDO.setCode_di(specialDTO.getCode_diagnos());
							specDO.setName_di(specialDTO.getName_diagnos());
							specDO.setDt_b(specialDTO.getDt_eff());
							specDO.setDt_e(specialDTO.getDt_end());		
							specDO.setStatus(DOStatus.UPDATED);
						}
					}
					

					
					if(map.get(specialDTO.getInsuranceno()) == null){
					//	BlhppatspecAggDO aggDO = new BlhppatspecAggDO();
						BlHpPatSpecDO patDO = new BlHpPatSpecDO();
						patDO.setName_pat(specialDTO.getName_pat());
						patDO.setNo_hp(specialDTO.getInsuranceno());
						patDO.setTel_pat(specialDTO.getPhonenumber());
						patDO.setStatus(DOStatus.NEW);
						patDO.setId_grp(Context.get().getGroupId());
						patDO.setId_org(Context.get().getOrgId());
						aggDO.setParentDO(patDO);
						specDiDO[0].setStatus(DOStatus.NEW);
						
						aggDO.setBlHpPatSpecDiDO(new BlHpPatSpecDiDO[]{specDiDO[0]});
						
						map.put(specialDTO.getInsuranceno(), aggDO);
					}else{			
						//BlhppatspecAggDO aggDO = map.get(specialDTO.getInsuranceno());
						aggDO = map.get(specialDTO.getInsuranceno());
						aggDO.getParentDO().setTel_pat(specialDTO.getPhonenumber());
						aggDO.getParentDO().setStatus(DOStatus.UPDATED);						
					}					
				}else{
					continue;
				}
			}else if("delete".equals(specialDTO.getAction())){
				if(map.get(specialDTO.getInsuranceno()) == null) continue;
				BlhppatspecAggDO aggDO = map.get(specialDTO.getInsuranceno());
				BlHpPatSpecDiDO[] specArr = aggDO.getBlHpPatSpecDiDO();
				Integer dlCount = 0;
				for(BlHpPatSpecDiDO specDO : specArr){
					if(specDO.getCode_di().equals(specialDTO.getCode_diagnos())){
						dlCount++;
						specDO.setStatus(DOStatus.DELETED);
					}
				}
				if(dlCount == 0){
					continue;
				}
				if(dlCount > 0 && dlCount == specArr.length){
					aggDO.getParentDO().setStatus(DOStatus.DELETED);
				}else if(dlCount > 0 && dlCount < specArr.length){
					aggDO.getParentDO().setStatus(DOStatus.UPDATED);
				}
			}
		}
		List<BlhppatspecAggDO> aggDOList = new ArrayList<BlhppatspecAggDO>();
		for(BlhppatspecAggDO aggDO : map.values()){
			if(aggDO.getParentDO().getStatus() > 0){
				aggDOList.add(aggDO);
			}
		}			
		IBlhppatspecCudService service = ServiceFinder.find(IBlhppatspecCudService.class);

		BlhppatspecAggDO[] retdos = service.save(aggDOList.toArray(new BlhppatspecAggDO[]{}));		
	}

}
