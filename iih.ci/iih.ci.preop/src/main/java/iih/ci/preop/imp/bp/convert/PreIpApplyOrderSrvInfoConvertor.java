package iih.ci.preop.imp.bp.convert;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.cache.BDFreqInfoCache;
import iih.ci.sdk.cache.BDRouteInfoCache;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CiTsOrSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预住院申请导入，医嘱服务信息转换类
 * 
 * @author mkp
 *
 */
public class PreIpApplyOrderSrvInfoConvertor {
	// 上下文
	CiEnContextDTO ctx;

	public PreIpApplyOrderSrvInfoConvertor(CiEnContextDTO ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public void transfer(CiTsOrDO tsOrder, CiEmsDTO ciEmsDTO) throws BizException {
		FArrayList emsSrvList = new FArrayList();
		// 查询治疗方案医嘱下服务信息
		SqlParamBuilder sql = new SqlParamBuilder("select * from CI_TS_OR_SRV where id_tsor ='" + tsOrder.getId_tsor() + "' order by sortno");
		List<CiTsOrSrvDO> tsOrSrvDOs = sql.Q(CiTsOrSrvDO.class);

		for (CiTsOrSrvDO tsOrdSrv : tsOrSrvDOs) {
			CiEmsSrvDTO emsSrvDTO = new CiEmsSrvDTO();
			// 获取医嘱服务主键
//			String id_orsrv = new DBUtil().getOIDs(1)[0];
//			emsSrvDTO.setId_orsrv(id_orsrv);
//			emsSrvDTO.setId_or(emsSrvDTO.getId_or());
			emsSrvDTO.setStatus(DOStatus.NEW);
			emsSrvDTO.setSortno(tsOrdSrv.getSortno());
			emsSrvDTO.setId_srv(tsOrdSrv.getId_srv());

			// 查询基础服务信息
			MedSrvDO bdSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, tsOrdSrv.getId_srv());
			if (bdSrvInfo != null) {
				emsSrvDTO.setId_srvtp(bdSrvInfo.getId_srvtp());
				// 是否服务套
				if (ciEmsDTO.getFg_set().booleanValue() && emsSrvDTO.getId_srv().equals(ciEmsDTO.getId_srv())) {
				    emsSrvDTO.setFg_set(FBoolean.TRUE);				    
				} else {
				    emsSrvDTO.setFg_set(FBoolean.FALSE);
				}
				// 价格
				emsSrvDTO.setPrice(null);
				// 患者价格分类
				emsSrvDTO.setId_pripat(ctx.getId_pripat());
				emsSrvDTO.setId_primd(bdSrvInfo.getId_primd());
				emsSrvDTO.setEu_blmd(bdSrvInfo.getEu_blmd());
				emsSrvDTO.setFg_bl(bdSrvInfo.getFg_bl());
				// 医疗单位
				emsSrvDTO.setId_unit_med(bdSrvInfo.getId_unit_med());
				emsSrvDTO.setQuan_med(bdSrvInfo.getQuan_med());
			} else {
				throw new BizException(tsOrder.getCode_or() + " 对应的服务信息未找到");
			}
			
			if (!emsSrvDTO.getFg_set().booleanValue() && ciEmsDTO.getFg_set().booleanValue()) {
			    emsSrvDTO.setId_srv_set(ciEmsDTO.getId_srv());
			}

			// 主医保计划
			emsSrvDTO.setId_hp(ctx.getId_hp());
			emsSrvDTO.setSd_srvtp(tsOrdSrv.getSd_srvtp());
			emsSrvDTO.setCode_srv(tsOrdSrv.getCode_srv());
			emsSrvDTO.setName_srv(tsOrdSrv.getName());
			emsSrvDTO.setId_srvca(tsOrdSrv.getId_srvca());
			
			SrvCateDO srvCateDO = ServiceFinder.find(ISrvcateRService.class).findById(tsOrdSrv.getId_srvca());
			if (srvCateDO != null) {
				emsSrvDTO.setInnercode_srvca(srvCateDO.getInnercode());				
			}
			emsSrvDTO.setId_unit_med(tsOrdSrv.getId_medu());
			if (!ObjectUtils.isEmpty(tsOrdSrv.getMedu_name())) {
				emsSrvDTO.setName_unit_med(tsOrdSrv.getMedu_name().trim());
			}
			emsSrvDTO.setQuan_med(tsOrdSrv.getQuan_medu());
			emsSrvDTO.setQuan_total_medu(tsOrdSrv.getQuan_total_medu());

			// 频次
			emsSrvDTO.setId_freq(tsOrdSrv.getId_freq());
			FreqDefDO freqInfo = BDFreqInfoCache.GetFreqInfo(tsOrdSrv.getId_freq());
			emsSrvDTO.setName_freq(freqInfo.getName());
			emsSrvDTO.setFreqct(freqInfo.getFreqct());
			emsSrvDTO.setSd_frequnitct(freqInfo.getSd_frequnitct());

			emsSrvDTO.setId_route(tsOrdSrv.getId_route());
			emsSrvDTO.setName_route(BDRouteInfoCache.GetNameOfBdRouteInfo(tsOrdSrv.getId_route()));
			emsSrvDTO.setId_routedes(tsOrdSrv.getId_routedes());
			emsSrvDTO.setName_routedes(tsOrdSrv.getRoutedes_name());

			emsSrvDTO.setDes_srv(tsOrdSrv.getSrv_des());

			emsSrvDTO.setFg_mm(tsOrdSrv.getFg_mm());
			emsSrvDTO.setFg_or(tsOrdSrv.getFg_or());

			// 科室信息
			emsSrvDTO.setId_org_srv(ctx.getId_org());
			emsSrvDTO.setId_dep_srv(ctx.getId_dep_en());
			emsSrvDTO.setId_ward_srv(ctx.getId_dep_ns());
			
			// 开立医生，根据参数判断
			emsSrvDTO.setId_emp_srv(ciEmsDTO.getId_emp_phy());
			emsSrvDTO.setDt_create_srv(ciEmsDTO.getDt_begin());
			// 医嘱项目来源类型
			emsSrvDTO.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
			emsSrvDTO.setFg_selfsrv(tsOrdSrv.getFg_selfsrv());

			// 根据医嘱项目对应物品数据信息创建医疗单服务物品信息
			if (ObjectUtils.isTrue(emsSrvDTO.getFg_mm())) {
				createOrderSrvMm(emsSrvDTO, ciEmsDTO);
			}

			emsSrvList.add(emsSrvDTO);
		}

		CiEmsSrvDTO setSrv = null;
		if (!ObjectUtils.isEmpty(emsSrvList)) {
		    // 服务套项目置于列表首位
//		    Iterator<CiEmsSrvDTO> iterator = emsSrvList.iterator();
//		    while(iterator.hasNext()) {    
//		        CiEmsSrvDTO item = iterator.next();  
//		        if(ciEmsDTO.getFg_set().booleanValue() && item.getId_srv().equals(ciEmsDTO.getId_srv())) {
//		            setSrv = item;
//		            iterator.remove();
//		        }   
//		    }
//		    if (setSrv != null) {
//		        emsSrvList.add(0, setSrv);		        
//		    }
		    
			ciEmsDTO.setEmssrvs(emsSrvList);
		}
	}

