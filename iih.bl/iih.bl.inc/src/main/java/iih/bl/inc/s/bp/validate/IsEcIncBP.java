package iih.bl.inc.s.bp.validate;

import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bl.inc.blecinctrans.d.EcIncTypeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 判断结算对应的发票是否是电子发票
 * @author ly 2019/12/25
 *
 */
public class IsEcIncBP {

	/**
	 * 判断结算对应的发票是否是电子发票
	 * @param stIds
	 * @param ecIncType
	 * @return
	 * @throws BizException
	 */
	public FMap exec(String[] stIds, String ecIncType) throws BizException{
		
		this.validate(stIds, ecIncType);
		
		FMap rlt = null;
		if(EcIncTypeEnum.OEP.equals(ecIncType)){
			rlt = this.dealOep(stIds);
		}else{
			rlt = this.dealIp(stIds);
		}
		
		return rlt;
	}
	
	/**
	 * 校验
	 * @param stIds
	 * @param ecIncType
	 * @throws BizException
	 */
	private void validate(String[] stIds,String ecIncType) throws BizException{
		
		if(ArrayUtil.isEmpty(stIds)){
			throw new BizException("判断电子发票:入参结算id数组为空");
		}
		
		if(StringUtil.isEmpty(ecIncType)){
			throw new BizException("判断电子发票:发票类型为空");
		}
	}

	/**
	 * 处理门诊
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FMap dealOep(String[] stIds) throws BizException{
		
		DAFacade daf = new DAFacade();
		
		String sql = "select distinct id_stoep,fg_ec_inc from bl_inc_oep where " 
				+ SqlUtils.getInSqlByIds("id_stoep", stIds);
		
		List<Map<String, Object>> rltList = (List<Map<String, Object>>)daf.execQuery(sql, new MapListHandler());
		
		FMap map = new FMap();
		for (Map<String, Object> rlt : rltList) {
			
			String stId = rlt.get("id_stoep").toString();
			FBoolean fgEcInc = (FBoolean)FTypeManager.convert2FType(FType.FBoolean, rlt.get("fg_ec_inc"));
			map.put(stId, fgEcInc);
		}
		
		return map;
	}
	
	/**
	 * 处理住院
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	private FMap dealIp(String[] stIds) throws BizException{
		return null;
	}
}
