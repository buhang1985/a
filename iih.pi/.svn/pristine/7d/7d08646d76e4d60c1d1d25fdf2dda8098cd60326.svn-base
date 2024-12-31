package iih.pi.reg.pat.s.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 设置患者默认值业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SetPatAggDefaultValueBp {

	private Map<String,PiPatCardTpDO> patCardMapCache;
	
	public void exec(PatiAggDO[] patAggs) throws BizException {
		if (patAggs == null || patAggs.length <= 0) {
			return;
		}
		for (int i = 0; i < patAggs.length; i++) {
			setDefaultValue(patAggs[i]);
		}
	}

	private void setDefaultValue(PatiAggDO patiAggDo) throws BizException {
		PatDO patdo = patiAggDo.getParentDO();

		// 建档来源类型赋默认值
		if (StringUtil.isEmpty(patdo.getId_patsrctp())) {
			// 窗口注册
			patdo.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_WINDOW);
			patdo.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_WINDOW);
		}

		// 为空性别字段赋值
		if (patdo.getId_sex() == null) {
			patdo.setId_sex(IPiDictCodeConst.ID_SEX_UNEXPLAIN);
			patdo.setSd_sex(IPiDictCodeConst.SD_SEX_UNEXPLAIN);
			patdo.setName_sex(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);
			patdo.setCode_sex(IPiDictCodeConst.SD_SEX_UNEXPLAIN);
		}

		// 身份证号X大写
		if (IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patdo.getSd_idtp()) && !StringUtil.isEmpty(patdo.getId_code())) {
			patdo.setId_code(patdo.getId_code().toUpperCase());
		}
		
		if(patdo.getLast_times_oep() == null){
			patdo.setLast_times_oep(0);
		}
		
		if(patdo.getLast_times_ip() == null){
			patdo.setLast_times_ip(0);
		}
		
		if(!ArrayUtil.isEmpty(patiAggDo.getPiPatCardDO())){
			
			this.loadPatCardCache();
			
			for (PiPatCardDO patCardDO : patiAggDo.getPiPatCardDO()) {
				
				if(patCardDO.getStatus() != DOStatus.NEW)
					continue;
				
				PiPatCardTpDO patCardTpDO = this.patCardMapCache.get(patCardDO.getId_patcardtp());
				if(patCardTpDO != null){
					patCardDO.setEu_cardcgmd(patCardTpDO.getEu_cardcgmd());
				}
			}
		}
	}
	
	/**
	 * 加载患者卡类型
	 */
	@SuppressWarnings("unchecked")
	private void loadPatCardCache() throws BizException {
		
		if(this.patCardMapCache != null)
			return;
		
		DAFacade daf = new DAFacade();
		List<PiPatCardTpDO> patCardList = (List<PiPatCardTpDO>)daf.findByCond(PiPatCardTpDO.class, "1=1", 
				new String[]{PiPatCardTpDO.ID_CARDTP,PiPatCardTpDO.EU_CARDCGMD});
		if (ListUtil.isEmpty(patCardList)) {
			this.patCardMapCache = new HashMap<String, PiPatCardTpDO>();
			return;
		}
		
		this.patCardMapCache = MapUtils.convertListToMap(patCardList, PiPatCardTpDO.ID_CARDTP);
	}
}
