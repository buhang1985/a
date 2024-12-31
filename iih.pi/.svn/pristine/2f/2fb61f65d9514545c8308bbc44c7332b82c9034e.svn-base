package iih.pi.reg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 还原患者卡
 * @author ly 2018/08/22
 *
 */
public class PiPatRestoreCardBP {

	/**
	 * 还原患者卡
	 * 用于发卡未收费的场景，把卡还原到空白状态
	 * @param patCardIds 患者卡id
	 * @throws BizException
	 * @author ly 2018/08/22 
	 */
	@SuppressWarnings("unchecked")
	public void exec(String[] patCardIds) throws BizException{
		
		if(ArrayUtil.isEmpty(patCardIds))
			return;
		
		DAFacade daf = new DAFacade();
		
		List<PiPatCardDO> patCardList = (List<PiPatCardDO>) daf.findByPKs(PiPatCardDO.class, patCardIds);
		
		if(ListUtil.isEmpty(patCardList))
			return;
		
		String patId = patCardList.get(0).getId_pat();
		List<String> cardIdList= new ArrayList<>();
		
		for (int i = 0; i < patCardList.size(); i++) {
			if(!StringUtil.isEmpty(patCardList.get(i).getId_card())){
				cardIdList.add(patCardList.get(i).getId_card());
			}
			
		}
		
		//删除患者卡记录
	    daf.deleteByPKs(PiPatCardDO.class, patCardIds);
	    
	    FBoolean fgCardMgr = new PiParams().PIPAT0027();// 是否开启卡库管理
	    if(FBoolean.FALSE.equals(fgCardMgr)){
	    	//不开启卡库管理的时候，删除卡逻辑还需要删除自动入库卡
	    	if(!ListUtil.isEmpty(cardIdList)){
	    		daf.deleteByPKs(PiCardDO.class,cardIdList.toArray(new String[0]));
	    	}
	    }else{
	    	  //还原卡状态
		    if(!ListUtil.isEmpty(cardIdList))
		    {
		    	String updateCardSql = "update pi_card set eu_cardsu = 0 where " + SqlUtils.getInSqlByIds("id_card", cardIdList.toArray(new String[0]));
		 	    daf.execUpdate(updateCardSql);
		 	    
		 	   //删除卡日志
				String deleteLogSql = "delete from pi_card_act where id_pat = '" + patId + "' and "
						+ SqlUtils.getInSqlByIds("id_card", cardIdList.toArray(new String[0]));
				daf.execUpdate(deleteLogSql);
		    }
		   
	    }
	}
}
