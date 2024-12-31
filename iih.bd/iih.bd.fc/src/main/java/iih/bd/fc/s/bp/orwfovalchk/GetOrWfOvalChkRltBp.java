package iih.bd.fc.s.bp.orwfovalchk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.bdwfdepctr.d.BdWfDepCtrDO;
import iih.bd.fc.bdwfdepctr.d.DgCtrEnum;
import iih.bd.fc.bdwfdepctr.i.IBdwfdepctrRService;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkOrDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltItmDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkSrvDTO;
import iih.bd.fc.wf.d.EnumFLowTp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescUtil;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescription;

/**
 * 获取医嘱流向整体校验结果
 * 
 * @author xuxing_2018年6月26日17:30:10
 * @version xuxing_2018年7月26日11:12:19,自备药无物资流向,修正循环空集合的bug，增加物品标识作为药品数量和排斥的依据
 * @version xuxing_2018年7月27日08:45:17_修改自备药物资科室空引起的空指针
 * @version xuxing_2018年7月30日11:35:261_药品数量，科室排斥基于第二次配液标识
 * @version xuxing_2018年7月30日17:02:47_友好整体校验提示
 * @version xuxing_2018年7月31日14:51:58_科室校验无需重复
 * @version xuxing_2018年8月1日10:33:47_二次配液标记改为目标科室外执行
 * @version dukx_2019年12月20日11:57:01_基础校验改为根据医嘱编码进行校验
 */
public class GetOrWfOvalChkRltBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 */
	public OrWfOvalChkRltDTO[] exec(OrWfOvalChkOrDTO[] params) throws BizException {

		// 1、基础校验
		String code_entp = validation(params);

		// 2、获取涉及的全部科室信息
		String[] id_deps = getDepIds(params);

		// 3、获取全部医嘱流向整体控制信息
		BdWfDepCtrDO[] wfDepCtrls = getWfDepCtrInfo(id_deps, code_entp);

		// 4、流向整体校验
		OrWfOvalChkRltDTO[] rtns = handle(params, wfDepCtrls);

		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private String validation(OrWfOvalChkOrDTO[] params) throws BizException {
		if (params == null || params.length < 1)
			throw new BizException("医嘱流向整体校验，入参空异常！");
		List<String> listOr = new ArrayList<String>();
		String code_entp = "";
		for (OrWfOvalChkOrDTO param : params) {
			if (listOr.contains(param.getCode_or()))
				throw new BizException("医嘱流向整体校验，医嘱【" + param.getCode_or()+ "】重复异常！");
			if (StringUtil.isEmptyWithTrim(param.getCode_entp()))
				throw new BizException("医嘱流向整体校验，就诊类型空异常！");
			if (StringUtil.isEmptyWithTrim(code_entp)) {
				code_entp = param.getCode_entp();
			} else {
				if (!code_entp.equals(param.getCode_entp()))
					throw new BizException("医嘱流向整体校验，就诊类型必须一致！");
			}
			if (param.getArraysrv() == null || param.getArraysrv().size() < 1)
				throw new BizException("医嘱流向整体校验，医嘱项目异常！");
			for (Object obj : param.getArraysrv()) {
				OrWfOvalChkSrvDTO srvParam = (OrWfOvalChkSrvDTO) obj;
				if (srvParam == null)
					throw new BizException("医嘱流向整体校验，医嘱项目信息中有空数据！");
				if (StringUtil.isEmptyWithTrim(srvParam.getSd_srvtp()))
					throw new BizException("医嘱流向整体校验，医嘱项目信息服务类型空异常！");
				// 非临床项目，执行和物资流向无必须有值校验
				if (FBoolean.FALSE.equals(srvParam.getFg_or()))
					continue;
				if (StringUtil.isEmptyWithTrim(srvParam.getId_dep_mp()))
					throw new BizException("医嘱流向整体校验，医嘱项目信息执行流向科室空异常！");
				// xuxing_2018年7月26日11:18:11_自备药无物资流向
				// if (StringUtil.isEmptyWithTrim(srvParam.getId_dep_wh()))
				// throw new BizException("医嘱流向整体校验，医嘱项目信息物资流向科室空异常！");
			}
			listOr.add(param.getId_or());
		}
		return code_entp;
	}

	/**
	 * 获取涉及的全部科室信息
	 * 
	 * @param params
	 * @return
	 */
	private String[] getDepIds(OrWfOvalChkOrDTO[] params) {
		List<String> reList = new ArrayList<String>();
		for (OrWfOvalChkOrDTO param : params) {
			for (Object obj : param.getArraysrv()) {
				OrWfOvalChkSrvDTO srvParam = (OrWfOvalChkSrvDTO) obj;
				// 2018年7月3日14:39:04过滤空的科室属性
				if (!reList.contains(srvParam.getId_dep_mp()) && !StringUtil.isEmptyWithTrim(srvParam.getId_dep_mp()))
					reList.add(srvParam.getId_dep_mp());
				if (!reList.contains(srvParam.getId_dep_wh()) && !StringUtil.isEmptyWithTrim(srvParam.getId_dep_wh()))
					reList.add(srvParam.getId_dep_wh());
			}
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 获取全部医嘱流向整体控制信息
	 * 
	 * @param id_deps
	 * @return
	 * @throws BizException
	 */
	private BdWfDepCtrDO[] getWfDepCtrInfo(String[] id_deps, String code_entp) throws BizException {
		BdWfDepCtrDO[] rtns = ServiceFinder.find(IBdwfdepctrRService.class).findByAttrValStrings(BdWfDepCtrDO.ID_DEP, id_deps);
		List<BdWfDepCtrDO> reList = new ArrayList<BdWfDepCtrDO>();
		if (rtns != null && rtns.length > 0) {
			// 2018年7月26日11:19:09,修正循环空集合的bug
			for (BdWfDepCtrDO bdWfDepCtrDO : rtns) {
				if (code_entp.equals(bdWfDepCtrDO.getCode_entp()))
					reList.add(bdWfDepCtrDO);
			}
		}
		return reList.toArray(new BdWfDepCtrDO[0]);
	}

	/**
	 * 流向整体校验
	 * 
	 * @param params
	 * @param wfDepCtrls
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OrWfOvalChkRltDTO[] handle(OrWfOvalChkOrDTO[] params, BdWfDepCtrDO[] wfDepCtrls) throws BizException {
		List<OrWfOvalChkRltDTO> reList = new ArrayList<OrWfOvalChkRltDTO>();
		HashMap<String, BdWfDepCtrDO> mapMpdep = getWfDepCtrlMap(EnumFLowTp.EXECUTEFLOW, wfDepCtrls);
		HashMap<String, BdWfDepCtrDO> mapWhdep = getWfDepCtrlMap(EnumFLowTp.SUPPLIESFLOW, wfDepCtrls);
		for (OrWfOvalChkOrDTO param : params) {
			int orLength = getOrLength(param, "01");
			OrWfOvalChkRltDTO rtn = new OrWfOvalChkRltDTO();
			rtn.setId_or(param.getId_or());// 医嘱ID
			rtn.setCode_or(param.getCode_or());//医嘱编码
			rtn.setFg_success(FBoolean.TRUE);// 校验成功
			reList.add(rtn);
			// 记录项目异常信息
			FArrayList arrayRes = new FArrayList();
			List<String> errorDept = new ArrayList<String>();
			for (Object obj : param.getArraysrv()) {
				OrWfOvalChkSrvDTO srvParam = (OrWfOvalChkSrvDTO) obj;
				// 流向整体控制规则
				BdWfDepCtrDO wfOvalCtrl = null;
				// 本次需要校验的科室所在入参中的属性
				String name_dep_attr = "";
				// 执行流向
				if (mapMpdep.containsKey(srvParam.getId_dep_mp())) {
					wfOvalCtrl = mapMpdep.get(srvParam.getId_dep_mp());
					name_dep_attr = "Id_dep_mp";
				}
				// 2018年7月26日11:22:58_xuxing_物资流向有可能为空，比如自备药
				// 物资流向
				if (!StringUtil.isEmptyWithTrim(srvParam.getId_dep_wh()) && mapWhdep.containsKey(srvParam.getId_dep_wh())) {
					wfOvalCtrl = mapWhdep.get(srvParam.getId_dep_wh());
					name_dep_attr = "Id_dep_wh";
				}

				// 当前的方式无匹配规则
				if (StringUtil.isEmptyWithTrim(name_dep_attr) || wfOvalCtrl == null)
					continue;

				// 记录校验不通过的科室_xuxing_2018年7月31日14:42:47，一个科室异常之后后续相同科室不做校验
				if (errorDept.contains(wfOvalCtrl.getId_dep()))
					continue;
				errorDept.add(wfOvalCtrl.getId_dep());

				// 加急匹配
				if (!isEnumAndBoolMatch(wfOvalCtrl.getEu_urgentctr(), param.getFg_urgent())) {
					String msg = DgCtrEnum.LIMIT_TRUE.equals(wfOvalCtrl.getEu_urgentctr()) ? "必须加急" : "不允许加急";
					OrWfOvalChkRltItmDTO error = initErrorMsg(srvParam, "01", "加急标志不符", "科室【" + wfOvalCtrl.getDep_name() + "】" + msg + "！");
					arrayRes.add(error);
					continue;
				}
				// 药品数量匹配
				if (orLength < wfOvalCtrl.getItmcnt_min() || orLength > wfOvalCtrl.getItmcnt_max()) {
					String msg = orLength < wfOvalCtrl.getItmcnt_min() ? ("限定医嘱内药品数量种类不得小于" + wfOvalCtrl.getItmcnt_min()) : ("限定医嘱内药品数量种类不得大于" + wfOvalCtrl.getItmcnt_max());
					OrWfOvalChkRltItmDTO error = initErrorMsg(srvParam, "02", "药品项目数不符", "科室【" + wfOvalCtrl.getDep_name() + "】" + msg + "！");
					arrayRes.add(error);
					continue;
				}
				// 是否是排斥科室
				if (FBoolean.TRUE.equals(wfOvalCtrl.getFg_redep()) && isDepExclude(param.getArraysrv(), name_dep_attr, wfOvalCtrl.getId_dep())) {
					OrWfOvalChkRltItmDTO error = initErrorMsg(srvParam, "03", "排斥其他科室", "科室【" + wfOvalCtrl.getDep_name() + "】不允许同医嘱内有其他科室！");
					arrayRes.add(error);
					continue;// 科室排斥
				}
				// 出院带药
				if (!isEnumAndBoolMatch(wfOvalCtrl.getEu_presoutpctr(), param.getFg_pres_outp())) {
					String msg = DgCtrEnum.LIMIT_TRUE.equals(wfOvalCtrl.getEu_presoutpctr()) ? "必须是出院带药" : "不允许出院带药";
					OrWfOvalChkRltItmDTO error = initErrorMsg(srvParam, "04", "出院带药标识不符", "科室【" + wfOvalCtrl.getDep_name() + "】" + msg + "！");
					arrayRes.add(error);
					continue;
				}
			}
			// 含有异常信息，有异常的开立
			if (arrayRes.size() > 0) {
				rtn.setFg_success(FBoolean.FALSE);
				rtn.setArraymsg(arrayRes);
			}
		}
		return reList.toArray(new OrWfOvalChkRltDTO[0]);
	}

	/**
	 * 实例化异常信息
	 * 
	 * @param sd_msg
	 * @param name_msg
	 * @param des_msg
	 * @return
	 */
	private OrWfOvalChkRltItmDTO initErrorMsg(OrWfOvalChkSrvDTO srvParam, String sd_msg, String name_msg, String des_msg) {
		OrWfOvalChkRltItmDTO error = new OrWfOvalChkRltItmDTO();
		error.setId_orsrv(srvParam.getId_orsrv());
		error.setId_or(srvParam.getId_or());
		error.setSd_msg(sd_msg);
		error.setName_msg(name_msg);
		error.setDes_msg(des_msg);
		return error;
	}

	/**
	 * 加急匹配
	 * 
	 * @param eu_urgent
	 * @param fg_urgent
	 * @return
	 */
	private boolean isEnumAndBoolMatch(Integer eu_enum, FBoolean fg_bool) {
		// 不限制
		if (eu_enum == DgCtrEnum.NOLIMIT)
			return true;
		// 加急
		if (eu_enum == DgCtrEnum.LIMIT_TRUE && FBoolean.TRUE.equals(fg_bool))
			return true;
		// 不加急
		if (eu_enum == DgCtrEnum.LIMIT_FALSE && FBoolean.FALSE.equals(fg_bool))
			return true;
		return false;
	}

	/**
	 * 获取加急枚举特性值
	 * 
	 * @param eu_urgent
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getUrgentMsg(Integer eu_urgent) {
		EnumDescription des = EnumDescUtil.getEnumDescriptionByValue(DgCtrEnum.class, eu_urgent);
		if (des != null)
			return des.getName();
		return "";
	}

	/**
	 * 排斥科室校验
	 * 
	 * @param arraySrv
	 * @param name_dep_attr
	 * @param id_dep
	 * @return
	 */
	private boolean isDepExclude(FArrayList arraySrv, String name_dep_attr, String id_dep) {
		for (Object obj : arraySrv) {
			OrWfOvalChkSrvDTO srvParam = (OrWfOvalChkSrvDTO) obj;
			// xuxing_2018年7月30日11:21:59_增加了目标科室外执行标志
			if (FBoolean.TRUE.equals(srvParam.getFg_outdeptadmt()))
				continue;
			// 非物品，不做校验
			if (FBoolean.FALSE.equals(srvParam.getFg_mm()))
				continue;
			// xuxing_2018年7月27日08:45:17_修自备药物资科室空引起的空指针
			String id_dep_trg = "";
			if (srvParam.getAttrVal(name_dep_attr) != null)
				id_dep_trg = srvParam.getAttrVal(name_dep_attr).toString();
			if (!id_dep.equals(id_dep_trg))
				return true;
		}
		return false;
	}

	/**
	 * 获取指定流向下的全部科室
	 * 
	 * @param eu_wftp
	 * @param wfDepCtrls
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, BdWfDepCtrDO> getWfDepCtrlMap(Integer eu_wftp, BdWfDepCtrDO[] wfDepCtrls) throws BizException {
		HashMap<String, BdWfDepCtrDO> reMap = new HashMap<String, BdWfDepCtrDO>();
		if (wfDepCtrls != null && wfDepCtrls.length > 0) {
			for (BdWfDepCtrDO bdWfDepCtrDO : wfDepCtrls) {
				if (eu_wftp.equals(bdWfDepCtrDO.getEu_wftp())) {
					if (reMap.containsKey(bdWfDepCtrDO.getId_dep()))
						throw new BizException("医嘱流向整体校验，流向类型为【" + eu_wftp + "】的科室【" + bdWfDepCtrDO.getDep_name() + "】重复！");
					reMap.put(bdWfDepCtrDO.getId_dep(), bdWfDepCtrDO);
				}
			}
		}
		return reMap;
	}

	/**
	 * 获取临床项目服务长度
	 * 
	 * @param param
	 * @return
	 */
	private int getOrLength(OrWfOvalChkOrDTO param, String sd_srvtp) {
		int reInt = 0;
		for (Object obj : param.getArraysrv()) {
			OrWfOvalChkSrvDTO srvParam = (OrWfOvalChkSrvDTO) obj;
			if (!StringUtil.isEmptyWithTrim(sd_srvtp) && srvParam.getSd_srvtp().indexOf(sd_srvtp) != 0)
				continue;
			// 2018年7月30日11:19:14_xuxing_药品数量基于目标科室外执行标识
			if (FBoolean.FALSE.equals(srvParam.getFg_outdeptadmt())) {
				// 临床项目服务长度=》物品标识项目长度
				if (FBoolean.TRUE.equals(srvParam.getFg_mm()))
					reInt++;
			}
		}
		return reInt;
	}
}