	/**
	 * 处理物品信息
	 * @param emsSrvDTO
	 * @param emsSrvDTO
	 * @throws BizException 
	 */
	private void createOrderSrvMm(CiEmsSrvDTO emsSrvDTO, CiEmsDTO ciEmsDTO) throws BizException {
		MeterialDO[] meterialDOs = ServiceFinder.find(IMeterialMDORService.class).findByAttrValString(MeterialDO.ID_SRV, emsSrvDTO.getId_srv());
		if (meterialDOs == null || meterialDOs.length == 0) {
			return;
		}
		MedSrvDrugDO[] srvDrugDOs = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDO.ID_SRV, emsSrvDTO.getId_srv());
		if (srvDrugDOs == null || srvDrugDOs.length == 0) {
			return;
		}
		// 获取医嘱服务物品主键
		String id_orsrvmm = new DBUtil().getOIDs(1)[0];
		emsSrvDTO.setId_orsrvmm(id_orsrvmm);
		emsSrvDTO.setId_mm(meterialDOs[0].getId_mm());
		emsSrvDTO.setCode_mm(meterialDOs[0].getCode());
		emsSrvDTO.setName_mm(meterialDOs[0].getName());
		emsSrvDTO.setSpec_mm(meterialDOs[0].getSpec());
		emsSrvDTO.setId_unit_sale(meterialDOs[0].getId_unit_pkgsp());
		emsSrvDTO.setName_unit_sale(meterialDOs[0].getName_unit_pkgsp());
		emsSrvDTO.setId_unit_base(meterialDOs[0].getId_unit_pkgbase());
		emsSrvDTO.setName_unit_base(meterialDOs[0].getName_unit_pkgbase());
		emsSrvDTO.setQuan_cur(meterialDOs[0].getQuan_med());
		emsSrvDTO.setFactor_mb(meterialDOs[0].getFactor_mb());
		emsSrvDTO.setId_dosage(srvDrugDOs[0].getId_dosage());
		emsSrvDTO.setSd_dosage(srvDrugDOs[0].getSd_dosage());
		emsSrvDTO.setName_dosage(srvDrugDOs[0].getDs_name());
		emsSrvDTO.setId_pharm(srvDrugDOs[0].getId_pharm());
		emsSrvDTO.setSd_pharm(srvDrugDOs[0].getSd_pharm());
		emsSrvDTO.setId_pois(srvDrugDOs[0].getId_pois());
		emsSrvDTO.setSd_pois(srvDrugDOs[0].getSd_pois());
		emsSrvDTO.setId_anti(srvDrugDOs[0].getId_anti());
		emsSrvDTO.setSd_anti(srvDrugDOs[0].getSd_anti());
		if (!StringUtils.isEmpty(emsSrvDTO.getSd_anti())
				&& emsSrvDTO.getSd_anti().equals(IBdMmDictCodeConst.SD_ANTI_NULL)) {
			emsSrvDTO.setFg_propc(null);
		}
		emsSrvDTO.setId_mmtp(meterialDOs[0].getId_mmtp());
		emsSrvDTO.setSd_mmtp(meterialDOs[0].getSd_mmtp());
		emsSrvDTO.setId_val(meterialDOs[0].getId_val());
		emsSrvDTO.setSd_val(meterialDOs[0].getSd_val());
		emsSrvDTO.setIndica(meterialDOs[0].getIndica());
		emsSrvDTO.setConstr(meterialDOs[0].getConstr());
		emsSrvDTO.setReact(meterialDOs[0].getReact());
		
		emsSrvDTO.setId_opmutp(meterialDOs[0].getId_mupkgutp()); // 取整模式
		emsSrvDTO.setSd_opmutp(meterialDOs[0].getSd_mupkgutp());
		emsSrvDTO.setId_mupkgutp(meterialDOs[0].getId_mupkgutp());// 取整模式
		emsSrvDTO.setSd_mupkgutp(meterialDOs[0].getSd_mupkgutp());
		emsSrvDTO.setId_herbpreparationtp(meterialDOs[0].getId_herbpreparationtp());//草药制剂类型
		emsSrvDTO.setSd_herbpreparationtp(meterialDOs[0].getSd_herbpreparationtp());//草药制剂类型(0饮片；1配方颗粒)
		//增加当前剂量，当前剂量单位，当前剂量换算系数
		emsSrvDTO.setId_medu_cur(meterialDOs[0].getId_unit_med());
		emsSrvDTO.setQuan_medu_cur(meterialDOs[0].getQuan_med());
//		if(meterialDOs[0].getFactor_cur() != null 9
//				&& meterialDOs[0].getFactor_cur().trim().length() > 0)
//		emsSrvDTO.setFactor_medu_cur(new FDouble(meterialDOs[0].getFactor_cur()));
	}
}
