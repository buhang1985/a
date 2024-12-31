package iih.bd.fc.s.bp.orpltpmatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.dto.matchdto.d.AttrMatchBas;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchAttrDO;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpMatchAttrDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:医嘱闭环匹配2.0数据转换
 * @author: tian.cj
 * @version：2019年11月7日 下午3:19:02 创建
 */
public class OrpltpMatchConvertBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public AttrMatchBas[] exec(OrpltpMatchDO[] params) throws BizException {

		// 1、基础校验
		if (params == null || params.length < 1)
			return null;

		// 2、查询子项数据
		OrpltpMatchAttrDO[] attrs = queryMatchAttrs(params);

		// 3、数据转换
		AttrMatchBas[] rtns = convert(params, attrs);

		return rtns;
	}

	/**
	 * 查询子项数据
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private OrpltpMatchAttrDO[] queryMatchAttrs(OrpltpMatchDO[] params) throws BizException {
		List<String> list = new ArrayList<String>();
		for (OrpltpMatchDO param : params) {
			if (!StringUtil.isEmptyWithTrim(param.getId_orpltp_match()))
				list.add(param.getId_orpltp_match());
		}
		return ServiceFinder.find(IOrpltpMatchAttrDORService.class).findByAttrValStrings(OrpltpMatchAttrDO.ID_ORPLTP_MATCH,list.toArray(new String[0]));
	}

	/**
	 * 数据转换
	 * 
	 * @param params
	 * @param attrs
	 * @return
	 */
	private AttrMatchBas[] convert(OrpltpMatchDO[] params, OrpltpMatchAttrDO[] attrs) {
		// 转换后数据的总集合
		List<AttrMatchBas> reList = new ArrayList<AttrMatchBas>();
		HashMap<String, AttrMatchBas> match = new HashMap<String, AttrMatchBas>();
		for (OrpltpMatchDO param : params) {
			if (!match.containsKey(param.getId_orpltp_match())) {
				AttrMatchBas arrtMatchBas = initArrtOrpltpMatch(param);
				match.put(param.getId_orpltp_match(), arrtMatchBas);
				reList.add(arrtMatchBas);
			}
			if(attrs==null)
				continue;
			AttrMatchBas attrMatchBas = match.get(param.getId_orpltp_match());
			for (OrpltpMatchAttrDO attrDO : attrs) {
				if (attrDO.getId_orpltp_match().equals(attrMatchBas.getId_orpltp_match())) {
					attrMatchBas.setId_orpltp_match_attr(attrDO.getId_orpltp_match_attr());
					addToList(attrMatchBas.getListSrv(), attrDO.getId_srv());
					addToList(attrMatchBas.getListDepor(), attrDO.getId_dep());
					addToList(attrMatchBas.getListDdm(), attrDO.getCode_duiddm());
					addToList(attrMatchBas.getListDepPhy(), attrDO.getId_dep_phy());
					addToList(attrMatchBas.getListDepNur(), attrDO.getId_dep_nur());
				}
			}
		}
		return reList.toArray(new AttrMatchBas[0]);
	}

	/**
	 * 数据转换
	 * 
	 * @param param
	 * @return
	 */
	private AttrMatchBas initArrtOrpltpMatch(OrpltpMatchDO param) {
		AttrMatchBas rtn = new AttrMatchBas();
		rtn.setId_orpltp_match(param.getId_orpltp_match());
		rtn.setId_orpltp(param.getId_orpltp());
		rtn.setId_srvtp(param.getId_srvtp());
		rtn.setSd_srvtp(param.getSd_srvtp());
		rtn.setCode_param(param.getCode_param());
		rtn.setId_mp_route(param.getId_mp_route());
		rtn.setEu_skintest(param.getEu_skintest());
		rtn.setEu_mp_in(param.getEu_mp_in());
		rtn.setEu_pres_outp(param.getEu_pres_outp());
		rtn.setEu_wholepack(param.getEu_wholepack());
		rtn.setEu_fg_back(param.getEu_fg_back()); //新增退药
		rtn.setEu_srv(param.getEu_srv());
		rtn.setEu_dep_or(param.getEu_dep_or());
		rtn.setEu_ddm(param.getEu_ddm());
		rtn.setEu_dep_phy(param.getEu_dep_phy());//新增就诊科室
		rtn.setEu_dep_nur(param.getEu_dep_nur());//新增护理单元
		rtn.setId_dep_rel(param.getId_dep_rel());//就诊部门关系
		rtn.setSd_dep_rel(param.getSd_dep_rel());
		rtn.setListSrv(new ArrayList<String>());
		rtn.setListDepor(new ArrayList<String>());
		rtn.setListDdm(new ArrayList<String>());
		rtn.setListDepPhy(new ArrayList<String>());
		rtn.setListDepNur(new ArrayList<String>());
		return rtn;
	}

	/**
	 * 添加到集合
	 * 
	 * @param list
	 * @param val
	 */
	private void addToList(List<String> list, String val) {
		if (StringUtil.isEmptyWithTrim(val))
			return;
		if (list.contains(val))
			return;
		list.add(val);
	}
}
