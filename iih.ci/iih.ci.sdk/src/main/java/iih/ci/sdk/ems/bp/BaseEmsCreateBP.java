package iih.ci.sdk.ems.bp;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ems.b.BaseEmsViewDTO;
import iih.ci.ems.b.BaseOrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.ems.itf.IEmsCreateBP;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 医疗单创建基类
 * @author wangqingzhu
 *
 */
public class BaseEmsCreateBP  extends ContextCache implements IEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 构造医疗单对象主体逻辑
	 * @param ctx
	 * @param medSrv
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected boolean constructEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrv, BaseEmsViewDTO ems)  throws BizException{
		return false;
	}
	
	/**
	 * 调用返回逻辑之前
	 * @param ctx
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected boolean beforeHandleReturnDocument(CiEnContextDTO ctx,BaseEmsViewDTO ems) throws BizException {
		
		return false;
	}
	
	/**
	 * 
	 * @param ctx
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected FArrayList handleReturnDocument(CiEnContextDTO ctx,BaseEmsViewDTO ems) throws BizException{
		FArrayList objList = new FArrayList();
		objList.add(ems);
		
		return objList;
	}

	/**
	 * 计算医保显示信息
	 * @param ctx
	 * @param model
	 * @throws BizException
	 */
	protected void filledHpShowInfo(CiEnContextDTO ctx, BaseOrderListViewDTO model) throws BizException {
//		List<OrderListViewDTO> lsSrvHpCa = SqlParamDbUtils.Q(
//		new SqlParamBuilder(" select (case when hpsrvca.id_hpsrvorca is null then '否' else '是' end) ishpsrvorca, hpsrvca.rate ratio_self from bd_hp_srvorca hpsrvca ")
//		.where()
//		.appendSqlParam("hpsrvca.id_srv=? ", model.getId_srv())
//		.and()
//		.appendSqlParam("hpsrvca.id_hp=? ",ctx.getId_hp_default())
//		,OrderListViewDTO.class);
//		if(!ObjectUtils.isEmpty(lsSrvHpCa)) {
//			model.setIshpsrvorca( lsSrvHpCa.get(0).getIshpsrvorca());
//			model.setRatio_self( lsSrvHpCa.get(0).getRatio_self());
//			if(!ObjectUtils.isEmpty(model.getRatio_self())) {
//				model.setAmt_self( model.getPri().multiply(new FDouble(model.getRatio_self()), 2).toString());
//			}
//		}else{
//			model.setRatio_self("1");
//			if(!ObjectUtils.isEmpty(model.getPri())){
//			model.setAmt_self( model.getPri().multiply(new FDouble(model.getRatio_self()), 2).toString());
//			}			
//		}
		
	}

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}
