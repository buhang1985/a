package iih.bd.pp.s;

import java.util.Map;

import iih.bd.pp.hp.bp.CheckIsSelfPaidDiBP;
import iih.bd.pp.hp.bp.GetAllMutiPayRatioListBP;
import iih.bd.pp.hp.bp.GetAllSrvMutiPayRatioBP;
import iih.bd.pp.hp.bp.GetHpSrvCtrDiListBP;
import iih.bd.pp.hp.bp.GetSrvPayRatioListBP;
import iih.bd.pp.hp.bp.TransToRatioHpCodeBP;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保基础数据服务
 * @author yankan
 * @since 2017-09-20
 *
 */
@Service(serviceInterfaces={IBdHpQryService.class}, binding=Binding.JSONRPC)
public class BdHpQryServiceImpl implements IBdHpQryService {
	/**
	 * 是否自费诊断
	 * @param hpId 医保计划ID
	 * @param entpCode 就诊类型编码
	 * @param diIds 诊断ID集合
	 * @return map，【key: 诊断ID，value: FBoolean】
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String,FBoolean> isSelfPaidDi(String hpId,String entpCode,String[] diIds) throws BizException{
		CheckIsSelfPaidDiBP checkBP = new CheckIsSelfPaidDiBP();
		return checkBP.exec(hpId, entpCode, diIds);
	}
	/**
	 * 获取多支付比例集合
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID或物品ID
	 * @param isMm 是否物品
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public MPayRatioDfDO[] getSrvPayRatioList(String hpId,String srvId,FBoolean isMm) throws BizException{
		GetSrvPayRatioListBP getSrvRatioBP = new GetSrvPayRatioListBP();
		return getSrvRatioBP.exec(hpId, srvId,isMm);
	}
	/**
	 * 获取所有服务多支付比例集合
	 * @return
	 * @author yankan
	 */
	@Override
	public SrvMPayRatioDO[] getAllSrvMutiPayRatio() throws BizException{
		GetAllSrvMutiPayRatioBP getAllSrvRatioBP = new GetAllSrvMutiPayRatioBP();
		return getAllSrvRatioBP.exec();
	}
	/**
	 * 转换为多支付比例的医保编码
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID或物品ID
	 * @param mpayRatioId 多支付比例ID
	 * @param isMm 是否物品
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public String transToRatioHpCode(String hpId,String srvId,String mpayRatioId,FBoolean isMm) throws BizException{
		TransToRatioHpCodeBP transBP = new TransToRatioHpCodeBP();
		return transBP.exec(hpId,srvId, mpayRatioId, isMm);
	}
	/**
	 * 获取所有多支付比例集合
	 * @return 
	 * @author yankan
	 */
	@Override
	public MPayRatioDfDO[] getAllMutiPayRatioList() throws BizException{
		GetAllMutiPayRatioListBP getAllRatioBP = new GetAllMutiPayRatioListBP();
		return getAllRatioBP.exec();
	}
	/**
	 * 获取医保服务限制诊断集合
	 * @param hpId 医保计划ID
	 * @param srvIds 服务ID集合 
	 * @return map，【key:服务ID,value:List<诊断ID>】
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FMap getHpSrvCtrDiList(String hpId,String[] srvIds) throws BizException{
		GetHpSrvCtrDiListBP getCtrDiListBP = new GetHpSrvCtrDiListBP();
		return getCtrDiListBP.exec(hpId, srvIds);
	}
}
