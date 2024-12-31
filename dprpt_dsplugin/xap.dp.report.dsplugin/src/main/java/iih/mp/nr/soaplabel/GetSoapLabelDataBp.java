package iih.mp.nr.soaplabel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import iih.mp.nr.soaplabel.dto.SoapLabelDataDTO;
import iih.mp.nr.soaplabel.qry.GetSoapLabelDataQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:获取汤药标签数据
 * @author:zhongcl.founder.com.cn
 * @date 2019年4月7日 下午9:29:09
 * @version jdk 1.7
 */
public class GetSoapLabelDataBp {
	
	public List<SoapLabelDataDTO> exec(String id_pres,String print_code,String sd_exectp) throws BizException {

		// 1.基础参数校验
		if (!validation(id_pres,print_code)) {
			return null;
		}

		// 2.分解执行计划Id
		List<String> id_preses = new ArrayList<String>();
		splitParam(id_preses, id_pres);

		// 3.数据获取
		List<SoapLabelDataDTO> labelDataDTOs = getLabelDataDTOs(id_preses,print_code,sd_exectp);

		// 4.数据过滤
		List<SoapLabelDataDTO> rtnList = packData(labelDataDTOs);

		return rtnList;
	}

	// 基础参数校验
	private boolean validation(String id_pres,String print_code) {
		if (StringUtil.isEmptyWithTrim(id_pres))
			return false;
		if(StringUtil.isEmptyWithTrim(print_code))
			return false;
		return true;
	}

	// 分解处方Id与执行计划Id
	private void splitParam(List<String> id_preses, String id_pres) {
		String[] idPres = id_pres.split(",");
		if (ArrayUtils.isNotEmpty(idPres)) {
			CollectionUtils.addAll(id_preses, idPres);
		}
	}

	// 数据获取
	private List<SoapLabelDataDTO> getLabelDataDTOs(List<String> id_preses,String print_code,String sd_exectp) throws DAException {
		GetSoapLabelDataQry qry = new GetSoapLabelDataQry(id_preses,print_code,sd_exectp);
		@SuppressWarnings("unchecked")
		List<SoapLabelDataDTO> labelDataDTOs = (List<SoapLabelDataDTO>) new DAFacade().execQuery(qry.getQrySQLStr(),
				qry.getQryParameter(null), new BeanListHandler(SoapLabelDataDTO.class));
		return labelDataDTOs;
	}

	// 4.数据过滤
	private List<SoapLabelDataDTO> packData(List<SoapLabelDataDTO> dataDTOs) {
		if (CollectionUtils.isEmpty(dataDTOs))
			return null;
		List<SoapLabelDataDTO> rtnList=new ArrayList<SoapLabelDataDTO>();
		Map<String, SoapLabelDataDTO> soapMap = new HashMap<String, SoapLabelDataDTO>();
		for (SoapLabelDataDTO soapLabelDataDTO : dataDTOs) {
			String drugParam=soapLabelDataDTO.getName_drug()+":"+soapLabelDataDTO.getDose()+soapLabelDataDTO.getName_spec()+";   ";
			
			if (soapMap.containsKey(soapLabelDataDTO.getId_pres())) {
				SoapLabelDataDTO dataDTO = soapMap.get(soapLabelDataDTO.getId_pres());
				String drug=dataDTO.getDrug_list();
				dataDTO.setDrug_list(drug+drugParam);
			} else {
				soapLabelDataDTO.setDrug_list(drugParam);
				if(StringUtil.isEmptyWithTrim(soapLabelDataDTO.getName_boildes())){
					soapLabelDataDTO.setName_boildes("");
				}
				soapMap.put(soapLabelDataDTO.getId_pres(), soapLabelDataDTO);
			}
		}
		Collection<SoapLabelDataDTO> collection= soapMap.values();
		if(CollectionUtils.isNotEmpty(collection)){
			CollectionUtils.addAll(rtnList, collection.iterator());
		}
		return rtnList;
	}
}
