package iih.ci.ord.s.ems.ip.ems.pathgy;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病理医疗单创建逻辑
 * 
 * @author Young
 *
 */
public class EmsPathgyCreateBP extends BaseIpEmsCreateBP {
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsCrtDTOs) throws BizException {
		EmsCrtDTO emsCrtDTO = emsCrtDTOs[0];
		EmsRstDTO emsRstDTO = new EmsRstDTO();

		MedSrvDO medSrvDO = ServiceFinder.find(IMedsrvMDORService.class).findById(emsCrtDTO.getId_srv());
		if (medSrvDO == null) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("查询主服务信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}

		EmsPathgyViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
				emsCrtDTO.getId_srv());
		EmsPathgyViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			emsViewDTO = emsModelFrom(ctx, medSrvDO, emsCrtDTO);
			if (emsViewDTO == null) {
				FArrayList errorEmsList = new FArrayList();
				errorEmsList.append(String.format("没有查到【%s】服务的属性信息", medSrvDO.getName()));
				emsRstDTO.setErrorEmsList(errorEmsList);
				return new EmsRstDTO[] { emsRstDTO };
			}
			BDEmsInfoCache.PutCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
					emsCrtDTO.getId_srv(),emsViewDTO);
		}else{
			emsViewDTO = (EmsPathgyViewDTO)cacheEmsViewDTO.clone();
		}

		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);

		this.calcOrderWfDeptInfo(ctx, medSrvDO, emsViewDTO);
		this.setOrdDeptEmpInfo(ctx, emsViewDTO);

		emsViewDTO.setDt_effe(OrderEmsDtUtils.GetEffeDateTime(ctx.getId_en(), ctx.getDt_open()));// 开始时间赋值
		// 医嘱编码
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		emsViewDTO.setNo_applyform(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));// 申请单号
		emsViewDTO.setId_emp(ctx.getId_emp_or());// 采集者ID
		emsViewDTO.setName_emp(ctx.getName_emp_or());// 采集者
		emsViewDTO.setDt_coll(CiOrdAppUtils.getServerDateTime());// 采集时间
		// 诊断
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			emsViewDTO.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			emsViewDTO.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsViewDTO.setName_diitm(diagOutlineInfo.getName_diag());// 主诊断名称
			// OrderEmsExtInfoUtils.SetDiInfo(emsRstDTO,
			// diagOutlineInfo.toFMap());
		}
		// 非物品单价
		emsViewDTO.setPri(OrderEmsPriceUtils.calculatePrice(medSrvDO, ctx.getId_pripat()));
		//
		this.handleDefaultInfo(emsCrtDTO, emsViewDTO);
		
		emsViewDTO.setStatus(DOStatus.NEW);
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);
		emsRstDTO.setDocument(this.handleReturnDocument(emsViewDTO));
		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 创建主模型对象
	 * 
	 * @param medSrv
	 * @return
	 * @throws BizException
	 */
	protected EmsPathgyViewDTO emsModelFrom(CiEnContextDTO ctx, MedSrvDO medSrv, EmsCrtDTO emsCrtDTO)
			throws BizException {
		MedSrvLisDO[] medSrvLisDOs = ServiceFinder.find(IMedSrvLisDORService.class)
				.find(String.format("a1.id_srv='%s'", medSrv.getId_srv()), "", FBoolean.FALSE);
		if (null == medSrvLisDOs || medSrvLisDOs.length == 0) {
			return null;
		}
		EmsPathgyViewDTO emsPathgyViewDTO = new EmsPathgyViewDTO();
		this.orderListViewInfoFrom(ctx, medSrv, emsCrtDTO.getDriverInfo(), emsPathgyViewDTO);
		emsPathgyViewDTO.setId_samptp(medSrvLisDOs[0].getId_samptp());// 标本类型ID
		emsPathgyViewDTO.setSd_samptp(medSrvLisDOs[0].getSd_samptp());// 标本类型编码
		emsPathgyViewDTO.setName_samptp(medSrvLisDOs[0].getSamptp_name());// 标本类型
		// emsPathgyViewDTO.setId_di(Id_di);//
		// emsPathgyViewDTO.setId_diitm(Id_diitm);//
		// emsPathgyViewDTO.setName_diitm(Name_diitm);//
		// emsPathgyViewDTO.setNo_applyform(CiOrdUtils.getApplyNo(medSrv.getSd_srvtp()));//申请单号
		emsPathgyViewDTO.setDes_sympsign(OrderUtils.getClinicalzztzInfo(ctx.getId_en()));// 病情描述
		// emsPathgyViewDTO.setAnnouncements(Announcements);//检查要求
		emsPathgyViewDTO.setFg_outer(FBoolean.FALSE);// 是否外院
		emsPathgyViewDTO.setOrg_pathgy_old(ctx.getName_org());// 既往医院
		// emsPathgyViewDTO.setNo_pathgy_old(No_pathgy_old);//既往病理号
		// emsPathgyViewDTO.setDt_pathgy_old(null);//既往病理日期
		// emsPathgyViewDTO.setDi_pathgy_old(Di_pathgy_old);//既往病理诊断
		// emsPathgyViewDTO.setCollectdes(Collectdes);//采集所见
		emsPathgyViewDTO.setId_emp(ctx.getId_emp_or());// 采集者ID
		emsPathgyViewDTO.setName_emp(ctx.getName_emp_or());// 采集者
		// emsPathgyViewDTO.setDt_coll(CiOrdAppUtils.getServerDateTime());//采集时间
		// emsPathgyViewDTO.setEmspathgyitems(null);//病理标本集合
		return emsPathgyViewDTO;
	}
}
