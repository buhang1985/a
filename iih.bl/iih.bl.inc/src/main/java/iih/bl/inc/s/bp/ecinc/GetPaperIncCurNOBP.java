package iih.bl.inc.s.bp.ecinc;

import java.util.List;

import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoInDTO;
import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoOutDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeInDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;

/**
 * 
 * 获取电子票当前纸质票当前号
 * @author ly 2020/01/06
 *
 */
public class GetPaperIncCurNOBP {
	
	/**
	 * 获取电子票当前纸质票当前号
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public BlEcIncCurPIncnoOutDTO exec(BlEcIncCurPIncnoInDTO dto) throws BizException{
	    	
		BlEcIncCurPIncnoOutDTO rtnDto = new BlEcIncCurPIncnoOutDTO();
		
		try {
			EcIncFacade incFacade = new EcIncFacade();
			EcIncManagePaperIncCodeInDTO mInDto = new EcIncManagePaperIncCodeInDTO();
			mInDto.setSd_incca(dto.getSd_incca());
			EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> mRlt = incFacade.getPaperActiveIncCode(mInDto);
			if(FBoolean.FALSE.equals(mRlt.getFg_success())){
				rtnDto.setErrormsg(mRlt.getErrormsg());
				return rtnDto;
			}
			
			List<EcIncManagePaperIncCodeOutDTO> pIncCodeList = mRlt.getData();
			if(ListUtil.isEmpty(pIncCodeList)){
				rtnDto.setErrormsg("未查询到纸质票据段代码");
				return rtnDto;
			}
			
			String incCode = pIncCodeList.get(0).getEcinc_code();
			
			EcIncPaperCurIncNoInDTO pInDto = new EcIncPaperCurIncNoInDTO();
			pInDto.setPinc_code(incCode);
			
			EcIncResultDTO<EcIncPaperCurIncNoOutDTO> pRlt = incFacade.getCurIncNo(pInDto);
			if(FBoolean.FALSE.equals(pRlt.getFg_success())){
				rtnDto.setErrormsg(pRlt.getErrormsg());
				return rtnDto;
			}
			
			EcIncPaperCurIncNoOutDTO curIncnoDto = pRlt.getData();
			if(curIncnoDto != null){
				rtnDto.setPinc_code(curIncnoDto.getPinc_code());
				rtnDto.setPincno(curIncnoDto.getPincno());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			rtnDto.setErrormsg(e.getMessage());
		}
		
		return rtnDto;
	}
}
