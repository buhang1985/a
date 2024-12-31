package iih.ci.ord.s.external.thirdws.op.treat;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EmstreatOrdDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EmstreatSrvDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EntWstreatDTO;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsTreatSaveAction extends OpCommonSaveAction{
	@Override
	public String save(EntWsDTO entDTO) throws BizException {
		super.save(entDTO);
		// 设置Agg容器
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		EntWstreatDTO enttreatdto = (EntWstreatDTO)entDTO;
		// 获取医嘱
		List<EmstreatOrdDTO> ordList = enttreatdto.getOrdList();

		for (EmstreatOrdDTO treatOrd : ordList) {
			CiorderAggDO aggdo = assebleOrderAgg(treatOrd);
			for (OrdSrvDO SrvDTO : aggdo.getOrdSrvDO()) {
				assebleSrvDO( SrvDTO );
			}
			ciorderAggDOList.add(aggdo);
		}

		// 保存
		EmsRstDTO retdto = Save(ciorderAggDOList.toArray(new CiorderAggDO[0]));
		ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
		// 返回结果XML
		return util.exec(new EmsRstDTO[] { retdto }, "root", "");
	}

	// 保存入库
	private EmsRstDTO Save(CiorderAggDO[] aggDOs) throws BizException {
		EmsRstDTO retdto = new EmsRstDTO();
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		try {
			aggDOs = service.save(aggDOs);
			this.fireSignEvent(aggDOs);
			retdto.setResultcode("0");
		} catch (Exception e) {
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
			throw new BizException(e);
		}
		return retdto;
	}
	private void assebleSrvDO(OrdSrvDO srv) {
		srv.setId_en(this.getEntdo().getId_ent());
		srv.setId_pat(this.getEntdo().getId_pat());
		srv.setId_entp(this.getEntdo().getId_entp());
		srv.setCode_entp(this.getEntdo().getCode_entp());
		srv.setEu_sourcemd(0);
	}
	
	@Override
	protected void assembleContent_or(CiorderAggDO agg) {
		CiOrderDO order = agg.getParentDO();
		order.setStatus(DOStatus.NEW);
		order.setContent_or(CiOrContentUtils.create(order.getSd_srvtp(), order.getName_or(), order.getRoute_name(), order.getFg_urgent()).toString());
		order.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		order.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
		order.setDt_sign(new FDateTime());
	}
	@Override
	public OrdSrvDO assembleSrv(BaseDTO srvdto) throws BizException {
		OrdSrvDO srvDo = super.assembleSrv(srvdto);
		EmstreatSrvDTO  lisSrvDTO = (EmstreatSrvDTO) srvdto;
		srvDo.setQuan_medu(new FDouble(lisSrvDTO.getQuan_medu_srv()));
		srvDo.setQuan_total_medu(new FDouble(lisSrvDTO.getQuan_cur_srv()));
		return srvDo;
	}

}
