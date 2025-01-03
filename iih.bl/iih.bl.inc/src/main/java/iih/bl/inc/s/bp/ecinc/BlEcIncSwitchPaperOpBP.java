package iih.bl.inc.s.bp.ecinc;

import java.util.List;

import iih.bl.inc.blecincprint.d.BlEcSwithPaperInDTO;
import iih.bl.inc.blecincprint.d.BlEcSwithPaperOutDTO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperCudService;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * 电子发票换开纸质发票(门诊)
 * @author ly 2020/01/16
 *
 */
public class BlEcIncSwitchPaperOpBP {

	/**
	 * 电子发票换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlEcSwithPaperOutDTO exec(BlEcSwithPaperInDTO dto) throws BizException{
		
		DAFacade daf = new DAFacade();
		List<BlIncOepDO> list = (List<BlIncOepDO>)daf.findByAttrValString(BlIncOepDO.class, BlIncOepDO.ID_STOEP, dto.getId_st(), null);
		BlIncOepDO incDO = list.get(0);
		List<BlIncOepPaperDO> paperList = (List<BlIncOepPaperDO>)daf.findByAttrValString(BlIncOepPaperDO.class, BlIncOepPaperDO.ID_INCOEP, incDO.getId_incoep(), null);
		
		EcIncFacade incFacade = new EcIncFacade();
		BlEcSwithPaperOutDTO rlt = new BlEcSwithPaperOutDTO();
		if(!ListUtil.isEmpty(paperList)){
			EcIncPaperSwitchInDTO inDto = new EcIncPaperSwitchInDTO();
			inDto.setId_inc(list.get(0).getId_incoep());
			inDto.setEcinc_code(list.get(0).getEc_inc_code());
			inDto.setEcincno(list.get(0).getIncno());
			inDto.setPinc_code(dto.getPinc_code());
			inDto.setPincno(dto.getPincno());
			
			EcIncResultDTO<EcIncPaperSwitchOutDTO> rltDto = incFacade.swichPaperInc(inDto);
			if(FBoolean.FALSE.equals(rltDto.getFg_success())){
				rlt.setErrormsg(rltDto.getErrormsg());
			}else{
				BlIncOepPaperDO paperDO = this.getActivePaperData(paperList);
				if(paperDO != null){
					paperDO.setFg_canc(FBoolean.TRUE);
					IBlincoeppaperCudService paperServive = ServiceFinder.find(IBlincoeppaperCudService.class);
					paperServive.update(new BlIncOepPaperDO[]{paperDO});
				}
				
				this.insertNewPaperDO(incDO, dto.getPinc_code(), dto.getPincno());
			}
		}else{
			EcIncPaperReSwitchInDTO inDto = new EcIncPaperReSwitchInDTO();
			
			inDto.setId_inc(list.get(0).getId_incoep());
			inDto.setEcinc_code(list.get(0).getEc_inc_code());
			inDto.setEcincno(list.get(0).getIncno());
			inDto.setPinc_code(dto.getPinc_code());
			inDto.setPincno(dto.getPincno());
			EcIncResultDTO<EcIncPaperReSwitchOutDTO> rltDto = incFacade.reSwichPaperInc(inDto);
			if(FBoolean.FALSE.equals(rltDto.getFg_success())){
				rlt.setErrormsg(rltDto.getErrormsg());
			}else{
				this.insertNewPaperDO(incDO, dto.getPinc_code(), dto.getPincno());
			}
		}
		rlt.setPinc_code(dto.getPinc_code());
		rlt.setPincno(dto.getPincno());
		return rlt;
	}
	
	/**
	 * 获取有效换开数据
	 * @param paperList
	 * @return
	 */
	private BlIncOepPaperDO getActivePaperData(List<BlIncOepPaperDO> paperList){
		
		if(ListUtil.isEmpty(paperList))
			return null;
		
		for (BlIncOepPaperDO blIncOepPaperDO : paperList) {
			if(FBoolean.FALSE.equals(blIncOepPaperDO.getFg_canc()))
				return blIncOepPaperDO;
		}
		
		return null;
	}

	/**
	 * 
	 * @param incDO
	 * @param pinc_code
	 * @param pincno
	 * @throws BizException
	 */
	private void insertNewPaperDO(BlIncOepDO incDO, String pinc_code, String pincno) throws BizException {
		
		BlIncOepPaperDO paperDO = new BlIncOepPaperDO();
		paperDO.setId_incoep(incDO.getId_incoep());
		paperDO.setId_grp(Context.get().getGroupId());
		paperDO.setId_org(Context.get().getOrgId());
		paperDO.setId_pat(incDO.getId_pat());
		//paperDO.setId_ent(incDO.getid_ent);
		paperDO.setId_entp(incDO.getId_enttp());
		paperDO.setCode_entp(incDO.getCode_enttp());
		paperDO.setId_incca(incDO.getId_incca());
		paperDO.setEu_direct(incDO.getEu_direct());
		paperDO.setEc_incno(incDO.getIncno());
		//paperDO.setCode_incpkg(Code_incpkg);
		paperDO.setInc_code(pinc_code);
		paperDO.setIncno(pincno);
		paperDO.setDt_inc(new FDateTime());
		paperDO.setId_emp_inc(Context.get().getStuffId());
		paperDO.setId_dep_inc(Context.get().getDeptId());
		paperDO.setTimes_prn(1);
		paperDO.setFg_canc(FBoolean.FALSE);
		paperDO.setId_stoep(incDO.getId_stoep());
		paperDO.setStatus(DOStatus.NEW);
		
		IBlincoeppaperCudService paperServive = ServiceFinder.find(IBlincoeppaperCudService.class);
		paperServive.insert(new BlIncOepPaperDO[]{paperDO});
	}
}
