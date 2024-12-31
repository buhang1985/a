package iih.ci.ord.i.ems.ip.assi.cp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import xap.mw.core.data.BizException;

public interface ICiCpMainService {

	abstract  EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException;
}
