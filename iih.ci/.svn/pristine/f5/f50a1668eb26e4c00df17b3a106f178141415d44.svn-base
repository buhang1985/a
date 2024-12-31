package iih.ci.ord.s.external.provide;

import iih.ci.ord.i.external.provide.ICiOrdCdssService;
import iih.ci.ord.i.external.provide.meta.cdss.OrderInfoDTO;
import iih.ci.ord.i.external.provide.meta.cdss.PatInfoDTO;
import iih.ci.ord.i.external.provide.meta.cdss.PsnInfoDTO;
import iih.ci.ord.s.external.provide.bp.cdss.repo.OrderInfoRepository;
import iih.ci.ord.s.external.provide.bp.cdss.repo.PatInfoRepository;
import iih.ci.ord.s.external.provide.bp.cdss.repo.PsnInfoRepository;
import xap.mw.core.data.BizException;

/**
 * CDSS对外查询服务
 * 
 * @author MaKunPeng
 *
 */
public class CiOrdCdssServiceImpl implements ICiOrdCdssService {
    
    PsnInfoRepository psnInfoRepository;
    PatInfoRepository patInfoRepository;
    OrderInfoRepository orderInfoRepository;
    
    public CiOrdCdssServiceImpl() {
        this.psnInfoRepository = new PsnInfoRepository();
        this.patInfoRepository = new PatInfoRepository();
        this.orderInfoRepository = new OrderInfoRepository();
    }

    @Override
    public PsnInfoDTO getPsnInfo(String id_psn) throws BizException {
        return psnInfoRepository.findPsnInfoByIdUserAndIdDep(id_psn);
    }

    @Override
    public PatInfoDTO getPatInfo(String id_en) throws BizException {
        return patInfoRepository.findPatInfoByIdEn(id_en);
    }

    @Override
    public OrderInfoDTO[] getOrderInfo(String[] orderIds) throws BizException {
        
        return orderInfoRepository.findOrderInfoByIdOrs(orderIds);
    }

}
