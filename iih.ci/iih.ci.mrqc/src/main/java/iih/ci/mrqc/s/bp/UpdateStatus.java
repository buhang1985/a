package iih.ci.mrqc.s.bp;

import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.ci.mrqc.qaflt.i.IQafltRService;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.qared.i.IQaCudService;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeCudService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class UpdateStatus {
	public FBoolean updateStatus(QaFltDTO[] qaflt)throws BizException{
	
		/**
		 *  实现代码
		 */
	    	DAFacade daf = new DAFacade();
	    	for(QaFltDTO dto : qaflt){
	    		String id_flt_sta =dto.getId_flt_sta();
	    		String id_revision=dto.getId_revision();
	    		String ssql =
	    	    		"update ci_qa_revision_notice ci set id_status='0001AA1000000003ZY3Q',sd_status='03'\n"
	    	    		+ " where ci.id_revision = '" + id_revision + "'";
	    		
	    		daf.execUpdate(ssql);
	    		
	    	}
	    	
		return FBoolean.TRUE;
	}
	


}
