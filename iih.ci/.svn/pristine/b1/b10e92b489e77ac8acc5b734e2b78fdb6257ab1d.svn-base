package iih.ci.mrqc.autoqc.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.mw.core.data.*;
import iih.ci.mrqc.autoqc.i.IAutoQc;
import iih.ci.mrqc.autoqc.s.bp.*;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltRService;

/**
* 组件操作方法服务实现
*/
@Service(serviceInterfaces={IAutoQc.class}, binding=Binding.JSONRPC)
public class IAutoQcImpl implements IAutoQc{


    /**
	 * getAutoQcDefects
	 * dyzdzkrk
     * @param id_ent id_ent
     * @return ItmDO[]
     * @throws BizException
	 */
    public void getAutoQcDefects( String id_ent ,String id_qc_type) throws BizException{
    	GetAutoQcDefectsBP bp=new GetAutoQcDefectsBP();
        bp.exec( id_ent ,id_qc_type);
    }
/**
 * 自动质控 新
 */
	@Override
	public QaFltDO[] getAutoQcDivideDos(String id_ent,String id_qc_type, Boolean isDocAutoQcSelf,String qcTypeCode) throws BizException {
		// TODO Auto-generated method stub
		GetAutoQcDivideDosBP bp=new GetAutoQcDivideDosBP();
		if(bp!=null)
		{
        bp.exec( id_ent ,id_qc_type ,isDocAutoQcSelf, qcTypeCode);

		}
        IQafltRService fltService=ServiceFinder.find(IQafltRService.class);
        QaFltDO[] resultDo=fltService.find(" id_ent='"+id_ent+"' and ID_QA_TY = '"+id_qc_type+"'", "", FBoolean.FALSE);
        return resultDo;
	}
/**
 * 终末质控产生扣分项
 */
	@Override
	public DivideDO[] getAutoQcDivideDosForTerminalQc(String id_ent, String sd_qc_type) throws BizException {
		// TODO Auto-generated method stub
		GetTermianlAutoDivideDosBP bp=new GetTermianlAutoDivideDosBP();
		return bp.exec(id_ent, sd_qc_type);
	}

	
}