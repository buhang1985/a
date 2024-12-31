package iih.ci.diag.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.s.CiDiUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

public class CiDiEventBuildBP {

	
	
	private CiEventDO getCiEventDO(CidiagAggDO diag) throws BizException{
		CiEventDO eventdo=null;
        if(diag == null  || diag.getParentDO() == null ) return null;
		eventdo=new CiEventDO();
		//eventdo.setId_et();et
		eventdo.setId_grp(diag.getParentDO().getId_grp());
		eventdo.setId_org(diag.getParentDO().getId_org());
		eventdo.setId_or(diag.getParentDO().getId_di());
		//eventdo.setId_di();
		//eventdo.setId_mr();
		eventdo.setDt_et(CiDiUtils.getSystemDateTime());
		eventdo.setId_ettp(ICiDictCodeConst.SD_EVENTTP_CI_DIAG);
		eventdo.setSd_ettp(ICiDictCodeConst.SD_EVENTTP_CI_DIAG);
		//eventdo.setCode();
		//eventdo.setName();
		//eventdo.setDes();
		//eventdo.setDes_status();
		eventdo.setId_pat(diag.getParentDO().getId_pat());
		eventdo.setId_entp(diag.getParentDO().getId_entp());
		eventdo.setCode_entp(diag.getParentDO().getCode_entp());
		eventdo.setId_ent(diag.getParentDO().getId_en());
		//eventdo.setId_dep_et();
		//eventdo.setId_emp_et();
		//eventdo.setId_mrtp();
		//eventdo.setIscompleted();
		//eventdo.setId_user(.getUserId());
		//eventdo.setDt_begin();
		//eventdo.setDt_end();
		//eventdo.setDt_complete();
		//eventdo.setIsrate();
		//eventdo.setRate();
		//eventdo.setIs_associated();
		AuditInfoUtil.addData(eventdo);//设置设计信息
		eventdo.setStatus(DOStatus.NEW);
		
		return eventdo;
	}
	
}
