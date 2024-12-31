package iih.bl.st.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.ci.ord.i.third.ICiOrderThirdService;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.en.pv.i.IEnOutCmdService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 一体化取消（删除相应的记账表和医嘱信息）
 * @param cgAggDTO
 * @return
 * @throws BizException
 */
public class DoIntegratedDepricingBp {

	public FBoolean exec(String[] id_cgArr) throws BizException {
		if(ArrayUtil.isEmpty(id_cgArr)) {
			throw new BizException("取消操作时，对应的记账信息不能为空！");
		}
		//1、获取已记账的主表id 获取对应医嘱id_or
	    String whereCond = SqlUtils.getInSqlByIds("id_cgoep", id_cgArr);
		String[] fields = {"Id_or","Id_ent"};
		DAFacade dAFacade=new DAFacade();
		List<BlCgItmOepDO> cgItemDoList = (List<BlCgItmOepDO>)dAFacade.findByCond(BlCgItmOepDO.class, whereCond,"dt_or desc", fields);
		if(ListUtil.isEmpty(cgItemDoList)) {
			throw new BizException("未查询到对应的记账明细，请重新操作!");
		}
		String id_ent=cgItemDoList.get(0).getId_ent();
		//2、根据记账主表id进行删除记账数据
		IBLCiOrderToBlCgService cgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		
		FBoolean retFlag = cgService.DeleteOepPricingInfo(id_cgArr);
		if(!retFlag.booleanValue()) {
			throw new BizException("撤销记账费用失败，请重新操作!");
		}
		//3、根据医嘱主表主键id_or，调用ci删除医嘱
		BlCgItmOepDO[] cgItemDoArr = cgItemDoList.toArray(new BlCgItmOepDO[]{});
		List<String> id_orList = new ArrayList<String>();
		for(BlCgItmOepDO itemDo : cgItemDoArr){
			if(!id_orList.contains(cgItemDoArr))
				id_orList.add(itemDo.getId_or());
		}
		//逻辑删除医嘱信息
		ICiOrderThirdService ciService = ServiceFinder.find(ICiOrderThirdService.class);
		ThirdRstDTO retCiDto = ciService.delete(id_orList.toArray(new String[]{}));
		
		if (retCiDto == null || !retCiDto.isSuccessful().booleanValue() ) {
			throw new BizException("处方删除失败！\n" + retCiDto.getErrorMessage());
		}
		
		//0132020: 门诊工作站-取消划价（门诊工作站取消划价不需要退号，所以删除以下代码）
		//进行退号
//		iih.en.pv.i.IEnOutCmdService.cancOpReg4Bl(String id_ent)

//		IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
//		try{
//		enService.cancOpReg4Bl(id_ent);
//		} catch(BizException ex){
//			throw new BizException("退号失败！\n"+ ex.getMessage());
//		}
		return FBoolean.TRUE;
	}
}
