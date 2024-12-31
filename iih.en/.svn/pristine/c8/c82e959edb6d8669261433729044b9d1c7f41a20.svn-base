package iih.en.que.s.bp.op;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.s.listener.bp.SendBrdMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 医生站点强制下屏
 * @author fanlq
 *
 */
public class SetBrdOfflineBP {
	/****
	 * 医生站点强制下屏
	 * @throws BizException 
	 */
	public FBoolean exec(EnBrdSiteDO brdSiteDO) throws BizException{
		if(brdSiteDO != null && !EnValidator.isEmpty(brdSiteDO.getCode())){
			IQuesiteRService service = ServiceFinder.find(IQuesiteRService.class);
			QueSiteDO[] queSiteDOs = service.find("code = '"+brdSiteDO.getCode()+"'", null, FBoolean.FALSE);
			if(queSiteDOs != null && queSiteDOs.length >0){
				QueSiteDO queSiteDO = queSiteDOs[0];
				if(queSiteDO != null && queSiteDO.getEu_pause()!=null){
						brdSiteDO.setCode(queSiteDO.getCode());
						brdSiteDO.setEu_status(BrdStatusEnum.DEL);
						brdSiteDO.setStatus(DOStatus.UPDATED);
						new SendBrdMsgBP().sendSiteMsg(new EnBrdSiteDO[]{brdSiteDO});
						return FBoolean.TRUE;
				}
				return FBoolean.FALSE;
			}
		}
		return FBoolean.FALSE;
	}
}
