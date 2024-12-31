package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.ems.uiorderdto.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDSrvtpInfoCache;
import iih.ci.ord.s.ems.define.OrdPicStatusIndex;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.qry.GetOrderListViewDTOQry;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.i.ISkintestRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医嘱加载逻辑
 * 
 * @author Young
 *
 */
public class OrderLoadOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO,
			FMap2 extension) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		if (ciEnContextDTO == null
				|| StringUtils.isNullOrEmpty(ciEnContextDTO.getId_en())
				|| StringUtils.isNullOrEmpty(ciEnContextDTO.getCode_entp())) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		String id_en = ciEnContextDTO.getId_en();
		String code_entp = ciEnContextDTO.getCode_entp();

		// 查询医嘱列表DTO
		ITransQry qry = new GetOrderListViewDTOQry(id_en, code_entp,
				this.getSequenceMode());
		OrderListViewDTO[] orderListViewDTOs = (OrderListViewDTO[]) AppFwUtil
				.getDORstWithDao(qry, OrderListViewDTO.class);

		String id_ors = "";
		for (OrderListViewDTO dto : orderListViewDTOs) {
			id_ors += ",'" + dto.getId_or() + "'";
		}
		// 查询医嘱费用
		Map<String, FDouble> mapIdorAmt = null;
		if (!StringUtils.isNullOrEmpty(id_ors)) {
			mapIdorAmt = this.getAmt_or(id_ors.substring(1));
		}

		FArrayList lstOrders = new FArrayList();
		for (OrderListViewDTO dto : orderListViewDTOs) {
			// 医嘱费用
			dto.setOr_total_pri(mapIdorAmt!=null&&mapIdorAmt.get(dto.getId_or())!=null?mapIdorAmt.get(dto.getId_or()):new FDouble("0.00"));
			// 服务类型名称
			dto.setName_srvtp(BDSrvtpInfoCache.GetNameOfBDSrvtpInfo(dto.getSd_srvtp()));
			// 医嘱状态
			this.getOrderDisplayStatus(dto);
			// 皮试结果
			this.getOrderSkintest_result(dto);

			lstOrders.append(dto);
		}

		rstDTO.setDocument(lstOrders);

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 获取医嘱列表排序模式
	 * 
	 * @return
	 * @throws BizException
	 */
	private String getSequenceMode() throws BizException {
		// CIORA0085 医嘱列表排列顺序模式 ：1 倒序 2 顺序
		String sequenceMode = "";
		String temp = ParamsetQryUtil.getParaString(CiOrdAppUtils
				.getEnvContext().getOrgId(),
				ICiOrdNSysParamConst.SYS_PARAM_OpListMarshalSequenceMode);
		if ("1".equals(temp)) {
			sequenceMode = "DESC";
		} else if ("2".equals(temp)) {
			sequenceMode = "ASC";
		}
		return sequenceMode;
	}

	/**
	 * 由医嘱ID查询医嘱费用
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private Map<String, FDouble> getAmt_or(String id_ors) throws BizException {
		if (StringUtils.isNullOrEmpty(id_ors))
			return null;
		String sql = "select ORSRV.id_or,sum((case when ORSRV.fg_bl='Y' and ORSRV.fg_mm='N' then nvl(ORSRV.pri*ORSRV.quan_total_medu, 0.0) "
				+ "when ORSRV.fg_mm='Y' then nvl(ORSRVMM.price_pgku_cur*ORSRVMM.quan_cur, 0.0) else 0.0 end)) as amt "
				+ "from ci_or_srv ORSRV left outer join ci_or_srv_mm ORSRVMM ON ORSRV.id_orsrv=ORSRVMM.id_orsrv where ORSRV.id_or in ("
				+ id_ors + ") group by ORSRV.id_or";
		List<Map<String, Object>> rst = CiOrdUtils.getRsMapList(sql);
		if (rst == null || rst.size() <= 0)
			return null;
		Map<String, FDouble> map = new HashMap<String, FDouble>();
		for (Map<String, Object> itm : rst) {
			String id_or = itm.get("id_or").toString();
			FDouble amt = new FDouble("0.00");
			amt = amt.add(Double.valueOf(itm.get("amt").toString()));
			map.put(id_or, amt);
		}

		return map;
	}

	/**
	 * 获取医嘱显示状态
	 * 
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	private void getOrderDisplayStatus(OrderListViewDTO orderListViewDTO)
			throws BizException {
		String strName_su_or = "";
		String strOrd_colligate = "";
		switch (orderListViewDTO.getSd_su_or()) {
		case ICiDictCodeConst.SD_SU_OPEN:
			strName_su_or = "开立";
			strOrd_colligate = OrdPicStatusIndex.OPEN.toString();
			break;
		case ICiDictCodeConst.SD_SU_SIGN:
			strName_su_or = "签署";
			strOrd_colligate = OrdPicStatusIndex.SIGN.toString();

			if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(orderListViewDTO
					.getSd_su_mp())) {
				if (orderListViewDTO.getFg_stop() == null) {
					strName_su_or = "未知";
					strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
				} else {
					if (orderListViewDTO.getFg_stop().isValue()) {
						strName_su_or = "执行中+预停";
						strOrd_colligate = OrdPicStatusIndex.EXEC_PRESTOP
								.toString();
					} else {
						strName_su_or = "执行中";
						strOrd_colligate = OrdPicStatusIndex.EXEC.toString();
					}
				}
			}
			break;
		case ICiDictCodeConst.SD_SU_CHECKTHROUGH:
			if (ICiDictCodeConst.SD_SU_MP_NONE.equals(orderListViewDTO
					.getSd_su_mp())) {
				if (orderListViewDTO.getFg_stop() == null) {
					strName_su_or = "未知";
					strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
				} else {
					if (orderListViewDTO.getFg_stop().isValue()) {
						strName_su_or = "确认+预停";
						strOrd_colligate = OrdPicStatusIndex.CONFRIM_PRESTOP
								.toString();
					} else {
						strName_su_or = "确认";
						strOrd_colligate = OrdPicStatusIndex.CONFIRM.toString();
					}
				}
			} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED
					.equals(orderListViewDTO.getSd_su_mp())) {
				if (orderListViewDTO.getFg_stop() == null) {
					strName_su_or = "未知";
					strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
				} else {
					if (orderListViewDTO.getFg_stop().isValue()) {
						strName_su_or = "执行中+预停";
						strOrd_colligate = OrdPicStatusIndex.EXEC_PRESTOP
								.toString();
					} else {
						strName_su_or = "执行中";
						strOrd_colligate = OrdPicStatusIndex.EXEC.toString();
					}
				}
			} else {
				strName_su_or = "未知";
				strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
			}
			break;
		case ICiDictCodeConst.SD_SU_CHECKSTOP:
			if (orderListViewDTO.getFg_stop() == null) {
				strName_su_or = "未知";
				strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
			} else if (orderListViewDTO.getFg_stop().isValue()) {
				if (ICiDictCodeConst.SD_SU_MP_NONE.equals(orderListViewDTO
						.getSd_su_mp())) {
					strName_su_or = "确认+停止";
					strOrd_colligate = OrdPicStatusIndex.CONFIRM_STOP
							.toString();
				} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED
						.equals(orderListViewDTO.getSd_su_mp())) {
					strName_su_or = "执行中+停止";
					strOrd_colligate = OrdPicStatusIndex.EXEC_STOP.toString();
				} else {
					strName_su_or = "未知";
					strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
				}
			}
			break;
		case ICiDictCodeConst.SD_SU_FINISH:
			if (ICiDictCodeConst.SD_SU_MP_EXEOK.equals(orderListViewDTO
					.getSd_su_mp())) {
				strName_su_or = "完成";
				strOrd_colligate = OrdPicStatusIndex.OVER.toString();
			} else if (ICiDictCodeConst.SD_SU_MP_EXECANC
					.equals(orderListViewDTO.getSd_su_mp())) {
				strName_su_or = "取消";
				strOrd_colligate = OrdPicStatusIndex.CANCEL.toString();
			} else if (ICiDictCodeConst.SD_SU_MP_CANCEL.equals(orderListViewDTO
					.getSd_su_mp())) {
				strName_su_or = "不执行";
				strOrd_colligate = OrdPicStatusIndex.NOTEXEC.toString();
			} else {
				strName_su_or = "未知";
				strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
			}
			break;
		case ICiDictCodeConst.SD_SU_CANCEL:
			strName_su_or = "作废";
			strOrd_colligate = OrdPicStatusIndex.OBSOLETE.toString();
			break;
		case ICiDictCodeConst.SD_SU_CHECKCANCEL:
			strName_su_or = "已作废";
			strOrd_colligate = OrdPicStatusIndex.CANCELLED.toString();
			break;
		default:
			strName_su_or = "未知";
			strOrd_colligate = OrdPicStatusIndex.UNKNOW.toString();
			break;
		}
		orderListViewDTO.setName_su_or(strName_su_or);
		orderListViewDTO.setOrd_colligate(strOrd_colligate);
	}

	/**
	 * 获取皮试结果
	 * 
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	private void getOrderSkintest_result(OrderListViewDTO orderListViewDTO)
			throws BizException {
		if (IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST
				.equals(orderListViewDTO.getSd_srvtp())) {
			ISkintestRService skinService = ServiceFinder
					.find(ISkintestRService.class);
			CiSkinTestRstDO[] szRstDO = skinService.find(
					String.format(" id_or='%s' ", orderListViewDTO.getId_or()),
					"", FBoolean.FALSE);
			if (szRstDO != null && szRstDO.length > 0) {
				String rstSkin = szRstDO[0].getSd_rst_skintest();
				if (StringUtils.isNullOrEmpty(rstSkin)) {
					orderListViewDTO.setSkintest_result("结果未出");
				} else {
					orderListViewDTO.setSkintest_result(szRstDO[0]
							.getSkinres_name());
				}
			} else {
				orderListViewDTO.setSkintest_result("结果未出");
			}
		}
	}
}
