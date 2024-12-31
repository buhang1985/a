package iih.bd.fc.s.bp.orpltpmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IMpDictCodeConst;
import iih.bd.fc.dto.matchdto.d.AttrMatchBas;
import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.i.IOrpltpMDORService;
import iih.bd.fc.orpltpmatch.d.EnumBool;
import iih.bd.fc.orpltpmatch.d.EnumOrpltpCtrl;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.s.bp.common.LogUtils;
import iih.bd.fc.s.bp.orpltpmatch.qry.GetOrpltpMatchAttrSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.paramset.i.ParamsetAccessor;

/**
 * @Description:医嘱闭环匹配算法
 * @author: tian.cj
 * @version：2019年11月7日 上午10:41:11 创建
 * @version：2020年1月2日 上午10:41:11 增加退药
 * @version：2020年4月1日11:02:14 添加闭环启用条件过滤
 * @version xuxing_2020年4月18日17:30:38，修正无扩展字段引起药品闭环全部失效问题
 */
public class GetOrpltpMatchAttrBp {

	/**
	 * 主入口
	 * 
	 * @param orpltpMatParDTO
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO exec(OrpltpMatchParamDTO param) throws BizException {

		LogUtils log = new LogUtils();
		log.setPoint("医嘱闭环匹配2.0匹配逻辑");

		// 1、基础校验
		validation(param);

		// 2、根据就诊类型获取所有的参数匹配
		OrpltpMatchDO[] params = getOrpltpMatch(param.getCode_entp());

		// 3、实例化用法参数
		initRouteParams(params);

		// 4、数据转换
		AttrMatchBas[] arrtMatchs = dataConvert(params);

		// 5、匹配逻辑
		AttrMatchBas[] rtnMatchs = filterRtn(arrtMatchs, param);

		// 6、权重取最优先的
		AttrMatchBas matchBas = getMaxMatch(rtnMatchs);

		// 7、将过滤后的结果进行匹配
		OrpltpDO rtn = getOrpltpRes(matchBas);

		// 8、错误配置信息写日志
		if (!StringUtil.isEmptyWithTrim(errorMsg))
			new LogUtils().logMsg("医嘱闭环匹配2.0，配置信息错误【" + errorMsg + "】");
		log.setFinishLog();

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validation(OrpltpMatchParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_entp()))
			throw new BizException("医嘱闭环匹配，就诊类型不能为空！");
		if (StringUtil.isEmptyWithTrim(param.getSd_srvtp()))
			throw new BizException("医嘱闭环匹配，服务类型不能为空！");
	}

	/**
	 * 根据就诊类型获取所有的参数匹配
	 * 
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	private OrpltpMatchDO[] getOrpltpMatch(String code_entp) throws BizException {
		GetOrpltpMatchAttrSql sql = new GetOrpltpMatchAttrSql(code_entp);
		OrpltpMatchDO[] matchDOs = (OrpltpMatchDO[]) AppFwUtil.getDORstWithDao(sql, OrpltpMatchDO.class);
		return matchDOs;
	}

	/**
	 * 实例化用法参数
	 * 
	 * @param params
	 * @throws BizException
	 */
	private void initRouteParams(OrpltpMatchDO[] params) throws BizException {
		if (params == null || params.length < 1)
			throw new BizException("医嘱闭环匹配数据为空,请检查医嘱闭环匹配数据！");
		List<String> listParamCode = new ArrayList<String>();
		for (OrpltpMatchDO param : params) {
			if (!StringUtil.isEmptyWithTrim(param.getCode_param()))
				listParamCode.add(param.getCode_param());
		}
		// 批量获取参数值
		Map<String, String> mapParam = ParamsetAccessor.getInstance().queryBatchParaValues(Context.get().getOrgId(), listParamCode.toArray(new String[0]));
		for (OrpltpMatchDO param : params) {
			if (StringUtil.isEmptyWithTrim(param.getCode_param()))
				continue;
			if (mapParam.containsKey(param.getCode_param()))
				param.setCode_param(mapParam.get(param.getCode_param()));
		}
	}

