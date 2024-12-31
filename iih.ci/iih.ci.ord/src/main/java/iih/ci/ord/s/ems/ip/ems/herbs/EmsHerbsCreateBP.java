package iih.ci.ord.s.ems.ip.ems.herbs;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsDrugsViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsHerbsViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsCreateBP;
import iih.ci.ord.s.ems.utils.OrderEmsQuanUtil;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 创建草药医疗单
 * @author wangqingzhu
 *
 */
public class EmsHerbsCreateBP extends EmsCommonDrugsCreateBP {
	
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsArray) 
			throws BizException {
		EmsCrtDTO emsCrtDTO = emsArray[0];
		EmsHerbsViewDTO emsViewDTO = new EmsHerbsViewDTO();
		ErrorEmsDTO err = assembleEmsViewInfo(ctx, emsCrtDTO.getId_srv(), emsCrtDTO.getId_mm(),emsViewDTO);
		// 返回值处理
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);
		
		EmsRstDTO rst = new EmsRstDTO();
		rst.setDocument(this.handleReturnDocument(emsViewDTO));

		return new EmsRstDTO[] { rst };
	}
	
	@Override
	protected ErrorEmsDTO assembleEmsViewInfo(CiEnContextDTO ctx, String id_srv, String id_mm, EmsDrugsViewDTO emsViewDTO) 
			throws BizException {
		ErrorEmsDTO err = super.assembleEmsViewInfo(ctx, id_srv, id_mm, emsViewDTO);
		EmsHerbsViewDTO herbsEmsViewDTO = (EmsHerbsViewDTO) emsViewDTO;
		herbsEmsViewDTO.setOrders(7);
		herbsEmsViewDTO.setDt_end(herbsEmsViewDTO.getDt_effe().addSeconds(7*24*3600));
		herbsEmsViewDTO.setFg_boil(FBoolean.TRUE);//代煎标识
		herbsEmsViewDTO.setOrders_boil(herbsEmsViewDTO.getOrders_boil());//代煎付数
		herbsEmsViewDTO.setQuan_cur(OrderEmsQuanUtil.getMMQuan_cur(herbsEmsViewDTO.getSd_mupkgutp(),herbsEmsViewDTO.getQuan_med(),herbsEmsViewDTO.getFactor_mb(),herbsEmsViewDTO.getFactor_cb(),herbsEmsViewDTO.getOrders()));
		herbsEmsViewDTO.setAmt_total(new FDouble(herbsEmsViewDTO.getPri().getDouble() * herbsEmsViewDTO.getQuan_cur().getDouble()));
		herbsEmsViewDTO.setFg_nothingwithorders(FBoolean.FALSE);//付数无关标识
		// 获取主服务信息
		MedSrvDO medSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, id_srv);
		this.calcOrderWfDeptInfo(ctx, medSrvInfo, emsViewDTO);
		return err;
	}
}
