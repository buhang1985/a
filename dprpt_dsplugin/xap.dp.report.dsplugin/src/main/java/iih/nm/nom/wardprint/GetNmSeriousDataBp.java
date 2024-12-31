package iih.nm.nom.wardprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.mp.nr.common.UdidocSearchUtils;
import iih.mp.nr.common.dto.UdidocDTO;
import iih.nm.nom.dto.NmSeriousCollectDTO;
import iih.nm.nom.wardprint.qry.GetNmSeriousDataQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:危重病人信息查询
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月28日下午2:01:59
 */
public class GetNmSeriousDataBp {

	public List<NmSeriousCollectDTO> exec(String id_dep_nurs, String dt_begin, String dt_end, String udidocCode) throws BizException {

		// 1.基础参数校验
		if (!validation(dt_begin, dt_end, udidocCode)) {
			return null;
		}

		// 2.分解科室Id
		List<String> id_deps = filterIdDeps(id_dep_nurs);

		// 3.设置时间区间
		dt_begin += " 00:00:00";
		dt_end += " 23:59:59";

		// 4.获取档案信息
		List<UdidocDTO> udidoc = UdidocSearchUtils.findByUdidoclistCode("EN.EN.0555");
		String[] id_udidoced = udidocCode.split(",");

		// 5.获取病危病重服务
		List<String> id_srvs = getIdSrvs(udidoc, id_udidoced);

		// 5.获取数据
		List<NmSeriousCollectDTO> rtnList = getNmSeriousCollect(dt_begin, dt_end, id_srvs, id_deps);

		// 6.设置性别，年龄值
		setSeriousSexAge(rtnList);

		return rtnList;
	}

	// 基础参数校验
	private boolean validation(String dt_begin, String dt_end, String code) throws BizException {

		if (StringUtils.isBlank(dt_begin)) {
			return false;
		}
		if (StringUtils.isBlank(dt_end)) {
			return false;
		}
		if (StringUtils.isBlank(code)) {
			return false;
		}
		if (dt_begin.compareTo(dt_end) > 0) {
			return false;
		}
		return true;
	}

	// 分解科室Id
	private List<String> filterIdDeps(String id_dep_nurs) {

		List<String> rtnList = new ArrayList<String>();
		if (StringUtils.isBlank(id_dep_nurs)) {
			return rtnList;
		} else {
			String[] id_deps = id_dep_nurs.split(",");
			if (ArrayUtils.isNotEmpty(id_deps))
				CollectionUtils.addAll(rtnList, id_deps);
		}
		return rtnList;
	}

	/**
	 * 获取病危病重服务
	 * 
	 * @param udidocDTOs
	 * @param id_udidocs
	 * @return
	 */
	private List<String> getIdSrvs(List<UdidocDTO> udidocDTOs, String[] id_udidocs) {

		List<String> id_srvs = new ArrayList<String>();
		if (CollectionUtils.isEmpty(udidocDTOs)) {
			return id_srvs;
		}
		List<String> tempList = Arrays.asList(id_udidocs);
		for (UdidocDTO udidocDTO : udidocDTOs) {
			if (tempList.contains(udidocDTO.getId_udidoc())) {
				id_srvs.add(udidocDTO.ctrl1);
			}
		}
		return id_srvs;
	}
	// 获取危重病人信息
	private List<NmSeriousCollectDTO> getNmSeriousCollect(String dt_begin, String dt_end, List<String> id_srvs, List<String> id_deps) throws BizException {
	
		if(CollectionUtils.isEmpty(id_srvs)){
			return null;
		}
		GetNmSeriousDataQry qry = new GetNmSeriousDataQry(dt_begin, dt_end, id_srvs, id_deps);
		@SuppressWarnings("unchecked")
		List<NmSeriousCollectDTO> collectDTOs = (List<NmSeriousCollectDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(NmSeriousCollectDTO.class));
		return collectDTOs;
	}

	// 设置性别,年龄
	private void setSeriousSexAge(List<NmSeriousCollectDTO> collectDTOs) throws BizException {
		int i = 1;
		if (CollectionUtils.isNotEmpty(collectDTOs)) {
			for (NmSeriousCollectDTO nmSeriousCollectDTO : collectDTOs) {
				FDate dt_birth = new FDate(nmSeriousCollectDTO.getDt_birth());
				nmSeriousCollectDTO.setAge(AgeCalcUtil.getAge(dt_birth));
				UdidocDTO udidoc = UdidocSearchUtils.findByCode("PI.PI.0515", nmSeriousCollectDTO.getSex_no());
				nmSeriousCollectDTO.setSex_name(udidoc.name);
				nmSeriousCollectDTO.setSerial_num(String.valueOf(i));
				i++;
			}
		}
	}
}
