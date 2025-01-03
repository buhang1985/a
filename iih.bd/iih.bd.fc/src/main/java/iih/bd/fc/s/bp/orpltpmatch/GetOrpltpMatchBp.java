package iih.bd.fc.s.bp.orpltpmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.i.IOrpltpMDORService;
import iih.bd.fc.orpltpmatch.d.EnumBool;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.s.bp.orpltpmatch.qry.GetOrpltpMatchAttrSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.paramset.i.ParamsetAccessor;

/**
 * 医嘱闭环匹配算法2018年8月30日11:54:04
 * 
 * @author zhongcl
 * @version xuxing_2018年9月5日15:16:31，迭代
 * @version xuxing_2020年4月18日17:30:38，修正无扩展字段引起药品闭环全部失效问题
 *
 */
public class GetOrpltpMatchBp {

	/**
	 * 主入口
	 * 
	 * @param orpltpMatParDTO
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO exec(OrpltpMatchParamDTO param) throws BizException {

		// 1、基础校验
		validation(param);

		// 2、根据就诊类型获取所有的参数匹配
		OrpltpMatchDO[] params = getOrpltpMatch(param.getCode_entp());

		// 3、实例化用法参数
		initRouteParams(params);

		// 4、匹配逻辑
		OrpltpMatchDO[] matchRes = filterRtn(params, param);

		// 5、权重取最优先的
		OrpltpMatchDO maxMatch = getMaxMatch(matchRes);

		// 6、将过滤后的结果进行匹配
		OrpltpDO rtn = getOrpltpRes(maxMatch);

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
		if (matchDOs == null || matchDOs.length < 1)
			throw new BizException("医嘱闭环匹配数据为空,请检查医嘱闭环匹配数据！");
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
			return;
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
	 * 匹配逻辑
	 * 
	 * @param orpltpMatchs
	 * @param param
	 * @return
	 */
	private OrpltpMatchDO[] filterRtn(OrpltpMatchDO[] orpltpMatchs, OrpltpMatchParamDTO param) {
		List<OrpltpMatchDO> reList = new ArrayList<OrpltpMatchDO>();
		for (OrpltpMatchDO orpltpParam : orpltpMatchs) {
			int power = 0;

			// 服务类型
			int powerSrvtp = getSrvtpPower(orpltpParam.getSd_srvtp(), param.getSd_srvtp());
			if (powerSrvtp == -1)
				continue;
			power += powerSrvtp;

			// 服务
			int powerSrv = getStrMatchPower(orpltpParam.getId_srv(), param.getId_srv());
			if (powerSrv == -1)
				continue;
			power += powerSrv;

			// 用法
			int powerRoute = getStrContasinPower(orpltpParam.getCode_param(), param.getId_route());
			if (powerRoute == -1)
				continue;
			power += powerRoute;

			// 皮试
			int powerSkin = getEnumMatchPower(orpltpParam.getEu_skintest(), param.getFg_skintest());
			if (powerSkin == -1)
				continue;
			power += powerSkin;

			// 在院执行
			int powerMpin = getEnumMatchPower(orpltpParam.getEu_mp_in(), param.getFg_mp_in());
			if (powerMpin == -1)
				continue;
			power += powerMpin;

			// 出院带药
			int powerPreout = getEnumMatchPower(orpltpParam.getEu_pres_outp(), param.getFg_pres_outp());
			if (powerPreout == -1)
				continue;
			power += powerPreout;

			// 在院整领
			int powerWholepack = getEnumMatchPower(orpltpParam.getEu_wholepack(), param.getFg_wholepack());
			if (powerWholepack == -1)
				continue;
			power += powerWholepack;

			// 记录匹配权重
			orpltpParam.setOrpltp_power(power);
			reList.add(orpltpParam);
		}
		return reList.toArray(new OrpltpMatchDO[0]);
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
	 * 单字符是否匹配
	 * 
	 * @param srcStr
	 * @param trgStr
	 * @return
	 */
	private int getStrMatchPower(String srcStr, String trgStr) {
		if (StringUtil.isEmptyWithTrim(srcStr))
			return 0;
		if (StringUtil.isEmptyWithTrim(trgStr))
			return -1;
		if (srcStr.equals(trgStr))
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

	/**
	 * 权重取最优先的
	 * 
	 * @param params
	 * @return
	 */
	private OrpltpMatchDO getMaxMatch(OrpltpMatchDO[] params) {
		if (params == null || params.length < 1)
			return null;
		OrpltpMatchDO max = params[0];
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
	private OrpltpDO getOrpltpRes(OrpltpMatchDO matchParam) throws BizException {
		return ServiceFinder.find(IOrpltpMDORService.class).findById(matchParam.getId_orpltp());
	}
}
