package iih.mp.nr.opreport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.pres.d.PreSkinTestDTO;
import iih.mp.nr.opreport.qry.GetPreInjectListInfosSql;
import iih.mp.nr.opreport.qry.getGrpNoInfosSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 注射单公共查询
 * 
 * @author fengjj
 * @version:2020年5月3日09:22:22，创建
 * 
 */
public abstract class GetInjectCommonBp {
	/**
	 * 注射单公共查询 入口
	 * 
	 * @param id_or_prs
	 * @return
	 * @throws BizException
	 */
	public List<PreSkinTestDTO> exec(String id_or_prs) throws BizException {
		// 1.参数校验
		validate(id_or_prs);

		// 2.查询数据
		List<PreSkinTestDTO> listDatas = queryData(id_or_prs);

		// 3.设置组号
		setGrpInfo(listDatas);

		// 4.分组
		List<PreSkinTestDTO> rtns = packageData(listDatas);

		// 5、设置皮试结果显示
		setSkinRes(rtns);

		return rtns;
	}

	/**
	 * 参数校验
	 * 
	 * @param id_or_prs
	 * @throws BizException
	 */
	private void validate(String id_or_prs) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_or_prs))
			throw new BizException("参数id_or_prs不能为空！");
	}

	/**
	 * 查询数据
	 * 
	 * @param id_or_prs
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PreSkinTestDTO> queryData(String id_or_prs) throws BizException {
		GetPreInjectListInfosSql sql = new GetPreInjectListInfosSql(id_or_prs);
		List<PreSkinTestDTO> reList = (List<PreSkinTestDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(PreSkinTestDTO.class));
		return reList;
	}

	/**
	 * 设置组号
	 * 
	 * @param listDatas
	 * @return
	 * @throws DAException
	 */
	private void setGrpInfo(List<PreSkinTestDTO> listDatas) throws DAException {
		if (listDatas == null || listDatas.size() <= 0)
			return;
		List<String> grp_nos = new ArrayList<>();
		for (PreSkinTestDTO preSkinTestDTO : listDatas) {
			String no_grp = preSkinTestDTO.getNo_grp();
			if (!grp_nos.contains(no_grp))
				grp_nos.add(no_grp);
		}
		if (grp_nos != null && grp_nos.size() > 0) {
			String inSqlStr = MpUtils.getInSqlStr(grp_nos.toArray(new String[0]));
			Map<String, String> map = getNoGrpInfo(inSqlStr);
			if (map != null && map.size() > 0) {
				for (PreSkinTestDTO dto : listDatas) {
					if (map.containsKey(dto.getNo_grp())) {
						dto.setDis_grp_no(map.get(dto.getNo_grp()) + "-" + dto.getSort_no());
					} else {
						dto.setDis_grp_no("1-1");
					}
				}
			} else {
				for (PreSkinTestDTO dto : listDatas) {
					dto.setDis_grp_no("1-1");
				}
			}
		}
	}

	/**
	 * 获取no_grp和分组总数的对应关系
	 * 
	 * @param inSqlStr
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getNoGrpInfo(String inSqlStr) throws DAException {
		Map<String, String> reMap = new HashMap<String, String>();
		getGrpNoInfosSql sql = new getGrpNoInfosSql(inSqlStr);
		List<Map<String, String>> list = (List<Map<String, String>>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new MapListHandler());
		if (!CollectionUtils.isEmpty(list)) {
			for (Map<String, String> map : list) {
				reMap.put(map.get("no_grp"), String.valueOf(map.get("num")));
			}
		}
		return reMap;
	}

	protected abstract List<PreSkinTestDTO> packageData(List<PreSkinTestDTO> list) throws BizException;

	/**
	 * 设置皮试显示结果
	 * 
	 * @param params
	 */
	private void setSkinRes(List<PreSkinTestDTO> params) {
		if (params == null || params.size() < 1)
			return;
		for (PreSkinTestDTO param : params) {
			String skinRes = "";
			if (param.getDrugarrays() != null && param.getDrugarrays().size() > 0) {
				for (PreSkinTestDTO drug : param.getDrugarrays()) {
					if (!StringUtil.isEmptyWithTrim(drug.getSkin_result()))
						skinRes += (skinRes.length() == 0 ? "" : ",") + drug.getSkin_result();
				}
				param.setSkin_result(skinRes);
			}
		}
	}
}
