package iih.nm.nom.wardprint;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.nm.nom.dto.NomNurQualityDTO;
import iih.nm.nom.wardprint.qry.GetNomQualityDataQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:护理质量监控报表打印
 * @author:zhongcl@founder.com.cn
 * @version:2018年11月20日 下午7:37:44 创建
 */
public class GetNomQualityDataBp {

	public List<NomNurQualityDTO> exec(String id_dep_nur,String dt_begin,String dt_end,String isWard) throws BizException{
		
		//1.参数校验
		if(!validation(dt_begin,dt_end)){
			return null;
		}
		
		//2.是否是病区
		FBoolean bIsWard=new FBoolean(isWard);
		
		//3.获取统计数据信息
		List<NomNurQualityDTO> nomNurQualityDTO=getNomNurQualityDTO(id_dep_nur,dt_begin,dt_end,bIsWard.booleanValue());
		
		return nomNurQualityDTO;
	}
	
	/**
	 * 基础参数校验
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private boolean validation(String dt_begin,String dt_end){
		
		if(StringUtils.isBlank(dt_begin)){
			return false;
		}
		if(StringUtils.isBlank(dt_end)){
			return false;
		}
		return true;
	}

	/** 
	 * 获取护理质量监控
	 * @param id_dep_nur
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws DAException 
	 */
	private List<NomNurQualityDTO> getNomNurQualityDTO(String id_dep_nur,String dt_begin,String dt_end,boolean isWard) throws BizException{
		
		GetNomQualityDataQry qry=new GetNomQualityDataQry(id_dep_nur,dt_begin,dt_end,isWard);
		@SuppressWarnings("unchecked")
		List<NomNurQualityDTO> nomNurQualityDOs = (List<NomNurQualityDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(NomNurQualityDTO.class));
		
		return nomNurQualityDOs;
	}
}