	/**
	 * 数据转换
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private AttrMatchBas[] dataConvert(OrpltpMatchDO[] params) throws BizException {
		OrpltpMatchConvertBp bp = new OrpltpMatchConvertBp();
		return bp.exec(params);
	}

	/**
	 * 匹配逻辑
	 * 
	 * @param orpltpMatchs
	 * @param param
	 * @return
	 */
	private AttrMatchBas[] filterRtn(AttrMatchBas[] orpltpMatchs, OrpltpMatchParamDTO param) {
		List<AttrMatchBas> reList = new ArrayList<AttrMatchBas>();
		for (AttrMatchBas attrbas : orpltpMatchs) {
			int power = 0;

			// 服务类型
			int powerSrvtp = getSrvtpPower(attrbas.getSd_srvtp(), param.getSd_srvtp());
			if (powerSrvtp == -1)
				continue;
			power += powerSrvtp;

			// 用法
			int powerRoute = getStrContasinPower(attrbas.getCode_param(), param.getId_route());
			if (powerRoute == -1)
				continue;
			power += powerRoute;

			// 皮试
			int powerSkin = getEnumMatchPower(attrbas.getEu_skintest(), param.getFg_skintest());
			if (powerSkin == -1)
				continue;
			power += powerSkin;

			// 在院执行
			int powerMpin = getEnumMatchPower(attrbas.getEu_mp_in(), param.getFg_mp_in());
			if (powerMpin == -1)
				continue;
			power += powerMpin;

			// 出院带药
			int powerPreout = getEnumMatchPower(attrbas.getEu_pres_outp(), param.getFg_pres_outp());
			if (powerPreout == -1)
				continue;
			power += powerPreout;

			// 在院整领
			int powerWholepack = getEnumMatchPower(attrbas.getEu_wholepack(), param.getFg_wholepack());
			if (powerWholepack == -1)
				continue;
			power += powerWholepack;

			// 退药标识
			int powerFgBack = getEnumMatchPower(attrbas.getEu_fg_back(), param.getFg_back());
			if (powerFgBack == -1)
				continue;
			power += powerFgBack;

			// 服务
			int powerSrv = getEnumMatchAttrPower(attrbas.getId_orpltp_match_attr(), attrbas.getEu_srv(), attrbas.getListSrv(), param.getId_srv());
			if (powerSrv == -1)
				continue;
			power += powerSrv;

			// 开单科室
			int powerDep = getEnumMatchAttrPower(attrbas.getId_orpltp_match_attr(), attrbas.getEu_dep_or(), attrbas.getListDepor(), param.getId_dep_or());
			if (powerDep == -1)
				continue;
			power += powerDep;

			// 就诊科室
			int powerDepPhy = getEnumMatchAttrPower(attrbas.getId_orpltp_match_attr(), attrbas.getEu_dep_phy(), attrbas.getListDepPhy(), param.getId_dep_phy());
			if (powerDepPhy == -1)
				continue;
			power += powerDepPhy;

			// 就诊开单部门关系
			int powerDepRel = getEnumDepRelPower(param.getId_dep_or(), param.getId_dep_phy(), attrbas.getId_dep_rel());
			if (powerDepRel == -1)
				continue;
			power += powerDepRel;

			// 护理单元
			int powerDepNur = getEnumMatchAttrPower(attrbas.getId_orpltp_match_attr(), attrbas.getEu_dep_nur(), attrbas.getListDepNur(), param.getId_dep_nur());
			if (powerDepNur == -1)
				continue;
			power += powerDepNur;

			// // 领药方式
			// int powerDdm =
			// getEnumMatchAttrPower(attrbas.getId_orpltp_match_attr(),
			// attrbas.getEu_ddm(), attrbas.getListDdm(),
			// param.getSd_drugdeliverymethod());
			// if (powerDdm == -1)
			// continue;
			// power += powerDdm;

			// 记录匹配权重
			attrbas.setOrpltp_power(power);
			reList.add(attrbas);
		}
		return reList.toArray(new AttrMatchBas[0]);
	}

	/**
	 * 获取服务类型权重
	 * 
	 * @param srcSrvtp
	 * @param trgSrvtp
	 * @return
	 */
	private int getSrvtpPower(String srcSrvtp, String trgSrvtp) {
		if (StringUtil.isEmptyWithTrim(trgSrvtp))
			return -1;
		if (srcSrvtp.equals(trgSrvtp))
			return 2;
		if (trgSrvtp.indexOf(srcSrvtp) == 0)
			return 1;
		return -1;
	}

