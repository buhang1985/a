package iih.bd.pp.hp.bp;

import java.util.List;

import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 转换为多支付比例的医保编码
 * @author yankan
 *
 */
public class TransToRatioHpCodeBP {
	/**
	 * 转换为多支付比例的医保编码
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID或物品ID
	 * @param mpayRatioId 多支付比例ID
	 * @param isMm 是否物品
	 * @return
	 * @throws BizException
	 */
	public String exec(String hpId,String srvId,String mpayRatioId,FBoolean isMm) throws BizException{
		String[] selectedFields = new String[] {SrvMPayRatioDO.CODE};
		String condition = "ID_HP=? AND ID_HPMPAYRATIODF=?";
		if(FBoolean.TRUE.equals(isMm)){
			condition += " AND ID_MM=?";					
		}else{
			condition += " AND ID_SRV=?";
		}
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		param.addParam(mpayRatioId);
		param.addParam(srvId);		
		
		List<SrvMPayRatioDO> mpayRationList = (List<SrvMPayRatioDO>)new DAFacade().findByCond(SrvMPayRatioDO.class, condition,selectedFields,param);
		if(ListUtil.isEmpty(mpayRationList)){
			throw new BizException("此服务医保多比例支付配置不存在！");
		}
		return mpayRationList.get(0).getCode();
	}
}
