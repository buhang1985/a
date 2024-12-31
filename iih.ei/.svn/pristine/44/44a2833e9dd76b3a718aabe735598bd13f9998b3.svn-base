package iih.ei.std.s.v1.bp.pe.pathgydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfo;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfoResultDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.pathgydata.qry.GetPathgySampInfoSql;
import iih.ei.std.s.v1.bp.mp.pathgydata.qry.QueryIPPathgySql;
import iih.ei.std.s.v1.bp.pe.pathgydata.qry.QueryPePathgySql;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.papt.pepsnappt.i.IPepsnapptRService;
import iih.pe.papt.pepsncatsel.d.PePsnapptCatDO;
import iih.pe.papt.pepsncatsel.i.IPepsncatselRService;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.i.IPepsnbinfoMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 
 * @ClassName: QueryPathgyDataBp
 * @Description: 查询病理申请单信息
 * @author zhy
 * @date 2019年9月27日
 *
 */
public class QueryPePathgyDataBp {

	/**
	 * 程序主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PathgyApplyInfoResultDTO exec(PathgyApplyParamDTO param) throws BizException {

		// 1.获取就诊类型
		String code_entp = param.getCode_entp();

		// 2.查询信息
		PathgyApplyInfo[] applyInfos = queryData(code_entp, param);

		// 3.封装信息
		PathgyApplyInfoResultDTO resultDTO = new PathgyApplyInfoResultDTO();
		resultDTO.setPathgyapplyinfo(ArrayListUtil.ConvertToFArrayList(applyInfos));
		return resultDTO;
	}

	/**
	 * 查询信息
	 * 
	 * @param code_entp
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PathgyApplyInfo[] queryData(String code_entp, PathgyApplyParamDTO param) throws BizException {
		
		// 体检
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)) {
			PathgyApplyInfo[] applyInfos = queryPeData(param);
			return applyInfos;
		}

		return null;
	}

	/**
	 * 获取患者id
	 * 
	 * @param code_user
	 * @param no_applyform
	 * @return
	 * @throws BizException
	 */
	private String getPatID(String code, String no_applyform) throws BizException {

		if (!StringUtil.isEmptyWithTrim(no_applyform)) {
			// 体检唯一码查询
			PePsnapptCatDO[] pePsnapptCatDo = ServiceFinder.find(IPepsncatselRService.class)
					.findByAttrValString(PePsnapptCatDO.NO_APPLY, no_applyform);
			if (pePsnapptCatDo != null && pePsnapptCatDo.length > 0) {
				PePsnApptDO pePsnApptDo = ServiceFinder.find(IPepsnapptRService.class).findById(pePsnapptCatDo[0].getId_pepsnappt());
				if (pePsnapptCatDo != null && pePsnapptCatDo.length > 0) {
					PePsnBInfoDO pePsnBInfoDo = ServiceFinder.find(IPepsnbinfoMDORService.class).findById(pePsnApptDo.getId_pepsnbinfo());
					if (pePsnBInfoDo != null) {
						return pePsnBInfoDo.getId_pat();
					}
				}
			}

		}

		if (!StringUtil.isEmptyWithTrim(code)) {
			// 体检唯一码查询
			PePsnApptDO[] pePsnApptDo = ServiceFinder.find(IPepsnapptRService.class).findByAttrValString(PePsnApptDO.PE_CODE, code);
			PePsnBInfoDO pePsnBInfoDo = ServiceFinder.find(IPepsnbinfoMDORService.class).findById(pePsnApptDo[0].getId_pepsnbinfo());
			if (pePsnBInfoDo != null) {
				return pePsnBInfoDo.getId_pat();
			}
		}

		return null;
	}

	/**
	 * 查询相关病理申请子表（病理标本）数据
	 * 
	 * @param no_applyforms
	 * @return
	 * @throws DAException
	 */
	private List<Map<String, Object>> queryApplySampDTOs(List<String> no_applyforms) throws DAException {
		GetPathgySampInfoSql sql = new GetPathgySampInfoSql(no_applyforms);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> applySamp = (List<Map<String, Object>>) new DAFacade().execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new MapListHandler());
		return applySamp;
	}

	/**
	 * 查询门诊病理数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PathgyApplyInfo[] queryPeData(PathgyApplyParamDTO param) throws BizException {

		// 获取患者id
		String patID = getPatID(param.getCode(), param.getNo_applyform());
		if (StringUtil.isEmptyWithTrim(patID)) {
			throw new BizException("没有找到对应患者信息!");
		}

		QueryPePathgySql sql = new QueryPePathgySql(param, patID);
		List<String> no_applyform = new ArrayList<String>();
		PathgyApplyInfo[] applyInfos = (PathgyApplyInfo[]) AppFwUtil.getDORstWithDao(sql, PathgyApplyInfo.class);
		for (PathgyApplyInfo applyInfo : applyInfos) {
			no_applyform.add(applyInfo.getNo_applyform());
		}
		List<Map<String, Object>> list = queryApplySampDTOs(no_applyform);
		Map<String, List<Map<String, Object>>> bbmc = new HashMap<>();
		for (Map<String, Object> maps : list) {
			if (bbmc.get(maps.get("no_applyform")) == null) {
				List<Map<String, Object>> bbmcList = new ArrayList<>();
				bbmcList.add(maps);
				bbmc.put((String) maps.get("no_applyform"), bbmcList);
			} else {
				bbmc.get(maps.get("no_applyform")).add(maps);
			}
		}
		for (PathgyApplyInfo rtnDto : applyInfos) {
			String name_lab = "";
			List<Map<String, Object>> map = bbmc.get(rtnDto.getNo_applyform());
			for (Map<String, Object> data : map) {
				name_lab += data.get("bbmc") == null ? "" : data.get("bbmc") + ";";
				rtnDto.setName_lab(name_lab);
			}
		}

		// 预交金收费流程模式是执行计费不过滤计费状态
		if (IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(EiParamUtils.BLCG0002())) {
			return applyInfos;
		}

		// 过滤返回结果
		PathgyApplyInfo[] rtnDtos = filterRst(applyInfos);
		if (null == rtnDtos || rtnDtos.length < 1) {
			return null;
		}
		return rtnDtos;
	}

	/**
	 * 过滤返回结果
	 * 
	 * @param applyInfos
	 * @return
	 */
	private PathgyApplyInfo[] filterRst(PathgyApplyInfo[] applyInfos) {
		List<PathgyApplyInfo> reList = new ArrayList<PathgyApplyInfo>();
		if (applyInfos != null && applyInfos.length > 0) {
			for (PathgyApplyInfo rtn : applyInfos) {
				if (rtn.getNum_bl() == 0) {
					// 无需计费的医嘱
					reList.add(rtn);
				} else {
					// 需要计费的医嘱
					if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(rtn.getSd_su_bl())) {
						reList.add(rtn);
					}
				}
			}
		}
		return reList.toArray(new PathgyApplyInfo[reList.size()]);
	}
}
