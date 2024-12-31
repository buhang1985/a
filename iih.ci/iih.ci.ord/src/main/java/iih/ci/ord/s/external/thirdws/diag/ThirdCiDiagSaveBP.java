package iih.ci.ord.s.external.thirdws.diag;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagMDORService;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.i.ICidiagMaintainService;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.thirdws.diag.d.EmsDiagDto;
import iih.ci.ord.i.external.thirdws.diag.d.EntWsDiagDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;
import iih.ci.ord.s.external.thirdws.op.ris.EmsRisSaveAction;
import iih.ci.ord.s.external.thirdws.op.ris.ThirdEmsRisValidate;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.xbd.udi.d.UdidocDO;

/*import iih.ci.diag.s.bp.SaveCiDiDtoBP;*/


/**
 * 第三方诊断回写
 * @author zhangwq
 *
 */
public class ThirdCiDiagSaveBP extends OpEmsCommonSaveBP {
	public ThirdCiDiagSaveBP() {
		this.setValidate(new ThirdEmsDiagValidate());
		this.setSaveAction(new EmsDiagSaveAction());
	}

	public ThirdCiDiagSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setValidate(new ThirdEmsDiagValidate());
		this.setSaveAction(new EmsDiagSaveAction());
	}
	
}
