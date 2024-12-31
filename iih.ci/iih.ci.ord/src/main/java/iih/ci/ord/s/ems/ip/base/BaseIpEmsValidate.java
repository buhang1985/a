package iih.ci.ord.s.ems.ip.base;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.ExcludeAllGrpInCoExistException;
import iih.ci.ord.s.bp.exception.ExcludeAllOrSrvMultiException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.srvreact.d.OrOpenSrvReactDTO;
import iih.en.pv.dto.d.IpBasicDTO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站医疗单校验基类
 * 
 * @author wangqingzhu
 *
 */
public class BaseIpEmsValidate implements IEmsValidate {
	protected CiEnContextDTO ciEnContextInfo;

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		ciEnContextInfo = ctx;
		ErrorEmsList errorEmsList = new ErrorEmsList();
		
		//检验患者是否在院、患者是否转科
		List<String> entErrorList = entStatusValidate(ctx.getId_en(),ctx.getId_dep_en(),ctx.getId_dep_ns());
		if(!entErrorList.isEmpty()){
			errorEmsList.add(new ErrorEmsDTO("", "", entErrorList));
			return errorEmsList;
		}
		FDateTime dt_inhos = OrderUtils.getInHosTime(ctx.getId_en());
		for (Object objModel : objEms) {
			OrderListViewDTO viewDTO = (OrderListViewDTO) objModel;
			List<String> errorList = new ArrayList<String>();
			if (CiOrdUtils.isEmpty(viewDTO.getQuan_med()) || viewDTO.getQuan_med().doubleValue() <= 0) {
				errorList.add(String.format("【%s】剂量为空！", viewDTO.getName_srv()));
			}
			// 物品校验剂量单位、血液类校验、Always 医嘱校验
			if (CiOrdUtils.isEmpty(viewDTO.getId_unit_med())
					&& (CiOrdUtils.isTrue(viewDTO.getFg_mm()) || viewDTO.getSd_srvtp().startsWith("14")
							|| IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(viewDTO.getSd_frequnitct()))) {
				errorList.add(String.format("【%s】剂量单位为空！", viewDTO.getName_srv()));
			}
			if (IBdSrvDictCodeConst.SD_TOTALOPENMODE_CYCLE.equals(viewDTO.getSd_totalopenmode())
					&& CiOrdUtils.isEmpty(viewDTO.getId_freq())) {
				errorList.add(String.format("【%s】频次为空！", viewDTO.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(viewDTO.getId_dep_mp())) {
				errorList.add(String.format("【%s】执行科室为空！", viewDTO.getName_srv()));
			}
			if (CiOrdUtils.isEmpty(viewDTO.getDt_effe())) {
				errorList.add(String.format("【%s】开始时间为空！", viewDTO.getName_srv()));
			} else {
				if (viewDTO.getDt_effe().before(dt_inhos)) {
					errorList.add(String.format("【%s】开始时间不能在入科时间[%s]之前！", viewDTO.getName_srv(), dt_inhos));
				}
			}
			if (!CiOrdUtils.isEmpty(viewDTO.getDt_end()) && viewDTO.getDt_end().before(viewDTO.getDt_effe())) {
				errorList.add(String.format("【%s】停止时间不能在开始时间[%s]之前！", viewDTO.getName_srv(), viewDTO.getDt_effe()));
			}
			if (!CiOrdUtils.validateFreqAndQuanMedu(viewDTO.getId_freq(), viewDTO.getId_unit_med()).booleanValue()) {
				errorList.add(String.format("【%s】频次为持续类型时，单位应为时间类型！", viewDTO.getName_srv(), viewDTO.getDt_effe()));
			}
			if(FBoolean.TRUE.equals(viewDTO.getFg_bl())&&(viewDTO.getPri()==null||FDouble.ZERO_DBL.compareTo(viewDTO.getPri())>=0)){
				errorList.add(String.format("【%s】价格为0异常！", viewDTO.getName_srv()));
			}
			//手工划价 价格不能为空
			if("1".equals(viewDTO.getEu_blmd()) && (viewDTO.getPri()==null||FDouble.ZERO_DBL.compareTo(viewDTO.getPri())>=0)) {
				errorList.add(String.format("【%s】手工划价，价格不能为空！", viewDTO.getName_srv()));
			}
			if (errorList.size() > 0) {
				errorEmsList.add(new ErrorEmsDTO(viewDTO.getCode_or(), viewDTO.getName_srv(), errorList));
			}

		}

		return errorEmsList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		ErrorEmsList errorEmsList = new ErrorEmsList();
		for (Object obj : szOrderPackage) {
			OrderPackageInfo pakInfo = (OrderPackageInfo) obj;
			List<String> errorList = new ArrayList<String>();
			CiOrderDO[] orders = CiOrdAppUtils.getOrQryService().findByAttrValString(CiOrderDO.CODE_OR,
					pakInfo.getOrderInfo().getCode_or());
			if (!CiOrdUtils.isEmpty(orders) && orders.length > 0 && pakInfo.getOrderInfo().getStatus()== DOStatus.NEW) {
				errorList.add(String.format("医嘱编码【%s】已存在，请刷新页面数据！", pakInfo.getOrderInfo().getCode_or()));
			}
			if (errorList.size() > 0) {
				StringBuilder strbu = new StringBuilder();
				for (int i = 0; i < errorList.size(); i++) {
					strbu.append(i + 1).append("、").append(errorList.get(i));
				}
				errorEmsList.add(new ErrorEmsDTO(pakInfo.getOrderInfo().getCode_or(),
						pakInfo.getOrderInfo().getName_or(), strbu.toString()));
			}

		}
		return errorEmsList;
	}

	/**
	 * 医嘱互斥校验
	 * 
	 * @param objEms
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected ErrorEmsList verifyMutuallyExclusive(Object[] objEms, CiEnContextDTO ctx) throws BizException {
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
			String id_pat = ctx.getId_pat();
			String id_en = ctx.getId_en();
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
				errorList.addAll(ciOrOpenSrvReactOrsHandle(id_pat, id_en, id_or, id_srvreacts, openOrDts, true));
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
				errorList.addAll(ciOrOpenSrvReactOrsHandle(id_pat, id_en, id_or, id_srvreacts, openOrDts, false));

			}
			if (errorList.size() > 0) {
				StringBuilder strbu = new StringBuilder();
				for (int i = 0; i < errorList.size(); i++) {
					strbu.append(i + 1).append("、").append(errorList.get(i));
				}
				errorEmsList.add(new ErrorEmsDTO(viewDTO.getCode_or(), viewDTO.getName_srv(), strbu.toString()));
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
	 * @param id_pat
	 * @param id_en
	 * @param id_or
	 * @param id_srvreacts
	 * @param openOrDts
	 * @param isAllExclude
	 * @return
	 * @throws BizException
	 */
	private List<String> ciOrOpenSrvReactOrsHandle(String id_pat, String id_en, String id_or, String id_srvreacts,
			FDateTime[] openOrDts, boolean isAllExclude) throws BizException {
		// 获得互斥医嘱相关数据信息
		OrOpenSrvReactDTO[] reactOrinfos = getCiOrOpenSrvReactOrSrvInfo(id_pat, id_en, id_or, id_srvreacts);
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
	 * @param id_pat
	 * @param id_en
	 * @param id_or
	 * @param id_srvreact
	 * @return
	 * @throws BizException
	 */
	private OrOpenSrvReactDTO[] getCiOrOpenSrvReactOrSrvInfo(String id_pat, String id_en, String id_or,
			String id_srvreacts) throws BizException {
		String qrySql = " select distinct A.id_or,A.Dt_Effe,A.Dt_End,B.Sd_Su_Mp,B.Id_Srv,B.Name as name_srv,A.Content_Or "
				+ " from ci_order A " + " inner join ci_or_srv B on A.id_or=B.Id_Or "
				+ " where A.Id_Pat=? and A.id_en=? " + getCond_IdOr(id_or)
				+ "and A.ds=0  and a.sd_su_or !='60' and (A.Fg_Canc='N' and A.Fg_stop='N'  and B.Sd_Su_Mp='"
				+ ICiDictCodeConst.SD_SU_MP_NONE + "') "
				+ " and B.Id_Srv in (select id_srv from  bd_srv_react_itm where " + getCond_IdSrvReact(id_srvreacts)
				+ ") ";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pat);
		sqlParam.addParam(id_en);
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
	/**
	 * 校验患者的就诊状态
	 * @param id_en
	 * @param id_dep_phy
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	private List<String> entStatusValidate(String id_en,String id_dep_phy,String id_dep_nur) throws BizException{
		List<String> errorInfos = new ArrayList<String>();
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		IpBasicDTO basicDto = (IpBasicDTO)new DAFacade().execQuery(getEntStr(), param, new BeanHandler(IpBasicDTO.class));
		//IpBasicDTO basicDto = CiOrdAppUtils.getIEQryService().getIpBasicInfo(id_en);
		if(!CiOrdUtils.isEmpty(basicDto.getSd_status())){
			if(basicDto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT)||basicDto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT)) throw new BizException("患者当前已经不在院，无法操作医嘱，请重新登录医生站!");
			if(!basicDto.getId_dep_phy().equals(id_dep_phy)) {
				errorInfos.add("患者已进行转科操作，无法操作医嘱！");
			}else if(!CiOrdUtils.isEmpty(id_dep_nur)&&!basicDto.getId_dep_nur().equals(id_dep_nur)) {
				errorInfos.add("患者已进行转科操作，无法操作医嘱！");
			}
		}
		return errorInfos;
	}
	private String getEntStr(){
		StringBuilder sb = new StringBuilder();
		sb.append("select ip.sd_status, "); 
		sb.append("case when dep.id_dep_trans is null "); 
		sb.append("then e.id_dep_phy else dep.id_dep_to end as id_dep_phy, "); 
		sb.append("case when dep.id_dep_trans is null ");
		sb.append("then e.id_dep_nur else dep.id_dep_nur_to end as id_dep_nur ");
		sb.append("from en_ent e "); 
		sb.append("left join en_ent_ip ip on e.id_ent = ip.id_ent "); 
		sb.append("left join en_dep_trans dep "); 
		sb.append("on e.id_ent = dep.id_ent and dep.eu_trans='0' "); 
		sb.append("where e.id_ent=? and rownum=1");
		return sb.toString();
	}
}
