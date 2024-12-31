package iih.pis.ivx.mt.i;

import xap.mw.core.data.BizException;

import java.util.Map;

import iih.pis.ivx.mt.d.EEnResult;
import iih.pis.ivx.mt.d.MtScCaBean;
import iih.pis.ivx.mt.d.MtScCaPara;
import iih.pis.ivx.mt.d.MtScDbSrvBean;
import iih.pis.ivx.mt.d.MtScDbSrvDTO;
import iih.pis.ivx.mt.d.MtScDbSrvPara;
import iih.pis.ivx.mt.d.PatAptListBean;
import iih.pis.ivx.mt.d.PatAptListPara;
import iih.pis.ivx.mt.d.SchBean;
import iih.pis.ivx.mt.d.SchDTO;
import iih.pis.ivx.mt.d.SchPara;

public interface IMtRService {
	
	public MtScCaBean[] getMtScCa(MtScCaPara mtScCaPara) throws BizException;
	
	public MtScDbSrvBean[] getMtScDbSrv(MtScDbSrvPara mtScDbSrvPara) throws BizException;
	
	public MtScDbSrvDTO[] getMtScDbSrvO(MtScDbSrvPara mtScDbSrvPara) throws BizException;
	
	public Map<String, Map<String, Map<String, SchBean>>> getSchList(SchPara schPara) throws BizException;
	
	public SchDTO[] getSchListO(SchPara schPara) throws BizException;

	public EEnResult<PatAptListBean> getPatAptList(PatAptListPara aptListPara) throws BizException;
	
	public EEnResult<PatAptListBean> getPatAptByIdApt(PatAptListPara aptListPara) throws BizException;
	
}
