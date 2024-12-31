package iih.ci.mr.s;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.bbd.d.EmpPhyDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.i.ICiMrHoService;

/**
 * 病历住院综合接口
 * 通用的病历住院接口
 * @author    张静波
 * @version   2018-06-19
*/
public class CiMrHoServiceImpl implements ICiMrHoService {

	@Override
	public FBoolean hasPresAuthorityByUser(String id_user) throws DAException{
		String sqlStr = "select * from bd_emp_phy left join sys_user on bd_emp_phy.id_psndoc = sys_user.id_psn where sys_user.id_user ='" + id_user + "'";
		DAFacade daf = new DAFacade();
		java.util.List<EmpPhyDO> lstEmps = ( java.util.List<EmpPhyDO>)daf.execQuery(sqlStr, new BeanListHandler(EmpPhyDO.class));
		if(lstEmps !=null&&lstEmps.size()>0)
		{
			return lstEmps.get(0).getFg_presrt();
		}
		return null;
	}

	@Override
	public FBoolean hasPresAuthorityByPsn(String id_psn) throws DAException {
		String sqlStr = "select fg_presrt,drid from bd_emp_phy where ds<1 and id_psndoc='" + id_psn + "'" ;
		DAFacade daf = new DAFacade();
		java.util.List<EmpPhyDO> lstEmps = ( java.util.List<EmpPhyDO>)daf.execQuery(sqlStr, new BeanListHandler(EmpPhyDO.class));
		if(lstEmps !=null&&lstEmps.size()>0)
		{
			return lstEmps.get(0).getFg_presrt();
		}
		return null;
	}

}
