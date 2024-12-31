package iih.ci.mrqc.autoqc.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.qaflt.d.QaFltDO;

/**
* 组件操作接口方法服务
*/
public interface IAutoQc {

    /**
	*  getAutoQcDefects
	*/
    public abstract  void getAutoQcDefects( String id_ent ,String id_qc_type) throws BizException;
    /**
	*  自动质控配置获取扣分项
	*/
    public abstract  QaFltDO[] getAutoQcDivideDos( String id_ent,String id_qc_type,Boolean isDocAutoQcSelf,String qcTypeCode) throws BizException;

    /**
	*  终末质控用
	*/
    public abstract  DivideDO[] getAutoQcDivideDosForTerminalQc( String id_ent,String sd_qc_type) throws BizException;
}
