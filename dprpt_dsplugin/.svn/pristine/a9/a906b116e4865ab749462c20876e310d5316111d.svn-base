package iih.nm.nom.wardprint;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.nm.nom.dto.NomNurQualityDTO;
import iih.nm.nom.wardprint.qry.GetNomQualityMonthQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @Description:护理管理质量监控查询
 * @author:zhongcl@founder.com.cn
 * @version:2019年2月23日下午4:30:14
 */
public class GetNomQualityMonthBp {

	public List<NomNurQualityDTO> exec(String id_dep_mps, String dt_begin, String dt_end,String is_ward) throws BizException {

		// 1.基础参数校验
		if (!validation(dt_begin, dt_end)) {
			return null;
		}

		//2.获取参数信息
		FBoolean isWard=new FBoolean(is_ward);
		
		// 3.科室Id拆分
		List<String> id_deps = splitIdDeps(id_dep_mps);

		//4.获取护理质量监控数据
		List<NomNurQualityDTO> rtnList=getNomNurQualityDTOs(id_deps,dt_begin,dt_end,isWard);
		
		return rtnList;
	}

	/**
	 * 基础参数校验
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private boolean validation(String dt_begin, String dt_end) {

		if (StringUtils.isBlank(dt_begin)) {
			return false;
		}
		if (StringUtils.isBlank(dt_end)) {
			return false;
		}
		return true;
	}

	/**
	 * 科室Id拆分
	 * @param id_dep_mps
	 * @return
	 */
	private List<String> splitIdDeps(String id_dep_mps) {

		if (StringUtils.isNotBlank(id_dep_mps)) {
			String[] id_deps = id_dep_mps.split(",");
			List<String> rtnList = new ArrayList<String>();
			if (ArrayUtils.isNotEmpty(id_deps)) {
				CollectionUtils.addAll(rtnList, id_deps);
			}
			return rtnList;

		}
		return new ArrayList<String>();
	}

	/**
	 * 获取护理质量监控数据
	 * @param id_deps
	 * @param dtBegin
	 * @param dtEnd
	 * @param isWard
	 * @return
	 * @throws DAException 
	 */
	private List<NomNurQualityDTO> getNomNurQualityDTOs(List<String> id_deps,String dtBegin,String dtEnd,FBoolean isWard) throws DAException{
		GetNomQualityMonthQry qry = new GetNomQualityMonthQry(dtBegin,dtEnd,id_deps,isWard);
		@SuppressWarnings("unchecked")
		List<NomNurQualityDTO> qualityMonthDTOs = (List<NomNurQualityDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(NomNurQualityDTO.class));
		return qualityMonthDTOs;
	}
}
