package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp;

import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.qry.GetPatSpecilQry;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 校验特殊病诊断下是否存在非药品医嘱
 * @author LIM
 *
 */
public class MiCheckDiDependNoMedBP {
	/**
	 * 校验特殊病诊断下是否存在非药品医嘱
	 * @param id_ent 就诊id
	 * @param id_hp 医保计划id
	 * @param diIds 删除诊断id
	 * @param diIdsAll 剩余诊断id
	 * @return	
	 * @throws BizException
	 */
	public List<MiMcDiDependOutParamDTO> exec(String id_ent,String id_hp,String[] diIds,String[] idDisSur)throws BizException{
		FBoolean bExist=FBoolean.FALSE;
		List<MiMcDiDependOutParamDTO> diDtoList= new ArrayList<MiMcDiDependOutParamDTO>();
		//1.判断删除的诊断是否该患者特殊病诊断
		GetPatSpecilQry patSpecil = new GetPatSpecilQry();
		bExist=patSpecil.exec(id_ent,id_hp,diIds);		
		if(FBoolean.TRUE.equals(bExist)){
			//2.判断该患者剩余诊断是否存在特殊病诊断
			bExist=patSpecil.exec(id_ent,id_hp,idDisSur);
			if(FBoolean.FALSE.equals(bExist)){
				//3.判断该次就诊是否存在非药品医嘱 ci还没提供接口
				ICiOrdBlService cisrv= ServiceFinder.find(ICiOrdBlService.class);
				FBoolean bhave=cisrv.checkSpecialOrder(id_ent);
				if(FBoolean.TRUE.equals(bhave)){	
					MiMcDiDependOutParamDTO	diDto=new MiMcDiDependOutParamDTO();
					diDto.setFg_delete(FBoolean.FALSE);
					diDto.setDesc_dpndrsn("待删除的特殊病诊断下有特殊病医嘱,不能删除该诊断!");
					diDtoList.add(diDto);
				}
			}
		}
		return diDtoList;
	}
}
