package iih.bl.comm.thirdpayapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRegDO;
import iih.bl.itf.trdtrans.i.ITrdtransregRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 第三方支付使用判断
 * 
 * @author ly 2019/01/21
 *
 */
public class BlThirdPayValidateUtil {

	/**
	 * 第三方支付使用判断
	 * @param pmIds 支付方式
	 * @param scene 使用场景
	 * @return
	 */
	public static BlThirdPayValidateRltDTO validate(String[] pmIds, String scene) throws BizException{

		if (ArrayUtil.isEmpty(pmIds) || StringUtil.isEmpty(scene)) {
			BlThirdPayValidateRltDTO rlt = new BlThirdPayValidateRltDTO();
			rlt.setFg_success(FBoolean.TRUE);
			return rlt;
		}

		ITrdtransregRService transService = ServiceFinder
				.find(ITrdtransregRService.class);
		BlThirdTransRegDO[] transRegDos = transService.find("1=1", null, FBoolean.FALSE);

		Map<String, BlThirdTransRegDO> _transCache = new HashMap<String, BlThirdTransRegDO>();
		if (!ArrayUtil.isEmpty(pmIds)) {
			for (BlThirdTransRegDO transRegDO : transRegDos) {
				_transCache.put(transRegDO.getId_pm(), transRegDO);
			}
		}

		BlThirdPayValidateRltDTO rlt = new BlThirdPayValidateRltDTO();

		BlThirdTransRegDO transRegDO = null;
		int count = 0;
		for (String pmId : pmIds) {
			if (_transCache.containsKey(pmId)) {
				transRegDO = _transCache.get(pmId);
				count++;
			}
		}

		// 未匹配到第三方支付方式
		if (count == 0) {
			rlt.setFg_success(FBoolean.TRUE);
			return rlt;
		}

		// 匹配多条第三方支付方式
		if (count > 1) {
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setError_msg("存在两种以上第三方支付交易付款方式，无法进行交易");
			return rlt;
		}

		// 场景不符合时
		if (StringUtil.isEmpty(transRegDO.getSd_scene()) || !transRegDO.getSd_scene().contains(scene)) {
			rlt.setFg_success(FBoolean.TRUE);
			return rlt;
		}

		rlt.setFg_success(FBoolean.TRUE);
		rlt.setId_pm(transRegDO.getId_pm());
		rlt.setId_paychannel(transRegDO.getId_paychannel());
		rlt.setSd_paychannel(transRegDO.getSd_paychannel());
		
		if(!StringUtil.isEmpty(transRegDO.getTrade_type())){
			//交易类型 正扫还是反扫
			rlt.setTradetype(transRegDO.getTrade_type());
		}
		return rlt;

	}
	
	/**
	 * 获取第三方支付的支付方式
	 * @param pmArr
	 * @param scene
	 * @return
	 * @throws BizException
	 */
	public static BlThirdPayValidateRltDTO[] getAllThirdPayPm(String[] pmArr,String scene) throws BizException
	{
		if(StringUtil.isEmpty(scene)||ArrayUtil.isEmpty(pmArr))
		{
			return null;
		}
		
		ITrdtransregRService transService = ServiceFinder
				.find(ITrdtransregRService.class);
		BlThirdTransRegDO[] transRegDos = transService.findByAttrValStrings(BlThirdTransRegDO.ID_PM, pmArr);
		
		if(ArrayUtil.isEmpty(transRegDos))
		{
			return null;
		}

		List<BlThirdPayValidateRltDTO> rltList=new ArrayList<>();
		
		for (BlThirdTransRegDO ThiransDo : transRegDos) {
			if(StringUtil.isEmpty(ThiransDo.getSd_scene()))
			{
				continue;
			}
			
			String[] seneArr=ThiransDo.getSd_scene().split(",");
			if(ArrayUtil.isEmpty(seneArr))
			{
				continue;
			}
			
			for (String sceneStr : seneArr) {
				if(scene.equals(sceneStr))
				{
					BlThirdPayValidateRltDTO rltDto=new BlThirdPayValidateRltDTO();
					rltDto.setFg_success(FBoolean.TRUE);
					rltDto.setId_pm(ThiransDo.getId_pm());
					rltDto.setId_paychannel(ThiransDo.getId_paychannel());
					rltDto.setSd_paychannel(ThiransDo.getSd_paychannel());
					
					if(!StringUtil.isEmpty(ThiransDo.getTrade_type())){
						//交易类型 正扫还是反扫
						rltDto.setTradetype(ThiransDo.getTrade_type());
					}
					
					rltList.add(rltDto);
					break;
				}
			}
		}
		
		return rltList.toArray(new BlThirdPayValidateRltDTO[0]);
	}
	
}
