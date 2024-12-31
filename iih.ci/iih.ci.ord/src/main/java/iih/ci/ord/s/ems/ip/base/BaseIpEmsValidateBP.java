package iih.ci.ord.s.ems.ip.base;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.ExcludeAllGrpInCoExistException;
import iih.ci.ord.s.bp.exception.ExcludeAllOrSrvMultiException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.srvreact.d.OrOpenSrvReactDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医疗单校验--互斥
 * 
 * @author zhangwq
 *
 */
@Deprecated
public class BaseIpEmsValidateBP {
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		// 转科医嘱需要在转科中添加特殊校验，需要在子类中实现
		ErrorEmsList errorEmsList = new ErrorEmsList();
		for (Object objModel : objEms) {
			List<String> errorList = new ArrayList<String>();
			OrderListViewDTO viewDTO = (OrderListViewDTO) objModel;
			SrvReactDTO[] srvreacts = getSrvReactInfos(viewDTO.getId_srv());
			if (srvreacts == null || srvreacts.length == 0)
				return errorEmsList;// 医嘱互斥项目检查
			// 对服务互斥数据进行分组处理
			Hashtable<String, ArrayList<SrvReactDTO>> reactht = CiOrdUtils.getSrvReactHt(srvreacts);
			String id_pi = ctx.getId_pat();
			String id_pv = ctx.getId_en();
			String id_or = viewDTO.getId_or();
			String id_srvreacts = CiOrdUtils.getSrvReactIdStrs(srvreacts);
			FDateTime[] openOrDts = new FDateTime[] { viewDTO.getDt_effe(), viewDTO.getDt_end() }; // ???

			// 存在全排医嘱
			if (reactht.containsKey(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL)) {
				ArrayList<SrvReactDTO> reactalls = reactht.get(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL);
				if (reactalls.size() > 1) {
					throw new ExcludeAllOrSrvMultiException(); // 医嘱保存时，医嘱项目中存在多个全排项目错误！
				}
				if (reactht.size() > 1) {
					throw new ExcludeAllGrpInCoExistException();// 医嘱保存时，医嘱项目中全排与组内排斥项目同时存在错误!
				}

				// 医嘱开立时，互斥医嘱有效性检查处理
				errorList.addAll(ciOrOpenSrvReactOrsHandle(id_pi, id_pv, id_or, id_srvreacts, openOrDts, true));
			} else {
				if (reactht.size() > 0) {// 组内排斥医嘱的情况
					ArrayList<SrvReactDTO> grpinreactlist = null;
					for (String key : reactht.keySet()) {
						grpinreactlist = reactht.get(key);
						if (grpinreactlist != null && grpinreactlist.size() > 1) {
							errorList.add("医嘱保存时，医嘱项目中同组内排斥项目同时存在错误！");
						}
					}
				}
				// 医嘱开立时，互斥医嘱有效性检查处理
				errorList.addAll(ciOrOpenSrvReactOrsHandle(id_pi, id_pv, id_or, id_srvreacts, openOrDts, false));

			}
			if (!CiOrdUtils.isEmpty(errorList)) {
				if (errorList.size() > 0) {
					errorEmsList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errorList));
				}
			}
		}
		return errorEmsList;
	}

	private String getSrv4EmsCondStr(Object[] objEms) {
		String rtnstr = "";
		int iN = 0;

		for (Object objModel : objEms) {
			OrderListViewDTO viewDTO = (OrderListViewDTO) objModel;
			rtnstr += CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR + viewDTO.getId_srv()
					+ CiOrdUtils.SQUOTE_MARK_STR;
			iN++;
		}
		if (iN == 0)
			return null;
		rtnstr = rtnstr.substring(1);
		if (iN == 1)
			return CiOrdUtils.EQUAL_STR + rtnstr;
		return CiOrdUtils.IN_STR_WITHBLANK + CiOrdUtils.LBRACE_STR + rtnstr + CiOrdUtils.RBRACE_STR;
	}

	/**
	 * 医嘱开立时，互斥医嘱有效性检查处理
	 * 
	 * @param id_pi
	 * @param id_pv
	 * @param id_or
	 * @param id_srvreacts
	 * @param openOrDts
	 * @param isAllExclude
	 * @return
	 * @throws BizException
	 */
	private List<String> ciOrOpenSrvReactOrsHandle(String id_pi, String id_pv, String id_or, String id_srvreacts,
			FDateTime[] openOrDts, boolean isAllExclude) throws BizException {
		// 获得互斥医嘱相关数据信息
		OrOpenSrvReactDTO[] reactOrinfos = getCiOrOpenSrvReactOrSrvInfo(id_pi, id_pv, id_or, id_srvreacts);
		List<String> errorList = new ArrayList<String>();
		// 有效性检查
		if (CiOrdUtils.isEmpty(reactOrinfos))
			return errorList;
		String errMsg = "";
		// 时间重叠性检查
		for (int i = 0; i < reactOrinfos.length; i++) {
			if (isAllExclude) {
				errMsg += reactOrinfos[i].getName_srv() + CiOrdUtils.CRLF;
			} else {
				if (isTimeOverlapped(new FDateTime[] { reactOrinfos[i].getDt_effe(), reactOrinfos[i].getDt_end() },
						openOrDts)) {
					errMsg += reactOrinfos[i].getName_srv() + CiOrdUtils.CRLF;
				}
			}

		}

		// 异常情况处理
		if (!CiOrdUtils.isEmpty(errMsg)) {
			if (isAllExclude) {
				errorList.add("医嘱开立时，存在如下全排斥医嘱：" + CiOrdUtils.CRLF + errMsg + "请处理完毕后再开立本医嘱！");
			} else {
				errorList.add("医嘱开立时，存在如下开始结束重叠医嘱：" + CiOrdUtils.CRLF + errMsg + "请处理完毕后再开立本医嘱！");
			}
		}
		return errorList;
	}

	/**
	 * 医嘱开立时，与其互斥医嘱信息数据
	 * 
	 * @param id_pi
	 * @param id_pv
	 * @param id_or
	 * @param id_srvreact
	 * @return
	 * @throws BizException
	 */
	private OrOpenSrvReactDTO[] getCiOrOpenSrvReactOrSrvInfo(String id_pi, String id_pv, String id_or,
			String id_srvreacts) throws BizException {
		String qrySql = " select distinct A.id_or,A.Dt_Effe,A.Dt_End,B.Sd_Su_Mp,B.Id_Srv,B.Name as name_srv,A.Content_Or "
				+ " from ci_order A " + " inner join ci_or_srv B on A.id_or=B.Id_Or "
				+ " where A.Id_Pat=? and A.id_en=? " + getCond_IdOr(id_or)
				+ "and A.ds=0  and a.sd_su_or !='60' and (A.Fg_Canc='N' and A.Fg_stop='N'  and B.Sd_Su_Mp='"
				+ ICiDictCodeConst.SD_SU_MP_NONE + "') "
				+ " and B.Id_Srv in (select id_srv from  bd_srv_react_itm where " + getCond_IdSrvReact(id_srvreacts)
				+ ") ";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pi);
		sqlParam.addParam(id_pv);
		if (!CiOrdUtils.isEmpty(id_or)) {
			sqlParam.addParam(id_or);
		}
		if (!CiOrdUtils.isInStr(CiOrdUtils.COMMA_STR, id_srvreacts)) {
			sqlParam.addParam(id_srvreacts);
		}
		List<OrOpenSrvReactDTO> srvReacts = (List<OrOpenSrvReactDTO>) new DAFacade().execQuery(qrySql, sqlParam,
				new BeanListHandler(OrOpenSrvReactDTO.class));
		if (srvReacts != null) {
			return srvReacts.toArray(new OrOpenSrvReactDTO[0]);
		}
		return null;
	}

	/**
	 * 获得互斥条件串
	 * 
	 * @return
	 */
	private String getCond_IdSrvReact(String id_srvreacts) {
		if (CiOrdUtils.isInStr(CiOrdUtils.COMMA_STR, id_srvreacts)) {
			String _id_srvreacts = CiOrdUtils.SQUOTE_MARK_STR
					+ id_srvreacts.replaceAll(CiOrdUtils.COMMA_STR,
							CiOrdUtils.SQUOTE_MARK_STR + CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR)
					+ CiOrdUtils.SQUOTE_MARK_STR;
			return "  id_srvreact in " + CiOrdUtils.LBRACE_STR + _id_srvreacts + CiOrdUtils.RBRACE_STR;
		} else {
			return " id_srvreact=? ";
		}
	}

	/**
	 * 获得医嘱条件串
	 * 
	 * @return
	 */
	private String getCond_IdOr(String id_or) {
		if (CiOrdUtils.isEmpty(id_or))
			return "";
		return " and A.Id_Or!=? ";
	}

	/**
	 * 重叠时间判断
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	private boolean isTimeOverlapped(FDateTime[] dt1, FDateTime[] dt2) {
		FDateTime[] dt = OrSrvSplitUtil.getValidStartEndDT(dt1, dt2);
		if (dt == null)
			return false;
		return true;
	}

	/**
	 * 查询互斥的服务对象
	 * 
	 * @param id_srv
	 * @return
	 * @throws DAException
	 */
	private SrvReactDTO[] getSrvReactInfos(String id_srv) throws DAException {
		String srvReactSql = "select A.Id_Srvreact,A.Code,A.Name,A.Sd_Reacttp,B.ID_SRV "
				+ " from bd_srv_react A inner join bd_srv_react_itm B ON A.Id_Srvreact=B.Id_Srvreact "
				+ " where B.Id_Srv = ? order by sd_reacttp,id_srvreact ";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_srv);
		List<SrvReactDTO> srvReacts = (List<SrvReactDTO>) new DAFacade().execQuery(srvReactSql, sqlParam,
				new BeanListHandler(SrvReactDTO.class));
		if (srvReacts != null) {
			return srvReacts.toArray(new SrvReactDTO[0]);
		}
		return null;
	}
}
