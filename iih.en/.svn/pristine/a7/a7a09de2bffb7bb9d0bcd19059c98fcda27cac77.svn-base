package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.res.empdep.d.EmpDepDO;
import iih.bd.res.empdep.i.IEmpdepCudService;
import iih.en.comm.util.EnParamUtils;
import iih.mi.mibd.dep.d.DepDo;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.permfw.resp.d.SubjectOrgDO;

/**
 * 修改用户 - 组织关系后,同步到科室员工关系表(新增)  监听类
 * @author zhang,zl
 *
 */
public class SynchroEmpDepListener implements IBusinessListener{
	
	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		// 1、验证
		if (!validation(arg0))
			return;
		// 2、取参数
		BDCommonEvent dataevent = (BDCommonEvent) arg0;
		Object obj=dataevent.getObjs();
		SubjectOrgDO[] dos=(SubjectOrgDO[]) obj;
		ArrayList<EmpDepDO> list = new ArrayList<EmpDepDO>();
		if(dos == null || dos.length<=0){
			return;
		}
		IDeptRService rserv = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deps = rserv.findByAttrValString(DepDo.ID_DEP, dos[0].getId_org());

		if(deps == null || deps.length<=0){
			return;
		}
		//组织参数 @@员工同步用户组织关系 0-不同步 1-同步
		if(!EnParamUtils.getIsSysEmpDep(deps[0].getId_org())){
			return ;
		}
		for(SubjectOrgDO o:dos){
			EmpDepDO emp = new EmpDepDO();
			list.add(emp);
			emp.setStatus(DOStatus.NEW);
			emp.setId_dep(o.getId_org()); 
			emp.setId_emp(o.getSubjectid());
			emp.setId_grp(deps[0].getId_grp());
			emp.setId_org(deps[0].getId_org());
		}
		IEmpdepCudService serv = ServiceFinder.find(IEmpdepCudService.class);
		serv.save(list.toArray(new EmpDepDO[0]));
	}
	
	/**
	 * 验证
	 * 
	 * @param arg0
	 * @return
	 */
	private boolean validation(IBusinessEvent arg0) {
		if (IEnEventConst.EVENT_SOURCE_EN_IP_SYNCHROEMPDEP.equals(arg0.getSourceID()) && IEventType.TYPE_INSERT_AFTER.equals(arg0.getEventType()))
			return true;
		return false;
	}
	

}
