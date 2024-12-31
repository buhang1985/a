package iih.ci.sdk.utils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.external.obtain.ICiOrdBlRService;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 价格计算工具类 -- 需要整改目前存在很多价格计算逻辑
 * @author wangqingzhu
 *
 */
public class OrderEmsPriceUtils {
	/**
	 * 医嘱服务计算价格（非物品计价）
	 * 
	 * @param medsrv
	 * @return
	 * @throws BizException
	 */
	public static FDouble calculatePrice(MedSrvDO medsrv, String id_pripat)
			throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();

		priParam.setId_srv(medsrv.getId_srv());
		priParam.setId_primd(medsrv.getId_primd());
		priParam.setNum(0);
		// 远程调用
		MedSrvPriceDO price = ServiceFinder.find(ICiOrdBlRService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);

		return price != null ? price.getPrice_ratio() : FDouble.ZERO_DBL;
	}

	/**
	 * 本服务计算价格
	 * 
	 * @param id_srv
	 * @param id_primd
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public static MedSrvPriceDO calculatePrice(String id_srv, String id_primd, String id_pripat) 
			throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();

		priParam.setId_srv(id_srv);
		priParam.setId_primd(id_primd);
		priParam.setNum(0);
		// 远程调用
		return ServiceFinder.find(ICiOrdBlRService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);

	}

	/**
	 * 本服务计算价格
	 * 
	 * @param id_srv
	 * @param id_primd
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public static FDouble calCulatePrice(String id_srv, String id_primd, String id_pripat) 
			throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();

		priParam.setId_srv(id_srv);
		priParam.setId_primd(id_primd);
		priParam.setNum(0);
		// 远程调用
		MedSrvPriceDO price = ServiceFinder.find(ICiOrdBlRService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);

		return price != null ? price.getPrice_ratio() : FDouble.ZERO_DBL;
	}

	/**
	 * 医嘱服务计算价格（非物品计价）
	 * 
	 * @param medsrv
	 * @param emsOrObsList
	 * @return
	 * @throws BizException
	 */
	public static MedSrvPriceDO calculatePrice(MedSrvDO medsrv, String id_pripat, FArrayList emsOrObsList) 
			throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		int iNumber = 0;

		priParam.setId_srv(medsrv.getId_srv());
		priParam.setId_primd(medsrv.getId_primd());
		priParam.setNum(iNumber);
		if (emsOrObsList != null) {
			FArrayList setItemSrvList = new FArrayList();
			for (Object obLap : emsOrObsList) {
				EmsObsLap lap = (EmsObsLap) obLap;
				if (ObjectUtils.isTrue(lap.getFg_chk())) {
					iNumber++;
					BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
					param.setId_srv(lap.getId_srv());
					param.setId_primd(lap.getId_primd());
					param.setNum(1);
					setItemSrvList.add(param);
				}
			}
			priParam.setNum(iNumber);
			priParam.setSrvsetitms(setItemSrvList);
		}
		// 单选模式下，服务套的临床项目没有被选中默认项目时候，不计算价格
		if (priParam.getSrvsetitms().size() == 0
				&& ObjectUtils.isTrue(medsrv.getFg_set())) {
			MedSrvPriceDO mspd = new MedSrvPriceDO();
			mspd.setRatio(FDouble.ONE_DBL);
			mspd.setPrice_ratio(FDouble.ZERO_DBL);
			mspd.setPrice_std(FDouble.ZERO_DBL);
			mspd.setId_pripat(id_pripat);
			return mspd;
		}

		MedSrvPriceDO price = ServiceFinder.find(ICiOrdBlRService.class)
				.ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);// .ciOrBdSrvPriceCal(priParam);

		return price;
	}

	/**
	 * 计算价格的代理模式
	 * 
	 * @author wangqingzhu
	 *
	 */
	public static interface IBdSrvPriCalParamFrom {
		public FArrayList getBdSrvPriCalParamList(FArrayList emsOrObsList);
	}

	/**
	 * 计算价格
	 * 
	 * @param medsrv
	 * @param id_pripat
	 * @param emsOrObsList
	 * @param iDelegate
	 * @return
	 * @throws BizException
	 */
	public static MedSrvPriceDO calculatePrice(MedSrvDO medsrv, String id_pripat, FArrayList emsOrObsList, IBdSrvPriCalParamFrom iDelegate) 
			throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();

		priParam.setId_srv(medsrv.getId_srv());
		priParam.setId_primd(medsrv.getId_primd());
		priParam.setNum(0);
		if (!ObjectUtils.isEmpty(emsOrObsList)) {
			FArrayList setItemSrvList = iDelegate.getBdSrvPriCalParamList(emsOrObsList);
			priParam.setNum(setItemSrvList.size());
			priParam.setSrvsetitms(setItemSrvList);
		}
		// 单选模式下，服务套的临床项目没有被选中默认项目时候，不计算价格
		if (priParam.getSrvsetitms().size() == 0 && ObjectUtils.isTrue(medsrv.getFg_set())) {
			MedSrvPriceDO mspd = new MedSrvPriceDO();
			mspd.setRatio(FDouble.ONE_DBL);
			mspd.setPrice_ratio(FDouble.ZERO_DBL);
			mspd.setPrice_std(FDouble.ZERO_DBL);
			mspd.setId_pripat(id_pripat);
			return mspd;
		}

		return ServiceFinder.find(ICiOrdBlRService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);
	}

	/**
	 * 获取物品价格
	 * 
	 * @param id_mm
	 * @param id_unit_sale
	 * @return
	 * @throws BizException
	 */
	public static FDouble getMaterialPrice(String id_mm, String id_unit_sale)
			throws BizException {
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(id_unit_sale);
		GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
		reqDtoArr[0] = reqDto;
		MaterialStockDTO[] materials = ServiceFinder.find(IMaterialStockService.class).getMaterialStocks(reqDtoArr);
		if (materials != null && materials.length > 0) {
			return materials[0].getPrice_act();
		} else {
			return FDouble.ZERO_DBL;
		}
	}
	
	/**
	 * 医嘱服务计算价格（非物品计价）--预住院申请单使用
	 * @param medsrv
	 * @param emsOrObsList
	 * @return
	 * @throws BizException
	 */
    public static FDouble CalculatePrice(CiEnContextDTO ctx,String id_srv, String id_setsrvs) throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		int iNumber = 0;
		MedSrvDO mainSrv=BDSrvInfoCache.GetBdSrvInfo(ctx, id_srv);
		priParam.setId_srv(mainSrv.getId_srv());
		priParam.setId_primd(mainSrv.getId_primd());
		priParam.setNum(iNumber);
		if (!ObjectUtils.isEmpty(id_setsrvs)) {
			FArrayList setItemSrvList = new FArrayList();
			for (String id_setsrv : id_setsrvs.split(",")) {
				MedSrvDO setSrv=BDSrvInfoCache.GetBdSrvInfo(ctx, id_setsrv);
				iNumber++;
				BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
				param.setId_srv(setSrv.getId_srv());
				param.setId_primd(setSrv.getId_primd());
				FDouble quan_medu =setSrv.getQuan_med();
				Integer num = (int) (quan_medu == null ? 1 : Math.ceil(quan_medu.toDouble()));							
				param.setNum(num);
				setItemSrvList.add(param);
			}
			priParam.setNum(iNumber);
			priParam.setSrvsetitms(setItemSrvList);
		}		

		MedSrvPriceDO price = ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCalByPriMode(priParam, ctx.getId_pripat());//.ciOrBdSrvPriceCal(priParam);
		
		return price.getPrice_ratio();
	}
}
