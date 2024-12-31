package iih.ci.ord.s.bp.skintest;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.d.AllergicHandleModeEnum;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDOCudService;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
/**
 * 获得过敏史的处理模式操作BP
 */
public class GetAllergicHisHandleModeBP {
	/**
	 * 获得过敏史的处理模式
	 * 返回值为：AllergicHandleModeEnum
	 * @param id_org
	 * @return 
	 * @throws BizException
	 */
	public Integer exec(String id_org)  throws BizException{ 
		//获得参数值
		Integer rtn=ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_PharmAllergyHandleMode);
		
		//结果处理并返回
		if(rtn==null)return AllergicHandleModeEnum.FORBIDDEN;
		if(!(rtn==0 || rtn==1 || rtn==2))return AllergicHandleModeEnum.FORBIDDEN;
		
		//返回结果
		return rtn;
	}
	
	/**
	 * 
	 * @code 获得过敏分类里对应药品开立控制方式参数  (0限制开立 9不限制)
	 * @author LiYue
	 * @date 2019年5月4日,下午4:12:20
	 * @return
	 * @throws BizException 
	 */
	public PiPatAlDO[]  getDrugOpeningControl(PiPatAlDO[] piPatAll) throws BizException {
		
		//有效性校验
		if(CiOrdUtils.isEmpty(piPatAll)) return null;
		//查询条件
		String idmms = "";
		String Id_alclas = "";
		for(PiPatAlDO PatAlDO : piPatAll){
			if(!StringUtils.isNullOrEmpty(PatAlDO.getId_mm())) {
				idmms += "'"+PatAlDO.getId_mm()+"'," ;
			}else if(!StringUtils.isNullOrEmpty(PatAlDO.getId_alcla())) {
				Id_alclas += "'"+PatAlDO.getId_alcla()+"'," ;
			}
			
		}
		// DTO没有ctrl1这个拓展字段， 暂时用Id_datasrc代替
		String sql ="select DISTINCT al.Id_alcla, udi.ctrl1 as Id_datasrc from  pi_pat_al al  " + 
				"left join bd_udidoc udi on udi.id_udidoc=al.ID_ALCLA " + 
				"where ";
		if(!StringUtils.isNullOrEmpty(idmms)){
			sql +="  al.ID_MM in ("+idmms+"'1')";
			if(!StringUtils.isNullOrEmpty(Id_alclas))
			sql +=" or al.Id_alcla in ("+Id_alclas+"'1')";
		}else if(!StringUtils.isNullOrEmpty(Id_alclas)) {
			sql +="  al.Id_alcla in ("+Id_alclas+"'1')";
		}
				
		
		List<PiPatAlDO> pipatdo = new ArrayList<PiPatAlDO>();
		try {
			pipatdo = (List<PiPatAlDO>) new DAFacade().execQuery(sql,new BeanListHandler(PiPatAlDO.class));
		} catch (Exception e) {
			throw new  BizException(sql+"对应药品开立控制方式参数维护异常！");
		}
		
		if(CiOrdUtils.isEmpty(pipatdo))return piPatAll;
		for (PiPatAlDO piPatAlDO : piPatAll) {
			for (PiPatAlDO  newPiPatAlDO: pipatdo) {
				if(!StringUtils.isNullOrEmpty(newPiPatAlDO.getId_alcla()) && piPatAlDO.getId_alcla().equals(newPiPatAlDO.getId_alcla())) {
					piPatAlDO.setId_datasrc(newPiPatAlDO.getId_datasrc());
				}
			}
		}
		return piPatAll;
	} 
	/**
	 * 获取过敏史全部有效过敏记录
	 * @code 
	 * @author LiYue
	 * @date 2019年5月7日,下午2:44:52
	 * @return
	 */
	public PiPatAlDO[] getALLPiPatAlDO() {
		return null;
	}

	/**
	 * 
	 * @code 获得过敏分类
	 * @author LiYue
	 * @date 2019年5月4日,下午9:33:22
	 * @param id_mm
	 * @return
	 * @throws BizException 
	 */
	public String getID_ALCLA(String id_mm) throws BizException {
		PiPatAlDO[] piPatAlDO = null;
		try {
			piPatAlDO = ServiceFinder.find(IPiPatAlDORService.class).findByAttrValString("id_mm", id_mm);
		} catch (BizException e1) {
			throw new  BizException("获取"+id_mm+"对应药品过敏分类错误！");
		}
		return piPatAlDO[0].ID_ALCLA;
	}	
		
	
	
	
}
