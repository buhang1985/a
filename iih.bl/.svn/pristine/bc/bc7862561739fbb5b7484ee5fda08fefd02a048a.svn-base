package iih.bl.hp.prepay.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.hp.prepay.d.HpPrePayDo;
import iih.bl.hp.prepay.s.HprepayCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 每日预结算保存
 * @author hanjq 上午10:42:42
 *
 */
public class SaveForDailyBP {

	/**
	 * 患者每日预结算保存
	 * @author : hanjq 2019年8月8日 下午1:34:48
	 * @param aggdos
	 * @param hprepayCrudServiceImpl
	 * @return
	 * @throws BizException
	 */
	public HpPrePayDo[] exec(HpPrePayDo[] aggdos, HprepayCrudServiceImpl hprepayCrudServiceImpl) throws BizException {
		ArrayList<HpPrePayDo> prePays = new ArrayList<>();
		HpPrePayDo[] tmp = null;
		if(aggdos != null && aggdos.length > 0){
			for(HpPrePayDo prePay : aggdos){
				if(prePay != null && StringUtils.isNotBlank(prePay.getId_pat())){
					HpPrePayDo prePayNew = (HpPrePayDo) prePay.clone();
					HpPrePayDo prePayDo = getDailyHpPrePayDo(prePay.getId_pat());					
					if(prePayDo != null){
						prePayNew.setStatus(DOStatus.UPDATED);
						prePayNew.setId_hpprepay(prePayDo.getId_hpprepay());
						tmp = hprepayCrudServiceImpl.update(new HpPrePayDo[]{prePayNew});
					}else{
						prePayNew.setStatus(DOStatus.NEW);
						tmp = hprepayCrudServiceImpl.save(new HpPrePayDo[]{prePayNew});
					}
					
					if(tmp != null && tmp.length > 0){
						prePays.add(tmp[0]);
					}
				}
			}
		}
		return prePays.toArray(new HpPrePayDo[0]);
	}
	
	/**
	 * 获取日结预结算
	 * @author : hanjq 2019年8月8日 上午11:50:51
	 * @param id_ent
	 * @return
	 * @throws DAException
	 */
	private HpPrePayDo getDailyHpPrePayDo(String id_pat) throws DAException{
		DAFacade daf = new DAFacade();
		FDate dt = new FDate();
		String thisDay = dt.getYear()+"-"+dt.getMonth()+"-"+dt.getDay();
		StringBuffer sb = new StringBuffer();
		sb.append("select Id_hpprepay  from bl_hp_prepay ");
		sb.append("where id_pat =  '").append(id_pat).append("'	 ");
		sb.append("	and sv >=  '").append(thisDay).append(" 00:00:00'	 ");
		sb.append("	and	sv <= '").append(thisDay).append(" 23:59:59'	");
		List<HpPrePayDo> prePays = (List<HpPrePayDo>) daf.execQuery(sb.toString(),  new BeanListHandler(HpPrePayDo.class));
		if(prePays != null && prePays.size() > 0){
			return prePays.get(0);
		}
		return null;		
	}

}
