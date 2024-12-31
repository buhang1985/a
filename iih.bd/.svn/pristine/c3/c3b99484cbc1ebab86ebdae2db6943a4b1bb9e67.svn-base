package iih.bd.fc.s.bp.orpltpmtpara;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.i.IOrpltpMDORService;
import iih.bd.fc.orpltpmtpara.d.EnumSkinTest;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱闭环匹配算法
 * 
 * @author xuxing_2016-11-07
 *
 */
public class GetOrderOrpltpBp {

	/**
	 * 主入口
	 * 
	 * @param orpltpMatParDTO
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO[] exec(OrpltpMatchParamDTO orpltpMatParDTO) throws BizException {

		// 1、参数校验
		if (orpltpMatParDTO == null) {
			return null;
		}

		// 2、取全部参数
		OrpltpmtParaDO[] paramAll = getOrpltpmtParam();

		// 3、过滤
		OrpltpmtParaDO[] params = filterOrpltpmtParamArray(paramAll, orpltpMatParDTO);

		// 4、获取闭环
		OrpltpDO[] rtn = getOrpltpRes(params);

		return rtn;
	}

	/**
	 * 取全部参数
	 *
	 * @return
	 * @throws BizException
	 */
	private OrpltpmtParaDO[] getOrpltpmtParam() throws BizException {

		IOrpltpmtparaRService findService = ServiceFinder.find(IOrpltpmtparaRService.class);

		OrpltpmtParaDO[] mtParams = findService.find("ds=0", "", FBoolean.FALSE);

		return mtParams;

	}

	/**
	 * 匹配逻辑
	 *
	 * @param orpltpMatParDTO
	 * @return
	 * @throws BizException
	 */
	private OrpltpmtParaDO[] filterOrpltpmtParamArray(OrpltpmtParaDO[] paramAll, OrpltpMatchParamDTO orpltpMatParDTO) throws BizException {

		if (paramAll == null || paramAll.length < 1) {
			return null;
		}

		List<OrpltpmtParaDO> reList = new ArrayList<OrpltpmtParaDO>();

		for (OrpltpmtParaDO paraDO : paramAll) {

			boolean fg_match = false;

			// 就诊类型匹配
			fg_match = isStrsInclude(paraDO.getSd_entps(), orpltpMatParDTO.getCode_entp());

			// 服务类型匹配
			fg_match = fg_match && isStrsIncludePar(paraDO.getSd_srvtps(), orpltpMatParDTO.getSd_srvtp());

			// 服务项目匹配
			fg_match =  fg_match && isStrsInclude(paraDO.getId_srvs(), orpltpMatParDTO.getId_srv());

			// 用法匹配
			fg_match =  fg_match && isStrsInclude(paraDO.getId_routes(), orpltpMatParDTO.getId_route());

			// 皮试匹配
			fg_match =  fg_match && isSkinTest(paraDO.getEu_skintest(), orpltpMatParDTO.getFg_skintest());

			if (fg_match) {
				reList.add(paraDO);
			}
		}

		return reList.toArray(new OrpltpmtParaDO[reList.size()]);
	}

	/**
	 * 获取闭环类型实体
	 *
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrpltpDO[] getOrpltpRes(OrpltpmtParaDO[] param) throws BizException {

		if (param != null && param.length > 0) {

			IOrpltpMDORService findService = ServiceFinder.find(IOrpltpMDORService.class);

			List<String> listOrpltp = new ArrayList<String>();

			for (OrpltpmtParaDO item : param) {

				if (!listOrpltp.contains(item.getId_orpltp())) {

					listOrpltp.add(item.getId_orpltp());
				}
			}

			return findService.findByBIds(listOrpltp.toArray(new String[listOrpltp.size()]), FBoolean.FALSE);
		}

		return null;
	}

	/**
	 * 是否需要皮试
	 *
	 * @param fg_skintest
	 * @param eu_skintest
	 * @return
	 */
	private boolean isSkinTest(Integer eu_skintest, FBoolean fg_skintest) {

		if (EnumSkinTest.UNLIMIT.equals(eu_skintest)) {
			return true;
		}

		if (EnumSkinTest.SKINTEST.equals(eu_skintest) && FBoolean.TRUE.equals(fg_skintest)) {
			return true;
		}

		if (EnumSkinTest.NOSKINTEST.equals(eu_skintest) && FBoolean.FALSE.equals(fg_skintest)) {
			return true;
		}

		return false;
	}

	/**
	 * 字符串包含（键）校验（以逗号分割），字符串和键都非空才校验
	 *
	 * @param strSplit
	 * @param str
	 * @return
	 */
	private boolean isStrsInclude(String strSplit, String str) {

		if (!StringUtil.isEmptyWithTrim(strSplit)) {

			if (StringUtil.isEmpty(str)) {
				return false;
			}

			for (String itm : strSplit.split(",")) {
				if (str.equals(itm)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * 子项中朝上匹配（服务类型）
	 *
	 * @param strSplit
	 * @param str
	 * @return
	 */
	private boolean isStrsIncludePar(String strSplit, String str) {

		if (!StringUtil.isEmptyWithTrim(strSplit)) {

			if (StringUtil.isEmpty(str)) {
				return false;
			}

			for (String itm : strSplit.split(",")) {

				if (str.indexOf(itm) == 0) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

}