	/**
	 * 单字符是否b包含
	 * 
	 * @param srcStr
	 * @param trgStr
	 * @return
	 */
	private int getStrContasinPower(String srcStrs, String trgStr) {
		if (StringUtil.isEmptyWithTrim(srcStrs))
			return 0;
		if (StringUtil.isEmptyWithTrim(trgStr))
			return -1;
		for (String str : srcStrs.split("\\,")) {
			if (str.equals(trgStr))
				return 1;
		}
		return -1;
	}

	/**
	 * 是否枚举匹配
	 * 
	 * @param enumSrc
	 * @param fg_bln
	 * @return
	 */
	private int getEnumMatchPower(Integer enumSrc, FBoolean fg_bln) {
		if (enumSrc == null)
			return 0;
		if (EnumBool.UNLIMIT == enumSrc)
			return 0;
		if (EnumBool.YES == enumSrc && FBoolean.TRUE.equals(fg_bln))
			return 1;
		if (EnumBool.NO == enumSrc && FBoolean.FALSE.equals(fg_bln))
			return 1;
		return -1;
	}

	private String errorMsg = "";

	/**
	 * 控制属性
	 * 
	 * @param id_wf_cfg
	 * @param eu_ctrl
	 * @param listKey
	 * @param val
	 * @return
	 */
	private int getEnumMatchAttrPower(String id_orpltp_match_attr, Integer eu_ctrl, List<String> listKey, String val) {
		// 未指定是否限制的(之前数据字段为空，用于之前的数据)
		if (eu_ctrl == null)
			return 1;
		// 指定不限制
		if (EnumOrpltpCtrl.NONE == eu_ctrl)
			return 1;
		// 限制集合为空，基础数据维护不正确，当限制失败处理
		if (listKey == null || listKey.size() < 1) {
			// 记录日志
			errorMsg += "【" + id_orpltp_match_attr + "】";
			return -1;
		}
		// 业务值为空
		if (StringUtil.isEmptyWithTrim(val))
			return -1;
		// 控制
		if (EnumOrpltpCtrl.CTRL == eu_ctrl) {
			if (listKey.contains(val)) {
				return 2;
			}
			return -1;
		}
		// 排除
		if (EnumOrpltpCtrl.EXCLUDE == eu_ctrl) {
			if (!listKey.contains(val)) {
				return 2;
			}
			return -1;
		}
		return -1;
	}

	/**
	 * 就诊开单部门关系控制
	 * 
	 * @param id_dep_rel
	 * @param userId_dep_rel
	 * @return
	 */
	private int getEnumDepRelPower(String id_dep_or, String id_dep_phy, String id_dep_rel) {
		// 之前数据库中字段值为空
		if (StringUtil.isEmptyWithTrim(id_dep_rel))
			return 1;
		// 不限制
		if (IMpDictCodeConst.MP_BD_DEPNODE.equals(id_dep_rel))
			return 1;
		if (StringUtil.isEmptyWithTrim(id_dep_or) || StringUtil.isEmptyWithTrim(id_dep_phy))
			return -1;
		if (id_dep_or.equals(id_dep_phy)) {// 就诊科室开单
			if (IMpDictCodeConst.MP_BD_DEPCTRL.equals(id_dep_rel)) {
				return 2;
			}
			if (IMpDictCodeConst.MP_BD_DEPEXCLUDE.equals(id_dep_rel)) {
				return -1;
			}
		} else {// 非就诊科室开单
			if (IMpDictCodeConst.MP_BD_DEPEXCLUDE.equals(id_dep_rel)) {
				return 2;
			}
			if (IMpDictCodeConst.MP_BD_DEPCTRL.equals(id_dep_rel)) {
				return -1;
			}
		}
		return -1;// 错误匹配
	}

	/**
	 * 权重取最优先的
	 * 
	 * @param params
	 * @return
	 */
	private AttrMatchBas getMaxMatch(AttrMatchBas[] params) {
		if (params == null || params.length < 1)
			return null;
		AttrMatchBas max = params[0];
		for (int i = 1; i < params.length; i++) {
			if (params[i].getOrpltp_power() > max.getOrpltp_power())
				max = params[i];
		}
		return max;
	}

	/**
	 * 将过滤后的结果进行匹配
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrpltpDO getOrpltpRes(AttrMatchBas matchParam) throws BizException {
		if (matchParam == null)
			return null;
		return ServiceFinder.find(IOrpltpMDORService.class).findById(matchParam.getId_orpltp());
	}
}
