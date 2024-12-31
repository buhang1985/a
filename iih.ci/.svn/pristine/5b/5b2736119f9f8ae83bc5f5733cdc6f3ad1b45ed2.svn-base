package iih.ci.ord.s.bp.base.fc;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得医嘱执行闭环类型操作BP
 */
public class GetOrMpCloseLoopTpBP {
	/**
	 * 获得医嘱执行闭环类型
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO[] exec(CiOrderDO ordo)  throws BizException{
		//有效性校验
		if(!validateCheck(ordo))return null;

		//获得匹配参数
		OrpltpMatchParamDTO param=getOrpltpMatchParam(ordo);
		
		//获得匹配的闭环类型id
		return CiOrdAppUtils.getIOrpltpmtParaService().GetOrpltp(param);
	}
	
	/**
	 * 有效性校验
	 * @param ordo
	 * @return
	 */
	private boolean validateCheck(CiOrderDO ordo){
		if(CiOrdUtils.isEmpty(ordo))return false;
		return true;
	}
	
	/**
	 * 获得闭环匹配参数
	 * @param ordo
	 * @return
	 */
	private OrpltpMatchParamDTO getOrpltpMatchParam(CiOrderDO ordo){
		OrpltpMatchParamDTO param=new OrpltpMatchParamDTO();
		param.setSd_srvtp(ordo.getSd_srvtp());
		param.setCode_entp(ordo.getCode_entp());
		param.setFg_skintest(ordo.getFg_skintest());
		param.setId_route(ordo.getId_route());
		param.setId_srv(ordo.getId_srv());
		param.setId_dep_or(ordo.getId_dep_or());
		param.setSd_drugdeliverymethod(ordo.getSd_drugdeliverymethod());
		if(StringUtils.isNotBlank(ordo.getSd_drugdeliverymethod())&&ICiDictCodeConst.SD_DRUG_DELIVERY_METHOD_PRES_BACK.equals(ordo.getSd_drugdeliverymethod())){
				param.setFg_back(FBoolean.TRUE);
		}else{
			param.setFg_back(FBoolean.FALSE);
		}
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		if(ctx!=null)
		{
			param.setId_dep_phy(ctx.getId_dep_en());//就诊科室
			param.setId_dep_nur(ctx.getId_dep_ns());//护理单元
		}
		return param;
	}
}
