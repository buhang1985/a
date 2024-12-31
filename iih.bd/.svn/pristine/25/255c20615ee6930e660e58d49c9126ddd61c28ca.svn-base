package iih.bd.fc.s.bp.orpltpmatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchMDOCudService;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱闭环匹配保存逻辑 2018年8月28日19:40:04
 * 
 * @author zhongcl
 *
 */
public class SaveOrpltpMatchBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 */
	public OrpltpMatchDO[] exec(OrpltpMatchDO[] params) throws BizException {

		// 1、业务校验
		matchValidation(params);

		// 保存
		OrpltpMatchDO[] opmds = save(params);

		return opmds;
	}

	/**
	 * 参数校验
	 * 
	 * @param params
	 */
	private void matchValidation(OrpltpMatchDO[] params) throws BizException {
		if (params != null && params.length != 0) {
			String idEntp = params[0].getId_entp();
			OrpltpMatchDO[] datas = getOrpltpMatch(idEntp);
			HashMap<String, String> map = new HashMap<String, String>();
			map = toHashMap(datas, map);
			List<OrpltpMatchDO> opmds = new ArrayList<OrpltpMatchDO>();
			for (OrpltpMatchDO opmd : params) {
				if (DOStatus.UNCHANGED != opmd.getStatus() && DOStatus.DELETED != opmd.getStatus()) {
					if (DOStatus.UPDATED == opmd.getStatus()) {
						map.remove(opmd.getId_orpltp_match());
					}
					opmds.add(opmd);
				}
			}
			toHashMap(opmds.toArray(new OrpltpMatchDO[opmds.size()]), map);
		}

	}

	/**
	 * 获取制定就诊类型下的 所有的医嘱闭环匹配信息
	 * 
	 * @param idEntp
	 * @return
	 * @throws BizException
	 */
	private OrpltpMatchDO[] getOrpltpMatch(String idEntp) throws BizException {

		IOrpltpmatchMDORService findService = ServiceFinder.find(IOrpltpmatchMDORService.class);
		StringBuilder condition = new StringBuilder();
		condition.append(OrpltpMatchDO.ID_ENTP + "=" + "'" + idEntp + "'");
		return findService.find(condition.toString(), "", FBoolean.FALSE);
	}

	/**
	 * 将数据拼接然后添加到map中。
	 * 
	 * @param source
	 *            数据源
	 * @param datas
	 *            需添加的map
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, String> toHashMap(OrpltpMatchDO[] source, HashMap<String, String> datas) throws BizException {
		// 将数据库中的医嘱闭环匹配信息拼成字符串，保存在map中
		for (OrpltpMatchDO orpltpMatch : source) {
			String orpStr = generateMapValue(orpltpMatch);
			if (datas.containsValue(orpStr)) {
				throw new BizException("医嘱闭环匹配，服务类型：" + orpltpMatch.getName_srvtp() + "数据重复");
			} else {
				datas.put(orpltpMatch.getId_orpltp_match(), orpStr);
			}
		}

		return datas;
	}

	/**
	 * 将医嘱匹配信息数据拼接成字符串
	 * @param orpltpMatch 医嘱匹配信息
	 * @return
	 */
	private String generateMapValue(OrpltpMatchDO orpltpMatch) {
		StringBuilder orpStr = new StringBuilder();
		orpStr.append(orpltpMatch.getId_orpltp());
		orpStr.append(orpltpMatch.getSd_srvtp());
		orpStr.append(orpltpMatch.getEu_skintest());
		orpStr.append(orpltpMatch.getEu_mp_in());
		orpStr.append(orpltpMatch.getEu_pres_outp());
		orpStr.append(orpltpMatch.getEu_wholepack());
		String idSrv = StringUtils.isNotBlank(orpltpMatch.getId_srv()) ? orpltpMatch.getId_srv() : "null";
		orpStr.append(idSrv);
		String idMpRoute = StringUtils.isNotBlank(orpltpMatch.getId_mp_route()) ? orpltpMatch.getId_mp_route() : "null";
		orpStr.append(idMpRoute);
		return orpStr.toString();
	}

	/**
	 * 保存
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private OrpltpMatchDO[] save(OrpltpMatchDO[] params) throws BizException {
		OrpltpMatchDO[] opmds = ServiceFinder.find(IOrpltpmatchMDOCudService.class).save(params);
		return opmds;
	}

}
