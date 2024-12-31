package iih.ci.ord.s.ems.op.ems.herbs;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.s.ems.op.ems.drugs.EmsDrugsCreateBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class EmsHerbsCreateBP extends EmsDrugsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx,EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		EmsRstDTO[] rsts = super.create(ctx,emsarray);

		rsts[0].getDriverInfo().setEmsBackendDriver(EmsType.HERB.toString());
		return rsts;
	}

	@Override
	protected EmsDrugItemDO emsModelFrom(MedSrvDO medSrv,EmsOrDrug drug, CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		EmsDrugItemDO emsDrugItem = super.emsModelFrom(medSrv,drug, ctx);
		
		// 获取药品用药属性管理模式，根据参数值确定频次、剂量、用法、用法要求、煎法、煎法要求 数据来源
		//商品名： 数据来源于bd_mm， 通用名：数据来源与bd_srv
		String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
		
		if(IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)){
			emsDrugItem.setName_boil(drug.getName_boil());// 煎法名称
			emsDrugItem.setId_boil(drug.getId_boil()); // 煎法
		}else{
			emsDrugItem.setName_boil(medSrv.getBoil_name());// 煎法名称
			emsDrugItem.setId_boil(medSrv.getId_boil()); // 煎法
		}
		
		emsDrugItem.setOrders(1); // 医嘱付数
		emsDrugItem.setFg_boil(FBoolean.FALSE);// 代煎标识
		emsDrugItem.setOrders_boil(0);// 代煎付数
		
		return emsDrugItem;
	}
}
