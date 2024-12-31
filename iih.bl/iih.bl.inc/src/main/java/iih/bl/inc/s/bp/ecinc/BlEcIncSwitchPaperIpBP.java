package iih.bl.inc.s.bp.ecinc;

import iih.bl.inc.blecincprint.d.BlEcSwithPaperInDTO;
import iih.bl.inc.blecincprint.d.BlEcSwithPaperOutDTO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincippaper.d.BlIncIpPaperDO;
import iih.bl.inc.blincippaper.i.IBlincippaperCudService;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import java.util.List;
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
 * 电子发票换开纸质发票(住院)
 * @author ly 2020/01/16
 *
 */
public class BlEcIncSwitchPaperIpBP {

	/**
	 * 电子发票换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public BlEcSwithPaperOutDTO exec(BlEcSwithPaperInDTO dto) throws BizException{
		
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlIncIpDO> list = (List<BlIncIpDO>)daf.findByAttrValString(BlIncIpDO.class, BlIncIpDO.ID_STIP, dto.getId_st(), null);
		BlIncIpDO incDO = list.get(0);
		@SuppressWarnings("unchecked")
		List<BlIncIpPaperDO> paperList = (List<BlIncIpPaperDO>)daf.findByAttrValString(BlIncIpPaperDO.class, BlIncIpPaperDO.ID_INCIP, incDO.getId_incip(), null);
		
		EcIncFacade incFacade = new EcIncFacade();
		BlEcSwithPaperOutDTO rlt = new BlEcSwithPaperOutDTO();
		if(!ListUtil.isEmpty(paperList)){
			EcIncPaperSwitchInDTO inDto = new EcIncPaperSwitchInDTO();
			inDto.setId_inc(list.get(0).getId_incip());
			inDto.setEcinc_code(list.get(0).getEc_inc_code());
			inDto.setEcincno(list.get(0).getIncno());
			inDto.setPinc_code(dto.getPinc_code());
			inDto.setPincno(dto.getPincno());
			
			EcIncResultDTO<EcIncPaperSwitchOutDTO> rltDto = incFacade.swichPaperInc(inDto);
			if(FBoolean.FALSE.equals(rltDto.getFg_success())){
				rlt.setErrormsg(rltDto.getErrormsg());
			}else{
				BlIncIpPaperDO paperDO = this.getActivePaperData(paperList);
				if(paperDO != null){
					paperDO.setFg_canc(FBoolean.TRUE);
					IBlincippaperCudService paperServive = ServiceFinder.find(IBlincippaperCudService.class);
					paperServive.update(new BlIncIpPaperDO[]{paperDO});
				}
				
				this.insertNewPaperDO(incDO, dto.getPinc_code(), dto.getPincno());
			}
		}else{
			EcIncPaperReSwitchInDTO inDto = new EcIncPaperReSwitchInDTO();
			
			inDto.setId_inc(list.get(0).getId_incip());
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
	private BlIncIpPaperDO getActivePaperData(List<BlIncIpPaperDO> paperList){
		
		if(ListUtil.isEmpty(paperList))
			return null;
		
		for (BlIncIpPaperDO blIncIpPaperDO : paperList) {
			if(FBoolean.FALSE.equals(blIncIpPaperDO.getFg_canc()))
				return blIncIpPaperDO;
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
	private void insertNewPaperDO(BlIncIpDO incDO, String pinc_code, String pincno) throws BizException {
		
		BlIncIpPaperDO paperDO = new BlIncIpPaperDO();
		paperDO.setId_incip(incDO.getId_incip());
		paperDO.setId_grp(Context.get().getGroupId());
		paperDO.setId_org(Context.get().getOrgId());
		paperDO.setId_pat(incDO.getId_pat());
		//paperDO.setId_ent(incDO.getid_ent);
		paperDO.setId_entp(incDO.getId_enttp());
		paperDO.setCode_entp(incDO.getCode_enttp());
//		paperDO.setId_incca(incDO.getId_incca());
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
		paperDO.setId_stip(incDO.getId_stip());
		paperDO.setStatus(DOStatus.NEW);
		
		IBlincippaperCudService paperServive = ServiceFinder.find(IBlincippaperCudService.class);
		paperServive.insert(new BlIncIpPaperDO[]{paperDO});
	}
}
