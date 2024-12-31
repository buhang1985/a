package iih.pi.concern.concern.i;

import xap.mw.core.data.BizException;
import iih.pi.concern.indinfodto.d.IndInfoDTO;

public interface IConcernQryService {
      public abstract IndInfoDTO[] getPiRecommendInd(String id_pi) throws BizException;
     
}