package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.MainStateDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enclin.d.desc.EntStateDODesc;
import iih.en.pv.enclin.i.IEntstateRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取患者主要就诊状况
 * （包含病情、护理、营养）
 * @author renying
 *
 */
public class GetMainEntStateBP {
	/**
	 * 获取患者主要就诊状况
	 * （包含病情、护理、营养）
	 * @param entId 就诊ID
	 * @return 主要就诊状况DTO
	 * @throws BizException
	 */
	public MainStateDTO exec(String entId) throws BizException{
		if(EnValidator.isEmpty(entId))
			return null;
		MainStateDTO mainStateDTO = this.setEntState(entId);
		return mainStateDTO;
	}
	
	/**
	 * 查找就诊状态赋值
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private MainStateDTO setEntState(String entId) throws BizException{
		IEntstateRService rService = ServiceFinder.find(IEntstateRService.class);
		String whereStr = EntStateDODesc.TABLE_ALIAS_NAME+".id_ent = '" +entId+"' and "+
				EntStateDODesc.TABLE_ALIAS_NAME +".id_enstatetp in ('"+ IBdFcDictCodeConst.ID_ENSTSTATETP_FOOD
				+"' ,'"+IBdFcDictCodeConst.ID_ENSTSTATETP_DISE +"','"+IBdFcDictCodeConst.ID_ENSTSTATETP_NUR
				+"')";				
		EntStateDO[] enStateDOs = rService.find(whereStr, "", FBoolean.FALSE);
		if(EnValidator.isEmpty(enStateDOs ))
			return null;
		MainStateDTO mainStateDTO = new MainStateDTO();
		mainStateDTO.setId_ent(entId);
		setLevelSDandID(mainStateDTO);
		for (EntStateDO entState: enStateDOs ){
			if( IBdFcDictCodeConst.ID_ENSTSTATETP_FOOD.equals(entState.getId_enstatetp())){
				mainStateDTO.setName_level_nutr(entState.getName_enstatetp());		
				mainStateDTO.setVal_level_nutr(entState.getVal());				
			}
			if( IBdFcDictCodeConst.ID_ENSTSTATETP_DISE.equals(entState.getId_enstatetp())){
				mainStateDTO.setName_level_dise(entState.getName_enstatetp());
				mainStateDTO.setVal_level_dise(entState.getVal());	
			}
			if( IBdFcDictCodeConst.ID_ENSTSTATETP_NUR.equals(entState.getId_enstatetp())){
				mainStateDTO.setName_level_nur(entState.getName_enstatetp());
				mainStateDTO.setVal_level_nur(entState.getVal());
			}
		}
		this.setVal(mainStateDTO);
		return 	mainStateDTO;
	}
	
	/**
	 * 设置等级类型的sd和id
	 * @param mainStateDTO
	 */
	private void setLevelSDandID(MainStateDTO mainStateDTO)
	{
		mainStateDTO.setId_level_nutr(IBdFcDictCodeConst.ID_ENSTSTATETP_FOOD);
		mainStateDTO.setSd_level_nutr(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD);			
		mainStateDTO.setId_level_dise(IBdFcDictCodeConst.ID_ENSTSTATETP_DISE );
		mainStateDTO.setSd_level_dise(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE );		
		mainStateDTO.setId_level_nur(IBdFcDictCodeConst.ID_ENSTSTATETP_NUR);
		mainStateDTO.setSd_level_nur(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR);			
	}
	
	/**
	 * 给值赋值名称和id
	 * @param mainStateDTO
	 * @throws BizException
	 */
	private void setVal(MainStateDTO mainStateDTO) throws BizException{
		if(mainStateDTO == null)
			return;
		IEnstateRService service = ServiceFinder.find(IEnstateRService.class);			
		BdEnStateDO[] bdEnStateDOs = service.findByAttrValStrings(BdEnStateDO.ID_ENSTATETP, new String[]{IBdFcDictCodeConst.ID_ENSTSTATETP_FOOD,
				IBdFcDictCodeConst.ID_ENSTSTATETP_DISE, IBdFcDictCodeConst.ID_ENSTSTATETP_NUR});
		if(EnValidator.isEmpty(bdEnStateDOs))
			return;
		for(BdEnStateDO enStateDO : bdEnStateDOs){
			if(IBdFcDictCodeConst.ID_ENSTSTATETP_FOOD.equals(enStateDO.getId_enstatetp())
					&&!EnValidator.isEmpty(enStateDO.getVal()) && 
					enStateDO.getVal().equals(mainStateDTO.getVal_level_nutr())){
				mainStateDTO.setName_val_level_nutr(enStateDO.getName());
				mainStateDTO.setId_entstate_nutr(enStateDO.getId_enstate());
			}
			
			if(IBdFcDictCodeConst.ID_ENSTSTATETP_DISE.equals(enStateDO.getId_enstatetp())
					&&!EnValidator.isEmpty(mainStateDTO.getVal_level_dise()) && 
					enStateDO.getVal().equals(mainStateDTO.getVal_level_dise())){
				mainStateDTO.setName_val_level_dise(enStateDO.getName());
				mainStateDTO.setId_entstate_dise(enStateDO.getId_enstate());
			}
								
		   if(IBdFcDictCodeConst.ID_ENSTSTATETP_NUR.equals(enStateDO.getId_enstatetp())
				   &&!EnValidator.isEmpty(enStateDO.getVal()) && 
					enStateDO.getVal().equals(mainStateDTO.getVal_level_nur())){
				mainStateDTO.setName_val_level_nur(enStateDO.getName());
				mainStateDTO.setId_enstate_nur(enStateDO.getId_enstate());
		   }
		}
		
	}
}
